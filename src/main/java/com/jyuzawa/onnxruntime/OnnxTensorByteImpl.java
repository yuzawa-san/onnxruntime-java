/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
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

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getByteBuffer().get());
        }
    }

    @Override
    public void getScalars(List<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            scalar.getByteBuffer().put(buffer.get()).flip();
        }
    }
}
