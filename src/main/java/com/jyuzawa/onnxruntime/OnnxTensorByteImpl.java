/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

final class OnnxTensorByteImpl extends OnnxTensorBufferImpl<ByteBuffer> {

    OnnxTensorByteImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(tensorInfo, valueContext, ortValueAddress, Function.identity());
    }

    @Override
    public ByteBuffer getByteBuffer() {
        return buffer;
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getByteBuffer().flip().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getByteBuffer().put(buffer.get()).flip());
    }
}
