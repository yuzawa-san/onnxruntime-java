/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.Map;

abstract class ExecutionProviderObjectAppender extends ExecutionProviderMapAppender {

    protected ExecutionProviderObjectAppender(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected final void appendToSessionOptions(
            MemorySession memorySession,
            ApiImpl api,
            MemoryAddress sessionOptions,
            MemoryAddress keys,
            MemoryAddress values,
            int numProperties) {
        MemoryAddress config = api.create(memorySession, out -> creator(api, out));
        memorySession.addCloseAction(() -> {
            release(api, config);
        });
        api.checkStatus(update(api, config, keys, values, numProperties));
        api.checkStatus(append(api, sessionOptions, config));
    }

    protected abstract Addressable creator(ApiImpl api, MemoryAddress out);

    protected abstract void release(ApiImpl api, MemoryAddress config);

    protected abstract Addressable update(
            ApiImpl api, MemoryAddress config, MemoryAddress keys, MemoryAddress values, int numProperties);

    protected abstract Addressable append(ApiImpl api, MemoryAddress sessionOptions, MemoryAddress config);
}
