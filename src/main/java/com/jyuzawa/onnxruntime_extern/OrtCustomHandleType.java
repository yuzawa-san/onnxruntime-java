/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtCustomHandleType {

    static final MemoryLayout $struct$LAYOUT =
            MemoryLayout.structLayout(C_CHAR.withName("__place_holder")).withName("OrtCustomHandleType");

    public static MemoryLayout $LAYOUT() {
        return OrtCustomHandleType.$struct$LAYOUT;
    }

    static final VarHandle __place_holder$VH =
            $struct$LAYOUT.varHandle(byte.class, MemoryLayout.PathElement.groupElement("__place_holder"));

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

    public static MemorySegment allocate(ResourceScope scope) {
        return allocate(SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
