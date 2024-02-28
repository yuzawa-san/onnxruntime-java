/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

final class constants$15 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$15() {}

    static final FunctionDescriptor const$0 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomCreateThreadFn.class, "apply", constants$15.const$0);
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(constants$15.const$0);
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomJoinThreadFn.class, "apply", constants$14.const$1);
    static final FunctionDescriptor const$4 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(RegisterCustomOpsFn.class, "apply", constants$15.const$4);
}
