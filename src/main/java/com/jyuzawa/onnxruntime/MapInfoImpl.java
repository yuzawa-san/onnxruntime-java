/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class MapInfoImpl implements MapInfo {

    private final OnnxTensorElementDataType keyType;
    private final TypeInfo typeInfo;

    MapInfoImpl(OnnxTensorElementDataType keyType, TypeInfoImpl typeInfo) {
        this.keyType = keyType;
        this.typeInfo = typeInfo;
    }

    @Override
    public OnnxTensorElementDataType getKeyType() {
        return keyType;
    }

    @Override
    public TypeInfo getValueType() {
        return typeInfo;
    }
}
