/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.Buffer;
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
    private final List<Runnable> closeables;
    private final MemorySegment session;

    IoBindingImpl(Builder builder) {
        // NOTE: this is shared since we want to allow closing from another thread.
        this.arena = Arena.ofShared();
        this.api = builder.api;
        this.session = builder.session.address();
        this.ioBinding = builder.api.create(arena, out -> builder.api.CreateIoBinding.apply(session, out));
        this.runOptions = api.create(arena, out -> api.CreateRunOptions.apply(out));
        Map<String, String> config = builder.config;
        if (config != null && !config.isEmpty()) {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                api.checkStatus(api.AddRunConfigEntry.apply(
                        runOptions, arena.allocateFrom(entry.getKey()), arena.allocateFrom(entry.getValue())));
            }
        }
        List<Builder.BindingBuilderImpl> rawInputs = builder.inputs;
        List<Builder.BindingBuilderImpl> rawOutputs = builder.outputs;
        this.closeables = new ArrayList<>(rawInputs.size() + rawOutputs.size());
        ValueContext valueContext = new ValueContext(
                builder.api,
                arena,
                builder.session.environment.ortAllocator,
                builder.session.environment.memoryInfo,
                closeables);
        this.inputs = add(rawInputs, valueContext, api, ioBinding, true);
        this.outputs = add(rawOutputs, valueContext, api, ioBinding, false);
    }

    private static final NamedCollectionImpl<OnnxValue> add(
            List<Builder.BindingBuilderImpl> bindingTuples,
            ValueContext valueContext,
            ApiImpl api,
            MemorySegment ioBinding,
            boolean isInput) {
        LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(bindingTuples.size());
        for (Builder.BindingBuilderImpl bindingTuple : bindingTuples) {
            NodeInfoImpl node = bindingTuple.node;
            OnnxValueImpl output = node.getTypeInfo().newValue(valueContext, null);
            MemorySegment memorySegment = bindingTuple.memorySegment;
            Buffer buffer = bindingTuple.buffer;
            if (memorySegment != null) {
                output.asTensor().wrap(memorySegment);
            } else if (buffer != null) {
                output.asTensor().wrap(buffer);
            }
            MemorySegment valueAddress = output.toNative();
            valueContext.closeables().add(() -> api.ReleaseValue.apply(valueAddress));
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
        api.ReleaseIoBinding.apply(ioBinding);
        api.ReleaseRunOptions.apply(runOptions);
        for (Runnable closeable : closeables) {
            closeable.run();
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
        final List<BindingBuilderImpl> inputs;
        final List<BindingBuilderImpl> outputs;

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

        @Override
        public BindingBuilder newInput() {
            BindingBuilderImpl bindingBuilder = new BindingBuilderImpl(session.inputs);
            inputs.add(bindingBuilder);
            return bindingBuilder;
        }

        @Override
        public BindingBuilder newOutput() {
            BindingBuilderImpl bindingBuilder = new BindingBuilderImpl(session.outputs);
            outputs.add(bindingBuilder);
            return bindingBuilder;
        }

        private class BindingBuilderImpl implements BindingBuilder {

            private NodeInfoImpl node;
            private MemorySegment memorySegment;
            private Buffer buffer;

            private final NamedCollection<NodeInfoImpl> nodes;

            private BindingBuilderImpl(NamedCollection<NodeInfoImpl> nodes) {
                this.nodes = nodes;
            }

            private BindingBuilder setNode(NodeInfoImpl theNode) {
                if (theNode == null) {
                    throw new IllegalArgumentException("node info not found");
                }
                if (theNode.getTypeInfo().getType() != OnnxType.TENSOR) {
                    throw new IllegalArgumentException("Only tensors are supported");
                }
                this.node = theNode;
                return this;
            }

            @Override
            public BindingBuilder index(int index) {
                return setNode(nodes.get(index));
            }

            @Override
            public BindingBuilder name(String name) {
                return setNode(nodes.get(name));
            }

            @Override
            public BindingBuilder memorySegment(MemorySegment newMemorySegment) {
                this.memorySegment = newMemorySegment;
                return this;
            }

            @Override
            public BindingBuilder buffer(Buffer newBuffer) {
                this.buffer = newBuffer;
                return this;
            }

            @Override
            public Builder bind() {
                if (node == null) {
                    throw new IllegalStateException("node is missing");
                }
                if (memorySegment != null && buffer != null) {
                    throw new IllegalStateException("both MemorySegment and Buffer are present");
                }
                return Builder.this;
            }
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
