package com.jyuzawa.onnxruntime;

import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.incubator.foreign.SymbolLookup;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;

import jdk.incubator.foreign.Addressable;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.*;
import static jdk.incubator.foreign.CLinker.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

import com.jyuzawa.onnxruntime.extern.OrtApi;
import com.jyuzawa.onnxruntime.extern.OrtApiBase;

public class Ort {
	static  {
		System.load("/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib");
	}

	public static void main(String[] args) throws IOException {
		SymbolLookup loaderLookup = SymbolLookup.loaderLookup();
		try (var scope = ResourceScope.newConfinedScope()) {
			MemoryAddress apiBaseAddress = OrtGetApiBase();
			MemorySegment apiBase = apiBaseAddress.asSegment(OrtApiBase.sizeof(), scope);
			MemoryAddress apiAddress = OrtApiBase.GetApi(apiBase).apply(ORT_API_VERSION());
			MemorySegment api = apiAddress.asSegment(OrtApi.sizeof(), scope);
			System.out.print(api);
			SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
			MemoryAddress ver = OrtApiBase.GetVersionString(apiBase).apply();
			System.out.println(toJavaString(ver));
			MemorySegment logName = toCString("ort", scope);
			MemorySegment env = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.CreateEnv(api).apply(ORT_LOGGING_LEVEL_ERROR(), logName.address(), env.address()));
			MemorySegment session = allocator.allocate(C_POINTER);
			String fpath= "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/src/test/resources/mmo_model.onnx";
			MemorySegment file = toCString(fpath,
					scope);
			
			
			try(RandomAccessFile raf = new RandomAccessFile(new File(fpath), "r");
					//Get file channel in read-only mode
		            FileChannel fileChannel = raf.getChannel()){
		             
		            //Get direct byte buffer access using channel.map() operation
		            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
		            MemorySegment mappedBuf  = MemorySegment.ofByteBuffer(buffer);
			
			MemorySegment sessionOptions = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.CreateSessionOptions(api).apply(sessionOptions.address()));
			checkStatus(api, OrtApi.SetIntraOpNumThreads(api).apply(sessionOptions.address(), 1));
//			checkStatus(api, OrtApi.CreateSession(api).apply(MemoryAccess.getAddress(env), file.address(),
//					MemoryAccess.getAddress(sessionOptions), session.address()));
			checkStatus(api, OrtApi.CreateSessionFromArray(api).apply(MemoryAccess.getAddress(env), mappedBuf.address(), buffer.capacity(),
					MemoryAccess.getAddress(sessionOptions), session.address()));
			mappedBuf.unload();
			}

			MemorySegment ortAllocator = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.GetAllocatorWithDefaultOptions(api).apply(ortAllocator.address()));
			MemorySegment inputOut = allocator.allocate(C_POINTER);

			checkStatus(api, OrtApi.SessionGetInputName(api).apply(MemoryAccess.getAddress(session), 0,
					MemoryAccess.getAddress(ortAllocator), inputOut.address()));

			System.out.println(toJavaString(MemoryAccess.getAddress(inputOut)));


			MemorySegment memoryInfo = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.CreateCpuMemoryInfo(api).apply(OrtArenaAllocator(), OrtMemTypeDefault(),
					memoryInfo.address()));

			float[] input = new float[] { 6195379, 28388, 4700000 };
			MemorySegment inputData = allocator.allocateArray(C_FLOAT, input);
			MemorySegment inputTensor = allocator.allocate(C_POINTER);
			long[] shape = new long[] { 1, 3 };
			MemorySegment shapeData = allocator.allocateArray(C_LONG, shape);
			checkStatus(api,
					OrtApi.CreateTensorWithDataAsOrtValue(api).apply(MemoryAccess.getAddress(memoryInfo),
							inputData.address(), inputData.byteSize(), shapeData.address(), shape.length,
							ONNX_TENSOR_ELEMENT_DATA_TYPE_FLOAT(), inputTensor.address()));

			MemorySegment input1 = toCString("float_input", scope);
			MemorySegment inputNames = allocator.allocateArray(C_POINTER, new Addressable[] { input1 });

			MemorySegment output1 = toCString("variable", scope);
			MemorySegment outputNames = allocator.allocateArray(C_POINTER, new Addressable[] { output1 });
			MemorySegment output = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.Run(api).apply(MemoryAccess.getAddress(session), MemoryAddress.NULL,
					inputNames.address(), inputTensor.address(), 1, outputNames.address(), 1, output.address()));
			MemorySegment floatOutput = allocator.allocate(C_POINTER);
			checkStatus(api,
					OrtApi.GetTensorMutableData(api).apply(MemoryAccess.getAddress(output), floatOutput.address()));
			var x = MemoryAccess.getAddress(floatOutput).asSegment(24, scope);
			System.out.println(MemoryAccess.getAddress(floatOutput) + " " + Arrays.toString(x.toFloatArray()));
		}
	}

	private static void checkStatus(MemorySegment api, MemoryAddress status) {
		if (MemoryAddress.NULL.equals(status)) {
			return;
		}
		int code = OrtApi.GetErrorCode(api).apply(status);
		String message = toJavaString(OrtApi.GetErrorMessage(api).apply(status));
		OrtApi.ReleaseStatus(api).apply(status);
		throw new RuntimeException("FAILED " + code + ": " + message);
	}
}
