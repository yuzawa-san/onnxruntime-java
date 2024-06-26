/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.MemoryLayout.PathElement.*;
import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * {@snippet lang=c :
 * struct OrtTensorRTProviderOptions {
 *     int device_id;
 *     int has_user_compute_stream;
 *     void *user_compute_stream;
 *     int trt_max_partition_iterations;
 *     int trt_min_subgraph_size;
 *     size_t trt_max_workspace_size;
 *     int trt_fp16_enable;
 *     int trt_int8_enable;
 *     const char *trt_int8_calibration_table_name;
 *     int trt_int8_use_native_calibration_table;
 *     int trt_dla_enable;
 *     int trt_dla_core;
 *     int trt_dump_subgraphs;
 *     int trt_engine_cache_enable;
 *     const char *trt_engine_cache_path;
 *     int trt_engine_decryption_enable;
 *     const char *trt_engine_decryption_lib_path;
 *     int trt_force_sequential_engine_build;
 * }
 * }
 */
public class OrtTensorRTProviderOptions {

    OrtTensorRTProviderOptions() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_INT.withName("device_id"),
                    onnxruntime_all_h.C_INT.withName("has_user_compute_stream"),
                    onnxruntime_all_h.C_POINTER.withName("user_compute_stream"),
                    onnxruntime_all_h.C_INT.withName("trt_max_partition_iterations"),
                    onnxruntime_all_h.C_INT.withName("trt_min_subgraph_size"),
                    onnxruntime_all_h.C_LONG.withName("trt_max_workspace_size"),
                    onnxruntime_all_h.C_INT.withName("trt_fp16_enable"),
                    onnxruntime_all_h.C_INT.withName("trt_int8_enable"),
                    onnxruntime_all_h.C_POINTER.withName("trt_int8_calibration_table_name"),
                    onnxruntime_all_h.C_INT.withName("trt_int8_use_native_calibration_table"),
                    onnxruntime_all_h.C_INT.withName("trt_dla_enable"),
                    onnxruntime_all_h.C_INT.withName("trt_dla_core"),
                    onnxruntime_all_h.C_INT.withName("trt_dump_subgraphs"),
                    onnxruntime_all_h.C_INT.withName("trt_engine_cache_enable"),
                    MemoryLayout.paddingLayout(4),
                    onnxruntime_all_h.C_POINTER.withName("trt_engine_cache_path"),
                    onnxruntime_all_h.C_INT.withName("trt_engine_decryption_enable"),
                    MemoryLayout.paddingLayout(4),
                    onnxruntime_all_h.C_POINTER.withName("trt_engine_decryption_lib_path"),
                    onnxruntime_all_h.C_INT.withName("trt_force_sequential_engine_build"),
                    MemoryLayout.paddingLayout(4))
            .withName("OrtTensorRTProviderOptions");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt device_id$LAYOUT = (OfInt) $LAYOUT.select(groupElement("device_id"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int device_id
     * }
     */
    public static final OfInt device_id$layout() {
        return device_id$LAYOUT;
    }

    private static final long device_id$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int device_id
     * }
     */
    public static final long device_id$offset() {
        return device_id$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int device_id
     * }
     */
    public static int device_id(MemorySegment struct) {
        return struct.get(device_id$LAYOUT, device_id$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int device_id
     * }
     */
    public static void device_id(MemorySegment struct, int fieldValue) {
        struct.set(device_id$LAYOUT, device_id$OFFSET, fieldValue);
    }

    private static final OfInt has_user_compute_stream$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("has_user_compute_stream"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int has_user_compute_stream
     * }
     */
    public static final OfInt has_user_compute_stream$layout() {
        return has_user_compute_stream$LAYOUT;
    }

    private static final long has_user_compute_stream$OFFSET = 4;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int has_user_compute_stream
     * }
     */
    public static final long has_user_compute_stream$offset() {
        return has_user_compute_stream$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int has_user_compute_stream
     * }
     */
    public static int has_user_compute_stream(MemorySegment struct) {
        return struct.get(has_user_compute_stream$LAYOUT, has_user_compute_stream$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int has_user_compute_stream
     * }
     */
    public static void has_user_compute_stream(MemorySegment struct, int fieldValue) {
        struct.set(has_user_compute_stream$LAYOUT, has_user_compute_stream$OFFSET, fieldValue);
    }

    private static final AddressLayout user_compute_stream$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("user_compute_stream"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void *user_compute_stream
     * }
     */
    public static final AddressLayout user_compute_stream$layout() {
        return user_compute_stream$LAYOUT;
    }

    private static final long user_compute_stream$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void *user_compute_stream
     * }
     */
    public static final long user_compute_stream$offset() {
        return user_compute_stream$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void *user_compute_stream
     * }
     */
    public static MemorySegment user_compute_stream(MemorySegment struct) {
        return struct.get(user_compute_stream$LAYOUT, user_compute_stream$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void *user_compute_stream
     * }
     */
    public static void user_compute_stream(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(user_compute_stream$LAYOUT, user_compute_stream$OFFSET, fieldValue);
    }

    private static final OfInt trt_max_partition_iterations$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("trt_max_partition_iterations"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_max_partition_iterations
     * }
     */
    public static final OfInt trt_max_partition_iterations$layout() {
        return trt_max_partition_iterations$LAYOUT;
    }

    private static final long trt_max_partition_iterations$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_max_partition_iterations
     * }
     */
    public static final long trt_max_partition_iterations$offset() {
        return trt_max_partition_iterations$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_max_partition_iterations
     * }
     */
    public static int trt_max_partition_iterations(MemorySegment struct) {
        return struct.get(trt_max_partition_iterations$LAYOUT, trt_max_partition_iterations$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_max_partition_iterations
     * }
     */
    public static void trt_max_partition_iterations(MemorySegment struct, int fieldValue) {
        struct.set(trt_max_partition_iterations$LAYOUT, trt_max_partition_iterations$OFFSET, fieldValue);
    }

    private static final OfInt trt_min_subgraph_size$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("trt_min_subgraph_size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_min_subgraph_size
     * }
     */
    public static final OfInt trt_min_subgraph_size$layout() {
        return trt_min_subgraph_size$LAYOUT;
    }

    private static final long trt_min_subgraph_size$OFFSET = 20;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_min_subgraph_size
     * }
     */
    public static final long trt_min_subgraph_size$offset() {
        return trt_min_subgraph_size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_min_subgraph_size
     * }
     */
    public static int trt_min_subgraph_size(MemorySegment struct) {
        return struct.get(trt_min_subgraph_size$LAYOUT, trt_min_subgraph_size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_min_subgraph_size
     * }
     */
    public static void trt_min_subgraph_size(MemorySegment struct, int fieldValue) {
        struct.set(trt_min_subgraph_size$LAYOUT, trt_min_subgraph_size$OFFSET, fieldValue);
    }

    private static final OfLong trt_max_workspace_size$LAYOUT =
            (OfLong) $LAYOUT.select(groupElement("trt_max_workspace_size"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t trt_max_workspace_size
     * }
     */
    public static final OfLong trt_max_workspace_size$layout() {
        return trt_max_workspace_size$LAYOUT;
    }

    private static final long trt_max_workspace_size$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t trt_max_workspace_size
     * }
     */
    public static final long trt_max_workspace_size$offset() {
        return trt_max_workspace_size$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t trt_max_workspace_size
     * }
     */
    public static long trt_max_workspace_size(MemorySegment struct) {
        return struct.get(trt_max_workspace_size$LAYOUT, trt_max_workspace_size$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t trt_max_workspace_size
     * }
     */
    public static void trt_max_workspace_size(MemorySegment struct, long fieldValue) {
        struct.set(trt_max_workspace_size$LAYOUT, trt_max_workspace_size$OFFSET, fieldValue);
    }

    private static final OfInt trt_fp16_enable$LAYOUT = (OfInt) $LAYOUT.select(groupElement("trt_fp16_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_fp16_enable
     * }
     */
    public static final OfInt trt_fp16_enable$layout() {
        return trt_fp16_enable$LAYOUT;
    }

    private static final long trt_fp16_enable$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_fp16_enable
     * }
     */
    public static final long trt_fp16_enable$offset() {
        return trt_fp16_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_fp16_enable
     * }
     */
    public static int trt_fp16_enable(MemorySegment struct) {
        return struct.get(trt_fp16_enable$LAYOUT, trt_fp16_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_fp16_enable
     * }
     */
    public static void trt_fp16_enable(MemorySegment struct, int fieldValue) {
        struct.set(trt_fp16_enable$LAYOUT, trt_fp16_enable$OFFSET, fieldValue);
    }

    private static final OfInt trt_int8_enable$LAYOUT = (OfInt) $LAYOUT.select(groupElement("trt_int8_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_int8_enable
     * }
     */
    public static final OfInt trt_int8_enable$layout() {
        return trt_int8_enable$LAYOUT;
    }

    private static final long trt_int8_enable$OFFSET = 36;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_int8_enable
     * }
     */
    public static final long trt_int8_enable$offset() {
        return trt_int8_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_int8_enable
     * }
     */
    public static int trt_int8_enable(MemorySegment struct) {
        return struct.get(trt_int8_enable$LAYOUT, trt_int8_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_int8_enable
     * }
     */
    public static void trt_int8_enable(MemorySegment struct, int fieldValue) {
        struct.set(trt_int8_enable$LAYOUT, trt_int8_enable$OFFSET, fieldValue);
    }

    private static final AddressLayout trt_int8_calibration_table_name$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("trt_int8_calibration_table_name"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *trt_int8_calibration_table_name
     * }
     */
    public static final AddressLayout trt_int8_calibration_table_name$layout() {
        return trt_int8_calibration_table_name$LAYOUT;
    }

    private static final long trt_int8_calibration_table_name$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *trt_int8_calibration_table_name
     * }
     */
    public static final long trt_int8_calibration_table_name$offset() {
        return trt_int8_calibration_table_name$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *trt_int8_calibration_table_name
     * }
     */
    public static MemorySegment trt_int8_calibration_table_name(MemorySegment struct) {
        return struct.get(trt_int8_calibration_table_name$LAYOUT, trt_int8_calibration_table_name$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *trt_int8_calibration_table_name
     * }
     */
    public static void trt_int8_calibration_table_name(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(trt_int8_calibration_table_name$LAYOUT, trt_int8_calibration_table_name$OFFSET, fieldValue);
    }

    private static final OfInt trt_int8_use_native_calibration_table$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("trt_int8_use_native_calibration_table"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_int8_use_native_calibration_table
     * }
     */
    public static final OfInt trt_int8_use_native_calibration_table$layout() {
        return trt_int8_use_native_calibration_table$LAYOUT;
    }

    private static final long trt_int8_use_native_calibration_table$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_int8_use_native_calibration_table
     * }
     */
    public static final long trt_int8_use_native_calibration_table$offset() {
        return trt_int8_use_native_calibration_table$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_int8_use_native_calibration_table
     * }
     */
    public static int trt_int8_use_native_calibration_table(MemorySegment struct) {
        return struct.get(trt_int8_use_native_calibration_table$LAYOUT, trt_int8_use_native_calibration_table$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_int8_use_native_calibration_table
     * }
     */
    public static void trt_int8_use_native_calibration_table(MemorySegment struct, int fieldValue) {
        struct.set(
                trt_int8_use_native_calibration_table$LAYOUT, trt_int8_use_native_calibration_table$OFFSET, fieldValue);
    }

    private static final OfInt trt_dla_enable$LAYOUT = (OfInt) $LAYOUT.select(groupElement("trt_dla_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_dla_enable
     * }
     */
    public static final OfInt trt_dla_enable$layout() {
        return trt_dla_enable$LAYOUT;
    }

    private static final long trt_dla_enable$OFFSET = 52;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_dla_enable
     * }
     */
    public static final long trt_dla_enable$offset() {
        return trt_dla_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_dla_enable
     * }
     */
    public static int trt_dla_enable(MemorySegment struct) {
        return struct.get(trt_dla_enable$LAYOUT, trt_dla_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_dla_enable
     * }
     */
    public static void trt_dla_enable(MemorySegment struct, int fieldValue) {
        struct.set(trt_dla_enable$LAYOUT, trt_dla_enable$OFFSET, fieldValue);
    }

    private static final OfInt trt_dla_core$LAYOUT = (OfInt) $LAYOUT.select(groupElement("trt_dla_core"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_dla_core
     * }
     */
    public static final OfInt trt_dla_core$layout() {
        return trt_dla_core$LAYOUT;
    }

    private static final long trt_dla_core$OFFSET = 56;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_dla_core
     * }
     */
    public static final long trt_dla_core$offset() {
        return trt_dla_core$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_dla_core
     * }
     */
    public static int trt_dla_core(MemorySegment struct) {
        return struct.get(trt_dla_core$LAYOUT, trt_dla_core$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_dla_core
     * }
     */
    public static void trt_dla_core(MemorySegment struct, int fieldValue) {
        struct.set(trt_dla_core$LAYOUT, trt_dla_core$OFFSET, fieldValue);
    }

    private static final OfInt trt_dump_subgraphs$LAYOUT = (OfInt) $LAYOUT.select(groupElement("trt_dump_subgraphs"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_dump_subgraphs
     * }
     */
    public static final OfInt trt_dump_subgraphs$layout() {
        return trt_dump_subgraphs$LAYOUT;
    }

    private static final long trt_dump_subgraphs$OFFSET = 60;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_dump_subgraphs
     * }
     */
    public static final long trt_dump_subgraphs$offset() {
        return trt_dump_subgraphs$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_dump_subgraphs
     * }
     */
    public static int trt_dump_subgraphs(MemorySegment struct) {
        return struct.get(trt_dump_subgraphs$LAYOUT, trt_dump_subgraphs$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_dump_subgraphs
     * }
     */
    public static void trt_dump_subgraphs(MemorySegment struct, int fieldValue) {
        struct.set(trt_dump_subgraphs$LAYOUT, trt_dump_subgraphs$OFFSET, fieldValue);
    }

    private static final OfInt trt_engine_cache_enable$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("trt_engine_cache_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_engine_cache_enable
     * }
     */
    public static final OfInt trt_engine_cache_enable$layout() {
        return trt_engine_cache_enable$LAYOUT;
    }

    private static final long trt_engine_cache_enable$OFFSET = 64;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_engine_cache_enable
     * }
     */
    public static final long trt_engine_cache_enable$offset() {
        return trt_engine_cache_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_engine_cache_enable
     * }
     */
    public static int trt_engine_cache_enable(MemorySegment struct) {
        return struct.get(trt_engine_cache_enable$LAYOUT, trt_engine_cache_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_engine_cache_enable
     * }
     */
    public static void trt_engine_cache_enable(MemorySegment struct, int fieldValue) {
        struct.set(trt_engine_cache_enable$LAYOUT, trt_engine_cache_enable$OFFSET, fieldValue);
    }

    private static final AddressLayout trt_engine_cache_path$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("trt_engine_cache_path"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *trt_engine_cache_path
     * }
     */
    public static final AddressLayout trt_engine_cache_path$layout() {
        return trt_engine_cache_path$LAYOUT;
    }

    private static final long trt_engine_cache_path$OFFSET = 72;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *trt_engine_cache_path
     * }
     */
    public static final long trt_engine_cache_path$offset() {
        return trt_engine_cache_path$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *trt_engine_cache_path
     * }
     */
    public static MemorySegment trt_engine_cache_path(MemorySegment struct) {
        return struct.get(trt_engine_cache_path$LAYOUT, trt_engine_cache_path$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *trt_engine_cache_path
     * }
     */
    public static void trt_engine_cache_path(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(trt_engine_cache_path$LAYOUT, trt_engine_cache_path$OFFSET, fieldValue);
    }

    private static final OfInt trt_engine_decryption_enable$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("trt_engine_decryption_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_engine_decryption_enable
     * }
     */
    public static final OfInt trt_engine_decryption_enable$layout() {
        return trt_engine_decryption_enable$LAYOUT;
    }

    private static final long trt_engine_decryption_enable$OFFSET = 80;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_engine_decryption_enable
     * }
     */
    public static final long trt_engine_decryption_enable$offset() {
        return trt_engine_decryption_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_engine_decryption_enable
     * }
     */
    public static int trt_engine_decryption_enable(MemorySegment struct) {
        return struct.get(trt_engine_decryption_enable$LAYOUT, trt_engine_decryption_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_engine_decryption_enable
     * }
     */
    public static void trt_engine_decryption_enable(MemorySegment struct, int fieldValue) {
        struct.set(trt_engine_decryption_enable$LAYOUT, trt_engine_decryption_enable$OFFSET, fieldValue);
    }

    private static final AddressLayout trt_engine_decryption_lib_path$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("trt_engine_decryption_lib_path"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *trt_engine_decryption_lib_path
     * }
     */
    public static final AddressLayout trt_engine_decryption_lib_path$layout() {
        return trt_engine_decryption_lib_path$LAYOUT;
    }

    private static final long trt_engine_decryption_lib_path$OFFSET = 88;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *trt_engine_decryption_lib_path
     * }
     */
    public static final long trt_engine_decryption_lib_path$offset() {
        return trt_engine_decryption_lib_path$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *trt_engine_decryption_lib_path
     * }
     */
    public static MemorySegment trt_engine_decryption_lib_path(MemorySegment struct) {
        return struct.get(trt_engine_decryption_lib_path$LAYOUT, trt_engine_decryption_lib_path$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *trt_engine_decryption_lib_path
     * }
     */
    public static void trt_engine_decryption_lib_path(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(trt_engine_decryption_lib_path$LAYOUT, trt_engine_decryption_lib_path$OFFSET, fieldValue);
    }

    private static final OfInt trt_force_sequential_engine_build$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("trt_force_sequential_engine_build"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int trt_force_sequential_engine_build
     * }
     */
    public static final OfInt trt_force_sequential_engine_build$layout() {
        return trt_force_sequential_engine_build$LAYOUT;
    }

    private static final long trt_force_sequential_engine_build$OFFSET = 96;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int trt_force_sequential_engine_build
     * }
     */
    public static final long trt_force_sequential_engine_build$offset() {
        return trt_force_sequential_engine_build$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int trt_force_sequential_engine_build
     * }
     */
    public static int trt_force_sequential_engine_build(MemorySegment struct) {
        return struct.get(trt_force_sequential_engine_build$LAYOUT, trt_force_sequential_engine_build$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int trt_force_sequential_engine_build
     * }
     */
    public static void trt_force_sequential_engine_build(MemorySegment struct, int fieldValue) {
        struct.set(trt_force_sequential_engine_build$LAYOUT, trt_force_sequential_engine_build$OFFSET, fieldValue);
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() {
        return layout().byteSize();
    }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(
            MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}
