/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.function.Function;

abstract class OnnxTensorBufferImpl<T extends Buffer> extends OnnxTensorImpl {

    private final MemorySegment memorySegment;
    protected final T buffer;

    protected OnnxTensorBufferImpl(
            TensorInfoImpl tensorInfo,
            ValueContext valueContext,
            MemoryAddress ortValueAddress,
            Function<ByteBuffer, T> convert) {
        super(tensorInfo, valueContext);
        SegmentAllocator segmentAllocator = valueContext.segmentAllocator();
        if (ortValueAddress == null) {
            this.memorySegment =
                    segmentAllocator.allocateArray(tensorInfo.getType().getValueLayout(), tensorInfo.getElementCount());
        } else {
            ApiImpl api = valueContext.api();
            MemoryAddress floatOutput =
                    api.create(segmentAllocator, out -> api.GetTensorMutableData.apply(ortValueAddress, out));
            this.memorySegment =
                    MemorySegment.ofAddress(floatOutput, tensorInfo.getByteCount(), valueContext.memorySession());
        }
        this.buffer = convert.apply(memorySegment.asByteBuffer().order(ByteOrder.nativeOrder()));
    }

    @Override
    public final String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + buffer + "}";
    }

    @Override
    public final MemoryAddress toNative() {
        ApiImpl api = valueContext.api();
        return api.create(
                valueContext.segmentAllocator(),
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        valueContext.memoryInfoAddress(),
                        memorySegment.address(),
                        memorySegment.byteSize(),
                        tensorInfo.shapeData.address(),
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out));
    }
}
