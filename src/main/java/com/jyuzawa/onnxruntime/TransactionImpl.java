/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtArenaAllocator;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtMemTypeDefault;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class TransactionImpl implements Transaction {

    //    private final Object cancelLock;
    //    private MemoryAddress runOptions;

    private final TransactionBuilderImpl builder;

    TransactionImpl(TransactionBuilderImpl builder) {
        this.builder = builder;
        //        this.cancelLock = new Object();
    }

    //    @Override
    //    public void cancel() {
    //        synchronized (cancelLock) {
    //            if (runOptions != null) {
    //                ApiImpl api = builder.api;
    //                api.checkStatus(api.RunOptionsSetTerminate.apply(runOptions));
    //            }
    //        }
    //    }

    @Override
    public NamedCollection<OnnxValue> run() {
        ApiImpl api = builder.api;
        MemoryAddress ortAllocator = builder.ortAllocator;
        try (MemorySession allocator = MemorySession.openShared()) {
            MemoryAddress memoryInfo = api.create(
                    allocator, out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out));
            allocator.addCloseAction(() -> {
                api.ReleaseMemoryInfo.apply(memoryInfo);
            });

            Map<String, OnnxValueImpl> inputs = builder.inputs;
            int numInputs = inputs.size();
            MemorySegment inputNames = allocator.allocateArray(C_POINTER, numInputs);
            MemorySegment inputValues = allocator.allocateArray(C_POINTER, numInputs);
            int idx = 0;
            for (Map.Entry<String, OnnxValueImpl> entry : inputs.entrySet()) {
                MemorySegment input1 = allocator.allocateUtf8String(entry.getKey());
                inputNames.setAtIndex(C_POINTER, idx, input1);
                MemoryAddress valueAddress = entry.getValue().toNative(api, ortAllocator, memoryInfo, allocator);
                inputValues.setAtIndex(C_POINTER, idx, valueAddress);
                idx++;
            }

            List<NodeInfo> outputs = builder.outputs;
            int numOutputs = outputs.size();
            MemorySegment outputNames = allocator.allocateArray(C_POINTER, numOutputs);
            for (int i = 0; i < numOutputs; i++) {
                MemorySegment input1 =
                        allocator.allocateUtf8String(outputs.get(i).getName());
                outputNames.setAtIndex(C_POINTER, i, input1);
            }

            MemorySegment output = allocator.allocate(C_POINTER);
            MemoryAddress runOptionsAddress = builder.newRunOptions(allocator);
            //            synchronized (cancelLock) {
            //                this.runOptions = runOptionsAddress;
            //            }
            try {
                api.checkStatus(api.Run.apply(
                        builder.session,
                        runOptionsAddress,
                        inputNames.address(),
                        inputValues.address(),
                        numInputs,
                        outputNames.address(),
                        numOutputs,
                        output.address()));
            } finally {
                //                synchronized (cancelLock) {
                api.ReleaseRunOptions.apply(runOptionsAddress);
                //                    runOptions = null;
                //                }
            }
            LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(outputs.size());
            for (int i = 0; i < outputs.size(); i++) {
                MemoryAddress outputAddress = output.getAtIndex(C_POINTER, i);
                // TODO: get typeinfo from result
                NodeInfo nodeInfo = outputs.get(i);
                OnnxValueImpl outputValue = OnnxValueImpl.fromTypeInfo(nodeInfo.getTypeInfo());
                outputValue.fromNative(api, ortAllocator, outputAddress, allocator);
                out.put(nodeInfo.getName(), outputValue);
            }

            return new NamedCollectionImpl<>(out);
        }
    }
}
