/*
 * Copyright (c) 2025 James Yuzawa (https://www.jyuzawa.com/)
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
 * typedef OrtCustomThreadHandle (*OrtCustomCreateThreadFn)(void *, OrtThreadWorkerFn, void *)
 * }
 */
public final class OrtCustomCreateThreadFn {

    private OrtCustomCreateThreadFn() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        MemorySegment apply(
                MemorySegment ort_custom_thread_creation_options,
                MemorySegment ort_thread_worker_fn,
                MemorySegment ort_worker_fn_param);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER);

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH =
            onnxruntime_all_h.upcallHandle(OrtCustomCreateThreadFn.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(OrtCustomCreateThreadFn.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static MemorySegment invoke(
            MemorySegment funcPtr,
            MemorySegment ort_custom_thread_creation_options,
            MemorySegment ort_thread_worker_fn,
            MemorySegment ort_worker_fn_param) {
        try {
            return (MemorySegment) DOWN$MH.invokeExact(
                    funcPtr, ort_custom_thread_creation_options, ort_thread_worker_fn, ort_worker_fn_param);
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
