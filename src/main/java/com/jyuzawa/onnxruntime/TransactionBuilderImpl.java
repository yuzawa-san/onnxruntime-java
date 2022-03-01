/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime.Transaction.Builder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jdk.incubator.foreign.MemoryAddress;

final class TransactionBuilderImpl implements Transaction.Builder {

    final ApiImpl api;
    final MemoryAddress session;
    final MemoryAddress ortAllocator;
    final Map<String, OnnxValueImpl> inputs;
    final List<NodeInfo> outputs;
    private final NamedCollection<NodeInfo> allInputs;
    private final NamedCollection<NodeInfo> allOutputs;

    public TransactionBuilderImpl(
            ApiImpl api,
            MemoryAddress session,
            MemoryAddress ortAllocator,
            NamedCollection<NodeInfo> allInputs,
            NamedCollection<NodeInfo> allOutputs) {
        this.api = api;
        this.session = session;
        this.ortAllocator = ortAllocator;
        this.allInputs = allInputs;
        this.allOutputs = allOutputs;
        this.inputs = new LinkedHashMap<>();
        this.outputs = new ArrayList<>();
    }

    @Override
    public Transaction build() {
        return new TransactionImpl(this);
    }

    private OnnxValue addInput(NodeInfo node) {
        OnnxValueImpl input = OnnxValueImpl.fromTypeInfo(node.getTypeInfo());
        inputs.put(node.getName(), input);
        return input;
    }

    @Override
    public OnnxValue addInput(String name) {
        return addInput(allInputs.get(name));
    }

    @Override
    public OnnxValue addInput(int index) {
        return addInput(allInputs.get(index));
    }

    private Builder addOutput(NodeInfo node) {
        outputs.add(node);
        return this;
    }

    @Override
    public Builder addOutput(String name) {
        return addOutput(allOutputs.get(name));
    }

    @Override
    public Builder addOutput(int index) {
        return addOutput(allOutputs.get(index));
    }
}
