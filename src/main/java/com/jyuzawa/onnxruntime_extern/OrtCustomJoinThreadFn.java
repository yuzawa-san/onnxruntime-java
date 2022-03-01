/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import jdk.incubator.foreign.*;

public interface OrtCustomJoinThreadFn {

    void apply(jdk.incubator.foreign.MemoryAddress x0);

    static MemoryAddress allocate(OrtCustomJoinThreadFn fi) {
        return RuntimeHelper.upcallStub(
                OrtCustomJoinThreadFn.class,
                fi,
                constants$1.OrtCustomJoinThreadFn$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;)V");
    }

    static MemoryAddress allocate(OrtCustomJoinThreadFn fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(
                OrtCustomJoinThreadFn.class,
                fi,
                constants$1.OrtCustomJoinThreadFn$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;)V",
                scope);
    }

    static OrtCustomJoinThreadFn ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$1.OrtCustomJoinThreadFn$MH.invokeExact((Addressable) addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
