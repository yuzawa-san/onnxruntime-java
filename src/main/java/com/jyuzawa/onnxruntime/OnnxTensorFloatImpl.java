/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.FloatBuffer;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorFloatImpl extends OnnxTensorImpl<FloatBuffer> {

    OnnxTensorFloatImpl(TensorInfo tensorInfo) {
        super(tensorInfo, FloatBuffer::allocate);
    }

    public FloatBuffer getFloatBuffer() {
        return buffer;
    }

    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }
}
