package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toCString;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import com.jyuzawa.onnxruntime.extern.OrtApi;

import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

final class EnvironmentImpl extends ManagedImpl implements Environment {
	
	public EnvironmentImpl(ApiImpl api, ResourceScope scope, MemoryAddress address) {
		super(api, scope, address);
	}

	public Session.Builder newSession() {
		return new SessionBuilderImpl(api, address);
	}

	@Override
	public void setTelemetryEvents(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLanguageProjection(int languageProjection) {
		// TODO Auto-generated method stub
		
	}
	
}
