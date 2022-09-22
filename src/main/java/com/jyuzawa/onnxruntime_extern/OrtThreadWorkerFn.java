/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public interface OrtThreadWorkerFn {

    void apply(java.lang.foreign.MemoryAddress ort_worker_fn_param);

    static MemorySegment allocate(OrtThreadWorkerFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(OrtThreadWorkerFn.class, fi, constants$0.OrtThreadWorkerFn$FUNC, session);
    }

    static OrtThreadWorkerFn ofAddress(MemoryAddress addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
        return (java.lang.foreign.MemoryAddress _ort_worker_fn_param) -> {
            try {
                constants$0.OrtThreadWorkerFn$MH.invokeExact(
                        (Addressable) symbol, (java.lang.foreign.Addressable) _ort_worker_fn_param);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
