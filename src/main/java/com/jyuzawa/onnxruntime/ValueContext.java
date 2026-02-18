/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;

record ValueContext(
        ApiImpl api, MemorySegment ortAllocatorAddress, MemorySegment memoryInfoAddress, boolean autoRelease) {}
