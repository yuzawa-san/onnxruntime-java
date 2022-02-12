/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

final class OnnxTypedMapByteImpl extends OnnxMapImpl<Byte> {

    OnnxTypedMapByteImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Byte> withByteKeys() {
        return this;
    }
}
