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
 * typedef OrtStatus *(*EpSelectionDelegate)(const OrtEpDevice **, size_t, const OrtKeyValuePairs *, const OrtKeyValuePairs *, const OrtEpDevice **, size_t, size_t *, void *)
 * }
 */
public final class EpSelectionDelegate {

    private EpSelectionDelegate() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        MemorySegment apply(
                MemorySegment ep_devices,
                long num_devices,
                MemorySegment model_metadata,
                MemorySegment runtime_metadata,
                MemorySegment selected,
                long max_selected,
                MemorySegment num_selected,
                MemorySegment state);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_LONG,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_LONG,
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER);

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH =
            onnxruntime_all_h.upcallHandle(EpSelectionDelegate.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(EpSelectionDelegate.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static MemorySegment invoke(
            MemorySegment funcPtr,
            MemorySegment ep_devices,
            long num_devices,
            MemorySegment model_metadata,
            MemorySegment runtime_metadata,
            MemorySegment selected,
            long max_selected,
            MemorySegment num_selected,
            MemorySegment state) {
        try {
            return (MemorySegment) DOWN$MH.invokeExact(
                    funcPtr,
                    ep_devices,
                    num_devices,
                    model_metadata,
                    runtime_metadata,
                    selected,
                    max_selected,
                    num_selected,
                    state);
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
