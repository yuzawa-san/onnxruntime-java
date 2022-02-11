/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface OnnxMap {

    MapInfo getInfo();

    OnnxValue get(Byte key);

    OnnxValue get(Short key);

    OnnxValue get(Integer key);

    OnnxValue get(Long key);

    OnnxValue get(String key);
}
