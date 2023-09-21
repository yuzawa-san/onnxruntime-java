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
 * struct OrtMIGraphXProviderOptions {
 *     int device_id;
 *     int migraphx_fp16_enable;
 *     int migraphx_int8_enable;
 * };
 * }
 */
public class OrtMIGraphXProviderOptions {

    public static MemoryLayout $LAYOUT() {
        return constants$10.const$0;
    }

    public static VarHandle device_id$VH() {
        return constants$10.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static int device_id$get(MemorySegment seg) {
        return (int) constants$10.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static void device_id$set(MemorySegment seg, int x) {
        constants$10.const$1.set(seg, 0L, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) constants$10.const$1.get(seg, index * sizeof());
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        constants$10.const$1.set(seg, index * sizeof(), x);
    }

    public static VarHandle migraphx_fp16_enable$VH() {
        return constants$10.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int migraphx_fp16_enable;
     * }
     */
    public static int migraphx_fp16_enable$get(MemorySegment seg) {
        return (int) constants$10.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int migraphx_fp16_enable;
     * }
     */
    public static void migraphx_fp16_enable$set(MemorySegment seg, int x) {
        constants$10.const$2.set(seg, 0L, x);
    }

    public static int migraphx_fp16_enable$get(MemorySegment seg, long index) {
        return (int) constants$10.const$2.get(seg, index * sizeof());
    }

    public static void migraphx_fp16_enable$set(MemorySegment seg, long index, int x) {
        constants$10.const$2.set(seg, index * sizeof(), x);
    }

    public static VarHandle migraphx_int8_enable$VH() {
        return constants$10.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int migraphx_int8_enable;
     * }
     */
    public static int migraphx_int8_enable$get(MemorySegment seg) {
        return (int) constants$10.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int migraphx_int8_enable;
     * }
     */
    public static void migraphx_int8_enable$set(MemorySegment seg, int x) {
        constants$10.const$3.set(seg, 0L, x);
    }

    public static int migraphx_int8_enable$get(MemorySegment seg, long index) {
        return (int) constants$10.const$3.get(seg, index * sizeof());
    }

    public static void migraphx_int8_enable$set(MemorySegment seg, long index, int x) {
        constants$10.const$3.set(seg, index * sizeof(), x);
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
