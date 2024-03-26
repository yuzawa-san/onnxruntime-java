/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$8 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$8() {}

    static final VarHandle const$0 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_fp16_enable"));
    static final VarHandle const$1 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_int8_enable"));
    static final VarHandle const$2 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_int8_calibration_table_name"));
    static final VarHandle const$3 = constants$6.const$5.varHandle(
            MemoryLayout.PathElement.groupElement("trt_int8_use_native_calibration_table"));
    static final VarHandle const$4 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_dla_enable"));
    static final VarHandle const$5 =
            constants$6.const$5.varHandle(MemoryLayout.PathElement.groupElement("trt_dla_core"));
}
