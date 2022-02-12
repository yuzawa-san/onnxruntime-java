/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxTypedMapIntImpl extends OnnxMapImpl<Integer> {

    OnnxTypedMapIntImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Integer> withIntegerKeys() {
        return this;
    }
}
