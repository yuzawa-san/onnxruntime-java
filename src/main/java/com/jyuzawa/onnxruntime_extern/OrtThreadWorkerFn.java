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
 * typedef void (*OrtThreadWorkerFn)(void *)
 * }
 */
public class OrtThreadWorkerFn {

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        void apply(MemorySegment ort_worker_fn_param);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER);

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH =
            onnxruntime_all_h.upcallHandle(OrtThreadWorkerFn.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(OrtThreadWorkerFn.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static void invoke(MemorySegment funcPtr, MemorySegment ort_worker_fn_param) {
        try {
            DOWN$MH.invokeExact(funcPtr, ort_worker_fn_param);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static OrtThreadWorkerFn.Function invoker(MemorySegment funcPtr) {
        return (ort_worker_fn_param) -> invoke(funcPtr, ort_worker_fn_param);
    }
}
