/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

final class OnnxMapStringImpl extends OnnxMapImpl<String, OnnxTensorStringImpl> {

    OnnxMapStringImpl(MapInfoImpl mapInfo) {
        super(mapInfo, OnnxTensorStringImpl::new);
    }

    @Override
    public OnnxTypedMap<String> asStringMap() {
        return this;
    }

    @Override
    protected void implodeKeyVector(OnnxTensorStringImpl keyVector, Set<String> keys) {
        String[] buffer = keyVector.getStringBuffer();
        int i = 0;
        for (String key : keys) {
            buffer[i++] = key;
        }
    }

    @Override
    protected Stream<String> explodeKeyVector(OnnxTensorStringImpl keyVector) {
        return Arrays.stream(keyVector.getStringBuffer());
    }
}
