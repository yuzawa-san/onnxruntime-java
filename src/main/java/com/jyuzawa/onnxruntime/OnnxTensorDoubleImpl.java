/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.util.Collection;
import java.util.stream.Stream;

final class OnnxTensorDoubleImpl extends OnnxTensorBufferImpl<DoubleBuffer> {

    OnnxTensorDoubleImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemoryAddress ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress);
    }

    @Override
    public DoubleBuffer getDoubleBuffer() {
        return buffer;
    }

    @Override
    protected DoubleBuffer convert(ByteBuffer byteBuffer) {
        return byteBuffer.asDoubleBuffer();
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getDoubleBuffer().flip().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getDoubleBuffer().put(buffer.get()).flip());
    }
}
