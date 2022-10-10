/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public interface OrtCustomJoinThreadFn {

    void apply(java.lang.foreign.MemoryAddress ort_custom_thread_handle);

    static MemorySegment allocate(OrtCustomJoinThreadFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(
                OrtCustomJoinThreadFn.class, fi, constants$1.OrtCustomJoinThreadFn$FUNC, session);
    }

    static OrtCustomJoinThreadFn ofAddress(MemoryAddress addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
        return (java.lang.foreign.MemoryAddress _ort_custom_thread_handle) -> {
            try {
                constants$1.OrtCustomJoinThreadFn$MH.invokeExact(
                        (Addressable) symbol, (java.lang.foreign.Addressable) _ort_custom_thread_handle);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
