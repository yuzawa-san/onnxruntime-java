/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtAllocator {
 *     unsigned int version;
 *     void* (*Alloc)(struct OrtAllocator*,unsigned long);
 *     void (*Free)(struct OrtAllocator*,void*);
 *     struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
 * };
 * }
 */
public class OrtAllocator {

    public static MemoryLayout $LAYOUT() {
        return constants$0.const$0;
    }

    public static VarHandle version$VH() {
        return constants$0.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned int version;
     * }
     */
    public static int version$get(MemorySegment seg) {
        return (int) constants$0.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned int version;
     * }
     */
    public static void version$set(MemorySegment seg, int x) {
        constants$0.const$1.set(seg, x);
    }

    public static int version$get(MemorySegment seg, long index) {
        return (int) constants$0.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void version$set(MemorySegment seg, long index, int x) {
        constants$0.const$1.set(seg.asSlice(index * sizeof()), x);
    }
    /**
     * {@snippet :
     * void* (*Alloc)(struct OrtAllocator*,unsigned long);
     * }
     */
    public interface Alloc {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(Alloc fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$0.const$3, fi, constants$0.const$2, scope);
        }

        static Alloc ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$0.const$4.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Alloc$VH() {
        return constants$0.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* (*Alloc)(struct OrtAllocator*,unsigned long);
     * }
     */
    public static MemorySegment Alloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$0.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* (*Alloc)(struct OrtAllocator*,unsigned long);
     * }
     */
    public static void Alloc$set(MemorySegment seg, MemorySegment x) {
        constants$0.const$5.set(seg, x);
    }

    public static MemorySegment Alloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$0.const$5.get(seg.asSlice(index * sizeof()));
    }

    public static void Alloc$set(MemorySegment seg, long index, MemorySegment x) {
        constants$0.const$5.set(seg.asSlice(index * sizeof()), x);
    }

    public static Alloc Alloc(MemorySegment segment, Arena scope) {
        return Alloc.ofAddress(Alloc$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*Free)(struct OrtAllocator*,void*);
     * }
     */
    public interface Free {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(Free fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$1.const$1, fi, constants$1.const$0, scope);
        }

        static Free ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    constants$1.const$2.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Free$VH() {
        return constants$1.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*Free)(struct OrtAllocator*,void*);
     * }
     */
    public static MemorySegment Free$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$1.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*Free)(struct OrtAllocator*,void*);
     * }
     */
    public static void Free$set(MemorySegment seg, MemorySegment x) {
        constants$1.const$3.set(seg, x);
    }

    public static MemorySegment Free$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$1.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void Free$set(MemorySegment seg, long index, MemorySegment x) {
        constants$1.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static Free Free(MemorySegment segment, Arena scope) {
        return Free.ofAddress(Free$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
     * }
     */
    public interface Info {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(Info fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$1.const$5, fi, constants$1.const$4, scope);
        }

        static Info ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Info$VH() {
        return constants$2.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
     * }
     */
    public static MemorySegment Info$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$2.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
     * }
     */
    public static void Info$set(MemorySegment seg, MemorySegment x) {
        constants$2.const$1.set(seg, x);
    }

    public static MemorySegment Info$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$2.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void Info$set(MemorySegment seg, long index, MemorySegment x) {
        constants$2.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static Info Info(MemorySegment segment, Arena scope) {
        return Info.ofAddress(Info$get(segment), scope);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
