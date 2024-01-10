/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A level of optimization to target.
 *
 * @since 1.0.0
 */
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
        return switch (number) {
            case 0 -> DISABLE_ALL;
            case 1 -> ENABLE_BASIC;
            case 2 -> ENABLE_EXTENDED;
            case 99 -> ENABLE_ALL;
            default -> DISABLE_ALL;
        };
    }
}
