/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxTypedMapShortImpl extends OnnxMapImpl<Short> {

    OnnxTypedMapShortImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Short> withShortKeys() {
        return this;
    }
}
