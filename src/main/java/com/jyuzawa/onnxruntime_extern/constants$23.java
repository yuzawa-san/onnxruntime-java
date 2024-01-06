/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$23 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$23() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CloneSessionOptions"));
    static final FunctionDescriptor const$1 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.SetSessionExecutionMode.class, "apply", constants$23.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$23.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetSessionExecutionMode"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.EnableProfiling.class, "apply", constants$15.const$2);
}
