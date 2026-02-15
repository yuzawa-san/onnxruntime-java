/*
 * Copyright (c) 2026 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

interface OnnxRuntimeEnum {
    int getNumber();

    static final class NumberMap<T extends Enum<T> & OnnxRuntimeEnum> extends AbstractMap<Integer, T> {
        private final Object[] table;
        private final Set<Entry<Integer, T>> entrySet;

        public NumberMap(Class<T> clazz) {
            int maxNum = Stream.of(clazz.getEnumConstants())
                    .map(OnnxRuntimeEnum::getNumber)
                    .max(Integer::compare)
                    .get();
            this.table = new Object[maxNum + 1];
            Set<Entry<Integer, T>> entrySet = new LinkedHashSet<>();
            for (T value : clazz.getEnumConstants()) {
                int number = value.getNumber();
                table[number] = value;
                entrySet.add(Map.entry(number, value));
            }
            this.entrySet = Collections.unmodifiableSet(entrySet);
        }

        @Override
        public T get(Object key) {
            return getOrDefault(key, null);
        }

        @SuppressWarnings("unchecked")
        @Override
        public T getOrDefault(Object key, T defaultValue) {
            if (key instanceof Integer number && number >= 0 && number < table.length) {
                Object value = table[number];
                if (value != null) {
                    return (T) value;
                }
            }
            return defaultValue;
        }

        @Override
        public Set<Entry<Integer, T>> entrySet() {
            return entrySet;
        }
    }
}
