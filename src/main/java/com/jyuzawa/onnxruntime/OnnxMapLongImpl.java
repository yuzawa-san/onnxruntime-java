/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.LongBuffer;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

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
    protected Stream<Long> explodeKeyVector(OnnxTensorLongImpl keyVector) {
        return Arrays.stream(keyVector.buffer.array()).boxed();
    }
}
