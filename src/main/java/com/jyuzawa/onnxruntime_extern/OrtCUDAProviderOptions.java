/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtCUDAProviderOptions {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_INT.withName("device_id"),
                    C_INT.withName("cudnn_conv_algo_search"),
                    C_LONG_LONG.withName("gpu_mem_limit"),
                    C_INT.withName("arena_extend_strategy"),
                    C_INT.withName("do_copy_in_default_stream"),
                    C_INT.withName("has_user_compute_stream"),
                    MemoryLayout.paddingLayout(32),
                    C_POINTER.withName("user_compute_stream"),
                    C_POINTER.withName("default_memory_arena_cfg"))
            .withName("OrtCUDAProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtCUDAProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_id$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtCUDAProviderOptions.device_id$VH;
    }

    public static int device_id$get(MemorySegment seg) {
        return (int) OrtCUDAProviderOptions.device_id$VH.get(seg);
    }

    public static void device_id$set(MemorySegment seg, int x) {
        OrtCUDAProviderOptions.device_id$VH.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) OrtCUDAProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        OrtCUDAProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle cudnn_conv_algo_search$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("cudnn_conv_algo_search"));

    public static VarHandle cudnn_conv_algo_search$VH() {
        return OrtCUDAProviderOptions.cudnn_conv_algo_search$VH;
    }

    public static int cudnn_conv_algo_search$get(MemorySegment seg) {
        return (int) OrtCUDAProviderOptions.cudnn_conv_algo_search$VH.get(seg);
    }

    public static void cudnn_conv_algo_search$set(MemorySegment seg, int x) {
        OrtCUDAProviderOptions.cudnn_conv_algo_search$VH.set(seg, x);
    }

    public static int cudnn_conv_algo_search$get(MemorySegment seg, long index) {
        return (int) OrtCUDAProviderOptions.cudnn_conv_algo_search$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void cudnn_conv_algo_search$set(MemorySegment seg, long index, int x) {
        OrtCUDAProviderOptions.cudnn_conv_algo_search$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle gpu_mem_limit$VH =
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("gpu_mem_limit"));

    public static VarHandle gpu_mem_limit$VH() {
        return OrtCUDAProviderOptions.gpu_mem_limit$VH;
    }

    public static long gpu_mem_limit$get(MemorySegment seg) {
        return (long) OrtCUDAProviderOptions.gpu_mem_limit$VH.get(seg);
    }

    public static void gpu_mem_limit$set(MemorySegment seg, long x) {
        OrtCUDAProviderOptions.gpu_mem_limit$VH.set(seg, x);
    }

    public static long gpu_mem_limit$get(MemorySegment seg, long index) {
        return (long) OrtCUDAProviderOptions.gpu_mem_limit$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void gpu_mem_limit$set(MemorySegment seg, long index, long x) {
        OrtCUDAProviderOptions.gpu_mem_limit$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle arena_extend_strategy$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("arena_extend_strategy"));

    public static VarHandle arena_extend_strategy$VH() {
        return OrtCUDAProviderOptions.arena_extend_strategy$VH;
    }

    public static int arena_extend_strategy$get(MemorySegment seg) {
        return (int) OrtCUDAProviderOptions.arena_extend_strategy$VH.get(seg);
    }

    public static void arena_extend_strategy$set(MemorySegment seg, int x) {
        OrtCUDAProviderOptions.arena_extend_strategy$VH.set(seg, x);
    }

    public static int arena_extend_strategy$get(MemorySegment seg, long index) {
        return (int) OrtCUDAProviderOptions.arena_extend_strategy$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void arena_extend_strategy$set(MemorySegment seg, long index, int x) {
        OrtCUDAProviderOptions.arena_extend_strategy$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle do_copy_in_default_stream$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("do_copy_in_default_stream"));

    public static VarHandle do_copy_in_default_stream$VH() {
        return OrtCUDAProviderOptions.do_copy_in_default_stream$VH;
    }

    public static int do_copy_in_default_stream$get(MemorySegment seg) {
        return (int) OrtCUDAProviderOptions.do_copy_in_default_stream$VH.get(seg);
    }

    public static void do_copy_in_default_stream$set(MemorySegment seg, int x) {
        OrtCUDAProviderOptions.do_copy_in_default_stream$VH.set(seg, x);
    }

    public static int do_copy_in_default_stream$get(MemorySegment seg, long index) {
        return (int) OrtCUDAProviderOptions.do_copy_in_default_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void do_copy_in_default_stream$set(MemorySegment seg, long index, int x) {
        OrtCUDAProviderOptions.do_copy_in_default_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle has_user_compute_stream$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("has_user_compute_stream"));

    public static VarHandle has_user_compute_stream$VH() {
        return OrtCUDAProviderOptions.has_user_compute_stream$VH;
    }

    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) OrtCUDAProviderOptions.has_user_compute_stream$VH.get(seg);
    }

    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        OrtCUDAProviderOptions.has_user_compute_stream$VH.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) OrtCUDAProviderOptions.has_user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        OrtCUDAProviderOptions.has_user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle user_compute_stream$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("user_compute_stream")));

    public static VarHandle user_compute_stream$VH() {
        return OrtCUDAProviderOptions.user_compute_stream$VH;
    }

    public static MemoryAddress user_compute_stream$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCUDAProviderOptions.user_compute_stream$VH.get(seg);
    }

    public static void user_compute_stream$set(MemorySegment seg, MemoryAddress x) {
        OrtCUDAProviderOptions.user_compute_stream$VH.set(seg, x);
    }

    public static MemoryAddress user_compute_stream$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCUDAProviderOptions.user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCUDAProviderOptions.user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle default_memory_arena_cfg$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("default_memory_arena_cfg")));

    public static VarHandle default_memory_arena_cfg$VH() {
        return OrtCUDAProviderOptions.default_memory_arena_cfg$VH;
    }

    public static MemoryAddress default_memory_arena_cfg$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCUDAProviderOptions.default_memory_arena_cfg$VH.get(seg);
    }

    public static void default_memory_arena_cfg$set(MemorySegment seg, MemoryAddress x) {
        OrtCUDAProviderOptions.default_memory_arena_cfg$VH.set(seg, x);
    }

    public static MemoryAddress default_memory_arena_cfg$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCUDAProviderOptions.default_memory_arena_cfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void default_memory_arena_cfg$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCUDAProviderOptions.default_memory_arena_cfg$VH.set(seg.asSlice(index * sizeof()), x);
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
