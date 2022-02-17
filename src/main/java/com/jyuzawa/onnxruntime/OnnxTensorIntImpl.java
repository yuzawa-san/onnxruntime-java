/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorIntImpl extends OnnxTensorBufferImpl<IntBuffer> implements MapScalar<Integer> {

    OnnxTensorIntImpl(TensorInfo tensorInfo) {
        super(tensorInfo, IntBuffer::allocate);
    }

    @Override
    public IntBuffer getIntBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void put(int index, Integer scalar) {
        buffer.put(index, scalar);
    }

    @Override
    public List<Integer> getValues() {
        List<Integer> out = new ArrayList<>(buffer.capacity());
        for (Integer key : buffer.array()) {
            out.add(key);
        }
        return out;
    }

    @Override
    public void loadVectorFromScalar(int index, OnnxTensorImpl scalar) {
        buffer.put(index, scalar.getIntBuffer().get(0));
    }

    @Override
    public void loadScalarFromVector(int index, OnnxTensorImpl scalar) {
        scalar.getIntBuffer().put(0, buffer.get(index));
    }
}
