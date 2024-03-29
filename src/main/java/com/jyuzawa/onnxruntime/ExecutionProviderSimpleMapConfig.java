/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
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
            MemorySession memorySession,
            ApiImpl api,
            MemoryAddress sessionOptions,
            MemoryAddress keys,
            MemoryAddress values,
            int numProperties) {
        api.checkStatus(api.SessionOptionsAppendExecutionProvider.apply(
                sessionOptions, memorySession.allocateUtf8String(name).address(), keys, values, numProperties));
    }
}
