/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
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

    static MemorySegment allocate(OrtCustomJoinThreadFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(
                OrtCustomJoinThreadFn.class, fi, constants$1.OrtCustomJoinThreadFn$FUNC, session);
    }

    static OrtCustomJoinThreadFn ofAddress(MemorySegment addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, session);
        return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
            try {
                constants$1.OrtCustomJoinThreadFn$MH.invokeExact(symbol, _ort_custom_thread_handle);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
