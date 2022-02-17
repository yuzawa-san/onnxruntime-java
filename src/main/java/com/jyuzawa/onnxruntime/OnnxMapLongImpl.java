/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxMapLongImpl extends OnnxMapImpl<Long, OnnxTensorLongImpl> {

    OnnxMapLongImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Long> asLongMap() {
        return this;
    }

    @Override
    protected OnnxTensorLongImpl newKeyVector(int size) {
        return new OnnxTensorLongImpl(new TensorInfoImpl(mapInfo.getKeyType(), size));
    }
}
