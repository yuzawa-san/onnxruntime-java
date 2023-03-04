/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtAllocator {
 *     uint32_t version;
 *     void* (*Alloc)(struct OrtAllocator*,size_t);
 *     void (*Free)(struct OrtAllocator*,void*);
 *     struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
 * };
 * }
 */
public class OrtAllocator {

    static final StructLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_INT$LAYOUT.withName("version"),
                    MemoryLayout.paddingLayout(32),
                    Constants$root.C_POINTER$LAYOUT.withName("Alloc"),
                    Constants$root.C_POINTER$LAYOUT.withName("Free"),
                    Constants$root.C_POINTER$LAYOUT.withName("Info"))
            .withName("OrtAllocator");

    public static MemoryLayout $LAYOUT() {
        return OrtAllocator.$struct$LAYOUT;
    }

    static final VarHandle version$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("version"));

    public static VarHandle version$VH() {
        return OrtAllocator.version$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * uint32_t version;
     * }
     */
    public static int version$get(MemorySegment seg) {
        return (int) OrtAllocator.version$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * uint32_t version;
     * }
     */
    public static void version$set(MemorySegment seg, int x) {
        OrtAllocator.version$VH.set(seg, x);
    }

    public static int version$get(MemorySegment seg, long index) {
        return (int) OrtAllocator.version$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void version$set(MemorySegment seg, long index, int x) {
        OrtAllocator.version$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final FunctionDescriptor Alloc$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle Alloc$MH = RuntimeHelper.downcallHandle(OrtAllocator.Alloc$FUNC);
    /**
     * {@snippet :
     * void* (*Alloc)(struct OrtAllocator*,size_t);
     * }
     */
    public interface Alloc {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(Alloc fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(Alloc.class, fi, OrtAllocator.Alloc$FUNC, scope);
        }

        static Alloc ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtAllocator.Alloc$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Alloc$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Alloc"));

    public static VarHandle Alloc$VH() {
        return OrtAllocator.Alloc$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* (*Alloc)(struct OrtAllocator*,size_t);
     * }
     */
    public static MemorySegment Alloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtAllocator.Alloc$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* (*Alloc)(struct OrtAllocator*,size_t);
     * }
     */
    public static void Alloc$set(MemorySegment seg, MemorySegment x) {
        OrtAllocator.Alloc$VH.set(seg, x);
    }

    public static MemorySegment Alloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtAllocator.Alloc$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Alloc$set(MemorySegment seg, long index, MemorySegment x) {
        OrtAllocator.Alloc$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Alloc Alloc(MemorySegment segment, SegmentScope scope) {
        return Alloc.ofAddress(Alloc$get(segment), scope);
    }

    static final FunctionDescriptor Free$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Free$MH = RuntimeHelper.downcallHandle(OrtAllocator.Free$FUNC);
    /**
     * {@snippet :
     * void (*Free)(struct OrtAllocator*,void*);
     * }
     */
    public interface Free {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(Free fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(Free.class, fi, OrtAllocator.Free$FUNC, scope);
        }

        static Free ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    OrtAllocator.Free$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Free$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Free"));

    public static VarHandle Free$VH() {
        return OrtAllocator.Free$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*Free)(struct OrtAllocator*,void*);
     * }
     */
    public static MemorySegment Free$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtAllocator.Free$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*Free)(struct OrtAllocator*,void*);
     * }
     */
    public static void Free$set(MemorySegment seg, MemorySegment x) {
        OrtAllocator.Free$VH.set(seg, x);
    }

    public static MemorySegment Free$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtAllocator.Free$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Free$set(MemorySegment seg, long index, MemorySegment x) {
        OrtAllocator.Free$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Free Free(MemorySegment segment, SegmentScope scope) {
        return Free.ofAddress(Free$get(segment), scope);
    }

    static final FunctionDescriptor Info$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Info$MH = RuntimeHelper.downcallHandle(OrtAllocator.Info$FUNC);
    /**
     * {@snippet :
     * struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
     * }
     */
    public interface Info {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(Info fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(Info.class, fi, OrtAllocator.Info$FUNC, scope);
        }

        static Info ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtAllocator.Info$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Info$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Info"));

    public static VarHandle Info$VH() {
        return OrtAllocator.Info$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
     * }
     */
    public static MemorySegment Info$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtAllocator.Info$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtMemoryInfo* (*Info)(struct OrtAllocator*);
     * }
     */
    public static void Info$set(MemorySegment seg, MemorySegment x) {
        OrtAllocator.Info$VH.set(seg, x);
    }

    public static MemorySegment Info$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtAllocator.Info$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Info$set(MemorySegment seg, long index, MemorySegment x) {
        OrtAllocator.Info$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Info Info(MemorySegment segment, SegmentScope scope) {
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

    public static MemorySegment ofAddress(MemorySegment addr, SegmentScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
