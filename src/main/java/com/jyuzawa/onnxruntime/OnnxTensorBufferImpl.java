/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.nio.Buffer;
import java.util.function.IntFunction;

abstract class OnnxTensorBufferImpl<T extends Buffer> extends OnnxTensorImpl {

    protected final T buffer;

    protected OnnxTensorBufferImpl(TensorInfoImpl tensorInfo, IntFunction<T> factory) {
        super(tensorInfo);
        this.buffer = factory.apply(Math.toIntExact(tensorInfo.getElementCount()));
    }

    @Override
    public final String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + buffer + "}";
    }

    @Override
    public final MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, MemorySession allocator) {
        MemorySegment rawInputData = getMemorySegment();
        // TODO: move value layout to this class?
        MemorySegment inputData =
                allocator.allocateArray(tensorInfo.getType().getValueLayout(), rawInputData.byteSize());
        inputData.copyFrom(rawInputData);
        MemoryAddress tensor = api.create(
                allocator,
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        memoryInfo,
                        inputData.address(),
                        inputData.byteSize(),
                        tensorInfo.shapeData.address(),
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out));
        allocator.addCloseAction(() -> {
            api.ReleaseValue.apply(tensor);
        });
        return tensor;
    }

    @Override
    public final void fromNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress address, MemorySession allocator) {
        MemoryAddress floatOutput = api.create(allocator, out -> api.GetTensorMutableData.apply(address, out));
        MemorySegment segment = MemorySegment.ofAddress(floatOutput, tensorInfo.getByteCount(), allocator);
        getMemorySegment().copyFrom(segment);
        allocator.addCloseAction(() -> {
            api.ReleaseValue.apply(address);
        });
    }

    protected abstract MemorySegment getMemorySegment();
}
