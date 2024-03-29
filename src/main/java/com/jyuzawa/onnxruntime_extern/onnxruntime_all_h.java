/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

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
        return (int) 17L;
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

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN() {
        return (int) 17L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ() {
        return (int) 18L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2() {
        return (int) 19L;
    }

    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ() {
        return (int) 20L;
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

    public static int OrtMemoryInfoDeviceType_CPU() {
        return (int) 0L;
    }

    public static int OrtMemoryInfoDeviceType_GPU() {
        return (int) 1L;
    }

    public static int OrtMemoryInfoDeviceType_FPGA() {
        return (int) 2L;
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

    public static int INPUT_OUTPUT_VARIADIC() {
        return (int) 2L;
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$MH() {
        return RuntimeHelper.requireNonNull(
                constants$2.OrtSessionOptionsAppendExecutionProvider_CUDA$MH,
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

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_ROCM$MH() {
        return RuntimeHelper.requireNonNull(
                constants$2.OrtSessionOptionsAppendExecutionProvider_ROCM$MH,
                "OrtSessionOptionsAppendExecutionProvider_ROCM");
    }

    public static MemoryAddress OrtSessionOptionsAppendExecutionProvider_ROCM(Addressable options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_ROCM$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH() {
        return RuntimeHelper.requireNonNull(
                constants$2.OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH,
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

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_Dnnl$MH() {
        return RuntimeHelper.requireNonNull(
                constants$2.OrtSessionOptionsAppendExecutionProvider_Dnnl$MH,
                "OrtSessionOptionsAppendExecutionProvider_Dnnl");
    }

    public static MemoryAddress OrtSessionOptionsAppendExecutionProvider_Dnnl(Addressable options, int use_arena) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_Dnnl$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact(options, use_arena);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_Tensorrt$MH() {
        return RuntimeHelper.requireNonNull(
                constants$2.OrtSessionOptionsAppendExecutionProvider_Tensorrt$MH,
                "OrtSessionOptionsAppendExecutionProvider_Tensorrt");
    }

    public static MemoryAddress OrtSessionOptionsAppendExecutionProvider_Tensorrt(Addressable options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_Tensorrt$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static int COREML_FLAG_USE_NONE() {
        return (int) 0L;
    }

    public static int COREML_FLAG_USE_CPU_ONLY() {
        return (int) 1L;
    }

    public static int COREML_FLAG_ENABLE_ON_SUBGRAPH() {
        return (int) 2L;
    }

    public static int COREML_FLAG_ONLY_ENABLE_DEVICE_WITH_ANE() {
        return (int) 4L;
    }

    public static int COREML_FLAG_ONLY_ALLOW_STATIC_INPUT_SHAPES() {
        return (int) 8L;
    }

    public static int COREML_FLAG_LAST() {
        return (int) 8L;
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_CoreML$MH() {
        return RuntimeHelper.requireNonNull(
                constants$3.OrtSessionOptionsAppendExecutionProvider_CoreML$MH,
                "OrtSessionOptionsAppendExecutionProvider_CoreML");
    }

    public static MemoryAddress OrtSessionOptionsAppendExecutionProvider_CoreML(Addressable options, int coreml_flags) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_CoreML$MH();
        try {
            return (java.lang.foreign.MemoryAddress) mh$.invokeExact(options, coreml_flags);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static MemorySegment ORT_FILE() {
        return constants$3.ORT_FILE$SEGMENT;
    }
}
