/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

/**
 * A map view of an {@link OnnxValue}. The keys are restricted to byte, short, integer, long, and string. Use the {@code with*} methods to get a typed view of the map.
 *
 */
public interface OnnxMap {

    MapInfo getInfo();

    OnnxTypedMap<Byte> withByteKeys();

    OnnxTypedMap<Short> withShortKeys();

    OnnxTypedMap<Integer> withIntegerKeys();

    OnnxTypedMap<Long> withLongKeys();

    OnnxTypedMap<String> withStringKeys();
}
