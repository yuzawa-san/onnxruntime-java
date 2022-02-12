/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorByteImpl extends OnnxTensorBufferImpl<ByteBuffer> {

    OnnxTensorByteImpl(TensorInfo tensorInfo) {
        super(tensorInfo, ByteBuffer::allocate);
    }

    @Override
    public ByteBuffer getByteBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }
}
