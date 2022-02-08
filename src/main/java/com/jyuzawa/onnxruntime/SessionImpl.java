/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.*;
import static jdk.incubator.foreign.CLinker.*;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.toJavaString;

import java.util.LinkedHashMap;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class SessionImpl extends ManagedImpl implements Session {

    private final NamedCollection<NodeInfo> overridableInitializers;
    private final NamedCollection<NodeInfo> inputs;
    private final NamedCollection<NodeInfo> outputs;
    private final ModelMetadata modelMetadata;
    private final MemoryAddress ortAllocator;

    public SessionImpl(ApiImpl api, ResourceScope scope, MemoryAddress session) {
        super(api, scope, session);
        SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
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
        MemoryAddress apply(MemoryAddress session, MemoryAddress out);
    }

    private interface GetName {
        MemoryAddress apply(MemoryAddress session, long idx, MemoryAddress ortAllocator, MemoryAddress out);
    }

    private interface GetTypeInfo {
        MemoryAddress apply(MemoryAddress session, long idx, MemoryAddress out);
    }

    private static NamedCollection<NodeInfo> createMap(
            ApiImpl api,
            SegmentAllocator allocator,
            MemoryAddress ortAllocator,
            MemoryAddress session,
            GetCount getCount,
            GetName getName,
            GetTypeInfo getTypeInfo) {
        MemorySegment numInputsSegment = allocator.allocate(C_LONG);
        api.checkStatus(getCount.apply(session, numInputsSegment.address()));
        long numInputs = MemoryAccess.getLong(numInputsSegment);
        LinkedHashMap<String, NodeInfo> inputs = new LinkedHashMap<>();
        for (long i = 0; i < numInputs; i++) {
            final long j = i;
            MemoryAddress nameSegment = api.create(allocator, out -> getName.apply(session, j, ortAllocator, out));
            String name = toJavaString(nameSegment);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
            MemoryAddress typeInfoAddress = api.create(allocator, out -> getTypeInfo.apply(session, j, out));
            TypeInfoImpl typeInfo = new TypeInfoImpl(api, typeInfoAddress, ortAllocator);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, typeInfoAddress));
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
        return new TransactionBuilderImpl(api, address, ortAllocator);
    }
}
