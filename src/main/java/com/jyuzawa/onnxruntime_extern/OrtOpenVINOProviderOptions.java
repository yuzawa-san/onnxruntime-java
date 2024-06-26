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
 * struct OrtOpenVINOProviderOptions {
 *     const char *device_type;
 *     unsigned char enable_npu_fast_compile;
 *     const char *device_id;
 *     size_t num_of_threads;
 *     const char *cache_dir;
 *     void *context;
 *     unsigned char enable_opencl_throttling;
 *     unsigned char enable_dynamic_shapes;
 * }
 * }
 */
public class OrtOpenVINOProviderOptions {

    OrtOpenVINOProviderOptions() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_POINTER.withName("device_type"),
                    onnxruntime_all_h.C_CHAR.withName("enable_npu_fast_compile"),
                    MemoryLayout.paddingLayout(7),
                    onnxruntime_all_h.C_POINTER.withName("device_id"),
                    onnxruntime_all_h.C_LONG.withName("num_of_threads"),
                    onnxruntime_all_h.C_POINTER.withName("cache_dir"),
                    onnxruntime_all_h.C_POINTER.withName("context"),
                    onnxruntime_all_h.C_CHAR.withName("enable_opencl_throttling"),
                    onnxruntime_all_h.C_CHAR.withName("enable_dynamic_shapes"),
                    MemoryLayout.paddingLayout(6))
            .withName("OrtOpenVINOProviderOptions");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final AddressLayout device_type$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("device_type"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *device_type
     * }
     */
    public static final AddressLayout device_type$layout() {
        return device_type$LAYOUT;
    }

    private static final long device_type$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *device_type
     * }
     */
    public static final long device_type$offset() {
        return device_type$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *device_type
     * }
     */
    public static MemorySegment device_type(MemorySegment struct) {
        return struct.get(device_type$LAYOUT, device_type$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *device_type
     * }
     */
    public static void device_type(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(device_type$LAYOUT, device_type$OFFSET, fieldValue);
    }

    private static final OfByte enable_npu_fast_compile$LAYOUT =
            (OfByte) $LAYOUT.select(groupElement("enable_npu_fast_compile"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * unsigned char enable_npu_fast_compile
     * }
     */
    public static final OfByte enable_npu_fast_compile$layout() {
        return enable_npu_fast_compile$LAYOUT;
    }

    private static final long enable_npu_fast_compile$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * unsigned char enable_npu_fast_compile
     * }
     */
    public static final long enable_npu_fast_compile$offset() {
        return enable_npu_fast_compile$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * unsigned char enable_npu_fast_compile
     * }
     */
    public static byte enable_npu_fast_compile(MemorySegment struct) {
        return struct.get(enable_npu_fast_compile$LAYOUT, enable_npu_fast_compile$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * unsigned char enable_npu_fast_compile
     * }
     */
    public static void enable_npu_fast_compile(MemorySegment struct, byte fieldValue) {
        struct.set(enable_npu_fast_compile$LAYOUT, enable_npu_fast_compile$OFFSET, fieldValue);
    }

    private static final AddressLayout device_id$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("device_id"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *device_id
     * }
     */
    public static final AddressLayout device_id$layout() {
        return device_id$LAYOUT;
    }

    private static final long device_id$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *device_id
     * }
     */
    public static final long device_id$offset() {
        return device_id$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *device_id
     * }
     */
    public static MemorySegment device_id(MemorySegment struct) {
        return struct.get(device_id$LAYOUT, device_id$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *device_id
     * }
     */
    public static void device_id(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(device_id$LAYOUT, device_id$OFFSET, fieldValue);
    }

    private static final OfLong num_of_threads$LAYOUT = (OfLong) $LAYOUT.select(groupElement("num_of_threads"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t num_of_threads
     * }
     */
    public static final OfLong num_of_threads$layout() {
        return num_of_threads$LAYOUT;
    }

    private static final long num_of_threads$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t num_of_threads
     * }
     */
    public static final long num_of_threads$offset() {
        return num_of_threads$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t num_of_threads
     * }
     */
    public static long num_of_threads(MemorySegment struct) {
        return struct.get(num_of_threads$LAYOUT, num_of_threads$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t num_of_threads
     * }
     */
    public static void num_of_threads(MemorySegment struct, long fieldValue) {
        struct.set(num_of_threads$LAYOUT, num_of_threads$OFFSET, fieldValue);
    }

    private static final AddressLayout cache_dir$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("cache_dir"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *cache_dir
     * }
     */
    public static final AddressLayout cache_dir$layout() {
        return cache_dir$LAYOUT;
    }

    private static final long cache_dir$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *cache_dir
     * }
     */
    public static final long cache_dir$offset() {
        return cache_dir$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *cache_dir
     * }
     */
    public static MemorySegment cache_dir(MemorySegment struct) {
        return struct.get(cache_dir$LAYOUT, cache_dir$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *cache_dir
     * }
     */
    public static void cache_dir(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(cache_dir$LAYOUT, cache_dir$OFFSET, fieldValue);
    }

    private static final AddressLayout context$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("context"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void *context
     * }
     */
    public static final AddressLayout context$layout() {
        return context$LAYOUT;
    }

    private static final long context$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void *context
     * }
     */
    public static final long context$offset() {
        return context$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void *context
     * }
     */
    public static MemorySegment context(MemorySegment struct) {
        return struct.get(context$LAYOUT, context$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void *context
     * }
     */
    public static void context(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(context$LAYOUT, context$OFFSET, fieldValue);
    }

    private static final OfByte enable_opencl_throttling$LAYOUT =
            (OfByte) $LAYOUT.select(groupElement("enable_opencl_throttling"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * unsigned char enable_opencl_throttling
     * }
     */
    public static final OfByte enable_opencl_throttling$layout() {
        return enable_opencl_throttling$LAYOUT;
    }

    private static final long enable_opencl_throttling$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * unsigned char enable_opencl_throttling
     * }
     */
    public static final long enable_opencl_throttling$offset() {
        return enable_opencl_throttling$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * unsigned char enable_opencl_throttling
     * }
     */
    public static byte enable_opencl_throttling(MemorySegment struct) {
        return struct.get(enable_opencl_throttling$LAYOUT, enable_opencl_throttling$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * unsigned char enable_opencl_throttling
     * }
     */
    public static void enable_opencl_throttling(MemorySegment struct, byte fieldValue) {
        struct.set(enable_opencl_throttling$LAYOUT, enable_opencl_throttling$OFFSET, fieldValue);
    }

    private static final OfByte enable_dynamic_shapes$LAYOUT =
            (OfByte) $LAYOUT.select(groupElement("enable_dynamic_shapes"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * unsigned char enable_dynamic_shapes
     * }
     */
    public static final OfByte enable_dynamic_shapes$layout() {
        return enable_dynamic_shapes$LAYOUT;
    }

    private static final long enable_dynamic_shapes$OFFSET = 49;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * unsigned char enable_dynamic_shapes
     * }
     */
    public static final long enable_dynamic_shapes$offset() {
        return enable_dynamic_shapes$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * unsigned char enable_dynamic_shapes
     * }
     */
    public static byte enable_dynamic_shapes(MemorySegment struct) {
        return struct.get(enable_dynamic_shapes$LAYOUT, enable_dynamic_shapes$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * unsigned char enable_dynamic_shapes
     * }
     */
    public static void enable_dynamic_shapes(MemorySegment struct, byte fieldValue) {
        struct.set(enable_dynamic_shapes$LAYOUT, enable_dynamic_shapes$OFFSET, fieldValue);
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
