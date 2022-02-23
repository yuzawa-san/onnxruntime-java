/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import jdk.incubator.foreign.*;

public interface OrtThreadWorkerFn {

    void apply(jdk.incubator.foreign.MemoryAddress x0);

    static MemoryAddress allocate(OrtThreadWorkerFn fi) {
        return RuntimeHelper.upcallStub(
                OrtThreadWorkerFn.class,
                fi,
                constants$0.OrtThreadWorkerFn$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;)V");
    }

    static MemoryAddress allocate(OrtThreadWorkerFn fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(
                OrtThreadWorkerFn.class,
                fi,
                constants$0.OrtThreadWorkerFn$FUNC,
                "(Ljdk/incubator/foreign/MemoryAddress;)V",
                scope);
    }

    static OrtThreadWorkerFn ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$0.OrtThreadWorkerFn$MH.invokeExact((Addressable) addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
