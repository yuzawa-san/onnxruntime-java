/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public interface RegisterCustomOpsFn {

    java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress options, java.lang.foreign.MemoryAddress api);

    static MemorySegment allocate(RegisterCustomOpsFn fi, MemorySession session) {
        return RuntimeHelper.upcallStub(RegisterCustomOpsFn.class, fi, constants$1.RegisterCustomOpsFn$FUNC, session);
    }

    static RegisterCustomOpsFn ofAddress(MemoryAddress addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
        return (java.lang.foreign.MemoryAddress _options, java.lang.foreign.MemoryAddress _api) -> {
            try {
                return (java.lang.foreign.Addressable)
                        (java.lang.foreign.MemoryAddress) constants$1.RegisterCustomOpsFn$MH.invokeExact(
                                (Addressable) symbol,
                                (java.lang.foreign.Addressable) _options,
                                (java.lang.foreign.Addressable) _api);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
