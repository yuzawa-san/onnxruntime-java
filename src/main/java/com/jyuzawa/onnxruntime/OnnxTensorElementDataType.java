/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.*;

import java.util.Map;

/**
 * A tensor type from ONNX.
 *
 * @since 1.0.0
 */
public enum OnnxTensorElementDataType implements OnnxRuntimeEnum {
    UNDEFINED(ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED(), 0),
    FLOAT(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT(), 32),
    UINT8(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8(), 8),
    INT8(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8(), 8),
    UINT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16(), 16),
    INT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16(), 16),
    INT32(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32(), 32),
    INT64(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64(), 64),
    STRING(ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING(), 0),
    BOOL(ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL(), 8),
    FLOAT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16(), 16),
    DOUBLE(ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE(), 64),
    UINT32(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32(), 32),
    UINT64(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64(), 64),
    COMPLEX64(ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64(), 64),
    COMPLEX128(ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128(), 128),
    BFLOAT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16(), 16),
    FLOAT8E4M3FN(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN(), 8),
    FLOAT8E4M3FNUZ(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ(), 8),
    FLOAT8E5M2(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2(), 8),
    FLOAT8E5M2FNUZ(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ(), 8),
    UINT4(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT4(), 4),
    INT4(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT4(), 4),
    FLOAT4E2M1(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT4E2M1(), 4),
    UINT2(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT2(), 2),
    INT2(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT2(), 2),
    FLOAT8E8M0(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E8M0(), 8);

    private final int number;
    private final int bits;

    private OnnxTensorElementDataType(int number, int bits) {
        this.number = number;
        this.bits = bits;
    }

    @Override
    public int getNumber() {
        return number;
    }

    private static final Map<Integer, OnnxTensorElementDataType> NUMBER_TO_VALUE =
            new NumberMap<>(OnnxTensorElementDataType.class);

    /**
     * Get a level based off its internal number.
     *
     * @param number
     *            the internal number of the level
     * @return the level, UNDEFINED if not found
     */
    public static final OnnxTensorElementDataType forNumber(int number) {
        return NUMBER_TO_VALUE.getOrDefault(number, UNDEFINED);
    }

    int getBits() {
        return bits;
    }
}
