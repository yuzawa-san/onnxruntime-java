/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
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
            MemorySegment ortValueAddress,
            Function<ByteBuffer, T> convert) {
        super(tensorInfo, valueContext);
        Arena arena = valueContext.arena();
        if (ortValueAddress == null) {
            this.memorySegment = arena.allocate(tensorInfo.getType().getValueLayout(), tensorInfo.getElementCount());
        } else {
            ApiImpl api = valueContext.api();
            MemorySegment floatOutput = api.create(arena, out -> api.GetTensorMutableData.apply(ortValueAddress, out));
            this.memorySegment = floatOutput.reinterpret(tensorInfo.getByteCount());
        }
        this.buffer = convert.apply(memorySegment.asByteBuffer().order(ByteOrder.nativeOrder()));
    }

    @Override
    public final String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + buffer + "}";
    }

    @Override
    public final MemorySegment toNative() {
        ApiImpl api = valueContext.api();
        return api.create(
                valueContext.arena(),
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        valueContext.memoryInfoAddress(),
                        memorySegment,
                        memorySegment.byteSize(),
                        tensorInfo.shapeData,
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out));
    }
}
