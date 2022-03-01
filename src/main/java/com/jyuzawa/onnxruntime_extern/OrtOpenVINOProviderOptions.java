/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtOpenVINOProviderOptions {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_POINTER.withName("device_type"),
                    C_CHAR.withName("enable_vpu_fast_compile"),
                    MemoryLayout.paddingLayout(56),
                    C_POINTER.withName("device_id"),
                    C_LONG.withName("num_of_threads"),
                    C_CHAR.withName("use_compiled_network"),
                    MemoryLayout.paddingLayout(56),
                    C_POINTER.withName("blob_dump_path"),
                    C_POINTER.withName("context"))
            .withName("OrtOpenVINOProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtOpenVINOProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_type$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("device_type")));

    public static VarHandle device_type$VH() {
        return OrtOpenVINOProviderOptions.device_type$VH;
    }

    public static MemoryAddress device_type$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtOpenVINOProviderOptions.device_type$VH.get(seg);
    }

    public static void device_type$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_type$VH.set(seg, x);
    }

    public static MemoryAddress device_type$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.device_type$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_type$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_type$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle enable_vpu_fast_compile$VH =
            $struct$LAYOUT.varHandle(byte.class, MemoryLayout.PathElement.groupElement("enable_vpu_fast_compile"));

    public static VarHandle enable_vpu_fast_compile$VH() {
        return OrtOpenVINOProviderOptions.enable_vpu_fast_compile$VH;
    }

    public static byte enable_vpu_fast_compile$get(MemorySegment seg) {
        return (byte) OrtOpenVINOProviderOptions.enable_vpu_fast_compile$VH.get(seg);
    }

    public static void enable_vpu_fast_compile$set(MemorySegment seg, byte x) {
        OrtOpenVINOProviderOptions.enable_vpu_fast_compile$VH.set(seg, x);
    }

    public static byte enable_vpu_fast_compile$get(MemorySegment seg, long index) {
        return (byte) OrtOpenVINOProviderOptions.enable_vpu_fast_compile$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void enable_vpu_fast_compile$set(MemorySegment seg, long index, byte x) {
        OrtOpenVINOProviderOptions.enable_vpu_fast_compile$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle device_id$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("device_id")));

    public static VarHandle device_id$VH() {
        return OrtOpenVINOProviderOptions.device_id$VH;
    }

    public static MemoryAddress device_id$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtOpenVINOProviderOptions.device_id$VH.get(seg);
    }

    public static void device_id$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_id$VH.set(seg, x);
    }

    public static MemoryAddress device_id$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle num_of_threads$VH =
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("num_of_threads"));

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

    static final VarHandle use_compiled_network$VH =
            $struct$LAYOUT.varHandle(byte.class, MemoryLayout.PathElement.groupElement("use_compiled_network"));

    public static VarHandle use_compiled_network$VH() {
        return OrtOpenVINOProviderOptions.use_compiled_network$VH;
    }

    public static byte use_compiled_network$get(MemorySegment seg) {
        return (byte) OrtOpenVINOProviderOptions.use_compiled_network$VH.get(seg);
    }

    public static void use_compiled_network$set(MemorySegment seg, byte x) {
        OrtOpenVINOProviderOptions.use_compiled_network$VH.set(seg, x);
    }

    public static byte use_compiled_network$get(MemorySegment seg, long index) {
        return (byte) OrtOpenVINOProviderOptions.use_compiled_network$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void use_compiled_network$set(MemorySegment seg, long index, byte x) {
        OrtOpenVINOProviderOptions.use_compiled_network$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle blob_dump_path$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("blob_dump_path")));

    public static VarHandle blob_dump_path$VH() {
        return OrtOpenVINOProviderOptions.blob_dump_path$VH;
    }

    public static MemoryAddress blob_dump_path$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtOpenVINOProviderOptions.blob_dump_path$VH.get(seg);
    }

    public static void blob_dump_path$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.blob_dump_path$VH.set(seg, x);
    }

    public static MemoryAddress blob_dump_path$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.blob_dump_path$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void blob_dump_path$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.blob_dump_path$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle context$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("context")));

    public static VarHandle context$VH() {
        return OrtOpenVINOProviderOptions.context$VH;
    }

    public static MemoryAddress context$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtOpenVINOProviderOptions.context$VH.get(seg);
    }

    public static void context$set(MemorySegment seg, MemoryAddress x) {
        OrtOpenVINOProviderOptions.context$VH.set(seg, x);
    }

    public static MemoryAddress context$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtOpenVINOProviderOptions.context$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void context$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtOpenVINOProviderOptions.context$VH.set(seg.asSlice(index * sizeof()), x);
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
