package com.jyuzawa.onnxruntime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface Environment extends Managed {

	void setTelemetryEvents(boolean enabled);
	
	void setLanguageProjection(int languageProjection);
	
	// TODO: allocator
//	void createAndRegisterAllocator();
	
	Session.Builder newSession();
		
	interface Builder {
		Builder setLogSeverityLevel(int level);
		
		Builder setLogId(String id);
		
		// TODO: threading options
//		Builder setThreadingOptions(ThreadingOptions threadingOptions);
		
		// TODO: custom logger
//		Builder setCustomLogger();
		
		Environment build();
		
		
		
	}
}
