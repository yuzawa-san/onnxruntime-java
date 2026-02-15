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
    final MemorySegment shapeData;
    private final List<Long> shape;
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

    TensorInfoImpl(OnnxTensorElementDataType type, Arena arena, List<Long> shape) {
        this.type = type;
        this.shape = Collections.unmodifiableList(shape);
        int size = shape.size();
        long[] shapeArray = new long[size];
        long elementCount = 1;
        for (int i = 0; i < size; i++) {
            long dim = shape.get(i);
            if (dim <= 0) {
                throw new IllegalArgumentException("Invalid shape: dimension must be greater than zero");
            }
            shapeArray[i] = dim;
            elementCount *= dim;
        }
        this.shapeData = arena.allocateFrom(C_LONG, shapeArray);
        this.elementCount = elementCount;
    }

    static TensorInfoImpl of(OnnxTensorElementDataType type, long elementCount, Arena arena) {
        MemorySegment shapeData = arena.allocateFrom(C_LONG, new long[] {elementCount});
        return new TensorInfoImpl(type, shapeData, 1, elementCount);
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
        // TODO: handle missing valueLayout
        return elementCount * type.getValueLayout().byteSize();
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
        switch (type) {
            case BOOL:
            case INT8:
                return new OnnxTensorByteImpl(this, valueContext, ortValueAddress);
            case INT16:
                return new OnnxTensorShortImpl(this, valueContext, ortValueAddress);
            case INT32:
                return new OnnxTensorIntImpl(this, valueContext, ortValueAddress);
            case INT64:
                return new OnnxTensorLongImpl(this, valueContext, ortValueAddress);
            case FLOAT:
                return new OnnxTensorFloatImpl(this, valueContext, ortValueAddress);
            case DOUBLE:
                return new OnnxTensorDoubleImpl(this, valueContext, ortValueAddress);
            case STRING:
                return new OnnxTensorStringImpl(this, valueContext, ortValueAddress);
            default:
                throw new UnsupportedOperationException("OnnxTensor with type " + type + " is not supported");
        }
    }
}
