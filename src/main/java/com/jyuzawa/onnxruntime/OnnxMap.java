/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

/**
 * A map view of an {@link OnnxValue}. Use the {@link MapInfo#getKeyType()} to
 * select a type-safe view.
 */
public interface OnnxMap {

    /**
     *
     * @return Information about the key and value types.
     */
    MapInfo getInfo();

    OnnxTypedMap<Long> asLongMap();

    OnnxTypedMap<String> asStringMap();
}
