/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_c_api_h.C_POINTER;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

abstract class ExecutionProviderMapConfig extends ExecutionProviderConfig {

    protected ExecutionProviderMapConfig(Map<String, String> properties) {
        super(properties);
    }

    protected abstract void appendToSessionOptions(
            Arena memorySession,
            ApiImpl api,
            MemorySegment sessionOptions,
            MemorySegment keys,
            MemorySegment values,
            int numProperties);

    @Override
    final void appendToSessionOptions(Arena memorySession, ApiImpl api, MemorySegment sessionOptions) {
        int numProps = properties.size();
        MemorySegment keys = memorySession.allocateArray(C_POINTER, numProps);
        MemorySegment values = memorySession.allocateArray(C_POINTER, numProps);
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            keys.setAtIndex(C_POINTER, i, memorySession.allocateUtf8String(entry.getKey()));
            values.setAtIndex(C_POINTER, i, memorySession.allocateUtf8String(entry.getValue()));
            i++;
        }
        appendToSessionOptions(memorySession, api, sessionOptions, keys, values, numProps);
    }
}
