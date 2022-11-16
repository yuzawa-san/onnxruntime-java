package com.jyuzawa.onnxruntime;

import java.util.Map;

public interface RunOptions {
	
	
	public interface Builder {
		Builder setLogSeverityLevel​(OnnxRuntimeLoggingLevel level);
        
        Builder setLogVerbosityLevel​(int level);
        
        Builder setRunTag​(String runTag);
        
        Builder setRunConfigMap(Map<String,String> config);
	}

}
