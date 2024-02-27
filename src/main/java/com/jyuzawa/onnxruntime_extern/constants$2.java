/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

class constants$2 {

    static final FunctionDescriptor RunAsyncCallbackFn$FUNC = FunctionDescriptor.ofVoid(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunAsyncCallbackFn$MH = RuntimeHelper.downcallHandle(constants$2.RunAsyncCallbackFn$FUNC);
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CUDA$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_CUDA",
            constants$2.OrtSessionOptionsAppendExecutionProvider_CUDA$FUNC);
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_ROCM$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_ROCM$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_ROCM",
            constants$2.OrtSessionOptionsAppendExecutionProvider_ROCM$FUNC);
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
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_Tensorrt$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_Tensorrt$MH = RuntimeHelper.downcallHandle(
            "OrtSessionOptionsAppendExecutionProvider_Tensorrt",
            constants$2.OrtSessionOptionsAppendExecutionProvider_Tensorrt$FUNC);
}
