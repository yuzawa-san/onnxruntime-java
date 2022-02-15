/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.LongBuffer;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorLongImpl extends OnnxTensorBufferImpl<LongBuffer> {

    OnnxTensorLongImpl(TensorInfo tensorInfo) {
        super(tensorInfo, LongBuffer::allocate);
    }

    @Override
    public LongBuffer getLongBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    protected void fromNativeMapValue(MemorySegment valueSegment, int i) {
        buffer.put(MemoryAccess.getLongAtIndex(valueSegment, i));
    }
}
