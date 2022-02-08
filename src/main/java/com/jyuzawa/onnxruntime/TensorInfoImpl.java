/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

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

    public String toString() {
        return "{TensorInfo: type=" + type + ", shape=" + shape + ", elementCount=" + elementCount + "}";
    }

    @Override
    public long getByteCount() {
        // TODO: handle missing valueLayout
        return elementCount * type.getValueLayout().byteSize();
    }
}
