/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;

record ValueContext(
        ApiImpl api,
        SegmentAllocator segmentAllocator,
        MemorySession memorySession,
        MemoryAddress ortAllocatorAddress,
        MemoryAddress memoryInfoAddress) {}
