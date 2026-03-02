/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class TransactionImpl implements Transaction {
    private final Builder builder;
    private final List<InputTuple> inputs;
    private final List<NodeInfoImpl> outputs;
    private final ValueContext valueContext;
    private final List<OnnxValueImpl> references;

    TransactionImpl(Builder builder) {
        this.builder = builder;
        this.inputs = new ArrayList<>(builder.session.inputs.size());
        this.outputs = new ArrayList<>(builder.session.outputs.size());
        this.references = new LinkedList<>();
        this.valueContext = new ValueContext(
                builder.api, builder.session.environment.ortAllocator, builder.session.environment.memoryInfo, false);
    }

    @Override
    public void close() {
        for (OnnxValueImpl reference : references) {
            reference.dispose();
        }
    }

    private OnnxValue addInput(NodeInfoImpl node) {
        OnnxValueImpl input = node.getTypeInfo().newValue(valueContext, null);
        references.add(input);
        inputs.add(new InputTuple(node, input));
        return input;
    }

    @Override
    public OnnxValue addInput(String name) {
        return addInput(builder.session.inputs.get(name));
    }

    @Override
    public OnnxValue addInput(int index) {
        return addInput(builder.session.inputs.get(index));
    }

    @Override
    public void addOutput(String name) {
        outputs.add(builder.session.outputs.get(name));
    }

    @Override
    public void addOutput(int index) {
        outputs.add(builder.session.outputs.get(index));
    }

    // @Override
    // public void cancel() {
    // synchronized (cancelLock) {
    // if (runOptions != null) {
    // ApiImpl api = builder.api;
    // api.checkStatus(api.RunOptionsSetTerminate.apply(runOptions));
    // }
    // }
    // }

    @Override
    public NamedCollection<OnnxValue> run() {
        NamedCollection<OnnxValue> out = run(builder, inputs, outputs, valueContext);
        int numOutputs = out.size();
        for (int i = 0; i < numOutputs; i++) {
            references.add((OnnxValueImpl) out.get(i));
        }
        return out;
    }

    private static NamedCollection<OnnxValue> run(
            Builder builder, List<InputTuple> inputs, List<NodeInfoImpl> outputs, ValueContext valueContext) {
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("No inputs specified");
        }
        if (outputs.isEmpty()) {
            throw new IllegalArgumentException("No outputs specified");
        }
        try (Arena arena = Arena.ofConfined()) {
            ApiImpl api = builder.api;
            SessionImpl sessionImpl = builder.session;
            int numInputs = inputs.size();
            int numOutputs = outputs.size();
            MemorySegment inputNames = arena.allocate(C_POINTER, numInputs);
            MemorySegment inputValues = arena.allocate(C_POINTER, numInputs);
            MemorySegment outputNames = arena.allocate(C_POINTER, numOutputs);
            MemorySegment outputValues = arena.allocate(C_POINTER, numOutputs);
            for (int i = 0; i < numInputs; i++) {
                InputTuple inputTuple = inputs.get(i);
                inputNames.setAtIndex(C_POINTER, i, inputTuple.nodeInfo().nameSegment);
                MemorySegment valueAddress = inputTuple.value().getNative();
                inputValues.setAtIndex(C_POINTER, i, valueAddress);
            }

            for (int i = 0; i < numOutputs; i++) {
                outputNames.setAtIndex(C_POINTER, i, outputs.get(i).nameSegment);
            }

            MemorySegment runOptionsAddress = builder.newRunOptions(arena);
            api.checkStatus(api.Run.apply(
                    sessionImpl.address(),
                    runOptionsAddress,
                    inputNames,
                    inputValues,
                    numInputs,
                    outputNames,
                    numOutputs,
                    outputValues));
            LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(outputs.size());
            for (int i = 0; i < outputs.size(); i++) {
                MemorySegment outputAddress = outputValues.getAtIndex(C_POINTER, i);
                NodeInfoImpl nodeInfo = outputs.get(i);
                OnnxValueImpl outputValue = nodeInfo.getTypeInfo().newValue(valueContext, outputAddress);
                out.put(nodeInfo.getName(), outputValue);
            }

            return new NamedCollectionImpl<>(out);
        }
    }

    static final class Builder implements Transaction.Builder {

        final ApiImpl api;
        final SessionImpl session;
        private OnnxRuntimeLoggingLevel logSeverityLevel;
        private Integer logVerbosityLevel;
        private String runTag;
        private Map<String, String> config;

        public Builder(SessionImpl session) {
            this.api = session.api;
            this.session = session;
        }

        @Override
        public Transaction build() {
            return new TransactionImpl(this);
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
        public Builder setConfigMap(Map<String, String> config) {
            this.config = config;
            return this;
        }

        private MemorySegment newRunOptions(Arena arena) {
            MemorySegment runOptions =
                    api.create(arena, out -> api.CreateRunOptions.apply(out), api.ReleaseRunOptions::apply);
            if (logSeverityLevel != null) {
                api.checkStatus(api.RunOptionsSetRunLogSeverityLevel.apply(runOptions, logSeverityLevel.getNumber()));
            }
            if (logVerbosityLevel != null) {
                api.checkStatus(api.RunOptionsSetRunLogVerbosityLevel.apply(runOptions, logVerbosityLevel));
            }
            if (runTag != null) {
                api.checkStatus(api.RunOptionsSetRunTag.apply(runOptions, arena.allocateFrom(runTag)));
            }
            if (config != null && !config.isEmpty()) {
                for (Map.Entry<String, String> entry : config.entrySet()) {
                    api.checkStatus(api.AddRunConfigEntry.apply(
                            runOptions, arena.allocateFrom(entry.getKey()), arena.allocateFrom(entry.getValue())));
                }
            }
            return runOptions;
        }

        @Override
        public NamedCollection<OnnxValue> run(Map<String, ? super OnnxValue> inputs, List<String> outputs) {
            List<InputTuple> inputTuples = new ArrayList<>(inputs.size());
            inputs.forEach(
                    (key, value) -> inputTuples.add(new InputTuple(session.inputs.get(key), (OnnxValueImpl) value)));
            int numOutputs = outputs.size();
            List<NodeInfoImpl> outputNodes = new ArrayList<>(numOutputs);
            for (int i = 0; i < numOutputs; i++) {
                outputNodes.add(session.outputs.get(outputs.get(i)));
            }
            ValueContext valueContext =
                    new ValueContext(api, session.environment.ortAllocator, session.environment.memoryInfo, true);
            return TransactionImpl.run(this, inputTuples, outputNodes, valueContext);
        }
    }

    private record InputTuple(NodeInfoImpl nodeInfo, OnnxValueImpl value) {}
}
