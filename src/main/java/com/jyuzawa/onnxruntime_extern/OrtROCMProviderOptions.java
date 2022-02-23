/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtROCMProviderOptions {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_INT.withName("device_id"),
                    C_INT.withName("miopen_conv_exhaustive_search"),
                    C_LONG.withName("gpu_mem_limit"),
                    C_INT.withName("arena_extend_strategy"),
                    C_INT.withName("do_copy_in_default_stream"),
                    C_INT.withName("has_user_compute_stream"),
                    MemoryLayout.paddingLayout(32),
                    C_POINTER.withName("user_compute_stream"),
                    C_POINTER.withName("default_memory_arena_cfg"))
            .withName("OrtROCMProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtROCMProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_id$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtROCMProviderOptions.device_id$VH;
    }

    public static int device_id$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.device_id$VH.get(seg);
    }

    public static void device_id$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.device_id$VH.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle miopen_conv_exhaustive_search$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("miopen_conv_exhaustive_search"));

    public static VarHandle miopen_conv_exhaustive_search$VH() {
        return OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH;
    }

    public static int miopen_conv_exhaustive_search$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH.get(seg);
    }

    public static void miopen_conv_exhaustive_search$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH.set(seg, x);
    }

    public static int miopen_conv_exhaustive_search$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void miopen_conv_exhaustive_search$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle gpu_mem_limit$VH =
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("gpu_mem_limit"));

    public static VarHandle gpu_mem_limit$VH() {
        return OrtROCMProviderOptions.gpu_mem_limit$VH;
    }

    public static long gpu_mem_limit$get(MemorySegment seg) {
        return (long) OrtROCMProviderOptions.gpu_mem_limit$VH.get(seg);
    }

    public static void gpu_mem_limit$set(MemorySegment seg, long x) {
        OrtROCMProviderOptions.gpu_mem_limit$VH.set(seg, x);
    }

    public static long gpu_mem_limit$get(MemorySegment seg, long index) {
        return (long) OrtROCMProviderOptions.gpu_mem_limit$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void gpu_mem_limit$set(MemorySegment seg, long index, long x) {
        OrtROCMProviderOptions.gpu_mem_limit$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle arena_extend_strategy$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("arena_extend_strategy"));

    public static VarHandle arena_extend_strategy$VH() {
        return OrtROCMProviderOptions.arena_extend_strategy$VH;
    }

    public static int arena_extend_strategy$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.arena_extend_strategy$VH.get(seg);
    }

    public static void arena_extend_strategy$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.arena_extend_strategy$VH.set(seg, x);
    }

    public static int arena_extend_strategy$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.arena_extend_strategy$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void arena_extend_strategy$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.arena_extend_strategy$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle do_copy_in_default_stream$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("do_copy_in_default_stream"));

    public static VarHandle do_copy_in_default_stream$VH() {
        return OrtROCMProviderOptions.do_copy_in_default_stream$VH;
    }

    public static int do_copy_in_default_stream$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.do_copy_in_default_stream$VH.get(seg);
    }

    public static void do_copy_in_default_stream$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.do_copy_in_default_stream$VH.set(seg, x);
    }

    public static int do_copy_in_default_stream$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.do_copy_in_default_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void do_copy_in_default_stream$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.do_copy_in_default_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle has_user_compute_stream$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("has_user_compute_stream"));

    public static VarHandle has_user_compute_stream$VH() {
        return OrtROCMProviderOptions.has_user_compute_stream$VH;
    }

    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.has_user_compute_stream$VH.get(seg);
    }

    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.has_user_compute_stream$VH.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.has_user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.has_user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle user_compute_stream$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("user_compute_stream")));

    public static VarHandle user_compute_stream$VH() {
        return OrtROCMProviderOptions.user_compute_stream$VH;
    }

    public static MemoryAddress user_compute_stream$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtROCMProviderOptions.user_compute_stream$VH.get(seg);
    }

    public static void user_compute_stream$set(MemorySegment seg, MemoryAddress x) {
        OrtROCMProviderOptions.user_compute_stream$VH.set(seg, x);
    }

    public static MemoryAddress user_compute_stream$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtROCMProviderOptions.user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtROCMProviderOptions.user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle default_memory_arena_cfg$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("default_memory_arena_cfg")));

    public static VarHandle default_memory_arena_cfg$VH() {
        return OrtROCMProviderOptions.default_memory_arena_cfg$VH;
    }

    public static MemoryAddress default_memory_arena_cfg$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtROCMProviderOptions.default_memory_arena_cfg$VH.get(seg);
    }

    public static void default_memory_arena_cfg$set(MemorySegment seg, MemoryAddress x) {
        OrtROCMProviderOptions.default_memory_arena_cfg$VH.set(seg, x);
    }

    public static MemoryAddress default_memory_arena_cfg$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtROCMProviderOptions.default_memory_arena_cfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void default_memory_arena_cfg$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtROCMProviderOptions.default_memory_arena_cfg$VH.set(seg.asSlice(index * sizeof()), x);
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
