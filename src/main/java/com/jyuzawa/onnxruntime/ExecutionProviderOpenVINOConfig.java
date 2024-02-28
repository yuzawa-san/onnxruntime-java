/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime_extern.OrtOpenVINOProviderOptions;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderOpenVINOConfig extends ExecutionProviderMapConfig {

    protected ExecutionProviderOpenVINOConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected void appendToSessionOptions(
            MemorySession memorySession,
            ApiImpl api,
            MemoryAddress sessionOptions,
            MemoryAddress keys,
            MemoryAddress values,
            int numProperties) {
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_OpenVINO_V2.apply(
                sessionOptions, keys, values, numProperties));
    }
}
