/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
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
        // NOTE: this is shared since we want to allow closing from another thread.
        this.memorySession = MemorySession.openShared();
        this.api = builder.api;
        this.session = builder.session.address();
        this.ioBinding = builder.api.create(memorySession, out -> builder.api.CreateIoBinding.apply(session, out));
        this.runOptions = api.create(memorySession, out -> api.CreateRunOptions.apply(out));
        Map<String, String> config = builder.config;
        if (config != null && !config.isEmpty()) {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                api.checkStatus(api.AddRunConfigEntry.apply(
                        runOptions,
                        memorySession.allocateUtf8String(entry.getKey()).address(),
                        memorySession.allocateUtf8String(entry.getValue()).address()));
            }
        }
        ValueContext valueContext = new ValueContext(
                builder.api,
                memorySession,
                memorySession,
                builder.session.environment.ortAllocator,
                builder.session.environment.memoryInfo);
        this.inputs = add(builder.inputs, valueContext, memorySession, api, ioBinding, true);
        this.outputs = add(builder.outputs, valueContext, memorySession, api, ioBinding, false);
    }

    private static final NamedCollectionImpl<OnnxValue> add(
            List<NodeInfoImpl> nodes,
            ValueContext valueContext,
            MemorySession memorySession,
            ApiImpl api,
            MemoryAddress ioBinding,
            boolean isInput) {
        LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(nodes.size());
        for (NodeInfoImpl node : nodes) {
            OnnxValueImpl output = node.getTypeInfo().newValue(valueContext, null);
            MemoryAddress valueAddress = output.toNative();
            memorySession.addCloseAction(() -> api.ReleaseValue.apply(valueAddress));
            out.put(node.getName(), output);
            final Addressable result;
            if (isInput) {
                result = api.BindInput.apply(ioBinding, node.nameSegment, valueAddress);
            } else {
                result = api.BindOutput.apply(ioBinding, node.nameSegment, valueAddress);
            }
            api.checkStatus(result);
        }
        return new NamedCollectionImpl<>(out);
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
            this.inputs = new ArrayList<>(session.inputs.size());
            this.outputs = new ArrayList<>(session.outputs.size());
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

    @Override
    public IoBinding synchronizeBoundInputs() {
        api.checkStatus(api.SynchronizeBoundInputs.apply(ioBinding));
        return this;
    }

    @Override
    public IoBinding synchronizeBoundOutputs() {
        api.checkStatus(api.SynchronizeBoundOutputs.apply(ioBinding));
        return this;
    }
}
