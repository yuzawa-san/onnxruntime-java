/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class OrtApiBase {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_POINTER$LAYOUT.withName("GetApi"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetVersionString"))
            .withName("OrtApiBase");

    public static MemoryLayout $LAYOUT() {
        return OrtApiBase.$struct$LAYOUT;
    }

    static final FunctionDescriptor GetApi$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle GetApi$MH = RuntimeHelper.downcallHandle(OrtApiBase.GetApi$FUNC);

    public interface GetApi {

        java.lang.foreign.Addressable apply(int _x0);

        static MemorySegment allocate(GetApi fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetApi.class, fi, OrtApiBase.GetApi$FUNC, session);
        }

        static GetApi ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApiBase.GetApi$MH.invokeExact((Addressable) symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetApi$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetApi"));

    public static VarHandle GetApi$VH() {
        return OrtApiBase.GetApi$VH;
    }

    public static MemoryAddress GetApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApiBase.GetApi$VH.get(seg);
    }

    public static void GetApi$set(MemorySegment seg, MemoryAddress x) {
        OrtApiBase.GetApi$VH.set(seg, x);
    }

    public static MemoryAddress GetApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApiBase.GetApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetApi$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApiBase.GetApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetApi GetApi(MemorySegment segment, MemorySession session) {
        return GetApi.ofAddress(GetApi$get(segment), session);
    }

    static final FunctionDescriptor GetVersionString$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetVersionString$MH = RuntimeHelper.downcallHandle(OrtApiBase.GetVersionString$FUNC);

    public interface GetVersionString {

        java.lang.foreign.Addressable apply();

        static MemorySegment allocate(GetVersionString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetVersionString.class, fi, OrtApiBase.GetVersionString$FUNC, session);
        }

        static GetVersionString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return () -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApiBase.GetVersionString$MH.invokeExact((Addressable) symbol);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetVersionString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetVersionString"));

    public static VarHandle GetVersionString$VH() {
        return OrtApiBase.GetVersionString$VH;
    }

    public static MemoryAddress GetVersionString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApiBase.GetVersionString$VH.get(seg);
    }

    public static void GetVersionString$set(MemorySegment seg, MemoryAddress x) {
        OrtApiBase.GetVersionString$VH.set(seg, x);
    }

    public static MemoryAddress GetVersionString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApiBase.GetVersionString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVersionString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApiBase.GetVersionString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVersionString GetVersionString(MemorySegment segment, MemorySession session) {
        return GetVersionString.ofAddress(GetVersionString$get(segment), session);
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
