package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

final class ThreadingOptionsBuilderImpl implements ThreadingOptions.Builder {
	
	private Boolean globalDenormalAsZero;
	private Integer globalInterOpNumThreads;
	private Integer globalIntraOpNumThreads;
	private Boolean globalSpinControl;

	ThreadingOptionsBuilderImpl() {
	}

	@Override
	public ThreadingOptions.Builder setGlobalDenormalAsZero(boolean globalDenormalAsZero){
		this.globalDenormalAsZero = globalDenormalAsZero;
		return this;
	}
	
	@Override
	public ThreadingOptions.Builder setGlobalInterOpNumThreads​(int numThreads){
		this.globalInterOpNumThreads = numThreads;
		return this;
	}
       
	@Override
	public ThreadingOptions.Builder setGlobalIntraOpNumThreads​(int numThreads){
		this.globalIntraOpNumThreads = numThreads;
		return this;
	}
       
	@Override
	public ThreadingOptions.Builder setGlobalSpinControl​(boolean globalSpinControl){
		this.globalSpinControl = globalSpinControl;
		return this;
	}
	
	 MemoryAddress build(ApiImpl api , MemorySession scope) {
		MemoryAddress threadingOptions = api.create(scope, out-> api.CreateThreadingOptions.apply(out));
    	if(globalDenormalAsZero != null && globalSpinControl) {
    	api.checkStatus(api.SetGlobalDenormalAsZero.apply(threadingOptions));
    	}
    	if(globalSpinControl != null) {
    	api.checkStatus(api.SetGlobalSpinControl.apply(threadingOptions, globalSpinControl ? 1:0));
    	}
    	if(globalInterOpNumThreads!= null) {
    	api.checkStatus(api.SetGlobalInterOpNumThreads.apply(threadingOptions, globalInterOpNumThreads));
    	}
    	if(globalIntraOpNumThreads!= null) {
    	api.checkStatus(api.SetGlobalIntraOpNumThreads.apply(threadingOptions, globalIntraOpNumThreads));
    	}
    	return threadingOptions;
	}
	
}
