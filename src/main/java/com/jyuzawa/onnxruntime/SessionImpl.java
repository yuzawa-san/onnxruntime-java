package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.toJavaString;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jyuzawa.onnxruntime.extern.OrtApi;

import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;


final class SessionImpl extends ManagedImpl implements Session {
	
	private final Map<String,NodeInfo> overridableInitializers;
	private final Map<String,NodeInfo> inputs;
	private final Map<String,NodeInfo> outputs;
	private final ModelMetadata modelMetadata;
	
	public SessionImpl(ApiImpl api, ResourceScope scope, MemoryAddress session) {
		super(api, scope, session);
		SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
		MemoryAddress ortAllocator = api.create(allocator, out -> api.GetAllocatorWithDefaultOptions.apply(out));
		this.overridableInitializers = createMap(api, allocator, ortAllocator,session, api.SessionGetOverridableInitializerCount::apply, api.SessionGetOverridableInitializerName::apply, api.SessionGetOverridableInitializerTypeInfo::apply);
		this.inputs = createMap(api, allocator, ortAllocator,session, api.SessionGetInputCount::apply, api.SessionGetInputName::apply, api.SessionGetInputTypeInfo::apply);
		this.outputs = createMap(api, allocator, ortAllocator,session, api.SessionGetOutputCount::apply, api.SessionGetOutputName::apply, api.SessionGetOutputTypeInfo::apply);
		
		MemoryAddress metadata = api.create(allocator, out-> api.SessionGetModelMetadata.apply(session, out));
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
	
	private static Map<String,NodeInfo> createMap(ApiImpl api, SegmentAllocator allocator, MemoryAddress ortAllocator, MemoryAddress session,
			GetCount getCount, GetName getName, GetTypeInfo getTypeInfo) {
		MemorySegment numInputsSegment = allocator.allocate(C_LONG);
		api.checkStatus(getCount.apply(session, numInputsSegment.address()));
		long numInputs = MemoryAccess.getLong(numInputsSegment);
		Map<String,NodeInfo> inputs = new LinkedHashMap<>();
		for( long i = 0; i < numInputs; i++) {
			final long j = i;
			MemoryAddress nameSegment = api.create(allocator, out-> getName.apply(session, j, ortAllocator, out));
			String name = toJavaString(nameSegment);
			api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
			MemoryAddress typeInfoAddress = api.create(allocator, out-> getTypeInfo.apply(session, j, out));
			TypeInfoImpl typeInfo = new TypeInfoImpl(api,typeInfoAddress,ortAllocator);
			api.checkStatus(api.AllocatorFree.apply(ortAllocator, typeInfoAddress));
			inputs.put(name, new NodeInfoImpl(name, typeInfo));
		}
		return Collections.unmodifiableMap(inputs);
	}

	
	@Override
	public Map<String,NodeInfo> getOverridableInitializers() {
		return overridableInitializers;
	}

	@Override
	public Map<String,NodeInfo> getInputs() {
		return inputs;
	}

	@Override
	public ModelMetadata getModelMetadata() {
		return modelMetadata;
	}

	@Override
	public Map<String,NodeInfo> getOutputs() {
		return outputs;
	}


	@Override
	public Transaction.Builder newTransaction() {
		return null;//new TransactionBuilderImpl();
	}



}
