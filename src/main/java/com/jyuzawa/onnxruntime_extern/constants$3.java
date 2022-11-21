/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

class constants$3 {

    static final OfAddress kOrtSessionOptionsEnableQuantQDQCleanup$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsEnableQuantQDQCleanup$VH =
            constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsEnableQuantQDQCleanup$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsEnableQuantQDQCleanup", constants$3.kOrtSessionOptionsEnableQuantQDQCleanup$LAYOUT);
    static final OfAddress kOrtSessionOptionsEnableGeluApproximation$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsEnableGeluApproximation$VH =
            constants$3.kOrtSessionOptionsEnableGeluApproximation$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsEnableGeluApproximation$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsEnableGeluApproximation", constants$3.kOrtSessionOptionsEnableGeluApproximation$LAYOUT);
    static final OfAddress kOrtSessionOptionsUseDeviceAllocatorForInitializers$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsUseDeviceAllocatorForInitializers$VH =
            constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsUseDeviceAllocatorForInitializers$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsUseDeviceAllocatorForInitializers",
                    constants$3.kOrtSessionOptionsUseDeviceAllocatorForInitializers$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigAllowInterOpSpinning$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigAllowInterOpSpinning$VH =
            constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigAllowInterOpSpinning$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigAllowInterOpSpinning",
                    constants$3.kOrtSessionOptionsConfigAllowInterOpSpinning$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigAllowIntraOpSpinning$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigAllowIntraOpSpinning$VH =
            constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigAllowIntraOpSpinning$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigAllowIntraOpSpinning",
                    constants$3.kOrtSessionOptionsConfigAllowIntraOpSpinning$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigUseORTModelBytesDirectly$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigUseORTModelBytesDirectly$VH =
            constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigUseORTModelBytesDirectly$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigUseORTModelBytesDirectly",
                    constants$3.kOrtSessionOptionsConfigUseORTModelBytesDirectly$LAYOUT);
}
