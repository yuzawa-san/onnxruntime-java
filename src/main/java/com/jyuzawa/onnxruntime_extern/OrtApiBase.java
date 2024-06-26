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
 * struct OrtApiBase {
 *     const OrtApi *(*GetApi)(uint32_t);
 *     const char *(*GetVersionString)(void);
 * }
 * }
 */
public class OrtApiBase {

    OrtApiBase() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_POINTER.withName("GetApi"),
                    onnxruntime_all_h.C_POINTER.withName("GetVersionString"))
            .withName("OrtApiBase");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    /**
     * {@snippet lang=c :
     * const OrtApi *(*GetApi)(uint32_t)
     * }
     */
    public static class GetApi {

        GetApi() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(int _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(GetApi.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetApi.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, int _x0) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetApi.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetApi$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetApi"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const OrtApi *(*GetApi)(uint32_t)
     * }
     */
    public static final AddressLayout GetApi$layout() {
        return GetApi$LAYOUT;
    }

    private static final long GetApi$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const OrtApi *(*GetApi)(uint32_t)
     * }
     */
    public static final long GetApi$offset() {
        return GetApi$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const OrtApi *(*GetApi)(uint32_t)
     * }
     */
    public static MemorySegment GetApi(MemorySegment struct) {
        return struct.get(GetApi$LAYOUT, GetApi$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const OrtApi *(*GetApi)(uint32_t)
     * }
     */
    public static void GetApi(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetApi$LAYOUT, GetApi$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * const OrtApi *(*GetApi)(uint32_t)
     * }
     */
    public static GetApi.Function GetApiFunction(MemorySegment struct) {
        return GetApi.function(GetApi(struct));
    }

    /**
     * {@snippet lang=c :
     * const char *(*GetVersionString)(void)
     * }
     */
    public static class GetVersionString {

        GetVersionString() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply();
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetVersionString.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVersionString.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetVersionString.Function function(MemorySegment funcPtr) {
            return () -> invoke(funcPtr);
        }
    }

    private static final AddressLayout GetVersionString$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetVersionString"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *(*GetVersionString)(void)
     * }
     */
    public static final AddressLayout GetVersionString$layout() {
        return GetVersionString$LAYOUT;
    }

    private static final long GetVersionString$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *(*GetVersionString)(void)
     * }
     */
    public static final long GetVersionString$offset() {
        return GetVersionString$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *(*GetVersionString)(void)
     * }
     */
    public static MemorySegment GetVersionString(MemorySegment struct) {
        return struct.get(GetVersionString$LAYOUT, GetVersionString$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *(*GetVersionString)(void)
     * }
     */
    public static void GetVersionString(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVersionString$LAYOUT, GetVersionString$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * const char *(*GetVersionString)(void)
     * }
     */
    public static GetVersionString.Function GetVersionStringFunction(MemorySegment struct) {
        return GetVersionString.function(GetVersionString(struct));
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() {
        return layout().byteSize();
    }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(
            MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}
