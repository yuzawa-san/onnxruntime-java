package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.toJavaString;

import com.jyuzawa.onnxruntime.extern.OrtApi;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

final class Util {
  private static void checkStatus(MemorySegment api, MemoryAddress status) {
    if (MemoryAddress.NULL.equals(status)) {
      return;
    }
    int code = OrtApi.GetErrorCode(api).apply(status);
    String message = toJavaString(OrtApi.GetErrorMessage(api).apply(status));
    OrtApi.ReleaseStatus(api).apply(status);
    throw new RuntimeException("FAILED " + code + ": " + message);
  }
}
