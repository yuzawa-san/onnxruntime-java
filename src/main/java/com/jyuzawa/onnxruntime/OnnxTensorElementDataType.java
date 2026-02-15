/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.*;

import java.lang.foreign.ValueLayout;
import java.util.Map;

/**
 * A tensor type from ONNX.
 *
 * @since 1.0.0
 */
public enum OnnxTensorElementDataType implements OnnxRuntimeEnum {
    UNDEFINED(ONNX_TENSOR_ELEMENT_DATA_TYPE_UNDEFINED(), null),
    FLOAT(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT(), C_FLOAT),
    UINT8(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT8(), null),
    INT8(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT8(), C_CHAR),
    UINT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT16(), null),
    INT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT16(), C_SHORT),
    INT32(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT32(), C_INT),
    INT64(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT64(), C_LONG),
    STRING(ONNX_TENSOR_ELEMENT_DATA_TYPE_STRING(), null),
    BOOL(ONNX_TENSOR_ELEMENT_DATA_TYPE_BOOL(), C_CHAR),
    FLOAT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT16(), null),
    DOUBLE(ONNX_TENSOR_ELEMENT_DATA_TYPE_DOUBLE(), C_DOUBLE),
    UINT32(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT32(), null),
    UINT64(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT64(), null),
    COMPLEX64(ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX64(), null),
    COMPLEX128(ONNX_TENSOR_ELEMENT_DATA_TYPE_COMPLEX128(), null),
    BFLOAT16(ONNX_TENSOR_ELEMENT_DATA_TYPE_BFLOAT16(), null),
    FLOAT8E4M3FN(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FN(), null),
    FLOAT8E4M3FNUZ(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E4M3FNUZ(), null),
    FLOAT8E5M2(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2(), null),
    FLOAT8E5M2FNUZ(ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT8E5M2FNUZ(), null),
    UINT4(ONNX_TENSOR_ELEMENT_DATA_TYPE_UINT4(), null),
    INT4(ONNX_TENSOR_ELEMENT_DATA_TYPE_INT4(), null);

    private final int number;
    private final ValueLayout valueLayout;

    private OnnxTensorElementDataType(int number, ValueLayout valueLayout) {
        this.number = number;
        this.valueLayout = valueLayout;
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

    ValueLayout getValueLayout() {
        return valueLayout;
    }
}
