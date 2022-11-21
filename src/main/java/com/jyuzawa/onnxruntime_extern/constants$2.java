/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

class constants$2 {

    static final OfAddress kOrtSessionOptionsConfigDisablePrepacking$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigDisablePrepacking$VH =
            constants$2.kOrtSessionOptionsConfigDisablePrepacking$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigDisablePrepacking$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigDisablePrepacking", constants$2.kOrtSessionOptionsConfigDisablePrepacking$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigUseEnvAllocators$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigUseEnvAllocators$VH =
            constants$2.kOrtSessionOptionsConfigUseEnvAllocators$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigUseEnvAllocators$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigUseEnvAllocators", constants$2.kOrtSessionOptionsConfigUseEnvAllocators$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigLoadModelFormat$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigLoadModelFormat$VH =
            constants$2.kOrtSessionOptionsConfigLoadModelFormat$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigLoadModelFormat$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigLoadModelFormat", constants$2.kOrtSessionOptionsConfigLoadModelFormat$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigSaveModelFormat$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigSaveModelFormat$VH =
            constants$2.kOrtSessionOptionsConfigSaveModelFormat$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigSaveModelFormat$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigSaveModelFormat", constants$2.kOrtSessionOptionsConfigSaveModelFormat$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigSetDenormalAsZero$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigSetDenormalAsZero$VH =
            constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigSetDenormalAsZero$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigSetDenormalAsZero", constants$2.kOrtSessionOptionsConfigSetDenormalAsZero$LAYOUT);
    static final OfAddress kOrtSessionOptionsDisableQuantQDQ$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsDisableQuantQDQ$VH =
            constants$2.kOrtSessionOptionsDisableQuantQDQ$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsDisableQuantQDQ$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsDisableQuantQDQ", constants$2.kOrtSessionOptionsDisableQuantQDQ$LAYOUT);
}
