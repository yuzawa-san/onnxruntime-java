/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import com.jyuzawa.onnxruntime.Transaction.Builder;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class TransactionBuilderImpl implements Transaction.Builder {

    final ApiImpl api;
    final MemoryAddress session;
    final MemoryAddress memoryInfo;
    final MemoryAddress ortAllocator;
    final List<InputTuple> inputs;
    final List<NodeInfoImpl> outputs;
    private final NamedCollection<NodeInfoImpl> allInputs;
    private final NamedCollection<NodeInfoImpl> allOutputs;
    private OnnxRuntimeLoggingLevel logSeverityLevel;
    private Integer logVerbosityLevel;
    private String runTag;
    private Map<String, String> config;

    public TransactionBuilderImpl(
            ApiImpl api,
            MemoryAddress session,
            MemoryAddress memoryInfo,
            MemoryAddress ortAllocator,
            NamedCollection<NodeInfoImpl> allInputs,
            NamedCollection<NodeInfoImpl> allOutputs) {
        this.api = api;
        this.session = session;
        this.memoryInfo = memoryInfo;
        this.ortAllocator = ortAllocator;
        this.allInputs = allInputs;
        this.allOutputs = allOutputs;
        this.inputs = new ArrayList<>(1);
        this.outputs = new ArrayList<>(1);
    }

    @Override
    public Transaction build() {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("No inputs specified");
        }
        if (outputs.isEmpty()) {
            throw new IllegalArgumentException("No outputs specified");
        }
        return new TransactionImpl(this);
    }

    private OnnxValue addInput(NodeInfoImpl node) {
        OnnxValueImpl input = OnnxValueImpl.fromTypeInfo(node.getTypeInfo());
        inputs.add(new InputTuple(node, input));
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

    private Builder addOutput(NodeInfoImpl node) {
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

    @Override
    public Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level) {
        this.logSeverityLevel = level;
        return this;
    }

    @Override
    public Builder setLogVerbosityLevel(int level) {
        this.logVerbosityLevel = level;
        return this;
    }

    @Override
    public Builder setRunTag(String runTag) {
        this.runTag = runTag;
        return this;
    }

    @Override
    public Builder setRunConfigMap(Map<String, String> config) {
        this.config = config;
        return this;
    }

    MemoryAddress newRunOptions(MemorySession scope, MemorySegment memorySegment) {
        api.checkStatus(api.CreateRunOptions.apply(memorySegment.address()));
        MemoryAddress runOptions = memorySegment.getAtIndex(C_POINTER, 0);
        if (logSeverityLevel != null) {
            api.checkStatus(api.RunOptionsSetRunLogSeverityLevel.apply(runOptions, logSeverityLevel.getNumber()));
        }
        if (logVerbosityLevel != null) {
            api.checkStatus(api.RunOptionsSetRunLogVerbosityLevel.apply(runOptions, logVerbosityLevel));
        }
        if (runTag != null) {
            api.checkStatus(api.RunOptionsSetRunTag.apply(
                    runOptions, scope.allocateUtf8String(runTag).address()));
        }
        if (config != null && !config.isEmpty()) {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                api.checkStatus(api.AddRunConfigEntry.apply(
                        runOptions,
                        scope.allocateUtf8String(entry.getKey()).address(),
                        scope.allocateUtf8String(entry.getValue()).address()));
            }
        }
        return runOptions;
    }

    record InputTuple(NodeInfoImpl nodeInfo, OnnxValueImpl value) {}
}
