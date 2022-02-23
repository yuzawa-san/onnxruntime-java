/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import jdk.incubator.foreign.*;

public interface OrtLoggingFunction {

    void apply(
            jdk.incubator.foreign.MemoryAddress x0,
            int x1,
            jdk.incubator.foreign.MemoryAddress x2,
            jdk.incubator.foreign.MemoryAddress x3,
            jdk.incubator.foreign.MemoryAddress x4,
            jdk.incubator.foreign.MemoryAddress x5);

    static MemoryAddress allocate(OrtLoggingFunction fi) {
        return RuntimeHelper.upcallStub(
                OrtLoggingFunction.class,
                fi,
                constants$0.OrtLoggingFunction$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
    }

    static MemoryAddress allocate(OrtLoggingFunction fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(
                OrtLoggingFunction.class,
                fi,
                constants$0.OrtLoggingFunction$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
                scope);
    }

    static OrtLoggingFunction ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0,
                int x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4,
                jdk.incubator.foreign.MemoryAddress x5) -> {
            try {
                constants$0.OrtLoggingFunction$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4, x5);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
