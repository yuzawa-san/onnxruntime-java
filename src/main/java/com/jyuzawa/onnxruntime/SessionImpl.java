/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.*;
import static jdk.incubator.foreign.CLinker.*;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toJavaString;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.incubator.foreign.ValueLayout;

final class SessionImpl extends ManagedImpl implements Session {

    private final Map<String, NodeInfo> overridableInitializers;
    private final Map<String, NodeInfo> inputs;
    private final Map<String, NodeInfo> outputs;
    private final ModelMetadata modelMetadata;
    private final MemoryAddress ortAllocator;

    public SessionImpl(ApiImpl api, ResourceScope scope, MemoryAddress session) {
        super(api, scope, session);
        SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
        this.ortAllocator = api.create(allocator, out -> api.GetAllocatorWithDefaultOptions.apply(out));
        this.overridableInitializers = createMap(
                api,
                allocator,
                ortAllocator,
                session,
                api.SessionGetOverridableInitializerCount::apply,
                api.SessionGetOverridableInitializerName::apply,
                api.SessionGetOverridableInitializerTypeInfo::apply);
        this.inputs = createMap(
                api,
                allocator,
                ortAllocator,
                session,
                api.SessionGetInputCount::apply,
                api.SessionGetInputName::apply,
                api.SessionGetInputTypeInfo::apply);
        this.outputs = createMap(
                api,
                allocator,
                ortAllocator,
                session,
                api.SessionGetOutputCount::apply,
                api.SessionGetOutputName::apply,
                api.SessionGetOutputTypeInfo::apply);

        MemoryAddress metadata = api.create(allocator, out -> api.SessionGetModelMetadata.apply(session, out));
        this.modelMetadata = new ModelMetadataImpl(api, metadata, ortAllocator);
        api.ReleaseModelMetadata.apply(metadata);
    }

    private interface GetCount {
        MemoryAddress apply(MemoryAddress session, MemoryAddress out);
    }

    private interface GetName {
        MemoryAddress apply(MemoryAddress session, long idx, MemoryAddress ortAllocator, MemoryAddress out);
    }

    private interface GetTypeInfo {
        MemoryAddress apply(MemoryAddress session, long idx, MemoryAddress out);
    }

    private static Map<String, NodeInfo> createMap(
            ApiImpl api,
            SegmentAllocator allocator,
            MemoryAddress ortAllocator,
            MemoryAddress session,
            GetCount getCount,
            GetName getName,
            GetTypeInfo getTypeInfo) {
        MemorySegment numInputsSegment = allocator.allocate(C_LONG);
        api.checkStatus(getCount.apply(session, numInputsSegment.address()));
        long numInputs = MemoryAccess.getLong(numInputsSegment);
        Map<String, NodeInfo> inputs = new LinkedHashMap<>();
        for (long i = 0; i < numInputs; i++) {
            final long j = i;
            MemoryAddress nameSegment = api.create(allocator, out -> getName.apply(session, j, ortAllocator, out));
            String name = toJavaString(nameSegment);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
            MemoryAddress typeInfoAddress = api.create(allocator, out -> getTypeInfo.apply(session, j, out));
            TypeInfoImpl typeInfo = new TypeInfoImpl(api, typeInfoAddress, ortAllocator);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, typeInfoAddress));
            inputs.put(name, new NodeInfoImpl(name, typeInfo));
        }
        return Collections.unmodifiableMap(inputs);
    }

    @Override
    public Map<String, NodeInfo> getOverridableInitializers() {
        return overridableInitializers;
    }

    @Override
    public Map<String, NodeInfo> getInputs() {
        return inputs;
    }

    @Override
    public ModelMetadata getModelMetadata() {
        return modelMetadata;
    }

    @Override
    public Map<String, NodeInfo> getOutputs() {
        return outputs;
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
    public Output run(Transaction transaction) {

        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
            MemoryAddress memoryInfo = api.create(
                    allocator, out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out));

            MemorySegment output1 = toCString("variable", scope);

            MemoryAddress ioBinding = api.create(allocator, out -> api.CreateIoBinding.apply(address, out));
            scope.addCloseAction(() -> {
                api.ReleaseIoBinding.apply(ioBinding);
            });

            for (Map.Entry<String, float[]> entry : transaction.getInputs().entrySet()) {
                String inputName = entry.getKey();
                float[] input = entry.getValue();
                NodeInfo inputInfo = inputs.get(inputName);
                if (inputInfo == null) {
                    throw new IllegalArgumentException("input missing");
                }
                TensorInfo tensorInfo = inputInfo.getTypeInfo().getTensorInfo();
                MemorySegment input1 = toCString(inputName, scope);
                ValueLayout valueLayout = tensorInfo.getType().getValueLayout();
                if (valueLayout == null) {
                    throw new IllegalArgumentException("invalid input types");
                }
                MemorySegment inputData = allocator.allocateArray(valueLayout, input);
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

            Collection<String> runOutputs = transaction.getOutputs();
            Map<String, MemoryAddress> outputValues = new HashMap<>(runOutputs.size());
            for (String outputName : runOutputs) {
                NodeInfo outputInfo = outputs.get(outputName);
                if (outputInfo == null) {
                    throw new IllegalArgumentException("input missing");
                }
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
                outputValues.put(outputName, outputTensor);
            }

            api.checkStatus(api.RunWithBinding.apply(address, MemoryAddress.NULL, ioBinding));

            for (Map.Entry<String, MemoryAddress> entry : outputValues.entrySet()) {
                String outputName = entry.getKey();
                MemorySegment floatOutput = allocator.allocate(C_POINTER);
                api.checkStatus(api.GetTensorMutableData.apply(entry.getValue(), floatOutput.address()));
                TensorInfo tensorInfo = outputs.get(outputName).getTypeInfo().getTensorInfo();
                long byteSize = tensorInfo.getType().getValueLayout().byteSize() * tensorInfo.getElementCount();
                var x = MemoryAccess.getAddress(floatOutput).asSegment(byteSize, scope);
                System.out.println(outputName + "=" + Arrays.toString(x.toFloatArray()));
            }

            return null;
        }
    }
}
