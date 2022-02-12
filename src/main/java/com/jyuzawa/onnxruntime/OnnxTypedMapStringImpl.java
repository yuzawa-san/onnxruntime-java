/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxTypedMapStringImpl extends OnnxMapImpl<String> {

    OnnxTypedMapStringImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<String> withStringKeys() {
        return this;
    }
}
