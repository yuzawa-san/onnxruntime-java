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
 * struct OrtApiBase {
 *     const OrtApi* (*GetApi)(uint32_t);
 *     char* (*GetVersionString)();
 * };
 * }
 */
public class OrtApiBase {

    static final StructLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_POINTER$LAYOUT.withName("GetApi"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetVersionString"))
            .withName("OrtApiBase");

    public static MemoryLayout $LAYOUT() {
        return OrtApiBase.$struct$LAYOUT;
    }

    static final FunctionDescriptor GetApi$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle GetApi$MH = RuntimeHelper.downcallHandle(OrtApiBase.GetApi$FUNC);
    /**
     * {@snippet :
     * const OrtApi* (*GetApi)(uint32_t);
     * }
     */
    public interface GetApi {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(GetApi fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetApi.class, fi, OrtApiBase.GetApi$FUNC, scope);
        }

        static GetApi ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApiBase.GetApi$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * const OrtApi* (*GetApi)(uint32_t);
     * }
     */
    public static MemorySegment GetApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApiBase.GetApi$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * const OrtApi* (*GetApi)(uint32_t);
     * }
     */
    public static void GetApi$set(MemorySegment seg, MemorySegment x) {
        OrtApiBase.GetApi$VH.set(seg, x);
    }

    public static MemorySegment GetApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApiBase.GetApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetApi$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApiBase.GetApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetApi GetApi(MemorySegment segment, SegmentScope scope) {
        return GetApi.ofAddress(GetApi$get(segment), scope);
    }

    static final FunctionDescriptor GetVersionString$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetVersionString$MH = RuntimeHelper.downcallHandle(OrtApiBase.GetVersionString$FUNC);
    /**
     * {@snippet :
     * char* (*GetVersionString)();
     * }
     */
    public interface GetVersionString {

        java.lang.foreign.MemorySegment apply();

        static MemorySegment allocate(GetVersionString fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetVersionString.class, fi, OrtApiBase.GetVersionString$FUNC, scope);
        }

        static GetVersionString ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return () -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApiBase.GetVersionString$MH.invokeExact(symbol);
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
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetVersionString)();
     * }
     */
    public static MemorySegment GetVersionString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApiBase.GetVersionString$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetVersionString)();
     * }
     */
    public static void GetVersionString$set(MemorySegment seg, MemorySegment x) {
        OrtApiBase.GetVersionString$VH.set(seg, x);
    }

    public static MemorySegment GetVersionString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApiBase.GetVersionString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVersionString$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApiBase.GetVersionString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVersionString GetVersionString(MemorySegment segment, SegmentScope scope) {
        return GetVersionString.ofAddress(GetVersionString$get(segment), scope);
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
