/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.OrtArenaAllocator;
import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.OrtMemTypeDefault;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toCString;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class TransactionImpl implements Transaction {

    private final ApiImpl api;
    private final MemoryAddress session;
    private final MemoryAddress ortAllocator;

    private final List<InputBuilderImpl> inputs;
    private final List<NodeInfo> outputs;

    TransactionImpl(TransactionBuilderImpl builder) {
        this.api = builder.api;
        this.session = builder.session;
        this.ortAllocator = builder.ortAllocator;
        this.inputs = builder.inputs;
        this.outputs = builder.outputs;
    }

    private final long[] shape(List<Long> original) {
        int shapeSize = original.size();
        long[] shapeArray = new long[shapeSize];
        for (int i = 0; i < shapeSize; i++) {
            shapeArray[i] = original.get(i);
        }
        return shapeArray;
    }

    @Override
    public NamedCollection<Value> run() {

        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
            MemoryAddress memoryInfo = api.create(
                    allocator, out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out));

            MemorySegment output1 = toCString("variable", scope);

            MemoryAddress ioBinding = api.create(allocator, out -> api.CreateIoBinding.apply(session, out));
            scope.addCloseAction(() -> {
                api.ReleaseIoBinding.apply(ioBinding);
            });

            for (InputBuilderImpl input : inputs) {
                NodeInfo inputInfo = input.nodeInfo;
                TensorInfo tensorInfo = inputInfo.getTypeInfo().getTensorInfo();
                MemorySegment input1 = toCString(inputInfo.getName(), scope);
                MemorySegment inputData = MemorySegment.ofByteBuffer(input.tensorBuffer);
                List<Long> shape = tensorInfo.getShape();
                int shapeSize = shape.size();
                MemorySegment shapeData = allocator.allocateArray(C_LONG, shape(shape));
                MemoryAddress inputTensor = api.create(
                        allocator,
                        out -> api.CreateTensorWithDataAsOrtValue.apply(
                                memoryInfo,
                                inputData.address(),
                                inputData.byteSize(),
                                shapeData.address(),
                                shapeSize,
                                tensorInfo.getType().getNumber(),
                                out));
                scope.addCloseAction(() -> {
                    api.ReleaseValue.apply(inputTensor);
                });
                api.checkStatus(api.BindInput.apply(ioBinding, input1.address(), inputTensor));
            }

            List<MemoryAddress> outputValues = new ArrayList<>(outputs.size());
            for (NodeInfo outputInfo : outputs) {
                TensorInfo tensorInfo = outputInfo.getTypeInfo().getTensorInfo();
                List<Long> shape = tensorInfo.getShape();
                int shapeSize = shape.size();
                MemorySegment outputShapeData = allocator.allocateArray(C_LONG, shape(shape));
                MemoryAddress outputTensor = api.create(
                        allocator,
                        out -> api.CreateTensorAsOrtValue.apply(
                                ortAllocator,
                                outputShapeData.address(),
                                shapeSize,
                                tensorInfo.getType().getNumber(),
                                out));
                scope.addCloseAction(() -> {
                    api.ReleaseValue.apply(outputTensor);
                });
                api.checkStatus(api.BindOutput.apply(ioBinding, output1.address(), outputTensor.address()));
                outputValues.add(outputTensor);
            }

            api.checkStatus(api.RunWithBinding.apply(session, MemoryAddress.NULL, ioBinding));

            LinkedHashMap<String, Value> out = new LinkedHashMap<>(outputs.size());
            for (int i = 0; i < outputs.size(); i++) {
                MemoryAddress outputAddress = outputValues.get(i);
                MemorySegment floatOutput = allocator.allocate(C_POINTER);
                api.checkStatus(api.GetTensorMutableData.apply(outputAddress, floatOutput.address()));
                NodeInfo nodeInfo = outputs.get(i);
                TensorInfo tensorInfo = nodeInfo.getTypeInfo().getTensorInfo();
                long byteSize = tensorInfo.getType().getValueLayout().byteSize() * tensorInfo.getElementCount();
                byte[] x = MemoryAccess.getAddress(floatOutput)
                        .asSegment(byteSize, scope)
                        .toByteArray();
                out.put(nodeInfo.getName(), new OutputImpl(ByteBuffer.wrap(x)));
            }

            return new NamedCollectionImpl<>(out);
        }
    }
}
