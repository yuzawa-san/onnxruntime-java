/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime.Transaction.Builder;
import java.util.ArrayList;
import java.util.List;
import jdk.incubator.foreign.MemoryAddress;

final class TransactionBuilderImpl implements Transaction.Builder {

    final ApiImpl api;
    final MemoryAddress session;
    final MemoryAddress ortAllocator;
    final List<InputBuilderImpl> inputs;
    final List<NodeInfo> outputs;
    RunOptions runOptions = new RunOptionsImpl();

    public TransactionBuilderImpl(ApiImpl api, MemoryAddress session, MemoryAddress ortAllocator) {
        this.api = api;
        this.session = session;
        this.ortAllocator = ortAllocator;
        this.inputs = new ArrayList<>();
        this.outputs = new ArrayList<>();
    }

    @Override
    public Transaction build() {
        return new TransactionImpl(this);
    }

    @Override
    public Input.Builder addInput(NodeInfo node) {
        InputBuilderImpl input = new InputBuilderImpl(node);
        inputs.add(input);
        return input;
    }

    @Override
    public Builder addOutput(NodeInfo node) {
        outputs.add(node);
        return this;
    }

    @Override
    public Builder setRunOptions(RunOptions runOptions) {
        this.runOptions = runOptions;
        return this;
    }
}
