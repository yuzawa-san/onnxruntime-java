/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

public interface Transaction {

    NamedCollection<OnnxValue> run();

    public interface Builder {
        OnnxValue addInput(String name);

        OnnxValue addInput(int index);

        Builder addOutput(String name);

        Builder addOutput(int index);

        // TODO: more run options
        Transaction build();
    }
}
