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
 * struct OrtCustomHandleType {
 *     char __place_holder;
 * }
 * }
 */
public class OrtCustomHandleType {

    OrtCustomHandleType() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_CHAR.withName("__place_holder"))
            .withName("OrtCustomHandleType");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfByte __place_holder$LAYOUT = (OfByte) $LAYOUT.select(groupElement("__place_holder"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * char __place_holder
     * }
     */
    public static final OfByte __place_holder$layout() {
        return __place_holder$LAYOUT;
    }

    private static final long __place_holder$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * char __place_holder
     * }
     */
    public static final long __place_holder$offset() {
        return __place_holder$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * char __place_holder
     * }
     */
    public static byte __place_holder(MemorySegment struct) {
        return struct.get(__place_holder$LAYOUT, __place_holder$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * char __place_holder
     * }
     */
    public static void __place_holder(MemorySegment struct, byte fieldValue) {
        struct.set(__place_holder$LAYOUT, __place_holder$OFFSET, fieldValue);
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
