/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.FloatBuffer;
import jdk.incubator.foreign.MemoryAccess;
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
    protected void fromNativeMapValue(MemorySegment valueSegment, int i) {
        buffer.put(MemoryAccess.getFloatAtIndex(valueSegment, i));
    }
}
