package com.jyuzawa.onnxruntime;

import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;

import jdk.incubator.foreign.Addressable;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_c_api_h.*;
import static jdk.incubator.foreign.CLinker.*;

import java.util.Arrays;

import com.jyuzawa.onnxruntime.extern.OrtApi;
import com.jyuzawa.onnxruntime.extern.OrtApiBase;

public class Ort {

	public static void main(String[] args) {
		try (var scope = ResourceScope.newConfinedScope()) {
			System.load(
					"/Users/jyuzawa/repos/onnxruntime-jni/onnxruntime/onnxruntime-osx-universal2-1.10.0/lib/libonnxruntime.dylib");
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
			MemorySegment file = toCString("/Users/jyuzawa/repos/onnxruntime-jni/src/test/resources/mmo_model.onnx",
					scope);
			System.out.println("HELLO");
			MemorySegment sessionOptions = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.CreateSessionOptions(api).apply(sessionOptions.address()));
			checkStatus(api, OrtApi.SetIntraOpNumThreads(api).apply(sessionOptions.address(), 1));
			System.out.println("world");
			checkStatus(api, OrtApi.CreateSession(api).apply(MemoryAccess.getAddress(env), file.address(),
					MemoryAccess.getAddress(sessionOptions), session.address()));
			System.out.println("blah");

			MemorySegment ortAllocator = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.GetAllocatorWithDefaultOptions(api).apply(ortAllocator.address()));
			MemorySegment inputOut = allocator.allocate(C_POINTER);

			System.out.println("ss");
			checkStatus(api, OrtApi.SessionGetInputName(api).apply(MemoryAccess.getAddress(session), 0,
					MemoryAccess.getAddress(ortAllocator), inputOut.address()));
			System.out.println("ww");

			System.out.println(toJavaString(MemoryAccess.getAddress(inputOut)));

			System.out.println("RUNOPTS");

			MemorySegment memoryInfo = allocator.allocate(C_POINTER);
			checkStatus(api, OrtApi.CreateCpuMemoryInfo(api).apply(OrtArenaAllocator(), OrtMemTypeDefault(),
					memoryInfo.address()));

			float[] input = new float[] { 6195379, 28388, 4700000 };
			MemorySegment inputData = allocator.allocateArray(C_FLOAT, input);
			System.out.println(Arrays.toString(inputData.toFloatArray()));
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
			System.out.println("RUN!");
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
			System.out.println("success " + status);
			return;
		}
		int code = OrtApi.GetErrorCode(api).apply(status);
		String message = toJavaString(OrtApi.GetErrorMessage(api).apply(status));
		OrtApi.ReleaseStatus(api).apply(status);
		throw new RuntimeException("FAILED " + code + ": " + message);
	}
}
