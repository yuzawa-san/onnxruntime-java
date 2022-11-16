package com.jyuzawa.onnxruntime;

import java.io.File;
import java.util.Map;

public interface SessionOptions {

	public interface Builder {

		Builder disablePerSessionThreads();

		Builder enableProfiling​(File filePath);

		Builder setLogSeverityLevel​(OnnxRuntimeLoggingLevel level);

		Builder setLogVerbosityLevel​(int level);

		Builder setSessionConfigMap(Map<String, String> config);

		Builder setExecutionMode​(OnnxRuntimeExecutionMode mode);

		Builder setInterOpNumThreads​(int numThreads);

		Builder setIntraOpNumThreads​(int numThreads);

		Builder setLoggerId​(String loggerId);

		Builder setMemoryPatternOptimization​(boolean memoryPatternOptimization);

		Builder setOptimizationLevel​(OnnxRuntimeOptimizationLevel level);

		Builder setOptimizedModelFilePath​(File outputPath);

	}
}
