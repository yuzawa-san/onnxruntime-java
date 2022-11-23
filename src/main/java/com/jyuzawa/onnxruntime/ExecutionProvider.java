/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

public enum ExecutionProvider {
    // these match the values defined in include/onnxruntime/core/graph/constants.h
    CPU_EXECUTION_PROVIDER("CPUExecutionProvider", ExecutionProviderConfigCPU::new),
    CUDA_EXECUTION_PROVIDER("CUDAExecutionProvider", ExecutionProviderConfigCUDA::new),
    DNNL_EXECUTION_PROVIDER("DnnlExecutionProvider"),
    OPENVINO_EXECUTION_PROVIDER("OpenVINOExecutionProvider"),
    VITISAI_EXECUTION_PROVIDER("VitisAIExecutionProvider"),
    TENSORRT_EXECUTION_PROVIDER("TensorrtExecutionProvider", ExecutionProviderConfigTensorRT::new),
    NNAPI_EXECUTION_PROVIDER("NnapiExecutionProvider"),
    RKNPU_EXECUTION_PROVIDER("RknpuExecutionProvider"),
    DML_EXECUTION_PROVIDER("DmlExecutionProvider"),
    MIGRAPHX_EXECUTION_PROVIDER("MIGraphXExecutionProvider"),
    ACL_EXECUTION_PROVIDER("ACLExecutionProvider"),
    ARMNN_EXECUTION_PROVIDER("ArmNNExecutionProvider"),
    ROCM_EXECUTION_PROVIDER("ROCMExecutionProvider"),
    COREML_EXECUTION_PROVIDER("CoreMLExecutionProvider"),
    SNPE_EXECUTION_PROVIDER("SNPEExecutionProvider", ExecutionProviderSimpleMapConfig.of("SNPE")),
    TVM_EXECUTION_PROVIDER("TvmExecutionProvider"),
    XNNPACK_EXECUTION_PROVIDER("XnnpackExecutionProvider", ExecutionProviderSimpleMapConfig.of("XNNPACK")),
    CANN_EXECUTION_PROVIDER("CANNExecutionProvider");

    private final String identifier;
    final ExecutionProviderConfigFactory factory;

    private ExecutionProvider(String identifier) {
        this(identifier, null);
    }

    private ExecutionProvider(String identifier, ExecutionProviderConfigFactory factory) {
        this.identifier = identifier;
        this.factory = factory;
    }

    boolean isSupported() {
        return factory != null;
    }

    public static final ExecutionProvider of(String identifier) {
        for (ExecutionProvider executionProvider : ExecutionProvider.values()) {
            if (executionProvider.identifier.equals(identifier)) {
                return executionProvider;
            }
        }
        return null;
    }
}
