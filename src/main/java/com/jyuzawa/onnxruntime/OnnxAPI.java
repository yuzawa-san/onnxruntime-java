package com.jyuzawa.onnxruntime;

import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;

public class OnnxAPI {
	static {
		String os = PlatformDependent.normalizedOs();
		String architecture = PlatformDependent.normalizedArch();
		if(PlatformDependent.isOsx()) {
			architecture = "universal2";
		}
		ClassLoader classLoader = OnnxAPI.class.getClassLoader();
		NativeLibraryLoader.load("onnxruntime_" + os + "_" + architecture, classLoader);
	}
}