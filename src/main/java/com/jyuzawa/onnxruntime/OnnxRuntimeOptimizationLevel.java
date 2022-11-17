/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

public enum OnnxRuntimeOptimizationLevel {
    DISABLE_ALL(0),
    ENABLE_BASIC(1),
    ENABLE_EXTENDED(2),
    ENABLE_ALL(99);

    private final int number;

    private OnnxRuntimeOptimizationLevel(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static final OnnxRuntimeOptimizationLevel forNumber(int number) {
        switch (number) {
            case 1:
                return ENABLE_BASIC;
            case 2:
                return ENABLE_EXTENDED;
            case 99:
                return ENABLE_ALL;
            case 0:
            default:
                return DISABLE_ALL;
        }
    }
}
