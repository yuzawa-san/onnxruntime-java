/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.OrtArenaAllocator;
import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.OrtMemTypeDefault;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toCString;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class TransactionImpl implements Transaction {

    private final ApiImpl api;
    private final MemoryAddress session;
    private final MemoryAddress ortAllocator;

    private final Map<String, OnnxValueImpl> inputs;
    private final List<NodeInfo> outputs;

    TransactionImpl(TransactionBuilderImpl builder) {
        this.api = builder.api;
        this.session = builder.session;
        this.ortAllocator = builder.ortAllocator;
        this.inputs = builder.inputs;
        this.outputs = builder.outputs;
    }

    @Override
    public NamedCollection<OnnxValue> run() {

        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
            MemoryAddress memoryInfo = api.create(
                    allocator, out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out));

            int numInputs = inputs.size();
            Addressable[] inputNamesVector = new Addressable[numInputs];
            Addressable[] inputValuesVector = new Addressable[numInputs];
            int idx = 0;
            for (Map.Entry<String, OnnxValueImpl> entry : inputs.entrySet()) {
                MemorySegment input1 = toCString(entry.getKey(), scope);
                inputNamesVector[idx] = input1;
                MemoryAddress valueAddress = entry.getValue().toNative(api, memoryInfo, allocator);
                inputValuesVector[idx] = valueAddress;
                scope.addCloseAction(() -> {
                    api.ReleaseValue.apply(valueAddress);
                });
                idx++;
            }
            MemorySegment inputNames = allocator.allocateArray(C_POINTER, inputNamesVector);
            MemorySegment inputValues = allocator.allocateArray(C_POINTER, inputValuesVector);

            int numOutputs = outputs.size();
            Addressable[] outputNamesVector = new Addressable[numOutputs];
            for (int i = 0; i < numOutputs; i++) {
                MemorySegment input1 = toCString(outputs.get(i).getName(), scope);
                outputNamesVector[i] = input1;
            }
            MemorySegment outputNames = allocator.allocateArray(C_POINTER, outputNamesVector);

            MemorySegment output = allocator.allocate(C_POINTER);
            api.checkStatus(api.Run.apply(
                    session,
                    MemoryAddress.NULL,
                    inputNames.address(),
                    inputValues.address(),
                    numInputs,
                    outputNames.address(),
                    numOutputs,
                    output.address()));

            LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(outputs.size());
            for (int i = 0; i < outputs.size(); i++) {
                MemoryAddress outputAddress = MemoryAccess.getAddressAtIndex(output, i);
                // TODO: get typeinfo from result
                NodeInfo nodeInfo = outputs.get(i);
                OnnxValueImpl outputValue = OnnxValueImpl.fromTypeInfo(nodeInfo.getTypeInfo());
                outputValue.fromNative(api, outputAddress, scope, allocator);
                out.put(nodeInfo.getName(), outputValue);
            }

            return new NamedCollectionImpl<>(out);
        }
    }
}
