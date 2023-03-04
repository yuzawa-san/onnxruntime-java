/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class onnxruntime_c_api_h {

    public static final OfByte C_CHAR = Constants$root.C_CHAR$LAYOUT;
    public static final OfShort C_SHORT = Constants$root.C_SHORT$LAYOUT;
    public static final OfInt C_INT = Constants$root.C_INT$LAYOUT;
    public static final OfLong C_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static final OfLong C_LONG_LONG = Constants$root.C_LONG_LONG$LAYOUT;
    public static final OfFloat C_FLOAT = Constants$root.C_FLOAT$LAYOUT;
    public static final OfDouble C_DOUBLE = Constants$root.C_DOUBLE$LAYOUT;
    public static final OfAddress C_POINTER = Constants$root.C_POINTER$LAYOUT;
    /**
     * {@snippet :
     * #define ORT_API_VERSION 14
     * }
     */
    public static int ORT_API_VERSION() {
        return (int) 14L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED = 0;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT = 1;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8 = 2;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8 = 3;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16 = 4;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16 = 5;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16() {
        return (int) 5L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32 = 6;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32() {
        return (int) 6L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64 = 7;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64() {
        return (int) 7L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING = 8;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING() {
        return (int) 8L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL = 9;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL() {
        return (int) 9L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16 = 10;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16() {
        return (int) 10L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE = 11;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE() {
        return (int) 11L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32 = 12;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32() {
        return (int) 12L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64 = 13;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64() {
        return (int) 13L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64 = 14;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64() {
        return (int) 14L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128 = 15;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128() {
        return (int) 15L;
    }
    /**
     * {@snippet :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16 = 16;
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16() {
        return (int) 16L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_UNKNOWN = 0;
     * }
     */
    public static int ONNX_TYPE_UNKNOWN() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_TENSOR = 1;
     * }
     */
    public static int ONNX_TYPE_TENSOR() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_SEQUENCE = 2;
     * }
     */
    public static int ONNX_TYPE_SEQUENCE() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_MAP = 3;
     * }
     */
    public static int ONNX_TYPE_MAP() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_OPAQUE = 4;
     * }
     */
    public static int ONNX_TYPE_OPAQUE() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_SPARSETENSOR = 5;
     * }
     */
    public static int ONNX_TYPE_SPARSETENSOR() {
        return (int) 5L;
    }
    /**
     * {@snippet :
     * enum ONNXType.ONNX_TYPE_OPTIONAL = 6;
     * }
     */
    public static int ONNX_TYPE_OPTIONAL() {
        return (int) 6L;
    }
    /**
     * {@snippet :
     * enum OrtSparseFormat.ORT_SPARSE_UNDEFINED = 0;
     * }
     */
    public static int ORT_SPARSE_UNDEFINED() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtSparseFormat.ORT_SPARSE_COO = 1;
     * }
     */
    public static int ORT_SPARSE_COO() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtSparseFormat.ORT_SPARSE_CSRC = 2;
     * }
     */
    public static int ORT_SPARSE_CSRC() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtSparseFormat.ORT_SPARSE_BLOCK_SPARSE = 4;
     * }
     */
    public static int ORT_SPARSE_BLOCK_SPARSE() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_COO_INDICES = 0;
     * }
     */
    public static int ORT_SPARSE_COO_INDICES() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_CSR_INNER_INDICES = 1;
     * }
     */
    public static int ORT_SPARSE_CSR_INNER_INDICES() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_CSR_OUTER_INDICES = 2;
     * }
     */
    public static int ORT_SPARSE_CSR_OUTER_INDICES() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_BLOCK_SPARSE_INDICES = 3;
     * }
     */
    public static int ORT_SPARSE_BLOCK_SPARSE_INDICES() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_VERBOSE = 0;
     * }
     */
    public static int ORT_LOGGING_LEVEL_VERBOSE() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_INFO = 1;
     * }
     */
    public static int ORT_LOGGING_LEVEL_INFO() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING = 2;
     * }
     */
    public static int ORT_LOGGING_LEVEL_WARNING() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_ERROR = 3;
     * }
     */
    public static int ORT_LOGGING_LEVEL_ERROR() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_FATAL = 4;
     * }
     */
    public static int ORT_LOGGING_LEVEL_FATAL() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_OK = 0;
     * }
     */
    public static int ORT_OK() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_FAIL = 1;
     * }
     */
    public static int ORT_FAIL() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_INVALID_ARGUMENT = 2;
     * }
     */
    public static int ORT_INVALID_ARGUMENT() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_NO_SUCHFILE = 3;
     * }
     */
    public static int ORT_NO_SUCHFILE() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_NO_MODEL = 4;
     * }
     */
    public static int ORT_NO_MODEL() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_ENGINE_ERROR = 5;
     * }
     */
    public static int ORT_ENGINE_ERROR() {
        return (int) 5L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_RUNTIME_EXCEPTION = 6;
     * }
     */
    public static int ORT_RUNTIME_EXCEPTION() {
        return (int) 6L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_INVALID_PROTOBUF = 7;
     * }
     */
    public static int ORT_INVALID_PROTOBUF() {
        return (int) 7L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_MODEL_LOADED = 8;
     * }
     */
    public static int ORT_MODEL_LOADED() {
        return (int) 8L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_NOT_IMPLEMENTED = 9;
     * }
     */
    public static int ORT_NOT_IMPLEMENTED() {
        return (int) 9L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_INVALID_GRAPH = 10;
     * }
     */
    public static int ORT_INVALID_GRAPH() {
        return (int) 10L;
    }
    /**
     * {@snippet :
     * enum OrtErrorCode.ORT_EP_FAIL = 11;
     * }
     */
    public static int ORT_EP_FAIL() {
        return (int) 11L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_UNDEFINED = 0;
     * }
     */
    public static int ORT_OP_ATTR_UNDEFINED() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_INT = 1;
     * }
     */
    public static int ORT_OP_ATTR_INT() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_INTS = 2;
     * }
     */
    public static int ORT_OP_ATTR_INTS() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_FLOAT = 3;
     * }
     */
    public static int ORT_OP_ATTR_FLOAT() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_FLOATS = 4;
     * }
     */
    public static int ORT_OP_ATTR_FLOATS() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_STRING = 5;
     * }
     */
    public static int ORT_OP_ATTR_STRING() {
        return (int) 5L;
    }
    /**
     * {@snippet :
     * enum OrtOpAttrType.ORT_OP_ATTR_STRINGS = 6;
     * }
     */
    public static int ORT_OP_ATTR_STRINGS() {
        return (int) 6L;
    }
    /**
     * {@snippet :
     * typedef struct OrtStatus* OrtStatusPtr;
     * }
     */
    public static final OfAddress OrtStatusPtr = Constants$root.C_POINTER$LAYOUT;
    /**
     * {@snippet :
     * enum GraphOptimizationLevel.ORT_DISABLE_ALL = 0;
     * }
     */
    public static int ORT_DISABLE_ALL() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum GraphOptimizationLevel.ORT_ENABLE_BASIC = 1;
     * }
     */
    public static int ORT_ENABLE_BASIC() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum GraphOptimizationLevel.ORT_ENABLE_EXTENDED = 2;
     * }
     */
    public static int ORT_ENABLE_EXTENDED() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum GraphOptimizationLevel.ORT_ENABLE_ALL = 99;
     * }
     */
    public static int ORT_ENABLE_ALL() {
        return (int) 99L;
    }
    /**
     * {@snippet :
     * enum ExecutionMode.ORT_SEQUENTIAL = 0;
     * }
     */
    public static int ORT_SEQUENTIAL() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum ExecutionMode.ORT_PARALLEL = 1;
     * }
     */
    public static int ORT_PARALLEL() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_C = 0;
     * }
     */
    public static int ORT_PROJECTION_C() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_CPLUSPLUS = 1;
     * }
     */
    public static int ORT_PROJECTION_CPLUSPLUS() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_CSHARP = 2;
     * }
     */
    public static int ORT_PROJECTION_CSHARP() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_PYTHON = 3;
     * }
     */
    public static int ORT_PROJECTION_PYTHON() {
        return (int) 3L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_JAVA = 4;
     * }
     */
    public static int ORT_PROJECTION_JAVA() {
        return (int) 4L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_WINML = 5;
     * }
     */
    public static int ORT_PROJECTION_WINML() {
        return (int) 5L;
    }
    /**
     * {@snippet :
     * enum OrtLanguageProjection.ORT_PROJECTION_NODEJS = 6;
     * }
     */
    public static int ORT_PROJECTION_NODEJS() {
        return (int) 6L;
    }
    /**
     * {@snippet :
     * enum OrtAllocatorType.OrtInvalidAllocator = -1;
     * }
     */
    public static int OrtInvalidAllocator() {
        return (int) -1L;
    }
    /**
     * {@snippet :
     * enum OrtAllocatorType.OrtDeviceAllocator = 0;
     * }
     */
    public static int OrtDeviceAllocator() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtAllocatorType.OrtArenaAllocator = 1;
     * }
     */
    public static int OrtArenaAllocator() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtMemType.OrtMemTypeCPUInput = -2;
     * }
     */
    public static int OrtMemTypeCPUInput() {
        return (int) -2L;
    }
    /**
     * {@snippet :
     * enum OrtMemType.OrtMemTypeCPUOutput = -1;
     * }
     */
    public static int OrtMemTypeCPUOutput() {
        return (int) -1L;
    }
    /**
     * {@snippet :
     * enum OrtMemType.OrtMemTypeCPU = -1;
     * }
     */
    public static int OrtMemTypeCPU() {
        return (int) -1L;
    }
    /**
     * {@snippet :
     * enum OrtMemType.OrtMemTypeDefault = 0;
     * }
     */
    public static int OrtMemTypeDefault() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtMemoryInfoDeviceType.OrtMemoryInfoDeviceType_CPU = 0;
     * }
     */
    public static int OrtMemoryInfoDeviceType_CPU() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtMemoryInfoDeviceType.OrtMemoryInfoDeviceType_GPU = 1;
     * }
     */
    public static int OrtMemoryInfoDeviceType_GPU() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtMemoryInfoDeviceType.OrtMemoryInfoDeviceType_FPGA = 2;
     * }
     */
    public static int OrtMemoryInfoDeviceType_FPGA() {
        return (int) 2L;
    }
    /**
     * {@snippet :
     * enum OrtCudnnConvAlgoSearch.OrtCudnnConvAlgoSearchExhaustive = 0;
     * }
     */
    public static int OrtCudnnConvAlgoSearchExhaustive() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtCudnnConvAlgoSearch.OrtCudnnConvAlgoSearchHeuristic = 1;
     * }
     */
    public static int OrtCudnnConvAlgoSearchHeuristic() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtCudnnConvAlgoSearch.OrtCudnnConvAlgoSearchDefault = 2;
     * }
     */
    public static int OrtCudnnConvAlgoSearchDefault() {
        return (int) 2L;
    }

    public static MethodHandle OrtGetApiBase$MH() {
        return RuntimeHelper.requireNonNull(constants$0.OrtGetApiBase$MH, "OrtGetApiBase");
    }
    /**
     * {@snippet :
     * const OrtApiBase* OrtGetApiBase();
     * }
     */
    public static MemorySegment OrtGetApiBase() {
        var mh$ = OrtGetApiBase$MH();
        try {
            return (java.lang.foreign.MemorySegment) mh$.invokeExact();
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    /**
     * {@snippet :
     * typedef struct OrtCustomHandleType* OrtCustomThreadHandle;
     * }
     */
    public static final OfAddress OrtCustomThreadHandle = Constants$root.C_POINTER$LAYOUT;
    /**
     * {@snippet :
     * enum OrtCustomOpInputOutputCharacteristic.INPUT_OUTPUT_REQUIRED = 0;
     * }
     */
    public static int INPUT_OUTPUT_REQUIRED() {
        return (int) 0L;
    }
    /**
     * {@snippet :
     * enum OrtCustomOpInputOutputCharacteristic.INPUT_OUTPUT_OPTIONAL = 1;
     * }
     */
    public static int INPUT_OUTPUT_OPTIONAL() {
        return (int) 1L;
    }
    /**
     * {@snippet :
     * enum OrtCustomOpInputOutputCharacteristic.INPUT_OUTPUT_VARIADIC = 2;
     * }
     */
    public static int INPUT_OUTPUT_VARIADIC() {
        return (int) 2L;
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$MH() {
        return RuntimeHelper.requireNonNull(
                constants$1.OrtSessionOptionsAppendExecutionProvider_CUDA$MH,
                "OrtSessionOptionsAppendExecutionProvider_CUDA");
    }
    /**
     * {@snippet :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CUDA(OrtSessionOptions* options, int device_id);
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_CUDA(MemorySegment options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_CUDA$MH();
        try {
            return (java.lang.foreign.MemorySegment) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH() {
        return RuntimeHelper.requireNonNull(
                constants$2.OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH,
                "OrtSessionOptionsAppendExecutionProvider_MIGraphX");
    }
    /**
     * {@snippet :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_MIGraphX(OrtSessionOptions* options, int device_id);
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_MIGraphX(
            MemorySegment options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH();
        try {
            return (java.lang.foreign.MemorySegment) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
