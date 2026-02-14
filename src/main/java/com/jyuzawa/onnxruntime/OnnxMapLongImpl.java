/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

final class OnnxMapLongImpl extends OnnxMapImpl<Long, OnnxTensorLongImpl> {

    OnnxMapLongImpl(MapInfoImpl mapInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(mapInfo, valueContext, ortValueAddress);
    }

    @Override
    protected OnnxTensorLongImpl newKeyVector(TensorInfoImpl tensorInfo, MemorySegment keyAddress) {
        return new OnnxTensorLongImpl(tensorInfo, valueContext, keyAddress);
    }

    @Override
    public OnnxTypedMap<Long> asLongMap() {
        return this;
    }

    @Override
    protected void implodeKeyVector(OnnxTensorLongImpl keyVector, Set<Long> keys) {
        LongBuffer buffer = keyVector.getBuffer();
        for (Long key : keys) {
            buffer.put(key);
        }
        buffer.flip();
    }

    @Override
    protected Stream<Long> explodeKeyVector(OnnxTensorLongImpl keyVector) {
        LongBuffer buf = keyVector.getBuffer();
        int count = buf.capacity();
        List<Long> out = new ArrayList<>(count);
        for (int i = 0; i < buf.capacity(); i++) {
            out.add(buf.get(i));
        }
        return out.stream();
    }
}
