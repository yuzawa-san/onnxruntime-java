/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class TensorInfoImpl implements TensorInfo {

    private final OnnxTensorElementDataType type;
    private final List<Long> shape;
    private final MemorySegment shapeData;
    private final long elementCount;

    TensorInfoImpl(OnnxTensorElementDataType type, MemorySegment shapeData, int dimCount, long elementCount) {
        this.type = type;
        List<Long> shape = new ArrayList<>(dimCount);
        for (int i = 0; i < dimCount; i++) {
            shape.add(shapeData.getAtIndex(C_LONG, i));
        }
        this.shape = Collections.unmodifiableList(shape);
        this.shapeData = shapeData;
        this.elementCount = elementCount;
    }

    TensorInfoImpl(OnnxTensorElementDataType type, List<Long> shape) {
        this.type = type;
        this.shape = Collections.unmodifiableList(shape);
        int size = shape.size();
        long elementCount = 1;
        for (int i = 0; i < size; i++) {
            long dim = shape.get(i);
            if (dim <= 0) {
                throw new IllegalArgumentException("Invalid shape: dimension must be greater than zero");
            }
            elementCount *= dim;
        }
        this.shapeData = null;
        this.elementCount = elementCount;
    }

    TensorInfoImpl(OnnxTensorElementDataType type, long size) {
        this(type, Collections.singletonList(size));
    }

    MemorySegment getShapeData(Arena arena) {
        if (shapeData != null) {
            return shapeData;
        }
        int size = shape.size();
        MemorySegment out = arena.allocate(C_LONG, size);
        for (int i = 0; i < size; i++) {
            out.setAtIndex(C_LONG, i, shape.get(i));
        }
        return out;
    }

    @Override
    public OnnxTensorElementDataType getType() {
        return type;
    }

    @Override
    public List<Long> getShape() {
        return shape;
    }

    @Override
    public long getElementCount() {
        return elementCount;
    }

    @Override
    public String toString() {
        return "tensor(" + type + shape + ")";
    }

    @Override
    public long getByteCount() {
        return Math.ceilDiv(elementCount * type.getBits(), 8);
    }

    @Override
    public boolean isDynamicShape() {
        int dims = shape.size();
        if (dims == 0) {
            return true;
        }
        for (int i = 0; i < dims; i++) {
            if (shape.get(i) < 0) {
                return true;
            }
        }
        return false;
    }

    final OnnxTensorImpl newValue(ValueContext valueContext, MemorySegment ortValueAddress) {
        return switch (type) {
            case INT8,
                    UINT8,
                    BOOL,
                    FLOAT8E4M3FN,
                    FLOAT8E4M3FNUZ,
                    FLOAT8E5M2,
                    FLOAT8E5M2FNUZ,
                    INT4,
                    UINT4,
                    FLOAT4E2M1,
                    INT2,
                    UINT2 -> new OnnxTensorByteImpl(this, valueContext, ortValueAddress);
            case INT16, UINT16, FLOAT16, BFLOAT16 -> new OnnxTensorShortImpl(this, valueContext, ortValueAddress);
            case INT32, UINT32 -> new OnnxTensorIntImpl(this, valueContext, ortValueAddress);
            case INT64, UINT64 -> new OnnxTensorLongImpl(this, valueContext, ortValueAddress);
            case FLOAT, COMPLEX64 -> new OnnxTensorFloatImpl(this, valueContext, ortValueAddress);
            case DOUBLE, COMPLEX128 -> new OnnxTensorDoubleImpl(this, valueContext, ortValueAddress);
            case STRING -> new OnnxTensorStringImpl(this, valueContext, ortValueAddress);
            case UNDEFINED ->
                throw new UnsupportedOperationException("OnnxTensor with type " + type + " is not supported");
        };
    }
}
