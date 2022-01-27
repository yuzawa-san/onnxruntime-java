package com.jyuzawa.onnxruntime;

import java.nio.file.Path;

import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OrtSessionOptions extends ManagedImpl {

	public OrtSessionOptions(ApiImpl api, ResourceScope scope, MemoryAddress address) {
		super(api, scope, address);
	}
	
	void enableProfiling(Path optimizedModelFilepath) {
		api.EnableProfiling.apply(address, address);
	}
	

}
