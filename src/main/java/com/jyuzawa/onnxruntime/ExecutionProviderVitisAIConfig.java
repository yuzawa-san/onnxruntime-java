/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderVitisAIConfig extends ExecutionProviderMapConfig {

    protected ExecutionProviderVitisAIConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    protected void appendToSessionOptions(
            Arena arena,
            ApiImpl api,
            MemorySegment sessionOptions,
            MemorySegment keys,
            MemorySegment values,
            int numProperties) {
        api.checkStatus(
                api.SessionOptionsAppendExecutionProvider_VitisAI.apply(sessionOptions, keys, values, numProperties));
    }
}
