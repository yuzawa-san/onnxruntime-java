package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime.extern.onnxruntime_all_h.ORT_LOGGING_LEVEL_ERROR;
import static jdk.incubator.foreign.CLinker.toCString;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class EnviromentBuilderImpl implements Environment.Builder {

  private final ApiImpl api;
  int severityLevel;
  String logId;

  EnviromentBuilderImpl(ApiImpl api) {
    this.api = api;
    this.severityLevel = ORT_LOGGING_LEVEL_ERROR();
    this.logId = "onnxruntime-java";
  }

  @Override
  public Environment.Builder setLogSeverityLevel(int severityLevel) {
    this.severityLevel = severityLevel;
    return this;
  }

  @Override
  public Environment.Builder setLogId(String id) {
    this.logId = id;
    return this;
  }

  @Override
  public Environment build() {
    ResourceScope scope = ResourceScope.newConfinedScope();
    SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
    MemorySegment logName = toCString(logId, scope);
    MemoryAddress env =
        api.create(allocator, out -> api.CreateEnv.apply(severityLevel, logName.address(), out));
    scope.addCloseAction(
        () -> {
          api.ReleaseEnv.apply(env);
        });
    return new EnvironmentImpl(api, scope, env);
  }
}
