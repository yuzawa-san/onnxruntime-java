/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_DOUBLE;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_FLOAT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_SHORT;

import java.lang.foreign.ValueLayout;

/**
 * A tensor type from ONNX.
 *
 * @since 1.0.0
 */
public enum OnnxTensorElementDataType {
    UNDEFINED(0, null),
    FLOAT(1, C_FLOAT),
    UINT8(2, null),
    INT8(3, C_CHAR),
    UINT16(4, null),
    INT16(5, C_SHORT),
    INT32(6, C_INT),
    INT64(7, C_LONG),
    STRING(8, null),
    BOOL(9, C_CHAR),
    FLOAT16(10, null),
    DOUBLE(11, C_DOUBLE),
    UINT32(12, null),
    UINT64(13, null),
    COMPLEX64(14, null),
    COMPLEX128(15, null),
    BFLOAT16(16, null);

    private final int number;
    private final ValueLayout valueLayout;

    private OnnxTensorElementDataType(int number, ValueLayout valueLayout) {
        this.number = number;
        this.valueLayout = valueLayout;
    }

    public int getNumber() {
        return number;
    }

    /**
     * Get a level based off its internal number.
     *
     * @param number
     *            the internal number of the level
     * @return the level, UNDEFINED if not found
     */
    public static final OnnxTensorElementDataType forNumber(int number) {
        switch (number) {
            case 1:
                return FLOAT;
            case 2:
                return UINT8;
            case 3:
                return INT8;
            case 4:
                return UINT16;
            case 5:
                return INT16;
            case 6:
                return INT32;
            case 7:
                return INT64;
            case 8:
                return STRING;
            case 9:
                return BOOL;
            case 10:
                return FLOAT16;
            case 11:
                return DOUBLE;
            case 12:
                return UINT32;
            case 13:
                return UINT64;
            case 14:
                return COMPLEX64;
            case 15:
                return COMPLEX128;
            case 16:
                return BFLOAT16;
            case 0:
            default:
                return UNDEFINED;
        }
    }

    ValueLayout getValueLayout() {
        return valueLayout;
    }
}
