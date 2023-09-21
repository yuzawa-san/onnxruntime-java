/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.NoSuchElementException;

/**
 * A map view of an {@link OnnxValue}. Use the {@link MapInfo#getKeyType()} to
 * select a type-safe view. A {@link NoSuchElementException} will be thrown if a view does not exist for this instance's type.
 *
 * @since 1.0.0
 */
public interface OnnxMap {

    /**
     * Get information about the key and value types.
     * @return map's type information
     */
    MapInfo getInfo();

    /**
     * Get a type safe view with long keys
     * @return long map view
     * @throws NoSuchElementException if this typed view does not exist
     */
    OnnxTypedMap<Long> asLongMap();

    /**
     * Get a type safe view with string keys
     * @return string map view
     * @throws NoSuchElementException if this typed view does not exist
     */
    OnnxTypedMap<String> asStringMap();
}
