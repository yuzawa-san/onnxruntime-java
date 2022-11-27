/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

final class OnnxMapLongImpl extends OnnxMapImpl<Long, OnnxTensorLongImpl> {

    OnnxMapLongImpl(MapInfoImpl mapInfo, ValueContext valueContext, MemoryAddress ortValueAddress) {
        super(mapInfo, valueContext, ortValueAddress);
    }

    @Override
    protected OnnxTensorLongImpl newKeyVector(TensorInfoImpl tensorInfo, MemoryAddress keyAddress) {
        return new OnnxTensorLongImpl(tensorInfo, valueContext, keyAddress);
    }

    @Override
    public OnnxTypedMap<Long> asLongMap() {
        return this;
    }

    @Override
    protected void implodeKeyVector(OnnxTensorLongImpl keyVector, Set<Long> keys) {
        LongBuffer buffer = keyVector.buffer;
        for (Long key : keys) {
            buffer.put(key);
        }
        buffer.flip();
    }

    @Override
    protected Stream<Long> explodeKeyVector(OnnxTensorLongImpl keyVector) {
        return Arrays.stream(keyVector.buffer.array()).boxed();
    }
}
