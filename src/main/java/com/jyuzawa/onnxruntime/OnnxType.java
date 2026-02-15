/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.*;

import java.util.Map;

/**
 * A type from ONNX.
 *
 * @since 1.0.0
 */
public enum OnnxType implements OnnxRuntimeEnum {
    UNKNOWN(ONNX_TYPE_UNKNOWN()),
    TENSOR(ONNX_TYPE_TENSOR()),
    SEQUENCE(ONNX_TYPE_SEQUENCE()),
    MAP(ONNX_TYPE_MAP()),
    OPAQUE(ONNX_TYPE_OPAQUE()),
    SPARSETENSOR(ONNX_TYPE_SPARSETENSOR()),
    OPTIONAL(ONNX_TYPE_OPTIONAL());

    private final int number;

    private OnnxType(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    private static final Map<Integer, OnnxType> NUMBER_TO_VALUE = new NumberMap<>(OnnxType.class);

    /**
     * Get a level based off its internal number.
     * @param number the internal number of the level
     * @return the level, UNKNOWN if not found
     */
    public static final OnnxType forNumber(int number) {
        return NUMBER_TO_VALUE.getOrDefault(number, UNKNOWN);
    }
}
