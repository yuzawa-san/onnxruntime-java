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

    /**
     * Get by name.
     * @param name the name of the desired input or output
     * @return a value in the collection, or null if it is not present
     */
    V get(String name);

    /**
     * Get by index.
     * @param index the index of the desired the input or output
     * @return a value in the collection
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
     */
    V get(int index);

    /**
     * Get a map view.
     * @return an unmodifiable map
     */
    Map<String, V> getMap();

    /**
     * Get a list view.
     * @return an unmodifiable list
     */
    List<V> getList();

    /**
     * Get the size
     * @return size
     */
    int size();
}
