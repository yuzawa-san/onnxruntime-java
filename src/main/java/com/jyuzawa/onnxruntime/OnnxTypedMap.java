/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;

/**
 * A type-safe map of an {@link OnnxValue}. Extends {@link java.util.Map} but 1)
 * put operations are restricted to respect ONNX type information. 2) views are
 * immutable.
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
    OnnxValue put(K key);

    /**
     * WARNING: Elements can only be put using {@link OnnxTypedMap#put(Object)}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default OnnxValue put(K key, OnnxValue value) {
        throw new UnsupportedOperationException("Elements can only be put using OnnxTypedMap.set(K)");
    }

    /**
     * WARNING: Elements can only be put using {@link OnnxTypedMap#put(Object)}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default void putAll(Map<? extends K, ? extends OnnxValue> m) {
        throw new UnsupportedOperationException("Elements can only be put using OnnxTypedMap.set(K)");
    }
}
