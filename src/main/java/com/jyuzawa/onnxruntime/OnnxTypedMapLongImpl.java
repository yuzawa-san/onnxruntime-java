/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxTypedMapLongImpl extends OnnxMapImpl<Long> {

    OnnxTypedMapLongImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Long> withLongKeys() {
        return this;
    }
}
