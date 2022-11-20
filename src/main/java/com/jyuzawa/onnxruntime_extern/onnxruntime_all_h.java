/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class onnxruntime_all_h {

    /* package-private */ onnxruntime_all_h() {}

    public static OfByte C_CHAR = Constants$root.C_CHAR$LAYOUT;
    public static OfShort C_SHORT = Constants$root.C_SHORT$LAYOUT;
    public static OfInt C_INT = Constants$root.C_INT$LAYOUT;
    public static OfLong C_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static OfLong C_LONG_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static OfFloat C_FLOAT = Constants$root.C_FLOAT$LAYOUT;
    public static OfDouble C_DOUBLE = Constants$root.C_DOUBLE$LAYOUT;
    public static OfAddress C_POINTER = Constants$root.C_POINTER$LAYOUT;

    public static int ORT_API_VERSION() {
        return (int) 13L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED() {
        return (int) 0L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT() {
        return (int) 1L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8() {
        return (int) 2L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8() {
        return (int) 3L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16() {
        return (int) 4L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16() {
        return (int) 5L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32() {
        return (int) 6L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64() {
        return (int) 7L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING() {
        return (int) 8L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL() {
        return (int) 9L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16() {
        return (int) 10L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE() {
        return (int) 11L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32() {
        return (int) 12L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64() {
        return (int) 13L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64() {
        return (int) 14L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128() {
        return (int) 15L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16() {
        return (int) 16L;
    }

    public static int ONNX_TYPE_UNKNOWN() {
        return (int) 0L;
    }

    public static int ONNX_TYPE_TENSOR() {
        return (int) 1L;
    }

    public static int ONNX_TYPE_SEQUENCE() {
        return (int) 2L;
    }

    public static int ONNX_TYPE_MAP() {
        return (int) 3L;
    }

    public static int ONNX_TYPE_OPAQUE() {
        return (int) 4L;
    }

    public static int ONNX_TYPE_SPARSETENSOR() {
        return (int) 5L;
    }

    public static int ONNX_TYPE_OPTIONAL() {
        return (int) 6L;
    }

    public static int ORT_SPARSE_UNDEFINED() {
        return (int) 0L;
    }

    public static int ORT_SPARSE_COO() {
        return (int) 1L;
    }

    public static int ORT_SPARSE_CSRC() {
        return (int) 2L;
    }

    public static int ORT_SPARSE_BLOCK_SPARSE() {
        return (int) 4L;
    }

    public static int ORT_SPARSE_COO_INDICES() {
        return (int) 0L;
    }

    public static int ORT_SPARSE_CSR_INNER_INDICES() {
        return (int) 1L;
    }

    public static int ORT_SPARSE_CSR_OUTER_INDICES() {
        return (int) 2L;
    }

    public static int ORT_SPARSE_BLOCK_SPARSE_INDICES() {
        return (int) 3L;
    }

    public static int ORT_LOGGING_LEVEL_VERBOSE() {
        return (int) 0L;
    }

    public static int ORT_LOGGING_LEVEL_INFO() {
        return (int) 1L;
    }

    public static int ORT_LOGGING_LEVEL_WARNING() {
        return (int) 2L;
    }

    public static int ORT_LOGGING_LEVEL_ERROR() {
        return (int) 3L;
    }

    public static int ORT_LOGGING_LEVEL_FATAL() {
        return (int) 4L;
    }

    public static int ORT_OK() {
        return (int) 0L;
    }

    public static int ORT_FAIL() {
        return (int) 1L;
    }

    public static int ORT_INVALID_ARGUMENT() {
        return (int) 2L;
    }

    public static int ORT_NO_SUCHFILE() {
        return (int) 3L;
    }

    public static int ORT_NO_MODEL() {
        return (int) 4L;
    }

    public static int ORT_ENGINE_ERROR() {
        return (int) 5L;
    }

    public static int ORT_RUNTIME_EXCEPTION() {
        return (int) 6L;
    }

    public static int ORT_INVALID_PROTOBUF() {
        return (int) 7L;
    }

    public static int ORT_MODEL_LOADED() {
        return (int) 8L;
    }

    public static int ORT_NOT_IMPLEMENTED() {
        return (int) 9L;
    }

    public static int ORT_INVALID_GRAPH() {
        return (int) 10L;
    }

    public static int ORT_EP_FAIL() {
        return (int) 11L;
    }

    public static int ORT_OP_ATTR_UNDEFINED() {
        return (int) 0L;
    }

    public static int ORT_OP_ATTR_INT() {
        return (int) 1L;
    }

    public static int ORT_OP_ATTR_INTS() {
        return (int) 2L;
    }

    public static int ORT_OP_ATTR_FLOAT() {
        return (int) 3L;
    }

    public static int ORT_OP_ATTR_FLOATS() {
        return (int) 4L;
    }

    public static int ORT_OP_ATTR_STRING() {
        return (int) 5L;
    }

    public static int ORT_OP_ATTR_STRINGS() {
        return (int) 6L;
    }

    public static OfAddress OrtStatusPtr = Constants$root.C_POINTER$LAYOUT;

    public static int ORT_DISABLE_ALL() {
        return (int) 0L;
    }

    public static int ORT_ENABLE_BASIC() {
        return (int) 1L;
    }

    public static int ORT_ENABLE_EXTENDED() {
        return (int) 2L;
    }

    public static int ORT_ENABLE_ALL() {
        return (int) 99L;
    }

    public static int ORT_SEQUENTIAL() {
        return (int) 0L;
    }

    public static int ORT_PARALLEL() {
        return (int) 1L;
    }

    public static int ORT_PROJECTION_C() {
        return (int) 0L;
    }

    public static int ORT_PROJECTION_CPLUSPLUS() {
        return (int) 1L;
    }

    public static int ORT_PROJECTION_CSHARP() {
        return (int) 2L;
    }

    public static int ORT_PROJECTION_PYTHON() {
        return (int) 3L;
    }

    public static int ORT_PROJECTION_JAVA() {
        return (int) 4L;
    }

    public static int ORT_PROJECTION_WINML() {
        return (int) 5L;
    }

    public static int ORT_PROJECTION_NODEJS() {
        return (int) 6L;
    }

    public static int OrtInvalidAllocator() {
        return (int) -1L;
    }

    public static int OrtDeviceAllocator() {
        return (int) 0L;
    }

    public static int OrtArenaAllocator() {
        return (int) 1L;
    }

    public static int OrtMemTypeCPUInput() {
        return (int) -2L;
    }

    public static int OrtMemTypeCPUOutput() {
        return (int) -1L;
    }

    public static int OrtMemTypeCPU() {
        return (int) -1L;
    }

    public static int OrtMemTypeDefault() {
        return (int) 0L;
    }

    public static int OrtCudnnConvAlgoSearchExhaustive() {
        return (int) 0L;
    }

    public static int OrtCudnnConvAlgoSearchHeuristic() {
        return (int) 1L;
    }

    public static int OrtCudnnConvAlgoSearchDefault() {
        return (int) 2L;
    }

    public static MethodHandle OrtGetApiBase$MH() {
        return RuntimeHelper.requireNonNull(constants$0.OrtGetApiBase$MH, "OrtGetApiBase");
    }

    public static MemoryAddress OrtGetApiBase() {
        var mh$ = OrtGetApiBase$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact();
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static OfAddress OrtCustomThreadHandle = Constants$root.C_POINTER$LAYOUT;

    public static int INPUT_OUTPUT_REQUIRED() {
        return (int) 0L;
    }

    public static int INPUT_OUTPUT_OPTIONAL() {
        return (int) 1L;
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$MH() {
        return RuntimeHelper.requireNonNull(
                constants$1.OrtSessionOptionsAppendExecutionProvider_CUDA$MH,
                "OrtSessionOptionsAppendExecutionProvider_CUDA");
    }

    public static MemoryAddress OrtSessionOptionsAppendExecutionProvider_CUDA(Addressable options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_CUDA$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH() {
        return RuntimeHelper.requireNonNull(
                constants$1.OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH,
                "OrtSessionOptionsAppendExecutionProvider_MIGraphX");
    }

    public static MemoryAddress OrtSessionOptionsAppendExecutionProvider_MIGraphX(Addressable options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static MemoryLayout kOrtRunOptionsConfigEnableMemoryArenaShrinkage$LAYOUT() {
        return constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$LAYOUT;
    }

    public static VarHandle kOrtRunOptionsConfigEnableMemoryArenaShrinkage$VH() {
        return constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$VH;
    }

    public static MemorySegment kOrtRunOptionsConfigEnableMemoryArenaShrinkage$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$SEGMENT,
                "kOrtRunOptionsConfigEnableMemoryArenaShrinkage");
    }

    public static MemoryAddress kOrtRunOptionsConfigEnableMemoryArenaShrinkage$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$VH.get(RuntimeHelper.requireNonNull(
                        constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$SEGMENT,
                        "kOrtRunOptionsConfigEnableMemoryArenaShrinkage"));
    }

    public static void kOrtRunOptionsConfigEnableMemoryArenaShrinkage$set(MemoryAddress x) {
        constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$1.kOrtRunOptionsConfigEnableMemoryArenaShrinkage$SEGMENT,
                        "kOrtRunOptionsConfigEnableMemoryArenaShrinkage"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigDisablePrepacking$LAYOUT() {
        return constants$2.kOrtSessionOptionsConfigDisablePrepacking$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigDisablePrepacking$VH() {
        return constants$2.kOrtSessionOptionsConfigDisablePrepacking$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigDisablePrepacking$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$2.kOrtSessionOptionsConfigDisablePrepacking$SEGMENT,
                "kOrtSessionOptionsConfigDisablePrepacking");
    }

    public static MemoryAddress kOrtSessionOptionsConfigDisablePrepacking$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$2.kOrtSessionOptionsConfigDisablePrepacking$VH.get(RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigDisablePrepacking$SEGMENT,
                        "kOrtSessionOptionsConfigDisablePrepacking"));
    }

    public static void kOrtSessionOptionsConfigDisablePrepacking$set(MemoryAddress x) {
        constants$2.kOrtSessionOptionsConfigDisablePrepacking$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigDisablePrepacking$SEGMENT,
                        "kOrtSessionOptionsConfigDisablePrepacking"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigUseEnvAllocators$LAYOUT() {
        return constants$2.kOrtSessionOptionsConfigUseEnvAllocators$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigUseEnvAllocators$VH() {
        return constants$2.kOrtSessionOptionsConfigUseEnvAllocators$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigUseEnvAllocators$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$2.kOrtSessionOptionsConfigUseEnvAllocators$SEGMENT,
                "kOrtSessionOptionsConfigUseEnvAllocators");
    }

    public static MemoryAddress kOrtSessionOptionsConfigUseEnvAllocators$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$2.kOrtSessionOptionsConfigUseEnvAllocators$VH.get(RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigUseEnvAllocators$SEGMENT,
                        "kOrtSessionOptionsConfigUseEnvAllocators"));
    }

    public static void kOrtSessionOptionsConfigUseEnvAllocators$set(MemoryAddress x) {
        constants$2.kOrtSessionOptionsConfigUseEnvAllocators$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigUseEnvAllocators$SEGMENT,
                        "kOrtSessionOptionsConfigUseEnvAllocators"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigLoadModelFormat$LAYOUT() {
        return constants$2.kOrtSessionOptionsConfigLoadModelFormat$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigLoadModelFormat$VH() {
        return constants$2.kOrtSessionOptionsConfigLoadModelFormat$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigLoadModelFormat$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$2.kOrtSessionOptionsConfigLoadModelFormat$SEGMENT, "kOrtSessionOptionsConfigLoadModelFormat");
    }

    public static MemoryAddress kOrtSessionOptionsConfigLoadModelFormat$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$2.kOrtSessionOptionsConfigLoadModelFormat$VH.get(RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigLoadModelFormat$SEGMENT,
                        "kOrtSessionOptionsConfigLoadModelFormat"));
    }

    public static void kOrtSessionOptionsConfigLoadModelFormat$set(MemoryAddress x) {
        constants$2.kOrtSessionOptionsConfigLoadModelFormat$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigLoadModelFormat$SEGMENT,
                        "kOrtSessionOptionsConfigLoadModelFormat"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigSaveModelFormat$LAYOUT() {
        return constants$2.kOrtSessionOptionsConfigSaveModelFormat$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigSaveModelFormat$VH() {
        return constants$2.kOrtSessionOptionsConfigSaveModelFormat$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigSaveModelFormat$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$2.kOrtSessionOptionsConfigSaveModelFormat$SEGMENT, "kOrtSessionOptionsConfigSaveModelFormat");
    }

    public static MemoryAddress kOrtSessionOptionsConfigSaveModelFormat$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$2.kOrtSessionOptionsConfigSaveModelFormat$VH.get(RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigSaveModelFormat$SEGMENT,
                        "kOrtSessionOptionsConfigSaveModelFormat"));
    }

    public static void kOrtSessionOptionsConfigSaveModelFormat$set(MemoryAddress x) {
        constants$2.kOrtSessionOptionsConfigSaveModelFormat$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigSaveModelFormat$SEGMENT,
                        "kOrtSessionOptionsConfigSaveModelFormat"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigSetDenormalAsZero$LAYOUT() {
        return constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigSetDenormalAsZero$VH() {
        return constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigSetDenormalAsZero$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$SEGMENT,
                "kOrtSessionOptionsConfigSetDenormalAsZero");
    }

    public static MemoryAddress kOrtSessionOptionsConfigSetDenormalAsZero$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$VH.get(RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$SEGMENT,
                        "kOrtSessionOptionsConfigSetDenormalAsZero"));
    }

    public static void kOrtSessionOptionsConfigSetDenormalAsZero$set(MemoryAddress x) {
        constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$SEGMENT,
                        "kOrtSessionOptionsConfigSetDenormalAsZero"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsDisableQuantQDQ$LAYOUT() {
        return constants$2.kOrtSessionOptionsDisableQuantQDQ$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsDisableQuantQDQ$VH() {
        return constants$2.kOrtSessionOptionsDisableQuantQDQ$VH;
    }

    public static MemorySegment kOrtSessionOptionsDisableQuantQDQ$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$2.kOrtSessionOptionsDisableQuantQDQ$SEGMENT, "kOrtSessionOptionsDisableQuantQDQ");
    }

    public static MemoryAddress kOrtSessionOptionsDisableQuantQDQ$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$2.kOrtSessionOptionsDisableQuantQDQ$VH.get(RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsDisableQuantQDQ$SEGMENT, "kOrtSessionOptionsDisableQuantQDQ"));
    }

    public static void kOrtSessionOptionsDisableQuantQDQ$set(MemoryAddress x) {
        constants$2.kOrtSessionOptionsDisableQuantQDQ$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$2.kOrtSessionOptionsDisableQuantQDQ$SEGMENT, "kOrtSessionOptionsDisableQuantQDQ"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsEnableQuantQDQCleanup$LAYOUT() {
        return constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsEnableQuantQDQCleanup$VH() {
        return constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$VH;
    }

    public static MemorySegment kOrtSessionOptionsEnableQuantQDQCleanup$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$SEGMENT, "kOrtSessionOptionsEnableQuantQDQCleanup");
    }

    public static MemoryAddress kOrtSessionOptionsEnableQuantQDQCleanup$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$VH.get(RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$SEGMENT,
                        "kOrtSessionOptionsEnableQuantQDQCleanup"));
    }

    public static void kOrtSessionOptionsEnableQuantQDQCleanup$set(MemoryAddress x) {
        constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$SEGMENT,
                        "kOrtSessionOptionsEnableQuantQDQCleanup"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsEnableGeluApproximation$LAYOUT() {
        return constants$3.kOrtSessionOptionsEnableGeluApproximation$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsEnableGeluApproximation$VH() {
        return constants$3.kOrtSessionOptionsEnableGeluApproximation$VH;
    }

    public static MemorySegment kOrtSessionOptionsEnableGeluApproximation$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$3.kOrtSessionOptionsEnableGeluApproximation$SEGMENT,
                "kOrtSessionOptionsEnableGeluApproximation");
    }

    public static MemoryAddress kOrtSessionOptionsEnableGeluApproximation$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$3.kOrtSessionOptionsEnableGeluApproximation$VH.get(RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsEnableGeluApproximation$SEGMENT,
                        "kOrtSessionOptionsEnableGeluApproximation"));
    }

    public static void kOrtSessionOptionsEnableGeluApproximation$set(MemoryAddress x) {
        constants$3.kOrtSessionOptionsEnableGeluApproximation$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsEnableGeluApproximation$SEGMENT,
                        "kOrtSessionOptionsEnableGeluApproximation"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsUseDeviceAllocatorForInitializers$LAYOUT() {
        return constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsUseDeviceAllocatorForInitializers$VH() {
        return constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$VH;
    }

    public static MemorySegment kOrtSessionOptionsUseDeviceAllocatorForInitializers$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$SEGMENT,
                "kOrtSessionOptionsUseDeviceAllocatorForInitializers");
    }

    public static MemoryAddress kOrtSessionOptionsUseDeviceAllocatorForInitializers$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$VH.get(RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$SEGMENT,
                        "kOrtSessionOptionsUseDeviceAllocatorForInitializers"));
    }

    public static void kOrtSessionOptionsUseDeviceAllocatorForInitializers$set(MemoryAddress x) {
        constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$SEGMENT,
                        "kOrtSessionOptionsUseDeviceAllocatorForInitializers"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigAllowInterOpSpinning$LAYOUT() {
        return constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigAllowInterOpSpinning$VH() {
        return constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigAllowInterOpSpinning$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$SEGMENT,
                "kOrtSessionOptionsConfigAllowInterOpSpinning");
    }

    public static MemoryAddress kOrtSessionOptionsConfigAllowInterOpSpinning$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$VH.get(RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$SEGMENT,
                        "kOrtSessionOptionsConfigAllowInterOpSpinning"));
    }

    public static void kOrtSessionOptionsConfigAllowInterOpSpinning$set(MemoryAddress x) {
        constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$SEGMENT,
                        "kOrtSessionOptionsConfigAllowInterOpSpinning"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigAllowIntraOpSpinning$LAYOUT() {
        return constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigAllowIntraOpSpinning$VH() {
        return constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigAllowIntraOpSpinning$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$SEGMENT,
                "kOrtSessionOptionsConfigAllowIntraOpSpinning");
    }

    public static MemoryAddress kOrtSessionOptionsConfigAllowIntraOpSpinning$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$VH.get(RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$SEGMENT,
                        "kOrtSessionOptionsConfigAllowIntraOpSpinning"));
    }

    public static void kOrtSessionOptionsConfigAllowIntraOpSpinning$set(MemoryAddress x) {
        constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$SEGMENT,
                        "kOrtSessionOptionsConfigAllowIntraOpSpinning"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigUseORTModelBytesDirectly$LAYOUT() {
        return constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigUseORTModelBytesDirectly$VH() {
        return constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigUseORTModelBytesDirectly$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$SEGMENT,
                "kOrtSessionOptionsConfigUseORTModelBytesDirectly");
    }

    public static MemoryAddress kOrtSessionOptionsConfigUseORTModelBytesDirectly$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$VH.get(RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$SEGMENT,
                        "kOrtSessionOptionsConfigUseORTModelBytesDirectly"));
    }

    public static void kOrtSessionOptionsConfigUseORTModelBytesDirectly$set(MemoryAddress x) {
        constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$SEGMENT,
                        "kOrtSessionOptionsConfigUseORTModelBytesDirectly"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigUseORTModelBytesForInitializers$LAYOUT() {
        return constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigUseORTModelBytesForInitializers$VH() {
        return constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigUseORTModelBytesForInitializers$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$SEGMENT,
                "kOrtSessionOptionsConfigUseORTModelBytesForInitializers");
    }

    public static MemoryAddress kOrtSessionOptionsConfigUseORTModelBytesForInitializers$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$VH.get(RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$SEGMENT,
                        "kOrtSessionOptionsConfigUseORTModelBytesForInitializers"));
    }

    public static void kOrtSessionOptionsConfigUseORTModelBytesForInitializers$set(MemoryAddress x) {
        constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$SEGMENT,
                        "kOrtSessionOptionsConfigUseORTModelBytesForInitializers"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsQDQIsInt8Allowed$LAYOUT() {
        return constants$4.kOrtSessionOptionsQDQIsInt8Allowed$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsQDQIsInt8Allowed$VH() {
        return constants$4.kOrtSessionOptionsQDQIsInt8Allowed$VH;
    }

    public static MemorySegment kOrtSessionOptionsQDQIsInt8Allowed$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$4.kOrtSessionOptionsQDQIsInt8Allowed$SEGMENT, "kOrtSessionOptionsQDQIsInt8Allowed");
    }

    public static MemoryAddress kOrtSessionOptionsQDQIsInt8Allowed$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$4.kOrtSessionOptionsQDQIsInt8Allowed$VH.get(RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsQDQIsInt8Allowed$SEGMENT, "kOrtSessionOptionsQDQIsInt8Allowed"));
    }

    public static void kOrtSessionOptionsQDQIsInt8Allowed$set(MemoryAddress x) {
        constants$4.kOrtSessionOptionsQDQIsInt8Allowed$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsQDQIsInt8Allowed$SEGMENT, "kOrtSessionOptionsQDQIsInt8Allowed"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsAvx2PrecisionMode$LAYOUT() {
        return constants$4.kOrtSessionOptionsAvx2PrecisionMode$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsAvx2PrecisionMode$VH() {
        return constants$4.kOrtSessionOptionsAvx2PrecisionMode$VH;
    }

    public static MemorySegment kOrtSessionOptionsAvx2PrecisionMode$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$4.kOrtSessionOptionsAvx2PrecisionMode$SEGMENT, "kOrtSessionOptionsAvx2PrecisionMode");
    }

    public static MemoryAddress kOrtSessionOptionsAvx2PrecisionMode$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$4.kOrtSessionOptionsAvx2PrecisionMode$VH.get(RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsAvx2PrecisionMode$SEGMENT,
                        "kOrtSessionOptionsAvx2PrecisionMode"));
    }

    public static void kOrtSessionOptionsAvx2PrecisionMode$set(MemoryAddress x) {
        constants$4.kOrtSessionOptionsAvx2PrecisionMode$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsAvx2PrecisionMode$SEGMENT, "kOrtSessionOptionsAvx2PrecisionMode"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigMinimalBuildOptimizations$LAYOUT() {
        return constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigMinimalBuildOptimizations$VH() {
        return constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigMinimalBuildOptimizations$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$SEGMENT,
                "kOrtSessionOptionsConfigMinimalBuildOptimizations");
    }

    public static MemoryAddress kOrtSessionOptionsConfigMinimalBuildOptimizations$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$VH.get(RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$SEGMENT,
                        "kOrtSessionOptionsConfigMinimalBuildOptimizations"));
    }

    public static void kOrtSessionOptionsConfigMinimalBuildOptimizations$set(MemoryAddress x) {
        constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$SEGMENT,
                        "kOrtSessionOptionsConfigMinimalBuildOptimizations"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$LAYOUT() {
        return constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$VH() {
        return constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$SEGMENT,
                "kOrtSessionOptionsConfigNnapiEpPartitioningStopOps");
    }

    public static MemoryAddress kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$VH.get(RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$SEGMENT,
                        "kOrtSessionOptionsConfigNnapiEpPartitioningStopOps"));
    }

    public static void kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$set(MemoryAddress x) {
        constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$SEGMENT,
                        "kOrtSessionOptionsConfigNnapiEpPartitioningStopOps"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigDynamicBlockBase$LAYOUT() {
        return constants$4.kOrtSessionOptionsConfigDynamicBlockBase$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigDynamicBlockBase$VH() {
        return constants$4.kOrtSessionOptionsConfigDynamicBlockBase$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigDynamicBlockBase$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$4.kOrtSessionOptionsConfigDynamicBlockBase$SEGMENT,
                "kOrtSessionOptionsConfigDynamicBlockBase");
    }

    public static MemoryAddress kOrtSessionOptionsConfigDynamicBlockBase$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$4.kOrtSessionOptionsConfigDynamicBlockBase$VH.get(RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigDynamicBlockBase$SEGMENT,
                        "kOrtSessionOptionsConfigDynamicBlockBase"));
    }

    public static void kOrtSessionOptionsConfigDynamicBlockBase$set(MemoryAddress x) {
        constants$4.kOrtSessionOptionsConfigDynamicBlockBase$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$4.kOrtSessionOptionsConfigDynamicBlockBase$SEGMENT,
                        "kOrtSessionOptionsConfigDynamicBlockBase"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigForceSpinningStop$LAYOUT() {
        return constants$5.kOrtSessionOptionsConfigForceSpinningStop$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigForceSpinningStop$VH() {
        return constants$5.kOrtSessionOptionsConfigForceSpinningStop$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigForceSpinningStop$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$5.kOrtSessionOptionsConfigForceSpinningStop$SEGMENT,
                "kOrtSessionOptionsConfigForceSpinningStop");
    }

    public static MemoryAddress kOrtSessionOptionsConfigForceSpinningStop$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$5.kOrtSessionOptionsConfigForceSpinningStop$VH.get(RuntimeHelper.requireNonNull(
                        constants$5.kOrtSessionOptionsConfigForceSpinningStop$SEGMENT,
                        "kOrtSessionOptionsConfigForceSpinningStop"));
    }

    public static void kOrtSessionOptionsConfigForceSpinningStop$set(MemoryAddress x) {
        constants$5.kOrtSessionOptionsConfigForceSpinningStop$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$5.kOrtSessionOptionsConfigForceSpinningStop$SEGMENT,
                        "kOrtSessionOptionsConfigForceSpinningStop"),
                x);
    }

    public static MemoryLayout kOrtSessionOptionsConfigStrictShapeTypeInference$LAYOUT() {
        return constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$LAYOUT;
    }

    public static VarHandle kOrtSessionOptionsConfigStrictShapeTypeInference$VH() {
        return constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$VH;
    }

    public static MemorySegment kOrtSessionOptionsConfigStrictShapeTypeInference$SEGMENT() {
        return RuntimeHelper.requireNonNull(
                constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$SEGMENT,
                "kOrtSessionOptionsConfigStrictShapeTypeInference");
    }

    public static MemoryAddress kOrtSessionOptionsConfigStrictShapeTypeInference$get() {
        return (java.lang.foreign.MemoryAddress)
                constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$VH.get(RuntimeHelper.requireNonNull(
                        constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$SEGMENT,
                        "kOrtSessionOptionsConfigStrictShapeTypeInference"));
    }

    public static void kOrtSessionOptionsConfigStrictShapeTypeInference$set(MemoryAddress x) {
        constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$VH.set(
                RuntimeHelper.requireNonNull(
                        constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$SEGMENT,
                        "kOrtSessionOptionsConfigStrictShapeTypeInference"),
                x);
    }
}
