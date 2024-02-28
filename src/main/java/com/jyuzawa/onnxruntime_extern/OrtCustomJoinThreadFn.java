/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

/**
 * {@snippet :
 * void (*OrtCustomJoinThreadFn)(struct OrtCustomHandleType* ort_custom_thread_handle);
 * }
 */
public interface OrtCustomJoinThreadFn {

    void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

    static MemorySegment allocate(OrtCustomJoinThreadFn fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$15.const$3, fi, constants$14.const$1, scope);
    }

    static OrtCustomJoinThreadFn ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
            try {
                constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
