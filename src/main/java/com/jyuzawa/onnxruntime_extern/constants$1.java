/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.MethodHandle;
import jdk.incubator.foreign.*;

class constants$1 {

    static final FunctionDescriptor OrtCustomCreateThreadFn$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle OrtCustomCreateThreadFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            constants$1.OrtCustomCreateThreadFn$FUNC,
            false);
    static final FunctionDescriptor OrtCustomJoinThreadFn$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle OrtCustomJoinThreadFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", constants$1.OrtCustomJoinThreadFn$FUNC, false);
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CUDA$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$MH = RuntimeHelper.downcallHandle(
            onnxruntime_all_h.LIBRARIES,
            "OrtSessionOptionsAppendExecutionProvider_CUDA",
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            constants$1.OrtSessionOptionsAppendExecutionProvider_CUDA$FUNC,
            false);
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_Tensorrt$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_Tensorrt$MH = RuntimeHelper.downcallHandle(
            onnxruntime_all_h.LIBRARIES,
            "OrtSessionOptionsAppendExecutionProvider_Tensorrt",
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            constants$1.OrtSessionOptionsAppendExecutionProvider_Tensorrt$FUNC,
            false);
}
