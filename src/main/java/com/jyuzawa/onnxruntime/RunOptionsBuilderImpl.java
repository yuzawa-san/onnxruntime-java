/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.Map;

import com.jyuzawa.onnxruntime.RunOptions.Builder;

final class RunOptionsBuilderImpl implements RunOptions.Builder {

	OnnxRuntimeLoggingLevel logSeverityLevel;
	Integer logVerbosityLevel;
	String runTag;
	Map<String, String> config;

	@Override
	public Builder setLogSeverityLevel​(OnnxRuntimeLoggingLevel level) {
		this.logSeverityLevel = level;
		return this;
	}

	@Override
	public Builder setLogVerbosityLevel​(int level) {
		this.logVerbosityLevel = level;
		return this;
	}

	@Override
	public Builder setRunTag​(String runTag) {
		this.runTag = runTag;
		return this;
	}

	@Override
	public Builder setRunConfigMap(Map<String, String> config) {
		this.config = config;
		return this;
	}

	MemoryAddress build(ApiImpl api, MemorySession scope) {
		MemoryAddress runOptions = api.create(scope, out -> api.CreateRunOptions.apply(out));
		if (logSeverityLevel != null) {
			api.checkStatus(api.RunOptionsSetRunLogSeverityLevel.apply(runOptions, logSeverityLevel.getNumber()));
		}
		if (logVerbosityLevel != null) {
			api.checkStatus(api.RunOptionsSetRunLogVerbosityLevel.apply(runOptions, logVerbosityLevel));
		}
		if (runTag != null) {
			api.checkStatus(api.RunOptionsSetRunTag.apply(runOptions, scope.allocateUtf8String(runTag).address()));
		}
		if (config != null || !config.isEmpty()) {
			for (Map.Entry<String, String> entry : config.entrySet()) {
				api.checkStatus(
						api.AddRunConfigEntry.apply(runOptions, scope.allocateUtf8String(entry.getKey()).address(),
								scope.allocateUtf8String(entry.getValue()).address()));
			}
		}
		return runOptions;
	}
}
