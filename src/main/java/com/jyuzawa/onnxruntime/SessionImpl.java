/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static java.lang.foreign.ValueLayout.JAVA_LONG;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.LinkedHashMap;

final class SessionImpl extends ManagedImpl implements Session {

    private final NamedCollection<NodeInfo> overridableInitializers;
    private final NamedCollection<NodeInfo> inputs;
    private final NamedCollection<NodeInfo> outputs;
    private final ModelMetadata modelMetadata;
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
        MemoryAddress metadata = api.create(allocator, out -> api.SessionGetModelMetadata.apply(session, out));
        this.modelMetadata = new ModelMetadataImpl(api, metadata, ortAllocator);
        api.ReleaseModelMetadata.apply(metadata);
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

    private static NamedCollection<NodeInfo> createMap(
            ApiImpl api,
            MemorySession allocator,
            MemoryAddress ortAllocator,
            MemoryAddress session,
            GetCount getCount,
            GetName getName,
            GetTypeInfo getTypeInfo) {
        MemorySegment numInputsSegment = allocator.allocate(JAVA_LONG);
        api.checkStatus(getCount.apply(session, numInputsSegment.address()));
        long numInputs = numInputsSegment.get(JAVA_LONG, 0);
        LinkedHashMap<String, NodeInfo> inputs = new LinkedHashMap<>();
        for (long i = 0; i < numInputs; i++) {
            final long j = i;
            MemoryAddress nameSegment = api.create(allocator, out -> getName.apply(session, j, ortAllocator, out));
            String name = nameSegment.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
            MemoryAddress typeInfoAddress = api.create(allocator, out -> getTypeInfo.apply(session, j, out));
            TypeInfoImpl typeInfo = new TypeInfoImpl(api, typeInfoAddress, ortAllocator);
            inputs.put(name, new NodeInfoImpl(name, typeInfo));
        }
        return new NamedCollectionImpl<>(inputs);
    }

    @Override
    public NamedCollection<NodeInfo> getOverridableInitializers() {
        return overridableInitializers;
    }

    @Override
    public NamedCollection<NodeInfo> getInputs() {
        return inputs;
    }

    @Override
    public ModelMetadata getModelMetadata() {
        return modelMetadata;
    }

    @Override
    public NamedCollection<NodeInfo> getOutputs() {
        return outputs;
    }

    @Override
    public Transaction.Builder newTransaction() {
        return new TransactionBuilderImpl(api, address, ortAllocator, inputs, outputs);
    }
}
