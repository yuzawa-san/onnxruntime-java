/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.*;

import java.util.Map;

/**
 * A preference for sequential or parallel execution.
 *
 * @since 1.0.0
 */
public enum OnnxRuntimeExecutionMode implements OnnxRuntimeEnum {
    SEQUENTIAL(ORT_SEQUENTIAL()),
    PARALLEL(ORT_PARALLEL());

    private final int number;

    private OnnxRuntimeExecutionMode(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return number;
    }

    private static final Map<Integer, OnnxRuntimeExecutionMode> NUMBER_TO_VALUE =
            new NumberMap<>(OnnxRuntimeExecutionMode.class);

    public static final OnnxRuntimeExecutionMode forNumber(int number) {
        return NUMBER_TO_VALUE.getOrDefault(number, SEQUENTIAL);
    }
}
