/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface Transaction {

    NamedCollection<Value> run();

    public interface Builder {
        Input.Builder addInput(NodeInfo nodeInfo);

        Builder addOutput(NodeInfo nodeInfo);

        Builder setRunOptions(RunOptions runOptions);

        Transaction build();
    }
}
