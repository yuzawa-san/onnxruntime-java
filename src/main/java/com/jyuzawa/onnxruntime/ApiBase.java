/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface ApiBase {

    String getVersion();

    Api getApi();

    static ApiBase get() {
        return ApiBaseImpl.INSTANCE;
    }
}
