/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorFloatImpl extends OnnxTensorBufferImpl<FloatBuffer> {

    OnnxTensorFloatImpl(TensorInfo tensorInfo) {
        super(tensorInfo, FloatBuffer::allocate);
    }

    @Override
    public FloatBuffer getFloatBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getFloatBuffer().get());
        }
    }

    @Override
    public void getScalars(List<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            scalar.getFloatBuffer().put(buffer.get()).flip();
        }
    }
}
