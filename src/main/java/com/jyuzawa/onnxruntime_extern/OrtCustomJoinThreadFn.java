/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.MemoryLayout.PathElement.*;
import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * {@snippet lang=c :
 * typedef void (*OrtCustomJoinThreadFn)(OrtCustomThreadHandle)
 * }
 */
public class OrtCustomJoinThreadFn {

    OrtCustomJoinThreadFn() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        void apply(MemorySegment ort_custom_thread_handle);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER);

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH =
            onnxruntime_all_h.upcallHandle(OrtCustomJoinThreadFn.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(OrtCustomJoinThreadFn.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static void invoke(MemorySegment funcPtr, MemorySegment ort_custom_thread_handle) {
        try {
            DOWN$MH.invokeExact(funcPtr, ort_custom_thread_handle);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    /**
     * Get an implementation of the function interface from a function pointer.
     */
    public static OrtCustomJoinThreadFn.Function function(MemorySegment funcPtr) {
        return (ort_custom_thread_handle) -> invoke(funcPtr, ort_custom_thread_handle);
    }
}
