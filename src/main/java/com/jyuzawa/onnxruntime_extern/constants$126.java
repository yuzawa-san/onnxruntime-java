/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

final class constants$126 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$126() {}

    static final MethodHandle const$0 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_ROCM", constants$23.const$1);
    static final MethodHandle const$1 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_MIGraphX", constants$23.const$1);
    static final MethodHandle const$2 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_Dnnl", constants$23.const$1);
    static final MethodHandle const$3 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_CoreML", constants$23.const$1);
    static final MemorySegment const$4 = RuntimeHelper.CONSTANT_ALLOCATOR.allocateFrom(
            "/var/folders/_0/vb3rmc0x05xfzm34qqcsmqk40000gn/T/jextract$1833926473484646174.h");
}
