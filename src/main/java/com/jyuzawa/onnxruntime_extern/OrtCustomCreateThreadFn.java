/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public interface OrtCustomCreateThreadFn {

    java.lang.foreign.Addressable apply(
            java.lang.foreign.MemoryAddress ort_custom_thread_creation_options,
            java.lang.foreign.MemoryAddress ort_thread_worker_fn,
            java.lang.foreign.MemoryAddress ort_worker_fn_param);

    static MemorySegment allocate(OrtCustomCreateThreadFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(
                OrtCustomCreateThreadFn.class, fi, constants$0.OrtCustomCreateThreadFn$FUNC, session);
    }

    static OrtCustomCreateThreadFn ofAddress(MemoryAddress addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
        return (java.lang.foreign.MemoryAddress _ort_custom_thread_creation_options,
                java.lang.foreign.MemoryAddress _ort_thread_worker_fn,
                java.lang.foreign.MemoryAddress _ort_worker_fn_param) -> {
            try {
                return (java.lang.foreign.Addressable)
                        (java.lang.foreign.MemoryAddress) constants$1.OrtCustomCreateThreadFn$MH.invokeExact(
                                (Addressable) symbol,
                                (java.lang.foreign.Addressable) _ort_custom_thread_creation_options,
                                (java.lang.foreign.Addressable) _ort_thread_worker_fn,
                                (java.lang.foreign.Addressable) _ort_worker_fn_param);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
