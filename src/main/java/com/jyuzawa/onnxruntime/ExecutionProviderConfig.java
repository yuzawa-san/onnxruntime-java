/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

abstract class ExecutionProviderConfig {

    protected static final String TRUE_VALUE = "1";

    protected final Map<String, String> properties;

    protected ExecutionProviderConfig(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public final String toString() {
        return properties.toString();
    }

    private Optional<String> get(String key) {
        return Optional.ofNullable(properties.get(key));
    }

    protected void copyInteger(String key, MemorySegment config, BiConsumer<MemorySegment, Integer> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, Integer.parseInt(val)));
    }

    protected void copyBoolean(String key, MemorySegment config, BiConsumer<MemorySegment, Boolean> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, TRUE_VALUE.equals(val) || Boolean.valueOf(val)));
    }

    protected void copyLong(String key, MemorySegment config, BiConsumer<MemorySegment, Long> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, Long.parseLong(val)));
    }

    protected void copyString(
            String key, MemorySegment config, Arena arena, BiConsumer<MemorySegment, MemorySegment> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, arena.allocateFrom(val)));
    }

    abstract void appendToSessionOptions(Arena arena, ApiImpl api, MemorySegment sessionOptions);
}
