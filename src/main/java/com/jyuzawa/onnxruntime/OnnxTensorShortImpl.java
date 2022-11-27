/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.stream.Stream;

final class OnnxTensorShortImpl extends OnnxTensorBufferImpl<ShortBuffer> {

    OnnxTensorShortImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemoryAddress ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress);
    }

    @Override
    public ShortBuffer getShortBuffer() {
        return buffer;
    }

    @Override
    protected ShortBuffer convert(ByteBuffer byteBuffer) {
        return byteBuffer.asShortBuffer();
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getShortBuffer().flip().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getShortBuffer().put(buffer.get()).flip());
    }
}
