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

    private MemorySegment memorySegment;
    private T buffer;
    private final Function<ByteBuffer, T> convert;

    protected OnnxTensorBufferImpl(
            TensorInfoImpl tensorInfo,
            ValueContext valueContext,
            MemorySegment ortValueAddress,
            Function<ByteBuffer, T> convert) {
        super(tensorInfo, valueContext);
        this.convert = convert;
        if (ortValueAddress != null) {
            Arena arena = valueContext.arena();
            ApiImpl api = valueContext.api();
            MemorySegment floatOutput = api.create(arena, out -> api.GetTensorMutableData.apply(ortValueAddress, out));
            this.memorySegment = floatOutput.reinterpret(tensorInfo.getByteCount());
        }
    }

    @Override
    public final String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + buffer + "}";
    }

    @Override
    public final MemorySegment toNative() {
        ApiImpl api = valueContext.api();
        MemorySegment theMemorySegment = getMemorySegment();
        return api.create(
                valueContext.arena(),
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        valueContext.memoryInfoAddress(),
                        theMemorySegment,
                        theMemorySegment.byteSize(),
                        tensorInfo.shapeData,
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out));
    }

    @Override
    final MemorySegment getMemorySegment() {
        if (memorySegment == null) {
            this.memorySegment =
                    valueContext.arena().allocate(tensorInfo.getType().getValueLayout(), tensorInfo.getElementCount());
        }
        return memorySegment;
    }

    protected final T getBuffer() {
        if (buffer == null) {
            this.buffer = convert.apply(getMemorySegment().asByteBuffer().order(ByteOrder.nativeOrder()));
        }
        return buffer;
    }

    @Override
    final OnnxTensorBufferImpl<T> wrap(MemorySegment newMemorySegment) {
        if (this.memorySegment != null) {
            throw new IllegalStateException("Cannot replace existing MemorySegment " + memorySegment);
        }
        if (newMemorySegment.byteSize() != tensorInfo.getByteCount()) {
            throw new IllegalArgumentException("MemorySegment size mismatch");
        }
        this.memorySegment = newMemorySegment;
        return this;
    }
}
