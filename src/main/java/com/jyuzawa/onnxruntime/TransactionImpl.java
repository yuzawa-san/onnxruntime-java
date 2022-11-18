/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import com.jyuzawa.onnxruntime.TransactionBuilderImpl.InputTuple;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.LinkedHashMap;
import java.util.List;

final class TransactionImpl implements Transaction {
    // private final Object cancelLock;
    // private MemoryAddress runOptions;

    private final TransactionBuilderImpl builder;

    TransactionImpl(TransactionBuilderImpl builder) {
        this.builder = builder;
        // this.cancelLock = new Object();
    }

    // @Override
    // public void cancel() {
    // synchronized (cancelLock) {
    // if (runOptions != null) {
    // ApiImpl api = builder.api;
    // api.checkStatus(api.RunOptionsSetTerminate.apply(runOptions));
    // }
    // }
    // }

    @Override
    public NamedCollection<OnnxValue> run() {
        ApiImpl api = builder.api;
        MemoryAddress ortAllocator = builder.ortAllocator;
        try (MemorySession allocator = MemorySession.openConfined()) {
            List<InputTuple> inputs = builder.inputs;
            int numInputs = inputs.size();
            List<NodeInfoImpl> outputs = builder.outputs;
            int numOutputs = outputs.size();
            long sizeOfPointer = C_POINTER.byteSize();
            MemorySegment segment = allocator.allocateArray(C_POINTER, numInputs * 2 + numOutputs * 2 + 1);
            long inputsBytes = numInputs * sizeOfPointer;
            long offset = 0;
            MemorySegment inputNames = segment.asSlice(offset, inputsBytes);
            offset += inputsBytes;
            MemorySegment inputValues = segment.asSlice(offset, inputsBytes);
            offset += inputsBytes;
            long outputsBytes = numOutputs * sizeOfPointer;
            MemorySegment outputNames = segment.asSlice(offset, outputsBytes);
            offset += outputsBytes;
            MemorySegment outputValues = segment.asSlice(offset, outputsBytes);
            offset += outputsBytes;
            MemorySegment runOptionsSegment = segment.asSlice(offset, sizeOfPointer);
            for (int i = 0; i < numOutputs; i++) {
                InputTuple inputTuple = inputs.get(i);
                inputNames.setAtIndex(C_POINTER, i, inputTuple.nodeInfo().nameSegment);
                MemoryAddress valueAddress =
                        inputTuple.value().toNative(api, ortAllocator, builder.memoryInfo, allocator);
                inputValues.setAtIndex(C_POINTER, i, valueAddress);
            }

            for (int i = 0; i < numOutputs; i++) {
                outputNames.setAtIndex(C_POINTER, i, outputs.get(i).nameSegment);
            }

            MemoryAddress runOptionsAddress = builder.newRunOptions(allocator, runOptionsSegment);
            // synchronized (cancelLock) {
            // this.runOptions = runOptionsAddress;
            // }
            try {
                api.checkStatus(api.Run.apply(
                        builder.session,
                        runOptionsAddress,
                        inputNames.address(),
                        inputValues.address(),
                        numInputs,
                        outputNames.address(),
                        numOutputs,
                        outputValues.address()));
            } finally {
                // synchronized (cancelLock) {
                api.ReleaseRunOptions.apply(runOptionsAddress);
                // runOptions = null;
                // }
            }
            LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(outputs.size());
            for (int i = 0; i < outputs.size(); i++) {
                MemoryAddress outputAddress = outputValues.getAtIndex(C_POINTER, i);
                // TODO: get typeinfo from result
                NodeInfoImpl nodeInfo = outputs.get(i);
                OnnxValueImpl outputValue = OnnxValueImpl.fromTypeInfo(nodeInfo.getTypeInfo());
                outputValue.fromNative(api, ortAllocator, outputAddress, allocator);
                out.put(nodeInfo.getName(), outputValue);
            }

            return new NamedCollectionImpl<>(out);
        }
    }
}
