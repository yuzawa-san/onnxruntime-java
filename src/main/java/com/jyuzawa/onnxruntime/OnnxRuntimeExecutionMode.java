/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A preference for sequential or parallel execution.
 *
 * @since 1.0.0
 */
public enum OnnxRuntimeExecutionMode {
    SEQUENTIAL(0),
    PARALLEL(1);

    private final int number;

    private OnnxRuntimeExecutionMode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static final OnnxRuntimeExecutionMode forNumber(int number) {
        return switch (number) {
            case 0 -> SEQUENTIAL;
            case 1 -> PARALLEL;
            default -> SEQUENTIAL;
        };
    }
}
