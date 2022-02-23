/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.MethodHandle;
import jdk.incubator.foreign.*;

class constants$0 {

    static final FunctionDescriptor OrtLoggingFunction$FUNC =
            FunctionDescriptor.ofVoid(C_POINTER, C_INT, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle OrtLoggingFunction$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
            constants$0.OrtLoggingFunction$FUNC,
            false);
    static final FunctionDescriptor OrtGetApiBase$FUNC = FunctionDescriptor.of(C_POINTER);
    static final MethodHandle OrtGetApiBase$MH = RuntimeHelper.downcallHandle(
            onnxruntime_all_h.LIBRARIES,
            "OrtGetApiBase",
            "()Ljdk/incubator/foreign/MemoryAddress;",
            constants$0.OrtGetApiBase$FUNC,
            false);
    static final FunctionDescriptor OrtThreadWorkerFn$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle OrtThreadWorkerFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", constants$0.OrtThreadWorkerFn$FUNC, false);
    static final FunctionDescriptor OrtCustomCreateThreadFn$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
}
