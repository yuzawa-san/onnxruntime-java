/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

final class OnnxMapStringImpl extends OnnxMapImpl<String, OnnxTensorStringImpl> {

    OnnxMapStringImpl(MapInfo mapInfo) {
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
    protected List<String> explodeKeyVector(OnnxTensorStringImpl keyVector) {
        return Arrays.asList(keyVector.getStringBuffer());
    }
}
