/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderDnnlConfig extends ExecutionProviderObjectConfig {

    ExecutionProviderDnnlConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected MemorySegment create(ApiImpl api, MemorySegment out) {
        return api.CreateDnnlProviderOptions.apply(out);
    }

    @Override
    protected void release(ApiImpl api, MemorySegment config) {
        api.ReleaseDnnlProviderOptions.apply(config);
    }

    @Override
    protected MemorySegment update(
            ApiImpl api, MemorySegment config, MemorySegment keys, MemorySegment values, int numProperties) {
        return api.UpdateDnnlProviderOptions.apply(config, keys, values, numProperties);
    }

    @Override
    protected MemorySegment append(ApiImpl api, MemorySegment sessionOptions, MemorySegment config) {
        return api.SessionOptionsAppendExecutionProvider_Dnnl.apply(sessionOptions, config);
    }
}
