/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

/**
 * {@snippet :
 * struct OrtCustomHandleType* (*OrtCustomCreateThreadFn)(void* ort_custom_thread_creation_options,void (*ort_thread_worker_fn)(void*),void* ort_worker_fn_param);
 * }
 */
public interface OrtCustomCreateThreadFn {

    java.lang.foreign.MemorySegment apply(
            java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
            java.lang.foreign.MemorySegment ort_thread_worker_fn,
            java.lang.foreign.MemorySegment ort_worker_fn_param);

    static MemorySegment allocate(OrtCustomCreateThreadFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(
                OrtCustomCreateThreadFn.class, fi, constants$0.OrtCustomCreateThreadFn$FUNC, session);
    }

    static OrtCustomCreateThreadFn ofAddress(MemorySegment addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, session);
        return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
            try {
                return (java.lang.foreign.MemorySegment) constants$1.OrtCustomCreateThreadFn$MH.invokeExact(
                        symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
