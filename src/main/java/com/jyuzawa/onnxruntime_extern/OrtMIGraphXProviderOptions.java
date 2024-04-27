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
 * struct OrtMIGraphXProviderOptions {
 *     int device_id;
 *     int migraphx_fp16_enable;
 *     int migraphx_int8_enable;
 *     int migraphx_use_native_calibration_table;
 *     const char *migraphx_int8_calibration_table_name;
 * }
 * }
 */
public class OrtMIGraphXProviderOptions {

    OrtMIGraphXProviderOptions() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_INT.withName("device_id"),
                    onnxruntime_all_h.C_INT.withName("migraphx_fp16_enable"),
                    onnxruntime_all_h.C_INT.withName("migraphx_int8_enable"),
                    onnxruntime_all_h.C_INT.withName("migraphx_use_native_calibration_table"),
                    onnxruntime_all_h.C_POINTER.withName("migraphx_int8_calibration_table_name"))
            .withName("OrtMIGraphXProviderOptions");

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

    private static final OfInt migraphx_fp16_enable$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("migraphx_fp16_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int migraphx_fp16_enable
     * }
     */
    public static final OfInt migraphx_fp16_enable$layout() {
        return migraphx_fp16_enable$LAYOUT;
    }

    private static final long migraphx_fp16_enable$OFFSET = 4;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int migraphx_fp16_enable
     * }
     */
    public static final long migraphx_fp16_enable$offset() {
        return migraphx_fp16_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int migraphx_fp16_enable
     * }
     */
    public static int migraphx_fp16_enable(MemorySegment struct) {
        return struct.get(migraphx_fp16_enable$LAYOUT, migraphx_fp16_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int migraphx_fp16_enable
     * }
     */
    public static void migraphx_fp16_enable(MemorySegment struct, int fieldValue) {
        struct.set(migraphx_fp16_enable$LAYOUT, migraphx_fp16_enable$OFFSET, fieldValue);
    }

    private static final OfInt migraphx_int8_enable$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("migraphx_int8_enable"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int migraphx_int8_enable
     * }
     */
    public static final OfInt migraphx_int8_enable$layout() {
        return migraphx_int8_enable$LAYOUT;
    }

    private static final long migraphx_int8_enable$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int migraphx_int8_enable
     * }
     */
    public static final long migraphx_int8_enable$offset() {
        return migraphx_int8_enable$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int migraphx_int8_enable
     * }
     */
    public static int migraphx_int8_enable(MemorySegment struct) {
        return struct.get(migraphx_int8_enable$LAYOUT, migraphx_int8_enable$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int migraphx_int8_enable
     * }
     */
    public static void migraphx_int8_enable(MemorySegment struct, int fieldValue) {
        struct.set(migraphx_int8_enable$LAYOUT, migraphx_int8_enable$OFFSET, fieldValue);
    }

    private static final OfInt migraphx_use_native_calibration_table$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("migraphx_use_native_calibration_table"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int migraphx_use_native_calibration_table
     * }
     */
    public static final OfInt migraphx_use_native_calibration_table$layout() {
        return migraphx_use_native_calibration_table$LAYOUT;
    }

    private static final long migraphx_use_native_calibration_table$OFFSET = 12;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int migraphx_use_native_calibration_table
     * }
     */
    public static final long migraphx_use_native_calibration_table$offset() {
        return migraphx_use_native_calibration_table$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int migraphx_use_native_calibration_table
     * }
     */
    public static int migraphx_use_native_calibration_table(MemorySegment struct) {
        return struct.get(migraphx_use_native_calibration_table$LAYOUT, migraphx_use_native_calibration_table$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int migraphx_use_native_calibration_table
     * }
     */
    public static void migraphx_use_native_calibration_table(MemorySegment struct, int fieldValue) {
        struct.set(
                migraphx_use_native_calibration_table$LAYOUT, migraphx_use_native_calibration_table$OFFSET, fieldValue);
    }

    private static final AddressLayout migraphx_int8_calibration_table_name$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("migraphx_int8_calibration_table_name"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *migraphx_int8_calibration_table_name
     * }
     */
    public static final AddressLayout migraphx_int8_calibration_table_name$layout() {
        return migraphx_int8_calibration_table_name$LAYOUT;
    }

    private static final long migraphx_int8_calibration_table_name$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *migraphx_int8_calibration_table_name
     * }
     */
    public static final long migraphx_int8_calibration_table_name$offset() {
        return migraphx_int8_calibration_table_name$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *migraphx_int8_calibration_table_name
     * }
     */
    public static MemorySegment migraphx_int8_calibration_table_name(MemorySegment struct) {
        return struct.get(migraphx_int8_calibration_table_name$LAYOUT, migraphx_int8_calibration_table_name$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *migraphx_int8_calibration_table_name
     * }
     */
    public static void migraphx_int8_calibration_table_name(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                migraphx_int8_calibration_table_name$LAYOUT, migraphx_int8_calibration_table_name$OFFSET, fieldValue);
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
