/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Collection;
import java.util.stream.Stream;

final class OnnxTensorIntImpl extends OnnxTensorBufferImpl<IntBuffer> {

    OnnxTensorIntImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemoryAddress ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress);
    }

    @Override
    public IntBuffer getIntBuffer() {
        return buffer;
    }

    @Override
    protected IntBuffer convert(ByteBuffer byteBuffer) {
        return byteBuffer.asIntBuffer();
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getIntBuffer().flip().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getIntBuffer().put(buffer.get()).flip());
    }
}
