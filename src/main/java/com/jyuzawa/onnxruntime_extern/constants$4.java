/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

class constants$4 {

    static final OfAddress kOrtSessionOptionsConfigUseORTModelBytesForInitializers$LAYOUT =
            Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigUseORTModelBytesForInitializers$VH =
            constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigUseORTModelBytesForInitializers$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigUseORTModelBytesForInitializers",
                    constants$4.kOrtSessionOptionsConfigUseORTModelBytesForInitializers$LAYOUT);
    static final OfAddress kOrtSessionOptionsQDQIsInt8Allowed$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsQDQIsInt8Allowed$VH =
            constants$4.kOrtSessionOptionsQDQIsInt8Allowed$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsQDQIsInt8Allowed$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsQDQIsInt8Allowed", constants$4.kOrtSessionOptionsQDQIsInt8Allowed$LAYOUT);
    static final OfAddress kOrtSessionOptionsAvx2PrecisionMode$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsAvx2PrecisionMode$VH =
            constants$4.kOrtSessionOptionsAvx2PrecisionMode$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsAvx2PrecisionMode$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsAvx2PrecisionMode", constants$4.kOrtSessionOptionsAvx2PrecisionMode$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigMinimalBuildOptimizations$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigMinimalBuildOptimizations$VH =
            constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigMinimalBuildOptimizations$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigMinimalBuildOptimizations",
                    constants$4.kOrtSessionOptionsConfigMinimalBuildOptimizations$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$VH =
            constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigNnapiEpPartitioningStopOps",
                    constants$4.kOrtSessionOptionsConfigNnapiEpPartitioningStopOps$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigDynamicBlockBase$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigDynamicBlockBase$VH =
            constants$4.kOrtSessionOptionsConfigDynamicBlockBase$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigDynamicBlockBase$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigDynamicBlockBase", constants$4.kOrtSessionOptionsConfigDynamicBlockBase$LAYOUT);
}
