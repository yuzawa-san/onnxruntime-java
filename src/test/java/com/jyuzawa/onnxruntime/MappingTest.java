/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.jpl.Log4jSystemLogger;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.junit.jupiter.api.Test;

public class MappingTest {

    private void assertLogging(OnnxRuntimeLoggingLevel expected, Level level) {
        Log4jSystemLogger logger = new Log4jSystemLogger(new SimpleLogger(
                "ASDF", level, false, false, false, false, null, null, new PropertiesUtil(new Properties()), null));
        assertEquals(expected, OnnxRuntimeLoggingLevel.getDefaultLogLevel(logger));
    }

    @Test
    public void loggerTest() {
        for (OnnxRuntimeLoggingLevel value : OnnxRuntimeLoggingLevel.values()) {
            assertEquals(value, OnnxRuntimeLoggingLevel.forNumber(value.getNumber()));
        }
        assertEquals(OnnxRuntimeLoggingLevel.VERBOSE, OnnxRuntimeLoggingLevel.forNumber(1000));

        assertLogging(OnnxRuntimeLoggingLevel.VERBOSE, Level.DEBUG);
        assertLogging(OnnxRuntimeLoggingLevel.INFO, Level.INFO);
        assertLogging(OnnxRuntimeLoggingLevel.WARNING, Level.WARN);
        assertLogging(OnnxRuntimeLoggingLevel.ERROR, Level.ERROR);
        assertLogging(OnnxRuntimeLoggingLevel.FATAL, Level.FATAL);
    }

    @Test
    public void valueTypeTest() {
        for (OnnxType value : OnnxType.values()) {
            assertEquals(value, OnnxType.forNumber(value.getNumber()));
        }
        assertEquals(OnnxType.UNKNOWN, OnnxType.forNumber(1000));
    }

    @Test
    public void tensorElementTypeTest() {
        for (OnnxTensorElementDataType value : OnnxTensorElementDataType.values()) {
            assertEquals(value, OnnxTensorElementDataType.forNumber(value.getNumber()));
        }
        assertEquals(OnnxTensorElementDataType.UNDEFINED, OnnxTensorElementDataType.forNumber(1000));
    }

    @Test
    public void executionModeTest() {
        for (OnnxRuntimeExecutionMode value : OnnxRuntimeExecutionMode.values()) {
            assertEquals(value, OnnxRuntimeExecutionMode.forNumber(value.getNumber()));
        }
        assertEquals(OnnxRuntimeExecutionMode.SEQUENTIAL, OnnxRuntimeExecutionMode.forNumber(1000));
    }

    @Test
    public void optimizationLevelTest() {
        for (OnnxRuntimeOptimizationLevel value : OnnxRuntimeOptimizationLevel.values()) {
            assertEquals(value, OnnxRuntimeOptimizationLevel.forNumber(value.getNumber()));
        }
        assertEquals(OnnxRuntimeOptimizationLevel.DISABLE_ALL, OnnxRuntimeOptimizationLevel.forNumber(1000));
    }

    @Test
    public void exceptionTest() {
        assertEquals(-1, new OnnxRuntimeException().getCode());
        assertEquals(10, new OnnxRuntimeException(10).getCode());
        assertEquals(10, new OnnxRuntimeException(10, "fsd").getCode());
        assertEquals(-1, new OnnxRuntimeException("fsf").getCode());
        assertEquals(-1, new OnnxRuntimeException("fsf", new IllegalArgumentException()).getCode());
    }
}
