/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

import com.jyuzawa.onnxruntime_extern.OrtOpenVINOProviderOptions;

final class ExecutionProviderOpenVINOConfig extends ExecutionProviderConfig {

    protected ExecutionProviderOpenVINOConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    final void appendToSessionOptions(Arena memorySession, ApiImpl api, MemorySegment sessionOptions) {
        MemorySegment config = OrtOpenVINOProviderOptions.allocate(memorySession);
        copyString("device_type", config, memorySession, OrtOpenVINOProviderOptions::device_type$set);
        copyByte("enable_vpu_fast_compile", config, OrtOpenVINOProviderOptions::enable_vpu_fast_compile$set);
        copyString("device_id", config, memorySession, OrtOpenVINOProviderOptions::device_id$set);
        copyLong("num_of_threads", config, OrtOpenVINOProviderOptions::num_of_threads$set);
        copyString("cache_dir", config, memorySession, OrtOpenVINOProviderOptions::cache_dir$set);
        // TODO: context
        copyByte("enable_opencl_throttling", config, OrtOpenVINOProviderOptions::enable_opencl_throttling$set);
        copyByte("enable_dynamic_shapes", config, OrtOpenVINOProviderOptions::enable_dynamic_shapes$set);
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_OpenVINO.apply(sessionOptions, config));
    }
}
