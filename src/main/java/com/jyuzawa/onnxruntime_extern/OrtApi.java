/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtApi {
 *     OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
 *     OrtErrorCode (*GetErrorCode)(const OrtStatus*);
 *     char* (*GetErrorMessage)(const OrtStatus*);
 *     OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
 *     OrtStatusPtr (*CreateEnvWithCustomLogger)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,OrtEnv**);
 *     OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
 *     OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
 *     OrtStatusPtr (*CreateSession)(const OrtEnv*,char*,const OrtSessionOptions*,OrtSession**);
 *     OrtStatusPtr (*CreateSessionFromArray)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtSession**);
 *     OrtStatusPtr (*Run)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**);
 *     OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
 *     OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
 *     OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
 *     OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
 *     OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
 *     OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
 *     OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
 *     OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
 *     OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
 *     OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
 *     OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
 *     OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
 *     OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
 *     OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
 *     OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
 *     OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
 *     OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
 *     OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
 *     OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
 *     OrtStatusPtr (*RegisterCustomOpsLibrary)(OrtSessionOptions*,char*,void**);
 *     OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
 *     OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
 *     OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
 *     OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
 *     OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
 *     OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
 *     OrtStatusPtr (*SessionGetInputName)(const OrtSession*,size_t,OrtAllocator*,char**);
 *     OrtStatusPtr (*SessionGetOutputName)(const OrtSession*,size_t,OrtAllocator*,char**);
 *     OrtStatusPtr (*SessionGetOverridableInitializerName)(const OrtSession*,size_t,OrtAllocator*,char**);
 *     OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
 *     OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
 *     OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
 *     OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
 *     OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
 *     OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
 *     OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
 *     OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
 *     OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
 *     OrtStatusPtr (*CreateTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
 *     OrtStatusPtr (*CreateTensorWithDataAsOrtValue)(const OrtMemoryInfo*,void*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
 *     OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
 *     OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
 *     OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
 *     OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
 *     OrtStatusPtr (*GetStringTensorContent)(const OrtValue*,void*,size_t,size_t*,size_t);
 *     OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
 *     OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
 *     OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
 *     OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
 *     OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
 *     OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
 *     OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
 *     OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
 *     OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
 *     OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
 *     OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
 *     OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
 *     OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
 *     OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
 *     OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
 *     OrtStatusPtr (*CompareMemoryInfo)(const OrtMemoryInfo*,const OrtMemoryInfo*,int*);
 *     OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
 *     OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
 *     OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
 *     OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
 *     OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
 *     OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
 *     OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
 *     OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
 *     OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
 *     OrtStatusPtr (*GetValue)(const OrtValue*,int,OrtAllocator*,OrtValue**);
 *     OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
 *     OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
 *     OrtStatusPtr (*CreateOpaqueValue)(char*,char*,void*,size_t,OrtValue**);
 *     OrtStatusPtr (*GetOpaqueValue)(char*,char*,const OrtValue*,void*,size_t);
 *     OrtStatusPtr (*KernelInfoGetAttribute_float)(const OrtKernelInfo*,char*,float*);
 *     OrtStatusPtr (*KernelInfoGetAttribute_int64)(const OrtKernelInfo*,char*,int64_t*);
 *     OrtStatusPtr (*KernelInfoGetAttribute_string)(const OrtKernelInfo*,char*,char*,size_t*);
 *     OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
 *     OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
 *     OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
 *     OrtStatusPtr (*KernelContext_GetOutput)(OrtKernelContext*,size_t,const int64_t*,size_t,OrtValue**);
 *     void (*ReleaseEnv)(OrtEnv*);
 *     void (*ReleaseStatus)(OrtStatus*);
 *     void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
 *     void (*ReleaseSession)(OrtSession*);
 *     void (*ReleaseValue)(OrtValue*);
 *     void (*ReleaseRunOptions)(OrtRunOptions*);
 *     void (*ReleaseTypeInfo)(OrtTypeInfo*);
 *     void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
 *     void (*ReleaseSessionOptions)(OrtSessionOptions*);
 *     void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
 *     OrtStatusPtr (*GetDenotationFromTypeInfo)(const OrtTypeInfo*,char**,size_t*);
 *     OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
 *     OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
 *     OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
 *     OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
 *     OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
 *     void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
 *     void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
 *     OrtStatusPtr (*SessionEndProfiling)(OrtSession*,OrtAllocator*,char**);
 *     OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
 *     OrtStatusPtr (*ModelMetadataGetProducerName)(const OrtModelMetadata*,OrtAllocator*,char**);
 *     OrtStatusPtr (*ModelMetadataGetGraphName)(const OrtModelMetadata*,OrtAllocator*,char**);
 *     OrtStatusPtr (*ModelMetadataGetDomain)(const OrtModelMetadata*,OrtAllocator*,char**);
 *     OrtStatusPtr (*ModelMetadataGetDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
 *     OrtStatusPtr (*ModelMetadataLookupCustomMetadataMap)(const OrtModelMetadata*,OrtAllocator*,char*,char**);
 *     OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
 *     void (*ReleaseModelMetadata)(OrtModelMetadata*);
 *     OrtStatusPtr (*CreateEnvWithGlobalThreadPools)(OrtLoggingLevel,char*,const OrtThreadingOptions*,OrtEnv**);
 *     OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
 *     OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
 *     void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
 *     OrtStatusPtr (*ModelMetadataGetCustomMetadataMapKeys)(const OrtModelMetadata*,OrtAllocator*,char***,int64_t*);
 *     OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
 *     OrtStatusPtr (*GetAvailableProviders)(char***,int*);
 *     OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
 *     OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
 *     OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
 *     OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
 *     OrtStatusPtr (*AddSessionConfigEntry)(OrtSessionOptions*,char*,char*);
 *     OrtStatusPtr (*CreateAllocator)(const OrtSession*,const OrtMemoryInfo*,OrtAllocator**);
 *     void (*ReleaseAllocator)(OrtAllocator*);
 *     OrtStatusPtr (*RunWithBinding)(OrtSession*,const OrtRunOptions*,const OrtIoBinding*);
 *     OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
 *     void (*ReleaseIoBinding)(OrtIoBinding*);
 *     OrtStatusPtr (*BindInput)(OrtIoBinding*,char*,const OrtValue*);
 *     OrtStatusPtr (*BindOutput)(OrtIoBinding*,char*,const OrtValue*);
 *     OrtStatusPtr (*BindOutputToDevice)(OrtIoBinding*,char*,const OrtMemoryInfo*);
 *     OrtStatusPtr (*GetBoundOutputNames)(const OrtIoBinding*,OrtAllocator*,char**,size_t**,size_t*);
 *     OrtStatusPtr (*GetBoundOutputValues)(const OrtIoBinding*,OrtAllocator*,OrtValue***,size_t*);
 *     void (*ClearBoundInputs)(OrtIoBinding*);
 *     void (*ClearBoundOutputs)(OrtIoBinding*);
 *     OrtStatusPtr (*TensorAt)(OrtValue*,const int64_t*,size_t,void**);
 *     OrtStatusPtr (*CreateAndRegisterAllocator)(OrtEnv*,const OrtMemoryInfo*,const OrtArenaCfg*);
 *     OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
 *     OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
 *     OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
 *     OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
 *     OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
 *     OrtStatusPtr (*AddInitializer)(OrtSessionOptions*,char*,const OrtValue*);
 *     OrtStatusPtr (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,struct OrtThreadingOptions*,OrtEnv**);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
 *     OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
 *     OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
 *     void (*ReleaseArenaCfg)(OrtArenaCfg*);
 *     OrtStatusPtr (*ModelMetadataGetGraphDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
 *     OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
 *     OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
 *     OrtStatusPtr (*KernelInfoGetAttributeArray_float)(const OrtKernelInfo*,char*,float*,size_t*);
 *     OrtStatusPtr (*KernelInfoGetAttributeArray_int64)(const OrtKernelInfo*,char*,int64_t*,size_t*);
 *     OrtStatusPtr (*CreateArenaCfgV2)(char**,const size_t*,size_t,OrtArenaCfg**);
 *     OrtStatusPtr (*AddRunConfigEntry)(OrtRunOptions*,char*,char*);
 *     OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
 *     void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
 *     OrtStatusPtr (*CreateSessionWithPrepackedWeightsContainer)(const OrtEnv*,char*,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
 *     OrtStatusPtr (*CreateSessionFromArrayWithPrepackedWeightsContainer)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
 *     OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
 *     OrtStatusPtr (*UpdateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*,char**,char**,size_t);
 *     OrtStatusPtr (*GetTensorRTProviderOptionsAsString)(const OrtTensorRTProviderOptionsV2*,OrtAllocator*,char**);
 *     void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
 *     OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
 *     OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
 *     OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
 *     OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
 *     OrtStatusPtr (*CreateSparseTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
 *     OrtStatusPtr (*FillSparseTensorCoo)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t);
 *     OrtStatusPtr (*FillSparseTensorCsr)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int64_t*,size_t);
 *     OrtStatusPtr (*FillSparseTensorBlockSparse)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int32_t*);
 *     OrtStatusPtr (*CreateSparseTensorWithValuesAsOrtValue)(const OrtMemoryInfo*,void*,const int64_t*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
 *     OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
 *     OrtStatusPtr (*UseCsrIndices)(OrtValue*,int64_t*,size_t,int64_t*,size_t);
 *     OrtStatusPtr (*UseBlockSparseIndices)(OrtValue*,const int64_t*,size_t,int32_t*);
 *     OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
 *     OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
 *     OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
 *     OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
 *     OrtStatusPtr (*GetSparseTensorIndices)(const OrtValue*,enum OrtSparseIndicesFormat,size_t*,void**);
 *     OrtStatusPtr (*HasValue)(const OrtValue*,int*);
 *     OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
 *     OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
 *     OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
 *     OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
 *     OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
 *     OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
 *     OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
 *     OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
 *     OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
 *     OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
 *     OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
 *     OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
 *     OrtStatusPtr (*UpdateCUDAProviderOptions)(OrtCUDAProviderOptionsV2*,char**,char**,size_t);
 *     OrtStatusPtr (*GetCUDAProviderOptionsAsString)(const OrtCUDAProviderOptionsV2*,OrtAllocator*,char**);
 *     void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
 *     OrtStatusPtr (*AddExternalInitializers)(OrtSessionOptions*,char**,const OrtValue**,size_t);
 *     OrtStatusPtr (*CreateOpAttr)(char*,void*,int,OrtOpAttrType,OrtOpAttr**);
 *     void (*ReleaseOpAttr)(OrtOpAttr*);
 *     OrtStatusPtr (*CreateOp)(const OrtKernelInfo*,char*,char*,int,char**,const ONNXTensorElementDataType*,int,const OrtOpAttr**,int,int,int,OrtOp**);
 *     OrtStatusPtr (*InvokeOp)(const OrtKernelContext*,const OrtOp*,const OrtValue**,int,OrtValue**,int);
 *     void (*ReleaseOp)(OrtOp*);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider)(OrtSessionOptions*,char*,char**,char**,size_t);
 *     OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
 *     void (*ReleaseKernelInfo)(OrtKernelInfo*);
 *     const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
 *     OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
 *     OrtStatusPtr (*UpdateCANNProviderOptions)(OrtCANNProviderOptions*,char**,char**,size_t);
 *     OrtStatusPtr (*GetCANNProviderOptionsAsString)(const OrtCANNProviderOptions*,OrtAllocator*,char**);
 *     void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
 *     void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
 *     OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
 *     OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
 *     OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
 *     OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
 *     OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
 *     OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
 *     OrtStatusPtr (*KernelInfo_GetInputName)(const OrtKernelInfo*,size_t,char*,size_t*);
 *     OrtStatusPtr (*KernelInfo_GetOutputName)(const OrtKernelInfo*,size_t,char*,size_t*);
 *     OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
 *     OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
 *     OrtStatusPtr (*KernelInfoGetAttribute_tensor)(const OrtKernelInfo*,char*,OrtAllocator*,OrtValue**);
 *     OrtStatusPtr (*HasSessionConfigEntry)(const OrtSessionOptions*,char*,int*);
 *     OrtStatusPtr (*GetSessionConfigEntry)(const OrtSessionOptions*,char*,char*,size_t*);
 * };
 * }
 */
public class OrtApi {

    static final StructLayout $struct$LAYOUT = MemoryLayout.structLayout(
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
                    Constants$root.C_POINTER$LAYOUT.withName("GetSessionConfigEntry"))
            .withName("OrtApi");

    public static MemoryLayout $LAYOUT() {
        return OrtApi.$struct$LAYOUT;
    }

    static final FunctionDescriptor CreateStatus$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateStatus$MH = RuntimeHelper.downcallHandle(OrtApi.CreateStatus$FUNC);
    /**
     * {@snippet :
     * OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
     * }
     */
    public interface CreateStatus {

        java.lang.foreign.MemorySegment apply(int _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateStatus fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateStatus.class, fi, OrtApi.CreateStatus$FUNC, scope);
        }

        static CreateStatus ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateStatus$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
     * }
     */
    public static MemorySegment CreateStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateStatus$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
     * }
     */
    public static void CreateStatus$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateStatus$VH.set(seg, x);
    }

    public static MemorySegment CreateStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateStatus$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateStatus$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateStatus$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateStatus CreateStatus(MemorySegment segment, SegmentScope scope) {
        return CreateStatus.ofAddress(CreateStatus$get(segment), scope);
    }

    static final FunctionDescriptor GetErrorCode$FUNC =
            FunctionDescriptor.of(Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetErrorCode$MH = RuntimeHelper.downcallHandle(OrtApi.GetErrorCode$FUNC);
    /**
     * {@snippet :
     * OrtErrorCode (*GetErrorCode)(const OrtStatus*);
     * }
     */
    public interface GetErrorCode {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetErrorCode fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetErrorCode.class, fi, OrtApi.GetErrorCode$FUNC, scope);
        }

        static GetErrorCode ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) OrtApi.GetErrorCode$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtErrorCode (*GetErrorCode)(const OrtStatus*);
     * }
     */
    public static MemorySegment GetErrorCode$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetErrorCode$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtErrorCode (*GetErrorCode)(const OrtStatus*);
     * }
     */
    public static void GetErrorCode$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetErrorCode$VH.set(seg, x);
    }

    public static MemorySegment GetErrorCode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetErrorCode$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetErrorCode$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetErrorCode$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetErrorCode GetErrorCode(MemorySegment segment, SegmentScope scope) {
        return GetErrorCode.ofAddress(GetErrorCode$get(segment), scope);
    }

    static final FunctionDescriptor GetErrorMessage$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetErrorMessage$MH = RuntimeHelper.downcallHandle(OrtApi.GetErrorMessage$FUNC);
    /**
     * {@snippet :
     * char* (*GetErrorMessage)(const OrtStatus*);
     * }
     */
    public interface GetErrorMessage {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetErrorMessage fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetErrorMessage.class, fi, OrtApi.GetErrorMessage$FUNC, scope);
        }

        static GetErrorMessage ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetErrorMessage$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetErrorMessage)(const OrtStatus*);
     * }
     */
    public static MemorySegment GetErrorMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetErrorMessage$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetErrorMessage)(const OrtStatus*);
     * }
     */
    public static void GetErrorMessage$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetErrorMessage$VH.set(seg, x);
    }

    public static MemorySegment GetErrorMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetErrorMessage$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetErrorMessage$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetErrorMessage$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetErrorMessage GetErrorMessage(MemorySegment segment, SegmentScope scope) {
        return GetErrorMessage.ofAddress(GetErrorMessage$get(segment), scope);
    }

    static final FunctionDescriptor CreateEnv$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateEnv$MH = RuntimeHelper.downcallHandle(OrtApi.CreateEnv$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public interface CreateEnv {

        java.lang.foreign.MemorySegment apply(
                int _x0, java.lang.foreign.MemorySegment _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateEnv fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateEnv.class, fi, OrtApi.CreateEnv$FUNC, scope);
        }

        static CreateEnv ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0, java.lang.foreign.MemorySegment __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateEnv$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateEnv$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static void CreateEnv$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateEnv$VH.set(seg, x);
    }

    public static MemorySegment CreateEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateEnv$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnv$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateEnv$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnv CreateEnv(MemorySegment segment, SegmentScope scope) {
        return CreateEnv.ofAddress(CreateEnv$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLogger)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public interface CreateEnvWithCustomLogger {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                int _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateEnvWithCustomLogger fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLogger.class, fi, OrtApi.CreateEnvWithCustomLogger$FUNC, scope);
        }

        static CreateEnvWithCustomLogger ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateEnvWithCustomLogger$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLogger)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithCustomLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateEnvWithCustomLogger$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLogger)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateEnvWithCustomLogger$VH.set(seg, x);
    }

    public static MemorySegment CreateEnvWithCustomLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateEnvWithCustomLogger$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateEnvWithCustomLogger$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithCustomLogger CreateEnvWithCustomLogger(MemorySegment segment, SegmentScope scope) {
        return CreateEnvWithCustomLogger.ofAddress(CreateEnvWithCustomLogger$get(segment), scope);
    }

    static final FunctionDescriptor EnableTelemetryEvents$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableTelemetryEvents$MH =
            RuntimeHelper.downcallHandle(OrtApi.EnableTelemetryEvents$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public interface EnableTelemetryEvents {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableTelemetryEvents fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(EnableTelemetryEvents.class, fi, OrtApi.EnableTelemetryEvents$FUNC, scope);
        }

        static EnableTelemetryEvents ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.EnableTelemetryEvents$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static MemorySegment EnableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableTelemetryEvents$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static void EnableTelemetryEvents$set(MemorySegment seg, MemorySegment x) {
        OrtApi.EnableTelemetryEvents$VH.set(seg, x);
    }

    public static MemorySegment EnableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableTelemetryEvents$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.EnableTelemetryEvents$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableTelemetryEvents EnableTelemetryEvents(MemorySegment segment, SegmentScope scope) {
        return EnableTelemetryEvents.ofAddress(EnableTelemetryEvents$get(segment), scope);
    }

    static final FunctionDescriptor DisableTelemetryEvents$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableTelemetryEvents$MH =
            RuntimeHelper.downcallHandle(OrtApi.DisableTelemetryEvents$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public interface DisableTelemetryEvents {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableTelemetryEvents fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    DisableTelemetryEvents.class, fi, OrtApi.DisableTelemetryEvents$FUNC, scope);
        }

        static DisableTelemetryEvents ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.DisableTelemetryEvents$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static MemorySegment DisableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableTelemetryEvents$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static void DisableTelemetryEvents$set(MemorySegment seg, MemorySegment x) {
        OrtApi.DisableTelemetryEvents$VH.set(seg, x);
    }

    public static MemorySegment DisableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableTelemetryEvents$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.DisableTelemetryEvents$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableTelemetryEvents DisableTelemetryEvents(MemorySegment segment, SegmentScope scope) {
        return DisableTelemetryEvents.ofAddress(DisableTelemetryEvents$get(segment), scope);
    }

    static final FunctionDescriptor CreateSession$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSession$MH = RuntimeHelper.downcallHandle(OrtApi.CreateSession$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSession)(const OrtEnv*,char*,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public interface CreateSession {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateSession fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateSession.class, fi, OrtApi.CreateSession$FUNC, scope);
        }

        static CreateSession ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateSession$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSession)(const OrtEnv*,char*,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSession$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSession)(const OrtEnv*,char*,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static void CreateSession$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSession$VH.set(seg, x);
    }

    public static MemorySegment CreateSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSession$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSession$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSession$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSession CreateSession(MemorySegment segment, SegmentScope scope) {
        return CreateSession.ofAddress(CreateSession$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArray)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public interface CreateSessionFromArray {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateSessionFromArray fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArray.class, fi, OrtApi.CreateSessionFromArray$FUNC, scope);
        }

        static CreateSessionFromArray ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateSessionFromArray$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArray)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionFromArray$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionFromArray$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArray)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static void CreateSessionFromArray$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSessionFromArray$VH.set(seg, x);
    }

    public static MemorySegment CreateSessionFromArray$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionFromArray$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSessionFromArray$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionFromArray CreateSessionFromArray(MemorySegment segment, SegmentScope scope) {
        return CreateSessionFromArray.ofAddress(CreateSessionFromArray$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*Run)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**);
     * }
     */
    public interface Run {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4,
                java.lang.foreign.MemorySegment _x5,
                long _x6,
                java.lang.foreign.MemorySegment _x7);

        static MemorySegment allocate(Run fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(Run.class, fi, OrtApi.Run$FUNC, scope);
        }

        static Run ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6,
                    java.lang.foreign.MemorySegment __x7) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.Run$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*Run)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**);
     * }
     */
    public static MemorySegment Run$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.Run$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*Run)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**);
     * }
     */
    public static void Run$set(MemorySegment seg, MemorySegment x) {
        OrtApi.Run$VH.set(seg, x);
    }

    public static MemorySegment Run$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.Run$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Run$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.Run$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Run Run(MemorySegment segment, SegmentScope scope) {
        return Run.ofAddress(Run$get(segment), scope);
    }

    static final FunctionDescriptor CreateSessionOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateSessionOptions$MH = RuntimeHelper.downcallHandle(OrtApi.CreateSessionOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
     * }
     */
    public interface CreateSessionOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateSessionOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateSessionOptions.class, fi, OrtApi.CreateSessionOptions$FUNC, scope);
        }

        static CreateSessionOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
     * }
     */
    public static MemorySegment CreateSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
     * }
     */
    public static void CreateSessionOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSessionOptions$VH.set(seg, x);
    }

    public static MemorySegment CreateSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionOptions CreateSessionOptions(MemorySegment segment, SegmentScope scope) {
        return CreateSessionOptions.ofAddress(CreateSessionOptions$get(segment), scope);
    }

    static final FunctionDescriptor SetOptimizedModelFilePath$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetOptimizedModelFilePath$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetOptimizedModelFilePath$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
     * }
     */
    public interface SetOptimizedModelFilePath {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetOptimizedModelFilePath fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetOptimizedModelFilePath.class, fi, OrtApi.SetOptimizedModelFilePath$FUNC, scope);
        }

        static SetOptimizedModelFilePath ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetOptimizedModelFilePath$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment SetOptimizedModelFilePath$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetOptimizedModelFilePath$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
     * }
     */
    public static void SetOptimizedModelFilePath$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetOptimizedModelFilePath$VH.set(seg, x);
    }

    public static MemorySegment SetOptimizedModelFilePath$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetOptimizedModelFilePath$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetOptimizedModelFilePath$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetOptimizedModelFilePath SetOptimizedModelFilePath(MemorySegment segment, SegmentScope scope) {
        return SetOptimizedModelFilePath.ofAddress(SetOptimizedModelFilePath$get(segment), scope);
    }

    static final FunctionDescriptor CloneSessionOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CloneSessionOptions$MH = RuntimeHelper.downcallHandle(OrtApi.CloneSessionOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
     * }
     */
    public interface CloneSessionOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CloneSessionOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CloneSessionOptions.class, fi, OrtApi.CloneSessionOptions$FUNC, scope);
        }

        static CloneSessionOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CloneSessionOptions$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
     * }
     */
    public static MemorySegment CloneSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CloneSessionOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
     * }
     */
    public static void CloneSessionOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CloneSessionOptions$VH.set(seg, x);
    }

    public static MemorySegment CloneSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CloneSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CloneSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CloneSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CloneSessionOptions CloneSessionOptions(MemorySegment segment, SegmentScope scope) {
        return CloneSessionOptions.ofAddress(CloneSessionOptions$get(segment), scope);
    }

    static final FunctionDescriptor SetSessionExecutionMode$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionExecutionMode$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionExecutionMode$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
     * }
     */
    public interface SetSessionExecutionMode {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionExecutionMode fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionExecutionMode.class, fi, OrtApi.SetSessionExecutionMode$FUNC, scope);
        }

        static SetSessionExecutionMode ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetSessionExecutionMode$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
     * }
     */
    public static MemorySegment SetSessionExecutionMode$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionExecutionMode$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
     * }
     */
    public static void SetSessionExecutionMode$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetSessionExecutionMode$VH.set(seg, x);
    }

    public static MemorySegment SetSessionExecutionMode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionExecutionMode$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetSessionExecutionMode$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionExecutionMode SetSessionExecutionMode(MemorySegment segment, SegmentScope scope) {
        return SetSessionExecutionMode.ofAddress(SetSessionExecutionMode$get(segment), scope);
    }

    static final FunctionDescriptor EnableProfiling$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableProfiling$MH = RuntimeHelper.downcallHandle(OrtApi.EnableProfiling$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
     * }
     */
    public interface EnableProfiling {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(EnableProfiling fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(EnableProfiling.class, fi, OrtApi.EnableProfiling$FUNC, scope);
        }

        static EnableProfiling ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.EnableProfiling$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment EnableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableProfiling$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
     * }
     */
    public static void EnableProfiling$set(MemorySegment seg, MemorySegment x) {
        OrtApi.EnableProfiling$VH.set(seg, x);
    }

    public static MemorySegment EnableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.EnableProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableProfiling EnableProfiling(MemorySegment segment, SegmentScope scope) {
        return EnableProfiling.ofAddress(EnableProfiling$get(segment), scope);
    }

    static final FunctionDescriptor DisableProfiling$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableProfiling$MH = RuntimeHelper.downcallHandle(OrtApi.DisableProfiling$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
     * }
     */
    public interface DisableProfiling {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableProfiling fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(DisableProfiling.class, fi, OrtApi.DisableProfiling$FUNC, scope);
        }

        static DisableProfiling ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.DisableProfiling$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableProfiling$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
     * }
     */
    public static void DisableProfiling$set(MemorySegment seg, MemorySegment x) {
        OrtApi.DisableProfiling$VH.set(seg, x);
    }

    public static MemorySegment DisableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.DisableProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableProfiling DisableProfiling(MemorySegment segment, SegmentScope scope) {
        return DisableProfiling.ofAddress(DisableProfiling$get(segment), scope);
    }

    static final FunctionDescriptor EnableMemPattern$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableMemPattern$MH = RuntimeHelper.downcallHandle(OrtApi.EnableMemPattern$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
     * }
     */
    public interface EnableMemPattern {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableMemPattern fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(EnableMemPattern.class, fi, OrtApi.EnableMemPattern$FUNC, scope);
        }

        static EnableMemPattern ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.EnableMemPattern$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableMemPattern$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static void EnableMemPattern$set(MemorySegment seg, MemorySegment x) {
        OrtApi.EnableMemPattern$VH.set(seg, x);
    }

    public static MemorySegment EnableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableMemPattern$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableMemPattern$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.EnableMemPattern$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableMemPattern EnableMemPattern(MemorySegment segment, SegmentScope scope) {
        return EnableMemPattern.ofAddress(EnableMemPattern$get(segment), scope);
    }

    static final FunctionDescriptor DisableMemPattern$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableMemPattern$MH = RuntimeHelper.downcallHandle(OrtApi.DisableMemPattern$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
     * }
     */
    public interface DisableMemPattern {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableMemPattern fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(DisableMemPattern.class, fi, OrtApi.DisableMemPattern$FUNC, scope);
        }

        static DisableMemPattern ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.DisableMemPattern$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableMemPattern$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static void DisableMemPattern$set(MemorySegment seg, MemorySegment x) {
        OrtApi.DisableMemPattern$VH.set(seg, x);
    }

    public static MemorySegment DisableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableMemPattern$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableMemPattern$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.DisableMemPattern$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableMemPattern DisableMemPattern(MemorySegment segment, SegmentScope scope) {
        return DisableMemPattern.ofAddress(DisableMemPattern$get(segment), scope);
    }

    static final FunctionDescriptor EnableCpuMemArena$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableCpuMemArena$MH = RuntimeHelper.downcallHandle(OrtApi.EnableCpuMemArena$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public interface EnableCpuMemArena {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableCpuMemArena fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(EnableCpuMemArena.class, fi, OrtApi.EnableCpuMemArena$FUNC, scope);
        }

        static EnableCpuMemArena ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.EnableCpuMemArena$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableCpuMemArena$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static void EnableCpuMemArena$set(MemorySegment seg, MemorySegment x) {
        OrtApi.EnableCpuMemArena$VH.set(seg, x);
    }

    public static MemorySegment EnableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableCpuMemArena$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.EnableCpuMemArena$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableCpuMemArena EnableCpuMemArena(MemorySegment segment, SegmentScope scope) {
        return EnableCpuMemArena.ofAddress(EnableCpuMemArena$get(segment), scope);
    }

    static final FunctionDescriptor DisableCpuMemArena$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisableCpuMemArena$MH = RuntimeHelper.downcallHandle(OrtApi.DisableCpuMemArena$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public interface DisableCpuMemArena {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableCpuMemArena fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(DisableCpuMemArena.class, fi, OrtApi.DisableCpuMemArena$FUNC, scope);
        }

        static DisableCpuMemArena ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.DisableCpuMemArena$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableCpuMemArena$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static void DisableCpuMemArena$set(MemorySegment seg, MemorySegment x) {
        OrtApi.DisableCpuMemArena$VH.set(seg, x);
    }

    public static MemorySegment DisableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisableCpuMemArena$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.DisableCpuMemArena$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableCpuMemArena DisableCpuMemArena(MemorySegment segment, SegmentScope scope) {
        return DisableCpuMemArena.ofAddress(DisableCpuMemArena$get(segment), scope);
    }

    static final FunctionDescriptor SetSessionLogId$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetSessionLogId$MH = RuntimeHelper.downcallHandle(OrtApi.SetSessionLogId$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
     * }
     */
    public interface SetSessionLogId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetSessionLogId fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetSessionLogId.class, fi, OrtApi.SetSessionLogId$FUNC, scope);
        }

        static SetSessionLogId ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.SetSessionLogId$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment SetSessionLogId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionLogId$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
     * }
     */
    public static void SetSessionLogId$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetSessionLogId$VH.set(seg, x);
    }

    public static MemorySegment SetSessionLogId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionLogId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogId$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetSessionLogId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogId SetSessionLogId(MemorySegment segment, SegmentScope scope) {
        return SetSessionLogId.ofAddress(SetSessionLogId$get(segment), scope);
    }

    static final FunctionDescriptor SetSessionLogVerbosityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionLogVerbosityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionLogVerbosityLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
     * }
     */
    public interface SetSessionLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionLogVerbosityLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogVerbosityLevel.class, fi, OrtApi.SetSessionLogVerbosityLevel$FUNC, scope);
        }

        static SetSessionLogVerbosityLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetSessionLogVerbosityLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetSessionLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionLogVerbosityLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetSessionLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemorySegment SetSessionLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetSessionLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetSessionLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel(MemorySegment segment, SegmentScope scope) {
        return SetSessionLogVerbosityLevel.ofAddress(SetSessionLogVerbosityLevel$get(segment), scope);
    }

    static final FunctionDescriptor SetSessionLogSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionLogSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionLogSeverityLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
     * }
     */
    public interface SetSessionLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionLogSeverityLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogSeverityLevel.class, fi, OrtApi.SetSessionLogSeverityLevel$FUNC, scope);
        }

        static SetSessionLogSeverityLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetSessionLogSeverityLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetSessionLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionLogSeverityLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetSessionLogSeverityLevel$VH.set(seg, x);
    }

    public static MemorySegment SetSessionLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetSessionLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetSessionLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogSeverityLevel SetSessionLogSeverityLevel(MemorySegment segment, SegmentScope scope) {
        return SetSessionLogSeverityLevel.ofAddress(SetSessionLogSeverityLevel$get(segment), scope);
    }

    static final FunctionDescriptor SetSessionGraphOptimizationLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetSessionGraphOptimizationLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetSessionGraphOptimizationLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
     * }
     */
    public interface SetSessionGraphOptimizationLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionGraphOptimizationLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionGraphOptimizationLevel.class, fi, OrtApi.SetSessionGraphOptimizationLevel$FUNC, scope);
        }

        static SetSessionGraphOptimizationLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetSessionGraphOptimizationLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
     * }
     */
    public static MemorySegment SetSessionGraphOptimizationLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetSessionGraphOptimizationLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
     * }
     */
    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetSessionGraphOptimizationLevel$VH.set(seg, x);
    }

    public static MemorySegment SetSessionGraphOptimizationLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetSessionGraphOptimizationLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetSessionGraphOptimizationLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel(
            MemorySegment segment, SegmentScope scope) {
        return SetSessionGraphOptimizationLevel.ofAddress(SetSessionGraphOptimizationLevel$get(segment), scope);
    }

    static final FunctionDescriptor SetIntraOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetIntraOpNumThreads$MH = RuntimeHelper.downcallHandle(OrtApi.SetIntraOpNumThreads$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public interface SetIntraOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetIntraOpNumThreads fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetIntraOpNumThreads.class, fi, OrtApi.SetIntraOpNumThreads$FUNC, scope);
        }

        static SetIntraOpNumThreads ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetIntraOpNumThreads$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetIntraOpNumThreads$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static void SetIntraOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetIntraOpNumThreads$VH.set(seg, x);
    }

    public static MemorySegment SetIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetIntraOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetIntraOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetIntraOpNumThreads SetIntraOpNumThreads(MemorySegment segment, SegmentScope scope) {
        return SetIntraOpNumThreads.ofAddress(SetIntraOpNumThreads$get(segment), scope);
    }

    static final FunctionDescriptor SetInterOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetInterOpNumThreads$MH = RuntimeHelper.downcallHandle(OrtApi.SetInterOpNumThreads$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public interface SetInterOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetInterOpNumThreads fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetInterOpNumThreads.class, fi, OrtApi.SetInterOpNumThreads$FUNC, scope);
        }

        static SetInterOpNumThreads ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetInterOpNumThreads$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetInterOpNumThreads$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static void SetInterOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetInterOpNumThreads$VH.set(seg, x);
    }

    public static MemorySegment SetInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetInterOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetInterOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetInterOpNumThreads SetInterOpNumThreads(MemorySegment segment, SegmentScope scope) {
        return SetInterOpNumThreads.ofAddress(SetInterOpNumThreads$get(segment), scope);
    }

    static final FunctionDescriptor CreateCustomOpDomain$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCustomOpDomain$MH = RuntimeHelper.downcallHandle(OrtApi.CreateCustomOpDomain$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
     * }
     */
    public interface CreateCustomOpDomain {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateCustomOpDomain fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateCustomOpDomain.class, fi, OrtApi.CreateCustomOpDomain$FUNC, scope);
        }

        static CreateCustomOpDomain ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateCustomOpDomain$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
     * }
     */
    public static MemorySegment CreateCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCustomOpDomain$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
     * }
     */
    public static void CreateCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateCustomOpDomain$VH.set(seg, x);
    }

    public static MemorySegment CreateCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCustomOpDomain CreateCustomOpDomain(MemorySegment segment, SegmentScope scope) {
        return CreateCustomOpDomain.ofAddress(CreateCustomOpDomain$get(segment), scope);
    }

    static final FunctionDescriptor CustomOpDomain_Add$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CustomOpDomain_Add$MH = RuntimeHelper.downcallHandle(OrtApi.CustomOpDomain_Add$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
     * }
     */
    public interface CustomOpDomain_Add {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CustomOpDomain_Add fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CustomOpDomain_Add.class, fi, OrtApi.CustomOpDomain_Add$FUNC, scope);
        }

        static CustomOpDomain_Add ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CustomOpDomain_Add$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
     * }
     */
    public static MemorySegment CustomOpDomain_Add$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CustomOpDomain_Add$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
     * }
     */
    public static void CustomOpDomain_Add$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CustomOpDomain_Add$VH.set(seg, x);
    }

    public static MemorySegment CustomOpDomain_Add$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CustomOpDomain_Add$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CustomOpDomain_Add$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CustomOpDomain_Add CustomOpDomain_Add(MemorySegment segment, SegmentScope scope) {
        return CustomOpDomain_Add.ofAddress(CustomOpDomain_Add$get(segment), scope);
    }

    static final FunctionDescriptor AddCustomOpDomain$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddCustomOpDomain$MH = RuntimeHelper.downcallHandle(OrtApi.AddCustomOpDomain$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
     * }
     */
    public interface AddCustomOpDomain {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(AddCustomOpDomain fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AddCustomOpDomain.class, fi, OrtApi.AddCustomOpDomain$FUNC, scope);
        }

        static AddCustomOpDomain ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddCustomOpDomain$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
     * }
     */
    public static MemorySegment AddCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddCustomOpDomain$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
     * }
     */
    public static void AddCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddCustomOpDomain$VH.set(seg, x);
    }

    public static MemorySegment AddCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddCustomOpDomain AddCustomOpDomain(MemorySegment segment, SegmentScope scope) {
        return AddCustomOpDomain.ofAddress(AddCustomOpDomain$get(segment), scope);
    }

    static final FunctionDescriptor RegisterCustomOpsLibrary$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsLibrary$MH =
            RuntimeHelper.downcallHandle(OrtApi.RegisterCustomOpsLibrary$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary)(OrtSessionOptions*,char*,void**);
     * }
     */
    public interface RegisterCustomOpsLibrary {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(RegisterCustomOpsLibrary fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsLibrary.class, fi, OrtApi.RegisterCustomOpsLibrary$FUNC, scope);
        }

        static RegisterCustomOpsLibrary ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RegisterCustomOpsLibrary$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary)(OrtSessionOptions*,char*,void**);
     * }
     */
    public static MemorySegment RegisterCustomOpsLibrary$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RegisterCustomOpsLibrary$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary)(OrtSessionOptions*,char*,void**);
     * }
     */
    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RegisterCustomOpsLibrary$VH.set(seg, x);
    }

    public static MemorySegment RegisterCustomOpsLibrary$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RegisterCustomOpsLibrary$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RegisterCustomOpsLibrary$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsLibrary RegisterCustomOpsLibrary(MemorySegment segment, SegmentScope scope) {
        return RegisterCustomOpsLibrary.ofAddress(RegisterCustomOpsLibrary$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetInputCount$MH = RuntimeHelper.downcallHandle(OrtApi.SessionGetInputCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
     * }
     */
    public interface SessionGetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetInputCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SessionGetInputCount.class, fi, OrtApi.SessionGetInputCount$FUNC, scope);
        }

        static SessionGetInputCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetInputCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
     * }
     */
    public static MemorySegment SessionGetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetInputCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
     * }
     */
    public static void SessionGetInputCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetInputCount$VH.set(seg, x);
    }

    public static MemorySegment SessionGetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputCount SessionGetInputCount(MemorySegment segment, SegmentScope scope) {
        return SessionGetInputCount.ofAddress(SessionGetInputCount$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetOutputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOutputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOutputCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
     * }
     */
    public interface SessionGetOutputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetOutputCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SessionGetOutputCount.class, fi, OrtApi.SessionGetOutputCount$FUNC, scope);
        }

        static SessionGetOutputCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetOutputCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
     * }
     */
    public static MemorySegment SessionGetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOutputCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
     * }
     */
    public static void SessionGetOutputCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetOutputCount$VH.set(seg, x);
    }

    public static MemorySegment SessionGetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputCount SessionGetOutputCount(MemorySegment segment, SegmentScope scope) {
        return SessionGetOutputCount.ofAddress(SessionGetOutputCount$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetOverridableInitializerCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOverridableInitializerCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOverridableInitializerCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
     * }
     */
    public interface SessionGetOverridableInitializerCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetOverridableInitializerCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerCount.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerCount$FUNC,
                    scope);
        }

        static SessionGetOverridableInitializerCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetOverridableInitializerCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOverridableInitializerCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
     * }
     */
    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetOverridableInitializerCount$VH.set(seg, x);
    }

    public static MemorySegment SessionGetOverridableInitializerCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionGetOverridableInitializerCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetOverridableInitializerCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount(
            MemorySegment segment, SegmentScope scope) {
        return SessionGetOverridableInitializerCount.ofAddress(
                SessionGetOverridableInitializerCount$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetInputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetInputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetInputTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public interface SessionGetInputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetInputTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputTypeInfo.class, fi, OrtApi.SessionGetInputTypeInfo$FUNC, scope);
        }

        static SessionGetInputTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetInputTypeInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetInputTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static void SessionGetInputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetInputTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment SessionGetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetInputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetInputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputTypeInfo SessionGetInputTypeInfo(MemorySegment segment, SegmentScope scope) {
        return SessionGetInputTypeInfo.ofAddress(SessionGetInputTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetOutputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOutputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOutputTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public interface SessionGetOutputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetOutputTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputTypeInfo.class, fi, OrtApi.SessionGetOutputTypeInfo$FUNC, scope);
        }

        static SessionGetOutputTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetOutputTypeInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOutputTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetOutputTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment SessionGetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOutputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetOutputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputTypeInfo SessionGetOutputTypeInfo(MemorySegment segment, SegmentScope scope) {
        return SessionGetOutputTypeInfo.ofAddress(SessionGetOutputTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetOverridableInitializerTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOverridableInitializerTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public interface SessionGetOverridableInitializerTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetOverridableInitializerTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerTypeInfo.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC,
                    scope);
        }

        static SessionGetOverridableInitializerTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetOverridableInitializerTypeInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOverridableInitializerTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetOverridableInitializerTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionGetOverridableInitializerTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetOverridableInitializerTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo(
            MemorySegment segment, SegmentScope scope) {
        return SessionGetOverridableInitializerTypeInfo.ofAddress(
                SessionGetOverridableInitializerTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetInputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetInputName$MH = RuntimeHelper.downcallHandle(OrtApi.SessionGetInputName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public interface SessionGetInputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(SessionGetInputName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SessionGetInputName.class, fi, OrtApi.SessionGetInputName$FUNC, scope);
        }

        static SessionGetInputName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetInputName$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetInputName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static void SessionGetInputName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetInputName$VH.set(seg, x);
    }

    public static MemorySegment SessionGetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetInputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetInputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputName SessionGetInputName(MemorySegment segment, SegmentScope scope) {
        return SessionGetInputName.ofAddress(SessionGetInputName$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetOutputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOutputName$MH = RuntimeHelper.downcallHandle(OrtApi.SessionGetOutputName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public interface SessionGetOutputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(SessionGetOutputName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SessionGetOutputName.class, fi, OrtApi.SessionGetOutputName$FUNC, scope);
        }

        static SessionGetOutputName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetOutputName$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOutputName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static void SessionGetOutputName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetOutputName$VH.set(seg, x);
    }

    public static MemorySegment SessionGetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOutputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetOutputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputName SessionGetOutputName(MemorySegment segment, SegmentScope scope) {
        return SessionGetOutputName.ofAddress(SessionGetOutputName$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetOverridableInitializerName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetOverridableInitializerName$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetOverridableInitializerName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public interface SessionGetOverridableInitializerName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(SessionGetOverridableInitializerName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerName.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerName$FUNC,
                    scope);
        }

        static SessionGetOverridableInitializerName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetOverridableInitializerName$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetOverridableInitializerName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetOverridableInitializerName$VH.set(seg, x);
    }

    public static MemorySegment SessionGetOverridableInitializerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionGetOverridableInitializerName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetOverridableInitializerName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerName SessionGetOverridableInitializerName(
            MemorySegment segment, SegmentScope scope) {
        return SessionGetOverridableInitializerName.ofAddress(SessionGetOverridableInitializerName$get(segment), scope);
    }

    static final FunctionDescriptor CreateRunOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateRunOptions$MH = RuntimeHelper.downcallHandle(OrtApi.CreateRunOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
     * }
     */
    public interface CreateRunOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateRunOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateRunOptions.class, fi, OrtApi.CreateRunOptions$FUNC, scope);
        }

        static CreateRunOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateRunOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
     * }
     */
    public static MemorySegment CreateRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateRunOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
     * }
     */
    public static void CreateRunOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateRunOptions$VH.set(seg, x);
    }

    public static MemorySegment CreateRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateRunOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateRunOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateRunOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateRunOptions CreateRunOptions(MemorySegment segment, SegmentScope scope) {
        return CreateRunOptions.ofAddress(CreateRunOptions$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsSetRunLogVerbosityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle RunOptionsSetRunLogVerbosityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
     * }
     */
    public interface RunOptionsSetRunLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogVerbosityLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogVerbosityLevel.class, fi, OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC, scope);
        }

        static RunOptionsSetRunLogVerbosityLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsSetRunLogVerbosityLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
     * }
     */
    public static MemorySegment RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
     * }
     */
    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel(
            MemorySegment segment, SegmentScope scope) {
        return RunOptionsSetRunLogVerbosityLevel.ofAddress(RunOptionsSetRunLogVerbosityLevel$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsSetRunLogSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle RunOptionsSetRunLogSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
     * }
     */
    public interface RunOptionsSetRunLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogSeverityLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogSeverityLevel.class, fi, OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC, scope);
        }

        static RunOptionsSetRunLogSeverityLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsSetRunLogSeverityLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
     * }
     */
    public static MemorySegment RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetRunLogSeverityLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
     * }
     */
    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsSetRunLogSeverityLevel$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.RunOptionsSetRunLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsSetRunLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel(
            MemorySegment segment, SegmentScope scope) {
        return RunOptionsSetRunLogSeverityLevel.ofAddress(RunOptionsSetRunLogSeverityLevel$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsSetRunTag$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsSetRunTag$MH = RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetRunTag$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
     * }
     */
    public interface RunOptionsSetRunTag {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsSetRunTag fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(RunOptionsSetRunTag.class, fi, OrtApi.RunOptionsSetRunTag$FUNC, scope);
        }

        static RunOptionsSetRunTag ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsSetRunTag$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
     * }
     */
    public static MemorySegment RunOptionsSetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetRunTag$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
     * }
     */
    public static void RunOptionsSetRunTag$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsSetRunTag$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsSetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetRunTag$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsSetRunTag$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunTag RunOptionsSetRunTag(MemorySegment segment, SegmentScope scope) {
        return RunOptionsSetRunTag.ofAddress(RunOptionsSetRunTag$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsGetRunLogVerbosityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsGetRunLogVerbosityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public interface RunOptionsGetRunLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsGetRunLogVerbosityLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogVerbosityLevel.class, fi, OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC, scope);
        }

        static RunOptionsGetRunLogVerbosityLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsGetRunLogVerbosityLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static MemorySegment RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunLogVerbosityLevel RunOptionsGetRunLogVerbosityLevel(
            MemorySegment segment, SegmentScope scope) {
        return RunOptionsGetRunLogVerbosityLevel.ofAddress(RunOptionsGetRunLogVerbosityLevel$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsGetRunLogSeverityLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsGetRunLogSeverityLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public interface RunOptionsGetRunLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsGetRunLogSeverityLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogSeverityLevel.class, fi, OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC, scope);
        }

        static RunOptionsGetRunLogSeverityLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsGetRunLogSeverityLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static MemorySegment RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsGetRunLogSeverityLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsGetRunLogSeverityLevel$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.RunOptionsGetRunLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsGetRunLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunLogSeverityLevel RunOptionsGetRunLogSeverityLevel(
            MemorySegment segment, SegmentScope scope) {
        return RunOptionsGetRunLogSeverityLevel.ofAddress(RunOptionsGetRunLogSeverityLevel$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsGetRunTag$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsGetRunTag$MH = RuntimeHelper.downcallHandle(OrtApi.RunOptionsGetRunTag$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
     * }
     */
    public interface RunOptionsGetRunTag {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsGetRunTag fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(RunOptionsGetRunTag.class, fi, OrtApi.RunOptionsGetRunTag$FUNC, scope);
        }

        static RunOptionsGetRunTag ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsGetRunTag$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
     * }
     */
    public static MemorySegment RunOptionsGetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsGetRunTag$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
     * }
     */
    public static void RunOptionsGetRunTag$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsGetRunTag$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsGetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsGetRunTag$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsGetRunTag$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunTag RunOptionsGetRunTag(MemorySegment segment, SegmentScope scope) {
        return RunOptionsGetRunTag.ofAddress(RunOptionsGetRunTag$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsSetTerminate$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsSetTerminate$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsSetTerminate$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
     * }
     */
    public interface RunOptionsSetTerminate {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(RunOptionsSetTerminate fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetTerminate.class, fi, OrtApi.RunOptionsSetTerminate$FUNC, scope);
        }

        static RunOptionsSetTerminate ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetTerminate$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
     * }
     */
    public static MemorySegment RunOptionsSetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetTerminate$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
     * }
     */
    public static void RunOptionsSetTerminate$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsSetTerminate$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsSetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsSetTerminate$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsSetTerminate$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetTerminate RunOptionsSetTerminate(MemorySegment segment, SegmentScope scope) {
        return RunOptionsSetTerminate.ofAddress(RunOptionsSetTerminate$get(segment), scope);
    }

    static final FunctionDescriptor RunOptionsUnsetTerminate$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunOptionsUnsetTerminate$MH =
            RuntimeHelper.downcallHandle(OrtApi.RunOptionsUnsetTerminate$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
     * }
     */
    public interface RunOptionsUnsetTerminate {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(RunOptionsUnsetTerminate fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsUnsetTerminate.class, fi, OrtApi.RunOptionsUnsetTerminate$FUNC, scope);
        }

        static RunOptionsUnsetTerminate ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunOptionsUnsetTerminate$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
     * }
     */
    public static MemorySegment RunOptionsUnsetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsUnsetTerminate$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
     * }
     */
    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunOptionsUnsetTerminate$VH.set(seg, x);
    }

    public static MemorySegment RunOptionsUnsetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunOptionsUnsetTerminate$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunOptionsUnsetTerminate$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsUnsetTerminate RunOptionsUnsetTerminate(MemorySegment segment, SegmentScope scope) {
        return RunOptionsUnsetTerminate.ofAddress(RunOptionsUnsetTerminate$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public interface CreateTensorAsOrtValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateTensorAsOrtValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorAsOrtValue.class, fi, OrtApi.CreateTensorAsOrtValue$FUNC, scope);
        }

        static CreateTensorAsOrtValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateTensorAsOrtValue$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateTensorAsOrtValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateTensorAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateTensorAsOrtValue$VH.set(seg, x);
    }

    public static MemorySegment CreateTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateTensorAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateTensorAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorAsOrtValue CreateTensorAsOrtValue(MemorySegment segment, SegmentScope scope) {
        return CreateTensorAsOrtValue.ofAddress(CreateTensorAsOrtValue$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateTensorWithDataAsOrtValue)(const OrtMemoryInfo*,void*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public interface CreateTensorWithDataAsOrtValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4,
                int _x5,
                java.lang.foreign.MemorySegment _x6);

        static MemorySegment allocate(CreateTensorWithDataAsOrtValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorWithDataAsOrtValue.class, fi, OrtApi.CreateTensorWithDataAsOrtValue$FUNC, scope);
        }

        static CreateTensorWithDataAsOrtValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4,
                    int __x5,
                    java.lang.foreign.MemorySegment __x6) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateTensorWithDataAsOrtValue$MH.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorWithDataAsOrtValue)(const OrtMemoryInfo*,void*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateTensorWithDataAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateTensorWithDataAsOrtValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorWithDataAsOrtValue)(const OrtMemoryInfo*,void*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateTensorWithDataAsOrtValue$VH.set(seg, x);
    }

    public static MemorySegment CreateTensorWithDataAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateTensorWithDataAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateTensorWithDataAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue(
            MemorySegment segment, SegmentScope scope) {
        return CreateTensorWithDataAsOrtValue.ofAddress(CreateTensorWithDataAsOrtValue$get(segment), scope);
    }

    static final FunctionDescriptor IsTensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle IsTensor$MH = RuntimeHelper.downcallHandle(OrtApi.IsTensor$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
     * }
     */
    public interface IsTensor {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(IsTensor fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(IsTensor.class, fi, OrtApi.IsTensor$FUNC, scope);
        }

        static IsTensor ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.IsTensor$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
     * }
     */
    public static MemorySegment IsTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.IsTensor$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
     * }
     */
    public static void IsTensor$set(MemorySegment seg, MemorySegment x) {
        OrtApi.IsTensor$VH.set(seg, x);
    }

    public static MemorySegment IsTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.IsTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void IsTensor$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.IsTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static IsTensor IsTensor(MemorySegment segment, SegmentScope scope) {
        return IsTensor.ofAddress(IsTensor$get(segment), scope);
    }

    static final FunctionDescriptor GetTensorMutableData$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorMutableData$MH = RuntimeHelper.downcallHandle(OrtApi.GetTensorMutableData$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
     * }
     */
    public interface GetTensorMutableData {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorMutableData fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetTensorMutableData.class, fi, OrtApi.GetTensorMutableData$FUNC, scope);
        }

        static GetTensorMutableData ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetTensorMutableData$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
     * }
     */
    public static MemorySegment GetTensorMutableData$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorMutableData$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
     * }
     */
    public static void GetTensorMutableData$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTensorMutableData$VH.set(seg, x);
    }

    public static MemorySegment GetTensorMutableData$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorMutableData$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorMutableData$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTensorMutableData$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorMutableData GetTensorMutableData(MemorySegment segment, SegmentScope scope) {
        return GetTensorMutableData.ofAddress(GetTensorMutableData$get(segment), scope);
    }

    static final FunctionDescriptor FillStringTensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle FillStringTensor$MH = RuntimeHelper.downcallHandle(OrtApi.FillStringTensor$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
     * }
     */
    public interface FillStringTensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(FillStringTensor fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(FillStringTensor.class, fi, OrtApi.FillStringTensor$FUNC, scope);
        }

        static FillStringTensor ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.FillStringTensor$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
     * }
     */
    public static MemorySegment FillStringTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillStringTensor$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
     * }
     */
    public static void FillStringTensor$set(MemorySegment seg, MemorySegment x) {
        OrtApi.FillStringTensor$VH.set(seg, x);
    }

    public static MemorySegment FillStringTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillStringTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillStringTensor$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.FillStringTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillStringTensor FillStringTensor(MemorySegment segment, SegmentScope scope) {
        return FillStringTensor.ofAddress(FillStringTensor$get(segment), scope);
    }

    static final FunctionDescriptor GetStringTensorDataLength$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetStringTensorDataLength$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorDataLength$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
     * }
     */
    public interface GetStringTensorDataLength {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetStringTensorDataLength fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorDataLength.class, fi, OrtApi.GetStringTensorDataLength$FUNC, scope);
        }

        static GetStringTensorDataLength ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetStringTensorDataLength$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
     * }
     */
    public static MemorySegment GetStringTensorDataLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorDataLength$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
     * }
     */
    public static void GetStringTensorDataLength$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetStringTensorDataLength$VH.set(seg, x);
    }

    public static MemorySegment GetStringTensorDataLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorDataLength$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetStringTensorDataLength$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorDataLength GetStringTensorDataLength(MemorySegment segment, SegmentScope scope) {
        return GetStringTensorDataLength.ofAddress(GetStringTensorDataLength$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorContent)(const OrtValue*,void*,size_t,size_t*,size_t);
     * }
     */
    public interface GetStringTensorContent {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(GetStringTensorContent fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorContent.class, fi, OrtApi.GetStringTensorContent$FUNC, scope);
        }

        static GetStringTensorContent ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetStringTensorContent$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorContent)(const OrtValue*,void*,size_t,size_t*,size_t);
     * }
     */
    public static MemorySegment GetStringTensorContent$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorContent$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorContent)(const OrtValue*,void*,size_t,size_t*,size_t);
     * }
     */
    public static void GetStringTensorContent$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetStringTensorContent$VH.set(seg, x);
    }

    public static MemorySegment GetStringTensorContent$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorContent$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorContent$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetStringTensorContent$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorContent GetStringTensorContent(MemorySegment segment, SegmentScope scope) {
        return GetStringTensorContent.ofAddress(GetStringTensorContent$get(segment), scope);
    }

    static final FunctionDescriptor CastTypeInfoToTensorInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToTensorInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToTensorInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface CastTypeInfoToTensorInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToTensorInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToTensorInfo.class, fi, OrtApi.CastTypeInfoToTensorInfo$FUNC, scope);
        }

        static CastTypeInfoToTensorInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CastTypeInfoToTensorInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToTensorInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CastTypeInfoToTensorInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CastTypeInfoToTensorInfo$VH.set(seg, x);
    }

    public static MemorySegment CastTypeInfoToTensorInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CastTypeInfoToTensorInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CastTypeInfoToTensorInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo(MemorySegment segment, SegmentScope scope) {
        return CastTypeInfoToTensorInfo.ofAddress(CastTypeInfoToTensorInfo$get(segment), scope);
    }

    static final FunctionDescriptor GetOnnxTypeFromTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetOnnxTypeFromTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetOnnxTypeFromTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public interface GetOnnxTypeFromTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetOnnxTypeFromTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOnnxTypeFromTypeInfo.class, fi, OrtApi.GetOnnxTypeFromTypeInfo$FUNC, scope);
        }

        static GetOnnxTypeFromTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetOnnxTypeFromTypeInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public static MemorySegment GetOnnxTypeFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetOnnxTypeFromTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetOnnxTypeFromTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment GetOnnxTypeFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetOnnxTypeFromTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetOnnxTypeFromTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo(MemorySegment segment, SegmentScope scope) {
        return GetOnnxTypeFromTypeInfo.ofAddress(GetOnnxTypeFromTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor CreateTensorTypeAndShapeInfo$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateTensorTypeAndShapeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateTensorTypeAndShapeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface CreateTensorTypeAndShapeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateTensorTypeAndShapeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorTypeAndShapeInfo.class, fi, OrtApi.CreateTensorTypeAndShapeInfo$FUNC, scope);
        }

        static CreateTensorTypeAndShapeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateTensorTypeAndShapeInfo$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment CreateTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateTensorTypeAndShapeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateTensorTypeAndShapeInfo$VH.set(seg, x);
    }

    public static MemorySegment CreateTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateTensorTypeAndShapeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateTensorTypeAndShapeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorTypeAndShapeInfo CreateTensorTypeAndShapeInfo(MemorySegment segment, SegmentScope scope) {
        return CreateTensorTypeAndShapeInfo.ofAddress(CreateTensorTypeAndShapeInfo$get(segment), scope);
    }

    static final FunctionDescriptor SetTensorElementType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetTensorElementType$MH = RuntimeHelper.downcallHandle(OrtApi.SetTensorElementType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public interface SetTensorElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetTensorElementType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetTensorElementType.class, fi, OrtApi.SetTensorElementType$FUNC, scope);
        }

        static SetTensorElementType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetTensorElementType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public static MemorySegment SetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetTensorElementType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public static void SetTensorElementType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetTensorElementType$VH.set(seg, x);
    }

    public static MemorySegment SetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetTensorElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetTensorElementType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetTensorElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetTensorElementType SetTensorElementType(MemorySegment segment, SegmentScope scope) {
        return SetTensorElementType.ofAddress(SetTensorElementType$get(segment), scope);
    }

    static final FunctionDescriptor SetDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle SetDimensions$MH = RuntimeHelper.downcallHandle(OrtApi.SetDimensions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
     * }
     */
    public interface SetDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(SetDimensions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetDimensions.class, fi, OrtApi.SetDimensions$FUNC, scope);
        }

        static SetDimensions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetDimensions$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
     * }
     */
    public static MemorySegment SetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetDimensions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
     * }
     */
    public static void SetDimensions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetDimensions$VH.set(seg, x);
    }

    public static MemorySegment SetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetDimensions SetDimensions(MemorySegment segment, SegmentScope scope) {
        return SetDimensions.ofAddress(SetDimensions$get(segment), scope);
    }

    static final FunctionDescriptor GetTensorElementType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorElementType$MH = RuntimeHelper.downcallHandle(OrtApi.GetTensorElementType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public interface GetTensorElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorElementType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetTensorElementType.class, fi, OrtApi.GetTensorElementType$FUNC, scope);
        }

        static GetTensorElementType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetTensorElementType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static MemorySegment GetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorElementType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static void GetTensorElementType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTensorElementType$VH.set(seg, x);
    }

    public static MemorySegment GetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorElementType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTensorElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorElementType GetTensorElementType(MemorySegment segment, SegmentScope scope) {
        return GetTensorElementType.ofAddress(GetTensorElementType$get(segment), scope);
    }

    static final FunctionDescriptor GetDimensionsCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetDimensionsCount$MH = RuntimeHelper.downcallHandle(OrtApi.GetDimensionsCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public interface GetDimensionsCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetDimensionsCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetDimensionsCount.class, fi, OrtApi.GetDimensionsCount$FUNC, scope);
        }

        static GetDimensionsCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetDimensionsCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static MemorySegment GetDimensionsCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetDimensionsCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static void GetDimensionsCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetDimensionsCount$VH.set(seg, x);
    }

    public static MemorySegment GetDimensionsCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetDimensionsCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDimensionsCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetDimensionsCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDimensionsCount GetDimensionsCount(MemorySegment segment, SegmentScope scope) {
        return GetDimensionsCount.ofAddress(GetDimensionsCount$get(segment), scope);
    }

    static final FunctionDescriptor GetDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetDimensions$MH = RuntimeHelper.downcallHandle(OrtApi.GetDimensions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
     * }
     */
    public interface GetDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(GetDimensions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetDimensions.class, fi, OrtApi.GetDimensions$FUNC, scope);
        }

        static GetDimensions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetDimensions$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
     * }
     */
    public static MemorySegment GetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetDimensions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
     * }
     */
    public static void GetDimensions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetDimensions$VH.set(seg, x);
    }

    public static MemorySegment GetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDimensions GetDimensions(MemorySegment segment, SegmentScope scope) {
        return GetDimensions.ofAddress(GetDimensions$get(segment), scope);
    }

    static final FunctionDescriptor GetSymbolicDimensions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetSymbolicDimensions$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSymbolicDimensions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public interface GetSymbolicDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(GetSymbolicDimensions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetSymbolicDimensions.class, fi, OrtApi.GetSymbolicDimensions$FUNC, scope);
        }

        static GetSymbolicDimensions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSymbolicDimensions$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public static MemorySegment GetSymbolicDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSymbolicDimensions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public static void GetSymbolicDimensions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSymbolicDimensions$VH.set(seg, x);
    }

    public static MemorySegment GetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSymbolicDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSymbolicDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSymbolicDimensions GetSymbolicDimensions(MemorySegment segment, SegmentScope scope) {
        return GetSymbolicDimensions.ofAddress(GetSymbolicDimensions$get(segment), scope);
    }

    static final FunctionDescriptor GetTensorShapeElementCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorShapeElementCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorShapeElementCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public interface GetTensorShapeElementCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorShapeElementCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorShapeElementCount.class, fi, OrtApi.GetTensorShapeElementCount$FUNC, scope);
        }

        static GetTensorShapeElementCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetTensorShapeElementCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static MemorySegment GetTensorShapeElementCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorShapeElementCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static void GetTensorShapeElementCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTensorShapeElementCount$VH.set(seg, x);
    }

    public static MemorySegment GetTensorShapeElementCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetTensorShapeElementCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTensorShapeElementCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorShapeElementCount GetTensorShapeElementCount(MemorySegment segment, SegmentScope scope) {
        return GetTensorShapeElementCount.ofAddress(GetTensorShapeElementCount$get(segment), scope);
    }

    static final FunctionDescriptor GetTensorTypeAndShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorTypeAndShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorTypeAndShape$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetTensorTypeAndShape {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorTypeAndShape fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetTensorTypeAndShape.class, fi, OrtApi.GetTensorTypeAndShape$FUNC, scope);
        }

        static GetTensorTypeAndShape ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetTensorTypeAndShape$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetTensorTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorTypeAndShape$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetTensorTypeAndShape$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTensorTypeAndShape$VH.set(seg, x);
    }

    public static MemorySegment GetTensorTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorTypeAndShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTensorTypeAndShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorTypeAndShape GetTensorTypeAndShape(MemorySegment segment, SegmentScope scope) {
        return GetTensorTypeAndShape.ofAddress(GetTensorTypeAndShape$get(segment), scope);
    }

    static final FunctionDescriptor GetTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTypeInfo$MH = RuntimeHelper.downcallHandle(OrtApi.GetTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
     * }
     */
    public interface GetTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetTypeInfo.class, fi, OrtApi.GetTypeInfo$FUNC, scope);
        }

        static GetTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetTypeInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
     * }
     */
    public static void GetTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment GetTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTypeInfo GetTypeInfo(MemorySegment segment, SegmentScope scope) {
        return GetTypeInfo.ofAddress(GetTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor GetValueType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetValueType$MH = RuntimeHelper.downcallHandle(OrtApi.GetValueType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
     * }
     */
    public interface GetValueType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetValueType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetValueType.class, fi, OrtApi.GetValueType$FUNC, scope);
        }

        static GetValueType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetValueType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
     * }
     */
    public static MemorySegment GetValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetValueType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
     * }
     */
    public static void GetValueType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetValueType$VH.set(seg, x);
    }

    public static MemorySegment GetValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetValueType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValueType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetValueType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValueType GetValueType(MemorySegment segment, SegmentScope scope) {
        return GetValueType.ofAddress(GetValueType$get(segment), scope);
    }

    static final FunctionDescriptor CreateMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CreateMemoryInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public interface CreateMemoryInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateMemoryInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateMemoryInfo.class, fi, OrtApi.CreateMemoryInfo$FUNC, scope);
        }

        static CreateMemoryInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    int __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateMemoryInfo$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static MemorySegment CreateMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateMemoryInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static void CreateMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateMemoryInfo$VH.set(seg, x);
    }

    public static MemorySegment CreateMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateMemoryInfo CreateMemoryInfo(MemorySegment segment, SegmentScope scope) {
        return CreateMemoryInfo.ofAddress(CreateMemoryInfo$get(segment), scope);
    }

    static final FunctionDescriptor CreateCpuMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCpuMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CreateCpuMemoryInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public interface CreateCpuMemoryInfo {

        java.lang.foreign.MemorySegment apply(int _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateCpuMemoryInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateCpuMemoryInfo.class, fi, OrtApi.CreateCpuMemoryInfo$FUNC, scope);
        }

        static CreateCpuMemoryInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateCpuMemoryInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static MemorySegment CreateCpuMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCpuMemoryInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static void CreateCpuMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateCpuMemoryInfo$VH.set(seg, x);
    }

    public static MemorySegment CreateCpuMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCpuMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateCpuMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCpuMemoryInfo CreateCpuMemoryInfo(MemorySegment segment, SegmentScope scope) {
        return CreateCpuMemoryInfo.ofAddress(CreateCpuMemoryInfo$get(segment), scope);
    }

    static final FunctionDescriptor CompareMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CompareMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CompareMemoryInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CompareMemoryInfo)(const OrtMemoryInfo*,const OrtMemoryInfo*,int*);
     * }
     */
    public interface CompareMemoryInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CompareMemoryInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CompareMemoryInfo.class, fi, OrtApi.CompareMemoryInfo$FUNC, scope);
        }

        static CompareMemoryInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CompareMemoryInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CompareMemoryInfo)(const OrtMemoryInfo*,const OrtMemoryInfo*,int*);
     * }
     */
    public static MemorySegment CompareMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CompareMemoryInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CompareMemoryInfo)(const OrtMemoryInfo*,const OrtMemoryInfo*,int*);
     * }
     */
    public static void CompareMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CompareMemoryInfo$VH.set(seg, x);
    }

    public static MemorySegment CompareMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CompareMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CompareMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CompareMemoryInfo CompareMemoryInfo(MemorySegment segment, SegmentScope scope) {
        return CompareMemoryInfo.ofAddress(CompareMemoryInfo$get(segment), scope);
    }

    static final FunctionDescriptor MemoryInfoGetName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetName$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
     * }
     */
    public interface MemoryInfoGetName {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(MemoryInfoGetName.class, fi, OrtApi.MemoryInfoGetName$FUNC, scope);
        }

        static MemoryInfoGetName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.MemoryInfoGetName$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
     * }
     */
    public static MemorySegment MemoryInfoGetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
     * }
     */
    public static void MemoryInfoGetName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.MemoryInfoGetName$VH.set(seg, x);
    }

    public static MemorySegment MemoryInfoGetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.MemoryInfoGetName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetName MemoryInfoGetName(MemorySegment segment, SegmentScope scope) {
        return MemoryInfoGetName.ofAddress(MemoryInfoGetName$get(segment), scope);
    }

    static final FunctionDescriptor MemoryInfoGetId$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetId$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetId$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
     * }
     */
    public interface MemoryInfoGetId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetId fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(MemoryInfoGetId.class, fi, OrtApi.MemoryInfoGetId$FUNC, scope);
        }

        static MemoryInfoGetId ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetId$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
     * }
     */
    public static MemorySegment MemoryInfoGetId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetId$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
     * }
     */
    public static void MemoryInfoGetId$set(MemorySegment seg, MemorySegment x) {
        OrtApi.MemoryInfoGetId$VH.set(seg, x);
    }

    public static MemorySegment MemoryInfoGetId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.MemoryInfoGetId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetId MemoryInfoGetId(MemorySegment segment, SegmentScope scope) {
        return MemoryInfoGetId.ofAddress(MemoryInfoGetId$get(segment), scope);
    }

    static final FunctionDescriptor MemoryInfoGetMemType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetMemType$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetMemType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
     * }
     */
    public interface MemoryInfoGetMemType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetMemType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(MemoryInfoGetMemType.class, fi, OrtApi.MemoryInfoGetMemType$FUNC, scope);
        }

        static MemoryInfoGetMemType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.MemoryInfoGetMemType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
     * }
     */
    public static MemorySegment MemoryInfoGetMemType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetMemType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
     * }
     */
    public static void MemoryInfoGetMemType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.MemoryInfoGetMemType$VH.set(seg, x);
    }

    public static MemorySegment MemoryInfoGetMemType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetMemType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.MemoryInfoGetMemType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetMemType MemoryInfoGetMemType(MemorySegment segment, SegmentScope scope) {
        return MemoryInfoGetMemType.ofAddress(MemoryInfoGetMemType$get(segment), scope);
    }

    static final FunctionDescriptor MemoryInfoGetType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetType$MH = RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
     * }
     */
    public interface MemoryInfoGetType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(MemoryInfoGetType.class, fi, OrtApi.MemoryInfoGetType$FUNC, scope);
        }

        static MemoryInfoGetType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.MemoryInfoGetType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
     * }
     */
    public static MemorySegment MemoryInfoGetType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
     * }
     */
    public static void MemoryInfoGetType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.MemoryInfoGetType$VH.set(seg, x);
    }

    public static MemorySegment MemoryInfoGetType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.MemoryInfoGetType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetType MemoryInfoGetType(MemorySegment segment, SegmentScope scope) {
        return MemoryInfoGetType.ofAddress(MemoryInfoGetType$get(segment), scope);
    }

    static final FunctionDescriptor AllocatorAlloc$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AllocatorAlloc$MH = RuntimeHelper.downcallHandle(OrtApi.AllocatorAlloc$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
     * }
     */
    public interface AllocatorAlloc {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(AllocatorAlloc fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AllocatorAlloc.class, fi, OrtApi.AllocatorAlloc$FUNC, scope);
        }

        static AllocatorAlloc ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AllocatorAlloc$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
     * }
     */
    public static MemorySegment AllocatorAlloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AllocatorAlloc$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
     * }
     */
    public static void AllocatorAlloc$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AllocatorAlloc$VH.set(seg, x);
    }

    public static MemorySegment AllocatorAlloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AllocatorAlloc$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorAlloc$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AllocatorAlloc$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorAlloc AllocatorAlloc(MemorySegment segment, SegmentScope scope) {
        return AllocatorAlloc.ofAddress(AllocatorAlloc$get(segment), scope);
    }

    static final FunctionDescriptor AllocatorFree$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AllocatorFree$MH = RuntimeHelper.downcallHandle(OrtApi.AllocatorFree$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
     * }
     */
    public interface AllocatorFree {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(AllocatorFree fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AllocatorFree.class, fi, OrtApi.AllocatorFree$FUNC, scope);
        }

        static AllocatorFree ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.AllocatorFree$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
     * }
     */
    public static MemorySegment AllocatorFree$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AllocatorFree$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
     * }
     */
    public static void AllocatorFree$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AllocatorFree$VH.set(seg, x);
    }

    public static MemorySegment AllocatorFree$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AllocatorFree$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorFree$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AllocatorFree$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorFree AllocatorFree(MemorySegment segment, SegmentScope scope) {
        return AllocatorFree.ofAddress(AllocatorFree$get(segment), scope);
    }

    static final FunctionDescriptor AllocatorGetInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AllocatorGetInfo$MH = RuntimeHelper.downcallHandle(OrtApi.AllocatorGetInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public interface AllocatorGetInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(AllocatorGetInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AllocatorGetInfo.class, fi, OrtApi.AllocatorGetInfo$FUNC, scope);
        }

        static AllocatorGetInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.AllocatorGetInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public static MemorySegment AllocatorGetInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AllocatorGetInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public static void AllocatorGetInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AllocatorGetInfo$VH.set(seg, x);
    }

    public static MemorySegment AllocatorGetInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AllocatorGetInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AllocatorGetInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorGetInfo AllocatorGetInfo(MemorySegment segment, SegmentScope scope) {
        return AllocatorGetInfo.ofAddress(AllocatorGetInfo$get(segment), scope);
    }

    static final FunctionDescriptor GetAllocatorWithDefaultOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetAllocatorWithDefaultOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetAllocatorWithDefaultOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
     * }
     */
    public interface GetAllocatorWithDefaultOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetAllocatorWithDefaultOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetAllocatorWithDefaultOptions.class, fi, OrtApi.GetAllocatorWithDefaultOptions$FUNC, scope);
        }

        static GetAllocatorWithDefaultOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetAllocatorWithDefaultOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
     * }
     */
    public static MemorySegment GetAllocatorWithDefaultOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetAllocatorWithDefaultOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
     * }
     */
    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetAllocatorWithDefaultOptions$VH.set(seg, x);
    }

    public static MemorySegment GetAllocatorWithDefaultOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetAllocatorWithDefaultOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetAllocatorWithDefaultOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions(
            MemorySegment segment, SegmentScope scope) {
        return GetAllocatorWithDefaultOptions.ofAddress(GetAllocatorWithDefaultOptions$get(segment), scope);
    }

    static final FunctionDescriptor AddFreeDimensionOverride$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle AddFreeDimensionOverride$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddFreeDimensionOverride$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public interface AddFreeDimensionOverride {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverride fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverride.class, fi, OrtApi.AddFreeDimensionOverride$FUNC, scope);
        }

        static AddFreeDimensionOverride ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddFreeDimensionOverride$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static MemorySegment AddFreeDimensionOverride$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddFreeDimensionOverride$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static void AddFreeDimensionOverride$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddFreeDimensionOverride$VH.set(seg, x);
    }

    public static MemorySegment AddFreeDimensionOverride$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddFreeDimensionOverride$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddFreeDimensionOverride$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddFreeDimensionOverride AddFreeDimensionOverride(MemorySegment segment, SegmentScope scope) {
        return AddFreeDimensionOverride.ofAddress(AddFreeDimensionOverride$get(segment), scope);
    }

    static final FunctionDescriptor GetValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetValue$MH = RuntimeHelper.downcallHandle(OrtApi.GetValue$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetValue)(const OrtValue*,int,OrtAllocator*,OrtValue**);
     * }
     */
    public interface GetValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                int _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetValue.class, fi, OrtApi.GetValue$FUNC, scope);
        }

        static GetValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetValue$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValue)(const OrtValue*,int,OrtAllocator*,OrtValue**);
     * }
     */
    public static MemorySegment GetValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValue)(const OrtValue*,int,OrtAllocator*,OrtValue**);
     * }
     */
    public static void GetValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetValue$VH.set(seg, x);
    }

    public static MemorySegment GetValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValue GetValue(MemorySegment segment, SegmentScope scope) {
        return GetValue.ofAddress(GetValue$get(segment), scope);
    }

    static final FunctionDescriptor GetValueCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetValueCount$MH = RuntimeHelper.downcallHandle(OrtApi.GetValueCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
     * }
     */
    public interface GetValueCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetValueCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetValueCount.class, fi, OrtApi.GetValueCount$FUNC, scope);
        }

        static GetValueCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetValueCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
     * }
     */
    public static MemorySegment GetValueCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetValueCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
     * }
     */
    public static void GetValueCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetValueCount$VH.set(seg, x);
    }

    public static MemorySegment GetValueCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetValueCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValueCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetValueCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValueCount GetValueCount(MemorySegment segment, SegmentScope scope) {
        return GetValueCount.ofAddress(GetValueCount$get(segment), scope);
    }

    static final FunctionDescriptor CreateValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateValue$MH = RuntimeHelper.downcallHandle(OrtApi.CreateValue$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
     * }
     */
    public interface CreateValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, int _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateValue.class, fi, OrtApi.CreateValue$FUNC, scope);
        }

        static CreateValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateValue$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
     * }
     */
    public static MemorySegment CreateValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
     * }
     */
    public static void CreateValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateValue$VH.set(seg, x);
    }

    public static MemorySegment CreateValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateValue CreateValue(MemorySegment segment, SegmentScope scope) {
        return CreateValue.ofAddress(CreateValue$get(segment), scope);
    }

    static final FunctionDescriptor CreateOpaqueValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateOpaqueValue$MH = RuntimeHelper.downcallHandle(OrtApi.CreateOpaqueValue$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateOpaqueValue)(char*,char*,void*,size_t,OrtValue**);
     * }
     */
    public interface CreateOpaqueValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateOpaqueValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateOpaqueValue.class, fi, OrtApi.CreateOpaqueValue$FUNC, scope);
        }

        static CreateOpaqueValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateOpaqueValue$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpaqueValue)(char*,char*,void*,size_t,OrtValue**);
     * }
     */
    public static MemorySegment CreateOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateOpaqueValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpaqueValue)(char*,char*,void*,size_t,OrtValue**);
     * }
     */
    public static void CreateOpaqueValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateOpaqueValue$VH.set(seg, x);
    }

    public static MemorySegment CreateOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateOpaqueValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateOpaqueValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOpaqueValue CreateOpaqueValue(MemorySegment segment, SegmentScope scope) {
        return CreateOpaqueValue.ofAddress(CreateOpaqueValue$get(segment), scope);
    }

    static final FunctionDescriptor GetOpaqueValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetOpaqueValue$MH = RuntimeHelper.downcallHandle(OrtApi.GetOpaqueValue$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetOpaqueValue)(char*,char*,const OrtValue*,void*,size_t);
     * }
     */
    public interface GetOpaqueValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(GetOpaqueValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetOpaqueValue.class, fi, OrtApi.GetOpaqueValue$FUNC, scope);
        }

        static GetOpaqueValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetOpaqueValue$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOpaqueValue)(char*,char*,const OrtValue*,void*,size_t);
     * }
     */
    public static MemorySegment GetOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetOpaqueValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOpaqueValue)(char*,char*,const OrtValue*,void*,size_t);
     * }
     */
    public static void GetOpaqueValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetOpaqueValue$VH.set(seg, x);
    }

    public static MemorySegment GetOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetOpaqueValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOpaqueValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetOpaqueValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOpaqueValue GetOpaqueValue(MemorySegment segment, SegmentScope scope) {
        return GetOpaqueValue.ofAddress(GetOpaqueValue$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_float$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_float$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_float$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_float)(const OrtKernelInfo*,char*,float*);
     * }
     */
    public interface KernelInfoGetAttribute_float {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfoGetAttribute_float fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_float.class, fi, OrtApi.KernelInfoGetAttribute_float$FUNC, scope);
        }

        static KernelInfoGetAttribute_float ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfoGetAttribute_float$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_float)(const OrtKernelInfo*,char*,float*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfoGetAttribute_float$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_float)(const OrtKernelInfo*,char*,float*);
     * }
     */
    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_float$VH.set(seg, x);
    }

    public static MemorySegment KernelInfoGetAttribute_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfoGetAttribute_float$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_float$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_float KernelInfoGetAttribute_float(MemorySegment segment, SegmentScope scope) {
        return KernelInfoGetAttribute_float.ofAddress(KernelInfoGetAttribute_float$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_int64$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_int64$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_int64$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_int64)(const OrtKernelInfo*,char*,int64_t*);
     * }
     */
    public interface KernelInfoGetAttribute_int64 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfoGetAttribute_int64 fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_int64.class, fi, OrtApi.KernelInfoGetAttribute_int64$FUNC, scope);
        }

        static KernelInfoGetAttribute_int64 ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfoGetAttribute_int64$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_int64)(const OrtKernelInfo*,char*,int64_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfoGetAttribute_int64$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_int64)(const OrtKernelInfo*,char*,int64_t*);
     * }
     */
    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_int64$VH.set(seg, x);
    }

    public static MemorySegment KernelInfoGetAttribute_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfoGetAttribute_int64$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_int64$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_int64 KernelInfoGetAttribute_int64(MemorySegment segment, SegmentScope scope) {
        return KernelInfoGetAttribute_int64.ofAddress(KernelInfoGetAttribute_int64$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_string$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_string$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_string$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_string)(const OrtKernelInfo*,char*,char*,size_t*);
     * }
     */
    public interface KernelInfoGetAttribute_string {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttribute_string fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_string.class, fi, OrtApi.KernelInfoGetAttribute_string$FUNC, scope);
        }

        static KernelInfoGetAttribute_string ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfoGetAttribute_string$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_string)(const OrtKernelInfo*,char*,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_string$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfoGetAttribute_string$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_string)(const OrtKernelInfo*,char*,char*,size_t*);
     * }
     */
    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_string$VH.set(seg, x);
    }

    public static MemorySegment KernelInfoGetAttribute_string$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfoGetAttribute_string$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_string$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_string KernelInfoGetAttribute_string(
            MemorySegment segment, SegmentScope scope) {
        return KernelInfoGetAttribute_string.ofAddress(KernelInfoGetAttribute_string$get(segment), scope);
    }

    static final FunctionDescriptor KernelContext_GetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetInputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetInputCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public interface KernelContext_GetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetInputCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInputCount.class, fi, OrtApi.KernelContext_GetInputCount$FUNC, scope);
        }

        static KernelContext_GetInputCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelContext_GetInputCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static MemorySegment KernelContext_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetInputCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static void KernelContext_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelContext_GetInputCount$VH.set(seg, x);
    }

    public static MemorySegment KernelContext_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelContext_GetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelContext_GetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetInputCount KernelContext_GetInputCount(MemorySegment segment, SegmentScope scope) {
        return KernelContext_GetInputCount.ofAddress(KernelContext_GetInputCount$get(segment), scope);
    }

    static final FunctionDescriptor KernelContext_GetOutputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetOutputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetOutputCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public interface KernelContext_GetOutputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetOutputCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutputCount.class, fi, OrtApi.KernelContext_GetOutputCount$FUNC, scope);
        }

        static KernelContext_GetOutputCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelContext_GetOutputCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static MemorySegment KernelContext_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetOutputCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static void KernelContext_GetOutputCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelContext_GetOutputCount$VH.set(seg, x);
    }

    public static MemorySegment KernelContext_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelContext_GetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelContext_GetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetOutputCount KernelContext_GetOutputCount(MemorySegment segment, SegmentScope scope) {
        return KernelContext_GetOutputCount.ofAddress(KernelContext_GetOutputCount$get(segment), scope);
    }

    static final FunctionDescriptor KernelContext_GetInput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetInput$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetInput$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
     * }
     */
    public interface KernelContext_GetInput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelContext_GetInput fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInput.class, fi, OrtApi.KernelContext_GetInput$FUNC, scope);
        }

        static KernelContext_GetInput ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelContext_GetInput$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
     * }
     */
    public static MemorySegment KernelContext_GetInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetInput$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
     * }
     */
    public static void KernelContext_GetInput$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelContext_GetInput$VH.set(seg, x);
    }

    public static MemorySegment KernelContext_GetInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetInput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelContext_GetInput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetInput KernelContext_GetInput(MemorySegment segment, SegmentScope scope) {
        return KernelContext_GetInput.ofAddress(KernelContext_GetInput$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutput)(OrtKernelContext*,size_t,const int64_t*,size_t,OrtValue**);
     * }
     */
    public interface KernelContext_GetOutput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(KernelContext_GetOutput fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutput.class, fi, OrtApi.KernelContext_GetOutput$FUNC, scope);
        }

        static KernelContext_GetOutput ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelContext_GetOutput$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutput)(OrtKernelContext*,size_t,const int64_t*,size_t,OrtValue**);
     * }
     */
    public static MemorySegment KernelContext_GetOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetOutput$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutput)(OrtKernelContext*,size_t,const int64_t*,size_t,OrtValue**);
     * }
     */
    public static void KernelContext_GetOutput$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelContext_GetOutput$VH.set(seg, x);
    }

    public static MemorySegment KernelContext_GetOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetOutput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelContext_GetOutput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetOutput KernelContext_GetOutput(MemorySegment segment, SegmentScope scope) {
        return KernelContext_GetOutput.ofAddress(KernelContext_GetOutput$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseEnv$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseEnv$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseEnv$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseEnv)(OrtEnv*);
     * }
     */
    public interface ReleaseEnv {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseEnv fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseEnv.class, fi, OrtApi.ReleaseEnv$FUNC, scope);
        }

        static ReleaseEnv ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseEnv$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseEnv)(OrtEnv*);
     * }
     */
    public static MemorySegment ReleaseEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseEnv$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseEnv)(OrtEnv*);
     * }
     */
    public static void ReleaseEnv$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseEnv$VH.set(seg, x);
    }

    public static MemorySegment ReleaseEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseEnv$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseEnv$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseEnv$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseEnv ReleaseEnv(MemorySegment segment, SegmentScope scope) {
        return ReleaseEnv.ofAddress(ReleaseEnv$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseStatus$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseStatus$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseStatus$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseStatus)(OrtStatus*);
     * }
     */
    public interface ReleaseStatus {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseStatus fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseStatus.class, fi, OrtApi.ReleaseStatus$FUNC, scope);
        }

        static ReleaseStatus ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseStatus$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseStatus)(OrtStatus*);
     * }
     */
    public static MemorySegment ReleaseStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseStatus$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseStatus)(OrtStatus*);
     * }
     */
    public static void ReleaseStatus$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseStatus$VH.set(seg, x);
    }

    public static MemorySegment ReleaseStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseStatus$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseStatus$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseStatus$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseStatus ReleaseStatus(MemorySegment segment, SegmentScope scope) {
        return ReleaseStatus.ofAddress(ReleaseStatus$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseMemoryInfo$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseMemoryInfo$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
     * }
     */
    public interface ReleaseMemoryInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseMemoryInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseMemoryInfo.class, fi, OrtApi.ReleaseMemoryInfo$FUNC, scope);
        }

        static ReleaseMemoryInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseMemoryInfo$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
     * }
     */
    public static MemorySegment ReleaseMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseMemoryInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
     * }
     */
    public static void ReleaseMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseMemoryInfo$VH.set(seg, x);
    }

    public static MemorySegment ReleaseMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseMemoryInfo ReleaseMemoryInfo(MemorySegment segment, SegmentScope scope) {
        return ReleaseMemoryInfo.ofAddress(ReleaseMemoryInfo$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseSession$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseSession$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseSession$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseSession)(OrtSession*);
     * }
     */
    public interface ReleaseSession {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSession fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseSession.class, fi, OrtApi.ReleaseSession$FUNC, scope);
        }

        static ReleaseSession ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseSession$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSession)(OrtSession*);
     * }
     */
    public static MemorySegment ReleaseSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseSession$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSession)(OrtSession*);
     * }
     */
    public static void ReleaseSession$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseSession$VH.set(seg, x);
    }

    public static MemorySegment ReleaseSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseSession$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSession$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseSession$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSession ReleaseSession(MemorySegment segment, SegmentScope scope) {
        return ReleaseSession.ofAddress(ReleaseSession$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseValue$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseValue$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseValue$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseValue)(OrtValue*);
     * }
     */
    public interface ReleaseValue {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseValue.class, fi, OrtApi.ReleaseValue$FUNC, scope);
        }

        static ReleaseValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseValue$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseValue)(OrtValue*);
     * }
     */
    public static MemorySegment ReleaseValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseValue)(OrtValue*);
     * }
     */
    public static void ReleaseValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseValue$VH.set(seg, x);
    }

    public static MemorySegment ReleaseValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseValue ReleaseValue(MemorySegment segment, SegmentScope scope) {
        return ReleaseValue.ofAddress(ReleaseValue$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseRunOptions$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseRunOptions$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseRunOptions$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseRunOptions)(OrtRunOptions*);
     * }
     */
    public interface ReleaseRunOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseRunOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseRunOptions.class, fi, OrtApi.ReleaseRunOptions$FUNC, scope);
        }

        static ReleaseRunOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseRunOptions$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseRunOptions)(OrtRunOptions*);
     * }
     */
    public static MemorySegment ReleaseRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseRunOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseRunOptions)(OrtRunOptions*);
     * }
     */
    public static void ReleaseRunOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseRunOptions$VH.set(seg, x);
    }

    public static MemorySegment ReleaseRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseRunOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseRunOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseRunOptions ReleaseRunOptions(MemorySegment segment, SegmentScope scope) {
        return ReleaseRunOptions.ofAddress(ReleaseRunOptions$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseTypeInfo$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseTypeInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseTypeInfo$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseTypeInfo)(OrtTypeInfo*);
     * }
     */
    public interface ReleaseTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseTypeInfo.class, fi, OrtApi.ReleaseTypeInfo$FUNC, scope);
        }

        static ReleaseTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseTypeInfo$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTypeInfo)(OrtTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTypeInfo)(OrtTypeInfo*);
     * }
     */
    public static void ReleaseTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment ReleaseTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTypeInfo ReleaseTypeInfo(MemorySegment segment, SegmentScope scope) {
        return ReleaseTypeInfo.ofAddress(ReleaseTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseTensorTypeAndShapeInfo$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseTensorTypeAndShapeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
     * }
     */
    public interface ReleaseTensorTypeAndShapeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTensorTypeAndShapeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorTypeAndShapeInfo.class, fi, OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC, scope);
        }

        static ReleaseTensorTypeAndShapeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseTensorTypeAndShapeInfo$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static MemorySegment ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseTensorTypeAndShapeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseTensorTypeAndShapeInfo$VH.set(seg, x);
    }

    public static MemorySegment ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ReleaseTensorTypeAndShapeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseTensorTypeAndShapeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo(
            MemorySegment segment, SegmentScope scope) {
        return ReleaseTensorTypeAndShapeInfo.ofAddress(ReleaseTensorTypeAndShapeInfo$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseSessionOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseSessionOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseSessionOptions$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseSessionOptions)(OrtSessionOptions*);
     * }
     */
    public interface ReleaseSessionOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSessionOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseSessionOptions.class, fi, OrtApi.ReleaseSessionOptions$FUNC, scope);
        }

        static ReleaseSessionOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseSessionOptions$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSessionOptions)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment ReleaseSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseSessionOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSessionOptions)(OrtSessionOptions*);
     * }
     */
    public static void ReleaseSessionOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseSessionOptions$VH.set(seg, x);
    }

    public static MemorySegment ReleaseSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSessionOptions ReleaseSessionOptions(MemorySegment segment, SegmentScope scope) {
        return ReleaseSessionOptions.ofAddress(ReleaseSessionOptions$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseCustomOpDomain$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseCustomOpDomain$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseCustomOpDomain$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
     * }
     */
    public interface ReleaseCustomOpDomain {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCustomOpDomain fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseCustomOpDomain.class, fi, OrtApi.ReleaseCustomOpDomain$FUNC, scope);
        }

        static ReleaseCustomOpDomain ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseCustomOpDomain$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
     * }
     */
    public static MemorySegment ReleaseCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseCustomOpDomain$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
     * }
     */
    public static void ReleaseCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseCustomOpDomain$VH.set(seg, x);
    }

    public static MemorySegment ReleaseCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCustomOpDomain ReleaseCustomOpDomain(MemorySegment segment, SegmentScope scope) {
        return ReleaseCustomOpDomain.ofAddress(ReleaseCustomOpDomain$get(segment), scope);
    }

    static final FunctionDescriptor GetDenotationFromTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetDenotationFromTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetDenotationFromTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetDenotationFromTypeInfo)(const OrtTypeInfo*,char**,size_t*);
     * }
     */
    public interface GetDenotationFromTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetDenotationFromTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetDenotationFromTypeInfo.class, fi, OrtApi.GetDenotationFromTypeInfo$FUNC, scope);
        }

        static GetDenotationFromTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetDenotationFromTypeInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDenotationFromTypeInfo)(const OrtTypeInfo*,char**,size_t*);
     * }
     */
    public static MemorySegment GetDenotationFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetDenotationFromTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDenotationFromTypeInfo)(const OrtTypeInfo*,char**,size_t*);
     * }
     */
    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetDenotationFromTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment GetDenotationFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetDenotationFromTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetDenotationFromTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDenotationFromTypeInfo GetDenotationFromTypeInfo(MemorySegment segment, SegmentScope scope) {
        return GetDenotationFromTypeInfo.ofAddress(GetDenotationFromTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor CastTypeInfoToMapTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToMapTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToMapTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
     * }
     */
    public interface CastTypeInfoToMapTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToMapTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToMapTypeInfo.class, fi, OrtApi.CastTypeInfoToMapTypeInfo$FUNC, scope);
        }

        static CastTypeInfoToMapTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CastTypeInfoToMapTypeInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CastTypeInfoToMapTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
     * }
     */
    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CastTypeInfoToMapTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment CastTypeInfoToMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CastTypeInfoToMapTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CastTypeInfoToMapTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo(MemorySegment segment, SegmentScope scope) {
        return CastTypeInfoToMapTypeInfo.ofAddress(CastTypeInfoToMapTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor CastTypeInfoToSequenceTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CastTypeInfoToSequenceTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
     * }
     */
    public interface CastTypeInfoToSequenceTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToSequenceTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToSequenceTypeInfo.class, fi, OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC, scope);
        }

        static CastTypeInfoToSequenceTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CastTypeInfoToSequenceTypeInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CastTypeInfoToSequenceTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
     * }
     */
    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CastTypeInfoToSequenceTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CastTypeInfoToSequenceTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CastTypeInfoToSequenceTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo(
            MemorySegment segment, SegmentScope scope) {
        return CastTypeInfoToSequenceTypeInfo.ofAddress(CastTypeInfoToSequenceTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor GetMapKeyType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetMapKeyType$MH = RuntimeHelper.downcallHandle(OrtApi.GetMapKeyType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public interface GetMapKeyType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetMapKeyType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetMapKeyType.class, fi, OrtApi.GetMapKeyType$FUNC, scope);
        }

        static GetMapKeyType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetMapKeyType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static MemorySegment GetMapKeyType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetMapKeyType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static void GetMapKeyType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetMapKeyType$VH.set(seg, x);
    }

    public static MemorySegment GetMapKeyType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetMapKeyType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetMapKeyType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetMapKeyType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetMapKeyType GetMapKeyType(MemorySegment segment, SegmentScope scope) {
        return GetMapKeyType.ofAddress(GetMapKeyType$get(segment), scope);
    }

    static final FunctionDescriptor GetMapValueType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetMapValueType$MH = RuntimeHelper.downcallHandle(OrtApi.GetMapValueType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
     * }
     */
    public interface GetMapValueType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetMapValueType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetMapValueType.class, fi, OrtApi.GetMapValueType$FUNC, scope);
        }

        static GetMapValueType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetMapValueType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetMapValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetMapValueType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static void GetMapValueType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetMapValueType$VH.set(seg, x);
    }

    public static MemorySegment GetMapValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetMapValueType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetMapValueType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetMapValueType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetMapValueType GetMapValueType(MemorySegment segment, SegmentScope scope) {
        return GetMapValueType.ofAddress(GetMapValueType$get(segment), scope);
    }

    static final FunctionDescriptor GetSequenceElementType$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSequenceElementType$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSequenceElementType$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
     * }
     */
    public interface GetSequenceElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSequenceElementType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSequenceElementType.class, fi, OrtApi.GetSequenceElementType$FUNC, scope);
        }

        static GetSequenceElementType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSequenceElementType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetSequenceElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSequenceElementType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static void GetSequenceElementType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSequenceElementType$VH.set(seg, x);
    }

    public static MemorySegment GetSequenceElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSequenceElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSequenceElementType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSequenceElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSequenceElementType GetSequenceElementType(MemorySegment segment, SegmentScope scope) {
        return GetSequenceElementType.ofAddress(GetSequenceElementType$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseMapTypeInfo$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseMapTypeInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseMapTypeInfo$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
     * }
     */
    public interface ReleaseMapTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseMapTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseMapTypeInfo.class, fi, OrtApi.ReleaseMapTypeInfo$FUNC, scope);
        }

        static ReleaseMapTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseMapTypeInfo$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseMapTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
     * }
     */
    public static void ReleaseMapTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseMapTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment ReleaseMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseMapTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseMapTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseMapTypeInfo ReleaseMapTypeInfo(MemorySegment segment, SegmentScope scope) {
        return ReleaseMapTypeInfo.ofAddress(ReleaseMapTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseSequenceTypeInfo$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseSequenceTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseSequenceTypeInfo$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
     * }
     */
    public interface ReleaseSequenceTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSequenceTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseSequenceTypeInfo.class, fi, OrtApi.ReleaseSequenceTypeInfo$FUNC, scope);
        }

        static ReleaseSequenceTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseSequenceTypeInfo$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseSequenceTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
     * }
     */
    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseSequenceTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment ReleaseSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseSequenceTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseSequenceTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSequenceTypeInfo ReleaseSequenceTypeInfo(MemorySegment segment, SegmentScope scope) {
        return ReleaseSequenceTypeInfo.ofAddress(ReleaseSequenceTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor SessionEndProfiling$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionEndProfiling$MH = RuntimeHelper.downcallHandle(OrtApi.SessionEndProfiling$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionEndProfiling)(OrtSession*,OrtAllocator*,char**);
     * }
     */
    public interface SessionEndProfiling {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionEndProfiling fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SessionEndProfiling.class, fi, OrtApi.SessionEndProfiling$FUNC, scope);
        }

        static SessionEndProfiling ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionEndProfiling$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionEndProfiling)(OrtSession*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionEndProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionEndProfiling$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionEndProfiling)(OrtSession*,OrtAllocator*,char**);
     * }
     */
    public static void SessionEndProfiling$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionEndProfiling$VH.set(seg, x);
    }

    public static MemorySegment SessionEndProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionEndProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionEndProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionEndProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionEndProfiling SessionEndProfiling(MemorySegment segment, SegmentScope scope) {
        return SessionEndProfiling.ofAddress(SessionEndProfiling$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetModelMetadata$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetModelMetadata$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetModelMetadata$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
     * }
     */
    public interface SessionGetModelMetadata {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetModelMetadata fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetModelMetadata.class, fi, OrtApi.SessionGetModelMetadata$FUNC, scope);
        }

        static SessionGetModelMetadata ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetModelMetadata$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
     * }
     */
    public static MemorySegment SessionGetModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetModelMetadata$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
     * }
     */
    public static void SessionGetModelMetadata$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetModelMetadata$VH.set(seg, x);
    }

    public static MemorySegment SessionGetModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetModelMetadata$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetModelMetadata$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetModelMetadata SessionGetModelMetadata(MemorySegment segment, SegmentScope scope) {
        return SessionGetModelMetadata.ofAddress(SessionGetModelMetadata$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetProducerName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetProducerName$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetProducerName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetProducerName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetProducerName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ModelMetadataGetProducerName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetProducerName.class, fi, OrtApi.ModelMetadataGetProducerName$FUNC, scope);
        }

        static ModelMetadataGetProducerName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetProducerName$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetProducerName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetProducerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetProducerName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetProducerName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetProducerName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetProducerName$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetProducerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ModelMetadataGetProducerName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetProducerName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetProducerName ModelMetadataGetProducerName(MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetProducerName.ofAddress(ModelMetadataGetProducerName$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetGraphName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetGraphName$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetGraphName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetGraphName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ModelMetadataGetGraphName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphName.class, fi, OrtApi.ModelMetadataGetGraphName$FUNC, scope);
        }

        static ModelMetadataGetGraphName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetGraphName$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetGraphName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetGraphName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetGraphName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetGraphName$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetGraphName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetGraphName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetGraphName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetGraphName ModelMetadataGetGraphName(MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetGraphName.ofAddress(ModelMetadataGetGraphName$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetDomain$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetDomain$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetDomain$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDomain)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetDomain {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ModelMetadataGetDomain fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDomain.class, fi, OrtApi.ModelMetadataGetDomain$FUNC, scope);
        }

        static ModelMetadataGetDomain ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetDomain$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDomain)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetDomain$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDomain)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetDomain$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetDomain$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetDomain ModelMetadataGetDomain(MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetDomain.ofAddress(ModelMetadataGetDomain$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetDescription$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetDescription$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetDescription$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetDescription {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ModelMetadataGetDescription fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDescription.class, fi, OrtApi.ModelMetadataGetDescription$FUNC, scope);
        }

        static ModelMetadataGetDescription ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetDescription$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetDescription$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetDescription$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetDescription$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ModelMetadataGetDescription$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetDescription$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetDescription ModelMetadataGetDescription(MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetDescription.ofAddress(ModelMetadataGetDescription$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataLookupCustomMetadataMap$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataLookupCustomMetadataMap$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataLookupCustomMetadataMap)(const OrtModelMetadata*,OrtAllocator*,char*,char**);
     * }
     */
    public interface ModelMetadataLookupCustomMetadataMap {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(ModelMetadataLookupCustomMetadataMap fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataLookupCustomMetadataMap.class,
                    fi,
                    OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC,
                    scope);
        }

        static ModelMetadataLookupCustomMetadataMap ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataLookupCustomMetadataMap$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataLookupCustomMetadataMap)(const OrtModelMetadata*,OrtAllocator*,char*,char**);
     * }
     */
    public static MemorySegment ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataLookupCustomMetadataMap$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataLookupCustomMetadataMap)(const OrtModelMetadata*,OrtAllocator*,char*,char**);
     * }
     */
    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataLookupCustomMetadataMap$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ModelMetadataLookupCustomMetadataMap$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataLookupCustomMetadataMap$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap(
            MemorySegment segment, SegmentScope scope) {
        return ModelMetadataLookupCustomMetadataMap.ofAddress(ModelMetadataLookupCustomMetadataMap$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetVersion$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetVersion$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetVersion$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
     * }
     */
    public interface ModelMetadataGetVersion {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(ModelMetadataGetVersion fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetVersion.class, fi, OrtApi.ModelMetadataGetVersion$FUNC, scope);
        }

        static ModelMetadataGetVersion ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetVersion$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
     * }
     */
    public static MemorySegment ModelMetadataGetVersion$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetVersion$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
     * }
     */
    public static void ModelMetadataGetVersion$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetVersion$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetVersion$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetVersion$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetVersion$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetVersion ModelMetadataGetVersion(MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetVersion.ofAddress(ModelMetadataGetVersion$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseModelMetadata$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseModelMetadata$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseModelMetadata$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseModelMetadata)(OrtModelMetadata*);
     * }
     */
    public interface ReleaseModelMetadata {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseModelMetadata fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseModelMetadata.class, fi, OrtApi.ReleaseModelMetadata$FUNC, scope);
        }

        static ReleaseModelMetadata ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseModelMetadata$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseModelMetadata)(OrtModelMetadata*);
     * }
     */
    public static MemorySegment ReleaseModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseModelMetadata$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseModelMetadata)(OrtModelMetadata*);
     * }
     */
    public static void ReleaseModelMetadata$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseModelMetadata$VH.set(seg, x);
    }

    public static MemorySegment ReleaseModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseModelMetadata$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseModelMetadata$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseModelMetadata ReleaseModelMetadata(MemorySegment segment, SegmentScope scope) {
        return ReleaseModelMetadata.ofAddress(ReleaseModelMetadata$get(segment), scope);
    }

    static final FunctionDescriptor CreateEnvWithGlobalThreadPools$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateEnvWithGlobalThreadPools$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateEnvWithGlobalThreadPools$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithGlobalThreadPools)(OrtLoggingLevel,char*,const OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public interface CreateEnvWithGlobalThreadPools {

        java.lang.foreign.MemorySegment apply(
                int _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateEnvWithGlobalThreadPools fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithGlobalThreadPools.class, fi, OrtApi.CreateEnvWithGlobalThreadPools$FUNC, scope);
        }

        static CreateEnvWithGlobalThreadPools ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateEnvWithGlobalThreadPools$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithGlobalThreadPools)(OrtLoggingLevel,char*,const OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateEnvWithGlobalThreadPools$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithGlobalThreadPools)(OrtLoggingLevel,char*,const OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateEnvWithGlobalThreadPools$VH.set(seg, x);
    }

    public static MemorySegment CreateEnvWithGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateEnvWithGlobalThreadPools$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateEnvWithGlobalThreadPools$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithGlobalThreadPools CreateEnvWithGlobalThreadPools(
            MemorySegment segment, SegmentScope scope) {
        return CreateEnvWithGlobalThreadPools.ofAddress(CreateEnvWithGlobalThreadPools$get(segment), scope);
    }

    static final FunctionDescriptor DisablePerSessionThreads$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle DisablePerSessionThreads$MH =
            RuntimeHelper.downcallHandle(OrtApi.DisablePerSessionThreads$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
     * }
     */
    public interface DisablePerSessionThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisablePerSessionThreads fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    DisablePerSessionThreads.class, fi, OrtApi.DisablePerSessionThreads$FUNC, scope);
        }

        static DisablePerSessionThreads ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.DisablePerSessionThreads$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisablePerSessionThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisablePerSessionThreads$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
     * }
     */
    public static void DisablePerSessionThreads$set(MemorySegment seg, MemorySegment x) {
        OrtApi.DisablePerSessionThreads$VH.set(seg, x);
    }

    public static MemorySegment DisablePerSessionThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.DisablePerSessionThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.DisablePerSessionThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisablePerSessionThreads DisablePerSessionThreads(MemorySegment segment, SegmentScope scope) {
        return DisablePerSessionThreads.ofAddress(DisablePerSessionThreads$get(segment), scope);
    }

    static final FunctionDescriptor CreateThreadingOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateThreadingOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateThreadingOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
     * }
     */
    public interface CreateThreadingOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateThreadingOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateThreadingOptions.class, fi, OrtApi.CreateThreadingOptions$FUNC, scope);
        }

        static CreateThreadingOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateThreadingOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
     * }
     */
    public static MemorySegment CreateThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateThreadingOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
     * }
     */
    public static void CreateThreadingOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateThreadingOptions$VH.set(seg, x);
    }

    public static MemorySegment CreateThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateThreadingOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateThreadingOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateThreadingOptions CreateThreadingOptions(MemorySegment segment, SegmentScope scope) {
        return CreateThreadingOptions.ofAddress(CreateThreadingOptions$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseThreadingOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseThreadingOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseThreadingOptions$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
     * }
     */
    public interface ReleaseThreadingOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseThreadingOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseThreadingOptions.class, fi, OrtApi.ReleaseThreadingOptions$FUNC, scope);
        }

        static ReleaseThreadingOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseThreadingOptions$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
     * }
     */
    public static MemorySegment ReleaseThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseThreadingOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
     * }
     */
    public static void ReleaseThreadingOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseThreadingOptions$VH.set(seg, x);
    }

    public static MemorySegment ReleaseThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseThreadingOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseThreadingOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseThreadingOptions ReleaseThreadingOptions(MemorySegment segment, SegmentScope scope) {
        return ReleaseThreadingOptions.ofAddress(ReleaseThreadingOptions$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetCustomMetadataMapKeys$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetCustomMetadataMapKeys$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetCustomMetadataMapKeys)(const OrtModelMetadata*,OrtAllocator*,char***,int64_t*);
     * }
     */
    public interface ModelMetadataGetCustomMetadataMapKeys {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(ModelMetadataGetCustomMetadataMapKeys fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetCustomMetadataMapKeys.class,
                    fi,
                    OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC,
                    scope);
        }

        static ModelMetadataGetCustomMetadataMapKeys ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetCustomMetadataMapKeys$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetCustomMetadataMapKeys)(const OrtModelMetadata*,OrtAllocator*,char***,int64_t*);
     * }
     */
    public static MemorySegment ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetCustomMetadataMapKeys)(const OrtModelMetadata*,OrtAllocator*,char***,int64_t*);
     * }
     */
    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys(
            MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetCustomMetadataMapKeys.ofAddress(
                ModelMetadataGetCustomMetadataMapKeys$get(segment), scope);
    }

    static final FunctionDescriptor AddFreeDimensionOverrideByName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle AddFreeDimensionOverrideByName$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddFreeDimensionOverrideByName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public interface AddFreeDimensionOverrideByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverrideByName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverrideByName.class, fi, OrtApi.AddFreeDimensionOverrideByName$FUNC, scope);
        }

        static AddFreeDimensionOverrideByName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddFreeDimensionOverrideByName$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static MemorySegment AddFreeDimensionOverrideByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddFreeDimensionOverrideByName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddFreeDimensionOverrideByName$VH.set(seg, x);
    }

    public static MemorySegment AddFreeDimensionOverrideByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.AddFreeDimensionOverrideByName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddFreeDimensionOverrideByName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddFreeDimensionOverrideByName AddFreeDimensionOverrideByName(
            MemorySegment segment, SegmentScope scope) {
        return AddFreeDimensionOverrideByName.ofAddress(AddFreeDimensionOverrideByName$get(segment), scope);
    }

    static final FunctionDescriptor GetAvailableProviders$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetAvailableProviders$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetAvailableProviders$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetAvailableProviders)(char***,int*);
     * }
     */
    public interface GetAvailableProviders {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetAvailableProviders fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetAvailableProviders.class, fi, OrtApi.GetAvailableProviders$FUNC, scope);
        }

        static GetAvailableProviders ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetAvailableProviders$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAvailableProviders)(char***,int*);
     * }
     */
    public static MemorySegment GetAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetAvailableProviders$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAvailableProviders)(char***,int*);
     * }
     */
    public static void GetAvailableProviders$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetAvailableProviders$VH.set(seg, x);
    }

    public static MemorySegment GetAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetAvailableProviders$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetAvailableProviders$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetAvailableProviders$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetAvailableProviders GetAvailableProviders(MemorySegment segment, SegmentScope scope) {
        return GetAvailableProviders.ofAddress(GetAvailableProviders$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseAvailableProviders$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle ReleaseAvailableProviders$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseAvailableProviders$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public interface ReleaseAvailableProviders {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(ReleaseAvailableProviders fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseAvailableProviders.class, fi, OrtApi.ReleaseAvailableProviders$FUNC, scope);
        }

        static ReleaseAvailableProviders ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ReleaseAvailableProviders$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public static MemorySegment ReleaseAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseAvailableProviders$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public static void ReleaseAvailableProviders$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseAvailableProviders$VH.set(seg, x);
    }

    public static MemorySegment ReleaseAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseAvailableProviders$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseAvailableProviders$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseAvailableProviders ReleaseAvailableProviders(MemorySegment segment, SegmentScope scope) {
        return ReleaseAvailableProviders.ofAddress(ReleaseAvailableProviders$get(segment), scope);
    }

    static final FunctionDescriptor GetStringTensorElementLength$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetStringTensorElementLength$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorElementLength$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
     * }
     */
    public interface GetStringTensorElementLength {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetStringTensorElementLength fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElementLength.class, fi, OrtApi.GetStringTensorElementLength$FUNC, scope);
        }

        static GetStringTensorElementLength ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetStringTensorElementLength$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
     * }
     */
    public static MemorySegment GetStringTensorElementLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorElementLength$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
     * }
     */
    public static void GetStringTensorElementLength$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetStringTensorElementLength$VH.set(seg, x);
    }

    public static MemorySegment GetStringTensorElementLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetStringTensorElementLength$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetStringTensorElementLength$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorElementLength GetStringTensorElementLength(MemorySegment segment, SegmentScope scope) {
        return GetStringTensorElementLength.ofAddress(GetStringTensorElementLength$get(segment), scope);
    }

    static final FunctionDescriptor GetStringTensorElement$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetStringTensorElement$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetStringTensorElement$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
     * }
     */
    public interface GetStringTensorElement {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, long _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetStringTensorElement fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElement.class, fi, OrtApi.GetStringTensorElement$FUNC, scope);
        }

        static GetStringTensorElement ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetStringTensorElement$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
     * }
     */
    public static MemorySegment GetStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorElement$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
     * }
     */
    public static void GetStringTensorElement$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetStringTensorElement$VH.set(seg, x);
    }

    public static MemorySegment GetStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetStringTensorElement$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorElement$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetStringTensorElement$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorElement GetStringTensorElement(MemorySegment segment, SegmentScope scope) {
        return GetStringTensorElement.ofAddress(GetStringTensorElement$get(segment), scope);
    }

    static final FunctionDescriptor FillStringTensorElement$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle FillStringTensorElement$MH =
            RuntimeHelper.downcallHandle(OrtApi.FillStringTensorElement$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
     * }
     */
    public interface FillStringTensorElement {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(FillStringTensorElement fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    FillStringTensorElement.class, fi, OrtApi.FillStringTensorElement$FUNC, scope);
        }

        static FillStringTensorElement ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.FillStringTensorElement$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
     * }
     */
    public static MemorySegment FillStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillStringTensorElement$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
     * }
     */
    public static void FillStringTensorElement$set(MemorySegment seg, MemorySegment x) {
        OrtApi.FillStringTensorElement$VH.set(seg, x);
    }

    public static MemorySegment FillStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillStringTensorElement$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillStringTensorElement$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.FillStringTensorElement$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillStringTensorElement FillStringTensorElement(MemorySegment segment, SegmentScope scope) {
        return FillStringTensorElement.ofAddress(FillStringTensorElement$get(segment), scope);
    }

    static final FunctionDescriptor AddSessionConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddSessionConfigEntry$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddSessionConfigEntry$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddSessionConfigEntry)(OrtSessionOptions*,char*,char*);
     * }
     */
    public interface AddSessionConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(AddSessionConfigEntry fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AddSessionConfigEntry.class, fi, OrtApi.AddSessionConfigEntry$FUNC, scope);
        }

        static AddSessionConfigEntry ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddSessionConfigEntry$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddSessionConfigEntry)(OrtSessionOptions*,char*,char*);
     * }
     */
    public static MemorySegment AddSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddSessionConfigEntry$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddSessionConfigEntry)(OrtSessionOptions*,char*,char*);
     * }
     */
    public static void AddSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddSessionConfigEntry$VH.set(seg, x);
    }

    public static MemorySegment AddSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddSessionConfigEntry AddSessionConfigEntry(MemorySegment segment, SegmentScope scope) {
        return AddSessionConfigEntry.ofAddress(AddSessionConfigEntry$get(segment), scope);
    }

    static final FunctionDescriptor CreateAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.CreateAllocator$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateAllocator)(const OrtSession*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public interface CreateAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateAllocator fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateAllocator.class, fi, OrtApi.CreateAllocator$FUNC, scope);
        }

        static CreateAllocator ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateAllocator$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAllocator)(const OrtSession*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public static MemorySegment CreateAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateAllocator$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAllocator)(const OrtSession*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public static void CreateAllocator$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateAllocator$VH.set(seg, x);
    }

    public static MemorySegment CreateAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAllocator CreateAllocator(MemorySegment segment, SegmentScope scope) {
        return CreateAllocator.ofAddress(CreateAllocator$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseAllocator$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseAllocator$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseAllocator)(OrtAllocator*);
     * }
     */
    public interface ReleaseAllocator {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseAllocator fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseAllocator.class, fi, OrtApi.ReleaseAllocator$FUNC, scope);
        }

        static ReleaseAllocator ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseAllocator$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseAllocator)(OrtAllocator*);
     * }
     */
    public static MemorySegment ReleaseAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseAllocator$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseAllocator)(OrtAllocator*);
     * }
     */
    public static void ReleaseAllocator$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseAllocator$VH.set(seg, x);
    }

    public static MemorySegment ReleaseAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseAllocator ReleaseAllocator(MemorySegment segment, SegmentScope scope) {
        return ReleaseAllocator.ofAddress(ReleaseAllocator$get(segment), scope);
    }

    static final FunctionDescriptor RunWithBinding$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RunWithBinding$MH = RuntimeHelper.downcallHandle(OrtApi.RunWithBinding$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RunWithBinding)(OrtSession*,const OrtRunOptions*,const OrtIoBinding*);
     * }
     */
    public interface RunWithBinding {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(RunWithBinding fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(RunWithBinding.class, fi, OrtApi.RunWithBinding$FUNC, scope);
        }

        static RunWithBinding ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RunWithBinding$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunWithBinding)(OrtSession*,const OrtRunOptions*,const OrtIoBinding*);
     * }
     */
    public static MemorySegment RunWithBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunWithBinding$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunWithBinding)(OrtSession*,const OrtRunOptions*,const OrtIoBinding*);
     * }
     */
    public static void RunWithBinding$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RunWithBinding$VH.set(seg, x);
    }

    public static MemorySegment RunWithBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RunWithBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunWithBinding$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RunWithBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunWithBinding RunWithBinding(MemorySegment segment, SegmentScope scope) {
        return RunWithBinding.ofAddress(RunWithBinding$get(segment), scope);
    }

    static final FunctionDescriptor CreateIoBinding$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateIoBinding$MH = RuntimeHelper.downcallHandle(OrtApi.CreateIoBinding$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
     * }
     */
    public interface CreateIoBinding {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateIoBinding fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateIoBinding.class, fi, OrtApi.CreateIoBinding$FUNC, scope);
        }

        static CreateIoBinding ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateIoBinding$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
     * }
     */
    public static MemorySegment CreateIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateIoBinding$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
     * }
     */
    public static void CreateIoBinding$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateIoBinding$VH.set(seg, x);
    }

    public static MemorySegment CreateIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateIoBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateIoBinding$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateIoBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateIoBinding CreateIoBinding(MemorySegment segment, SegmentScope scope) {
        return CreateIoBinding.ofAddress(CreateIoBinding$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseIoBinding$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseIoBinding$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseIoBinding$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseIoBinding)(OrtIoBinding*);
     * }
     */
    public interface ReleaseIoBinding {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseIoBinding fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseIoBinding.class, fi, OrtApi.ReleaseIoBinding$FUNC, scope);
        }

        static ReleaseIoBinding ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseIoBinding$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseIoBinding)(OrtIoBinding*);
     * }
     */
    public static MemorySegment ReleaseIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseIoBinding$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseIoBinding)(OrtIoBinding*);
     * }
     */
    public static void ReleaseIoBinding$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseIoBinding$VH.set(seg, x);
    }

    public static MemorySegment ReleaseIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseIoBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseIoBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseIoBinding ReleaseIoBinding(MemorySegment segment, SegmentScope scope) {
        return ReleaseIoBinding.ofAddress(ReleaseIoBinding$get(segment), scope);
    }

    static final FunctionDescriptor BindInput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle BindInput$MH = RuntimeHelper.downcallHandle(OrtApi.BindInput$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*BindInput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public interface BindInput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(BindInput fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(BindInput.class, fi, OrtApi.BindInput$FUNC, scope);
        }

        static BindInput ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.BindInput$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*BindInput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static MemorySegment BindInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.BindInput$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*BindInput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static void BindInput$set(MemorySegment seg, MemorySegment x) {
        OrtApi.BindInput$VH.set(seg, x);
    }

    public static MemorySegment BindInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.BindInput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindInput$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.BindInput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindInput BindInput(MemorySegment segment, SegmentScope scope) {
        return BindInput.ofAddress(BindInput$get(segment), scope);
    }

    static final FunctionDescriptor BindOutput$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle BindOutput$MH = RuntimeHelper.downcallHandle(OrtApi.BindOutput$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*BindOutput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public interface BindOutput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(BindOutput fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(BindOutput.class, fi, OrtApi.BindOutput$FUNC, scope);
        }

        static BindOutput ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.BindOutput$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static MemorySegment BindOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.BindOutput$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static void BindOutput$set(MemorySegment seg, MemorySegment x) {
        OrtApi.BindOutput$VH.set(seg, x);
    }

    public static MemorySegment BindOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.BindOutput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindOutput$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.BindOutput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindOutput BindOutput(MemorySegment segment, SegmentScope scope) {
        return BindOutput.ofAddress(BindOutput$get(segment), scope);
    }

    static final FunctionDescriptor BindOutputToDevice$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle BindOutputToDevice$MH = RuntimeHelper.downcallHandle(OrtApi.BindOutputToDevice$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*BindOutputToDevice)(OrtIoBinding*,char*,const OrtMemoryInfo*);
     * }
     */
    public interface BindOutputToDevice {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(BindOutputToDevice fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(BindOutputToDevice.class, fi, OrtApi.BindOutputToDevice$FUNC, scope);
        }

        static BindOutputToDevice ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.BindOutputToDevice$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutputToDevice)(OrtIoBinding*,char*,const OrtMemoryInfo*);
     * }
     */
    public static MemorySegment BindOutputToDevice$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.BindOutputToDevice$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutputToDevice)(OrtIoBinding*,char*,const OrtMemoryInfo*);
     * }
     */
    public static void BindOutputToDevice$set(MemorySegment seg, MemorySegment x) {
        OrtApi.BindOutputToDevice$VH.set(seg, x);
    }

    public static MemorySegment BindOutputToDevice$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.BindOutputToDevice$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindOutputToDevice$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.BindOutputToDevice$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindOutputToDevice BindOutputToDevice(MemorySegment segment, SegmentScope scope) {
        return BindOutputToDevice.ofAddress(BindOutputToDevice$get(segment), scope);
    }

    static final FunctionDescriptor GetBoundOutputNames$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetBoundOutputNames$MH = RuntimeHelper.downcallHandle(OrtApi.GetBoundOutputNames$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputNames)(const OrtIoBinding*,OrtAllocator*,char**,size_t**,size_t*);
     * }
     */
    public interface GetBoundOutputNames {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(GetBoundOutputNames fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetBoundOutputNames.class, fi, OrtApi.GetBoundOutputNames$FUNC, scope);
        }

        static GetBoundOutputNames ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetBoundOutputNames$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputNames)(const OrtIoBinding*,OrtAllocator*,char**,size_t**,size_t*);
     * }
     */
    public static MemorySegment GetBoundOutputNames$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetBoundOutputNames$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputNames)(const OrtIoBinding*,OrtAllocator*,char**,size_t**,size_t*);
     * }
     */
    public static void GetBoundOutputNames$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetBoundOutputNames$VH.set(seg, x);
    }

    public static MemorySegment GetBoundOutputNames$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetBoundOutputNames$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetBoundOutputNames$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBoundOutputNames GetBoundOutputNames(MemorySegment segment, SegmentScope scope) {
        return GetBoundOutputNames.ofAddress(GetBoundOutputNames$get(segment), scope);
    }

    static final FunctionDescriptor GetBoundOutputValues$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetBoundOutputValues$MH = RuntimeHelper.downcallHandle(OrtApi.GetBoundOutputValues$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputValues)(const OrtIoBinding*,OrtAllocator*,OrtValue***,size_t*);
     * }
     */
    public interface GetBoundOutputValues {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetBoundOutputValues fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetBoundOutputValues.class, fi, OrtApi.GetBoundOutputValues$FUNC, scope);
        }

        static GetBoundOutputValues ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetBoundOutputValues$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputValues)(const OrtIoBinding*,OrtAllocator*,OrtValue***,size_t*);
     * }
     */
    public static MemorySegment GetBoundOutputValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetBoundOutputValues$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputValues)(const OrtIoBinding*,OrtAllocator*,OrtValue***,size_t*);
     * }
     */
    public static void GetBoundOutputValues$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetBoundOutputValues$VH.set(seg, x);
    }

    public static MemorySegment GetBoundOutputValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetBoundOutputValues$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetBoundOutputValues$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBoundOutputValues GetBoundOutputValues(MemorySegment segment, SegmentScope scope) {
        return GetBoundOutputValues.ofAddress(GetBoundOutputValues$get(segment), scope);
    }

    static final FunctionDescriptor ClearBoundInputs$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ClearBoundInputs$MH = RuntimeHelper.downcallHandle(OrtApi.ClearBoundInputs$FUNC);
    /**
     * {@snippet :
     * void (*ClearBoundInputs)(OrtIoBinding*);
     * }
     */
    public interface ClearBoundInputs {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ClearBoundInputs fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ClearBoundInputs.class, fi, OrtApi.ClearBoundInputs$FUNC, scope);
        }

        static ClearBoundInputs ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ClearBoundInputs$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ClearBoundInputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment ClearBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ClearBoundInputs$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ClearBoundInputs)(OrtIoBinding*);
     * }
     */
    public static void ClearBoundInputs$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ClearBoundInputs$VH.set(seg, x);
    }

    public static MemorySegment ClearBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ClearBoundInputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ClearBoundInputs$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ClearBoundInputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ClearBoundInputs ClearBoundInputs(MemorySegment segment, SegmentScope scope) {
        return ClearBoundInputs.ofAddress(ClearBoundInputs$get(segment), scope);
    }

    static final FunctionDescriptor ClearBoundOutputs$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ClearBoundOutputs$MH = RuntimeHelper.downcallHandle(OrtApi.ClearBoundOutputs$FUNC);
    /**
     * {@snippet :
     * void (*ClearBoundOutputs)(OrtIoBinding*);
     * }
     */
    public interface ClearBoundOutputs {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ClearBoundOutputs fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ClearBoundOutputs.class, fi, OrtApi.ClearBoundOutputs$FUNC, scope);
        }

        static ClearBoundOutputs ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ClearBoundOutputs$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ClearBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment ClearBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ClearBoundOutputs$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ClearBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static void ClearBoundOutputs$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ClearBoundOutputs$VH.set(seg, x);
    }

    public static MemorySegment ClearBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ClearBoundOutputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ClearBoundOutputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ClearBoundOutputs ClearBoundOutputs(MemorySegment segment, SegmentScope scope) {
        return ClearBoundOutputs.ofAddress(ClearBoundOutputs$get(segment), scope);
    }

    static final FunctionDescriptor TensorAt$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle TensorAt$MH = RuntimeHelper.downcallHandle(OrtApi.TensorAt$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*TensorAt)(OrtValue*,const int64_t*,size_t,void**);
     * }
     */
    public interface TensorAt {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(TensorAt fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(TensorAt.class, fi, OrtApi.TensorAt$FUNC, scope);
        }

        static TensorAt ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.TensorAt$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*TensorAt)(OrtValue*,const int64_t*,size_t,void**);
     * }
     */
    public static MemorySegment TensorAt$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.TensorAt$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*TensorAt)(OrtValue*,const int64_t*,size_t,void**);
     * }
     */
    public static void TensorAt$set(MemorySegment seg, MemorySegment x) {
        OrtApi.TensorAt$VH.set(seg, x);
    }

    public static MemorySegment TensorAt$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.TensorAt$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void TensorAt$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.TensorAt$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static TensorAt TensorAt(MemorySegment segment, SegmentScope scope) {
        return TensorAt.ofAddress(TensorAt$get(segment), scope);
    }

    static final FunctionDescriptor CreateAndRegisterAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateAndRegisterAllocator$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateAndRegisterAllocator$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocator)(OrtEnv*,const OrtMemoryInfo*,const OrtArenaCfg*);
     * }
     */
    public interface CreateAndRegisterAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateAndRegisterAllocator fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateAndRegisterAllocator.class, fi, OrtApi.CreateAndRegisterAllocator$FUNC, scope);
        }

        static CreateAndRegisterAllocator ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateAndRegisterAllocator$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocator)(OrtEnv*,const OrtMemoryInfo*,const OrtArenaCfg*);
     * }
     */
    public static MemorySegment CreateAndRegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateAndRegisterAllocator$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocator)(OrtEnv*,const OrtMemoryInfo*,const OrtArenaCfg*);
     * }
     */
    public static void CreateAndRegisterAllocator$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateAndRegisterAllocator$VH.set(seg, x);
    }

    public static MemorySegment CreateAndRegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateAndRegisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateAndRegisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAndRegisterAllocator CreateAndRegisterAllocator(MemorySegment segment, SegmentScope scope) {
        return CreateAndRegisterAllocator.ofAddress(CreateAndRegisterAllocator$get(segment), scope);
    }

    static final FunctionDescriptor SetLanguageProjection$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetLanguageProjection$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetLanguageProjection$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
     * }
     */
    public interface SetLanguageProjection {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetLanguageProjection fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetLanguageProjection.class, fi, OrtApi.SetLanguageProjection$FUNC, scope);
        }

        static SetLanguageProjection ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetLanguageProjection$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
     * }
     */
    public static MemorySegment SetLanguageProjection$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetLanguageProjection$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
     * }
     */
    public static void SetLanguageProjection$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetLanguageProjection$VH.set(seg, x);
    }

    public static MemorySegment SetLanguageProjection$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetLanguageProjection$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetLanguageProjection$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetLanguageProjection$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetLanguageProjection SetLanguageProjection(MemorySegment segment, SegmentScope scope) {
        return SetLanguageProjection.ofAddress(SetLanguageProjection$get(segment), scope);
    }

    static final FunctionDescriptor SessionGetProfilingStartTimeNs$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionGetProfilingStartTimeNs$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionGetProfilingStartTimeNs$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
     * }
     */
    public interface SessionGetProfilingStartTimeNs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetProfilingStartTimeNs fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetProfilingStartTimeNs.class, fi, OrtApi.SessionGetProfilingStartTimeNs$FUNC, scope);
        }

        static SessionGetProfilingStartTimeNs ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionGetProfilingStartTimeNs$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
     * }
     */
    public static MemorySegment SessionGetProfilingStartTimeNs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionGetProfilingStartTimeNs$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
     * }
     */
    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionGetProfilingStartTimeNs$VH.set(seg, x);
    }

    public static MemorySegment SessionGetProfilingStartTimeNs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionGetProfilingStartTimeNs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionGetProfilingStartTimeNs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs(
            MemorySegment segment, SegmentScope scope) {
        return SessionGetProfilingStartTimeNs.ofAddress(SessionGetProfilingStartTimeNs$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalIntraOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetGlobalIntraOpNumThreads$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalIntraOpNumThreads$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalIntraOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalIntraOpNumThreads fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalIntraOpNumThreads.class, fi, OrtApi.SetGlobalIntraOpNumThreads$FUNC, scope);
        }

        static SetGlobalIntraOpNumThreads ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalIntraOpNumThreads$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalIntraOpNumThreads$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalIntraOpNumThreads$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetGlobalIntraOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalIntraOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads(MemorySegment segment, SegmentScope scope) {
        return SetGlobalIntraOpNumThreads.ofAddress(SetGlobalIntraOpNumThreads$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalInterOpNumThreads$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetGlobalInterOpNumThreads$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalInterOpNumThreads$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalInterOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalInterOpNumThreads fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalInterOpNumThreads.class, fi, OrtApi.SetGlobalInterOpNumThreads$FUNC, scope);
        }

        static SetGlobalInterOpNumThreads ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalInterOpNumThreads$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalInterOpNumThreads$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalInterOpNumThreads$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetGlobalInterOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalInterOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads(MemorySegment segment, SegmentScope scope) {
        return SetGlobalInterOpNumThreads.ofAddress(SetGlobalInterOpNumThreads$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalSpinControl$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetGlobalSpinControl$MH = RuntimeHelper.downcallHandle(OrtApi.SetGlobalSpinControl$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalSpinControl {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalSpinControl fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetGlobalSpinControl.class, fi, OrtApi.SetGlobalSpinControl$FUNC, scope);
        }

        static SetGlobalSpinControl ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalSpinControl$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalSpinControl$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalSpinControl$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalSpinControl$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalSpinControl$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalSpinControl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalSpinControl$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalSpinControl$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalSpinControl SetGlobalSpinControl(MemorySegment segment, SegmentScope scope) {
        return SetGlobalSpinControl.ofAddress(SetGlobalSpinControl$get(segment), scope);
    }

    static final FunctionDescriptor AddInitializer$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddInitializer$MH = RuntimeHelper.downcallHandle(OrtApi.AddInitializer$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddInitializer)(OrtSessionOptions*,char*,const OrtValue*);
     * }
     */
    public interface AddInitializer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(AddInitializer fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AddInitializer.class, fi, OrtApi.AddInitializer$FUNC, scope);
        }

        static AddInitializer ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddInitializer$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddInitializer)(OrtSessionOptions*,char*,const OrtValue*);
     * }
     */
    public static MemorySegment AddInitializer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddInitializer$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddInitializer)(OrtSessionOptions*,char*,const OrtValue*);
     * }
     */
    public static void AddInitializer$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddInitializer$VH.set(seg, x);
    }

    public static MemorySegment AddInitializer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddInitializer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddInitializer$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddInitializer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddInitializer AddInitializer(MemorySegment segment, SegmentScope scope) {
        return AddInitializer.ofAddress(AddInitializer$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,struct OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public interface CreateEnvWithCustomLoggerAndGlobalThreadPools {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                int _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5);

        static MemorySegment allocate(CreateEnvWithCustomLoggerAndGlobalThreadPools fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLoggerAndGlobalThreadPools.class,
                    fi,
                    OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC,
                    scope);
        }

        static CreateEnvWithCustomLoggerAndGlobalThreadPools ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$MH.invokeExact(
                                    symbol, __x0, __x1, __x2, __x3, __x4, __x5);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,struct OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,struct OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.set(seg, x);
    }

    public static MemorySegment CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools(
            MemorySegment segment, SegmentScope scope) {
        return CreateEnvWithCustomLoggerAndGlobalThreadPools.ofAddress(
                CreateEnvWithCustomLoggerAndGlobalThreadPools$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CUDA$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CUDA$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CUDA {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CUDA.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_CUDA$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA SessionOptionsAppendExecutionProvider_CUDA(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_CUDA.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_ROCM$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_ROCM$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_ROCM {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_ROCM fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_ROCM.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_ROCM ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_ROCM$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_ROCM.ofAddress(
                SessionOptionsAppendExecutionProvider_ROCM$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_OpenVINO$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_OpenVINO$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_OpenVINO {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_OpenVINO fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_OpenVINO.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_OpenVINO.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalDenormalAsZero$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalDenormalAsZero$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalDenormalAsZero$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
     * }
     */
    public interface SetGlobalDenormalAsZero {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SetGlobalDenormalAsZero fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalDenormalAsZero.class, fi, OrtApi.SetGlobalDenormalAsZero$FUNC, scope);
        }

        static SetGlobalDenormalAsZero ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalDenormalAsZero$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
     * }
     */
    public static MemorySegment SetGlobalDenormalAsZero$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalDenormalAsZero$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
     * }
     */
    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalDenormalAsZero$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalDenormalAsZero$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalDenormalAsZero$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalDenormalAsZero$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalDenormalAsZero SetGlobalDenormalAsZero(MemorySegment segment, SegmentScope scope) {
        return SetGlobalDenormalAsZero.ofAddress(SetGlobalDenormalAsZero$get(segment), scope);
    }

    static final FunctionDescriptor CreateArenaCfg$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateArenaCfg$MH = RuntimeHelper.downcallHandle(OrtApi.CreateArenaCfg$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
     * }
     */
    public interface CreateArenaCfg {

        java.lang.foreign.MemorySegment apply(long _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateArenaCfg fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateArenaCfg.class, fi, OrtApi.CreateArenaCfg$FUNC, scope);
        }

        static CreateArenaCfg ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (long __x0, int __x1, int __x2, int __x3, java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateArenaCfg$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
     * }
     */
    public static MemorySegment CreateArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateArenaCfg$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
     * }
     */
    public static void CreateArenaCfg$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateArenaCfg$VH.set(seg, x);
    }

    public static MemorySegment CreateArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateArenaCfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateArenaCfg$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateArenaCfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateArenaCfg CreateArenaCfg(MemorySegment segment, SegmentScope scope) {
        return CreateArenaCfg.ofAddress(CreateArenaCfg$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseArenaCfg$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseArenaCfg$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseArenaCfg$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseArenaCfg)(OrtArenaCfg*);
     * }
     */
    public interface ReleaseArenaCfg {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseArenaCfg fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseArenaCfg.class, fi, OrtApi.ReleaseArenaCfg$FUNC, scope);
        }

        static ReleaseArenaCfg ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseArenaCfg$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseArenaCfg)(OrtArenaCfg*);
     * }
     */
    public static MemorySegment ReleaseArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseArenaCfg$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseArenaCfg)(OrtArenaCfg*);
     * }
     */
    public static void ReleaseArenaCfg$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseArenaCfg$VH.set(seg, x);
    }

    public static MemorySegment ReleaseArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseArenaCfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseArenaCfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseArenaCfg ReleaseArenaCfg(MemorySegment segment, SegmentScope scope) {
        return ReleaseArenaCfg.ofAddress(ReleaseArenaCfg$get(segment), scope);
    }

    static final FunctionDescriptor ModelMetadataGetGraphDescription$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ModelMetadataGetGraphDescription$MH =
            RuntimeHelper.downcallHandle(OrtApi.ModelMetadataGetGraphDescription$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetGraphDescription {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ModelMetadataGetGraphDescription fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphDescription.class, fi, OrtApi.ModelMetadataGetGraphDescription$FUNC, scope);
        }

        static ModelMetadataGetGraphDescription ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.ModelMetadataGetGraphDescription$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetGraphDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ModelMetadataGetGraphDescription$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ModelMetadataGetGraphDescription$VH.set(seg, x);
    }

    public static MemorySegment ModelMetadataGetGraphDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ModelMetadataGetGraphDescription$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ModelMetadataGetGraphDescription$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription(
            MemorySegment segment, SegmentScope scope) {
        return ModelMetadataGetGraphDescription.ofAddress(ModelMetadataGetGraphDescription$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_TensorRT$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_TensorRT$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_TensorRT {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT SessionOptionsAppendExecutionProvider_TensorRT(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_TensorRT.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT$get(segment), scope);
    }

    static final FunctionDescriptor SetCurrentGpuDeviceId$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle SetCurrentGpuDeviceId$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetCurrentGpuDeviceId$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public interface SetCurrentGpuDeviceId {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(SetCurrentGpuDeviceId fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(SetCurrentGpuDeviceId.class, fi, OrtApi.SetCurrentGpuDeviceId$FUNC, scope);
        }

        static SetCurrentGpuDeviceId ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.SetCurrentGpuDeviceId$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public static MemorySegment SetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetCurrentGpuDeviceId$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetCurrentGpuDeviceId$VH.set(seg, x);
    }

    public static MemorySegment SetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetCurrentGpuDeviceId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetCurrentGpuDeviceId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetCurrentGpuDeviceId SetCurrentGpuDeviceId(MemorySegment segment, SegmentScope scope) {
        return SetCurrentGpuDeviceId.ofAddress(SetCurrentGpuDeviceId$get(segment), scope);
    }

    static final FunctionDescriptor GetCurrentGpuDeviceId$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCurrentGpuDeviceId$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCurrentGpuDeviceId$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public interface GetCurrentGpuDeviceId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetCurrentGpuDeviceId fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetCurrentGpuDeviceId.class, fi, OrtApi.GetCurrentGpuDeviceId$FUNC, scope);
        }

        static GetCurrentGpuDeviceId ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetCurrentGpuDeviceId$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public static MemorySegment GetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetCurrentGpuDeviceId$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetCurrentGpuDeviceId$VH.set(seg, x);
    }

    public static MemorySegment GetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetCurrentGpuDeviceId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetCurrentGpuDeviceId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCurrentGpuDeviceId GetCurrentGpuDeviceId(MemorySegment segment, SegmentScope scope) {
        return GetCurrentGpuDeviceId.ofAddress(GetCurrentGpuDeviceId$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfoGetAttributeArray_float$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttributeArray_float$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttributeArray_float$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_float)(const OrtKernelInfo*,char*,float*,size_t*);
     * }
     */
    public interface KernelInfoGetAttributeArray_float {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttributeArray_float fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_float.class, fi, OrtApi.KernelInfoGetAttributeArray_float$FUNC, scope);
        }

        static KernelInfoGetAttributeArray_float ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfoGetAttributeArray_float$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_float)(const OrtKernelInfo*,char*,float*,size_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttributeArray_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfoGetAttributeArray_float$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_float)(const OrtKernelInfo*,char*,float*,size_t*);
     * }
     */
    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfoGetAttributeArray_float$VH.set(seg, x);
    }

    public static MemorySegment KernelInfoGetAttributeArray_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfoGetAttributeArray_float$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfoGetAttributeArray_float$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttributeArray_float KernelInfoGetAttributeArray_float(
            MemorySegment segment, SegmentScope scope) {
        return KernelInfoGetAttributeArray_float.ofAddress(KernelInfoGetAttributeArray_float$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfoGetAttributeArray_int64$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttributeArray_int64$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttributeArray_int64$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_int64)(const OrtKernelInfo*,char*,int64_t*,size_t*);
     * }
     */
    public interface KernelInfoGetAttributeArray_int64 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttributeArray_int64 fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_int64.class, fi, OrtApi.KernelInfoGetAttributeArray_int64$FUNC, scope);
        }

        static KernelInfoGetAttributeArray_int64 ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfoGetAttributeArray_int64$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_int64)(const OrtKernelInfo*,char*,int64_t*,size_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttributeArray_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfoGetAttributeArray_int64$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_int64)(const OrtKernelInfo*,char*,int64_t*,size_t*);
     * }
     */
    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfoGetAttributeArray_int64$VH.set(seg, x);
    }

    public static MemorySegment KernelInfoGetAttributeArray_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfoGetAttributeArray_int64$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfoGetAttributeArray_int64$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttributeArray_int64 KernelInfoGetAttributeArray_int64(
            MemorySegment segment, SegmentScope scope) {
        return KernelInfoGetAttributeArray_int64.ofAddress(KernelInfoGetAttributeArray_int64$get(segment), scope);
    }

    static final FunctionDescriptor CreateArenaCfgV2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateArenaCfgV2$MH = RuntimeHelper.downcallHandle(OrtApi.CreateArenaCfgV2$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfgV2)(char**,const size_t*,size_t,OrtArenaCfg**);
     * }
     */
    public interface CreateArenaCfgV2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateArenaCfgV2 fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateArenaCfgV2.class, fi, OrtApi.CreateArenaCfgV2$FUNC, scope);
        }

        static CreateArenaCfgV2 ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateArenaCfgV2$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfgV2)(char**,const size_t*,size_t,OrtArenaCfg**);
     * }
     */
    public static MemorySegment CreateArenaCfgV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateArenaCfgV2$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfgV2)(char**,const size_t*,size_t,OrtArenaCfg**);
     * }
     */
    public static void CreateArenaCfgV2$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateArenaCfgV2$VH.set(seg, x);
    }

    public static MemorySegment CreateArenaCfgV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateArenaCfgV2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateArenaCfgV2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateArenaCfgV2 CreateArenaCfgV2(MemorySegment segment, SegmentScope scope) {
        return CreateArenaCfgV2.ofAddress(CreateArenaCfgV2$get(segment), scope);
    }

    static final FunctionDescriptor AddRunConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle AddRunConfigEntry$MH = RuntimeHelper.downcallHandle(OrtApi.AddRunConfigEntry$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddRunConfigEntry)(OrtRunOptions*,char*,char*);
     * }
     */
    public interface AddRunConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(AddRunConfigEntry fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(AddRunConfigEntry.class, fi, OrtApi.AddRunConfigEntry$FUNC, scope);
        }

        static AddRunConfigEntry ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddRunConfigEntry$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddRunConfigEntry)(OrtRunOptions*,char*,char*);
     * }
     */
    public static MemorySegment AddRunConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddRunConfigEntry$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddRunConfigEntry)(OrtRunOptions*,char*,char*);
     * }
     */
    public static void AddRunConfigEntry$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddRunConfigEntry$VH.set(seg, x);
    }

    public static MemorySegment AddRunConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddRunConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddRunConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddRunConfigEntry AddRunConfigEntry(MemorySegment segment, SegmentScope scope) {
        return AddRunConfigEntry.ofAddress(AddRunConfigEntry$get(segment), scope);
    }

    static final FunctionDescriptor CreatePrepackedWeightsContainer$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreatePrepackedWeightsContainer$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreatePrepackedWeightsContainer$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
     * }
     */
    public interface CreatePrepackedWeightsContainer {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreatePrepackedWeightsContainer fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreatePrepackedWeightsContainer.class, fi, OrtApi.CreatePrepackedWeightsContainer$FUNC, scope);
        }

        static CreatePrepackedWeightsContainer ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreatePrepackedWeightsContainer$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
     * }
     */
    public static MemorySegment CreatePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreatePrepackedWeightsContainer$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
     * }
     */
    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreatePrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemorySegment CreatePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreatePrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreatePrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreatePrepackedWeightsContainer CreatePrepackedWeightsContainer(
            MemorySegment segment, SegmentScope scope) {
        return CreatePrepackedWeightsContainer.ofAddress(CreatePrepackedWeightsContainer$get(segment), scope);
    }

    static final FunctionDescriptor ReleasePrepackedWeightsContainer$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleasePrepackedWeightsContainer$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleasePrepackedWeightsContainer$FUNC);
    /**
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
     * }
     */
    public interface ReleasePrepackedWeightsContainer {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleasePrepackedWeightsContainer fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleasePrepackedWeightsContainer.class, fi, OrtApi.ReleasePrepackedWeightsContainer$FUNC, scope);
        }

        static ReleasePrepackedWeightsContainer ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleasePrepackedWeightsContainer$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
     * }
     */
    public static MemorySegment ReleasePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleasePrepackedWeightsContainer$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
     * }
     */
    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleasePrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemorySegment ReleasePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ReleasePrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleasePrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleasePrepackedWeightsContainer ReleasePrepackedWeightsContainer(
            MemorySegment segment, SegmentScope scope) {
        return ReleasePrepackedWeightsContainer.ofAddress(ReleasePrepackedWeightsContainer$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSessionWithPrepackedWeightsContainer)(const OrtEnv*,char*,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public interface CreateSessionWithPrepackedWeightsContainer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateSessionWithPrepackedWeightsContainer fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionWithPrepackedWeightsContainer$FUNC,
                    scope);
        }

        static CreateSessionWithPrepackedWeightsContainer ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateSessionWithPrepackedWeightsContainer$MH.invokeExact(
                                    symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionWithPrepackedWeightsContainer)(const OrtEnv*,char*,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionWithPrepackedWeightsContainer)(const OrtEnv*,char*,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemorySegment CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionWithPrepackedWeightsContainer CreateSessionWithPrepackedWeightsContainer(
            MemorySegment segment, SegmentScope scope) {
        return CreateSessionWithPrepackedWeightsContainer.ofAddress(
                CreateSessionWithPrepackedWeightsContainer$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArrayWithPrepackedWeightsContainer)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public interface CreateSessionFromArrayWithPrepackedWeightsContainer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5);

        static MemorySegment allocate(CreateSessionFromArrayWithPrepackedWeightsContainer fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArrayWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC,
                    scope);
        }

        static CreateSessionFromArrayWithPrepackedWeightsContainer ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$MH.invokeExact(
                                    symbol, __x0, __x1, __x2, __x3, __x4, __x5);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArrayWithPrepackedWeightsContainer)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArrayWithPrepackedWeightsContainer)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemorySegment CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionFromArrayWithPrepackedWeightsContainer
            CreateSessionFromArrayWithPrepackedWeightsContainer(MemorySegment segment, SegmentScope scope) {
        return CreateSessionFromArrayWithPrepackedWeightsContainer.ofAddress(
                CreateSessionFromArrayWithPrepackedWeightsContainer$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_TensorRT_V2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT_V2 fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT_V2 ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_TensorRT_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT_V2$get(segment), scope);
    }

    static final FunctionDescriptor CreateTensorRTProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateTensorRTProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateTensorRTProviderOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
     * }
     */
    public interface CreateTensorRTProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateTensorRTProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorRTProviderOptions.class, fi, OrtApi.CreateTensorRTProviderOptions$FUNC, scope);
        }

        static CreateTensorRTProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateTensorRTProviderOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
     * }
     */
    public static MemorySegment CreateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateTensorRTProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
     * }
     */
    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment CreateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorRTProviderOptions CreateTensorRTProviderOptions(
            MemorySegment segment, SegmentScope scope) {
        return CreateTensorRTProviderOptions.ofAddress(CreateTensorRTProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor UpdateTensorRTProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateTensorRTProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateTensorRTProviderOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public interface UpdateTensorRTProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateTensorRTProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    UpdateTensorRTProviderOptions.class, fi, OrtApi.UpdateTensorRTProviderOptions$FUNC, scope);
        }

        static UpdateTensorRTProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UpdateTensorRTProviderOptions$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UpdateTensorRTProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UpdateTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment UpdateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.UpdateTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UpdateTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions(
            MemorySegment segment, SegmentScope scope) {
        return UpdateTensorRTProviderOptions.ofAddress(UpdateTensorRTProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor GetTensorRTProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorRTProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetTensorRTProviderOptionsAsString$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsAsString)(const OrtTensorRTProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public interface GetTensorRTProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetTensorRTProviderOptionsAsString fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorRTProviderOptionsAsString.class,
                    fi,
                    OrtApi.GetTensorRTProviderOptionsAsString$FUNC,
                    scope);
        }

        static GetTensorRTProviderOptionsAsString ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetTensorRTProviderOptionsAsString$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsAsString)(const OrtTensorRTProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetTensorRTProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorRTProviderOptionsAsString$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsAsString)(const OrtTensorRTProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTensorRTProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemorySegment GetTensorRTProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetTensorRTProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTensorRTProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorRTProviderOptionsAsString GetTensorRTProviderOptionsAsString(
            MemorySegment segment, SegmentScope scope) {
        return GetTensorRTProviderOptionsAsString.ofAddress(GetTensorRTProviderOptionsAsString$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseTensorRTProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseTensorRTProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseTensorRTProviderOptions$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
     * }
     */
    public interface ReleaseTensorRTProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTensorRTProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorRTProviderOptions.class, fi, OrtApi.ReleaseTensorRTProviderOptions$FUNC, scope);
        }

        static ReleaseTensorRTProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseTensorRTProviderOptions$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static MemorySegment ReleaseTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseTensorRTProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment ReleaseTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ReleaseTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions(
            MemorySegment segment, SegmentScope scope) {
        return ReleaseTensorRTProviderOptions.ofAddress(ReleaseTensorRTProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor EnableOrtCustomOps$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle EnableOrtCustomOps$MH = RuntimeHelper.downcallHandle(OrtApi.EnableOrtCustomOps$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
     * }
     */
    public interface EnableOrtCustomOps {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableOrtCustomOps fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(EnableOrtCustomOps.class, fi, OrtApi.EnableOrtCustomOps$FUNC, scope);
        }

        static EnableOrtCustomOps ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.EnableOrtCustomOps$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableOrtCustomOps$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableOrtCustomOps$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
     * }
     */
    public static void EnableOrtCustomOps$set(MemorySegment seg, MemorySegment x) {
        OrtApi.EnableOrtCustomOps$VH.set(seg, x);
    }

    public static MemorySegment EnableOrtCustomOps$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.EnableOrtCustomOps$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.EnableOrtCustomOps$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableOrtCustomOps EnableOrtCustomOps(MemorySegment segment, SegmentScope scope) {
        return EnableOrtCustomOps.ofAddress(EnableOrtCustomOps$get(segment), scope);
    }

    static final FunctionDescriptor RegisterAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.RegisterAllocator$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
     * }
     */
    public interface RegisterAllocator {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RegisterAllocator fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(RegisterAllocator.class, fi, OrtApi.RegisterAllocator$FUNC, scope);
        }

        static RegisterAllocator ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RegisterAllocator$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
     * }
     */
    public static MemorySegment RegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RegisterAllocator$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
     * }
     */
    public static void RegisterAllocator$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RegisterAllocator$VH.set(seg, x);
    }

    public static MemorySegment RegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.RegisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RegisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterAllocator RegisterAllocator(MemorySegment segment, SegmentScope scope) {
        return RegisterAllocator.ofAddress(RegisterAllocator$get(segment), scope);
    }

    static final FunctionDescriptor UnregisterAllocator$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle UnregisterAllocator$MH = RuntimeHelper.downcallHandle(OrtApi.UnregisterAllocator$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
     * }
     */
    public interface UnregisterAllocator {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(UnregisterAllocator fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(UnregisterAllocator.class, fi, OrtApi.UnregisterAllocator$FUNC, scope);
        }

        static UnregisterAllocator ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UnregisterAllocator$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
     * }
     */
    public static MemorySegment UnregisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UnregisterAllocator$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
     * }
     */
    public static void UnregisterAllocator$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UnregisterAllocator$VH.set(seg, x);
    }

    public static MemorySegment UnregisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.UnregisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UnregisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UnregisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UnregisterAllocator UnregisterAllocator(MemorySegment segment, SegmentScope scope) {
        return UnregisterAllocator.ofAddress(UnregisterAllocator$get(segment), scope);
    }

    static final FunctionDescriptor IsSparseTensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle IsSparseTensor$MH = RuntimeHelper.downcallHandle(OrtApi.IsSparseTensor$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
     * }
     */
    public interface IsSparseTensor {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(IsSparseTensor fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(IsSparseTensor.class, fi, OrtApi.IsSparseTensor$FUNC, scope);
        }

        static IsSparseTensor ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.IsSparseTensor$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
     * }
     */
    public static MemorySegment IsSparseTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.IsSparseTensor$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
     * }
     */
    public static void IsSparseTensor$set(MemorySegment seg, MemorySegment x) {
        OrtApi.IsSparseTensor$VH.set(seg, x);
    }

    public static MemorySegment IsSparseTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.IsSparseTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void IsSparseTensor$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.IsSparseTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static IsSparseTensor IsSparseTensor(MemorySegment segment, SegmentScope scope) {
        return IsSparseTensor.ofAddress(IsSparseTensor$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public interface CreateSparseTensorAsOrtValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateSparseTensorAsOrtValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorAsOrtValue.class, fi, OrtApi.CreateSparseTensorAsOrtValue$FUNC, scope);
        }

        static CreateSparseTensorAsOrtValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateSparseTensorAsOrtValue$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateSparseTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSparseTensorAsOrtValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSparseTensorAsOrtValue$VH.set(seg, x);
    }

    public static MemorySegment CreateSparseTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateSparseTensorAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSparseTensorAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSparseTensorAsOrtValue CreateSparseTensorAsOrtValue(MemorySegment segment, SegmentScope scope) {
        return CreateSparseTensorAsOrtValue.ofAddress(CreateSparseTensorAsOrtValue$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCoo)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t);
     * }
     */
    public interface FillSparseTensorCoo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5,
                long _x6);

        static MemorySegment allocate(FillSparseTensorCoo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(FillSparseTensorCoo.class, fi, OrtApi.FillSparseTensorCoo$FUNC, scope);
        }

        static FillSparseTensorCoo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.FillSparseTensorCoo$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCoo)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t);
     * }
     */
    public static MemorySegment FillSparseTensorCoo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorCoo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCoo)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t);
     * }
     */
    public static void FillSparseTensorCoo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.FillSparseTensorCoo$VH.set(seg, x);
    }

    public static MemorySegment FillSparseTensorCoo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorCoo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.FillSparseTensorCoo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorCoo FillSparseTensorCoo(MemorySegment segment, SegmentScope scope) {
        return FillSparseTensorCoo.ofAddress(FillSparseTensorCoo$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCsr)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int64_t*,size_t);
     * }
     */
    public interface FillSparseTensorCsr {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5,
                long _x6,
                java.lang.foreign.MemorySegment _x7,
                long _x8);

        static MemorySegment allocate(FillSparseTensorCsr fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(FillSparseTensorCsr.class, fi, OrtApi.FillSparseTensorCsr$FUNC, scope);
        }

        static FillSparseTensorCsr ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6,
                    java.lang.foreign.MemorySegment __x7,
                    long __x8) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorCsr$MH.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCsr)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int64_t*,size_t);
     * }
     */
    public static MemorySegment FillSparseTensorCsr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorCsr$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCsr)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int64_t*,size_t);
     * }
     */
    public static void FillSparseTensorCsr$set(MemorySegment seg, MemorySegment x) {
        OrtApi.FillSparseTensorCsr$VH.set(seg, x);
    }

    public static MemorySegment FillSparseTensorCsr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorCsr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.FillSparseTensorCsr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorCsr FillSparseTensorCsr(MemorySegment segment, SegmentScope scope) {
        return FillSparseTensorCsr.ofAddress(FillSparseTensorCsr$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorBlockSparse)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int32_t*);
     * }
     */
    public interface FillSparseTensorBlockSparse {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5,
                long _x6,
                java.lang.foreign.MemorySegment _x7);

        static MemorySegment allocate(FillSparseTensorBlockSparse fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorBlockSparse.class, fi, OrtApi.FillSparseTensorBlockSparse$FUNC, scope);
        }

        static FillSparseTensorBlockSparse ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6,
                    java.lang.foreign.MemorySegment __x7) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorBlockSparse$MH.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorBlockSparse)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int32_t*);
     * }
     */
    public static MemorySegment FillSparseTensorBlockSparse$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.FillSparseTensorBlockSparse$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorBlockSparse)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int32_t*);
     * }
     */
    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, MemorySegment x) {
        OrtApi.FillSparseTensorBlockSparse$VH.set(seg, x);
    }

    public static MemorySegment FillSparseTensorBlockSparse$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.FillSparseTensorBlockSparse$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.FillSparseTensorBlockSparse$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorBlockSparse FillSparseTensorBlockSparse(MemorySegment segment, SegmentScope scope) {
        return FillSparseTensorBlockSparse.ofAddress(FillSparseTensorBlockSparse$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorWithValuesAsOrtValue)(const OrtMemoryInfo*,void*,const int64_t*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public interface CreateSparseTensorWithValuesAsOrtValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4,
                long _x5,
                int _x6,
                java.lang.foreign.MemorySegment _x7);

        static MemorySegment allocate(CreateSparseTensorWithValuesAsOrtValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorWithValuesAsOrtValue.class,
                    fi,
                    OrtApi.CreateSparseTensorWithValuesAsOrtValue$FUNC,
                    scope);
        }

        static CreateSparseTensorWithValuesAsOrtValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4,
                    long __x5,
                    int __x6,
                    java.lang.foreign.MemorySegment __x7) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateSparseTensorWithValuesAsOrtValue$MH.invokeExact(
                                    symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorWithValuesAsOrtValue)(const OrtMemoryInfo*,void*,const int64_t*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorWithValuesAsOrtValue)(const OrtMemoryInfo*,void*,const int64_t*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.set(seg, x);
    }

    public static MemorySegment CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSparseTensorWithValuesAsOrtValue CreateSparseTensorWithValuesAsOrtValue(
            MemorySegment segment, SegmentScope scope) {
        return CreateSparseTensorWithValuesAsOrtValue.ofAddress(
                CreateSparseTensorWithValuesAsOrtValue$get(segment), scope);
    }

    static final FunctionDescriptor UseCooIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UseCooIndices$MH = RuntimeHelper.downcallHandle(OrtApi.UseCooIndices$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
     * }
     */
    public interface UseCooIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(UseCooIndices fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(UseCooIndices.class, fi, OrtApi.UseCooIndices$FUNC, scope);
        }

        static UseCooIndices ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UseCooIndices$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
     * }
     */
    public static MemorySegment UseCooIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UseCooIndices$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
     * }
     */
    public static void UseCooIndices$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UseCooIndices$VH.set(seg, x);
    }

    public static MemorySegment UseCooIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.UseCooIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseCooIndices$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UseCooIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseCooIndices UseCooIndices(MemorySegment segment, SegmentScope scope) {
        return UseCooIndices.ofAddress(UseCooIndices$get(segment), scope);
    }

    static final FunctionDescriptor UseCsrIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UseCsrIndices$MH = RuntimeHelper.downcallHandle(OrtApi.UseCsrIndices$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UseCsrIndices)(OrtValue*,int64_t*,size_t,int64_t*,size_t);
     * }
     */
    public interface UseCsrIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(UseCsrIndices fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(UseCsrIndices.class, fi, OrtApi.UseCsrIndices$FUNC, scope);
        }

        static UseCsrIndices ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UseCsrIndices$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCsrIndices)(OrtValue*,int64_t*,size_t,int64_t*,size_t);
     * }
     */
    public static MemorySegment UseCsrIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UseCsrIndices$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCsrIndices)(OrtValue*,int64_t*,size_t,int64_t*,size_t);
     * }
     */
    public static void UseCsrIndices$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UseCsrIndices$VH.set(seg, x);
    }

    public static MemorySegment UseCsrIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.UseCsrIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseCsrIndices$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UseCsrIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseCsrIndices UseCsrIndices(MemorySegment segment, SegmentScope scope) {
        return UseCsrIndices.ofAddress(UseCsrIndices$get(segment), scope);
    }

    static final FunctionDescriptor UseBlockSparseIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle UseBlockSparseIndices$MH =
            RuntimeHelper.downcallHandle(OrtApi.UseBlockSparseIndices$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UseBlockSparseIndices)(OrtValue*,const int64_t*,size_t,int32_t*);
     * }
     */
    public interface UseBlockSparseIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(UseBlockSparseIndices fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(UseBlockSparseIndices.class, fi, OrtApi.UseBlockSparseIndices$FUNC, scope);
        }

        static UseBlockSparseIndices ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UseBlockSparseIndices$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UseBlockSparseIndices)(OrtValue*,const int64_t*,size_t,int32_t*);
     * }
     */
    public static MemorySegment UseBlockSparseIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UseBlockSparseIndices$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UseBlockSparseIndices)(OrtValue*,const int64_t*,size_t,int32_t*);
     * }
     */
    public static void UseBlockSparseIndices$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UseBlockSparseIndices$VH.set(seg, x);
    }

    public static MemorySegment UseBlockSparseIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.UseBlockSparseIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UseBlockSparseIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseBlockSparseIndices UseBlockSparseIndices(MemorySegment segment, SegmentScope scope) {
        return UseBlockSparseIndices.ofAddress(UseBlockSparseIndices$get(segment), scope);
    }

    static final FunctionDescriptor GetSparseTensorFormat$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorFormat$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorFormat$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public interface GetSparseTensorFormat {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSparseTensorFormat fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetSparseTensorFormat.class, fi, OrtApi.GetSparseTensorFormat$FUNC, scope);
        }

        static GetSparseTensorFormat ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSparseTensorFormat$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public static MemorySegment GetSparseTensorFormat$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorFormat$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public static void GetSparseTensorFormat$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSparseTensorFormat$VH.set(seg, x);
    }

    public static MemorySegment GetSparseTensorFormat$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorFormat$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSparseTensorFormat$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorFormat GetSparseTensorFormat(MemorySegment segment, SegmentScope scope) {
        return GetSparseTensorFormat.ofAddress(GetSparseTensorFormat$get(segment), scope);
    }

    static final FunctionDescriptor GetSparseTensorValuesTypeAndShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorValuesTypeAndShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorValuesTypeAndShape$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetSparseTensorValuesTypeAndShape {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSparseTensorValuesTypeAndShape fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValuesTypeAndShape.class, fi, OrtApi.GetSparseTensorValuesTypeAndShape$FUNC, scope);
        }

        static GetSparseTensorValuesTypeAndShape ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSparseTensorValuesTypeAndShape$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetSparseTensorValuesTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorValuesTypeAndShape$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSparseTensorValuesTypeAndShape$VH.set(seg, x);
    }

    public static MemorySegment GetSparseTensorValuesTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetSparseTensorValuesTypeAndShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSparseTensorValuesTypeAndShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorValuesTypeAndShape GetSparseTensorValuesTypeAndShape(
            MemorySegment segment, SegmentScope scope) {
        return GetSparseTensorValuesTypeAndShape.ofAddress(GetSparseTensorValuesTypeAndShape$get(segment), scope);
    }

    static final FunctionDescriptor GetSparseTensorValues$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorValues$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorValues$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
     * }
     */
    public interface GetSparseTensorValues {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSparseTensorValues fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetSparseTensorValues.class, fi, OrtApi.GetSparseTensorValues$FUNC, scope);
        }

        static GetSparseTensorValues ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSparseTensorValues$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
     * }
     */
    public static MemorySegment GetSparseTensorValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorValues$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
     * }
     */
    public static void GetSparseTensorValues$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSparseTensorValues$VH.set(seg, x);
    }

    public static MemorySegment GetSparseTensorValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorValues$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSparseTensorValues$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorValues GetSparseTensorValues(MemorySegment segment, SegmentScope scope) {
        return GetSparseTensorValues.ofAddress(GetSparseTensorValues$get(segment), scope);
    }

    static final FunctionDescriptor GetSparseTensorIndicesTypeShape$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorIndicesTypeShape$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorIndicesTypeShape$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetSparseTensorIndicesTypeShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetSparseTensorIndicesTypeShape fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndicesTypeShape.class, fi, OrtApi.GetSparseTensorIndicesTypeShape$FUNC, scope);
        }

        static GetSparseTensorIndicesTypeShape ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSparseTensorIndicesTypeShape$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetSparseTensorIndicesTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorIndicesTypeShape$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSparseTensorIndicesTypeShape$VH.set(seg, x);
    }

    public static MemorySegment GetSparseTensorIndicesTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetSparseTensorIndicesTypeShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSparseTensorIndicesTypeShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorIndicesTypeShape GetSparseTensorIndicesTypeShape(
            MemorySegment segment, SegmentScope scope) {
        return GetSparseTensorIndicesTypeShape.ofAddress(GetSparseTensorIndicesTypeShape$get(segment), scope);
    }

    static final FunctionDescriptor GetSparseTensorIndices$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSparseTensorIndices$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSparseTensorIndices$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndices)(const OrtValue*,enum OrtSparseIndicesFormat,size_t*,void**);
     * }
     */
    public interface GetSparseTensorIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                int _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetSparseTensorIndices fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndices.class, fi, OrtApi.GetSparseTensorIndices$FUNC, scope);
        }

        static GetSparseTensorIndices ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSparseTensorIndices$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndices)(const OrtValue*,enum OrtSparseIndicesFormat,size_t*,void**);
     * }
     */
    public static MemorySegment GetSparseTensorIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorIndices$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndices)(const OrtValue*,enum OrtSparseIndicesFormat,size_t*,void**);
     * }
     */
    public static void GetSparseTensorIndices$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSparseTensorIndices$VH.set(seg, x);
    }

    public static MemorySegment GetSparseTensorIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSparseTensorIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSparseTensorIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorIndices GetSparseTensorIndices(MemorySegment segment, SegmentScope scope) {
        return GetSparseTensorIndices.ofAddress(GetSparseTensorIndices$get(segment), scope);
    }

    static final FunctionDescriptor HasValue$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle HasValue$MH = RuntimeHelper.downcallHandle(OrtApi.HasValue$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*HasValue)(const OrtValue*,int*);
     * }
     */
    public interface HasValue {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(HasValue fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(HasValue.class, fi, OrtApi.HasValue$FUNC, scope);
        }

        static HasValue ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.HasValue$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*HasValue)(const OrtValue*,int*);
     * }
     */
    public static MemorySegment HasValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.HasValue$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*HasValue)(const OrtValue*,int*);
     * }
     */
    public static void HasValue$set(MemorySegment seg, MemorySegment x) {
        OrtApi.HasValue$VH.set(seg, x);
    }

    public static MemorySegment HasValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.HasValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void HasValue$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.HasValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static HasValue HasValue(MemorySegment segment, SegmentScope scope) {
        return HasValue.ofAddress(HasValue$get(segment), scope);
    }

    static final FunctionDescriptor KernelContext_GetGPUComputeStream$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelContext_GetGPUComputeStream$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelContext_GetGPUComputeStream$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
     * }
     */
    public interface KernelContext_GetGPUComputeStream {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetGPUComputeStream fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetGPUComputeStream.class, fi, OrtApi.KernelContext_GetGPUComputeStream$FUNC, scope);
        }

        static KernelContext_GetGPUComputeStream ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelContext_GetGPUComputeStream$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
     * }
     */
    public static MemorySegment KernelContext_GetGPUComputeStream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelContext_GetGPUComputeStream$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
     * }
     */
    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelContext_GetGPUComputeStream$VH.set(seg, x);
    }

    public static MemorySegment KernelContext_GetGPUComputeStream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelContext_GetGPUComputeStream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelContext_GetGPUComputeStream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetGPUComputeStream KernelContext_GetGPUComputeStream(
            MemorySegment segment, SegmentScope scope) {
        return KernelContext_GetGPUComputeStream.ofAddress(KernelContext_GetGPUComputeStream$get(segment), scope);
    }

    static final FunctionDescriptor GetTensorMemoryInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetTensorMemoryInfo$MH = RuntimeHelper.downcallHandle(OrtApi.GetTensorMemoryInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
     * }
     */
    public interface GetTensorMemoryInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorMemoryInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetTensorMemoryInfo.class, fi, OrtApi.GetTensorMemoryInfo$FUNC, scope);
        }

        static GetTensorMemoryInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetTensorMemoryInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
     * }
     */
    public static MemorySegment GetTensorMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorMemoryInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
     * }
     */
    public static void GetTensorMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTensorMemoryInfo$VH.set(seg, x);
    }

    public static MemorySegment GetTensorMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTensorMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTensorMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorMemoryInfo GetTensorMemoryInfo(MemorySegment segment, SegmentScope scope) {
        return GetTensorMemoryInfo.ofAddress(GetTensorMemoryInfo$get(segment), scope);
    }

    static final FunctionDescriptor GetExecutionProviderApi$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetExecutionProviderApi$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetExecutionProviderApi$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
     * }
     */
    public interface GetExecutionProviderApi {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetExecutionProviderApi fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderApi.class, fi, OrtApi.GetExecutionProviderApi$FUNC, scope);
        }

        static GetExecutionProviderApi ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetExecutionProviderApi$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
     * }
     */
    public static MemorySegment GetExecutionProviderApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetExecutionProviderApi$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
     * }
     */
    public static void GetExecutionProviderApi$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetExecutionProviderApi$VH.set(seg, x);
    }

    public static MemorySegment GetExecutionProviderApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetExecutionProviderApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetExecutionProviderApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetExecutionProviderApi GetExecutionProviderApi(MemorySegment segment, SegmentScope scope) {
        return GetExecutionProviderApi.ofAddress(GetExecutionProviderApi$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsSetCustomCreateThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsSetCustomCreateThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public interface SessionOptionsSetCustomCreateThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsSetCustomCreateThreadFn fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomCreateThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC,
                    scope);
        }

        static SessionOptionsSetCustomCreateThreadFn ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsSetCustomCreateThreadFn$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomCreateThreadFn SessionOptionsSetCustomCreateThreadFn(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsSetCustomCreateThreadFn.ofAddress(
                SessionOptionsSetCustomCreateThreadFn$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsSetCustomThreadCreationOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsSetCustomThreadCreationOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
     * }
     */
    public interface SessionOptionsSetCustomThreadCreationOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsSetCustomThreadCreationOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC,
                    scope);
        }

        static SessionOptionsSetCustomThreadCreationOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsSetCustomThreadCreationOptions$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
     * }
     */
    public static void SessionOptionsSetCustomThreadCreationOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomThreadCreationOptions SessionOptionsSetCustomThreadCreationOptions(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsSetCustomThreadCreationOptions.ofAddress(
                SessionOptionsSetCustomThreadCreationOptions$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsSetCustomJoinThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsSetCustomJoinThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public interface SessionOptionsSetCustomJoinThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsSetCustomJoinThreadFn fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomJoinThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC,
                    scope);
        }

        static SessionOptionsSetCustomJoinThreadFn ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsSetCustomJoinThreadFn$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomJoinThreadFn SessionOptionsSetCustomJoinThreadFn(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsSetCustomJoinThreadFn.ofAddress(SessionOptionsSetCustomJoinThreadFn$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalCustomCreateThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalCustomCreateThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalCustomCreateThreadFn$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public interface SetGlobalCustomCreateThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalCustomCreateThreadFn fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomCreateThreadFn.class, fi, OrtApi.SetGlobalCustomCreateThreadFn$FUNC, scope);
        }

        static SetGlobalCustomCreateThreadFn ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalCustomCreateThreadFn$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static MemorySegment SetGlobalCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalCustomCreateThreadFn$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalCustomCreateThreadFn$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetGlobalCustomCreateThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalCustomCreateThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomCreateThreadFn SetGlobalCustomCreateThreadFn(
            MemorySegment segment, SegmentScope scope) {
        return SetGlobalCustomCreateThreadFn.ofAddress(SetGlobalCustomCreateThreadFn$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalCustomThreadCreationOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalCustomThreadCreationOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalCustomThreadCreationOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
     * }
     */
    public interface SetGlobalCustomThreadCreationOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalCustomThreadCreationOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SetGlobalCustomThreadCreationOptions$FUNC,
                    scope);
        }

        static SetGlobalCustomThreadCreationOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalCustomThreadCreationOptions$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
     * }
     */
    public static MemorySegment SetGlobalCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalCustomThreadCreationOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
     * }
     */
    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalCustomThreadCreationOptions$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetGlobalCustomThreadCreationOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalCustomThreadCreationOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomThreadCreationOptions SetGlobalCustomThreadCreationOptions(
            MemorySegment segment, SegmentScope scope) {
        return SetGlobalCustomThreadCreationOptions.ofAddress(SetGlobalCustomThreadCreationOptions$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalCustomJoinThreadFn$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalCustomJoinThreadFn$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalCustomJoinThreadFn$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public interface SetGlobalCustomJoinThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalCustomJoinThreadFn fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomJoinThreadFn.class, fi, OrtApi.SetGlobalCustomJoinThreadFn$FUNC, scope);
        }

        static SetGlobalCustomJoinThreadFn ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalCustomJoinThreadFn$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static MemorySegment SetGlobalCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalCustomJoinThreadFn$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalCustomJoinThreadFn$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetGlobalCustomJoinThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalCustomJoinThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomJoinThreadFn SetGlobalCustomJoinThreadFn(MemorySegment segment, SegmentScope scope) {
        return SetGlobalCustomJoinThreadFn.ofAddress(SetGlobalCustomJoinThreadFn$get(segment), scope);
    }

    static final FunctionDescriptor SynchronizeBoundInputs$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SynchronizeBoundInputs$MH =
            RuntimeHelper.downcallHandle(OrtApi.SynchronizeBoundInputs$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
     * }
     */
    public interface SynchronizeBoundInputs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SynchronizeBoundInputs fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundInputs.class, fi, OrtApi.SynchronizeBoundInputs$FUNC, scope);
        }

        static SynchronizeBoundInputs ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.SynchronizeBoundInputs$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment SynchronizeBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SynchronizeBoundInputs$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
     * }
     */
    public static void SynchronizeBoundInputs$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SynchronizeBoundInputs$VH.set(seg, x);
    }

    public static MemorySegment SynchronizeBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SynchronizeBoundInputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SynchronizeBoundInputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SynchronizeBoundInputs SynchronizeBoundInputs(MemorySegment segment, SegmentScope scope) {
        return SynchronizeBoundInputs.ofAddress(SynchronizeBoundInputs$get(segment), scope);
    }

    static final FunctionDescriptor SynchronizeBoundOutputs$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SynchronizeBoundOutputs$MH =
            RuntimeHelper.downcallHandle(OrtApi.SynchronizeBoundOutputs$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
     * }
     */
    public interface SynchronizeBoundOutputs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SynchronizeBoundOutputs fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundOutputs.class, fi, OrtApi.SynchronizeBoundOutputs$FUNC, scope);
        }

        static SynchronizeBoundOutputs ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SynchronizeBoundOutputs$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment SynchronizeBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SynchronizeBoundOutputs$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static void SynchronizeBoundOutputs$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SynchronizeBoundOutputs$VH.set(seg, x);
    }

    public static MemorySegment SynchronizeBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.SynchronizeBoundOutputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SynchronizeBoundOutputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SynchronizeBoundOutputs SynchronizeBoundOutputs(MemorySegment segment, SegmentScope scope) {
        return SynchronizeBoundOutputs.ofAddress(SynchronizeBoundOutputs$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CUDA_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CUDA_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CUDA_V2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA_V2 fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CUDA_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA_V2 ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA_V2 SessionOptionsAppendExecutionProvider_CUDA_V2(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_CUDA_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA_V2$get(segment), scope);
    }

    static final FunctionDescriptor CreateCUDAProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCUDAProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateCUDAProviderOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
     * }
     */
    public interface CreateCUDAProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateCUDAProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateCUDAProviderOptions.class, fi, OrtApi.CreateCUDAProviderOptions$FUNC, scope);
        }

        static CreateCUDAProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateCUDAProviderOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
     * }
     */
    public static MemorySegment CreateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCUDAProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
     * }
     */
    public static void CreateCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateCUDAProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment CreateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCUDAProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateCUDAProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCUDAProviderOptions CreateCUDAProviderOptions(MemorySegment segment, SegmentScope scope) {
        return CreateCUDAProviderOptions.ofAddress(CreateCUDAProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor UpdateCUDAProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateCUDAProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateCUDAProviderOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptions)(OrtCUDAProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public interface UpdateCUDAProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateCUDAProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    UpdateCUDAProviderOptions.class, fi, OrtApi.UpdateCUDAProviderOptions$FUNC, scope);
        }

        static UpdateCUDAProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UpdateCUDAProviderOptions$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptions)(OrtCUDAProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UpdateCUDAProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptions)(OrtCUDAProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UpdateCUDAProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment UpdateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.UpdateCUDAProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UpdateCUDAProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateCUDAProviderOptions UpdateCUDAProviderOptions(MemorySegment segment, SegmentScope scope) {
        return UpdateCUDAProviderOptions.ofAddress(UpdateCUDAProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor GetCUDAProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCUDAProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCUDAProviderOptionsAsString$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsAsString)(const OrtCUDAProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public interface GetCUDAProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetCUDAProviderOptionsAsString fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetCUDAProviderOptionsAsString.class, fi, OrtApi.GetCUDAProviderOptionsAsString$FUNC, scope);
        }

        static GetCUDAProviderOptionsAsString ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetCUDAProviderOptionsAsString$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsAsString)(const OrtCUDAProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetCUDAProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetCUDAProviderOptionsAsString$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsAsString)(const OrtCUDAProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetCUDAProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemorySegment GetCUDAProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetCUDAProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetCUDAProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCUDAProviderOptionsAsString GetCUDAProviderOptionsAsString(
            MemorySegment segment, SegmentScope scope) {
        return GetCUDAProviderOptionsAsString.ofAddress(GetCUDAProviderOptionsAsString$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseCUDAProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseCUDAProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseCUDAProviderOptions$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
     * }
     */
    public interface ReleaseCUDAProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCUDAProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseCUDAProviderOptions.class, fi, OrtApi.ReleaseCUDAProviderOptions$FUNC, scope);
        }

        static ReleaseCUDAProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseCUDAProviderOptions$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
     * }
     */
    public static MemorySegment ReleaseCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseCUDAProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
     * }
     */
    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseCUDAProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment ReleaseCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ReleaseCUDAProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseCUDAProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCUDAProviderOptions ReleaseCUDAProviderOptions(MemorySegment segment, SegmentScope scope) {
        return ReleaseCUDAProviderOptions.ofAddress(ReleaseCUDAProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_MIGraphX$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_MIGraphX$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_MIGraphX {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_MIGraphX fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_MIGraphX.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_MIGraphX ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(
            MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_MIGraphX SessionOptionsAppendExecutionProvider_MIGraphX(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_MIGraphX.ofAddress(
                SessionOptionsAppendExecutionProvider_MIGraphX$get(segment), scope);
    }

    static final FunctionDescriptor AddExternalInitializers$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle AddExternalInitializers$MH =
            RuntimeHelper.downcallHandle(OrtApi.AddExternalInitializers$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*AddExternalInitializers)(OrtSessionOptions*,char**,const OrtValue**,size_t);
     * }
     */
    public interface AddExternalInitializers {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(AddExternalInitializers fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    AddExternalInitializers.class, fi, OrtApi.AddExternalInitializers$FUNC, scope);
        }

        static AddExternalInitializers ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.AddExternalInitializers$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddExternalInitializers)(OrtSessionOptions*,char**,const OrtValue**,size_t);
     * }
     */
    public static MemorySegment AddExternalInitializers$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddExternalInitializers$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddExternalInitializers)(OrtSessionOptions*,char**,const OrtValue**,size_t);
     * }
     */
    public static void AddExternalInitializers$set(MemorySegment seg, MemorySegment x) {
        OrtApi.AddExternalInitializers$VH.set(seg, x);
    }

    public static MemorySegment AddExternalInitializers$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.AddExternalInitializers$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddExternalInitializers$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.AddExternalInitializers$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddExternalInitializers AddExternalInitializers(MemorySegment segment, SegmentScope scope) {
        return AddExternalInitializers.ofAddress(AddExternalInitializers$get(segment), scope);
    }

    static final FunctionDescriptor CreateOpAttr$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_INT$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateOpAttr$MH = RuntimeHelper.downcallHandle(OrtApi.CreateOpAttr$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateOpAttr)(char*,void*,int,OrtOpAttrType,OrtOpAttr**);
     * }
     */
    public interface CreateOpAttr {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                int _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateOpAttr fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateOpAttr.class, fi, OrtApi.CreateOpAttr$FUNC, scope);
        }

        static CreateOpAttr ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    int __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateOpAttr$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpAttr)(char*,void*,int,OrtOpAttrType,OrtOpAttr**);
     * }
     */
    public static MemorySegment CreateOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateOpAttr$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpAttr)(char*,void*,int,OrtOpAttrType,OrtOpAttr**);
     * }
     */
    public static void CreateOpAttr$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateOpAttr$VH.set(seg, x);
    }

    public static MemorySegment CreateOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateOpAttr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateOpAttr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOpAttr CreateOpAttr(MemorySegment segment, SegmentScope scope) {
        return CreateOpAttr.ofAddress(CreateOpAttr$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseOpAttr$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseOpAttr$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseOpAttr$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseOpAttr)(OrtOpAttr*);
     * }
     */
    public interface ReleaseOpAttr {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseOpAttr fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseOpAttr.class, fi, OrtApi.ReleaseOpAttr$FUNC, scope);
        }

        static ReleaseOpAttr ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseOpAttr$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseOpAttr)(OrtOpAttr*);
     * }
     */
    public static MemorySegment ReleaseOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseOpAttr$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseOpAttr)(OrtOpAttr*);
     * }
     */
    public static void ReleaseOpAttr$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseOpAttr$VH.set(seg, x);
    }

    public static MemorySegment ReleaseOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseOpAttr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseOpAttr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseOpAttr ReleaseOpAttr(MemorySegment segment, SegmentScope scope) {
        return ReleaseOpAttr.ofAddress(ReleaseOpAttr$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateOp)(const OrtKernelInfo*,char*,char*,int,char**,const ONNXTensorElementDataType*,int,const OrtOpAttr**,int,int,int,OrtOp**);
     * }
     */
    public interface CreateOp {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5,
                int _x6,
                java.lang.foreign.MemorySegment _x7,
                int _x8,
                int _x9,
                int _x10,
                java.lang.foreign.MemorySegment _x11);

        static MemorySegment allocate(CreateOp fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateOp.class, fi, OrtApi.CreateOp$FUNC, scope);
        }

        static CreateOp ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    int __x6,
                    java.lang.foreign.MemorySegment __x7,
                    int __x8,
                    int __x9,
                    int __x10,
                    java.lang.foreign.MemorySegment __x11) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CreateOp$MH.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8, __x9, __x10, __x11);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOp)(const OrtKernelInfo*,char*,char*,int,char**,const ONNXTensorElementDataType*,int,const OrtOpAttr**,int,int,int,OrtOp**);
     * }
     */
    public static MemorySegment CreateOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateOp$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOp)(const OrtKernelInfo*,char*,char*,int,char**,const ONNXTensorElementDataType*,int,const OrtOpAttr**,int,int,int,OrtOp**);
     * }
     */
    public static void CreateOp$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateOp$VH.set(seg, x);
    }

    public static MemorySegment CreateOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateOp$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOp$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateOp$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOp CreateOp(MemorySegment segment, SegmentScope scope) {
        return CreateOp.ofAddress(CreateOp$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*InvokeOp)(const OrtKernelContext*,const OrtOp*,const OrtValue**,int,OrtValue**,int);
     * }
     */
    public interface InvokeOp {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4,
                int _x5);

        static MemorySegment allocate(InvokeOp fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(InvokeOp.class, fi, OrtApi.InvokeOp$FUNC, scope);
        }

        static InvokeOp ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4,
                    int __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.InvokeOp$MH.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*InvokeOp)(const OrtKernelContext*,const OrtOp*,const OrtValue**,int,OrtValue**,int);
     * }
     */
    public static MemorySegment InvokeOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.InvokeOp$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*InvokeOp)(const OrtKernelContext*,const OrtOp*,const OrtValue**,int,OrtValue**,int);
     * }
     */
    public static void InvokeOp$set(MemorySegment seg, MemorySegment x) {
        OrtApi.InvokeOp$VH.set(seg, x);
    }

    public static MemorySegment InvokeOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.InvokeOp$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void InvokeOp$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.InvokeOp$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static InvokeOp InvokeOp(MemorySegment segment, SegmentScope scope) {
        return InvokeOp.ofAddress(InvokeOp$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseOp$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseOp$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseOp$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseOp)(OrtOp*);
     * }
     */
    public interface ReleaseOp {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseOp fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseOp.class, fi, OrtApi.ReleaseOp$FUNC, scope);
        }

        static ReleaseOp ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseOp$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseOp)(OrtOp*);
     * }
     */
    public static MemorySegment ReleaseOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseOp$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseOp)(OrtOp*);
     * }
     */
    public static void ReleaseOp$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseOp$VH.set(seg, x);
    }

    public static MemorySegment ReleaseOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseOp$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseOp$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseOp$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseOp ReleaseOp(MemorySegment segment, SegmentScope scope) {
        return ReleaseOp.ofAddress(ReleaseOp$get(segment), scope);
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
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider)(OrtSessionOptions*,char*,char**,char**,size_t);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider$MH.invokeExact(
                                    symbol, __x0, __x1, __x2, __x3, __x4);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider)(OrtSessionOptions*,char*,char**,char**,size_t);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider)(OrtSessionOptions*,char*,char**,char**,size_t);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider SessionOptionsAppendExecutionProvider(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider.ofAddress(
                SessionOptionsAppendExecutionProvider$get(segment), scope);
    }

    static final FunctionDescriptor CopyKernelInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CopyKernelInfo$MH = RuntimeHelper.downcallHandle(OrtApi.CopyKernelInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
     * }
     */
    public interface CopyKernelInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CopyKernelInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CopyKernelInfo.class, fi, OrtApi.CopyKernelInfo$FUNC, scope);
        }

        static CopyKernelInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.CopyKernelInfo$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
     * }
     */
    public static MemorySegment CopyKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CopyKernelInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
     * }
     */
    public static void CopyKernelInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CopyKernelInfo$VH.set(seg, x);
    }

    public static MemorySegment CopyKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CopyKernelInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CopyKernelInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CopyKernelInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CopyKernelInfo CopyKernelInfo(MemorySegment segment, SegmentScope scope) {
        return CopyKernelInfo.ofAddress(CopyKernelInfo$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseKernelInfo$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseKernelInfo$MH = RuntimeHelper.downcallHandle(OrtApi.ReleaseKernelInfo$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseKernelInfo)(OrtKernelInfo*);
     * }
     */
    public interface ReleaseKernelInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseKernelInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(ReleaseKernelInfo.class, fi, OrtApi.ReleaseKernelInfo$FUNC, scope);
        }

        static ReleaseKernelInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseKernelInfo$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseKernelInfo)(OrtKernelInfo*);
     * }
     */
    public static MemorySegment ReleaseKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseKernelInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseKernelInfo)(OrtKernelInfo*);
     * }
     */
    public static void ReleaseKernelInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseKernelInfo$VH.set(seg, x);
    }

    public static MemorySegment ReleaseKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseKernelInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseKernelInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseKernelInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseKernelInfo ReleaseKernelInfo(MemorySegment segment, SegmentScope scope) {
        return ReleaseKernelInfo.ofAddress(ReleaseKernelInfo$get(segment), scope);
    }

    static final FunctionDescriptor GetTrainingApi$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle GetTrainingApi$MH = RuntimeHelper.downcallHandle(OrtApi.GetTrainingApi$FUNC);
    /**
     * {@snippet :
     * const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
     * }
     */
    public interface GetTrainingApi {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(GetTrainingApi fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetTrainingApi.class, fi, OrtApi.GetTrainingApi$FUNC, scope);
        }

        static GetTrainingApi ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtApi.GetTrainingApi$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
     * }
     */
    public static MemorySegment GetTrainingApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTrainingApi$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
     * }
     */
    public static void GetTrainingApi$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetTrainingApi$VH.set(seg, x);
    }

    public static MemorySegment GetTrainingApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetTrainingApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTrainingApi$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetTrainingApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTrainingApi GetTrainingApi(MemorySegment segment, SegmentScope scope) {
        return GetTrainingApi.ofAddress(GetTrainingApi$get(segment), scope);
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CANN$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CANN$MH =
            RuntimeHelper.downcallHandle(OrtApi.SessionOptionsAppendExecutionProvider_CANN$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CANN {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CANN fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CANN.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CANN$FUNC,
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_CANN ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SessionOptionsAppendExecutionProvider_CANN$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.set(seg, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CANN$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CANN SessionOptionsAppendExecutionProvider_CANN(
            MemorySegment segment, SegmentScope scope) {
        return SessionOptionsAppendExecutionProvider_CANN.ofAddress(
                SessionOptionsAppendExecutionProvider_CANN$get(segment), scope);
    }

    static final FunctionDescriptor CreateCANNProviderOptions$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateCANNProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.CreateCANNProviderOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
     * }
     */
    public interface CreateCANNProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateCANNProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateCANNProviderOptions.class, fi, OrtApi.CreateCANNProviderOptions$FUNC, scope);
        }

        static CreateCANNProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.CreateCANNProviderOptions$MH.invokeExact(symbol, __x0);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
     * }
     */
    public static MemorySegment CreateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCANNProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
     * }
     */
    public static void CreateCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.CreateCANNProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment CreateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.CreateCANNProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.CreateCANNProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCANNProviderOptions CreateCANNProviderOptions(MemorySegment segment, SegmentScope scope) {
        return CreateCANNProviderOptions.ofAddress(CreateCANNProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor UpdateCANNProviderOptions$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle UpdateCANNProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateCANNProviderOptions$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateCANNProviderOptions)(OrtCANNProviderOptions*,char**,char**,size_t);
     * }
     */
    public interface UpdateCANNProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateCANNProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    UpdateCANNProviderOptions.class, fi, OrtApi.UpdateCANNProviderOptions$FUNC, scope);
        }

        static UpdateCANNProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UpdateCANNProviderOptions$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCANNProviderOptions)(OrtCANNProviderOptions*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UpdateCANNProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCANNProviderOptions)(OrtCANNProviderOptions*,char**,char**,size_t);
     * }
     */
    public static void UpdateCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UpdateCANNProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment UpdateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.UpdateCANNProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UpdateCANNProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateCANNProviderOptions UpdateCANNProviderOptions(MemorySegment segment, SegmentScope scope) {
        return UpdateCANNProviderOptions.ofAddress(UpdateCANNProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor GetCANNProviderOptionsAsString$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetCANNProviderOptionsAsString$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetCANNProviderOptionsAsString$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetCANNProviderOptionsAsString)(const OrtCANNProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public interface GetCANNProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetCANNProviderOptionsAsString fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetCANNProviderOptionsAsString.class, fi, OrtApi.GetCANNProviderOptionsAsString$FUNC, scope);
        }

        static GetCANNProviderOptionsAsString ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetCANNProviderOptionsAsString$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCANNProviderOptionsAsString)(const OrtCANNProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetCANNProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetCANNProviderOptionsAsString$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCANNProviderOptionsAsString)(const OrtCANNProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetCANNProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemorySegment GetCANNProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.GetCANNProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetCANNProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCANNProviderOptionsAsString GetCANNProviderOptionsAsString(
            MemorySegment segment, SegmentScope scope) {
        return GetCANNProviderOptionsAsString.ofAddress(GetCANNProviderOptionsAsString$get(segment), scope);
    }

    static final FunctionDescriptor ReleaseCANNProviderOptions$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle ReleaseCANNProviderOptions$MH =
            RuntimeHelper.downcallHandle(OrtApi.ReleaseCANNProviderOptions$FUNC);
    /**
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
     * }
     */
    public interface ReleaseCANNProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCANNProviderOptions fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseCANNProviderOptions.class, fi, OrtApi.ReleaseCANNProviderOptions$FUNC, scope);
        }

        static ReleaseCANNProviderOptions ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtApi.ReleaseCANNProviderOptions$MH.invokeExact(symbol, _ort_custom_thread_handle);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.ReleaseCANNProviderOptions$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
     * }
     */
    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        OrtApi.ReleaseCANNProviderOptions$VH.set(seg, x);
    }

    public static MemorySegment ReleaseCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.ReleaseCANNProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.ReleaseCANNProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCANNProviderOptions ReleaseCANNProviderOptions(MemorySegment segment, SegmentScope scope) {
        return ReleaseCANNProviderOptions.ofAddress(ReleaseCANNProviderOptions$get(segment), scope);
    }

    static final FunctionDescriptor MemoryInfoGetDeviceType$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle MemoryInfoGetDeviceType$MH =
            RuntimeHelper.downcallHandle(OrtApi.MemoryInfoGetDeviceType$FUNC);
    /**
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
     * }
     */
    public interface MemoryInfoGetDeviceType {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetDeviceType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetDeviceType.class, fi, OrtApi.MemoryInfoGetDeviceType$FUNC, scope);
        }

        static MemoryInfoGetDeviceType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    OrtApi.MemoryInfoGetDeviceType$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
     * }
     */
    public static MemorySegment MemoryInfoGetDeviceType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetDeviceType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
     * }
     */
    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, MemorySegment x) {
        OrtApi.MemoryInfoGetDeviceType$VH.set(seg, x);
    }

    public static MemorySegment MemoryInfoGetDeviceType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.MemoryInfoGetDeviceType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.MemoryInfoGetDeviceType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetDeviceType MemoryInfoGetDeviceType(MemorySegment segment, SegmentScope scope) {
        return MemoryInfoGetDeviceType.ofAddress(MemoryInfoGetDeviceType$get(segment), scope);
    }

    static final FunctionDescriptor UpdateEnvWithCustomLogLevel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_INT$LAYOUT);
    static final MethodHandle UpdateEnvWithCustomLogLevel$MH =
            RuntimeHelper.downcallHandle(OrtApi.UpdateEnvWithCustomLogLevel$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
     * }
     */
    public interface UpdateEnvWithCustomLogLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(UpdateEnvWithCustomLogLevel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    UpdateEnvWithCustomLogLevel.class, fi, OrtApi.UpdateEnvWithCustomLogLevel$FUNC, scope);
        }

        static UpdateEnvWithCustomLogLevel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.UpdateEnvWithCustomLogLevel$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
     * }
     */
    public static MemorySegment UpdateEnvWithCustomLogLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.UpdateEnvWithCustomLogLevel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
     * }
     */
    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, MemorySegment x) {
        OrtApi.UpdateEnvWithCustomLogLevel$VH.set(seg, x);
    }

    public static MemorySegment UpdateEnvWithCustomLogLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.UpdateEnvWithCustomLogLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.UpdateEnvWithCustomLogLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateEnvWithCustomLogLevel UpdateEnvWithCustomLogLevel(MemorySegment segment, SegmentScope scope) {
        return UpdateEnvWithCustomLogLevel.ofAddress(UpdateEnvWithCustomLogLevel$get(segment), scope);
    }

    static final FunctionDescriptor SetGlobalIntraOpThreadAffinity$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle SetGlobalIntraOpThreadAffinity$MH =
            RuntimeHelper.downcallHandle(OrtApi.SetGlobalIntraOpThreadAffinity$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
     * }
     */
    public interface SetGlobalIntraOpThreadAffinity {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalIntraOpThreadAffinity fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalIntraOpThreadAffinity.class, fi, OrtApi.SetGlobalIntraOpThreadAffinity$FUNC, scope);
        }

        static SetGlobalIntraOpThreadAffinity ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.SetGlobalIntraOpThreadAffinity$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
     * }
     */
    public static MemorySegment SetGlobalIntraOpThreadAffinity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.SetGlobalIntraOpThreadAffinity$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
     * }
     */
    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, MemorySegment x) {
        OrtApi.SetGlobalIntraOpThreadAffinity$VH.set(seg, x);
    }

    public static MemorySegment SetGlobalIntraOpThreadAffinity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.SetGlobalIntraOpThreadAffinity$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.SetGlobalIntraOpThreadAffinity$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalIntraOpThreadAffinity SetGlobalIntraOpThreadAffinity(
            MemorySegment segment, SegmentScope scope) {
        return SetGlobalIntraOpThreadAffinity.ofAddress(SetGlobalIntraOpThreadAffinity$get(segment), scope);
    }

    static final FunctionDescriptor RegisterCustomOpsLibrary_V2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsLibrary_V2$MH =
            RuntimeHelper.downcallHandle(OrtApi.RegisterCustomOpsLibrary_V2$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
     * }
     */
    public interface RegisterCustomOpsLibrary_V2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RegisterCustomOpsLibrary_V2 fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsLibrary_V2.class, fi, OrtApi.RegisterCustomOpsLibrary_V2$FUNC, scope);
        }

        static RegisterCustomOpsLibrary_V2 ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RegisterCustomOpsLibrary_V2$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment RegisterCustomOpsLibrary_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RegisterCustomOpsLibrary_V2$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
     * }
     */
    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RegisterCustomOpsLibrary_V2$VH.set(seg, x);
    }

    public static MemorySegment RegisterCustomOpsLibrary_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.RegisterCustomOpsLibrary_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RegisterCustomOpsLibrary_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsLibrary_V2 RegisterCustomOpsLibrary_V2(MemorySegment segment, SegmentScope scope) {
        return RegisterCustomOpsLibrary_V2.ofAddress(RegisterCustomOpsLibrary_V2$get(segment), scope);
    }

    static final FunctionDescriptor RegisterCustomOpsUsingFunction$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle RegisterCustomOpsUsingFunction$MH =
            RuntimeHelper.downcallHandle(OrtApi.RegisterCustomOpsUsingFunction$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
     * }
     */
    public interface RegisterCustomOpsUsingFunction {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RegisterCustomOpsUsingFunction fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsUsingFunction.class, fi, OrtApi.RegisterCustomOpsUsingFunction$FUNC, scope);
        }

        static RegisterCustomOpsUsingFunction ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.RegisterCustomOpsUsingFunction$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment RegisterCustomOpsUsingFunction$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.RegisterCustomOpsUsingFunction$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
     * }
     */
    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, MemorySegment x) {
        OrtApi.RegisterCustomOpsUsingFunction$VH.set(seg, x);
    }

    public static MemorySegment RegisterCustomOpsUsingFunction$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.RegisterCustomOpsUsingFunction$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.RegisterCustomOpsUsingFunction$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsUsingFunction RegisterCustomOpsUsingFunction(
            MemorySegment segment, SegmentScope scope) {
        return RegisterCustomOpsUsingFunction.ofAddress(RegisterCustomOpsUsingFunction$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfo_GetInputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetInputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetInputCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public interface KernelInfo_GetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelInfo_GetInputCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetInputCount.class, fi, OrtApi.KernelInfo_GetInputCount$FUNC, scope);
        }

        static KernelInfo_GetInputCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfo_GetInputCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetInputCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static void KernelInfo_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfo_GetInputCount$VH.set(seg, x);
    }

    public static MemorySegment KernelInfo_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfo_GetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetInputCount KernelInfo_GetInputCount(MemorySegment segment, SegmentScope scope) {
        return KernelInfo_GetInputCount.ofAddress(KernelInfo_GetInputCount$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfo_GetOutputCount$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetOutputCount$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetOutputCount$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public interface KernelInfo_GetOutputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelInfo_GetOutputCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetOutputCount.class, fi, OrtApi.KernelInfo_GetOutputCount$FUNC, scope);
        }

        static KernelInfo_GetOutputCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfo_GetOutputCount$MH.invokeExact(symbol, __x0, __x1);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetOutputCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfo_GetOutputCount$VH.set(seg, x);
    }

    public static MemorySegment KernelInfo_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfo_GetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetOutputCount KernelInfo_GetOutputCount(MemorySegment segment, SegmentScope scope) {
        return KernelInfo_GetOutputCount.ofAddress(KernelInfo_GetOutputCount$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfo_GetInputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetInputName$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetInputName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public interface KernelInfo_GetInputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfo_GetInputName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetInputName.class, fi, OrtApi.KernelInfo_GetInputName$FUNC, scope);
        }

        static KernelInfo_GetInputName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfo_GetInputName$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetInputName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static void KernelInfo_GetInputName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfo_GetInputName$VH.set(seg, x);
    }

    public static MemorySegment KernelInfo_GetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetInputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetInputName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfo_GetInputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetInputName KernelInfo_GetInputName(MemorySegment segment, SegmentScope scope) {
        return KernelInfo_GetInputName.ofAddress(KernelInfo_GetInputName$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfo_GetOutputName$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetOutputName$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetOutputName$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public interface KernelInfo_GetOutputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfo_GetOutputName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetOutputName.class, fi, OrtApi.KernelInfo_GetOutputName$FUNC, scope);
        }

        static KernelInfo_GetOutputName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfo_GetOutputName$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetOutputName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static void KernelInfo_GetOutputName$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfo_GetOutputName$VH.set(seg, x);
    }

    public static MemorySegment KernelInfo_GetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetOutputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetOutputName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfo_GetOutputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetOutputName KernelInfo_GetOutputName(MemorySegment segment, SegmentScope scope) {
        return KernelInfo_GetOutputName.ofAddress(KernelInfo_GetOutputName$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfo_GetInputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetInputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetInputTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public interface KernelInfo_GetInputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetInputTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetInputTypeInfo.class, fi, OrtApi.KernelInfo_GetInputTypeInfo$FUNC, scope);
        }

        static KernelInfo_GetInputTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfo_GetInputTypeInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment KernelInfo_GetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetInputTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfo_GetInputTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment KernelInfo_GetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfo_GetInputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfo_GetInputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetInputTypeInfo KernelInfo_GetInputTypeInfo(MemorySegment segment, SegmentScope scope) {
        return KernelInfo_GetInputTypeInfo.ofAddress(KernelInfo_GetInputTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfo_GetOutputTypeInfo$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_LONG_LONG$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfo_GetOutputTypeInfo$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfo_GetOutputTypeInfo$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public interface KernelInfo_GetOutputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetOutputTypeInfo fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfo_GetOutputTypeInfo.class, fi, OrtApi.KernelInfo_GetOutputTypeInfo$FUNC, scope);
        }

        static KernelInfo_GetOutputTypeInfo ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfo_GetOutputTypeInfo$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfo_GetOutputTypeInfo$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfo_GetOutputTypeInfo$VH.set(seg, x);
    }

    public static MemorySegment KernelInfo_GetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfo_GetOutputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfo_GetOutputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfo_GetOutputTypeInfo KernelInfo_GetOutputTypeInfo(MemorySegment segment, SegmentScope scope) {
        return KernelInfo_GetOutputTypeInfo.ofAddress(KernelInfo_GetOutputTypeInfo$get(segment), scope);
    }

    static final FunctionDescriptor KernelInfoGetAttribute_tensor$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelInfoGetAttribute_tensor$MH =
            RuntimeHelper.downcallHandle(OrtApi.KernelInfoGetAttribute_tensor$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_tensor)(const OrtKernelInfo*,char*,OrtAllocator*,OrtValue**);
     * }
     */
    public interface KernelInfoGetAttribute_tensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttribute_tensor fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_tensor.class, fi, OrtApi.KernelInfoGetAttribute_tensor$FUNC, scope);
        }

        static KernelInfoGetAttribute_tensor ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.KernelInfoGetAttribute_tensor$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_tensor)(const OrtKernelInfo*,char*,OrtAllocator*,OrtValue**);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.KernelInfoGetAttribute_tensor$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_tensor)(const OrtKernelInfo*,char*,OrtAllocator*,OrtValue**);
     * }
     */
    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_tensor$VH.set(seg, x);
    }

    public static MemorySegment KernelInfoGetAttribute_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtApi.KernelInfoGetAttribute_tensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.KernelInfoGetAttribute_tensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_tensor KernelInfoGetAttribute_tensor(
            MemorySegment segment, SegmentScope scope) {
        return KernelInfoGetAttribute_tensor.ofAddress(KernelInfoGetAttribute_tensor$get(segment), scope);
    }

    static final FunctionDescriptor HasSessionConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle HasSessionConfigEntry$MH =
            RuntimeHelper.downcallHandle(OrtApi.HasSessionConfigEntry$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*HasSessionConfigEntry)(const OrtSessionOptions*,char*,int*);
     * }
     */
    public interface HasSessionConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(HasSessionConfigEntry fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(HasSessionConfigEntry.class, fi, OrtApi.HasSessionConfigEntry$FUNC, scope);
        }

        static HasSessionConfigEntry ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.HasSessionConfigEntry$MH.invokeExact(symbol, __x0, __x1, __x2);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*HasSessionConfigEntry)(const OrtSessionOptions*,char*,int*);
     * }
     */
    public static MemorySegment HasSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.HasSessionConfigEntry$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*HasSessionConfigEntry)(const OrtSessionOptions*,char*,int*);
     * }
     */
    public static void HasSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        OrtApi.HasSessionConfigEntry$VH.set(seg, x);
    }

    public static MemorySegment HasSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.HasSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void HasSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.HasSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static HasSessionConfigEntry HasSessionConfigEntry(MemorySegment segment, SegmentScope scope) {
        return HasSessionConfigEntry.ofAddress(HasSessionConfigEntry$get(segment), scope);
    }

    static final FunctionDescriptor GetSessionConfigEntry$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetSessionConfigEntry$MH =
            RuntimeHelper.downcallHandle(OrtApi.GetSessionConfigEntry$FUNC);
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSessionConfigEntry)(const OrtSessionOptions*,char*,char*,size_t*);
     * }
     */
    public interface GetSessionConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetSessionConfigEntry fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetSessionConfigEntry.class, fi, OrtApi.GetSessionConfigEntry$FUNC, scope);
        }

        static GetSessionConfigEntry ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtApi.GetSessionConfigEntry$MH.invokeExact(symbol, __x0, __x1, __x2, __x3);
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
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSessionConfigEntry)(const OrtSessionOptions*,char*,char*,size_t*);
     * }
     */
    public static MemorySegment GetSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSessionConfigEntry$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSessionConfigEntry)(const OrtSessionOptions*,char*,char*,size_t*);
     * }
     */
    public static void GetSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        OrtApi.GetSessionConfigEntry$VH.set(seg, x);
    }

    public static MemorySegment GetSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtApi.GetSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        OrtApi.GetSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSessionConfigEntry GetSessionConfigEntry(MemorySegment segment, SegmentScope scope) {
        return GetSessionConfigEntry.ofAddress(GetSessionConfigEntry$get(segment), scope);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemorySegment addr, SegmentScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
