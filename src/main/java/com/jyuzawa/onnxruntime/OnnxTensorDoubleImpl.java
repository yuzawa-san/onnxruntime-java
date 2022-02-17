/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.DoubleBuffer;
import java.util.Collection;
import java.util.stream.Stream;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorDoubleImpl extends OnnxTensorBufferImpl<DoubleBuffer> {

    OnnxTensorDoubleImpl(TensorInfo tensorInfo) {
        super(tensorInfo, DoubleBuffer::allocate);
    }

    @Override
    public DoubleBuffer getDoubleBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
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
