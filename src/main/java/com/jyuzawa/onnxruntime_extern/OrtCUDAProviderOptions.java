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
 * struct OrtCUDAProviderOptions {
 *     int device_id;
 *     OrtCudnnConvAlgoSearch cudnn_conv_algo_search;
 *     size_t gpu_mem_limit;
 *     int arena_extend_strategy;
 *     int do_copy_in_default_stream;
 *     int has_user_compute_stream;
 *     void *user_compute_stream;
 *     OrtArenaCfg *default_memory_arena_cfg;
 *     int tunable_op_enable;
 *     int tunable_op_tuning_enable;
 *     int tunable_op_max_tuning_duration_ms;
 * }
 * }
 */
public class OrtCUDAProviderOptions {

    OrtCUDAProviderOptions() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_INT.withName("device_id"),
                    onnxruntime_all_h.C_INT.withName("cudnn_conv_algo_search"),
                    onnxruntime_all_h.C_LONG.withName("gpu_mem_limit"),
                    onnxruntime_all_h.C_INT.withName("arena_extend_strategy"),
                    onnxruntime_all_h.C_INT.withName("do_copy_in_default_stream"),
                    onnxruntime_all_h.C_INT.withName("has_user_compute_stream"),
                    MemoryLayout.paddingLayout(4),
                    onnxruntime_all_h.C_POINTER.withName("user_compute_stream"),
                    onnxruntime_all_h.C_POINTER.withName("default_memory_arena_cfg"),
                    onnxruntime_all_h.C_INT.withName("tunable_op_enable"),
                    onnxruntime_all_h.C_INT.withName("tunable_op_tuning_enable"),
                    onnxruntime_all_h.C_INT.withName("tunable_op_max_tuning_duration_ms"),
                    MemoryLayout.paddingLayout(4))
            .withName("OrtCUDAProviderOptions");

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

    private static final OfInt cudnn_conv_algo_search$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("cudnn_conv_algo_search"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtCudnnConvAlgoSearch cudnn_conv_algo_search
     * }
     */
    public static final OfInt cudnn_conv_algo_search$layout() {
        return cudnn_conv_algo_search$LAYOUT;
    }

    private static final long cudnn_conv_algo_search$OFFSET = 4;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtCudnnConvAlgoSearch cudnn_conv_algo_search
     * }
     */
    public static final long cudnn_conv_algo_search$offset() {
        return cudnn_conv_algo_search$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtCudnnConvAlgoSearch cudnn_conv_algo_search
     * }
     */
    public static int cudnn_conv_algo_search(MemorySegment struct) {
        return struct.get(cudnn_conv_algo_search$LAYOUT, cudnn_conv_algo_search$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtCudnnConvAlgoSearch cudnn_conv_algo_search
     * }
     */
    public static void cudnn_conv_algo_search(MemorySegment struct, int fieldValue) {
        struct.set(cudnn_conv_algo_search$LAYOUT, cudnn_conv_algo_search$OFFSET, fieldValue);
    }

    private static final OfLong gpu_mem_limit$LAYOUT = (OfLong) $LAYOUT.select(groupElement("gpu_mem_limit"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t gpu_mem_limit
     * }
     */
    public static final OfLong gpu_mem_limit$layout() {
        return gpu_mem_limit$LAYOUT;
    }

    private static final long gpu_mem_limit$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t gpu_mem_limit
     * }
     */
    public static final long gpu_mem_limit$offset() {
        return gpu_mem_limit$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t gpu_mem_limit
     * }
     */
    public static long gpu_mem_limit(MemorySegment struct) {
        return struct.get(gpu_mem_limit$LAYOUT, gpu_mem_limit$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t gpu_mem_limit
     * }
     */
    public static void gpu_mem_limit(MemorySegment struct, long fieldValue) {
        struct.set(gpu_mem_limit$LAYOUT, gpu_mem_limit$OFFSET, fieldValue);
    }

    private static final OfInt arena_extend_strategy$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("arena_extend_strategy"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int arena_extend_strategy
     * }
     */
    public static final OfInt arena_extend_strategy$layout() {
        return arena_extend_strategy$LAYOUT;
    }

    private static final long arena_extend_strategy$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int arena_extend_strategy
     * }
     */
    public static final long arena_extend_strategy$offset() {
        return arena_extend_strategy$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int arena_extend_strategy
     * }
     */
    public static int arena_extend_strategy(MemorySegment struct) {
        return struct.get(arena_extend_strategy$LAYOUT, arena_extend_strategy$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int arena_extend_strategy
     * }
     */
    public static void arena_extend_strategy(MemorySegment struct, int fieldValue) {
        struct.set(arena_extend_strategy$LAYOUT, arena_extend_strategy$OFFSET, fieldValue);
    }

    private static final OfInt do_copy_in_default_stream$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("do_copy_in_default_stream"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int do_copy_in_default_stream
     * }
     */
    public static final OfInt do_copy_in_default_stream$layout() {
        return do_copy_in_default_stream$LAYOUT;
    }

    private static final long do_copy_in_default_stream$OFFSET = 20;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int do_copy_in_default_stream
     * }
     */
    public static final long do_copy_in_default_stream$offset() {
        return do_copy_in_default_stream$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int do_copy_in_default_stream
     * }
     */
    public static int do_copy_in_default_stream(MemorySegment struct) {
        return struct.get(do_copy_in_default_stream$LAYOUT, do_copy_in_default_stream$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int do_copy_in_default_stream
     * }
     */
    public static void do_copy_in_default_stream(MemorySegment struct, int fieldValue) {
        struct.set(do_copy_in_default_stream$LAYOUT, do_copy_in_default_stream$OFFSET, fieldValue);
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

    private static final long has_user_compute_stream$OFFSET = 24;

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

    private static final long user_compute_stream$OFFSET = 32;

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

    private static final AddressLayout default_memory_arena_cfg$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("default_memory_arena_cfg"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtArenaCfg *default_memory_arena_cfg
     * }
     */
    public static final AddressLayout default_memory_arena_cfg$layout() {
        return default_memory_arena_cfg$LAYOUT;
    }

    private static final long default_memory_arena_cfg$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtArenaCfg *default_memory_arena_cfg
     * }
     */
    public static final long default_memory_arena_cfg$offset() {
        return default_memory_arena_cfg$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtArenaCfg *default_memory_arena_cfg
     * }
     */
    public static MemorySegment default_memory_arena_cfg(MemorySegment struct) {
        return struct.get(default_memory_arena_cfg$LAYOUT, default_memory_arena_cfg$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtArenaCfg *default_memory_arena_cfg
     * }
     */
    public static void default_memory_arena_cfg(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(default_memory_arena_cfg$LAYOUT, default_memory_arena_cfg$OFFSET, fieldValue);
    }

    private static final OfInt tunable_op_enable$LAYOUT = (OfInt) $LAYOUT.select(groupElement("tunable_op_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int tunable_op_enable
     * }
     */
    public static final OfInt tunable_op_enable$layout() {
        return tunable_op_enable$LAYOUT;
    }

    private static final long tunable_op_enable$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int tunable_op_enable
     * }
     */
    public static final long tunable_op_enable$offset() {
        return tunable_op_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int tunable_op_enable
     * }
     */
    public static int tunable_op_enable(MemorySegment struct) {
        return struct.get(tunable_op_enable$LAYOUT, tunable_op_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int tunable_op_enable
     * }
     */
    public static void tunable_op_enable(MemorySegment struct, int fieldValue) {
        struct.set(tunable_op_enable$LAYOUT, tunable_op_enable$OFFSET, fieldValue);
    }

    private static final OfInt tunable_op_tuning_enable$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("tunable_op_tuning_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int tunable_op_tuning_enable
     * }
     */
    public static final OfInt tunable_op_tuning_enable$layout() {
        return tunable_op_tuning_enable$LAYOUT;
    }

    private static final long tunable_op_tuning_enable$OFFSET = 52;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int tunable_op_tuning_enable
     * }
     */
    public static final long tunable_op_tuning_enable$offset() {
        return tunable_op_tuning_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int tunable_op_tuning_enable
     * }
     */
    public static int tunable_op_tuning_enable(MemorySegment struct) {
        return struct.get(tunable_op_tuning_enable$LAYOUT, tunable_op_tuning_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int tunable_op_tuning_enable
     * }
     */
    public static void tunable_op_tuning_enable(MemorySegment struct, int fieldValue) {
        struct.set(tunable_op_tuning_enable$LAYOUT, tunable_op_tuning_enable$OFFSET, fieldValue);
    }

    private static final OfInt tunable_op_max_tuning_duration_ms$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("tunable_op_max_tuning_duration_ms"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int tunable_op_max_tuning_duration_ms
     * }
     */
    public static final OfInt tunable_op_max_tuning_duration_ms$layout() {
        return tunable_op_max_tuning_duration_ms$LAYOUT;
    }

    private static final long tunable_op_max_tuning_duration_ms$OFFSET = 56;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int tunable_op_max_tuning_duration_ms
     * }
     */
    public static final long tunable_op_max_tuning_duration_ms$offset() {
        return tunable_op_max_tuning_duration_ms$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int tunable_op_max_tuning_duration_ms
     * }
     */
    public static int tunable_op_max_tuning_duration_ms(MemorySegment struct) {
        return struct.get(tunable_op_max_tuning_duration_ms$LAYOUT, tunable_op_max_tuning_duration_ms$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int tunable_op_max_tuning_duration_ms
     * }
     */
    public static void tunable_op_max_tuning_duration_ms(MemorySegment struct, int fieldValue) {
        struct.set(tunable_op_max_tuning_duration_ms$LAYOUT, tunable_op_max_tuning_duration_ms$OFFSET, fieldValue);
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
