package com.jyuzawa.onnxruntime;

public interface ApiBase {

  String getVersion();

  Api getApi();

  static ApiBase get() {
    return ApiBaseImpl.INSTANCE;
  }
}
