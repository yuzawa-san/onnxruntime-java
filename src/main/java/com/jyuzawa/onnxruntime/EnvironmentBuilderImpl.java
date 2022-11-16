/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

final class EnvironmentBuilderImpl implements Environment.Builder {

    private final ApiImpl api;
    private OnnxRuntimeLoggingLevel severityLevel;
    private String logId;
    private ThreadingOptionsBuilderImpl threadingOptions;

    EnvironmentBuilderImpl(ApiImpl api) {
        this.api = api;
        this.severityLevel = OnnxRuntimeLoggingLevel.DEFAULT;
        this.logId = "onnxruntime-java";
    }

    @Override
    public Environment.Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel severityLevel) {
        this.severityLevel = severityLevel;
        return this;
    }

    @Override
    public Environment.Builder setLogId(String id) {
        this.logId = id;
        return this;
    }
    
    @Override
	public ThreadingOptions.Builder getThreadingOptionsBuilder(){
    	if(threadingOptions == null) {
    		threadingOptions = new ThreadingOptionsBuilderImpl();
    	}
    	return threadingOptions;
    }
    

    @Override
    public Environment build() {
        MemorySession scope = MemorySession.openShared();
        MemorySegment logName = scope.allocateUtf8String(logId);
        MemoryAddress env;
        if(threadingOptions!= null) {
        	MemoryAddress threadingOptionsAddress = threadingOptions.build(api, scope);
        	env = api.create(
                    scope,
                    out -> api.CreateEnvWithCustomLoggerAndGlobalThreadPools.apply(
                            OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                            MemoryAddress.NULL,
                            severityLevel.getNumber(),
                            logName.address(),
                            threadingOptionsAddress,
                            out));
            api.ReleaseThreadingOptions.apply(threadingOptionsAddress);
        }else {
        env = api.create(
                scope,
                out -> api.CreateEnvWithCustomLogger.apply(
                        OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                        MemoryAddress.NULL,
                        severityLevel.getNumber(),
                        logName.address(),
                        out));
        }
        scope.addCloseAction(() -> {
            api.ReleaseEnv.apply(env);
        });
        return new EnvironmentImpl(api, scope, env);
    }
}
