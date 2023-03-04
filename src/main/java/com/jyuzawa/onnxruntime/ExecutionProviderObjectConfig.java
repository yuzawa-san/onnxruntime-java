/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

abstract class ExecutionProviderObjectConfig extends ExecutionProviderMapConfig {

    protected ExecutionProviderObjectConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected final void appendToSessionOptions(
            Arena memorySession,
            ApiImpl api,
            MemorySegment sessionOptions,
            MemorySegment keys,
            MemorySegment values,
            int numProperties) {
        MemorySegment config = api.create(memorySession, out -> create(api, out));
        memorySession.addCloseAction(() -> {
            release(api, config);
        });
        api.checkStatus(update(api, config, keys, values, numProperties));
        api.checkStatus(append(api, sessionOptions, config));
    }

    protected abstract MemorySegment create(ApiImpl api, MemorySegment out);

    protected abstract void release(ApiImpl api, MemorySegment config);

    protected abstract MemorySegment update(
            ApiImpl api, MemorySegment config, MemorySegment keys, MemorySegment values, int numProperties);

    protected abstract MemorySegment append(ApiImpl api, MemorySegment sessionOptions, MemorySegment config);
}
