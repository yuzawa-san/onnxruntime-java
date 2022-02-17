/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.FloatBuffer;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorFloatImpl extends OnnxTensorBufferImpl<FloatBuffer> implements MapScalar<Float> {

    OnnxTensorFloatImpl(TensorInfo tensorInfo) {
        super(tensorInfo, FloatBuffer::allocate);
    }

    @Override
    public FloatBuffer getFloatBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void put(int index, Float scalar) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Float> getValues() {
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
