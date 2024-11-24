/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

abstract class ExecutionProviderMapConfig extends ExecutionProviderConfig {

    protected ExecutionProviderMapConfig(Map<String, String> properties) {
        super(properties);
    }

    protected abstract void appendToSessionOptions(
            Arena arena,
            ApiImpl api,
            MemorySegment sessionOptions,
            MemorySegment keys,
            MemorySegment values,
            int numProperties);

    @Override
    final void appendToSessionOptions(Arena arena, ApiImpl api, MemorySegment sessionOptions) {
        int numProps = properties.size();
        MemorySegment keys = arena.allocate(C_POINTER, numProps);
        MemorySegment values = arena.allocate(C_POINTER, numProps);
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            keys.setAtIndex(C_POINTER, i, arena.allocateFrom(entry.getKey()));
            values.setAtIndex(C_POINTER, i, arena.allocateFrom(entry.getValue()));
            i++;
        }
        appendToSessionOptions(arena, api, sessionOptions, keys, values, numProps);
    }
}
