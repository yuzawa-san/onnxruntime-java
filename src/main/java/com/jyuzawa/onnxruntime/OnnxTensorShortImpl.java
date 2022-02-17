/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.stream.Stream;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorShortImpl extends OnnxTensorBufferImpl<ShortBuffer> {

    OnnxTensorShortImpl(TensorInfo tensorInfo) {
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
            buffer.put(scalar.getShortBuffer().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getShortBuffer().put(buffer.get()).flip());
    }
}
