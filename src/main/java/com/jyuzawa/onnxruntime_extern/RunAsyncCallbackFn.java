/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public interface RunAsyncCallbackFn {

    void apply(
            java.lang.foreign.MemoryAddress user_data,
            java.lang.foreign.MemoryAddress outputs,
            long num_outputs,
            java.lang.foreign.MemoryAddress status);

    static MemorySegment allocate(RunAsyncCallbackFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(RunAsyncCallbackFn.class, fi, constants$1.RunAsyncCallbackFn$FUNC, session);
    }

    static RunAsyncCallbackFn ofAddress(MemoryAddress addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
        return (java.lang.foreign.MemoryAddress _user_data,
                java.lang.foreign.MemoryAddress _outputs,
                long _num_outputs,
                java.lang.foreign.MemoryAddress _status) -> {
            try {
                constants$2.RunAsyncCallbackFn$MH.invokeExact(
                        (Addressable) symbol,
                        (java.lang.foreign.Addressable) _user_data,
                        (java.lang.foreign.Addressable) _outputs,
                        _num_outputs,
                        (java.lang.foreign.Addressable) _status);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
