/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderCPUConfig extends ExecutionProviderConfig {

    private static final String USE_ARENA = "use_arena";

    protected ExecutionProviderCPUConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    void appendToSessionOptions(Arena arena, ApiImpl api, MemorySegment sessionOptions) {
        // default is true
        // https://github.com/microsoft/onnxruntime/blob/fb85b31facb9fb3fc99c76f99c93ea8f06ada39b/onnxruntime/core/providers/cpu/cpu_execution_provider.h#L14
        String useArena = properties.getOrDefault(USE_ARENA, "1");
        if ("1".equals(useArena) || "true".equals(useArena)) {
            api.checkStatus(api.EnableCpuMemArena.apply(sessionOptions));
        } else {
            api.checkStatus(api.DisableCpuMemArena.apply(sessionOptions));
        }
    }
}
