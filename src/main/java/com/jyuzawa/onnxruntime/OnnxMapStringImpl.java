/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxMapStringImpl extends OnnxMapImpl<String, OnnxTensorStringImpl> {

    OnnxMapStringImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<String> asStringMap() {
        return this;
    }

    @Override
    protected OnnxTensorStringImpl newKeyVector(int size) {
        return new OnnxTensorStringImpl(new TensorInfoImpl(mapInfo.getKeyType(), size));
    }
}
