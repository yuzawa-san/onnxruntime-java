/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;
import java.util.function.Function;

interface ExecutionProviderFactory extends Function<Map<String, String>, ExecutionProviderAppender> {}
