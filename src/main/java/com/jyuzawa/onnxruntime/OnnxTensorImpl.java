/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.Buffer;
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

    protected OnnxTensorImpl(TensorInfoImpl tensorInfo, ValueContext valueContext) {
        super(OnnxType.TENSOR, valueContext);
        this.tensorInfo = tensorInfo;
    }

    @Override
    public final OnnxTensorImpl asTensor() {
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

    abstract MemorySegment getMemorySegment();

    abstract OnnxTensorImpl wrap(MemorySegment newMemorySegment);

    final OnnxTensor wrap(Buffer newBuffer) {
        if (!newBuffer.isDirect()) {
            throw new IllegalArgumentException("Only direct buffers may be wrapped");
        }
        return wrap(MemorySegment.ofBuffer(newBuffer));
    }
}
