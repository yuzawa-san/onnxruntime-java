/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.LongBuffer;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorLongImpl extends OnnxTensorBufferImpl<LongBuffer> implements MapScalar<Long> {

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
    public void put(int index, Long scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Long> getValues() {
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
