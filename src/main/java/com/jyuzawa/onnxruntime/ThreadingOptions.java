package com.jyuzawa.onnxruntime;

public interface ThreadingOptions {
	
	public interface Builder {
		Builder setGlobalDenormalAsZero(boolean globalDenormalAsZero);
		
		 Builder setGlobalInterOpNumThreads​(int numThreads);
	        
	     Builder setGlobalIntraOpNumThreads​(int numThreads);
	        
	     Builder setGlobalSpinControl​(boolean globalSpinControl);

	}

}
