/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.ValueLayout;

class SizeT {
    private static final boolean IS_WINDOWS =
            System.getProperty("os.name", "").toLowerCase().startsWith("windows");
    static final ValueLayout C_LONG = IS_WINDOWS ? CLinker.C_LONG_LONG : CLinker.C_LONG;
}
