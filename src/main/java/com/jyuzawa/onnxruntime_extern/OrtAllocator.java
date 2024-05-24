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
 * struct OrtAllocator {
 *     uint32_t version;
 *     void *(*Alloc)(struct OrtAllocator *, size_t);
 *     void (*Free)(struct OrtAllocator *, void *);
 *     const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *);
 *     void *(*Reserve)(struct OrtAllocator *, size_t);
 * }
 * }
 */
public class OrtAllocator {

    OrtAllocator() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_INT.withName("version"),
                    MemoryLayout.paddingLayout(4),
                    onnxruntime_all_h.C_POINTER.withName("Alloc"),
                    onnxruntime_all_h.C_POINTER.withName("Free"),
                    onnxruntime_all_h.C_POINTER.withName("Info"),
                    onnxruntime_all_h.C_POINTER.withName("Reserve"))
            .withName("OrtAllocator");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt version$LAYOUT = (OfInt) $LAYOUT.select(groupElement("version"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static final OfInt version$layout() {
        return version$LAYOUT;
    }

    private static final long version$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static final long version$offset() {
        return version$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static int version(MemorySegment struct) {
        return struct.get(version$LAYOUT, version$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static void version(MemorySegment struct, int fieldValue) {
        struct.set(version$LAYOUT, version$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void *(*Alloc)(struct OrtAllocator *, size_t)
     * }
     */
    public static class Alloc {

        Alloc() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(Alloc.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(Alloc.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static Alloc.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout Alloc$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("Alloc"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void *(*Alloc)(struct OrtAllocator *, size_t)
     * }
     */
    public static final AddressLayout Alloc$layout() {
        return Alloc$LAYOUT;
    }

    private static final long Alloc$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void *(*Alloc)(struct OrtAllocator *, size_t)
     * }
     */
    public static final long Alloc$offset() {
        return Alloc$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void *(*Alloc)(struct OrtAllocator *, size_t)
     * }
     */
    public static MemorySegment Alloc(MemorySegment struct) {
        return struct.get(Alloc$LAYOUT, Alloc$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void *(*Alloc)(struct OrtAllocator *, size_t)
     * }
     */
    public static void Alloc(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(Alloc$LAYOUT, Alloc$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void *(*Alloc)(struct OrtAllocator *, size_t)
     * }
     */
    public static Alloc.Function AllocFunction(MemorySegment struct) {
        return Alloc.function(Alloc(struct));
    }

    /**
     * {@snippet lang=c :
     * void (*Free)(struct OrtAllocator *, void *)
     * }
     */
    public static class Free {

        Free() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            void apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(Free.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(Free.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static Free.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout Free$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("Free"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*Free)(struct OrtAllocator *, void *)
     * }
     */
    public static final AddressLayout Free$layout() {
        return Free$LAYOUT;
    }

    private static final long Free$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*Free)(struct OrtAllocator *, void *)
     * }
     */
    public static final long Free$offset() {
        return Free$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*Free)(struct OrtAllocator *, void *)
     * }
     */
    public static MemorySegment Free(MemorySegment struct) {
        return struct.get(Free$LAYOUT, Free$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*Free)(struct OrtAllocator *, void *)
     * }
     */
    public static void Free(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(Free$LAYOUT, Free$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void (*Free)(struct OrtAllocator *, void *)
     * }
     */
    public static Free.Function FreeFunction(MemorySegment struct) {
        return Free.function(Free(struct));
    }

    /**
     * {@snippet lang=c :
     * const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *)
     * }
     */
    public static class Info {

        Info() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(Info.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(Info.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static Info.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout Info$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("Info"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *)
     * }
     */
    public static final AddressLayout Info$layout() {
        return Info$LAYOUT;
    }

    private static final long Info$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *)
     * }
     */
    public static final long Info$offset() {
        return Info$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *)
     * }
     */
    public static MemorySegment Info(MemorySegment struct) {
        return struct.get(Info$LAYOUT, Info$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *)
     * }
     */
    public static void Info(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(Info$LAYOUT, Info$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * const struct OrtMemoryInfo *(*Info)(const struct OrtAllocator *)
     * }
     */
    public static Info.Function InfoFunction(MemorySegment struct) {
        return Info.function(Info(struct));
    }

    /**
     * {@snippet lang=c :
     * void *(*Reserve)(struct OrtAllocator *, size_t)
     * }
     */
    public static class Reserve {

        Reserve() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(Reserve.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(Reserve.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static Reserve.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout Reserve$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("Reserve"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void *(*Reserve)(struct OrtAllocator *, size_t)
     * }
     */
    public static final AddressLayout Reserve$layout() {
        return Reserve$LAYOUT;
    }

    private static final long Reserve$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void *(*Reserve)(struct OrtAllocator *, size_t)
     * }
     */
    public static final long Reserve$offset() {
        return Reserve$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void *(*Reserve)(struct OrtAllocator *, size_t)
     * }
     */
    public static MemorySegment Reserve(MemorySegment struct) {
        return struct.get(Reserve$LAYOUT, Reserve$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void *(*Reserve)(struct OrtAllocator *, size_t)
     * }
     */
    public static void Reserve(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(Reserve$LAYOUT, Reserve$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void *(*Reserve)(struct OrtAllocator *, size_t)
     * }
     */
    public static Reserve.Function ReserveFunction(MemorySegment struct) {
        return Reserve.function(Reserve(struct));
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
