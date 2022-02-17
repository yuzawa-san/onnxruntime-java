/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorByteImpl extends OnnxTensorBufferImpl<ByteBuffer> implements MapScalar<Byte> {

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
    public void put(int index, Byte scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Byte> getValues() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void loadVectorFromScalar(int index, OnnxTensorImpl scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadScalarFromVector(int index, OnnxTensorImpl scalar) {
        // TODO Auto-generated method stub

    }
}
