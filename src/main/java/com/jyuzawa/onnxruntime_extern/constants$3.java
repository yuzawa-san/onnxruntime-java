/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$3 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$3() {}

    static final VarHandle const$0 = constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("device_id"));
    static final VarHandle const$1 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("cudnn_conv_algo_search"));
    static final VarHandle const$2 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("gpu_mem_limit"));
    static final VarHandle const$3 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("arena_extend_strategy"));
    static final VarHandle const$4 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("do_copy_in_default_stream"));
    static final VarHandle const$5 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("has_user_compute_stream"));
}
