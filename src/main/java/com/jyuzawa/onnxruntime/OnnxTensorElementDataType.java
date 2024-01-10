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
        return switch (number) {
            case 0 -> UNDEFINED;
            case 1 -> FLOAT;
            case 2 -> UINT8;
            case 3 -> INT8;
            case 4 -> UINT16;
            case 5 -> INT16;
            case 6 -> INT32;
            case 7 -> INT64;
            case 8 -> STRING;
            case 9 -> BOOL;
            case 10 -> FLOAT16;
            case 11 -> DOUBLE;
            case 12 -> UINT32;
            case 13 -> UINT64;
            case 14 -> COMPLEX64;
            case 15 -> COMPLEX128;
            case 16 -> BFLOAT16;
            default -> UNDEFINED;
        };
    }

    ValueLayout getValueLayout() {
        return valueLayout;
    }
}
