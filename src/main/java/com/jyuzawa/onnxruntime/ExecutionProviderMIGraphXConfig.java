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
        copyInteger("device_id", config, OrtMIGraphXProviderOptions::device_id);
        copyInteger("migraphx_fp16_enable", config, OrtMIGraphXProviderOptions::migraphx_fp16_enable);
        copyInteger("migraphx_int8_enable", config, OrtMIGraphXProviderOptions::migraphx_int8_enable);
        copyInteger(
                "migraphx_use_native_calibration_table",
                config,
                OrtMIGraphXProviderOptions::migraphx_use_native_calibration_table);
        copyString(
                "migraphx_int8_calibration_table_name",
                config,
                memorySession,
                OrtMIGraphXProviderOptions::migraphx_int8_calibration_table_name);
        copyInteger("migraphx_save_compiled_model", config, OrtMIGraphXProviderOptions::migraphx_save_compiled_model);
        copyString(
                "migraphx_save_model_path",
                config,
                memorySession,
                OrtMIGraphXProviderOptions::migraphx_save_model_path);

        copyInteger("migraphx_load_compiled_model", config, OrtMIGraphXProviderOptions::migraphx_load_compiled_model);
        copyString(
                "migraphx_load_model_path",
                config,
                memorySession,
                OrtMIGraphXProviderOptions::migraphx_load_model_path);
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_MIGraphX.apply(sessionOptions, config));
    }
}
