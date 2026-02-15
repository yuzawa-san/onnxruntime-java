/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

final class OnnxTensorLongImpl extends OnnxTensorBufferImpl<LongBuffer> {

    private static final Function<ByteBuffer, LongBuffer> CONVERT = ByteBuffer::asLongBuffer;

    OnnxTensorLongImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress, CONVERT);
    }

    @Override
    public LongBuffer getLongBuffer() {
        return buffer;
    }

    @Override
    void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getLongBuffer().flip().get());
        }
    }

    @Override
    void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getLongBuffer().put(buffer.get()).flip());
    }
}
