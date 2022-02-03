package com.jyuzawa.onnxruntime;

public interface Environment extends Managed {

  void setTelemetryEvents(boolean enabled);

  void setLanguageProjection(int languageProjection);

  // TODO: allocator
  //	void createAndRegisterAllocator();

  Session.Builder newSession();

  public interface Builder {
    Builder setLogSeverityLevel(int level);

    Builder setLogId(String id);

    // TODO: threading options
    //		Builder setThreadingOptions(ThreadingOptions threadingOptions);

    // TODO: custom logger
    //		Builder setCustomLogger();

    Environment build();
  }
}
