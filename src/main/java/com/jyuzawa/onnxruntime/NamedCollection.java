/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.List;
import java.util.Map;

public interface NamedCollection<V> {

    V get(String name);

    V get(int index);

    Map<String, V> map();

    List<V> list();

    int size();
}
