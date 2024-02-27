/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class OrtAllocator {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
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

    public static int version$get(MemorySegment seg) {
        return (int) OrtAllocator.version$VH.get(seg);
    }

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

    public interface Alloc {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, long _x1);

        static MemorySegment allocate(Alloc fi, MemorySession session) {
            return RuntimeHelper.upcallStub(Alloc.class, fi, OrtAllocator.Alloc$FUNC, session);
        }

        static Alloc ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtAllocator.Alloc$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
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

    public static MemoryAddress Alloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtAllocator.Alloc$VH.get(seg);
    }

    public static void Alloc$set(MemorySegment seg, MemoryAddress x) {
        OrtAllocator.Alloc$VH.set(seg, x);
    }

    public static MemoryAddress Alloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtAllocator.Alloc$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Alloc$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtAllocator.Alloc$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Alloc Alloc(MemorySegment segment, MemorySession session) {
        return Alloc.ofAddress(Alloc$get(segment), session);
    }

    static final FunctionDescriptor Free$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Free$MH = RuntimeHelper.downcallHandle(OrtAllocator.Free$FUNC);

    public interface Free {

        void apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(Free fi, MemorySession session) {
            return RuntimeHelper.upcallStub(Free.class, fi, OrtAllocator.Free$FUNC, session);
        }

        static Free ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    OrtAllocator.Free$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, (java.lang.foreign.Addressable)
                                    __x1);
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

    public static MemoryAddress Free$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtAllocator.Free$VH.get(seg);
    }

    public static void Free$set(MemorySegment seg, MemoryAddress x) {
        OrtAllocator.Free$VH.set(seg, x);
    }

    public static MemoryAddress Free$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtAllocator.Free$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Free$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtAllocator.Free$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Free Free(MemorySegment segment, MemorySession session) {
        return Free.ofAddress(Free$get(segment), session);
    }

    static final FunctionDescriptor Info$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Info$MH = RuntimeHelper.downcallHandle(OrtAllocator.Info$FUNC);

    public interface Info {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(Info fi, MemorySession session) {
            return RuntimeHelper.upcallStub(Info.class, fi, OrtAllocator.Info$FUNC, session);
        }

        static Info ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtAllocator.Info$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
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

    public static MemoryAddress Info$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtAllocator.Info$VH.get(seg);
    }

    public static void Info$set(MemorySegment seg, MemoryAddress x) {
        OrtAllocator.Info$VH.set(seg, x);
    }

    public static MemoryAddress Info$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtAllocator.Info$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Info$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtAllocator.Info$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Info Info(MemorySegment segment, MemorySession session) {
        return Info.ofAddress(Info$get(segment), session);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session);
    }
}
