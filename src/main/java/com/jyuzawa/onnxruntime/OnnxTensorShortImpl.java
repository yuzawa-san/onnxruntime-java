/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.stream.Stream;

final class OnnxTensorShortImpl extends OnnxTensorBufferImpl<ShortBuffer> {

    OnnxTensorShortImpl(TensorInfoImpl tensorInfo) {
        super(tensorInfo, ShortBuffer::allocate);
    }

    @Override
    public ShortBuffer getShortBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
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
