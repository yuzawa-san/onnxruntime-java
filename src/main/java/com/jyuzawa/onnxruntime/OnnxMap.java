/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.NoSuchElementException;

/**
 * A map view of an {@link OnnxValue}. Use the {@link MapInfo#getKeyType()} to
 * select a type-safe view. A {@link NoSuchElementException} will be thrown if a view does not exist for this instance's type.
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
