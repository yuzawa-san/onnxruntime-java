/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$9 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$9() {}

    static final VarHandle const$0 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_dump_subgraphs"));
    static final VarHandle const$1 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_cache_enable"));
    static final VarHandle const$2 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_cache_path"));
    static final VarHandle const$3 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_decryption_enable"));
    static final VarHandle const$4 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_decryption_lib_path"));
    static final VarHandle const$5 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_force_sequential_engine_build"));
}
