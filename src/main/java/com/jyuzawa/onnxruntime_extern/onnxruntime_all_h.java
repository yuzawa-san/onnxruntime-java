/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.MemoryLayout.PathElement.*;
import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class onnxruntime_all_h {

    onnxruntime_all_h() {
        // Should not be called directly
    }

    static final Arena LIBRARY_ARENA = Arena.ofAuto();
    static final boolean TRACE_DOWNCALLS = Boolean.getBoolean("jextract.trace.downcalls");

    static void traceDowncall(String name, Object... args) {
        String traceArgs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
        System.out.printf("%s(%s)\n", name, traceArgs);
    }

    static MemorySegment findOrThrow(String symbol) {
        return SYMBOL_LOOKUP.find(symbol).orElseThrow(() -> new UnsatisfiedLinkError("unresolved symbol: " + symbol));
    }

    static MethodHandle upcallHandle(Class<?> fi, String name, FunctionDescriptor fdesc) {
        try {
            return MethodHandles.lookup().findVirtual(fi, name, fdesc.toMethodType());
        } catch (ReflectiveOperationException ex) {
            throw new AssertionError(ex);
        }
    }

    static {
    }

    static final SymbolLookup SYMBOL_LOOKUP =
            SymbolLookup.loaderLookup().or(Linker.nativeLinker().defaultLookup());

    public static final ValueLayout.OfBoolean C_BOOL = ValueLayout.JAVA_BOOLEAN;
    public static final ValueLayout.OfByte C_CHAR = ValueLayout.JAVA_BYTE;
    public static final ValueLayout.OfShort C_SHORT = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfInt C_INT = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfLong C_LONG_LONG = ValueLayout.JAVA_LONG;
    public static final ValueLayout.OfFloat C_FLOAT = ValueLayout.JAVA_FLOAT;
    public static final ValueLayout.OfDouble C_DOUBLE = ValueLayout.JAVA_DOUBLE;
    public static final AddressLayout C_POINTER =
            ValueLayout.ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(java.lang.Long.MAX_VALUE, JAVA_BYTE));
    public static final ValueLayout.OfLong C_LONG = ValueLayout.JAVA_LONG;
    private static final int ORT_API_VERSION = (int) 17L;
    /**
     * {@snippet lang=c :
     * #define ORT_API_VERSION 17
     * }
     */
    public static int ORT_API_VERSION() {
        return ORT_API_VERSION;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED = 0
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT = 1
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8 = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8 = 2
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8 = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8 = 3
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16 = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16 = 4
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16 = (int) 5L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16 = 5
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32 = (int) 6L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32 = 6
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64 = (int) 7L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64 = 7
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING = (int) 8L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING = 8
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL = (int) 9L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL = 9
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16 = (int) 10L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16 = 10
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE = (int) 11L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE = 11
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32 = (int) 12L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32 = 12
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64 = (int) 13L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64 = 13
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64 = (int) 14L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64 = 14
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128 = (int) 15L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128 = 15
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16 = (int) 16L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16 = 16
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN = (int) 17L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN = 17
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ = (int) 18L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ = 18
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2 = (int) 19L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2 = 19
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2;
    }

    private static final int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ = (int) 20L;
    /**
     * {@snippet lang=c :
     * enum ONNXTensorElementDataType.ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ = 20
     * }
     */
    public static int ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ() {
        return ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ;
    }

    private static final int ONNX_TYPE_UNKNOWN = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_UNKNOWN = 0
     * }
     */
    public static int ONNX_TYPE_UNKNOWN() {
        return ONNX_TYPE_UNKNOWN;
    }

    private static final int ONNX_TYPE_TENSOR = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_TENSOR = 1
     * }
     */
    public static int ONNX_TYPE_TENSOR() {
        return ONNX_TYPE_TENSOR;
    }

    private static final int ONNX_TYPE_SEQUENCE = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_SEQUENCE = 2
     * }
     */
    public static int ONNX_TYPE_SEQUENCE() {
        return ONNX_TYPE_SEQUENCE;
    }

    private static final int ONNX_TYPE_MAP = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_MAP = 3
     * }
     */
    public static int ONNX_TYPE_MAP() {
        return ONNX_TYPE_MAP;
    }

    private static final int ONNX_TYPE_OPAQUE = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_OPAQUE = 4
     * }
     */
    public static int ONNX_TYPE_OPAQUE() {
        return ONNX_TYPE_OPAQUE;
    }

    private static final int ONNX_TYPE_SPARSETENSOR = (int) 5L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_SPARSETENSOR = 5
     * }
     */
    public static int ONNX_TYPE_SPARSETENSOR() {
        return ONNX_TYPE_SPARSETENSOR;
    }

    private static final int ONNX_TYPE_OPTIONAL = (int) 6L;
    /**
     * {@snippet lang=c :
     * enum ONNXType.ONNX_TYPE_OPTIONAL = 6
     * }
     */
    public static int ONNX_TYPE_OPTIONAL() {
        return ONNX_TYPE_OPTIONAL;
    }

    private static final int ORT_SPARSE_UNDEFINED = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseFormat.ORT_SPARSE_UNDEFINED = 0
     * }
     */
    public static int ORT_SPARSE_UNDEFINED() {
        return ORT_SPARSE_UNDEFINED;
    }

    private static final int ORT_SPARSE_COO = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseFormat.ORT_SPARSE_COO = 1
     * }
     */
    public static int ORT_SPARSE_COO() {
        return ORT_SPARSE_COO;
    }

    private static final int ORT_SPARSE_CSRC = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseFormat.ORT_SPARSE_CSRC = 2
     * }
     */
    public static int ORT_SPARSE_CSRC() {
        return ORT_SPARSE_CSRC;
    }

    private static final int ORT_SPARSE_BLOCK_SPARSE = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseFormat.ORT_SPARSE_BLOCK_SPARSE = 4
     * }
     */
    public static int ORT_SPARSE_BLOCK_SPARSE() {
        return ORT_SPARSE_BLOCK_SPARSE;
    }

    private static final int ORT_SPARSE_COO_INDICES = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_COO_INDICES = 0
     * }
     */
    public static int ORT_SPARSE_COO_INDICES() {
        return ORT_SPARSE_COO_INDICES;
    }

    private static final int ORT_SPARSE_CSR_INNER_INDICES = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_CSR_INNER_INDICES = 1
     * }
     */
    public static int ORT_SPARSE_CSR_INNER_INDICES() {
        return ORT_SPARSE_CSR_INNER_INDICES;
    }

    private static final int ORT_SPARSE_CSR_OUTER_INDICES = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_CSR_OUTER_INDICES = 2
     * }
     */
    public static int ORT_SPARSE_CSR_OUTER_INDICES() {
        return ORT_SPARSE_CSR_OUTER_INDICES;
    }

    private static final int ORT_SPARSE_BLOCK_SPARSE_INDICES = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum OrtSparseIndicesFormat.ORT_SPARSE_BLOCK_SPARSE_INDICES = 3
     * }
     */
    public static int ORT_SPARSE_BLOCK_SPARSE_INDICES() {
        return ORT_SPARSE_BLOCK_SPARSE_INDICES;
    }

    private static final int ORT_LOGGING_LEVEL_VERBOSE = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_VERBOSE = 0
     * }
     */
    public static int ORT_LOGGING_LEVEL_VERBOSE() {
        return ORT_LOGGING_LEVEL_VERBOSE;
    }

    private static final int ORT_LOGGING_LEVEL_INFO = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_INFO = 1
     * }
     */
    public static int ORT_LOGGING_LEVEL_INFO() {
        return ORT_LOGGING_LEVEL_INFO;
    }

    private static final int ORT_LOGGING_LEVEL_WARNING = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING = 2
     * }
     */
    public static int ORT_LOGGING_LEVEL_WARNING() {
        return ORT_LOGGING_LEVEL_WARNING;
    }

    private static final int ORT_LOGGING_LEVEL_ERROR = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_ERROR = 3
     * }
     */
    public static int ORT_LOGGING_LEVEL_ERROR() {
        return ORT_LOGGING_LEVEL_ERROR;
    }

    private static final int ORT_LOGGING_LEVEL_FATAL = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum OrtLoggingLevel.ORT_LOGGING_LEVEL_FATAL = 4
     * }
     */
    public static int ORT_LOGGING_LEVEL_FATAL() {
        return ORT_LOGGING_LEVEL_FATAL;
    }

    private static final int ORT_OK = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_OK = 0
     * }
     */
    public static int ORT_OK() {
        return ORT_OK;
    }

    private static final int ORT_FAIL = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_FAIL = 1
     * }
     */
    public static int ORT_FAIL() {
        return ORT_FAIL;
    }

    private static final int ORT_INVALID_ARGUMENT = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_INVALID_ARGUMENT = 2
     * }
     */
    public static int ORT_INVALID_ARGUMENT() {
        return ORT_INVALID_ARGUMENT;
    }

    private static final int ORT_NO_SUCHFILE = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_NO_SUCHFILE = 3
     * }
     */
    public static int ORT_NO_SUCHFILE() {
        return ORT_NO_SUCHFILE;
    }

    private static final int ORT_NO_MODEL = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_NO_MODEL = 4
     * }
     */
    public static int ORT_NO_MODEL() {
        return ORT_NO_MODEL;
    }

    private static final int ORT_ENGINE_ERROR = (int) 5L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_ENGINE_ERROR = 5
     * }
     */
    public static int ORT_ENGINE_ERROR() {
        return ORT_ENGINE_ERROR;
    }

    private static final int ORT_RUNTIME_EXCEPTION = (int) 6L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_RUNTIME_EXCEPTION = 6
     * }
     */
    public static int ORT_RUNTIME_EXCEPTION() {
        return ORT_RUNTIME_EXCEPTION;
    }

    private static final int ORT_INVALID_PROTOBUF = (int) 7L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_INVALID_PROTOBUF = 7
     * }
     */
    public static int ORT_INVALID_PROTOBUF() {
        return ORT_INVALID_PROTOBUF;
    }

    private static final int ORT_MODEL_LOADED = (int) 8L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_MODEL_LOADED = 8
     * }
     */
    public static int ORT_MODEL_LOADED() {
        return ORT_MODEL_LOADED;
    }

    private static final int ORT_NOT_IMPLEMENTED = (int) 9L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_NOT_IMPLEMENTED = 9
     * }
     */
    public static int ORT_NOT_IMPLEMENTED() {
        return ORT_NOT_IMPLEMENTED;
    }

    private static final int ORT_INVALID_GRAPH = (int) 10L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_INVALID_GRAPH = 10
     * }
     */
    public static int ORT_INVALID_GRAPH() {
        return ORT_INVALID_GRAPH;
    }

    private static final int ORT_EP_FAIL = (int) 11L;
    /**
     * {@snippet lang=c :
     * enum OrtErrorCode.ORT_EP_FAIL = 11
     * }
     */
    public static int ORT_EP_FAIL() {
        return ORT_EP_FAIL;
    }

    private static final int ORT_OP_ATTR_UNDEFINED = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_UNDEFINED = 0
     * }
     */
    public static int ORT_OP_ATTR_UNDEFINED() {
        return ORT_OP_ATTR_UNDEFINED;
    }

    private static final int ORT_OP_ATTR_INT = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_INT = 1
     * }
     */
    public static int ORT_OP_ATTR_INT() {
        return ORT_OP_ATTR_INT;
    }

    private static final int ORT_OP_ATTR_INTS = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_INTS = 2
     * }
     */
    public static int ORT_OP_ATTR_INTS() {
        return ORT_OP_ATTR_INTS;
    }

    private static final int ORT_OP_ATTR_FLOAT = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_FLOAT = 3
     * }
     */
    public static int ORT_OP_ATTR_FLOAT() {
        return ORT_OP_ATTR_FLOAT;
    }

    private static final int ORT_OP_ATTR_FLOATS = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_FLOATS = 4
     * }
     */
    public static int ORT_OP_ATTR_FLOATS() {
        return ORT_OP_ATTR_FLOATS;
    }

    private static final int ORT_OP_ATTR_STRING = (int) 5L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_STRING = 5
     * }
     */
    public static int ORT_OP_ATTR_STRING() {
        return ORT_OP_ATTR_STRING;
    }

    private static final int ORT_OP_ATTR_STRINGS = (int) 6L;
    /**
     * {@snippet lang=c :
     * enum OrtOpAttrType.ORT_OP_ATTR_STRINGS = 6
     * }
     */
    public static int ORT_OP_ATTR_STRINGS() {
        return ORT_OP_ATTR_STRINGS;
    }
    /**
     * {@snippet lang=c :
     * typedef OrtStatus *OrtStatusPtr
     * }
     */
    public static final AddressLayout OrtStatusPtr = onnxruntime_all_h.C_POINTER;

    private static final int ORT_DISABLE_ALL = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum GraphOptimizationLevel.ORT_DISABLE_ALL = 0
     * }
     */
    public static int ORT_DISABLE_ALL() {
        return ORT_DISABLE_ALL;
    }

    private static final int ORT_ENABLE_BASIC = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum GraphOptimizationLevel.ORT_ENABLE_BASIC = 1
     * }
     */
    public static int ORT_ENABLE_BASIC() {
        return ORT_ENABLE_BASIC;
    }

    private static final int ORT_ENABLE_EXTENDED = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum GraphOptimizationLevel.ORT_ENABLE_EXTENDED = 2
     * }
     */
    public static int ORT_ENABLE_EXTENDED() {
        return ORT_ENABLE_EXTENDED;
    }

    private static final int ORT_ENABLE_ALL = (int) 99L;
    /**
     * {@snippet lang=c :
     * enum GraphOptimizationLevel.ORT_ENABLE_ALL = 99
     * }
     */
    public static int ORT_ENABLE_ALL() {
        return ORT_ENABLE_ALL;
    }

    private static final int ORT_SEQUENTIAL = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum ExecutionMode.ORT_SEQUENTIAL = 0
     * }
     */
    public static int ORT_SEQUENTIAL() {
        return ORT_SEQUENTIAL;
    }

    private static final int ORT_PARALLEL = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum ExecutionMode.ORT_PARALLEL = 1
     * }
     */
    public static int ORT_PARALLEL() {
        return ORT_PARALLEL;
    }

    private static final int ORT_PROJECTION_C = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_C = 0
     * }
     */
    public static int ORT_PROJECTION_C() {
        return ORT_PROJECTION_C;
    }

    private static final int ORT_PROJECTION_CPLUSPLUS = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_CPLUSPLUS = 1
     * }
     */
    public static int ORT_PROJECTION_CPLUSPLUS() {
        return ORT_PROJECTION_CPLUSPLUS;
    }

    private static final int ORT_PROJECTION_CSHARP = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_CSHARP = 2
     * }
     */
    public static int ORT_PROJECTION_CSHARP() {
        return ORT_PROJECTION_CSHARP;
    }

    private static final int ORT_PROJECTION_PYTHON = (int) 3L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_PYTHON = 3
     * }
     */
    public static int ORT_PROJECTION_PYTHON() {
        return ORT_PROJECTION_PYTHON;
    }

    private static final int ORT_PROJECTION_JAVA = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_JAVA = 4
     * }
     */
    public static int ORT_PROJECTION_JAVA() {
        return ORT_PROJECTION_JAVA;
    }

    private static final int ORT_PROJECTION_WINML = (int) 5L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_WINML = 5
     * }
     */
    public static int ORT_PROJECTION_WINML() {
        return ORT_PROJECTION_WINML;
    }

    private static final int ORT_PROJECTION_NODEJS = (int) 6L;
    /**
     * {@snippet lang=c :
     * enum OrtLanguageProjection.ORT_PROJECTION_NODEJS = 6
     * }
     */
    public static int ORT_PROJECTION_NODEJS() {
        return ORT_PROJECTION_NODEJS;
    }

    private static final int OrtInvalidAllocator = (int) -1L;
    /**
     * {@snippet lang=c :
     * enum OrtAllocatorType.OrtInvalidAllocator = -1
     * }
     */
    public static int OrtInvalidAllocator() {
        return OrtInvalidAllocator;
    }

    private static final int OrtDeviceAllocator = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtAllocatorType.OrtDeviceAllocator = 0
     * }
     */
    public static int OrtDeviceAllocator() {
        return OrtDeviceAllocator;
    }

    private static final int OrtArenaAllocator = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtAllocatorType.OrtArenaAllocator = 1
     * }
     */
    public static int OrtArenaAllocator() {
        return OrtArenaAllocator;
    }

    private static final int OrtMemTypeCPUInput = (int) -2L;
    /**
     * {@snippet lang=c :
     * enum OrtMemType.OrtMemTypeCPUInput = -2
     * }
     */
    public static int OrtMemTypeCPUInput() {
        return OrtMemTypeCPUInput;
    }

    private static final int OrtMemTypeCPUOutput = (int) -1L;
    /**
     * {@snippet lang=c :
     * enum OrtMemType.OrtMemTypeCPUOutput = -1
     * }
     */
    public static int OrtMemTypeCPUOutput() {
        return OrtMemTypeCPUOutput;
    }

    private static final int OrtMemTypeCPU = (int) -1L;
    /**
     * {@snippet lang=c :
     * enum OrtMemType.OrtMemTypeCPU = -1
     * }
     */
    public static int OrtMemTypeCPU() {
        return OrtMemTypeCPU;
    }

    private static final int OrtMemTypeDefault = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtMemType.OrtMemTypeDefault = 0
     * }
     */
    public static int OrtMemTypeDefault() {
        return OrtMemTypeDefault;
    }

    private static final int OrtMemoryInfoDeviceType_CPU = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtMemoryInfoDeviceType.OrtMemoryInfoDeviceType_CPU = 0
     * }
     */
    public static int OrtMemoryInfoDeviceType_CPU() {
        return OrtMemoryInfoDeviceType_CPU;
    }

    private static final int OrtMemoryInfoDeviceType_GPU = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtMemoryInfoDeviceType.OrtMemoryInfoDeviceType_GPU = 1
     * }
     */
    public static int OrtMemoryInfoDeviceType_GPU() {
        return OrtMemoryInfoDeviceType_GPU;
    }

    private static final int OrtMemoryInfoDeviceType_FPGA = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtMemoryInfoDeviceType.OrtMemoryInfoDeviceType_FPGA = 2
     * }
     */
    public static int OrtMemoryInfoDeviceType_FPGA() {
        return OrtMemoryInfoDeviceType_FPGA;
    }

    private static final int OrtCudnnConvAlgoSearchExhaustive = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtCudnnConvAlgoSearch.OrtCudnnConvAlgoSearchExhaustive = 0
     * }
     */
    public static int OrtCudnnConvAlgoSearchExhaustive() {
        return OrtCudnnConvAlgoSearchExhaustive;
    }

    private static final int OrtCudnnConvAlgoSearchHeuristic = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtCudnnConvAlgoSearch.OrtCudnnConvAlgoSearchHeuristic = 1
     * }
     */
    public static int OrtCudnnConvAlgoSearchHeuristic() {
        return OrtCudnnConvAlgoSearchHeuristic;
    }

    private static final int OrtCudnnConvAlgoSearchDefault = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtCudnnConvAlgoSearch.OrtCudnnConvAlgoSearchDefault = 2
     * }
     */
    public static int OrtCudnnConvAlgoSearchDefault() {
        return OrtCudnnConvAlgoSearchDefault;
    }

    private static class OrtGetApiBase {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(onnxruntime_all_h.C_POINTER);

        public static final MethodHandle HANDLE =
                Linker.nativeLinker().downcallHandle(onnxruntime_all_h.findOrThrow("OrtGetApiBase"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * const OrtApiBase *OrtGetApiBase(void)
     * }
     */
    public static FunctionDescriptor OrtGetApiBase$descriptor() {
        return OrtGetApiBase.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * const OrtApiBase *OrtGetApiBase(void)
     * }
     */
    public static MethodHandle OrtGetApiBase$handle() {
        return OrtGetApiBase.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * const OrtApiBase *OrtGetApiBase(void)
     * }
     */
    public static MemorySegment OrtGetApiBase() {
        var mh$ = OrtGetApiBase.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtGetApiBase");
            }
            return (MemorySegment) mh$.invokeExact();
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    /**
     * {@snippet lang=c :
     * typedef const struct OrtCustomHandleType {
     *     char __place_holder;
     * } *OrtCustomThreadHandle
     * }
     */
    public static final AddressLayout OrtCustomThreadHandle = onnxruntime_all_h.C_POINTER;

    private static final int INPUT_OUTPUT_REQUIRED = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum OrtCustomOpInputOutputCharacteristic.INPUT_OUTPUT_REQUIRED = 0
     * }
     */
    public static int INPUT_OUTPUT_REQUIRED() {
        return INPUT_OUTPUT_REQUIRED;
    }

    private static final int INPUT_OUTPUT_OPTIONAL = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum OrtCustomOpInputOutputCharacteristic.INPUT_OUTPUT_OPTIONAL = 1
     * }
     */
    public static int INPUT_OUTPUT_OPTIONAL() {
        return INPUT_OUTPUT_OPTIONAL;
    }

    private static final int INPUT_OUTPUT_VARIADIC = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum OrtCustomOpInputOutputCharacteristic.INPUT_OUTPUT_VARIADIC = 2
     * }
     */
    public static int INPUT_OUTPUT_VARIADIC() {
        return INPUT_OUTPUT_VARIADIC;
    }

    private static class OrtSessionOptionsAppendExecutionProvider_CUDA {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        public static final MethodHandle HANDLE = Linker.nativeLinker()
                .downcallHandle(onnxruntime_all_h.findOrThrow("OrtSessionOptionsAppendExecutionProvider_CUDA"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CUDA(OrtSessionOptions *options, int device_id)
     * }
     */
    public static FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CUDA$descriptor() {
        return OrtSessionOptionsAppendExecutionProvider_CUDA.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CUDA(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$handle() {
        return OrtSessionOptionsAppendExecutionProvider_CUDA.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CUDA(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_CUDA(MemorySegment options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_CUDA.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtSessionOptionsAppendExecutionProvider_CUDA", options, device_id);
            }
            return (MemorySegment) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class OrtSessionOptionsAppendExecutionProvider_ROCM {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        public static final MethodHandle HANDLE = Linker.nativeLinker()
                .downcallHandle(onnxruntime_all_h.findOrThrow("OrtSessionOptionsAppendExecutionProvider_ROCM"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_ROCM(OrtSessionOptions *options, int device_id)
     * }
     */
    public static FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_ROCM$descriptor() {
        return OrtSessionOptionsAppendExecutionProvider_ROCM.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_ROCM(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_ROCM$handle() {
        return OrtSessionOptionsAppendExecutionProvider_ROCM.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_ROCM(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_ROCM(MemorySegment options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_ROCM.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtSessionOptionsAppendExecutionProvider_ROCM", options, device_id);
            }
            return (MemorySegment) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class OrtSessionOptionsAppendExecutionProvider_MIGraphX {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        public static final MethodHandle HANDLE = Linker.nativeLinker()
                .downcallHandle(
                        onnxruntime_all_h.findOrThrow("OrtSessionOptionsAppendExecutionProvider_MIGraphX"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_MIGraphX(OrtSessionOptions *options, int device_id)
     * }
     */
    public static FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_MIGraphX$descriptor() {
        return OrtSessionOptionsAppendExecutionProvider_MIGraphX.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_MIGraphX(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_MIGraphX$handle() {
        return OrtSessionOptionsAppendExecutionProvider_MIGraphX.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_MIGraphX(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_MIGraphX(
            MemorySegment options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_MIGraphX.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtSessionOptionsAppendExecutionProvider_MIGraphX", options, device_id);
            }
            return (MemorySegment) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class OrtSessionOptionsAppendExecutionProvider_Dnnl {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        public static final MethodHandle HANDLE = Linker.nativeLinker()
                .downcallHandle(onnxruntime_all_h.findOrThrow("OrtSessionOptionsAppendExecutionProvider_Dnnl"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_Dnnl(OrtSessionOptions *options, int use_arena)
     * }
     */
    public static FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_Dnnl$descriptor() {
        return OrtSessionOptionsAppendExecutionProvider_Dnnl.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_Dnnl(OrtSessionOptions *options, int use_arena)
     * }
     */
    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_Dnnl$handle() {
        return OrtSessionOptionsAppendExecutionProvider_Dnnl.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_Dnnl(OrtSessionOptions *options, int use_arena)
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_Dnnl(MemorySegment options, int use_arena) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_Dnnl.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtSessionOptionsAppendExecutionProvider_Dnnl", options, use_arena);
            }
            return (MemorySegment) mh$.invokeExact(options, use_arena);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    private static class OrtSessionOptionsAppendExecutionProvider_Tensorrt {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        public static final MethodHandle HANDLE = Linker.nativeLinker()
                .downcallHandle(
                        onnxruntime_all_h.findOrThrow("OrtSessionOptionsAppendExecutionProvider_Tensorrt"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_Tensorrt(OrtSessionOptions *options, int device_id)
     * }
     */
    public static FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_Tensorrt$descriptor() {
        return OrtSessionOptionsAppendExecutionProvider_Tensorrt.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_Tensorrt(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_Tensorrt$handle() {
        return OrtSessionOptionsAppendExecutionProvider_Tensorrt.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_Tensorrt(OrtSessionOptions *options, int device_id)
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_Tensorrt(
            MemorySegment options, int device_id) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_Tensorrt.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtSessionOptionsAppendExecutionProvider_Tensorrt", options, device_id);
            }
            return (MemorySegment) mh$.invokeExact(options, device_id);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

    private static final int COREML_FLAG_USE_NONE = (int) 0L;
    /**
     * {@snippet lang=c :
     * enum COREMLFlags.COREML_FLAG_USE_NONE = 0
     * }
     */
    public static int COREML_FLAG_USE_NONE() {
        return COREML_FLAG_USE_NONE;
    }

    private static final int COREML_FLAG_USE_CPU_ONLY = (int) 1L;
    /**
     * {@snippet lang=c :
     * enum COREMLFlags.COREML_FLAG_USE_CPU_ONLY = 1
     * }
     */
    public static int COREML_FLAG_USE_CPU_ONLY() {
        return COREML_FLAG_USE_CPU_ONLY;
    }

    private static final int COREML_FLAG_ENABLE_ON_SUBGRAPH = (int) 2L;
    /**
     * {@snippet lang=c :
     * enum COREMLFlags.COREML_FLAG_ENABLE_ON_SUBGRAPH = 2
     * }
     */
    public static int COREML_FLAG_ENABLE_ON_SUBGRAPH() {
        return COREML_FLAG_ENABLE_ON_SUBGRAPH;
    }

    private static final int COREML_FLAG_ONLY_ENABLE_DEVICE_WITH_ANE = (int) 4L;
    /**
     * {@snippet lang=c :
     * enum COREMLFlags.COREML_FLAG_ONLY_ENABLE_DEVICE_WITH_ANE = 4
     * }
     */
    public static int COREML_FLAG_ONLY_ENABLE_DEVICE_WITH_ANE() {
        return COREML_FLAG_ONLY_ENABLE_DEVICE_WITH_ANE;
    }

    private static final int COREML_FLAG_ONLY_ALLOW_STATIC_INPUT_SHAPES = (int) 8L;
    /**
     * {@snippet lang=c :
     * enum COREMLFlags.COREML_FLAG_ONLY_ALLOW_STATIC_INPUT_SHAPES = 8
     * }
     */
    public static int COREML_FLAG_ONLY_ALLOW_STATIC_INPUT_SHAPES() {
        return COREML_FLAG_ONLY_ALLOW_STATIC_INPUT_SHAPES;
    }

    private static final int COREML_FLAG_LAST = (int) 8L;
    /**
     * {@snippet lang=c :
     * enum COREMLFlags.COREML_FLAG_LAST = 8
     * }
     */
    public static int COREML_FLAG_LAST() {
        return COREML_FLAG_LAST;
    }

    private static class OrtSessionOptionsAppendExecutionProvider_CoreML {
        public static final FunctionDescriptor DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_INT);

        public static final MethodHandle HANDLE = Linker.nativeLinker()
                .downcallHandle(onnxruntime_all_h.findOrThrow("OrtSessionOptionsAppendExecutionProvider_CoreML"), DESC);
    }

    /**
     * Function descriptor for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CoreML(OrtSessionOptions *options, uint32_t coreml_flags)
     * }
     */
    public static FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CoreML$descriptor() {
        return OrtSessionOptionsAppendExecutionProvider_CoreML.DESC;
    }

    /**
     * Downcall method handle for:
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CoreML(OrtSessionOptions *options, uint32_t coreml_flags)
     * }
     */
    public static MethodHandle OrtSessionOptionsAppendExecutionProvider_CoreML$handle() {
        return OrtSessionOptionsAppendExecutionProvider_CoreML.HANDLE;
    }
    /**
     * {@snippet lang=c :
     * OrtStatusPtr OrtSessionOptionsAppendExecutionProvider_CoreML(OrtSessionOptions *options, uint32_t coreml_flags)
     * }
     */
    public static MemorySegment OrtSessionOptionsAppendExecutionProvider_CoreML(
            MemorySegment options, int coreml_flags) {
        var mh$ = OrtSessionOptionsAppendExecutionProvider_CoreML.HANDLE;
        try {
            if (TRACE_DOWNCALLS) {
                traceDowncall("OrtSessionOptionsAppendExecutionProvider_CoreML", options, coreml_flags);
            }
            return (MemorySegment) mh$.invokeExact(options, coreml_flags);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
    /**
     * {@snippet lang=c :
     * #define ORT_FILE "/var/folders/_0/vb3rmc0x05xfzm34qqcsmqk40000gn/T/jextract$5388632510910069834.h"
     * }
     */
    public static MemorySegment ORT_FILE() {
        class Holder {
            static final MemorySegment ORT_FILE = onnxruntime_all_h.LIBRARY_ARENA.allocateFrom(
                    "/var/folders/_0/vb3rmc0x05xfzm34qqcsmqk40000gn/T/jextract$5388632510910069834.h");
        }
        return Holder.ORT_FILE;
    }
}
