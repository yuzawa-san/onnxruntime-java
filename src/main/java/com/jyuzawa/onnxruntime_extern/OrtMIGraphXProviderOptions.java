/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

public class OrtMIGraphXProviderOptions {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_INT$LAYOUT.withName("device_id"),
                    Constants$root.C_INT$LAYOUT.withName("migraphx_fp16_enable"),
                    Constants$root.C_INT$LAYOUT.withName("migraphx_int8_enable"))
            .withName("OrtMIGraphXProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtMIGraphXProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_id$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtMIGraphXProviderOptions.device_id$VH;
    }

    public static int device_id$get(MemorySegment seg) {
        return (int) OrtMIGraphXProviderOptions.device_id$VH.get(seg);
    }

    public static void device_id$set(MemorySegment seg, int x) {
        OrtMIGraphXProviderOptions.device_id$VH.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) OrtMIGraphXProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        OrtMIGraphXProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle migraphx_fp16_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("migraphx_fp16_enable"));

    public static VarHandle migraphx_fp16_enable$VH() {
        return OrtMIGraphXProviderOptions.migraphx_fp16_enable$VH;
    }

    public static int migraphx_fp16_enable$get(MemorySegment seg) {
        return (int) OrtMIGraphXProviderOptions.migraphx_fp16_enable$VH.get(seg);
    }

    public static void migraphx_fp16_enable$set(MemorySegment seg, int x) {
        OrtMIGraphXProviderOptions.migraphx_fp16_enable$VH.set(seg, x);
    }

    public static int migraphx_fp16_enable$get(MemorySegment seg, long index) {
        return (int) OrtMIGraphXProviderOptions.migraphx_fp16_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void migraphx_fp16_enable$set(MemorySegment seg, long index, int x) {
        OrtMIGraphXProviderOptions.migraphx_fp16_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle migraphx_int8_enable$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("migraphx_int8_enable"));

    public static VarHandle migraphx_int8_enable$VH() {
        return OrtMIGraphXProviderOptions.migraphx_int8_enable$VH;
    }

    public static int migraphx_int8_enable$get(MemorySegment seg) {
        return (int) OrtMIGraphXProviderOptions.migraphx_int8_enable$VH.get(seg);
    }

    public static void migraphx_int8_enable$set(MemorySegment seg, int x) {
        OrtMIGraphXProviderOptions.migraphx_int8_enable$VH.set(seg, x);
    }

    public static int migraphx_int8_enable$get(MemorySegment seg, long index) {
        return (int) OrtMIGraphXProviderOptions.migraphx_int8_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void migraphx_int8_enable$set(MemorySegment seg, long index, int x) {
        OrtMIGraphXProviderOptions.migraphx_int8_enable$VH.set(seg.asSlice(index * sizeof()), x);
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
