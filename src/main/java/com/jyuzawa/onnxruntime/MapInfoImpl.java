/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

final class MapInfoImpl implements MapInfo {

    private final OnnxTensorElementDataType keyType;
    private final TypeInfoImpl typeInfo;

    MapInfoImpl(OnnxTensorElementDataType keyType, TypeInfoImpl typeInfo) {
        this.keyType = keyType;
        this.typeInfo = typeInfo;
    }

    @Override
    public OnnxTensorElementDataType getKeyType() {
        return keyType;
    }

    @Override
    public TypeInfoImpl getValueType() {
        return typeInfo;
    }

    @Override
    public String toString() {
        return "map(" + keyType + "," + typeInfo + ")";
    }
}
