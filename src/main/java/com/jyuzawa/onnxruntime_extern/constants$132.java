/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

final class constants$132 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$132() {}

    static final MethodHandle const$0 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_Dnnl", constants$23.const$3);
    static final MethodHandle const$1 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_Tensorrt", constants$23.const$3);
    static final MethodHandle const$2 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_CoreML", constants$23.const$3);
    static final MemorySegment const$3 =
            RuntimeHelper.CONSTANT_ALLOCATOR.allocateFrom("/tmp/jextract$10412803484612329544.h");
}
