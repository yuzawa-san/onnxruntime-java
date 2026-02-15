/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.*;

import java.util.Map;

/**
 * A level of optimization to target.
 *
 * @since 1.0.0
 */
public enum OnnxRuntimeOptimizationLevel implements OnnxRuntimeEnum {
    DISABLE_ALL(ORT_DISABLE_ALL()),
    ENABLE_BASIC(ORT_ENABLE_BASIC()),
    ENABLE_EXTENDED(ORT_ENABLE_EXTENDED()),
    ENABLE_LAYOUT(ORT_ENABLE_LAYOUT()),
    ENABLE_ALL(ORT_ENABLE_ALL());

    private final int number;

    private OnnxRuntimeOptimizationLevel(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    private static final Map<Integer, OnnxRuntimeOptimizationLevel> NUMBER_TO_VALUE =
            new NumberMap<>(OnnxRuntimeOptimizationLevel.class);

    public static final OnnxRuntimeOptimizationLevel forNumber(int number) {
        return NUMBER_TO_VALUE.getOrDefault(number, DISABLE_ALL);
    }
}
