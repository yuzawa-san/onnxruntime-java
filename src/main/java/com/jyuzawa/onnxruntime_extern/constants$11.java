/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$11 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$11() {}

    static final VarHandle const$0 =
            constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("enable_vpu_fast_compile"));
    static final VarHandle const$1 = constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("device_id"));
    static final VarHandle const$2 =
            constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("num_of_threads"));
    static final VarHandle const$3 = constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("cache_dir"));
    static final VarHandle const$4 = constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("context"));
    static final VarHandle const$5 =
            constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("enable_opencl_throttling"));
}
