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
 * struct OrtTensorRTProviderOptions {
 *     int device_id;
 *     int has_user_compute_stream;
 *     void* user_compute_stream;
 *     int trt_max_partition_iterations;
 *     int trt_min_subgraph_size;
 *     unsigned long trt_max_workspace_size;
 *     int trt_fp16_enable;
 *     int trt_int8_enable;
 *     char* trt_int8_calibration_table_name;
 *     int trt_int8_use_native_calibration_table;
 *     int trt_dla_enable;
 *     int trt_dla_core;
 *     int trt_dump_subgraphs;
 *     int trt_engine_cache_enable;
 *     char* trt_engine_cache_path;
 *     int trt_engine_decryption_enable;
 *     char* trt_engine_decryption_lib_path;
 *     int trt_force_sequential_engine_build;
 * };
 * }
 */
public class OrtTensorRTProviderOptions {

    public static MemoryLayout $LAYOUT() {
        return constants$6.const$5;
    }

    public static VarHandle device_id$VH() {
        return constants$7.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static int device_id$get(MemorySegment seg) {
        return (int) constants$7.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static void device_id$set(MemorySegment seg, int x) {
        constants$7.const$0.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) constants$7.const$0.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        constants$7.const$0.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle has_user_compute_stream$VH() {
        return constants$7.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) constants$7.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        constants$7.const$1.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) constants$7.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        constants$7.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle user_compute_stream$VH() {
        return constants$7.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static MemorySegment user_compute_stream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$7.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static void user_compute_stream$set(MemorySegment seg, MemorySegment x) {
        constants$7.const$2.set(seg, x);
    }

    public static MemorySegment user_compute_stream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$7.const$2.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemorySegment x) {
        constants$7.const$2.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_max_partition_iterations$VH() {
        return constants$7.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_max_partition_iterations;
     * }
     */
    public static int trt_max_partition_iterations$get(MemorySegment seg) {
        return (int) constants$7.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_max_partition_iterations;
     * }
     */
    public static void trt_max_partition_iterations$set(MemorySegment seg, int x) {
        constants$7.const$3.set(seg, x);
    }

    public static int trt_max_partition_iterations$get(MemorySegment seg, long index) {
        return (int) constants$7.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_max_partition_iterations$set(MemorySegment seg, long index, int x) {
        constants$7.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_min_subgraph_size$VH() {
        return constants$7.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_min_subgraph_size;
     * }
     */
    public static int trt_min_subgraph_size$get(MemorySegment seg) {
        return (int) constants$7.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_min_subgraph_size;
     * }
     */
    public static void trt_min_subgraph_size$set(MemorySegment seg, int x) {
        constants$7.const$4.set(seg, x);
    }

    public static int trt_min_subgraph_size$get(MemorySegment seg, long index) {
        return (int) constants$7.const$4.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_min_subgraph_size$set(MemorySegment seg, long index, int x) {
        constants$7.const$4.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_max_workspace_size$VH() {
        return constants$7.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned long trt_max_workspace_size;
     * }
     */
    public static long trt_max_workspace_size$get(MemorySegment seg) {
        return (long) constants$7.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned long trt_max_workspace_size;
     * }
     */
    public static void trt_max_workspace_size$set(MemorySegment seg, long x) {
        constants$7.const$5.set(seg, x);
    }

    public static long trt_max_workspace_size$get(MemorySegment seg, long index) {
        return (long) constants$7.const$5.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_max_workspace_size$set(MemorySegment seg, long index, long x) {
        constants$7.const$5.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_fp16_enable$VH() {
        return constants$8.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_fp16_enable;
     * }
     */
    public static int trt_fp16_enable$get(MemorySegment seg) {
        return (int) constants$8.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_fp16_enable;
     * }
     */
    public static void trt_fp16_enable$set(MemorySegment seg, int x) {
        constants$8.const$0.set(seg, x);
    }

    public static int trt_fp16_enable$get(MemorySegment seg, long index) {
        return (int) constants$8.const$0.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_fp16_enable$set(MemorySegment seg, long index, int x) {
        constants$8.const$0.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_int8_enable$VH() {
        return constants$8.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_int8_enable;
     * }
     */
    public static int trt_int8_enable$get(MemorySegment seg) {
        return (int) constants$8.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_int8_enable;
     * }
     */
    public static void trt_int8_enable$set(MemorySegment seg, int x) {
        constants$8.const$1.set(seg, x);
    }

    public static int trt_int8_enable$get(MemorySegment seg, long index) {
        return (int) constants$8.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_enable$set(MemorySegment seg, long index, int x) {
        constants$8.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_int8_calibration_table_name$VH() {
        return constants$8.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* trt_int8_calibration_table_name;
     * }
     */
    public static MemorySegment trt_int8_calibration_table_name$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$8.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* trt_int8_calibration_table_name;
     * }
     */
    public static void trt_int8_calibration_table_name$set(MemorySegment seg, MemorySegment x) {
        constants$8.const$2.set(seg, x);
    }

    public static MemorySegment trt_int8_calibration_table_name$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$8.const$2.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_calibration_table_name$set(MemorySegment seg, long index, MemorySegment x) {
        constants$8.const$2.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_int8_use_native_calibration_table$VH() {
        return constants$8.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_int8_use_native_calibration_table;
     * }
     */
    public static int trt_int8_use_native_calibration_table$get(MemorySegment seg) {
        return (int) constants$8.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_int8_use_native_calibration_table;
     * }
     */
    public static void trt_int8_use_native_calibration_table$set(MemorySegment seg, int x) {
        constants$8.const$3.set(seg, x);
    }

    public static int trt_int8_use_native_calibration_table$get(MemorySegment seg, long index) {
        return (int) constants$8.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_use_native_calibration_table$set(MemorySegment seg, long index, int x) {
        constants$8.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_dla_enable$VH() {
        return constants$8.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_dla_enable;
     * }
     */
    public static int trt_dla_enable$get(MemorySegment seg) {
        return (int) constants$8.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_dla_enable;
     * }
     */
    public static void trt_dla_enable$set(MemorySegment seg, int x) {
        constants$8.const$4.set(seg, x);
    }

    public static int trt_dla_enable$get(MemorySegment seg, long index) {
        return (int) constants$8.const$4.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dla_enable$set(MemorySegment seg, long index, int x) {
        constants$8.const$4.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_dla_core$VH() {
        return constants$8.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_dla_core;
     * }
     */
    public static int trt_dla_core$get(MemorySegment seg) {
        return (int) constants$8.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_dla_core;
     * }
     */
    public static void trt_dla_core$set(MemorySegment seg, int x) {
        constants$8.const$5.set(seg, x);
    }

    public static int trt_dla_core$get(MemorySegment seg, long index) {
        return (int) constants$8.const$5.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dla_core$set(MemorySegment seg, long index, int x) {
        constants$8.const$5.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_dump_subgraphs$VH() {
        return constants$9.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_dump_subgraphs;
     * }
     */
    public static int trt_dump_subgraphs$get(MemorySegment seg) {
        return (int) constants$9.const$0.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_dump_subgraphs;
     * }
     */
    public static void trt_dump_subgraphs$set(MemorySegment seg, int x) {
        constants$9.const$0.set(seg, x);
    }

    public static int trt_dump_subgraphs$get(MemorySegment seg, long index) {
        return (int) constants$9.const$0.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dump_subgraphs$set(MemorySegment seg, long index, int x) {
        constants$9.const$0.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_engine_cache_enable$VH() {
        return constants$9.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_engine_cache_enable;
     * }
     */
    public static int trt_engine_cache_enable$get(MemorySegment seg) {
        return (int) constants$9.const$1.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_engine_cache_enable;
     * }
     */
    public static void trt_engine_cache_enable$set(MemorySegment seg, int x) {
        constants$9.const$1.set(seg, x);
    }

    public static int trt_engine_cache_enable$get(MemorySegment seg, long index) {
        return (int) constants$9.const$1.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_cache_enable$set(MemorySegment seg, long index, int x) {
        constants$9.const$1.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_engine_cache_path$VH() {
        return constants$9.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* trt_engine_cache_path;
     * }
     */
    public static MemorySegment trt_engine_cache_path$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$9.const$2.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* trt_engine_cache_path;
     * }
     */
    public static void trt_engine_cache_path$set(MemorySegment seg, MemorySegment x) {
        constants$9.const$2.set(seg, x);
    }

    public static MemorySegment trt_engine_cache_path$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$9.const$2.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_cache_path$set(MemorySegment seg, long index, MemorySegment x) {
        constants$9.const$2.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_engine_decryption_enable$VH() {
        return constants$9.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_engine_decryption_enable;
     * }
     */
    public static int trt_engine_decryption_enable$get(MemorySegment seg) {
        return (int) constants$9.const$3.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_engine_decryption_enable;
     * }
     */
    public static void trt_engine_decryption_enable$set(MemorySegment seg, int x) {
        constants$9.const$3.set(seg, x);
    }

    public static int trt_engine_decryption_enable$get(MemorySegment seg, long index) {
        return (int) constants$9.const$3.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_decryption_enable$set(MemorySegment seg, long index, int x) {
        constants$9.const$3.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_engine_decryption_lib_path$VH() {
        return constants$9.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* trt_engine_decryption_lib_path;
     * }
     */
    public static MemorySegment trt_engine_decryption_lib_path$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$9.const$4.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* trt_engine_decryption_lib_path;
     * }
     */
    public static void trt_engine_decryption_lib_path$set(MemorySegment seg, MemorySegment x) {
        constants$9.const$4.set(seg, x);
    }

    public static MemorySegment trt_engine_decryption_lib_path$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$9.const$4.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_decryption_lib_path$set(MemorySegment seg, long index, MemorySegment x) {
        constants$9.const$4.set(seg.asSlice(index * sizeof()), x);
    }

    public static VarHandle trt_force_sequential_engine_build$VH() {
        return constants$9.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_force_sequential_engine_build;
     * }
     */
    public static int trt_force_sequential_engine_build$get(MemorySegment seg) {
        return (int) constants$9.const$5.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_force_sequential_engine_build;
     * }
     */
    public static void trt_force_sequential_engine_build$set(MemorySegment seg, int x) {
        constants$9.const$5.set(seg, x);
    }

    public static int trt_force_sequential_engine_build$get(MemorySegment seg, long index) {
        return (int) constants$9.const$5.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_force_sequential_engine_build$set(MemorySegment seg, long index, int x) {
        constants$9.const$5.set(seg.asSlice(index * sizeof()), x);
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
