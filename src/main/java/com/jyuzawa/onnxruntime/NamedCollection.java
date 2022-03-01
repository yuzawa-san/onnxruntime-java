/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.List;
import java.util.Map;

/**
 * An immutable collection which can be accessed by list index or name.
 * @param <V> the type in the collection
 */
public interface NamedCollection<V> {

    V get(String name);

    V get(int index);

    Map<String, V> getMap();

    List<V> getList();

    int size();
}
