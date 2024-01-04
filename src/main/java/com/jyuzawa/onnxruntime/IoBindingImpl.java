/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class IoBindingImpl implements IoBinding {
    private final ApiImpl api;
    private final MemorySession memorySession;
    private final MemoryAddress ioBinding;
    private final MemoryAddress runOptions;
    private final NamedCollectionImpl<OnnxValue> inputs;
    private final NamedCollectionImpl<OnnxValue> outputs;
    private final MemoryAddress session;

    IoBindingImpl(Builder builder) {
        this.memorySession = MemorySession.openConfined();
        this.api = builder.api;
        this.session = builder.session.address();
        SegmentAllocator allocator = SegmentAllocator.newNativeArena(memorySession);
        this.ioBinding = builder.api.create(allocator, out -> builder.api.CreateIoBinding.apply(session, out));
        this.runOptions = api.create(allocator, out -> api.CreateRunOptions.apply(out));
        Map<String, String> config = builder.config;
        if (config != null && !config.isEmpty()) {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                api.checkStatus(api.AddRunConfigEntry.apply(
                        runOptions,
                        allocator.allocateUtf8String(entry.getKey()).address(),
                        allocator.allocateUtf8String(entry.getValue()).address()));
            }
        }
        ValueContext valueContext = new ValueContext(
                builder.api,
                allocator,
                memorySession,
                builder.session.environment.ortAllocator,
                builder.session.environment.memoryInfo);

        LinkedHashMap<String, OnnxValue> rawInputs = new LinkedHashMap<>(builder.inputs.size());
        for (NodeInfoImpl inputNode : builder.inputs) {
            OnnxValueImpl input = inputNode.getTypeInfo().newValue(valueContext, null);
            MemoryAddress valueAddress = input.toNative();
            memorySession.addCloseAction(() -> builder.api.ReleaseValue.apply(valueAddress));
            rawInputs.put(inputNode.getName(), input);
            builder.api.checkStatus(
                    api.BindInput.apply(ioBinding.address(), inputNode.nameSegment.address(), valueAddress.address()));
        }
        this.inputs = new NamedCollectionImpl<>(rawInputs);

        LinkedHashMap<String, OnnxValue> rawOutputs = new LinkedHashMap<>(builder.outputs.size());
        for (NodeInfoImpl outputNode : builder.outputs) {
            OnnxValueImpl output = outputNode.getTypeInfo().newValue(valueContext, null);
            MemoryAddress valueAddress = output.toNative();
            memorySession.addCloseAction(() -> builder.api.ReleaseValue.apply(valueAddress));
            rawOutputs.put(outputNode.getName(), output);
            builder.api.checkStatus(api.BindOutput.apply(
                    ioBinding.address(), outputNode.nameSegment.address(), valueAddress.address()));
        }
        this.outputs = new NamedCollectionImpl<>(rawOutputs);
    }

    @Override
    public void close() {
        api.ReleaseIoBinding.apply(ioBinding);
        api.ReleaseRunOptions.apply(runOptions);
        memorySession.close();
    }

    @Override
    public void run() {
        api.checkStatus(api.RunWithBinding.apply(session, runOptions, ioBinding));
    }

    static final class Builder implements IoBinding.Builder {

        final ApiImpl api;
        final SessionImpl session;
        private Map<String, String> config;
        final List<NodeInfoImpl> inputs;
        final List<NodeInfoImpl> outputs;

        public Builder(SessionImpl session) {
            this.api = session.api;
            this.session = session;
            this.inputs = new ArrayList<>();
            this.outputs = new ArrayList<>();
        }

        @Override
        public IoBinding build() {
            if (inputs.isEmpty()) {
                throw new IllegalArgumentException("No inputs specified");
            }
            if (outputs.isEmpty()) {
                throw new IllegalArgumentException("No outputs specified");
            }
            return new IoBindingImpl(this);
        }

        @Override
        public Builder setConfigMap(Map<String, String> config) {
            this.config = config;
            return this;
        }

        private void accumulate(List<NodeInfoImpl> list, NodeInfoImpl nodeInfo) {
            if (nodeInfo == null) {
                throw new IllegalArgumentException("node info missing");
            }
            list.add(nodeInfo);
        }

        @Override
        public Builder bindInput(String name) {
            accumulate(inputs, session.inputs.get(name));
            return this;
        }

        @Override
        public Builder bindInput(int index) {
            accumulate(inputs, session.inputs.get(index));
            return this;
        }

        @Override
        public Builder bindOutput(String name) {
            accumulate(outputs, session.outputs.get(name));
            return this;
        }

        @Override
        public Builder bindOutput(int index) {
            accumulate(outputs, session.outputs.get(index));
            return this;
        }
    }

    @Override
    public IoBinding setLogSeverityLevel(OnnxRuntimeLoggingLevel level) {
        api.checkStatus(api.RunOptionsSetRunLogSeverityLevel.apply(runOptions, level.getNumber()));
        return this;
    }

    @Override
    public IoBinding setLogVerbosityLevel(int level) {
        api.checkStatus(api.RunOptionsSetRunLogVerbosityLevel.apply(runOptions, level));
        return this;
    }

    @Override
    public IoBinding setRunTag(String runTag) {
        try (MemorySession allocator = MemorySession.openConfined()) {
            MemorySegment segment = allocator.allocateUtf8String(runTag);
            api.checkStatus(api.RunOptionsSetRunTag.apply(runOptions, segment.address()));
        }
        return this;
    }

    @Override
    public NamedCollection<OnnxValue> getInputs() {
        return inputs;
    }

    @Override
    public NamedCollection<OnnxValue> getOutputs() {
        return outputs;
    }
}