/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxMapShortImpl extends OnnxMapImpl<Short> {

    OnnxMapShortImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxMap<Short> asShortMap() {
        return this;
    }
}
