/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.util.Map;

final class ExecutionProviderCUDA extends ExecutionProviderObjectAppender {

    ExecutionProviderCUDA(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected Addressable creator(ApiImpl api, MemoryAddress out) {
        return api.CreateCUDAProviderOptions.apply(out);
    }

    @Override
    protected void release(ApiImpl api, MemoryAddress config) {
        api.ReleaseCUDAProviderOptions.apply(config);
    }

    @Override
    protected Addressable update(
            ApiImpl api, MemoryAddress config, MemoryAddress keys, MemoryAddress values, int numProperties) {
        return api.UpdateCUDAProviderOptions.apply(config, keys, values, numProperties);
    }

    @Override
    protected Addressable append(ApiImpl api, MemoryAddress sessionOptions, MemoryAddress config) {
        return api.SessionOptionsAppendExecutionProvider_CUDA_V2.apply(sessionOptions, config);
    }
}
