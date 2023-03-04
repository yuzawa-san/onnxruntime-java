/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_c_api_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_c_api_h.C_POINTER;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentScope;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.function.Supplier;

/**
 * The level for the internal logger within the ONNX runtime.
 *
 */
public enum OnnxRuntimeLoggingLevel {
    VERBOSE(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);

    private static final Logger LOG = System.getLogger(Environment.class.getName());

    static final MemorySegment LOG_CALLBACK = createCallback();
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
        switch (number) {
            case 1:
                return INFO;
            case 2:
                return WARNING;
            case 3:
                return ERROR;
            case 4:
                return FATAL;
            case 0:
            default:
                return VERBOSE;
        }
    }

    @SuppressWarnings("unused")
    private static final void logCallback(
            MemorySegment parameterAddress,
            int level,
            MemorySegment categoryAddress,
            MemorySegment idAddress,
            MemorySegment locationAddress,
            MemorySegment messageAddress) {
        String category = categoryAddress.getUtf8String(0);
        String id = idAddress.getUtf8String(0);
        String location = locationAddress.getUtf8String(0);
        String message = messageAddress.getUtf8String(0);
        Supplier<String> line = () -> new StringBuilder()
                .append(category)
                .append(' ')
                .append(id)
                .append(' ')
                .append(location)
                .append(' ')
                .append(message)
                .toString();
        switch (OnnxRuntimeLoggingLevel.forNumber(level)) {
            case VERBOSE:
                LOG.log(Level.DEBUG, line);
                break;
            case INFO:
                LOG.log(Level.INFO, line);
                break;
            case WARNING:
                LOG.log(Level.WARNING, line);
                break;
            case FATAL:
            case ERROR:
                LOG.log(Level.ERROR, line);
                break;
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

    private static final MemorySegment createCallback() {
        try {
            FunctionDescriptor LOG_CALLBACK_DESCRIPTOR =
                    FunctionDescriptor.ofVoid(C_POINTER, C_INT, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
            MethodHandle LOG_CALLBACK_HANDLE = MethodHandles.lookup()
                    .findStatic(
                            OnnxRuntimeLoggingLevel.class,
                            "logCallback",
                            MethodType.methodType(
                                    void.class,
                                    MemorySegment.class,
                                    int.class,
                                    MemorySegment.class,
                                    MemorySegment.class,
                                    MemorySegment.class,
                                    MemorySegment.class));
            return Linker.nativeLinker()
                    .upcallStub(LOG_CALLBACK_HANDLE, LOG_CALLBACK_DESCRIPTOR, SegmentScope.global());
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new OnnxRuntimeException("failed to initialize logger", e);
        }
    }
}
