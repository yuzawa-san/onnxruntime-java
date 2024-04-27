/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

final class OnnxMapStringImpl extends OnnxMapImpl<String, OnnxTensorStringImpl> {

    OnnxMapStringImpl(MapInfoImpl mapInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(mapInfo, valueContext, ortValueAddress);
    }

    @Override
    protected OnnxTensorStringImpl newKeyVector(TensorInfoImpl tensorInfo, MemorySegment keyAddress) {
        return new OnnxTensorStringImpl(tensorInfo, valueContext, keyAddress);
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
