/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;

public interface OnnxMap {

    MapInfo getInfo();

    <K> Map<K, OnnxValue> getData(Class<K> keyClazz);
}
