/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.IntBuffer;
import jdk.incubator.foreign.MemoryAccess;
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
    protected void fromNativeMapValue(MemorySegment valueSegment, int i) {
        buffer.put(MemoryAccess.getIntAtIndex(valueSegment, i));
    }
}
