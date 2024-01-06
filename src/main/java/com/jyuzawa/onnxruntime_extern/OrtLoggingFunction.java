/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

/**
 * {@snippet :
 * void (*OrtLoggingFunction)(void* param,enum OrtLoggingLevel severity,char* category,char* logid,char* code_location,char* message);
 * }
 */
public interface OrtLoggingFunction {

    void apply(
            java.lang.foreign.MemorySegment param,
            int severity,
            java.lang.foreign.MemorySegment category,
            java.lang.foreign.MemorySegment logid,
            java.lang.foreign.MemorySegment code_location,
            java.lang.foreign.MemorySegment message);

    static MemorySegment allocate(OrtLoggingFunction fi, Arena scope) {
        return RuntimeHelper.upcallStub(constants$2.const$3, fi, constants$2.const$2, scope);
    }

    static OrtLoggingFunction ofAddress(MemorySegment addr, Arena arena) {
        MemorySegment symbol = addr.reinterpret(arena, null);
        return (java.lang.foreign.MemorySegment _param,
                int _severity,
                java.lang.foreign.MemorySegment _category,
                java.lang.foreign.MemorySegment _logid,
                java.lang.foreign.MemorySegment _code_location,
                java.lang.foreign.MemorySegment _message) -> {
            try {
                constants$2.const$4.invokeExact(symbol, _param, _severity, _category, _logid, _code_location, _message);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}
