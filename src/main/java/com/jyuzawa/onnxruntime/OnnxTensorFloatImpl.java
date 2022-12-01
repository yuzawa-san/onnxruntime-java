/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

final class OnnxTensorFloatImpl extends OnnxTensorBufferImpl<FloatBuffer> {

    private static final Function<ByteBuffer, FloatBuffer> CONVERT = ByteBuffer::asFloatBuffer;

    OnnxTensorFloatImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemoryAddress ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress, CONVERT);
    }

    @Override
    public FloatBuffer getFloatBuffer() {
        return buffer;
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getFloatBuffer().flip().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getFloatBuffer().put(buffer.get()).flip());
    }
}
