/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

public class OrtOpenVINOProviderOptions {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_POINTER$LAYOUT.withName("device_type"),
                    Constants$root.C_CHAR$LAYOUT.withName("enable_npu_fast_compile"),
                    MemoryLayout.paddingLayout(56),
                    Constants$root.C_POINTER$LAYOUT.withName("device_id"),
                    Constants$root.C_LONG_LONG$LAYOUT.withName("num_of_threads"),
                    Constants$root.C_POINTER$LAYOUT.withName("cache_dir"),
                    Constants$root.C_POINTER$LAYOUT.withName("context"),
                    Constants$root.C_CHAR$LAYOUT.withName("enable_opencl_throttling"),
                    Constants$root.C_CHAR$LAYOUT.withName("enable_dynamic_shapes"),
                    MemoryLayout.paddingLayout(48))
            .withName("OrtOpenVINOProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtOpenVINOProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_type$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("device_type"));

    public static VarHandle device_type$VH() {
        return OrtOpenVINOProviderOptions.device_type$VH;
    }

    public static MemoryAddress device_type$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtOpenVINOProviderOptions.device_type$VH.get(seg);
    }

    public static void device_type$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_type$VH.set(seg, x);
    }

    public static MemoryAddress device_type$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.device_type$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_type$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_type$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle enable_npu_fast_compile$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("enable_npu_fast_compile"));

    public static VarHandle enable_npu_fast_compile$VH() {
        return OrtOpenVINOProviderOptions.enable_npu_fast_compile$VH;
    }

    public static byte enable_npu_fast_compile$get(MemorySegment seg) {
        return (byte) OrtOpenVINOProviderOptions.enable_npu_fast_compile$VH.get(seg);
    }

    public static void enable_npu_fast_compile$set(MemorySegment seg, byte x) {
        OrtOpenVINOProviderOptions.enable_npu_fast_compile$VH.set(seg, x);
    }

    public static byte enable_npu_fast_compile$get(MemorySegment seg, long index) {
        return (byte) OrtOpenVINOProviderOptions.enable_npu_fast_compile$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void enable_npu_fast_compile$set(MemorySegment seg, long index, byte x) {
        OrtOpenVINOProviderOptions.enable_npu_fast_compile$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle device_id$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtOpenVINOProviderOptions.device_id$VH;
    }

    public static MemoryAddress device_id$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtOpenVINOProviderOptions.device_id$VH.get(seg);
    }

    public static void device_id$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_id$VH.set(seg, x);
    }

    public static MemoryAddress device_id$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle num_of_threads$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("num_of_threads"));

    public static VarHandle num_of_threads$VH() {
        return OrtOpenVINOProviderOptions.num_of_threads$VH;
    }

    public static long num_of_threads$get(MemorySegment seg) {
        return (long) OrtOpenVINOProviderOptions.num_of_threads$VH.get(seg);
    }

    public static void num_of_threads$set(MemorySegment seg, long x) {
        OrtOpenVINOProviderOptions.num_of_threads$VH.set(seg, x);
    }

    public static long num_of_threads$get(MemorySegment seg, long index) {
        return (long) OrtOpenVINOProviderOptions.num_of_threads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void num_of_threads$set(MemorySegment seg, long index, long x) {
        OrtOpenVINOProviderOptions.num_of_threads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle cache_dir$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("cache_dir"));

    public static VarHandle cache_dir$VH() {
        return OrtOpenVINOProviderOptions.cache_dir$VH;
    }

    public static MemoryAddress cache_dir$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtOpenVINOProviderOptions.cache_dir$VH.get(seg);
    }

    public static void cache_dir$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.cache_dir$VH.set(seg, x);
    }

    public static MemoryAddress cache_dir$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.cache_dir$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void cache_dir$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.cache_dir$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle context$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("context"));

    public static VarHandle context$VH() {
        return OrtOpenVINOProviderOptions.context$VH;
    }

    public static MemoryAddress context$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtOpenVINOProviderOptions.context$VH.get(seg);
    }

    public static void context$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.context$VH.set(seg, x);
    }

    public static MemoryAddress context$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.context$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void context$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.context$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle enable_opencl_throttling$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("enable_opencl_throttling"));

    public static VarHandle enable_opencl_throttling$VH() {
        return OrtOpenVINOProviderOptions.enable_opencl_throttling$VH;
    }

    public static byte enable_opencl_throttling$get(MemorySegment seg) {
        return (byte) OrtOpenVINOProviderOptions.enable_opencl_throttling$VH.get(seg);
    }

    public static void enable_opencl_throttling$set(MemorySegment seg, byte x) {
        OrtOpenVINOProviderOptions.enable_opencl_throttling$VH.set(seg, x);
    }

    public static byte enable_opencl_throttling$get(MemorySegment seg, long index) {
        return (byte) OrtOpenVINOProviderOptions.enable_opencl_throttling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void enable_opencl_throttling$set(MemorySegment seg, long index, byte x) {
        OrtOpenVINOProviderOptions.enable_opencl_throttling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle enable_dynamic_shapes$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("enable_dynamic_shapes"));

    public static VarHandle enable_dynamic_shapes$VH() {
        return OrtOpenVINOProviderOptions.enable_dynamic_shapes$VH;
    }

    public static byte enable_dynamic_shapes$get(MemorySegment seg) {
        return (byte) OrtOpenVINOProviderOptions.enable_dynamic_shapes$VH.get(seg);
    }

    public static void enable_dynamic_shapes$set(MemorySegment seg, byte x) {
        OrtOpenVINOProviderOptions.enable_dynamic_shapes$VH.set(seg, x);
    }

    public static byte enable_dynamic_shapes$get(MemorySegment seg, long index) {
        return (byte) OrtOpenVINOProviderOptions.enable_dynamic_shapes$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void enable_dynamic_shapes$set(MemorySegment seg, long index, byte x) {
        OrtOpenVINOProviderOptions.enable_dynamic_shapes$VH.set(seg.asSlice(index * sizeof()), x);
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
