/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
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
