/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.function.Function;

abstract class OnnxTensorBufferImpl<T extends Buffer> extends OnnxTensorImpl {

    private final Function<ByteBuffer, T> convert;
    private MemorySegment memorySegment;
    private T buffer;

    protected OnnxTensorBufferImpl(
            TensorInfoImpl tensorInfo,
            ValueContext valueContext,
            MemorySegment ortValueAddress,
            Function<ByteBuffer, T> convert) {
        super(tensorInfo, valueContext, ortValueAddress);
        this.convert = convert;
    }

    @Override
    protected final boolean isInitialized() {
        return buffer != null;
    }

    protected final T getBuffer() {
        if (buffer != null) {
            return buffer;
        }
        ApiImpl api = valueContext.api();
        if (ortValueAddress == null) {
            ortValueAddress = api.create(
                    this.arena,
                    out -> api.CreateTensorAsOrtValue.apply(
                            valueContext.ortAllocatorAddress(),
                            tensorInfo.getShapeData(arena),
                            tensorInfo.getShape().size(),
                            tensorInfo.getType().getNumber(),
                            out),
                    api.ReleaseValue::apply);
        }
        MemorySegment tensorData = api.create(this.arena, out -> api.GetTensorMutableData.apply(ortValueAddress, out));
        this.memorySegment = tensorData.reinterpret(tensorInfo.getByteCount(), this.arena, _ -> {});
        return this.buffer = convert.apply(memorySegment.asByteBuffer().order(ByteOrder.nativeOrder()));
    }

    @Override
    public final String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + getBuffer() + "}";
    }

    @Override
    public final MemorySegment toNative() {
        getBuffer();
        return ortValueAddress;
    }
}
