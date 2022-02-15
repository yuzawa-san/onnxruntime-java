/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxMapIntImpl extends OnnxMapImpl<Integer> {

    OnnxMapIntImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Integer> asIntMap() {
        return this;
    }
}
