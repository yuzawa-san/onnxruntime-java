/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class TransactionImpl implements Transaction {
    // private final Object cancelLock;
    // private MemoryAddress runOptions;

    private final Arena memorySession;
    private final SegmentAllocator allocator;
    private final Builder builder;
    private final List<InputTuple> inputs;
    private final List<NodeInfoImpl> outputs;
    private final ValueContext valueContext;

    TransactionImpl(Builder builder) {
        this.memorySession = Arena.ofConfined();
        this.allocator = memorySession;
        this.builder = builder;
        this.inputs = new ArrayList<>(builder.session.inputs.size());
        this.outputs = new ArrayList<>(builder.session.outputs.size());
        this.valueContext = new ValueContext(
                builder.api,
                allocator,
                memorySession,
                builder.session.environment.ortAllocator,
                builder.session.environment.memoryInfo);
        // this.cancelLock = new Object();
    }

    @Override
    public void close() {
        memorySession.close();
    }

    private OnnxValue addInput(NodeInfoImpl node) {
        OnnxValueImpl input = node.getTypeInfo().newValue(valueContext, null);
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
        if (inputs.isEmpty()) {
            throw new IllegalArgumentException("No inputs specified");
        }
        if (outputs.isEmpty()) {
            throw new IllegalArgumentException("No outputs specified");
        }
        ApiImpl api = builder.api;
        SessionImpl sessionImpl = builder.session;
        int numInputs = inputs.size();
        int numOutputs = outputs.size();
        MemorySegment inputNames = allocator.allocateArray(C_POINTER, numInputs);
        MemorySegment inputValues = allocator.allocateArray(C_POINTER, numInputs);
        MemorySegment outputNames = allocator.allocateArray(C_POINTER, numOutputs);
        MemorySegment outputValues = allocator.allocateArray(C_POINTER, numOutputs);
        List<MemorySegment> inputSegments = new ArrayList<>(numInputs);
        for (int i = 0; i < numInputs; i++) {
            InputTuple inputTuple = inputs.get(i);
            inputNames.setAtIndex(C_POINTER, i, inputTuple.nodeInfo().nameSegment);
            MemorySegment valueAddress = inputTuple.value().toNative();
            inputSegments.add(valueAddress);
            inputValues.setAtIndex(C_POINTER, i, valueAddress);
        }

        for (int i = 0; i < numOutputs; i++) {
            outputNames.setAtIndex(C_POINTER, i, outputs.get(i).nameSegment);
        }

        MemorySegment runOptionsAddress = builder.newRunOptions(allocator);
        // synchronized (cancelLock) {
        // this.runOptions = runOptionsAddress;
        // }
        try {
            api.checkStatus(api.Run.apply(
                    sessionImpl.address(),
                    runOptionsAddress,
                    inputNames,
                    inputValues,
                    numInputs,
                    outputNames,
                    numOutputs,
                    outputValues));
        } finally {
            // synchronized (cancelLock) {
            api.ReleaseRunOptions.apply(runOptionsAddress);
            // runOptions = null;
            // }
            for (int i = 0; i < numInputs; i++) {
                api.ReleaseValue.apply(inputSegments.get(i));
            }
        }
        LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(outputs.size());
        for (int i = 0; i < outputs.size(); i++) {
            MemorySegment outputAddress = outputValues.getAtIndex(C_POINTER, i);
            // TODO: get typeinfo from result
            NodeInfoImpl nodeInfo = outputs.get(i);
            OnnxValueImpl outputValue = nodeInfo.getTypeInfo().newValue(valueContext, outputAddress);
            api.ReleaseValue.apply(outputAddress);
            out.put(nodeInfo.getName(), outputValue);
        }

        return new NamedCollectionImpl<>(out);
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

        private MemorySegment newRunOptions(SegmentAllocator scope) {
            MemorySegment runOptions = api.create(scope, out -> api.CreateRunOptions.apply(out));
            if (logSeverityLevel != null) {
                api.checkStatus(api.RunOptionsSetRunLogSeverityLevel.apply(runOptions, logSeverityLevel.getNumber()));
            }
            if (logVerbosityLevel != null) {
                api.checkStatus(api.RunOptionsSetRunLogVerbosityLevel.apply(runOptions, logVerbosityLevel));
            }
            if (runTag != null) {
                api.checkStatus(api.RunOptionsSetRunTag.apply(runOptions, scope.allocateUtf8String(runTag)));
            }
            if (config != null && !config.isEmpty()) {
                for (Map.Entry<String, String> entry : config.entrySet()) {
                    api.checkStatus(api.AddRunConfigEntry.apply(
                            runOptions,
                            scope.allocateUtf8String(entry.getKey()),
                            scope.allocateUtf8String(entry.getValue())));
                }
            }
            return runOptions;
        }
    }

    private record InputTuple(NodeInfoImpl nodeInfo, OnnxValueImpl value) {}
}
