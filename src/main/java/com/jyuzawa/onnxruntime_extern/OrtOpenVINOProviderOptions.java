/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtOpenVINOProviderOptions {
 *     char* device_type;
 *     unsigned char enable_npu_fast_compile;
 *     char* device_id;
 *     size_t num_of_threads;
 *     char* cache_dir;
 *     void* context;
 *     unsigned char enable_opencl_throttling;
 *     unsigned char enable_dynamic_shapes;
 * };
 * }
 */
public class OrtOpenVINOProviderOptions {

    public static MemoryLayout $LAYOUT() {
        return constants$11.const$0;
    }

    public static VarHandle device_type$VH() {
        return constants$11.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* device_type;
     * }
     */
    public static MemorySegment device_type$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$11.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* device_type;
     * }
     */
    public static void device_type$set(MemorySegment seg, MemorySegment x) {
        constants$11.const$1.set(seg, 0L, x);
    }

    public static MemorySegment device_type$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$11.const$1.get(seg, index * sizeof());
    }

    public static void device_type$set(MemorySegment seg, long index, MemorySegment x) {
        constants$11.const$1.set(seg, index * sizeof(), x);
    }

    public static VarHandle enable_npu_fast_compile$VH() {
        return constants$11.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char enable_npu_fast_compile;
     * }
     */
    public static byte enable_npu_fast_compile$get(MemorySegment seg) {
        return (byte) constants$11.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char enable_npu_fast_compile;
     * }
     */
    public static void enable_npu_fast_compile$set(MemorySegment seg, byte x) {
        constants$11.const$2.set(seg, 0L, x);
    }

    public static byte enable_npu_fast_compile$get(MemorySegment seg, long index) {
        return (byte) constants$11.const$2.get(seg, index * sizeof());
    }

    public static void enable_npu_fast_compile$set(MemorySegment seg, long index, byte x) {
        constants$11.const$2.set(seg, index * sizeof(), x);
    }

    public static VarHandle device_id$VH() {
        return constants$11.const$3;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* device_id;
     * }
     */
    public static MemorySegment device_id$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$11.const$3.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* device_id;
     * }
     */
    public static void device_id$set(MemorySegment seg, MemorySegment x) {
        constants$11.const$3.set(seg, 0L, x);
    }

    public static MemorySegment device_id$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$11.const$3.get(seg, index * sizeof());
    }

    public static void device_id$set(MemorySegment seg, long index, MemorySegment x) {
        constants$11.const$3.set(seg, index * sizeof(), x);
    }

    public static VarHandle num_of_threads$VH() {
        return constants$11.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t num_of_threads;
     * }
     */
    public static long num_of_threads$get(MemorySegment seg) {
        return (long) constants$11.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t num_of_threads;
     * }
     */
    public static void num_of_threads$set(MemorySegment seg, long x) {
        constants$11.const$4.set(seg, 0L, x);
    }

    public static long num_of_threads$get(MemorySegment seg, long index) {
        return (long) constants$11.const$4.get(seg, index * sizeof());
    }

    public static void num_of_threads$set(MemorySegment seg, long index, long x) {
        constants$11.const$4.set(seg, index * sizeof(), x);
    }

    public static VarHandle cache_dir$VH() {
        return constants$11.const$5;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* cache_dir;
     * }
     */
    public static MemorySegment cache_dir$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$11.const$5.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* cache_dir;
     * }
     */
    public static void cache_dir$set(MemorySegment seg, MemorySegment x) {
        constants$11.const$5.set(seg, 0L, x);
    }

    public static MemorySegment cache_dir$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$11.const$5.get(seg, index * sizeof());
    }

    public static void cache_dir$set(MemorySegment seg, long index, MemorySegment x) {
        constants$11.const$5.set(seg, index * sizeof(), x);
    }

    public static VarHandle context$VH() {
        return constants$12.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* context;
     * }
     */
    public static MemorySegment context$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$12.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* context;
     * }
     */
    public static void context$set(MemorySegment seg, MemorySegment x) {
        constants$12.const$0.set(seg, 0L, x);
    }

    public static MemorySegment context$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$12.const$0.get(seg, index * sizeof());
    }

    public static void context$set(MemorySegment seg, long index, MemorySegment x) {
        constants$12.const$0.set(seg, index * sizeof(), x);
    }

    public static VarHandle enable_opencl_throttling$VH() {
        return constants$12.const$1;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char enable_opencl_throttling;
     * }
     */
    public static byte enable_opencl_throttling$get(MemorySegment seg) {
        return (byte) constants$12.const$1.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char enable_opencl_throttling;
     * }
     */
    public static void enable_opencl_throttling$set(MemorySegment seg, byte x) {
        constants$12.const$1.set(seg, 0L, x);
    }

    public static byte enable_opencl_throttling$get(MemorySegment seg, long index) {
        return (byte) constants$12.const$1.get(seg, index * sizeof());
    }

    public static void enable_opencl_throttling$set(MemorySegment seg, long index, byte x) {
        constants$12.const$1.set(seg, index * sizeof(), x);
    }

    public static VarHandle enable_dynamic_shapes$VH() {
        return constants$12.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * unsigned char enable_dynamic_shapes;
     * }
     */
    public static byte enable_dynamic_shapes$get(MemorySegment seg) {
        return (byte) constants$12.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * unsigned char enable_dynamic_shapes;
     * }
     */
    public static void enable_dynamic_shapes$set(MemorySegment seg, byte x) {
        constants$12.const$2.set(seg, 0L, x);
    }

    public static byte enable_dynamic_shapes$get(MemorySegment seg, long index) {
        return (byte) constants$12.const$2.get(seg, index * sizeof());
    }

    public static void enable_dynamic_shapes$set(MemorySegment seg, long index, byte x) {
        constants$12.const$2.set(seg, index * sizeof(), x);
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

    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
