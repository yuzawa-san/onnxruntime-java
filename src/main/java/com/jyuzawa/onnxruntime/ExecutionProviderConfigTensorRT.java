/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.util.Map;

final class ExecutionProviderConfigTensorRT extends ExecutionProviderObjectConfig {

    ExecutionProviderConfigTensorRT(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected Addressable create(ApiImpl api, MemoryAddress out) {
        return api.CreateTensorRTProviderOptions.apply(out);
    }

    @Override
    protected void release(ApiImpl api, MemoryAddress config) {
        api.ReleaseTensorRTProviderOptions.apply(config);
    }

    @Override
    protected Addressable update(
            ApiImpl api, MemoryAddress config, MemoryAddress keys, MemoryAddress values, int numProperties) {
        return api.UpdateTensorRTProviderOptions.apply(config, keys, values, numProperties);
    }

    @Override
    protected Addressable append(ApiImpl api, MemoryAddress sessionOptions, MemoryAddress config) {
        return api.SessionOptionsAppendExecutionProvider_TensorRT_V2.apply(sessionOptions, config);
    }
}
