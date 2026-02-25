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
 * typedef OrtStatus *(*OrtGetInitializerLocationFunc)(void *, const char *, const OrtValue *, const OrtExternalInitializerInfo *, OrtExternalInitializerInfo **)
 * }
 */
public final class OrtGetInitializerLocationFunc {

    private OrtGetInitializerLocationFunc() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        MemorySegment apply(
                MemorySegment state,
                MemorySegment initializer_name,
                MemorySegment initializer_value,
                MemorySegment external_info,
                MemorySegment new_external_info);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
            onnxruntime_all_h.C_POINTER,
            onnxruntime_all_h.C_POINTER,
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
            onnxruntime_all_h.upcallHandle(OrtGetInitializerLocationFunc.Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(OrtGetInitializerLocationFunc.Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static MemorySegment invoke(
            MemorySegment funcPtr,
            MemorySegment state,
            MemorySegment initializer_name,
            MemorySegment initializer_value,
            MemorySegment external_info,
            MemorySegment new_external_info) {
        try {
            return (MemorySegment) DOWN$MH.invokeExact(
                    funcPtr, state, initializer_name, initializer_value, external_info, new_external_info);
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
