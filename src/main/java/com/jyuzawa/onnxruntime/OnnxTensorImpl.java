/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.List;

abstract class OnnxTensorImpl extends OnnxValueImpl implements OnnxTensor {

    protected final TensorInfo tensorInfo;

    protected OnnxTensorImpl(TensorInfo tensorInfo) {
        super(OnnxType.TENSOR);
        this.tensorInfo = tensorInfo;
    }

    @Override
    public final OnnxTensor asTensor() {
        return this;
    }

    @Override
    public final TensorInfo getInfo() {
        return tensorInfo;
    }

    private final IllegalStateException fail() {
        return new IllegalStateException("Invalid access of OnnxTensor with type " + tensorInfo.getType());
    }

    public ByteBuffer getByteBuffer() {
        throw fail();
    }

    public ShortBuffer getShortBuffer() {
        throw fail();
    }

    public IntBuffer getIntBuffer() {
        throw fail();
    }

    public LongBuffer getLongBuffer() {
        throw fail();
    }

    public FloatBuffer getFloatBuffer() {
        throw fail();
    }

    public DoubleBuffer getDoubleBuffer() {
        throw fail();
    }

    public String[] getStringBuffer() {
        throw fail();
    }

    protected static final long[] shape(List<Long> original) {
        int shapeSize = original.size();
        long[] shapeArray = new long[shapeSize];
        for (int i = 0; i < shapeSize; i++) {
            shapeArray[i] = original.get(i);
        }
        return shapeArray;
    }

    static final OnnxTensorImpl fromTypeInfo(TensorInfo tensorInfo) {
        OnnxTensorElementDataType type = tensorInfo.getType();
        switch (type) {
            case BOOL:
            case INT8:
                return new OnnxTensorByteImpl(tensorInfo);
            case INT16:
                return new OnnxTensorShortImpl(tensorInfo);
            case INT32:
                return new OnnxTensorIntImpl(tensorInfo);
            case INT64:
                return new OnnxTensorLongImpl(tensorInfo);
            case FLOAT:
                return new OnnxTensorFloatImpl(tensorInfo);
            case DOUBLE:
                return new OnnxTensorDoubleImpl(tensorInfo);
            case STRING:
                return new OnnxTensorStringImpl(tensorInfo);
            default:
                throw new UnsupportedOperationException("OnnxTensor with type " + type + " is not supported");
        }
    }
}
