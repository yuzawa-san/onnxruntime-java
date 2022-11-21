/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

class constants$5 {

    static final OfAddress kOrtSessionOptionsConfigForceSpinningStop$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigForceSpinningStop$VH =
            constants$5.kOrtSessionOptionsConfigForceSpinningStop$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigForceSpinningStop$SEGMENT = RuntimeHelper.lookupGlobalVariable(
            "kOrtSessionOptionsConfigForceSpinningStop", constants$5.kOrtSessionOptionsConfigForceSpinningStop$LAYOUT);
    static final OfAddress kOrtSessionOptionsConfigStrictShapeTypeInference$LAYOUT = Constants$root.C_POINTER$LAYOUT;
    static final VarHandle kOrtSessionOptionsConfigStrictShapeTypeInference$VH =
            constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$LAYOUT.varHandle();
    static final MemorySegment kOrtSessionOptionsConfigStrictShapeTypeInference$SEGMENT =
            RuntimeHelper.lookupGlobalVariable(
                    "kOrtSessionOptionsConfigStrictShapeTypeInference",
                    constants$5.kOrtSessionOptionsConfigStrictShapeTypeInference$LAYOUT);
}
