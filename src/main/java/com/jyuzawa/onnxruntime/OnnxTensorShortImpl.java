/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ShortBuffer;
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
}
