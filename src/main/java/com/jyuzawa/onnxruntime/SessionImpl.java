/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtArenaAllocator;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtMemTypeDefault;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.nio.file.Path;
import java.util.LinkedHashMap;

final class SessionImpl extends ManagedImpl implements Session {

    private final NamedCollection<NodeInfoImpl> overridableInitializers;
    private final NamedCollection<NodeInfoImpl> inputs;
    private final NamedCollection<NodeInfoImpl> outputs;
    private final ModelMetadata modelMetadata;
    private final MemoryAddress memoryInfo;
    private final MemoryAddress ortAllocator;

    public SessionImpl(ApiImpl api, MemorySession allocator, MemoryAddress session) {
        super(api, allocator, session);
        this.ortAllocator = api.create(allocator, out -> api.GetAllocatorWithDefaultOptions.apply(out));
        this.overridableInitializers = createMap(
                api,
                allocator,
                ortAllocator,
                session,
                api.SessionGetOverridableInitializerCount::apply,
                api.SessionGetOverridableInitializerName::apply,
                api.SessionGetOverridableInitializerTypeInfo::apply);
        this.inputs = createMap(
                api,
                allocator,
                ortAllocator,
                session,
                api.SessionGetInputCount::apply,
                api.SessionGetInputName::apply,
                api.SessionGetInputTypeInfo::apply);
        this.outputs = createMap(
                api,
                allocator,
                ortAllocator,
                session,
                api.SessionGetOutputCount::apply,
                api.SessionGetOutputName::apply,
                api.SessionGetOutputTypeInfo::apply);
        this.modelMetadata = new ModelMetadataImpl(api, session, ortAllocator);
        this.memoryInfo = api.create(
                allocator, out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out));
        allocator.addCloseAction(() -> {
            api.ReleaseMemoryInfo.apply(memoryInfo);
        });
    }

    private interface GetCount {
        Addressable apply(MemoryAddress session, MemoryAddress out);
    }

    private interface GetName {
        Addressable apply(MemoryAddress session, long idx, MemoryAddress ortAllocator, MemoryAddress out);
    }

    private interface GetTypeInfo {
        Addressable apply(MemoryAddress session, long idx, MemoryAddress out);
    }

    private static NamedCollection<NodeInfoImpl> createMap(
            ApiImpl api,
            MemorySession allocator,
            MemoryAddress ortAllocator,
            MemoryAddress session,
            GetCount getCount,
            GetName getName,
            GetTypeInfo getTypeInfo) {
        MemorySegment numInputsSegment = allocator.allocate(C_LONG);
        api.checkStatus(getCount.apply(session, numInputsSegment.address()));
        long numInputs = numInputsSegment.getAtIndex(C_LONG, 0);
        LinkedHashMap<String, NodeInfoImpl> inputs = new LinkedHashMap<>();
        for (long i = 0; i < numInputs; i++) {
            final long j = i;
            MemoryAddress nameSegment = api.create(allocator, out -> getName.apply(session, j, ortAllocator, out));
            String name = nameSegment.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
            MemoryAddress typeInfoAddress = api.create(allocator, out -> getTypeInfo.apply(session, j, out));
            TypeInfoImpl typeInfo = new TypeInfoImpl(api, typeInfoAddress, allocator, ortAllocator);
            inputs.put(name, new NodeInfoImpl(name, allocator.allocateUtf8String(name), typeInfo));
        }
        return new NamedCollectionImpl<>(inputs);
    }

    @Override
    public long getProfilingStartTimeInNs() {
        try (MemorySession session = MemorySession.openConfined()) {
            return api.extractLong(session, out -> api.SessionGetProfilingStartTimeNs.apply(address, out));
        }
    }

    @Override
    public Path endProfiling() {
        try (MemorySession session = MemorySession.openConfined()) {
            MemoryAddress path = api.create(session, out -> api.SessionEndProfiling.apply(address, ortAllocator, out));
            return Path.of(path.getUtf8String(0));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public NamedCollection<NodeInfo> getOverridableInitializers() {
        return (NamedCollection<NodeInfo>) (NamedCollection<?>) overridableInitializers;
    }

    @SuppressWarnings("unchecked")
    @Override
    public NamedCollection<NodeInfo> getInputs() {
        return (NamedCollection<NodeInfo>) (NamedCollection<?>) inputs;
    }

    @Override
    public ModelMetadata getModelMetadata() {
        return modelMetadata;
    }

    @SuppressWarnings("unchecked")
    @Override
    public NamedCollection<NodeInfo> getOutputs() {
        return (NamedCollection<NodeInfo>) (NamedCollection<?>) outputs;
    }

    @Override
    public Transaction.Builder newTransaction() {
        return new TransactionBuilderImpl(api, address, memoryInfo, ortAllocator, inputs, outputs);
    }
}
