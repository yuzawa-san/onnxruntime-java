/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class OnnxMapLongImpl extends OnnxMapImpl<Long, OnnxTensorLongImpl> {

    OnnxMapLongImpl(MapInfo mapInfo) {
        super(mapInfo, OnnxTensorLongImpl::new);
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
    protected List<Long> explodeKeyVector(OnnxTensorLongImpl keyVector) {
        LongBuffer buffer = keyVector.buffer;
        List<Long> out = new ArrayList<>(buffer.capacity());
        for (Long key : buffer.array()) {
            out.add(key);
        }
        return out;
    }
}
