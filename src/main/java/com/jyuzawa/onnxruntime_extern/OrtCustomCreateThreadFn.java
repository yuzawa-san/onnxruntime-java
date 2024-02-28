/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
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

    static MemorySegment allocate(OrtCustomCreateThreadFn fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$15.const$1, fi, constants$15.const$0, scope);
    }

    static OrtCustomCreateThreadFn ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
            try {
                return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(
                        symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
