/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$123 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$123() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_ParallelFor"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2.class, "apply", constants$83.const$3);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_OpenVINO_V2"));
    static final StructLayout const$3 = MemoryLayout.structLayout(
                    JAVA_INT.withName("version"),
                    MemoryLayout.paddingLayout(4),
                    RuntimeHelper.POINTER.withName("CreateKernel"),
                    RuntimeHelper.POINTER.withName("GetName"),
                    RuntimeHelper.POINTER.withName("GetExecutionProviderType"),
                    RuntimeHelper.POINTER.withName("GetInputType"),
                    RuntimeHelper.POINTER.withName("GetInputTypeCount"),
                    RuntimeHelper.POINTER.withName("GetOutputType"),
                    RuntimeHelper.POINTER.withName("GetOutputTypeCount"),
                    RuntimeHelper.POINTER.withName("KernelCompute"),
                    RuntimeHelper.POINTER.withName("KernelDestroy"),
                    RuntimeHelper.POINTER.withName("GetInputCharacteristic"),
                    RuntimeHelper.POINTER.withName("GetOutputCharacteristic"),
                    RuntimeHelper.POINTER.withName("GetInputMemoryType"),
                    RuntimeHelper.POINTER.withName("GetVariadicInputMinArity"),
                    RuntimeHelper.POINTER.withName("GetVariadicInputHomogeneity"),
                    RuntimeHelper.POINTER.withName("GetVariadicOutputMinArity"),
                    RuntimeHelper.POINTER.withName("GetVariadicOutputHomogeneity"),
                    RuntimeHelper.POINTER.withName("CreateKernelV2"),
                    RuntimeHelper.POINTER.withName("KernelComputeV2"),
                    RuntimeHelper.POINTER.withName("InferOutputShapeFn"),
                    RuntimeHelper.POINTER.withName("GetStartVersion"),
                    RuntimeHelper.POINTER.withName("GetEndVersion"))
            .withName("OrtCustomOp");
    static final VarHandle const$4 = constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("version"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.CreateKernel.class, "apply", constants$15.const$0);
}
