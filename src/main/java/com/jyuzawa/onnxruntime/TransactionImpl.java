/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class TransactionImpl implements Transaction {
    // private final Object cancelLock;
    // private MemoryAddress runOptions;

    private final Builder builder;

    TransactionImpl(Builder builder) {
        this.builder = builder;
        // this.cancelLock = new Object();
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
        ApiImpl api = builder.api;
        SessionImpl sessionImpl = builder.session;
        EnvironmentImpl environment = sessionImpl.environment;
        MemoryAddress ortAllocator = environment.ortAllocator;
        try (MemorySession session = MemorySession.openConfined()) {
            SegmentAllocator allocator = SegmentAllocator.newNativeArena(session);
            List<InputTuple> inputs = builder.inputs;
            int numInputs = inputs.size();
            List<NodeInfoImpl> outputs = builder.outputs;
            int numOutputs = outputs.size();
            MemorySegment inputNames = allocator.allocateArray(C_POINTER, numInputs);
            MemorySegment inputValues = allocator.allocateArray(C_POINTER, numInputs);
            MemorySegment outputNames = allocator.allocateArray(C_POINTER, numOutputs);
            MemorySegment outputValues = allocator.allocateArray(C_POINTER, numOutputs);
            List<MemoryAddress> inputValueAddresses = new ArrayList<>(numInputs);
            for (int i = 0; i < numInputs; i++) {
                InputTuple inputTuple = inputs.get(i);
                inputNames.setAtIndex(C_POINTER, i, inputTuple.nodeInfo().nameSegment);
                MemoryAddress valueAddress =
                        inputTuple.value().toNative(api, ortAllocator, environment.memoryInfo, allocator);
                inputValueAddresses.add(valueAddress);
                inputValues.setAtIndex(C_POINTER, i, valueAddress);
            }

            for (int i = 0; i < numOutputs; i++) {
                outputNames.setAtIndex(C_POINTER, i, outputs.get(i).nameSegment);
            }

            MemoryAddress runOptionsAddress = builder.newRunOptions(allocator);
            // synchronized (cancelLock) {
            // this.runOptions = runOptionsAddress;
            // }
            try {
                api.checkStatus(api.Run.apply(
                        sessionImpl.address(),
                        runOptionsAddress,
                        inputNames.address(),
                        inputValues.address(),
                        numInputs,
                        outputNames.address(),
                        numOutputs,
                        outputValues.address()));
            } finally {
                for (int i = 0; i < numInputs; i++) {
                    api.ReleaseValue.apply(inputValueAddresses.get(i));
                }
                // synchronized (cancelLock) {
                api.ReleaseRunOptions.apply(runOptionsAddress);
                // runOptions = null;
                // }
            }
            LinkedHashMap<String, OnnxValue> out = new LinkedHashMap<>(outputs.size());
            for (int i = 0; i < outputs.size(); i++) {
                MemoryAddress outputAddress = outputValues.getAtIndex(C_POINTER, i);
                // TODO: get typeinfo from result
                NodeInfoImpl nodeInfo = outputs.get(i);
                OnnxValueImpl outputValue = OnnxValueImpl.fromTypeInfo(nodeInfo.getTypeInfo());
                try {
                    outputValue.fromNative(api, ortAllocator, outputAddress, allocator, session);
                } finally {
                    api.ReleaseValue.apply(outputAddress);
                }
                out.put(nodeInfo.getName(), outputValue);
            }

            return new NamedCollectionImpl<>(out);
        }
    }

    static final class Builder implements Transaction.Builder {

        final ApiImpl api;
        final SessionImpl session;
        final List<InputTuple> inputs;
        final List<NodeInfoImpl> outputs;
        private OnnxRuntimeLoggingLevel logSeverityLevel;
        private Integer logVerbosityLevel;
        private String runTag;
        private Map<String, String> config;

        public Builder(SessionImpl session) {
            this.api = session.api;
            this.session = session;
            this.inputs = new ArrayList<>(session.inputs.size());
            this.outputs = new ArrayList<>(session.outputs.size());
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
            return addInput(session.inputs.get(name));
        }

        @Override
        public OnnxValue addInput(int index) {
            return addInput(session.inputs.get(index));
        }

        private Builder addOutput(NodeInfoImpl node) {
            outputs.add(node);
            return this;
        }

        @Override
        public Builder addOutput(String name) {
            return addOutput(session.outputs.get(name));
        }

        @Override
        public Builder addOutput(int index) {
            return addOutput(session.outputs.get(index));
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

        private MemoryAddress newRunOptions(SegmentAllocator scope) {
            MemoryAddress runOptions = api.create(scope, out -> api.CreateRunOptions.apply(out));
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
    }

    private record InputTuple(NodeInfoImpl nodeInfo, OnnxValueImpl value) {}
}
