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
 *     size_t trt_max_workspace_size;
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

    static final StructLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_INT$LAYOUT.withName("device_id"),
                    Constants$root.C_INT$LAYOUT.withName("has_user_compute_stream"),
                    Constants$root.C_POINTER$LAYOUT.withName("user_compute_stream"),
                    Constants$root.C_INT$LAYOUT.withName("trt_max_partition_iterations"),
                    Constants$root.C_INT$LAYOUT.withName("trt_min_subgraph_size"),
                    Constants$root.C_LONG_LONG$LAYOUT.withName("trt_max_workspace_size"),
                    Constants$root.C_INT$LAYOUT.withName("trt_fp16_enable"),
                    Constants$root.C_INT$LAYOUT.withName("trt_int8_enable"),
                    Constants$root.C_POINTER$LAYOUT.withName("trt_int8_calibration_table_name"),
                    Constants$root.C_INT$LAYOUT.withName("trt_int8_use_native_calibration_table"),
                    Constants$root.C_INT$LAYOUT.withName("trt_dla_enable"),
                    Constants$root.C_INT$LAYOUT.withName("trt_dla_core"),
                    Constants$root.C_INT$LAYOUT.withName("trt_dump_subgraphs"),
                    Constants$root.C_INT$LAYOUT.withName("trt_engine_cache_enable"),
                    MemoryLayout.paddingLayout(32),
                    Constants$root.C_POINTER$LAYOUT.withName("trt_engine_cache_path"),
                    Constants$root.C_INT$LAYOUT.withName("trt_engine_decryption_enable"),
                    MemoryLayout.paddingLayout(32),
                    Constants$root.C_POINTER$LAYOUT.withName("trt_engine_decryption_lib_path"),
                    Constants$root.C_INT$LAYOUT.withName("trt_force_sequential_engine_build"),
                    MemoryLayout.paddingLayout(32))
            .withName("OrtTensorRTProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtTensorRTProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_id$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtTensorRTProviderOptions.device_id$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static int device_id$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.device_id$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static void device_id$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.device_id$VH.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle has_user_compute_stream$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("has_user_compute_stream"));

    public static VarHandle has_user_compute_stream$VH() {
        return OrtTensorRTProviderOptions.has_user_compute_stream$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.has_user_compute_stream$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.has_user_compute_stream$VH.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.has_user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.has_user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle user_compute_stream$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("user_compute_stream"));

    public static VarHandle user_compute_stream$VH() {
        return OrtTensorRTProviderOptions.user_compute_stream$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static MemorySegment user_compute_stream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtTensorRTProviderOptions.user_compute_stream$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static void user_compute_stream$set(MemorySegment seg, MemorySegment x) {
        OrtTensorRTProviderOptions.user_compute_stream$VH.set(seg, x);
    }

    public static MemorySegment user_compute_stream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtTensorRTProviderOptions.user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemorySegment x) {
        OrtTensorRTProviderOptions.user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_max_partition_iterations$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_max_partition_iterations"));

    public static VarHandle trt_max_partition_iterations$VH() {
        return OrtTensorRTProviderOptions.trt_max_partition_iterations$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_max_partition_iterations;
     * }
     */
    public static int trt_max_partition_iterations$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_max_partition_iterations;
     * }
     */
    public static void trt_max_partition_iterations$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.set(seg, x);
    }

    public static int trt_max_partition_iterations$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_max_partition_iterations$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_min_subgraph_size$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_min_subgraph_size"));

    public static VarHandle trt_min_subgraph_size$VH() {
        return OrtTensorRTProviderOptions.trt_min_subgraph_size$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_min_subgraph_size;
     * }
     */
    public static int trt_min_subgraph_size$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_min_subgraph_size;
     * }
     */
    public static void trt_min_subgraph_size$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.set(seg, x);
    }

    public static int trt_min_subgraph_size$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_min_subgraph_size$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_max_workspace_size$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_max_workspace_size"));

    public static VarHandle trt_max_workspace_size$VH() {
        return OrtTensorRTProviderOptions.trt_max_workspace_size$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t trt_max_workspace_size;
     * }
     */
    public static long trt_max_workspace_size$get(MemorySegment seg) {
        return (long) OrtTensorRTProviderOptions.trt_max_workspace_size$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t trt_max_workspace_size;
     * }
     */
    public static void trt_max_workspace_size$set(MemorySegment seg, long x) {
        OrtTensorRTProviderOptions.trt_max_workspace_size$VH.set(seg, x);
    }

    public static long trt_max_workspace_size$get(MemorySegment seg, long index) {
        return (long) OrtTensorRTProviderOptions.trt_max_workspace_size$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_max_workspace_size$set(MemorySegment seg, long index, long x) {
        OrtTensorRTProviderOptions.trt_max_workspace_size$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_fp16_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_fp16_enable"));

    public static VarHandle trt_fp16_enable$VH() {
        return OrtTensorRTProviderOptions.trt_fp16_enable$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_fp16_enable;
     * }
     */
    public static int trt_fp16_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_fp16_enable$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_fp16_enable;
     * }
     */
    public static void trt_fp16_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_fp16_enable$VH.set(seg, x);
    }

    public static int trt_fp16_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_fp16_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_fp16_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_fp16_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_int8_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_int8_enable"));

    public static VarHandle trt_int8_enable$VH() {
        return OrtTensorRTProviderOptions.trt_int8_enable$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_int8_enable;
     * }
     */
    public static int trt_int8_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_int8_enable$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_int8_enable;
     * }
     */
    public static void trt_int8_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_int8_enable$VH.set(seg, x);
    }

    public static int trt_int8_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_int8_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_int8_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_int8_calibration_table_name$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_int8_calibration_table_name"));

    public static VarHandle trt_int8_calibration_table_name$VH() {
        return OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* trt_int8_calibration_table_name;
     * }
     */
    public static MemorySegment trt_int8_calibration_table_name$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* trt_int8_calibration_table_name;
     * }
     */
    public static void trt_int8_calibration_table_name$set(MemorySegment seg, MemorySegment x) {
        OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.set(seg, x);
    }

    public static MemorySegment trt_int8_calibration_table_name$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_calibration_table_name$set(MemorySegment seg, long index, MemorySegment x) {
        OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_int8_use_native_calibration_table$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_int8_use_native_calibration_table"));

    public static VarHandle trt_int8_use_native_calibration_table$VH() {
        return OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_int8_use_native_calibration_table;
     * }
     */
    public static int trt_int8_use_native_calibration_table$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_int8_use_native_calibration_table;
     * }
     */
    public static void trt_int8_use_native_calibration_table$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.set(seg, x);
    }

    public static int trt_int8_use_native_calibration_table$get(MemorySegment seg, long index) {
        return (int)
                OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_use_native_calibration_table$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_dla_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_dla_enable"));

    public static VarHandle trt_dla_enable$VH() {
        return OrtTensorRTProviderOptions.trt_dla_enable$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_dla_enable;
     * }
     */
    public static int trt_dla_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_dla_enable$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_dla_enable;
     * }
     */
    public static void trt_dla_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_dla_enable$VH.set(seg, x);
    }

    public static int trt_dla_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_dla_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dla_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_dla_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_dla_core$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_dla_core"));

    public static VarHandle trt_dla_core$VH() {
        return OrtTensorRTProviderOptions.trt_dla_core$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_dla_core;
     * }
     */
    public static int trt_dla_core$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_dla_core$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_dla_core;
     * }
     */
    public static void trt_dla_core$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_dla_core$VH.set(seg, x);
    }

    public static int trt_dla_core$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_dla_core$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dla_core$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_dla_core$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_dump_subgraphs$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_dump_subgraphs"));

    public static VarHandle trt_dump_subgraphs$VH() {
        return OrtTensorRTProviderOptions.trt_dump_subgraphs$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_dump_subgraphs;
     * }
     */
    public static int trt_dump_subgraphs$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_dump_subgraphs;
     * }
     */
    public static void trt_dump_subgraphs$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.set(seg, x);
    }

    public static int trt_dump_subgraphs$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dump_subgraphs$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_cache_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_cache_enable"));

    public static VarHandle trt_engine_cache_enable$VH() {
        return OrtTensorRTProviderOptions.trt_engine_cache_enable$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_engine_cache_enable;
     * }
     */
    public static int trt_engine_cache_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_engine_cache_enable;
     * }
     */
    public static void trt_engine_cache_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.set(seg, x);
    }

    public static int trt_engine_cache_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_cache_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_cache_path$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_cache_path"));

    public static VarHandle trt_engine_cache_path$VH() {
        return OrtTensorRTProviderOptions.trt_engine_cache_path$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* trt_engine_cache_path;
     * }
     */
    public static MemorySegment trt_engine_cache_path$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtTensorRTProviderOptions.trt_engine_cache_path$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* trt_engine_cache_path;
     * }
     */
    public static void trt_engine_cache_path$set(MemorySegment seg, MemorySegment x) {
        OrtTensorRTProviderOptions.trt_engine_cache_path$VH.set(seg, x);
    }

    public static MemorySegment trt_engine_cache_path$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtTensorRTProviderOptions.trt_engine_cache_path$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_cache_path$set(MemorySegment seg, long index, MemorySegment x) {
        OrtTensorRTProviderOptions.trt_engine_cache_path$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_decryption_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_decryption_enable"));

    public static VarHandle trt_engine_decryption_enable$VH() {
        return OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_engine_decryption_enable;
     * }
     */
    public static int trt_engine_decryption_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_engine_decryption_enable;
     * }
     */
    public static void trt_engine_decryption_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.set(seg, x);
    }

    public static int trt_engine_decryption_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_decryption_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_decryption_lib_path$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_engine_decryption_lib_path"));

    public static VarHandle trt_engine_decryption_lib_path$VH() {
        return OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* trt_engine_decryption_lib_path;
     * }
     */
    public static MemorySegment trt_engine_decryption_lib_path$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* trt_engine_decryption_lib_path;
     * }
     */
    public static void trt_engine_decryption_lib_path$set(MemorySegment seg, MemorySegment x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.set(seg, x);
    }

    public static MemorySegment trt_engine_decryption_lib_path$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_decryption_lib_path$set(MemorySegment seg, long index, MemorySegment x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_force_sequential_engine_build$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("trt_force_sequential_engine_build"));

    public static VarHandle trt_force_sequential_engine_build$VH() {
        return OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int trt_force_sequential_engine_build;
     * }
     */
    public static int trt_force_sequential_engine_build$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int trt_force_sequential_engine_build;
     * }
     */
    public static void trt_force_sequential_engine_build$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.set(seg, x);
    }

    public static int trt_force_sequential_engine_build$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_force_sequential_engine_build$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.set(seg.asSlice(index * sizeof()), x);
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
