/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * The universe of possible execution providers.
 *
 * The identifiers are the constants defined in //https://github.com/microsoft/onnxruntime/blob/main/include/onnxruntime/core/graph/constants.h
 *
 */
public enum ExecutionProvider {
    /**
     * CPU: The default, added implicitly always.
     */
    CPU_EXECUTION_PROVIDER("CPUExecutionProvider", ExecutionProviderCPUConfig::new),
    /**
     * CUDA: supported
     */
    CUDA_EXECUTION_PROVIDER("CUDAExecutionProvider", ExecutionProviderCUDAConfig::new),
    /**
     * DNNL: supported
     */
    DNNL_EXECUTION_PROVIDER("DnnlExecutionProvider", ExecutionProviderDnnlConfig::new),
    /**
     * OpenVINO: supported
     */
    OPENVINO_EXECUTION_PROVIDER("OpenVINOExecutionProvider", ExecutionProviderOpenVINOConfig::new),
    /**
     * VitisAI: not supported
     */
    VITISAI_EXECUTION_PROVIDER("VitisAIExecutionProvider"),
    /**
     * TensorRT: supported
     */
    TENSORRT_EXECUTION_PROVIDER("TensorrtExecutionProvider", ExecutionProviderTensorRTConfig::new),
    /**
     * NNApi: not supported
     */
    NNAPI_EXECUTION_PROVIDER("NnapiExecutionProvider"),
    /**
     * RKNPU: not supported
     */
    RKNPU_EXECUTION_PROVIDER("RknpuExecutionProvider"),
    /**
     * DML: not supported
     */
    DML_EXECUTION_PROVIDER("DmlExecutionProvider"),
    /**
     * MIGraphX: supported
     */
    MIGRAPHX_EXECUTION_PROVIDER("MIGraphXExecutionProvider", ExecutionProviderMIGraphXConfig::new),
    /**
     * ACL: not supported
     */
    ACL_EXECUTION_PROVIDER("ACLExecutionProvider"),
    /**
     * ARMNN: not supported
     */
    ARMNN_EXECUTION_PROVIDER("ArmNNExecutionProvider"),
    /**
     * ROCM: supported
     */
    ROCM_EXECUTION_PROVIDER("ROCMExecutionProvider", ExecutionProviderROCMConfig::new),
    /**
     * CoreML: supported
     */
    COREML_EXECUTION_PROVIDER("CoreMLExecutionProvider", ExecutionProviderCoreMLConfig::new),
    /**
     * SNPE: supported
     */
    SNPE_EXECUTION_PROVIDER("SNPEExecutionProvider", ExecutionProviderSimpleMapConfig.of("SNPE")),
    /**
     * TVM: not supported
     */
    TVM_EXECUTION_PROVIDER("TvmExecutionProvider"),
    /**
     * XNNPACK: supported
     */
    XNNPACK_EXECUTION_PROVIDER("XnnpackExecutionProvider", ExecutionProviderSimpleMapConfig.of("XNNPACK")),
    /**
     * CANN: not supported
     */
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

    /**
     * Find a enum value based on its identifier string.
     * @param identifier the string constant name for this execution provider
     * @return an enum value
     */
    public static final ExecutionProvider of(String identifier) {
        for (ExecutionProvider executionProvider : ExecutionProvider.values()) {
            if (executionProvider.identifier.equals(identifier)) {
                return executionProvider;
            }
        }
        return null;
    }
}
