/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

class constants$3 {

    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CoreML$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_CoreML$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_CoreML",
            constants$3.OrtSessionOptionsAppendExecutionProvider_CoreML$FUNC);
    static final MemorySegment ORT_FILE$SEGMENT =
            RuntimeHelper.CONSTANT_ALLOCATOR.allocateUtf8String("/tmp/jextract$8269144415710592828.h");
}
