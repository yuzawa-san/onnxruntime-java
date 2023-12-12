/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtApiBase {
 *     struct OrtApi* (*GetApi)(unsigned int);
 *     char* (*GetVersionString)();
 * };
 * }
 */
public class OrtApiBase {

    public static MemoryLayout $LAYOUT() {
        return constants$12.const$1;
    }
    /**
     * {@snippet :
     * struct OrtApi* (*GetApi)(unsigned int);
     * }
     */
    public interface GetApi {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(GetApi fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$12.const$3, fi, constants$12.const$2, scope);
        }

        static GetApi ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$12.const$4.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetApi$VH() {
        return constants$12.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtApi* (*GetApi)(unsigned int);
     * }
     */
    public static MemorySegment GetApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$12.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtApi* (*GetApi)(unsigned int);
     * }
     */
    public static void GetApi$set(MemorySegment seg, MemorySegment x) {
        constants$12.const$5.set(seg, x);
    }

    public static MemorySegment GetApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$12.const$5.get(seg.asSlice(index * sizeof()));
    }

    public static void GetApi$set(MemorySegment seg, long index, MemorySegment x) {
        constants$12.const$5.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetApi GetApi(MemorySegment segment, Arena scope) {
        return GetApi.ofAddress(GetApi$get(segment), scope);
    }
    /**
     * {@snippet :
     * char* (*GetVersionString)();
     * }
     */
    public interface GetVersionString {

        java.lang.foreign.MemorySegment apply();

        static MemorySegment allocate(GetVersionString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$13.const$1, fi, constants$13.const$0, scope);
        }

        static GetVersionString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return () -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$13.const$2.invokeExact(symbol);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetVersionString$VH() {
        return constants$13.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetVersionString)();
     * }
     */
    public static MemorySegment GetVersionString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$13.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetVersionString)();
     * }
     */
    public static void GetVersionString$set(MemorySegment seg, MemorySegment x) {
        constants$13.const$3.set(seg, x);
    }

    public static MemorySegment GetVersionString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$13.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVersionString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$13.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVersionString GetVersionString(MemorySegment segment, Arena scope) {
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

    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
