/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderSimpleMapConfig extends ExecutionProviderMapConfig {

    private final String name;

    private ExecutionProviderSimpleMapConfig(Map<String, String> properties, String name) {
        super(properties);
        this.name = name;
    }

    static final ExecutionProviderConfigFactory of(String name) {
        return properties -> new ExecutionProviderSimpleMapConfig(properties, name);
    }

    @Override
    protected void appendToSessionOptions(
Arena memorySession,
            ApiImpl api,
            MemorySegment sessionOptions,
            MemorySegment keys,
            MemorySegment values,
            int numProperties) {
        api.checkStatus(api.SessionOptionsAppendExecutionProvider.apply(
                sessionOptions, memorySession.allocateUtf8String(name), keys, values, numProperties));
    }
}
