/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

final class OnnxTensorShortImpl extends OnnxTensorBufferImpl<ShortBuffer> {

    private static final Function<ByteBuffer, ShortBuffer> CONVERT = ByteBuffer::asShortBuffer;

    OnnxTensorShortImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress, CONVERT);
    }

    @Override
    public ShortBuffer getShortBuffer() {
        return getBuffer();
    }

    @Override
    void putScalars(Collection<OnnxTensorImpl> scalars) {
        ShortBuffer buffer = getBuffer();
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getShortBuffer().flip().get());
        }
    }

    @Override
    void getScalars(Stream<OnnxTensorImpl> scalars) {
        ShortBuffer buffer = getBuffer();
        scalars.forEach(scalar -> scalar.getShortBuffer().put(buffer.get()).flip());
    }
}
