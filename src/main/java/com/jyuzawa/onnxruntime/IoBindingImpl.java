/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class IoBindingImpl implements IoBinding {
    private final ApiImpl api;
    private final Arena arena;
    private final MemorySegment ioBinding;
    private final MemorySegment runOptions;
    private final NamedCollectionImpl<OnnxValue> inputs;
    private final NamedCollectionImpl<OnnxValue> outputs;
    private final MemorySegment session;

    IoBindingImpl(Builder builder) {
        // NOTE: this is shared since we want to allow closing from another thread.
        this.arena = Arena.ofShared();
        this.api = builder.api;
        this.session = builder.session.address();
        this.ioBinding = builder.api.create(
                arena, out -> builder.api.CreateIoBinding.apply(session, out), api.ReleaseIoBinding::apply);
        this.runOptions = api.create(arena, out -> api.CreateRunOptions.apply(out), api.ReleaseRunOptions::apply);
        Map<String, String> config = builder.config;
        if (config != null && !config.isEmpty()) {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                api.checkStatus(api.AddRunConfigEntry.apply(
                        runOptions, arena.allocateFrom(entry.getKey()), arena.allocateFrom(entry.getValue())));
            }
        }
        List<NodeInfoImpl> rawInputs = builder.inputs;
        List<NodeInfoImpl> rawOutputs = builder.outputs;
        ValueContext valueContext = new ValueContext(
                builder.api, builder.session.environment.ortAllocator, builder.session.environment.memoryInfo, false);
        this.inputs = add(rawInputs, valueContext, api, ioBinding, true);
        this.outputs = add(rawOutputs, valueContext, api, ioBinding, false);
    }

    private static final NamedCollectionImpl<OnnxValue> add(
            List<NodeInfoImpl> nodes,
            ValueContext valueContext,
            ApiImpl api,
            MemorySegment ioBinding,
            boolean isInput) {
        LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(nodes.size());
        for (NodeInfoImpl node : nodes) {
            OnnxValueImpl output = node.getTypeInfo().newValue(valueContext, null);
            MemorySegment valueAddress = output.getNative();
            out.put(node.getName(), output);
            final MemorySegment result;
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
        int numInputs = inputs.size();
        for (int i = 0; i < numInputs; i++) {
            ((OnnxValueImpl) inputs.get(i)).dispose();
        }
        int numOutputs = outputs.size();
        for (int i = 0; i < numOutputs; i++) {
            ((OnnxValueImpl) outputs.get(i)).dispose();
        }
        arena.close();
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
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocateFrom(runTag);
            api.checkStatus(api.RunOptionsSetRunTag.apply(runOptions, segment));
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
