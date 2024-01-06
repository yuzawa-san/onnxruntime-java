/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$118 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$118() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetCUDAProviderOptionsByName"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT, JAVA_INT, RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.KernelContext_GetResource.class, "apply", constants$118.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$118.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetResource"));
    static final StructLayout const$5 = MemoryLayout.structLayout(
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
                    RuntimeHelper.POINTER.withName("KernelComputeV2"))
            .withName("OrtCustomOp");
}
