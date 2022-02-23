/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtTensorRTProviderOptions {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_INT.withName("device_id"),
                    C_INT.withName("has_user_compute_stream"),
                    C_POINTER.withName("user_compute_stream"),
                    C_INT.withName("trt_max_partition_iterations"),
                    C_INT.withName("trt_min_subgraph_size"),
                    C_LONG.withName("trt_max_workspace_size"),
                    C_INT.withName("trt_fp16_enable"),
                    C_INT.withName("trt_int8_enable"),
                    C_POINTER.withName("trt_int8_calibration_table_name"),
                    C_INT.withName("trt_int8_use_native_calibration_table"),
                    C_INT.withName("trt_dla_enable"),
                    C_INT.withName("trt_dla_core"),
                    C_INT.withName("trt_dump_subgraphs"),
                    C_INT.withName("trt_engine_cache_enable"),
                    MemoryLayout.paddingLayout(32),
                    C_POINTER.withName("trt_engine_cache_path"),
                    C_INT.withName("trt_engine_decryption_enable"),
                    MemoryLayout.paddingLayout(32),
                    C_POINTER.withName("trt_engine_decryption_lib_path"),
                    C_INT.withName("trt_force_sequential_engine_build"),
                    MemoryLayout.paddingLayout(32))
            .withName("OrtTensorRTProviderOptions");

    public static MemoryLayout $LAYOUT() {
        return OrtTensorRTProviderOptions.$struct$LAYOUT;
    }

    static final VarHandle device_id$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("device_id"));

    public static VarHandle device_id$VH() {
        return OrtTensorRTProviderOptions.device_id$VH;
    }

    public static int device_id$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.device_id$VH.get(seg);
    }

    public static void device_id$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.device_id$VH.set(seg, x);
    }

    public static int device_id$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.device_id$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void device_id$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.device_id$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle has_user_compute_stream$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("has_user_compute_stream"));

    public static VarHandle has_user_compute_stream$VH() {
        return OrtTensorRTProviderOptions.has_user_compute_stream$VH;
    }

    public static int has_user_compute_stream$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.has_user_compute_stream$VH.get(seg);
    }

    public static void has_user_compute_stream$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.has_user_compute_stream$VH.set(seg, x);
    }

    public static int has_user_compute_stream$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.has_user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void has_user_compute_stream$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.has_user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle user_compute_stream$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("user_compute_stream")));

    public static VarHandle user_compute_stream$VH() {
        return OrtTensorRTProviderOptions.user_compute_stream$VH;
    }

    public static MemoryAddress user_compute_stream$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtTensorRTProviderOptions.user_compute_stream$VH.get(seg);
    }

    public static void user_compute_stream$set(MemorySegment seg, MemoryAddress x) {
        OrtTensorRTProviderOptions.user_compute_stream$VH.set(seg, x);
    }

    public static MemoryAddress user_compute_stream$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtTensorRTProviderOptions.user_compute_stream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void user_compute_stream$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtTensorRTProviderOptions.user_compute_stream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_max_partition_iterations$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_max_partition_iterations"));

    public static VarHandle trt_max_partition_iterations$VH() {
        return OrtTensorRTProviderOptions.trt_max_partition_iterations$VH;
    }

    public static int trt_max_partition_iterations$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.get(seg);
    }

    public static void trt_max_partition_iterations$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.set(seg, x);
    }

    public static int trt_max_partition_iterations$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_max_partition_iterations$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_max_partition_iterations$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_min_subgraph_size$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_min_subgraph_size"));

    public static VarHandle trt_min_subgraph_size$VH() {
        return OrtTensorRTProviderOptions.trt_min_subgraph_size$VH;
    }

    public static int trt_min_subgraph_size$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.get(seg);
    }

    public static void trt_min_subgraph_size$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.set(seg, x);
    }

    public static int trt_min_subgraph_size$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_min_subgraph_size$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_min_subgraph_size$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_max_workspace_size$VH =
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("trt_max_workspace_size"));

    public static VarHandle trt_max_workspace_size$VH() {
        return OrtTensorRTProviderOptions.trt_max_workspace_size$VH;
    }

    public static long trt_max_workspace_size$get(MemorySegment seg) {
        return (long) OrtTensorRTProviderOptions.trt_max_workspace_size$VH.get(seg);
    }

    public static void trt_max_workspace_size$set(MemorySegment seg, long x) {
        OrtTensorRTProviderOptions.trt_max_workspace_size$VH.set(seg, x);
    }

    public static long trt_max_workspace_size$get(MemorySegment seg, long index) {
        return (long) OrtTensorRTProviderOptions.trt_max_workspace_size$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_max_workspace_size$set(MemorySegment seg, long index, long x) {
        OrtTensorRTProviderOptions.trt_max_workspace_size$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_fp16_enable$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_fp16_enable"));

    public static VarHandle trt_fp16_enable$VH() {
        return OrtTensorRTProviderOptions.trt_fp16_enable$VH;
    }

    public static int trt_fp16_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_fp16_enable$VH.get(seg);
    }

    public static void trt_fp16_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_fp16_enable$VH.set(seg, x);
    }

    public static int trt_fp16_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_fp16_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_fp16_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_fp16_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_int8_enable$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_int8_enable"));

    public static VarHandle trt_int8_enable$VH() {
        return OrtTensorRTProviderOptions.trt_int8_enable$VH;
    }

    public static int trt_int8_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_int8_enable$VH.get(seg);
    }

    public static void trt_int8_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_int8_enable$VH.set(seg, x);
    }

    public static int trt_int8_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_int8_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_int8_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_int8_calibration_table_name$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("trt_int8_calibration_table_name")));

    public static VarHandle trt_int8_calibration_table_name$VH() {
        return OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH;
    }

    public static MemoryAddress trt_int8_calibration_table_name$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.get(seg);
    }

    public static void trt_int8_calibration_table_name$set(MemorySegment seg, MemoryAddress x) {
        OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.set(seg, x);
    }

    public static MemoryAddress trt_int8_calibration_table_name$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_calibration_table_name$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtTensorRTProviderOptions.trt_int8_calibration_table_name$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_int8_use_native_calibration_table$VH = $struct$LAYOUT.varHandle(
            int.class, MemoryLayout.PathElement.groupElement("trt_int8_use_native_calibration_table"));

    public static VarHandle trt_int8_use_native_calibration_table$VH() {
        return OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH;
    }

    public static int trt_int8_use_native_calibration_table$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.get(seg);
    }

    public static void trt_int8_use_native_calibration_table$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.set(seg, x);
    }

    public static int trt_int8_use_native_calibration_table$get(MemorySegment seg, long index) {
        return (int)
                OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_int8_use_native_calibration_table$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_int8_use_native_calibration_table$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_dla_enable$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_dla_enable"));

    public static VarHandle trt_dla_enable$VH() {
        return OrtTensorRTProviderOptions.trt_dla_enable$VH;
    }

    public static int trt_dla_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_dla_enable$VH.get(seg);
    }

    public static void trt_dla_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_dla_enable$VH.set(seg, x);
    }

    public static int trt_dla_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_dla_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dla_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_dla_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_dla_core$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_dla_core"));

    public static VarHandle trt_dla_core$VH() {
        return OrtTensorRTProviderOptions.trt_dla_core$VH;
    }

    public static int trt_dla_core$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_dla_core$VH.get(seg);
    }

    public static void trt_dla_core$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_dla_core$VH.set(seg, x);
    }

    public static int trt_dla_core$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_dla_core$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dla_core$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_dla_core$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_dump_subgraphs$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_dump_subgraphs"));

    public static VarHandle trt_dump_subgraphs$VH() {
        return OrtTensorRTProviderOptions.trt_dump_subgraphs$VH;
    }

    public static int trt_dump_subgraphs$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.get(seg);
    }

    public static void trt_dump_subgraphs$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.set(seg, x);
    }

    public static int trt_dump_subgraphs$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_dump_subgraphs$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_dump_subgraphs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_cache_enable$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_engine_cache_enable"));

    public static VarHandle trt_engine_cache_enable$VH() {
        return OrtTensorRTProviderOptions.trt_engine_cache_enable$VH;
    }

    public static int trt_engine_cache_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.get(seg);
    }

    public static void trt_engine_cache_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.set(seg, x);
    }

    public static int trt_engine_cache_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_cache_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_engine_cache_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_cache_path$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("trt_engine_cache_path")));

    public static VarHandle trt_engine_cache_path$VH() {
        return OrtTensorRTProviderOptions.trt_engine_cache_path$VH;
    }

    public static MemoryAddress trt_engine_cache_path$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtTensorRTProviderOptions.trt_engine_cache_path$VH.get(seg);
    }

    public static void trt_engine_cache_path$set(MemorySegment seg, MemoryAddress x) {
        OrtTensorRTProviderOptions.trt_engine_cache_path$VH.set(seg, x);
    }

    public static MemoryAddress trt_engine_cache_path$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtTensorRTProviderOptions.trt_engine_cache_path$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_cache_path$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtTensorRTProviderOptions.trt_engine_cache_path$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_decryption_enable$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("trt_engine_decryption_enable"));

    public static VarHandle trt_engine_decryption_enable$VH() {
        return OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH;
    }

    public static int trt_engine_decryption_enable$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.get(seg);
    }

    public static void trt_engine_decryption_enable$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.set(seg, x);
    }

    public static int trt_engine_decryption_enable$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_decryption_enable$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_enable$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_engine_decryption_lib_path$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("trt_engine_decryption_lib_path")));

    public static VarHandle trt_engine_decryption_lib_path$VH() {
        return OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH;
    }

    public static MemoryAddress trt_engine_decryption_lib_path$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.get(seg);
    }

    public static void trt_engine_decryption_lib_path$set(MemorySegment seg, MemoryAddress x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.set(seg, x);
    }

    public static MemoryAddress trt_engine_decryption_lib_path$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_engine_decryption_lib_path$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtTensorRTProviderOptions.trt_engine_decryption_lib_path$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final VarHandle trt_force_sequential_engine_build$VH = $struct$LAYOUT.varHandle(
            int.class, MemoryLayout.PathElement.groupElement("trt_force_sequential_engine_build"));

    public static VarHandle trt_force_sequential_engine_build$VH() {
        return OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH;
    }

    public static int trt_force_sequential_engine_build$get(MemorySegment seg) {
        return (int) OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.get(seg);
    }

    public static void trt_force_sequential_engine_build$set(MemorySegment seg, int x) {
        OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.set(seg, x);
    }

    public static int trt_force_sequential_engine_build$get(MemorySegment seg, long index) {
        return (int) OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void trt_force_sequential_engine_build$set(MemorySegment seg, long index, int x) {
        OrtTensorRTProviderOptions.trt_force_sequential_engine_build$VH.set(seg.asSlice(index * sizeof()), x);
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
