/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * The level for the internal logger within the ONNX runtime.
 *
 * @since 1.0.0
 */
public enum OnnxRuntimeLoggingLevel {
    VERBOSE(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);

    private static final Logger LOG = System.getLogger(Environment.class.getName());

    static final MemoryAddress LOG_CALLBACK = createCallback();
    static final OnnxRuntimeLoggingLevel DEFAULT = getDefaultLogLevel();

    private final int number;

    private OnnxRuntimeLoggingLevel(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    /**
     * Get a level based off its internal number.
     * @param number the internal number of the level
     * @return the level, VERBOSE if not found
     */
    public static final OnnxRuntimeLoggingLevel forNumber(int number) {
        return switch (number) {
            case 0 -> VERBOSE;
            case 1 -> INFO;
            case 2 -> WARNING;
            case 3 -> ERROR;
            case 4 -> FATAL;
            default -> VERBOSE;
        };
    }

    @SuppressWarnings("unused")
    private static final void logCallback(
            MemoryAddress parameterAddress,
            int level,
            MemoryAddress categoryAddress,
            MemoryAddress idAddress,
            MemoryAddress locationAddress,
            MemoryAddress messageAddress) {
        Level theLevel =
                switch (OnnxRuntimeLoggingLevel.forNumber(level)) {
                    case VERBOSE -> Level.DEBUG;
                    case INFO -> Level.INFO;
                    case WARNING -> Level.WARNING;
                    case FATAL, ERROR -> Level.ERROR;
                };
        if (LOG.isLoggable(theLevel)) {
            String category = categoryAddress.address().getUtf8String(0);
            String id = idAddress.address().getUtf8String(0);
            String location = locationAddress.address().getUtf8String(0);
            String message = messageAddress.address().getUtf8String(0);
            LOG.log(theLevel, category + ' ' + id + ' ' + location + ' ' + message);
        }
    }

    private static final OnnxRuntimeLoggingLevel getDefaultLogLevel() {
        if (LOG.isLoggable(Level.DEBUG)) {
            return VERBOSE;
        }
        if (LOG.isLoggable(Level.INFO)) {
            return INFO;
        }
        if (LOG.isLoggable(Level.WARNING)) {
            return WARNING;
        }
        if (LOG.isLoggable(Level.ERROR)) {
            return ERROR;
        }
        return FATAL;
    }

    private static final MemoryAddress createCallback() {
        try {
            FunctionDescriptor LOG_CALLBACK_DESCRIPTOR =
                    FunctionDescriptor.ofVoid(C_POINTER, C_INT, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
            MethodHandle LOG_CALLBACK_HANDLE = MethodHandles.lookup()
                    .findStatic(
                            OnnxRuntimeLoggingLevel.class,
                            "logCallback",
                            MethodType.methodType(
                                    void.class,
                                    MemoryAddress.class,
                                    int.class,
                                    MemoryAddress.class,
                                    MemoryAddress.class,
                                    MemoryAddress.class,
                                    MemoryAddress.class));
            return Linker.nativeLinker()
                    .upcallStub(LOG_CALLBACK_HANDLE, LOG_CALLBACK_DESCRIPTOR, MemorySession.global())
                    .address();
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new OnnxRuntimeException("failed to initialize logger", e);
        }
    }
}
