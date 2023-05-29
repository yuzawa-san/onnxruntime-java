/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime_extern.onnxruntime_all_h;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.Map;

final class ExecutionProviderCoreMLConfig extends ExecutionProviderConfig {

    private static final String TRUE_VALUE = "1";

    protected ExecutionProviderCoreMLConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    final void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions) {
        int flags = 0;
        if (TRUE_VALUE.equals(properties.get("use_cpu_only"))) {
            flags |= onnxruntime_all_h.COREML_FLAG_USE_CPU_ONLY();
        }
        if (TRUE_VALUE.equals(properties.get("enable_on_subgraph"))) {
            flags |= onnxruntime_all_h.COREML_FLAG_ENABLE_ON_SUBGRAPH();
        }
        if (TRUE_VALUE.equals(properties.get("device_with_ane"))) {
            flags |= onnxruntime_all_h.COREML_FLAG_ONLY_ENABLE_DEVICE_WITH_ANE();
        }
        api.checkStatus(onnxruntime_all_h.OrtSessionOptionsAppendExecutionProvider_CoreML(sessionOptions, flags));
    }
}
