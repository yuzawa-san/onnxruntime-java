/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_LONG;

import java.nio.Buffer;
import java.util.List;
import java.util.function.IntFunction;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

abstract class OnnxTensorBufferImpl<T extends Buffer> extends OnnxTensorImpl {

    protected final T buffer;

    protected OnnxTensorBufferImpl(TensorInfo tensorInfo, IntFunction<T> factory) {
        super(tensorInfo);
        this.buffer = factory.apply(Math.toIntExact(tensorInfo.getElementCount()));
    }

    @Override
    public final String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + buffer + "}";
    }

    @Override
    public final MemoryAddress toNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress memoryInfo,
            ResourceScope scope,
            SegmentAllocator allocator) {
        MemorySegment rawInputData = getMemorySegment();
        // TODO: move value layout to this class?
        MemorySegment inputData =
                allocator.allocateArray(tensorInfo.getType().getValueLayout(), rawInputData.byteSize());
        inputData.copyFrom(rawInputData);
        List<Long> shape = tensorInfo.getShape();
        int shapeSize = shape.size();
        MemorySegment shapeData = allocator.allocateArray(C_LONG, shape(shape));
        return api.create(
                allocator,
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        memoryInfo,
                        inputData.address(),
                        inputData.byteSize(),
                        shapeData.address(),
                        shapeSize,
                        tensorInfo.getType().getNumber(),
                        out));
    }

    @Override
    public final void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            ResourceScope scope,
            SegmentAllocator allocator) {
        MemoryAddress floatOutput = api.create(allocator, out -> api.GetTensorMutableData.apply(address, out));
        MemorySegment segment = floatOutput.asSegment(tensorInfo.getByteCount(), scope);
        getMemorySegment().copyFrom(segment);
    }

    protected abstract MemorySegment getMemorySegment();
}
