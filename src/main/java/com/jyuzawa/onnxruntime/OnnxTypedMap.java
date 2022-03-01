/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;

/**
 * A type-safe map of an {@link OnnxValue}. Extends {@link java.util.Map} to provide an UNMODIFIABLE view. Use {@link #set(Object)} to populate the map.
 *
 * @param <K> key type
 */
public interface OnnxTypedMap<K> extends Map<K, OnnxValue> {

    /**
     *
     * @return Information about the key and value types.
     */
    MapInfo getInfo();

    /**
     *
     * @param key
     * @return A new OnnxValue of correct type, which the key is mapped towards.
     */
    OnnxValue set(K key);
}
