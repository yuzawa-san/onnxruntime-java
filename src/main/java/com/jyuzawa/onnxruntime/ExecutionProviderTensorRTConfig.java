/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderTensorRTConfig extends ExecutionProviderObjectConfig {

    ExecutionProviderTensorRTConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected MemorySegment create(ApiImpl api, MemorySegment out) {
        return api.CreateTensorRTProviderOptions.apply(out);
    }

    @Override
    protected void release(ApiImpl api, MemorySegment config) {
        api.ReleaseTensorRTProviderOptions.apply(config);
    }

    @Override
    protected MemorySegment update(
            ApiImpl api, MemorySegment config, MemorySegment keys, MemorySegment values, int numProperties) {
        return api.UpdateTensorRTProviderOptions.apply(config, keys, values, numProperties);
    }

    @Override
    protected MemorySegment append(ApiImpl api, MemorySegment sessionOptions, MemorySegment config) {
        return api.SessionOptionsAppendExecutionProvider_TensorRT_V2.apply(sessionOptions, config);
    }
}
