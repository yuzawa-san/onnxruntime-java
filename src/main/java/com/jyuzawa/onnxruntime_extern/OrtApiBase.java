/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtApiBase {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_POINTER.withName("GetApi"), C_POINTER.withName("GetVersionString"))
            .withName("OrtApiBase");

    public static MemoryLayout $LAYOUT() {
        return OrtApiBase.$struct$LAYOUT;
    }

    static final FunctionDescriptor GetApi$FUNC = FunctionDescriptor.of(C_POINTER, C_INT);
    static final MethodHandle GetApi$MH =
            RuntimeHelper.downcallHandle("(I)Ljdk/incubator/foreign/MemoryAddress;", OrtApiBase.GetApi$FUNC, false);

    public interface GetApi {

        jdk.incubator.foreign.MemoryAddress apply(int x0);

        static MemoryAddress allocate(GetApi fi) {
            return RuntimeHelper.upcallStub(
                    GetApi.class, fi, OrtApiBase.GetApi$FUNC, "(I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetApi fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetApi.class, fi, OrtApiBase.GetApi$FUNC, "(I)Ljdk/incubator/foreign/MemoryAddress;", scope);
        }

        static GetApi ofAddress(MemoryAddress addr) {
            return (int x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApiBase.GetApi$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetApi$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetApi")));

    public static VarHandle GetApi$VH() {
        return OrtApiBase.GetApi$VH;
    }

    public static MemoryAddress GetApi$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApiBase.GetApi$VH.get(seg);
    }

    public static void GetApi$set(MemorySegment seg, MemoryAddress x) {
        OrtApiBase.GetApi$VH.set(seg, x);
    }

    public static MemoryAddress GetApi$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApiBase.GetApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetApi$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApiBase.GetApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetApi GetApi(MemorySegment segment) {
        return GetApi.ofAddress(GetApi$get(segment));
    }

    static final FunctionDescriptor GetVersionString$FUNC = FunctionDescriptor.of(C_POINTER);
    static final MethodHandle GetVersionString$MH = RuntimeHelper.downcallHandle(
            "()Ljdk/incubator/foreign/MemoryAddress;", OrtApiBase.GetVersionString$FUNC, false);

    public interface GetVersionString {

        jdk.incubator.foreign.MemoryAddress apply();

        static MemoryAddress allocate(GetVersionString fi) {
            return RuntimeHelper.upcallStub(
                    GetVersionString.class,
                    fi,
                    OrtApiBase.GetVersionString$FUNC,
                    "()Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetVersionString fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetVersionString.class,
                    fi,
                    OrtApiBase.GetVersionString$FUNC,
                    "()Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetVersionString ofAddress(MemoryAddress addr) {
            return () -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApiBase.GetVersionString$MH.invokeExact((Addressable) addr);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetVersionString$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetVersionString")));

    public static VarHandle GetVersionString$VH() {
        return OrtApiBase.GetVersionString$VH;
    }

    public static MemoryAddress GetVersionString$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApiBase.GetVersionString$VH.get(seg);
    }

    public static void GetVersionString$set(MemorySegment seg, MemoryAddress x) {
        OrtApiBase.GetVersionString$VH.set(seg, x);
    }

    public static MemoryAddress GetVersionString$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApiBase.GetVersionString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVersionString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApiBase.GetVersionString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVersionString GetVersionString(MemorySegment segment) {
        return GetVersionString.ofAddress(GetVersionString$get(segment));
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
