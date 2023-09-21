/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtApi {
 *     struct OrtStatus* (*CreateStatus)(enum OrtErrorCode,char*);
 *     enum OrtErrorCode (*GetErrorCode)(struct OrtStatus*);
 *     char* (*GetErrorMessage)(struct OrtStatus*);
 *     struct OrtStatus* (*CreateEnv)(enum OrtLoggingLevel,char*,struct OrtEnv**);
 *     struct OrtStatus* (*CreateEnvWithCustomLogger)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtEnv**);
 *     struct OrtStatus* (*EnableTelemetryEvents)(struct OrtEnv*);
 *     struct OrtStatus* (*DisableTelemetryEvents)(struct OrtEnv*);
 *     struct OrtStatus* (*CreateSession)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtSession**);
 *     struct OrtStatus* (*CreateSessionFromArray)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtSession**);
 *     struct OrtStatus* (*Run)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**);
 *     struct OrtStatus* (*CreateSessionOptions)(struct OrtSessionOptions**);
 *     struct OrtStatus* (*SetOptimizedModelFilePath)(struct OrtSessionOptions*,char*);
 *     struct OrtStatus* (*CloneSessionOptions)(struct OrtSessionOptions*,struct OrtSessionOptions**);
 *     struct OrtStatus* (*SetSessionExecutionMode)(struct OrtSessionOptions*,enum ExecutionMode);
 *     struct OrtStatus* (*EnableProfiling)(struct OrtSessionOptions*,char*);
 *     struct OrtStatus* (*DisableProfiling)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*EnableMemPattern)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*DisableMemPattern)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*EnableCpuMemArena)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*DisableCpuMemArena)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*SetSessionLogId)(struct OrtSessionOptions*,char*);
 *     struct OrtStatus* (*SetSessionLogVerbosityLevel)(struct OrtSessionOptions*,int);
 *     struct OrtStatus* (*SetSessionLogSeverityLevel)(struct OrtSessionOptions*,int);
 *     struct OrtStatus* (*SetSessionGraphOptimizationLevel)(struct OrtSessionOptions*,enum GraphOptimizationLevel);
 *     struct OrtStatus* (*SetIntraOpNumThreads)(struct OrtSessionOptions*,int);
 *     struct OrtStatus* (*SetInterOpNumThreads)(struct OrtSessionOptions*,int);
 *     struct OrtStatus* (*CreateCustomOpDomain)(char*,struct OrtCustomOpDomain**);
 *     struct OrtStatus* (*CustomOpDomain_Add)(struct OrtCustomOpDomain*,struct OrtCustomOp*);
 *     struct OrtStatus* (*AddCustomOpDomain)(struct OrtSessionOptions*,struct OrtCustomOpDomain*);
 *     struct OrtStatus* (*RegisterCustomOpsLibrary)(struct OrtSessionOptions*,char*,void**);
 *     struct OrtStatus* (*SessionGetInputCount)(struct OrtSession*,unsigned long*);
 *     struct OrtStatus* (*SessionGetOutputCount)(struct OrtSession*,unsigned long*);
 *     struct OrtStatus* (*SessionGetOverridableInitializerCount)(struct OrtSession*,unsigned long*);
 *     struct OrtStatus* (*SessionGetInputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
 *     struct OrtStatus* (*SessionGetOutputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
 *     struct OrtStatus* (*SessionGetOverridableInitializerTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
 *     struct OrtStatus* (*SessionGetInputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*SessionGetOutputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*SessionGetOverridableInitializerName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*CreateRunOptions)(struct OrtRunOptions**);
 *     struct OrtStatus* (*RunOptionsSetRunLogVerbosityLevel)(struct OrtRunOptions*,int);
 *     struct OrtStatus* (*RunOptionsSetRunLogSeverityLevel)(struct OrtRunOptions*,int);
 *     struct OrtStatus* (*RunOptionsSetRunTag)(struct OrtRunOptions*,char*);
 *     struct OrtStatus* (*RunOptionsGetRunLogVerbosityLevel)(struct OrtRunOptions*,int*);
 *     struct OrtStatus* (*RunOptionsGetRunLogSeverityLevel)(struct OrtRunOptions*,int*);
 *     struct OrtStatus* (*RunOptionsGetRunTag)(struct OrtRunOptions*,char**);
 *     struct OrtStatus* (*RunOptionsSetTerminate)(struct OrtRunOptions*);
 *     struct OrtStatus* (*RunOptionsUnsetTerminate)(struct OrtRunOptions*);
 *     struct OrtStatus* (*CreateTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
 *     struct OrtStatus* (*CreateTensorWithDataAsOrtValue)(struct OrtMemoryInfo*,void*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
 *     struct OrtStatus* (*IsTensor)(struct OrtValue*,int*);
 *     struct OrtStatus* (*GetTensorMutableData)(struct OrtValue*,void**);
 *     struct OrtStatus* (*FillStringTensor)(struct OrtValue*,char**,unsigned long);
 *     struct OrtStatus* (*GetStringTensorDataLength)(struct OrtValue*,unsigned long*);
 *     struct OrtStatus* (*GetStringTensorContent)(struct OrtValue*,void*,unsigned long,unsigned long*,unsigned long);
 *     struct OrtStatus* (*CastTypeInfoToTensorInfo)(struct OrtTypeInfo*,struct OrtTensorTypeAndShapeInfo**);
 *     struct OrtStatus* (*GetOnnxTypeFromTypeInfo)(struct OrtTypeInfo*,enum ONNXType*);
 *     struct OrtStatus* (*CreateTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo**);
 *     struct OrtStatus* (*SetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
 *     struct OrtStatus* (*SetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
 *     struct OrtStatus* (*GetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
 *     struct OrtStatus* (*GetDimensionsCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
 *     struct OrtStatus* (*GetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
 *     struct OrtStatus* (*GetSymbolicDimensions)(struct OrtTensorTypeAndShapeInfo*,char**,unsigned long);
 *     struct OrtStatus* (*GetTensorShapeElementCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
 *     struct OrtStatus* (*GetTensorTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
 *     struct OrtStatus* (*GetTypeInfo)(struct OrtValue*,struct OrtTypeInfo**);
 *     struct OrtStatus* (*GetValueType)(struct OrtValue*,enum ONNXType*);
 *     struct OrtStatus* (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,struct OrtMemoryInfo**);
 *     struct OrtStatus* (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,struct OrtMemoryInfo**);
 *     struct OrtStatus* (*CompareMemoryInfo)(struct OrtMemoryInfo*,struct OrtMemoryInfo*,int*);
 *     struct OrtStatus* (*MemoryInfoGetName)(struct OrtMemoryInfo*,char**);
 *     struct OrtStatus* (*MemoryInfoGetId)(struct OrtMemoryInfo*,int*);
 *     struct OrtStatus* (*MemoryInfoGetMemType)(struct OrtMemoryInfo*,enum OrtMemType*);
 *     struct OrtStatus* (*MemoryInfoGetType)(struct OrtMemoryInfo*,enum OrtAllocatorType*);
 *     struct OrtStatus* (*AllocatorAlloc)(struct OrtAllocator*,unsigned long,void**);
 *     struct OrtStatus* (*AllocatorFree)(struct OrtAllocator*,void*);
 *     struct OrtStatus* (*AllocatorGetInfo)(struct OrtAllocator*,struct OrtMemoryInfo**);
 *     struct OrtStatus* (*GetAllocatorWithDefaultOptions)(struct OrtAllocator**);
 *     struct OrtStatus* (*AddFreeDimensionOverride)(struct OrtSessionOptions*,char*,long long);
 *     struct OrtStatus* (*GetValue)(struct OrtValue*,int,struct OrtAllocator*,struct OrtValue**);
 *     struct OrtStatus* (*GetValueCount)(struct OrtValue*,unsigned long*);
 *     struct OrtStatus* (*CreateValue)(struct OrtValue**,unsigned long,enum ONNXType,struct OrtValue**);
 *     struct OrtStatus* (*CreateOpaqueValue)(char*,char*,void*,unsigned long,struct OrtValue**);
 *     struct OrtStatus* (*GetOpaqueValue)(char*,char*,struct OrtValue*,void*,unsigned long);
 *     struct OrtStatus* (*KernelInfoGetAttribute_float)(struct OrtKernelInfo*,char*,float*);
 *     struct OrtStatus* (*KernelInfoGetAttribute_int64)(struct OrtKernelInfo*,char*,long long*);
 *     struct OrtStatus* (*KernelInfoGetAttribute_string)(struct OrtKernelInfo*,char*,char*,unsigned long*);
 *     struct OrtStatus* (*KernelContext_GetInputCount)(struct OrtKernelContext*,unsigned long*);
 *     struct OrtStatus* (*KernelContext_GetOutputCount)(struct OrtKernelContext*,unsigned long*);
 *     struct OrtStatus* (*KernelContext_GetInput)(struct OrtKernelContext*,unsigned long,struct OrtValue**);
 *     struct OrtStatus* (*KernelContext_GetOutput)(struct OrtKernelContext*,unsigned long,long long*,unsigned long,struct OrtValue**);
 *     void (*ReleaseEnv)(struct OrtEnv*);
 *     void (*ReleaseStatus)(struct OrtStatus*);
 *     void (*ReleaseMemoryInfo)(struct OrtMemoryInfo*);
 *     void (*ReleaseSession)(struct OrtSession*);
 *     void (*ReleaseValue)(struct OrtValue*);
 *     void (*ReleaseRunOptions)(struct OrtRunOptions*);
 *     void (*ReleaseTypeInfo)(struct OrtTypeInfo*);
 *     void (*ReleaseTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo*);
 *     void (*ReleaseSessionOptions)(struct OrtSessionOptions*);
 *     void (*ReleaseCustomOpDomain)(struct OrtCustomOpDomain*);
 *     struct OrtStatus* (*GetDenotationFromTypeInfo)(struct OrtTypeInfo*,char**,unsigned long*);
 *     struct OrtStatus* (*CastTypeInfoToMapTypeInfo)(struct OrtTypeInfo*,struct OrtMapTypeInfo**);
 *     struct OrtStatus* (*CastTypeInfoToSequenceTypeInfo)(struct OrtTypeInfo*,struct OrtSequenceTypeInfo**);
 *     struct OrtStatus* (*GetMapKeyType)(struct OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
 *     struct OrtStatus* (*GetMapValueType)(struct OrtMapTypeInfo*,struct OrtTypeInfo**);
 *     struct OrtStatus* (*GetSequenceElementType)(struct OrtSequenceTypeInfo*,struct OrtTypeInfo**);
 *     void (*ReleaseMapTypeInfo)(struct OrtMapTypeInfo*);
 *     void (*ReleaseSequenceTypeInfo)(struct OrtSequenceTypeInfo*);
 *     struct OrtStatus* (*SessionEndProfiling)(struct OrtSession*,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*SessionGetModelMetadata)(struct OrtSession*,struct OrtModelMetadata**);
 *     struct OrtStatus* (*ModelMetadataGetProducerName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*ModelMetadataGetGraphName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*ModelMetadataGetDomain)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*ModelMetadataGetDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*ModelMetadataLookupCustomMetadataMap)(struct OrtModelMetadata*,struct OrtAllocator*,char*,char**);
 *     struct OrtStatus* (*ModelMetadataGetVersion)(struct OrtModelMetadata*,long long*);
 *     void (*ReleaseModelMetadata)(struct OrtModelMetadata*);
 *     struct OrtStatus* (*CreateEnvWithGlobalThreadPools)(enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
 *     struct OrtStatus* (*DisablePerSessionThreads)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*CreateThreadingOptions)(struct OrtThreadingOptions**);
 *     void (*ReleaseThreadingOptions)(struct OrtThreadingOptions*);
 *     struct OrtStatus* (*ModelMetadataGetCustomMetadataMapKeys)(struct OrtModelMetadata*,struct OrtAllocator*,char***,long long*);
 *     struct OrtStatus* (*AddFreeDimensionOverrideByName)(struct OrtSessionOptions*,char*,long long);
 *     struct OrtStatus* (*GetAvailableProviders)(char***,int*);
 *     struct OrtStatus* (*ReleaseAvailableProviders)(char**,int);
 *     struct OrtStatus* (*GetStringTensorElementLength)(struct OrtValue*,unsigned long,unsigned long*);
 *     struct OrtStatus* (*GetStringTensorElement)(struct OrtValue*,unsigned long,unsigned long,void*);
 *     struct OrtStatus* (*FillStringTensorElement)(struct OrtValue*,char*,unsigned long);
 *     struct OrtStatus* (*AddSessionConfigEntry)(struct OrtSessionOptions*,char*,char*);
 *     struct OrtStatus* (*CreateAllocator)(struct OrtSession*,struct OrtMemoryInfo*,struct OrtAllocator**);
 *     void (*ReleaseAllocator)(struct OrtAllocator*);
 *     struct OrtStatus* (*RunWithBinding)(struct OrtSession*,struct OrtRunOptions*,struct OrtIoBinding*);
 *     struct OrtStatus* (*CreateIoBinding)(struct OrtSession*,struct OrtIoBinding**);
 *     void (*ReleaseIoBinding)(struct OrtIoBinding*);
 *     struct OrtStatus* (*BindInput)(struct OrtIoBinding*,char*,struct OrtValue*);
 *     struct OrtStatus* (*BindOutput)(struct OrtIoBinding*,char*,struct OrtValue*);
 *     struct OrtStatus* (*BindOutputToDevice)(struct OrtIoBinding*,char*,struct OrtMemoryInfo*);
 *     struct OrtStatus* (*GetBoundOutputNames)(struct OrtIoBinding*,struct OrtAllocator*,char**,unsigned long**,unsigned long*);
 *     struct OrtStatus* (*GetBoundOutputValues)(struct OrtIoBinding*,struct OrtAllocator*,struct OrtValue***,unsigned long*);
 *     void (*ClearBoundInputs)(struct OrtIoBinding*);
 *     void (*ClearBoundOutputs)(struct OrtIoBinding*);
 *     struct OrtStatus* (*TensorAt)(struct OrtValue*,long long*,unsigned long,void**);
 *     struct OrtStatus* (*CreateAndRegisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*,struct OrtArenaCfg*);
 *     struct OrtStatus* (*SetLanguageProjection)(struct OrtEnv*,enum OrtLanguageProjection);
 *     struct OrtStatus* (*SessionGetProfilingStartTimeNs)(struct OrtSession*,unsigned long long*);
 *     struct OrtStatus* (*SetGlobalIntraOpNumThreads)(struct OrtThreadingOptions*,int);
 *     struct OrtStatus* (*SetGlobalInterOpNumThreads)(struct OrtThreadingOptions*,int);
 *     struct OrtStatus* (*SetGlobalSpinControl)(struct OrtThreadingOptions*,int);
 *     struct OrtStatus* (*AddInitializer)(struct OrtSessionOptions*,char*,struct OrtValue*);
 *     struct OrtStatus* (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA)(struct OrtSessionOptions*,struct OrtCUDAProviderOptions*);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_ROCM)(struct OrtSessionOptions*,struct OrtROCMProviderOptions*);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_OpenVINO)(struct OrtSessionOptions*,struct OrtOpenVINOProviderOptions*);
 *     struct OrtStatus* (*SetGlobalDenormalAsZero)(struct OrtThreadingOptions*);
 *     struct OrtStatus* (*CreateArenaCfg)(unsigned long,int,int,int,struct OrtArenaCfg**);
 *     void (*ReleaseArenaCfg)(struct OrtArenaCfg*);
 *     struct OrtStatus* (*ModelMetadataGetGraphDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptions*);
 *     struct OrtStatus* (*SetCurrentGpuDeviceId)(int);
 *     struct OrtStatus* (*GetCurrentGpuDeviceId)(int*);
 *     struct OrtStatus* (*KernelInfoGetAttributeArray_float)(struct OrtKernelInfo*,char*,float*,unsigned long*);
 *     struct OrtStatus* (*KernelInfoGetAttributeArray_int64)(struct OrtKernelInfo*,char*,long long*,unsigned long*);
 *     struct OrtStatus* (*CreateArenaCfgV2)(char**,unsigned long*,unsigned long,struct OrtArenaCfg**);
 *     struct OrtStatus* (*AddRunConfigEntry)(struct OrtRunOptions*,char*,char*);
 *     struct OrtStatus* (*CreatePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer**);
 *     void (*ReleasePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer*);
 *     struct OrtStatus* (*CreateSessionWithPrepackedWeightsContainer)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
 *     struct OrtStatus* (*CreateSessionFromArrayWithPrepackedWeightsContainer)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptionsV2*);
 *     struct OrtStatus* (*CreateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2**);
 *     struct OrtStatus* (*UpdateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*,char**,char**,unsigned long);
 *     struct OrtStatus* (*GetTensorRTProviderOptionsAsString)(struct OrtTensorRTProviderOptionsV2*,struct OrtAllocator*,char**);
 *     void (*ReleaseTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*);
 *     struct OrtStatus* (*EnableOrtCustomOps)(struct OrtSessionOptions*);
 *     struct OrtStatus* (*RegisterAllocator)(struct OrtEnv*,struct OrtAllocator*);
 *     struct OrtStatus* (*UnregisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*);
 *     struct OrtStatus* (*IsSparseTensor)(struct OrtValue*,int*);
 *     struct OrtStatus* (*CreateSparseTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
 *     struct OrtStatus* (*FillSparseTensorCoo)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long);
 *     struct OrtStatus* (*FillSparseTensorCsr)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,long long*,unsigned long);
 *     struct OrtStatus* (*FillSparseTensorBlockSparse)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,int*);
 *     struct OrtStatus* (*CreateSparseTensorWithValuesAsOrtValue)(struct OrtMemoryInfo*,void*,long long*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
 *     struct OrtStatus* (*UseCooIndices)(struct OrtValue*,long long*,unsigned long);
 *     struct OrtStatus* (*UseCsrIndices)(struct OrtValue*,long long*,unsigned long,long long*,unsigned long);
 *     struct OrtStatus* (*UseBlockSparseIndices)(struct OrtValue*,long long*,unsigned long,int*);
 *     struct OrtStatus* (*GetSparseTensorFormat)(struct OrtValue*,enum OrtSparseFormat*);
 *     struct OrtStatus* (*GetSparseTensorValuesTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
 *     struct OrtStatus* (*GetSparseTensorValues)(struct OrtValue*,void**);
 *     struct OrtStatus* (*GetSparseTensorIndicesTypeShape)(struct OrtValue*,enum OrtSparseIndicesFormat,struct OrtTensorTypeAndShapeInfo**);
 *     struct OrtStatus* (*GetSparseTensorIndices)(struct OrtValue*,enum OrtSparseIndicesFormat,unsigned long*,void**);
 *     struct OrtStatus* (*HasValue)(struct OrtValue*,int*);
 *     struct OrtStatus* (*KernelContext_GetGPUComputeStream)(struct OrtKernelContext*,void**);
 *     struct OrtStatus* (*GetTensorMemoryInfo)(struct OrtValue*,struct OrtMemoryInfo**);
 *     struct OrtStatus* (*GetExecutionProviderApi)(char*,unsigned int,void**);
 *     struct OrtStatus* (*SessionOptionsSetCustomCreateThreadFn)(struct OrtSessionOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
 *     struct OrtStatus* (*SessionOptionsSetCustomThreadCreationOptions)(struct OrtSessionOptions*,void*);
 *     struct OrtStatus* (*SessionOptionsSetCustomJoinThreadFn)(struct OrtSessionOptions*,void (*)(struct OrtCustomHandleType*));
 *     struct OrtStatus* (*SetGlobalCustomCreateThreadFn)(struct OrtThreadingOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
 *     struct OrtStatus* (*SetGlobalCustomThreadCreationOptions)(struct OrtThreadingOptions*,void*);
 *     struct OrtStatus* (*SetGlobalCustomJoinThreadFn)(struct OrtThreadingOptions*,void (*)(struct OrtCustomHandleType*));
 *     struct OrtStatus* (*SynchronizeBoundInputs)(struct OrtIoBinding*);
 *     struct OrtStatus* (*SynchronizeBoundOutputs)(struct OrtIoBinding*);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA_V2)(struct OrtSessionOptions*,struct OrtCUDAProviderOptionsV2*);
 *     struct OrtStatus* (*CreateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2**);
 *     struct OrtStatus* (*UpdateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*,char**,char**,unsigned long);
 *     struct OrtStatus* (*GetCUDAProviderOptionsAsString)(struct OrtCUDAProviderOptionsV2*,struct OrtAllocator*,char**);
 *     void (*ReleaseCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_MIGraphX)(struct OrtSessionOptions*,struct OrtMIGraphXProviderOptions*);
 *     struct OrtStatus* (*AddExternalInitializers)(struct OrtSessionOptions*,char**,struct OrtValue**,unsigned long);
 *     struct OrtStatus* (*CreateOpAttr)(char*,void*,int,enum OrtOpAttrType,struct OrtOpAttr**);
 *     void (*ReleaseOpAttr)(struct OrtOpAttr*);
 *     struct OrtStatus* (*CreateOp)(struct OrtKernelInfo*,char*,char*,int,char**,enum ONNXTensorElementDataType*,int,struct OrtOpAttr**,int,int,int,struct OrtOp**);
 *     struct OrtStatus* (*InvokeOp)(struct OrtKernelContext*,struct OrtOp*,struct OrtValue**,int,struct OrtValue**,int);
 *     void (*ReleaseOp)(struct OrtOp*);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider)(struct OrtSessionOptions*,char*,char**,char**,unsigned long);
 *     struct OrtStatus* (*CopyKernelInfo)(struct OrtKernelInfo*,struct OrtKernelInfo**);
 *     void (*ReleaseKernelInfo)(struct OrtKernelInfo*);
 *     struct OrtTrainingApi* (*GetTrainingApi)(unsigned int);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CANN)(struct OrtSessionOptions*,struct OrtCANNProviderOptions*);
 *     struct OrtStatus* (*CreateCANNProviderOptions)(struct OrtCANNProviderOptions**);
 *     struct OrtStatus* (*UpdateCANNProviderOptions)(struct OrtCANNProviderOptions*,char**,char**,unsigned long);
 *     struct OrtStatus* (*GetCANNProviderOptionsAsString)(struct OrtCANNProviderOptions*,struct OrtAllocator*,char**);
 *     void (*ReleaseCANNProviderOptions)(struct OrtCANNProviderOptions*);
 *     void (*MemoryInfoGetDeviceType)(struct OrtMemoryInfo*,enum OrtMemoryInfoDeviceType*);
 *     struct OrtStatus* (*UpdateEnvWithCustomLogLevel)(struct OrtEnv*,enum OrtLoggingLevel);
 *     struct OrtStatus* (*SetGlobalIntraOpThreadAffinity)(struct OrtThreadingOptions*,char*);
 *     struct OrtStatus* (*RegisterCustomOpsLibrary_V2)(struct OrtSessionOptions*,char*);
 *     struct OrtStatus* (*RegisterCustomOpsUsingFunction)(struct OrtSessionOptions*,char*);
 *     struct OrtStatus* (*KernelInfo_GetInputCount)(struct OrtKernelInfo*,unsigned long*);
 *     struct OrtStatus* (*KernelInfo_GetOutputCount)(struct OrtKernelInfo*,unsigned long*);
 *     struct OrtStatus* (*KernelInfo_GetInputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
 *     struct OrtStatus* (*KernelInfo_GetOutputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
 *     struct OrtStatus* (*KernelInfo_GetInputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
 *     struct OrtStatus* (*KernelInfo_GetOutputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
 *     struct OrtStatus* (*KernelInfoGetAttribute_tensor)(struct OrtKernelInfo*,char*,struct OrtAllocator*,struct OrtValue**);
 *     struct OrtStatus* (*HasSessionConfigEntry)(struct OrtSessionOptions*,char*,int*);
 *     struct OrtStatus* (*GetSessionConfigEntry)(struct OrtSessionOptions*,char*,char*,unsigned long*);
 *     struct OrtStatus* (*SessionOptionsAppendExecutionProvider_Dnnl)(struct OrtSessionOptions*,struct OrtDnnlProviderOptions*);
 *     struct OrtStatus* (*CreateDnnlProviderOptions)(struct OrtDnnlProviderOptions**);
 *     struct OrtStatus* (*UpdateDnnlProviderOptions)(struct OrtDnnlProviderOptions*,char**,char**,unsigned long);
 *     struct OrtStatus* (*GetDnnlProviderOptionsAsString)(struct OrtDnnlProviderOptions*,struct OrtAllocator*,char**);
 *     void (*ReleaseDnnlProviderOptions)(struct OrtDnnlProviderOptions*);
 *     struct OrtStatus* (*KernelInfo_GetNodeName)(struct OrtKernelInfo*,char*,unsigned long*);
 *     struct OrtStatus* (*KernelInfo_GetLogger)(struct OrtKernelInfo*,struct OrtLogger**);
 *     struct OrtStatus* (*KernelContext_GetLogger)(struct OrtKernelContext*,struct OrtLogger**);
 *     struct OrtStatus* (*Logger_LogMessage)(struct OrtLogger*,enum OrtLoggingLevel,char*,char*,int,char*);
 *     struct OrtStatus* (*Logger_GetLoggingSeverityLevel)(struct OrtLogger*,enum OrtLoggingLevel*);
 *     struct OrtStatus* (*KernelInfoGetConstantInput_tensor)(struct OrtKernelInfo*,unsigned long,int*,struct OrtValue**);
 *     struct OrtStatus* (*CastTypeInfoToOptionalTypeInfo)(struct OrtTypeInfo*,struct OrtOptionalTypeInfo**);
 *     struct OrtStatus* (*GetOptionalContainedTypeInfo)(struct OrtOptionalTypeInfo*,struct OrtTypeInfo**);
 *     struct OrtStatus* (*GetResizedStringTensorElementBuffer)(struct OrtValue*,unsigned long,unsigned long,char**);
 *     struct OrtStatus* (*KernelContext_GetAllocator)(struct OrtKernelContext*,struct OrtMemoryInfo*,struct OrtAllocator**);
 *     char* (*GetBuildInfoString)();
 *     struct OrtStatus* (*CreateROCMProviderOptions)(struct OrtROCMProviderOptions**);
 *     struct OrtStatus* (*UpdateROCMProviderOptions)(struct OrtROCMProviderOptions*,char**,char**,unsigned long);
 *     struct OrtStatus* (*GetROCMProviderOptionsAsString)(struct OrtROCMProviderOptions*,struct OrtAllocator*,char**);
 *     void (*ReleaseROCMProviderOptions)(struct OrtROCMProviderOptions*);
 *     struct OrtStatus* (*CreateAndRegisterAllocatorV2)(struct OrtEnv*,char*,struct OrtMemoryInfo*,struct OrtArenaCfg*,char**,char**,unsigned long);
 *     struct OrtStatus* (*RunAsync)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**,void (*)(void*,struct OrtValue**,unsigned long,struct OrtStatus*),void*);
 *     struct OrtStatus* (*UpdateTensorRTProviderOptionsWithValue)(struct OrtTensorRTProviderOptionsV2*,char*,void*);
 *     struct OrtStatus* (*GetTensorRTProviderOptionsByName)(struct OrtTensorRTProviderOptionsV2*,char*,void**);
 *     struct OrtStatus* (*UpdateCUDAProviderOptionsWithValue)(struct OrtCUDAProviderOptionsV2*,char*,void*);
 *     struct OrtStatus* (*GetCUDAProviderOptionsByName)(struct OrtCUDAProviderOptionsV2*,char*,void**);
 *     struct OrtStatus* (*KernelContext_GetResource)(struct OrtKernelContext*,int,int,void**);
 * };
 * }
 */
public class OrtApi {

    public static MemoryLayout $LAYOUT() {
        return constants$16.const$2;
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateStatus)(enum OrtErrorCode,char*);
     * }
     */
    public interface CreateStatus {

        java.lang.foreign.MemorySegment apply(int _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateStatus fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$16.const$4, fi, constants$16.const$3, scope);
        }

        static CreateStatus ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateStatus$VH() {
        return constants$17.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateStatus)(enum OrtErrorCode,char*);
     * }
     */
    public static MemorySegment CreateStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$17.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateStatus)(enum OrtErrorCode,char*);
     * }
     */
    public static void CreateStatus$set(MemorySegment seg, MemorySegment x) {
        constants$17.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$17.const$0.get(seg, index * sizeof());
    }

    public static void CreateStatus$set(MemorySegment seg, long index, MemorySegment x) {
        constants$17.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateStatus CreateStatus(MemorySegment segment, Arena scope) {
        return CreateStatus.ofAddress(CreateStatus$get(segment), scope);
    }
    /**
     * {@snippet :
     * enum OrtErrorCode (*GetErrorCode)(struct OrtStatus*);
     * }
     */
    public interface GetErrorCode {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetErrorCode fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$17.const$2, fi, constants$17.const$1, scope);
        }

        static GetErrorCode ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) constants$17.const$3.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetErrorCode$VH() {
        return constants$17.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * enum OrtErrorCode (*GetErrorCode)(struct OrtStatus*);
     * }
     */
    public static MemorySegment GetErrorCode$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$17.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * enum OrtErrorCode (*GetErrorCode)(struct OrtStatus*);
     * }
     */
    public static void GetErrorCode$set(MemorySegment seg, MemorySegment x) {
        constants$17.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetErrorCode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$17.const$4.get(seg, index * sizeof());
    }

    public static void GetErrorCode$set(MemorySegment seg, long index, MemorySegment x) {
        constants$17.const$4.set(seg, index * sizeof(), x);
    }

    public static GetErrorCode GetErrorCode(MemorySegment segment, Arena scope) {
        return GetErrorCode.ofAddress(GetErrorCode$get(segment), scope);
    }
    /**
     * {@snippet :
     * char* (*GetErrorMessage)(struct OrtStatus*);
     * }
     */
    public interface GetErrorMessage {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetErrorMessage fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$17.const$5, fi, constants$1.const$4, scope);
        }

        static GetErrorMessage ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetErrorMessage$VH() {
        return constants$18.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetErrorMessage)(struct OrtStatus*);
     * }
     */
    public static MemorySegment GetErrorMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$18.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetErrorMessage)(struct OrtStatus*);
     * }
     */
    public static void GetErrorMessage$set(MemorySegment seg, MemorySegment x) {
        constants$18.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetErrorMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$18.const$0.get(seg, index * sizeof());
    }

    public static void GetErrorMessage$set(MemorySegment seg, long index, MemorySegment x) {
        constants$18.const$0.set(seg, index * sizeof(), x);
    }

    public static GetErrorMessage GetErrorMessage(MemorySegment segment, Arena scope) {
        return GetErrorMessage.ofAddress(GetErrorMessage$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateEnv)(enum OrtLoggingLevel,char*,struct OrtEnv**);
     * }
     */
    public interface CreateEnv {

        java.lang.foreign.MemorySegment apply(
                int _x0, java.lang.foreign.MemorySegment _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateEnv fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$18.const$2, fi, constants$18.const$1, scope);
        }

        static CreateEnv ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0, java.lang.foreign.MemorySegment __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$18.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnv$VH() {
        return constants$18.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnv)(enum OrtLoggingLevel,char*,struct OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$18.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnv)(enum OrtLoggingLevel,char*,struct OrtEnv**);
     * }
     */
    public static void CreateEnv$set(MemorySegment seg, MemorySegment x) {
        constants$18.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$18.const$4.get(seg, index * sizeof());
    }

    public static void CreateEnv$set(MemorySegment seg, long index, MemorySegment x) {
        constants$18.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateEnv CreateEnv(MemorySegment segment, Arena scope) {
        return CreateEnv.ofAddress(CreateEnv$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithCustomLogger)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtEnv**);
     * }
     */
    public interface CreateEnvWithCustomLogger {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                int _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateEnvWithCustomLogger fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$19.const$0, fi, constants$18.const$5, scope);
        }

        static CreateEnvWithCustomLogger ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$19.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnvWithCustomLogger$VH() {
        return constants$19.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithCustomLogger)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithCustomLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$19.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithCustomLogger)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtEnv**);
     * }
     */
    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, MemorySegment x) {
        constants$19.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnvWithCustomLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$19.const$2.get(seg, index * sizeof());
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, long index, MemorySegment x) {
        constants$19.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateEnvWithCustomLogger CreateEnvWithCustomLogger(MemorySegment segment, Arena scope) {
        return CreateEnvWithCustomLogger.ofAddress(CreateEnvWithCustomLogger$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*EnableTelemetryEvents)(struct OrtEnv*);
     * }
     */
    public interface EnableTelemetryEvents {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableTelemetryEvents fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$19.const$3, fi, constants$1.const$4, scope);
        }

        static EnableTelemetryEvents ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle EnableTelemetryEvents$VH() {
        return constants$19.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableTelemetryEvents)(struct OrtEnv*);
     * }
     */
    public static MemorySegment EnableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$19.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableTelemetryEvents)(struct OrtEnv*);
     * }
     */
    public static void EnableTelemetryEvents$set(MemorySegment seg, MemorySegment x) {
        constants$19.const$4.set(seg, 0L, x);
    }

    public static MemorySegment EnableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$19.const$4.get(seg, index * sizeof());
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, long index, MemorySegment x) {
        constants$19.const$4.set(seg, index * sizeof(), x);
    }

    public static EnableTelemetryEvents EnableTelemetryEvents(MemorySegment segment, Arena scope) {
        return EnableTelemetryEvents.ofAddress(EnableTelemetryEvents$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*DisableTelemetryEvents)(struct OrtEnv*);
     * }
     */
    public interface DisableTelemetryEvents {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableTelemetryEvents fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$19.const$5, fi, constants$1.const$4, scope);
        }

        static DisableTelemetryEvents ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle DisableTelemetryEvents$VH() {
        return constants$20.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableTelemetryEvents)(struct OrtEnv*);
     * }
     */
    public static MemorySegment DisableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$20.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableTelemetryEvents)(struct OrtEnv*);
     * }
     */
    public static void DisableTelemetryEvents$set(MemorySegment seg, MemorySegment x) {
        constants$20.const$0.set(seg, 0L, x);
    }

    public static MemorySegment DisableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$20.const$0.get(seg, index * sizeof());
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, long index, MemorySegment x) {
        constants$20.const$0.set(seg, index * sizeof(), x);
    }

    public static DisableTelemetryEvents DisableTelemetryEvents(MemorySegment segment, Arena scope) {
        return DisableTelemetryEvents.ofAddress(DisableTelemetryEvents$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSession)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtSession**);
     * }
     */
    public interface CreateSession {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateSession fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$20.const$2, fi, constants$20.const$1, scope);
        }

        static CreateSession ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSession$VH() {
        return constants$20.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSession)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtSession**);
     * }
     */
    public static MemorySegment CreateSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$20.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSession)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtSession**);
     * }
     */
    public static void CreateSession$set(MemorySegment seg, MemorySegment x) {
        constants$20.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$20.const$4.get(seg, index * sizeof());
    }

    public static void CreateSession$set(MemorySegment seg, long index, MemorySegment x) {
        constants$20.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateSession CreateSession(MemorySegment segment, Arena scope) {
        return CreateSession.ofAddress(CreateSession$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSessionFromArray)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtSession**);
     * }
     */
    public interface CreateSessionFromArray {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateSessionFromArray fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$21.const$0, fi, constants$20.const$5, scope);
        }

        static CreateSessionFromArray ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$21.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionFromArray$VH() {
        return constants$21.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionFromArray)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionFromArray$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$21.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionFromArray)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtSession**);
     * }
     */
    public static void CreateSessionFromArray$set(MemorySegment seg, MemorySegment x) {
        constants$21.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionFromArray$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$21.const$2.get(seg, index * sizeof());
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, long index, MemorySegment x) {
        constants$21.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateSessionFromArray CreateSessionFromArray(MemorySegment segment, Arena scope) {
        return CreateSessionFromArray.ofAddress(CreateSessionFromArray$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*Run)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**);
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

        static MemorySegment allocate(Run fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$21.const$4, fi, constants$21.const$3, scope);
        }

        static Run ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
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
                            constants$21.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Run$VH() {
        return constants$22.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*Run)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**);
     * }
     */
    public static MemorySegment Run$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$22.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*Run)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**);
     * }
     */
    public static void Run$set(MemorySegment seg, MemorySegment x) {
        constants$22.const$0.set(seg, 0L, x);
    }

    public static MemorySegment Run$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$22.const$0.get(seg, index * sizeof());
    }

    public static void Run$set(MemorySegment seg, long index, MemorySegment x) {
        constants$22.const$0.set(seg, index * sizeof(), x);
    }

    public static Run Run(MemorySegment segment, Arena scope) {
        return Run.ofAddress(Run$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSessionOptions)(struct OrtSessionOptions**);
     * }
     */
    public interface CreateSessionOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateSessionOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$22.const$1, fi, constants$1.const$4, scope);
        }

        static CreateSessionOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionOptions$VH() {
        return constants$22.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionOptions)(struct OrtSessionOptions**);
     * }
     */
    public static MemorySegment CreateSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$22.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionOptions)(struct OrtSessionOptions**);
     * }
     */
    public static void CreateSessionOptions$set(MemorySegment seg, MemorySegment x) {
        constants$22.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$22.const$2.get(seg, index * sizeof());
    }

    public static void CreateSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$22.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateSessionOptions CreateSessionOptions(MemorySegment segment, Arena scope) {
        return CreateSessionOptions.ofAddress(CreateSessionOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetOptimizedModelFilePath)(struct OrtSessionOptions*,char*);
     * }
     */
    public interface SetOptimizedModelFilePath {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SetOptimizedModelFilePath fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$22.const$3, fi, constants$15.const$2, scope);
        }

        static SetOptimizedModelFilePath ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetOptimizedModelFilePath$VH() {
        return constants$22.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetOptimizedModelFilePath)(struct OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment SetOptimizedModelFilePath$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$22.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetOptimizedModelFilePath)(struct OrtSessionOptions*,char*);
     * }
     */
    public static void SetOptimizedModelFilePath$set(MemorySegment seg, MemorySegment x) {
        constants$22.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetOptimizedModelFilePath$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$22.const$4.get(seg, index * sizeof());
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, long index, MemorySegment x) {
        constants$22.const$4.set(seg, index * sizeof(), x);
    }

    public static SetOptimizedModelFilePath SetOptimizedModelFilePath(MemorySegment segment, Arena scope) {
        return SetOptimizedModelFilePath.ofAddress(SetOptimizedModelFilePath$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CloneSessionOptions)(struct OrtSessionOptions*,struct OrtSessionOptions**);
     * }
     */
    public interface CloneSessionOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CloneSessionOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$22.const$5, fi, constants$15.const$2, scope);
        }

        static CloneSessionOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CloneSessionOptions$VH() {
        return constants$23.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CloneSessionOptions)(struct OrtSessionOptions*,struct OrtSessionOptions**);
     * }
     */
    public static MemorySegment CloneSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$23.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CloneSessionOptions)(struct OrtSessionOptions*,struct OrtSessionOptions**);
     * }
     */
    public static void CloneSessionOptions$set(MemorySegment seg, MemorySegment x) {
        constants$23.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CloneSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$23.const$0.get(seg, index * sizeof());
    }

    public static void CloneSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$23.const$0.set(seg, index * sizeof(), x);
    }

    public static CloneSessionOptions CloneSessionOptions(MemorySegment segment, Arena scope) {
        return CloneSessionOptions.ofAddress(CloneSessionOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetSessionExecutionMode)(struct OrtSessionOptions*,enum ExecutionMode);
     * }
     */
    public interface SetSessionExecutionMode {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionExecutionMode fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$23.const$2, fi, constants$23.const$1, scope);
        }

        static SetSessionExecutionMode ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionExecutionMode$VH() {
        return constants$23.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionExecutionMode)(struct OrtSessionOptions*,enum ExecutionMode);
     * }
     */
    public static MemorySegment SetSessionExecutionMode$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$23.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionExecutionMode)(struct OrtSessionOptions*,enum ExecutionMode);
     * }
     */
    public static void SetSessionExecutionMode$set(MemorySegment seg, MemorySegment x) {
        constants$23.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionExecutionMode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$23.const$4.get(seg, index * sizeof());
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, long index, MemorySegment x) {
        constants$23.const$4.set(seg, index * sizeof(), x);
    }

    public static SetSessionExecutionMode SetSessionExecutionMode(MemorySegment segment, Arena scope) {
        return SetSessionExecutionMode.ofAddress(SetSessionExecutionMode$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*EnableProfiling)(struct OrtSessionOptions*,char*);
     * }
     */
    public interface EnableProfiling {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(EnableProfiling fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$23.const$5, fi, constants$15.const$2, scope);
        }

        static EnableProfiling ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle EnableProfiling$VH() {
        return constants$24.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableProfiling)(struct OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment EnableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$24.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableProfiling)(struct OrtSessionOptions*,char*);
     * }
     */
    public static void EnableProfiling$set(MemorySegment seg, MemorySegment x) {
        constants$24.const$0.set(seg, 0L, x);
    }

    public static MemorySegment EnableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$24.const$0.get(seg, index * sizeof());
    }

    public static void EnableProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        constants$24.const$0.set(seg, index * sizeof(), x);
    }

    public static EnableProfiling EnableProfiling(MemorySegment segment, Arena scope) {
        return EnableProfiling.ofAddress(EnableProfiling$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*DisableProfiling)(struct OrtSessionOptions*);
     * }
     */
    public interface DisableProfiling {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableProfiling fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$24.const$1, fi, constants$1.const$4, scope);
        }

        static DisableProfiling ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle DisableProfiling$VH() {
        return constants$24.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableProfiling)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$24.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableProfiling)(struct OrtSessionOptions*);
     * }
     */
    public static void DisableProfiling$set(MemorySegment seg, MemorySegment x) {
        constants$24.const$2.set(seg, 0L, x);
    }

    public static MemorySegment DisableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$24.const$2.get(seg, index * sizeof());
    }

    public static void DisableProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        constants$24.const$2.set(seg, index * sizeof(), x);
    }

    public static DisableProfiling DisableProfiling(MemorySegment segment, Arena scope) {
        return DisableProfiling.ofAddress(DisableProfiling$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*EnableMemPattern)(struct OrtSessionOptions*);
     * }
     */
    public interface EnableMemPattern {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableMemPattern fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$24.const$3, fi, constants$1.const$4, scope);
        }

        static EnableMemPattern ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle EnableMemPattern$VH() {
        return constants$24.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableMemPattern)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$24.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableMemPattern)(struct OrtSessionOptions*);
     * }
     */
    public static void EnableMemPattern$set(MemorySegment seg, MemorySegment x) {
        constants$24.const$4.set(seg, 0L, x);
    }

    public static MemorySegment EnableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$24.const$4.get(seg, index * sizeof());
    }

    public static void EnableMemPattern$set(MemorySegment seg, long index, MemorySegment x) {
        constants$24.const$4.set(seg, index * sizeof(), x);
    }

    public static EnableMemPattern EnableMemPattern(MemorySegment segment, Arena scope) {
        return EnableMemPattern.ofAddress(EnableMemPattern$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*DisableMemPattern)(struct OrtSessionOptions*);
     * }
     */
    public interface DisableMemPattern {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableMemPattern fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$24.const$5, fi, constants$1.const$4, scope);
        }

        static DisableMemPattern ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle DisableMemPattern$VH() {
        return constants$25.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableMemPattern)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$25.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableMemPattern)(struct OrtSessionOptions*);
     * }
     */
    public static void DisableMemPattern$set(MemorySegment seg, MemorySegment x) {
        constants$25.const$0.set(seg, 0L, x);
    }

    public static MemorySegment DisableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$25.const$0.get(seg, index * sizeof());
    }

    public static void DisableMemPattern$set(MemorySegment seg, long index, MemorySegment x) {
        constants$25.const$0.set(seg, index * sizeof(), x);
    }

    public static DisableMemPattern DisableMemPattern(MemorySegment segment, Arena scope) {
        return DisableMemPattern.ofAddress(DisableMemPattern$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*EnableCpuMemArena)(struct OrtSessionOptions*);
     * }
     */
    public interface EnableCpuMemArena {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableCpuMemArena fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$25.const$1, fi, constants$1.const$4, scope);
        }

        static EnableCpuMemArena ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle EnableCpuMemArena$VH() {
        return constants$25.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableCpuMemArena)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$25.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableCpuMemArena)(struct OrtSessionOptions*);
     * }
     */
    public static void EnableCpuMemArena$set(MemorySegment seg, MemorySegment x) {
        constants$25.const$2.set(seg, 0L, x);
    }

    public static MemorySegment EnableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$25.const$2.get(seg, index * sizeof());
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, long index, MemorySegment x) {
        constants$25.const$2.set(seg, index * sizeof(), x);
    }

    public static EnableCpuMemArena EnableCpuMemArena(MemorySegment segment, Arena scope) {
        return EnableCpuMemArena.ofAddress(EnableCpuMemArena$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*DisableCpuMemArena)(struct OrtSessionOptions*);
     * }
     */
    public interface DisableCpuMemArena {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableCpuMemArena fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$25.const$3, fi, constants$1.const$4, scope);
        }

        static DisableCpuMemArena ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle DisableCpuMemArena$VH() {
        return constants$25.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableCpuMemArena)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$25.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*DisableCpuMemArena)(struct OrtSessionOptions*);
     * }
     */
    public static void DisableCpuMemArena$set(MemorySegment seg, MemorySegment x) {
        constants$25.const$4.set(seg, 0L, x);
    }

    public static MemorySegment DisableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$25.const$4.get(seg, index * sizeof());
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, long index, MemorySegment x) {
        constants$25.const$4.set(seg, index * sizeof(), x);
    }

    public static DisableCpuMemArena DisableCpuMemArena(MemorySegment segment, Arena scope) {
        return DisableCpuMemArena.ofAddress(DisableCpuMemArena$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogId)(struct OrtSessionOptions*,char*);
     * }
     */
    public interface SetSessionLogId {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SetSessionLogId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$25.const$5, fi, constants$15.const$2, scope);
        }

        static SetSessionLogId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionLogId$VH() {
        return constants$26.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogId)(struct OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment SetSessionLogId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$26.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogId)(struct OrtSessionOptions*,char*);
     * }
     */
    public static void SetSessionLogId$set(MemorySegment seg, MemorySegment x) {
        constants$26.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionLogId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$26.const$0.get(seg, index * sizeof());
    }

    public static void SetSessionLogId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$26.const$0.set(seg, index * sizeof(), x);
    }

    public static SetSessionLogId SetSessionLogId(MemorySegment segment, Arena scope) {
        return SetSessionLogId.ofAddress(SetSessionLogId$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogVerbosityLevel)(struct OrtSessionOptions*,int);
     * }
     */
    public interface SetSessionLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionLogVerbosityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$26.const$1, fi, constants$23.const$1, scope);
        }

        static SetSessionLogVerbosityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionLogVerbosityLevel$VH() {
        return constants$26.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogVerbosityLevel)(struct OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetSessionLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$26.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogVerbosityLevel)(struct OrtSessionOptions*,int);
     * }
     */
    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$26.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$26.const$2.get(seg, index * sizeof());
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$26.const$2.set(seg, index * sizeof(), x);
    }

    public static SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel(MemorySegment segment, Arena scope) {
        return SetSessionLogVerbosityLevel.ofAddress(SetSessionLogVerbosityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogSeverityLevel)(struct OrtSessionOptions*,int);
     * }
     */
    public interface SetSessionLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionLogSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$26.const$3, fi, constants$23.const$1, scope);
        }

        static SetSessionLogSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionLogSeverityLevel$VH() {
        return constants$26.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogSeverityLevel)(struct OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetSessionLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$26.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionLogSeverityLevel)(struct OrtSessionOptions*,int);
     * }
     */
    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$26.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$26.const$4.get(seg, index * sizeof());
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$26.const$4.set(seg, index * sizeof(), x);
    }

    public static SetSessionLogSeverityLevel SetSessionLogSeverityLevel(MemorySegment segment, Arena scope) {
        return SetSessionLogSeverityLevel.ofAddress(SetSessionLogSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetSessionGraphOptimizationLevel)(struct OrtSessionOptions*,enum GraphOptimizationLevel);
     * }
     */
    public interface SetSessionGraphOptimizationLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionGraphOptimizationLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$26.const$5, fi, constants$23.const$1, scope);
        }

        static SetSessionGraphOptimizationLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionGraphOptimizationLevel$VH() {
        return constants$27.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionGraphOptimizationLevel)(struct OrtSessionOptions*,enum GraphOptimizationLevel);
     * }
     */
    public static MemorySegment SetSessionGraphOptimizationLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$27.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetSessionGraphOptimizationLevel)(struct OrtSessionOptions*,enum GraphOptimizationLevel);
     * }
     */
    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, MemorySegment x) {
        constants$27.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionGraphOptimizationLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$27.const$0.get(seg, index * sizeof());
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$27.const$0.set(seg, index * sizeof(), x);
    }

    public static SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel(
            MemorySegment segment, Arena scope) {
        return SetSessionGraphOptimizationLevel.ofAddress(SetSessionGraphOptimizationLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetIntraOpNumThreads)(struct OrtSessionOptions*,int);
     * }
     */
    public interface SetIntraOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetIntraOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$27.const$1, fi, constants$23.const$1, scope);
        }

        static SetIntraOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetIntraOpNumThreads$VH() {
        return constants$27.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetIntraOpNumThreads)(struct OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$27.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetIntraOpNumThreads)(struct OrtSessionOptions*,int);
     * }
     */
    public static void SetIntraOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$27.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$27.const$2.get(seg, index * sizeof());
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$27.const$2.set(seg, index * sizeof(), x);
    }

    public static SetIntraOpNumThreads SetIntraOpNumThreads(MemorySegment segment, Arena scope) {
        return SetIntraOpNumThreads.ofAddress(SetIntraOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetInterOpNumThreads)(struct OrtSessionOptions*,int);
     * }
     */
    public interface SetInterOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetInterOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$27.const$3, fi, constants$23.const$1, scope);
        }

        static SetInterOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetInterOpNumThreads$VH() {
        return constants$27.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetInterOpNumThreads)(struct OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$27.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetInterOpNumThreads)(struct OrtSessionOptions*,int);
     * }
     */
    public static void SetInterOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$27.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$27.const$4.get(seg, index * sizeof());
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$27.const$4.set(seg, index * sizeof(), x);
    }

    public static SetInterOpNumThreads SetInterOpNumThreads(MemorySegment segment, Arena scope) {
        return SetInterOpNumThreads.ofAddress(SetInterOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateCustomOpDomain)(char*,struct OrtCustomOpDomain**);
     * }
     */
    public interface CreateCustomOpDomain {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CreateCustomOpDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$27.const$5, fi, constants$15.const$2, scope);
        }

        static CreateCustomOpDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateCustomOpDomain$VH() {
        return constants$28.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCustomOpDomain)(char*,struct OrtCustomOpDomain**);
     * }
     */
    public static MemorySegment CreateCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$28.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCustomOpDomain)(char*,struct OrtCustomOpDomain**);
     * }
     */
    public static void CreateCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        constants$28.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$28.const$0.get(seg, index * sizeof());
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$28.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateCustomOpDomain CreateCustomOpDomain(MemorySegment segment, Arena scope) {
        return CreateCustomOpDomain.ofAddress(CreateCustomOpDomain$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CustomOpDomain_Add)(struct OrtCustomOpDomain*,struct OrtCustomOp*);
     * }
     */
    public interface CustomOpDomain_Add {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CustomOpDomain_Add fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$28.const$1, fi, constants$15.const$2, scope);
        }

        static CustomOpDomain_Add ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CustomOpDomain_Add$VH() {
        return constants$28.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CustomOpDomain_Add)(struct OrtCustomOpDomain*,struct OrtCustomOp*);
     * }
     */
    public static MemorySegment CustomOpDomain_Add$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$28.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CustomOpDomain_Add)(struct OrtCustomOpDomain*,struct OrtCustomOp*);
     * }
     */
    public static void CustomOpDomain_Add$set(MemorySegment seg, MemorySegment x) {
        constants$28.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CustomOpDomain_Add$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$28.const$2.get(seg, index * sizeof());
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, long index, MemorySegment x) {
        constants$28.const$2.set(seg, index * sizeof(), x);
    }

    public static CustomOpDomain_Add CustomOpDomain_Add(MemorySegment segment, Arena scope) {
        return CustomOpDomain_Add.ofAddress(CustomOpDomain_Add$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddCustomOpDomain)(struct OrtSessionOptions*,struct OrtCustomOpDomain*);
     * }
     */
    public interface AddCustomOpDomain {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(AddCustomOpDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$28.const$3, fi, constants$15.const$2, scope);
        }

        static AddCustomOpDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddCustomOpDomain$VH() {
        return constants$28.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddCustomOpDomain)(struct OrtSessionOptions*,struct OrtCustomOpDomain*);
     * }
     */
    public static MemorySegment AddCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$28.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddCustomOpDomain)(struct OrtSessionOptions*,struct OrtCustomOpDomain*);
     * }
     */
    public static void AddCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        constants$28.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AddCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$28.const$4.get(seg, index * sizeof());
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$28.const$4.set(seg, index * sizeof(), x);
    }

    public static AddCustomOpDomain AddCustomOpDomain(MemorySegment segment, Arena scope) {
        return AddCustomOpDomain.ofAddress(AddCustomOpDomain$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsLibrary)(struct OrtSessionOptions*,char*,void**);
     * }
     */
    public interface RegisterCustomOpsLibrary {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(RegisterCustomOpsLibrary fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$28.const$5, fi, constants$14.const$4, scope);
        }

        static RegisterCustomOpsLibrary ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterCustomOpsLibrary$VH() {
        return constants$29.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsLibrary)(struct OrtSessionOptions*,char*,void**);
     * }
     */
    public static MemorySegment RegisterCustomOpsLibrary$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$29.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsLibrary)(struct OrtSessionOptions*,char*,void**);
     * }
     */
    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, MemorySegment x) {
        constants$29.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RegisterCustomOpsLibrary$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$29.const$0.get(seg, index * sizeof());
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, long index, MemorySegment x) {
        constants$29.const$0.set(seg, index * sizeof(), x);
    }

    public static RegisterCustomOpsLibrary RegisterCustomOpsLibrary(MemorySegment segment, Arena scope) {
        return RegisterCustomOpsLibrary.ofAddress(RegisterCustomOpsLibrary$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public interface SessionGetInputCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionGetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$29.const$1, fi, constants$15.const$2, scope);
        }

        static SessionGetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetInputCount$VH() {
        return constants$29.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public static MemorySegment SessionGetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$29.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public static void SessionGetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$29.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$29.const$2.get(seg, index * sizeof());
    }

    public static void SessionGetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$29.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionGetInputCount SessionGetInputCount(MemorySegment segment, Arena scope) {
        return SessionGetInputCount.ofAddress(SessionGetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public interface SessionGetOutputCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionGetOutputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$29.const$3, fi, constants$15.const$2, scope);
        }

        static SessionGetOutputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOutputCount$VH() {
        return constants$29.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public static MemorySegment SessionGetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$29.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public static void SessionGetOutputCount$set(MemorySegment seg, MemorySegment x) {
        constants$29.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$29.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$29.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetOutputCount SessionGetOutputCount(MemorySegment segment, Arena scope) {
        return SessionGetOutputCount.ofAddress(SessionGetOutputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public interface SessionGetOverridableInitializerCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionGetOverridableInitializerCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$29.const$5, fi, constants$15.const$2, scope);
        }

        static SessionGetOverridableInitializerCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOverridableInitializerCount$VH() {
        return constants$30.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$30.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerCount)(struct OrtSession*,unsigned long*);
     * }
     */
    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, MemorySegment x) {
        constants$30.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOverridableInitializerCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$30.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$30.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount(
            MemorySegment segment, Arena scope) {
        return SessionGetOverridableInitializerCount.ofAddress(
                SessionGetOverridableInitializerCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public interface SessionGetInputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetInputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$30.const$2, fi, constants$30.const$1, scope);
        }

        static SessionGetInputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetInputTypeInfo$VH() {
        return constants$30.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$30.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static void SessionGetInputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$30.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$30.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$30.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetInputTypeInfo SessionGetInputTypeInfo(MemorySegment segment, Arena scope) {
        return SessionGetInputTypeInfo.ofAddress(SessionGetInputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public interface SessionGetOutputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetOutputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$30.const$5, fi, constants$30.const$1, scope);
        }

        static SessionGetOutputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOutputTypeInfo$VH() {
        return constants$31.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$31.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$31.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$31.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$31.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetOutputTypeInfo SessionGetOutputTypeInfo(MemorySegment segment, Arena scope) {
        return SessionGetOutputTypeInfo.ofAddress(SessionGetOutputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public interface SessionGetOverridableInitializerTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetOverridableInitializerTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$31.const$1, fi, constants$30.const$1, scope);
        }

        static SessionGetOverridableInitializerTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOverridableInitializerTypeInfo$VH() {
        return constants$31.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$31.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerTypeInfo)(struct OrtSession*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$31.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$31.const$2.get(seg, index * sizeof());
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$31.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo(
            MemorySegment segment, Arena scope) {
        return SessionGetOverridableInitializerTypeInfo.ofAddress(
                SessionGetOverridableInitializerTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public interface SessionGetInputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(SessionGetInputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$31.const$4, fi, constants$31.const$3, scope);
        }

        static SessionGetInputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$31.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetInputName$VH() {
        return constants$32.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$32.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetInputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public static void SessionGetInputName$set(MemorySegment seg, MemorySegment x) {
        constants$32.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$32.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetInputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$32.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetInputName SessionGetInputName(MemorySegment segment, Arena scope) {
        return SessionGetInputName.ofAddress(SessionGetInputName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public interface SessionGetOutputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(SessionGetOutputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$32.const$1, fi, constants$31.const$3, scope);
        }

        static SessionGetOutputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$31.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOutputName$VH() {
        return constants$32.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$32.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOutputName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public static void SessionGetOutputName$set(MemorySegment seg, MemorySegment x) {
        constants$32.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$32.const$2.get(seg, index * sizeof());
    }

    public static void SessionGetOutputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$32.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionGetOutputName SessionGetOutputName(MemorySegment segment, Arena scope) {
        return SessionGetOutputName.ofAddress(SessionGetOutputName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public interface SessionGetOverridableInitializerName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(SessionGetOverridableInitializerName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$32.const$3, fi, constants$31.const$3, scope);
        }

        static SessionGetOverridableInitializerName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$31.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOverridableInitializerName$VH() {
        return constants$32.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$32.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetOverridableInitializerName)(struct OrtSession*,unsigned long,struct OrtAllocator*,char**);
     * }
     */
    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, MemorySegment x) {
        constants$32.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOverridableInitializerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$32.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$32.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetOverridableInitializerName SessionGetOverridableInitializerName(
            MemorySegment segment, Arena scope) {
        return SessionGetOverridableInitializerName.ofAddress(SessionGetOverridableInitializerName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateRunOptions)(struct OrtRunOptions**);
     * }
     */
    public interface CreateRunOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateRunOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$32.const$5, fi, constants$1.const$4, scope);
        }

        static CreateRunOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateRunOptions$VH() {
        return constants$33.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateRunOptions)(struct OrtRunOptions**);
     * }
     */
    public static MemorySegment CreateRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$33.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateRunOptions)(struct OrtRunOptions**);
     * }
     */
    public static void CreateRunOptions$set(MemorySegment seg, MemorySegment x) {
        constants$33.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$33.const$0.get(seg, index * sizeof());
    }

    public static void CreateRunOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$33.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateRunOptions CreateRunOptions(MemorySegment segment, Arena scope) {
        return CreateRunOptions.ofAddress(CreateRunOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunLogVerbosityLevel)(struct OrtRunOptions*,int);
     * }
     */
    public interface RunOptionsSetRunLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogVerbosityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$33.const$1, fi, constants$23.const$1, scope);
        }

        static RunOptionsSetRunLogVerbosityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetRunLogVerbosityLevel$VH() {
        return constants$33.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunLogVerbosityLevel)(struct OrtRunOptions*,int);
     * }
     */
    public static MemorySegment RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$33.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunLogVerbosityLevel)(struct OrtRunOptions*,int);
     * }
     */
    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$33.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$33.const$2.get(seg, index * sizeof());
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$33.const$2.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsSetRunLogVerbosityLevel.ofAddress(RunOptionsSetRunLogVerbosityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunLogSeverityLevel)(struct OrtRunOptions*,int);
     * }
     */
    public interface RunOptionsSetRunLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$33.const$3, fi, constants$23.const$1, scope);
        }

        static RunOptionsSetRunLogSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetRunLogSeverityLevel$VH() {
        return constants$33.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunLogSeverityLevel)(struct OrtRunOptions*,int);
     * }
     */
    public static MemorySegment RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$33.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunLogSeverityLevel)(struct OrtRunOptions*,int);
     * }
     */
    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$33.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$33.const$4.get(seg, index * sizeof());
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$33.const$4.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsSetRunLogSeverityLevel.ofAddress(RunOptionsSetRunLogSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunTag)(struct OrtRunOptions*,char*);
     * }
     */
    public interface RunOptionsSetRunTag {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RunOptionsSetRunTag fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$33.const$5, fi, constants$15.const$2, scope);
        }

        static RunOptionsSetRunTag ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetRunTag$VH() {
        return constants$34.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunTag)(struct OrtRunOptions*,char*);
     * }
     */
    public static MemorySegment RunOptionsSetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$34.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetRunTag)(struct OrtRunOptions*,char*);
     * }
     */
    public static void RunOptionsSetRunTag$set(MemorySegment seg, MemorySegment x) {
        constants$34.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$34.const$0.get(seg, index * sizeof());
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, long index, MemorySegment x) {
        constants$34.const$0.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetRunTag RunOptionsSetRunTag(MemorySegment segment, Arena scope) {
        return RunOptionsSetRunTag.ofAddress(RunOptionsSetRunTag$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunLogVerbosityLevel)(struct OrtRunOptions*,int*);
     * }
     */
    public interface RunOptionsGetRunLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RunOptionsGetRunLogVerbosityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$34.const$1, fi, constants$15.const$2, scope);
        }

        static RunOptionsGetRunLogVerbosityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsGetRunLogVerbosityLevel$VH() {
        return constants$34.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunLogVerbosityLevel)(struct OrtRunOptions*,int*);
     * }
     */
    public static MemorySegment RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$34.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunLogVerbosityLevel)(struct OrtRunOptions*,int*);
     * }
     */
    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$34.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$34.const$2.get(seg, index * sizeof());
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$34.const$2.set(seg, index * sizeof(), x);
    }

    public static RunOptionsGetRunLogVerbosityLevel RunOptionsGetRunLogVerbosityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsGetRunLogVerbosityLevel.ofAddress(RunOptionsGetRunLogVerbosityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunLogSeverityLevel)(struct OrtRunOptions*,int*);
     * }
     */
    public interface RunOptionsGetRunLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RunOptionsGetRunLogSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$34.const$3, fi, constants$15.const$2, scope);
        }

        static RunOptionsGetRunLogSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsGetRunLogSeverityLevel$VH() {
        return constants$34.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunLogSeverityLevel)(struct OrtRunOptions*,int*);
     * }
     */
    public static MemorySegment RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$34.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunLogSeverityLevel)(struct OrtRunOptions*,int*);
     * }
     */
    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$34.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$34.const$4.get(seg, index * sizeof());
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$34.const$4.set(seg, index * sizeof(), x);
    }

    public static RunOptionsGetRunLogSeverityLevel RunOptionsGetRunLogSeverityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsGetRunLogSeverityLevel.ofAddress(RunOptionsGetRunLogSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunTag)(struct OrtRunOptions*,char**);
     * }
     */
    public interface RunOptionsGetRunTag {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RunOptionsGetRunTag fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$34.const$5, fi, constants$15.const$2, scope);
        }

        static RunOptionsGetRunTag ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsGetRunTag$VH() {
        return constants$35.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunTag)(struct OrtRunOptions*,char**);
     * }
     */
    public static MemorySegment RunOptionsGetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$35.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsGetRunTag)(struct OrtRunOptions*,char**);
     * }
     */
    public static void RunOptionsGetRunTag$set(MemorySegment seg, MemorySegment x) {
        constants$35.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsGetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$35.const$0.get(seg, index * sizeof());
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, long index, MemorySegment x) {
        constants$35.const$0.set(seg, index * sizeof(), x);
    }

    public static RunOptionsGetRunTag RunOptionsGetRunTag(MemorySegment segment, Arena scope) {
        return RunOptionsGetRunTag.ofAddress(RunOptionsGetRunTag$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetTerminate)(struct OrtRunOptions*);
     * }
     */
    public interface RunOptionsSetTerminate {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(RunOptionsSetTerminate fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$35.const$1, fi, constants$1.const$4, scope);
        }

        static RunOptionsSetTerminate ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetTerminate$VH() {
        return constants$35.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetTerminate)(struct OrtRunOptions*);
     * }
     */
    public static MemorySegment RunOptionsSetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$35.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsSetTerminate)(struct OrtRunOptions*);
     * }
     */
    public static void RunOptionsSetTerminate$set(MemorySegment seg, MemorySegment x) {
        constants$35.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$35.const$2.get(seg, index * sizeof());
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, long index, MemorySegment x) {
        constants$35.const$2.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetTerminate RunOptionsSetTerminate(MemorySegment segment, Arena scope) {
        return RunOptionsSetTerminate.ofAddress(RunOptionsSetTerminate$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunOptionsUnsetTerminate)(struct OrtRunOptions*);
     * }
     */
    public interface RunOptionsUnsetTerminate {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(RunOptionsUnsetTerminate fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$35.const$3, fi, constants$1.const$4, scope);
        }

        static RunOptionsUnsetTerminate ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsUnsetTerminate$VH() {
        return constants$35.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsUnsetTerminate)(struct OrtRunOptions*);
     * }
     */
    public static MemorySegment RunOptionsUnsetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$35.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunOptionsUnsetTerminate)(struct OrtRunOptions*);
     * }
     */
    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, MemorySegment x) {
        constants$35.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsUnsetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$35.const$4.get(seg, index * sizeof());
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, long index, MemorySegment x) {
        constants$35.const$4.set(seg, index * sizeof(), x);
    }

    public static RunOptionsUnsetTerminate RunOptionsUnsetTerminate(MemorySegment segment, Arena scope) {
        return RunOptionsUnsetTerminate.ofAddress(RunOptionsUnsetTerminate$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public interface CreateTensorAsOrtValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateTensorAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$36.const$0, fi, constants$35.const$5, scope);
        }

        static CreateTensorAsOrtValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$36.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateTensorAsOrtValue$VH() {
        return constants$36.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static MemorySegment CreateTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$36.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static void CreateTensorAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$36.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$36.const$2.get(seg, index * sizeof());
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$36.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateTensorAsOrtValue CreateTensorAsOrtValue(MemorySegment segment, Arena scope) {
        return CreateTensorAsOrtValue.ofAddress(CreateTensorAsOrtValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateTensorWithDataAsOrtValue)(struct OrtMemoryInfo*,void*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
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

        static MemorySegment allocate(CreateTensorWithDataAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$36.const$4, fi, constants$36.const$3, scope);
        }

        static CreateTensorWithDataAsOrtValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4,
                    int __x5,
                    java.lang.foreign.MemorySegment __x6) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$36.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateTensorWithDataAsOrtValue$VH() {
        return constants$37.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorWithDataAsOrtValue)(struct OrtMemoryInfo*,void*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static MemorySegment CreateTensorWithDataAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$37.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorWithDataAsOrtValue)(struct OrtMemoryInfo*,void*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$37.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorWithDataAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$37.const$0.get(seg, index * sizeof());
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$37.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue(MemorySegment segment, Arena scope) {
        return CreateTensorWithDataAsOrtValue.ofAddress(CreateTensorWithDataAsOrtValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*IsTensor)(struct OrtValue*,int*);
     * }
     */
    public interface IsTensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(IsTensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$37.const$1, fi, constants$15.const$2, scope);
        }

        static IsTensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle IsTensor$VH() {
        return constants$37.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*IsTensor)(struct OrtValue*,int*);
     * }
     */
    public static MemorySegment IsTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$37.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*IsTensor)(struct OrtValue*,int*);
     * }
     */
    public static void IsTensor$set(MemorySegment seg, MemorySegment x) {
        constants$37.const$2.set(seg, 0L, x);
    }

    public static MemorySegment IsTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$37.const$2.get(seg, index * sizeof());
    }

    public static void IsTensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$37.const$2.set(seg, index * sizeof(), x);
    }

    public static IsTensor IsTensor(MemorySegment segment, Arena scope) {
        return IsTensor.ofAddress(IsTensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorMutableData)(struct OrtValue*,void**);
     * }
     */
    public interface GetTensorMutableData {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetTensorMutableData fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$37.const$3, fi, constants$15.const$2, scope);
        }

        static GetTensorMutableData ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorMutableData$VH() {
        return constants$37.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorMutableData)(struct OrtValue*,void**);
     * }
     */
    public static MemorySegment GetTensorMutableData$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$37.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorMutableData)(struct OrtValue*,void**);
     * }
     */
    public static void GetTensorMutableData$set(MemorySegment seg, MemorySegment x) {
        constants$37.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorMutableData$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$37.const$4.get(seg, index * sizeof());
    }

    public static void GetTensorMutableData$set(MemorySegment seg, long index, MemorySegment x) {
        constants$37.const$4.set(seg, index * sizeof(), x);
    }

    public static GetTensorMutableData GetTensorMutableData(MemorySegment segment, Arena scope) {
        return GetTensorMutableData.ofAddress(GetTensorMutableData$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*FillStringTensor)(struct OrtValue*,char**,unsigned long);
     * }
     */
    public interface FillStringTensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(FillStringTensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$38.const$0, fi, constants$37.const$5, scope);
        }

        static FillStringTensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillStringTensor$VH() {
        return constants$38.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*FillStringTensor)(struct OrtValue*,char**,unsigned long);
     * }
     */
    public static MemorySegment FillStringTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$38.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*FillStringTensor)(struct OrtValue*,char**,unsigned long);
     * }
     */
    public static void FillStringTensor$set(MemorySegment seg, MemorySegment x) {
        constants$38.const$2.set(seg, 0L, x);
    }

    public static MemorySegment FillStringTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$38.const$2.get(seg, index * sizeof());
    }

    public static void FillStringTensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$38.const$2.set(seg, index * sizeof(), x);
    }

    public static FillStringTensor FillStringTensor(MemorySegment segment, Arena scope) {
        return FillStringTensor.ofAddress(FillStringTensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorDataLength)(struct OrtValue*,unsigned long*);
     * }
     */
    public interface GetStringTensorDataLength {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetStringTensorDataLength fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$38.const$3, fi, constants$15.const$2, scope);
        }

        static GetStringTensorDataLength ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorDataLength$VH() {
        return constants$38.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorDataLength)(struct OrtValue*,unsigned long*);
     * }
     */
    public static MemorySegment GetStringTensorDataLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$38.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorDataLength)(struct OrtValue*,unsigned long*);
     * }
     */
    public static void GetStringTensorDataLength$set(MemorySegment seg, MemorySegment x) {
        constants$38.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorDataLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$38.const$4.get(seg, index * sizeof());
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, long index, MemorySegment x) {
        constants$38.const$4.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorDataLength GetStringTensorDataLength(MemorySegment segment, Arena scope) {
        return GetStringTensorDataLength.ofAddress(GetStringTensorDataLength$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorContent)(struct OrtValue*,void*,unsigned long,unsigned long*,unsigned long);
     * }
     */
    public interface GetStringTensorContent {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(GetStringTensorContent fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$39.const$0, fi, constants$38.const$5, scope);
        }

        static GetStringTensorContent ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$39.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorContent$VH() {
        return constants$39.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorContent)(struct OrtValue*,void*,unsigned long,unsigned long*,unsigned long);
     * }
     */
    public static MemorySegment GetStringTensorContent$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$39.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorContent)(struct OrtValue*,void*,unsigned long,unsigned long*,unsigned long);
     * }
     */
    public static void GetStringTensorContent$set(MemorySegment seg, MemorySegment x) {
        constants$39.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorContent$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$39.const$2.get(seg, index * sizeof());
    }

    public static void GetStringTensorContent$set(MemorySegment seg, long index, MemorySegment x) {
        constants$39.const$2.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorContent GetStringTensorContent(MemorySegment segment, Arena scope) {
        return GetStringTensorContent.ofAddress(GetStringTensorContent$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToTensorInfo)(struct OrtTypeInfo*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface CastTypeInfoToTensorInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CastTypeInfoToTensorInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$39.const$3, fi, constants$15.const$2, scope);
        }

        static CastTypeInfoToTensorInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToTensorInfo$VH() {
        return constants$39.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToTensorInfo)(struct OrtTypeInfo*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToTensorInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$39.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToTensorInfo)(struct OrtTypeInfo*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, MemorySegment x) {
        constants$39.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToTensorInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$39.const$4.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$39.const$4.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToTensorInfo.ofAddress(CastTypeInfoToTensorInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetOnnxTypeFromTypeInfo)(struct OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public interface GetOnnxTypeFromTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetOnnxTypeFromTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$39.const$5, fi, constants$15.const$2, scope);
        }

        static GetOnnxTypeFromTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOnnxTypeFromTypeInfo$VH() {
        return constants$40.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetOnnxTypeFromTypeInfo)(struct OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public static MemorySegment GetOnnxTypeFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$40.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetOnnxTypeFromTypeInfo)(struct OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$40.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetOnnxTypeFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$40.const$0.get(seg, index * sizeof());
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$40.const$0.set(seg, index * sizeof(), x);
    }

    public static GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo(MemorySegment segment, Arena scope) {
        return GetOnnxTypeFromTypeInfo.ofAddress(GetOnnxTypeFromTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface CreateTensorTypeAndShapeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateTensorTypeAndShapeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$40.const$1, fi, constants$1.const$4, scope);
        }

        static CreateTensorTypeAndShapeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateTensorTypeAndShapeInfo$VH() {
        return constants$40.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment CreateTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$40.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$40.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$40.const$2.get(seg, index * sizeof());
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$40.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateTensorTypeAndShapeInfo CreateTensorTypeAndShapeInfo(MemorySegment segment, Arena scope) {
        return CreateTensorTypeAndShapeInfo.ofAddress(CreateTensorTypeAndShapeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public interface SetTensorElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetTensorElementType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$40.const$3, fi, constants$23.const$1, scope);
        }

        static SetTensorElementType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetTensorElementType$VH() {
        return constants$40.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public static MemorySegment SetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$40.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public static void SetTensorElementType$set(MemorySegment seg, MemorySegment x) {
        constants$40.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$40.const$4.get(seg, index * sizeof());
    }

    public static void SetTensorElementType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$40.const$4.set(seg, index * sizeof(), x);
    }

    public static SetTensorElementType SetTensorElementType(MemorySegment segment, Arena scope) {
        return SetTensorElementType.ofAddress(SetTensorElementType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
     * }
     */
    public interface SetDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(SetDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$40.const$5, fi, constants$37.const$5, scope);
        }

        static SetDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetDimensions$VH() {
        return constants$41.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
     * }
     */
    public static MemorySegment SetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$41.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
     * }
     */
    public static void SetDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$41.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$41.const$0.get(seg, index * sizeof());
    }

    public static void SetDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$41.const$0.set(seg, index * sizeof(), x);
    }

    public static SetDimensions SetDimensions(MemorySegment segment, Arena scope) {
        return SetDimensions.ofAddress(SetDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public interface GetTensorElementType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetTensorElementType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$41.const$1, fi, constants$15.const$2, scope);
        }

        static GetTensorElementType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorElementType$VH() {
        return constants$41.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static MemorySegment GetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$41.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorElementType)(struct OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static void GetTensorElementType$set(MemorySegment seg, MemorySegment x) {
        constants$41.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$41.const$2.get(seg, index * sizeof());
    }

    public static void GetTensorElementType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$41.const$2.set(seg, index * sizeof(), x);
    }

    public static GetTensorElementType GetTensorElementType(MemorySegment segment, Arena scope) {
        return GetTensorElementType.ofAddress(GetTensorElementType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetDimensionsCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
     * }
     */
    public interface GetDimensionsCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetDimensionsCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$41.const$3, fi, constants$15.const$2, scope);
        }

        static GetDimensionsCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDimensionsCount$VH() {
        return constants$41.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDimensionsCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
     * }
     */
    public static MemorySegment GetDimensionsCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$41.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDimensionsCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
     * }
     */
    public static void GetDimensionsCount$set(MemorySegment seg, MemorySegment x) {
        constants$41.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetDimensionsCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$41.const$4.get(seg, index * sizeof());
    }

    public static void GetDimensionsCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$41.const$4.set(seg, index * sizeof(), x);
    }

    public static GetDimensionsCount GetDimensionsCount(MemorySegment segment, Arena scope) {
        return GetDimensionsCount.ofAddress(GetDimensionsCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
     * }
     */
    public interface GetDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(GetDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$41.const$5, fi, constants$37.const$5, scope);
        }

        static GetDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDimensions$VH() {
        return constants$42.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
     * }
     */
    public static MemorySegment GetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$42.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDimensions)(struct OrtTensorTypeAndShapeInfo*,long long*,unsigned long);
     * }
     */
    public static void GetDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$42.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$42.const$0.get(seg, index * sizeof());
    }

    public static void GetDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$42.const$0.set(seg, index * sizeof(), x);
    }

    public static GetDimensions GetDimensions(MemorySegment segment, Arena scope) {
        return GetDimensions.ofAddress(GetDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSymbolicDimensions)(struct OrtTensorTypeAndShapeInfo*,char**,unsigned long);
     * }
     */
    public interface GetSymbolicDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(GetSymbolicDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$42.const$1, fi, constants$37.const$5, scope);
        }

        static GetSymbolicDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSymbolicDimensions$VH() {
        return constants$42.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSymbolicDimensions)(struct OrtTensorTypeAndShapeInfo*,char**,unsigned long);
     * }
     */
    public static MemorySegment GetSymbolicDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$42.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSymbolicDimensions)(struct OrtTensorTypeAndShapeInfo*,char**,unsigned long);
     * }
     */
    public static void GetSymbolicDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$42.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$42.const$2.get(seg, index * sizeof());
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$42.const$2.set(seg, index * sizeof(), x);
    }

    public static GetSymbolicDimensions GetSymbolicDimensions(MemorySegment segment, Arena scope) {
        return GetSymbolicDimensions.ofAddress(GetSymbolicDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorShapeElementCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
     * }
     */
    public interface GetTensorShapeElementCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetTensorShapeElementCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$42.const$3, fi, constants$15.const$2, scope);
        }

        static GetTensorShapeElementCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorShapeElementCount$VH() {
        return constants$42.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorShapeElementCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
     * }
     */
    public static MemorySegment GetTensorShapeElementCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$42.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorShapeElementCount)(struct OrtTensorTypeAndShapeInfo*,unsigned long*);
     * }
     */
    public static void GetTensorShapeElementCount$set(MemorySegment seg, MemorySegment x) {
        constants$42.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorShapeElementCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$42.const$4.get(seg, index * sizeof());
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$42.const$4.set(seg, index * sizeof(), x);
    }

    public static GetTensorShapeElementCount GetTensorShapeElementCount(MemorySegment segment, Arena scope) {
        return GetTensorShapeElementCount.ofAddress(GetTensorShapeElementCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetTensorTypeAndShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetTensorTypeAndShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$42.const$5, fi, constants$15.const$2, scope);
        }

        static GetTensorTypeAndShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorTypeAndShape$VH() {
        return constants$43.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetTensorTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$43.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetTensorTypeAndShape$set(MemorySegment seg, MemorySegment x) {
        constants$43.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$43.const$0.get(seg, index * sizeof());
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$43.const$0.set(seg, index * sizeof(), x);
    }

    public static GetTensorTypeAndShape GetTensorTypeAndShape(MemorySegment segment, Arena scope) {
        return GetTensorTypeAndShape.ofAddress(GetTensorTypeAndShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTypeInfo)(struct OrtValue*,struct OrtTypeInfo**);
     * }
     */
    public interface GetTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$43.const$1, fi, constants$15.const$2, scope);
        }

        static GetTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTypeInfo$VH() {
        return constants$43.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTypeInfo)(struct OrtValue*,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$43.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTypeInfo)(struct OrtValue*,struct OrtTypeInfo**);
     * }
     */
    public static void GetTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$43.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$43.const$2.get(seg, index * sizeof());
    }

    public static void GetTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$43.const$2.set(seg, index * sizeof(), x);
    }

    public static GetTypeInfo GetTypeInfo(MemorySegment segment, Arena scope) {
        return GetTypeInfo.ofAddress(GetTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetValueType)(struct OrtValue*,enum ONNXType*);
     * }
     */
    public interface GetValueType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetValueType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$43.const$3, fi, constants$15.const$2, scope);
        }

        static GetValueType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetValueType$VH() {
        return constants$43.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetValueType)(struct OrtValue*,enum ONNXType*);
     * }
     */
    public static MemorySegment GetValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$43.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetValueType)(struct OrtValue*,enum ONNXType*);
     * }
     */
    public static void GetValueType$set(MemorySegment seg, MemorySegment x) {
        constants$43.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$43.const$4.get(seg, index * sizeof());
    }

    public static void GetValueType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$43.const$4.set(seg, index * sizeof(), x);
    }

    public static GetValueType GetValueType(MemorySegment segment, Arena scope) {
        return GetValueType.ofAddress(GetValueType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,struct OrtMemoryInfo**);
     * }
     */
    public interface CreateMemoryInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$44.const$0, fi, constants$43.const$5, scope);
        }

        static CreateMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    int __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$44.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateMemoryInfo$VH() {
        return constants$44.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,struct OrtMemoryInfo**);
     * }
     */
    public static MemorySegment CreateMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$44.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,struct OrtMemoryInfo**);
     * }
     */
    public static void CreateMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$44.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$44.const$2.get(seg, index * sizeof());
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$44.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateMemoryInfo CreateMemoryInfo(MemorySegment segment, Arena scope) {
        return CreateMemoryInfo.ofAddress(CreateMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,struct OrtMemoryInfo**);
     * }
     */
    public interface CreateCpuMemoryInfo {

        java.lang.foreign.MemorySegment apply(int _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateCpuMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$44.const$4, fi, constants$44.const$3, scope);
        }

        static CreateCpuMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$44.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateCpuMemoryInfo$VH() {
        return constants$45.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,struct OrtMemoryInfo**);
     * }
     */
    public static MemorySegment CreateCpuMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$45.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,struct OrtMemoryInfo**);
     * }
     */
    public static void CreateCpuMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$45.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateCpuMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$45.const$0.get(seg, index * sizeof());
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$45.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateCpuMemoryInfo CreateCpuMemoryInfo(MemorySegment segment, Arena scope) {
        return CreateCpuMemoryInfo.ofAddress(CreateCpuMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CompareMemoryInfo)(struct OrtMemoryInfo*,struct OrtMemoryInfo*,int*);
     * }
     */
    public interface CompareMemoryInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(CompareMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$45.const$1, fi, constants$14.const$4, scope);
        }

        static CompareMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CompareMemoryInfo$VH() {
        return constants$45.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CompareMemoryInfo)(struct OrtMemoryInfo*,struct OrtMemoryInfo*,int*);
     * }
     */
    public static MemorySegment CompareMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$45.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CompareMemoryInfo)(struct OrtMemoryInfo*,struct OrtMemoryInfo*,int*);
     * }
     */
    public static void CompareMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$45.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CompareMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$45.const$2.get(seg, index * sizeof());
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$45.const$2.set(seg, index * sizeof(), x);
    }

    public static CompareMemoryInfo CompareMemoryInfo(MemorySegment segment, Arena scope) {
        return CompareMemoryInfo.ofAddress(CompareMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetName)(struct OrtMemoryInfo*,char**);
     * }
     */
    public interface MemoryInfoGetName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(MemoryInfoGetName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$45.const$3, fi, constants$15.const$2, scope);
        }

        static MemoryInfoGetName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetName$VH() {
        return constants$45.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetName)(struct OrtMemoryInfo*,char**);
     * }
     */
    public static MemorySegment MemoryInfoGetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$45.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetName)(struct OrtMemoryInfo*,char**);
     * }
     */
    public static void MemoryInfoGetName$set(MemorySegment seg, MemorySegment x) {
        constants$45.const$4.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$45.const$4.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$45.const$4.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetName MemoryInfoGetName(MemorySegment segment, Arena scope) {
        return MemoryInfoGetName.ofAddress(MemoryInfoGetName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetId)(struct OrtMemoryInfo*,int*);
     * }
     */
    public interface MemoryInfoGetId {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(MemoryInfoGetId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$45.const$5, fi, constants$15.const$2, scope);
        }

        static MemoryInfoGetId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetId$VH() {
        return constants$46.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetId)(struct OrtMemoryInfo*,int*);
     * }
     */
    public static MemorySegment MemoryInfoGetId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$46.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetId)(struct OrtMemoryInfo*,int*);
     * }
     */
    public static void MemoryInfoGetId$set(MemorySegment seg, MemorySegment x) {
        constants$46.const$0.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$46.const$0.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$46.const$0.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetId MemoryInfoGetId(MemorySegment segment, Arena scope) {
        return MemoryInfoGetId.ofAddress(MemoryInfoGetId$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetMemType)(struct OrtMemoryInfo*,enum OrtMemType*);
     * }
     */
    public interface MemoryInfoGetMemType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(MemoryInfoGetMemType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$46.const$1, fi, constants$15.const$2, scope);
        }

        static MemoryInfoGetMemType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetMemType$VH() {
        return constants$46.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetMemType)(struct OrtMemoryInfo*,enum OrtMemType*);
     * }
     */
    public static MemorySegment MemoryInfoGetMemType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$46.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetMemType)(struct OrtMemoryInfo*,enum OrtMemType*);
     * }
     */
    public static void MemoryInfoGetMemType$set(MemorySegment seg, MemorySegment x) {
        constants$46.const$2.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetMemType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$46.const$2.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$46.const$2.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetMemType MemoryInfoGetMemType(MemorySegment segment, Arena scope) {
        return MemoryInfoGetMemType.ofAddress(MemoryInfoGetMemType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetType)(struct OrtMemoryInfo*,enum OrtAllocatorType*);
     * }
     */
    public interface MemoryInfoGetType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(MemoryInfoGetType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$46.const$3, fi, constants$15.const$2, scope);
        }

        static MemoryInfoGetType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetType$VH() {
        return constants$46.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetType)(struct OrtMemoryInfo*,enum OrtAllocatorType*);
     * }
     */
    public static MemorySegment MemoryInfoGetType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$46.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*MemoryInfoGetType)(struct OrtMemoryInfo*,enum OrtAllocatorType*);
     * }
     */
    public static void MemoryInfoGetType$set(MemorySegment seg, MemorySegment x) {
        constants$46.const$4.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$46.const$4.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$46.const$4.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetType MemoryInfoGetType(MemorySegment segment, Arena scope) {
        return MemoryInfoGetType.ofAddress(MemoryInfoGetType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AllocatorAlloc)(struct OrtAllocator*,unsigned long,void**);
     * }
     */
    public interface AllocatorAlloc {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(AllocatorAlloc fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$46.const$5, fi, constants$30.const$1, scope);
        }

        static AllocatorAlloc ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AllocatorAlloc$VH() {
        return constants$47.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AllocatorAlloc)(struct OrtAllocator*,unsigned long,void**);
     * }
     */
    public static MemorySegment AllocatorAlloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$47.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AllocatorAlloc)(struct OrtAllocator*,unsigned long,void**);
     * }
     */
    public static void AllocatorAlloc$set(MemorySegment seg, MemorySegment x) {
        constants$47.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AllocatorAlloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$47.const$0.get(seg, index * sizeof());
    }

    public static void AllocatorAlloc$set(MemorySegment seg, long index, MemorySegment x) {
        constants$47.const$0.set(seg, index * sizeof(), x);
    }

    public static AllocatorAlloc AllocatorAlloc(MemorySegment segment, Arena scope) {
        return AllocatorAlloc.ofAddress(AllocatorAlloc$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AllocatorFree)(struct OrtAllocator*,void*);
     * }
     */
    public interface AllocatorFree {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(AllocatorFree fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$47.const$1, fi, constants$15.const$2, scope);
        }

        static AllocatorFree ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AllocatorFree$VH() {
        return constants$47.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AllocatorFree)(struct OrtAllocator*,void*);
     * }
     */
    public static MemorySegment AllocatorFree$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$47.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AllocatorFree)(struct OrtAllocator*,void*);
     * }
     */
    public static void AllocatorFree$set(MemorySegment seg, MemorySegment x) {
        constants$47.const$2.set(seg, 0L, x);
    }

    public static MemorySegment AllocatorFree$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$47.const$2.get(seg, index * sizeof());
    }

    public static void AllocatorFree$set(MemorySegment seg, long index, MemorySegment x) {
        constants$47.const$2.set(seg, index * sizeof(), x);
    }

    public static AllocatorFree AllocatorFree(MemorySegment segment, Arena scope) {
        return AllocatorFree.ofAddress(AllocatorFree$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AllocatorGetInfo)(struct OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public interface AllocatorGetInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(AllocatorGetInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$47.const$3, fi, constants$15.const$2, scope);
        }

        static AllocatorGetInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AllocatorGetInfo$VH() {
        return constants$47.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AllocatorGetInfo)(struct OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public static MemorySegment AllocatorGetInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$47.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AllocatorGetInfo)(struct OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public static void AllocatorGetInfo$set(MemorySegment seg, MemorySegment x) {
        constants$47.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AllocatorGetInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$47.const$4.get(seg, index * sizeof());
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$47.const$4.set(seg, index * sizeof(), x);
    }

    public static AllocatorGetInfo AllocatorGetInfo(MemorySegment segment, Arena scope) {
        return AllocatorGetInfo.ofAddress(AllocatorGetInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetAllocatorWithDefaultOptions)(struct OrtAllocator**);
     * }
     */
    public interface GetAllocatorWithDefaultOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetAllocatorWithDefaultOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$47.const$5, fi, constants$1.const$4, scope);
        }

        static GetAllocatorWithDefaultOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetAllocatorWithDefaultOptions$VH() {
        return constants$48.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetAllocatorWithDefaultOptions)(struct OrtAllocator**);
     * }
     */
    public static MemorySegment GetAllocatorWithDefaultOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$48.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetAllocatorWithDefaultOptions)(struct OrtAllocator**);
     * }
     */
    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, MemorySegment x) {
        constants$48.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetAllocatorWithDefaultOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$48.const$0.get(seg, index * sizeof());
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$48.const$0.set(seg, index * sizeof(), x);
    }

    public static GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions(MemorySegment segment, Arena scope) {
        return GetAllocatorWithDefaultOptions.ofAddress(GetAllocatorWithDefaultOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddFreeDimensionOverride)(struct OrtSessionOptions*,char*,long long);
     * }
     */
    public interface AddFreeDimensionOverride {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverride fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$48.const$1, fi, constants$37.const$5, scope);
        }

        static AddFreeDimensionOverride ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddFreeDimensionOverride$VH() {
        return constants$48.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddFreeDimensionOverride)(struct OrtSessionOptions*,char*,long long);
     * }
     */
    public static MemorySegment AddFreeDimensionOverride$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$48.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddFreeDimensionOverride)(struct OrtSessionOptions*,char*,long long);
     * }
     */
    public static void AddFreeDimensionOverride$set(MemorySegment seg, MemorySegment x) {
        constants$48.const$2.set(seg, 0L, x);
    }

    public static MemorySegment AddFreeDimensionOverride$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$48.const$2.get(seg, index * sizeof());
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, long index, MemorySegment x) {
        constants$48.const$2.set(seg, index * sizeof(), x);
    }

    public static AddFreeDimensionOverride AddFreeDimensionOverride(MemorySegment segment, Arena scope) {
        return AddFreeDimensionOverride.ofAddress(AddFreeDimensionOverride$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetValue)(struct OrtValue*,int,struct OrtAllocator*,struct OrtValue**);
     * }
     */
    public interface GetValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                int _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$48.const$4, fi, constants$48.const$3, scope);
        }

        static GetValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$48.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetValue$VH() {
        return constants$49.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetValue)(struct OrtValue*,int,struct OrtAllocator*,struct OrtValue**);
     * }
     */
    public static MemorySegment GetValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$49.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetValue)(struct OrtValue*,int,struct OrtAllocator*,struct OrtValue**);
     * }
     */
    public static void GetValue$set(MemorySegment seg, MemorySegment x) {
        constants$49.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$49.const$0.get(seg, index * sizeof());
    }

    public static void GetValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$49.const$0.set(seg, index * sizeof(), x);
    }

    public static GetValue GetValue(MemorySegment segment, Arena scope) {
        return GetValue.ofAddress(GetValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetValueCount)(struct OrtValue*,unsigned long*);
     * }
     */
    public interface GetValueCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetValueCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$49.const$1, fi, constants$15.const$2, scope);
        }

        static GetValueCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetValueCount$VH() {
        return constants$49.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetValueCount)(struct OrtValue*,unsigned long*);
     * }
     */
    public static MemorySegment GetValueCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$49.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetValueCount)(struct OrtValue*,unsigned long*);
     * }
     */
    public static void GetValueCount$set(MemorySegment seg, MemorySegment x) {
        constants$49.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetValueCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$49.const$2.get(seg, index * sizeof());
    }

    public static void GetValueCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$49.const$2.set(seg, index * sizeof(), x);
    }

    public static GetValueCount GetValueCount(MemorySegment segment, Arena scope) {
        return GetValueCount.ofAddress(GetValueCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateValue)(struct OrtValue**,unsigned long,enum ONNXType,struct OrtValue**);
     * }
     */
    public interface CreateValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, int _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$49.const$4, fi, constants$49.const$3, scope);
        }

        static CreateValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$49.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateValue$VH() {
        return constants$50.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateValue)(struct OrtValue**,unsigned long,enum ONNXType,struct OrtValue**);
     * }
     */
    public static MemorySegment CreateValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$50.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateValue)(struct OrtValue**,unsigned long,enum ONNXType,struct OrtValue**);
     * }
     */
    public static void CreateValue$set(MemorySegment seg, MemorySegment x) {
        constants$50.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$50.const$0.get(seg, index * sizeof());
    }

    public static void CreateValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$50.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateValue CreateValue(MemorySegment segment, Arena scope) {
        return CreateValue.ofAddress(CreateValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateOpaqueValue)(char*,char*,void*,unsigned long,struct OrtValue**);
     * }
     */
    public interface CreateOpaqueValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateOpaqueValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$50.const$2, fi, constants$50.const$1, scope);
        }

        static CreateOpaqueValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$50.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateOpaqueValue$VH() {
        return constants$50.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateOpaqueValue)(char*,char*,void*,unsigned long,struct OrtValue**);
     * }
     */
    public static MemorySegment CreateOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$50.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateOpaqueValue)(char*,char*,void*,unsigned long,struct OrtValue**);
     * }
     */
    public static void CreateOpaqueValue$set(MemorySegment seg, MemorySegment x) {
        constants$50.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$50.const$4.get(seg, index * sizeof());
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$50.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateOpaqueValue CreateOpaqueValue(MemorySegment segment, Arena scope) {
        return CreateOpaqueValue.ofAddress(CreateOpaqueValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetOpaqueValue)(char*,char*,struct OrtValue*,void*,unsigned long);
     * }
     */
    public interface GetOpaqueValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(GetOpaqueValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$51.const$0, fi, constants$50.const$5, scope);
        }

        static GetOpaqueValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$51.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOpaqueValue$VH() {
        return constants$51.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetOpaqueValue)(char*,char*,struct OrtValue*,void*,unsigned long);
     * }
     */
    public static MemorySegment GetOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$51.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetOpaqueValue)(char*,char*,struct OrtValue*,void*,unsigned long);
     * }
     */
    public static void GetOpaqueValue$set(MemorySegment seg, MemorySegment x) {
        constants$51.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$51.const$2.get(seg, index * sizeof());
    }

    public static void GetOpaqueValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$51.const$2.set(seg, index * sizeof(), x);
    }

    public static GetOpaqueValue GetOpaqueValue(MemorySegment segment, Arena scope) {
        return GetOpaqueValue.ofAddress(GetOpaqueValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_float)(struct OrtKernelInfo*,char*,float*);
     * }
     */
    public interface KernelInfoGetAttribute_float {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(KernelInfoGetAttribute_float fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$51.const$3, fi, constants$14.const$4, scope);
        }

        static KernelInfoGetAttribute_float ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_float$VH() {
        return constants$51.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_float)(struct OrtKernelInfo*,char*,float*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$51.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_float)(struct OrtKernelInfo*,char*,float*);
     * }
     */
    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, MemorySegment x) {
        constants$51.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$51.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, long index, MemorySegment x) {
        constants$51.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_float KernelInfoGetAttribute_float(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_float.ofAddress(KernelInfoGetAttribute_float$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_int64)(struct OrtKernelInfo*,char*,long long*);
     * }
     */
    public interface KernelInfoGetAttribute_int64 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(KernelInfoGetAttribute_int64 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$51.const$5, fi, constants$14.const$4, scope);
        }

        static KernelInfoGetAttribute_int64 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_int64$VH() {
        return constants$52.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_int64)(struct OrtKernelInfo*,char*,long long*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$52.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_int64)(struct OrtKernelInfo*,char*,long long*);
     * }
     */
    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$52.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_int64 KernelInfoGetAttribute_int64(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_int64.ofAddress(KernelInfoGetAttribute_int64$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_string)(struct OrtKernelInfo*,char*,char*,unsigned long*);
     * }
     */
    public interface KernelInfoGetAttribute_string {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttribute_string fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$52.const$1, fi, constants$20.const$1, scope);
        }

        static KernelInfoGetAttribute_string ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_string$VH() {
        return constants$52.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_string)(struct OrtKernelInfo*,char*,char*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_string$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$52.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_string)(struct OrtKernelInfo*,char*,char*,unsigned long*);
     * }
     */
    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_string$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$52.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_string KernelInfoGetAttribute_string(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_string.ofAddress(KernelInfoGetAttribute_string$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetInputCount)(struct OrtKernelContext*,unsigned long*);
     * }
     */
    public interface KernelContext_GetInputCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelContext_GetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$52.const$3, fi, constants$15.const$2, scope);
        }

        static KernelContext_GetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetInputCount$VH() {
        return constants$52.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetInputCount)(struct OrtKernelContext*,unsigned long*);
     * }
     */
    public static MemorySegment KernelContext_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$52.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetInputCount)(struct OrtKernelContext*,unsigned long*);
     * }
     */
    public static void KernelContext_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$52.const$4.get(seg, index * sizeof());
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetInputCount KernelContext_GetInputCount(MemorySegment segment, Arena scope) {
        return KernelContext_GetInputCount.ofAddress(KernelContext_GetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetOutputCount)(struct OrtKernelContext*,unsigned long*);
     * }
     */
    public interface KernelContext_GetOutputCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelContext_GetOutputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$52.const$5, fi, constants$15.const$2, scope);
        }

        static KernelContext_GetOutputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetOutputCount$VH() {
        return constants$53.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetOutputCount)(struct OrtKernelContext*,unsigned long*);
     * }
     */
    public static MemorySegment KernelContext_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$53.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetOutputCount)(struct OrtKernelContext*,unsigned long*);
     * }
     */
    public static void KernelContext_GetOutputCount$set(MemorySegment seg, MemorySegment x) {
        constants$53.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$53.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$53.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetOutputCount KernelContext_GetOutputCount(MemorySegment segment, Arena scope) {
        return KernelContext_GetOutputCount.ofAddress(KernelContext_GetOutputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetInput)(struct OrtKernelContext*,unsigned long,struct OrtValue**);
     * }
     */
    public interface KernelContext_GetInput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelContext_GetInput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$53.const$1, fi, constants$30.const$1, scope);
        }

        static KernelContext_GetInput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetInput$VH() {
        return constants$53.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetInput)(struct OrtKernelContext*,unsigned long,struct OrtValue**);
     * }
     */
    public static MemorySegment KernelContext_GetInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$53.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetInput)(struct OrtKernelContext*,unsigned long,struct OrtValue**);
     * }
     */
    public static void KernelContext_GetInput$set(MemorySegment seg, MemorySegment x) {
        constants$53.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$53.const$2.get(seg, index * sizeof());
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$53.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetInput KernelContext_GetInput(MemorySegment segment, Arena scope) {
        return KernelContext_GetInput.ofAddress(KernelContext_GetInput$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetOutput)(struct OrtKernelContext*,unsigned long,long long*,unsigned long,struct OrtValue**);
     * }
     */
    public interface KernelContext_GetOutput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(KernelContext_GetOutput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$53.const$4, fi, constants$53.const$3, scope);
        }

        static KernelContext_GetOutput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$53.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetOutput$VH() {
        return constants$54.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetOutput)(struct OrtKernelContext*,unsigned long,long long*,unsigned long,struct OrtValue**);
     * }
     */
    public static MemorySegment KernelContext_GetOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$54.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetOutput)(struct OrtKernelContext*,unsigned long,long long*,unsigned long,struct OrtValue**);
     * }
     */
    public static void KernelContext_GetOutput$set(MemorySegment seg, MemorySegment x) {
        constants$54.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$54.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$54.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetOutput KernelContext_GetOutput(MemorySegment segment, Arena scope) {
        return KernelContext_GetOutput.ofAddress(KernelContext_GetOutput$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseEnv)(struct OrtEnv*);
     * }
     */
    public interface ReleaseEnv {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseEnv fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$54.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseEnv ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseEnv$VH() {
        return constants$54.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseEnv)(struct OrtEnv*);
     * }
     */
    public static MemorySegment ReleaseEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$54.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseEnv)(struct OrtEnv*);
     * }
     */
    public static void ReleaseEnv$set(MemorySegment seg, MemorySegment x) {
        constants$54.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$54.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseEnv$set(MemorySegment seg, long index, MemorySegment x) {
        constants$54.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseEnv ReleaseEnv(MemorySegment segment, Arena scope) {
        return ReleaseEnv.ofAddress(ReleaseEnv$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseStatus)(struct OrtStatus*);
     * }
     */
    public interface ReleaseStatus {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseStatus fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$54.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseStatus ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseStatus$VH() {
        return constants$54.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseStatus)(struct OrtStatus*);
     * }
     */
    public static MemorySegment ReleaseStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$54.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseStatus)(struct OrtStatus*);
     * }
     */
    public static void ReleaseStatus$set(MemorySegment seg, MemorySegment x) {
        constants$54.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$54.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseStatus$set(MemorySegment seg, long index, MemorySegment x) {
        constants$54.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseStatus ReleaseStatus(MemorySegment segment, Arena scope) {
        return ReleaseStatus.ofAddress(ReleaseStatus$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseMemoryInfo)(struct OrtMemoryInfo*);
     * }
     */
    public interface ReleaseMemoryInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$54.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseMemoryInfo$VH() {
        return constants$55.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseMemoryInfo)(struct OrtMemoryInfo*);
     * }
     */
    public static MemorySegment ReleaseMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$55.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseMemoryInfo)(struct OrtMemoryInfo*);
     * }
     */
    public static void ReleaseMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$55.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$55.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$55.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseMemoryInfo ReleaseMemoryInfo(MemorySegment segment, Arena scope) {
        return ReleaseMemoryInfo.ofAddress(ReleaseMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseSession)(struct OrtSession*);
     * }
     */
    public interface ReleaseSession {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSession fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$55.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseSession ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseSession$VH() {
        return constants$55.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSession)(struct OrtSession*);
     * }
     */
    public static MemorySegment ReleaseSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$55.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSession)(struct OrtSession*);
     * }
     */
    public static void ReleaseSession$set(MemorySegment seg, MemorySegment x) {
        constants$55.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$55.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseSession$set(MemorySegment seg, long index, MemorySegment x) {
        constants$55.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseSession ReleaseSession(MemorySegment segment, Arena scope) {
        return ReleaseSession.ofAddress(ReleaseSession$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseValue)(struct OrtValue*);
     * }
     */
    public interface ReleaseValue {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$55.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseValue$VH() {
        return constants$55.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseValue)(struct OrtValue*);
     * }
     */
    public static MemorySegment ReleaseValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$55.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseValue)(struct OrtValue*);
     * }
     */
    public static void ReleaseValue$set(MemorySegment seg, MemorySegment x) {
        constants$55.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$55.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$55.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseValue ReleaseValue(MemorySegment segment, Arena scope) {
        return ReleaseValue.ofAddress(ReleaseValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseRunOptions)(struct OrtRunOptions*);
     * }
     */
    public interface ReleaseRunOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseRunOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$55.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseRunOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseRunOptions$VH() {
        return constants$56.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseRunOptions)(struct OrtRunOptions*);
     * }
     */
    public static MemorySegment ReleaseRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$56.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseRunOptions)(struct OrtRunOptions*);
     * }
     */
    public static void ReleaseRunOptions$set(MemorySegment seg, MemorySegment x) {
        constants$56.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$56.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$56.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseRunOptions ReleaseRunOptions(MemorySegment segment, Arena scope) {
        return ReleaseRunOptions.ofAddress(ReleaseRunOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseTypeInfo)(struct OrtTypeInfo*);
     * }
     */
    public interface ReleaseTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$56.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseTypeInfo$VH() {
        return constants$56.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTypeInfo)(struct OrtTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$56.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTypeInfo)(struct OrtTypeInfo*);
     * }
     */
    public static void ReleaseTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$56.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$56.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$56.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseTypeInfo ReleaseTypeInfo(MemorySegment segment, Arena scope) {
        return ReleaseTypeInfo.ofAddress(ReleaseTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo*);
     * }
     */
    public interface ReleaseTensorTypeAndShapeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTensorTypeAndShapeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$56.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseTensorTypeAndShapeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseTensorTypeAndShapeInfo$VH() {
        return constants$56.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static MemorySegment ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$56.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(struct OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$56.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$56.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$56.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo(MemorySegment segment, Arena scope) {
        return ReleaseTensorTypeAndShapeInfo.ofAddress(ReleaseTensorTypeAndShapeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseSessionOptions)(struct OrtSessionOptions*);
     * }
     */
    public interface ReleaseSessionOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSessionOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$56.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseSessionOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseSessionOptions$VH() {
        return constants$57.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSessionOptions)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment ReleaseSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$57.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSessionOptions)(struct OrtSessionOptions*);
     * }
     */
    public static void ReleaseSessionOptions$set(MemorySegment seg, MemorySegment x) {
        constants$57.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$57.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$57.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseSessionOptions ReleaseSessionOptions(MemorySegment segment, Arena scope) {
        return ReleaseSessionOptions.ofAddress(ReleaseSessionOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(struct OrtCustomOpDomain*);
     * }
     */
    public interface ReleaseCustomOpDomain {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCustomOpDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$57.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseCustomOpDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseCustomOpDomain$VH() {
        return constants$57.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(struct OrtCustomOpDomain*);
     * }
     */
    public static MemorySegment ReleaseCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$57.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(struct OrtCustomOpDomain*);
     * }
     */
    public static void ReleaseCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        constants$57.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$57.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$57.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseCustomOpDomain ReleaseCustomOpDomain(MemorySegment segment, Arena scope) {
        return ReleaseCustomOpDomain.ofAddress(ReleaseCustomOpDomain$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetDenotationFromTypeInfo)(struct OrtTypeInfo*,char**,unsigned long*);
     * }
     */
    public interface GetDenotationFromTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetDenotationFromTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$57.const$3, fi, constants$14.const$4, scope);
        }

        static GetDenotationFromTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDenotationFromTypeInfo$VH() {
        return constants$57.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDenotationFromTypeInfo)(struct OrtTypeInfo*,char**,unsigned long*);
     * }
     */
    public static MemorySegment GetDenotationFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$57.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDenotationFromTypeInfo)(struct OrtTypeInfo*,char**,unsigned long*);
     * }
     */
    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$57.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetDenotationFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$57.const$4.get(seg, index * sizeof());
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$57.const$4.set(seg, index * sizeof(), x);
    }

    public static GetDenotationFromTypeInfo GetDenotationFromTypeInfo(MemorySegment segment, Arena scope) {
        return GetDenotationFromTypeInfo.ofAddress(GetDenotationFromTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToMapTypeInfo)(struct OrtTypeInfo*,struct OrtMapTypeInfo**);
     * }
     */
    public interface CastTypeInfoToMapTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CastTypeInfoToMapTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$57.const$5, fi, constants$15.const$2, scope);
        }

        static CastTypeInfoToMapTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToMapTypeInfo$VH() {
        return constants$58.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToMapTypeInfo)(struct OrtTypeInfo*,struct OrtMapTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$58.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToMapTypeInfo)(struct OrtTypeInfo*,struct OrtMapTypeInfo**);
     * }
     */
    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$58.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$58.const$0.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$58.const$0.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToMapTypeInfo.ofAddress(CastTypeInfoToMapTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToSequenceTypeInfo)(struct OrtTypeInfo*,struct OrtSequenceTypeInfo**);
     * }
     */
    public interface CastTypeInfoToSequenceTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CastTypeInfoToSequenceTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$58.const$1, fi, constants$15.const$2, scope);
        }

        static CastTypeInfoToSequenceTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToSequenceTypeInfo$VH() {
        return constants$58.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToSequenceTypeInfo)(struct OrtTypeInfo*,struct OrtSequenceTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$58.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToSequenceTypeInfo)(struct OrtTypeInfo*,struct OrtSequenceTypeInfo**);
     * }
     */
    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$58.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$58.const$2.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$58.const$2.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToSequenceTypeInfo.ofAddress(CastTypeInfoToSequenceTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetMapKeyType)(struct OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public interface GetMapKeyType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetMapKeyType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$58.const$3, fi, constants$15.const$2, scope);
        }

        static GetMapKeyType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetMapKeyType$VH() {
        return constants$58.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetMapKeyType)(struct OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static MemorySegment GetMapKeyType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$58.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetMapKeyType)(struct OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static void GetMapKeyType$set(MemorySegment seg, MemorySegment x) {
        constants$58.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetMapKeyType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$58.const$4.get(seg, index * sizeof());
    }

    public static void GetMapKeyType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$58.const$4.set(seg, index * sizeof(), x);
    }

    public static GetMapKeyType GetMapKeyType(MemorySegment segment, Arena scope) {
        return GetMapKeyType.ofAddress(GetMapKeyType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetMapValueType)(struct OrtMapTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public interface GetMapValueType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetMapValueType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$58.const$5, fi, constants$15.const$2, scope);
        }

        static GetMapValueType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetMapValueType$VH() {
        return constants$59.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetMapValueType)(struct OrtMapTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetMapValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$59.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetMapValueType)(struct OrtMapTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public static void GetMapValueType$set(MemorySegment seg, MemorySegment x) {
        constants$59.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetMapValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$59.const$0.get(seg, index * sizeof());
    }

    public static void GetMapValueType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$59.const$0.set(seg, index * sizeof(), x);
    }

    public static GetMapValueType GetMapValueType(MemorySegment segment, Arena scope) {
        return GetMapValueType.ofAddress(GetMapValueType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSequenceElementType)(struct OrtSequenceTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public interface GetSequenceElementType {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetSequenceElementType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$59.const$1, fi, constants$15.const$2, scope);
        }

        static GetSequenceElementType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSequenceElementType$VH() {
        return constants$59.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSequenceElementType)(struct OrtSequenceTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetSequenceElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$59.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSequenceElementType)(struct OrtSequenceTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public static void GetSequenceElementType$set(MemorySegment seg, MemorySegment x) {
        constants$59.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetSequenceElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$59.const$2.get(seg, index * sizeof());
    }

    public static void GetSequenceElementType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$59.const$2.set(seg, index * sizeof(), x);
    }

    public static GetSequenceElementType GetSequenceElementType(MemorySegment segment, Arena scope) {
        return GetSequenceElementType.ofAddress(GetSequenceElementType$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(struct OrtMapTypeInfo*);
     * }
     */
    public interface ReleaseMapTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseMapTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$59.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseMapTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseMapTypeInfo$VH() {
        return constants$59.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(struct OrtMapTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$59.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(struct OrtMapTypeInfo*);
     * }
     */
    public static void ReleaseMapTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$59.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$59.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$59.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseMapTypeInfo ReleaseMapTypeInfo(MemorySegment segment, Arena scope) {
        return ReleaseMapTypeInfo.ofAddress(ReleaseMapTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(struct OrtSequenceTypeInfo*);
     * }
     */
    public interface ReleaseSequenceTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSequenceTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$59.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseSequenceTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseSequenceTypeInfo$VH() {
        return constants$60.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(struct OrtSequenceTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$60.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(struct OrtSequenceTypeInfo*);
     * }
     */
    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$60.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$60.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$60.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseSequenceTypeInfo ReleaseSequenceTypeInfo(MemorySegment segment, Arena scope) {
        return ReleaseSequenceTypeInfo.ofAddress(ReleaseSequenceTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionEndProfiling)(struct OrtSession*,struct OrtAllocator*,char**);
     * }
     */
    public interface SessionEndProfiling {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(SessionEndProfiling fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$60.const$1, fi, constants$14.const$4, scope);
        }

        static SessionEndProfiling ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionEndProfiling$VH() {
        return constants$60.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionEndProfiling)(struct OrtSession*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionEndProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$60.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionEndProfiling)(struct OrtSession*,struct OrtAllocator*,char**);
     * }
     */
    public static void SessionEndProfiling$set(MemorySegment seg, MemorySegment x) {
        constants$60.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionEndProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$60.const$2.get(seg, index * sizeof());
    }

    public static void SessionEndProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        constants$60.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionEndProfiling SessionEndProfiling(MemorySegment segment, Arena scope) {
        return SessionEndProfiling.ofAddress(SessionEndProfiling$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetModelMetadata)(struct OrtSession*,struct OrtModelMetadata**);
     * }
     */
    public interface SessionGetModelMetadata {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionGetModelMetadata fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$60.const$3, fi, constants$15.const$2, scope);
        }

        static SessionGetModelMetadata ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetModelMetadata$VH() {
        return constants$60.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetModelMetadata)(struct OrtSession*,struct OrtModelMetadata**);
     * }
     */
    public static MemorySegment SessionGetModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$60.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetModelMetadata)(struct OrtSession*,struct OrtModelMetadata**);
     * }
     */
    public static void SessionGetModelMetadata$set(MemorySegment seg, MemorySegment x) {
        constants$60.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$60.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, long index, MemorySegment x) {
        constants$60.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetModelMetadata SessionGetModelMetadata(MemorySegment segment, Arena scope) {
        return SessionGetModelMetadata.ofAddress(SessionGetModelMetadata$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetProducerName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetProducerName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(ModelMetadataGetProducerName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$60.const$5, fi, constants$14.const$4, scope);
        }

        static ModelMetadataGetProducerName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetProducerName$VH() {
        return constants$61.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetProducerName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetProducerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$61.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetProducerName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetProducerName$set(MemorySegment seg, MemorySegment x) {
        constants$61.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetProducerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$61.const$0.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$61.const$0.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetProducerName ModelMetadataGetProducerName(MemorySegment segment, Arena scope) {
        return ModelMetadataGetProducerName.ofAddress(ModelMetadataGetProducerName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetGraphName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetGraphName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(ModelMetadataGetGraphName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$61.const$1, fi, constants$14.const$4, scope);
        }

        static ModelMetadataGetGraphName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetGraphName$VH() {
        return constants$61.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetGraphName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetGraphName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$61.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetGraphName)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetGraphName$set(MemorySegment seg, MemorySegment x) {
        constants$61.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetGraphName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$61.const$2.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$61.const$2.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetGraphName ModelMetadataGetGraphName(MemorySegment segment, Arena scope) {
        return ModelMetadataGetGraphName.ofAddress(ModelMetadataGetGraphName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetDomain)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetDomain {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(ModelMetadataGetDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$61.const$3, fi, constants$14.const$4, scope);
        }

        static ModelMetadataGetDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetDomain$VH() {
        return constants$61.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetDomain)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$61.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetDomain)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetDomain$set(MemorySegment seg, MemorySegment x) {
        constants$61.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$61.const$4.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$61.const$4.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetDomain ModelMetadataGetDomain(MemorySegment segment, Arena scope) {
        return ModelMetadataGetDomain.ofAddress(ModelMetadataGetDomain$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetDescription {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(ModelMetadataGetDescription fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$61.const$5, fi, constants$14.const$4, scope);
        }

        static ModelMetadataGetDescription ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetDescription$VH() {
        return constants$62.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$62.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetDescription$set(MemorySegment seg, MemorySegment x) {
        constants$62.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$62.const$0.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, long index, MemorySegment x) {
        constants$62.const$0.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetDescription ModelMetadataGetDescription(MemorySegment segment, Arena scope) {
        return ModelMetadataGetDescription.ofAddress(ModelMetadataGetDescription$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataLookupCustomMetadataMap)(struct OrtModelMetadata*,struct OrtAllocator*,char*,char**);
     * }
     */
    public interface ModelMetadataLookupCustomMetadataMap {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(ModelMetadataLookupCustomMetadataMap fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$62.const$1, fi, constants$20.const$1, scope);
        }

        static ModelMetadataLookupCustomMetadataMap ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataLookupCustomMetadataMap$VH() {
        return constants$62.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataLookupCustomMetadataMap)(struct OrtModelMetadata*,struct OrtAllocator*,char*,char**);
     * }
     */
    public static MemorySegment ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$62.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataLookupCustomMetadataMap)(struct OrtModelMetadata*,struct OrtAllocator*,char*,char**);
     * }
     */
    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, MemorySegment x) {
        constants$62.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$62.const$2.get(seg, index * sizeof());
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, long index, MemorySegment x) {
        constants$62.const$2.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap(
            MemorySegment segment, Arena scope) {
        return ModelMetadataLookupCustomMetadataMap.ofAddress(ModelMetadataLookupCustomMetadataMap$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetVersion)(struct OrtModelMetadata*,long long*);
     * }
     */
    public interface ModelMetadataGetVersion {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(ModelMetadataGetVersion fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$62.const$3, fi, constants$15.const$2, scope);
        }

        static ModelMetadataGetVersion ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetVersion$VH() {
        return constants$62.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetVersion)(struct OrtModelMetadata*,long long*);
     * }
     */
    public static MemorySegment ModelMetadataGetVersion$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$62.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetVersion)(struct OrtModelMetadata*,long long*);
     * }
     */
    public static void ModelMetadataGetVersion$set(MemorySegment seg, MemorySegment x) {
        constants$62.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetVersion$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$62.const$4.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, long index, MemorySegment x) {
        constants$62.const$4.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetVersion ModelMetadataGetVersion(MemorySegment segment, Arena scope) {
        return ModelMetadataGetVersion.ofAddress(ModelMetadataGetVersion$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseModelMetadata)(struct OrtModelMetadata*);
     * }
     */
    public interface ReleaseModelMetadata {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseModelMetadata fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$62.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseModelMetadata ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseModelMetadata$VH() {
        return constants$63.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseModelMetadata)(struct OrtModelMetadata*);
     * }
     */
    public static MemorySegment ReleaseModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$63.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseModelMetadata)(struct OrtModelMetadata*);
     * }
     */
    public static void ReleaseModelMetadata$set(MemorySegment seg, MemorySegment x) {
        constants$63.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$63.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, long index, MemorySegment x) {
        constants$63.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseModelMetadata ReleaseModelMetadata(MemorySegment segment, Arena scope) {
        return ReleaseModelMetadata.ofAddress(ReleaseModelMetadata$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithGlobalThreadPools)(enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
     * }
     */
    public interface CreateEnvWithGlobalThreadPools {

        java.lang.foreign.MemorySegment apply(
                int _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateEnvWithGlobalThreadPools fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$63.const$2, fi, constants$63.const$1, scope);
        }

        static CreateEnvWithGlobalThreadPools ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$63.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnvWithGlobalThreadPools$VH() {
        return constants$63.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithGlobalThreadPools)(enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$63.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithGlobalThreadPools)(enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
     * }
     */
    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, MemorySegment x) {
        constants$63.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnvWithGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$63.const$4.get(seg, index * sizeof());
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, long index, MemorySegment x) {
        constants$63.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateEnvWithGlobalThreadPools CreateEnvWithGlobalThreadPools(MemorySegment segment, Arena scope) {
        return CreateEnvWithGlobalThreadPools.ofAddress(CreateEnvWithGlobalThreadPools$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*DisablePerSessionThreads)(struct OrtSessionOptions*);
     * }
     */
    public interface DisablePerSessionThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisablePerSessionThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$63.const$5, fi, constants$1.const$4, scope);
        }

        static DisablePerSessionThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle DisablePerSessionThreads$VH() {
        return constants$64.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*DisablePerSessionThreads)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisablePerSessionThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$64.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*DisablePerSessionThreads)(struct OrtSessionOptions*);
     * }
     */
    public static void DisablePerSessionThreads$set(MemorySegment seg, MemorySegment x) {
        constants$64.const$0.set(seg, 0L, x);
    }

    public static MemorySegment DisablePerSessionThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$64.const$0.get(seg, index * sizeof());
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$64.const$0.set(seg, index * sizeof(), x);
    }

    public static DisablePerSessionThreads DisablePerSessionThreads(MemorySegment segment, Arena scope) {
        return DisablePerSessionThreads.ofAddress(DisablePerSessionThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateThreadingOptions)(struct OrtThreadingOptions**);
     * }
     */
    public interface CreateThreadingOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateThreadingOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$64.const$1, fi, constants$1.const$4, scope);
        }

        static CreateThreadingOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateThreadingOptions$VH() {
        return constants$64.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateThreadingOptions)(struct OrtThreadingOptions**);
     * }
     */
    public static MemorySegment CreateThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$64.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateThreadingOptions)(struct OrtThreadingOptions**);
     * }
     */
    public static void CreateThreadingOptions$set(MemorySegment seg, MemorySegment x) {
        constants$64.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$64.const$2.get(seg, index * sizeof());
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$64.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateThreadingOptions CreateThreadingOptions(MemorySegment segment, Arena scope) {
        return CreateThreadingOptions.ofAddress(CreateThreadingOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseThreadingOptions)(struct OrtThreadingOptions*);
     * }
     */
    public interface ReleaseThreadingOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseThreadingOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$64.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseThreadingOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseThreadingOptions$VH() {
        return constants$64.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseThreadingOptions)(struct OrtThreadingOptions*);
     * }
     */
    public static MemorySegment ReleaseThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$64.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseThreadingOptions)(struct OrtThreadingOptions*);
     * }
     */
    public static void ReleaseThreadingOptions$set(MemorySegment seg, MemorySegment x) {
        constants$64.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$64.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$64.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseThreadingOptions ReleaseThreadingOptions(MemorySegment segment, Arena scope) {
        return ReleaseThreadingOptions.ofAddress(ReleaseThreadingOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetCustomMetadataMapKeys)(struct OrtModelMetadata*,struct OrtAllocator*,char***,long long*);
     * }
     */
    public interface ModelMetadataGetCustomMetadataMapKeys {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(ModelMetadataGetCustomMetadataMapKeys fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$64.const$5, fi, constants$20.const$1, scope);
        }

        static ModelMetadataGetCustomMetadataMapKeys ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetCustomMetadataMapKeys$VH() {
        return constants$65.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetCustomMetadataMapKeys)(struct OrtModelMetadata*,struct OrtAllocator*,char***,long long*);
     * }
     */
    public static MemorySegment ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$65.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetCustomMetadataMapKeys)(struct OrtModelMetadata*,struct OrtAllocator*,char***,long long*);
     * }
     */
    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, MemorySegment x) {
        constants$65.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$65.const$0.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, long index, MemorySegment x) {
        constants$65.const$0.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys(
            MemorySegment segment, Arena scope) {
        return ModelMetadataGetCustomMetadataMapKeys.ofAddress(
                ModelMetadataGetCustomMetadataMapKeys$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddFreeDimensionOverrideByName)(struct OrtSessionOptions*,char*,long long);
     * }
     */
    public interface AddFreeDimensionOverrideByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverrideByName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$65.const$1, fi, constants$37.const$5, scope);
        }

        static AddFreeDimensionOverrideByName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddFreeDimensionOverrideByName$VH() {
        return constants$65.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddFreeDimensionOverrideByName)(struct OrtSessionOptions*,char*,long long);
     * }
     */
    public static MemorySegment AddFreeDimensionOverrideByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$65.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddFreeDimensionOverrideByName)(struct OrtSessionOptions*,char*,long long);
     * }
     */
    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, MemorySegment x) {
        constants$65.const$2.set(seg, 0L, x);
    }

    public static MemorySegment AddFreeDimensionOverrideByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$65.const$2.get(seg, index * sizeof());
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$65.const$2.set(seg, index * sizeof(), x);
    }

    public static AddFreeDimensionOverrideByName AddFreeDimensionOverrideByName(MemorySegment segment, Arena scope) {
        return AddFreeDimensionOverrideByName.ofAddress(AddFreeDimensionOverrideByName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetAvailableProviders)(char***,int*);
     * }
     */
    public interface GetAvailableProviders {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetAvailableProviders fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$65.const$3, fi, constants$15.const$2, scope);
        }

        static GetAvailableProviders ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetAvailableProviders$VH() {
        return constants$65.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetAvailableProviders)(char***,int*);
     * }
     */
    public static MemorySegment GetAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$65.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetAvailableProviders)(char***,int*);
     * }
     */
    public static void GetAvailableProviders$set(MemorySegment seg, MemorySegment x) {
        constants$65.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$65.const$4.get(seg, index * sizeof());
    }

    public static void GetAvailableProviders$set(MemorySegment seg, long index, MemorySegment x) {
        constants$65.const$4.set(seg, index * sizeof(), x);
    }

    public static GetAvailableProviders GetAvailableProviders(MemorySegment segment, Arena scope) {
        return GetAvailableProviders.ofAddress(GetAvailableProviders$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public interface ReleaseAvailableProviders {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(ReleaseAvailableProviders fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$65.const$5, fi, constants$23.const$1, scope);
        }

        static ReleaseAvailableProviders ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseAvailableProviders$VH() {
        return constants$66.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public static MemorySegment ReleaseAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$66.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public static void ReleaseAvailableProviders$set(MemorySegment seg, MemorySegment x) {
        constants$66.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$66.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, long index, MemorySegment x) {
        constants$66.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseAvailableProviders ReleaseAvailableProviders(MemorySegment segment, Arena scope) {
        return ReleaseAvailableProviders.ofAddress(ReleaseAvailableProviders$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorElementLength)(struct OrtValue*,unsigned long,unsigned long*);
     * }
     */
    public interface GetStringTensorElementLength {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetStringTensorElementLength fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$66.const$1, fi, constants$30.const$1, scope);
        }

        static GetStringTensorElementLength ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorElementLength$VH() {
        return constants$66.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorElementLength)(struct OrtValue*,unsigned long,unsigned long*);
     * }
     */
    public static MemorySegment GetStringTensorElementLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$66.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorElementLength)(struct OrtValue*,unsigned long,unsigned long*);
     * }
     */
    public static void GetStringTensorElementLength$set(MemorySegment seg, MemorySegment x) {
        constants$66.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorElementLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$66.const$2.get(seg, index * sizeof());
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, long index, MemorySegment x) {
        constants$66.const$2.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorElementLength GetStringTensorElementLength(MemorySegment segment, Arena scope) {
        return GetStringTensorElementLength.ofAddress(GetStringTensorElementLength$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorElement)(struct OrtValue*,unsigned long,unsigned long,void*);
     * }
     */
    public interface GetStringTensorElement {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, long _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetStringTensorElement fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$66.const$4, fi, constants$66.const$3, scope);
        }

        static GetStringTensorElement ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$66.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorElement$VH() {
        return constants$67.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorElement)(struct OrtValue*,unsigned long,unsigned long,void*);
     * }
     */
    public static MemorySegment GetStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$67.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetStringTensorElement)(struct OrtValue*,unsigned long,unsigned long,void*);
     * }
     */
    public static void GetStringTensorElement$set(MemorySegment seg, MemorySegment x) {
        constants$67.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$67.const$0.get(seg, index * sizeof());
    }

    public static void GetStringTensorElement$set(MemorySegment seg, long index, MemorySegment x) {
        constants$67.const$0.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorElement GetStringTensorElement(MemorySegment segment, Arena scope) {
        return GetStringTensorElement.ofAddress(GetStringTensorElement$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*FillStringTensorElement)(struct OrtValue*,char*,unsigned long);
     * }
     */
    public interface FillStringTensorElement {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(FillStringTensorElement fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$67.const$1, fi, constants$37.const$5, scope);
        }

        static FillStringTensorElement ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillStringTensorElement$VH() {
        return constants$67.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*FillStringTensorElement)(struct OrtValue*,char*,unsigned long);
     * }
     */
    public static MemorySegment FillStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$67.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*FillStringTensorElement)(struct OrtValue*,char*,unsigned long);
     * }
     */
    public static void FillStringTensorElement$set(MemorySegment seg, MemorySegment x) {
        constants$67.const$2.set(seg, 0L, x);
    }

    public static MemorySegment FillStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$67.const$2.get(seg, index * sizeof());
    }

    public static void FillStringTensorElement$set(MemorySegment seg, long index, MemorySegment x) {
        constants$67.const$2.set(seg, index * sizeof(), x);
    }

    public static FillStringTensorElement FillStringTensorElement(MemorySegment segment, Arena scope) {
        return FillStringTensorElement.ofAddress(FillStringTensorElement$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddSessionConfigEntry)(struct OrtSessionOptions*,char*,char*);
     * }
     */
    public interface AddSessionConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(AddSessionConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$67.const$3, fi, constants$14.const$4, scope);
        }

        static AddSessionConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddSessionConfigEntry$VH() {
        return constants$67.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddSessionConfigEntry)(struct OrtSessionOptions*,char*,char*);
     * }
     */
    public static MemorySegment AddSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$67.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddSessionConfigEntry)(struct OrtSessionOptions*,char*,char*);
     * }
     */
    public static void AddSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$67.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AddSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$67.const$4.get(seg, index * sizeof());
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$67.const$4.set(seg, index * sizeof(), x);
    }

    public static AddSessionConfigEntry AddSessionConfigEntry(MemorySegment segment, Arena scope) {
        return AddSessionConfigEntry.ofAddress(AddSessionConfigEntry$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateAllocator)(struct OrtSession*,struct OrtMemoryInfo*,struct OrtAllocator**);
     * }
     */
    public interface CreateAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(CreateAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$67.const$5, fi, constants$14.const$4, scope);
        }

        static CreateAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateAllocator$VH() {
        return constants$68.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateAllocator)(struct OrtSession*,struct OrtMemoryInfo*,struct OrtAllocator**);
     * }
     */
    public static MemorySegment CreateAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$68.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateAllocator)(struct OrtSession*,struct OrtMemoryInfo*,struct OrtAllocator**);
     * }
     */
    public static void CreateAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$68.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$68.const$0.get(seg, index * sizeof());
    }

    public static void CreateAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$68.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateAllocator CreateAllocator(MemorySegment segment, Arena scope) {
        return CreateAllocator.ofAddress(CreateAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseAllocator)(struct OrtAllocator*);
     * }
     */
    public interface ReleaseAllocator {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$68.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseAllocator$VH() {
        return constants$68.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseAllocator)(struct OrtAllocator*);
     * }
     */
    public static MemorySegment ReleaseAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$68.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseAllocator)(struct OrtAllocator*);
     * }
     */
    public static void ReleaseAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$68.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$68.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$68.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseAllocator ReleaseAllocator(MemorySegment segment, Arena scope) {
        return ReleaseAllocator.ofAddress(ReleaseAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunWithBinding)(struct OrtSession*,struct OrtRunOptions*,struct OrtIoBinding*);
     * }
     */
    public interface RunWithBinding {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(RunWithBinding fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$68.const$3, fi, constants$14.const$4, scope);
        }

        static RunWithBinding ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunWithBinding$VH() {
        return constants$68.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunWithBinding)(struct OrtSession*,struct OrtRunOptions*,struct OrtIoBinding*);
     * }
     */
    public static MemorySegment RunWithBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$68.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunWithBinding)(struct OrtSession*,struct OrtRunOptions*,struct OrtIoBinding*);
     * }
     */
    public static void RunWithBinding$set(MemorySegment seg, MemorySegment x) {
        constants$68.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunWithBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$68.const$4.get(seg, index * sizeof());
    }

    public static void RunWithBinding$set(MemorySegment seg, long index, MemorySegment x) {
        constants$68.const$4.set(seg, index * sizeof(), x);
    }

    public static RunWithBinding RunWithBinding(MemorySegment segment, Arena scope) {
        return RunWithBinding.ofAddress(RunWithBinding$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateIoBinding)(struct OrtSession*,struct OrtIoBinding**);
     * }
     */
    public interface CreateIoBinding {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CreateIoBinding fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$68.const$5, fi, constants$15.const$2, scope);
        }

        static CreateIoBinding ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateIoBinding$VH() {
        return constants$69.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateIoBinding)(struct OrtSession*,struct OrtIoBinding**);
     * }
     */
    public static MemorySegment CreateIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$69.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateIoBinding)(struct OrtSession*,struct OrtIoBinding**);
     * }
     */
    public static void CreateIoBinding$set(MemorySegment seg, MemorySegment x) {
        constants$69.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$69.const$0.get(seg, index * sizeof());
    }

    public static void CreateIoBinding$set(MemorySegment seg, long index, MemorySegment x) {
        constants$69.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateIoBinding CreateIoBinding(MemorySegment segment, Arena scope) {
        return CreateIoBinding.ofAddress(CreateIoBinding$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseIoBinding)(struct OrtIoBinding*);
     * }
     */
    public interface ReleaseIoBinding {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseIoBinding fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$69.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseIoBinding ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseIoBinding$VH() {
        return constants$69.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseIoBinding)(struct OrtIoBinding*);
     * }
     */
    public static MemorySegment ReleaseIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$69.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseIoBinding)(struct OrtIoBinding*);
     * }
     */
    public static void ReleaseIoBinding$set(MemorySegment seg, MemorySegment x) {
        constants$69.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$69.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, long index, MemorySegment x) {
        constants$69.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseIoBinding ReleaseIoBinding(MemorySegment segment, Arena scope) {
        return ReleaseIoBinding.ofAddress(ReleaseIoBinding$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*BindInput)(struct OrtIoBinding*,char*,struct OrtValue*);
     * }
     */
    public interface BindInput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(BindInput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$69.const$3, fi, constants$14.const$4, scope);
        }

        static BindInput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle BindInput$VH() {
        return constants$69.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*BindInput)(struct OrtIoBinding*,char*,struct OrtValue*);
     * }
     */
    public static MemorySegment BindInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$69.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*BindInput)(struct OrtIoBinding*,char*,struct OrtValue*);
     * }
     */
    public static void BindInput$set(MemorySegment seg, MemorySegment x) {
        constants$69.const$4.set(seg, 0L, x);
    }

    public static MemorySegment BindInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$69.const$4.get(seg, index * sizeof());
    }

    public static void BindInput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$69.const$4.set(seg, index * sizeof(), x);
    }

    public static BindInput BindInput(MemorySegment segment, Arena scope) {
        return BindInput.ofAddress(BindInput$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*BindOutput)(struct OrtIoBinding*,char*,struct OrtValue*);
     * }
     */
    public interface BindOutput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(BindOutput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$69.const$5, fi, constants$14.const$4, scope);
        }

        static BindOutput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle BindOutput$VH() {
        return constants$70.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*BindOutput)(struct OrtIoBinding*,char*,struct OrtValue*);
     * }
     */
    public static MemorySegment BindOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$70.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*BindOutput)(struct OrtIoBinding*,char*,struct OrtValue*);
     * }
     */
    public static void BindOutput$set(MemorySegment seg, MemorySegment x) {
        constants$70.const$0.set(seg, 0L, x);
    }

    public static MemorySegment BindOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$70.const$0.get(seg, index * sizeof());
    }

    public static void BindOutput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$70.const$0.set(seg, index * sizeof(), x);
    }

    public static BindOutput BindOutput(MemorySegment segment, Arena scope) {
        return BindOutput.ofAddress(BindOutput$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*BindOutputToDevice)(struct OrtIoBinding*,char*,struct OrtMemoryInfo*);
     * }
     */
    public interface BindOutputToDevice {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(BindOutputToDevice fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$70.const$1, fi, constants$14.const$4, scope);
        }

        static BindOutputToDevice ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle BindOutputToDevice$VH() {
        return constants$70.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*BindOutputToDevice)(struct OrtIoBinding*,char*,struct OrtMemoryInfo*);
     * }
     */
    public static MemorySegment BindOutputToDevice$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$70.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*BindOutputToDevice)(struct OrtIoBinding*,char*,struct OrtMemoryInfo*);
     * }
     */
    public static void BindOutputToDevice$set(MemorySegment seg, MemorySegment x) {
        constants$70.const$2.set(seg, 0L, x);
    }

    public static MemorySegment BindOutputToDevice$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$70.const$2.get(seg, index * sizeof());
    }

    public static void BindOutputToDevice$set(MemorySegment seg, long index, MemorySegment x) {
        constants$70.const$2.set(seg, index * sizeof(), x);
    }

    public static BindOutputToDevice BindOutputToDevice(MemorySegment segment, Arena scope) {
        return BindOutputToDevice.ofAddress(BindOutputToDevice$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetBoundOutputNames)(struct OrtIoBinding*,struct OrtAllocator*,char**,unsigned long**,unsigned long*);
     * }
     */
    public interface GetBoundOutputNames {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(GetBoundOutputNames fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$70.const$4, fi, constants$70.const$3, scope);
        }

        static GetBoundOutputNames ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$70.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetBoundOutputNames$VH() {
        return constants$71.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetBoundOutputNames)(struct OrtIoBinding*,struct OrtAllocator*,char**,unsigned long**,unsigned long*);
     * }
     */
    public static MemorySegment GetBoundOutputNames$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$71.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetBoundOutputNames)(struct OrtIoBinding*,struct OrtAllocator*,char**,unsigned long**,unsigned long*);
     * }
     */
    public static void GetBoundOutputNames$set(MemorySegment seg, MemorySegment x) {
        constants$71.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetBoundOutputNames$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$71.const$0.get(seg, index * sizeof());
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, long index, MemorySegment x) {
        constants$71.const$0.set(seg, index * sizeof(), x);
    }

    public static GetBoundOutputNames GetBoundOutputNames(MemorySegment segment, Arena scope) {
        return GetBoundOutputNames.ofAddress(GetBoundOutputNames$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetBoundOutputValues)(struct OrtIoBinding*,struct OrtAllocator*,struct OrtValue***,unsigned long*);
     * }
     */
    public interface GetBoundOutputValues {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetBoundOutputValues fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$71.const$1, fi, constants$20.const$1, scope);
        }

        static GetBoundOutputValues ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetBoundOutputValues$VH() {
        return constants$71.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetBoundOutputValues)(struct OrtIoBinding*,struct OrtAllocator*,struct OrtValue***,unsigned long*);
     * }
     */
    public static MemorySegment GetBoundOutputValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$71.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetBoundOutputValues)(struct OrtIoBinding*,struct OrtAllocator*,struct OrtValue***,unsigned long*);
     * }
     */
    public static void GetBoundOutputValues$set(MemorySegment seg, MemorySegment x) {
        constants$71.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetBoundOutputValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$71.const$2.get(seg, index * sizeof());
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, long index, MemorySegment x) {
        constants$71.const$2.set(seg, index * sizeof(), x);
    }

    public static GetBoundOutputValues GetBoundOutputValues(MemorySegment segment, Arena scope) {
        return GetBoundOutputValues.ofAddress(GetBoundOutputValues$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ClearBoundInputs)(struct OrtIoBinding*);
     * }
     */
    public interface ClearBoundInputs {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ClearBoundInputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$71.const$3, fi, constants$13.const$5, scope);
        }

        static ClearBoundInputs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ClearBoundInputs$VH() {
        return constants$71.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ClearBoundInputs)(struct OrtIoBinding*);
     * }
     */
    public static MemorySegment ClearBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$71.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ClearBoundInputs)(struct OrtIoBinding*);
     * }
     */
    public static void ClearBoundInputs$set(MemorySegment seg, MemorySegment x) {
        constants$71.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ClearBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$71.const$4.get(seg, index * sizeof());
    }

    public static void ClearBoundInputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$71.const$4.set(seg, index * sizeof(), x);
    }

    public static ClearBoundInputs ClearBoundInputs(MemorySegment segment, Arena scope) {
        return ClearBoundInputs.ofAddress(ClearBoundInputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ClearBoundOutputs)(struct OrtIoBinding*);
     * }
     */
    public interface ClearBoundOutputs {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ClearBoundOutputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$71.const$5, fi, constants$13.const$5, scope);
        }

        static ClearBoundOutputs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ClearBoundOutputs$VH() {
        return constants$72.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ClearBoundOutputs)(struct OrtIoBinding*);
     * }
     */
    public static MemorySegment ClearBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$72.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ClearBoundOutputs)(struct OrtIoBinding*);
     * }
     */
    public static void ClearBoundOutputs$set(MemorySegment seg, MemorySegment x) {
        constants$72.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ClearBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$72.const$0.get(seg, index * sizeof());
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$72.const$0.set(seg, index * sizeof(), x);
    }

    public static ClearBoundOutputs ClearBoundOutputs(MemorySegment segment, Arena scope) {
        return ClearBoundOutputs.ofAddress(ClearBoundOutputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*TensorAt)(struct OrtValue*,long long*,unsigned long,void**);
     * }
     */
    public interface TensorAt {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(TensorAt fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$72.const$2, fi, constants$72.const$1, scope);
        }

        static TensorAt ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$72.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle TensorAt$VH() {
        return constants$72.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*TensorAt)(struct OrtValue*,long long*,unsigned long,void**);
     * }
     */
    public static MemorySegment TensorAt$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$72.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*TensorAt)(struct OrtValue*,long long*,unsigned long,void**);
     * }
     */
    public static void TensorAt$set(MemorySegment seg, MemorySegment x) {
        constants$72.const$4.set(seg, 0L, x);
    }

    public static MemorySegment TensorAt$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$72.const$4.get(seg, index * sizeof());
    }

    public static void TensorAt$set(MemorySegment seg, long index, MemorySegment x) {
        constants$72.const$4.set(seg, index * sizeof(), x);
    }

    public static TensorAt TensorAt(MemorySegment segment, Arena scope) {
        return TensorAt.ofAddress(TensorAt$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateAndRegisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*,struct OrtArenaCfg*);
     * }
     */
    public interface CreateAndRegisterAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(CreateAndRegisterAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$72.const$5, fi, constants$14.const$4, scope);
        }

        static CreateAndRegisterAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateAndRegisterAllocator$VH() {
        return constants$73.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateAndRegisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*,struct OrtArenaCfg*);
     * }
     */
    public static MemorySegment CreateAndRegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$73.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateAndRegisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*,struct OrtArenaCfg*);
     * }
     */
    public static void CreateAndRegisterAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$73.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateAndRegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$73.const$0.get(seg, index * sizeof());
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$73.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateAndRegisterAllocator CreateAndRegisterAllocator(MemorySegment segment, Arena scope) {
        return CreateAndRegisterAllocator.ofAddress(CreateAndRegisterAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetLanguageProjection)(struct OrtEnv*,enum OrtLanguageProjection);
     * }
     */
    public interface SetLanguageProjection {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetLanguageProjection fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$73.const$1, fi, constants$23.const$1, scope);
        }

        static SetLanguageProjection ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetLanguageProjection$VH() {
        return constants$73.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetLanguageProjection)(struct OrtEnv*,enum OrtLanguageProjection);
     * }
     */
    public static MemorySegment SetLanguageProjection$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$73.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetLanguageProjection)(struct OrtEnv*,enum OrtLanguageProjection);
     * }
     */
    public static void SetLanguageProjection$set(MemorySegment seg, MemorySegment x) {
        constants$73.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetLanguageProjection$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$73.const$2.get(seg, index * sizeof());
    }

    public static void SetLanguageProjection$set(MemorySegment seg, long index, MemorySegment x) {
        constants$73.const$2.set(seg, index * sizeof(), x);
    }

    public static SetLanguageProjection SetLanguageProjection(MemorySegment segment, Arena scope) {
        return SetLanguageProjection.ofAddress(SetLanguageProjection$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionGetProfilingStartTimeNs)(struct OrtSession*,unsigned long long*);
     * }
     */
    public interface SessionGetProfilingStartTimeNs {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionGetProfilingStartTimeNs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$73.const$3, fi, constants$15.const$2, scope);
        }

        static SessionGetProfilingStartTimeNs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetProfilingStartTimeNs$VH() {
        return constants$73.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetProfilingStartTimeNs)(struct OrtSession*,unsigned long long*);
     * }
     */
    public static MemorySegment SessionGetProfilingStartTimeNs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$73.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionGetProfilingStartTimeNs)(struct OrtSession*,unsigned long long*);
     * }
     */
    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, MemorySegment x) {
        constants$73.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetProfilingStartTimeNs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$73.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$73.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs(MemorySegment segment, Arena scope) {
        return SessionGetProfilingStartTimeNs.ofAddress(SessionGetProfilingStartTimeNs$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalIntraOpNumThreads)(struct OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalIntraOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalIntraOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$73.const$5, fi, constants$23.const$1, scope);
        }

        static SetGlobalIntraOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalIntraOpNumThreads$VH() {
        return constants$74.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalIntraOpNumThreads)(struct OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$74.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalIntraOpNumThreads)(struct OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$74.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$74.const$0.get(seg, index * sizeof());
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$74.const$0.set(seg, index * sizeof(), x);
    }

    public static SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads(MemorySegment segment, Arena scope) {
        return SetGlobalIntraOpNumThreads.ofAddress(SetGlobalIntraOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalInterOpNumThreads)(struct OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalInterOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalInterOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$74.const$1, fi, constants$23.const$1, scope);
        }

        static SetGlobalInterOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalInterOpNumThreads$VH() {
        return constants$74.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalInterOpNumThreads)(struct OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$74.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalInterOpNumThreads)(struct OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$74.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$74.const$2.get(seg, index * sizeof());
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$74.const$2.set(seg, index * sizeof(), x);
    }

    public static SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads(MemorySegment segment, Arena scope) {
        return SetGlobalInterOpNumThreads.ofAddress(SetGlobalInterOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalSpinControl)(struct OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalSpinControl {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalSpinControl fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$74.const$3, fi, constants$23.const$1, scope);
        }

        static SetGlobalSpinControl ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalSpinControl$VH() {
        return constants$74.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalSpinControl)(struct OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalSpinControl$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$74.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalSpinControl)(struct OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalSpinControl$set(MemorySegment seg, MemorySegment x) {
        constants$74.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalSpinControl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$74.const$4.get(seg, index * sizeof());
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, long index, MemorySegment x) {
        constants$74.const$4.set(seg, index * sizeof(), x);
    }

    public static SetGlobalSpinControl SetGlobalSpinControl(MemorySegment segment, Arena scope) {
        return SetGlobalSpinControl.ofAddress(SetGlobalSpinControl$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddInitializer)(struct OrtSessionOptions*,char*,struct OrtValue*);
     * }
     */
    public interface AddInitializer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(AddInitializer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$74.const$5, fi, constants$14.const$4, scope);
        }

        static AddInitializer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddInitializer$VH() {
        return constants$75.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddInitializer)(struct OrtSessionOptions*,char*,struct OrtValue*);
     * }
     */
    public static MemorySegment AddInitializer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$75.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddInitializer)(struct OrtSessionOptions*,char*,struct OrtValue*);
     * }
     */
    public static void AddInitializer$set(MemorySegment seg, MemorySegment x) {
        constants$75.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AddInitializer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$75.const$0.get(seg, index * sizeof());
    }

    public static void AddInitializer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$75.const$0.set(seg, index * sizeof(), x);
    }

    public static AddInitializer AddInitializer(MemorySegment segment, Arena scope) {
        return AddInitializer.ofAddress(AddInitializer$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
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

        static MemorySegment allocate(CreateEnvWithCustomLoggerAndGlobalThreadPools fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$75.const$2, fi, constants$75.const$1, scope);
        }

        static CreateEnvWithCustomLoggerAndGlobalThreadPools ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$75.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$VH() {
        return constants$75.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$75.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(void (*)(void*,enum OrtLoggingLevel,char*,char*,char*,char*),void*,enum OrtLoggingLevel,char*,struct OrtThreadingOptions*,struct OrtEnv**);
     * }
     */
    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(MemorySegment seg, MemorySegment x) {
        constants$75.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$75.const$4.get(seg, index * sizeof());
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$75.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools(
            MemorySegment segment, Arena scope) {
        return CreateEnvWithCustomLoggerAndGlobalThreadPools.ofAddress(
                CreateEnvWithCustomLoggerAndGlobalThreadPools$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA)(struct OrtSessionOptions*,struct OrtCUDAProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CUDA {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$75.const$5, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA$VH() {
        return constants$76.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA)(struct OrtSessionOptions*,struct OrtCUDAProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$76.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA)(struct OrtSessionOptions*,struct OrtCUDAProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, MemorySegment x) {
        constants$76.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$76.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, long index, MemorySegment x) {
        constants$76.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA SessionOptionsAppendExecutionProvider_CUDA(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_CUDA.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_ROCM)(struct OrtSessionOptions*,struct OrtROCMProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_ROCM {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_ROCM fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$76.const$1, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_ROCM ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_ROCM$VH() {
        return constants$76.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_ROCM)(struct OrtSessionOptions*,struct OrtROCMProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$76.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_ROCM)(struct OrtSessionOptions*,struct OrtROCMProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, MemorySegment x) {
        constants$76.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$76.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, long index, MemorySegment x) {
        constants$76.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_ROCM.ofAddress(
                SessionOptionsAppendExecutionProvider_ROCM$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_OpenVINO)(struct OrtSessionOptions*,struct OrtOpenVINOProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_OpenVINO {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_OpenVINO fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$76.const$3, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_OpenVINO$VH() {
        return constants$76.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_OpenVINO)(struct OrtSessionOptions*,struct OrtOpenVINOProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$76.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_OpenVINO)(struct OrtSessionOptions*,struct OrtOpenVINOProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(MemorySegment seg, MemorySegment x) {
        constants$76.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$76.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$76.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_OpenVINO.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalDenormalAsZero)(struct OrtThreadingOptions*);
     * }
     */
    public interface SetGlobalDenormalAsZero {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SetGlobalDenormalAsZero fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$76.const$5, fi, constants$1.const$4, scope);
        }

        static SetGlobalDenormalAsZero ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalDenormalAsZero$VH() {
        return constants$77.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalDenormalAsZero)(struct OrtThreadingOptions*);
     * }
     */
    public static MemorySegment SetGlobalDenormalAsZero$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$77.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalDenormalAsZero)(struct OrtThreadingOptions*);
     * }
     */
    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, MemorySegment x) {
        constants$77.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalDenormalAsZero$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$77.const$0.get(seg, index * sizeof());
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, long index, MemorySegment x) {
        constants$77.const$0.set(seg, index * sizeof(), x);
    }

    public static SetGlobalDenormalAsZero SetGlobalDenormalAsZero(MemorySegment segment, Arena scope) {
        return SetGlobalDenormalAsZero.ofAddress(SetGlobalDenormalAsZero$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateArenaCfg)(unsigned long,int,int,int,struct OrtArenaCfg**);
     * }
     */
    public interface CreateArenaCfg {

        java.lang.foreign.MemorySegment apply(long _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateArenaCfg fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$77.const$2, fi, constants$77.const$1, scope);
        }

        static CreateArenaCfg ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (long __x0, int __x1, int __x2, int __x3, java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$77.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateArenaCfg$VH() {
        return constants$77.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateArenaCfg)(unsigned long,int,int,int,struct OrtArenaCfg**);
     * }
     */
    public static MemorySegment CreateArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$77.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateArenaCfg)(unsigned long,int,int,int,struct OrtArenaCfg**);
     * }
     */
    public static void CreateArenaCfg$set(MemorySegment seg, MemorySegment x) {
        constants$77.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$77.const$4.get(seg, index * sizeof());
    }

    public static void CreateArenaCfg$set(MemorySegment seg, long index, MemorySegment x) {
        constants$77.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateArenaCfg CreateArenaCfg(MemorySegment segment, Arena scope) {
        return CreateArenaCfg.ofAddress(CreateArenaCfg$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseArenaCfg)(struct OrtArenaCfg*);
     * }
     */
    public interface ReleaseArenaCfg {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseArenaCfg fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$77.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseArenaCfg ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseArenaCfg$VH() {
        return constants$78.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseArenaCfg)(struct OrtArenaCfg*);
     * }
     */
    public static MemorySegment ReleaseArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$78.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseArenaCfg)(struct OrtArenaCfg*);
     * }
     */
    public static void ReleaseArenaCfg$set(MemorySegment seg, MemorySegment x) {
        constants$78.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$78.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, long index, MemorySegment x) {
        constants$78.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseArenaCfg ReleaseArenaCfg(MemorySegment segment, Arena scope) {
        return ReleaseArenaCfg.ofAddress(ReleaseArenaCfg$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetGraphDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public interface ModelMetadataGetGraphDescription {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(ModelMetadataGetGraphDescription fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$78.const$1, fi, constants$14.const$4, scope);
        }

        static ModelMetadataGetGraphDescription ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetGraphDescription$VH() {
        return constants$78.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetGraphDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetGraphDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$78.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*ModelMetadataGetGraphDescription)(struct OrtModelMetadata*,struct OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, MemorySegment x) {
        constants$78.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetGraphDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$78.const$2.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, long index, MemorySegment x) {
        constants$78.const$2.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription(
            MemorySegment segment, Arena scope) {
        return ModelMetadataGetGraphDescription.ofAddress(ModelMetadataGetGraphDescription$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_TensorRT {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$78.const$3, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT$VH() {
        return constants$78.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$78.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(MemorySegment seg, MemorySegment x) {
        constants$78.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$78.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$78.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT SessionOptionsAppendExecutionProvider_TensorRT(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_TensorRT.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public interface SetCurrentGpuDeviceId {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(SetCurrentGpuDeviceId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$78.const$5, fi, constants$12.const$2, scope);
        }

        static SetCurrentGpuDeviceId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$12.const$4.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetCurrentGpuDeviceId$VH() {
        return constants$79.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public static MemorySegment SetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$79.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, MemorySegment x) {
        constants$79.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$79.const$0.get(seg, index * sizeof());
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$79.const$0.set(seg, index * sizeof(), x);
    }

    public static SetCurrentGpuDeviceId SetCurrentGpuDeviceId(MemorySegment segment, Arena scope) {
        return SetCurrentGpuDeviceId.ofAddress(SetCurrentGpuDeviceId$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public interface GetCurrentGpuDeviceId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetCurrentGpuDeviceId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$79.const$1, fi, constants$1.const$4, scope);
        }

        static GetCurrentGpuDeviceId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCurrentGpuDeviceId$VH() {
        return constants$79.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public static MemorySegment GetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$79.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, MemorySegment x) {
        constants$79.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$79.const$2.get(seg, index * sizeof());
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$79.const$2.set(seg, index * sizeof(), x);
    }

    public static GetCurrentGpuDeviceId GetCurrentGpuDeviceId(MemorySegment segment, Arena scope) {
        return GetCurrentGpuDeviceId.ofAddress(GetCurrentGpuDeviceId$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttributeArray_float)(struct OrtKernelInfo*,char*,float*,unsigned long*);
     * }
     */
    public interface KernelInfoGetAttributeArray_float {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttributeArray_float fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$79.const$3, fi, constants$20.const$1, scope);
        }

        static KernelInfoGetAttributeArray_float ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttributeArray_float$VH() {
        return constants$79.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttributeArray_float)(struct OrtKernelInfo*,char*,float*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfoGetAttributeArray_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$79.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttributeArray_float)(struct OrtKernelInfo*,char*,float*,unsigned long*);
     * }
     */
    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, MemorySegment x) {
        constants$79.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttributeArray_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$79.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, long index, MemorySegment x) {
        constants$79.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttributeArray_float KernelInfoGetAttributeArray_float(
            MemorySegment segment, Arena scope) {
        return KernelInfoGetAttributeArray_float.ofAddress(KernelInfoGetAttributeArray_float$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttributeArray_int64)(struct OrtKernelInfo*,char*,long long*,unsigned long*);
     * }
     */
    public interface KernelInfoGetAttributeArray_int64 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttributeArray_int64 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$79.const$5, fi, constants$20.const$1, scope);
        }

        static KernelInfoGetAttributeArray_int64 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttributeArray_int64$VH() {
        return constants$80.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttributeArray_int64)(struct OrtKernelInfo*,char*,long long*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfoGetAttributeArray_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$80.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttributeArray_int64)(struct OrtKernelInfo*,char*,long long*,unsigned long*);
     * }
     */
    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, MemorySegment x) {
        constants$80.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttributeArray_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$80.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, long index, MemorySegment x) {
        constants$80.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttributeArray_int64 KernelInfoGetAttributeArray_int64(
            MemorySegment segment, Arena scope) {
        return KernelInfoGetAttributeArray_int64.ofAddress(KernelInfoGetAttributeArray_int64$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateArenaCfgV2)(char**,unsigned long*,unsigned long,struct OrtArenaCfg**);
     * }
     */
    public interface CreateArenaCfgV2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateArenaCfgV2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$80.const$1, fi, constants$72.const$1, scope);
        }

        static CreateArenaCfgV2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$72.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateArenaCfgV2$VH() {
        return constants$80.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateArenaCfgV2)(char**,unsigned long*,unsigned long,struct OrtArenaCfg**);
     * }
     */
    public static MemorySegment CreateArenaCfgV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$80.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateArenaCfgV2)(char**,unsigned long*,unsigned long,struct OrtArenaCfg**);
     * }
     */
    public static void CreateArenaCfgV2$set(MemorySegment seg, MemorySegment x) {
        constants$80.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateArenaCfgV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$80.const$2.get(seg, index * sizeof());
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$80.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateArenaCfgV2 CreateArenaCfgV2(MemorySegment segment, Arena scope) {
        return CreateArenaCfgV2.ofAddress(CreateArenaCfgV2$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddRunConfigEntry)(struct OrtRunOptions*,char*,char*);
     * }
     */
    public interface AddRunConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(AddRunConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$80.const$3, fi, constants$14.const$4, scope);
        }

        static AddRunConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddRunConfigEntry$VH() {
        return constants$80.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddRunConfigEntry)(struct OrtRunOptions*,char*,char*);
     * }
     */
    public static MemorySegment AddRunConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$80.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddRunConfigEntry)(struct OrtRunOptions*,char*,char*);
     * }
     */
    public static void AddRunConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$80.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AddRunConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$80.const$4.get(seg, index * sizeof());
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$80.const$4.set(seg, index * sizeof(), x);
    }

    public static AddRunConfigEntry AddRunConfigEntry(MemorySegment segment, Arena scope) {
        return AddRunConfigEntry.ofAddress(AddRunConfigEntry$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreatePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer**);
     * }
     */
    public interface CreatePrepackedWeightsContainer {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreatePrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$80.const$5, fi, constants$1.const$4, scope);
        }

        static CreatePrepackedWeightsContainer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreatePrepackedWeightsContainer$VH() {
        return constants$81.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreatePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer**);
     * }
     */
    public static MemorySegment CreatePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$81.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreatePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer**);
     * }
     */
    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$81.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreatePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$81.const$0.get(seg, index * sizeof());
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$81.const$0.set(seg, index * sizeof(), x);
    }

    public static CreatePrepackedWeightsContainer CreatePrepackedWeightsContainer(MemorySegment segment, Arena scope) {
        return CreatePrepackedWeightsContainer.ofAddress(CreatePrepackedWeightsContainer$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer*);
     * }
     */
    public interface ReleasePrepackedWeightsContainer {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleasePrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$81.const$1, fi, constants$13.const$5, scope);
        }

        static ReleasePrepackedWeightsContainer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleasePrepackedWeightsContainer$VH() {
        return constants$81.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer*);
     * }
     */
    public static MemorySegment ReleasePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$81.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(struct OrtPrepackedWeightsContainer*);
     * }
     */
    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$81.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleasePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$81.const$2.get(seg, index * sizeof());
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$81.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleasePrepackedWeightsContainer ReleasePrepackedWeightsContainer(
            MemorySegment segment, Arena scope) {
        return ReleasePrepackedWeightsContainer.ofAddress(ReleasePrepackedWeightsContainer$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSessionWithPrepackedWeightsContainer)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
     * }
     */
    public interface CreateSessionWithPrepackedWeightsContainer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateSessionWithPrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$81.const$3, fi, constants$70.const$3, scope);
        }

        static CreateSessionWithPrepackedWeightsContainer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$70.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionWithPrepackedWeightsContainer$VH() {
        return constants$81.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionWithPrepackedWeightsContainer)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$81.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionWithPrepackedWeightsContainer)(struct OrtEnv*,char*,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
     * }
     */
    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$81.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$81.const$4.get(seg, index * sizeof());
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$81.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateSessionWithPrepackedWeightsContainer CreateSessionWithPrepackedWeightsContainer(
            MemorySegment segment, Arena scope) {
        return CreateSessionWithPrepackedWeightsContainer.ofAddress(
                CreateSessionWithPrepackedWeightsContainer$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSessionFromArrayWithPrepackedWeightsContainer)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
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

        static MemorySegment allocate(CreateSessionFromArrayWithPrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$82.const$0, fi, constants$81.const$5, scope);
        }

        static CreateSessionFromArrayWithPrepackedWeightsContainer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$82.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionFromArrayWithPrepackedWeightsContainer$VH() {
        return constants$82.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionFromArrayWithPrepackedWeightsContainer)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$82.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSessionFromArrayWithPrepackedWeightsContainer)(struct OrtEnv*,void*,unsigned long,struct OrtSessionOptions*,struct OrtPrepackedWeightsContainer*,struct OrtSession**);
     * }
     */
    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$82.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$82.const$2.get(seg, index * sizeof());
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$82.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateSessionFromArrayWithPrepackedWeightsContainer
            CreateSessionFromArrayWithPrepackedWeightsContainer(MemorySegment segment, Arena scope) {
        return CreateSessionFromArrayWithPrepackedWeightsContainer.ofAddress(
                CreateSessionFromArrayWithPrepackedWeightsContainer$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptionsV2*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_TensorRT_V2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$82.const$3, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$VH() {
        return constants$82.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$82.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(struct OrtSessionOptions*,struct OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(MemorySegment seg, MemorySegment x) {
        constants$82.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$82.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$82.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_TensorRT_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT_V2$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2**);
     * }
     */
    public interface CreateTensorRTProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateTensorRTProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$82.const$5, fi, constants$1.const$4, scope);
        }

        static CreateTensorRTProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateTensorRTProviderOptions$VH() {
        return constants$83.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2**);
     * }
     */
    public static MemorySegment CreateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$83.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2**);
     * }
     */
    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$83.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$83.const$0.get(seg, index * sizeof());
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$83.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateTensorRTProviderOptions CreateTensorRTProviderOptions(MemorySegment segment, Arena scope) {
        return CreateTensorRTProviderOptions.ofAddress(CreateTensorRTProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*,char**,char**,unsigned long);
     * }
     */
    public interface UpdateTensorRTProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateTensorRTProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$83.const$2, fi, constants$83.const$1, scope);
        }

        static UpdateTensorRTProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateTensorRTProviderOptions$VH() {
        return constants$83.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment UpdateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$83.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*,char**,char**,unsigned long);
     * }
     */
    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$83.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UpdateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$83.const$4.get(seg, index * sizeof());
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$83.const$4.set(seg, index * sizeof(), x);
    }

    public static UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateTensorRTProviderOptions.ofAddress(UpdateTensorRTProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorRTProviderOptionsAsString)(struct OrtTensorRTProviderOptionsV2*,struct OrtAllocator*,char**);
     * }
     */
    public interface GetTensorRTProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetTensorRTProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$83.const$5, fi, constants$14.const$4, scope);
        }

        static GetTensorRTProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorRTProviderOptionsAsString$VH() {
        return constants$84.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorRTProviderOptionsAsString)(struct OrtTensorRTProviderOptionsV2*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetTensorRTProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$84.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorRTProviderOptionsAsString)(struct OrtTensorRTProviderOptionsV2*,struct OrtAllocator*,char**);
     * }
     */
    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$84.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorRTProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$84.const$0.get(seg, index * sizeof());
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$84.const$0.set(seg, index * sizeof(), x);
    }

    public static GetTensorRTProviderOptionsAsString GetTensorRTProviderOptionsAsString(
            MemorySegment segment, Arena scope) {
        return GetTensorRTProviderOptionsAsString.ofAddress(GetTensorRTProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*);
     * }
     */
    public interface ReleaseTensorRTProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTensorRTProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$84.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseTensorRTProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseTensorRTProviderOptions$VH() {
        return constants$84.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static MemorySegment ReleaseTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$84.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(struct OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$84.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$84.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$84.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseTensorRTProviderOptions.ofAddress(ReleaseTensorRTProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*EnableOrtCustomOps)(struct OrtSessionOptions*);
     * }
     */
    public interface EnableOrtCustomOps {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableOrtCustomOps fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$84.const$3, fi, constants$1.const$4, scope);
        }

        static EnableOrtCustomOps ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle EnableOrtCustomOps$VH() {
        return constants$84.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableOrtCustomOps)(struct OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableOrtCustomOps$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$84.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*EnableOrtCustomOps)(struct OrtSessionOptions*);
     * }
     */
    public static void EnableOrtCustomOps$set(MemorySegment seg, MemorySegment x) {
        constants$84.const$4.set(seg, 0L, x);
    }

    public static MemorySegment EnableOrtCustomOps$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$84.const$4.get(seg, index * sizeof());
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, long index, MemorySegment x) {
        constants$84.const$4.set(seg, index * sizeof(), x);
    }

    public static EnableOrtCustomOps EnableOrtCustomOps(MemorySegment segment, Arena scope) {
        return EnableOrtCustomOps.ofAddress(EnableOrtCustomOps$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RegisterAllocator)(struct OrtEnv*,struct OrtAllocator*);
     * }
     */
    public interface RegisterAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RegisterAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$84.const$5, fi, constants$15.const$2, scope);
        }

        static RegisterAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterAllocator$VH() {
        return constants$85.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterAllocator)(struct OrtEnv*,struct OrtAllocator*);
     * }
     */
    public static MemorySegment RegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$85.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterAllocator)(struct OrtEnv*,struct OrtAllocator*);
     * }
     */
    public static void RegisterAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$85.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$85.const$0.get(seg, index * sizeof());
    }

    public static void RegisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$85.const$0.set(seg, index * sizeof(), x);
    }

    public static RegisterAllocator RegisterAllocator(MemorySegment segment, Arena scope) {
        return RegisterAllocator.ofAddress(RegisterAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UnregisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*);
     * }
     */
    public interface UnregisterAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(UnregisterAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$85.const$1, fi, constants$15.const$2, scope);
        }

        static UnregisterAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UnregisterAllocator$VH() {
        return constants$85.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UnregisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*);
     * }
     */
    public static MemorySegment UnregisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$85.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UnregisterAllocator)(struct OrtEnv*,struct OrtMemoryInfo*);
     * }
     */
    public static void UnregisterAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$85.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UnregisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$85.const$2.get(seg, index * sizeof());
    }

    public static void UnregisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$85.const$2.set(seg, index * sizeof(), x);
    }

    public static UnregisterAllocator UnregisterAllocator(MemorySegment segment, Arena scope) {
        return UnregisterAllocator.ofAddress(UnregisterAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*IsSparseTensor)(struct OrtValue*,int*);
     * }
     */
    public interface IsSparseTensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(IsSparseTensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$85.const$3, fi, constants$15.const$2, scope);
        }

        static IsSparseTensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle IsSparseTensor$VH() {
        return constants$85.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*IsSparseTensor)(struct OrtValue*,int*);
     * }
     */
    public static MemorySegment IsSparseTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$85.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*IsSparseTensor)(struct OrtValue*,int*);
     * }
     */
    public static void IsSparseTensor$set(MemorySegment seg, MemorySegment x) {
        constants$85.const$4.set(seg, 0L, x);
    }

    public static MemorySegment IsSparseTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$85.const$4.get(seg, index * sizeof());
    }

    public static void IsSparseTensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$85.const$4.set(seg, index * sizeof(), x);
    }

    public static IsSparseTensor IsSparseTensor(MemorySegment segment, Arena scope) {
        return IsSparseTensor.ofAddress(IsSparseTensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSparseTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public interface CreateSparseTensorAsOrtValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateSparseTensorAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$85.const$5, fi, constants$35.const$5, scope);
        }

        static CreateSparseTensorAsOrtValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$36.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSparseTensorAsOrtValue$VH() {
        return constants$86.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSparseTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static MemorySegment CreateSparseTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$86.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSparseTensorAsOrtValue)(struct OrtAllocator*,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$86.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateSparseTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$86.const$0.get(seg, index * sizeof());
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$86.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateSparseTensorAsOrtValue CreateSparseTensorAsOrtValue(MemorySegment segment, Arena scope) {
        return CreateSparseTensorAsOrtValue.ofAddress(CreateSparseTensorAsOrtValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorCoo)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long);
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

        static MemorySegment allocate(FillSparseTensorCoo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$86.const$2, fi, constants$86.const$1, scope);
        }

        static FillSparseTensorCoo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$86.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillSparseTensorCoo$VH() {
        return constants$86.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorCoo)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long);
     * }
     */
    public static MemorySegment FillSparseTensorCoo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$86.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorCoo)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long);
     * }
     */
    public static void FillSparseTensorCoo$set(MemorySegment seg, MemorySegment x) {
        constants$86.const$4.set(seg, 0L, x);
    }

    public static MemorySegment FillSparseTensorCoo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$86.const$4.get(seg, index * sizeof());
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$86.const$4.set(seg, index * sizeof(), x);
    }

    public static FillSparseTensorCoo FillSparseTensorCoo(MemorySegment segment, Arena scope) {
        return FillSparseTensorCoo.ofAddress(FillSparseTensorCoo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorCsr)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,long long*,unsigned long);
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

        static MemorySegment allocate(FillSparseTensorCsr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$87.const$0, fi, constants$86.const$5, scope);
        }

        static FillSparseTensorCsr ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
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
                    return (java.lang.foreign.MemorySegment) constants$87.const$1.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillSparseTensorCsr$VH() {
        return constants$87.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorCsr)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,long long*,unsigned long);
     * }
     */
    public static MemorySegment FillSparseTensorCsr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$87.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorCsr)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,long long*,unsigned long);
     * }
     */
    public static void FillSparseTensorCsr$set(MemorySegment seg, MemorySegment x) {
        constants$87.const$2.set(seg, 0L, x);
    }

    public static MemorySegment FillSparseTensorCsr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$87.const$2.get(seg, index * sizeof());
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$87.const$2.set(seg, index * sizeof(), x);
    }

    public static FillSparseTensorCsr FillSparseTensorCsr(MemorySegment segment, Arena scope) {
        return FillSparseTensorCsr.ofAddress(FillSparseTensorCsr$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorBlockSparse)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,int*);
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

        static MemorySegment allocate(FillSparseTensorBlockSparse fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$87.const$4, fi, constants$87.const$3, scope);
        }

        static FillSparseTensorBlockSparse ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6,
                    java.lang.foreign.MemorySegment __x7) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$87.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillSparseTensorBlockSparse$VH() {
        return constants$88.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorBlockSparse)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,int*);
     * }
     */
    public static MemorySegment FillSparseTensorBlockSparse$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$88.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*FillSparseTensorBlockSparse)(struct OrtValue*,struct OrtMemoryInfo*,long long*,unsigned long,void*,long long*,unsigned long,int*);
     * }
     */
    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, MemorySegment x) {
        constants$88.const$0.set(seg, 0L, x);
    }

    public static MemorySegment FillSparseTensorBlockSparse$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$88.const$0.get(seg, index * sizeof());
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, long index, MemorySegment x) {
        constants$88.const$0.set(seg, index * sizeof(), x);
    }

    public static FillSparseTensorBlockSparse FillSparseTensorBlockSparse(MemorySegment segment, Arena scope) {
        return FillSparseTensorBlockSparse.ofAddress(FillSparseTensorBlockSparse$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateSparseTensorWithValuesAsOrtValue)(struct OrtMemoryInfo*,void*,long long*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
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

        static MemorySegment allocate(CreateSparseTensorWithValuesAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$88.const$2, fi, constants$88.const$1, scope);
        }

        static CreateSparseTensorWithValuesAsOrtValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
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
                            constants$88.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSparseTensorWithValuesAsOrtValue$VH() {
        return constants$88.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSparseTensorWithValuesAsOrtValue)(struct OrtMemoryInfo*,void*,long long*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static MemorySegment CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$88.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateSparseTensorWithValuesAsOrtValue)(struct OrtMemoryInfo*,void*,long long*,unsigned long,long long*,unsigned long,enum ONNXTensorElementDataType,struct OrtValue**);
     * }
     */
    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$88.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$88.const$4.get(seg, index * sizeof());
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$88.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateSparseTensorWithValuesAsOrtValue CreateSparseTensorWithValuesAsOrtValue(
            MemorySegment segment, Arena scope) {
        return CreateSparseTensorWithValuesAsOrtValue.ofAddress(
                CreateSparseTensorWithValuesAsOrtValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UseCooIndices)(struct OrtValue*,long long*,unsigned long);
     * }
     */
    public interface UseCooIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(UseCooIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$88.const$5, fi, constants$37.const$5, scope);
        }

        static UseCooIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UseCooIndices$VH() {
        return constants$89.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UseCooIndices)(struct OrtValue*,long long*,unsigned long);
     * }
     */
    public static MemorySegment UseCooIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$89.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UseCooIndices)(struct OrtValue*,long long*,unsigned long);
     * }
     */
    public static void UseCooIndices$set(MemorySegment seg, MemorySegment x) {
        constants$89.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UseCooIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$89.const$0.get(seg, index * sizeof());
    }

    public static void UseCooIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$89.const$0.set(seg, index * sizeof(), x);
    }

    public static UseCooIndices UseCooIndices(MemorySegment segment, Arena scope) {
        return UseCooIndices.ofAddress(UseCooIndices$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UseCsrIndices)(struct OrtValue*,long long*,unsigned long,long long*,unsigned long);
     * }
     */
    public interface UseCsrIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(UseCsrIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$89.const$1, fi, constants$38.const$5, scope);
        }

        static UseCsrIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$39.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UseCsrIndices$VH() {
        return constants$89.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UseCsrIndices)(struct OrtValue*,long long*,unsigned long,long long*,unsigned long);
     * }
     */
    public static MemorySegment UseCsrIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$89.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UseCsrIndices)(struct OrtValue*,long long*,unsigned long,long long*,unsigned long);
     * }
     */
    public static void UseCsrIndices$set(MemorySegment seg, MemorySegment x) {
        constants$89.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UseCsrIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$89.const$2.get(seg, index * sizeof());
    }

    public static void UseCsrIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$89.const$2.set(seg, index * sizeof(), x);
    }

    public static UseCsrIndices UseCsrIndices(MemorySegment segment, Arena scope) {
        return UseCsrIndices.ofAddress(UseCsrIndices$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UseBlockSparseIndices)(struct OrtValue*,long long*,unsigned long,int*);
     * }
     */
    public interface UseBlockSparseIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(UseBlockSparseIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$89.const$3, fi, constants$72.const$1, scope);
        }

        static UseBlockSparseIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$72.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UseBlockSparseIndices$VH() {
        return constants$89.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UseBlockSparseIndices)(struct OrtValue*,long long*,unsigned long,int*);
     * }
     */
    public static MemorySegment UseBlockSparseIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$89.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UseBlockSparseIndices)(struct OrtValue*,long long*,unsigned long,int*);
     * }
     */
    public static void UseBlockSparseIndices$set(MemorySegment seg, MemorySegment x) {
        constants$89.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UseBlockSparseIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$89.const$4.get(seg, index * sizeof());
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$89.const$4.set(seg, index * sizeof(), x);
    }

    public static UseBlockSparseIndices UseBlockSparseIndices(MemorySegment segment, Arena scope) {
        return UseBlockSparseIndices.ofAddress(UseBlockSparseIndices$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorFormat)(struct OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public interface GetSparseTensorFormat {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetSparseTensorFormat fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$89.const$5, fi, constants$15.const$2, scope);
        }

        static GetSparseTensorFormat ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorFormat$VH() {
        return constants$90.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorFormat)(struct OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public static MemorySegment GetSparseTensorFormat$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$90.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorFormat)(struct OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public static void GetSparseTensorFormat$set(MemorySegment seg, MemorySegment x) {
        constants$90.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorFormat$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$90.const$0.get(seg, index * sizeof());
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, long index, MemorySegment x) {
        constants$90.const$0.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorFormat GetSparseTensorFormat(MemorySegment segment, Arena scope) {
        return GetSparseTensorFormat.ofAddress(GetSparseTensorFormat$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorValuesTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetSparseTensorValuesTypeAndShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetSparseTensorValuesTypeAndShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$90.const$1, fi, constants$15.const$2, scope);
        }

        static GetSparseTensorValuesTypeAndShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorValuesTypeAndShape$VH() {
        return constants$90.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorValuesTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetSparseTensorValuesTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$90.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorValuesTypeAndShape)(struct OrtValue*,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, MemorySegment x) {
        constants$90.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorValuesTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$90.const$2.get(seg, index * sizeof());
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$90.const$2.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorValuesTypeAndShape GetSparseTensorValuesTypeAndShape(
            MemorySegment segment, Arena scope) {
        return GetSparseTensorValuesTypeAndShape.ofAddress(GetSparseTensorValuesTypeAndShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorValues)(struct OrtValue*,void**);
     * }
     */
    public interface GetSparseTensorValues {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetSparseTensorValues fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$90.const$3, fi, constants$15.const$2, scope);
        }

        static GetSparseTensorValues ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorValues$VH() {
        return constants$90.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorValues)(struct OrtValue*,void**);
     * }
     */
    public static MemorySegment GetSparseTensorValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$90.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorValues)(struct OrtValue*,void**);
     * }
     */
    public static void GetSparseTensorValues$set(MemorySegment seg, MemorySegment x) {
        constants$90.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$90.const$4.get(seg, index * sizeof());
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, long index, MemorySegment x) {
        constants$90.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorValues GetSparseTensorValues(MemorySegment segment, Arena scope) {
        return GetSparseTensorValues.ofAddress(GetSparseTensorValues$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorIndicesTypeShape)(struct OrtValue*,enum OrtSparseIndicesFormat,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetSparseTensorIndicesTypeShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetSparseTensorIndicesTypeShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$91.const$0, fi, constants$90.const$5, scope);
        }

        static GetSparseTensorIndicesTypeShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$91.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorIndicesTypeShape$VH() {
        return constants$91.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorIndicesTypeShape)(struct OrtValue*,enum OrtSparseIndicesFormat,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetSparseTensorIndicesTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$91.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorIndicesTypeShape)(struct OrtValue*,enum OrtSparseIndicesFormat,struct OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, MemorySegment x) {
        constants$91.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorIndicesTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$91.const$2.get(seg, index * sizeof());
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$91.const$2.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorIndicesTypeShape GetSparseTensorIndicesTypeShape(MemorySegment segment, Arena scope) {
        return GetSparseTensorIndicesTypeShape.ofAddress(GetSparseTensorIndicesTypeShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorIndices)(struct OrtValue*,enum OrtSparseIndicesFormat,unsigned long*,void**);
     * }
     */
    public interface GetSparseTensorIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                int _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetSparseTensorIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$91.const$3, fi, constants$48.const$3, scope);
        }

        static GetSparseTensorIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$48.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorIndices$VH() {
        return constants$91.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorIndices)(struct OrtValue*,enum OrtSparseIndicesFormat,unsigned long*,void**);
     * }
     */
    public static MemorySegment GetSparseTensorIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$91.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSparseTensorIndices)(struct OrtValue*,enum OrtSparseIndicesFormat,unsigned long*,void**);
     * }
     */
    public static void GetSparseTensorIndices$set(MemorySegment seg, MemorySegment x) {
        constants$91.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$91.const$4.get(seg, index * sizeof());
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$91.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorIndices GetSparseTensorIndices(MemorySegment segment, Arena scope) {
        return GetSparseTensorIndices.ofAddress(GetSparseTensorIndices$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*HasValue)(struct OrtValue*,int*);
     * }
     */
    public interface HasValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(HasValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$91.const$5, fi, constants$15.const$2, scope);
        }

        static HasValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle HasValue$VH() {
        return constants$92.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*HasValue)(struct OrtValue*,int*);
     * }
     */
    public static MemorySegment HasValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$92.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*HasValue)(struct OrtValue*,int*);
     * }
     */
    public static void HasValue$set(MemorySegment seg, MemorySegment x) {
        constants$92.const$0.set(seg, 0L, x);
    }

    public static MemorySegment HasValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$92.const$0.get(seg, index * sizeof());
    }

    public static void HasValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$92.const$0.set(seg, index * sizeof(), x);
    }

    public static HasValue HasValue(MemorySegment segment, Arena scope) {
        return HasValue.ofAddress(HasValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetGPUComputeStream)(struct OrtKernelContext*,void**);
     * }
     */
    public interface KernelContext_GetGPUComputeStream {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelContext_GetGPUComputeStream fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$92.const$1, fi, constants$15.const$2, scope);
        }

        static KernelContext_GetGPUComputeStream ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetGPUComputeStream$VH() {
        return constants$92.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetGPUComputeStream)(struct OrtKernelContext*,void**);
     * }
     */
    public static MemorySegment KernelContext_GetGPUComputeStream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$92.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetGPUComputeStream)(struct OrtKernelContext*,void**);
     * }
     */
    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, MemorySegment x) {
        constants$92.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetGPUComputeStream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$92.const$2.get(seg, index * sizeof());
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, long index, MemorySegment x) {
        constants$92.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetGPUComputeStream KernelContext_GetGPUComputeStream(
            MemorySegment segment, Arena scope) {
        return KernelContext_GetGPUComputeStream.ofAddress(KernelContext_GetGPUComputeStream$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorMemoryInfo)(struct OrtValue*,struct OrtMemoryInfo**);
     * }
     */
    public interface GetTensorMemoryInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetTensorMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$92.const$3, fi, constants$15.const$2, scope);
        }

        static GetTensorMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorMemoryInfo$VH() {
        return constants$92.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorMemoryInfo)(struct OrtValue*,struct OrtMemoryInfo**);
     * }
     */
    public static MemorySegment GetTensorMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$92.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorMemoryInfo)(struct OrtValue*,struct OrtMemoryInfo**);
     * }
     */
    public static void GetTensorMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$92.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$92.const$4.get(seg, index * sizeof());
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$92.const$4.set(seg, index * sizeof(), x);
    }

    public static GetTensorMemoryInfo GetTensorMemoryInfo(MemorySegment segment, Arena scope) {
        return GetTensorMemoryInfo.ofAddress(GetTensorMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetExecutionProviderApi)(char*,unsigned int,void**);
     * }
     */
    public interface GetExecutionProviderApi {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetExecutionProviderApi fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$92.const$5, fi, constants$90.const$5, scope);
        }

        static GetExecutionProviderApi ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$91.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetExecutionProviderApi$VH() {
        return constants$93.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetExecutionProviderApi)(char*,unsigned int,void**);
     * }
     */
    public static MemorySegment GetExecutionProviderApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$93.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetExecutionProviderApi)(char*,unsigned int,void**);
     * }
     */
    public static void GetExecutionProviderApi$set(MemorySegment seg, MemorySegment x) {
        constants$93.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetExecutionProviderApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$93.const$0.get(seg, index * sizeof());
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, long index, MemorySegment x) {
        constants$93.const$0.set(seg, index * sizeof(), x);
    }

    public static GetExecutionProviderApi GetExecutionProviderApi(MemorySegment segment, Arena scope) {
        return GetExecutionProviderApi.ofAddress(GetExecutionProviderApi$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomCreateThreadFn)(struct OrtSessionOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
     * }
     */
    public interface SessionOptionsSetCustomCreateThreadFn {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsSetCustomCreateThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$93.const$1, fi, constants$15.const$2, scope);
        }

        static SessionOptionsSetCustomCreateThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsSetCustomCreateThreadFn$VH() {
        return constants$93.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomCreateThreadFn)(struct OrtSessionOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
     * }
     */
    public static MemorySegment SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$93.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomCreateThreadFn)(struct OrtSessionOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
     * }
     */
    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$93.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$93.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$93.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsSetCustomCreateThreadFn SessionOptionsSetCustomCreateThreadFn(
            MemorySegment segment, Arena scope) {
        return SessionOptionsSetCustomCreateThreadFn.ofAddress(
                SessionOptionsSetCustomCreateThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomThreadCreationOptions)(struct OrtSessionOptions*,void*);
     * }
     */
    public interface SessionOptionsSetCustomThreadCreationOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsSetCustomThreadCreationOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$93.const$3, fi, constants$15.const$2, scope);
        }

        static SessionOptionsSetCustomThreadCreationOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsSetCustomThreadCreationOptions$VH() {
        return constants$93.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomThreadCreationOptions)(struct OrtSessionOptions*,void*);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$93.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomThreadCreationOptions)(struct OrtSessionOptions*,void*);
     * }
     */
    public static void SessionOptionsSetCustomThreadCreationOptions$set(MemorySegment seg, MemorySegment x) {
        constants$93.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$93.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$93.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsSetCustomThreadCreationOptions SessionOptionsSetCustomThreadCreationOptions(
            MemorySegment segment, Arena scope) {
        return SessionOptionsSetCustomThreadCreationOptions.ofAddress(
                SessionOptionsSetCustomThreadCreationOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomJoinThreadFn)(struct OrtSessionOptions*,void (*)(struct OrtCustomHandleType*));
     * }
     */
    public interface SessionOptionsSetCustomJoinThreadFn {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsSetCustomJoinThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$93.const$5, fi, constants$15.const$2, scope);
        }

        static SessionOptionsSetCustomJoinThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsSetCustomJoinThreadFn$VH() {
        return constants$94.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomJoinThreadFn)(struct OrtSessionOptions*,void (*)(struct OrtCustomHandleType*));
     * }
     */
    public static MemorySegment SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$94.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsSetCustomJoinThreadFn)(struct OrtSessionOptions*,void (*)(struct OrtCustomHandleType*));
     * }
     */
    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$94.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$94.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$94.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsSetCustomJoinThreadFn SessionOptionsSetCustomJoinThreadFn(
            MemorySegment segment, Arena scope) {
        return SessionOptionsSetCustomJoinThreadFn.ofAddress(SessionOptionsSetCustomJoinThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomCreateThreadFn)(struct OrtThreadingOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
     * }
     */
    public interface SetGlobalCustomCreateThreadFn {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SetGlobalCustomCreateThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$94.const$1, fi, constants$15.const$2, scope);
        }

        static SetGlobalCustomCreateThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalCustomCreateThreadFn$VH() {
        return constants$94.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomCreateThreadFn)(struct OrtThreadingOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
     * }
     */
    public static MemorySegment SetGlobalCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$94.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomCreateThreadFn)(struct OrtThreadingOptions*,struct OrtCustomHandleType* (*)(void*,void (*)(void*),void*));
     * }
     */
    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$94.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$94.const$2.get(seg, index * sizeof());
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$94.const$2.set(seg, index * sizeof(), x);
    }

    public static SetGlobalCustomCreateThreadFn SetGlobalCustomCreateThreadFn(MemorySegment segment, Arena scope) {
        return SetGlobalCustomCreateThreadFn.ofAddress(SetGlobalCustomCreateThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomThreadCreationOptions)(struct OrtThreadingOptions*,void*);
     * }
     */
    public interface SetGlobalCustomThreadCreationOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SetGlobalCustomThreadCreationOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$94.const$3, fi, constants$15.const$2, scope);
        }

        static SetGlobalCustomThreadCreationOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalCustomThreadCreationOptions$VH() {
        return constants$94.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomThreadCreationOptions)(struct OrtThreadingOptions*,void*);
     * }
     */
    public static MemorySegment SetGlobalCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$94.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomThreadCreationOptions)(struct OrtThreadingOptions*,void*);
     * }
     */
    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, MemorySegment x) {
        constants$94.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$94.const$4.get(seg, index * sizeof());
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$94.const$4.set(seg, index * sizeof(), x);
    }

    public static SetGlobalCustomThreadCreationOptions SetGlobalCustomThreadCreationOptions(
            MemorySegment segment, Arena scope) {
        return SetGlobalCustomThreadCreationOptions.ofAddress(SetGlobalCustomThreadCreationOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomJoinThreadFn)(struct OrtThreadingOptions*,void (*)(struct OrtCustomHandleType*));
     * }
     */
    public interface SetGlobalCustomJoinThreadFn {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SetGlobalCustomJoinThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$94.const$5, fi, constants$15.const$2, scope);
        }

        static SetGlobalCustomJoinThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalCustomJoinThreadFn$VH() {
        return constants$95.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomJoinThreadFn)(struct OrtThreadingOptions*,void (*)(struct OrtCustomHandleType*));
     * }
     */
    public static MemorySegment SetGlobalCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$95.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalCustomJoinThreadFn)(struct OrtThreadingOptions*,void (*)(struct OrtCustomHandleType*));
     * }
     */
    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$95.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$95.const$0.get(seg, index * sizeof());
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$95.const$0.set(seg, index * sizeof(), x);
    }

    public static SetGlobalCustomJoinThreadFn SetGlobalCustomJoinThreadFn(MemorySegment segment, Arena scope) {
        return SetGlobalCustomJoinThreadFn.ofAddress(SetGlobalCustomJoinThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SynchronizeBoundInputs)(struct OrtIoBinding*);
     * }
     */
    public interface SynchronizeBoundInputs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SynchronizeBoundInputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$95.const$1, fi, constants$1.const$4, scope);
        }

        static SynchronizeBoundInputs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SynchronizeBoundInputs$VH() {
        return constants$95.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SynchronizeBoundInputs)(struct OrtIoBinding*);
     * }
     */
    public static MemorySegment SynchronizeBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$95.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SynchronizeBoundInputs)(struct OrtIoBinding*);
     * }
     */
    public static void SynchronizeBoundInputs$set(MemorySegment seg, MemorySegment x) {
        constants$95.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SynchronizeBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$95.const$2.get(seg, index * sizeof());
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$95.const$2.set(seg, index * sizeof(), x);
    }

    public static SynchronizeBoundInputs SynchronizeBoundInputs(MemorySegment segment, Arena scope) {
        return SynchronizeBoundInputs.ofAddress(SynchronizeBoundInputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SynchronizeBoundOutputs)(struct OrtIoBinding*);
     * }
     */
    public interface SynchronizeBoundOutputs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SynchronizeBoundOutputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$95.const$3, fi, constants$1.const$4, scope);
        }

        static SynchronizeBoundOutputs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SynchronizeBoundOutputs$VH() {
        return constants$95.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SynchronizeBoundOutputs)(struct OrtIoBinding*);
     * }
     */
    public static MemorySegment SynchronizeBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$95.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SynchronizeBoundOutputs)(struct OrtIoBinding*);
     * }
     */
    public static void SynchronizeBoundOutputs$set(MemorySegment seg, MemorySegment x) {
        constants$95.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SynchronizeBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$95.const$4.get(seg, index * sizeof());
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$95.const$4.set(seg, index * sizeof(), x);
    }

    public static SynchronizeBoundOutputs SynchronizeBoundOutputs(MemorySegment segment, Arena scope) {
        return SynchronizeBoundOutputs.ofAddress(SynchronizeBoundOutputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA_V2)(struct OrtSessionOptions*,struct OrtCUDAProviderOptionsV2*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CUDA_V2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$95.const$5, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA_V2$VH() {
        return constants$96.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA_V2)(struct OrtSessionOptions*,struct OrtCUDAProviderOptionsV2*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$96.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CUDA_V2)(struct OrtSessionOptions*,struct OrtCUDAProviderOptionsV2*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(MemorySegment seg, MemorySegment x) {
        constants$96.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$96.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$96.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA_V2 SessionOptionsAppendExecutionProvider_CUDA_V2(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_CUDA_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA_V2$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2**);
     * }
     */
    public interface CreateCUDAProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateCUDAProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$96.const$1, fi, constants$1.const$4, scope);
        }

        static CreateCUDAProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateCUDAProviderOptions$VH() {
        return constants$96.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2**);
     * }
     */
    public static MemorySegment CreateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$96.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2**);
     * }
     */
    public static void CreateCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$96.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$96.const$2.get(seg, index * sizeof());
    }

    public static void CreateCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$96.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateCUDAProviderOptions CreateCUDAProviderOptions(MemorySegment segment, Arena scope) {
        return CreateCUDAProviderOptions.ofAddress(CreateCUDAProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*,char**,char**,unsigned long);
     * }
     */
    public interface UpdateCUDAProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateCUDAProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$96.const$3, fi, constants$83.const$1, scope);
        }

        static UpdateCUDAProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateCUDAProviderOptions$VH() {
        return constants$96.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment UpdateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$96.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*,char**,char**,unsigned long);
     * }
     */
    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$96.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UpdateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$96.const$4.get(seg, index * sizeof());
    }

    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$96.const$4.set(seg, index * sizeof(), x);
    }

    public static UpdateCUDAProviderOptions UpdateCUDAProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateCUDAProviderOptions.ofAddress(UpdateCUDAProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetCUDAProviderOptionsAsString)(struct OrtCUDAProviderOptionsV2*,struct OrtAllocator*,char**);
     * }
     */
    public interface GetCUDAProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetCUDAProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$96.const$5, fi, constants$14.const$4, scope);
        }

        static GetCUDAProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCUDAProviderOptionsAsString$VH() {
        return constants$97.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCUDAProviderOptionsAsString)(struct OrtCUDAProviderOptionsV2*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetCUDAProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$97.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCUDAProviderOptionsAsString)(struct OrtCUDAProviderOptionsV2*,struct OrtAllocator*,char**);
     * }
     */
    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$97.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetCUDAProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$97.const$0.get(seg, index * sizeof());
    }

    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$97.const$0.set(seg, index * sizeof(), x);
    }

    public static GetCUDAProviderOptionsAsString GetCUDAProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetCUDAProviderOptionsAsString.ofAddress(GetCUDAProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*);
     * }
     */
    public interface ReleaseCUDAProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCUDAProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$97.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseCUDAProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseCUDAProviderOptions$VH() {
        return constants$97.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*);
     * }
     */
    public static MemorySegment ReleaseCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$97.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(struct OrtCUDAProviderOptionsV2*);
     * }
     */
    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$97.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$97.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$97.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseCUDAProviderOptions ReleaseCUDAProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseCUDAProviderOptions.ofAddress(ReleaseCUDAProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_MIGraphX)(struct OrtSessionOptions*,struct OrtMIGraphXProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_MIGraphX {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_MIGraphX fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$97.const$3, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_MIGraphX ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_MIGraphX$VH() {
        return constants$97.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_MIGraphX)(struct OrtSessionOptions*,struct OrtMIGraphXProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$97.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_MIGraphX)(struct OrtSessionOptions*,struct OrtMIGraphXProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(MemorySegment seg, MemorySegment x) {
        constants$97.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$97.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$97.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_MIGraphX SessionOptionsAppendExecutionProvider_MIGraphX(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_MIGraphX.ofAddress(
                SessionOptionsAppendExecutionProvider_MIGraphX$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*AddExternalInitializers)(struct OrtSessionOptions*,char**,struct OrtValue**,unsigned long);
     * }
     */
    public interface AddExternalInitializers {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(AddExternalInitializers fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$97.const$5, fi, constants$83.const$1, scope);
        }

        static AddExternalInitializers ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddExternalInitializers$VH() {
        return constants$98.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*AddExternalInitializers)(struct OrtSessionOptions*,char**,struct OrtValue**,unsigned long);
     * }
     */
    public static MemorySegment AddExternalInitializers$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$98.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*AddExternalInitializers)(struct OrtSessionOptions*,char**,struct OrtValue**,unsigned long);
     * }
     */
    public static void AddExternalInitializers$set(MemorySegment seg, MemorySegment x) {
        constants$98.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AddExternalInitializers$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$98.const$0.get(seg, index * sizeof());
    }

    public static void AddExternalInitializers$set(MemorySegment seg, long index, MemorySegment x) {
        constants$98.const$0.set(seg, index * sizeof(), x);
    }

    public static AddExternalInitializers AddExternalInitializers(MemorySegment segment, Arena scope) {
        return AddExternalInitializers.ofAddress(AddExternalInitializers$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateOpAttr)(char*,void*,int,enum OrtOpAttrType,struct OrtOpAttr**);
     * }
     */
    public interface CreateOpAttr {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                int _x2,
                int _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateOpAttr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$98.const$2, fi, constants$98.const$1, scope);
        }

        static CreateOpAttr ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    int __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$98.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateOpAttr$VH() {
        return constants$98.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateOpAttr)(char*,void*,int,enum OrtOpAttrType,struct OrtOpAttr**);
     * }
     */
    public static MemorySegment CreateOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$98.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateOpAttr)(char*,void*,int,enum OrtOpAttrType,struct OrtOpAttr**);
     * }
     */
    public static void CreateOpAttr$set(MemorySegment seg, MemorySegment x) {
        constants$98.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$98.const$4.get(seg, index * sizeof());
    }

    public static void CreateOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$98.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateOpAttr CreateOpAttr(MemorySegment segment, Arena scope) {
        return CreateOpAttr.ofAddress(CreateOpAttr$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseOpAttr)(struct OrtOpAttr*);
     * }
     */
    public interface ReleaseOpAttr {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseOpAttr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$98.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseOpAttr ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseOpAttr$VH() {
        return constants$99.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseOpAttr)(struct OrtOpAttr*);
     * }
     */
    public static MemorySegment ReleaseOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$99.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseOpAttr)(struct OrtOpAttr*);
     * }
     */
    public static void ReleaseOpAttr$set(MemorySegment seg, MemorySegment x) {
        constants$99.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$99.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$99.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseOpAttr ReleaseOpAttr(MemorySegment segment, Arena scope) {
        return ReleaseOpAttr.ofAddress(ReleaseOpAttr$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateOp)(struct OrtKernelInfo*,char*,char*,int,char**,enum ONNXTensorElementDataType*,int,struct OrtOpAttr**,int,int,int,struct OrtOp**);
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

        static MemorySegment allocate(CreateOp fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$99.const$2, fi, constants$99.const$1, scope);
        }

        static CreateOp ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
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
                    return (java.lang.foreign.MemorySegment) constants$99.const$3.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8, __x9, __x10, __x11);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateOp$VH() {
        return constants$99.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateOp)(struct OrtKernelInfo*,char*,char*,int,char**,enum ONNXTensorElementDataType*,int,struct OrtOpAttr**,int,int,int,struct OrtOp**);
     * }
     */
    public static MemorySegment CreateOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$99.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateOp)(struct OrtKernelInfo*,char*,char*,int,char**,enum ONNXTensorElementDataType*,int,struct OrtOpAttr**,int,int,int,struct OrtOp**);
     * }
     */
    public static void CreateOp$set(MemorySegment seg, MemorySegment x) {
        constants$99.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$99.const$4.get(seg, index * sizeof());
    }

    public static void CreateOp$set(MemorySegment seg, long index, MemorySegment x) {
        constants$99.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateOp CreateOp(MemorySegment segment, Arena scope) {
        return CreateOp.ofAddress(CreateOp$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*InvokeOp)(struct OrtKernelContext*,struct OrtOp*,struct OrtValue**,int,struct OrtValue**,int);
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

        static MemorySegment allocate(InvokeOp fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$100.const$0, fi, constants$99.const$5, scope);
        }

        static InvokeOp ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    int __x3,
                    java.lang.foreign.MemorySegment __x4,
                    int __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$100.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle InvokeOp$VH() {
        return constants$100.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*InvokeOp)(struct OrtKernelContext*,struct OrtOp*,struct OrtValue**,int,struct OrtValue**,int);
     * }
     */
    public static MemorySegment InvokeOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$100.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*InvokeOp)(struct OrtKernelContext*,struct OrtOp*,struct OrtValue**,int,struct OrtValue**,int);
     * }
     */
    public static void InvokeOp$set(MemorySegment seg, MemorySegment x) {
        constants$100.const$2.set(seg, 0L, x);
    }

    public static MemorySegment InvokeOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$100.const$2.get(seg, index * sizeof());
    }

    public static void InvokeOp$set(MemorySegment seg, long index, MemorySegment x) {
        constants$100.const$2.set(seg, index * sizeof(), x);
    }

    public static InvokeOp InvokeOp(MemorySegment segment, Arena scope) {
        return InvokeOp.ofAddress(InvokeOp$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseOp)(struct OrtOp*);
     * }
     */
    public interface ReleaseOp {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseOp fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$100.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseOp ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseOp$VH() {
        return constants$100.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseOp)(struct OrtOp*);
     * }
     */
    public static MemorySegment ReleaseOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$100.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseOp)(struct OrtOp*);
     * }
     */
    public static void ReleaseOp$set(MemorySegment seg, MemorySegment x) {
        constants$100.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$100.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseOp$set(MemorySegment seg, long index, MemorySegment x) {
        constants$100.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseOp ReleaseOp(MemorySegment segment, Arena scope) {
        return ReleaseOp.ofAddress(ReleaseOp$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider)(struct OrtSessionOptions*,char*,char**,char**,unsigned long);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$100.const$5, fi, constants$50.const$5, scope);
        }

        static SessionOptionsAppendExecutionProvider ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$51.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider$VH() {
        return constants$101.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider)(struct OrtSessionOptions*,char*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$101.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider)(struct OrtSessionOptions*,char*,char**,char**,unsigned long);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, MemorySegment x) {
        constants$101.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$101.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, long index, MemorySegment x) {
        constants$101.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider SessionOptionsAppendExecutionProvider(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider.ofAddress(
                SessionOptionsAppendExecutionProvider$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CopyKernelInfo)(struct OrtKernelInfo*,struct OrtKernelInfo**);
     * }
     */
    public interface CopyKernelInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CopyKernelInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$101.const$1, fi, constants$15.const$2, scope);
        }

        static CopyKernelInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CopyKernelInfo$VH() {
        return constants$101.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CopyKernelInfo)(struct OrtKernelInfo*,struct OrtKernelInfo**);
     * }
     */
    public static MemorySegment CopyKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$101.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CopyKernelInfo)(struct OrtKernelInfo*,struct OrtKernelInfo**);
     * }
     */
    public static void CopyKernelInfo$set(MemorySegment seg, MemorySegment x) {
        constants$101.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CopyKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$101.const$2.get(seg, index * sizeof());
    }

    public static void CopyKernelInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$101.const$2.set(seg, index * sizeof(), x);
    }

    public static CopyKernelInfo CopyKernelInfo(MemorySegment segment, Arena scope) {
        return CopyKernelInfo.ofAddress(CopyKernelInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseKernelInfo)(struct OrtKernelInfo*);
     * }
     */
    public interface ReleaseKernelInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseKernelInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$101.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseKernelInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseKernelInfo$VH() {
        return constants$101.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseKernelInfo)(struct OrtKernelInfo*);
     * }
     */
    public static MemorySegment ReleaseKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$101.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseKernelInfo)(struct OrtKernelInfo*);
     * }
     */
    public static void ReleaseKernelInfo$set(MemorySegment seg, MemorySegment x) {
        constants$101.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$101.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseKernelInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$101.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseKernelInfo ReleaseKernelInfo(MemorySegment segment, Arena scope) {
        return ReleaseKernelInfo.ofAddress(ReleaseKernelInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtTrainingApi* (*GetTrainingApi)(unsigned int);
     * }
     */
    public interface GetTrainingApi {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(GetTrainingApi fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$101.const$5, fi, constants$12.const$2, scope);
        }

        static GetTrainingApi ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$12.const$4.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTrainingApi$VH() {
        return constants$102.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtTrainingApi* (*GetTrainingApi)(unsigned int);
     * }
     */
    public static MemorySegment GetTrainingApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$102.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtTrainingApi* (*GetTrainingApi)(unsigned int);
     * }
     */
    public static void GetTrainingApi$set(MemorySegment seg, MemorySegment x) {
        constants$102.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetTrainingApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$102.const$0.get(seg, index * sizeof());
    }

    public static void GetTrainingApi$set(MemorySegment seg, long index, MemorySegment x) {
        constants$102.const$0.set(seg, index * sizeof(), x);
    }

    public static GetTrainingApi GetTrainingApi(MemorySegment segment, Arena scope) {
        return GetTrainingApi.ofAddress(GetTrainingApi$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CANN)(struct OrtSessionOptions*,struct OrtCANNProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CANN {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CANN fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$102.const$1, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_CANN ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_CANN$VH() {
        return constants$102.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CANN)(struct OrtSessionOptions*,struct OrtCANNProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$102.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_CANN)(struct OrtSessionOptions*,struct OrtCANNProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, MemorySegment x) {
        constants$102.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$102.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, long index, MemorySegment x) {
        constants$102.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_CANN SessionOptionsAppendExecutionProvider_CANN(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_CANN.ofAddress(
                SessionOptionsAppendExecutionProvider_CANN$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateCANNProviderOptions)(struct OrtCANNProviderOptions**);
     * }
     */
    public interface CreateCANNProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateCANNProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$102.const$3, fi, constants$1.const$4, scope);
        }

        static CreateCANNProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateCANNProviderOptions$VH() {
        return constants$102.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCANNProviderOptions)(struct OrtCANNProviderOptions**);
     * }
     */
    public static MemorySegment CreateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$102.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateCANNProviderOptions)(struct OrtCANNProviderOptions**);
     * }
     */
    public static void CreateCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$102.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$102.const$4.get(seg, index * sizeof());
    }

    public static void CreateCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$102.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateCANNProviderOptions CreateCANNProviderOptions(MemorySegment segment, Arena scope) {
        return CreateCANNProviderOptions.ofAddress(CreateCANNProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateCANNProviderOptions)(struct OrtCANNProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public interface UpdateCANNProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateCANNProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$102.const$5, fi, constants$83.const$1, scope);
        }

        static UpdateCANNProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateCANNProviderOptions$VH() {
        return constants$103.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateCANNProviderOptions)(struct OrtCANNProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment UpdateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$103.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateCANNProviderOptions)(struct OrtCANNProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public static void UpdateCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$103.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UpdateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$103.const$0.get(seg, index * sizeof());
    }

    public static void UpdateCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$103.const$0.set(seg, index * sizeof(), x);
    }

    public static UpdateCANNProviderOptions UpdateCANNProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateCANNProviderOptions.ofAddress(UpdateCANNProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetCANNProviderOptionsAsString)(struct OrtCANNProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public interface GetCANNProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetCANNProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$103.const$1, fi, constants$14.const$4, scope);
        }

        static GetCANNProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCANNProviderOptionsAsString$VH() {
        return constants$103.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCANNProviderOptionsAsString)(struct OrtCANNProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetCANNProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$103.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCANNProviderOptionsAsString)(struct OrtCANNProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$103.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetCANNProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$103.const$2.get(seg, index * sizeof());
    }

    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$103.const$2.set(seg, index * sizeof(), x);
    }

    public static GetCANNProviderOptionsAsString GetCANNProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetCANNProviderOptionsAsString.ofAddress(GetCANNProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(struct OrtCANNProviderOptions*);
     * }
     */
    public interface ReleaseCANNProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCANNProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$103.const$3, fi, constants$13.const$5, scope);
        }

        static ReleaseCANNProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseCANNProviderOptions$VH() {
        return constants$103.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(struct OrtCANNProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$103.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(struct OrtCANNProviderOptions*);
     * }
     */
    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$103.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$103.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$103.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseCANNProviderOptions ReleaseCANNProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseCANNProviderOptions.ofAddress(ReleaseCANNProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(struct OrtMemoryInfo*,enum OrtMemoryInfoDeviceType*);
     * }
     */
    public interface MemoryInfoGetDeviceType {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetDeviceType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$103.const$5, fi, constants$1.const$0, scope);
        }

        static MemoryInfoGetDeviceType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    constants$1.const$2.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetDeviceType$VH() {
        return constants$104.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(struct OrtMemoryInfo*,enum OrtMemoryInfoDeviceType*);
     * }
     */
    public static MemorySegment MemoryInfoGetDeviceType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$104.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(struct OrtMemoryInfo*,enum OrtMemoryInfoDeviceType*);
     * }
     */
    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, MemorySegment x) {
        constants$104.const$0.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetDeviceType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$104.const$0.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$104.const$0.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetDeviceType MemoryInfoGetDeviceType(MemorySegment segment, Arena scope) {
        return MemoryInfoGetDeviceType.ofAddress(MemoryInfoGetDeviceType$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateEnvWithCustomLogLevel)(struct OrtEnv*,enum OrtLoggingLevel);
     * }
     */
    public interface UpdateEnvWithCustomLogLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(UpdateEnvWithCustomLogLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$104.const$1, fi, constants$23.const$1, scope);
        }

        static UpdateEnvWithCustomLogLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateEnvWithCustomLogLevel$VH() {
        return constants$104.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateEnvWithCustomLogLevel)(struct OrtEnv*,enum OrtLoggingLevel);
     * }
     */
    public static MemorySegment UpdateEnvWithCustomLogLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$104.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateEnvWithCustomLogLevel)(struct OrtEnv*,enum OrtLoggingLevel);
     * }
     */
    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, MemorySegment x) {
        constants$104.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UpdateEnvWithCustomLogLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$104.const$2.get(seg, index * sizeof());
    }

    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$104.const$2.set(seg, index * sizeof(), x);
    }

    public static UpdateEnvWithCustomLogLevel UpdateEnvWithCustomLogLevel(MemorySegment segment, Arena scope) {
        return UpdateEnvWithCustomLogLevel.ofAddress(UpdateEnvWithCustomLogLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SetGlobalIntraOpThreadAffinity)(struct OrtThreadingOptions*,char*);
     * }
     */
    public interface SetGlobalIntraOpThreadAffinity {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SetGlobalIntraOpThreadAffinity fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$104.const$3, fi, constants$15.const$2, scope);
        }

        static SetGlobalIntraOpThreadAffinity ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalIntraOpThreadAffinity$VH() {
        return constants$104.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalIntraOpThreadAffinity)(struct OrtThreadingOptions*,char*);
     * }
     */
    public static MemorySegment SetGlobalIntraOpThreadAffinity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$104.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SetGlobalIntraOpThreadAffinity)(struct OrtThreadingOptions*,char*);
     * }
     */
    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, MemorySegment x) {
        constants$104.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalIntraOpThreadAffinity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$104.const$4.get(seg, index * sizeof());
    }

    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, long index, MemorySegment x) {
        constants$104.const$4.set(seg, index * sizeof(), x);
    }

    public static SetGlobalIntraOpThreadAffinity SetGlobalIntraOpThreadAffinity(MemorySegment segment, Arena scope) {
        return SetGlobalIntraOpThreadAffinity.ofAddress(SetGlobalIntraOpThreadAffinity$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsLibrary_V2)(struct OrtSessionOptions*,char*);
     * }
     */
    public interface RegisterCustomOpsLibrary_V2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RegisterCustomOpsLibrary_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$104.const$5, fi, constants$15.const$2, scope);
        }

        static RegisterCustomOpsLibrary_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterCustomOpsLibrary_V2$VH() {
        return constants$105.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsLibrary_V2)(struct OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment RegisterCustomOpsLibrary_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$105.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsLibrary_V2)(struct OrtSessionOptions*,char*);
     * }
     */
    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, MemorySegment x) {
        constants$105.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RegisterCustomOpsLibrary_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$105.const$0.get(seg, index * sizeof());
    }

    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$105.const$0.set(seg, index * sizeof(), x);
    }

    public static RegisterCustomOpsLibrary_V2 RegisterCustomOpsLibrary_V2(MemorySegment segment, Arena scope) {
        return RegisterCustomOpsLibrary_V2.ofAddress(RegisterCustomOpsLibrary_V2$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsUsingFunction)(struct OrtSessionOptions*,char*);
     * }
     */
    public interface RegisterCustomOpsUsingFunction {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(RegisterCustomOpsUsingFunction fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$105.const$1, fi, constants$15.const$2, scope);
        }

        static RegisterCustomOpsUsingFunction ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterCustomOpsUsingFunction$VH() {
        return constants$105.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsUsingFunction)(struct OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment RegisterCustomOpsUsingFunction$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$105.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RegisterCustomOpsUsingFunction)(struct OrtSessionOptions*,char*);
     * }
     */
    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, MemorySegment x) {
        constants$105.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RegisterCustomOpsUsingFunction$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$105.const$2.get(seg, index * sizeof());
    }

    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, long index, MemorySegment x) {
        constants$105.const$2.set(seg, index * sizeof(), x);
    }

    public static RegisterCustomOpsUsingFunction RegisterCustomOpsUsingFunction(MemorySegment segment, Arena scope) {
        return RegisterCustomOpsUsingFunction.ofAddress(RegisterCustomOpsUsingFunction$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputCount)(struct OrtKernelInfo*,unsigned long*);
     * }
     */
    public interface KernelInfo_GetInputCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelInfo_GetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$105.const$3, fi, constants$15.const$2, scope);
        }

        static KernelInfo_GetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetInputCount$VH() {
        return constants$105.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputCount)(struct OrtKernelInfo*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfo_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$105.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputCount)(struct OrtKernelInfo*,unsigned long*);
     * }
     */
    public static void KernelInfo_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$105.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$105.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$105.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetInputCount KernelInfo_GetInputCount(MemorySegment segment, Arena scope) {
        return KernelInfo_GetInputCount.ofAddress(KernelInfo_GetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputCount)(struct OrtKernelInfo*,unsigned long*);
     * }
     */
    public interface KernelInfo_GetOutputCount {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelInfo_GetOutputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$105.const$5, fi, constants$15.const$2, scope);
        }

        static KernelInfo_GetOutputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetOutputCount$VH() {
        return constants$106.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputCount)(struct OrtKernelInfo*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$106.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputCount)(struct OrtKernelInfo*,unsigned long*);
     * }
     */
    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, MemorySegment x) {
        constants$106.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$106.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$106.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetOutputCount KernelInfo_GetOutputCount(MemorySegment segment, Arena scope) {
        return KernelInfo_GetOutputCount.ofAddress(KernelInfo_GetOutputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
     * }
     */
    public interface KernelInfo_GetInputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfo_GetInputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$106.const$1, fi, constants$31.const$3, scope);
        }

        static KernelInfo_GetInputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$31.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetInputName$VH() {
        return constants$106.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfo_GetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$106.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
     * }
     */
    public static void KernelInfo_GetInputName$set(MemorySegment seg, MemorySegment x) {
        constants$106.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$106.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetInputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$106.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetInputName KernelInfo_GetInputName(MemorySegment segment, Arena scope) {
        return KernelInfo_GetInputName.ofAddress(KernelInfo_GetInputName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
     * }
     */
    public interface KernelInfo_GetOutputName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfo_GetOutputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$106.const$3, fi, constants$31.const$3, scope);
        }

        static KernelInfo_GetOutputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$31.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetOutputName$VH() {
        return constants$106.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$106.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputName)(struct OrtKernelInfo*,unsigned long,char*,unsigned long*);
     * }
     */
    public static void KernelInfo_GetOutputName$set(MemorySegment seg, MemorySegment x) {
        constants$106.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$106.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetOutputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$106.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetOutputName KernelInfo_GetOutputName(MemorySegment segment, Arena scope) {
        return KernelInfo_GetOutputName.ofAddress(KernelInfo_GetOutputName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public interface KernelInfo_GetInputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetInputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$106.const$5, fi, constants$30.const$1, scope);
        }

        static KernelInfo_GetInputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetInputTypeInfo$VH() {
        return constants$107.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment KernelInfo_GetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$107.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetInputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$107.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$107.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$107.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetInputTypeInfo KernelInfo_GetInputTypeInfo(MemorySegment segment, Arena scope) {
        return KernelInfo_GetInputTypeInfo.ofAddress(KernelInfo_GetInputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public interface KernelInfo_GetOutputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetOutputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$107.const$1, fi, constants$30.const$1, scope);
        }

        static KernelInfo_GetOutputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetOutputTypeInfo$VH() {
        return constants$107.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$107.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetOutputTypeInfo)(struct OrtKernelInfo*,unsigned long,struct OrtTypeInfo**);
     * }
     */
    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$107.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$107.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$107.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetOutputTypeInfo KernelInfo_GetOutputTypeInfo(MemorySegment segment, Arena scope) {
        return KernelInfo_GetOutputTypeInfo.ofAddress(KernelInfo_GetOutputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_tensor)(struct OrtKernelInfo*,char*,struct OrtAllocator*,struct OrtValue**);
     * }
     */
    public interface KernelInfoGetAttribute_tensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetAttribute_tensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$107.const$3, fi, constants$20.const$1, scope);
        }

        static KernelInfoGetAttribute_tensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_tensor$VH() {
        return constants$107.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_tensor)(struct OrtKernelInfo*,char*,struct OrtAllocator*,struct OrtValue**);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$107.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetAttribute_tensor)(struct OrtKernelInfo*,char*,struct OrtAllocator*,struct OrtValue**);
     * }
     */
    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, MemorySegment x) {
        constants$107.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$107.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$107.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_tensor KernelInfoGetAttribute_tensor(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_tensor.ofAddress(KernelInfoGetAttribute_tensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*HasSessionConfigEntry)(struct OrtSessionOptions*,char*,int*);
     * }
     */
    public interface HasSessionConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(HasSessionConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$107.const$5, fi, constants$14.const$4, scope);
        }

        static HasSessionConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle HasSessionConfigEntry$VH() {
        return constants$108.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*HasSessionConfigEntry)(struct OrtSessionOptions*,char*,int*);
     * }
     */
    public static MemorySegment HasSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$108.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*HasSessionConfigEntry)(struct OrtSessionOptions*,char*,int*);
     * }
     */
    public static void HasSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$108.const$0.set(seg, 0L, x);
    }

    public static MemorySegment HasSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$108.const$0.get(seg, index * sizeof());
    }

    public static void HasSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$108.const$0.set(seg, index * sizeof(), x);
    }

    public static HasSessionConfigEntry HasSessionConfigEntry(MemorySegment segment, Arena scope) {
        return HasSessionConfigEntry.ofAddress(HasSessionConfigEntry$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetSessionConfigEntry)(struct OrtSessionOptions*,char*,char*,unsigned long*);
     * }
     */
    public interface GetSessionConfigEntry {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetSessionConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$108.const$1, fi, constants$20.const$1, scope);
        }

        static GetSessionConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSessionConfigEntry$VH() {
        return constants$108.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSessionConfigEntry)(struct OrtSessionOptions*,char*,char*,unsigned long*);
     * }
     */
    public static MemorySegment GetSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$108.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetSessionConfigEntry)(struct OrtSessionOptions*,char*,char*,unsigned long*);
     * }
     */
    public static void GetSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$108.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$108.const$2.get(seg, index * sizeof());
    }

    public static void GetSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$108.const$2.set(seg, index * sizeof(), x);
    }

    public static GetSessionConfigEntry GetSessionConfigEntry(MemorySegment segment, Arena scope) {
        return GetSessionConfigEntry.ofAddress(GetSessionConfigEntry$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_Dnnl)(struct OrtSessionOptions*,struct OrtDnnlProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_Dnnl {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_Dnnl fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$108.const$3, fi, constants$15.const$2, scope);
        }

        static SessionOptionsAppendExecutionProvider_Dnnl ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_Dnnl$VH() {
        return constants$108.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_Dnnl)(struct OrtSessionOptions*,struct OrtDnnlProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_Dnnl$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$108.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*SessionOptionsAppendExecutionProvider_Dnnl)(struct OrtSessionOptions*,struct OrtDnnlProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_Dnnl$set(MemorySegment seg, MemorySegment x) {
        constants$108.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_Dnnl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$108.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_Dnnl$set(MemorySegment seg, long index, MemorySegment x) {
        constants$108.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_Dnnl SessionOptionsAppendExecutionProvider_Dnnl(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_Dnnl.ofAddress(
                SessionOptionsAppendExecutionProvider_Dnnl$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateDnnlProviderOptions)(struct OrtDnnlProviderOptions**);
     * }
     */
    public interface CreateDnnlProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateDnnlProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$108.const$5, fi, constants$1.const$4, scope);
        }

        static CreateDnnlProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateDnnlProviderOptions$VH() {
        return constants$109.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateDnnlProviderOptions)(struct OrtDnnlProviderOptions**);
     * }
     */
    public static MemorySegment CreateDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$109.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateDnnlProviderOptions)(struct OrtDnnlProviderOptions**);
     * }
     */
    public static void CreateDnnlProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$109.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$109.const$0.get(seg, index * sizeof());
    }

    public static void CreateDnnlProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$109.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateDnnlProviderOptions CreateDnnlProviderOptions(MemorySegment segment, Arena scope) {
        return CreateDnnlProviderOptions.ofAddress(CreateDnnlProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateDnnlProviderOptions)(struct OrtDnnlProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public interface UpdateDnnlProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateDnnlProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$109.const$1, fi, constants$83.const$1, scope);
        }

        static UpdateDnnlProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateDnnlProviderOptions$VH() {
        return constants$109.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateDnnlProviderOptions)(struct OrtDnnlProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment UpdateDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$109.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateDnnlProviderOptions)(struct OrtDnnlProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public static void UpdateDnnlProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$109.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UpdateDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$109.const$2.get(seg, index * sizeof());
    }

    public static void UpdateDnnlProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$109.const$2.set(seg, index * sizeof(), x);
    }

    public static UpdateDnnlProviderOptions UpdateDnnlProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateDnnlProviderOptions.ofAddress(UpdateDnnlProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetDnnlProviderOptionsAsString)(struct OrtDnnlProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public interface GetDnnlProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetDnnlProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$109.const$3, fi, constants$14.const$4, scope);
        }

        static GetDnnlProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDnnlProviderOptionsAsString$VH() {
        return constants$109.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDnnlProviderOptionsAsString)(struct OrtDnnlProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetDnnlProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$109.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetDnnlProviderOptionsAsString)(struct OrtDnnlProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public static void GetDnnlProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$109.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetDnnlProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$109.const$4.get(seg, index * sizeof());
    }

    public static void GetDnnlProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$109.const$4.set(seg, index * sizeof(), x);
    }

    public static GetDnnlProviderOptionsAsString GetDnnlProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetDnnlProviderOptionsAsString.ofAddress(GetDnnlProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseDnnlProviderOptions)(struct OrtDnnlProviderOptions*);
     * }
     */
    public interface ReleaseDnnlProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseDnnlProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$109.const$5, fi, constants$13.const$5, scope);
        }

        static ReleaseDnnlProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseDnnlProviderOptions$VH() {
        return constants$110.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseDnnlProviderOptions)(struct OrtDnnlProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$110.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseDnnlProviderOptions)(struct OrtDnnlProviderOptions*);
     * }
     */
    public static void ReleaseDnnlProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$110.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$110.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseDnnlProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$110.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseDnnlProviderOptions ReleaseDnnlProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseDnnlProviderOptions.ofAddress(ReleaseDnnlProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetNodeName)(struct OrtKernelInfo*,char*,unsigned long*);
     * }
     */
    public interface KernelInfo_GetNodeName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(KernelInfo_GetNodeName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$110.const$1, fi, constants$14.const$4, scope);
        }

        static KernelInfo_GetNodeName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetNodeName$VH() {
        return constants$110.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetNodeName)(struct OrtKernelInfo*,char*,unsigned long*);
     * }
     */
    public static MemorySegment KernelInfo_GetNodeName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$110.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetNodeName)(struct OrtKernelInfo*,char*,unsigned long*);
     * }
     */
    public static void KernelInfo_GetNodeName$set(MemorySegment seg, MemorySegment x) {
        constants$110.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetNodeName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$110.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetNodeName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$110.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetNodeName KernelInfo_GetNodeName(MemorySegment segment, Arena scope) {
        return KernelInfo_GetNodeName.ofAddress(KernelInfo_GetNodeName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetLogger)(struct OrtKernelInfo*,struct OrtLogger**);
     * }
     */
    public interface KernelInfo_GetLogger {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelInfo_GetLogger fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$110.const$3, fi, constants$15.const$2, scope);
        }

        static KernelInfo_GetLogger ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetLogger$VH() {
        return constants$110.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetLogger)(struct OrtKernelInfo*,struct OrtLogger**);
     * }
     */
    public static MemorySegment KernelInfo_GetLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$110.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfo_GetLogger)(struct OrtKernelInfo*,struct OrtLogger**);
     * }
     */
    public static void KernelInfo_GetLogger$set(MemorySegment seg, MemorySegment x) {
        constants$110.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$110.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetLogger$set(MemorySegment seg, long index, MemorySegment x) {
        constants$110.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetLogger KernelInfo_GetLogger(MemorySegment segment, Arena scope) {
        return KernelInfo_GetLogger.ofAddress(KernelInfo_GetLogger$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetLogger)(struct OrtKernelContext*,struct OrtLogger**);
     * }
     */
    public interface KernelContext_GetLogger {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(KernelContext_GetLogger fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$110.const$5, fi, constants$15.const$2, scope);
        }

        static KernelContext_GetLogger ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetLogger$VH() {
        return constants$111.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetLogger)(struct OrtKernelContext*,struct OrtLogger**);
     * }
     */
    public static MemorySegment KernelContext_GetLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$111.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetLogger)(struct OrtKernelContext*,struct OrtLogger**);
     * }
     */
    public static void KernelContext_GetLogger$set(MemorySegment seg, MemorySegment x) {
        constants$111.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$111.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_GetLogger$set(MemorySegment seg, long index, MemorySegment x) {
        constants$111.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetLogger KernelContext_GetLogger(MemorySegment segment, Arena scope) {
        return KernelContext_GetLogger.ofAddress(KernelContext_GetLogger$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*Logger_LogMessage)(struct OrtLogger*,enum OrtLoggingLevel,char*,char*,int,char*);
     * }
     */
    public interface Logger_LogMessage {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                int _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                int _x4,
                java.lang.foreign.MemorySegment _x5);

        static MemorySegment allocate(Logger_LogMessage fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$111.const$2, fi, constants$111.const$1, scope);
        }

        static Logger_LogMessage ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    int __x4,
                    java.lang.foreign.MemorySegment __x5) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$111.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Logger_LogMessage$VH() {
        return constants$111.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*Logger_LogMessage)(struct OrtLogger*,enum OrtLoggingLevel,char*,char*,int,char*);
     * }
     */
    public static MemorySegment Logger_LogMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$111.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*Logger_LogMessage)(struct OrtLogger*,enum OrtLoggingLevel,char*,char*,int,char*);
     * }
     */
    public static void Logger_LogMessage$set(MemorySegment seg, MemorySegment x) {
        constants$111.const$4.set(seg, 0L, x);
    }

    public static MemorySegment Logger_LogMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$111.const$4.get(seg, index * sizeof());
    }

    public static void Logger_LogMessage$set(MemorySegment seg, long index, MemorySegment x) {
        constants$111.const$4.set(seg, index * sizeof(), x);
    }

    public static Logger_LogMessage Logger_LogMessage(MemorySegment segment, Arena scope) {
        return Logger_LogMessage.ofAddress(Logger_LogMessage$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*Logger_GetLoggingSeverityLevel)(struct OrtLogger*,enum OrtLoggingLevel*);
     * }
     */
    public interface Logger_GetLoggingSeverityLevel {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(Logger_GetLoggingSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$111.const$5, fi, constants$15.const$2, scope);
        }

        static Logger_GetLoggingSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Logger_GetLoggingSeverityLevel$VH() {
        return constants$112.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*Logger_GetLoggingSeverityLevel)(struct OrtLogger*,enum OrtLoggingLevel*);
     * }
     */
    public static MemorySegment Logger_GetLoggingSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$112.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*Logger_GetLoggingSeverityLevel)(struct OrtLogger*,enum OrtLoggingLevel*);
     * }
     */
    public static void Logger_GetLoggingSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$112.const$0.set(seg, 0L, x);
    }

    public static MemorySegment Logger_GetLoggingSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$112.const$0.get(seg, index * sizeof());
    }

    public static void Logger_GetLoggingSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$112.const$0.set(seg, index * sizeof(), x);
    }

    public static Logger_GetLoggingSeverityLevel Logger_GetLoggingSeverityLevel(MemorySegment segment, Arena scope) {
        return Logger_GetLoggingSeverityLevel.ofAddress(Logger_GetLoggingSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetConstantInput_tensor)(struct OrtKernelInfo*,unsigned long,int*,struct OrtValue**);
     * }
     */
    public interface KernelInfoGetConstantInput_tensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetConstantInput_tensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$112.const$1, fi, constants$31.const$3, scope);
        }

        static KernelInfoGetConstantInput_tensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$31.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetConstantInput_tensor$VH() {
        return constants$112.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetConstantInput_tensor)(struct OrtKernelInfo*,unsigned long,int*,struct OrtValue**);
     * }
     */
    public static MemorySegment KernelInfoGetConstantInput_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$112.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelInfoGetConstantInput_tensor)(struct OrtKernelInfo*,unsigned long,int*,struct OrtValue**);
     * }
     */
    public static void KernelInfoGetConstantInput_tensor$set(MemorySegment seg, MemorySegment x) {
        constants$112.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetConstantInput_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$112.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfoGetConstantInput_tensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$112.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetConstantInput_tensor KernelInfoGetConstantInput_tensor(
            MemorySegment segment, Arena scope) {
        return KernelInfoGetConstantInput_tensor.ofAddress(KernelInfoGetConstantInput_tensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToOptionalTypeInfo)(struct OrtTypeInfo*,struct OrtOptionalTypeInfo**);
     * }
     */
    public interface CastTypeInfoToOptionalTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(CastTypeInfoToOptionalTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$112.const$3, fi, constants$15.const$2, scope);
        }

        static CastTypeInfoToOptionalTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToOptionalTypeInfo$VH() {
        return constants$112.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToOptionalTypeInfo)(struct OrtTypeInfo*,struct OrtOptionalTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToOptionalTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$112.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CastTypeInfoToOptionalTypeInfo)(struct OrtTypeInfo*,struct OrtOptionalTypeInfo**);
     * }
     */
    public static void CastTypeInfoToOptionalTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$112.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToOptionalTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$112.const$4.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToOptionalTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$112.const$4.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToOptionalTypeInfo CastTypeInfoToOptionalTypeInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToOptionalTypeInfo.ofAddress(CastTypeInfoToOptionalTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetOptionalContainedTypeInfo)(struct OrtOptionalTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public interface GetOptionalContainedTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment options, java.lang.foreign.MemorySegment api);

        static MemorySegment allocate(GetOptionalContainedTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$112.const$5, fi, constants$15.const$2, scope);
        }

        static GetOptionalContainedTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _options, java.lang.foreign.MemorySegment _api) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, _options, _api);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOptionalContainedTypeInfo$VH() {
        return constants$113.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetOptionalContainedTypeInfo)(struct OrtOptionalTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetOptionalContainedTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$113.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetOptionalContainedTypeInfo)(struct OrtOptionalTypeInfo*,struct OrtTypeInfo**);
     * }
     */
    public static void GetOptionalContainedTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$113.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetOptionalContainedTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$113.const$0.get(seg, index * sizeof());
    }

    public static void GetOptionalContainedTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$113.const$0.set(seg, index * sizeof(), x);
    }

    public static GetOptionalContainedTypeInfo GetOptionalContainedTypeInfo(MemorySegment segment, Arena scope) {
        return GetOptionalContainedTypeInfo.ofAddress(GetOptionalContainedTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetResizedStringTensorElementBuffer)(struct OrtValue*,unsigned long,unsigned long,char**);
     * }
     */
    public interface GetResizedStringTensorElementBuffer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, long _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetResizedStringTensorElementBuffer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$113.const$1, fi, constants$66.const$3, scope);
        }

        static GetResizedStringTensorElementBuffer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$66.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetResizedStringTensorElementBuffer$VH() {
        return constants$113.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetResizedStringTensorElementBuffer)(struct OrtValue*,unsigned long,unsigned long,char**);
     * }
     */
    public static MemorySegment GetResizedStringTensorElementBuffer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$113.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetResizedStringTensorElementBuffer)(struct OrtValue*,unsigned long,unsigned long,char**);
     * }
     */
    public static void GetResizedStringTensorElementBuffer$set(MemorySegment seg, MemorySegment x) {
        constants$113.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetResizedStringTensorElementBuffer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$113.const$2.get(seg, index * sizeof());
    }

    public static void GetResizedStringTensorElementBuffer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$113.const$2.set(seg, index * sizeof(), x);
    }

    public static GetResizedStringTensorElementBuffer GetResizedStringTensorElementBuffer(
            MemorySegment segment, Arena scope) {
        return GetResizedStringTensorElementBuffer.ofAddress(GetResizedStringTensorElementBuffer$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetAllocator)(struct OrtKernelContext*,struct OrtMemoryInfo*,struct OrtAllocator**);
     * }
     */
    public interface KernelContext_GetAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(KernelContext_GetAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$113.const$3, fi, constants$14.const$4, scope);
        }

        static KernelContext_GetAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetAllocator$VH() {
        return constants$113.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetAllocator)(struct OrtKernelContext*,struct OrtMemoryInfo*,struct OrtAllocator**);
     * }
     */
    public static MemorySegment KernelContext_GetAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$113.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetAllocator)(struct OrtKernelContext*,struct OrtMemoryInfo*,struct OrtAllocator**);
     * }
     */
    public static void KernelContext_GetAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$113.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$113.const$4.get(seg, index * sizeof());
    }

    public static void KernelContext_GetAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$113.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetAllocator KernelContext_GetAllocator(MemorySegment segment, Arena scope) {
        return KernelContext_GetAllocator.ofAddress(KernelContext_GetAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * char* (*GetBuildInfoString)();
     * }
     */
    public interface GetBuildInfoString {

        java.lang.foreign.MemorySegment apply();

        static MemorySegment allocate(GetBuildInfoString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$113.const$5, fi, constants$13.const$0, scope);
        }

        static GetBuildInfoString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return () -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$13.const$2.invokeExact(symbol);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetBuildInfoString$VH() {
        return constants$114.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetBuildInfoString)();
     * }
     */
    public static MemorySegment GetBuildInfoString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$114.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetBuildInfoString)();
     * }
     */
    public static void GetBuildInfoString$set(MemorySegment seg, MemorySegment x) {
        constants$114.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetBuildInfoString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$114.const$0.get(seg, index * sizeof());
    }

    public static void GetBuildInfoString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$114.const$0.set(seg, index * sizeof(), x);
    }

    public static GetBuildInfoString GetBuildInfoString(MemorySegment segment, Arena scope) {
        return GetBuildInfoString.ofAddress(GetBuildInfoString$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateROCMProviderOptions)(struct OrtROCMProviderOptions**);
     * }
     */
    public interface CreateROCMProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateROCMProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$114.const$1, fi, constants$1.const$4, scope);
        }

        static CreateROCMProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateROCMProviderOptions$VH() {
        return constants$114.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateROCMProviderOptions)(struct OrtROCMProviderOptions**);
     * }
     */
    public static MemorySegment CreateROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$114.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateROCMProviderOptions)(struct OrtROCMProviderOptions**);
     * }
     */
    public static void CreateROCMProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$114.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$114.const$2.get(seg, index * sizeof());
    }

    public static void CreateROCMProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$114.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateROCMProviderOptions CreateROCMProviderOptions(MemorySegment segment, Arena scope) {
        return CreateROCMProviderOptions.ofAddress(CreateROCMProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateROCMProviderOptions)(struct OrtROCMProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public interface UpdateROCMProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateROCMProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$114.const$3, fi, constants$83.const$1, scope);
        }

        static UpdateROCMProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateROCMProviderOptions$VH() {
        return constants$114.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateROCMProviderOptions)(struct OrtROCMProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment UpdateROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$114.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateROCMProviderOptions)(struct OrtROCMProviderOptions*,char**,char**,unsigned long);
     * }
     */
    public static void UpdateROCMProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$114.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UpdateROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$114.const$4.get(seg, index * sizeof());
    }

    public static void UpdateROCMProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$114.const$4.set(seg, index * sizeof(), x);
    }

    public static UpdateROCMProviderOptions UpdateROCMProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateROCMProviderOptions.ofAddress(UpdateROCMProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetROCMProviderOptionsAsString)(struct OrtROCMProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public interface GetROCMProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetROCMProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$114.const$5, fi, constants$14.const$4, scope);
        }

        static GetROCMProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetROCMProviderOptionsAsString$VH() {
        return constants$115.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetROCMProviderOptionsAsString)(struct OrtROCMProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetROCMProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$115.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetROCMProviderOptionsAsString)(struct OrtROCMProviderOptions*,struct OrtAllocator*,char**);
     * }
     */
    public static void GetROCMProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$115.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetROCMProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$115.const$0.get(seg, index * sizeof());
    }

    public static void GetROCMProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$115.const$0.set(seg, index * sizeof(), x);
    }

    public static GetROCMProviderOptionsAsString GetROCMProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetROCMProviderOptionsAsString.ofAddress(GetROCMProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseROCMProviderOptions)(struct OrtROCMProviderOptions*);
     * }
     */
    public interface ReleaseROCMProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseROCMProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$115.const$1, fi, constants$13.const$5, scope);
        }

        static ReleaseROCMProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseROCMProviderOptions$VH() {
        return constants$115.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseROCMProviderOptions)(struct OrtROCMProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$115.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseROCMProviderOptions)(struct OrtROCMProviderOptions*);
     * }
     */
    public static void ReleaseROCMProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$115.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$115.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseROCMProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$115.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseROCMProviderOptions ReleaseROCMProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseROCMProviderOptions.ofAddress(ReleaseROCMProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*CreateAndRegisterAllocatorV2)(struct OrtEnv*,char*,struct OrtMemoryInfo*,struct OrtArenaCfg*,char**,char**,unsigned long);
     * }
     */
    public interface CreateAndRegisterAllocatorV2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                java.lang.foreign.MemorySegment _x4,
                java.lang.foreign.MemorySegment _x5,
                long _x6);

        static MemorySegment allocate(CreateAndRegisterAllocatorV2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$115.const$4, fi, constants$115.const$3, scope);
        }

        static CreateAndRegisterAllocatorV2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    java.lang.foreign.MemorySegment __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$115.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateAndRegisterAllocatorV2$VH() {
        return constants$116.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateAndRegisterAllocatorV2)(struct OrtEnv*,char*,struct OrtMemoryInfo*,struct OrtArenaCfg*,char**,char**,unsigned long);
     * }
     */
    public static MemorySegment CreateAndRegisterAllocatorV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$116.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*CreateAndRegisterAllocatorV2)(struct OrtEnv*,char*,struct OrtMemoryInfo*,struct OrtArenaCfg*,char**,char**,unsigned long);
     * }
     */
    public static void CreateAndRegisterAllocatorV2$set(MemorySegment seg, MemorySegment x) {
        constants$116.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateAndRegisterAllocatorV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$116.const$0.get(seg, index * sizeof());
    }

    public static void CreateAndRegisterAllocatorV2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$116.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateAndRegisterAllocatorV2 CreateAndRegisterAllocatorV2(MemorySegment segment, Arena scope) {
        return CreateAndRegisterAllocatorV2.ofAddress(CreateAndRegisterAllocatorV2$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*RunAsync)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**,void (*)(void*,struct OrtValue**,unsigned long,struct OrtStatus*),void*);
     * }
     */
    public interface RunAsync {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3,
                long _x4,
                java.lang.foreign.MemorySegment _x5,
                long _x6,
                java.lang.foreign.MemorySegment _x7,
                java.lang.foreign.MemorySegment _x8,
                java.lang.foreign.MemorySegment _x9);

        static MemorySegment allocate(RunAsync fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$116.const$2, fi, constants$116.const$1, scope);
        }

        static RunAsync ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3,
                    long __x4,
                    java.lang.foreign.MemorySegment __x5,
                    long __x6,
                    java.lang.foreign.MemorySegment __x7,
                    java.lang.foreign.MemorySegment __x8,
                    java.lang.foreign.MemorySegment __x9) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$116.const$3.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8, __x9);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunAsync$VH() {
        return constants$116.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*RunAsync)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**,void (*)(void*,struct OrtValue**,unsigned long,struct OrtStatus*),void*);
     * }
     */
    public static MemorySegment RunAsync$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$116.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*RunAsync)(struct OrtSession*,struct OrtRunOptions*,char**,struct OrtValue**,unsigned long,char**,unsigned long,struct OrtValue**,void (*)(void*,struct OrtValue**,unsigned long,struct OrtStatus*),void*);
     * }
     */
    public static void RunAsync$set(MemorySegment seg, MemorySegment x) {
        constants$116.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunAsync$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$116.const$4.get(seg, index * sizeof());
    }

    public static void RunAsync$set(MemorySegment seg, long index, MemorySegment x) {
        constants$116.const$4.set(seg, index * sizeof(), x);
    }

    public static RunAsync RunAsync(MemorySegment segment, Arena scope) {
        return RunAsync.ofAddress(RunAsync$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateTensorRTProviderOptionsWithValue)(struct OrtTensorRTProviderOptionsV2*,char*,void*);
     * }
     */
    public interface UpdateTensorRTProviderOptionsWithValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(UpdateTensorRTProviderOptionsWithValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$116.const$5, fi, constants$14.const$4, scope);
        }

        static UpdateTensorRTProviderOptionsWithValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateTensorRTProviderOptionsWithValue$VH() {
        return constants$117.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateTensorRTProviderOptionsWithValue)(struct OrtTensorRTProviderOptionsV2*,char*,void*);
     * }
     */
    public static MemorySegment UpdateTensorRTProviderOptionsWithValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$117.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateTensorRTProviderOptionsWithValue)(struct OrtTensorRTProviderOptionsV2*,char*,void*);
     * }
     */
    public static void UpdateTensorRTProviderOptionsWithValue$set(MemorySegment seg, MemorySegment x) {
        constants$117.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UpdateTensorRTProviderOptionsWithValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$117.const$0.get(seg, index * sizeof());
    }

    public static void UpdateTensorRTProviderOptionsWithValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$117.const$0.set(seg, index * sizeof(), x);
    }

    public static UpdateTensorRTProviderOptionsWithValue UpdateTensorRTProviderOptionsWithValue(
            MemorySegment segment, Arena scope) {
        return UpdateTensorRTProviderOptionsWithValue.ofAddress(
                UpdateTensorRTProviderOptionsWithValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetTensorRTProviderOptionsByName)(struct OrtTensorRTProviderOptionsV2*,char*,void**);
     * }
     */
    public interface GetTensorRTProviderOptionsByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetTensorRTProviderOptionsByName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$117.const$1, fi, constants$14.const$4, scope);
        }

        static GetTensorRTProviderOptionsByName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorRTProviderOptionsByName$VH() {
        return constants$117.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorRTProviderOptionsByName)(struct OrtTensorRTProviderOptionsV2*,char*,void**);
     * }
     */
    public static MemorySegment GetTensorRTProviderOptionsByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$117.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetTensorRTProviderOptionsByName)(struct OrtTensorRTProviderOptionsV2*,char*,void**);
     * }
     */
    public static void GetTensorRTProviderOptionsByName$set(MemorySegment seg, MemorySegment x) {
        constants$117.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorRTProviderOptionsByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$117.const$2.get(seg, index * sizeof());
    }

    public static void GetTensorRTProviderOptionsByName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$117.const$2.set(seg, index * sizeof(), x);
    }

    public static GetTensorRTProviderOptionsByName GetTensorRTProviderOptionsByName(
            MemorySegment segment, Arena scope) {
        return GetTensorRTProviderOptionsByName.ofAddress(GetTensorRTProviderOptionsByName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*UpdateCUDAProviderOptionsWithValue)(struct OrtCUDAProviderOptionsV2*,char*,void*);
     * }
     */
    public interface UpdateCUDAProviderOptionsWithValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(UpdateCUDAProviderOptionsWithValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$117.const$3, fi, constants$14.const$4, scope);
        }

        static UpdateCUDAProviderOptionsWithValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateCUDAProviderOptionsWithValue$VH() {
        return constants$117.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateCUDAProviderOptionsWithValue)(struct OrtCUDAProviderOptionsV2*,char*,void*);
     * }
     */
    public static MemorySegment UpdateCUDAProviderOptionsWithValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$117.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*UpdateCUDAProviderOptionsWithValue)(struct OrtCUDAProviderOptionsV2*,char*,void*);
     * }
     */
    public static void UpdateCUDAProviderOptionsWithValue$set(MemorySegment seg, MemorySegment x) {
        constants$117.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UpdateCUDAProviderOptionsWithValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$117.const$4.get(seg, index * sizeof());
    }

    public static void UpdateCUDAProviderOptionsWithValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$117.const$4.set(seg, index * sizeof(), x);
    }

    public static UpdateCUDAProviderOptionsWithValue UpdateCUDAProviderOptionsWithValue(
            MemorySegment segment, Arena scope) {
        return UpdateCUDAProviderOptionsWithValue.ofAddress(UpdateCUDAProviderOptionsWithValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*GetCUDAProviderOptionsByName)(struct OrtCUDAProviderOptionsV2*,char*,void**);
     * }
     */
    public interface GetCUDAProviderOptionsByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(GetCUDAProviderOptionsByName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$117.const$5, fi, constants$14.const$4, scope);
        }

        static GetCUDAProviderOptionsByName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCUDAProviderOptionsByName$VH() {
        return constants$118.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCUDAProviderOptionsByName)(struct OrtCUDAProviderOptionsV2*,char*,void**);
     * }
     */
    public static MemorySegment GetCUDAProviderOptionsByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$118.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*GetCUDAProviderOptionsByName)(struct OrtCUDAProviderOptionsV2*,char*,void**);
     * }
     */
    public static void GetCUDAProviderOptionsByName$set(MemorySegment seg, MemorySegment x) {
        constants$118.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetCUDAProviderOptionsByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$118.const$0.get(seg, index * sizeof());
    }

    public static void GetCUDAProviderOptionsByName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$118.const$0.set(seg, index * sizeof(), x);
    }

    public static GetCUDAProviderOptionsByName GetCUDAProviderOptionsByName(MemorySegment segment, Arena scope) {
        return GetCUDAProviderOptionsByName.ofAddress(GetCUDAProviderOptionsByName$get(segment), scope);
    }
    /**
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetResource)(struct OrtKernelContext*,int,int,void**);
     * }
     */
    public interface KernelContext_GetResource {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, int _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelContext_GetResource fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$118.const$2, fi, constants$118.const$1, scope);
        }

        static KernelContext_GetResource ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1, int __x2, java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$118.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetResource$VH() {
        return constants$118.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetResource)(struct OrtKernelContext*,int,int,void**);
     * }
     */
    public static MemorySegment KernelContext_GetResource$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$118.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * struct OrtStatus* (*KernelContext_GetResource)(struct OrtKernelContext*,int,int,void**);
     * }
     */
    public static void KernelContext_GetResource$set(MemorySegment seg, MemorySegment x) {
        constants$118.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetResource$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$118.const$4.get(seg, index * sizeof());
    }

    public static void KernelContext_GetResource$set(MemorySegment seg, long index, MemorySegment x) {
        constants$118.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetResource KernelContext_GetResource(MemorySegment segment, Arena scope) {
        return KernelContext_GetResource.ofAddress(KernelContext_GetResource$get(segment), scope);
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

    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
