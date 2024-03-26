/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$7 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$7() {}

    static final VarHandle const$0 = constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("device_id"));
    static final VarHandle const$1 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("has_user_compute_stream"));
    static final VarHandle const$2 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("user_compute_stream"));
    static final VarHandle const$3 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_max_partition_iterations"));
    static final VarHandle const$4 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_min_subgraph_size"));
    static final VarHandle const$5 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_max_workspace_size"));
}
