/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

final class OnnxTensorIntImpl extends OnnxTensorBufferImpl<IntBuffer> {

    private static final Function<ByteBuffer, IntBuffer> CONVERT = ByteBuffer::asIntBuffer;

    OnnxTensorIntImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress, CONVERT);
    }

    @Override
    public IntBuffer getIntBuffer() {
        return getBuffer();
    }

    @Override
    void putScalars(Collection<OnnxTensorImpl> scalars) {
        IntBuffer buffer = getBuffer();
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getIntBuffer().flip().get());
        }
    }

    @Override
    void getScalars(Stream<OnnxTensorImpl> scalars) {
        IntBuffer buffer = getBuffer();
        scalars.forEach(scalar -> scalar.getIntBuffer().put(buffer.get()).flip());
    }
}
