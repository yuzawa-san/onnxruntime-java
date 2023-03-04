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

    static MemorySegment allocate(RegisterCustomOpsFn fi, SegmentScope scope) {
        return RuntimeHelper.upcallStub(RegisterCustomOpsFn.class, fi, constants$1.RegisterCustomOpsFn$FUNC, scope);
    }

    static RegisterCustomOpsFn ofAddress(MemorySegment addr, SegmentScope scope) {
        MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
        return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
            try {
                return (java.lang.foreign.MemorySegment)
                        constants$1.RegisterCustomOpsFn$MH.invokeExact(symbol, _options, _api);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
