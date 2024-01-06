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

    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(constants$14.const$4);
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomJoinThreadFn.class, "apply", constants$13.const$5);
    static final FunctionDescriptor const$2 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(RegisterCustomOpsFn.class, "apply", constants$15.const$2);
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(constants$15.const$2);
    static final FunctionDescriptor const$5 =
            FunctionDescriptor.ofVoid(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG, RuntimeHelper.POINTER);
}
