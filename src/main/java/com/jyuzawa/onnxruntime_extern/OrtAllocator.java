/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtAllocator {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_INT.withName("version"),
                    MemoryLayout.paddingLayout(32),
                    C_POINTER.withName("Alloc"),
                    C_POINTER.withName("Free"),
                    C_POINTER.withName("Info"))
            .withName("OrtAllocator");

    public static MemoryLayout $LAYOUT() {
        return OrtAllocator.$struct$LAYOUT;
    }

    static final VarHandle version$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("version"));

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

    static final FunctionDescriptor Alloc$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle Alloc$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtAllocator.Alloc$FUNC,
            false);

    public interface Alloc {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, long x1);

        static MemoryAddress allocate(Alloc fi) {
            return RuntimeHelper.upcallStub(
                    Alloc.class,
                    fi,
                    OrtAllocator.Alloc$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(Alloc fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    Alloc.class,
                    fi,
                    OrtAllocator.Alloc$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static Alloc ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtAllocator.Alloc$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Alloc$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("Alloc")));

    public static VarHandle Alloc$VH() {
        return OrtAllocator.Alloc$VH;
    }

    public static MemoryAddress Alloc$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtAllocator.Alloc$VH.get(seg);
    }

    public static void Alloc$set(MemorySegment seg, MemoryAddress x) {
        OrtAllocator.Alloc$VH.set(seg, x);
    }

    public static MemoryAddress Alloc$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtAllocator.Alloc$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Alloc$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtAllocator.Alloc$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Alloc Alloc(MemorySegment segment) {
        return Alloc.ofAddress(Alloc$get(segment));
    }

    static final FunctionDescriptor Free$FUNC = FunctionDescriptor.ofVoid(C_POINTER, C_POINTER);
    static final MethodHandle Free$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
            OrtAllocator.Free$FUNC,
            false);

    public interface Free {

        void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(Free fi) {
            return RuntimeHelper.upcallStub(
                    Free.class,
                    fi,
                    OrtAllocator.Free$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(Free fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    Free.class,
                    fi,
                    OrtAllocator.Free$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static Free ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    OrtAllocator.Free$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Free$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("Free")));

    public static VarHandle Free$VH() {
        return OrtAllocator.Free$VH;
    }

    public static MemoryAddress Free$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtAllocator.Free$VH.get(seg);
    }

    public static void Free$set(MemorySegment seg, MemoryAddress x) {
        OrtAllocator.Free$VH.set(seg, x);
    }

    public static MemoryAddress Free$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtAllocator.Free$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Free$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtAllocator.Free$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Free Free(MemorySegment segment) {
        return Free.ofAddress(Free$get(segment));
    }

    static final FunctionDescriptor Info$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle Info$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtAllocator.Info$FUNC,
            false);

    public interface Info {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(Info fi) {
            return RuntimeHelper.upcallStub(
                    Info.class,
                    fi,
                    OrtAllocator.Info$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(Info fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    Info.class,
                    fi,
                    OrtAllocator.Info$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static Info ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtAllocator.Info$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Info$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("Info")));

    public static VarHandle Info$VH() {
        return OrtAllocator.Info$VH;
    }

    public static MemoryAddress Info$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtAllocator.Info$VH.get(seg);
    }

    public static void Info$set(MemorySegment seg, MemoryAddress x) {
        OrtAllocator.Info$VH.set(seg, x);
    }

    public static MemoryAddress Info$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtAllocator.Info$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Info$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtAllocator.Info$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Info Info(MemorySegment segment) {
        return Info.ofAddress(Info$get(segment));
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocate(ResourceScope scope) {
        return allocate(SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
