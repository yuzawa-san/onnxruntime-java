/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.toJavaString;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;

public enum OrtLoggingLevel {
    VERBOSE(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);

    private static final Logger LOG = System.getLogger(OrtLoggingLevel.class.getName());

    static final MemoryAddress LOG_CALLBACK = createCallback();
    static final OrtLoggingLevel DEFAULT = getDefaultLogLevel();

    private final int number;

    private OrtLoggingLevel(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    static final OrtLoggingLevel forNumber(int number) {
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
    private static final MemoryAddress logCallback(
            MemoryAddress parameterAddress,
            int level,
            MemoryAddress categoryAddress,
            MemoryAddress idAddress,
            MemoryAddress locationAddress,
            MemoryAddress messageAddress) {
        String category = toJavaString(categoryAddress);
        String id = toJavaString(idAddress);
        String location = toJavaString(locationAddress);
        String message = toJavaString(messageAddress);
        switch (OrtLoggingLevel.forNumber(level)) {
            case VERBOSE:
                LOG.log(Level.DEBUG, "{} {} {} {}", category, id, location, message);
                break;
            case INFO:
                LOG.log(Level.INFO, "{} {} {} {}", category, id, location, message);
                break;
            case WARNING:
                LOG.log(Level.WARNING, "{} {} {} {}", category, id, location, message);
                break;
            case FATAL:
            case ERROR:
                LOG.log(Level.ERROR, "{} {} {} {}", category, id, location, message);
                break;
        }
        return MemoryAddress.NULL;
    }

    private static final OrtLoggingLevel getDefaultLogLevel() {
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
            FunctionDescriptor LOG_CALLBACK_DESCRIPTOR = FunctionDescriptor.of(
                    CLinker.C_POINTER,
                    CLinker.C_POINTER,
                    CLinker.C_INT,
                    CLinker.C_POINTER,
                    CLinker.C_POINTER,
                    CLinker.C_POINTER,
                    CLinker.C_POINTER);
            MethodHandle LOG_CALLBACK_HANDLE = MethodHandles.lookup()
                    .findStatic(
                            OrtLoggingLevel.class,
                            "logCallback",
                            MethodType.methodType(
                                    MemoryAddress.class,
                                    MemoryAddress.class,
                                    int.class,
                                    MemoryAddress.class,
                                    MemoryAddress.class,
                                    MemoryAddress.class,
                                    MemoryAddress.class));
            return CLinker.getInstance()
                    .upcallStub(LOG_CALLBACK_HANDLE, LOG_CALLBACK_DESCRIPTOR, ResourceScope.globalScope());
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new OrtException("failed to initialize logger", e);
        }
    }
}
