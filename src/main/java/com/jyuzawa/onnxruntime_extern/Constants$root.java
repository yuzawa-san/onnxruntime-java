/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;

public class Constants$root {

    static final OfBoolean C_BOOL$LAYOUT = JAVA_BOOLEAN;
    static final OfByte C_CHAR$LAYOUT = JAVA_BYTE;
    static final OfShort C_SHORT$LAYOUT = JAVA_SHORT.withBitAlignment(16);
    static final OfInt C_INT$LAYOUT = JAVA_INT.withBitAlignment(32);
    static final OfLong C_LONG$LAYOUT = JAVA_LONG.withBitAlignment(64);
    static final OfLong C_LONG_LONG$LAYOUT = JAVA_LONG.withBitAlignment(64);
    static final OfFloat C_FLOAT$LAYOUT = JAVA_FLOAT.withBitAlignment(32);
    static final OfDouble C_DOUBLE$LAYOUT = JAVA_DOUBLE.withBitAlignment(64);
    static final OfAddress C_POINTER$LAYOUT = ADDRESS.withBitAlignment(64);
}
