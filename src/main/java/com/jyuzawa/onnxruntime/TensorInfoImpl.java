/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Collections;
import java.util.List;

final class TensorInfoImpl implements TensorInfo {

    // TODO: symbolic dims
    private final OnnxTensorElementDataType type;
    private final List<Long> shape;
    private final long elementCount;

    TensorInfoImpl(OnnxTensorElementDataType type, List<Long> shape, long elementCount) {
        this.type = type;
        this.shape = shape;
        this.elementCount = elementCount;
    }

    TensorInfoImpl(OnnxTensorElementDataType type, long elementCount) {
        this(type, Collections.singletonList(elementCount), elementCount);
    }

    TensorInfoImpl(OnnxTensorElementDataType type) {
        this(type, 1);
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
}
