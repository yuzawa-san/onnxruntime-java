/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class OrtApi {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_POINTER$LAYOUT.withName("CreateStatus"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetErrorCode"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetErrorMessage"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateEnv"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateEnvWithCustomLogger"),
                    Constants$root.C_POINTER$LAYOUT.withName("EnableTelemetryEvents"),
                    Constants$root.C_POINTER$LAYOUT.withName("DisableTelemetryEvents"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSession"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSessionFromArray"),
                    Constants$root.C_POINTER$LAYOUT.withName("Run"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSessionOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetOptimizedModelFilePath"),
                    Constants$root.C_POINTER$LAYOUT.withName("CloneSessionOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetSessionExecutionMode"),
                    Constants$root.C_POINTER$LAYOUT.withName("EnableProfiling"),
                    Constants$root.C_POINTER$LAYOUT.withName("DisableProfiling"),
                    Constants$root.C_POINTER$LAYOUT.withName("EnableMemPattern"),
                    Constants$root.C_POINTER$LAYOUT.withName("DisableMemPattern"),
                    Constants$root.C_POINTER$LAYOUT.withName("EnableCpuMemArena"),
                    Constants$root.C_POINTER$LAYOUT.withName("DisableCpuMemArena"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetSessionLogId"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetSessionLogVerbosityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetSessionLogSeverityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetSessionGraphOptimizationLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetIntraOpNumThreads"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetInterOpNumThreads"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateCustomOpDomain"),
                    Constants$root.C_POINTER$LAYOUT.withName("CustomOpDomain_Add"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddCustomOpDomain"),
                    Constants$root.C_POINTER$LAYOUT.withName("RegisterCustomOpsLibrary"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetInputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetOutputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetOverridableInitializerCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetInputTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetOutputTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetOverridableInitializerTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetInputName"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetOutputName"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetOverridableInitializerName"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateRunOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsSetRunLogVerbosityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsSetRunLogSeverityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsSetRunTag"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsGetRunLogVerbosityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsGetRunLogSeverityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsGetRunTag"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsSetTerminate"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunOptionsUnsetTerminate"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateTensorAsOrtValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateTensorWithDataAsOrtValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("IsTensor"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorMutableData"),
                    Constants$root.C_POINTER$LAYOUT.withName("FillStringTensor"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetStringTensorDataLength"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetStringTensorContent"),
                    Constants$root.C_POINTER$LAYOUT.withName("CastTypeInfoToTensorInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetOnnxTypeFromTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateTensorTypeAndShapeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetTensorElementType"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetDimensions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorElementType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetDimensionsCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetDimensions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSymbolicDimensions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorShapeElementCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorTypeAndShape"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetValueType"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateMemoryInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateCpuMemoryInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("CompareMemoryInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("MemoryInfoGetName"),
                    Constants$root.C_POINTER$LAYOUT.withName("MemoryInfoGetId"),
                    Constants$root.C_POINTER$LAYOUT.withName("MemoryInfoGetMemType"),
                    Constants$root.C_POINTER$LAYOUT.withName("MemoryInfoGetType"),
                    Constants$root.C_POINTER$LAYOUT.withName("AllocatorAlloc"),
                    Constants$root.C_POINTER$LAYOUT.withName("AllocatorFree"),
                    Constants$root.C_POINTER$LAYOUT.withName("AllocatorGetInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetAllocatorWithDefaultOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddFreeDimensionOverride"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetValueCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateOpaqueValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetOpaqueValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetAttribute_float"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetAttribute_int64"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetAttribute_string"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetInputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetOutputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetInput"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetOutput"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseEnv"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseStatus"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseMemoryInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseSession"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseRunOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseTensorTypeAndShapeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseSessionOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseCustomOpDomain"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetDenotationFromTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("CastTypeInfoToMapTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("CastTypeInfoToSequenceTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetMapKeyType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetMapValueType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSequenceElementType"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseMapTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseSequenceTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionEndProfiling"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetModelMetadata"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetProducerName"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetGraphName"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetDomain"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetDescription"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataLookupCustomMetadataMap"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetVersion"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseModelMetadata"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateEnvWithGlobalThreadPools"),
                    Constants$root.C_POINTER$LAYOUT.withName("DisablePerSessionThreads"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateThreadingOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseThreadingOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetCustomMetadataMapKeys"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddFreeDimensionOverrideByName"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetAvailableProviders"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseAvailableProviders"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetStringTensorElementLength"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetStringTensorElement"),
                    Constants$root.C_POINTER$LAYOUT.withName("FillStringTensorElement"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddSessionConfigEntry"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateAllocator"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseAllocator"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunWithBinding"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateIoBinding"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseIoBinding"),
                    Constants$root.C_POINTER$LAYOUT.withName("BindInput"),
                    Constants$root.C_POINTER$LAYOUT.withName("BindOutput"),
                    Constants$root.C_POINTER$LAYOUT.withName("BindOutputToDevice"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetBoundOutputNames"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetBoundOutputValues"),
                    Constants$root.C_POINTER$LAYOUT.withName("ClearBoundInputs"),
                    Constants$root.C_POINTER$LAYOUT.withName("ClearBoundOutputs"),
                    Constants$root.C_POINTER$LAYOUT.withName("TensorAt"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateAndRegisterAllocator"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetLanguageProjection"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionGetProfilingStartTimeNs"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalIntraOpNumThreads"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalInterOpNumThreads"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalSpinControl"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddInitializer"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateEnvWithCustomLoggerAndGlobalThreadPools"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_CUDA"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_ROCM"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_OpenVINO"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalDenormalAsZero"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateArenaCfg"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseArenaCfg"),
                    Constants$root.C_POINTER$LAYOUT.withName("ModelMetadataGetGraphDescription"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_TensorRT"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetCurrentGpuDeviceId"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetCurrentGpuDeviceId"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetAttributeArray_float"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetAttributeArray_int64"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateArenaCfgV2"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddRunConfigEntry"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreatePrepackedWeightsContainer"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleasePrepackedWeightsContainer"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSessionWithPrepackedWeightsContainer"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSessionFromArrayWithPrepackedWeightsContainer"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_TensorRT_V2"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateTensorRTProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateTensorRTProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorRTProviderOptionsAsString"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseTensorRTProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("EnableOrtCustomOps"),
                    Constants$root.C_POINTER$LAYOUT.withName("RegisterAllocator"),
                    Constants$root.C_POINTER$LAYOUT.withName("UnregisterAllocator"),
                    Constants$root.C_POINTER$LAYOUT.withName("IsSparseTensor"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSparseTensorAsOrtValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("FillSparseTensorCoo"),
                    Constants$root.C_POINTER$LAYOUT.withName("FillSparseTensorCsr"),
                    Constants$root.C_POINTER$LAYOUT.withName("FillSparseTensorBlockSparse"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateSparseTensorWithValuesAsOrtValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("UseCooIndices"),
                    Constants$root.C_POINTER$LAYOUT.withName("UseCsrIndices"),
                    Constants$root.C_POINTER$LAYOUT.withName("UseBlockSparseIndices"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSparseTensorFormat"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSparseTensorValuesTypeAndShape"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSparseTensorValues"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSparseTensorIndicesTypeShape"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSparseTensorIndices"),
                    Constants$root.C_POINTER$LAYOUT.withName("HasValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetGPUComputeStream"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorMemoryInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetExecutionProviderApi"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsSetCustomCreateThreadFn"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsSetCustomThreadCreationOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsSetCustomJoinThreadFn"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalCustomCreateThreadFn"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalCustomThreadCreationOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalCustomJoinThreadFn"),
                    Constants$root.C_POINTER$LAYOUT.withName("SynchronizeBoundInputs"),
                    Constants$root.C_POINTER$LAYOUT.withName("SynchronizeBoundOutputs"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_CUDA_V2"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateCUDAProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateCUDAProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetCUDAProviderOptionsAsString"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseCUDAProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_MIGraphX"),
                    Constants$root.C_POINTER$LAYOUT.withName("AddExternalInitializers"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateOpAttr"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseOpAttr"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateOp"),
                    Constants$root.C_POINTER$LAYOUT.withName("InvokeOp"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseOp"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider"),
                    Constants$root.C_POINTER$LAYOUT.withName("CopyKernelInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseKernelInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTrainingApi"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_CANN"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateCANNProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateCANNProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetCANNProviderOptionsAsString"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseCANNProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("MemoryInfoGetDeviceType"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateEnvWithCustomLogLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetGlobalIntraOpThreadAffinity"),
                    Constants$root.C_POINTER$LAYOUT.withName("RegisterCustomOpsLibrary_V2"),
                    Constants$root.C_POINTER$LAYOUT.withName("RegisterCustomOpsUsingFunction"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetInputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetOutputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetInputName"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetOutputName"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetInputTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetOutputTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetAttribute_tensor"),
                    Constants$root.C_POINTER$LAYOUT.withName("HasSessionConfigEntry"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetSessionConfigEntry"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_Dnnl"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateDnnlProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateDnnlProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetDnnlProviderOptionsAsString"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseDnnlProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetNodeName"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfo_GetLogger"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetLogger"),
                    Constants$root.C_POINTER$LAYOUT.withName("Logger_LogMessage"),
                    Constants$root.C_POINTER$LAYOUT.withName("Logger_GetLoggingSeverityLevel"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelInfoGetConstantInput_tensor"),
                    Constants$root.C_POINTER$LAYOUT.withName("CastTypeInfoToOptionalTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetOptionalContainedTypeInfo"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetResizedStringTensorElementBuffer"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetAllocator"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetBuildInfoString"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateROCMProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateROCMProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetROCMProviderOptionsAsString"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReleaseROCMProviderOptions"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateAndRegisterAllocatorV2"),
                    Constants$root.C_POINTER$LAYOUT.withName("RunAsync"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateTensorRTProviderOptionsWithValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetTensorRTProviderOptionsByName"),
                    Constants$root.C_POINTER$LAYOUT.withName("UpdateCUDAProviderOptionsWithValue"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetCUDAProviderOptionsByName"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_GetResource"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetUserLoggingFunction"),
                    Constants$root.C_POINTER$LAYOUT.withName("ShapeInferContext_GetInputCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("ShapeInferContext_GetInputTypeShape"),
                    Constants$root.C_POINTER$LAYOUT.withName("ShapeInferContext_GetAttribute"),
                    Constants$root.C_POINTER$LAYOUT.withName("ShapeInferContext_SetOutputTypeShape"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetSymbolicDimensions"),
                    Constants$root.C_POINTER$LAYOUT.withName("ReadOpAttr"),
                    Constants$root.C_POINTER$LAYOUT.withName("SetDeterministicCompute"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelContext_ParallelFor"),
                    Constants$root.C_POINTER$LAYOUT.withName("SessionOptionsAppendExecutionProvider_OpenVINO_V2"))
            .withName("OrtApi");

    public static MemoryLayout $LAYOUT() {
        return OrtApi.$struct$LAYOUT;
    }

    static final FunctionDescriptor CreateStatus$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateStatus$MH = RuntimeHelper.downcallHandle(OrtApi.CreateStatus$FUNC);

    public interface CreateStatus {

        java.lang.foreign.Addressable apply(int _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CreateStatus fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateStatus.class, fi, OrtApi.CreateStatus$FUNC, session);
        }

        static CreateStatus ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateStatus$MH.invokeExact(
                                    (Addressable) symbol, __x0, (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateStatus$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateStatus"));

    public static VarHandle CreateStatus$VH() {
        return OrtApi.CreateStatus$VH;
    }

    public static MemoryAddress CreateStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateStatus$VH.get(seg);
    }

    public static void CreateStatus$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateStatus$VH.set(seg, x);
    }

    public static MemoryAddress CreateStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateStatus$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateStatus$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateStatus$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateStatus CreateStatus(MemorySegment segment, MemorySession session) {
        return CreateStatus.ofAddress(CreateStatus$get(segment), session);
    }

    static final FunctionDescriptor GetErrorCode$FUNC =
            FunctionDescriptor.of(Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetErrorCode$MH = RuntimeHelper.downcallHandle(OrtApi.GetErrorCode$FUNC);

    public interface GetErrorCode {

        int apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetErrorCode fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetErrorCode.class, fi, OrtApi.GetErrorCode$FUNC, session);
        }

        static GetErrorCode ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (int) OrtApi.GetErrorCode$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetErrorCode$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetErrorCode"));

    public static VarHandle GetErrorCode$VH() {
        return OrtApi.GetErrorCode$VH;
    }

    public static MemoryAddress GetErrorCode$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetErrorCode$VH.get(seg);
    }

    public static void GetErrorCode$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetErrorCode$VH.set(seg, x);
    }

    public static MemoryAddress GetErrorCode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetErrorCode$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetErrorCode$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetErrorCode$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetErrorCode GetErrorCode(MemorySegment segment, MemorySession session) {
        return GetErrorCode.ofAddress(GetErrorCode$get(segment), session);
    }

    static final FunctionDescriptor GetErrorMessage$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetErrorMessage$MH = RuntimeHelper.downcallHandle(OrtApi.GetErrorMessage$FUNC);

    public interface GetErrorMessage {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetErrorMessage fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetErrorMessage.class, fi, OrtApi.GetErrorMessage$FUNC, session);
        }

        static GetErrorMessage ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetErrorMessage$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetErrorMessage$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetErrorMessage"));

    public static VarHandle GetErrorMessage$VH() {
        return OrtApi.GetErrorMessage$VH;
    }

    public static MemoryAddress GetErrorMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetErrorMessage$VH.get(seg);
    }

    public static void GetErrorMessage$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetErrorMessage$VH.set(seg, x);
    }

    public static MemoryAddress GetErrorMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetErrorMessage$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetErrorMessage$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetErrorMessage$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetErrorMessage GetErrorMessage(MemorySegment segment, MemorySession session) {
        return GetErrorMessage.ofAddress(GetErrorMessage$get(segment), session);
    }

    static final FunctionDescriptor CreateEnv$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateEnv$MH = RuntimeHelper.downcallHandle(OrtApi.CreateEnv$FUNC);

    public interface CreateEnv {

        java.lang.foreign.Addressable apply(
                int _x0, java.lang.foreign.MemoryAddress _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(CreateEnv fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateEnv.class, fi, OrtApi.CreateEnv$FUNC, session);
        }

        static CreateEnv ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0, java.lang.foreign.MemoryAddress __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateEnv$MH.invokeExact(
                                    (Addressable) symbol,
                                    __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnv$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateEnv"));

    public static VarHandle CreateEnv$VH() {
        return OrtApi.CreateEnv$VH;
    }

    public static MemoryAddress CreateEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateEnv$VH.get(seg);
    }

    public static void CreateEnv$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnv$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateEnv$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnv$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnv$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnv CreateEnv(MemorySegment segment, MemorySession session) {
        return CreateEnv.ofAddress(CreateEnv$get(segment), session);
    }

    static final FunctionDescriptor CreateEnvWithCustomLogger$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateEnvWithCustomLogger$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateEnvWithCustomLogger$FUNC);

    public interface CreateEnvWithCustomLogger {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                int _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateEnvWithCustomLogger fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLogger.class, fi, OrtApi.CreateEnvWithCustomLogger$FUNC, session);
        }

        static CreateEnvWithCustomLogger ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    int __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateEnvWithCustomLogger$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnvWithCustomLogger$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLogger"));

    public static VarHandle CreateEnvWithCustomLogger$VH() {
        return OrtApi.CreateEnvWithCustomLogger$VH;
    }

    public static MemoryAddress CreateEnvWithCustomLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateEnvWithCustomLogger$VH.get(seg);
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLogger$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnvWithCustomLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateEnvWithCustomLogger$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLogger$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithCustomLogger CreateEnvWithCustomLogger(MemorySegment segment, MemorySession session) {
        return CreateEnvWithCustomLogger.ofAddress(CreateEnvWithCustomLogger$get(segment), session);
    }

    static final FunctionDescriptor EnableTelemetryEvents$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableTelemetryEvents$MH =
            RuntimeHelper.downcallHandle(OrtApi.EnableTelemetryEvents$FUNC);

    public interface EnableTelemetryEvents {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(EnableTelemetryEvents fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    EnableTelemetryEvents.class, fi, OrtApi.EnableTelemetryEvents$FUNC, session);
        }

        static EnableTelemetryEvents ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.EnableTelemetryEvents$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableTelemetryEvents$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("EnableTelemetryEvents"));

    public static VarHandle EnableTelemetryEvents$VH() {
        return OrtApi.EnableTelemetryEvents$VH;
    }

    public static MemoryAddress EnableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableTelemetryEvents$VH.get(seg);
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableTelemetryEvents$VH.set(seg, x);
    }

    public static MemoryAddress EnableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableTelemetryEvents$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableTelemetryEvents$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableTelemetryEvents EnableTelemetryEvents(MemorySegment segment, MemorySession session) {
        return EnableTelemetryEvents.ofAddress(EnableTelemetryEvents$get(segment), session);
    }

    static final FunctionDescriptor DisableTelemetryEvents$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableTelemetryEvents$MH =
            RuntimeHelper.downcallHandle(OrtApi.DisableTelemetryEvents$FUNC);

    public interface DisableTelemetryEvents {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(DisableTelemetryEvents fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    DisableTelemetryEvents.class, fi, OrtApi.DisableTelemetryEvents$FUNC, session);
        }

        static DisableTelemetryEvents ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.DisableTelemetryEvents$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableTelemetryEvents$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("DisableTelemetryEvents"));

    public static VarHandle DisableTelemetryEvents$VH() {
        return OrtApi.DisableTelemetryEvents$VH;
    }

    public static MemoryAddress DisableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableTelemetryEvents$VH.get(seg);
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableTelemetryEvents$VH.set(seg, x);
    }

    public static MemoryAddress DisableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableTelemetryEvents$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableTelemetryEvents$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableTelemetryEvents DisableTelemetryEvents(MemorySegment segment, MemorySession session) {
        return DisableTelemetryEvents.ofAddress(DisableTelemetryEvents$get(segment), session);
    }

    static final FunctionDescriptor CreateSession$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSession$MH = RuntimeHelper.downcallHandle(OrtApi.CreateSession$FUNC);

    public interface CreateSession {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(CreateSession fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateSession.class, fi, OrtApi.CreateSession$FUNC, session);
        }

        static CreateSession ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateSession$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSession$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateSession"));

    public static VarHandle CreateSession$VH() {
        return OrtApi.CreateSession$VH;
    }

    public static MemoryAddress CreateSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSession$VH.get(seg);
    }

    public static void CreateSession$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSession$VH.set(seg, x);
    }

    public static MemoryAddress CreateSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSession$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSession$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSession$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSession CreateSession(MemorySegment segment, MemorySession session) {
        return CreateSession.ofAddress(CreateSession$get(segment), session);
    }

    static final FunctionDescriptor CreateSessionFromArray$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSessionFromArray$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateSessionFromArray$FUNC);

    public interface CreateSessionFromArray {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateSessionFromArray fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArray.class, fi, OrtApi.CreateSessionFromArray$FUNC, session);
        }

        static CreateSessionFromArray ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionFromArray$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionFromArray$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateSessionFromArray"));

    public static VarHandle CreateSessionFromArray$VH() {
        return OrtApi.CreateSessionFromArray$VH;
    }

    public static MemoryAddress CreateSessionFromArray$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionFromArray$VH.get(seg);
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionFromArray$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionFromArray$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionFromArray$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionFromArray$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionFromArray CreateSessionFromArray(MemorySegment segment, MemorySession session) {
        return CreateSessionFromArray.ofAddress(CreateSessionFromArray$get(segment), session);
    }

    static final FunctionDescriptor Run$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Run$MH = RuntimeHelper.downcallHandle(OrtApi.Run$FUNC);

    public interface Run {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4,
                java.lang.foreign.MemoryAddress _x5,
                long _x6,
                java.lang.foreign.MemoryAddress _x7);

        static MemorySegment allocate(Run fi, MemorySession session) {
            return RuntimeHelper.upcallStub(Run.class, fi, OrtApi.Run$FUNC, session);
        }

        static Run ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    long __x6,
                    java.lang.foreign.MemoryAddress __x7) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress) OrtApi.Run$MH.invokeExact(
                            (Addressable) symbol,
                            (java.lang.foreign.Addressable) __x0,
                            (java.lang.foreign.Addressable) __x1,
                            (java.lang.foreign.Addressable) __x2,
                            (java.lang.foreign.Addressable) __x3,
                            __x4,
                            (java.lang.foreign.Addressable) __x5,
                            __x6,
                            (java.lang.foreign.Addressable) __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Run$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Run"));

    public static VarHandle Run$VH() {
        return OrtApi.Run$VH;
    }

    public static MemoryAddress Run$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.Run$VH.get(seg);
    }

    public static void Run$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.Run$VH.set(seg, x);
    }

    public static MemoryAddress Run$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.Run$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Run$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.Run$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Run Run(MemorySegment segment, MemorySession session) {
        return Run.ofAddress(Run$get(segment), session);
    }

    static final FunctionDescriptor CreateSessionOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSessionOptions$MH = RuntimeHelper.downcallHandle(OrtApi.CreateSessionOptions$FUNC);

    public interface CreateSessionOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateSessionOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateSessionOptions.class, fi, OrtApi.CreateSessionOptions$FUNC, session);
        }

        static CreateSessionOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateSessionOptions"));

    public static VarHandle CreateSessionOptions$VH() {
        return OrtApi.CreateSessionOptions$VH;
    }

    public static MemoryAddress CreateSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionOptions$VH.get(seg);
    }

    public static void CreateSessionOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionOptions CreateSessionOptions(MemorySegment segment, MemorySession session) {
        return CreateSessionOptions.ofAddress(CreateSessionOptions$get(segment), session);
    }

    static final FunctionDescriptor SetOptimizedModelFilePath$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetOptimizedModelFilePath$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetOptimizedModelFilePath$FUNC);

    public interface SetOptimizedModelFilePath {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SetOptimizedModelFilePath fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetOptimizedModelFilePath.class, fi, OrtApi.SetOptimizedModelFilePath$FUNC, session);
        }

        static SetOptimizedModelFilePath ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetOptimizedModelFilePath$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetOptimizedModelFilePath$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetOptimizedModelFilePath"));

    public static VarHandle SetOptimizedModelFilePath$VH() {
        return OrtApi.SetOptimizedModelFilePath$VH;
    }

    public static MemoryAddress SetOptimizedModelFilePath$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetOptimizedModelFilePath$VH.get(seg);
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetOptimizedModelFilePath$VH.set(seg, x);
    }

    public static MemoryAddress SetOptimizedModelFilePath$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetOptimizedModelFilePath$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetOptimizedModelFilePath$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetOptimizedModelFilePath SetOptimizedModelFilePath(MemorySegment segment, MemorySession session) {
        return SetOptimizedModelFilePath.ofAddress(SetOptimizedModelFilePath$get(segment), session);
    }

    static final FunctionDescriptor CloneSessionOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CloneSessionOptions$MH = RuntimeHelper.downcallHandle(OrtApi.CloneSessionOptions$FUNC);

    public interface CloneSessionOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CloneSessionOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CloneSessionOptions.class, fi, OrtApi.CloneSessionOptions$FUNC, session);
        }

        static CloneSessionOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CloneSessionOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CloneSessionOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CloneSessionOptions"));

    public static VarHandle CloneSessionOptions$VH() {
        return OrtApi.CloneSessionOptions$VH;
    }

    public static MemoryAddress CloneSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CloneSessionOptions$VH.get(seg);
    }

    public static void CloneSessionOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CloneSessionOptions$VH.set(seg, x);
    }

    public static MemoryAddress CloneSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CloneSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CloneSessionOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CloneSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CloneSessionOptions CloneSessionOptions(MemorySegment segment, MemorySession session) {
        return CloneSessionOptions.ofAddress(CloneSessionOptions$get(segment), session);
    }

    static final FunctionDescriptor SetSessionExecutionMode$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionExecutionMode$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionExecutionMode$FUNC);

    public interface SetSessionExecutionMode {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetSessionExecutionMode fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetSessionExecutionMode.class, fi, OrtApi.SetSessionExecutionMode$FUNC, session);
        }

        static SetSessionExecutionMode ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetSessionExecutionMode$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionExecutionMode$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetSessionExecutionMode"));

    public static VarHandle SetSessionExecutionMode$VH() {
        return OrtApi.SetSessionExecutionMode$VH;
    }

    public static MemoryAddress SetSessionExecutionMode$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionExecutionMode$VH.get(seg);
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionExecutionMode$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionExecutionMode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionExecutionMode$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionExecutionMode$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionExecutionMode SetSessionExecutionMode(MemorySegment segment, MemorySession session) {
        return SetSessionExecutionMode.ofAddress(SetSessionExecutionMode$get(segment), session);
    }

    static final FunctionDescriptor EnableProfiling$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableProfiling$MH = RuntimeHelper.downcallHandle(OrtApi.EnableProfiling$FUNC);

    public interface EnableProfiling {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(EnableProfiling fi, MemorySession session) {
            return RuntimeHelper.upcallStub(EnableProfiling.class, fi, OrtApi.EnableProfiling$FUNC, session);
        }

        static EnableProfiling ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.EnableProfiling$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableProfiling$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("EnableProfiling"));

    public static VarHandle EnableProfiling$VH() {
        return OrtApi.EnableProfiling$VH;
    }

    public static MemoryAddress EnableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableProfiling$VH.get(seg);
    }

    public static void EnableProfiling$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableProfiling$VH.set(seg, x);
    }

    public static MemoryAddress EnableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableProfiling$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableProfiling EnableProfiling(MemorySegment segment, MemorySession session) {
        return EnableProfiling.ofAddress(EnableProfiling$get(segment), session);
    }

    static final FunctionDescriptor DisableProfiling$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableProfiling$MH = RuntimeHelper.downcallHandle(OrtApi.DisableProfiling$FUNC);

    public interface DisableProfiling {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(DisableProfiling fi, MemorySession session) {
            return RuntimeHelper.upcallStub(DisableProfiling.class, fi, OrtApi.DisableProfiling$FUNC, session);
        }

        static DisableProfiling ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.DisableProfiling$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableProfiling$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("DisableProfiling"));

    public static VarHandle DisableProfiling$VH() {
        return OrtApi.DisableProfiling$VH;
    }

    public static MemoryAddress DisableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableProfiling$VH.get(seg);
    }

    public static void DisableProfiling$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableProfiling$VH.set(seg, x);
    }

    public static MemoryAddress DisableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableProfiling$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableProfiling DisableProfiling(MemorySegment segment, MemorySession session) {
        return DisableProfiling.ofAddress(DisableProfiling$get(segment), session);
    }

    static final FunctionDescriptor EnableMemPattern$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableMemPattern$MH = RuntimeHelper.downcallHandle(OrtApi.EnableMemPattern$FUNC);

    public interface EnableMemPattern {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(EnableMemPattern fi, MemorySession session) {
            return RuntimeHelper.upcallStub(EnableMemPattern.class, fi, OrtApi.EnableMemPattern$FUNC, session);
        }

        static EnableMemPattern ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.EnableMemPattern$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableMemPattern$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("EnableMemPattern"));

    public static VarHandle EnableMemPattern$VH() {
        return OrtApi.EnableMemPattern$VH;
    }

    public static MemoryAddress EnableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableMemPattern$VH.get(seg);
    }

    public static void EnableMemPattern$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableMemPattern$VH.set(seg, x);
    }

    public static MemoryAddress EnableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableMemPattern$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableMemPattern$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableMemPattern$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableMemPattern EnableMemPattern(MemorySegment segment, MemorySession session) {
        return EnableMemPattern.ofAddress(EnableMemPattern$get(segment), session);
    }

    static final FunctionDescriptor DisableMemPattern$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableMemPattern$MH = RuntimeHelper.downcallHandle(OrtApi.DisableMemPattern$FUNC);

    public interface DisableMemPattern {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(DisableMemPattern fi, MemorySession session) {
            return RuntimeHelper.upcallStub(DisableMemPattern.class, fi, OrtApi.DisableMemPattern$FUNC, session);
        }

        static DisableMemPattern ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.DisableMemPattern$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableMemPattern$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("DisableMemPattern"));

    public static VarHandle DisableMemPattern$VH() {
        return OrtApi.DisableMemPattern$VH;
    }

    public static MemoryAddress DisableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableMemPattern$VH.get(seg);
    }

    public static void DisableMemPattern$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableMemPattern$VH.set(seg, x);
    }

    public static MemoryAddress DisableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableMemPattern$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableMemPattern$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableMemPattern$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableMemPattern DisableMemPattern(MemorySegment segment, MemorySession session) {
        return DisableMemPattern.ofAddress(DisableMemPattern$get(segment), session);
    }

    static final FunctionDescriptor EnableCpuMemArena$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableCpuMemArena$MH = RuntimeHelper.downcallHandle(OrtApi.EnableCpuMemArena$FUNC);

    public interface EnableCpuMemArena {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(EnableCpuMemArena fi, MemorySession session) {
            return RuntimeHelper.upcallStub(EnableCpuMemArena.class, fi, OrtApi.EnableCpuMemArena$FUNC, session);
        }

        static EnableCpuMemArena ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.EnableCpuMemArena$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableCpuMemArena$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("EnableCpuMemArena"));

    public static VarHandle EnableCpuMemArena$VH() {
        return OrtApi.EnableCpuMemArena$VH;
    }

    public static MemoryAddress EnableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableCpuMemArena$VH.get(seg);
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableCpuMemArena$VH.set(seg, x);
    }

    public static MemoryAddress EnableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableCpuMemArena$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableCpuMemArena$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableCpuMemArena EnableCpuMemArena(MemorySegment segment, MemorySession session) {
        return EnableCpuMemArena.ofAddress(EnableCpuMemArena$get(segment), session);
    }

    static final FunctionDescriptor DisableCpuMemArena$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableCpuMemArena$MH = RuntimeHelper.downcallHandle(OrtApi.DisableCpuMemArena$FUNC);

    public interface DisableCpuMemArena {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(DisableCpuMemArena fi, MemorySession session) {
            return RuntimeHelper.upcallStub(DisableCpuMemArena.class, fi, OrtApi.DisableCpuMemArena$FUNC, session);
        }

        static DisableCpuMemArena ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.DisableCpuMemArena$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableCpuMemArena$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("DisableCpuMemArena"));

    public static VarHandle DisableCpuMemArena$VH() {
        return OrtApi.DisableCpuMemArena$VH;
    }

    public static MemoryAddress DisableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableCpuMemArena$VH.get(seg);
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableCpuMemArena$VH.set(seg, x);
    }

    public static MemoryAddress DisableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisableCpuMemArena$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableCpuMemArena$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableCpuMemArena DisableCpuMemArena(MemorySegment segment, MemorySession session) {
        return DisableCpuMemArena.ofAddress(DisableCpuMemArena$get(segment), session);
    }

    static final FunctionDescriptor SetSessionLogId$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetSessionLogId$MH = RuntimeHelper.downcallHandle(OrtApi.SetSessionLogId$FUNC);

    public interface SetSessionLogId {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SetSessionLogId fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SetSessionLogId.class, fi, OrtApi.SetSessionLogId$FUNC, session);
        }

        static SetSessionLogId ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogId$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionLogId$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetSessionLogId"));

    public static VarHandle SetSessionLogId$VH() {
        return OrtApi.SetSessionLogId$VH;
    }

    public static MemoryAddress SetSessionLogId$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogId$VH.get(seg);
    }

    public static void SetSessionLogId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionLogId$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionLogId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionLogId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogId SetSessionLogId(MemorySegment segment, MemorySession session) {
        return SetSessionLogId.ofAddress(SetSessionLogId$get(segment), session);
    }

    static final FunctionDescriptor SetSessionLogVerbosityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionLogVerbosityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionLogVerbosityLevel$FUNC);

    public interface SetSessionLogVerbosityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetSessionLogVerbosityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogVerbosityLevel.class, fi, OrtApi.SetSessionLogVerbosityLevel$FUNC, session);
        }

        static SetSessionLogVerbosityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogVerbosityLevel$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionLogVerbosityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetSessionLogVerbosityLevel"));

    public static VarHandle SetSessionLogVerbosityLevel$VH() {
        return OrtApi.SetSessionLogVerbosityLevel$VH;
    }

    public static MemoryAddress SetSessionLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogVerbosityLevel$VH.get(seg);
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetSessionLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel(
            MemorySegment segment, MemorySession session) {
        return SetSessionLogVerbosityLevel.ofAddress(SetSessionLogVerbosityLevel$get(segment), session);
    }

    static final FunctionDescriptor SetSessionLogSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionLogSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionLogSeverityLevel$FUNC);

    public interface SetSessionLogSeverityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetSessionLogSeverityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogSeverityLevel.class, fi, OrtApi.SetSessionLogSeverityLevel$FUNC, session);
        }

        static SetSessionLogSeverityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogSeverityLevel$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionLogSeverityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetSessionLogSeverityLevel"));

    public static VarHandle SetSessionLogSeverityLevel$VH() {
        return OrtApi.SetSessionLogSeverityLevel$VH;
    }

    public static MemoryAddress SetSessionLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionLogSeverityLevel$VH.get(seg);
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionLogSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetSessionLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogSeverityLevel SetSessionLogSeverityLevel(MemorySegment segment, MemorySession session) {
        return SetSessionLogSeverityLevel.ofAddress(SetSessionLogSeverityLevel$get(segment), session);
    }

    static final FunctionDescriptor SetSessionGraphOptimizationLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionGraphOptimizationLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionGraphOptimizationLevel$FUNC);

    public interface SetSessionGraphOptimizationLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetSessionGraphOptimizationLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetSessionGraphOptimizationLevel.class, fi, OrtApi.SetSessionGraphOptimizationLevel$FUNC, session);
        }

        static SetSessionGraphOptimizationLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetSessionGraphOptimizationLevel$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionGraphOptimizationLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetSessionGraphOptimizationLevel"));

    public static VarHandle SetSessionGraphOptimizationLevel$VH() {
        return OrtApi.SetSessionGraphOptimizationLevel$VH;
    }

    public static MemoryAddress SetSessionGraphOptimizationLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSessionGraphOptimizationLevel$VH.get(seg);
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionGraphOptimizationLevel$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionGraphOptimizationLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetSessionGraphOptimizationLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionGraphOptimizationLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel(
            MemorySegment segment, MemorySession session) {
        return SetSessionGraphOptimizationLevel.ofAddress(SetSessionGraphOptimizationLevel$get(segment), session);
    }

    static final FunctionDescriptor SetIntraOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetIntraOpNumThreads$MH = RuntimeHelper.downcallHandle(OrtApi.SetIntraOpNumThreads$FUNC);

    public interface SetIntraOpNumThreads {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetIntraOpNumThreads fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SetIntraOpNumThreads.class, fi, OrtApi.SetIntraOpNumThreads$FUNC, session);
        }

        static SetIntraOpNumThreads ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetIntraOpNumThreads$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetIntraOpNumThreads$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetIntraOpNumThreads"));

    public static VarHandle SetIntraOpNumThreads$VH() {
        return OrtApi.SetIntraOpNumThreads$VH;
    }

    public static MemoryAddress SetIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetIntraOpNumThreads$VH.get(seg);
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetIntraOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetIntraOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetIntraOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetIntraOpNumThreads SetIntraOpNumThreads(MemorySegment segment, MemorySession session) {
        return SetIntraOpNumThreads.ofAddress(SetIntraOpNumThreads$get(segment), session);
    }

    static final FunctionDescriptor SetInterOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetInterOpNumThreads$MH = RuntimeHelper.downcallHandle(OrtApi.SetInterOpNumThreads$FUNC);

    public interface SetInterOpNumThreads {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetInterOpNumThreads fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SetInterOpNumThreads.class, fi, OrtApi.SetInterOpNumThreads$FUNC, session);
        }

        static SetInterOpNumThreads ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetInterOpNumThreads$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetInterOpNumThreads$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetInterOpNumThreads"));

    public static VarHandle SetInterOpNumThreads$VH() {
        return OrtApi.SetInterOpNumThreads$VH;
    }

    public static MemoryAddress SetInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetInterOpNumThreads$VH.get(seg);
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetInterOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetInterOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetInterOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetInterOpNumThreads SetInterOpNumThreads(MemorySegment segment, MemorySession session) {
        return SetInterOpNumThreads.ofAddress(SetInterOpNumThreads$get(segment), session);
    }

    static final FunctionDescriptor CreateCustomOpDomain$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCustomOpDomain$MH = RuntimeHelper.downcallHandle(OrtApi.CreateCustomOpDomain$FUNC);

    public interface CreateCustomOpDomain {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CreateCustomOpDomain fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateCustomOpDomain.class, fi, OrtApi.CreateCustomOpDomain$FUNC, session);
        }

        static CreateCustomOpDomain ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateCustomOpDomain$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateCustomOpDomain$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateCustomOpDomain"));

    public static VarHandle CreateCustomOpDomain$VH() {
        return OrtApi.CreateCustomOpDomain$VH;
    }

    public static MemoryAddress CreateCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCustomOpDomain$VH.get(seg);
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateCustomOpDomain$VH.set(seg, x);
    }

    public static MemoryAddress CreateCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCustomOpDomain CreateCustomOpDomain(MemorySegment segment, MemorySession session) {
        return CreateCustomOpDomain.ofAddress(CreateCustomOpDomain$get(segment), session);
    }

    static final FunctionDescriptor CustomOpDomain_Add$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CustomOpDomain_Add$MH = RuntimeHelper.downcallHandle(OrtApi.CustomOpDomain_Add$FUNC);

    public interface CustomOpDomain_Add {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CustomOpDomain_Add fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CustomOpDomain_Add.class, fi, OrtApi.CustomOpDomain_Add$FUNC, session);
        }

        static CustomOpDomain_Add ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CustomOpDomain_Add$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CustomOpDomain_Add$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CustomOpDomain_Add"));

    public static VarHandle CustomOpDomain_Add$VH() {
        return OrtApi.CustomOpDomain_Add$VH;
    }

    public static MemoryAddress CustomOpDomain_Add$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CustomOpDomain_Add$VH.get(seg);
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CustomOpDomain_Add$VH.set(seg, x);
    }

    public static MemoryAddress CustomOpDomain_Add$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CustomOpDomain_Add$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CustomOpDomain_Add$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CustomOpDomain_Add CustomOpDomain_Add(MemorySegment segment, MemorySession session) {
        return CustomOpDomain_Add.ofAddress(CustomOpDomain_Add$get(segment), session);
    }

    static final FunctionDescriptor AddCustomOpDomain$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddCustomOpDomain$MH = RuntimeHelper.downcallHandle(OrtApi.AddCustomOpDomain$FUNC);

    public interface AddCustomOpDomain {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(AddCustomOpDomain fi, MemorySession session) {
            return RuntimeHelper.upcallStub(AddCustomOpDomain.class, fi, OrtApi.AddCustomOpDomain$FUNC, session);
        }

        static AddCustomOpDomain ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddCustomOpDomain$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddCustomOpDomain$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddCustomOpDomain"));

    public static VarHandle AddCustomOpDomain$VH() {
        return OrtApi.AddCustomOpDomain$VH;
    }

    public static MemoryAddress AddCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddCustomOpDomain$VH.get(seg);
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddCustomOpDomain$VH.set(seg, x);
    }

    public static MemoryAddress AddCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddCustomOpDomain AddCustomOpDomain(MemorySegment segment, MemorySession session) {
        return AddCustomOpDomain.ofAddress(AddCustomOpDomain$get(segment), session);
    }

    static final FunctionDescriptor RegisterCustomOpsLibrary$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsLibrary$MH =
            RuntimeHelper.downcallHandle(OrtApi.RegisterCustomOpsLibrary$FUNC);

    public interface RegisterCustomOpsLibrary {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(RegisterCustomOpsLibrary fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsLibrary.class, fi, OrtApi.RegisterCustomOpsLibrary$FUNC, session);
        }

        static RegisterCustomOpsLibrary ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsLibrary$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RegisterCustomOpsLibrary$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RegisterCustomOpsLibrary"));

    public static VarHandle RegisterCustomOpsLibrary$VH() {
        return OrtApi.RegisterCustomOpsLibrary$VH;
    }

    public static MemoryAddress RegisterCustomOpsLibrary$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsLibrary$VH.get(seg);
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RegisterCustomOpsLibrary$VH.set(seg, x);
    }

    public static MemoryAddress RegisterCustomOpsLibrary$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsLibrary$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RegisterCustomOpsLibrary$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsLibrary RegisterCustomOpsLibrary(MemorySegment segment, MemorySession session) {
        return RegisterCustomOpsLibrary.ofAddress(RegisterCustomOpsLibrary$get(segment), session);
    }

    static final FunctionDescriptor SessionGetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetInputCount$MH = RuntimeHelper.downcallHandle(OrtApi.SessionGetInputCount$FUNC);

    public interface SessionGetInputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionGetInputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SessionGetInputCount.class, fi, OrtApi.SessionGetInputCount$FUNC, session);
        }

        static SessionGetInputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetInputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetInputCount"));

    public static VarHandle SessionGetInputCount$VH() {
        return OrtApi.SessionGetInputCount$VH;
    }

    public static MemoryAddress SessionGetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputCount$VH.get(seg);
    }

    public static void SessionGetInputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetInputCount$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputCount SessionGetInputCount(MemorySegment segment, MemorySession session) {
        return SessionGetInputCount.ofAddress(SessionGetInputCount$get(segment), session);
    }

    static final FunctionDescriptor SessionGetOutputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOutputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOutputCount$FUNC);

    public interface SessionGetOutputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionGetOutputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputCount.class, fi, OrtApi.SessionGetOutputCount$FUNC, session);
        }

        static SessionGetOutputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOutputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOutputCount"));

    public static VarHandle SessionGetOutputCount$VH() {
        return OrtApi.SessionGetOutputCount$VH;
    }

    public static MemoryAddress SessionGetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputCount$VH.get(seg);
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOutputCount$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputCount SessionGetOutputCount(MemorySegment segment, MemorySession session) {
        return SessionGetOutputCount.ofAddress(SessionGetOutputCount$get(segment), session);
    }

    static final FunctionDescriptor SessionGetOverridableInitializerCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOverridableInitializerCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOverridableInitializerCount$FUNC);

    public interface SessionGetOverridableInitializerCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionGetOverridableInitializerCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerCount.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerCount$FUNC,
                    session);
        }

        static SessionGetOverridableInitializerCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionGetOverridableInitializerCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOverridableInitializerCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerCount"));

    public static VarHandle SessionGetOverridableInitializerCount$VH() {
        return OrtApi.SessionGetOverridableInitializerCount$VH;
    }

    public static MemoryAddress SessionGetOverridableInitializerCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOverridableInitializerCount$VH.get(seg);
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerCount$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOverridableInitializerCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionGetOverridableInitializerCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount(
            MemorySegment segment, MemorySession session) {
        return SessionGetOverridableInitializerCount.ofAddress(
                SessionGetOverridableInitializerCount$get(segment), session);
    }

    static final FunctionDescriptor SessionGetInputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetInputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetInputTypeInfo$FUNC);

    public interface SessionGetInputTypeInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(SessionGetInputTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputTypeInfo.class, fi, OrtApi.SessionGetInputTypeInfo$FUNC, session);
        }

        static SessionGetInputTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetInputTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetInputTypeInfo"));

    public static VarHandle SessionGetInputTypeInfo$VH() {
        return OrtApi.SessionGetInputTypeInfo$VH;
    }

    public static MemoryAddress SessionGetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputTypeInfo$VH.get(seg);
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetInputTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetInputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputTypeInfo SessionGetInputTypeInfo(MemorySegment segment, MemorySession session) {
        return SessionGetInputTypeInfo.ofAddress(SessionGetInputTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor SessionGetOutputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOutputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOutputTypeInfo$FUNC);

    public interface SessionGetOutputTypeInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(SessionGetOutputTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputTypeInfo.class, fi, OrtApi.SessionGetOutputTypeInfo$FUNC, session);
        }

        static SessionGetOutputTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOutputTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOutputTypeInfo"));

    public static VarHandle SessionGetOutputTypeInfo$VH() {
        return OrtApi.SessionGetOutputTypeInfo$VH;
    }

    public static MemoryAddress SessionGetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputTypeInfo$VH.get(seg);
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOutputTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOutputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputTypeInfo SessionGetOutputTypeInfo(MemorySegment segment, MemorySession session) {
        return SessionGetOutputTypeInfo.ofAddress(SessionGetOutputTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor SessionGetOverridableInitializerTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOverridableInitializerTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC);

    public interface SessionGetOverridableInitializerTypeInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(SessionGetOverridableInitializerTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerTypeInfo.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC,
                    session);
        }

        static SessionGetOverridableInitializerTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionGetOverridableInitializerTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOverridableInitializerTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerTypeInfo"));

    public static VarHandle SessionGetOverridableInitializerTypeInfo$VH() {
        return OrtApi.SessionGetOverridableInitializerTypeInfo$VH;
    }

    public static MemoryAddress SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOverridableInitializerTypeInfo$VH.get(seg);
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionGetOverridableInitializerTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo(
            MemorySegment segment, MemorySession session) {
        return SessionGetOverridableInitializerTypeInfo.ofAddress(
                SessionGetOverridableInitializerTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor SessionGetInputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetInputName$MH = RuntimeHelper.downcallHandle(OrtApi.SessionGetInputName$FUNC);

    public interface SessionGetInputName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(SessionGetInputName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SessionGetInputName.class, fi, OrtApi.SessionGetInputName$FUNC, session);
        }

        static SessionGetInputName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetInputName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetInputName"));

    public static VarHandle SessionGetInputName$VH() {
        return OrtApi.SessionGetInputName$VH;
    }

    public static MemoryAddress SessionGetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputName$VH.get(seg);
    }

    public static void SessionGetInputName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetInputName$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetInputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetInputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputName SessionGetInputName(MemorySegment segment, MemorySession session) {
        return SessionGetInputName.ofAddress(SessionGetInputName$get(segment), session);
    }

    static final FunctionDescriptor SessionGetOutputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOutputName$MH = RuntimeHelper.downcallHandle(OrtApi.SessionGetOutputName$FUNC);

    public interface SessionGetOutputName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(SessionGetOutputName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SessionGetOutputName.class, fi, OrtApi.SessionGetOutputName$FUNC, session);
        }

        static SessionGetOutputName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOutputName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOutputName"));

    public static VarHandle SessionGetOutputName$VH() {
        return OrtApi.SessionGetOutputName$VH;
    }

    public static MemoryAddress SessionGetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputName$VH.get(seg);
    }

    public static void SessionGetOutputName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOutputName$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOutputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOutputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputName SessionGetOutputName(MemorySegment segment, MemorySession session) {
        return SessionGetOutputName.ofAddress(SessionGetOutputName$get(segment), session);
    }

    static final FunctionDescriptor SessionGetOverridableInitializerName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOverridableInitializerName$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOverridableInitializerName$FUNC);

    public interface SessionGetOverridableInitializerName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(SessionGetOverridableInitializerName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerName.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerName$FUNC,
                    session);
        }

        static SessionGetOverridableInitializerName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionGetOverridableInitializerName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOverridableInitializerName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerName"));

    public static VarHandle SessionGetOverridableInitializerName$VH() {
        return OrtApi.SessionGetOverridableInitializerName$VH;
    }

    public static MemoryAddress SessionGetOverridableInitializerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetOverridableInitializerName$VH.get(seg);
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerName$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOverridableInitializerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionGetOverridableInitializerName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerName SessionGetOverridableInitializerName(
            MemorySegment segment, MemorySession session) {
        return SessionGetOverridableInitializerName.ofAddress(
                SessionGetOverridableInitializerName$get(segment), session);
    }

    static final FunctionDescriptor CreateRunOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateRunOptions$MH = RuntimeHelper.downcallHandle(OrtApi.CreateRunOptions$FUNC);

    public interface CreateRunOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateRunOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateRunOptions.class, fi, OrtApi.CreateRunOptions$FUNC, session);
        }

        static CreateRunOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateRunOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateRunOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateRunOptions"));

    public static VarHandle CreateRunOptions$VH() {
        return OrtApi.CreateRunOptions$VH;
    }

    public static MemoryAddress CreateRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateRunOptions$VH.get(seg);
    }

    public static void CreateRunOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateRunOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateRunOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateRunOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateRunOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateRunOptions CreateRunOptions(MemorySegment segment, MemorySession session) {
        return CreateRunOptions.ofAddress(CreateRunOptions$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsSetRunLogVerbosityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle RunOptionsSetRunLogVerbosityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC);

    public interface RunOptionsSetRunLogVerbosityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogVerbosityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogVerbosityLevel.class,
                    fi,
                    OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC,
                    session);
        }

        static RunOptionsSetRunLogVerbosityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunLogVerbosityLevel$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetRunLogVerbosityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsSetRunLogVerbosityLevel"));

    public static VarHandle RunOptionsSetRunLogVerbosityLevel$VH() {
        return OrtApi.RunOptionsSetRunLogVerbosityLevel$VH;
    }

    public static MemoryAddress RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.get(seg);
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel(
            MemorySegment segment, MemorySession session) {
        return RunOptionsSetRunLogVerbosityLevel.ofAddress(RunOptionsSetRunLogVerbosityLevel$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsSetRunLogSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle RunOptionsSetRunLogSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC);

    public interface RunOptionsSetRunLogSeverityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogSeverityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogSeverityLevel.class, fi, OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC, session);
        }

        static RunOptionsSetRunLogSeverityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunLogSeverityLevel$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetRunLogSeverityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsSetRunLogSeverityLevel"));

    public static VarHandle RunOptionsSetRunLogSeverityLevel$VH() {
        return OrtApi.RunOptionsSetRunLogSeverityLevel$VH;
    }

    public static MemoryAddress RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunLogSeverityLevel$VH.get(seg);
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.RunOptionsSetRunLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel(
            MemorySegment segment, MemorySession session) {
        return RunOptionsSetRunLogSeverityLevel.ofAddress(RunOptionsSetRunLogSeverityLevel$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsSetRunTag$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsSetRunTag$MH = RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetRunTag$FUNC);

    public interface RunOptionsSetRunTag {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RunOptionsSetRunTag fi, MemorySession session) {
            return RuntimeHelper.upcallStub(RunOptionsSetRunTag.class, fi, OrtApi.RunOptionsSetRunTag$FUNC, session);
        }

        static RunOptionsSetRunTag ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunTag$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetRunTag$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsSetRunTag"));

    public static VarHandle RunOptionsSetRunTag$VH() {
        return OrtApi.RunOptionsSetRunTag$VH;
    }

    public static MemoryAddress RunOptionsSetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunTag$VH.get(seg);
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetRunTag$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetRunTag$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetRunTag$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunTag RunOptionsSetRunTag(MemorySegment segment, MemorySession session) {
        return RunOptionsSetRunTag.ofAddress(RunOptionsSetRunTag$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsGetRunLogVerbosityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsGetRunLogVerbosityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC);

    public interface RunOptionsGetRunLogVerbosityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RunOptionsGetRunLogVerbosityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogVerbosityLevel.class,
                    fi,
                    OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC,
                    session);
        }

        static RunOptionsGetRunLogVerbosityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunLogVerbosityLevel$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsGetRunLogVerbosityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsGetRunLogVerbosityLevel"));

    public static VarHandle RunOptionsGetRunLogVerbosityLevel$VH() {
        return OrtApi.RunOptionsGetRunLogVerbosityLevel$VH;
    }

    public static MemoryAddress RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.get(seg);
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunLogVerbosityLevel RunOptionsGetRunLogVerbosityLevel(
            MemorySegment segment, MemorySession session) {
        return RunOptionsGetRunLogVerbosityLevel.ofAddress(RunOptionsGetRunLogVerbosityLevel$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsGetRunLogSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsGetRunLogSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC);

    public interface RunOptionsGetRunLogSeverityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RunOptionsGetRunLogSeverityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogSeverityLevel.class, fi, OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC, session);
        }

        static RunOptionsGetRunLogSeverityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunLogSeverityLevel$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsGetRunLogSeverityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsGetRunLogSeverityLevel"));

    public static VarHandle RunOptionsGetRunLogSeverityLevel$VH() {
        return OrtApi.RunOptionsGetRunLogSeverityLevel$VH;
    }

    public static MemoryAddress RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunLogSeverityLevel$VH.get(seg);
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.RunOptionsGetRunLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunLogSeverityLevel RunOptionsGetRunLogSeverityLevel(
            MemorySegment segment, MemorySession session) {
        return RunOptionsGetRunLogSeverityLevel.ofAddress(RunOptionsGetRunLogSeverityLevel$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsGetRunTag$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsGetRunTag$MH = RuntimeHelper.downcallHandle(OrtApi.RunOptionsGetRunTag$FUNC);

    public interface RunOptionsGetRunTag {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RunOptionsGetRunTag fi, MemorySession session) {
            return RuntimeHelper.upcallStub(RunOptionsGetRunTag.class, fi, OrtApi.RunOptionsGetRunTag$FUNC, session);
        }

        static RunOptionsGetRunTag ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunTag$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsGetRunTag$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsGetRunTag"));

    public static VarHandle RunOptionsGetRunTag$VH() {
        return OrtApi.RunOptionsGetRunTag$VH;
    }

    public static MemoryAddress RunOptionsGetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunTag$VH.get(seg);
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsGetRunTag$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsGetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsGetRunTag$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsGetRunTag$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunTag RunOptionsGetRunTag(MemorySegment segment, MemorySession session) {
        return RunOptionsGetRunTag.ofAddress(RunOptionsGetRunTag$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsSetTerminate$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsSetTerminate$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetTerminate$FUNC);

    public interface RunOptionsSetTerminate {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(RunOptionsSetTerminate fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetTerminate.class, fi, OrtApi.RunOptionsSetTerminate$FUNC, session);
        }

        static RunOptionsSetTerminate ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetTerminate$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetTerminate$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsSetTerminate"));

    public static VarHandle RunOptionsSetTerminate$VH() {
        return OrtApi.RunOptionsSetTerminate$VH;
    }

    public static MemoryAddress RunOptionsSetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetTerminate$VH.get(seg);
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetTerminate$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsSetTerminate$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetTerminate$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetTerminate RunOptionsSetTerminate(MemorySegment segment, MemorySession session) {
        return RunOptionsSetTerminate.ofAddress(RunOptionsSetTerminate$get(segment), session);
    }

    static final FunctionDescriptor RunOptionsUnsetTerminate$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsUnsetTerminate$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsUnsetTerminate$FUNC);

    public interface RunOptionsUnsetTerminate {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(RunOptionsUnsetTerminate fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RunOptionsUnsetTerminate.class, fi, OrtApi.RunOptionsUnsetTerminate$FUNC, session);
        }

        static RunOptionsUnsetTerminate ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsUnsetTerminate$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsUnsetTerminate$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunOptionsUnsetTerminate"));

    public static VarHandle RunOptionsUnsetTerminate$VH() {
        return OrtApi.RunOptionsUnsetTerminate$VH;
    }

    public static MemoryAddress RunOptionsUnsetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsUnsetTerminate$VH.get(seg);
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsUnsetTerminate$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsUnsetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunOptionsUnsetTerminate$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsUnsetTerminate$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsUnsetTerminate RunOptionsUnsetTerminate(MemorySegment segment, MemorySession session) {
        return RunOptionsUnsetTerminate.ofAddress(RunOptionsUnsetTerminate$get(segment), session);
    }

    static final FunctionDescriptor CreateTensorAsOrtValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateTensorAsOrtValue$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateTensorAsOrtValue$FUNC);

    public interface CreateTensorAsOrtValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                int _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateTensorAsOrtValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateTensorAsOrtValue.class, fi, OrtApi.CreateTensorAsOrtValue$FUNC, session);
        }

        static CreateTensorAsOrtValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    int __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorAsOrtValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorAsOrtValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorAsOrtValue"));

    public static VarHandle CreateTensorAsOrtValue$VH() {
        return OrtApi.CreateTensorAsOrtValue$VH;
    }

    public static MemoryAddress CreateTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorAsOrtValue$VH.get(seg);
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorAsOrtValue CreateTensorAsOrtValue(MemorySegment segment, MemorySession session) {
        return CreateTensorAsOrtValue.ofAddress(CreateTensorAsOrtValue$get(segment), session);
    }

    static final FunctionDescriptor CreateTensorWithDataAsOrtValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateTensorWithDataAsOrtValue$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateTensorWithDataAsOrtValue$FUNC);

    public interface CreateTensorWithDataAsOrtValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4,
                int _x5,
                java.lang.foreign.MemoryAddress _x6);

        static MemorySegment allocate(CreateTensorWithDataAsOrtValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateTensorWithDataAsOrtValue.class, fi, OrtApi.CreateTensorWithDataAsOrtValue$FUNC, session);
        }

        static CreateTensorWithDataAsOrtValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4,
                    int __x5,
                    java.lang.foreign.MemoryAddress __x6) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorWithDataAsOrtValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4,
                                    __x5,
                                    (java.lang.foreign.Addressable) __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorWithDataAsOrtValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorWithDataAsOrtValue"));

    public static VarHandle CreateTensorWithDataAsOrtValue$VH() {
        return OrtApi.CreateTensorWithDataAsOrtValue$VH;
    }

    public static MemoryAddress CreateTensorWithDataAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorWithDataAsOrtValue$VH.get(seg);
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorWithDataAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorWithDataAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateTensorWithDataAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorWithDataAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue(
            MemorySegment segment, MemorySession session) {
        return CreateTensorWithDataAsOrtValue.ofAddress(CreateTensorWithDataAsOrtValue$get(segment), session);
    }

    static final FunctionDescriptor IsTensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle IsTensor$MH = RuntimeHelper.downcallHandle(OrtApi.IsTensor$FUNC);

    public interface IsTensor {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(IsTensor fi, MemorySession session) {
            return RuntimeHelper.upcallStub(IsTensor.class, fi, OrtApi.IsTensor$FUNC, session);
        }

        static IsTensor ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.IsTensor$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle IsTensor$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("IsTensor"));

    public static VarHandle IsTensor$VH() {
        return OrtApi.IsTensor$VH;
    }

    public static MemoryAddress IsTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.IsTensor$VH.get(seg);
    }

    public static void IsTensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.IsTensor$VH.set(seg, x);
    }

    public static MemoryAddress IsTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.IsTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void IsTensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.IsTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static IsTensor IsTensor(MemorySegment segment, MemorySession session) {
        return IsTensor.ofAddress(IsTensor$get(segment), session);
    }

    static final FunctionDescriptor GetTensorMutableData$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorMutableData$MH = RuntimeHelper.downcallHandle(OrtApi.GetTensorMutableData$FUNC);

    public interface GetTensorMutableData {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetTensorMutableData fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetTensorMutableData.class, fi, OrtApi.GetTensorMutableData$FUNC, session);
        }

        static GetTensorMutableData ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorMutableData$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorMutableData$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorMutableData"));

    public static VarHandle GetTensorMutableData$VH() {
        return OrtApi.GetTensorMutableData$VH;
    }

    public static MemoryAddress GetTensorMutableData$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorMutableData$VH.get(seg);
    }

    public static void GetTensorMutableData$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorMutableData$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorMutableData$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorMutableData$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorMutableData$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorMutableData$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorMutableData GetTensorMutableData(MemorySegment segment, MemorySession session) {
        return GetTensorMutableData.ofAddress(GetTensorMutableData$get(segment), session);
    }

    static final FunctionDescriptor FillStringTensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle FillStringTensor$MH = RuntimeHelper.downcallHandle(OrtApi.FillStringTensor$FUNC);

    public interface FillStringTensor {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(FillStringTensor fi, MemorySession session) {
            return RuntimeHelper.upcallStub(FillStringTensor.class, fi, OrtApi.FillStringTensor$FUNC, session);
        }

        static FillStringTensor ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.FillStringTensor$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillStringTensor$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("FillStringTensor"));

    public static VarHandle FillStringTensor$VH() {
        return OrtApi.FillStringTensor$VH;
    }

    public static MemoryAddress FillStringTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillStringTensor$VH.get(seg);
    }

    public static void FillStringTensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillStringTensor$VH.set(seg, x);
    }

    public static MemoryAddress FillStringTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillStringTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillStringTensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillStringTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillStringTensor FillStringTensor(MemorySegment segment, MemorySession session) {
        return FillStringTensor.ofAddress(FillStringTensor$get(segment), session);
    }

    static final FunctionDescriptor GetStringTensorDataLength$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetStringTensorDataLength$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorDataLength$FUNC);

    public interface GetStringTensorDataLength {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetStringTensorDataLength fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorDataLength.class, fi, OrtApi.GetStringTensorDataLength$FUNC, session);
        }

        static GetStringTensorDataLength ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorDataLength$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorDataLength$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorDataLength"));

    public static VarHandle GetStringTensorDataLength$VH() {
        return OrtApi.GetStringTensorDataLength$VH;
    }

    public static MemoryAddress GetStringTensorDataLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorDataLength$VH.get(seg);
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorDataLength$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorDataLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorDataLength$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorDataLength$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorDataLength GetStringTensorDataLength(MemorySegment segment, MemorySession session) {
        return GetStringTensorDataLength.ofAddress(GetStringTensorDataLength$get(segment), session);
    }

    static final FunctionDescriptor GetStringTensorContent$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetStringTensorContent$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorContent$FUNC);

    public interface GetStringTensorContent {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4);

        static MemorySegment allocate(GetStringTensorContent fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorContent.class, fi, OrtApi.GetStringTensorContent$FUNC, session);
        }

        static GetStringTensorContent ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorContent$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorContent$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorContent"));

    public static VarHandle GetStringTensorContent$VH() {
        return OrtApi.GetStringTensorContent$VH;
    }

    public static MemoryAddress GetStringTensorContent$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorContent$VH.get(seg);
    }

    public static void GetStringTensorContent$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorContent$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorContent$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorContent$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorContent$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorContent$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorContent GetStringTensorContent(MemorySegment segment, MemorySession session) {
        return GetStringTensorContent.ofAddress(GetStringTensorContent$get(segment), session);
    }

    static final FunctionDescriptor CastTypeInfoToTensorInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToTensorInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToTensorInfo$FUNC);

    public interface CastTypeInfoToTensorInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CastTypeInfoToTensorInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToTensorInfo.class, fi, OrtApi.CastTypeInfoToTensorInfo$FUNC, session);
        }

        static CastTypeInfoToTensorInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToTensorInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToTensorInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CastTypeInfoToTensorInfo"));

    public static VarHandle CastTypeInfoToTensorInfo$VH() {
        return OrtApi.CastTypeInfoToTensorInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToTensorInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToTensorInfo$VH.get(seg);
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToTensorInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToTensorInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToTensorInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToTensorInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo(MemorySegment segment, MemorySession session) {
        return CastTypeInfoToTensorInfo.ofAddress(CastTypeInfoToTensorInfo$get(segment), session);
    }

    static final FunctionDescriptor GetOnnxTypeFromTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetOnnxTypeFromTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetOnnxTypeFromTypeInfo$FUNC);

    public interface GetOnnxTypeFromTypeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetOnnxTypeFromTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetOnnxTypeFromTypeInfo.class, fi, OrtApi.GetOnnxTypeFromTypeInfo$FUNC, session);
        }

        static GetOnnxTypeFromTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetOnnxTypeFromTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOnnxTypeFromTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetOnnxTypeFromTypeInfo"));

    public static VarHandle GetOnnxTypeFromTypeInfo$VH() {
        return OrtApi.GetOnnxTypeFromTypeInfo$VH;
    }

    public static MemoryAddress GetOnnxTypeFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetOnnxTypeFromTypeInfo$VH.get(seg);
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetOnnxTypeFromTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetOnnxTypeFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetOnnxTypeFromTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetOnnxTypeFromTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo(MemorySegment segment, MemorySession session) {
        return GetOnnxTypeFromTypeInfo.ofAddress(GetOnnxTypeFromTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor CreateTensorTypeAndShapeInfo$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateTensorTypeAndShapeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateTensorTypeAndShapeInfo$FUNC);

    public interface CreateTensorTypeAndShapeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateTensorTypeAndShapeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateTensorTypeAndShapeInfo.class, fi, OrtApi.CreateTensorTypeAndShapeInfo$FUNC, session);
        }

        static CreateTensorTypeAndShapeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorTypeAndShapeInfo$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorTypeAndShapeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorTypeAndShapeInfo"));

    public static VarHandle CreateTensorTypeAndShapeInfo$VH() {
        return OrtApi.CreateTensorTypeAndShapeInfo$VH;
    }

    public static MemoryAddress CreateTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorTypeAndShapeInfo$VH.get(seg);
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorTypeAndShapeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateTensorTypeAndShapeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorTypeAndShapeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorTypeAndShapeInfo CreateTensorTypeAndShapeInfo(
            MemorySegment segment, MemorySession session) {
        return CreateTensorTypeAndShapeInfo.ofAddress(CreateTensorTypeAndShapeInfo$get(segment), session);
    }

    static final FunctionDescriptor SetTensorElementType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetTensorElementType$MH = RuntimeHelper.downcallHandle(OrtApi.SetTensorElementType$FUNC);

    public interface SetTensorElementType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetTensorElementType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SetTensorElementType.class, fi, OrtApi.SetTensorElementType$FUNC, session);
        }

        static SetTensorElementType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetTensorElementType$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetTensorElementType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetTensorElementType"));

    public static VarHandle SetTensorElementType$VH() {
        return OrtApi.SetTensorElementType$VH;
    }

    public static MemoryAddress SetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetTensorElementType$VH.get(seg);
    }

    public static void SetTensorElementType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetTensorElementType$VH.set(seg, x);
    }

    public static MemoryAddress SetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetTensorElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetTensorElementType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetTensorElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetTensorElementType SetTensorElementType(MemorySegment segment, MemorySession session) {
        return SetTensorElementType.ofAddress(SetTensorElementType$get(segment), session);
    }

    static final FunctionDescriptor SetDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle SetDimensions$MH = RuntimeHelper.downcallHandle(OrtApi.SetDimensions$FUNC);

    public interface SetDimensions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(SetDimensions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SetDimensions.class, fi, OrtApi.SetDimensions$FUNC, session);
        }

        static SetDimensions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetDimensions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetDimensions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetDimensions"));

    public static VarHandle SetDimensions$VH() {
        return OrtApi.SetDimensions$VH;
    }

    public static MemoryAddress SetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetDimensions$VH.get(seg);
    }

    public static void SetDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetDimensions$VH.set(seg, x);
    }

    public static MemoryAddress SetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetDimensions SetDimensions(MemorySegment segment, MemorySession session) {
        return SetDimensions.ofAddress(SetDimensions$get(segment), session);
    }

    static final FunctionDescriptor GetTensorElementType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorElementType$MH = RuntimeHelper.downcallHandle(OrtApi.GetTensorElementType$FUNC);

    public interface GetTensorElementType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetTensorElementType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetTensorElementType.class, fi, OrtApi.GetTensorElementType$FUNC, session);
        }

        static GetTensorElementType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorElementType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorElementType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorElementType"));

    public static VarHandle GetTensorElementType$VH() {
        return OrtApi.GetTensorElementType$VH;
    }

    public static MemoryAddress GetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorElementType$VH.get(seg);
    }

    public static void GetTensorElementType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorElementType$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorElementType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorElementType GetTensorElementType(MemorySegment segment, MemorySession session) {
        return GetTensorElementType.ofAddress(GetTensorElementType$get(segment), session);
    }

    static final FunctionDescriptor GetDimensionsCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetDimensionsCount$MH = RuntimeHelper.downcallHandle(OrtApi.GetDimensionsCount$FUNC);

    public interface GetDimensionsCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetDimensionsCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetDimensionsCount.class, fi, OrtApi.GetDimensionsCount$FUNC, session);
        }

        static GetDimensionsCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetDimensionsCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDimensionsCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetDimensionsCount"));

    public static VarHandle GetDimensionsCount$VH() {
        return OrtApi.GetDimensionsCount$VH;
    }

    public static MemoryAddress GetDimensionsCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDimensionsCount$VH.get(seg);
    }

    public static void GetDimensionsCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDimensionsCount$VH.set(seg, x);
    }

    public static MemoryAddress GetDimensionsCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDimensionsCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDimensionsCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDimensionsCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDimensionsCount GetDimensionsCount(MemorySegment segment, MemorySession session) {
        return GetDimensionsCount.ofAddress(GetDimensionsCount$get(segment), session);
    }

    static final FunctionDescriptor GetDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetDimensions$MH = RuntimeHelper.downcallHandle(OrtApi.GetDimensions$FUNC);

    public interface GetDimensions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(GetDimensions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetDimensions.class, fi, OrtApi.GetDimensions$FUNC, session);
        }

        static GetDimensions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetDimensions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDimensions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetDimensions"));

    public static VarHandle GetDimensions$VH() {
        return OrtApi.GetDimensions$VH;
    }

    public static MemoryAddress GetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDimensions$VH.get(seg);
    }

    public static void GetDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDimensions$VH.set(seg, x);
    }

    public static MemoryAddress GetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDimensions GetDimensions(MemorySegment segment, MemorySession session) {
        return GetDimensions.ofAddress(GetDimensions$get(segment), session);
    }

    static final FunctionDescriptor GetSymbolicDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetSymbolicDimensions$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSymbolicDimensions$FUNC);

    public interface GetSymbolicDimensions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(GetSymbolicDimensions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSymbolicDimensions.class, fi, OrtApi.GetSymbolicDimensions$FUNC, session);
        }

        static GetSymbolicDimensions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSymbolicDimensions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSymbolicDimensions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSymbolicDimensions"));

    public static VarHandle GetSymbolicDimensions$VH() {
        return OrtApi.GetSymbolicDimensions$VH;
    }

    public static MemoryAddress GetSymbolicDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSymbolicDimensions$VH.get(seg);
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSymbolicDimensions$VH.set(seg, x);
    }

    public static MemoryAddress GetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSymbolicDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSymbolicDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSymbolicDimensions GetSymbolicDimensions(MemorySegment segment, MemorySession session) {
        return GetSymbolicDimensions.ofAddress(GetSymbolicDimensions$get(segment), session);
    }

    static final FunctionDescriptor GetTensorShapeElementCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorShapeElementCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorShapeElementCount$FUNC);

    public interface GetTensorShapeElementCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetTensorShapeElementCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetTensorShapeElementCount.class, fi, OrtApi.GetTensorShapeElementCount$FUNC, session);
        }

        static GetTensorShapeElementCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorShapeElementCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorShapeElementCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorShapeElementCount"));

    public static VarHandle GetTensorShapeElementCount$VH() {
        return OrtApi.GetTensorShapeElementCount$VH;
    }

    public static MemoryAddress GetTensorShapeElementCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorShapeElementCount$VH.get(seg);
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorShapeElementCount$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorShapeElementCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetTensorShapeElementCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorShapeElementCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorShapeElementCount GetTensorShapeElementCount(MemorySegment segment, MemorySession session) {
        return GetTensorShapeElementCount.ofAddress(GetTensorShapeElementCount$get(segment), session);
    }

    static final FunctionDescriptor GetTensorTypeAndShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorTypeAndShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorTypeAndShape$FUNC);

    public interface GetTensorTypeAndShape {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetTensorTypeAndShape fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetTensorTypeAndShape.class, fi, OrtApi.GetTensorTypeAndShape$FUNC, session);
        }

        static GetTensorTypeAndShape ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorTypeAndShape$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorTypeAndShape$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorTypeAndShape"));

    public static VarHandle GetTensorTypeAndShape$VH() {
        return OrtApi.GetTensorTypeAndShape$VH;
    }

    public static MemoryAddress GetTensorTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorTypeAndShape$VH.get(seg);
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorTypeAndShape$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorTypeAndShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorTypeAndShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorTypeAndShape GetTensorTypeAndShape(MemorySegment segment, MemorySession session) {
        return GetTensorTypeAndShape.ofAddress(GetTensorTypeAndShape$get(segment), session);
    }

    static final FunctionDescriptor GetTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTypeInfo$MH = RuntimeHelper.downcallHandle(OrtApi.GetTypeInfo$FUNC);

    public interface GetTypeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetTypeInfo.class, fi, OrtApi.GetTypeInfo$FUNC, session);
        }

        static GetTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTypeInfo"));

    public static VarHandle GetTypeInfo$VH() {
        return OrtApi.GetTypeInfo$VH;
    }

    public static MemoryAddress GetTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTypeInfo$VH.get(seg);
    }

    public static void GetTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTypeInfo GetTypeInfo(MemorySegment segment, MemorySession session) {
        return GetTypeInfo.ofAddress(GetTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor GetValueType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetValueType$MH = RuntimeHelper.downcallHandle(OrtApi.GetValueType$FUNC);

    public interface GetValueType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetValueType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetValueType.class, fi, OrtApi.GetValueType$FUNC, session);
        }

        static GetValueType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetValueType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetValueType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetValueType"));

    public static VarHandle GetValueType$VH() {
        return OrtApi.GetValueType$VH;
    }

    public static MemoryAddress GetValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetValueType$VH.get(seg);
    }

    public static void GetValueType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetValueType$VH.set(seg, x);
    }

    public static MemoryAddress GetValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetValueType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValueType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetValueType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValueType GetValueType(MemorySegment segment, MemorySession session) {
        return GetValueType.ofAddress(GetValueType$get(segment), session);
    }

    static final FunctionDescriptor CreateMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CreateMemoryInfo$FUNC);

    public interface CreateMemoryInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateMemoryInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateMemoryInfo.class, fi, OrtApi.CreateMemoryInfo$FUNC, session);
        }

        static CreateMemoryInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    int __x1,
                    int __x2,
                    int __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateMemoryInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateMemoryInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateMemoryInfo"));

    public static VarHandle CreateMemoryInfo$VH() {
        return OrtApi.CreateMemoryInfo$VH;
    }

    public static MemoryAddress CreateMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateMemoryInfo$VH.get(seg);
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress CreateMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateMemoryInfo CreateMemoryInfo(MemorySegment segment, MemorySession session) {
        return CreateMemoryInfo.ofAddress(CreateMemoryInfo$get(segment), session);
    }

    static final FunctionDescriptor CreateCpuMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCpuMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CreateCpuMemoryInfo$FUNC);

    public interface CreateCpuMemoryInfo {

        java.lang.foreign.Addressable apply(int _x0, int _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(CreateCpuMemoryInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateCpuMemoryInfo.class, fi, OrtApi.CreateCpuMemoryInfo$FUNC, session);
        }

        static CreateCpuMemoryInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0, int __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateCpuMemoryInfo$MH.invokeExact(
                                    (Addressable) symbol, __x0, __x1, (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateCpuMemoryInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateCpuMemoryInfo"));

    public static VarHandle CreateCpuMemoryInfo$VH() {
        return OrtApi.CreateCpuMemoryInfo$VH;
    }

    public static MemoryAddress CreateCpuMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCpuMemoryInfo$VH.get(seg);
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateCpuMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress CreateCpuMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCpuMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateCpuMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCpuMemoryInfo CreateCpuMemoryInfo(MemorySegment segment, MemorySession session) {
        return CreateCpuMemoryInfo.ofAddress(CreateCpuMemoryInfo$get(segment), session);
    }

    static final FunctionDescriptor CompareMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CompareMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CompareMemoryInfo$FUNC);

    public interface CompareMemoryInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(CompareMemoryInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CompareMemoryInfo.class, fi, OrtApi.CompareMemoryInfo$FUNC, session);
        }

        static CompareMemoryInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CompareMemoryInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CompareMemoryInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CompareMemoryInfo"));

    public static VarHandle CompareMemoryInfo$VH() {
        return OrtApi.CompareMemoryInfo$VH;
    }

    public static MemoryAddress CompareMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CompareMemoryInfo$VH.get(seg);
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CompareMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress CompareMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CompareMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CompareMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CompareMemoryInfo CompareMemoryInfo(MemorySegment segment, MemorySession session) {
        return CompareMemoryInfo.ofAddress(CompareMemoryInfo$get(segment), session);
    }

    static final FunctionDescriptor MemoryInfoGetName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetName$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetName$FUNC);

    public interface MemoryInfoGetName {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(MemoryInfoGetName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(MemoryInfoGetName.class, fi, OrtApi.MemoryInfoGetName$FUNC, session);
        }

        static MemoryInfoGetName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("MemoryInfoGetName"));

    public static VarHandle MemoryInfoGetName$VH() {
        return OrtApi.MemoryInfoGetName$VH;
    }

    public static MemoryAddress MemoryInfoGetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetName$VH.get(seg);
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetName$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetName MemoryInfoGetName(MemorySegment segment, MemorySession session) {
        return MemoryInfoGetName.ofAddress(MemoryInfoGetName$get(segment), session);
    }

    static final FunctionDescriptor MemoryInfoGetId$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetId$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetId$FUNC);

    public interface MemoryInfoGetId {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(MemoryInfoGetId fi, MemorySession session) {
            return RuntimeHelper.upcallStub(MemoryInfoGetId.class, fi, OrtApi.MemoryInfoGetId$FUNC, session);
        }

        static MemoryInfoGetId ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetId$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetId$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("MemoryInfoGetId"));

    public static VarHandle MemoryInfoGetId$VH() {
        return OrtApi.MemoryInfoGetId$VH;
    }

    public static MemoryAddress MemoryInfoGetId$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetId$VH.get(seg);
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetId$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetId MemoryInfoGetId(MemorySegment segment, MemorySession session) {
        return MemoryInfoGetId.ofAddress(MemoryInfoGetId$get(segment), session);
    }

    static final FunctionDescriptor MemoryInfoGetMemType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetMemType$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetMemType$FUNC);

    public interface MemoryInfoGetMemType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(MemoryInfoGetMemType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(MemoryInfoGetMemType.class, fi, OrtApi.MemoryInfoGetMemType$FUNC, session);
        }

        static MemoryInfoGetMemType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetMemType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetMemType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("MemoryInfoGetMemType"));

    public static VarHandle MemoryInfoGetMemType$VH() {
        return OrtApi.MemoryInfoGetMemType$VH;
    }

    public static MemoryAddress MemoryInfoGetMemType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetMemType$VH.get(seg);
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetMemType$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetMemType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetMemType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetMemType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetMemType MemoryInfoGetMemType(MemorySegment segment, MemorySession session) {
        return MemoryInfoGetMemType.ofAddress(MemoryInfoGetMemType$get(segment), session);
    }

    static final FunctionDescriptor MemoryInfoGetType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetType$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetType$FUNC);

    public interface MemoryInfoGetType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(MemoryInfoGetType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(MemoryInfoGetType.class, fi, OrtApi.MemoryInfoGetType$FUNC, session);
        }

        static MemoryInfoGetType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("MemoryInfoGetType"));

    public static VarHandle MemoryInfoGetType$VH() {
        return OrtApi.MemoryInfoGetType$VH;
    }

    public static MemoryAddress MemoryInfoGetType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetType$VH.get(seg);
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetType$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetType MemoryInfoGetType(MemorySegment segment, MemorySession session) {
        return MemoryInfoGetType.ofAddress(MemoryInfoGetType$get(segment), session);
    }

    static final FunctionDescriptor AllocatorAlloc$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AllocatorAlloc$MH = RuntimeHelper.downcallHandle(OrtApi.AllocatorAlloc$FUNC);

    public interface AllocatorAlloc {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(AllocatorAlloc fi, MemorySession session) {
            return RuntimeHelper.upcallStub(AllocatorAlloc.class, fi, OrtApi.AllocatorAlloc$FUNC, session);
        }

        static AllocatorAlloc ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AllocatorAlloc$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AllocatorAlloc$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AllocatorAlloc"));

    public static VarHandle AllocatorAlloc$VH() {
        return OrtApi.AllocatorAlloc$VH;
    }

    public static MemoryAddress AllocatorAlloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AllocatorAlloc$VH.get(seg);
    }

    public static void AllocatorAlloc$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AllocatorAlloc$VH.set(seg, x);
    }

    public static MemoryAddress AllocatorAlloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AllocatorAlloc$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorAlloc$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AllocatorAlloc$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorAlloc AllocatorAlloc(MemorySegment segment, MemorySession session) {
        return AllocatorAlloc.ofAddress(AllocatorAlloc$get(segment), session);
    }

    static final FunctionDescriptor AllocatorFree$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AllocatorFree$MH = RuntimeHelper.downcallHandle(OrtApi.AllocatorFree$FUNC);

    public interface AllocatorFree {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(AllocatorFree fi, MemorySession session) {
            return RuntimeHelper.upcallStub(AllocatorFree.class, fi, OrtApi.AllocatorFree$FUNC, session);
        }

        static AllocatorFree ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AllocatorFree$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AllocatorFree$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AllocatorFree"));

    public static VarHandle AllocatorFree$VH() {
        return OrtApi.AllocatorFree$VH;
    }

    public static MemoryAddress AllocatorFree$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AllocatorFree$VH.get(seg);
    }

    public static void AllocatorFree$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AllocatorFree$VH.set(seg, x);
    }

    public static MemoryAddress AllocatorFree$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AllocatorFree$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorFree$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AllocatorFree$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorFree AllocatorFree(MemorySegment segment, MemorySession session) {
        return AllocatorFree.ofAddress(AllocatorFree$get(segment), session);
    }

    static final FunctionDescriptor AllocatorGetInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AllocatorGetInfo$MH = RuntimeHelper.downcallHandle(OrtApi.AllocatorGetInfo$FUNC);

    public interface AllocatorGetInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(AllocatorGetInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(AllocatorGetInfo.class, fi, OrtApi.AllocatorGetInfo$FUNC, session);
        }

        static AllocatorGetInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AllocatorGetInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AllocatorGetInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AllocatorGetInfo"));

    public static VarHandle AllocatorGetInfo$VH() {
        return OrtApi.AllocatorGetInfo$VH;
    }

    public static MemoryAddress AllocatorGetInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AllocatorGetInfo$VH.get(seg);
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AllocatorGetInfo$VH.set(seg, x);
    }

    public static MemoryAddress AllocatorGetInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AllocatorGetInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AllocatorGetInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorGetInfo AllocatorGetInfo(MemorySegment segment, MemorySession session) {
        return AllocatorGetInfo.ofAddress(AllocatorGetInfo$get(segment), session);
    }

    static final FunctionDescriptor GetAllocatorWithDefaultOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetAllocatorWithDefaultOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetAllocatorWithDefaultOptions$FUNC);

    public interface GetAllocatorWithDefaultOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetAllocatorWithDefaultOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetAllocatorWithDefaultOptions.class, fi, OrtApi.GetAllocatorWithDefaultOptions$FUNC, session);
        }

        static GetAllocatorWithDefaultOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetAllocatorWithDefaultOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetAllocatorWithDefaultOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetAllocatorWithDefaultOptions"));

    public static VarHandle GetAllocatorWithDefaultOptions$VH() {
        return OrtApi.GetAllocatorWithDefaultOptions$VH;
    }

    public static MemoryAddress GetAllocatorWithDefaultOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetAllocatorWithDefaultOptions$VH.get(seg);
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetAllocatorWithDefaultOptions$VH.set(seg, x);
    }

    public static MemoryAddress GetAllocatorWithDefaultOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetAllocatorWithDefaultOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetAllocatorWithDefaultOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions(
            MemorySegment segment, MemorySession session) {
        return GetAllocatorWithDefaultOptions.ofAddress(GetAllocatorWithDefaultOptions$get(segment), session);
    }

    static final FunctionDescriptor AddFreeDimensionOverride$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle AddFreeDimensionOverride$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddFreeDimensionOverride$FUNC);

    public interface AddFreeDimensionOverride {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverride fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverride.class, fi, OrtApi.AddFreeDimensionOverride$FUNC, session);
        }

        static AddFreeDimensionOverride ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverride$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddFreeDimensionOverride$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddFreeDimensionOverride"));

    public static VarHandle AddFreeDimensionOverride$VH() {
        return OrtApi.AddFreeDimensionOverride$VH;
    }

    public static MemoryAddress AddFreeDimensionOverride$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverride$VH.get(seg);
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverride$VH.set(seg, x);
    }

    public static MemoryAddress AddFreeDimensionOverride$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverride$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverride$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddFreeDimensionOverride AddFreeDimensionOverride(MemorySegment segment, MemorySession session) {
        return AddFreeDimensionOverride.ofAddress(AddFreeDimensionOverride$get(segment), session);
    }

    static final FunctionDescriptor GetValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetValue$MH = RuntimeHelper.downcallHandle(OrtApi.GetValue$FUNC);

    public interface GetValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                int _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(GetValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetValue.class, fi, OrtApi.GetValue$FUNC, session);
        }

        static GetValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    int __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetValue$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetValue"));

    public static VarHandle GetValue$VH() {
        return OrtApi.GetValue$VH;
    }

    public static MemoryAddress GetValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetValue$VH.get(seg);
    }

    public static void GetValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetValue$VH.set(seg, x);
    }

    public static MemoryAddress GetValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValue GetValue(MemorySegment segment, MemorySession session) {
        return GetValue.ofAddress(GetValue$get(segment), session);
    }

    static final FunctionDescriptor GetValueCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetValueCount$MH = RuntimeHelper.downcallHandle(OrtApi.GetValueCount$FUNC);

    public interface GetValueCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetValueCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetValueCount.class, fi, OrtApi.GetValueCount$FUNC, session);
        }

        static GetValueCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetValueCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetValueCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetValueCount"));

    public static VarHandle GetValueCount$VH() {
        return OrtApi.GetValueCount$VH;
    }

    public static MemoryAddress GetValueCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetValueCount$VH.get(seg);
    }

    public static void GetValueCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetValueCount$VH.set(seg, x);
    }

    public static MemoryAddress GetValueCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetValueCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValueCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetValueCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValueCount GetValueCount(MemorySegment segment, MemorySession session) {
        return GetValueCount.ofAddress(GetValueCount$get(segment), session);
    }

    static final FunctionDescriptor CreateValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateValue$MH = RuntimeHelper.downcallHandle(OrtApi.CreateValue$FUNC);

    public interface CreateValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, int _x2, java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(CreateValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateValue.class, fi, OrtApi.CreateValue$FUNC, session);
        }

        static CreateValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    int __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateValue"));

    public static VarHandle CreateValue$VH() {
        return OrtApi.CreateValue$VH;
    }

    public static MemoryAddress CreateValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateValue$VH.get(seg);
    }

    public static void CreateValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateValue CreateValue(MemorySegment segment, MemorySession session) {
        return CreateValue.ofAddress(CreateValue$get(segment), session);
    }

    static final FunctionDescriptor CreateOpaqueValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateOpaqueValue$MH = RuntimeHelper.downcallHandle(OrtApi.CreateOpaqueValue$FUNC);

    public interface CreateOpaqueValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateOpaqueValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateOpaqueValue.class, fi, OrtApi.CreateOpaqueValue$FUNC, session);
        }

        static CreateOpaqueValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateOpaqueValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateOpaqueValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateOpaqueValue"));

    public static VarHandle CreateOpaqueValue$VH() {
        return OrtApi.CreateOpaqueValue$VH;
    }

    public static MemoryAddress CreateOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateOpaqueValue$VH.get(seg);
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateOpaqueValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateOpaqueValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateOpaqueValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOpaqueValue CreateOpaqueValue(MemorySegment segment, MemorySession session) {
        return CreateOpaqueValue.ofAddress(CreateOpaqueValue$get(segment), session);
    }

    static final FunctionDescriptor GetOpaqueValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetOpaqueValue$MH = RuntimeHelper.downcallHandle(OrtApi.GetOpaqueValue$FUNC);

    public interface GetOpaqueValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4);

        static MemorySegment allocate(GetOpaqueValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetOpaqueValue.class, fi, OrtApi.GetOpaqueValue$FUNC, session);
        }

        static GetOpaqueValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetOpaqueValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOpaqueValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetOpaqueValue"));

    public static VarHandle GetOpaqueValue$VH() {
        return OrtApi.GetOpaqueValue$VH;
    }

    public static MemoryAddress GetOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetOpaqueValue$VH.get(seg);
    }

    public static void GetOpaqueValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetOpaqueValue$VH.set(seg, x);
    }

    public static MemoryAddress GetOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetOpaqueValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOpaqueValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetOpaqueValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOpaqueValue GetOpaqueValue(MemorySegment segment, MemorySession session) {
        return GetOpaqueValue.ofAddress(GetOpaqueValue$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_float$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_float$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_float$FUNC);

    public interface KernelInfoGetAttribute_float {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelInfoGetAttribute_float fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_float.class, fi, OrtApi.KernelInfoGetAttribute_float$FUNC, session);
        }

        static KernelInfoGetAttribute_float ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_float$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_float$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_float"));

    public static VarHandle KernelInfoGetAttribute_float$VH() {
        return OrtApi.KernelInfoGetAttribute_float$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_float$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_float$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_float$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_float$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_float KernelInfoGetAttribute_float(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetAttribute_float.ofAddress(KernelInfoGetAttribute_float$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_int64$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_int64$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_int64$FUNC);

    public interface KernelInfoGetAttribute_int64 {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelInfoGetAttribute_int64 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_int64.class, fi, OrtApi.KernelInfoGetAttribute_int64$FUNC, session);
        }

        static KernelInfoGetAttribute_int64 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_int64$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_int64$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_int64"));

    public static VarHandle KernelInfoGetAttribute_int64$VH() {
        return OrtApi.KernelInfoGetAttribute_int64$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_int64$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_int64$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_int64$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_int64$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_int64 KernelInfoGetAttribute_int64(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetAttribute_int64.ofAddress(KernelInfoGetAttribute_int64$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_string$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_string$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_string$FUNC);

    public interface KernelInfoGetAttribute_string {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfoGetAttribute_string fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_string.class, fi, OrtApi.KernelInfoGetAttribute_string$FUNC, session);
        }

        static KernelInfoGetAttribute_string ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_string$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_string$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_string"));

    public static VarHandle KernelInfoGetAttribute_string$VH() {
        return OrtApi.KernelInfoGetAttribute_string$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_string$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_string$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_string$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_string$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_string$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_string$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_string KernelInfoGetAttribute_string(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetAttribute_string.ofAddress(KernelInfoGetAttribute_string$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetInputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetInputCount$FUNC);

    public interface KernelContext_GetInputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelContext_GetInputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInputCount.class, fi, OrtApi.KernelContext_GetInputCount$FUNC, session);
        }

        static KernelContext_GetInputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetInputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetInputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetInputCount"));

    public static VarHandle KernelContext_GetInputCount$VH() {
        return OrtApi.KernelContext_GetInputCount$VH;
    }

    public static MemoryAddress KernelContext_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetInputCount$VH.get(seg);
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetInputCount$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelContext_GetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetInputCount KernelContext_GetInputCount(
            MemorySegment segment, MemorySession session) {
        return KernelContext_GetInputCount.ofAddress(KernelContext_GetInputCount$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetOutputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetOutputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetOutputCount$FUNC);

    public interface KernelContext_GetOutputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelContext_GetOutputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutputCount.class, fi, OrtApi.KernelContext_GetOutputCount$FUNC, session);
        }

        static KernelContext_GetOutputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetOutputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetOutputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetOutputCount"));

    public static VarHandle KernelContext_GetOutputCount$VH() {
        return OrtApi.KernelContext_GetOutputCount$VH;
    }

    public static MemoryAddress KernelContext_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetOutputCount$VH.get(seg);
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetOutputCount$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelContext_GetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetOutputCount KernelContext_GetOutputCount(
            MemorySegment segment, MemorySession session) {
        return KernelContext_GetOutputCount.ofAddress(KernelContext_GetOutputCount$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetInput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetInput$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetInput$FUNC);

    public interface KernelContext_GetInput {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelContext_GetInput fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInput.class, fi, OrtApi.KernelContext_GetInput$FUNC, session);
        }

        static KernelContext_GetInput ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetInput$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetInput$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetInput"));

    public static VarHandle KernelContext_GetInput$VH() {
        return OrtApi.KernelContext_GetInput$VH;
    }

    public static MemoryAddress KernelContext_GetInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetInput$VH.get(seg);
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetInput$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetInput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetInput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetInput KernelContext_GetInput(MemorySegment segment, MemorySession session) {
        return KernelContext_GetInput.ofAddress(KernelContext_GetInput$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetOutput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetOutput$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetOutput$FUNC);

    public interface KernelContext_GetOutput {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(KernelContext_GetOutput fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutput.class, fi, OrtApi.KernelContext_GetOutput$FUNC, session);
        }

        static KernelContext_GetOutput ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetOutput$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetOutput$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetOutput"));

    public static VarHandle KernelContext_GetOutput$VH() {
        return OrtApi.KernelContext_GetOutput$VH;
    }

    public static MemoryAddress KernelContext_GetOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetOutput$VH.get(seg);
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetOutput$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetOutput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetOutput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetOutput KernelContext_GetOutput(MemorySegment segment, MemorySession session) {
        return KernelContext_GetOutput.ofAddress(KernelContext_GetOutput$get(segment), session);
    }

    static final FunctionDescriptor ReleaseEnv$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseEnv$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseEnv$FUNC);

    public interface ReleaseEnv {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseEnv fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseEnv.class, fi, OrtApi.ReleaseEnv$FUNC, session);
        }

        static ReleaseEnv ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseEnv$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseEnv$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseEnv"));

    public static VarHandle ReleaseEnv$VH() {
        return OrtApi.ReleaseEnv$VH;
    }

    public static MemoryAddress ReleaseEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseEnv$VH.get(seg);
    }

    public static void ReleaseEnv$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseEnv$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseEnv$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseEnv$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseEnv$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseEnv ReleaseEnv(MemorySegment segment, MemorySession session) {
        return ReleaseEnv.ofAddress(ReleaseEnv$get(segment), session);
    }

    static final FunctionDescriptor ReleaseStatus$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseStatus$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseStatus$FUNC);

    public interface ReleaseStatus {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseStatus fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseStatus.class, fi, OrtApi.ReleaseStatus$FUNC, session);
        }

        static ReleaseStatus ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseStatus$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseStatus$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseStatus"));

    public static VarHandle ReleaseStatus$VH() {
        return OrtApi.ReleaseStatus$VH;
    }

    public static MemoryAddress ReleaseStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseStatus$VH.get(seg);
    }

    public static void ReleaseStatus$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseStatus$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseStatus$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseStatus$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseStatus$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseStatus ReleaseStatus(MemorySegment segment, MemorySession session) {
        return ReleaseStatus.ofAddress(ReleaseStatus$get(segment), session);
    }

    static final FunctionDescriptor ReleaseMemoryInfo$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseMemoryInfo$FUNC);

    public interface ReleaseMemoryInfo {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseMemoryInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseMemoryInfo.class, fi, OrtApi.ReleaseMemoryInfo$FUNC, session);
        }

        static ReleaseMemoryInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseMemoryInfo$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseMemoryInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseMemoryInfo"));

    public static VarHandle ReleaseMemoryInfo$VH() {
        return OrtApi.ReleaseMemoryInfo$VH;
    }

    public static MemoryAddress ReleaseMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseMemoryInfo$VH.get(seg);
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseMemoryInfo ReleaseMemoryInfo(MemorySegment segment, MemorySession session) {
        return ReleaseMemoryInfo.ofAddress(ReleaseMemoryInfo$get(segment), session);
    }

    static final FunctionDescriptor ReleaseSession$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseSession$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseSession$FUNC);

    public interface ReleaseSession {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseSession fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseSession.class, fi, OrtApi.ReleaseSession$FUNC, session);
        }

        static ReleaseSession ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseSession$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseSession$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseSession"));

    public static VarHandle ReleaseSession$VH() {
        return OrtApi.ReleaseSession$VH;
    }

    public static MemoryAddress ReleaseSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseSession$VH.get(seg);
    }

    public static void ReleaseSession$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseSession$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseSession$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSession$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseSession$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSession ReleaseSession(MemorySegment segment, MemorySession session) {
        return ReleaseSession.ofAddress(ReleaseSession$get(segment), session);
    }

    static final FunctionDescriptor ReleaseValue$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseValue$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseValue$FUNC);

    public interface ReleaseValue {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseValue.class, fi, OrtApi.ReleaseValue$FUNC, session);
        }

        static ReleaseValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseValue$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseValue"));

    public static VarHandle ReleaseValue$VH() {
        return OrtApi.ReleaseValue$VH;
    }

    public static MemoryAddress ReleaseValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseValue$VH.get(seg);
    }

    public static void ReleaseValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseValue$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseValue ReleaseValue(MemorySegment segment, MemorySession session) {
        return ReleaseValue.ofAddress(ReleaseValue$get(segment), session);
    }

    static final FunctionDescriptor ReleaseRunOptions$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseRunOptions$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseRunOptions$FUNC);

    public interface ReleaseRunOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseRunOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseRunOptions.class, fi, OrtApi.ReleaseRunOptions$FUNC, session);
        }

        static ReleaseRunOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseRunOptions$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseRunOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseRunOptions"));

    public static VarHandle ReleaseRunOptions$VH() {
        return OrtApi.ReleaseRunOptions$VH;
    }

    public static MemoryAddress ReleaseRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseRunOptions$VH.get(seg);
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseRunOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseRunOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseRunOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseRunOptions ReleaseRunOptions(MemorySegment segment, MemorySession session) {
        return ReleaseRunOptions.ofAddress(ReleaseRunOptions$get(segment), session);
    }

    static final FunctionDescriptor ReleaseTypeInfo$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseTypeInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseTypeInfo$FUNC);

    public interface ReleaseTypeInfo {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseTypeInfo.class, fi, OrtApi.ReleaseTypeInfo$FUNC, session);
        }

        static ReleaseTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseTypeInfo$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseTypeInfo"));

    public static VarHandle ReleaseTypeInfo$VH() {
        return OrtApi.ReleaseTypeInfo$VH;
    }

    public static MemoryAddress ReleaseTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseTypeInfo$VH.get(seg);
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTypeInfo ReleaseTypeInfo(MemorySegment segment, MemorySession session) {
        return ReleaseTypeInfo.ofAddress(ReleaseTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor ReleaseTensorTypeAndShapeInfo$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseTensorTypeAndShapeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC);

    public interface ReleaseTensorTypeAndShapeInfo {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseTensorTypeAndShapeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorTypeAndShapeInfo.class, fi, OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC, session);
        }

        static ReleaseTensorTypeAndShapeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseTensorTypeAndShapeInfo$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseTensorTypeAndShapeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseTensorTypeAndShapeInfo"));

    public static VarHandle ReleaseTensorTypeAndShapeInfo$VH() {
        return OrtApi.ReleaseTensorTypeAndShapeInfo$VH;
    }

    public static MemoryAddress ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseTensorTypeAndShapeInfo$VH.get(seg);
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseTensorTypeAndShapeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleaseTensorTypeAndShapeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseTensorTypeAndShapeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo(
            MemorySegment segment, MemorySession session) {
        return ReleaseTensorTypeAndShapeInfo.ofAddress(ReleaseTensorTypeAndShapeInfo$get(segment), session);
    }

    static final FunctionDescriptor ReleaseSessionOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseSessionOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseSessionOptions$FUNC);

    public interface ReleaseSessionOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseSessionOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseSessionOptions.class, fi, OrtApi.ReleaseSessionOptions$FUNC, session);
        }

        static ReleaseSessionOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseSessionOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseSessionOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseSessionOptions"));

    public static VarHandle ReleaseSessionOptions$VH() {
        return OrtApi.ReleaseSessionOptions$VH;
    }

    public static MemoryAddress ReleaseSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseSessionOptions$VH.get(seg);
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseSessionOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSessionOptions ReleaseSessionOptions(MemorySegment segment, MemorySession session) {
        return ReleaseSessionOptions.ofAddress(ReleaseSessionOptions$get(segment), session);
    }

    static final FunctionDescriptor ReleaseCustomOpDomain$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseCustomOpDomain$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseCustomOpDomain$FUNC);

    public interface ReleaseCustomOpDomain {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseCustomOpDomain fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseCustomOpDomain.class, fi, OrtApi.ReleaseCustomOpDomain$FUNC, session);
        }

        static ReleaseCustomOpDomain ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseCustomOpDomain$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseCustomOpDomain$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseCustomOpDomain"));

    public static VarHandle ReleaseCustomOpDomain$VH() {
        return OrtApi.ReleaseCustomOpDomain$VH;
    }

    public static MemoryAddress ReleaseCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseCustomOpDomain$VH.get(seg);
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseCustomOpDomain$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCustomOpDomain ReleaseCustomOpDomain(MemorySegment segment, MemorySession session) {
        return ReleaseCustomOpDomain.ofAddress(ReleaseCustomOpDomain$get(segment), session);
    }

    static final FunctionDescriptor GetDenotationFromTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetDenotationFromTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetDenotationFromTypeInfo$FUNC);

    public interface GetDenotationFromTypeInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetDenotationFromTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetDenotationFromTypeInfo.class, fi, OrtApi.GetDenotationFromTypeInfo$FUNC, session);
        }

        static GetDenotationFromTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetDenotationFromTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDenotationFromTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetDenotationFromTypeInfo"));

    public static VarHandle GetDenotationFromTypeInfo$VH() {
        return OrtApi.GetDenotationFromTypeInfo$VH;
    }

    public static MemoryAddress GetDenotationFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDenotationFromTypeInfo$VH.get(seg);
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDenotationFromTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetDenotationFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDenotationFromTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDenotationFromTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDenotationFromTypeInfo GetDenotationFromTypeInfo(MemorySegment segment, MemorySession session) {
        return GetDenotationFromTypeInfo.ofAddress(GetDenotationFromTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor CastTypeInfoToMapTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToMapTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToMapTypeInfo$FUNC);

    public interface CastTypeInfoToMapTypeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CastTypeInfoToMapTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToMapTypeInfo.class, fi, OrtApi.CastTypeInfoToMapTypeInfo$FUNC, session);
        }

        static CastTypeInfoToMapTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToMapTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToMapTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CastTypeInfoToMapTypeInfo"));

    public static VarHandle CastTypeInfoToMapTypeInfo$VH() {
        return OrtApi.CastTypeInfoToMapTypeInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToMapTypeInfo$VH.get(seg);
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToMapTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToMapTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToMapTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo(MemorySegment segment, MemorySession session) {
        return CastTypeInfoToMapTypeInfo.ofAddress(CastTypeInfoToMapTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor CastTypeInfoToSequenceTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToSequenceTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC);

    public interface CastTypeInfoToSequenceTypeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CastTypeInfoToSequenceTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToSequenceTypeInfo.class, fi, OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC, session);
        }

        static CastTypeInfoToSequenceTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToSequenceTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToSequenceTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CastTypeInfoToSequenceTypeInfo"));

    public static VarHandle CastTypeInfoToSequenceTypeInfo$VH() {
        return OrtApi.CastTypeInfoToSequenceTypeInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToSequenceTypeInfo$VH.get(seg);
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToSequenceTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CastTypeInfoToSequenceTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToSequenceTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo(
            MemorySegment segment, MemorySession session) {
        return CastTypeInfoToSequenceTypeInfo.ofAddress(CastTypeInfoToSequenceTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor GetMapKeyType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetMapKeyType$MH = RuntimeHelper.downcallHandle(OrtApi.GetMapKeyType$FUNC);

    public interface GetMapKeyType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetMapKeyType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetMapKeyType.class, fi, OrtApi.GetMapKeyType$FUNC, session);
        }

        static GetMapKeyType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetMapKeyType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetMapKeyType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetMapKeyType"));

    public static VarHandle GetMapKeyType$VH() {
        return OrtApi.GetMapKeyType$VH;
    }

    public static MemoryAddress GetMapKeyType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetMapKeyType$VH.get(seg);
    }

    public static void GetMapKeyType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetMapKeyType$VH.set(seg, x);
    }

    public static MemoryAddress GetMapKeyType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetMapKeyType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetMapKeyType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetMapKeyType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetMapKeyType GetMapKeyType(MemorySegment segment, MemorySession session) {
        return GetMapKeyType.ofAddress(GetMapKeyType$get(segment), session);
    }

    static final FunctionDescriptor GetMapValueType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetMapValueType$MH = RuntimeHelper.downcallHandle(OrtApi.GetMapValueType$FUNC);

    public interface GetMapValueType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetMapValueType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetMapValueType.class, fi, OrtApi.GetMapValueType$FUNC, session);
        }

        static GetMapValueType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetMapValueType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetMapValueType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetMapValueType"));

    public static VarHandle GetMapValueType$VH() {
        return OrtApi.GetMapValueType$VH;
    }

    public static MemoryAddress GetMapValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetMapValueType$VH.get(seg);
    }

    public static void GetMapValueType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetMapValueType$VH.set(seg, x);
    }

    public static MemoryAddress GetMapValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetMapValueType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetMapValueType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetMapValueType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetMapValueType GetMapValueType(MemorySegment segment, MemorySession session) {
        return GetMapValueType.ofAddress(GetMapValueType$get(segment), session);
    }

    static final FunctionDescriptor GetSequenceElementType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSequenceElementType$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSequenceElementType$FUNC);

    public interface GetSequenceElementType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetSequenceElementType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSequenceElementType.class, fi, OrtApi.GetSequenceElementType$FUNC, session);
        }

        static GetSequenceElementType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSequenceElementType$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSequenceElementType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSequenceElementType"));

    public static VarHandle GetSequenceElementType$VH() {
        return OrtApi.GetSequenceElementType$VH;
    }

    public static MemoryAddress GetSequenceElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSequenceElementType$VH.get(seg);
    }

    public static void GetSequenceElementType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSequenceElementType$VH.set(seg, x);
    }

    public static MemoryAddress GetSequenceElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSequenceElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSequenceElementType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSequenceElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSequenceElementType GetSequenceElementType(MemorySegment segment, MemorySession session) {
        return GetSequenceElementType.ofAddress(GetSequenceElementType$get(segment), session);
    }

    static final FunctionDescriptor ReleaseMapTypeInfo$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseMapTypeInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseMapTypeInfo$FUNC);

    public interface ReleaseMapTypeInfo {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseMapTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseMapTypeInfo.class, fi, OrtApi.ReleaseMapTypeInfo$FUNC, session);
        }

        static ReleaseMapTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseMapTypeInfo$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseMapTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseMapTypeInfo"));

    public static VarHandle ReleaseMapTypeInfo$VH() {
        return OrtApi.ReleaseMapTypeInfo$VH;
    }

    public static MemoryAddress ReleaseMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseMapTypeInfo$VH.get(seg);
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseMapTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseMapTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseMapTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseMapTypeInfo ReleaseMapTypeInfo(MemorySegment segment, MemorySession session) {
        return ReleaseMapTypeInfo.ofAddress(ReleaseMapTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor ReleaseSequenceTypeInfo$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseSequenceTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseSequenceTypeInfo$FUNC);

    public interface ReleaseSequenceTypeInfo {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseSequenceTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseSequenceTypeInfo.class, fi, OrtApi.ReleaseSequenceTypeInfo$FUNC, session);
        }

        static ReleaseSequenceTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseSequenceTypeInfo$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseSequenceTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseSequenceTypeInfo"));

    public static VarHandle ReleaseSequenceTypeInfo$VH() {
        return OrtApi.ReleaseSequenceTypeInfo$VH;
    }

    public static MemoryAddress ReleaseSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseSequenceTypeInfo$VH.get(seg);
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseSequenceTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseSequenceTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseSequenceTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSequenceTypeInfo ReleaseSequenceTypeInfo(MemorySegment segment, MemorySession session) {
        return ReleaseSequenceTypeInfo.ofAddress(ReleaseSequenceTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor SessionEndProfiling$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionEndProfiling$MH = RuntimeHelper.downcallHandle(OrtApi.SessionEndProfiling$FUNC);

    public interface SessionEndProfiling {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(SessionEndProfiling fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SessionEndProfiling.class, fi, OrtApi.SessionEndProfiling$FUNC, session);
        }

        static SessionEndProfiling ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionEndProfiling$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionEndProfiling$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionEndProfiling"));

    public static VarHandle SessionEndProfiling$VH() {
        return OrtApi.SessionEndProfiling$VH;
    }

    public static MemoryAddress SessionEndProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionEndProfiling$VH.get(seg);
    }

    public static void SessionEndProfiling$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionEndProfiling$VH.set(seg, x);
    }

    public static MemoryAddress SessionEndProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionEndProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionEndProfiling$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionEndProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionEndProfiling SessionEndProfiling(MemorySegment segment, MemorySession session) {
        return SessionEndProfiling.ofAddress(SessionEndProfiling$get(segment), session);
    }

    static final FunctionDescriptor SessionGetModelMetadata$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetModelMetadata$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetModelMetadata$FUNC);

    public interface SessionGetModelMetadata {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionGetModelMetadata fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetModelMetadata.class, fi, OrtApi.SessionGetModelMetadata$FUNC, session);
        }

        static SessionGetModelMetadata ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetModelMetadata$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetModelMetadata$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetModelMetadata"));

    public static VarHandle SessionGetModelMetadata$VH() {
        return OrtApi.SessionGetModelMetadata$VH;
    }

    public static MemoryAddress SessionGetModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetModelMetadata$VH.get(seg);
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetModelMetadata$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetModelMetadata$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetModelMetadata$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetModelMetadata SessionGetModelMetadata(MemorySegment segment, MemorySession session) {
        return SessionGetModelMetadata.ofAddress(SessionGetModelMetadata$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetProducerName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetProducerName$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetProducerName$FUNC);

    public interface ModelMetadataGetProducerName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ModelMetadataGetProducerName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetProducerName.class, fi, OrtApi.ModelMetadataGetProducerName$FUNC, session);
        }

        static ModelMetadataGetProducerName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetProducerName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetProducerName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetProducerName"));

    public static VarHandle ModelMetadataGetProducerName$VH() {
        return OrtApi.ModelMetadataGetProducerName$VH;
    }

    public static MemoryAddress ModelMetadataGetProducerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetProducerName$VH.get(seg);
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetProducerName$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetProducerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetProducerName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetProducerName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetProducerName ModelMetadataGetProducerName(
            MemorySegment segment, MemorySession session) {
        return ModelMetadataGetProducerName.ofAddress(ModelMetadataGetProducerName$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetGraphName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetGraphName$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetGraphName$FUNC);

    public interface ModelMetadataGetGraphName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ModelMetadataGetGraphName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphName.class, fi, OrtApi.ModelMetadataGetGraphName$FUNC, session);
        }

        static ModelMetadataGetGraphName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetGraphName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetGraphName"));

    public static VarHandle ModelMetadataGetGraphName$VH() {
        return OrtApi.ModelMetadataGetGraphName$VH;
    }

    public static MemoryAddress ModelMetadataGetGraphName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphName$VH.get(seg);
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphName$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetGraphName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetGraphName ModelMetadataGetGraphName(MemorySegment segment, MemorySession session) {
        return ModelMetadataGetGraphName.ofAddress(ModelMetadataGetGraphName$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetDomain$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetDomain$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetDomain$FUNC);

    public interface ModelMetadataGetDomain {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ModelMetadataGetDomain fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDomain.class, fi, OrtApi.ModelMetadataGetDomain$FUNC, session);
        }

        static ModelMetadataGetDomain ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetDomain$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetDomain$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetDomain"));

    public static VarHandle ModelMetadataGetDomain$VH() {
        return OrtApi.ModelMetadataGetDomain$VH;
    }

    public static MemoryAddress ModelMetadataGetDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetDomain$VH.get(seg);
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetDomain$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetDomain ModelMetadataGetDomain(MemorySegment segment, MemorySession session) {
        return ModelMetadataGetDomain.ofAddress(ModelMetadataGetDomain$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetDescription$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetDescription$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetDescription$FUNC);

    public interface ModelMetadataGetDescription {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ModelMetadataGetDescription fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDescription.class, fi, OrtApi.ModelMetadataGetDescription$FUNC, session);
        }

        static ModelMetadataGetDescription ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetDescription$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetDescription$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetDescription"));

    public static VarHandle ModelMetadataGetDescription$VH() {
        return OrtApi.ModelMetadataGetDescription$VH;
    }

    public static MemoryAddress ModelMetadataGetDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetDescription$VH.get(seg);
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetDescription$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetDescription$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetDescription$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetDescription ModelMetadataGetDescription(
            MemorySegment segment, MemorySession session) {
        return ModelMetadataGetDescription.ofAddress(ModelMetadataGetDescription$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataLookupCustomMetadataMap$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataLookupCustomMetadataMap$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC);

    public interface ModelMetadataLookupCustomMetadataMap {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(ModelMetadataLookupCustomMetadataMap fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataLookupCustomMetadataMap.class,
                    fi,
                    OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC,
                    session);
        }

        static ModelMetadataLookupCustomMetadataMap ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.ModelMetadataLookupCustomMetadataMap$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataLookupCustomMetadataMap$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataLookupCustomMetadataMap"));

    public static VarHandle ModelMetadataLookupCustomMetadataMap$VH() {
        return OrtApi.ModelMetadataLookupCustomMetadataMap$VH;
    }

    public static MemoryAddress ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataLookupCustomMetadataMap$VH.get(seg);
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataLookupCustomMetadataMap$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ModelMetadataLookupCustomMetadataMap$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataLookupCustomMetadataMap$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap(
            MemorySegment segment, MemorySession session) {
        return ModelMetadataLookupCustomMetadataMap.ofAddress(
                ModelMetadataLookupCustomMetadataMap$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetVersion$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetVersion$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetVersion$FUNC);

    public interface ModelMetadataGetVersion {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(ModelMetadataGetVersion fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetVersion.class, fi, OrtApi.ModelMetadataGetVersion$FUNC, session);
        }

        static ModelMetadataGetVersion ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetVersion$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetVersion$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetVersion"));

    public static VarHandle ModelMetadataGetVersion$VH() {
        return OrtApi.ModelMetadataGetVersion$VH;
    }

    public static MemoryAddress ModelMetadataGetVersion$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetVersion$VH.get(seg);
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetVersion$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetVersion$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetVersion$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetVersion$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetVersion ModelMetadataGetVersion(MemorySegment segment, MemorySession session) {
        return ModelMetadataGetVersion.ofAddress(ModelMetadataGetVersion$get(segment), session);
    }

    static final FunctionDescriptor ReleaseModelMetadata$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseModelMetadata$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseModelMetadata$FUNC);

    public interface ReleaseModelMetadata {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseModelMetadata fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseModelMetadata.class, fi, OrtApi.ReleaseModelMetadata$FUNC, session);
        }

        static ReleaseModelMetadata ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseModelMetadata$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseModelMetadata$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseModelMetadata"));

    public static VarHandle ReleaseModelMetadata$VH() {
        return OrtApi.ReleaseModelMetadata$VH;
    }

    public static MemoryAddress ReleaseModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseModelMetadata$VH.get(seg);
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseModelMetadata$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseModelMetadata$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseModelMetadata$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseModelMetadata ReleaseModelMetadata(MemorySegment segment, MemorySession session) {
        return ReleaseModelMetadata.ofAddress(ReleaseModelMetadata$get(segment), session);
    }

    static final FunctionDescriptor CreateEnvWithGlobalThreadPools$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateEnvWithGlobalThreadPools$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateEnvWithGlobalThreadPools$FUNC);

    public interface CreateEnvWithGlobalThreadPools {

        java.lang.foreign.Addressable apply(
                int _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(CreateEnvWithGlobalThreadPools fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithGlobalThreadPools.class, fi, OrtApi.CreateEnvWithGlobalThreadPools$FUNC, session);
        }

        static CreateEnvWithGlobalThreadPools ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateEnvWithGlobalThreadPools$MH.invokeExact(
                                    (Addressable) symbol,
                                    __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnvWithGlobalThreadPools$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateEnvWithGlobalThreadPools"));

    public static VarHandle CreateEnvWithGlobalThreadPools$VH() {
        return OrtApi.CreateEnvWithGlobalThreadPools$VH;
    }

    public static MemoryAddress CreateEnvWithGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateEnvWithGlobalThreadPools$VH.get(seg);
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnvWithGlobalThreadPools$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnvWithGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateEnvWithGlobalThreadPools$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnvWithGlobalThreadPools$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithGlobalThreadPools CreateEnvWithGlobalThreadPools(
            MemorySegment segment, MemorySession session) {
        return CreateEnvWithGlobalThreadPools.ofAddress(CreateEnvWithGlobalThreadPools$get(segment), session);
    }

    static final FunctionDescriptor DisablePerSessionThreads$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisablePerSessionThreads$MH =
            RuntimeHelper.downcallHandle(OrtApi.DisablePerSessionThreads$FUNC);

    public interface DisablePerSessionThreads {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(DisablePerSessionThreads fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    DisablePerSessionThreads.class, fi, OrtApi.DisablePerSessionThreads$FUNC, session);
        }

        static DisablePerSessionThreads ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.DisablePerSessionThreads$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisablePerSessionThreads$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("DisablePerSessionThreads"));

    public static VarHandle DisablePerSessionThreads$VH() {
        return OrtApi.DisablePerSessionThreads$VH;
    }

    public static MemoryAddress DisablePerSessionThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisablePerSessionThreads$VH.get(seg);
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisablePerSessionThreads$VH.set(seg, x);
    }

    public static MemoryAddress DisablePerSessionThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.DisablePerSessionThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisablePerSessionThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisablePerSessionThreads DisablePerSessionThreads(MemorySegment segment, MemorySession session) {
        return DisablePerSessionThreads.ofAddress(DisablePerSessionThreads$get(segment), session);
    }

    static final FunctionDescriptor CreateThreadingOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateThreadingOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateThreadingOptions$FUNC);

    public interface CreateThreadingOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateThreadingOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateThreadingOptions.class, fi, OrtApi.CreateThreadingOptions$FUNC, session);
        }

        static CreateThreadingOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateThreadingOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateThreadingOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateThreadingOptions"));

    public static VarHandle CreateThreadingOptions$VH() {
        return OrtApi.CreateThreadingOptions$VH;
    }

    public static MemoryAddress CreateThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateThreadingOptions$VH.get(seg);
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateThreadingOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateThreadingOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateThreadingOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateThreadingOptions CreateThreadingOptions(MemorySegment segment, MemorySession session) {
        return CreateThreadingOptions.ofAddress(CreateThreadingOptions$get(segment), session);
    }

    static final FunctionDescriptor ReleaseThreadingOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseThreadingOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseThreadingOptions$FUNC);

    public interface ReleaseThreadingOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseThreadingOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseThreadingOptions.class, fi, OrtApi.ReleaseThreadingOptions$FUNC, session);
        }

        static ReleaseThreadingOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseThreadingOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseThreadingOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseThreadingOptions"));

    public static VarHandle ReleaseThreadingOptions$VH() {
        return OrtApi.ReleaseThreadingOptions$VH;
    }

    public static MemoryAddress ReleaseThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseThreadingOptions$VH.get(seg);
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseThreadingOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseThreadingOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseThreadingOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseThreadingOptions ReleaseThreadingOptions(MemorySegment segment, MemorySession session) {
        return ReleaseThreadingOptions.ofAddress(ReleaseThreadingOptions$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetCustomMetadataMapKeys$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetCustomMetadataMapKeys$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC);

    public interface ModelMetadataGetCustomMetadataMapKeys {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(ModelMetadataGetCustomMetadataMapKeys fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetCustomMetadataMapKeys.class,
                    fi,
                    OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC,
                    session);
        }

        static ModelMetadataGetCustomMetadataMapKeys ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetCustomMetadataMapKeys$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetCustomMetadataMapKeys$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetCustomMetadataMapKeys"));

    public static VarHandle ModelMetadataGetCustomMetadataMapKeys$VH() {
        return OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH;
    }

    public static MemoryAddress ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.get(seg);
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys(
            MemorySegment segment, MemorySession session) {
        return ModelMetadataGetCustomMetadataMapKeys.ofAddress(
                ModelMetadataGetCustomMetadataMapKeys$get(segment), session);
    }

    static final FunctionDescriptor AddFreeDimensionOverrideByName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle AddFreeDimensionOverrideByName$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddFreeDimensionOverrideByName$FUNC);

    public interface AddFreeDimensionOverrideByName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverrideByName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverrideByName.class, fi, OrtApi.AddFreeDimensionOverrideByName$FUNC, session);
        }

        static AddFreeDimensionOverrideByName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverrideByName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddFreeDimensionOverrideByName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddFreeDimensionOverrideByName"));

    public static VarHandle AddFreeDimensionOverrideByName$VH() {
        return OrtApi.AddFreeDimensionOverrideByName$VH;
    }

    public static MemoryAddress AddFreeDimensionOverrideByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverrideByName$VH.get(seg);
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverrideByName$VH.set(seg, x);
    }

    public static MemoryAddress AddFreeDimensionOverrideByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.AddFreeDimensionOverrideByName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverrideByName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddFreeDimensionOverrideByName AddFreeDimensionOverrideByName(
            MemorySegment segment, MemorySession session) {
        return AddFreeDimensionOverrideByName.ofAddress(AddFreeDimensionOverrideByName$get(segment), session);
    }

    static final FunctionDescriptor GetAvailableProviders$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetAvailableProviders$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetAvailableProviders$FUNC);

    public interface GetAvailableProviders {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetAvailableProviders fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetAvailableProviders.class, fi, OrtApi.GetAvailableProviders$FUNC, session);
        }

        static GetAvailableProviders ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetAvailableProviders$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetAvailableProviders$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetAvailableProviders"));

    public static VarHandle GetAvailableProviders$VH() {
        return OrtApi.GetAvailableProviders$VH;
    }

    public static MemoryAddress GetAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetAvailableProviders$VH.get(seg);
    }

    public static void GetAvailableProviders$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetAvailableProviders$VH.set(seg, x);
    }

    public static MemoryAddress GetAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetAvailableProviders$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetAvailableProviders$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetAvailableProviders$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetAvailableProviders GetAvailableProviders(MemorySegment segment, MemorySession session) {
        return GetAvailableProviders.ofAddress(GetAvailableProviders$get(segment), session);
    }

    static final FunctionDescriptor ReleaseAvailableProviders$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle ReleaseAvailableProviders$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseAvailableProviders$FUNC);

    public interface ReleaseAvailableProviders {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(ReleaseAvailableProviders fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseAvailableProviders.class, fi, OrtApi.ReleaseAvailableProviders$FUNC, session);
        }

        static ReleaseAvailableProviders ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ReleaseAvailableProviders$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseAvailableProviders$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseAvailableProviders"));

    public static VarHandle ReleaseAvailableProviders$VH() {
        return OrtApi.ReleaseAvailableProviders$VH;
    }

    public static MemoryAddress ReleaseAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseAvailableProviders$VH.get(seg);
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseAvailableProviders$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseAvailableProviders$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseAvailableProviders$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseAvailableProviders ReleaseAvailableProviders(MemorySegment segment, MemorySession session) {
        return ReleaseAvailableProviders.ofAddress(ReleaseAvailableProviders$get(segment), session);
    }

    static final FunctionDescriptor GetStringTensorElementLength$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetStringTensorElementLength$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorElementLength$FUNC);

    public interface GetStringTensorElementLength {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetStringTensorElementLength fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElementLength.class, fi, OrtApi.GetStringTensorElementLength$FUNC, session);
        }

        static GetStringTensorElementLength ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorElementLength$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorElementLength$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorElementLength"));

    public static VarHandle GetStringTensorElementLength$VH() {
        return OrtApi.GetStringTensorElementLength$VH;
    }

    public static MemoryAddress GetStringTensorElementLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorElementLength$VH.get(seg);
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorElementLength$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorElementLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetStringTensorElementLength$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorElementLength$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorElementLength GetStringTensorElementLength(
            MemorySegment segment, MemorySession session) {
        return GetStringTensorElementLength.ofAddress(GetStringTensorElementLength$get(segment), session);
    }

    static final FunctionDescriptor GetStringTensorElement$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetStringTensorElement$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorElement$FUNC);

    public interface GetStringTensorElement {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, long _x2, java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(GetStringTensorElement fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElement.class, fi, OrtApi.GetStringTensorElement$FUNC, session);
        }

        static GetStringTensorElement ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorElement$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorElement$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorElement"));

    public static VarHandle GetStringTensorElement$VH() {
        return OrtApi.GetStringTensorElement$VH;
    }

    public static MemoryAddress GetStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorElement$VH.get(seg);
    }

    public static void GetStringTensorElement$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorElement$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetStringTensorElement$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorElement$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorElement$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorElement GetStringTensorElement(MemorySegment segment, MemorySession session) {
        return GetStringTensorElement.ofAddress(GetStringTensorElement$get(segment), session);
    }

    static final FunctionDescriptor FillStringTensorElement$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle FillStringTensorElement$MH =
            RuntimeHelper.downcallHandle(OrtApi.FillStringTensorElement$FUNC);

    public interface FillStringTensorElement {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(FillStringTensorElement fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    FillStringTensorElement.class, fi, OrtApi.FillStringTensorElement$FUNC, session);
        }

        static FillStringTensorElement ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.FillStringTensorElement$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillStringTensorElement$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("FillStringTensorElement"));

    public static VarHandle FillStringTensorElement$VH() {
        return OrtApi.FillStringTensorElement$VH;
    }

    public static MemoryAddress FillStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillStringTensorElement$VH.get(seg);
    }

    public static void FillStringTensorElement$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillStringTensorElement$VH.set(seg, x);
    }

    public static MemoryAddress FillStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillStringTensorElement$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillStringTensorElement$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillStringTensorElement$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillStringTensorElement FillStringTensorElement(MemorySegment segment, MemorySession session) {
        return FillStringTensorElement.ofAddress(FillStringTensorElement$get(segment), session);
    }

    static final FunctionDescriptor AddSessionConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddSessionConfigEntry$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddSessionConfigEntry$FUNC);

    public interface AddSessionConfigEntry {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(AddSessionConfigEntry fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    AddSessionConfigEntry.class, fi, OrtApi.AddSessionConfigEntry$FUNC, session);
        }

        static AddSessionConfigEntry ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddSessionConfigEntry$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddSessionConfigEntry$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddSessionConfigEntry"));

    public static VarHandle AddSessionConfigEntry$VH() {
        return OrtApi.AddSessionConfigEntry$VH;
    }

    public static MemoryAddress AddSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddSessionConfigEntry$VH.get(seg);
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddSessionConfigEntry$VH.set(seg, x);
    }

    public static MemoryAddress AddSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddSessionConfigEntry AddSessionConfigEntry(MemorySegment segment, MemorySession session) {
        return AddSessionConfigEntry.ofAddress(AddSessionConfigEntry$get(segment), session);
    }

    static final FunctionDescriptor CreateAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.CreateAllocator$FUNC);

    public interface CreateAllocator {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(CreateAllocator fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateAllocator.class, fi, OrtApi.CreateAllocator$FUNC, session);
        }

        static CreateAllocator ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateAllocator$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateAllocator$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateAllocator"));

    public static VarHandle CreateAllocator$VH() {
        return OrtApi.CreateAllocator$VH;
    }

    public static MemoryAddress CreateAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateAllocator$VH.get(seg);
    }

    public static void CreateAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateAllocator$VH.set(seg, x);
    }

    public static MemoryAddress CreateAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAllocator CreateAllocator(MemorySegment segment, MemorySession session) {
        return CreateAllocator.ofAddress(CreateAllocator$get(segment), session);
    }

    static final FunctionDescriptor ReleaseAllocator$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseAllocator$FUNC);

    public interface ReleaseAllocator {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseAllocator fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseAllocator.class, fi, OrtApi.ReleaseAllocator$FUNC, session);
        }

        static ReleaseAllocator ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseAllocator$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseAllocator$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseAllocator"));

    public static VarHandle ReleaseAllocator$VH() {
        return OrtApi.ReleaseAllocator$VH;
    }

    public static MemoryAddress ReleaseAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseAllocator$VH.get(seg);
    }

    public static void ReleaseAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseAllocator$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseAllocator ReleaseAllocator(MemorySegment segment, MemorySession session) {
        return ReleaseAllocator.ofAddress(ReleaseAllocator$get(segment), session);
    }

    static final FunctionDescriptor RunWithBinding$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunWithBinding$MH = RuntimeHelper.downcallHandle(OrtApi.RunWithBinding$FUNC);

    public interface RunWithBinding {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(RunWithBinding fi, MemorySession session) {
            return RuntimeHelper.upcallStub(RunWithBinding.class, fi, OrtApi.RunWithBinding$FUNC, session);
        }

        static RunWithBinding ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunWithBinding$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunWithBinding$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunWithBinding"));

    public static VarHandle RunWithBinding$VH() {
        return OrtApi.RunWithBinding$VH;
    }

    public static MemoryAddress RunWithBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunWithBinding$VH.get(seg);
    }

    public static void RunWithBinding$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunWithBinding$VH.set(seg, x);
    }

    public static MemoryAddress RunWithBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunWithBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunWithBinding$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunWithBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunWithBinding RunWithBinding(MemorySegment segment, MemorySession session) {
        return RunWithBinding.ofAddress(RunWithBinding$get(segment), session);
    }

    static final FunctionDescriptor CreateIoBinding$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateIoBinding$MH = RuntimeHelper.downcallHandle(OrtApi.CreateIoBinding$FUNC);

    public interface CreateIoBinding {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CreateIoBinding fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateIoBinding.class, fi, OrtApi.CreateIoBinding$FUNC, session);
        }

        static CreateIoBinding ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateIoBinding$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateIoBinding$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateIoBinding"));

    public static VarHandle CreateIoBinding$VH() {
        return OrtApi.CreateIoBinding$VH;
    }

    public static MemoryAddress CreateIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateIoBinding$VH.get(seg);
    }

    public static void CreateIoBinding$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateIoBinding$VH.set(seg, x);
    }

    public static MemoryAddress CreateIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateIoBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateIoBinding$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateIoBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateIoBinding CreateIoBinding(MemorySegment segment, MemorySession session) {
        return CreateIoBinding.ofAddress(CreateIoBinding$get(segment), session);
    }

    static final FunctionDescriptor ReleaseIoBinding$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseIoBinding$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseIoBinding$FUNC);

    public interface ReleaseIoBinding {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseIoBinding fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseIoBinding.class, fi, OrtApi.ReleaseIoBinding$FUNC, session);
        }

        static ReleaseIoBinding ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseIoBinding$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseIoBinding$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseIoBinding"));

    public static VarHandle ReleaseIoBinding$VH() {
        return OrtApi.ReleaseIoBinding$VH;
    }

    public static MemoryAddress ReleaseIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseIoBinding$VH.get(seg);
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseIoBinding$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseIoBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseIoBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseIoBinding ReleaseIoBinding(MemorySegment segment, MemorySession session) {
        return ReleaseIoBinding.ofAddress(ReleaseIoBinding$get(segment), session);
    }

    static final FunctionDescriptor BindInput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle BindInput$MH = RuntimeHelper.downcallHandle(OrtApi.BindInput$FUNC);

    public interface BindInput {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(BindInput fi, MemorySession session) {
            return RuntimeHelper.upcallStub(BindInput.class, fi, OrtApi.BindInput$FUNC, session);
        }

        static BindInput ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.BindInput$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle BindInput$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("BindInput"));

    public static VarHandle BindInput$VH() {
        return OrtApi.BindInput$VH;
    }

    public static MemoryAddress BindInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.BindInput$VH.get(seg);
    }

    public static void BindInput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.BindInput$VH.set(seg, x);
    }

    public static MemoryAddress BindInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.BindInput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindInput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.BindInput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindInput BindInput(MemorySegment segment, MemorySession session) {
        return BindInput.ofAddress(BindInput$get(segment), session);
    }

    static final FunctionDescriptor BindOutput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle BindOutput$MH = RuntimeHelper.downcallHandle(OrtApi.BindOutput$FUNC);

    public interface BindOutput {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(BindOutput fi, MemorySession session) {
            return RuntimeHelper.upcallStub(BindOutput.class, fi, OrtApi.BindOutput$FUNC, session);
        }

        static BindOutput ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.BindOutput$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle BindOutput$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("BindOutput"));

    public static VarHandle BindOutput$VH() {
        return OrtApi.BindOutput$VH;
    }

    public static MemoryAddress BindOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.BindOutput$VH.get(seg);
    }

    public static void BindOutput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.BindOutput$VH.set(seg, x);
    }

    public static MemoryAddress BindOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.BindOutput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindOutput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.BindOutput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindOutput BindOutput(MemorySegment segment, MemorySession session) {
        return BindOutput.ofAddress(BindOutput$get(segment), session);
    }

    static final FunctionDescriptor BindOutputToDevice$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle BindOutputToDevice$MH = RuntimeHelper.downcallHandle(OrtApi.BindOutputToDevice$FUNC);

    public interface BindOutputToDevice {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(BindOutputToDevice fi, MemorySession session) {
            return RuntimeHelper.upcallStub(BindOutputToDevice.class, fi, OrtApi.BindOutputToDevice$FUNC, session);
        }

        static BindOutputToDevice ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.BindOutputToDevice$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle BindOutputToDevice$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("BindOutputToDevice"));

    public static VarHandle BindOutputToDevice$VH() {
        return OrtApi.BindOutputToDevice$VH;
    }

    public static MemoryAddress BindOutputToDevice$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.BindOutputToDevice$VH.get(seg);
    }

    public static void BindOutputToDevice$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.BindOutputToDevice$VH.set(seg, x);
    }

    public static MemoryAddress BindOutputToDevice$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.BindOutputToDevice$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindOutputToDevice$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.BindOutputToDevice$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindOutputToDevice BindOutputToDevice(MemorySegment segment, MemorySession session) {
        return BindOutputToDevice.ofAddress(BindOutputToDevice$get(segment), session);
    }

    static final FunctionDescriptor GetBoundOutputNames$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetBoundOutputNames$MH = RuntimeHelper.downcallHandle(OrtApi.GetBoundOutputNames$FUNC);

    public interface GetBoundOutputNames {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(GetBoundOutputNames fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetBoundOutputNames.class, fi, OrtApi.GetBoundOutputNames$FUNC, session);
        }

        static GetBoundOutputNames ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetBoundOutputNames$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetBoundOutputNames$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetBoundOutputNames"));

    public static VarHandle GetBoundOutputNames$VH() {
        return OrtApi.GetBoundOutputNames$VH;
    }

    public static MemoryAddress GetBoundOutputNames$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetBoundOutputNames$VH.get(seg);
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetBoundOutputNames$VH.set(seg, x);
    }

    public static MemoryAddress GetBoundOutputNames$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetBoundOutputNames$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetBoundOutputNames$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBoundOutputNames GetBoundOutputNames(MemorySegment segment, MemorySession session) {
        return GetBoundOutputNames.ofAddress(GetBoundOutputNames$get(segment), session);
    }

    static final FunctionDescriptor GetBoundOutputValues$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetBoundOutputValues$MH = RuntimeHelper.downcallHandle(OrtApi.GetBoundOutputValues$FUNC);

    public interface GetBoundOutputValues {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(GetBoundOutputValues fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetBoundOutputValues.class, fi, OrtApi.GetBoundOutputValues$FUNC, session);
        }

        static GetBoundOutputValues ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetBoundOutputValues$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetBoundOutputValues$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetBoundOutputValues"));

    public static VarHandle GetBoundOutputValues$VH() {
        return OrtApi.GetBoundOutputValues$VH;
    }

    public static MemoryAddress GetBoundOutputValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetBoundOutputValues$VH.get(seg);
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetBoundOutputValues$VH.set(seg, x);
    }

    public static MemoryAddress GetBoundOutputValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetBoundOutputValues$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetBoundOutputValues$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBoundOutputValues GetBoundOutputValues(MemorySegment segment, MemorySession session) {
        return GetBoundOutputValues.ofAddress(GetBoundOutputValues$get(segment), session);
    }

    static final FunctionDescriptor ClearBoundInputs$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ClearBoundInputs$MH = RuntimeHelper.downcallHandle(OrtApi.ClearBoundInputs$FUNC);

    public interface ClearBoundInputs {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ClearBoundInputs fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ClearBoundInputs.class, fi, OrtApi.ClearBoundInputs$FUNC, session);
        }

        static ClearBoundInputs ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ClearBoundInputs$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ClearBoundInputs$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ClearBoundInputs"));

    public static VarHandle ClearBoundInputs$VH() {
        return OrtApi.ClearBoundInputs$VH;
    }

    public static MemoryAddress ClearBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ClearBoundInputs$VH.get(seg);
    }

    public static void ClearBoundInputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ClearBoundInputs$VH.set(seg, x);
    }

    public static MemoryAddress ClearBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ClearBoundInputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ClearBoundInputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ClearBoundInputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ClearBoundInputs ClearBoundInputs(MemorySegment segment, MemorySession session) {
        return ClearBoundInputs.ofAddress(ClearBoundInputs$get(segment), session);
    }

    static final FunctionDescriptor ClearBoundOutputs$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ClearBoundOutputs$MH = RuntimeHelper.downcallHandle(OrtApi.ClearBoundOutputs$FUNC);

    public interface ClearBoundOutputs {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ClearBoundOutputs fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ClearBoundOutputs.class, fi, OrtApi.ClearBoundOutputs$FUNC, session);
        }

        static ClearBoundOutputs ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ClearBoundOutputs$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ClearBoundOutputs$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ClearBoundOutputs"));

    public static VarHandle ClearBoundOutputs$VH() {
        return OrtApi.ClearBoundOutputs$VH;
    }

    public static MemoryAddress ClearBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ClearBoundOutputs$VH.get(seg);
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ClearBoundOutputs$VH.set(seg, x);
    }

    public static MemoryAddress ClearBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ClearBoundOutputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ClearBoundOutputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ClearBoundOutputs ClearBoundOutputs(MemorySegment segment, MemorySession session) {
        return ClearBoundOutputs.ofAddress(ClearBoundOutputs$get(segment), session);
    }

    static final FunctionDescriptor TensorAt$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle TensorAt$MH = RuntimeHelper.downcallHandle(OrtApi.TensorAt$FUNC);

    public interface TensorAt {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(TensorAt fi, MemorySession session) {
            return RuntimeHelper.upcallStub(TensorAt.class, fi, OrtApi.TensorAt$FUNC, session);
        }

        static TensorAt ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.TensorAt$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle TensorAt$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("TensorAt"));

    public static VarHandle TensorAt$VH() {
        return OrtApi.TensorAt$VH;
    }

    public static MemoryAddress TensorAt$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.TensorAt$VH.get(seg);
    }

    public static void TensorAt$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.TensorAt$VH.set(seg, x);
    }

    public static MemoryAddress TensorAt$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.TensorAt$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void TensorAt$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.TensorAt$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static TensorAt TensorAt(MemorySegment segment, MemorySession session) {
        return TensorAt.ofAddress(TensorAt$get(segment), session);
    }

    static final FunctionDescriptor CreateAndRegisterAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateAndRegisterAllocator$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateAndRegisterAllocator$FUNC);

    public interface CreateAndRegisterAllocator {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(CreateAndRegisterAllocator fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateAndRegisterAllocator.class, fi, OrtApi.CreateAndRegisterAllocator$FUNC, session);
        }

        static CreateAndRegisterAllocator ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateAndRegisterAllocator$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateAndRegisterAllocator$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateAndRegisterAllocator"));

    public static VarHandle CreateAndRegisterAllocator$VH() {
        return OrtApi.CreateAndRegisterAllocator$VH;
    }

    public static MemoryAddress CreateAndRegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateAndRegisterAllocator$VH.get(seg);
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateAndRegisterAllocator$VH.set(seg, x);
    }

    public static MemoryAddress CreateAndRegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateAndRegisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateAndRegisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAndRegisterAllocator CreateAndRegisterAllocator(MemorySegment segment, MemorySession session) {
        return CreateAndRegisterAllocator.ofAddress(CreateAndRegisterAllocator$get(segment), session);
    }

    static final FunctionDescriptor SetLanguageProjection$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetLanguageProjection$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetLanguageProjection$FUNC);

    public interface SetLanguageProjection {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetLanguageProjection fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetLanguageProjection.class, fi, OrtApi.SetLanguageProjection$FUNC, session);
        }

        static SetLanguageProjection ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetLanguageProjection$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetLanguageProjection$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetLanguageProjection"));

    public static VarHandle SetLanguageProjection$VH() {
        return OrtApi.SetLanguageProjection$VH;
    }

    public static MemoryAddress SetLanguageProjection$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetLanguageProjection$VH.get(seg);
    }

    public static void SetLanguageProjection$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetLanguageProjection$VH.set(seg, x);
    }

    public static MemoryAddress SetLanguageProjection$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetLanguageProjection$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetLanguageProjection$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetLanguageProjection$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetLanguageProjection SetLanguageProjection(MemorySegment segment, MemorySession session) {
        return SetLanguageProjection.ofAddress(SetLanguageProjection$get(segment), session);
    }

    static final FunctionDescriptor SessionGetProfilingStartTimeNs$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetProfilingStartTimeNs$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetProfilingStartTimeNs$FUNC);

    public interface SessionGetProfilingStartTimeNs {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionGetProfilingStartTimeNs fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionGetProfilingStartTimeNs.class, fi, OrtApi.SessionGetProfilingStartTimeNs$FUNC, session);
        }

        static SessionGetProfilingStartTimeNs ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionGetProfilingStartTimeNs$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetProfilingStartTimeNs$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionGetProfilingStartTimeNs"));

    public static VarHandle SessionGetProfilingStartTimeNs$VH() {
        return OrtApi.SessionGetProfilingStartTimeNs$VH;
    }

    public static MemoryAddress SessionGetProfilingStartTimeNs$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionGetProfilingStartTimeNs$VH.get(seg);
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetProfilingStartTimeNs$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetProfilingStartTimeNs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionGetProfilingStartTimeNs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetProfilingStartTimeNs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs(
            MemorySegment segment, MemorySession session) {
        return SessionGetProfilingStartTimeNs.ofAddress(SessionGetProfilingStartTimeNs$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalIntraOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetGlobalIntraOpNumThreads$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalIntraOpNumThreads$FUNC);

    public interface SetGlobalIntraOpNumThreads {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetGlobalIntraOpNumThreads fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalIntraOpNumThreads.class, fi, OrtApi.SetGlobalIntraOpNumThreads$FUNC, session);
        }

        static SetGlobalIntraOpNumThreads ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalIntraOpNumThreads$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalIntraOpNumThreads$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalIntraOpNumThreads"));

    public static VarHandle SetGlobalIntraOpNumThreads$VH() {
        return OrtApi.SetGlobalIntraOpNumThreads$VH;
    }

    public static MemoryAddress SetGlobalIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalIntraOpNumThreads$VH.get(seg);
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalIntraOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetGlobalIntraOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalIntraOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads(MemorySegment segment, MemorySession session) {
        return SetGlobalIntraOpNumThreads.ofAddress(SetGlobalIntraOpNumThreads$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalInterOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetGlobalInterOpNumThreads$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalInterOpNumThreads$FUNC);

    public interface SetGlobalInterOpNumThreads {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetGlobalInterOpNumThreads fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalInterOpNumThreads.class, fi, OrtApi.SetGlobalInterOpNumThreads$FUNC, session);
        }

        static SetGlobalInterOpNumThreads ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalInterOpNumThreads$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalInterOpNumThreads$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalInterOpNumThreads"));

    public static VarHandle SetGlobalInterOpNumThreads$VH() {
        return OrtApi.SetGlobalInterOpNumThreads$VH;
    }

    public static MemoryAddress SetGlobalInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalInterOpNumThreads$VH.get(seg);
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalInterOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetGlobalInterOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalInterOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads(MemorySegment segment, MemorySession session) {
        return SetGlobalInterOpNumThreads.ofAddress(SetGlobalInterOpNumThreads$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalSpinControl$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetGlobalSpinControl$MH = RuntimeHelper.downcallHandle(OrtApi.SetGlobalSpinControl$FUNC);

    public interface SetGlobalSpinControl {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(SetGlobalSpinControl fi, MemorySession session) {
            return RuntimeHelper.upcallStub(SetGlobalSpinControl.class, fi, OrtApi.SetGlobalSpinControl$FUNC, session);
        }

        static SetGlobalSpinControl ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalSpinControl$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalSpinControl$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalSpinControl"));

    public static VarHandle SetGlobalSpinControl$VH() {
        return OrtApi.SetGlobalSpinControl$VH;
    }

    public static MemoryAddress SetGlobalSpinControl$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalSpinControl$VH.get(seg);
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalSpinControl$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalSpinControl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalSpinControl$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalSpinControl$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalSpinControl SetGlobalSpinControl(MemorySegment segment, MemorySession session) {
        return SetGlobalSpinControl.ofAddress(SetGlobalSpinControl$get(segment), session);
    }

    static final FunctionDescriptor AddInitializer$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddInitializer$MH = RuntimeHelper.downcallHandle(OrtApi.AddInitializer$FUNC);

    public interface AddInitializer {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(AddInitializer fi, MemorySession session) {
            return RuntimeHelper.upcallStub(AddInitializer.class, fi, OrtApi.AddInitializer$FUNC, session);
        }

        static AddInitializer ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddInitializer$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddInitializer$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddInitializer"));

    public static VarHandle AddInitializer$VH() {
        return OrtApi.AddInitializer$VH;
    }

    public static MemoryAddress AddInitializer$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddInitializer$VH.get(seg);
    }

    public static void AddInitializer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddInitializer$VH.set(seg, x);
    }

    public static MemoryAddress AddInitializer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddInitializer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddInitializer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddInitializer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddInitializer AddInitializer(MemorySegment segment, MemorySession session) {
        return AddInitializer.ofAddress(AddInitializer$get(segment), session);
    }

    static final FunctionDescriptor CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC);

    public interface CreateEnvWithCustomLoggerAndGlobalThreadPools {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                int _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5);

        static MemorySegment allocate(CreateEnvWithCustomLoggerAndGlobalThreadPools fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLoggerAndGlobalThreadPools.class,
                    fi,
                    OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC,
                    session);
        }

        static CreateEnvWithCustomLoggerAndGlobalThreadPools ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    int __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLoggerAndGlobalThreadPools"));

    public static VarHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$VH() {
        return OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH;
    }

    public static MemoryAddress CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.get(seg);
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools(
            MemorySegment segment, MemorySession session) {
        return CreateEnvWithCustomLoggerAndGlobalThreadPools.ofAddress(
                CreateEnvWithCustomLoggerAndGlobalThreadPools$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CUDA$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CUDA$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC);

    public interface SessionOptionsAppendExecutionProvider_CUDA {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CUDA.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_CUDA ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_CUDA$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_CUDA$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_CUDA"));

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA SessionOptionsAppendExecutionProvider_CUDA(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_CUDA.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_ROCM$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_ROCM$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC);

    public interface SessionOptionsAppendExecutionProvider_ROCM {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_ROCM fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_ROCM.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_ROCM ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_ROCM$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_ROCM$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_ROCM"));

    public static VarHandle SessionOptionsAppendExecutionProvider_ROCM$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_ROCM.ofAddress(
                SessionOptionsAppendExecutionProvider_ROCM$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_OpenVINO$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_OpenVINO$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC);

    public interface SessionOptionsAppendExecutionProvider_OpenVINO {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_OpenVINO fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_OpenVINO.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_OpenVINO$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_OpenVINO"));

    public static VarHandle SessionOptionsAppendExecutionProvider_OpenVINO$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_OpenVINO.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalDenormalAsZero$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalDenormalAsZero$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalDenormalAsZero$FUNC);

    public interface SetGlobalDenormalAsZero {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(SetGlobalDenormalAsZero fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalDenormalAsZero.class, fi, OrtApi.SetGlobalDenormalAsZero$FUNC, session);
        }

        static SetGlobalDenormalAsZero ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalDenormalAsZero$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalDenormalAsZero$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalDenormalAsZero"));

    public static VarHandle SetGlobalDenormalAsZero$VH() {
        return OrtApi.SetGlobalDenormalAsZero$VH;
    }

    public static MemoryAddress SetGlobalDenormalAsZero$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalDenormalAsZero$VH.get(seg);
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalDenormalAsZero$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalDenormalAsZero$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalDenormalAsZero$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalDenormalAsZero$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalDenormalAsZero SetGlobalDenormalAsZero(MemorySegment segment, MemorySession session) {
        return SetGlobalDenormalAsZero.ofAddress(SetGlobalDenormalAsZero$get(segment), session);
    }

    static final FunctionDescriptor CreateArenaCfg$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateArenaCfg$MH = RuntimeHelper.downcallHandle(OrtApi.CreateArenaCfg$FUNC);

    public interface CreateArenaCfg {

        java.lang.foreign.Addressable apply(long _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateArenaCfg fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateArenaCfg.class, fi, OrtApi.CreateArenaCfg$FUNC, session);
        }

        static CreateArenaCfg ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (long __x0, int __x1, int __x2, int __x3, java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateArenaCfg$MH.invokeExact(
                                    (Addressable) symbol, __x0, __x1, __x2, __x3, (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateArenaCfg$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateArenaCfg"));

    public static VarHandle CreateArenaCfg$VH() {
        return OrtApi.CreateArenaCfg$VH;
    }

    public static MemoryAddress CreateArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateArenaCfg$VH.get(seg);
    }

    public static void CreateArenaCfg$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateArenaCfg$VH.set(seg, x);
    }

    public static MemoryAddress CreateArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateArenaCfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateArenaCfg$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateArenaCfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateArenaCfg CreateArenaCfg(MemorySegment segment, MemorySession session) {
        return CreateArenaCfg.ofAddress(CreateArenaCfg$get(segment), session);
    }

    static final FunctionDescriptor ReleaseArenaCfg$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseArenaCfg$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseArenaCfg$FUNC);

    public interface ReleaseArenaCfg {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseArenaCfg fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseArenaCfg.class, fi, OrtApi.ReleaseArenaCfg$FUNC, session);
        }

        static ReleaseArenaCfg ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseArenaCfg$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseArenaCfg$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseArenaCfg"));

    public static VarHandle ReleaseArenaCfg$VH() {
        return OrtApi.ReleaseArenaCfg$VH;
    }

    public static MemoryAddress ReleaseArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseArenaCfg$VH.get(seg);
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseArenaCfg$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseArenaCfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseArenaCfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseArenaCfg ReleaseArenaCfg(MemorySegment segment, MemorySession session) {
        return ReleaseArenaCfg.ofAddress(ReleaseArenaCfg$get(segment), session);
    }

    static final FunctionDescriptor ModelMetadataGetGraphDescription$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetGraphDescription$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetGraphDescription$FUNC);

    public interface ModelMetadataGetGraphDescription {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ModelMetadataGetGraphDescription fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphDescription.class, fi, OrtApi.ModelMetadataGetGraphDescription$FUNC, session);
        }

        static ModelMetadataGetGraphDescription ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphDescription$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetGraphDescription$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetGraphDescription"));

    public static VarHandle ModelMetadataGetGraphDescription$VH() {
        return OrtApi.ModelMetadataGetGraphDescription$VH;
    }

    public static MemoryAddress ModelMetadataGetGraphDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphDescription$VH.get(seg);
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphDescription$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetGraphDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetGraphDescription$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphDescription$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription(
            MemorySegment segment, MemorySession session) {
        return ModelMetadataGetGraphDescription.ofAddress(ModelMetadataGetGraphDescription$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_TensorRT$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_TensorRT$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC);

    public interface SessionOptionsAppendExecutionProvider_TensorRT {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_TensorRT$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_TensorRT"));

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT SessionOptionsAppendExecutionProvider_TensorRT(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_TensorRT.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT$get(segment), session);
    }

    static final FunctionDescriptor SetCurrentGpuDeviceId$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetCurrentGpuDeviceId$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetCurrentGpuDeviceId$FUNC);

    public interface SetCurrentGpuDeviceId {

        java.lang.foreign.Addressable apply(int _x0);

        static MemorySegment allocate(SetCurrentGpuDeviceId fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetCurrentGpuDeviceId.class, fi, OrtApi.SetCurrentGpuDeviceId$FUNC, session);
        }

        static SetCurrentGpuDeviceId ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SetCurrentGpuDeviceId$MH.invokeExact((Addressable) symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetCurrentGpuDeviceId$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetCurrentGpuDeviceId"));

    public static VarHandle SetCurrentGpuDeviceId$VH() {
        return OrtApi.SetCurrentGpuDeviceId$VH;
    }

    public static MemoryAddress SetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetCurrentGpuDeviceId$VH.get(seg);
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetCurrentGpuDeviceId$VH.set(seg, x);
    }

    public static MemoryAddress SetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetCurrentGpuDeviceId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetCurrentGpuDeviceId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetCurrentGpuDeviceId SetCurrentGpuDeviceId(MemorySegment segment, MemorySession session) {
        return SetCurrentGpuDeviceId.ofAddress(SetCurrentGpuDeviceId$get(segment), session);
    }

    static final FunctionDescriptor GetCurrentGpuDeviceId$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCurrentGpuDeviceId$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCurrentGpuDeviceId$FUNC);

    public interface GetCurrentGpuDeviceId {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetCurrentGpuDeviceId fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetCurrentGpuDeviceId.class, fi, OrtApi.GetCurrentGpuDeviceId$FUNC, session);
        }

        static GetCurrentGpuDeviceId ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetCurrentGpuDeviceId$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetCurrentGpuDeviceId$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetCurrentGpuDeviceId"));

    public static VarHandle GetCurrentGpuDeviceId$VH() {
        return OrtApi.GetCurrentGpuDeviceId$VH;
    }

    public static MemoryAddress GetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetCurrentGpuDeviceId$VH.get(seg);
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetCurrentGpuDeviceId$VH.set(seg, x);
    }

    public static MemoryAddress GetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetCurrentGpuDeviceId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetCurrentGpuDeviceId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCurrentGpuDeviceId GetCurrentGpuDeviceId(MemorySegment segment, MemorySession session) {
        return GetCurrentGpuDeviceId.ofAddress(GetCurrentGpuDeviceId$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetAttributeArray_float$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttributeArray_float$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttributeArray_float$FUNC);

    public interface KernelInfoGetAttributeArray_float {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfoGetAttributeArray_float fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_float.class,
                    fi,
                    OrtApi.KernelInfoGetAttributeArray_float$FUNC,
                    session);
        }

        static KernelInfoGetAttributeArray_float ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttributeArray_float$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttributeArray_float$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_float"));

    public static VarHandle KernelInfoGetAttributeArray_float$VH() {
        return OrtApi.KernelInfoGetAttributeArray_float$VH;
    }

    public static MemoryAddress KernelInfoGetAttributeArray_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttributeArray_float$VH.get(seg);
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_float$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttributeArray_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttributeArray_float$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_float$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttributeArray_float KernelInfoGetAttributeArray_float(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetAttributeArray_float.ofAddress(KernelInfoGetAttributeArray_float$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetAttributeArray_int64$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttributeArray_int64$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttributeArray_int64$FUNC);

    public interface KernelInfoGetAttributeArray_int64 {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfoGetAttributeArray_int64 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_int64.class,
                    fi,
                    OrtApi.KernelInfoGetAttributeArray_int64$FUNC,
                    session);
        }

        static KernelInfoGetAttributeArray_int64 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttributeArray_int64$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttributeArray_int64$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_int64"));

    public static VarHandle KernelInfoGetAttributeArray_int64$VH() {
        return OrtApi.KernelInfoGetAttributeArray_int64$VH;
    }

    public static MemoryAddress KernelInfoGetAttributeArray_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttributeArray_int64$VH.get(seg);
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_int64$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttributeArray_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttributeArray_int64$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_int64$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttributeArray_int64 KernelInfoGetAttributeArray_int64(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetAttributeArray_int64.ofAddress(KernelInfoGetAttributeArray_int64$get(segment), session);
    }

    static final FunctionDescriptor CreateArenaCfgV2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateArenaCfgV2$MH = RuntimeHelper.downcallHandle(OrtApi.CreateArenaCfgV2$FUNC);

    public interface CreateArenaCfgV2 {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(CreateArenaCfgV2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateArenaCfgV2.class, fi, OrtApi.CreateArenaCfgV2$FUNC, session);
        }

        static CreateArenaCfgV2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateArenaCfgV2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateArenaCfgV2$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateArenaCfgV2"));

    public static VarHandle CreateArenaCfgV2$VH() {
        return OrtApi.CreateArenaCfgV2$VH;
    }

    public static MemoryAddress CreateArenaCfgV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateArenaCfgV2$VH.get(seg);
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateArenaCfgV2$VH.set(seg, x);
    }

    public static MemoryAddress CreateArenaCfgV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateArenaCfgV2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateArenaCfgV2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateArenaCfgV2 CreateArenaCfgV2(MemorySegment segment, MemorySession session) {
        return CreateArenaCfgV2.ofAddress(CreateArenaCfgV2$get(segment), session);
    }

    static final FunctionDescriptor AddRunConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddRunConfigEntry$MH = RuntimeHelper.downcallHandle(OrtApi.AddRunConfigEntry$FUNC);

    public interface AddRunConfigEntry {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(AddRunConfigEntry fi, MemorySession session) {
            return RuntimeHelper.upcallStub(AddRunConfigEntry.class, fi, OrtApi.AddRunConfigEntry$FUNC, session);
        }

        static AddRunConfigEntry ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddRunConfigEntry$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddRunConfigEntry$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddRunConfigEntry"));

    public static VarHandle AddRunConfigEntry$VH() {
        return OrtApi.AddRunConfigEntry$VH;
    }

    public static MemoryAddress AddRunConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddRunConfigEntry$VH.get(seg);
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddRunConfigEntry$VH.set(seg, x);
    }

    public static MemoryAddress AddRunConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddRunConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddRunConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddRunConfigEntry AddRunConfigEntry(MemorySegment segment, MemorySession session) {
        return AddRunConfigEntry.ofAddress(AddRunConfigEntry$get(segment), session);
    }

    static final FunctionDescriptor CreatePrepackedWeightsContainer$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreatePrepackedWeightsContainer$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreatePrepackedWeightsContainer$FUNC);

    public interface CreatePrepackedWeightsContainer {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreatePrepackedWeightsContainer fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreatePrepackedWeightsContainer.class, fi, OrtApi.CreatePrepackedWeightsContainer$FUNC, session);
        }

        static CreatePrepackedWeightsContainer ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreatePrepackedWeightsContainer$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreatePrepackedWeightsContainer$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreatePrepackedWeightsContainer"));

    public static VarHandle CreatePrepackedWeightsContainer$VH() {
        return OrtApi.CreatePrepackedWeightsContainer$VH;
    }

    public static MemoryAddress CreatePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreatePrepackedWeightsContainer$VH.get(seg);
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreatePrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress CreatePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreatePrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreatePrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreatePrepackedWeightsContainer CreatePrepackedWeightsContainer(
            MemorySegment segment, MemorySession session) {
        return CreatePrepackedWeightsContainer.ofAddress(CreatePrepackedWeightsContainer$get(segment), session);
    }

    static final FunctionDescriptor ReleasePrepackedWeightsContainer$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleasePrepackedWeightsContainer$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleasePrepackedWeightsContainer$FUNC);

    public interface ReleasePrepackedWeightsContainer {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleasePrepackedWeightsContainer fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleasePrepackedWeightsContainer.class, fi, OrtApi.ReleasePrepackedWeightsContainer$FUNC, session);
        }

        static ReleasePrepackedWeightsContainer ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleasePrepackedWeightsContainer$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleasePrepackedWeightsContainer$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleasePrepackedWeightsContainer"));

    public static VarHandle ReleasePrepackedWeightsContainer$VH() {
        return OrtApi.ReleasePrepackedWeightsContainer$VH;
    }

    public static MemoryAddress ReleasePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleasePrepackedWeightsContainer$VH.get(seg);
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleasePrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress ReleasePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleasePrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleasePrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleasePrepackedWeightsContainer ReleasePrepackedWeightsContainer(
            MemorySegment segment, MemorySession session) {
        return ReleasePrepackedWeightsContainer.ofAddress(ReleasePrepackedWeightsContainer$get(segment), session);
    }

    static final FunctionDescriptor CreateSessionWithPrepackedWeightsContainer$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSessionWithPrepackedWeightsContainer$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateSessionWithPrepackedWeightsContainer$FUNC);

    public interface CreateSessionWithPrepackedWeightsContainer {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateSessionWithPrepackedWeightsContainer fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateSessionWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionWithPrepackedWeightsContainer$FUNC,
                    session);
        }

        static CreateSessionWithPrepackedWeightsContainer ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.CreateSessionWithPrepackedWeightsContainer$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionWithPrepackedWeightsContainer$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("CreateSessionWithPrepackedWeightsContainer"));

    public static VarHandle CreateSessionWithPrepackedWeightsContainer$VH() {
        return OrtApi.CreateSessionWithPrepackedWeightsContainer$VH;
    }

    public static MemoryAddress CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.get(seg);
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionWithPrepackedWeightsContainer CreateSessionWithPrepackedWeightsContainer(
            MemorySegment segment, MemorySession session) {
        return CreateSessionWithPrepackedWeightsContainer.ofAddress(
                CreateSessionWithPrepackedWeightsContainer$get(segment), session);
    }

    static final FunctionDescriptor CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSessionFromArrayWithPrepackedWeightsContainer$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC);

    public interface CreateSessionFromArrayWithPrepackedWeightsContainer {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5);

        static MemorySegment allocate(CreateSessionFromArrayWithPrepackedWeightsContainer fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArrayWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC,
                    session);
        }

        static CreateSessionFromArrayWithPrepackedWeightsContainer ofAddress(
                MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionFromArrayWithPrepackedWeightsContainer$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("CreateSessionFromArrayWithPrepackedWeightsContainer"));

    public static VarHandle CreateSessionFromArrayWithPrepackedWeightsContainer$VH() {
        return OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH;
    }

    public static MemoryAddress CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.get(seg);
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionFromArrayWithPrepackedWeightsContainer
            CreateSessionFromArrayWithPrepackedWeightsContainer(MemorySegment segment, MemorySession session) {
        return CreateSessionFromArrayWithPrepackedWeightsContainer.ofAddress(
                CreateSessionFromArrayWithPrepackedWeightsContainer$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC);

    public interface SessionOptionsAppendExecutionProvider_TensorRT_V2 {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT_V2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT_V2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_TensorRT_V2"));

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_TensorRT_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT_V2$get(segment), session);
    }

    static final FunctionDescriptor CreateTensorRTProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateTensorRTProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateTensorRTProviderOptions$FUNC);

    public interface CreateTensorRTProviderOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateTensorRTProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateTensorRTProviderOptions.class, fi, OrtApi.CreateTensorRTProviderOptions$FUNC, session);
        }

        static CreateTensorRTProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorRTProviderOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorRTProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorRTProviderOptions"));

    public static VarHandle CreateTensorRTProviderOptions$VH() {
        return OrtApi.CreateTensorRTProviderOptions$VH;
    }

    public static MemoryAddress CreateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateTensorRTProviderOptions$VH.get(seg);
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorRTProviderOptions CreateTensorRTProviderOptions(
            MemorySegment segment, MemorySession session) {
        return CreateTensorRTProviderOptions.ofAddress(CreateTensorRTProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor UpdateTensorRTProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateTensorRTProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateTensorRTProviderOptions$FUNC);

    public interface UpdateTensorRTProviderOptions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(UpdateTensorRTProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateTensorRTProviderOptions.class, fi, OrtApi.UpdateTensorRTProviderOptions$FUNC, session);
        }

        static UpdateTensorRTProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateTensorRTProviderOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateTensorRTProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateTensorRTProviderOptions"));

    public static VarHandle UpdateTensorRTProviderOptions$VH() {
        return OrtApi.UpdateTensorRTProviderOptions$VH;
    }

    public static MemoryAddress UpdateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateTensorRTProviderOptions$VH.get(seg);
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress UpdateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.UpdateTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions(
            MemorySegment segment, MemorySession session) {
        return UpdateTensorRTProviderOptions.ofAddress(UpdateTensorRTProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor GetTensorRTProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorRTProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorRTProviderOptionsAsString$FUNC);

    public interface GetTensorRTProviderOptionsAsString {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetTensorRTProviderOptionsAsString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetTensorRTProviderOptionsAsString.class,
                    fi,
                    OrtApi.GetTensorRTProviderOptionsAsString$FUNC,
                    session);
        }

        static GetTensorRTProviderOptionsAsString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorRTProviderOptionsAsString$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorRTProviderOptionsAsString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorRTProviderOptionsAsString"));

    public static VarHandle GetTensorRTProviderOptionsAsString$VH() {
        return OrtApi.GetTensorRTProviderOptionsAsString$VH;
    }

    public static MemoryAddress GetTensorRTProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorRTProviderOptionsAsString$VH.get(seg);
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorRTProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorRTProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetTensorRTProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorRTProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorRTProviderOptionsAsString GetTensorRTProviderOptionsAsString(
            MemorySegment segment, MemorySession session) {
        return GetTensorRTProviderOptionsAsString.ofAddress(GetTensorRTProviderOptionsAsString$get(segment), session);
    }

    static final FunctionDescriptor ReleaseTensorRTProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseTensorRTProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseTensorRTProviderOptions$FUNC);

    public interface ReleaseTensorRTProviderOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseTensorRTProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorRTProviderOptions.class, fi, OrtApi.ReleaseTensorRTProviderOptions$FUNC, session);
        }

        static ReleaseTensorRTProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseTensorRTProviderOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseTensorRTProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseTensorRTProviderOptions"));

    public static VarHandle ReleaseTensorRTProviderOptions$VH() {
        return OrtApi.ReleaseTensorRTProviderOptions$VH;
    }

    public static MemoryAddress ReleaseTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseTensorRTProviderOptions$VH.get(seg);
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleaseTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions(
            MemorySegment segment, MemorySession session) {
        return ReleaseTensorRTProviderOptions.ofAddress(ReleaseTensorRTProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor EnableOrtCustomOps$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableOrtCustomOps$MH = RuntimeHelper.downcallHandle(OrtApi.EnableOrtCustomOps$FUNC);

    public interface EnableOrtCustomOps {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(EnableOrtCustomOps fi, MemorySession session) {
            return RuntimeHelper.upcallStub(EnableOrtCustomOps.class, fi, OrtApi.EnableOrtCustomOps$FUNC, session);
        }

        static EnableOrtCustomOps ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.EnableOrtCustomOps$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableOrtCustomOps$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("EnableOrtCustomOps"));

    public static VarHandle EnableOrtCustomOps$VH() {
        return OrtApi.EnableOrtCustomOps$VH;
    }

    public static MemoryAddress EnableOrtCustomOps$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableOrtCustomOps$VH.get(seg);
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableOrtCustomOps$VH.set(seg, x);
    }

    public static MemoryAddress EnableOrtCustomOps$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.EnableOrtCustomOps$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableOrtCustomOps$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableOrtCustomOps EnableOrtCustomOps(MemorySegment segment, MemorySession session) {
        return EnableOrtCustomOps.ofAddress(EnableOrtCustomOps$get(segment), session);
    }

    static final FunctionDescriptor RegisterAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.RegisterAllocator$FUNC);

    public interface RegisterAllocator {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RegisterAllocator fi, MemorySession session) {
            return RuntimeHelper.upcallStub(RegisterAllocator.class, fi, OrtApi.RegisterAllocator$FUNC, session);
        }

        static RegisterAllocator ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RegisterAllocator$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RegisterAllocator$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RegisterAllocator"));

    public static VarHandle RegisterAllocator$VH() {
        return OrtApi.RegisterAllocator$VH;
    }

    public static MemoryAddress RegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RegisterAllocator$VH.get(seg);
    }

    public static void RegisterAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RegisterAllocator$VH.set(seg, x);
    }

    public static MemoryAddress RegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RegisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RegisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterAllocator RegisterAllocator(MemorySegment segment, MemorySession session) {
        return RegisterAllocator.ofAddress(RegisterAllocator$get(segment), session);
    }

    static final FunctionDescriptor UnregisterAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle UnregisterAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.UnregisterAllocator$FUNC);

    public interface UnregisterAllocator {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(UnregisterAllocator fi, MemorySession session) {
            return RuntimeHelper.upcallStub(UnregisterAllocator.class, fi, OrtApi.UnregisterAllocator$FUNC, session);
        }

        static UnregisterAllocator ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UnregisterAllocator$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UnregisterAllocator$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UnregisterAllocator"));

    public static VarHandle UnregisterAllocator$VH() {
        return OrtApi.UnregisterAllocator$VH;
    }

    public static MemoryAddress UnregisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UnregisterAllocator$VH.get(seg);
    }

    public static void UnregisterAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UnregisterAllocator$VH.set(seg, x);
    }

    public static MemoryAddress UnregisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UnregisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UnregisterAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UnregisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UnregisterAllocator UnregisterAllocator(MemorySegment segment, MemorySession session) {
        return UnregisterAllocator.ofAddress(UnregisterAllocator$get(segment), session);
    }

    static final FunctionDescriptor IsSparseTensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle IsSparseTensor$MH = RuntimeHelper.downcallHandle(OrtApi.IsSparseTensor$FUNC);

    public interface IsSparseTensor {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(IsSparseTensor fi, MemorySession session) {
            return RuntimeHelper.upcallStub(IsSparseTensor.class, fi, OrtApi.IsSparseTensor$FUNC, session);
        }

        static IsSparseTensor ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.IsSparseTensor$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle IsSparseTensor$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("IsSparseTensor"));

    public static VarHandle IsSparseTensor$VH() {
        return OrtApi.IsSparseTensor$VH;
    }

    public static MemoryAddress IsSparseTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.IsSparseTensor$VH.get(seg);
    }

    public static void IsSparseTensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.IsSparseTensor$VH.set(seg, x);
    }

    public static MemoryAddress IsSparseTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.IsSparseTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void IsSparseTensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.IsSparseTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static IsSparseTensor IsSparseTensor(MemorySegment segment, MemorySession session) {
        return IsSparseTensor.ofAddress(IsSparseTensor$get(segment), session);
    }

    static final FunctionDescriptor CreateSparseTensorAsOrtValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSparseTensorAsOrtValue$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateSparseTensorAsOrtValue$FUNC);

    public interface CreateSparseTensorAsOrtValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                int _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateSparseTensorAsOrtValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorAsOrtValue.class, fi, OrtApi.CreateSparseTensorAsOrtValue$FUNC, session);
        }

        static CreateSparseTensorAsOrtValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    int __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateSparseTensorAsOrtValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSparseTensorAsOrtValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateSparseTensorAsOrtValue"));

    public static VarHandle CreateSparseTensorAsOrtValue$VH() {
        return OrtApi.CreateSparseTensorAsOrtValue$VH;
    }

    public static MemoryAddress CreateSparseTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSparseTensorAsOrtValue$VH.get(seg);
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSparseTensorAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateSparseTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateSparseTensorAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSparseTensorAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSparseTensorAsOrtValue CreateSparseTensorAsOrtValue(
            MemorySegment segment, MemorySession session) {
        return CreateSparseTensorAsOrtValue.ofAddress(CreateSparseTensorAsOrtValue$get(segment), session);
    }

    static final FunctionDescriptor FillSparseTensorCoo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle FillSparseTensorCoo$MH = RuntimeHelper.downcallHandle(OrtApi.FillSparseTensorCoo$FUNC);

    public interface FillSparseTensorCoo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5,
                long _x6);

        static MemorySegment allocate(FillSparseTensorCoo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(FillSparseTensorCoo.class, fi, OrtApi.FillSparseTensorCoo$FUNC, session);
        }

        static FillSparseTensorCoo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    long __x6) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorCoo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5,
                                    __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillSparseTensorCoo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("FillSparseTensorCoo"));

    public static VarHandle FillSparseTensorCoo$VH() {
        return OrtApi.FillSparseTensorCoo$VH;
    }

    public static MemoryAddress FillSparseTensorCoo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorCoo$VH.get(seg);
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillSparseTensorCoo$VH.set(seg, x);
    }

    public static MemoryAddress FillSparseTensorCoo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorCoo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillSparseTensorCoo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorCoo FillSparseTensorCoo(MemorySegment segment, MemorySession session) {
        return FillSparseTensorCoo.ofAddress(FillSparseTensorCoo$get(segment), session);
    }

    static final FunctionDescriptor FillSparseTensorCsr$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle FillSparseTensorCsr$MH = RuntimeHelper.downcallHandle(OrtApi.FillSparseTensorCsr$FUNC);

    public interface FillSparseTensorCsr {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5,
                long _x6,
                java.lang.foreign.MemoryAddress _x7,
                long _x8);

        static MemorySegment allocate(FillSparseTensorCsr fi, MemorySession session) {
            return RuntimeHelper.upcallStub(FillSparseTensorCsr.class, fi, OrtApi.FillSparseTensorCsr$FUNC, session);
        }

        static FillSparseTensorCsr ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    long __x6,
                    java.lang.foreign.MemoryAddress __x7,
                    long __x8) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorCsr$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5,
                                    __x6,
                                    (java.lang.foreign.Addressable) __x7,
                                    __x8);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillSparseTensorCsr$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("FillSparseTensorCsr"));

    public static VarHandle FillSparseTensorCsr$VH() {
        return OrtApi.FillSparseTensorCsr$VH;
    }

    public static MemoryAddress FillSparseTensorCsr$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorCsr$VH.get(seg);
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillSparseTensorCsr$VH.set(seg, x);
    }

    public static MemoryAddress FillSparseTensorCsr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorCsr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillSparseTensorCsr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorCsr FillSparseTensorCsr(MemorySegment segment, MemorySession session) {
        return FillSparseTensorCsr.ofAddress(FillSparseTensorCsr$get(segment), session);
    }

    static final FunctionDescriptor FillSparseTensorBlockSparse$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle FillSparseTensorBlockSparse$MH =
            RuntimeHelper.downcallHandle(OrtApi.FillSparseTensorBlockSparse$FUNC);

    public interface FillSparseTensorBlockSparse {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5,
                long _x6,
                java.lang.foreign.MemoryAddress _x7);

        static MemorySegment allocate(FillSparseTensorBlockSparse fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorBlockSparse.class, fi, OrtApi.FillSparseTensorBlockSparse$FUNC, session);
        }

        static FillSparseTensorBlockSparse ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    long __x6,
                    java.lang.foreign.MemoryAddress __x7) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorBlockSparse$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5,
                                    __x6,
                                    (java.lang.foreign.Addressable) __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillSparseTensorBlockSparse$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("FillSparseTensorBlockSparse"));

    public static VarHandle FillSparseTensorBlockSparse$VH() {
        return OrtApi.FillSparseTensorBlockSparse$VH;
    }

    public static MemoryAddress FillSparseTensorBlockSparse$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.FillSparseTensorBlockSparse$VH.get(seg);
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillSparseTensorBlockSparse$VH.set(seg, x);
    }

    public static MemoryAddress FillSparseTensorBlockSparse$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.FillSparseTensorBlockSparse$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillSparseTensorBlockSparse$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorBlockSparse FillSparseTensorBlockSparse(
            MemorySegment segment, MemorySession session) {
        return FillSparseTensorBlockSparse.ofAddress(FillSparseTensorBlockSparse$get(segment), session);
    }

    static final FunctionDescriptor CreateSparseTensorWithValuesAsOrtValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSparseTensorWithValuesAsOrtValue$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateSparseTensorWithValuesAsOrtValue$FUNC);

    public interface CreateSparseTensorWithValuesAsOrtValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4,
                long _x5,
                int _x6,
                java.lang.foreign.MemoryAddress _x7);

        static MemorySegment allocate(CreateSparseTensorWithValuesAsOrtValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorWithValuesAsOrtValue.class,
                    fi,
                    OrtApi.CreateSparseTensorWithValuesAsOrtValue$FUNC,
                    session);
        }

        static CreateSparseTensorWithValuesAsOrtValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    long __x5,
                    int __x6,
                    java.lang.foreign.MemoryAddress __x7) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.CreateSparseTensorWithValuesAsOrtValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    __x5,
                                    __x6,
                                    (java.lang.foreign.Addressable) __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSparseTensorWithValuesAsOrtValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateSparseTensorWithValuesAsOrtValue"));

    public static VarHandle CreateSparseTensorWithValuesAsOrtValue$VH() {
        return OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH;
    }

    public static MemoryAddress CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.get(seg);
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSparseTensorWithValuesAsOrtValue CreateSparseTensorWithValuesAsOrtValue(
            MemorySegment segment, MemorySession session) {
        return CreateSparseTensorWithValuesAsOrtValue.ofAddress(
                CreateSparseTensorWithValuesAsOrtValue$get(segment), session);
    }

    static final FunctionDescriptor UseCooIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UseCooIndices$MH = RuntimeHelper.downcallHandle(OrtApi.UseCooIndices$FUNC);

    public interface UseCooIndices {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(UseCooIndices fi, MemorySession session) {
            return RuntimeHelper.upcallStub(UseCooIndices.class, fi, OrtApi.UseCooIndices$FUNC, session);
        }

        static UseCooIndices ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UseCooIndices$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UseCooIndices$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UseCooIndices"));

    public static VarHandle UseCooIndices$VH() {
        return OrtApi.UseCooIndices$VH;
    }

    public static MemoryAddress UseCooIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UseCooIndices$VH.get(seg);
    }

    public static void UseCooIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UseCooIndices$VH.set(seg, x);
    }

    public static MemoryAddress UseCooIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UseCooIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseCooIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UseCooIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseCooIndices UseCooIndices(MemorySegment segment, MemorySession session) {
        return UseCooIndices.ofAddress(UseCooIndices$get(segment), session);
    }

    static final FunctionDescriptor UseCsrIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UseCsrIndices$MH = RuntimeHelper.downcallHandle(OrtApi.UseCsrIndices$FUNC);

    public interface UseCsrIndices {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4);

        static MemorySegment allocate(UseCsrIndices fi, MemorySession session) {
            return RuntimeHelper.upcallStub(UseCsrIndices.class, fi, OrtApi.UseCsrIndices$FUNC, session);
        }

        static UseCsrIndices ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UseCsrIndices$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UseCsrIndices$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UseCsrIndices"));

    public static VarHandle UseCsrIndices$VH() {
        return OrtApi.UseCsrIndices$VH;
    }

    public static MemoryAddress UseCsrIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UseCsrIndices$VH.get(seg);
    }

    public static void UseCsrIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UseCsrIndices$VH.set(seg, x);
    }

    public static MemoryAddress UseCsrIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UseCsrIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseCsrIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UseCsrIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseCsrIndices UseCsrIndices(MemorySegment segment, MemorySession session) {
        return UseCsrIndices.ofAddress(UseCsrIndices$get(segment), session);
    }

    static final FunctionDescriptor UseBlockSparseIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle UseBlockSparseIndices$MH =
            RuntimeHelper.downcallHandle(OrtApi.UseBlockSparseIndices$FUNC);

    public interface UseBlockSparseIndices {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(UseBlockSparseIndices fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UseBlockSparseIndices.class, fi, OrtApi.UseBlockSparseIndices$FUNC, session);
        }

        static UseBlockSparseIndices ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UseBlockSparseIndices$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UseBlockSparseIndices$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UseBlockSparseIndices"));

    public static VarHandle UseBlockSparseIndices$VH() {
        return OrtApi.UseBlockSparseIndices$VH;
    }

    public static MemoryAddress UseBlockSparseIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UseBlockSparseIndices$VH.get(seg);
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UseBlockSparseIndices$VH.set(seg, x);
    }

    public static MemoryAddress UseBlockSparseIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UseBlockSparseIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UseBlockSparseIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseBlockSparseIndices UseBlockSparseIndices(MemorySegment segment, MemorySession session) {
        return UseBlockSparseIndices.ofAddress(UseBlockSparseIndices$get(segment), session);
    }

    static final FunctionDescriptor GetSparseTensorFormat$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorFormat$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorFormat$FUNC);

    public interface GetSparseTensorFormat {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetSparseTensorFormat fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorFormat.class, fi, OrtApi.GetSparseTensorFormat$FUNC, session);
        }

        static GetSparseTensorFormat ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorFormat$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorFormat$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorFormat"));

    public static VarHandle GetSparseTensorFormat$VH() {
        return OrtApi.GetSparseTensorFormat$VH;
    }

    public static MemoryAddress GetSparseTensorFormat$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorFormat$VH.get(seg);
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorFormat$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorFormat$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorFormat$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorFormat$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorFormat GetSparseTensorFormat(MemorySegment segment, MemorySession session) {
        return GetSparseTensorFormat.ofAddress(GetSparseTensorFormat$get(segment), session);
    }

    static final FunctionDescriptor GetSparseTensorValuesTypeAndShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorValuesTypeAndShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorValuesTypeAndShape$FUNC);

    public interface GetSparseTensorValuesTypeAndShape {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetSparseTensorValuesTypeAndShape fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValuesTypeAndShape.class,
                    fi,
                    OrtApi.GetSparseTensorValuesTypeAndShape$FUNC,
                    session);
        }

        static GetSparseTensorValuesTypeAndShape ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorValuesTypeAndShape$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorValuesTypeAndShape$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorValuesTypeAndShape"));

    public static VarHandle GetSparseTensorValuesTypeAndShape$VH() {
        return OrtApi.GetSparseTensorValuesTypeAndShape$VH;
    }

    public static MemoryAddress GetSparseTensorValuesTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorValuesTypeAndShape$VH.get(seg);
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorValuesTypeAndShape$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorValuesTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetSparseTensorValuesTypeAndShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorValuesTypeAndShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorValuesTypeAndShape GetSparseTensorValuesTypeAndShape(
            MemorySegment segment, MemorySession session) {
        return GetSparseTensorValuesTypeAndShape.ofAddress(GetSparseTensorValuesTypeAndShape$get(segment), session);
    }

    static final FunctionDescriptor GetSparseTensorValues$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorValues$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorValues$FUNC);

    public interface GetSparseTensorValues {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetSparseTensorValues fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValues.class, fi, OrtApi.GetSparseTensorValues$FUNC, session);
        }

        static GetSparseTensorValues ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorValues$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorValues$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorValues"));

    public static VarHandle GetSparseTensorValues$VH() {
        return OrtApi.GetSparseTensorValues$VH;
    }

    public static MemoryAddress GetSparseTensorValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorValues$VH.get(seg);
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorValues$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorValues$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorValues$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorValues GetSparseTensorValues(MemorySegment segment, MemorySession session) {
        return GetSparseTensorValues.ofAddress(GetSparseTensorValues$get(segment), session);
    }

    static final FunctionDescriptor GetSparseTensorIndicesTypeShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorIndicesTypeShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorIndicesTypeShape$FUNC);

    public interface GetSparseTensorIndicesTypeShape {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, int _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetSparseTensorIndicesTypeShape fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndicesTypeShape.class, fi, OrtApi.GetSparseTensorIndicesTypeShape$FUNC, session);
        }

        static GetSparseTensorIndicesTypeShape ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorIndicesTypeShape$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorIndicesTypeShape$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorIndicesTypeShape"));

    public static VarHandle GetSparseTensorIndicesTypeShape$VH() {
        return OrtApi.GetSparseTensorIndicesTypeShape$VH;
    }

    public static MemoryAddress GetSparseTensorIndicesTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorIndicesTypeShape$VH.get(seg);
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorIndicesTypeShape$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorIndicesTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetSparseTensorIndicesTypeShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorIndicesTypeShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorIndicesTypeShape GetSparseTensorIndicesTypeShape(
            MemorySegment segment, MemorySession session) {
        return GetSparseTensorIndicesTypeShape.ofAddress(GetSparseTensorIndicesTypeShape$get(segment), session);
    }

    static final FunctionDescriptor GetSparseTensorIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorIndices$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorIndices$FUNC);

    public interface GetSparseTensorIndices {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                int _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(GetSparseTensorIndices fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndices.class, fi, OrtApi.GetSparseTensorIndices$FUNC, session);
        }

        static GetSparseTensorIndices ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    int __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorIndices$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorIndices$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorIndices"));

    public static VarHandle GetSparseTensorIndices$VH() {
        return OrtApi.GetSparseTensorIndices$VH;
    }

    public static MemoryAddress GetSparseTensorIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorIndices$VH.get(seg);
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorIndices$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSparseTensorIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorIndices GetSparseTensorIndices(MemorySegment segment, MemorySession session) {
        return GetSparseTensorIndices.ofAddress(GetSparseTensorIndices$get(segment), session);
    }

    static final FunctionDescriptor HasValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle HasValue$MH = RuntimeHelper.downcallHandle(OrtApi.HasValue$FUNC);

    public interface HasValue {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(HasValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(HasValue.class, fi, OrtApi.HasValue$FUNC, session);
        }

        static HasValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.HasValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle HasValue$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("HasValue"));

    public static VarHandle HasValue$VH() {
        return OrtApi.HasValue$VH;
    }

    public static MemoryAddress HasValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.HasValue$VH.get(seg);
    }

    public static void HasValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.HasValue$VH.set(seg, x);
    }

    public static MemoryAddress HasValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.HasValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void HasValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.HasValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static HasValue HasValue(MemorySegment segment, MemorySession session) {
        return HasValue.ofAddress(HasValue$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetGPUComputeStream$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetGPUComputeStream$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetGPUComputeStream$FUNC);

    public interface KernelContext_GetGPUComputeStream {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelContext_GetGPUComputeStream fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetGPUComputeStream.class,
                    fi,
                    OrtApi.KernelContext_GetGPUComputeStream$FUNC,
                    session);
        }

        static KernelContext_GetGPUComputeStream ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetGPUComputeStream$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetGPUComputeStream$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetGPUComputeStream"));

    public static VarHandle KernelContext_GetGPUComputeStream$VH() {
        return OrtApi.KernelContext_GetGPUComputeStream$VH;
    }

    public static MemoryAddress KernelContext_GetGPUComputeStream$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetGPUComputeStream$VH.get(seg);
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetGPUComputeStream$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetGPUComputeStream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelContext_GetGPUComputeStream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetGPUComputeStream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetGPUComputeStream KernelContext_GetGPUComputeStream(
            MemorySegment segment, MemorySession session) {
        return KernelContext_GetGPUComputeStream.ofAddress(KernelContext_GetGPUComputeStream$get(segment), session);
    }

    static final FunctionDescriptor GetTensorMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.GetTensorMemoryInfo$FUNC);

    public interface GetTensorMemoryInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetTensorMemoryInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetTensorMemoryInfo.class, fi, OrtApi.GetTensorMemoryInfo$FUNC, session);
        }

        static GetTensorMemoryInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorMemoryInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorMemoryInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorMemoryInfo"));

    public static VarHandle GetTensorMemoryInfo$VH() {
        return OrtApi.GetTensorMemoryInfo$VH;
    }

    public static MemoryAddress GetTensorMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorMemoryInfo$VH.get(seg);
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorMemoryInfo GetTensorMemoryInfo(MemorySegment segment, MemorySession session) {
        return GetTensorMemoryInfo.ofAddress(GetTensorMemoryInfo$get(segment), session);
    }

    static final FunctionDescriptor GetExecutionProviderApi$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetExecutionProviderApi$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetExecutionProviderApi$FUNC);

    public interface GetExecutionProviderApi {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, int _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetExecutionProviderApi fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderApi.class, fi, OrtApi.GetExecutionProviderApi$FUNC, session);
        }

        static GetExecutionProviderApi ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetExecutionProviderApi$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetExecutionProviderApi$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetExecutionProviderApi"));

    public static VarHandle GetExecutionProviderApi$VH() {
        return OrtApi.GetExecutionProviderApi$VH;
    }

    public static MemoryAddress GetExecutionProviderApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetExecutionProviderApi$VH.get(seg);
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetExecutionProviderApi$VH.set(seg, x);
    }

    public static MemoryAddress GetExecutionProviderApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetExecutionProviderApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetExecutionProviderApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetExecutionProviderApi GetExecutionProviderApi(MemorySegment segment, MemorySession session) {
        return GetExecutionProviderApi.ofAddress(GetExecutionProviderApi$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsSetCustomCreateThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsSetCustomCreateThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC);

    public interface SessionOptionsSetCustomCreateThreadFn {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsSetCustomCreateThreadFn fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomCreateThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC,
                    session);
        }

        static SessionOptionsSetCustomCreateThreadFn ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsSetCustomCreateThreadFn$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsSetCustomCreateThreadFn$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomCreateThreadFn"));

    public static VarHandle SessionOptionsSetCustomCreateThreadFn$VH() {
        return OrtApi.SessionOptionsSetCustomCreateThreadFn$VH;
    }

    public static MemoryAddress SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.get(seg);
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomCreateThreadFn SessionOptionsSetCustomCreateThreadFn(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsSetCustomCreateThreadFn.ofAddress(
                SessionOptionsSetCustomCreateThreadFn$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsSetCustomThreadCreationOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsSetCustomThreadCreationOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC);

    public interface SessionOptionsSetCustomThreadCreationOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsSetCustomThreadCreationOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC,
                    session);
        }

        static SessionOptionsSetCustomThreadCreationOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsSetCustomThreadCreationOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsSetCustomThreadCreationOptions$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomThreadCreationOptions"));

    public static VarHandle SessionOptionsSetCustomThreadCreationOptions$VH() {
        return OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH;
    }

    public static MemoryAddress SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.get(seg);
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomThreadCreationOptions SessionOptionsSetCustomThreadCreationOptions(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsSetCustomThreadCreationOptions.ofAddress(
                SessionOptionsSetCustomThreadCreationOptions$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsSetCustomJoinThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsSetCustomJoinThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC);

    public interface SessionOptionsSetCustomJoinThreadFn {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsSetCustomJoinThreadFn fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomJoinThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC,
                    session);
        }

        static SessionOptionsSetCustomJoinThreadFn ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomJoinThreadFn$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsSetCustomJoinThreadFn$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomJoinThreadFn"));

    public static VarHandle SessionOptionsSetCustomJoinThreadFn$VH() {
        return OrtApi.SessionOptionsSetCustomJoinThreadFn$VH;
    }

    public static MemoryAddress SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.get(seg);
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomJoinThreadFn SessionOptionsSetCustomJoinThreadFn(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsSetCustomJoinThreadFn.ofAddress(SessionOptionsSetCustomJoinThreadFn$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalCustomCreateThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalCustomCreateThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalCustomCreateThreadFn$FUNC);

    public interface SetGlobalCustomCreateThreadFn {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SetGlobalCustomCreateThreadFn fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomCreateThreadFn.class, fi, OrtApi.SetGlobalCustomCreateThreadFn$FUNC, session);
        }

        static SetGlobalCustomCreateThreadFn ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalCustomCreateThreadFn$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalCustomCreateThreadFn$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalCustomCreateThreadFn"));

    public static VarHandle SetGlobalCustomCreateThreadFn$VH() {
        return OrtApi.SetGlobalCustomCreateThreadFn$VH;
    }

    public static MemoryAddress SetGlobalCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalCustomCreateThreadFn$VH.get(seg);
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalCustomCreateThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetGlobalCustomCreateThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalCustomCreateThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomCreateThreadFn SetGlobalCustomCreateThreadFn(
            MemorySegment segment, MemorySession session) {
        return SetGlobalCustomCreateThreadFn.ofAddress(SetGlobalCustomCreateThreadFn$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalCustomThreadCreationOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalCustomThreadCreationOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalCustomThreadCreationOptions$FUNC);

    public interface SetGlobalCustomThreadCreationOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SetGlobalCustomThreadCreationOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SetGlobalCustomThreadCreationOptions$FUNC,
                    session);
        }

        static SetGlobalCustomThreadCreationOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SetGlobalCustomThreadCreationOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalCustomThreadCreationOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalCustomThreadCreationOptions"));

    public static VarHandle SetGlobalCustomThreadCreationOptions$VH() {
        return OrtApi.SetGlobalCustomThreadCreationOptions$VH;
    }

    public static MemoryAddress SetGlobalCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalCustomThreadCreationOptions$VH.get(seg);
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalCustomThreadCreationOptions$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetGlobalCustomThreadCreationOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalCustomThreadCreationOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomThreadCreationOptions SetGlobalCustomThreadCreationOptions(
            MemorySegment segment, MemorySession session) {
        return SetGlobalCustomThreadCreationOptions.ofAddress(
                SetGlobalCustomThreadCreationOptions$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalCustomJoinThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalCustomJoinThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalCustomJoinThreadFn$FUNC);

    public interface SetGlobalCustomJoinThreadFn {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SetGlobalCustomJoinThreadFn fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomJoinThreadFn.class, fi, OrtApi.SetGlobalCustomJoinThreadFn$FUNC, session);
        }

        static SetGlobalCustomJoinThreadFn ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalCustomJoinThreadFn$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalCustomJoinThreadFn$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalCustomJoinThreadFn"));

    public static VarHandle SetGlobalCustomJoinThreadFn$VH() {
        return OrtApi.SetGlobalCustomJoinThreadFn$VH;
    }

    public static MemoryAddress SetGlobalCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalCustomJoinThreadFn$VH.get(seg);
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalCustomJoinThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetGlobalCustomJoinThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalCustomJoinThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomJoinThreadFn SetGlobalCustomJoinThreadFn(
            MemorySegment segment, MemorySession session) {
        return SetGlobalCustomJoinThreadFn.ofAddress(SetGlobalCustomJoinThreadFn$get(segment), session);
    }

    static final FunctionDescriptor SynchronizeBoundInputs$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SynchronizeBoundInputs$MH =
            RuntimeHelper.downcallHandle(OrtApi.SynchronizeBoundInputs$FUNC);

    public interface SynchronizeBoundInputs {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(SynchronizeBoundInputs fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundInputs.class, fi, OrtApi.SynchronizeBoundInputs$FUNC, session);
        }

        static SynchronizeBoundInputs ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SynchronizeBoundInputs$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SynchronizeBoundInputs$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SynchronizeBoundInputs"));

    public static VarHandle SynchronizeBoundInputs$VH() {
        return OrtApi.SynchronizeBoundInputs$VH;
    }

    public static MemoryAddress SynchronizeBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SynchronizeBoundInputs$VH.get(seg);
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SynchronizeBoundInputs$VH.set(seg, x);
    }

    public static MemoryAddress SynchronizeBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SynchronizeBoundInputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SynchronizeBoundInputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SynchronizeBoundInputs SynchronizeBoundInputs(MemorySegment segment, MemorySession session) {
        return SynchronizeBoundInputs.ofAddress(SynchronizeBoundInputs$get(segment), session);
    }

    static final FunctionDescriptor SynchronizeBoundOutputs$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SynchronizeBoundOutputs$MH =
            RuntimeHelper.downcallHandle(OrtApi.SynchronizeBoundOutputs$FUNC);

    public interface SynchronizeBoundOutputs {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(SynchronizeBoundOutputs fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundOutputs.class, fi, OrtApi.SynchronizeBoundOutputs$FUNC, session);
        }

        static SynchronizeBoundOutputs ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SynchronizeBoundOutputs$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SynchronizeBoundOutputs$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SynchronizeBoundOutputs"));

    public static VarHandle SynchronizeBoundOutputs$VH() {
        return OrtApi.SynchronizeBoundOutputs$VH;
    }

    public static MemoryAddress SynchronizeBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SynchronizeBoundOutputs$VH.get(seg);
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SynchronizeBoundOutputs$VH.set(seg, x);
    }

    public static MemoryAddress SynchronizeBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SynchronizeBoundOutputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SynchronizeBoundOutputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SynchronizeBoundOutputs SynchronizeBoundOutputs(MemorySegment segment, MemorySession session) {
        return SynchronizeBoundOutputs.ofAddress(SynchronizeBoundOutputs$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CUDA_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CUDA_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$FUNC);

    public interface SessionOptionsAppendExecutionProvider_CUDA_V2 {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA_V2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CUDA_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_CUDA_V2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_CUDA_V2$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_CUDA_V2"));

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA_V2$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA_V2 SessionOptionsAppendExecutionProvider_CUDA_V2(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_CUDA_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA_V2$get(segment), session);
    }

    static final FunctionDescriptor CreateCUDAProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCUDAProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateCUDAProviderOptions$FUNC);

    public interface CreateCUDAProviderOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateCUDAProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateCUDAProviderOptions.class, fi, OrtApi.CreateCUDAProviderOptions$FUNC, session);
        }

        static CreateCUDAProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateCUDAProviderOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateCUDAProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateCUDAProviderOptions"));

    public static VarHandle CreateCUDAProviderOptions$VH() {
        return OrtApi.CreateCUDAProviderOptions$VH;
    }

    public static MemoryAddress CreateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCUDAProviderOptions$VH.get(seg);
    }

    public static void CreateCUDAProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateCUDAProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCUDAProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCUDAProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateCUDAProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCUDAProviderOptions CreateCUDAProviderOptions(MemorySegment segment, MemorySession session) {
        return CreateCUDAProviderOptions.ofAddress(CreateCUDAProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor UpdateCUDAProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateCUDAProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateCUDAProviderOptions$FUNC);

    public interface UpdateCUDAProviderOptions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(UpdateCUDAProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateCUDAProviderOptions.class, fi, OrtApi.UpdateCUDAProviderOptions$FUNC, session);
        }

        static UpdateCUDAProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateCUDAProviderOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateCUDAProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateCUDAProviderOptions"));

    public static VarHandle UpdateCUDAProviderOptions$VH() {
        return OrtApi.UpdateCUDAProviderOptions$VH;
    }

    public static MemoryAddress UpdateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateCUDAProviderOptions$VH.get(seg);
    }

    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateCUDAProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress UpdateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateCUDAProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateCUDAProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateCUDAProviderOptions UpdateCUDAProviderOptions(MemorySegment segment, MemorySession session) {
        return UpdateCUDAProviderOptions.ofAddress(UpdateCUDAProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor GetCUDAProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCUDAProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCUDAProviderOptionsAsString$FUNC);

    public interface GetCUDAProviderOptionsAsString {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetCUDAProviderOptionsAsString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetCUDAProviderOptionsAsString.class, fi, OrtApi.GetCUDAProviderOptionsAsString$FUNC, session);
        }

        static GetCUDAProviderOptionsAsString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetCUDAProviderOptionsAsString$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetCUDAProviderOptionsAsString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetCUDAProviderOptionsAsString"));

    public static VarHandle GetCUDAProviderOptionsAsString$VH() {
        return OrtApi.GetCUDAProviderOptionsAsString$VH;
    }

    public static MemoryAddress GetCUDAProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetCUDAProviderOptionsAsString$VH.get(seg);
    }

    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetCUDAProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemoryAddress GetCUDAProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetCUDAProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetCUDAProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCUDAProviderOptionsAsString GetCUDAProviderOptionsAsString(
            MemorySegment segment, MemorySession session) {
        return GetCUDAProviderOptionsAsString.ofAddress(GetCUDAProviderOptionsAsString$get(segment), session);
    }

    static final FunctionDescriptor ReleaseCUDAProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseCUDAProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseCUDAProviderOptions$FUNC);

    public interface ReleaseCUDAProviderOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseCUDAProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseCUDAProviderOptions.class, fi, OrtApi.ReleaseCUDAProviderOptions$FUNC, session);
        }

        static ReleaseCUDAProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseCUDAProviderOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseCUDAProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseCUDAProviderOptions"));

    public static VarHandle ReleaseCUDAProviderOptions$VH() {
        return OrtApi.ReleaseCUDAProviderOptions$VH;
    }

    public static MemoryAddress ReleaseCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseCUDAProviderOptions$VH.get(seg);
    }

    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseCUDAProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleaseCUDAProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseCUDAProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCUDAProviderOptions ReleaseCUDAProviderOptions(MemorySegment segment, MemorySession session) {
        return ReleaseCUDAProviderOptions.ofAddress(ReleaseCUDAProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_MIGraphX$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_MIGraphX$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$FUNC);

    public interface SessionOptionsAppendExecutionProvider_MIGraphX {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_MIGraphX fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_MIGraphX.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_MIGraphX ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_MIGraphX$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_MIGraphX"));

    public static VarHandle SessionOptionsAppendExecutionProvider_MIGraphX$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_MIGraphX SessionOptionsAppendExecutionProvider_MIGraphX(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_MIGraphX.ofAddress(
                SessionOptionsAppendExecutionProvider_MIGraphX$get(segment), session);
    }

    static final FunctionDescriptor AddExternalInitializers$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle AddExternalInitializers$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddExternalInitializers$FUNC);

    public interface AddExternalInitializers {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(AddExternalInitializers fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    AddExternalInitializers.class, fi, OrtApi.AddExternalInitializers$FUNC, session);
        }

        static AddExternalInitializers ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.AddExternalInitializers$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddExternalInitializers$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("AddExternalInitializers"));

    public static VarHandle AddExternalInitializers$VH() {
        return OrtApi.AddExternalInitializers$VH;
    }

    public static MemoryAddress AddExternalInitializers$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddExternalInitializers$VH.get(seg);
    }

    public static void AddExternalInitializers$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddExternalInitializers$VH.set(seg, x);
    }

    public static MemoryAddress AddExternalInitializers$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.AddExternalInitializers$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddExternalInitializers$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddExternalInitializers$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddExternalInitializers AddExternalInitializers(MemorySegment segment, MemorySession session) {
        return AddExternalInitializers.ofAddress(AddExternalInitializers$get(segment), session);
    }

    static final FunctionDescriptor CreateOpAttr$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateOpAttr$MH = RuntimeHelper.downcallHandle(OrtApi.CreateOpAttr$FUNC);

    public interface CreateOpAttr {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                int _x2,
                int _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(CreateOpAttr fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateOpAttr.class, fi, OrtApi.CreateOpAttr$FUNC, session);
        }

        static CreateOpAttr ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    int __x2,
                    int __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateOpAttr$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateOpAttr$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateOpAttr"));

    public static VarHandle CreateOpAttr$VH() {
        return OrtApi.CreateOpAttr$VH;
    }

    public static MemoryAddress CreateOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateOpAttr$VH.get(seg);
    }

    public static void CreateOpAttr$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateOpAttr$VH.set(seg, x);
    }

    public static MemoryAddress CreateOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateOpAttr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOpAttr$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateOpAttr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOpAttr CreateOpAttr(MemorySegment segment, MemorySession session) {
        return CreateOpAttr.ofAddress(CreateOpAttr$get(segment), session);
    }

    static final FunctionDescriptor ReleaseOpAttr$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseOpAttr$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseOpAttr$FUNC);

    public interface ReleaseOpAttr {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseOpAttr fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseOpAttr.class, fi, OrtApi.ReleaseOpAttr$FUNC, session);
        }

        static ReleaseOpAttr ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseOpAttr$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseOpAttr$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseOpAttr"));

    public static VarHandle ReleaseOpAttr$VH() {
        return OrtApi.ReleaseOpAttr$VH;
    }

    public static MemoryAddress ReleaseOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseOpAttr$VH.get(seg);
    }

    public static void ReleaseOpAttr$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseOpAttr$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseOpAttr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseOpAttr$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseOpAttr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseOpAttr ReleaseOpAttr(MemorySegment segment, MemorySession session) {
        return ReleaseOpAttr.ofAddress(ReleaseOpAttr$get(segment), session);
    }

    static final FunctionDescriptor CreateOp$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateOp$MH = RuntimeHelper.downcallHandle(OrtApi.CreateOp$FUNC);

    public interface CreateOp {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                int _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5,
                int _x6,
                java.lang.foreign.MemoryAddress _x7,
                int _x8,
                int _x9,
                int _x10,
                java.lang.foreign.MemoryAddress _x11);

        static MemorySegment allocate(CreateOp fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateOp.class, fi, OrtApi.CreateOp$FUNC, session);
        }

        static CreateOp ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    int __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    int __x6,
                    java.lang.foreign.MemoryAddress __x7,
                    int __x8,
                    int __x9,
                    int __x10,
                    java.lang.foreign.MemoryAddress __x11) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateOp$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5,
                                    __x6,
                                    (java.lang.foreign.Addressable) __x7,
                                    __x8,
                                    __x9,
                                    __x10,
                                    (java.lang.foreign.Addressable) __x11);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateOp$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateOp"));

    public static VarHandle CreateOp$VH() {
        return OrtApi.CreateOp$VH;
    }

    public static MemoryAddress CreateOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateOp$VH.get(seg);
    }

    public static void CreateOp$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateOp$VH.set(seg, x);
    }

    public static MemoryAddress CreateOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateOp$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOp$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateOp$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOp CreateOp(MemorySegment segment, MemorySession session) {
        return CreateOp.ofAddress(CreateOp$get(segment), session);
    }

    static final FunctionDescriptor InvokeOp$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT);
    static final MethodHandle InvokeOp$MH = RuntimeHelper.downcallHandle(OrtApi.InvokeOp$FUNC);

    public interface InvokeOp {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                int _x3,
                java.lang.foreign.MemoryAddress _x4,
                int _x5);

        static MemorySegment allocate(InvokeOp fi, MemorySession session) {
            return RuntimeHelper.upcallStub(InvokeOp.class, fi, OrtApi.InvokeOp$FUNC, session);
        }

        static InvokeOp ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    int __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    int __x5) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.InvokeOp$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle InvokeOp$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("InvokeOp"));

    public static VarHandle InvokeOp$VH() {
        return OrtApi.InvokeOp$VH;
    }

    public static MemoryAddress InvokeOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.InvokeOp$VH.get(seg);
    }

    public static void InvokeOp$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.InvokeOp$VH.set(seg, x);
    }

    public static MemoryAddress InvokeOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.InvokeOp$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void InvokeOp$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.InvokeOp$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static InvokeOp InvokeOp(MemorySegment segment, MemorySession session) {
        return InvokeOp.ofAddress(InvokeOp$get(segment), session);
    }

    static final FunctionDescriptor ReleaseOp$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseOp$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseOp$FUNC);

    public interface ReleaseOp {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseOp fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseOp.class, fi, OrtApi.ReleaseOp$FUNC, session);
        }

        static ReleaseOp ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseOp$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseOp$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseOp"));

    public static VarHandle ReleaseOp$VH() {
        return OrtApi.ReleaseOp$VH;
    }

    public static MemoryAddress ReleaseOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseOp$VH.get(seg);
    }

    public static void ReleaseOp$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseOp$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseOp$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseOp$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseOp$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseOp ReleaseOp(MemorySegment segment, MemorySession session) {
        return ReleaseOp.ofAddress(ReleaseOp$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider$FUNC);

    public interface SessionOptionsAppendExecutionProvider {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider"));

    public static VarHandle SessionOptionsAppendExecutionProvider$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider SessionOptionsAppendExecutionProvider(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider.ofAddress(
                SessionOptionsAppendExecutionProvider$get(segment), session);
    }

    static final FunctionDescriptor CopyKernelInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CopyKernelInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CopyKernelInfo$FUNC);

    public interface CopyKernelInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CopyKernelInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CopyKernelInfo.class, fi, OrtApi.CopyKernelInfo$FUNC, session);
        }

        static CopyKernelInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CopyKernelInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CopyKernelInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CopyKernelInfo"));

    public static VarHandle CopyKernelInfo$VH() {
        return OrtApi.CopyKernelInfo$VH;
    }

    public static MemoryAddress CopyKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CopyKernelInfo$VH.get(seg);
    }

    public static void CopyKernelInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CopyKernelInfo$VH.set(seg, x);
    }

    public static MemoryAddress CopyKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CopyKernelInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CopyKernelInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CopyKernelInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CopyKernelInfo CopyKernelInfo(MemorySegment segment, MemorySession session) {
        return CopyKernelInfo.ofAddress(CopyKernelInfo$get(segment), session);
    }

    static final FunctionDescriptor ReleaseKernelInfo$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseKernelInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseKernelInfo$FUNC);

    public interface ReleaseKernelInfo {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseKernelInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReleaseKernelInfo.class, fi, OrtApi.ReleaseKernelInfo$FUNC, session);
        }

        static ReleaseKernelInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseKernelInfo$MH.invokeExact((Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseKernelInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseKernelInfo"));

    public static VarHandle ReleaseKernelInfo$VH() {
        return OrtApi.ReleaseKernelInfo$VH;
    }

    public static MemoryAddress ReleaseKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseKernelInfo$VH.get(seg);
    }

    public static void ReleaseKernelInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseKernelInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseKernelInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseKernelInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseKernelInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseKernelInfo ReleaseKernelInfo(MemorySegment segment, MemorySession session) {
        return ReleaseKernelInfo.ofAddress(ReleaseKernelInfo$get(segment), session);
    }

    static final FunctionDescriptor GetTrainingApi$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle GetTrainingApi$MH = RuntimeHelper.downcallHandle(OrtApi.GetTrainingApi$FUNC);

    public interface GetTrainingApi {

        java.lang.foreign.Addressable apply(int _x0);

        static MemorySegment allocate(GetTrainingApi fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetTrainingApi.class, fi, OrtApi.GetTrainingApi$FUNC, session);
        }

        static GetTrainingApi ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.GetTrainingApi$MH.invokeExact((Addressable) symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTrainingApi$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTrainingApi"));

    public static VarHandle GetTrainingApi$VH() {
        return OrtApi.GetTrainingApi$VH;
    }

    public static MemoryAddress GetTrainingApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTrainingApi$VH.get(seg);
    }

    public static void GetTrainingApi$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTrainingApi$VH.set(seg, x);
    }

    public static MemoryAddress GetTrainingApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTrainingApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTrainingApi$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTrainingApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTrainingApi GetTrainingApi(MemorySegment segment, MemorySession session) {
        return GetTrainingApi.ofAddress(GetTrainingApi$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CANN$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CANN$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_CANN$FUNC);

    public interface SessionOptionsAppendExecutionProvider_CANN {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CANN fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CANN.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CANN$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_CANN ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_CANN$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_CANN$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_CANN"));

    public static VarHandle SessionOptionsAppendExecutionProvider_CANN$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CANN SessionOptionsAppendExecutionProvider_CANN(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_CANN.ofAddress(
                SessionOptionsAppendExecutionProvider_CANN$get(segment), session);
    }

    static final FunctionDescriptor CreateCANNProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCANNProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateCANNProviderOptions$FUNC);

    public interface CreateCANNProviderOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateCANNProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateCANNProviderOptions.class, fi, OrtApi.CreateCANNProviderOptions$FUNC, session);
        }

        static CreateCANNProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateCANNProviderOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateCANNProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateCANNProviderOptions"));

    public static VarHandle CreateCANNProviderOptions$VH() {
        return OrtApi.CreateCANNProviderOptions$VH;
    }

    public static MemoryAddress CreateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCANNProviderOptions$VH.get(seg);
    }

    public static void CreateCANNProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateCANNProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateCANNProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCANNProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateCANNProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCANNProviderOptions CreateCANNProviderOptions(MemorySegment segment, MemorySession session) {
        return CreateCANNProviderOptions.ofAddress(CreateCANNProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor UpdateCANNProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateCANNProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateCANNProviderOptions$FUNC);

    public interface UpdateCANNProviderOptions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(UpdateCANNProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateCANNProviderOptions.class, fi, OrtApi.UpdateCANNProviderOptions$FUNC, session);
        }

        static UpdateCANNProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateCANNProviderOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateCANNProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateCANNProviderOptions"));

    public static VarHandle UpdateCANNProviderOptions$VH() {
        return OrtApi.UpdateCANNProviderOptions$VH;
    }

    public static MemoryAddress UpdateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateCANNProviderOptions$VH.get(seg);
    }

    public static void UpdateCANNProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateCANNProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress UpdateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateCANNProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateCANNProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateCANNProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateCANNProviderOptions UpdateCANNProviderOptions(MemorySegment segment, MemorySession session) {
        return UpdateCANNProviderOptions.ofAddress(UpdateCANNProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor GetCANNProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCANNProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCANNProviderOptionsAsString$FUNC);

    public interface GetCANNProviderOptionsAsString {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetCANNProviderOptionsAsString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetCANNProviderOptionsAsString.class, fi, OrtApi.GetCANNProviderOptionsAsString$FUNC, session);
        }

        static GetCANNProviderOptionsAsString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetCANNProviderOptionsAsString$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetCANNProviderOptionsAsString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetCANNProviderOptionsAsString"));

    public static VarHandle GetCANNProviderOptionsAsString$VH() {
        return OrtApi.GetCANNProviderOptionsAsString$VH;
    }

    public static MemoryAddress GetCANNProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetCANNProviderOptionsAsString$VH.get(seg);
    }

    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetCANNProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemoryAddress GetCANNProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetCANNProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetCANNProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCANNProviderOptionsAsString GetCANNProviderOptionsAsString(
            MemorySegment segment, MemorySession session) {
        return GetCANNProviderOptionsAsString.ofAddress(GetCANNProviderOptionsAsString$get(segment), session);
    }

    static final FunctionDescriptor ReleaseCANNProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseCANNProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseCANNProviderOptions$FUNC);

    public interface ReleaseCANNProviderOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseCANNProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseCANNProviderOptions.class, fi, OrtApi.ReleaseCANNProviderOptions$FUNC, session);
        }

        static ReleaseCANNProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseCANNProviderOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseCANNProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseCANNProviderOptions"));

    public static VarHandle ReleaseCANNProviderOptions$VH() {
        return OrtApi.ReleaseCANNProviderOptions$VH;
    }

    public static MemoryAddress ReleaseCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseCANNProviderOptions$VH.get(seg);
    }

    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseCANNProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleaseCANNProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseCANNProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCANNProviderOptions ReleaseCANNProviderOptions(MemorySegment segment, MemorySession session) {
        return ReleaseCANNProviderOptions.ofAddress(ReleaseCANNProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor MemoryInfoGetDeviceType$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetDeviceType$MH =
            RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetDeviceType$FUNC);

    public interface MemoryInfoGetDeviceType {

        void apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(MemoryInfoGetDeviceType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetDeviceType.class, fi, OrtApi.MemoryInfoGetDeviceType$FUNC, session);
        }

        static MemoryInfoGetDeviceType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    OrtApi.MemoryInfoGetDeviceType$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, (java.lang.foreign.Addressable)
                                    __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetDeviceType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("MemoryInfoGetDeviceType"));

    public static VarHandle MemoryInfoGetDeviceType$VH() {
        return OrtApi.MemoryInfoGetDeviceType$VH;
    }

    public static MemoryAddress MemoryInfoGetDeviceType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetDeviceType$VH.get(seg);
    }

    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetDeviceType$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetDeviceType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.MemoryInfoGetDeviceType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetDeviceType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetDeviceType MemoryInfoGetDeviceType(MemorySegment segment, MemorySession session) {
        return MemoryInfoGetDeviceType.ofAddress(MemoryInfoGetDeviceType$get(segment), session);
    }

    static final FunctionDescriptor UpdateEnvWithCustomLogLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle UpdateEnvWithCustomLogLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateEnvWithCustomLogLevel$FUNC);

    public interface UpdateEnvWithCustomLogLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, int _x1);

        static MemorySegment allocate(UpdateEnvWithCustomLogLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateEnvWithCustomLogLevel.class, fi, OrtApi.UpdateEnvWithCustomLogLevel$FUNC, session);
        }

        static UpdateEnvWithCustomLogLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateEnvWithCustomLogLevel$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateEnvWithCustomLogLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateEnvWithCustomLogLevel"));

    public static VarHandle UpdateEnvWithCustomLogLevel$VH() {
        return OrtApi.UpdateEnvWithCustomLogLevel$VH;
    }

    public static MemoryAddress UpdateEnvWithCustomLogLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateEnvWithCustomLogLevel$VH.get(seg);
    }

    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateEnvWithCustomLogLevel$VH.set(seg, x);
    }

    public static MemoryAddress UpdateEnvWithCustomLogLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.UpdateEnvWithCustomLogLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateEnvWithCustomLogLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateEnvWithCustomLogLevel UpdateEnvWithCustomLogLevel(
            MemorySegment segment, MemorySession session) {
        return UpdateEnvWithCustomLogLevel.ofAddress(UpdateEnvWithCustomLogLevel$get(segment), session);
    }

    static final FunctionDescriptor SetGlobalIntraOpThreadAffinity$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalIntraOpThreadAffinity$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalIntraOpThreadAffinity$FUNC);

    public interface SetGlobalIntraOpThreadAffinity {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SetGlobalIntraOpThreadAffinity fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetGlobalIntraOpThreadAffinity.class, fi, OrtApi.SetGlobalIntraOpThreadAffinity$FUNC, session);
        }

        static SetGlobalIntraOpThreadAffinity ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalIntraOpThreadAffinity$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalIntraOpThreadAffinity$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalIntraOpThreadAffinity"));

    public static VarHandle SetGlobalIntraOpThreadAffinity$VH() {
        return OrtApi.SetGlobalIntraOpThreadAffinity$VH;
    }

    public static MemoryAddress SetGlobalIntraOpThreadAffinity$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetGlobalIntraOpThreadAffinity$VH.get(seg);
    }

    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalIntraOpThreadAffinity$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalIntraOpThreadAffinity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SetGlobalIntraOpThreadAffinity$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalIntraOpThreadAffinity$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalIntraOpThreadAffinity SetGlobalIntraOpThreadAffinity(
            MemorySegment segment, MemorySession session) {
        return SetGlobalIntraOpThreadAffinity.ofAddress(SetGlobalIntraOpThreadAffinity$get(segment), session);
    }

    static final FunctionDescriptor RegisterCustomOpsLibrary_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsLibrary_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.RegisterCustomOpsLibrary_V2$FUNC);

    public interface RegisterCustomOpsLibrary_V2 {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RegisterCustomOpsLibrary_V2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsLibrary_V2.class, fi, OrtApi.RegisterCustomOpsLibrary_V2$FUNC, session);
        }

        static RegisterCustomOpsLibrary_V2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsLibrary_V2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RegisterCustomOpsLibrary_V2$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RegisterCustomOpsLibrary_V2"));

    public static VarHandle RegisterCustomOpsLibrary_V2$VH() {
        return OrtApi.RegisterCustomOpsLibrary_V2$VH;
    }

    public static MemoryAddress RegisterCustomOpsLibrary_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsLibrary_V2$VH.get(seg);
    }

    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RegisterCustomOpsLibrary_V2$VH.set(seg, x);
    }

    public static MemoryAddress RegisterCustomOpsLibrary_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.RegisterCustomOpsLibrary_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RegisterCustomOpsLibrary_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsLibrary_V2 RegisterCustomOpsLibrary_V2(
            MemorySegment segment, MemorySession session) {
        return RegisterCustomOpsLibrary_V2.ofAddress(RegisterCustomOpsLibrary_V2$get(segment), session);
    }

    static final FunctionDescriptor RegisterCustomOpsUsingFunction$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsUsingFunction$MH =
            RuntimeHelper.downcallHandle(OrtApi.RegisterCustomOpsUsingFunction$FUNC);

    public interface RegisterCustomOpsUsingFunction {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(RegisterCustomOpsUsingFunction fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsUsingFunction.class, fi, OrtApi.RegisterCustomOpsUsingFunction$FUNC, session);
        }

        static RegisterCustomOpsUsingFunction ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsUsingFunction$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RegisterCustomOpsUsingFunction$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RegisterCustomOpsUsingFunction"));

    public static VarHandle RegisterCustomOpsUsingFunction$VH() {
        return OrtApi.RegisterCustomOpsUsingFunction$VH;
    }

    public static MemoryAddress RegisterCustomOpsUsingFunction$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RegisterCustomOpsUsingFunction$VH.get(seg);
    }

    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RegisterCustomOpsUsingFunction$VH.set(seg, x);
    }

    public static MemoryAddress RegisterCustomOpsUsingFunction$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.RegisterCustomOpsUsingFunction$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RegisterCustomOpsUsingFunction$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsUsingFunction RegisterCustomOpsUsingFunction(
            MemorySegment segment, MemorySession session) {
        return RegisterCustomOpsUsingFunction.ofAddress(RegisterCustomOpsUsingFunction$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetInputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetInputCount$FUNC);

    public interface KernelInfo_GetInputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelInfo_GetInputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetInputCount.class, fi, OrtApi.KernelInfo_GetInputCount$FUNC, session);
        }

        static KernelInfo_GetInputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetInputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputCount"));

    public static VarHandle KernelInfo_GetInputCount$VH() {
        return OrtApi.KernelInfo_GetInputCount$VH;
    }

    public static MemoryAddress KernelInfo_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputCount$VH.get(seg);
    }

    public static void KernelInfo_GetInputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetInputCount$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetInputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetInputCount KernelInfo_GetInputCount(MemorySegment segment, MemorySession session) {
        return KernelInfo_GetInputCount.ofAddress(KernelInfo_GetInputCount$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetOutputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetOutputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetOutputCount$FUNC);

    public interface KernelInfo_GetOutputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelInfo_GetOutputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetOutputCount.class, fi, OrtApi.KernelInfo_GetOutputCount$FUNC, session);
        }

        static KernelInfo_GetOutputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetOutputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetOutputCount"));

    public static VarHandle KernelInfo_GetOutputCount$VH() {
        return OrtApi.KernelInfo_GetOutputCount$VH;
    }

    public static MemoryAddress KernelInfo_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputCount$VH.get(seg);
    }

    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetOutputCount$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetOutputCount KernelInfo_GetOutputCount(MemorySegment segment, MemorySession session) {
        return KernelInfo_GetOutputCount.ofAddress(KernelInfo_GetOutputCount$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetInputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetInputName$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetInputName$FUNC);

    public interface KernelInfo_GetInputName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfo_GetInputName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetInputName.class, fi, OrtApi.KernelInfo_GetInputName$FUNC, session);
        }

        static KernelInfo_GetInputName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetInputName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputName"));

    public static VarHandle KernelInfo_GetInputName$VH() {
        return OrtApi.KernelInfo_GetInputName$VH;
    }

    public static MemoryAddress KernelInfo_GetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputName$VH.get(seg);
    }

    public static void KernelInfo_GetInputName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetInputName$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetInputName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetInputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetInputName KernelInfo_GetInputName(MemorySegment segment, MemorySession session) {
        return KernelInfo_GetInputName.ofAddress(KernelInfo_GetInputName$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetOutputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetOutputName$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetOutputName$FUNC);

    public interface KernelInfo_GetOutputName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfo_GetOutputName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetOutputName.class, fi, OrtApi.KernelInfo_GetOutputName$FUNC, session);
        }

        static KernelInfo_GetOutputName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetOutputName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetOutputName"));

    public static VarHandle KernelInfo_GetOutputName$VH() {
        return OrtApi.KernelInfo_GetOutputName$VH;
    }

    public static MemoryAddress KernelInfo_GetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputName$VH.get(seg);
    }

    public static void KernelInfo_GetOutputName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetOutputName$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetOutputName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetOutputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetOutputName KernelInfo_GetOutputName(MemorySegment segment, MemorySession session) {
        return KernelInfo_GetOutputName.ofAddress(KernelInfo_GetOutputName$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetInputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetInputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetInputTypeInfo$FUNC);

    public interface KernelInfo_GetInputTypeInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelInfo_GetInputTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetInputTypeInfo.class, fi, OrtApi.KernelInfo_GetInputTypeInfo$FUNC, session);
        }

        static KernelInfo_GetInputTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetInputTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputTypeInfo"));

    public static VarHandle KernelInfo_GetInputTypeInfo$VH() {
        return OrtApi.KernelInfo_GetInputTypeInfo$VH;
    }

    public static MemoryAddress KernelInfo_GetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetInputTypeInfo$VH.get(seg);
    }

    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetInputTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfo_GetInputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetInputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetInputTypeInfo KernelInfo_GetInputTypeInfo(
            MemorySegment segment, MemorySession session) {
        return KernelInfo_GetInputTypeInfo.ofAddress(KernelInfo_GetInputTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetOutputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetOutputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetOutputTypeInfo$FUNC);

    public interface KernelInfo_GetOutputTypeInfo {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelInfo_GetOutputTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetOutputTypeInfo.class, fi, OrtApi.KernelInfo_GetOutputTypeInfo$FUNC, session);
        }

        static KernelInfo_GetOutputTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetOutputTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetOutputTypeInfo"));

    public static VarHandle KernelInfo_GetOutputTypeInfo$VH() {
        return OrtApi.KernelInfo_GetOutputTypeInfo$VH;
    }

    public static MemoryAddress KernelInfo_GetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetOutputTypeInfo$VH.get(seg);
    }

    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetOutputTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfo_GetOutputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetOutputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetOutputTypeInfo KernelInfo_GetOutputTypeInfo(
            MemorySegment segment, MemorySession session) {
        return KernelInfo_GetOutputTypeInfo.ofAddress(KernelInfo_GetOutputTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_tensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_tensor$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_tensor$FUNC);

    public interface KernelInfoGetAttribute_tensor {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfoGetAttribute_tensor fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_tensor.class, fi, OrtApi.KernelInfoGetAttribute_tensor$FUNC, session);
        }

        static KernelInfoGetAttribute_tensor ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_tensor$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_tensor$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_tensor"));

    public static VarHandle KernelInfoGetAttribute_tensor$VH() {
        return OrtApi.KernelInfoGetAttribute_tensor$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_tensor$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_tensor$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_tensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_tensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_tensor KernelInfoGetAttribute_tensor(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetAttribute_tensor.ofAddress(KernelInfoGetAttribute_tensor$get(segment), session);
    }

    static final FunctionDescriptor HasSessionConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle HasSessionConfigEntry$MH =
            RuntimeHelper.downcallHandle(OrtApi.HasSessionConfigEntry$FUNC);

    public interface HasSessionConfigEntry {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(HasSessionConfigEntry fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    HasSessionConfigEntry.class, fi, OrtApi.HasSessionConfigEntry$FUNC, session);
        }

        static HasSessionConfigEntry ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.HasSessionConfigEntry$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle HasSessionConfigEntry$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("HasSessionConfigEntry"));

    public static VarHandle HasSessionConfigEntry$VH() {
        return OrtApi.HasSessionConfigEntry$VH;
    }

    public static MemoryAddress HasSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.HasSessionConfigEntry$VH.get(seg);
    }

    public static void HasSessionConfigEntry$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.HasSessionConfigEntry$VH.set(seg, x);
    }

    public static MemoryAddress HasSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.HasSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void HasSessionConfigEntry$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.HasSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static HasSessionConfigEntry HasSessionConfigEntry(MemorySegment segment, MemorySession session) {
        return HasSessionConfigEntry.ofAddress(HasSessionConfigEntry$get(segment), session);
    }

    static final FunctionDescriptor GetSessionConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSessionConfigEntry$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSessionConfigEntry$FUNC);

    public interface GetSessionConfigEntry {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(GetSessionConfigEntry fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetSessionConfigEntry.class, fi, OrtApi.GetSessionConfigEntry$FUNC, session);
        }

        static GetSessionConfigEntry ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetSessionConfigEntry$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSessionConfigEntry$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetSessionConfigEntry"));

    public static VarHandle GetSessionConfigEntry$VH() {
        return OrtApi.GetSessionConfigEntry$VH;
    }

    public static MemoryAddress GetSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSessionConfigEntry$VH.get(seg);
    }

    public static void GetSessionConfigEntry$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSessionConfigEntry$VH.set(seg, x);
    }

    public static MemoryAddress GetSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSessionConfigEntry$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSessionConfigEntry GetSessionConfigEntry(MemorySegment segment, MemorySession session) {
        return GetSessionConfigEntry.ofAddress(GetSessionConfigEntry$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_Dnnl$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_Dnnl$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$FUNC);

    public interface SessionOptionsAppendExecutionProvider_Dnnl {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_Dnnl fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_Dnnl.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_Dnnl ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_Dnnl$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_Dnnl"));

    public static VarHandle SessionOptionsAppendExecutionProvider_Dnnl$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_Dnnl$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_Dnnl$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_Dnnl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_Dnnl$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_Dnnl$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_Dnnl SessionOptionsAppendExecutionProvider_Dnnl(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_Dnnl.ofAddress(
                SessionOptionsAppendExecutionProvider_Dnnl$get(segment), session);
    }

    static final FunctionDescriptor CreateDnnlProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateDnnlProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateDnnlProviderOptions$FUNC);

    public interface CreateDnnlProviderOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateDnnlProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateDnnlProviderOptions.class, fi, OrtApi.CreateDnnlProviderOptions$FUNC, session);
        }

        static CreateDnnlProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateDnnlProviderOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateDnnlProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateDnnlProviderOptions"));

    public static VarHandle CreateDnnlProviderOptions$VH() {
        return OrtApi.CreateDnnlProviderOptions$VH;
    }

    public static MemoryAddress CreateDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateDnnlProviderOptions$VH.get(seg);
    }

    public static void CreateDnnlProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateDnnlProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateDnnlProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateDnnlProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateDnnlProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateDnnlProviderOptions CreateDnnlProviderOptions(MemorySegment segment, MemorySession session) {
        return CreateDnnlProviderOptions.ofAddress(CreateDnnlProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor UpdateDnnlProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateDnnlProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateDnnlProviderOptions$FUNC);

    public interface UpdateDnnlProviderOptions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(UpdateDnnlProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateDnnlProviderOptions.class, fi, OrtApi.UpdateDnnlProviderOptions$FUNC, session);
        }

        static UpdateDnnlProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateDnnlProviderOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateDnnlProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateDnnlProviderOptions"));

    public static VarHandle UpdateDnnlProviderOptions$VH() {
        return OrtApi.UpdateDnnlProviderOptions$VH;
    }

    public static MemoryAddress UpdateDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateDnnlProviderOptions$VH.get(seg);
    }

    public static void UpdateDnnlProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateDnnlProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress UpdateDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateDnnlProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateDnnlProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateDnnlProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateDnnlProviderOptions UpdateDnnlProviderOptions(MemorySegment segment, MemorySession session) {
        return UpdateDnnlProviderOptions.ofAddress(UpdateDnnlProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor GetDnnlProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetDnnlProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetDnnlProviderOptionsAsString$FUNC);

    public interface GetDnnlProviderOptionsAsString {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetDnnlProviderOptionsAsString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetDnnlProviderOptionsAsString.class, fi, OrtApi.GetDnnlProviderOptionsAsString$FUNC, session);
        }

        static GetDnnlProviderOptionsAsString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetDnnlProviderOptionsAsString$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDnnlProviderOptionsAsString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetDnnlProviderOptionsAsString"));

    public static VarHandle GetDnnlProviderOptionsAsString$VH() {
        return OrtApi.GetDnnlProviderOptionsAsString$VH;
    }

    public static MemoryAddress GetDnnlProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetDnnlProviderOptionsAsString$VH.get(seg);
    }

    public static void GetDnnlProviderOptionsAsString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDnnlProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemoryAddress GetDnnlProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetDnnlProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDnnlProviderOptionsAsString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDnnlProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDnnlProviderOptionsAsString GetDnnlProviderOptionsAsString(
            MemorySegment segment, MemorySession session) {
        return GetDnnlProviderOptionsAsString.ofAddress(GetDnnlProviderOptionsAsString$get(segment), session);
    }

    static final FunctionDescriptor ReleaseDnnlProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseDnnlProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseDnnlProviderOptions$FUNC);

    public interface ReleaseDnnlProviderOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseDnnlProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseDnnlProviderOptions.class, fi, OrtApi.ReleaseDnnlProviderOptions$FUNC, session);
        }

        static ReleaseDnnlProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseDnnlProviderOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseDnnlProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseDnnlProviderOptions"));

    public static VarHandle ReleaseDnnlProviderOptions$VH() {
        return OrtApi.ReleaseDnnlProviderOptions$VH;
    }

    public static MemoryAddress ReleaseDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseDnnlProviderOptions$VH.get(seg);
    }

    public static void ReleaseDnnlProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseDnnlProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleaseDnnlProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseDnnlProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseDnnlProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseDnnlProviderOptions ReleaseDnnlProviderOptions(MemorySegment segment, MemorySession session) {
        return ReleaseDnnlProviderOptions.ofAddress(ReleaseDnnlProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetNodeName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetNodeName$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetNodeName$FUNC);

    public interface KernelInfo_GetNodeName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelInfo_GetNodeName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetNodeName.class, fi, OrtApi.KernelInfo_GetNodeName$FUNC, session);
        }

        static KernelInfo_GetNodeName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetNodeName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetNodeName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetNodeName"));

    public static VarHandle KernelInfo_GetNodeName$VH() {
        return OrtApi.KernelInfo_GetNodeName$VH;
    }

    public static MemoryAddress KernelInfo_GetNodeName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetNodeName$VH.get(seg);
    }

    public static void KernelInfo_GetNodeName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetNodeName$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetNodeName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetNodeName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetNodeName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetNodeName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetNodeName KernelInfo_GetNodeName(MemorySegment segment, MemorySession session) {
        return KernelInfo_GetNodeName.ofAddress(KernelInfo_GetNodeName$get(segment), session);
    }

    static final FunctionDescriptor KernelInfo_GetLogger$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetLogger$MH = RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetLogger$FUNC);

    public interface KernelInfo_GetLogger {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelInfo_GetLogger fi, MemorySession session) {
            return RuntimeHelper.upcallStub(KernelInfo_GetLogger.class, fi, OrtApi.KernelInfo_GetLogger$FUNC, session);
        }

        static KernelInfo_GetLogger ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetLogger$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfo_GetLogger$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetLogger"));

    public static VarHandle KernelInfo_GetLogger$VH() {
        return OrtApi.KernelInfo_GetLogger$VH;
    }

    public static MemoryAddress KernelInfo_GetLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetLogger$VH.get(seg);
    }

    public static void KernelInfo_GetLogger$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfo_GetLogger$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfo_GetLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfo_GetLogger$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetLogger$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfo_GetLogger$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetLogger KernelInfo_GetLogger(MemorySegment segment, MemorySession session) {
        return KernelInfo_GetLogger.ofAddress(KernelInfo_GetLogger$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetLogger$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetLogger$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetLogger$FUNC);

    public interface KernelContext_GetLogger {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelContext_GetLogger fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetLogger.class, fi, OrtApi.KernelContext_GetLogger$FUNC, session);
        }

        static KernelContext_GetLogger ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetLogger$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetLogger$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetLogger"));

    public static VarHandle KernelContext_GetLogger$VH() {
        return OrtApi.KernelContext_GetLogger$VH;
    }

    public static MemoryAddress KernelContext_GetLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetLogger$VH.get(seg);
    }

    public static void KernelContext_GetLogger$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetLogger$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetLogger$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetLogger$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetLogger$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetLogger KernelContext_GetLogger(MemorySegment segment, MemorySession session) {
        return KernelContext_GetLogger.ofAddress(KernelContext_GetLogger$get(segment), session);
    }

    static final FunctionDescriptor Logger_LogMessage$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Logger_LogMessage$MH = RuntimeHelper.downcallHandle(OrtApi.Logger_LogMessage$FUNC);

    public interface Logger_LogMessage {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                int _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                int _x4,
                java.lang.foreign.MemoryAddress _x5);

        static MemorySegment allocate(Logger_LogMessage fi, MemorySession session) {
            return RuntimeHelper.upcallStub(Logger_LogMessage.class, fi, OrtApi.Logger_LogMessage$FUNC, session);
        }

        static Logger_LogMessage ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    int __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    int __x4,
                    java.lang.foreign.MemoryAddress __x5) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.Logger_LogMessage$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4,
                                    (java.lang.foreign.Addressable) __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Logger_LogMessage$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Logger_LogMessage"));

    public static VarHandle Logger_LogMessage$VH() {
        return OrtApi.Logger_LogMessage$VH;
    }

    public static MemoryAddress Logger_LogMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.Logger_LogMessage$VH.get(seg);
    }

    public static void Logger_LogMessage$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.Logger_LogMessage$VH.set(seg, x);
    }

    public static MemoryAddress Logger_LogMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.Logger_LogMessage$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Logger_LogMessage$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.Logger_LogMessage$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Logger_LogMessage Logger_LogMessage(MemorySegment segment, MemorySession session) {
        return Logger_LogMessage.ofAddress(Logger_LogMessage$get(segment), session);
    }

    static final FunctionDescriptor Logger_GetLoggingSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle Logger_GetLoggingSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.Logger_GetLoggingSeverityLevel$FUNC);

    public interface Logger_GetLoggingSeverityLevel {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(Logger_GetLoggingSeverityLevel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    Logger_GetLoggingSeverityLevel.class, fi, OrtApi.Logger_GetLoggingSeverityLevel$FUNC, session);
        }

        static Logger_GetLoggingSeverityLevel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.Logger_GetLoggingSeverityLevel$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Logger_GetLoggingSeverityLevel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("Logger_GetLoggingSeverityLevel"));

    public static VarHandle Logger_GetLoggingSeverityLevel$VH() {
        return OrtApi.Logger_GetLoggingSeverityLevel$VH;
    }

    public static MemoryAddress Logger_GetLoggingSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.Logger_GetLoggingSeverityLevel$VH.get(seg);
    }

    public static void Logger_GetLoggingSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.Logger_GetLoggingSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress Logger_GetLoggingSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.Logger_GetLoggingSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Logger_GetLoggingSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.Logger_GetLoggingSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Logger_GetLoggingSeverityLevel Logger_GetLoggingSeverityLevel(
            MemorySegment segment, MemorySession session) {
        return Logger_GetLoggingSeverityLevel.ofAddress(Logger_GetLoggingSeverityLevel$get(segment), session);
    }

    static final FunctionDescriptor KernelInfoGetConstantInput_tensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetConstantInput_tensor$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetConstantInput_tensor$FUNC);

    public interface KernelInfoGetConstantInput_tensor {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                long _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelInfoGetConstantInput_tensor fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetConstantInput_tensor.class,
                    fi,
                    OrtApi.KernelInfoGetConstantInput_tensor$FUNC,
                    session);
        }

        static KernelInfoGetConstantInput_tensor ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetConstantInput_tensor$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetConstantInput_tensor$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetConstantInput_tensor"));

    public static VarHandle KernelInfoGetConstantInput_tensor$VH() {
        return OrtApi.KernelInfoGetConstantInput_tensor$VH;
    }

    public static MemoryAddress KernelInfoGetConstantInput_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelInfoGetConstantInput_tensor$VH.get(seg);
    }

    public static void KernelInfoGetConstantInput_tensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetConstantInput_tensor$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetConstantInput_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelInfoGetConstantInput_tensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetConstantInput_tensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetConstantInput_tensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetConstantInput_tensor KernelInfoGetConstantInput_tensor(
            MemorySegment segment, MemorySession session) {
        return KernelInfoGetConstantInput_tensor.ofAddress(KernelInfoGetConstantInput_tensor$get(segment), session);
    }

    static final FunctionDescriptor CastTypeInfoToOptionalTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToOptionalTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToOptionalTypeInfo$FUNC);

    public interface CastTypeInfoToOptionalTypeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(CastTypeInfoToOptionalTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToOptionalTypeInfo.class, fi, OrtApi.CastTypeInfoToOptionalTypeInfo$FUNC, session);
        }

        static CastTypeInfoToOptionalTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToOptionalTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToOptionalTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CastTypeInfoToOptionalTypeInfo"));

    public static VarHandle CastTypeInfoToOptionalTypeInfo$VH() {
        return OrtApi.CastTypeInfoToOptionalTypeInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToOptionalTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CastTypeInfoToOptionalTypeInfo$VH.get(seg);
    }

    public static void CastTypeInfoToOptionalTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToOptionalTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToOptionalTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CastTypeInfoToOptionalTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToOptionalTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToOptionalTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToOptionalTypeInfo CastTypeInfoToOptionalTypeInfo(
            MemorySegment segment, MemorySession session) {
        return CastTypeInfoToOptionalTypeInfo.ofAddress(CastTypeInfoToOptionalTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor GetOptionalContainedTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetOptionalContainedTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetOptionalContainedTypeInfo$FUNC);

    public interface GetOptionalContainedTypeInfo {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(GetOptionalContainedTypeInfo fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetOptionalContainedTypeInfo.class, fi, OrtApi.GetOptionalContainedTypeInfo$FUNC, session);
        }

        static GetOptionalContainedTypeInfo ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetOptionalContainedTypeInfo$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOptionalContainedTypeInfo$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetOptionalContainedTypeInfo"));

    public static VarHandle GetOptionalContainedTypeInfo$VH() {
        return OrtApi.GetOptionalContainedTypeInfo$VH;
    }

    public static MemoryAddress GetOptionalContainedTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetOptionalContainedTypeInfo$VH.get(seg);
    }

    public static void GetOptionalContainedTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetOptionalContainedTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetOptionalContainedTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetOptionalContainedTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOptionalContainedTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetOptionalContainedTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOptionalContainedTypeInfo GetOptionalContainedTypeInfo(
            MemorySegment segment, MemorySession session) {
        return GetOptionalContainedTypeInfo.ofAddress(GetOptionalContainedTypeInfo$get(segment), session);
    }

    static final FunctionDescriptor GetResizedStringTensorElementBuffer$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetResizedStringTensorElementBuffer$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetResizedStringTensorElementBuffer$FUNC);

    public interface GetResizedStringTensorElementBuffer {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, long _x2, java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(GetResizedStringTensorElementBuffer fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetResizedStringTensorElementBuffer.class,
                    fi,
                    OrtApi.GetResizedStringTensorElementBuffer$FUNC,
                    session);
        }

        static GetResizedStringTensorElementBuffer ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetResizedStringTensorElementBuffer$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetResizedStringTensorElementBuffer$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetResizedStringTensorElementBuffer"));

    public static VarHandle GetResizedStringTensorElementBuffer$VH() {
        return OrtApi.GetResizedStringTensorElementBuffer$VH;
    }

    public static MemoryAddress GetResizedStringTensorElementBuffer$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetResizedStringTensorElementBuffer$VH.get(seg);
    }

    public static void GetResizedStringTensorElementBuffer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetResizedStringTensorElementBuffer$VH.set(seg, x);
    }

    public static MemoryAddress GetResizedStringTensorElementBuffer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetResizedStringTensorElementBuffer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetResizedStringTensorElementBuffer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetResizedStringTensorElementBuffer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetResizedStringTensorElementBuffer GetResizedStringTensorElementBuffer(
            MemorySegment segment, MemorySession session) {
        return GetResizedStringTensorElementBuffer.ofAddress(GetResizedStringTensorElementBuffer$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetAllocator$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetAllocator$FUNC);

    public interface KernelContext_GetAllocator {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(KernelContext_GetAllocator fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetAllocator.class, fi, OrtApi.KernelContext_GetAllocator$FUNC, session);
        }

        static KernelContext_GetAllocator ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetAllocator$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetAllocator$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetAllocator"));

    public static VarHandle KernelContext_GetAllocator$VH() {
        return OrtApi.KernelContext_GetAllocator$VH;
    }

    public static MemoryAddress KernelContext_GetAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetAllocator$VH.get(seg);
    }

    public static void KernelContext_GetAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetAllocator$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.KernelContext_GetAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetAllocator KernelContext_GetAllocator(MemorySegment segment, MemorySession session) {
        return KernelContext_GetAllocator.ofAddress(KernelContext_GetAllocator$get(segment), session);
    }

    static final FunctionDescriptor GetBuildInfoString$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetBuildInfoString$MH = RuntimeHelper.downcallHandle(OrtApi.GetBuildInfoString$FUNC);

    public interface GetBuildInfoString {

        java.lang.foreign.Addressable apply();

        static MemorySegment allocate(GetBuildInfoString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetBuildInfoString.class, fi, OrtApi.GetBuildInfoString$FUNC, session);
        }

        static GetBuildInfoString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return () -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.GetBuildInfoString$MH.invokeExact((Addressable) symbol);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetBuildInfoString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetBuildInfoString"));

    public static VarHandle GetBuildInfoString$VH() {
        return OrtApi.GetBuildInfoString$VH;
    }

    public static MemoryAddress GetBuildInfoString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetBuildInfoString$VH.get(seg);
    }

    public static void GetBuildInfoString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetBuildInfoString$VH.set(seg, x);
    }

    public static MemoryAddress GetBuildInfoString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetBuildInfoString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBuildInfoString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetBuildInfoString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBuildInfoString GetBuildInfoString(MemorySegment segment, MemorySession session) {
        return GetBuildInfoString.ofAddress(GetBuildInfoString$get(segment), session);
    }

    static final FunctionDescriptor CreateROCMProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateROCMProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateROCMProviderOptions$FUNC);

    public interface CreateROCMProviderOptions {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(CreateROCMProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateROCMProviderOptions.class, fi, OrtApi.CreateROCMProviderOptions$FUNC, session);
        }

        static CreateROCMProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateROCMProviderOptions$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateROCMProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateROCMProviderOptions"));

    public static VarHandle CreateROCMProviderOptions$VH() {
        return OrtApi.CreateROCMProviderOptions$VH;
    }

    public static MemoryAddress CreateROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateROCMProviderOptions$VH.get(seg);
    }

    public static void CreateROCMProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateROCMProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateROCMProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateROCMProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateROCMProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateROCMProviderOptions CreateROCMProviderOptions(MemorySegment segment, MemorySession session) {
        return CreateROCMProviderOptions.ofAddress(CreateROCMProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor UpdateROCMProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateROCMProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateROCMProviderOptions$FUNC);

    public interface UpdateROCMProviderOptions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(UpdateROCMProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateROCMProviderOptions.class, fi, OrtApi.UpdateROCMProviderOptions$FUNC, session);
        }

        static UpdateROCMProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateROCMProviderOptions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateROCMProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateROCMProviderOptions"));

    public static VarHandle UpdateROCMProviderOptions$VH() {
        return OrtApi.UpdateROCMProviderOptions$VH;
    }

    public static MemoryAddress UpdateROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateROCMProviderOptions$VH.get(seg);
    }

    public static void UpdateROCMProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateROCMProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress UpdateROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateROCMProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateROCMProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateROCMProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateROCMProviderOptions UpdateROCMProviderOptions(MemorySegment segment, MemorySession session) {
        return UpdateROCMProviderOptions.ofAddress(UpdateROCMProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor GetROCMProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetROCMProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetROCMProviderOptionsAsString$FUNC);

    public interface GetROCMProviderOptionsAsString {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetROCMProviderOptionsAsString fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetROCMProviderOptionsAsString.class, fi, OrtApi.GetROCMProviderOptionsAsString$FUNC, session);
        }

        static GetROCMProviderOptionsAsString ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetROCMProviderOptionsAsString$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetROCMProviderOptionsAsString$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetROCMProviderOptionsAsString"));

    public static VarHandle GetROCMProviderOptionsAsString$VH() {
        return OrtApi.GetROCMProviderOptionsAsString$VH;
    }

    public static MemoryAddress GetROCMProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetROCMProviderOptionsAsString$VH.get(seg);
    }

    public static void GetROCMProviderOptionsAsString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetROCMProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemoryAddress GetROCMProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetROCMProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetROCMProviderOptionsAsString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetROCMProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetROCMProviderOptionsAsString GetROCMProviderOptionsAsString(
            MemorySegment segment, MemorySession session) {
        return GetROCMProviderOptionsAsString.ofAddress(GetROCMProviderOptionsAsString$get(segment), session);
    }

    static final FunctionDescriptor ReleaseROCMProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseROCMProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseROCMProviderOptions$FUNC);

    public interface ReleaseROCMProviderOptions {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(ReleaseROCMProviderOptions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ReleaseROCMProviderOptions.class, fi, OrtApi.ReleaseROCMProviderOptions$FUNC, session);
        }

        static ReleaseROCMProviderOptions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtApi.ReleaseROCMProviderOptions$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseROCMProviderOptions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReleaseROCMProviderOptions"));

    public static VarHandle ReleaseROCMProviderOptions$VH() {
        return OrtApi.ReleaseROCMProviderOptions$VH;
    }

    public static MemoryAddress ReleaseROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReleaseROCMProviderOptions$VH.get(seg);
    }

    public static void ReleaseROCMProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseROCMProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ReleaseROCMProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseROCMProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseROCMProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseROCMProviderOptions ReleaseROCMProviderOptions(MemorySegment segment, MemorySession session) {
        return ReleaseROCMProviderOptions.ofAddress(ReleaseROCMProviderOptions$get(segment), session);
    }

    static final FunctionDescriptor CreateAndRegisterAllocatorV2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle CreateAndRegisterAllocatorV2$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateAndRegisterAllocatorV2$FUNC);

    public interface CreateAndRegisterAllocatorV2 {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                java.lang.foreign.MemoryAddress _x4,
                java.lang.foreign.MemoryAddress _x5,
                long _x6);

        static MemorySegment allocate(CreateAndRegisterAllocatorV2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    CreateAndRegisterAllocatorV2.class, fi, OrtApi.CreateAndRegisterAllocatorV2$FUNC, session);
        }

        static CreateAndRegisterAllocatorV2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    java.lang.foreign.MemoryAddress __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    long __x6) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.CreateAndRegisterAllocatorV2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    (java.lang.foreign.Addressable) __x4,
                                    (java.lang.foreign.Addressable) __x5,
                                    __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateAndRegisterAllocatorV2$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateAndRegisterAllocatorV2"));

    public static VarHandle CreateAndRegisterAllocatorV2$VH() {
        return OrtApi.CreateAndRegisterAllocatorV2$VH;
    }

    public static MemoryAddress CreateAndRegisterAllocatorV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.CreateAndRegisterAllocatorV2$VH.get(seg);
    }

    public static void CreateAndRegisterAllocatorV2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateAndRegisterAllocatorV2$VH.set(seg, x);
    }

    public static MemoryAddress CreateAndRegisterAllocatorV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.CreateAndRegisterAllocatorV2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAndRegisterAllocatorV2$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateAndRegisterAllocatorV2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAndRegisterAllocatorV2 CreateAndRegisterAllocatorV2(
            MemorySegment segment, MemorySession session) {
        return CreateAndRegisterAllocatorV2.ofAddress(CreateAndRegisterAllocatorV2$get(segment), session);
    }

    static final FunctionDescriptor RunAsync$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunAsync$MH = RuntimeHelper.downcallHandle(OrtApi.RunAsync$FUNC);

    public interface RunAsync {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3,
                long _x4,
                java.lang.foreign.MemoryAddress _x5,
                long _x6,
                java.lang.foreign.MemoryAddress _x7,
                java.lang.foreign.MemoryAddress _x8,
                java.lang.foreign.MemoryAddress _x9);

        static MemorySegment allocate(RunAsync fi, MemorySession session) {
            return RuntimeHelper.upcallStub(RunAsync.class, fi, OrtApi.RunAsync$FUNC, session);
        }

        static RunAsync ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3,
                    long __x4,
                    java.lang.foreign.MemoryAddress __x5,
                    long __x6,
                    java.lang.foreign.MemoryAddress __x7,
                    java.lang.foreign.MemoryAddress __x8,
                    java.lang.foreign.MemoryAddress __x9) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.RunAsync$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3,
                                    __x4,
                                    (java.lang.foreign.Addressable) __x5,
                                    __x6,
                                    (java.lang.foreign.Addressable) __x7,
                                    (java.lang.foreign.Addressable) __x8,
                                    (java.lang.foreign.Addressable) __x9);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunAsync$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("RunAsync"));

    public static VarHandle RunAsync$VH() {
        return OrtApi.RunAsync$VH;
    }

    public static MemoryAddress RunAsync$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunAsync$VH.get(seg);
    }

    public static void RunAsync$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunAsync$VH.set(seg, x);
    }

    public static MemoryAddress RunAsync$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.RunAsync$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunAsync$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunAsync$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunAsync RunAsync(MemorySegment segment, MemorySession session) {
        return RunAsync.ofAddress(RunAsync$get(segment), session);
    }

    static final FunctionDescriptor UpdateTensorRTProviderOptionsWithValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle UpdateTensorRTProviderOptionsWithValue$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateTensorRTProviderOptionsWithValue$FUNC);

    public interface UpdateTensorRTProviderOptionsWithValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(UpdateTensorRTProviderOptionsWithValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateTensorRTProviderOptionsWithValue.class,
                    fi,
                    OrtApi.UpdateTensorRTProviderOptionsWithValue$FUNC,
                    session);
        }

        static UpdateTensorRTProviderOptionsWithValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.UpdateTensorRTProviderOptionsWithValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateTensorRTProviderOptionsWithValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateTensorRTProviderOptionsWithValue"));

    public static VarHandle UpdateTensorRTProviderOptionsWithValue$VH() {
        return OrtApi.UpdateTensorRTProviderOptionsWithValue$VH;
    }

    public static MemoryAddress UpdateTensorRTProviderOptionsWithValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateTensorRTProviderOptionsWithValue$VH.get(seg);
    }

    public static void UpdateTensorRTProviderOptionsWithValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateTensorRTProviderOptionsWithValue$VH.set(seg, x);
    }

    public static MemoryAddress UpdateTensorRTProviderOptionsWithValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.UpdateTensorRTProviderOptionsWithValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateTensorRTProviderOptionsWithValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateTensorRTProviderOptionsWithValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateTensorRTProviderOptionsWithValue UpdateTensorRTProviderOptionsWithValue(
            MemorySegment segment, MemorySession session) {
        return UpdateTensorRTProviderOptionsWithValue.ofAddress(
                UpdateTensorRTProviderOptionsWithValue$get(segment), session);
    }

    static final FunctionDescriptor GetTensorRTProviderOptionsByName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorRTProviderOptionsByName$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorRTProviderOptionsByName$FUNC);

    public interface GetTensorRTProviderOptionsByName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetTensorRTProviderOptionsByName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetTensorRTProviderOptionsByName.class, fi, OrtApi.GetTensorRTProviderOptionsByName$FUNC, session);
        }

        static GetTensorRTProviderOptionsByName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetTensorRTProviderOptionsByName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorRTProviderOptionsByName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetTensorRTProviderOptionsByName"));

    public static VarHandle GetTensorRTProviderOptionsByName$VH() {
        return OrtApi.GetTensorRTProviderOptionsByName$VH;
    }

    public static MemoryAddress GetTensorRTProviderOptionsByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetTensorRTProviderOptionsByName$VH.get(seg);
    }

    public static void GetTensorRTProviderOptionsByName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorRTProviderOptionsByName$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorRTProviderOptionsByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetTensorRTProviderOptionsByName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorRTProviderOptionsByName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorRTProviderOptionsByName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorRTProviderOptionsByName GetTensorRTProviderOptionsByName(
            MemorySegment segment, MemorySession session) {
        return GetTensorRTProviderOptionsByName.ofAddress(GetTensorRTProviderOptionsByName$get(segment), session);
    }

    static final FunctionDescriptor UpdateCUDAProviderOptionsWithValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle UpdateCUDAProviderOptionsWithValue$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateCUDAProviderOptionsWithValue$FUNC);

    public interface UpdateCUDAProviderOptionsWithValue {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(UpdateCUDAProviderOptionsWithValue fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    UpdateCUDAProviderOptionsWithValue.class,
                    fi,
                    OrtApi.UpdateCUDAProviderOptionsWithValue$FUNC,
                    session);
        }

        static UpdateCUDAProviderOptionsWithValue ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.UpdateCUDAProviderOptionsWithValue$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateCUDAProviderOptionsWithValue$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("UpdateCUDAProviderOptionsWithValue"));

    public static VarHandle UpdateCUDAProviderOptionsWithValue$VH() {
        return OrtApi.UpdateCUDAProviderOptionsWithValue$VH;
    }

    public static MemoryAddress UpdateCUDAProviderOptionsWithValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.UpdateCUDAProviderOptionsWithValue$VH.get(seg);
    }

    public static void UpdateCUDAProviderOptionsWithValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateCUDAProviderOptionsWithValue$VH.set(seg, x);
    }

    public static MemoryAddress UpdateCUDAProviderOptionsWithValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.UpdateCUDAProviderOptionsWithValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateCUDAProviderOptionsWithValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateCUDAProviderOptionsWithValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateCUDAProviderOptionsWithValue UpdateCUDAProviderOptionsWithValue(
            MemorySegment segment, MemorySession session) {
        return UpdateCUDAProviderOptionsWithValue.ofAddress(UpdateCUDAProviderOptionsWithValue$get(segment), session);
    }

    static final FunctionDescriptor GetCUDAProviderOptionsByName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCUDAProviderOptionsByName$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCUDAProviderOptionsByName$FUNC);

    public interface GetCUDAProviderOptionsByName {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(GetCUDAProviderOptionsByName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetCUDAProviderOptionsByName.class, fi, OrtApi.GetCUDAProviderOptionsByName$FUNC, session);
        }

        static GetCUDAProviderOptionsByName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.GetCUDAProviderOptionsByName$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetCUDAProviderOptionsByName$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetCUDAProviderOptionsByName"));

    public static VarHandle GetCUDAProviderOptionsByName$VH() {
        return OrtApi.GetCUDAProviderOptionsByName$VH;
    }

    public static MemoryAddress GetCUDAProviderOptionsByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.GetCUDAProviderOptionsByName$VH.get(seg);
    }

    public static void GetCUDAProviderOptionsByName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetCUDAProviderOptionsByName$VH.set(seg, x);
    }

    public static MemoryAddress GetCUDAProviderOptionsByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.GetCUDAProviderOptionsByName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCUDAProviderOptionsByName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetCUDAProviderOptionsByName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCUDAProviderOptionsByName GetCUDAProviderOptionsByName(
            MemorySegment segment, MemorySession session) {
        return GetCUDAProviderOptionsByName.ofAddress(GetCUDAProviderOptionsByName$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_GetResource$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetResource$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetResource$FUNC);

    public interface KernelContext_GetResource {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, int _x1, int _x2, java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(KernelContext_GetResource fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetResource.class, fi, OrtApi.KernelContext_GetResource$FUNC, session);
        }

        static KernelContext_GetResource ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, int __x1, int __x2, java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetResource$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetResource$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetResource"));

    public static VarHandle KernelContext_GetResource$VH() {
        return OrtApi.KernelContext_GetResource$VH;
    }

    public static MemoryAddress KernelContext_GetResource$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetResource$VH.get(seg);
    }

    public static void KernelContext_GetResource$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetResource$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetResource$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_GetResource$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetResource$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetResource$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetResource KernelContext_GetResource(MemorySegment segment, MemorySession session) {
        return KernelContext_GetResource.ofAddress(KernelContext_GetResource$get(segment), session);
    }

    static final FunctionDescriptor SetUserLoggingFunction$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetUserLoggingFunction$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetUserLoggingFunction$FUNC);

    public interface SetUserLoggingFunction {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(SetUserLoggingFunction fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetUserLoggingFunction.class, fi, OrtApi.SetUserLoggingFunction$FUNC, session);
        }

        static SetUserLoggingFunction ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetUserLoggingFunction$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetUserLoggingFunction$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetUserLoggingFunction"));

    public static VarHandle SetUserLoggingFunction$VH() {
        return OrtApi.SetUserLoggingFunction$VH;
    }

    public static MemoryAddress SetUserLoggingFunction$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetUserLoggingFunction$VH.get(seg);
    }

    public static void SetUserLoggingFunction$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetUserLoggingFunction$VH.set(seg, x);
    }

    public static MemoryAddress SetUserLoggingFunction$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetUserLoggingFunction$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetUserLoggingFunction$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetUserLoggingFunction$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetUserLoggingFunction SetUserLoggingFunction(MemorySegment segment, MemorySession session) {
        return SetUserLoggingFunction.ofAddress(SetUserLoggingFunction$get(segment), session);
    }

    static final FunctionDescriptor ShapeInferContext_GetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ShapeInferContext_GetInputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.ShapeInferContext_GetInputCount$FUNC);

    public interface ShapeInferContext_GetInputCount {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(ShapeInferContext_GetInputCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ShapeInferContext_GetInputCount.class, fi, OrtApi.ShapeInferContext_GetInputCount$FUNC, session);
        }

        static ShapeInferContext_GetInputCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_GetInputCount$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ShapeInferContext_GetInputCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ShapeInferContext_GetInputCount"));

    public static VarHandle ShapeInferContext_GetInputCount$VH() {
        return OrtApi.ShapeInferContext_GetInputCount$VH;
    }

    public static MemoryAddress ShapeInferContext_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_GetInputCount$VH.get(seg);
    }

    public static void ShapeInferContext_GetInputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ShapeInferContext_GetInputCount$VH.set(seg, x);
    }

    public static MemoryAddress ShapeInferContext_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ShapeInferContext_GetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ShapeInferContext_GetInputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ShapeInferContext_GetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ShapeInferContext_GetInputCount ShapeInferContext_GetInputCount(
            MemorySegment segment, MemorySession session) {
        return ShapeInferContext_GetInputCount.ofAddress(ShapeInferContext_GetInputCount$get(segment), session);
    }

    static final FunctionDescriptor ShapeInferContext_GetInputTypeShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ShapeInferContext_GetInputTypeShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.ShapeInferContext_GetInputTypeShape$FUNC);

    public interface ShapeInferContext_GetInputTypeShape {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ShapeInferContext_GetInputTypeShape fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ShapeInferContext_GetInputTypeShape.class,
                    fi,
                    OrtApi.ShapeInferContext_GetInputTypeShape$FUNC,
                    session);
        }

        static ShapeInferContext_GetInputTypeShape ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_GetInputTypeShape$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ShapeInferContext_GetInputTypeShape$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ShapeInferContext_GetInputTypeShape"));

    public static VarHandle ShapeInferContext_GetInputTypeShape$VH() {
        return OrtApi.ShapeInferContext_GetInputTypeShape$VH;
    }

    public static MemoryAddress ShapeInferContext_GetInputTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_GetInputTypeShape$VH.get(seg);
    }

    public static void ShapeInferContext_GetInputTypeShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ShapeInferContext_GetInputTypeShape$VH.set(seg, x);
    }

    public static MemoryAddress ShapeInferContext_GetInputTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ShapeInferContext_GetInputTypeShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ShapeInferContext_GetInputTypeShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ShapeInferContext_GetInputTypeShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ShapeInferContext_GetInputTypeShape ShapeInferContext_GetInputTypeShape(
            MemorySegment segment, MemorySession session) {
        return ShapeInferContext_GetInputTypeShape.ofAddress(ShapeInferContext_GetInputTypeShape$get(segment), session);
    }

    static final FunctionDescriptor ShapeInferContext_GetAttribute$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ShapeInferContext_GetAttribute$MH =
            RuntimeHelper.downcallHandle(OrtApi.ShapeInferContext_GetAttribute$FUNC);

    public interface ShapeInferContext_GetAttribute {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ShapeInferContext_GetAttribute fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ShapeInferContext_GetAttribute.class, fi, OrtApi.ShapeInferContext_GetAttribute$FUNC, session);
        }

        static ShapeInferContext_GetAttribute ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_GetAttribute$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ShapeInferContext_GetAttribute$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ShapeInferContext_GetAttribute"));

    public static VarHandle ShapeInferContext_GetAttribute$VH() {
        return OrtApi.ShapeInferContext_GetAttribute$VH;
    }

    public static MemoryAddress ShapeInferContext_GetAttribute$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_GetAttribute$VH.get(seg);
    }

    public static void ShapeInferContext_GetAttribute$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ShapeInferContext_GetAttribute$VH.set(seg, x);
    }

    public static MemoryAddress ShapeInferContext_GetAttribute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ShapeInferContext_GetAttribute$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ShapeInferContext_GetAttribute$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ShapeInferContext_GetAttribute$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ShapeInferContext_GetAttribute ShapeInferContext_GetAttribute(
            MemorySegment segment, MemorySession session) {
        return ShapeInferContext_GetAttribute.ofAddress(ShapeInferContext_GetAttribute$get(segment), session);
    }

    static final FunctionDescriptor ShapeInferContext_SetOutputTypeShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ShapeInferContext_SetOutputTypeShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.ShapeInferContext_SetOutputTypeShape$FUNC);

    public interface ShapeInferContext_SetOutputTypeShape {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, long _x1, java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(ShapeInferContext_SetOutputTypeShape fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    ShapeInferContext_SetOutputTypeShape.class,
                    fi,
                    OrtApi.ShapeInferContext_SetOutputTypeShape$FUNC,
                    session);
        }

        static ShapeInferContext_SetOutputTypeShape ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1, java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.ShapeInferContext_SetOutputTypeShape$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ShapeInferContext_SetOutputTypeShape$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ShapeInferContext_SetOutputTypeShape"));

    public static VarHandle ShapeInferContext_SetOutputTypeShape$VH() {
        return OrtApi.ShapeInferContext_SetOutputTypeShape$VH;
    }

    public static MemoryAddress ShapeInferContext_SetOutputTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ShapeInferContext_SetOutputTypeShape$VH.get(seg);
    }

    public static void ShapeInferContext_SetOutputTypeShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ShapeInferContext_SetOutputTypeShape$VH.set(seg, x);
    }

    public static MemoryAddress ShapeInferContext_SetOutputTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.ShapeInferContext_SetOutputTypeShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ShapeInferContext_SetOutputTypeShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ShapeInferContext_SetOutputTypeShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ShapeInferContext_SetOutputTypeShape ShapeInferContext_SetOutputTypeShape(
            MemorySegment segment, MemorySession session) {
        return ShapeInferContext_SetOutputTypeShape.ofAddress(
                ShapeInferContext_SetOutputTypeShape$get(segment), session);
    }

    static final FunctionDescriptor SetSymbolicDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle SetSymbolicDimensions$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSymbolicDimensions$FUNC);

    public interface SetSymbolicDimensions {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1, long _x2);

        static MemorySegment allocate(SetSymbolicDimensions fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetSymbolicDimensions.class, fi, OrtApi.SetSymbolicDimensions$FUNC, session);
        }

        static SetSymbolicDimensions ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetSymbolicDimensions$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSymbolicDimensions$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetSymbolicDimensions"));

    public static VarHandle SetSymbolicDimensions$VH() {
        return OrtApi.SetSymbolicDimensions$VH;
    }

    public static MemoryAddress SetSymbolicDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSymbolicDimensions$VH.get(seg);
    }

    public static void SetSymbolicDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSymbolicDimensions$VH.set(seg, x);
    }

    public static MemoryAddress SetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetSymbolicDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSymbolicDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSymbolicDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSymbolicDimensions SetSymbolicDimensions(MemorySegment segment, MemorySession session) {
        return SetSymbolicDimensions.ofAddress(SetSymbolicDimensions$get(segment), session);
    }

    static final FunctionDescriptor ReadOpAttr$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReadOpAttr$MH = RuntimeHelper.downcallHandle(OrtApi.ReadOpAttr$FUNC);

    public interface ReadOpAttr {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                int _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(ReadOpAttr fi, MemorySession session) {
            return RuntimeHelper.upcallStub(ReadOpAttr.class, fi, OrtApi.ReadOpAttr$FUNC, session);
        }

        static ReadOpAttr ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    int __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.ReadOpAttr$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReadOpAttr$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("ReadOpAttr"));

    public static VarHandle ReadOpAttr$VH() {
        return OrtApi.ReadOpAttr$VH;
    }

    public static MemoryAddress ReadOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReadOpAttr$VH.get(seg);
    }

    public static void ReadOpAttr$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReadOpAttr$VH.set(seg, x);
    }

    public static MemoryAddress ReadOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.ReadOpAttr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReadOpAttr$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReadOpAttr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReadOpAttr ReadOpAttr(MemorySegment segment, MemorySession session) {
        return ReadOpAttr.ofAddress(ReadOpAttr$get(segment), session);
    }

    static final FunctionDescriptor SetDeterministicCompute$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_BOOL$LAYOUT);
    static final MethodHandle SetDeterministicCompute$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetDeterministicCompute$FUNC);

    public interface SetDeterministicCompute {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, boolean _x1);

        static MemorySegment allocate(SetDeterministicCompute fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SetDeterministicCompute.class, fi, OrtApi.SetDeterministicCompute$FUNC, session);
        }

        static SetDeterministicCompute ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, boolean __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.SetDeterministicCompute$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetDeterministicCompute$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("SetDeterministicCompute"));

    public static VarHandle SetDeterministicCompute$VH() {
        return OrtApi.SetDeterministicCompute$VH;
    }

    public static MemoryAddress SetDeterministicCompute$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetDeterministicCompute$VH.get(seg);
    }

    public static void SetDeterministicCompute$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetDeterministicCompute$VH.set(seg, x);
    }

    public static MemoryAddress SetDeterministicCompute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SetDeterministicCompute$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetDeterministicCompute$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetDeterministicCompute$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetDeterministicCompute SetDeterministicCompute(MemorySegment segment, MemorySession session) {
        return SetDeterministicCompute.ofAddress(SetDeterministicCompute$get(segment), session);
    }

    static final FunctionDescriptor KernelContext_ParallelFor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_ParallelFor$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_ParallelFor$FUNC);

    public interface KernelContext_ParallelFor {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                long _x2,
                long _x3,
                java.lang.foreign.MemoryAddress _x4);

        static MemorySegment allocate(KernelContext_ParallelFor fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    KernelContext_ParallelFor.class, fi, OrtApi.KernelContext_ParallelFor$FUNC, session);
        }

        static KernelContext_ParallelFor ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    long __x2,
                    long __x3,
                    java.lang.foreign.MemoryAddress __x4) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_ParallelFor$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    __x2,
                                    __x3,
                                    (java.lang.foreign.Addressable) __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_ParallelFor$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_ParallelFor"));

    public static VarHandle KernelContext_ParallelFor$VH() {
        return OrtApi.KernelContext_ParallelFor$VH;
    }

    public static MemoryAddress KernelContext_ParallelFor$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_ParallelFor$VH.get(seg);
    }

    public static void KernelContext_ParallelFor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_ParallelFor$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_ParallelFor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtApi.KernelContext_ParallelFor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_ParallelFor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_ParallelFor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_ParallelFor KernelContext_ParallelFor(MemorySegment segment, MemorySession session) {
        return KernelContext_ParallelFor.ofAddress(KernelContext_ParallelFor$get(segment), session);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_OpenVINO_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_OpenVINO_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$FUNC);

    public interface SessionOptionsAppendExecutionProvider_OpenVINO_V2 {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                long _x3);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_OpenVINO_V2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_OpenVINO_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$FUNC,
                    session);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO_V2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.Addressable) (java.lang.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH = $struct$LAYOUT.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_OpenVINO_V2"));

    public static VarHandle SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_OpenVINO_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO_V2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_OpenVINO_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO_V2$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO_V2 SessionOptionsAppendExecutionProvider_OpenVINO_V2(
            MemorySegment segment, MemorySession session) {
        return SessionOptionsAppendExecutionProvider_OpenVINO_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO_V2$get(segment), session);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session);
    }
}
