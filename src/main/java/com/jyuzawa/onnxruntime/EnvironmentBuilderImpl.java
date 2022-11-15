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
    private boolean globalThreadPool;
    private boolean globalDenormalAsZero;
    private int globalInterOpNumThreads;
    private int globalIntraOpNumThreads;
    private boolean globalSpinControl;

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
	public Environment.Builder setGlobalDenormalAsZero() {
    	this.globalThreadPool = true;
    	this.globalDenormalAsZero = true;
    	return this;
    }
    
    @Override
	public Environment.Builder setGlobalInterOpNumThreads​(int numThreads) {
    	this.globalThreadPool = true;
    	this.globalInterOpNumThreads = numThreads;
    	return this;
    }
    
    
    @Override
	public Environment.Builder setGlobalIntraOpNumThreads​(int numThreads){
    	this.globalThreadPool = true;
    	this.globalIntraOpNumThreads = numThreads;
    	return this;
    }
    
    @Override
	public Environment.Builder setGlobalSpinControl​(boolean allowSpinning){
    	this.globalThreadPool = true;
    	this.globalSpinControl = allowSpinning;
    	return this;
    }
    

    @Override
    public Environment build() {
        MemorySession scope = MemorySession.openShared();
        MemorySegment logName = scope.allocateUtf8String(logId);
        MemoryAddress env;
        if(globalThreadPool) {
        	MemoryAddress threadingOptions = api.create(scope, out-> api.CreateThreadingOptions.apply(out));
        	if(globalDenormalAsZero) {
        	api.checkStatus(api.SetGlobalDenormalAsZero.apply(threadingOptions));
        	}
        	api.checkStatus(api.SetGlobalSpinControl.apply(threadingOptions, globalSpinControl ? 1:0));
        	api.checkStatus(api.SetGlobalInterOpNumThreads.apply(threadingOptions, globalInterOpNumThreads));
        	api.checkStatus(api.SetGlobalIntraOpNumThreads.apply(threadingOptions, globalIntraOpNumThreads));
        	env = api.create(
                    scope,
                    out -> api.CreateEnvWithCustomLoggerAndGlobalThreadPools.apply(
                            OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                            MemoryAddress.NULL,
                            severityLevel.getNumber(),
                            logName.address(),
                            threadingOptions,
                            out));
            api.ReleaseThreadingOptions.apply(threadingOptions);
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
