/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

public class OrtCustomHandleType {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_CHAR$LAYOUT.withName("__place_holder"))
            .withName("OrtCustomHandleType");

    public static MemoryLayout $LAYOUT() {
        return OrtCustomHandleType.$struct$LAYOUT;
    }

    static final VarHandle __place_holder$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("__place_holder"));

    public static VarHandle __place_holder$VH() {
        return OrtCustomHandleType.__place_holder$VH;
    }

    public static byte __place_holder$get(MemorySegment seg) {
        return (byte) OrtCustomHandleType.__place_holder$VH.get(seg);
    }

    public static void __place_holder$set(MemorySegment seg, byte x) {
        OrtCustomHandleType.__place_holder$VH.set(seg, x);
    }

    public static byte __place_holder$get(MemorySegment seg, long index) {
        return (byte) OrtCustomHandleType.__place_holder$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void __place_holder$set(MemorySegment seg, long index, byte x) {
        OrtCustomHandleType.__place_holder$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session);
    }
}
