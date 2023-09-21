/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

/**
 * {@snippet :
 * struct OrtStatus* (*RegisterCustomOpsFn)(struct OrtSessionOptions* options,struct OrtApiBase* api);
 * }
 */
public interface RegisterCustomOpsFn {

    java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

    static MemorySegment allocate(RegisterCustomOpsFn fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$15.const$3, fi, constants$15.const$2, scope);
    }

    static RegisterCustomOpsFn ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
            try {
                return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
