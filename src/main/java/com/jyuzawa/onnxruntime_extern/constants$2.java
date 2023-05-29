/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

class constants$2 {

    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_MIGraphX$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_MIGraphX",
            constants$2.OrtSessionOptionsAppendExecutionProvider_MIGraphX$FUNC);
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_Dnnl$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_Dnnl$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_Dnnl",
            constants$2.OrtSessionOptionsAppendExecutionProvider_Dnnl$FUNC);
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CoreML$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_CoreML$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_CoreML",
            constants$2.OrtSessionOptionsAppendExecutionProvider_CoreML$FUNC);
    static final MemorySegment ORT_FILE$SEGMENT =
            RuntimeHelper.CONSTANT_ALLOCATOR.allocateUtf8String("/tmp/jextract$6461729276767156453.h");
}
