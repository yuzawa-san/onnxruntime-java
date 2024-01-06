/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class TensorInfoImpl implements TensorInfo {

    // TODO: symbolic dims
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

    static TensorInfoImpl of(OnnxTensorElementDataType type, long elementCount, SegmentAllocator scope) {
        MemorySegment shapeData = scope.allocateFrom(C_LONG, new long[] {elementCount});
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
