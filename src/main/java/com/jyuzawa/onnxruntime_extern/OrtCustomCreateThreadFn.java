/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import jdk.incubator.foreign.*;

public interface OrtCustomCreateThreadFn {

    jdk.incubator.foreign.MemoryAddress apply(
            jdk.incubator.foreign.MemoryAddress x0,
            jdk.incubator.foreign.MemoryAddress x1,
            jdk.incubator.foreign.MemoryAddress x2);

    static MemoryAddress allocate(OrtCustomCreateThreadFn fi) {
        return RuntimeHelper.upcallStub(
                OrtCustomCreateThreadFn.class,
                fi,
                constants$0.OrtCustomCreateThreadFn$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
    }

    static MemoryAddress allocate(OrtCustomCreateThreadFn fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(
                OrtCustomCreateThreadFn.class,
                fi,
                constants$0.OrtCustomCreateThreadFn$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                scope);
    }

    static OrtCustomCreateThreadFn ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                return (jdk.incubator.foreign.MemoryAddress)
                        constants$1.OrtCustomCreateThreadFn$MH.invokeExact((Addressable) addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
