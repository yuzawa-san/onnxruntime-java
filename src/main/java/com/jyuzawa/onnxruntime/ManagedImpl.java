package com.jyuzawa.onnxruntime;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import com.jyuzawa.onnxruntime.extern.OrtApi;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

class ManagedImpl implements Managed {
	
	protected final ApiImpl api;
	protected final ResourceScope scope;
	protected final MemoryAddress address;

	public ManagedImpl(ApiImpl api, ResourceScope scope, MemoryAddress address) {
		this.api = api;
		this.scope = scope;
		this.address = address;
	}
	
	public void close() {
		scope.close();
	}
	
	public String toString() {
		return "{"+getClass().getSimpleName()+": "+address+"}";
	}

}
