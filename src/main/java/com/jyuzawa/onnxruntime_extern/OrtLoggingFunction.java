/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public interface OrtLoggingFunction {

    void apply(
            java.lang.foreign.MemoryAddress param,
            int severity,
            java.lang.foreign.MemoryAddress category,
            java.lang.foreign.MemoryAddress logid,
            java.lang.foreign.MemoryAddress code_location,
            java.lang.foreign.MemoryAddress message);

    static MemorySegment allocate(OrtLoggingFunction fi, MemorySession session) {
        return RuntimeHelper.upcallStub(OrtLoggingFunction.class, fi, constants$0.OrtLoggingFunction$FUNC, session);
    }

    static OrtLoggingFunction ofAddress(MemoryAddress addr, MemorySession session) {
        MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
        return (java.lang.foreign.MemoryAddress _param,
                int _severity,
                java.lang.foreign.MemoryAddress _category,
                java.lang.foreign.MemoryAddress _logid,
                java.lang.foreign.MemoryAddress _code_location,
                java.lang.foreign.MemoryAddress _message) -> {
            try {
                constants$0.OrtLoggingFunction$MH.invokeExact(
                        (Addressable) symbol,
                        (java.lang.foreign.Addressable) _param,
                        _severity,
                        (java.lang.foreign.Addressable) _category,
                        (java.lang.foreign.Addressable) _logid,
                        (java.lang.foreign.Addressable) _code_location,
                        (java.lang.foreign.Addressable) _message);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
