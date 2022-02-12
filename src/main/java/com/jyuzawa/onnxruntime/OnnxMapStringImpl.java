/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxMapStringImpl extends OnnxMapImpl<String> {

    OnnxMapStringImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxMap<String> asStringMap() {
        return this;
    }
}
