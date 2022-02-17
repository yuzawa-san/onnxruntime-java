/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.FloatBuffer;
import java.util.Collection;
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
    public void implodeValues(Collection<OnnxTensorImpl> values) {
        for (OnnxTensorImpl value : values) {
            buffer.put(value.getFloatBuffer().get());
        }
    }

    @Override
    public void loadScalarFromVector(int index, OnnxTensorImpl scalar) {
        scalar.getFloatBuffer().put(0, buffer.get(index));
    }
}
