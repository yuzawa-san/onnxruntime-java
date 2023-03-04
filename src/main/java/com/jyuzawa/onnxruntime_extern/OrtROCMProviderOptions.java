/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtROCMProviderOptions {
 *     int device_id;
 *     int miopen_conv_exhaustive_search;
 *     size_t gpu_mem_limit;
 *     int arena_extend_strategy;
 *     int do_copy_in_default_stream;
 *     int has_user_compute_stream;
 *     void* user_compute_stream;
 *     OrtArenaCfg* default_memory_arena_cfg;
 * };
 * }
 */
public class OrtROCMProviderOptions {

    static final StructLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_INT$LAYOUT.withName("device_id"),
                    Constants$root.C_INT$LAYOUT.withName("miopen_conv_exhaustive_search"),
                    Constants$root.C_LONG_LONG$LAYOUT.withName("gpu_mem_limit"),
                    Constants$root.C_INT$LAYOUT.withName("arena_extend_strategy"),
                    Constants$root.C_INT$LAYOUT.withName("do_copy_in_default_stream"),
                    Constants$root.C_INT$LAYOUT.withName("has_user_compute_stream"),
                    MemoryLayout.paddingLayout(32),
                    Constants$root.C_POINTER$LAYOUT.withName("user_compute_stream"),
                    Constants$root.C_POINTER$LAYOUT.withName("default_memory_arena_cfg"),
                    Constants$root.C_INT$LAYOUT.withName("tunable_op_enabled"),
                    MemoryLayout.paddingLayout(32))
            .withName("OrtROCMProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtROCMProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_id$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtROCMProviderOptions.device_id$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int device_id;
     * }
     */
    public static int device_id$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.device_id$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int device_id;
     * }
     */
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
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("miopen_conv_exhaustive_search"));

    public static VarHandle miopen_conv_exhaustive_search$VH() {
        return OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int miopen_conv_exhaustive_search;
     * }
     */
    public static int miopen_conv_exhaustive_search$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.miopen_conv_exhaustive_search$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int miopen_conv_exhaustive_search;
     * }
     */
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
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("gpu_mem_limit"));

    public static VarHandle gpu_mem_limit$VH() {
        return OrtROCMProviderOptions.gpu_mem_limit$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t gpu_mem_limit;
     * }
     */
    public static long gpu_mem_limit$get(MemorySegment seg) {
        return (long) OrtROCMProviderOptions.gpu_mem_limit$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t gpu_mem_limit;
     * }
     */
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
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("arena_extend_strategy"));

    public static VarHandle arena_extend_strategy$VH() {
        return OrtROCMProviderOptions.arena_extend_strategy$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int arena_extend_strategy;
     * }
     */
    public static int arena_extend_strategy$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.arena_extend_strategy$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int arena_extend_strategy;
     * }
     */
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
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("do_copy_in_default_stream"));

    public static VarHandle do_copy_in_default_stream$VH() {
        return OrtROCMProviderOptions.do_copy_in_default_stream$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int do_copy_in_default_stream;
     * }
     */
    public static int do_copy_in_default_stream$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.do_copy_in_default_stream$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int do_copy_in_default_stream;
     * }
     */
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
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("has_user_compute_stream"));

    public static VarHandle has_user_compute_stream$VH() {
        return OrtROCMProviderOptions.has_user_compute_stream$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.has_user_compute_stream$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int has_user_compute_stream;
     * }
     */
    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.has_user_compute_stream$VH.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.has_user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.has_user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle user_compute_stream$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("user_compute_stream"));

    public static VarHandle user_compute_stream$VH() {
        return OrtROCMProviderOptions.user_compute_stream$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static MemorySegment user_compute_stream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtROCMProviderOptions.user_compute_stream$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* user_compute_stream;
     * }
     */
    public static void user_compute_stream$set(MemorySegment seg, MemorySegment x) {
        OrtROCMProviderOptions.user_compute_stream$VH.set(seg, x);
    }

    public static MemorySegment user_compute_stream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtROCMProviderOptions.user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemorySegment x) {
        OrtROCMProviderOptions.user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle default_memory_arena_cfg$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("default_memory_arena_cfg"));

    public static VarHandle default_memory_arena_cfg$VH() {
        return OrtROCMProviderOptions.default_memory_arena_cfg$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtArenaCfg* default_memory_arena_cfg;
     * }
     */
    public static MemorySegment default_memory_arena_cfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtROCMProviderOptions.default_memory_arena_cfg$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtArenaCfg* default_memory_arena_cfg;
     * }
     */
    public static void default_memory_arena_cfg$set(MemorySegment seg, MemorySegment x) {
        OrtROCMProviderOptions.default_memory_arena_cfg$VH.set(seg, x);
    }

    public static MemorySegment default_memory_arena_cfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtROCMProviderOptions.default_memory_arena_cfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void default_memory_arena_cfg$set(MemorySegment seg, long index, MemorySegment x) {
        OrtROCMProviderOptions.default_memory_arena_cfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle tunable_op_enabled$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_enabled"));

    public static VarHandle tunable_op_enabled$VH() {
        return OrtROCMProviderOptions.tunable_op_enabled$VH;
    }

    public static int tunable_op_enabled$get(MemorySegment seg) {
        return (int) OrtROCMProviderOptions.tunable_op_enabled$VH.get(seg);
    }

    public static void tunable_op_enabled$set(MemorySegment seg, int x) {
        OrtROCMProviderOptions.tunable_op_enabled$VH.set(seg, x);
    }

    public static int tunable_op_enabled$get(MemorySegment seg, long index) {
        return (int) OrtROCMProviderOptions.tunable_op_enabled$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void tunable_op_enabled$set(MemorySegment seg, long index, int x) {
        OrtROCMProviderOptions.tunable_op_enabled$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemorySegment addr, MemorySession session) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session);
    }
}
