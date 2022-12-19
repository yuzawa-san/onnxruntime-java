/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;

final class MapInfoImpl implements MapInfo {

    private final OnnxTensorElementDataType keyType;
    private final TypeInfoImpl valueType;

    MapInfoImpl(OnnxTensorElementDataType keyType, TypeInfoImpl valueType) {
        this.keyType = keyType;
        this.valueType = valueType;
    }

    @Override
    public OnnxTensorElementDataType getKeyType() {
        return keyType;
    }

    @Override
    public TypeInfoImpl getValueType() {
        return valueType;
    }

    @Override
    public String toString() {
        return "map(" + keyType + "," + valueType + ")";
    }

    final OnnxValueImpl newValue(ValueContext valueContext, MemorySegment ortValueAddress) {
        if (valueType.getType() != OnnxType.TENSOR || valueType.getTensorInfo().getElementCount() != 1) {
            throw new UnsupportedOperationException("OnnxMap only supports scalar values");
        }
        switch (keyType) {
            case INT64:
                return new OnnxMapLongImpl(this, valueContext, ortValueAddress);
            case STRING:
                return new OnnxMapStringImpl(this, valueContext, ortValueAddress);
            default:
                throw new UnsupportedOperationException("OnnxMap does not support keys of type " + keyType);
        }
    }
}
