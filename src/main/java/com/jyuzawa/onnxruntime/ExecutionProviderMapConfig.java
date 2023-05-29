/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.Map;

abstract class ExecutionProviderMapConfig extends ExecutionProviderConfig {

    protected ExecutionProviderMapConfig(Map<String, String> properties) {
        super(properties);
    }

    protected abstract void appendToSessionOptions(
            MemorySession memorySession,
            ApiImpl api,
            MemoryAddress sessionOptions,
            MemoryAddress keys,
            MemoryAddress values,
            int numProperties);

    @Override
    final void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions) {
        int numProps = properties.size();
        MemorySegment keys = memorySession.allocateArray(C_POINTER, numProps);
        MemorySegment values = memorySession.allocateArray(C_POINTER, numProps);
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            keys.setAtIndex(C_POINTER, i, memorySession.allocateUtf8String(entry.getKey()));
            values.setAtIndex(C_POINTER, i, memorySession.allocateUtf8String(entry.getValue()));
            i++;
        }
        appendToSessionOptions(memorySession, api, sessionOptions, keys.address(), values.address(), numProps);
    }
}
