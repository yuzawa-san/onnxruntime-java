/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ShortBuffer;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorShortImpl extends OnnxTensorBufferImpl<ShortBuffer> implements MapScalar<Short> {

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

    @Override
    public void put(int index, Short scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Short> getValues() {
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
