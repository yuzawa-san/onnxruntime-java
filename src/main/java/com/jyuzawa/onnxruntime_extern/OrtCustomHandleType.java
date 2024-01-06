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
 * struct OrtCustomHandleType {
 *     char __place_holder;
 * };
 * }
 */
public class OrtCustomHandleType {

    public static MemoryLayout $LAYOUT() {
        return constants$14.const$2;
    }

    public static VarHandle __place_holder$VH() {
        return constants$14.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char __place_holder;
     * }
     */
    public static byte __place_holder$get(MemorySegment seg) {
        return (byte) constants$14.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char __place_holder;
     * }
     */
    public static void __place_holder$set(MemorySegment seg, byte x) {
        constants$14.const$3.set(seg, x);
    }

    public static byte __place_holder$get(MemorySegment seg, long index) {
        return (byte) constants$14.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void __place_holder$set(MemorySegment seg, long index, byte x) {
        constants$14.const$3.set(seg.asSlice(index * sizeof()), x);
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
