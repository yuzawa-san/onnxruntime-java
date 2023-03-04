/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

/**
 * {@snippet :
 * void (*OrtThreadWorkerFn)(void* ort_worker_fn_param);
 * }
 */
public interface OrtThreadWorkerFn {

    void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

    static MemorySegment allocate(OrtThreadWorkerFn fi, SegmentScope scope) {
        return RuntimeHelper.upcallStub(OrtThreadWorkerFn.class, fi, constants$0.OrtThreadWorkerFn$FUNC, scope);
    }

    static OrtThreadWorkerFn ofAddress(MemorySegment addr, SegmentScope scope) {
        MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
        return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
            try {
                constants$0.OrtThreadWorkerFn$MH.invokeExact(symbol, _ort_custom_thread_handle);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
