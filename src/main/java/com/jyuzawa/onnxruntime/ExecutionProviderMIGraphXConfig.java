/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime_extern.OrtMIGraphXProviderOptions;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderMIGraphXConfig extends ExecutionProviderConfig {

    protected ExecutionProviderMIGraphXConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    final void appendToSessionOptions(Arena memorySession, ApiImpl api, MemorySegment sessionOptions) {
        MemorySegment config = OrtMIGraphXProviderOptions.allocate(memorySession);
        copyInteger("device_id", config, OrtMIGraphXProviderOptions::device_id$set);
        copyInteger("migraphx_fp16_enable", config, OrtMIGraphXProviderOptions::migraphx_fp16_enable$set);
        copyInteger("migraphx_int8_enable", config, OrtMIGraphXProviderOptions::migraphx_int8_enable$set);
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_MIGraphX.apply(sessionOptions, config));
    }
}
