/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.List;

record ValueContext(
        ApiImpl api,
        Arena arena,
        MemorySegment ortAllocatorAddress,
        MemorySegment memoryInfoAddress,
        List<Runnable> closeables) {}
