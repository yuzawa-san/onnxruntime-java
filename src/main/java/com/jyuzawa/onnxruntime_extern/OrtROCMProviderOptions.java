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
 * struct OrtROCMProviderOptions {
 *     int device_id;
 *     int miopen_conv_exhaustive_search;
 *     unsigned long gpu_mem_limit;
 *     int arena_extend_strategy;
 *     int do_copy_in_default_stream;
 *     int has_user_compute_stream;
 *     void* user_compute_stream;
 *     struct OrtArenaCfg* default_memory_arena_cfg;
 *     int tunable_op_enable;
 *     int tunable_op_tuning_enable;
 *     int tunable_op_max_tuning_duration_ms;
 * };
 * }
 */
public class OrtROCMProviderOptions {

    public static MemoryLayout $LAYOUT() {
        return constants$4.const$5;
    }

    public static VarHandle device_id$VH() {
        return constants$5.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static int device_id$get(MemorySegment seg) {
        return (int) constants$5.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static void device_id$set(MemorySegment seg, int x) {
        constants$5.const$0.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) constants$5.const$0.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        constants$5.const$0.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle miopen_conv_exhaustive_search$VH() {
        return constants$5.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int miopen_conv_exhaustive_search;
     * }
     */
    public static int miopen_conv_exhaustive_search$get(MemorySegment seg) {
        return (int) constants$5.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int miopen_conv_exhaustive_search;
     * }
     */
    public static void miopen_conv_exhaustive_search$set(MemorySegment seg, int x) {
        constants$5.const$1.set(seg, x);
    }

    public static int miopen_conv_exhaustive_search$get(MemorySegment seg, long index) {
        return (int) constants$5.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void miopen_conv_exhaustive_search$set(MemorySegment seg, long index, int x) {
        constants$5.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle gpu_mem_limit$VH() {
        return constants$5.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned long gpu_mem_limit;
     * }
     */
    public static long gpu_mem_limit$get(MemorySegment seg) {
        return (long) constants$5.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned long gpu_mem_limit;
     * }
     */
    public static void gpu_mem_limit$set(MemorySegment seg, long x) {
        constants$5.const$2.set(seg, x);
    }

    public static long gpu_mem_limit$get(MemorySegment seg, long index) {
        return (long) constants$5.const$2.get(seg.asSlice(index * sizeof()));
    }

    public static void gpu_mem_limit$set(MemorySegment seg, long index, long x) {
        constants$5.const$2.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle arena_extend_strategy$VH() {
        return constants$5.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int arena_extend_strategy;
     * }
     */
    public static int arena_extend_strategy$get(MemorySegment seg) {
        return (int) constants$5.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int arena_extend_strategy;
     * }
     */
    public static void arena_extend_strategy$set(MemorySegment seg, int x) {
        constants$5.const$3.set(seg, x);
    }

    public static int arena_extend_strategy$get(MemorySegment seg, long index) {
        return (int) constants$5.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void arena_extend_strategy$set(MemorySegment seg, long index, int x) {
        constants$5.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle do_copy_in_default_stream$VH() {
        return constants$5.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int do_copy_in_default_stream;
     * }
     */
    public static int do_copy_in_default_stream$get(MemorySegment seg) {
        return (int) constants$5.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int do_copy_in_default_stream;
     * }
     */
    public static void do_copy_in_default_stream$set(MemorySegment seg, int x) {
        constants$5.const$4.set(seg, x);
    }

    public static int do_copy_in_default_stream$get(MemorySegment seg, long index) {
        return (int) constants$5.const$4.get(seg.asSlice(index * sizeof()));
    }

    public static void do_copy_in_default_stream$set(MemorySegment seg, long index, int x) {
        constants$5.const$4.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle has_user_compute_stream$VH() {
        return constants$5.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) constants$5.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        constants$5.const$5.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) constants$5.const$5.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        constants$5.const$5.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle user_compute_stream$VH() {
        return constants$6.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static MemorySegment user_compute_stream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$6.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static void user_compute_stream$set(MemorySegment seg, MemorySegment x) {
        constants$6.const$0.set(seg, x);
    }

    public static MemorySegment user_compute_stream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$6.const$0.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemorySegment x) {
        constants$6.const$0.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle default_memory_arena_cfg$VH() {
        return constants$6.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtArenaCfg* default_memory_arena_cfg;
     * }
     */
    public static MemorySegment default_memory_arena_cfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$6.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtArenaCfg* default_memory_arena_cfg;
     * }
     */
    public static void default_memory_arena_cfg$set(MemorySegment seg, MemorySegment x) {
        constants$6.const$1.set(seg, x);
    }

    public static MemorySegment default_memory_arena_cfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$6.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void default_memory_arena_cfg$set(MemorySegment seg, long index, MemorySegment x) {
        constants$6.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle tunable_op_enable$VH() {
        return constants$6.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int tunable_op_enable;
     * }
     */
    public static int tunable_op_enable$get(MemorySegment seg) {
        return (int) constants$6.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int tunable_op_enable;
     * }
     */
    public static void tunable_op_enable$set(MemorySegment seg, int x) {
        constants$6.const$2.set(seg, x);
    }

    public static int tunable_op_enable$get(MemorySegment seg, long index) {
        return (int) constants$6.const$2.get(seg.asSlice(index * sizeof()));
    }

    public static void tunable_op_enable$set(MemorySegment seg, long index, int x) {
        constants$6.const$2.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle tunable_op_tuning_enable$VH() {
        return constants$6.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int tunable_op_tuning_enable;
     * }
     */
    public static int tunable_op_tuning_enable$get(MemorySegment seg) {
        return (int) constants$6.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int tunable_op_tuning_enable;
     * }
     */
    public static void tunable_op_tuning_enable$set(MemorySegment seg, int x) {
        constants$6.const$3.set(seg, x);
    }

    public static int tunable_op_tuning_enable$get(MemorySegment seg, long index) {
        return (int) constants$6.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void tunable_op_tuning_enable$set(MemorySegment seg, long index, int x) {
        constants$6.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle tunable_op_max_tuning_duration_ms$VH() {
        return constants$6.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int tunable_op_max_tuning_duration_ms;
     * }
     */
    public static int tunable_op_max_tuning_duration_ms$get(MemorySegment seg) {
        return (int) constants$6.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int tunable_op_max_tuning_duration_ms;
     * }
     */
    public static void tunable_op_max_tuning_duration_ms$set(MemorySegment seg, int x) {
        constants$6.const$4.set(seg, x);
    }

    public static int tunable_op_max_tuning_duration_ms$get(MemorySegment seg, long index) {
        return (int) constants$6.const$4.get(seg.asSlice(index * sizeof()));
    }

    public static void tunable_op_max_tuning_duration_ms$set(MemorySegment seg, long index, int x) {
        constants$6.const$4.set(seg.asSlice(index * sizeof()), x);
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
