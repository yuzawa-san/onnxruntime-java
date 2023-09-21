/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

/**
 * {@snippet :
 * void (*RunAsyncCallbackFn)(void* user_data,struct OrtValue** outputs,unsigned long num_outputs,struct OrtStatus* status);
 * }
 */
public interface RunAsyncCallbackFn {

    void apply(
            java.lang.foreign.MemorySegment user_data,
            java.lang.foreign.MemorySegment outputs,
            long num_outputs,
            java.lang.foreign.MemorySegment status);

    static MemorySegment allocate(RunAsyncCallbackFn fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$16.const$0, fi, constants$15.const$5, scope);
    }

    static RunAsyncCallbackFn ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _user_data,
                java.lang.foreign.MemorySegment _outputs,
                long _num_outputs,
                java.lang.foreign.MemorySegment _status) -> {
            try {
                constants$16.const$1.invokeExact(symbol, _user_data, _outputs, _num_outputs, _status);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
