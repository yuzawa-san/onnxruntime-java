/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxMapByteImpl extends OnnxMapImpl<Byte> {

    OnnxMapByteImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxMap<Byte> asByteMap() {
        return this;
    }
}
