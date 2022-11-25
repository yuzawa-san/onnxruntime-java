/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;

abstract class ExecutionProviderConfig {

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

    protected void copyByte(String key, MemorySegment config, BiConsumer<MemorySegment, Byte> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, Integer.valueOf(val).byteValue()));
    }

    protected void copyInteger(String key, MemorySegment config, BiConsumer<MemorySegment, Integer> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, Integer.parseInt(val)));
    }

    protected void copyLong(String key, MemorySegment config, BiConsumer<MemorySegment, Long> consumer) {
        get(key).ifPresent(val -> consumer.accept(config, Long.parseLong(val)));
    }

    protected void copyString(
            String key,
            MemorySegment config,
            SegmentAllocator allocator,
            BiConsumer<MemorySegment, MemoryAddress> consumer) {
        get(key).ifPresent(val ->
                consumer.accept(config, allocator.allocateUtf8String(val).address()));
    }

    abstract void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions);
}
