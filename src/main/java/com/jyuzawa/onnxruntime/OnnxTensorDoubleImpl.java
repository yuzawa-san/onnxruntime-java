/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.DoubleBuffer;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorDoubleImpl extends OnnxTensorBufferImpl<DoubleBuffer> implements MapScalar<Double> {

    OnnxTensorDoubleImpl(TensorInfo tensorInfo) {
        super(tensorInfo, DoubleBuffer::allocate);
    }

    @Override
    public DoubleBuffer getDoubleBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void put(int index, Double scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Double> getValues() {
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
