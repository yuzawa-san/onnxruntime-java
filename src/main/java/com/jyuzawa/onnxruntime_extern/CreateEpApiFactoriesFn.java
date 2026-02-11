/*
 * Copyright (c) 2026 James Yuzawa (https://www.jyuzawa.com/)
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
 * typedef OrtStatus *(*CreateEpApiFactoriesFn)(const char *, const OrtApiBase *, const OrtLogger *, OrtEpFactory **, size_t, size_t *)
 * }
 */
public final class CreateEpApiFactoriesFn {

    private CreateEpApiFactoriesFn() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        MemorySegment apply(
                MemorySegment registered_name,
                MemorySegment ort_api_base,
                MemorySegment default_logger,
                MemorySegment factories,
                long max_factories,
                MemorySegment num_factories);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_LONG,
            onnxruntime_all_h.C_POINTER);

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH =
            onnxruntime_all_h.upcallHandle(CreateEpApiFactoriesFn.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(CreateEpApiFactoriesFn.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static MemorySegment invoke(
            MemorySegment funcPtr,
            MemorySegment registered_name,
            MemorySegment ort_api_base,
            MemorySegment default_logger,
            MemorySegment factories,
            long max_factories,
            MemorySegment num_factories) {
        try {
            return (MemorySegment) DOWN$MH.invokeExact(
                    funcPtr, registered_name, ort_api_base, default_logger, factories, max_factories, num_factories);
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
