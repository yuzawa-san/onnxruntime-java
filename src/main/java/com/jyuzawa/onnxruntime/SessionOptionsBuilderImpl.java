package com.jyuzawa.onnxruntime;

import java.io.File;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.Map;

final class SessionOptionsBuilderImpl implements SessionOptions.Builder {

	OnnxRuntimeLoggingLevel logSeverityLevel;
	Integer logVerbosityLevel;
	String loggerId;
	Boolean memoryPatternOptimization;
	Map<String, String> config;
	Integer interOpNumThreads;
	Integer intraOpNumThreads;
	File optimizedFilePath;
	File profilingOutput;
	boolean disablePerSessionThreads;
	OnnxRuntimeExecutionMode executionMode;
	OnnxRuntimeOptimizationLevel optimizationLevel;

	@Override
	public SessionOptions.Builder enableProfiling​(File filePath) {
		this.profilingOutput = filePath;
		return this;
	}

	@Override
	public SessionOptions.Builder setOptimizedModelFilePath​(File outputPath) {
		this.optimizedFilePath = outputPath;
		return this;
	}

	@Override
	public SessionOptions.Builder disablePerSessionThreads() {
		this.disablePerSessionThreads = true;
		return this;
	}

	@Override
	public SessionOptions.Builder setExecutionMode​(OnnxRuntimeExecutionMode mode) {
		this.executionMode = mode;
		return this;
	}

	@Override
	public SessionOptions.Builder setOptimizationLevel​(OnnxRuntimeOptimizationLevel level) {
		this.optimizationLevel = level;
		return this;
	}

	@Override
	public SessionOptions.Builder setLogSeverityLevel​(OnnxRuntimeLoggingLevel level) {
		this.logSeverityLevel = level;
		return this;
	}

	@Override
	public SessionOptions.Builder setLogVerbosityLevel​(int level) {
		this.logVerbosityLevel = level;
		return this;
	}

	@Override
	public SessionOptions.Builder setLoggerId​(String loggerId) {
		this.loggerId = loggerId;
		return this;
	}

	@Override
	public SessionOptions.Builder setMemoryPatternOptimization​(boolean memoryPatternOptimization) {
		this.memoryPatternOptimization = memoryPatternOptimization;
		return this;
	}

	@Override
	public SessionOptions.Builder setSessionConfigMap(Map<String, String> config) {
		this.config = config;
		return this;
	}

	@Override
	public SessionOptions.Builder setInterOpNumThreads​(int numThreads) {
		this.interOpNumThreads = numThreads;
		return this;
	}

	@Override
	public SessionOptions.Builder setIntraOpNumThreads​(int numThreads) {
		this.intraOpNumThreads = numThreads;
		return this;
	}

	public MemoryAddress build(ApiImpl api, MemorySession allocator) {
		MemoryAddress sessionOptions = api.create(allocator, out -> api.CreateSessionOptions.apply(out));

		if (logSeverityLevel != null) {
			api.checkStatus(api.SetSessionLogSeverityLevel.apply(sessionOptions, logSeverityLevel.getNumber()));
		}
		if (logVerbosityLevel != null) {
			api.checkStatus(api.SetSessionLogVerbosityLevel.apply(sessionOptions, logVerbosityLevel));
		}
		if (loggerId != null) {
			api.checkStatus(
					api.SetSessionLogId.apply(sessionOptions, allocator.allocateUtf8String(loggerId).address()));
		}
		if (memoryPatternOptimization != null) {
			if (memoryPatternOptimization) {
				api.checkStatus(api.EnableMemPattern.apply(sessionOptions));
			} else {
				api.checkStatus(api.DisableMemPattern.apply(sessionOptions));
			}
		}
		if (interOpNumThreads != null) {
			api.checkStatus(api.SetInterOpNumThreads.apply(sessionOptions, interOpNumThreads));
		}
		if (intraOpNumThreads != null) {
			api.checkStatus(api.SetIntraOpNumThreads.apply(sessionOptions, intraOpNumThreads));
		}
		if (disablePerSessionThreads) {
			api.checkStatus(api.DisablePerSessionThreads.apply(sessionOptions));
		}
		if (executionMode != null) {
			api.checkStatus(api.SetSessionExecutionMode.apply(sessionOptions, executionMode.getNumber()));
		}
		if (optimizationLevel != null) {
			api.checkStatus(api.SetSessionGraphOptimizationLevel.apply(sessionOptions, optimizationLevel.getNumber()));
		}
		if (optimizedFilePath != null) {
			api.checkStatus(api.SetOptimizedModelFilePath.apply(sessionOptions,
					allocator.allocateUtf8String(optimizedFilePath.getAbsolutePath()).address()));
		}
		if (profilingOutput != null) {
			api.checkStatus(api.EnableProfiling.apply(sessionOptions,
					allocator.allocateUtf8String(optimizedFilePath.getAbsolutePath()).address()));
		}
		if (config != null && !config.isEmpty()) {
			for (Map.Entry<String, String> entry : config.entrySet()) {
				api.checkStatus(api.AddSessionConfigEntry.apply(sessionOptions,
						allocator.allocateUtf8String(entry.getKey()).address(),
						allocator.allocateUtf8String(entry.getValue()).address()));
			}
		}

		return sessionOptions;
	}

}
