/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

abstract class OnnxTensorImpl extends OnnxValueImpl implements OnnxTensor {

    protected final TensorInfoImpl tensorInfo;

    protected OnnxTensorImpl(TensorInfoImpl tensorInfo) {
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

    private final NoSuchElementException fail() {
        return new NoSuchElementException("Invalid access of OnnxTensor with type " + tensorInfo.getType());
    }

    @Override
    public ByteBuffer getByteBuffer() {
        throw fail();
    }

    @Override
    public ShortBuffer getShortBuffer() {
        throw fail();
    }

    @Override
    public IntBuffer getIntBuffer() {
        throw fail();
    }

    @Override
    public LongBuffer getLongBuffer() {
        throw fail();
    }

    @Override
    public FloatBuffer getFloatBuffer() {
        throw fail();
    }

    @Override
    public DoubleBuffer getDoubleBuffer() {
        throw fail();
    }

    @Override
    public String[] getStringBuffer() {
        throw fail();
    }

    abstract void putScalars(Collection<OnnxTensorImpl> scalars);

    abstract void getScalars(Stream<OnnxTensorImpl> scalars);

    static final OnnxTensorImpl fromTypeInfo(TensorInfoImpl tensorInfo) {
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
