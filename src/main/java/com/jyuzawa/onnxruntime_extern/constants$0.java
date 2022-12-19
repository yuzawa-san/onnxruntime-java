/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

final class constants$0 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$0() {}

    static final FunctionDescriptor OrtLoggingFunction$FUNC = FunctionDescriptor.ofVoid(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle OrtLoggingFunction$MH = RuntimeHelper.downcallHandle(constants$0.OrtLoggingFunction$FUNC);
    static final FunctionDescriptor OrtGetApiBase$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle OrtGetApiBase$MH =
            RuntimeHelper.downcallHandle("OrtGetApiBase", constants$0.OrtGetApiBase$FUNC);
    static final FunctionDescriptor OrtThreadWorkerFn$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle OrtThreadWorkerFn$MH = RuntimeHelper.downcallHandle(constants$0.OrtThreadWorkerFn$FUNC);
    static final FunctionDescriptor OrtCustomCreateThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
}
