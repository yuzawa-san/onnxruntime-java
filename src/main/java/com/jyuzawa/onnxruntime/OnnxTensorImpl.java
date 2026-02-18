/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h$shared.C_LONG;

import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

abstract class OnnxTensorImpl extends OnnxValueImpl implements OnnxTensor {

    protected TensorInfoImpl tensorInfo;

    protected OnnxTensorImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(OnnxType.TENSOR, valueContext, ortValueAddress);
        // handle dynamic shaped tensor outputs: we will need to read the shape
        if (ortValueAddress != null && tensorInfo.isDynamicShape()) {
            ApiImpl api = valueContext.api();
            MemorySegment ortTensorInfo = api.create(
                    arena,
                    out -> api.GetTensorTypeAndShape.apply(ortValueAddress, out),
                    api.ReleaseTensorTypeAndShapeInfo::apply);
            OnnxTensorElementDataType dataType = OnnxTensorElementDataType.forNumber(
                    api.extractInt(arena, out -> api.GetTensorElementType.apply(ortTensorInfo, out)));
            int dimCount = api.extractInt(arena, out -> api.GetDimensionsCount.apply(ortTensorInfo, out));
            MemorySegment dims = arena.allocate(C_LONG, dimCount);
            api.checkStatus(api.GetDimensions.apply(ortTensorInfo, dims, dimCount));
            long elementCount = api.extractInt(arena, out -> api.GetTensorShapeElementCount.apply(ortTensorInfo, out));
            this.tensorInfo = new TensorInfoImpl(dataType, dims, dimCount, elementCount);
        } else {
            this.tensorInfo = tensorInfo;
        }
    }

    protected abstract boolean isInitialized();

    @Override
    public final OnnxTensor asTensor() {
        if (tensorInfo.isDynamicShape()) {
            throw new IllegalArgumentException("Dynamic shaped tensor info must specify static shape");
        }
        return this;
    }

    @Override
    public final OnnxTensor asTensor(List<Long> shape) {
        if (isInitialized()) {
            throw new IllegalArgumentException("Tensor buffer already initialized");
        }
        if (!tensorInfo.isDynamicShape()) {
            throw new IllegalArgumentException("Static shaped tensor info must not specify alternative shape");
        }

        this.tensorInfo = new TensorInfoImpl(tensorInfo.getType(), shape);
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
}
