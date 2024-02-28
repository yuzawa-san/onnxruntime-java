/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$10 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$10() {}

    static final StructLayout const$0 = MemoryLayout.structLayout(
                    JAVA_INT.withName("device_id"),
                    JAVA_INT.withName("migraphx_fp16_enable"),
                    JAVA_INT.withName("migraphx_int8_enable"),
                    JAVA_INT.withName("migraphx_use_native_calibration_table"),
                    RuntimeHelper.POINTER.withName("migraphx_int8_calibration_table_name"))
            .withName("OrtMIGraphXProviderOptions");
    static final VarHandle const$1 = constants$10.const$0.varHandle(MemoryLayout.PathElement.groupElement("device_id"));
    static final VarHandle const$2 =
            constants$10.const$0.varHandle(MemoryLayout.PathElement.groupElement("migraphx_fp16_enable"));
    static final VarHandle const$3 =
            constants$10.const$0.varHandle(MemoryLayout.PathElement.groupElement("migraphx_int8_enable"));
    static final VarHandle const$4 = constants$10.const$0.varHandle(
            MemoryLayout.PathElement.groupElement("migraphx_use_native_calibration_table"));
    static final VarHandle const$5 = constants$10.const$0.varHandle(
            MemoryLayout.PathElement.groupElement("migraphx_int8_calibration_table_name"));
}
