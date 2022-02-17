/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.IntBuffer;
import java.util.Collection;
import java.util.stream.Stream;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorIntImpl extends OnnxTensorBufferImpl<IntBuffer> {

    OnnxTensorIntImpl(TensorInfo tensorInfo) {
        super(tensorInfo, IntBuffer::allocate);
    }

    @Override
    public IntBuffer getIntBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getIntBuffer().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getIntBuffer().put(buffer.get()).flip());
    }
}
