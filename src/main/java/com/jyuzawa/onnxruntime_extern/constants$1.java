/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

class constants$1 {

    static final FunctionDescriptor OrtCustomCreateThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle OrtCustomCreateThreadFn$MH =
            RuntimeHelper.downcallHandle(constants$1.OrtCustomCreateThreadFn$FUNC);
    static final FunctionDescriptor OrtCustomJoinThreadFn$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle OrtCustomJoinThreadFn$MH =
            RuntimeHelper.downcallHandle(constants$1.OrtCustomJoinThreadFn$FUNC);
    static final FunctionDescriptor RegisterCustomOpsFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsFn$MH =
            RuntimeHelper.downcallHandle(constants$1.RegisterCustomOpsFn$FUNC);
    static final FunctionDescriptor RunAsyncCallbackFn$FUNC = FunctionDescriptor.ofVoid(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
}
