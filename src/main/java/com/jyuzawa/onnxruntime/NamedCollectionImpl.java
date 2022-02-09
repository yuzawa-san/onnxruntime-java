/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class NamedCollectionImpl<V> implements NamedCollection<V> {

    private final Map<String, V> map;
    private final List<V> list;

    NamedCollectionImpl(LinkedHashMap<String, V> map) {
        this.map = Collections.unmodifiableMap(map);
        List<V> rawList = new ArrayList<>(map.size());
        rawList.addAll(map.values());
        this.list = Collections.unmodifiableList(rawList);
    }

    @Override
    public V get(String name) {
        return map.get(name);
    }

    @Override
    public V get(int index) {
        return list.get(index);
    }

    @Override
    public Map<String, V> map() {
        return map;
    }

    @Override
    public List<V> list() {
        return list;
    }

    public String toString() {
        return map.toString();
    }
}
