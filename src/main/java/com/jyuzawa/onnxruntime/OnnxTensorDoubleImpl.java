/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.DoubleBuffer;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorDoubleImpl extends OnnxTensorBufferImpl<DoubleBuffer> {

    OnnxTensorDoubleImpl(TensorInfo tensorInfo) {
        super(tensorInfo, DoubleBuffer::allocate);
    }

    public DoubleBuffer getDoubleBuffer() {
        return buffer;
    }

    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }
}
