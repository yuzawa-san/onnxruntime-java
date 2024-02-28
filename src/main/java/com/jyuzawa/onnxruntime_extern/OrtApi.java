/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
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
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_Dnnl)(OrtSessionOptions*,const OrtDnnlProviderOptions*);
 *     OrtStatusPtr (*CreateDnnlProviderOptions)(OrtDnnlProviderOptions**);
 *     OrtStatusPtr (*UpdateDnnlProviderOptions)(OrtDnnlProviderOptions*,char**,char**,size_t);
 *     OrtStatusPtr (*GetDnnlProviderOptionsAsString)(const OrtDnnlProviderOptions*,OrtAllocator*,char**);
 *     void (*ReleaseDnnlProviderOptions)(OrtDnnlProviderOptions*);
 *     OrtStatusPtr (*KernelInfo_GetNodeName)(const OrtKernelInfo*,char*,size_t*);
 *     OrtStatusPtr (*KernelInfo_GetLogger)(const OrtKernelInfo*,const OrtLogger**);
 *     OrtStatusPtr (*KernelContext_GetLogger)(const OrtKernelContext*,const OrtLogger**);
 *     OrtStatusPtr (*Logger_LogMessage)(const OrtLogger*,OrtLoggingLevel,char*,char*,int,char*);
 *     OrtStatusPtr (*Logger_GetLoggingSeverityLevel)(const OrtLogger*,OrtLoggingLevel*);
 *     OrtStatusPtr (*KernelInfoGetConstantInput_tensor)(const OrtKernelInfo*,size_t,int*,const OrtValue**);
 *     OrtStatusPtr (*CastTypeInfoToOptionalTypeInfo)(const OrtTypeInfo*,const OrtOptionalTypeInfo**);
 *     OrtStatusPtr (*GetOptionalContainedTypeInfo)(const OrtOptionalTypeInfo*,OrtTypeInfo**);
 *     OrtStatusPtr (*GetResizedStringTensorElementBuffer)(OrtValue*,size_t,size_t,char**);
 *     OrtStatusPtr (*KernelContext_GetAllocator)(const OrtKernelContext*,const OrtMemoryInfo*,OrtAllocator**);
 *     char* (*GetBuildInfoString)();
 *     OrtStatusPtr (*CreateROCMProviderOptions)(OrtROCMProviderOptions**);
 *     OrtStatusPtr (*UpdateROCMProviderOptions)(OrtROCMProviderOptions*,char**,char**,size_t);
 *     OrtStatusPtr (*GetROCMProviderOptionsAsString)(const OrtROCMProviderOptions*,OrtAllocator*,char**);
 *     void (*ReleaseROCMProviderOptions)(OrtROCMProviderOptions*);
 *     OrtStatusPtr (*CreateAndRegisterAllocatorV2)(OrtEnv*,char*,const OrtMemoryInfo*,const OrtArenaCfg*,char**,char**,size_t);
 *     OrtStatusPtr (*RunAsync)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**,RunAsyncCallbackFn,void*);
 *     OrtStatusPtr (*UpdateTensorRTProviderOptionsWithValue)(OrtTensorRTProviderOptionsV2*,char*,void*);
 *     OrtStatusPtr (*GetTensorRTProviderOptionsByName)(const OrtTensorRTProviderOptionsV2*,char*,void**);
 *     OrtStatusPtr (*UpdateCUDAProviderOptionsWithValue)(OrtCUDAProviderOptionsV2*,char*,void*);
 *     OrtStatusPtr (*GetCUDAProviderOptionsByName)(const OrtCUDAProviderOptionsV2*,char*,void**);
 *     OrtStatusPtr (*KernelContext_GetResource)(const OrtKernelContext*,int,int,void**);
 *     OrtStatusPtr (*SetUserLoggingFunction)(OrtSessionOptions*,OrtLoggingFunction,void*);
 *     OrtStatusPtr (*ShapeInferContext_GetInputCount)(const OrtShapeInferContext*,size_t*);
 *     OrtStatusPtr (*ShapeInferContext_GetInputTypeShape)(const OrtShapeInferContext*,size_t,OrtTensorTypeAndShapeInfo**);
 *     OrtStatusPtr (*ShapeInferContext_GetAttribute)(const OrtShapeInferContext*,char*,const OrtOpAttr**);
 *     OrtStatusPtr (*ShapeInferContext_SetOutputTypeShape)(const OrtShapeInferContext*,size_t,const OrtTensorTypeAndShapeInfo*);
 *     OrtStatusPtr (*SetSymbolicDimensions)(OrtTensorTypeAndShapeInfo*,char**,size_t);
 *     OrtStatusPtr (*ReadOpAttr)(const OrtOpAttr*,OrtOpAttrType,void*,size_t,size_t*);
 *     OrtStatusPtr (*SetDeterministicCompute)(OrtSessionOptions*,_Bool);
 *     OrtStatusPtr (*KernelContext_ParallelFor)(const OrtKernelContext*,void (*)(void*,size_t),size_t,size_t,void*);
 *     OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO_V2)(OrtSessionOptions*,char**,char**,size_t);
 * };
 * }
 */
public class OrtApi {

    public static MemoryLayout $LAYOUT() {
        return constants$16.const$4;
    }
    /**
     * {@snippet :
     * OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
     * }
     */
    public interface CreateStatus {

        java.lang.foreign.MemorySegment apply(int _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateStatus fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$17.const$0, fi, constants$16.const$5, scope);
        }

        static CreateStatus ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$17.const$1.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateStatus$VH() {
        return constants$17.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
     * }
     */
    public static MemorySegment CreateStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$17.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatus* (*CreateStatus)(OrtErrorCode,char*);
     * }
     */
    public static void CreateStatus$set(MemorySegment seg, MemorySegment x) {
        constants$17.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$17.const$2.get(seg, index * sizeof());
    }

    public static void CreateStatus$set(MemorySegment seg, long index, MemorySegment x) {
        constants$17.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateStatus CreateStatus(MemorySegment segment, Arena scope) {
        return CreateStatus.ofAddress(CreateStatus$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtErrorCode (*GetErrorCode)(const OrtStatus*);
     * }
     */
    public interface GetErrorCode {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetErrorCode fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$17.const$4, fi, constants$17.const$3, scope);
        }

        static GetErrorCode ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) constants$17.const$5.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetErrorCode$VH() {
        return constants$18.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtErrorCode (*GetErrorCode)(const OrtStatus*);
     * }
     */
    public static MemorySegment GetErrorCode$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$18.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtErrorCode (*GetErrorCode)(const OrtStatus*);
     * }
     */
    public static void GetErrorCode$set(MemorySegment seg, MemorySegment x) {
        constants$18.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetErrorCode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$18.const$0.get(seg, index * sizeof());
    }

    public static void GetErrorCode$set(MemorySegment seg, long index, MemorySegment x) {
        constants$18.const$0.set(seg, index * sizeof(), x);
    }

    public static GetErrorCode GetErrorCode(MemorySegment segment, Arena scope) {
        return GetErrorCode.ofAddress(GetErrorCode$get(segment), scope);
    }
    /**
     * {@snippet :
     * char* (*GetErrorMessage)(const OrtStatus*);
     * }
     */
    public interface GetErrorMessage {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetErrorMessage fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$18.const$1, fi, constants$1.const$4, scope);
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
        return constants$18.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetErrorMessage)(const OrtStatus*);
     * }
     */
    public static MemorySegment GetErrorMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$18.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetErrorMessage)(const OrtStatus*);
     * }
     */
    public static void GetErrorMessage$set(MemorySegment seg, MemorySegment x) {
        constants$18.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetErrorMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$18.const$2.get(seg, index * sizeof());
    }

    public static void GetErrorMessage$set(MemorySegment seg, long index, MemorySegment x) {
        constants$18.const$2.set(seg, index * sizeof(), x);
    }

    public static GetErrorMessage GetErrorMessage(MemorySegment segment, Arena scope) {
        return GetErrorMessage.ofAddress(GetErrorMessage$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public interface CreateEnv {

        java.lang.foreign.MemorySegment apply(
                int _x0, java.lang.foreign.MemorySegment _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateEnv fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$18.const$4, fi, constants$18.const$3, scope);
        }

        static CreateEnv ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0, java.lang.foreign.MemorySegment __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$18.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnv$VH() {
        return constants$19.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$19.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnv)(OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static void CreateEnv$set(MemorySegment seg, MemorySegment x) {
        constants$19.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$19.const$0.get(seg, index * sizeof());
    }

    public static void CreateEnv$set(MemorySegment seg, long index, MemorySegment x) {
        constants$19.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateEnv CreateEnv(MemorySegment segment, Arena scope) {
        return CreateEnv.ofAddress(CreateEnv$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateEnvWithCustomLogger fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$19.const$2, fi, constants$19.const$1, scope);
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
                            constants$19.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnvWithCustomLogger$VH() {
        return constants$19.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLogger)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithCustomLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$19.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLogger)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,OrtEnv**);
     * }
     */
    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, MemorySegment x) {
        constants$19.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnvWithCustomLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$19.const$4.get(seg, index * sizeof());
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, long index, MemorySegment x) {
        constants$19.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateEnvWithCustomLogger CreateEnvWithCustomLogger(MemorySegment segment, Arena scope) {
        return CreateEnvWithCustomLogger.ofAddress(CreateEnvWithCustomLogger$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public interface EnableTelemetryEvents {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableTelemetryEvents fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$19.const$5, fi, constants$1.const$4, scope);
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
        return constants$20.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static MemorySegment EnableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$20.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static void EnableTelemetryEvents$set(MemorySegment seg, MemorySegment x) {
        constants$20.const$0.set(seg, 0L, x);
    }

    public static MemorySegment EnableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$20.const$0.get(seg, index * sizeof());
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, long index, MemorySegment x) {
        constants$20.const$0.set(seg, index * sizeof(), x);
    }

    public static EnableTelemetryEvents EnableTelemetryEvents(MemorySegment segment, Arena scope) {
        return EnableTelemetryEvents.ofAddress(EnableTelemetryEvents$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public interface DisableTelemetryEvents {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableTelemetryEvents fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$20.const$1, fi, constants$1.const$4, scope);
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
        return constants$20.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static MemorySegment DisableTelemetryEvents$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$20.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableTelemetryEvents)(const OrtEnv*);
     * }
     */
    public static void DisableTelemetryEvents$set(MemorySegment seg, MemorySegment x) {
        constants$20.const$2.set(seg, 0L, x);
    }

    public static MemorySegment DisableTelemetryEvents$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$20.const$2.get(seg, index * sizeof());
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, long index, MemorySegment x) {
        constants$20.const$2.set(seg, index * sizeof(), x);
    }

    public static DisableTelemetryEvents DisableTelemetryEvents(MemorySegment segment, Arena scope) {
        return DisableTelemetryEvents.ofAddress(DisableTelemetryEvents$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateSession fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$20.const$4, fi, constants$20.const$3, scope);
        }

        static CreateSession ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSession$VH() {
        return constants$21.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSession)(const OrtEnv*,char*,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$21.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSession)(const OrtEnv*,char*,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static void CreateSession$set(MemorySegment seg, MemorySegment x) {
        constants$21.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$21.const$0.get(seg, index * sizeof());
    }

    public static void CreateSession$set(MemorySegment seg, long index, MemorySegment x) {
        constants$21.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateSession CreateSession(MemorySegment segment, Arena scope) {
        return CreateSession.ofAddress(CreateSession$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateSessionFromArray fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$21.const$2, fi, constants$21.const$1, scope);
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
                            constants$21.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionFromArray$VH() {
        return constants$21.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArray)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionFromArray$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$21.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArray)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtSession**);
     * }
     */
    public static void CreateSessionFromArray$set(MemorySegment seg, MemorySegment x) {
        constants$21.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionFromArray$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$21.const$4.get(seg, index * sizeof());
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, long index, MemorySegment x) {
        constants$21.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateSessionFromArray CreateSessionFromArray(MemorySegment segment, Arena scope) {
        return CreateSessionFromArray.ofAddress(CreateSessionFromArray$get(segment), scope);
    }
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

        static MemorySegment allocate(Run fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$22.const$0, fi, constants$21.const$5, scope);
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
                            constants$22.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Run$VH() {
        return constants$22.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*Run)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**);
     * }
     */
    public static MemorySegment Run$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$22.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*Run)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**);
     * }
     */
    public static void Run$set(MemorySegment seg, MemorySegment x) {
        constants$22.const$2.set(seg, 0L, x);
    }

    public static MemorySegment Run$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$22.const$2.get(seg, index * sizeof());
    }

    public static void Run$set(MemorySegment seg, long index, MemorySegment x) {
        constants$22.const$2.set(seg, index * sizeof(), x);
    }

    public static Run Run(MemorySegment segment, Arena scope) {
        return Run.ofAddress(Run$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
     * }
     */
    public interface CreateSessionOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateSessionOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$22.const$3, fi, constants$1.const$4, scope);
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
        return constants$22.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
     * }
     */
    public static MemorySegment CreateSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$22.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionOptions)(OrtSessionOptions**);
     * }
     */
    public static void CreateSessionOptions$set(MemorySegment seg, MemorySegment x) {
        constants$22.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$22.const$4.get(seg, index * sizeof());
    }

    public static void CreateSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$22.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateSessionOptions CreateSessionOptions(MemorySegment segment, Arena scope) {
        return CreateSessionOptions.ofAddress(CreateSessionOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
     * }
     */
    public interface SetOptimizedModelFilePath {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetOptimizedModelFilePath fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$22.const$5, fi, constants$15.const$4, scope);
        }

        static SetOptimizedModelFilePath ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetOptimizedModelFilePath$VH() {
        return constants$23.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment SetOptimizedModelFilePath$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$23.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetOptimizedModelFilePath)(OrtSessionOptions*,char*);
     * }
     */
    public static void SetOptimizedModelFilePath$set(MemorySegment seg, MemorySegment x) {
        constants$23.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetOptimizedModelFilePath$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$23.const$0.get(seg, index * sizeof());
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, long index, MemorySegment x) {
        constants$23.const$0.set(seg, index * sizeof(), x);
    }

    public static SetOptimizedModelFilePath SetOptimizedModelFilePath(MemorySegment segment, Arena scope) {
        return SetOptimizedModelFilePath.ofAddress(SetOptimizedModelFilePath$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
     * }
     */
    public interface CloneSessionOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CloneSessionOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$23.const$1, fi, constants$15.const$4, scope);
        }

        static CloneSessionOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CloneSessionOptions$VH() {
        return constants$23.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
     * }
     */
    public static MemorySegment CloneSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$23.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CloneSessionOptions)(const OrtSessionOptions*,OrtSessionOptions**);
     * }
     */
    public static void CloneSessionOptions$set(MemorySegment seg, MemorySegment x) {
        constants$23.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CloneSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$23.const$2.get(seg, index * sizeof());
    }

    public static void CloneSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$23.const$2.set(seg, index * sizeof(), x);
    }

    public static CloneSessionOptions CloneSessionOptions(MemorySegment segment, Arena scope) {
        return CloneSessionOptions.ofAddress(CloneSessionOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
     * }
     */
    public interface SetSessionExecutionMode {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionExecutionMode fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$23.const$4, fi, constants$23.const$3, scope);
        }

        static SetSessionExecutionMode ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionExecutionMode$VH() {
        return constants$24.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
     * }
     */
    public static MemorySegment SetSessionExecutionMode$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$24.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionExecutionMode)(OrtSessionOptions*,ExecutionMode);
     * }
     */
    public static void SetSessionExecutionMode$set(MemorySegment seg, MemorySegment x) {
        constants$24.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionExecutionMode$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$24.const$0.get(seg, index * sizeof());
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, long index, MemorySegment x) {
        constants$24.const$0.set(seg, index * sizeof(), x);
    }

    public static SetSessionExecutionMode SetSessionExecutionMode(MemorySegment segment, Arena scope) {
        return SetSessionExecutionMode.ofAddress(SetSessionExecutionMode$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
     * }
     */
    public interface EnableProfiling {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(EnableProfiling fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$24.const$1, fi, constants$15.const$4, scope);
        }

        static EnableProfiling ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle EnableProfiling$VH() {
        return constants$24.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment EnableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$24.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableProfiling)(OrtSessionOptions*,char*);
     * }
     */
    public static void EnableProfiling$set(MemorySegment seg, MemorySegment x) {
        constants$24.const$2.set(seg, 0L, x);
    }

    public static MemorySegment EnableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$24.const$2.get(seg, index * sizeof());
    }

    public static void EnableProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        constants$24.const$2.set(seg, index * sizeof(), x);
    }

    public static EnableProfiling EnableProfiling(MemorySegment segment, Arena scope) {
        return EnableProfiling.ofAddress(EnableProfiling$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
     * }
     */
    public interface DisableProfiling {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableProfiling fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$24.const$3, fi, constants$1.const$4, scope);
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
        return constants$24.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$24.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableProfiling)(OrtSessionOptions*);
     * }
     */
    public static void DisableProfiling$set(MemorySegment seg, MemorySegment x) {
        constants$24.const$4.set(seg, 0L, x);
    }

    public static MemorySegment DisableProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$24.const$4.get(seg, index * sizeof());
    }

    public static void DisableProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        constants$24.const$4.set(seg, index * sizeof(), x);
    }

    public static DisableProfiling DisableProfiling(MemorySegment segment, Arena scope) {
        return DisableProfiling.ofAddress(DisableProfiling$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
     * }
     */
    public interface EnableMemPattern {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableMemPattern fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$24.const$5, fi, constants$1.const$4, scope);
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
        return constants$25.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$25.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static void EnableMemPattern$set(MemorySegment seg, MemorySegment x) {
        constants$25.const$0.set(seg, 0L, x);
    }

    public static MemorySegment EnableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$25.const$0.get(seg, index * sizeof());
    }

    public static void EnableMemPattern$set(MemorySegment seg, long index, MemorySegment x) {
        constants$25.const$0.set(seg, index * sizeof(), x);
    }

    public static EnableMemPattern EnableMemPattern(MemorySegment segment, Arena scope) {
        return EnableMemPattern.ofAddress(EnableMemPattern$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
     * }
     */
    public interface DisableMemPattern {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableMemPattern fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$25.const$1, fi, constants$1.const$4, scope);
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
        return constants$25.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableMemPattern$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$25.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableMemPattern)(OrtSessionOptions*);
     * }
     */
    public static void DisableMemPattern$set(MemorySegment seg, MemorySegment x) {
        constants$25.const$2.set(seg, 0L, x);
    }

    public static MemorySegment DisableMemPattern$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$25.const$2.get(seg, index * sizeof());
    }

    public static void DisableMemPattern$set(MemorySegment seg, long index, MemorySegment x) {
        constants$25.const$2.set(seg, index * sizeof(), x);
    }

    public static DisableMemPattern DisableMemPattern(MemorySegment segment, Arena scope) {
        return DisableMemPattern.ofAddress(DisableMemPattern$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public interface EnableCpuMemArena {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableCpuMemArena fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$25.const$3, fi, constants$1.const$4, scope);
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
        return constants$25.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$25.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static void EnableCpuMemArena$set(MemorySegment seg, MemorySegment x) {
        constants$25.const$4.set(seg, 0L, x);
    }

    public static MemorySegment EnableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$25.const$4.get(seg, index * sizeof());
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, long index, MemorySegment x) {
        constants$25.const$4.set(seg, index * sizeof(), x);
    }

    public static EnableCpuMemArena EnableCpuMemArena(MemorySegment segment, Arena scope) {
        return EnableCpuMemArena.ofAddress(EnableCpuMemArena$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public interface DisableCpuMemArena {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisableCpuMemArena fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$25.const$5, fi, constants$1.const$4, scope);
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
        return constants$26.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisableCpuMemArena$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$26.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisableCpuMemArena)(OrtSessionOptions*);
     * }
     */
    public static void DisableCpuMemArena$set(MemorySegment seg, MemorySegment x) {
        constants$26.const$0.set(seg, 0L, x);
    }

    public static MemorySegment DisableCpuMemArena$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$26.const$0.get(seg, index * sizeof());
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, long index, MemorySegment x) {
        constants$26.const$0.set(seg, index * sizeof(), x);
    }

    public static DisableCpuMemArena DisableCpuMemArena(MemorySegment segment, Arena scope) {
        return DisableCpuMemArena.ofAddress(DisableCpuMemArena$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
     * }
     */
    public interface SetSessionLogId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetSessionLogId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$26.const$1, fi, constants$15.const$4, scope);
        }

        static SetSessionLogId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionLogId$VH() {
        return constants$26.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment SetSessionLogId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$26.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogId)(OrtSessionOptions*,char*);
     * }
     */
    public static void SetSessionLogId$set(MemorySegment seg, MemorySegment x) {
        constants$26.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionLogId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$26.const$2.get(seg, index * sizeof());
    }

    public static void SetSessionLogId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$26.const$2.set(seg, index * sizeof(), x);
    }

    public static SetSessionLogId SetSessionLogId(MemorySegment segment, Arena scope) {
        return SetSessionLogId.ofAddress(SetSessionLogId$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
     * }
     */
    public interface SetSessionLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionLogVerbosityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$26.const$3, fi, constants$23.const$3, scope);
        }

        static SetSessionLogVerbosityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionLogVerbosityLevel$VH() {
        return constants$26.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetSessionLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$26.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogVerbosityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$26.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$26.const$4.get(seg, index * sizeof());
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$26.const$4.set(seg, index * sizeof(), x);
    }

    public static SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel(MemorySegment segment, Arena scope) {
        return SetSessionLogVerbosityLevel.ofAddress(SetSessionLogVerbosityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
     * }
     */
    public interface SetSessionLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionLogSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$26.const$5, fi, constants$23.const$3, scope);
        }

        static SetSessionLogSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionLogSeverityLevel$VH() {
        return constants$27.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetSessionLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$27.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionLogSeverityLevel)(OrtSessionOptions*,int);
     * }
     */
    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$27.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$27.const$0.get(seg, index * sizeof());
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$27.const$0.set(seg, index * sizeof(), x);
    }

    public static SetSessionLogSeverityLevel SetSessionLogSeverityLevel(MemorySegment segment, Arena scope) {
        return SetSessionLogSeverityLevel.ofAddress(SetSessionLogSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
     * }
     */
    public interface SetSessionGraphOptimizationLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetSessionGraphOptimizationLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$27.const$1, fi, constants$23.const$3, scope);
        }

        static SetSessionGraphOptimizationLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSessionGraphOptimizationLevel$VH() {
        return constants$27.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
     * }
     */
    public static MemorySegment SetSessionGraphOptimizationLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$27.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSessionGraphOptimizationLevel)(OrtSessionOptions*,GraphOptimizationLevel);
     * }
     */
    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, MemorySegment x) {
        constants$27.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetSessionGraphOptimizationLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$27.const$2.get(seg, index * sizeof());
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$27.const$2.set(seg, index * sizeof(), x);
    }

    public static SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel(
            MemorySegment segment, Arena scope) {
        return SetSessionGraphOptimizationLevel.ofAddress(SetSessionGraphOptimizationLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public interface SetIntraOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetIntraOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$27.const$3, fi, constants$23.const$3, scope);
        }

        static SetIntraOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetIntraOpNumThreads$VH() {
        return constants$27.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$27.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetIntraOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static void SetIntraOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$27.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$27.const$4.get(seg, index * sizeof());
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$27.const$4.set(seg, index * sizeof(), x);
    }

    public static SetIntraOpNumThreads SetIntraOpNumThreads(MemorySegment segment, Arena scope) {
        return SetIntraOpNumThreads.ofAddress(SetIntraOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public interface SetInterOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetInterOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$27.const$5, fi, constants$23.const$3, scope);
        }

        static SetInterOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetInterOpNumThreads$VH() {
        return constants$28.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static MemorySegment SetInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$28.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetInterOpNumThreads)(OrtSessionOptions*,int);
     * }
     */
    public static void SetInterOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$28.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$28.const$0.get(seg, index * sizeof());
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$28.const$0.set(seg, index * sizeof(), x);
    }

    public static SetInterOpNumThreads SetInterOpNumThreads(MemorySegment segment, Arena scope) {
        return SetInterOpNumThreads.ofAddress(SetInterOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
     * }
     */
    public interface CreateCustomOpDomain {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateCustomOpDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$28.const$1, fi, constants$15.const$4, scope);
        }

        static CreateCustomOpDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateCustomOpDomain$VH() {
        return constants$28.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
     * }
     */
    public static MemorySegment CreateCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$28.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCustomOpDomain)(char*,OrtCustomOpDomain**);
     * }
     */
    public static void CreateCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        constants$28.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$28.const$2.get(seg, index * sizeof());
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$28.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateCustomOpDomain CreateCustomOpDomain(MemorySegment segment, Arena scope) {
        return CreateCustomOpDomain.ofAddress(CreateCustomOpDomain$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
     * }
     */
    public interface CustomOpDomain_Add {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CustomOpDomain_Add fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$28.const$3, fi, constants$15.const$4, scope);
        }

        static CustomOpDomain_Add ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CustomOpDomain_Add$VH() {
        return constants$28.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
     * }
     */
    public static MemorySegment CustomOpDomain_Add$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$28.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CustomOpDomain_Add)(OrtCustomOpDomain*,const OrtCustomOp*);
     * }
     */
    public static void CustomOpDomain_Add$set(MemorySegment seg, MemorySegment x) {
        constants$28.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CustomOpDomain_Add$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$28.const$4.get(seg, index * sizeof());
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, long index, MemorySegment x) {
        constants$28.const$4.set(seg, index * sizeof(), x);
    }

    public static CustomOpDomain_Add CustomOpDomain_Add(MemorySegment segment, Arena scope) {
        return CustomOpDomain_Add.ofAddress(CustomOpDomain_Add$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
     * }
     */
    public interface AddCustomOpDomain {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(AddCustomOpDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$28.const$5, fi, constants$15.const$4, scope);
        }

        static AddCustomOpDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddCustomOpDomain$VH() {
        return constants$29.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
     * }
     */
    public static MemorySegment AddCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$29.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddCustomOpDomain)(OrtSessionOptions*,OrtCustomOpDomain*);
     * }
     */
    public static void AddCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        constants$29.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AddCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$29.const$0.get(seg, index * sizeof());
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$29.const$0.set(seg, index * sizeof(), x);
    }

    public static AddCustomOpDomain AddCustomOpDomain(MemorySegment segment, Arena scope) {
        return AddCustomOpDomain.ofAddress(AddCustomOpDomain$get(segment), scope);
    }
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

        static MemorySegment allocate(RegisterCustomOpsLibrary fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$29.const$1, fi, constants$15.const$0, scope);
        }

        static RegisterCustomOpsLibrary ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterCustomOpsLibrary$VH() {
        return constants$29.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary)(OrtSessionOptions*,char*,void**);
     * }
     */
    public static MemorySegment RegisterCustomOpsLibrary$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$29.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary)(OrtSessionOptions*,char*,void**);
     * }
     */
    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, MemorySegment x) {
        constants$29.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RegisterCustomOpsLibrary$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$29.const$2.get(seg, index * sizeof());
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, long index, MemorySegment x) {
        constants$29.const$2.set(seg, index * sizeof(), x);
    }

    public static RegisterCustomOpsLibrary RegisterCustomOpsLibrary(MemorySegment segment, Arena scope) {
        return RegisterCustomOpsLibrary.ofAddress(RegisterCustomOpsLibrary$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
     * }
     */
    public interface SessionGetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$29.const$3, fi, constants$15.const$4, scope);
        }

        static SessionGetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetInputCount$VH() {
        return constants$29.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
     * }
     */
    public static MemorySegment SessionGetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$29.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputCount)(const OrtSession*,size_t*);
     * }
     */
    public static void SessionGetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$29.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$29.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$29.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetInputCount SessionGetInputCount(MemorySegment segment, Arena scope) {
        return SessionGetInputCount.ofAddress(SessionGetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
     * }
     */
    public interface SessionGetOutputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetOutputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$29.const$5, fi, constants$15.const$4, scope);
        }

        static SessionGetOutputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOutputCount$VH() {
        return constants$30.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
     * }
     */
    public static MemorySegment SessionGetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$30.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputCount)(const OrtSession*,size_t*);
     * }
     */
    public static void SessionGetOutputCount$set(MemorySegment seg, MemorySegment x) {
        constants$30.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$30.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$30.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetOutputCount SessionGetOutputCount(MemorySegment segment, Arena scope) {
        return SessionGetOutputCount.ofAddress(SessionGetOutputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
     * }
     */
    public interface SessionGetOverridableInitializerCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetOverridableInitializerCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$30.const$1, fi, constants$15.const$4, scope);
        }

        static SessionGetOverridableInitializerCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOverridableInitializerCount$VH() {
        return constants$30.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$30.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerCount)(const OrtSession*,size_t*);
     * }
     */
    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, MemorySegment x) {
        constants$30.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOverridableInitializerCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$30.const$2.get(seg, index * sizeof());
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$30.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount(
            MemorySegment segment, Arena scope) {
        return SessionGetOverridableInitializerCount.ofAddress(
                SessionGetOverridableInitializerCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public interface SessionGetInputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetInputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$30.const$4, fi, constants$30.const$3, scope);
        }

        static SessionGetInputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetInputTypeInfo$VH() {
        return constants$31.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$31.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static void SessionGetInputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$31.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$31.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$31.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetInputTypeInfo SessionGetInputTypeInfo(MemorySegment segment, Arena scope) {
        return SessionGetInputTypeInfo.ofAddress(SessionGetInputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public interface SessionGetOutputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetOutputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$31.const$1, fi, constants$30.const$3, scope);
        }

        static SessionGetOutputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOutputTypeInfo$VH() {
        return constants$31.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$31.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$31.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$31.const$2.get(seg, index * sizeof());
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$31.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionGetOutputTypeInfo SessionGetOutputTypeInfo(MemorySegment segment, Arena scope) {
        return SessionGetOutputTypeInfo.ofAddress(SessionGetOutputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public interface SessionGetOverridableInitializerTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SessionGetOverridableInitializerTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$31.const$3, fi, constants$30.const$3, scope);
        }

        static SessionGetOverridableInitializerTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOverridableInitializerTypeInfo$VH() {
        return constants$31.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$31.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerTypeInfo)(const OrtSession*,size_t,OrtTypeInfo**);
     * }
     */
    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$31.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$31.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$31.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo(
            MemorySegment segment, Arena scope) {
        return SessionGetOverridableInitializerTypeInfo.ofAddress(
                SessionGetOverridableInitializerTypeInfo$get(segment), scope);
    }
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

        static MemorySegment allocate(SessionGetInputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$32.const$0, fi, constants$31.const$5, scope);
        }

        static SessionGetInputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$32.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetInputName$VH() {
        return constants$32.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$32.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetInputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static void SessionGetInputName$set(MemorySegment seg, MemorySegment x) {
        constants$32.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$32.const$2.get(seg, index * sizeof());
    }

    public static void SessionGetInputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$32.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionGetInputName SessionGetInputName(MemorySegment segment, Arena scope) {
        return SessionGetInputName.ofAddress(SessionGetInputName$get(segment), scope);
    }
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

        static MemorySegment allocate(SessionGetOutputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$32.const$3, fi, constants$31.const$5, scope);
        }

        static SessionGetOutputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$32.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOutputName$VH() {
        return constants$32.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$32.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOutputName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static void SessionGetOutputName$set(MemorySegment seg, MemorySegment x) {
        constants$32.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$32.const$4.get(seg, index * sizeof());
    }

    public static void SessionGetOutputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$32.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionGetOutputName SessionGetOutputName(MemorySegment segment, Arena scope) {
        return SessionGetOutputName.ofAddress(SessionGetOutputName$get(segment), scope);
    }
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

        static MemorySegment allocate(SessionGetOverridableInitializerName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$32.const$5, fi, constants$31.const$5, scope);
        }

        static SessionGetOverridableInitializerName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$32.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetOverridableInitializerName$VH() {
        return constants$33.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionGetOverridableInitializerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$33.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetOverridableInitializerName)(const OrtSession*,size_t,OrtAllocator*,char**);
     * }
     */
    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, MemorySegment x) {
        constants$33.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetOverridableInitializerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$33.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$33.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetOverridableInitializerName SessionGetOverridableInitializerName(
            MemorySegment segment, Arena scope) {
        return SessionGetOverridableInitializerName.ofAddress(SessionGetOverridableInitializerName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
     * }
     */
    public interface CreateRunOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateRunOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$33.const$1, fi, constants$1.const$4, scope);
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
        return constants$33.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
     * }
     */
    public static MemorySegment CreateRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$33.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateRunOptions)(OrtRunOptions**);
     * }
     */
    public static void CreateRunOptions$set(MemorySegment seg, MemorySegment x) {
        constants$33.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$33.const$2.get(seg, index * sizeof());
    }

    public static void CreateRunOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$33.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateRunOptions CreateRunOptions(MemorySegment segment, Arena scope) {
        return CreateRunOptions.ofAddress(CreateRunOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
     * }
     */
    public interface RunOptionsSetRunLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogVerbosityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$33.const$3, fi, constants$23.const$3, scope);
        }

        static RunOptionsSetRunLogVerbosityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetRunLogVerbosityLevel$VH() {
        return constants$33.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
     * }
     */
    public static MemorySegment RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$33.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogVerbosityLevel)(OrtRunOptions*,int);
     * }
     */
    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$33.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$33.const$4.get(seg, index * sizeof());
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$33.const$4.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsSetRunLogVerbosityLevel.ofAddress(RunOptionsSetRunLogVerbosityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
     * }
     */
    public interface RunOptionsSetRunLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(RunOptionsSetRunLogSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$33.const$5, fi, constants$23.const$3, scope);
        }

        static RunOptionsSetRunLogSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetRunLogSeverityLevel$VH() {
        return constants$34.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
     * }
     */
    public static MemorySegment RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$34.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunLogSeverityLevel)(OrtRunOptions*,int);
     * }
     */
    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$34.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$34.const$0.get(seg, index * sizeof());
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$34.const$0.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsSetRunLogSeverityLevel.ofAddress(RunOptionsSetRunLogSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
     * }
     */
    public interface RunOptionsSetRunTag {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsSetRunTag fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$34.const$1, fi, constants$15.const$4, scope);
        }

        static RunOptionsSetRunTag ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsSetRunTag$VH() {
        return constants$34.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
     * }
     */
    public static MemorySegment RunOptionsSetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$34.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetRunTag)(OrtRunOptions*,char*);
     * }
     */
    public static void RunOptionsSetRunTag$set(MemorySegment seg, MemorySegment x) {
        constants$34.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$34.const$2.get(seg, index * sizeof());
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, long index, MemorySegment x) {
        constants$34.const$2.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetRunTag RunOptionsSetRunTag(MemorySegment segment, Arena scope) {
        return RunOptionsSetRunTag.ofAddress(RunOptionsSetRunTag$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public interface RunOptionsGetRunLogVerbosityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsGetRunLogVerbosityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$34.const$3, fi, constants$15.const$4, scope);
        }

        static RunOptionsGetRunLogVerbosityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsGetRunLogVerbosityLevel$VH() {
        return constants$34.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static MemorySegment RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$34.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogVerbosityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$34.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$34.const$4.get(seg, index * sizeof());
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$34.const$4.set(seg, index * sizeof(), x);
    }

    public static RunOptionsGetRunLogVerbosityLevel RunOptionsGetRunLogVerbosityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsGetRunLogVerbosityLevel.ofAddress(RunOptionsGetRunLogVerbosityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public interface RunOptionsGetRunLogSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsGetRunLogSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$34.const$5, fi, constants$15.const$4, scope);
        }

        static RunOptionsGetRunLogSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsGetRunLogSeverityLevel$VH() {
        return constants$35.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static MemorySegment RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$35.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunLogSeverityLevel)(const OrtRunOptions*,int*);
     * }
     */
    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$35.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$35.const$0.get(seg, index * sizeof());
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$35.const$0.set(seg, index * sizeof(), x);
    }

    public static RunOptionsGetRunLogSeverityLevel RunOptionsGetRunLogSeverityLevel(
            MemorySegment segment, Arena scope) {
        return RunOptionsGetRunLogSeverityLevel.ofAddress(RunOptionsGetRunLogSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
     * }
     */
    public interface RunOptionsGetRunTag {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RunOptionsGetRunTag fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$35.const$1, fi, constants$15.const$4, scope);
        }

        static RunOptionsGetRunTag ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunOptionsGetRunTag$VH() {
        return constants$35.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
     * }
     */
    public static MemorySegment RunOptionsGetRunTag$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$35.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsGetRunTag)(const OrtRunOptions*,char**);
     * }
     */
    public static void RunOptionsGetRunTag$set(MemorySegment seg, MemorySegment x) {
        constants$35.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsGetRunTag$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$35.const$2.get(seg, index * sizeof());
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, long index, MemorySegment x) {
        constants$35.const$2.set(seg, index * sizeof(), x);
    }

    public static RunOptionsGetRunTag RunOptionsGetRunTag(MemorySegment segment, Arena scope) {
        return RunOptionsGetRunTag.ofAddress(RunOptionsGetRunTag$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
     * }
     */
    public interface RunOptionsSetTerminate {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(RunOptionsSetTerminate fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$35.const$3, fi, constants$1.const$4, scope);
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
        return constants$35.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
     * }
     */
    public static MemorySegment RunOptionsSetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$35.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsSetTerminate)(OrtRunOptions*);
     * }
     */
    public static void RunOptionsSetTerminate$set(MemorySegment seg, MemorySegment x) {
        constants$35.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsSetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$35.const$4.get(seg, index * sizeof());
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, long index, MemorySegment x) {
        constants$35.const$4.set(seg, index * sizeof(), x);
    }

    public static RunOptionsSetTerminate RunOptionsSetTerminate(MemorySegment segment, Arena scope) {
        return RunOptionsSetTerminate.ofAddress(RunOptionsSetTerminate$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
     * }
     */
    public interface RunOptionsUnsetTerminate {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(RunOptionsUnsetTerminate fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$35.const$5, fi, constants$1.const$4, scope);
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
        return constants$36.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
     * }
     */
    public static MemorySegment RunOptionsUnsetTerminate$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$36.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunOptionsUnsetTerminate)(OrtRunOptions*);
     * }
     */
    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, MemorySegment x) {
        constants$36.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunOptionsUnsetTerminate$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$36.const$0.get(seg, index * sizeof());
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, long index, MemorySegment x) {
        constants$36.const$0.set(seg, index * sizeof(), x);
    }

    public static RunOptionsUnsetTerminate RunOptionsUnsetTerminate(MemorySegment segment, Arena scope) {
        return RunOptionsUnsetTerminate.ofAddress(RunOptionsUnsetTerminate$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateTensorAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$36.const$2, fi, constants$36.const$1, scope);
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
                            constants$36.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateTensorAsOrtValue$VH() {
        return constants$36.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$36.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateTensorAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$36.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$36.const$4.get(seg, index * sizeof());
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$36.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateTensorAsOrtValue CreateTensorAsOrtValue(MemorySegment segment, Arena scope) {
        return CreateTensorAsOrtValue.ofAddress(CreateTensorAsOrtValue$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateTensorWithDataAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$37.const$0, fi, constants$36.const$5, scope);
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
                            constants$37.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateTensorWithDataAsOrtValue$VH() {
        return constants$37.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorWithDataAsOrtValue)(const OrtMemoryInfo*,void*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateTensorWithDataAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$37.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorWithDataAsOrtValue)(const OrtMemoryInfo*,void*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$37.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorWithDataAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$37.const$2.get(seg, index * sizeof());
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$37.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue(MemorySegment segment, Arena scope) {
        return CreateTensorWithDataAsOrtValue.ofAddress(CreateTensorWithDataAsOrtValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
     * }
     */
    public interface IsTensor {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(IsTensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$37.const$3, fi, constants$15.const$4, scope);
        }

        static IsTensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle IsTensor$VH() {
        return constants$37.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
     * }
     */
    public static MemorySegment IsTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$37.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*IsTensor)(const OrtValue*,int*);
     * }
     */
    public static void IsTensor$set(MemorySegment seg, MemorySegment x) {
        constants$37.const$4.set(seg, 0L, x);
    }

    public static MemorySegment IsTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$37.const$4.get(seg, index * sizeof());
    }

    public static void IsTensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$37.const$4.set(seg, index * sizeof(), x);
    }

    public static IsTensor IsTensor(MemorySegment segment, Arena scope) {
        return IsTensor.ofAddress(IsTensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
     * }
     */
    public interface GetTensorMutableData {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorMutableData fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$37.const$5, fi, constants$15.const$4, scope);
        }

        static GetTensorMutableData ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorMutableData$VH() {
        return constants$38.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
     * }
     */
    public static MemorySegment GetTensorMutableData$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$38.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMutableData)(OrtValue*,void**);
     * }
     */
    public static void GetTensorMutableData$set(MemorySegment seg, MemorySegment x) {
        constants$38.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorMutableData$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$38.const$0.get(seg, index * sizeof());
    }

    public static void GetTensorMutableData$set(MemorySegment seg, long index, MemorySegment x) {
        constants$38.const$0.set(seg, index * sizeof(), x);
    }

    public static GetTensorMutableData GetTensorMutableData(MemorySegment segment, Arena scope) {
        return GetTensorMutableData.ofAddress(GetTensorMutableData$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
     * }
     */
    public interface FillStringTensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(FillStringTensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$38.const$2, fi, constants$38.const$1, scope);
        }

        static FillStringTensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillStringTensor$VH() {
        return constants$38.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
     * }
     */
    public static MemorySegment FillStringTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$38.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensor)(OrtValue*,char**,size_t);
     * }
     */
    public static void FillStringTensor$set(MemorySegment seg, MemorySegment x) {
        constants$38.const$4.set(seg, 0L, x);
    }

    public static MemorySegment FillStringTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$38.const$4.get(seg, index * sizeof());
    }

    public static void FillStringTensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$38.const$4.set(seg, index * sizeof(), x);
    }

    public static FillStringTensor FillStringTensor(MemorySegment segment, Arena scope) {
        return FillStringTensor.ofAddress(FillStringTensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
     * }
     */
    public interface GetStringTensorDataLength {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetStringTensorDataLength fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$38.const$5, fi, constants$15.const$4, scope);
        }

        static GetStringTensorDataLength ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorDataLength$VH() {
        return constants$39.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
     * }
     */
    public static MemorySegment GetStringTensorDataLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$39.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorDataLength)(const OrtValue*,size_t*);
     * }
     */
    public static void GetStringTensorDataLength$set(MemorySegment seg, MemorySegment x) {
        constants$39.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorDataLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$39.const$0.get(seg, index * sizeof());
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, long index, MemorySegment x) {
        constants$39.const$0.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorDataLength GetStringTensorDataLength(MemorySegment segment, Arena scope) {
        return GetStringTensorDataLength.ofAddress(GetStringTensorDataLength$get(segment), scope);
    }
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

        static MemorySegment allocate(GetStringTensorContent fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$39.const$2, fi, constants$39.const$1, scope);
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
                            constants$39.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorContent$VH() {
        return constants$39.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorContent)(const OrtValue*,void*,size_t,size_t*,size_t);
     * }
     */
    public static MemorySegment GetStringTensorContent$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$39.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorContent)(const OrtValue*,void*,size_t,size_t*,size_t);
     * }
     */
    public static void GetStringTensorContent$set(MemorySegment seg, MemorySegment x) {
        constants$39.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorContent$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$39.const$4.get(seg, index * sizeof());
    }

    public static void GetStringTensorContent$set(MemorySegment seg, long index, MemorySegment x) {
        constants$39.const$4.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorContent GetStringTensorContent(MemorySegment segment, Arena scope) {
        return GetStringTensorContent.ofAddress(GetStringTensorContent$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface CastTypeInfoToTensorInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToTensorInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$39.const$5, fi, constants$15.const$4, scope);
        }

        static CastTypeInfoToTensorInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToTensorInfo$VH() {
        return constants$40.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToTensorInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$40.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToTensorInfo)(const OrtTypeInfo*,const OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, MemorySegment x) {
        constants$40.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToTensorInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$40.const$0.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$40.const$0.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToTensorInfo.ofAddress(CastTypeInfoToTensorInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public interface GetOnnxTypeFromTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetOnnxTypeFromTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$40.const$1, fi, constants$15.const$4, scope);
        }

        static GetOnnxTypeFromTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOnnxTypeFromTypeInfo$VH() {
        return constants$40.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public static MemorySegment GetOnnxTypeFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$40.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOnnxTypeFromTypeInfo)(const OrtTypeInfo*,enum ONNXType*);
     * }
     */
    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$40.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetOnnxTypeFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$40.const$2.get(seg, index * sizeof());
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$40.const$2.set(seg, index * sizeof(), x);
    }

    public static GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo(MemorySegment segment, Arena scope) {
        return GetOnnxTypeFromTypeInfo.ofAddress(GetOnnxTypeFromTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface CreateTensorTypeAndShapeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateTensorTypeAndShapeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$40.const$3, fi, constants$1.const$4, scope);
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
        return constants$40.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment CreateTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$40.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$40.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$40.const$4.get(seg, index * sizeof());
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$40.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateTensorTypeAndShapeInfo CreateTensorTypeAndShapeInfo(MemorySegment segment, Arena scope) {
        return CreateTensorTypeAndShapeInfo.ofAddress(CreateTensorTypeAndShapeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public interface SetTensorElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetTensorElementType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$40.const$5, fi, constants$23.const$3, scope);
        }

        static SetTensorElementType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetTensorElementType$VH() {
        return constants$41.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public static MemorySegment SetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$41.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetTensorElementType)(OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType);
     * }
     */
    public static void SetTensorElementType$set(MemorySegment seg, MemorySegment x) {
        constants$41.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$41.const$0.get(seg, index * sizeof());
    }

    public static void SetTensorElementType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$41.const$0.set(seg, index * sizeof(), x);
    }

    public static SetTensorElementType SetTensorElementType(MemorySegment segment, Arena scope) {
        return SetTensorElementType.ofAddress(SetTensorElementType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
     * }
     */
    public interface SetDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(SetDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$41.const$1, fi, constants$38.const$1, scope);
        }

        static SetDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetDimensions$VH() {
        return constants$41.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
     * }
     */
    public static MemorySegment SetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$41.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetDimensions)(OrtTensorTypeAndShapeInfo*,const int64_t*,size_t);
     * }
     */
    public static void SetDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$41.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$41.const$2.get(seg, index * sizeof());
    }

    public static void SetDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$41.const$2.set(seg, index * sizeof(), x);
    }

    public static SetDimensions SetDimensions(MemorySegment segment, Arena scope) {
        return SetDimensions.ofAddress(SetDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public interface GetTensorElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorElementType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$41.const$3, fi, constants$15.const$4, scope);
        }

        static GetTensorElementType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorElementType$VH() {
        return constants$41.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static MemorySegment GetTensorElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$41.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorElementType)(const OrtTensorTypeAndShapeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static void GetTensorElementType$set(MemorySegment seg, MemorySegment x) {
        constants$41.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$41.const$4.get(seg, index * sizeof());
    }

    public static void GetTensorElementType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$41.const$4.set(seg, index * sizeof(), x);
    }

    public static GetTensorElementType GetTensorElementType(MemorySegment segment, Arena scope) {
        return GetTensorElementType.ofAddress(GetTensorElementType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public interface GetDimensionsCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetDimensionsCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$41.const$5, fi, constants$15.const$4, scope);
        }

        static GetDimensionsCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDimensionsCount$VH() {
        return constants$42.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static MemorySegment GetDimensionsCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$42.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensionsCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static void GetDimensionsCount$set(MemorySegment seg, MemorySegment x) {
        constants$42.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetDimensionsCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$42.const$0.get(seg, index * sizeof());
    }

    public static void GetDimensionsCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$42.const$0.set(seg, index * sizeof(), x);
    }

    public static GetDimensionsCount GetDimensionsCount(MemorySegment segment, Arena scope) {
        return GetDimensionsCount.ofAddress(GetDimensionsCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
     * }
     */
    public interface GetDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(GetDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$42.const$1, fi, constants$38.const$1, scope);
        }

        static GetDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDimensions$VH() {
        return constants$42.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
     * }
     */
    public static MemorySegment GetDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$42.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDimensions)(const OrtTensorTypeAndShapeInfo*,int64_t*,size_t);
     * }
     */
    public static void GetDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$42.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$42.const$2.get(seg, index * sizeof());
    }

    public static void GetDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$42.const$2.set(seg, index * sizeof(), x);
    }

    public static GetDimensions GetDimensions(MemorySegment segment, Arena scope) {
        return GetDimensions.ofAddress(GetDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public interface GetSymbolicDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(GetSymbolicDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$42.const$3, fi, constants$38.const$1, scope);
        }

        static GetSymbolicDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSymbolicDimensions$VH() {
        return constants$42.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public static MemorySegment GetSymbolicDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$42.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSymbolicDimensions)(const OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public static void GetSymbolicDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$42.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$42.const$4.get(seg, index * sizeof());
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$42.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSymbolicDimensions GetSymbolicDimensions(MemorySegment segment, Arena scope) {
        return GetSymbolicDimensions.ofAddress(GetSymbolicDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public interface GetTensorShapeElementCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorShapeElementCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$42.const$5, fi, constants$15.const$4, scope);
        }

        static GetTensorShapeElementCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorShapeElementCount$VH() {
        return constants$43.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static MemorySegment GetTensorShapeElementCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$43.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorShapeElementCount)(const OrtTensorTypeAndShapeInfo*,size_t*);
     * }
     */
    public static void GetTensorShapeElementCount$set(MemorySegment seg, MemorySegment x) {
        constants$43.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorShapeElementCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$43.const$0.get(seg, index * sizeof());
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$43.const$0.set(seg, index * sizeof(), x);
    }

    public static GetTensorShapeElementCount GetTensorShapeElementCount(MemorySegment segment, Arena scope) {
        return GetTensorShapeElementCount.ofAddress(GetTensorShapeElementCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetTensorTypeAndShape {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorTypeAndShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$43.const$1, fi, constants$15.const$4, scope);
        }

        static GetTensorTypeAndShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorTypeAndShape$VH() {
        return constants$43.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetTensorTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$43.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetTensorTypeAndShape$set(MemorySegment seg, MemorySegment x) {
        constants$43.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$43.const$2.get(seg, index * sizeof());
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$43.const$2.set(seg, index * sizeof(), x);
    }

    public static GetTensorTypeAndShape GetTensorTypeAndShape(MemorySegment segment, Arena scope) {
        return GetTensorTypeAndShape.ofAddress(GetTensorTypeAndShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
     * }
     */
    public interface GetTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$43.const$3, fi, constants$15.const$4, scope);
        }

        static GetTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTypeInfo$VH() {
        return constants$43.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$43.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTypeInfo)(const OrtValue*,OrtTypeInfo**);
     * }
     */
    public static void GetTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$43.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$43.const$4.get(seg, index * sizeof());
    }

    public static void GetTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$43.const$4.set(seg, index * sizeof(), x);
    }

    public static GetTypeInfo GetTypeInfo(MemorySegment segment, Arena scope) {
        return GetTypeInfo.ofAddress(GetTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
     * }
     */
    public interface GetValueType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetValueType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$43.const$5, fi, constants$15.const$4, scope);
        }

        static GetValueType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetValueType$VH() {
        return constants$44.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
     * }
     */
    public static MemorySegment GetValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$44.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueType)(const OrtValue*,enum ONNXType*);
     * }
     */
    public static void GetValueType$set(MemorySegment seg, MemorySegment x) {
        constants$44.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$44.const$0.get(seg, index * sizeof());
    }

    public static void GetValueType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$44.const$0.set(seg, index * sizeof(), x);
    }

    public static GetValueType GetValueType(MemorySegment segment, Arena scope) {
        return GetValueType.ofAddress(GetValueType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public interface CreateMemoryInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$44.const$2, fi, constants$44.const$1, scope);
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
                            constants$44.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateMemoryInfo$VH() {
        return constants$44.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static MemorySegment CreateMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$44.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateMemoryInfo)(char*,enum OrtAllocatorType,int,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static void CreateMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$44.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$44.const$4.get(seg, index * sizeof());
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$44.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateMemoryInfo CreateMemoryInfo(MemorySegment segment, Arena scope) {
        return CreateMemoryInfo.ofAddress(CreateMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public interface CreateCpuMemoryInfo {

        java.lang.foreign.MemorySegment apply(int _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(CreateCpuMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$45.const$0, fi, constants$44.const$5, scope);
        }

        static CreateCpuMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$45.const$1.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateCpuMemoryInfo$VH() {
        return constants$45.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static MemorySegment CreateCpuMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$45.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCpuMemoryInfo)(enum OrtAllocatorType,enum OrtMemType,OrtMemoryInfo**);
     * }
     */
    public static void CreateCpuMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$45.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateCpuMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$45.const$2.get(seg, index * sizeof());
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$45.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateCpuMemoryInfo CreateCpuMemoryInfo(MemorySegment segment, Arena scope) {
        return CreateCpuMemoryInfo.ofAddress(CreateCpuMemoryInfo$get(segment), scope);
    }
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

        static MemorySegment allocate(CompareMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$45.const$3, fi, constants$15.const$0, scope);
        }

        static CompareMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CompareMemoryInfo$VH() {
        return constants$45.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CompareMemoryInfo)(const OrtMemoryInfo*,const OrtMemoryInfo*,int*);
     * }
     */
    public static MemorySegment CompareMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$45.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CompareMemoryInfo)(const OrtMemoryInfo*,const OrtMemoryInfo*,int*);
     * }
     */
    public static void CompareMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$45.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CompareMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$45.const$4.get(seg, index * sizeof());
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$45.const$4.set(seg, index * sizeof(), x);
    }

    public static CompareMemoryInfo CompareMemoryInfo(MemorySegment segment, Arena scope) {
        return CompareMemoryInfo.ofAddress(CompareMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
     * }
     */
    public interface MemoryInfoGetName {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$45.const$5, fi, constants$15.const$4, scope);
        }

        static MemoryInfoGetName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetName$VH() {
        return constants$46.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
     * }
     */
    public static MemorySegment MemoryInfoGetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$46.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetName)(const OrtMemoryInfo*,char**);
     * }
     */
    public static void MemoryInfoGetName$set(MemorySegment seg, MemorySegment x) {
        constants$46.const$0.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$46.const$0.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$46.const$0.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetName MemoryInfoGetName(MemorySegment segment, Arena scope) {
        return MemoryInfoGetName.ofAddress(MemoryInfoGetName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
     * }
     */
    public interface MemoryInfoGetId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$46.const$1, fi, constants$15.const$4, scope);
        }

        static MemoryInfoGetId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetId$VH() {
        return constants$46.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
     * }
     */
    public static MemorySegment MemoryInfoGetId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$46.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetId)(const OrtMemoryInfo*,int*);
     * }
     */
    public static void MemoryInfoGetId$set(MemorySegment seg, MemorySegment x) {
        constants$46.const$2.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$46.const$2.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$46.const$2.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetId MemoryInfoGetId(MemorySegment segment, Arena scope) {
        return MemoryInfoGetId.ofAddress(MemoryInfoGetId$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
     * }
     */
    public interface MemoryInfoGetMemType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetMemType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$46.const$3, fi, constants$15.const$4, scope);
        }

        static MemoryInfoGetMemType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetMemType$VH() {
        return constants$46.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
     * }
     */
    public static MemorySegment MemoryInfoGetMemType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$46.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetMemType)(const OrtMemoryInfo*,OrtMemType*);
     * }
     */
    public static void MemoryInfoGetMemType$set(MemorySegment seg, MemorySegment x) {
        constants$46.const$4.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetMemType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$46.const$4.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$46.const$4.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetMemType MemoryInfoGetMemType(MemorySegment segment, Arena scope) {
        return MemoryInfoGetMemType.ofAddress(MemoryInfoGetMemType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
     * }
     */
    public interface MemoryInfoGetType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$46.const$5, fi, constants$15.const$4, scope);
        }

        static MemoryInfoGetType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle MemoryInfoGetType$VH() {
        return constants$47.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
     * }
     */
    public static MemorySegment MemoryInfoGetType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$47.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*MemoryInfoGetType)(const OrtMemoryInfo*,OrtAllocatorType*);
     * }
     */
    public static void MemoryInfoGetType$set(MemorySegment seg, MemorySegment x) {
        constants$47.const$0.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$47.const$0.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$47.const$0.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetType MemoryInfoGetType(MemorySegment segment, Arena scope) {
        return MemoryInfoGetType.ofAddress(MemoryInfoGetType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
     * }
     */
    public interface AllocatorAlloc {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(AllocatorAlloc fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$47.const$1, fi, constants$30.const$3, scope);
        }

        static AllocatorAlloc ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AllocatorAlloc$VH() {
        return constants$47.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
     * }
     */
    public static MemorySegment AllocatorAlloc$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$47.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorAlloc)(OrtAllocator*,size_t,void**);
     * }
     */
    public static void AllocatorAlloc$set(MemorySegment seg, MemorySegment x) {
        constants$47.const$2.set(seg, 0L, x);
    }

    public static MemorySegment AllocatorAlloc$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$47.const$2.get(seg, index * sizeof());
    }

    public static void AllocatorAlloc$set(MemorySegment seg, long index, MemorySegment x) {
        constants$47.const$2.set(seg, index * sizeof(), x);
    }

    public static AllocatorAlloc AllocatorAlloc(MemorySegment segment, Arena scope) {
        return AllocatorAlloc.ofAddress(AllocatorAlloc$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
     * }
     */
    public interface AllocatorFree {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(AllocatorFree fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$47.const$3, fi, constants$15.const$4, scope);
        }

        static AllocatorFree ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AllocatorFree$VH() {
        return constants$47.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
     * }
     */
    public static MemorySegment AllocatorFree$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$47.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorFree)(OrtAllocator*,void*);
     * }
     */
    public static void AllocatorFree$set(MemorySegment seg, MemorySegment x) {
        constants$47.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AllocatorFree$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$47.const$4.get(seg, index * sizeof());
    }

    public static void AllocatorFree$set(MemorySegment seg, long index, MemorySegment x) {
        constants$47.const$4.set(seg, index * sizeof(), x);
    }

    public static AllocatorFree AllocatorFree(MemorySegment segment, Arena scope) {
        return AllocatorFree.ofAddress(AllocatorFree$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public interface AllocatorGetInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(AllocatorGetInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$47.const$5, fi, constants$15.const$4, scope);
        }

        static AllocatorGetInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AllocatorGetInfo$VH() {
        return constants$48.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public static MemorySegment AllocatorGetInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$48.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AllocatorGetInfo)(const OrtAllocator*,struct OrtMemoryInfo**);
     * }
     */
    public static void AllocatorGetInfo$set(MemorySegment seg, MemorySegment x) {
        constants$48.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AllocatorGetInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$48.const$0.get(seg, index * sizeof());
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$48.const$0.set(seg, index * sizeof(), x);
    }

    public static AllocatorGetInfo AllocatorGetInfo(MemorySegment segment, Arena scope) {
        return AllocatorGetInfo.ofAddress(AllocatorGetInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
     * }
     */
    public interface GetAllocatorWithDefaultOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetAllocatorWithDefaultOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$48.const$1, fi, constants$1.const$4, scope);
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
        return constants$48.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
     * }
     */
    public static MemorySegment GetAllocatorWithDefaultOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$48.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAllocatorWithDefaultOptions)(OrtAllocator**);
     * }
     */
    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, MemorySegment x) {
        constants$48.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetAllocatorWithDefaultOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$48.const$2.get(seg, index * sizeof());
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$48.const$2.set(seg, index * sizeof(), x);
    }

    public static GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions(MemorySegment segment, Arena scope) {
        return GetAllocatorWithDefaultOptions.ofAddress(GetAllocatorWithDefaultOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public interface AddFreeDimensionOverride {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverride fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$48.const$3, fi, constants$38.const$1, scope);
        }

        static AddFreeDimensionOverride ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddFreeDimensionOverride$VH() {
        return constants$48.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static MemorySegment AddFreeDimensionOverride$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$48.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverride)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static void AddFreeDimensionOverride$set(MemorySegment seg, MemorySegment x) {
        constants$48.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AddFreeDimensionOverride$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$48.const$4.get(seg, index * sizeof());
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, long index, MemorySegment x) {
        constants$48.const$4.set(seg, index * sizeof(), x);
    }

    public static AddFreeDimensionOverride AddFreeDimensionOverride(MemorySegment segment, Arena scope) {
        return AddFreeDimensionOverride.ofAddress(AddFreeDimensionOverride$get(segment), scope);
    }
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

        static MemorySegment allocate(GetValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$49.const$0, fi, constants$48.const$5, scope);
        }

        static GetValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$49.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetValue$VH() {
        return constants$49.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValue)(const OrtValue*,int,OrtAllocator*,OrtValue**);
     * }
     */
    public static MemorySegment GetValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$49.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValue)(const OrtValue*,int,OrtAllocator*,OrtValue**);
     * }
     */
    public static void GetValue$set(MemorySegment seg, MemorySegment x) {
        constants$49.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$49.const$2.get(seg, index * sizeof());
    }

    public static void GetValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$49.const$2.set(seg, index * sizeof(), x);
    }

    public static GetValue GetValue(MemorySegment segment, Arena scope) {
        return GetValue.ofAddress(GetValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
     * }
     */
    public interface GetValueCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetValueCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$49.const$3, fi, constants$15.const$4, scope);
        }

        static GetValueCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetValueCount$VH() {
        return constants$49.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
     * }
     */
    public static MemorySegment GetValueCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$49.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetValueCount)(const OrtValue*,size_t*);
     * }
     */
    public static void GetValueCount$set(MemorySegment seg, MemorySegment x) {
        constants$49.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetValueCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$49.const$4.get(seg, index * sizeof());
    }

    public static void GetValueCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$49.const$4.set(seg, index * sizeof(), x);
    }

    public static GetValueCount GetValueCount(MemorySegment segment, Arena scope) {
        return GetValueCount.ofAddress(GetValueCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
     * }
     */
    public interface CreateValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, int _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$50.const$0, fi, constants$49.const$5, scope);
        }

        static CreateValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    int __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$50.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateValue$VH() {
        return constants$50.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
     * }
     */
    public static MemorySegment CreateValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$50.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateValue)(const OrtValue**,size_t,enum ONNXType,OrtValue**);
     * }
     */
    public static void CreateValue$set(MemorySegment seg, MemorySegment x) {
        constants$50.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$50.const$2.get(seg, index * sizeof());
    }

    public static void CreateValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$50.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateValue CreateValue(MemorySegment segment, Arena scope) {
        return CreateValue.ofAddress(CreateValue$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateOpaqueValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$50.const$4, fi, constants$50.const$3, scope);
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
                            constants$50.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateOpaqueValue$VH() {
        return constants$51.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpaqueValue)(char*,char*,void*,size_t,OrtValue**);
     * }
     */
    public static MemorySegment CreateOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$51.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpaqueValue)(char*,char*,void*,size_t,OrtValue**);
     * }
     */
    public static void CreateOpaqueValue$set(MemorySegment seg, MemorySegment x) {
        constants$51.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$51.const$0.get(seg, index * sizeof());
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$51.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateOpaqueValue CreateOpaqueValue(MemorySegment segment, Arena scope) {
        return CreateOpaqueValue.ofAddress(CreateOpaqueValue$get(segment), scope);
    }
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

        static MemorySegment allocate(GetOpaqueValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$51.const$2, fi, constants$51.const$1, scope);
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
                            constants$51.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOpaqueValue$VH() {
        return constants$51.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOpaqueValue)(char*,char*,const OrtValue*,void*,size_t);
     * }
     */
    public static MemorySegment GetOpaqueValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$51.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOpaqueValue)(char*,char*,const OrtValue*,void*,size_t);
     * }
     */
    public static void GetOpaqueValue$set(MemorySegment seg, MemorySegment x) {
        constants$51.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetOpaqueValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$51.const$4.get(seg, index * sizeof());
    }

    public static void GetOpaqueValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$51.const$4.set(seg, index * sizeof(), x);
    }

    public static GetOpaqueValue GetOpaqueValue(MemorySegment segment, Arena scope) {
        return GetOpaqueValue.ofAddress(GetOpaqueValue$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfoGetAttribute_float fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$51.const$5, fi, constants$15.const$0, scope);
        }

        static KernelInfoGetAttribute_float ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_float$VH() {
        return constants$52.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_float)(const OrtKernelInfo*,char*,float*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$52.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_float)(const OrtKernelInfo*,char*,float*);
     * }
     */
    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$52.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_float KernelInfoGetAttribute_float(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_float.ofAddress(KernelInfoGetAttribute_float$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfoGetAttribute_int64 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$52.const$1, fi, constants$15.const$0, scope);
        }

        static KernelInfoGetAttribute_int64 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_int64$VH() {
        return constants$52.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_int64)(const OrtKernelInfo*,char*,int64_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$52.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_int64)(const OrtKernelInfo*,char*,int64_t*);
     * }
     */
    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$52.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_int64 KernelInfoGetAttribute_int64(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_int64.ofAddress(KernelInfoGetAttribute_int64$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfoGetAttribute_string fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$52.const$3, fi, constants$20.const$3, scope);
        }

        static KernelInfoGetAttribute_string ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_string$VH() {
        return constants$52.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_string)(const OrtKernelInfo*,char*,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_string$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$52.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_string)(const OrtKernelInfo*,char*,char*,size_t*);
     * }
     */
    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, MemorySegment x) {
        constants$52.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_string$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$52.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, long index, MemorySegment x) {
        constants$52.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_string KernelInfoGetAttribute_string(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_string.ofAddress(KernelInfoGetAttribute_string$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public interface KernelContext_GetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$52.const$5, fi, constants$15.const$4, scope);
        }

        static KernelContext_GetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetInputCount$VH() {
        return constants$53.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static MemorySegment KernelContext_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$53.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static void KernelContext_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$53.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$53.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$53.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetInputCount KernelContext_GetInputCount(MemorySegment segment, Arena scope) {
        return KernelContext_GetInputCount.ofAddress(KernelContext_GetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public interface KernelContext_GetOutputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetOutputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$53.const$1, fi, constants$15.const$4, scope);
        }

        static KernelContext_GetOutputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetOutputCount$VH() {
        return constants$53.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static MemorySegment KernelContext_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$53.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutputCount)(const OrtKernelContext*,size_t*);
     * }
     */
    public static void KernelContext_GetOutputCount$set(MemorySegment seg, MemorySegment x) {
        constants$53.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$53.const$2.get(seg, index * sizeof());
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$53.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetOutputCount KernelContext_GetOutputCount(MemorySegment segment, Arena scope) {
        return KernelContext_GetOutputCount.ofAddress(KernelContext_GetOutputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
     * }
     */
    public interface KernelContext_GetInput {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelContext_GetInput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$53.const$3, fi, constants$30.const$3, scope);
        }

        static KernelContext_GetInput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetInput$VH() {
        return constants$53.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
     * }
     */
    public static MemorySegment KernelContext_GetInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$53.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetInput)(const OrtKernelContext*,size_t,const OrtValue**);
     * }
     */
    public static void KernelContext_GetInput$set(MemorySegment seg, MemorySegment x) {
        constants$53.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$53.const$4.get(seg, index * sizeof());
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$53.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetInput KernelContext_GetInput(MemorySegment segment, Arena scope) {
        return KernelContext_GetInput.ofAddress(KernelContext_GetInput$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelContext_GetOutput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$54.const$0, fi, constants$53.const$5, scope);
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
                            constants$54.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetOutput$VH() {
        return constants$54.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutput)(OrtKernelContext*,size_t,const int64_t*,size_t,OrtValue**);
     * }
     */
    public static MemorySegment KernelContext_GetOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$54.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetOutput)(OrtKernelContext*,size_t,const int64_t*,size_t,OrtValue**);
     * }
     */
    public static void KernelContext_GetOutput$set(MemorySegment seg, MemorySegment x) {
        constants$54.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$54.const$2.get(seg, index * sizeof());
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$54.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetOutput KernelContext_GetOutput(MemorySegment segment, Arena scope) {
        return KernelContext_GetOutput.ofAddress(KernelContext_GetOutput$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseEnv)(OrtEnv*);
     * }
     */
    public interface ReleaseEnv {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseEnv fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$54.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseEnv ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseEnv$VH() {
        return constants$54.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseEnv)(OrtEnv*);
     * }
     */
    public static MemorySegment ReleaseEnv$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$54.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseEnv)(OrtEnv*);
     * }
     */
    public static void ReleaseEnv$set(MemorySegment seg, MemorySegment x) {
        constants$54.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseEnv$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$54.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseEnv$set(MemorySegment seg, long index, MemorySegment x) {
        constants$54.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseEnv ReleaseEnv(MemorySegment segment, Arena scope) {
        return ReleaseEnv.ofAddress(ReleaseEnv$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseStatus)(OrtStatus*);
     * }
     */
    public interface ReleaseStatus {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseStatus fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$54.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseStatus ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseStatus$VH() {
        return constants$55.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseStatus)(OrtStatus*);
     * }
     */
    public static MemorySegment ReleaseStatus$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$55.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseStatus)(OrtStatus*);
     * }
     */
    public static void ReleaseStatus$set(MemorySegment seg, MemorySegment x) {
        constants$55.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseStatus$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$55.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseStatus$set(MemorySegment seg, long index, MemorySegment x) {
        constants$55.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseStatus ReleaseStatus(MemorySegment segment, Arena scope) {
        return ReleaseStatus.ofAddress(ReleaseStatus$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
     * }
     */
    public interface ReleaseMemoryInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$55.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseMemoryInfo$VH() {
        return constants$55.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
     * }
     */
    public static MemorySegment ReleaseMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$55.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseMemoryInfo)(OrtMemoryInfo*);
     * }
     */
    public static void ReleaseMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$55.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$55.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$55.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseMemoryInfo ReleaseMemoryInfo(MemorySegment segment, Arena scope) {
        return ReleaseMemoryInfo.ofAddress(ReleaseMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseSession)(OrtSession*);
     * }
     */
    public interface ReleaseSession {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSession fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$55.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseSession ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseSession$VH() {
        return constants$55.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSession)(OrtSession*);
     * }
     */
    public static MemorySegment ReleaseSession$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$55.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSession)(OrtSession*);
     * }
     */
    public static void ReleaseSession$set(MemorySegment seg, MemorySegment x) {
        constants$55.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseSession$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$55.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseSession$set(MemorySegment seg, long index, MemorySegment x) {
        constants$55.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseSession ReleaseSession(MemorySegment segment, Arena scope) {
        return ReleaseSession.ofAddress(ReleaseSession$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseValue)(OrtValue*);
     * }
     */
    public interface ReleaseValue {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$55.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseValue$VH() {
        return constants$56.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseValue)(OrtValue*);
     * }
     */
    public static MemorySegment ReleaseValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$56.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseValue)(OrtValue*);
     * }
     */
    public static void ReleaseValue$set(MemorySegment seg, MemorySegment x) {
        constants$56.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$56.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$56.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseValue ReleaseValue(MemorySegment segment, Arena scope) {
        return ReleaseValue.ofAddress(ReleaseValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseRunOptions)(OrtRunOptions*);
     * }
     */
    public interface ReleaseRunOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseRunOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$56.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseRunOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseRunOptions$VH() {
        return constants$56.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseRunOptions)(OrtRunOptions*);
     * }
     */
    public static MemorySegment ReleaseRunOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$56.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseRunOptions)(OrtRunOptions*);
     * }
     */
    public static void ReleaseRunOptions$set(MemorySegment seg, MemorySegment x) {
        constants$56.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseRunOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$56.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$56.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseRunOptions ReleaseRunOptions(MemorySegment segment, Arena scope) {
        return ReleaseRunOptions.ofAddress(ReleaseRunOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseTypeInfo)(OrtTypeInfo*);
     * }
     */
    public interface ReleaseTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$56.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseTypeInfo$VH() {
        return constants$56.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTypeInfo)(OrtTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$56.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTypeInfo)(OrtTypeInfo*);
     * }
     */
    public static void ReleaseTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$56.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$56.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$56.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseTypeInfo ReleaseTypeInfo(MemorySegment segment, Arena scope) {
        return ReleaseTypeInfo.ofAddress(ReleaseTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
     * }
     */
    public interface ReleaseTensorTypeAndShapeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTensorTypeAndShapeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$56.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseTensorTypeAndShapeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseTensorTypeAndShapeInfo$VH() {
        return constants$57.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static MemorySegment ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$57.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTensorTypeAndShapeInfo)(OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$57.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$57.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$57.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo(MemorySegment segment, Arena scope) {
        return ReleaseTensorTypeAndShapeInfo.ofAddress(ReleaseTensorTypeAndShapeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseSessionOptions)(OrtSessionOptions*);
     * }
     */
    public interface ReleaseSessionOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSessionOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$57.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseSessionOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseSessionOptions$VH() {
        return constants$57.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSessionOptions)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment ReleaseSessionOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$57.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSessionOptions)(OrtSessionOptions*);
     * }
     */
    public static void ReleaseSessionOptions$set(MemorySegment seg, MemorySegment x) {
        constants$57.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseSessionOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$57.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$57.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseSessionOptions ReleaseSessionOptions(MemorySegment segment, Arena scope) {
        return ReleaseSessionOptions.ofAddress(ReleaseSessionOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
     * }
     */
    public interface ReleaseCustomOpDomain {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCustomOpDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$57.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseCustomOpDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseCustomOpDomain$VH() {
        return constants$57.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
     * }
     */
    public static MemorySegment ReleaseCustomOpDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$57.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCustomOpDomain)(OrtCustomOpDomain*);
     * }
     */
    public static void ReleaseCustomOpDomain$set(MemorySegment seg, MemorySegment x) {
        constants$57.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseCustomOpDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$57.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$57.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseCustomOpDomain ReleaseCustomOpDomain(MemorySegment segment, Arena scope) {
        return ReleaseCustomOpDomain.ofAddress(ReleaseCustomOpDomain$get(segment), scope);
    }
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

        static MemorySegment allocate(GetDenotationFromTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$57.const$5, fi, constants$15.const$0, scope);
        }

        static GetDenotationFromTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDenotationFromTypeInfo$VH() {
        return constants$58.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDenotationFromTypeInfo)(const OrtTypeInfo*,char**,size_t*);
     * }
     */
    public static MemorySegment GetDenotationFromTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$58.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDenotationFromTypeInfo)(const OrtTypeInfo*,char**,size_t*);
     * }
     */
    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$58.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetDenotationFromTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$58.const$0.get(seg, index * sizeof());
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$58.const$0.set(seg, index * sizeof(), x);
    }

    public static GetDenotationFromTypeInfo GetDenotationFromTypeInfo(MemorySegment segment, Arena scope) {
        return GetDenotationFromTypeInfo.ofAddress(GetDenotationFromTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
     * }
     */
    public interface CastTypeInfoToMapTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToMapTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$58.const$1, fi, constants$15.const$4, scope);
        }

        static CastTypeInfoToMapTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToMapTypeInfo$VH() {
        return constants$58.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$58.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToMapTypeInfo)(const OrtTypeInfo*,const OrtMapTypeInfo**);
     * }
     */
    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$58.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$58.const$2.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$58.const$2.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToMapTypeInfo.ofAddress(CastTypeInfoToMapTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
     * }
     */
    public interface CastTypeInfoToSequenceTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToSequenceTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$58.const$3, fi, constants$15.const$4, scope);
        }

        static CastTypeInfoToSequenceTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToSequenceTypeInfo$VH() {
        return constants$58.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$58.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToSequenceTypeInfo)(const OrtTypeInfo*,const OrtSequenceTypeInfo**);
     * }
     */
    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$58.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$58.const$4.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$58.const$4.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToSequenceTypeInfo.ofAddress(CastTypeInfoToSequenceTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public interface GetMapKeyType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetMapKeyType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$58.const$5, fi, constants$15.const$4, scope);
        }

        static GetMapKeyType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetMapKeyType$VH() {
        return constants$59.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static MemorySegment GetMapKeyType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$59.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapKeyType)(const OrtMapTypeInfo*,enum ONNXTensorElementDataType*);
     * }
     */
    public static void GetMapKeyType$set(MemorySegment seg, MemorySegment x) {
        constants$59.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetMapKeyType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$59.const$0.get(seg, index * sizeof());
    }

    public static void GetMapKeyType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$59.const$0.set(seg, index * sizeof(), x);
    }

    public static GetMapKeyType GetMapKeyType(MemorySegment segment, Arena scope) {
        return GetMapKeyType.ofAddress(GetMapKeyType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
     * }
     */
    public interface GetMapValueType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetMapValueType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$59.const$1, fi, constants$15.const$4, scope);
        }

        static GetMapValueType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetMapValueType$VH() {
        return constants$59.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetMapValueType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$59.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetMapValueType)(const OrtMapTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static void GetMapValueType$set(MemorySegment seg, MemorySegment x) {
        constants$59.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetMapValueType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$59.const$2.get(seg, index * sizeof());
    }

    public static void GetMapValueType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$59.const$2.set(seg, index * sizeof(), x);
    }

    public static GetMapValueType GetMapValueType(MemorySegment segment, Arena scope) {
        return GetMapValueType.ofAddress(GetMapValueType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
     * }
     */
    public interface GetSequenceElementType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSequenceElementType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$59.const$3, fi, constants$15.const$4, scope);
        }

        static GetSequenceElementType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSequenceElementType$VH() {
        return constants$59.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetSequenceElementType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$59.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSequenceElementType)(const OrtSequenceTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static void GetSequenceElementType$set(MemorySegment seg, MemorySegment x) {
        constants$59.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSequenceElementType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$59.const$4.get(seg, index * sizeof());
    }

    public static void GetSequenceElementType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$59.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSequenceElementType GetSequenceElementType(MemorySegment segment, Arena scope) {
        return GetSequenceElementType.ofAddress(GetSequenceElementType$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
     * }
     */
    public interface ReleaseMapTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseMapTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$59.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseMapTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseMapTypeInfo$VH() {
        return constants$60.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseMapTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$60.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseMapTypeInfo)(OrtMapTypeInfo*);
     * }
     */
    public static void ReleaseMapTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$60.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseMapTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$60.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$60.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseMapTypeInfo ReleaseMapTypeInfo(MemorySegment segment, Arena scope) {
        return ReleaseMapTypeInfo.ofAddress(ReleaseMapTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
     * }
     */
    public interface ReleaseSequenceTypeInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseSequenceTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$60.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseSequenceTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseSequenceTypeInfo$VH() {
        return constants$60.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
     * }
     */
    public static MemorySegment ReleaseSequenceTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$60.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseSequenceTypeInfo)(OrtSequenceTypeInfo*);
     * }
     */
    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$60.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$60.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$60.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseSequenceTypeInfo ReleaseSequenceTypeInfo(MemorySegment segment, Arena scope) {
        return ReleaseSequenceTypeInfo.ofAddress(ReleaseSequenceTypeInfo$get(segment), scope);
    }
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

        static MemorySegment allocate(SessionEndProfiling fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$60.const$3, fi, constants$15.const$0, scope);
        }

        static SessionEndProfiling ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionEndProfiling$VH() {
        return constants$60.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionEndProfiling)(OrtSession*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment SessionEndProfiling$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$60.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionEndProfiling)(OrtSession*,OrtAllocator*,char**);
     * }
     */
    public static void SessionEndProfiling$set(MemorySegment seg, MemorySegment x) {
        constants$60.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionEndProfiling$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$60.const$4.get(seg, index * sizeof());
    }

    public static void SessionEndProfiling$set(MemorySegment seg, long index, MemorySegment x) {
        constants$60.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionEndProfiling SessionEndProfiling(MemorySegment segment, Arena scope) {
        return SessionEndProfiling.ofAddress(SessionEndProfiling$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
     * }
     */
    public interface SessionGetModelMetadata {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetModelMetadata fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$60.const$5, fi, constants$15.const$4, scope);
        }

        static SessionGetModelMetadata ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetModelMetadata$VH() {
        return constants$61.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
     * }
     */
    public static MemorySegment SessionGetModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$61.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetModelMetadata)(const OrtSession*,OrtModelMetadata**);
     * }
     */
    public static void SessionGetModelMetadata$set(MemorySegment seg, MemorySegment x) {
        constants$61.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$61.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, long index, MemorySegment x) {
        constants$61.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetModelMetadata SessionGetModelMetadata(MemorySegment segment, Arena scope) {
        return SessionGetModelMetadata.ofAddress(SessionGetModelMetadata$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataGetProducerName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$61.const$1, fi, constants$15.const$0, scope);
        }

        static ModelMetadataGetProducerName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetProducerName$VH() {
        return constants$61.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetProducerName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetProducerName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$61.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetProducerName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetProducerName$set(MemorySegment seg, MemorySegment x) {
        constants$61.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetProducerName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$61.const$2.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$61.const$2.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetProducerName ModelMetadataGetProducerName(MemorySegment segment, Arena scope) {
        return ModelMetadataGetProducerName.ofAddress(ModelMetadataGetProducerName$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataGetGraphName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$61.const$3, fi, constants$15.const$0, scope);
        }

        static ModelMetadataGetGraphName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetGraphName$VH() {
        return constants$61.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetGraphName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$61.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphName)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetGraphName$set(MemorySegment seg, MemorySegment x) {
        constants$61.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetGraphName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$61.const$4.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$61.const$4.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetGraphName ModelMetadataGetGraphName(MemorySegment segment, Arena scope) {
        return ModelMetadataGetGraphName.ofAddress(ModelMetadataGetGraphName$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataGetDomain fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$61.const$5, fi, constants$15.const$0, scope);
        }

        static ModelMetadataGetDomain ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetDomain$VH() {
        return constants$62.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDomain)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetDomain$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$62.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDomain)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetDomain$set(MemorySegment seg, MemorySegment x) {
        constants$62.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetDomain$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$62.const$0.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, long index, MemorySegment x) {
        constants$62.const$0.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetDomain ModelMetadataGetDomain(MemorySegment segment, Arena scope) {
        return ModelMetadataGetDomain.ofAddress(ModelMetadataGetDomain$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataGetDescription fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$62.const$1, fi, constants$15.const$0, scope);
        }

        static ModelMetadataGetDescription ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetDescription$VH() {
        return constants$62.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$62.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetDescription$set(MemorySegment seg, MemorySegment x) {
        constants$62.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$62.const$2.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, long index, MemorySegment x) {
        constants$62.const$2.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetDescription ModelMetadataGetDescription(MemorySegment segment, Arena scope) {
        return ModelMetadataGetDescription.ofAddress(ModelMetadataGetDescription$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataLookupCustomMetadataMap fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$62.const$3, fi, constants$20.const$3, scope);
        }

        static ModelMetadataLookupCustomMetadataMap ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataLookupCustomMetadataMap$VH() {
        return constants$62.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataLookupCustomMetadataMap)(const OrtModelMetadata*,OrtAllocator*,char*,char**);
     * }
     */
    public static MemorySegment ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$62.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataLookupCustomMetadataMap)(const OrtModelMetadata*,OrtAllocator*,char*,char**);
     * }
     */
    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, MemorySegment x) {
        constants$62.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$62.const$4.get(seg, index * sizeof());
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, long index, MemorySegment x) {
        constants$62.const$4.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap(
            MemorySegment segment, Arena scope) {
        return ModelMetadataLookupCustomMetadataMap.ofAddress(ModelMetadataLookupCustomMetadataMap$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
     * }
     */
    public interface ModelMetadataGetVersion {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(ModelMetadataGetVersion fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$62.const$5, fi, constants$15.const$4, scope);
        }

        static ModelMetadataGetVersion ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetVersion$VH() {
        return constants$63.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
     * }
     */
    public static MemorySegment ModelMetadataGetVersion$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$63.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetVersion)(const OrtModelMetadata*,int64_t*);
     * }
     */
    public static void ModelMetadataGetVersion$set(MemorySegment seg, MemorySegment x) {
        constants$63.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetVersion$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$63.const$0.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, long index, MemorySegment x) {
        constants$63.const$0.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetVersion ModelMetadataGetVersion(MemorySegment segment, Arena scope) {
        return ModelMetadataGetVersion.ofAddress(ModelMetadataGetVersion$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseModelMetadata)(OrtModelMetadata*);
     * }
     */
    public interface ReleaseModelMetadata {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseModelMetadata fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$63.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseModelMetadata ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseModelMetadata$VH() {
        return constants$63.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseModelMetadata)(OrtModelMetadata*);
     * }
     */
    public static MemorySegment ReleaseModelMetadata$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$63.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseModelMetadata)(OrtModelMetadata*);
     * }
     */
    public static void ReleaseModelMetadata$set(MemorySegment seg, MemorySegment x) {
        constants$63.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseModelMetadata$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$63.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, long index, MemorySegment x) {
        constants$63.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseModelMetadata ReleaseModelMetadata(MemorySegment segment, Arena scope) {
        return ReleaseModelMetadata.ofAddress(ReleaseModelMetadata$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateEnvWithGlobalThreadPools fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$63.const$4, fi, constants$63.const$3, scope);
        }

        static CreateEnvWithGlobalThreadPools ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$63.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnvWithGlobalThreadPools$VH() {
        return constants$64.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithGlobalThreadPools)(OrtLoggingLevel,char*,const OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$64.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithGlobalThreadPools)(OrtLoggingLevel,char*,const OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, MemorySegment x) {
        constants$64.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnvWithGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$64.const$0.get(seg, index * sizeof());
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, long index, MemorySegment x) {
        constants$64.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateEnvWithGlobalThreadPools CreateEnvWithGlobalThreadPools(MemorySegment segment, Arena scope) {
        return CreateEnvWithGlobalThreadPools.ofAddress(CreateEnvWithGlobalThreadPools$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
     * }
     */
    public interface DisablePerSessionThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(DisablePerSessionThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$64.const$1, fi, constants$1.const$4, scope);
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
        return constants$64.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment DisablePerSessionThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$64.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*DisablePerSessionThreads)(OrtSessionOptions*);
     * }
     */
    public static void DisablePerSessionThreads$set(MemorySegment seg, MemorySegment x) {
        constants$64.const$2.set(seg, 0L, x);
    }

    public static MemorySegment DisablePerSessionThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$64.const$2.get(seg, index * sizeof());
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$64.const$2.set(seg, index * sizeof(), x);
    }

    public static DisablePerSessionThreads DisablePerSessionThreads(MemorySegment segment, Arena scope) {
        return DisablePerSessionThreads.ofAddress(DisablePerSessionThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
     * }
     */
    public interface CreateThreadingOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateThreadingOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$64.const$3, fi, constants$1.const$4, scope);
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
        return constants$64.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
     * }
     */
    public static MemorySegment CreateThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$64.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateThreadingOptions)(OrtThreadingOptions**);
     * }
     */
    public static void CreateThreadingOptions$set(MemorySegment seg, MemorySegment x) {
        constants$64.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$64.const$4.get(seg, index * sizeof());
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$64.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateThreadingOptions CreateThreadingOptions(MemorySegment segment, Arena scope) {
        return CreateThreadingOptions.ofAddress(CreateThreadingOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
     * }
     */
    public interface ReleaseThreadingOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseThreadingOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$64.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseThreadingOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseThreadingOptions$VH() {
        return constants$65.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
     * }
     */
    public static MemorySegment ReleaseThreadingOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$65.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseThreadingOptions)(OrtThreadingOptions*);
     * }
     */
    public static void ReleaseThreadingOptions$set(MemorySegment seg, MemorySegment x) {
        constants$65.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseThreadingOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$65.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$65.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseThreadingOptions ReleaseThreadingOptions(MemorySegment segment, Arena scope) {
        return ReleaseThreadingOptions.ofAddress(ReleaseThreadingOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataGetCustomMetadataMapKeys fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$65.const$1, fi, constants$20.const$3, scope);
        }

        static ModelMetadataGetCustomMetadataMapKeys ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetCustomMetadataMapKeys$VH() {
        return constants$65.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetCustomMetadataMapKeys)(const OrtModelMetadata*,OrtAllocator*,char***,int64_t*);
     * }
     */
    public static MemorySegment ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$65.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetCustomMetadataMapKeys)(const OrtModelMetadata*,OrtAllocator*,char***,int64_t*);
     * }
     */
    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, MemorySegment x) {
        constants$65.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$65.const$2.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, long index, MemorySegment x) {
        constants$65.const$2.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys(
            MemorySegment segment, Arena scope) {
        return ModelMetadataGetCustomMetadataMapKeys.ofAddress(
                ModelMetadataGetCustomMetadataMapKeys$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public interface AddFreeDimensionOverrideByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(AddFreeDimensionOverrideByName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$65.const$3, fi, constants$38.const$1, scope);
        }

        static AddFreeDimensionOverrideByName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddFreeDimensionOverrideByName$VH() {
        return constants$65.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static MemorySegment AddFreeDimensionOverrideByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$65.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddFreeDimensionOverrideByName)(OrtSessionOptions*,char*,int64_t);
     * }
     */
    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, MemorySegment x) {
        constants$65.const$4.set(seg, 0L, x);
    }

    public static MemorySegment AddFreeDimensionOverrideByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$65.const$4.get(seg, index * sizeof());
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$65.const$4.set(seg, index * sizeof(), x);
    }

    public static AddFreeDimensionOverrideByName AddFreeDimensionOverrideByName(MemorySegment segment, Arena scope) {
        return AddFreeDimensionOverrideByName.ofAddress(AddFreeDimensionOverrideByName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetAvailableProviders)(char***,int*);
     * }
     */
    public interface GetAvailableProviders {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetAvailableProviders fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$65.const$5, fi, constants$15.const$4, scope);
        }

        static GetAvailableProviders ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetAvailableProviders$VH() {
        return constants$66.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAvailableProviders)(char***,int*);
     * }
     */
    public static MemorySegment GetAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$66.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetAvailableProviders)(char***,int*);
     * }
     */
    public static void GetAvailableProviders$set(MemorySegment seg, MemorySegment x) {
        constants$66.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$66.const$0.get(seg, index * sizeof());
    }

    public static void GetAvailableProviders$set(MemorySegment seg, long index, MemorySegment x) {
        constants$66.const$0.set(seg, index * sizeof(), x);
    }

    public static GetAvailableProviders GetAvailableProviders(MemorySegment segment, Arena scope) {
        return GetAvailableProviders.ofAddress(GetAvailableProviders$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public interface ReleaseAvailableProviders {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(ReleaseAvailableProviders fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$66.const$1, fi, constants$23.const$3, scope);
        }

        static ReleaseAvailableProviders ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseAvailableProviders$VH() {
        return constants$66.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public static MemorySegment ReleaseAvailableProviders$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$66.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ReleaseAvailableProviders)(char**,int);
     * }
     */
    public static void ReleaseAvailableProviders$set(MemorySegment seg, MemorySegment x) {
        constants$66.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseAvailableProviders$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$66.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, long index, MemorySegment x) {
        constants$66.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseAvailableProviders ReleaseAvailableProviders(MemorySegment segment, Arena scope) {
        return ReleaseAvailableProviders.ofAddress(ReleaseAvailableProviders$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
     * }
     */
    public interface GetStringTensorElementLength {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetStringTensorElementLength fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$66.const$3, fi, constants$30.const$3, scope);
        }

        static GetStringTensorElementLength ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorElementLength$VH() {
        return constants$66.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
     * }
     */
    public static MemorySegment GetStringTensorElementLength$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$66.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElementLength)(const OrtValue*,size_t,size_t*);
     * }
     */
    public static void GetStringTensorElementLength$set(MemorySegment seg, MemorySegment x) {
        constants$66.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorElementLength$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$66.const$4.get(seg, index * sizeof());
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, long index, MemorySegment x) {
        constants$66.const$4.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorElementLength GetStringTensorElementLength(MemorySegment segment, Arena scope) {
        return GetStringTensorElementLength.ofAddress(GetStringTensorElementLength$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
     * }
     */
    public interface GetStringTensorElement {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, long _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetStringTensorElement fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$67.const$0, fi, constants$66.const$5, scope);
        }

        static GetStringTensorElement ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$67.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetStringTensorElement$VH() {
        return constants$67.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
     * }
     */
    public static MemorySegment GetStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$67.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetStringTensorElement)(const OrtValue*,size_t,size_t,void*);
     * }
     */
    public static void GetStringTensorElement$set(MemorySegment seg, MemorySegment x) {
        constants$67.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$67.const$2.get(seg, index * sizeof());
    }

    public static void GetStringTensorElement$set(MemorySegment seg, long index, MemorySegment x) {
        constants$67.const$2.set(seg, index * sizeof(), x);
    }

    public static GetStringTensorElement GetStringTensorElement(MemorySegment segment, Arena scope) {
        return GetStringTensorElement.ofAddress(GetStringTensorElement$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
     * }
     */
    public interface FillStringTensorElement {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(FillStringTensorElement fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$67.const$3, fi, constants$38.const$1, scope);
        }

        static FillStringTensorElement ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillStringTensorElement$VH() {
        return constants$67.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
     * }
     */
    public static MemorySegment FillStringTensorElement$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$67.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillStringTensorElement)(OrtValue*,char*,size_t);
     * }
     */
    public static void FillStringTensorElement$set(MemorySegment seg, MemorySegment x) {
        constants$67.const$4.set(seg, 0L, x);
    }

    public static MemorySegment FillStringTensorElement$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$67.const$4.get(seg, index * sizeof());
    }

    public static void FillStringTensorElement$set(MemorySegment seg, long index, MemorySegment x) {
        constants$67.const$4.set(seg, index * sizeof(), x);
    }

    public static FillStringTensorElement FillStringTensorElement(MemorySegment segment, Arena scope) {
        return FillStringTensorElement.ofAddress(FillStringTensorElement$get(segment), scope);
    }
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

        static MemorySegment allocate(AddSessionConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$67.const$5, fi, constants$15.const$0, scope);
        }

        static AddSessionConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddSessionConfigEntry$VH() {
        return constants$68.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddSessionConfigEntry)(OrtSessionOptions*,char*,char*);
     * }
     */
    public static MemorySegment AddSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$68.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddSessionConfigEntry)(OrtSessionOptions*,char*,char*);
     * }
     */
    public static void AddSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$68.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AddSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$68.const$0.get(seg, index * sizeof());
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$68.const$0.set(seg, index * sizeof(), x);
    }

    public static AddSessionConfigEntry AddSessionConfigEntry(MemorySegment segment, Arena scope) {
        return AddSessionConfigEntry.ofAddress(AddSessionConfigEntry$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$68.const$1, fi, constants$15.const$0, scope);
        }

        static CreateAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateAllocator$VH() {
        return constants$68.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAllocator)(const OrtSession*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public static MemorySegment CreateAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$68.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAllocator)(const OrtSession*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public static void CreateAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$68.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$68.const$2.get(seg, index * sizeof());
    }

    public static void CreateAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$68.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateAllocator CreateAllocator(MemorySegment segment, Arena scope) {
        return CreateAllocator.ofAddress(CreateAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseAllocator)(OrtAllocator*);
     * }
     */
    public interface ReleaseAllocator {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$68.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseAllocator$VH() {
        return constants$68.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseAllocator)(OrtAllocator*);
     * }
     */
    public static MemorySegment ReleaseAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$68.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseAllocator)(OrtAllocator*);
     * }
     */
    public static void ReleaseAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$68.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$68.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$68.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseAllocator ReleaseAllocator(MemorySegment segment, Arena scope) {
        return ReleaseAllocator.ofAddress(ReleaseAllocator$get(segment), scope);
    }
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

        static MemorySegment allocate(RunWithBinding fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$68.const$5, fi, constants$15.const$0, scope);
        }

        static RunWithBinding ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunWithBinding$VH() {
        return constants$69.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunWithBinding)(OrtSession*,const OrtRunOptions*,const OrtIoBinding*);
     * }
     */
    public static MemorySegment RunWithBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$69.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunWithBinding)(OrtSession*,const OrtRunOptions*,const OrtIoBinding*);
     * }
     */
    public static void RunWithBinding$set(MemorySegment seg, MemorySegment x) {
        constants$69.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunWithBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$69.const$0.get(seg, index * sizeof());
    }

    public static void RunWithBinding$set(MemorySegment seg, long index, MemorySegment x) {
        constants$69.const$0.set(seg, index * sizeof(), x);
    }

    public static RunWithBinding RunWithBinding(MemorySegment segment, Arena scope) {
        return RunWithBinding.ofAddress(RunWithBinding$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
     * }
     */
    public interface CreateIoBinding {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CreateIoBinding fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$69.const$1, fi, constants$15.const$4, scope);
        }

        static CreateIoBinding ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateIoBinding$VH() {
        return constants$69.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
     * }
     */
    public static MemorySegment CreateIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$69.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateIoBinding)(OrtSession*,OrtIoBinding**);
     * }
     */
    public static void CreateIoBinding$set(MemorySegment seg, MemorySegment x) {
        constants$69.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$69.const$2.get(seg, index * sizeof());
    }

    public static void CreateIoBinding$set(MemorySegment seg, long index, MemorySegment x) {
        constants$69.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateIoBinding CreateIoBinding(MemorySegment segment, Arena scope) {
        return CreateIoBinding.ofAddress(CreateIoBinding$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseIoBinding)(OrtIoBinding*);
     * }
     */
    public interface ReleaseIoBinding {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseIoBinding fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$69.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseIoBinding ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseIoBinding$VH() {
        return constants$69.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseIoBinding)(OrtIoBinding*);
     * }
     */
    public static MemorySegment ReleaseIoBinding$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$69.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseIoBinding)(OrtIoBinding*);
     * }
     */
    public static void ReleaseIoBinding$set(MemorySegment seg, MemorySegment x) {
        constants$69.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseIoBinding$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$69.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, long index, MemorySegment x) {
        constants$69.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseIoBinding ReleaseIoBinding(MemorySegment segment, Arena scope) {
        return ReleaseIoBinding.ofAddress(ReleaseIoBinding$get(segment), scope);
    }
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

        static MemorySegment allocate(BindInput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$69.const$5, fi, constants$15.const$0, scope);
        }

        static BindInput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle BindInput$VH() {
        return constants$70.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*BindInput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static MemorySegment BindInput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$70.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*BindInput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static void BindInput$set(MemorySegment seg, MemorySegment x) {
        constants$70.const$0.set(seg, 0L, x);
    }

    public static MemorySegment BindInput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$70.const$0.get(seg, index * sizeof());
    }

    public static void BindInput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$70.const$0.set(seg, index * sizeof(), x);
    }

    public static BindInput BindInput(MemorySegment segment, Arena scope) {
        return BindInput.ofAddress(BindInput$get(segment), scope);
    }
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

        static MemorySegment allocate(BindOutput fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$70.const$1, fi, constants$15.const$0, scope);
        }

        static BindOutput ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle BindOutput$VH() {
        return constants$70.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static MemorySegment BindOutput$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$70.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutput)(OrtIoBinding*,char*,const OrtValue*);
     * }
     */
    public static void BindOutput$set(MemorySegment seg, MemorySegment x) {
        constants$70.const$2.set(seg, 0L, x);
    }

    public static MemorySegment BindOutput$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$70.const$2.get(seg, index * sizeof());
    }

    public static void BindOutput$set(MemorySegment seg, long index, MemorySegment x) {
        constants$70.const$2.set(seg, index * sizeof(), x);
    }

    public static BindOutput BindOutput(MemorySegment segment, Arena scope) {
        return BindOutput.ofAddress(BindOutput$get(segment), scope);
    }
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

        static MemorySegment allocate(BindOutputToDevice fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$70.const$3, fi, constants$15.const$0, scope);
        }

        static BindOutputToDevice ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle BindOutputToDevice$VH() {
        return constants$70.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutputToDevice)(OrtIoBinding*,char*,const OrtMemoryInfo*);
     * }
     */
    public static MemorySegment BindOutputToDevice$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$70.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*BindOutputToDevice)(OrtIoBinding*,char*,const OrtMemoryInfo*);
     * }
     */
    public static void BindOutputToDevice$set(MemorySegment seg, MemorySegment x) {
        constants$70.const$4.set(seg, 0L, x);
    }

    public static MemorySegment BindOutputToDevice$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$70.const$4.get(seg, index * sizeof());
    }

    public static void BindOutputToDevice$set(MemorySegment seg, long index, MemorySegment x) {
        constants$70.const$4.set(seg, index * sizeof(), x);
    }

    public static BindOutputToDevice BindOutputToDevice(MemorySegment segment, Arena scope) {
        return BindOutputToDevice.ofAddress(BindOutputToDevice$get(segment), scope);
    }
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

        static MemorySegment allocate(GetBoundOutputNames fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$71.const$0, fi, constants$70.const$5, scope);
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
                            constants$71.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetBoundOutputNames$VH() {
        return constants$71.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputNames)(const OrtIoBinding*,OrtAllocator*,char**,size_t**,size_t*);
     * }
     */
    public static MemorySegment GetBoundOutputNames$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$71.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputNames)(const OrtIoBinding*,OrtAllocator*,char**,size_t**,size_t*);
     * }
     */
    public static void GetBoundOutputNames$set(MemorySegment seg, MemorySegment x) {
        constants$71.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetBoundOutputNames$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$71.const$2.get(seg, index * sizeof());
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, long index, MemorySegment x) {
        constants$71.const$2.set(seg, index * sizeof(), x);
    }

    public static GetBoundOutputNames GetBoundOutputNames(MemorySegment segment, Arena scope) {
        return GetBoundOutputNames.ofAddress(GetBoundOutputNames$get(segment), scope);
    }
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

        static MemorySegment allocate(GetBoundOutputValues fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$71.const$3, fi, constants$20.const$3, scope);
        }

        static GetBoundOutputValues ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetBoundOutputValues$VH() {
        return constants$71.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputValues)(const OrtIoBinding*,OrtAllocator*,OrtValue***,size_t*);
     * }
     */
    public static MemorySegment GetBoundOutputValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$71.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetBoundOutputValues)(const OrtIoBinding*,OrtAllocator*,OrtValue***,size_t*);
     * }
     */
    public static void GetBoundOutputValues$set(MemorySegment seg, MemorySegment x) {
        constants$71.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetBoundOutputValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$71.const$4.get(seg, index * sizeof());
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, long index, MemorySegment x) {
        constants$71.const$4.set(seg, index * sizeof(), x);
    }

    public static GetBoundOutputValues GetBoundOutputValues(MemorySegment segment, Arena scope) {
        return GetBoundOutputValues.ofAddress(GetBoundOutputValues$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ClearBoundInputs)(OrtIoBinding*);
     * }
     */
    public interface ClearBoundInputs {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ClearBoundInputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$71.const$5, fi, constants$14.const$1, scope);
        }

        static ClearBoundInputs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ClearBoundInputs$VH() {
        return constants$72.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ClearBoundInputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment ClearBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$72.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ClearBoundInputs)(OrtIoBinding*);
     * }
     */
    public static void ClearBoundInputs$set(MemorySegment seg, MemorySegment x) {
        constants$72.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ClearBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$72.const$0.get(seg, index * sizeof());
    }

    public static void ClearBoundInputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$72.const$0.set(seg, index * sizeof(), x);
    }

    public static ClearBoundInputs ClearBoundInputs(MemorySegment segment, Arena scope) {
        return ClearBoundInputs.ofAddress(ClearBoundInputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ClearBoundOutputs)(OrtIoBinding*);
     * }
     */
    public interface ClearBoundOutputs {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ClearBoundOutputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$72.const$1, fi, constants$14.const$1, scope);
        }

        static ClearBoundOutputs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ClearBoundOutputs$VH() {
        return constants$72.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ClearBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment ClearBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$72.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ClearBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static void ClearBoundOutputs$set(MemorySegment seg, MemorySegment x) {
        constants$72.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ClearBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$72.const$2.get(seg, index * sizeof());
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$72.const$2.set(seg, index * sizeof(), x);
    }

    public static ClearBoundOutputs ClearBoundOutputs(MemorySegment segment, Arena scope) {
        return ClearBoundOutputs.ofAddress(ClearBoundOutputs$get(segment), scope);
    }
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

        static MemorySegment allocate(TensorAt fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$72.const$4, fi, constants$72.const$3, scope);
        }

        static TensorAt ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$72.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle TensorAt$VH() {
        return constants$73.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*TensorAt)(OrtValue*,const int64_t*,size_t,void**);
     * }
     */
    public static MemorySegment TensorAt$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$73.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*TensorAt)(OrtValue*,const int64_t*,size_t,void**);
     * }
     */
    public static void TensorAt$set(MemorySegment seg, MemorySegment x) {
        constants$73.const$0.set(seg, 0L, x);
    }

    public static MemorySegment TensorAt$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$73.const$0.get(seg, index * sizeof());
    }

    public static void TensorAt$set(MemorySegment seg, long index, MemorySegment x) {
        constants$73.const$0.set(seg, index * sizeof(), x);
    }

    public static TensorAt TensorAt(MemorySegment segment, Arena scope) {
        return TensorAt.ofAddress(TensorAt$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateAndRegisterAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$73.const$1, fi, constants$15.const$0, scope);
        }

        static CreateAndRegisterAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateAndRegisterAllocator$VH() {
        return constants$73.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocator)(OrtEnv*,const OrtMemoryInfo*,const OrtArenaCfg*);
     * }
     */
    public static MemorySegment CreateAndRegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$73.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocator)(OrtEnv*,const OrtMemoryInfo*,const OrtArenaCfg*);
     * }
     */
    public static void CreateAndRegisterAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$73.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateAndRegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$73.const$2.get(seg, index * sizeof());
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$73.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateAndRegisterAllocator CreateAndRegisterAllocator(MemorySegment segment, Arena scope) {
        return CreateAndRegisterAllocator.ofAddress(CreateAndRegisterAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
     * }
     */
    public interface SetLanguageProjection {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetLanguageProjection fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$73.const$3, fi, constants$23.const$3, scope);
        }

        static SetLanguageProjection ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetLanguageProjection$VH() {
        return constants$73.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
     * }
     */
    public static MemorySegment SetLanguageProjection$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$73.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetLanguageProjection)(const OrtEnv*,OrtLanguageProjection);
     * }
     */
    public static void SetLanguageProjection$set(MemorySegment seg, MemorySegment x) {
        constants$73.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetLanguageProjection$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$73.const$4.get(seg, index * sizeof());
    }

    public static void SetLanguageProjection$set(MemorySegment seg, long index, MemorySegment x) {
        constants$73.const$4.set(seg, index * sizeof(), x);
    }

    public static SetLanguageProjection SetLanguageProjection(MemorySegment segment, Arena scope) {
        return SetLanguageProjection.ofAddress(SetLanguageProjection$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
     * }
     */
    public interface SessionGetProfilingStartTimeNs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionGetProfilingStartTimeNs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$73.const$5, fi, constants$15.const$4, scope);
        }

        static SessionGetProfilingStartTimeNs ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionGetProfilingStartTimeNs$VH() {
        return constants$74.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
     * }
     */
    public static MemorySegment SessionGetProfilingStartTimeNs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$74.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionGetProfilingStartTimeNs)(const OrtSession*,uint64_t*);
     * }
     */
    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, MemorySegment x) {
        constants$74.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionGetProfilingStartTimeNs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$74.const$0.get(seg, index * sizeof());
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$74.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs(MemorySegment segment, Arena scope) {
        return SessionGetProfilingStartTimeNs.ofAddress(SessionGetProfilingStartTimeNs$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalIntraOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalIntraOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$74.const$1, fi, constants$23.const$3, scope);
        }

        static SetGlobalIntraOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalIntraOpNumThreads$VH() {
        return constants$74.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalIntraOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$74.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$74.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$74.const$2.get(seg, index * sizeof());
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$74.const$2.set(seg, index * sizeof(), x);
    }

    public static SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads(MemorySegment segment, Arena scope) {
        return SetGlobalIntraOpNumThreads.ofAddress(SetGlobalIntraOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalInterOpNumThreads {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalInterOpNumThreads fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$74.const$3, fi, constants$23.const$3, scope);
        }

        static SetGlobalInterOpNumThreads ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalInterOpNumThreads$VH() {
        return constants$74.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalInterOpNumThreads$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$74.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalInterOpNumThreads)(OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, MemorySegment x) {
        constants$74.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalInterOpNumThreads$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$74.const$4.get(seg, index * sizeof());
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, long index, MemorySegment x) {
        constants$74.const$4.set(seg, index * sizeof(), x);
    }

    public static SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads(MemorySegment segment, Arena scope) {
        return SetGlobalInterOpNumThreads.ofAddress(SetGlobalInterOpNumThreads$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
     * }
     */
    public interface SetGlobalSpinControl {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(SetGlobalSpinControl fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$74.const$5, fi, constants$23.const$3, scope);
        }

        static SetGlobalSpinControl ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalSpinControl$VH() {
        return constants$75.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
     * }
     */
    public static MemorySegment SetGlobalSpinControl$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$75.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalSpinControl)(OrtThreadingOptions*,int);
     * }
     */
    public static void SetGlobalSpinControl$set(MemorySegment seg, MemorySegment x) {
        constants$75.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalSpinControl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$75.const$0.get(seg, index * sizeof());
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, long index, MemorySegment x) {
        constants$75.const$0.set(seg, index * sizeof(), x);
    }

    public static SetGlobalSpinControl SetGlobalSpinControl(MemorySegment segment, Arena scope) {
        return SetGlobalSpinControl.ofAddress(SetGlobalSpinControl$get(segment), scope);
    }
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

        static MemorySegment allocate(AddInitializer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$75.const$1, fi, constants$15.const$0, scope);
        }

        static AddInitializer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddInitializer$VH() {
        return constants$75.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddInitializer)(OrtSessionOptions*,char*,const OrtValue*);
     * }
     */
    public static MemorySegment AddInitializer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$75.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddInitializer)(OrtSessionOptions*,char*,const OrtValue*);
     * }
     */
    public static void AddInitializer$set(MemorySegment seg, MemorySegment x) {
        constants$75.const$2.set(seg, 0L, x);
    }

    public static MemorySegment AddInitializer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$75.const$2.get(seg, index * sizeof());
    }

    public static void AddInitializer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$75.const$2.set(seg, index * sizeof(), x);
    }

    public static AddInitializer AddInitializer(MemorySegment segment, Arena scope) {
        return AddInitializer.ofAddress(AddInitializer$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateEnvWithCustomLoggerAndGlobalThreadPools fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$75.const$4, fi, constants$75.const$3, scope);
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
                            constants$75.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$VH() {
        return constants$76.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,struct OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static MemorySegment CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$76.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateEnvWithCustomLoggerAndGlobalThreadPools)(OrtLoggingFunction,void*,OrtLoggingLevel,char*,struct OrtThreadingOptions*,OrtEnv**);
     * }
     */
    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(MemorySegment seg, MemorySegment x) {
        constants$76.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$76.const$0.get(seg, index * sizeof());
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$76.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools(
            MemorySegment segment, Arena scope) {
        return CreateEnvWithCustomLoggerAndGlobalThreadPools.ofAddress(
                CreateEnvWithCustomLoggerAndGlobalThreadPools$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CUDA {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$76.const$1, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA$VH() {
        return constants$76.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$76.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA)(OrtSessionOptions*,const OrtCUDAProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, MemorySegment x) {
        constants$76.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$76.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, long index, MemorySegment x) {
        constants$76.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA SessionOptionsAppendExecutionProvider_CUDA(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_CUDA.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_ROCM {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_ROCM fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$76.const$3, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_ROCM ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_ROCM$VH() {
        return constants$76.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$76.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_ROCM)(OrtSessionOptions*,const OrtROCMProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, MemorySegment x) {
        constants$76.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$76.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, long index, MemorySegment x) {
        constants$76.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_ROCM.ofAddress(
                SessionOptionsAppendExecutionProvider_ROCM$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_OpenVINO {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_OpenVINO fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$76.const$5, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_OpenVINO$VH() {
        return constants$77.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$77.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO)(OrtSessionOptions*,const OrtOpenVINOProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(MemorySegment seg, MemorySegment x) {
        constants$77.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$77.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$77.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_OpenVINO.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
     * }
     */
    public interface SetGlobalDenormalAsZero {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SetGlobalDenormalAsZero fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$77.const$1, fi, constants$1.const$4, scope);
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
        return constants$77.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
     * }
     */
    public static MemorySegment SetGlobalDenormalAsZero$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$77.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalDenormalAsZero)(OrtThreadingOptions*);
     * }
     */
    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, MemorySegment x) {
        constants$77.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalDenormalAsZero$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$77.const$2.get(seg, index * sizeof());
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, long index, MemorySegment x) {
        constants$77.const$2.set(seg, index * sizeof(), x);
    }

    public static SetGlobalDenormalAsZero SetGlobalDenormalAsZero(MemorySegment segment, Arena scope) {
        return SetGlobalDenormalAsZero.ofAddress(SetGlobalDenormalAsZero$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
     * }
     */
    public interface CreateArenaCfg {

        java.lang.foreign.MemorySegment apply(long _x0, int _x1, int _x2, int _x3, java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(CreateArenaCfg fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$77.const$4, fi, constants$77.const$3, scope);
        }

        static CreateArenaCfg ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (long __x0, int __x1, int __x2, int __x3, java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$77.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateArenaCfg$VH() {
        return constants$78.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
     * }
     */
    public static MemorySegment CreateArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$78.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfg)(size_t,int,int,int,OrtArenaCfg**);
     * }
     */
    public static void CreateArenaCfg$set(MemorySegment seg, MemorySegment x) {
        constants$78.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$78.const$0.get(seg, index * sizeof());
    }

    public static void CreateArenaCfg$set(MemorySegment seg, long index, MemorySegment x) {
        constants$78.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateArenaCfg CreateArenaCfg(MemorySegment segment, Arena scope) {
        return CreateArenaCfg.ofAddress(CreateArenaCfg$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseArenaCfg)(OrtArenaCfg*);
     * }
     */
    public interface ReleaseArenaCfg {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseArenaCfg fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$78.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseArenaCfg ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseArenaCfg$VH() {
        return constants$78.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseArenaCfg)(OrtArenaCfg*);
     * }
     */
    public static MemorySegment ReleaseArenaCfg$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$78.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseArenaCfg)(OrtArenaCfg*);
     * }
     */
    public static void ReleaseArenaCfg$set(MemorySegment seg, MemorySegment x) {
        constants$78.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseArenaCfg$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$78.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, long index, MemorySegment x) {
        constants$78.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseArenaCfg ReleaseArenaCfg(MemorySegment segment, Arena scope) {
        return ReleaseArenaCfg.ofAddress(ReleaseArenaCfg$get(segment), scope);
    }
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

        static MemorySegment allocate(ModelMetadataGetGraphDescription fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$78.const$3, fi, constants$15.const$0, scope);
        }

        static ModelMetadataGetGraphDescription ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ModelMetadataGetGraphDescription$VH() {
        return constants$78.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment ModelMetadataGetGraphDescription$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$78.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ModelMetadataGetGraphDescription)(const OrtModelMetadata*,OrtAllocator*,char**);
     * }
     */
    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, MemorySegment x) {
        constants$78.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ModelMetadataGetGraphDescription$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$78.const$4.get(seg, index * sizeof());
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, long index, MemorySegment x) {
        constants$78.const$4.set(seg, index * sizeof(), x);
    }

    public static ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription(
            MemorySegment segment, Arena scope) {
        return ModelMetadataGetGraphDescription.ofAddress(ModelMetadataGetGraphDescription$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_TensorRT {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$78.const$5, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT$VH() {
        return constants$79.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$79.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT)(OrtSessionOptions*,const OrtTensorRTProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(MemorySegment seg, MemorySegment x) {
        constants$79.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$79.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$79.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT SessionOptionsAppendExecutionProvider_TensorRT(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_TensorRT.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public interface SetCurrentGpuDeviceId {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(SetCurrentGpuDeviceId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$79.const$1, fi, constants$12.const$4, scope);
        }

        static SetCurrentGpuDeviceId ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$13.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetCurrentGpuDeviceId$VH() {
        return constants$79.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public static MemorySegment SetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$79.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetCurrentGpuDeviceId)(int);
     * }
     */
    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, MemorySegment x) {
        constants$79.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$79.const$2.get(seg, index * sizeof());
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$79.const$2.set(seg, index * sizeof(), x);
    }

    public static SetCurrentGpuDeviceId SetCurrentGpuDeviceId(MemorySegment segment, Arena scope) {
        return SetCurrentGpuDeviceId.ofAddress(SetCurrentGpuDeviceId$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public interface GetCurrentGpuDeviceId {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetCurrentGpuDeviceId fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$79.const$3, fi, constants$1.const$4, scope);
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
        return constants$79.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public static MemorySegment GetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$79.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCurrentGpuDeviceId)(int*);
     * }
     */
    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, MemorySegment x) {
        constants$79.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$79.const$4.get(seg, index * sizeof());
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemorySegment x) {
        constants$79.const$4.set(seg, index * sizeof(), x);
    }

    public static GetCurrentGpuDeviceId GetCurrentGpuDeviceId(MemorySegment segment, Arena scope) {
        return GetCurrentGpuDeviceId.ofAddress(GetCurrentGpuDeviceId$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfoGetAttributeArray_float fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$79.const$5, fi, constants$20.const$3, scope);
        }

        static KernelInfoGetAttributeArray_float ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttributeArray_float$VH() {
        return constants$80.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_float)(const OrtKernelInfo*,char*,float*,size_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttributeArray_float$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$80.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_float)(const OrtKernelInfo*,char*,float*,size_t*);
     * }
     */
    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, MemorySegment x) {
        constants$80.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttributeArray_float$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$80.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, long index, MemorySegment x) {
        constants$80.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttributeArray_float KernelInfoGetAttributeArray_float(
            MemorySegment segment, Arena scope) {
        return KernelInfoGetAttributeArray_float.ofAddress(KernelInfoGetAttributeArray_float$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfoGetAttributeArray_int64 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$80.const$1, fi, constants$20.const$3, scope);
        }

        static KernelInfoGetAttributeArray_int64 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttributeArray_int64$VH() {
        return constants$80.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_int64)(const OrtKernelInfo*,char*,int64_t*,size_t*);
     * }
     */
    public static MemorySegment KernelInfoGetAttributeArray_int64$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$80.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttributeArray_int64)(const OrtKernelInfo*,char*,int64_t*,size_t*);
     * }
     */
    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, MemorySegment x) {
        constants$80.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttributeArray_int64$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$80.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, long index, MemorySegment x) {
        constants$80.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttributeArray_int64 KernelInfoGetAttributeArray_int64(
            MemorySegment segment, Arena scope) {
        return KernelInfoGetAttributeArray_int64.ofAddress(KernelInfoGetAttributeArray_int64$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateArenaCfgV2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$80.const$3, fi, constants$72.const$3, scope);
        }

        static CreateArenaCfgV2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$72.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateArenaCfgV2$VH() {
        return constants$80.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfgV2)(char**,const size_t*,size_t,OrtArenaCfg**);
     * }
     */
    public static MemorySegment CreateArenaCfgV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$80.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateArenaCfgV2)(char**,const size_t*,size_t,OrtArenaCfg**);
     * }
     */
    public static void CreateArenaCfgV2$set(MemorySegment seg, MemorySegment x) {
        constants$80.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateArenaCfgV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$80.const$4.get(seg, index * sizeof());
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$80.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateArenaCfgV2 CreateArenaCfgV2(MemorySegment segment, Arena scope) {
        return CreateArenaCfgV2.ofAddress(CreateArenaCfgV2$get(segment), scope);
    }
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

        static MemorySegment allocate(AddRunConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$80.const$5, fi, constants$15.const$0, scope);
        }

        static AddRunConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddRunConfigEntry$VH() {
        return constants$81.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddRunConfigEntry)(OrtRunOptions*,char*,char*);
     * }
     */
    public static MemorySegment AddRunConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$81.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddRunConfigEntry)(OrtRunOptions*,char*,char*);
     * }
     */
    public static void AddRunConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$81.const$0.set(seg, 0L, x);
    }

    public static MemorySegment AddRunConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$81.const$0.get(seg, index * sizeof());
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$81.const$0.set(seg, index * sizeof(), x);
    }

    public static AddRunConfigEntry AddRunConfigEntry(MemorySegment segment, Arena scope) {
        return AddRunConfigEntry.ofAddress(AddRunConfigEntry$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
     * }
     */
    public interface CreatePrepackedWeightsContainer {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreatePrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$81.const$1, fi, constants$1.const$4, scope);
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
        return constants$81.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
     * }
     */
    public static MemorySegment CreatePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$81.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreatePrepackedWeightsContainer)(OrtPrepackedWeightsContainer**);
     * }
     */
    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$81.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreatePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$81.const$2.get(seg, index * sizeof());
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$81.const$2.set(seg, index * sizeof(), x);
    }

    public static CreatePrepackedWeightsContainer CreatePrepackedWeightsContainer(MemorySegment segment, Arena scope) {
        return CreatePrepackedWeightsContainer.ofAddress(CreatePrepackedWeightsContainer$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
     * }
     */
    public interface ReleasePrepackedWeightsContainer {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleasePrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$81.const$3, fi, constants$14.const$1, scope);
        }

        static ReleasePrepackedWeightsContainer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleasePrepackedWeightsContainer$VH() {
        return constants$81.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
     * }
     */
    public static MemorySegment ReleasePrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$81.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleasePrepackedWeightsContainer)(OrtPrepackedWeightsContainer*);
     * }
     */
    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$81.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleasePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$81.const$4.get(seg, index * sizeof());
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$81.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleasePrepackedWeightsContainer ReleasePrepackedWeightsContainer(
            MemorySegment segment, Arena scope) {
        return ReleasePrepackedWeightsContainer.ofAddress(ReleasePrepackedWeightsContainer$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateSessionWithPrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$81.const$5, fi, constants$70.const$5, scope);
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
                            constants$71.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionWithPrepackedWeightsContainer$VH() {
        return constants$82.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionWithPrepackedWeightsContainer)(const OrtEnv*,char*,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$82.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionWithPrepackedWeightsContainer)(const OrtEnv*,char*,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$82.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$82.const$0.get(seg, index * sizeof());
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$82.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateSessionWithPrepackedWeightsContainer CreateSessionWithPrepackedWeightsContainer(
            MemorySegment segment, Arena scope) {
        return CreateSessionWithPrepackedWeightsContainer.ofAddress(
                CreateSessionWithPrepackedWeightsContainer$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateSessionFromArrayWithPrepackedWeightsContainer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$82.const$2, fi, constants$82.const$1, scope);
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
                            constants$82.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSessionFromArrayWithPrepackedWeightsContainer$VH() {
        return constants$82.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArrayWithPrepackedWeightsContainer)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static MemorySegment CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$82.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSessionFromArrayWithPrepackedWeightsContainer)(const OrtEnv*,void*,size_t,const OrtSessionOptions*,OrtPrepackedWeightsContainer*,OrtSession**);
     * }
     */
    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(MemorySegment seg, MemorySegment x) {
        constants$82.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$82.const$4.get(seg, index * sizeof());
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$82.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateSessionFromArrayWithPrepackedWeightsContainer
            CreateSessionFromArrayWithPrepackedWeightsContainer(MemorySegment segment, Arena scope) {
        return CreateSessionFromArrayWithPrepackedWeightsContainer.ofAddress(
                CreateSessionFromArrayWithPrepackedWeightsContainer$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_TensorRT_V2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_TensorRT_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$82.const$5, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$VH() {
        return constants$83.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$83.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_TensorRT_V2)(OrtSessionOptions*,const OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(MemorySegment seg, MemorySegment x) {
        constants$83.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$83.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$83.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_TensorRT_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT_V2$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
     * }
     */
    public interface CreateTensorRTProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateTensorRTProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$83.const$1, fi, constants$1.const$4, scope);
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
        return constants$83.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
     * }
     */
    public static MemorySegment CreateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$83.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2**);
     * }
     */
    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$83.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$83.const$2.get(seg, index * sizeof());
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$83.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateTensorRTProviderOptions CreateTensorRTProviderOptions(MemorySegment segment, Arena scope) {
        return CreateTensorRTProviderOptions.ofAddress(CreateTensorRTProviderOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(UpdateTensorRTProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$83.const$4, fi, constants$83.const$3, scope);
        }

        static UpdateTensorRTProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateTensorRTProviderOptions$VH() {
        return constants$84.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$84.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$84.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UpdateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$84.const$0.get(seg, index * sizeof());
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$84.const$0.set(seg, index * sizeof(), x);
    }

    public static UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateTensorRTProviderOptions.ofAddress(UpdateTensorRTProviderOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(GetTensorRTProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$84.const$1, fi, constants$15.const$0, scope);
        }

        static GetTensorRTProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorRTProviderOptionsAsString$VH() {
        return constants$84.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsAsString)(const OrtTensorRTProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetTensorRTProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$84.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsAsString)(const OrtTensorRTProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$84.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorRTProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$84.const$2.get(seg, index * sizeof());
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$84.const$2.set(seg, index * sizeof(), x);
    }

    public static GetTensorRTProviderOptionsAsString GetTensorRTProviderOptionsAsString(
            MemorySegment segment, Arena scope) {
        return GetTensorRTProviderOptionsAsString.ofAddress(GetTensorRTProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
     * }
     */
    public interface ReleaseTensorRTProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseTensorRTProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$84.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseTensorRTProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseTensorRTProviderOptions$VH() {
        return constants$84.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static MemorySegment ReleaseTensorRTProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$84.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseTensorRTProviderOptions)(OrtTensorRTProviderOptionsV2*);
     * }
     */
    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$84.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$84.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$84.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseTensorRTProviderOptions.ofAddress(ReleaseTensorRTProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
     * }
     */
    public interface EnableOrtCustomOps {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(EnableOrtCustomOps fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$84.const$5, fi, constants$1.const$4, scope);
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
        return constants$85.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
     * }
     */
    public static MemorySegment EnableOrtCustomOps$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$85.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*EnableOrtCustomOps)(OrtSessionOptions*);
     * }
     */
    public static void EnableOrtCustomOps$set(MemorySegment seg, MemorySegment x) {
        constants$85.const$0.set(seg, 0L, x);
    }

    public static MemorySegment EnableOrtCustomOps$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$85.const$0.get(seg, index * sizeof());
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, long index, MemorySegment x) {
        constants$85.const$0.set(seg, index * sizeof(), x);
    }

    public static EnableOrtCustomOps EnableOrtCustomOps(MemorySegment segment, Arena scope) {
        return EnableOrtCustomOps.ofAddress(EnableOrtCustomOps$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
     * }
     */
    public interface RegisterAllocator {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RegisterAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$85.const$1, fi, constants$15.const$4, scope);
        }

        static RegisterAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterAllocator$VH() {
        return constants$85.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
     * }
     */
    public static MemorySegment RegisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$85.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterAllocator)(OrtEnv*,OrtAllocator*);
     * }
     */
    public static void RegisterAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$85.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RegisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$85.const$2.get(seg, index * sizeof());
    }

    public static void RegisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$85.const$2.set(seg, index * sizeof(), x);
    }

    public static RegisterAllocator RegisterAllocator(MemorySegment segment, Arena scope) {
        return RegisterAllocator.ofAddress(RegisterAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
     * }
     */
    public interface UnregisterAllocator {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(UnregisterAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$85.const$3, fi, constants$15.const$4, scope);
        }

        static UnregisterAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UnregisterAllocator$VH() {
        return constants$85.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
     * }
     */
    public static MemorySegment UnregisterAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$85.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UnregisterAllocator)(OrtEnv*,const OrtMemoryInfo*);
     * }
     */
    public static void UnregisterAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$85.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UnregisterAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$85.const$4.get(seg, index * sizeof());
    }

    public static void UnregisterAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$85.const$4.set(seg, index * sizeof(), x);
    }

    public static UnregisterAllocator UnregisterAllocator(MemorySegment segment, Arena scope) {
        return UnregisterAllocator.ofAddress(UnregisterAllocator$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
     * }
     */
    public interface IsSparseTensor {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(IsSparseTensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$85.const$5, fi, constants$15.const$4, scope);
        }

        static IsSparseTensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle IsSparseTensor$VH() {
        return constants$86.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
     * }
     */
    public static MemorySegment IsSparseTensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$86.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*IsSparseTensor)(const OrtValue*,int*);
     * }
     */
    public static void IsSparseTensor$set(MemorySegment seg, MemorySegment x) {
        constants$86.const$0.set(seg, 0L, x);
    }

    public static MemorySegment IsSparseTensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$86.const$0.get(seg, index * sizeof());
    }

    public static void IsSparseTensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$86.const$0.set(seg, index * sizeof(), x);
    }

    public static IsSparseTensor IsSparseTensor(MemorySegment segment, Arena scope) {
        return IsSparseTensor.ofAddress(IsSparseTensor$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateSparseTensorAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$86.const$1, fi, constants$36.const$1, scope);
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
                            constants$36.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSparseTensorAsOrtValue$VH() {
        return constants$86.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateSparseTensorAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$86.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorAsOrtValue)(OrtAllocator*,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$86.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateSparseTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$86.const$2.get(seg, index * sizeof());
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$86.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateSparseTensorAsOrtValue CreateSparseTensorAsOrtValue(MemorySegment segment, Arena scope) {
        return CreateSparseTensorAsOrtValue.ofAddress(CreateSparseTensorAsOrtValue$get(segment), scope);
    }
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

        static MemorySegment allocate(FillSparseTensorCoo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$86.const$4, fi, constants$86.const$3, scope);
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
                            constants$86.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillSparseTensorCoo$VH() {
        return constants$87.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCoo)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t);
     * }
     */
    public static MemorySegment FillSparseTensorCoo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$87.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCoo)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t);
     * }
     */
    public static void FillSparseTensorCoo$set(MemorySegment seg, MemorySegment x) {
        constants$87.const$0.set(seg, 0L, x);
    }

    public static MemorySegment FillSparseTensorCoo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$87.const$0.get(seg, index * sizeof());
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$87.const$0.set(seg, index * sizeof(), x);
    }

    public static FillSparseTensorCoo FillSparseTensorCoo(MemorySegment segment, Arena scope) {
        return FillSparseTensorCoo.ofAddress(FillSparseTensorCoo$get(segment), scope);
    }
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

        static MemorySegment allocate(FillSparseTensorCsr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$87.const$2, fi, constants$87.const$1, scope);
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
                    return (java.lang.foreign.MemorySegment) constants$87.const$3.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillSparseTensorCsr$VH() {
        return constants$87.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCsr)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int64_t*,size_t);
     * }
     */
    public static MemorySegment FillSparseTensorCsr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$87.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorCsr)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int64_t*,size_t);
     * }
     */
    public static void FillSparseTensorCsr$set(MemorySegment seg, MemorySegment x) {
        constants$87.const$4.set(seg, 0L, x);
    }

    public static MemorySegment FillSparseTensorCsr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$87.const$4.get(seg, index * sizeof());
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$87.const$4.set(seg, index * sizeof(), x);
    }

    public static FillSparseTensorCsr FillSparseTensorCsr(MemorySegment segment, Arena scope) {
        return FillSparseTensorCsr.ofAddress(FillSparseTensorCsr$get(segment), scope);
    }
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

        static MemorySegment allocate(FillSparseTensorBlockSparse fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$88.const$0, fi, constants$87.const$5, scope);
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
                            constants$88.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle FillSparseTensorBlockSparse$VH() {
        return constants$88.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorBlockSparse)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int32_t*);
     * }
     */
    public static MemorySegment FillSparseTensorBlockSparse$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$88.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*FillSparseTensorBlockSparse)(OrtValue*,const OrtMemoryInfo*,const int64_t*,size_t,void*,const int64_t*,size_t,const int32_t*);
     * }
     */
    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, MemorySegment x) {
        constants$88.const$2.set(seg, 0L, x);
    }

    public static MemorySegment FillSparseTensorBlockSparse$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$88.const$2.get(seg, index * sizeof());
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, long index, MemorySegment x) {
        constants$88.const$2.set(seg, index * sizeof(), x);
    }

    public static FillSparseTensorBlockSparse FillSparseTensorBlockSparse(MemorySegment segment, Arena scope) {
        return FillSparseTensorBlockSparse.ofAddress(FillSparseTensorBlockSparse$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateSparseTensorWithValuesAsOrtValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$88.const$4, fi, constants$88.const$3, scope);
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
                            constants$88.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateSparseTensorWithValuesAsOrtValue$VH() {
        return constants$89.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorWithValuesAsOrtValue)(const OrtMemoryInfo*,void*,const int64_t*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static MemorySegment CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$89.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateSparseTensorWithValuesAsOrtValue)(const OrtMemoryInfo*,void*,const int64_t*,size_t,const int64_t*,size_t,ONNXTensorElementDataType,OrtValue**);
     * }
     */
    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, MemorySegment x) {
        constants$89.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$89.const$0.get(seg, index * sizeof());
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$89.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateSparseTensorWithValuesAsOrtValue CreateSparseTensorWithValuesAsOrtValue(
            MemorySegment segment, Arena scope) {
        return CreateSparseTensorWithValuesAsOrtValue.ofAddress(
                CreateSparseTensorWithValuesAsOrtValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
     * }
     */
    public interface UseCooIndices {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(UseCooIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$89.const$1, fi, constants$38.const$1, scope);
        }

        static UseCooIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UseCooIndices$VH() {
        return constants$89.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
     * }
     */
    public static MemorySegment UseCooIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$89.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCooIndices)(OrtValue*,int64_t*,size_t);
     * }
     */
    public static void UseCooIndices$set(MemorySegment seg, MemorySegment x) {
        constants$89.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UseCooIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$89.const$2.get(seg, index * sizeof());
    }

    public static void UseCooIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$89.const$2.set(seg, index * sizeof(), x);
    }

    public static UseCooIndices UseCooIndices(MemorySegment segment, Arena scope) {
        return UseCooIndices.ofAddress(UseCooIndices$get(segment), scope);
    }
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

        static MemorySegment allocate(UseCsrIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$89.const$3, fi, constants$39.const$1, scope);
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
                            constants$39.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UseCsrIndices$VH() {
        return constants$89.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCsrIndices)(OrtValue*,int64_t*,size_t,int64_t*,size_t);
     * }
     */
    public static MemorySegment UseCsrIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$89.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UseCsrIndices)(OrtValue*,int64_t*,size_t,int64_t*,size_t);
     * }
     */
    public static void UseCsrIndices$set(MemorySegment seg, MemorySegment x) {
        constants$89.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UseCsrIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$89.const$4.get(seg, index * sizeof());
    }

    public static void UseCsrIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$89.const$4.set(seg, index * sizeof(), x);
    }

    public static UseCsrIndices UseCsrIndices(MemorySegment segment, Arena scope) {
        return UseCsrIndices.ofAddress(UseCsrIndices$get(segment), scope);
    }
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

        static MemorySegment allocate(UseBlockSparseIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$89.const$5, fi, constants$72.const$3, scope);
        }

        static UseBlockSparseIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$72.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UseBlockSparseIndices$VH() {
        return constants$90.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UseBlockSparseIndices)(OrtValue*,const int64_t*,size_t,int32_t*);
     * }
     */
    public static MemorySegment UseBlockSparseIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$90.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UseBlockSparseIndices)(OrtValue*,const int64_t*,size_t,int32_t*);
     * }
     */
    public static void UseBlockSparseIndices$set(MemorySegment seg, MemorySegment x) {
        constants$90.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UseBlockSparseIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$90.const$0.get(seg, index * sizeof());
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$90.const$0.set(seg, index * sizeof(), x);
    }

    public static UseBlockSparseIndices UseBlockSparseIndices(MemorySegment segment, Arena scope) {
        return UseBlockSparseIndices.ofAddress(UseBlockSparseIndices$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public interface GetSparseTensorFormat {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSparseTensorFormat fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$90.const$1, fi, constants$15.const$4, scope);
        }

        static GetSparseTensorFormat ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorFormat$VH() {
        return constants$90.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public static MemorySegment GetSparseTensorFormat$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$90.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorFormat)(const OrtValue*,enum OrtSparseFormat*);
     * }
     */
    public static void GetSparseTensorFormat$set(MemorySegment seg, MemorySegment x) {
        constants$90.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorFormat$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$90.const$2.get(seg, index * sizeof());
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, long index, MemorySegment x) {
        constants$90.const$2.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorFormat GetSparseTensorFormat(MemorySegment segment, Arena scope) {
        return GetSparseTensorFormat.ofAddress(GetSparseTensorFormat$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetSparseTensorValuesTypeAndShape {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSparseTensorValuesTypeAndShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$90.const$3, fi, constants$15.const$4, scope);
        }

        static GetSparseTensorValuesTypeAndShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorValuesTypeAndShape$VH() {
        return constants$90.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetSparseTensorValuesTypeAndShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$90.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValuesTypeAndShape)(const OrtValue*,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, MemorySegment x) {
        constants$90.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorValuesTypeAndShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$90.const$4.get(seg, index * sizeof());
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$90.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorValuesTypeAndShape GetSparseTensorValuesTypeAndShape(
            MemorySegment segment, Arena scope) {
        return GetSparseTensorValuesTypeAndShape.ofAddress(GetSparseTensorValuesTypeAndShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
     * }
     */
    public interface GetSparseTensorValues {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetSparseTensorValues fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$90.const$5, fi, constants$15.const$4, scope);
        }

        static GetSparseTensorValues ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorValues$VH() {
        return constants$91.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
     * }
     */
    public static MemorySegment GetSparseTensorValues$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$91.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorValues)(const OrtValue*,void**);
     * }
     */
    public static void GetSparseTensorValues$set(MemorySegment seg, MemorySegment x) {
        constants$91.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorValues$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$91.const$0.get(seg, index * sizeof());
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, long index, MemorySegment x) {
        constants$91.const$0.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorValues GetSparseTensorValues(MemorySegment segment, Arena scope) {
        return GetSparseTensorValues.ofAddress(GetSparseTensorValues$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface GetSparseTensorIndicesTypeShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetSparseTensorIndicesTypeShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$91.const$2, fi, constants$91.const$1, scope);
        }

        static GetSparseTensorIndicesTypeShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$91.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorIndicesTypeShape$VH() {
        return constants$91.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment GetSparseTensorIndicesTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$91.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndicesTypeShape)(const OrtValue*,enum OrtSparseIndicesFormat,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, MemorySegment x) {
        constants$91.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorIndicesTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$91.const$4.get(seg, index * sizeof());
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$91.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorIndicesTypeShape GetSparseTensorIndicesTypeShape(MemorySegment segment, Arena scope) {
        return GetSparseTensorIndicesTypeShape.ofAddress(GetSparseTensorIndicesTypeShape$get(segment), scope);
    }
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

        static MemorySegment allocate(GetSparseTensorIndices fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$91.const$5, fi, constants$48.const$5, scope);
        }

        static GetSparseTensorIndices ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$49.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSparseTensorIndices$VH() {
        return constants$92.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndices)(const OrtValue*,enum OrtSparseIndicesFormat,size_t*,void**);
     * }
     */
    public static MemorySegment GetSparseTensorIndices$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$92.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSparseTensorIndices)(const OrtValue*,enum OrtSparseIndicesFormat,size_t*,void**);
     * }
     */
    public static void GetSparseTensorIndices$set(MemorySegment seg, MemorySegment x) {
        constants$92.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetSparseTensorIndices$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$92.const$0.get(seg, index * sizeof());
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, long index, MemorySegment x) {
        constants$92.const$0.set(seg, index * sizeof(), x);
    }

    public static GetSparseTensorIndices GetSparseTensorIndices(MemorySegment segment, Arena scope) {
        return GetSparseTensorIndices.ofAddress(GetSparseTensorIndices$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*HasValue)(const OrtValue*,int*);
     * }
     */
    public interface HasValue {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(HasValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$92.const$1, fi, constants$15.const$4, scope);
        }

        static HasValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle HasValue$VH() {
        return constants$92.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*HasValue)(const OrtValue*,int*);
     * }
     */
    public static MemorySegment HasValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$92.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*HasValue)(const OrtValue*,int*);
     * }
     */
    public static void HasValue$set(MemorySegment seg, MemorySegment x) {
        constants$92.const$2.set(seg, 0L, x);
    }

    public static MemorySegment HasValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$92.const$2.get(seg, index * sizeof());
    }

    public static void HasValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$92.const$2.set(seg, index * sizeof(), x);
    }

    public static HasValue HasValue(MemorySegment segment, Arena scope) {
        return HasValue.ofAddress(HasValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
     * }
     */
    public interface KernelContext_GetGPUComputeStream {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetGPUComputeStream fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$92.const$3, fi, constants$15.const$4, scope);
        }

        static KernelContext_GetGPUComputeStream ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetGPUComputeStream$VH() {
        return constants$92.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
     * }
     */
    public static MemorySegment KernelContext_GetGPUComputeStream$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$92.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetGPUComputeStream)(const OrtKernelContext*,void**);
     * }
     */
    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, MemorySegment x) {
        constants$92.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetGPUComputeStream$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$92.const$4.get(seg, index * sizeof());
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, long index, MemorySegment x) {
        constants$92.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetGPUComputeStream KernelContext_GetGPUComputeStream(
            MemorySegment segment, Arena scope) {
        return KernelContext_GetGPUComputeStream.ofAddress(KernelContext_GetGPUComputeStream$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
     * }
     */
    public interface GetTensorMemoryInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetTensorMemoryInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$92.const$5, fi, constants$15.const$4, scope);
        }

        static GetTensorMemoryInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorMemoryInfo$VH() {
        return constants$93.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
     * }
     */
    public static MemorySegment GetTensorMemoryInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$93.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorMemoryInfo)(const OrtValue*,const OrtMemoryInfo**);
     * }
     */
    public static void GetTensorMemoryInfo$set(MemorySegment seg, MemorySegment x) {
        constants$93.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorMemoryInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$93.const$0.get(seg, index * sizeof());
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$93.const$0.set(seg, index * sizeof(), x);
    }

    public static GetTensorMemoryInfo GetTensorMemoryInfo(MemorySegment segment, Arena scope) {
        return GetTensorMemoryInfo.ofAddress(GetTensorMemoryInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
     * }
     */
    public interface GetExecutionProviderApi {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetExecutionProviderApi fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$93.const$1, fi, constants$91.const$1, scope);
        }

        static GetExecutionProviderApi ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$91.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetExecutionProviderApi$VH() {
        return constants$93.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
     * }
     */
    public static MemorySegment GetExecutionProviderApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$93.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetExecutionProviderApi)(char*,uint32_t,void**);
     * }
     */
    public static void GetExecutionProviderApi$set(MemorySegment seg, MemorySegment x) {
        constants$93.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetExecutionProviderApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$93.const$2.get(seg, index * sizeof());
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, long index, MemorySegment x) {
        constants$93.const$2.set(seg, index * sizeof(), x);
    }

    public static GetExecutionProviderApi GetExecutionProviderApi(MemorySegment segment, Arena scope) {
        return GetExecutionProviderApi.ofAddress(GetExecutionProviderApi$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public interface SessionOptionsSetCustomCreateThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsSetCustomCreateThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$93.const$3, fi, constants$15.const$4, scope);
        }

        static SessionOptionsSetCustomCreateThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsSetCustomCreateThreadFn$VH() {
        return constants$93.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$93.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomCreateThreadFn)(OrtSessionOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$93.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$93.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$93.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsSetCustomCreateThreadFn SessionOptionsSetCustomCreateThreadFn(
            MemorySegment segment, Arena scope) {
        return SessionOptionsSetCustomCreateThreadFn.ofAddress(
                SessionOptionsSetCustomCreateThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
     * }
     */
    public interface SessionOptionsSetCustomThreadCreationOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsSetCustomThreadCreationOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$93.const$5, fi, constants$15.const$4, scope);
        }

        static SessionOptionsSetCustomThreadCreationOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsSetCustomThreadCreationOptions$VH() {
        return constants$94.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$94.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomThreadCreationOptions)(OrtSessionOptions*,void*);
     * }
     */
    public static void SessionOptionsSetCustomThreadCreationOptions$set(MemorySegment seg, MemorySegment x) {
        constants$94.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$94.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$94.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsSetCustomThreadCreationOptions SessionOptionsSetCustomThreadCreationOptions(
            MemorySegment segment, Arena scope) {
        return SessionOptionsSetCustomThreadCreationOptions.ofAddress(
                SessionOptionsSetCustomThreadCreationOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public interface SessionOptionsSetCustomJoinThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsSetCustomJoinThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$94.const$1, fi, constants$15.const$4, scope);
        }

        static SessionOptionsSetCustomJoinThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsSetCustomJoinThreadFn$VH() {
        return constants$94.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static MemorySegment SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$94.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsSetCustomJoinThreadFn)(OrtSessionOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$94.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$94.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$94.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsSetCustomJoinThreadFn SessionOptionsSetCustomJoinThreadFn(
            MemorySegment segment, Arena scope) {
        return SessionOptionsSetCustomJoinThreadFn.ofAddress(SessionOptionsSetCustomJoinThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public interface SetGlobalCustomCreateThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalCustomCreateThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$94.const$3, fi, constants$15.const$4, scope);
        }

        static SetGlobalCustomCreateThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalCustomCreateThreadFn$VH() {
        return constants$94.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static MemorySegment SetGlobalCustomCreateThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$94.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomCreateThreadFn)(OrtThreadingOptions*,OrtCustomCreateThreadFn);
     * }
     */
    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$94.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$94.const$4.get(seg, index * sizeof());
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$94.const$4.set(seg, index * sizeof(), x);
    }

    public static SetGlobalCustomCreateThreadFn SetGlobalCustomCreateThreadFn(MemorySegment segment, Arena scope) {
        return SetGlobalCustomCreateThreadFn.ofAddress(SetGlobalCustomCreateThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
     * }
     */
    public interface SetGlobalCustomThreadCreationOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalCustomThreadCreationOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$94.const$5, fi, constants$15.const$4, scope);
        }

        static SetGlobalCustomThreadCreationOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalCustomThreadCreationOptions$VH() {
        return constants$95.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
     * }
     */
    public static MemorySegment SetGlobalCustomThreadCreationOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$95.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomThreadCreationOptions)(OrtThreadingOptions*,void*);
     * }
     */
    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, MemorySegment x) {
        constants$95.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$95.const$0.get(seg, index * sizeof());
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$95.const$0.set(seg, index * sizeof(), x);
    }

    public static SetGlobalCustomThreadCreationOptions SetGlobalCustomThreadCreationOptions(
            MemorySegment segment, Arena scope) {
        return SetGlobalCustomThreadCreationOptions.ofAddress(SetGlobalCustomThreadCreationOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public interface SetGlobalCustomJoinThreadFn {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalCustomJoinThreadFn fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$95.const$1, fi, constants$15.const$4, scope);
        }

        static SetGlobalCustomJoinThreadFn ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalCustomJoinThreadFn$VH() {
        return constants$95.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static MemorySegment SetGlobalCustomJoinThreadFn$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$95.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalCustomJoinThreadFn)(OrtThreadingOptions*,OrtCustomJoinThreadFn);
     * }
     */
    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, MemorySegment x) {
        constants$95.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$95.const$2.get(seg, index * sizeof());
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, long index, MemorySegment x) {
        constants$95.const$2.set(seg, index * sizeof(), x);
    }

    public static SetGlobalCustomJoinThreadFn SetGlobalCustomJoinThreadFn(MemorySegment segment, Arena scope) {
        return SetGlobalCustomJoinThreadFn.ofAddress(SetGlobalCustomJoinThreadFn$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
     * }
     */
    public interface SynchronizeBoundInputs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SynchronizeBoundInputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$95.const$3, fi, constants$1.const$4, scope);
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
        return constants$95.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment SynchronizeBoundInputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$95.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundInputs)(OrtIoBinding*);
     * }
     */
    public static void SynchronizeBoundInputs$set(MemorySegment seg, MemorySegment x) {
        constants$95.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SynchronizeBoundInputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$95.const$4.get(seg, index * sizeof());
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$95.const$4.set(seg, index * sizeof(), x);
    }

    public static SynchronizeBoundInputs SynchronizeBoundInputs(MemorySegment segment, Arena scope) {
        return SynchronizeBoundInputs.ofAddress(SynchronizeBoundInputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
     * }
     */
    public interface SynchronizeBoundOutputs {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(SynchronizeBoundOutputs fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$95.const$5, fi, constants$1.const$4, scope);
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
        return constants$96.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static MemorySegment SynchronizeBoundOutputs$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$96.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SynchronizeBoundOutputs)(OrtIoBinding*);
     * }
     */
    public static void SynchronizeBoundOutputs$set(MemorySegment seg, MemorySegment x) {
        constants$96.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SynchronizeBoundOutputs$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$96.const$0.get(seg, index * sizeof());
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, long index, MemorySegment x) {
        constants$96.const$0.set(seg, index * sizeof(), x);
    }

    public static SynchronizeBoundOutputs SynchronizeBoundOutputs(MemorySegment segment, Arena scope) {
        return SynchronizeBoundOutputs.ofAddress(SynchronizeBoundOutputs$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CUDA_V2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CUDA_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$96.const$1, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA_V2$VH() {
        return constants$96.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$96.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CUDA_V2)(OrtSessionOptions*,const OrtCUDAProviderOptionsV2*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(MemorySegment seg, MemorySegment x) {
        constants$96.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CUDA_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$96.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$96.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA_V2 SessionOptionsAppendExecutionProvider_CUDA_V2(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_CUDA_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA_V2$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
     * }
     */
    public interface CreateCUDAProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateCUDAProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$96.const$3, fi, constants$1.const$4, scope);
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
        return constants$96.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
     * }
     */
    public static MemorySegment CreateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$96.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCUDAProviderOptions)(OrtCUDAProviderOptionsV2**);
     * }
     */
    public static void CreateCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$96.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$96.const$4.get(seg, index * sizeof());
    }

    public static void CreateCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$96.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateCUDAProviderOptions CreateCUDAProviderOptions(MemorySegment segment, Arena scope) {
        return CreateCUDAProviderOptions.ofAddress(CreateCUDAProviderOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(UpdateCUDAProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$96.const$5, fi, constants$83.const$3, scope);
        }

        static UpdateCUDAProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateCUDAProviderOptions$VH() {
        return constants$97.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptions)(OrtCUDAProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$97.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptions)(OrtCUDAProviderOptionsV2*,char**,char**,size_t);
     * }
     */
    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$97.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UpdateCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$97.const$0.get(seg, index * sizeof());
    }

    public static void UpdateCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$97.const$0.set(seg, index * sizeof(), x);
    }

    public static UpdateCUDAProviderOptions UpdateCUDAProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateCUDAProviderOptions.ofAddress(UpdateCUDAProviderOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(GetCUDAProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$97.const$1, fi, constants$15.const$0, scope);
        }

        static GetCUDAProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCUDAProviderOptionsAsString$VH() {
        return constants$97.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsAsString)(const OrtCUDAProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetCUDAProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$97.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsAsString)(const OrtCUDAProviderOptionsV2*,OrtAllocator*,char**);
     * }
     */
    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$97.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetCUDAProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$97.const$2.get(seg, index * sizeof());
    }

    public static void GetCUDAProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$97.const$2.set(seg, index * sizeof(), x);
    }

    public static GetCUDAProviderOptionsAsString GetCUDAProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetCUDAProviderOptionsAsString.ofAddress(GetCUDAProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
     * }
     */
    public interface ReleaseCUDAProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCUDAProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$97.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseCUDAProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseCUDAProviderOptions$VH() {
        return constants$97.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
     * }
     */
    public static MemorySegment ReleaseCUDAProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$97.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCUDAProviderOptions)(OrtCUDAProviderOptionsV2*);
     * }
     */
    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$97.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseCUDAProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$97.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseCUDAProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$97.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseCUDAProviderOptions ReleaseCUDAProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseCUDAProviderOptions.ofAddress(ReleaseCUDAProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_MIGraphX {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_MIGraphX fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$97.const$5, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_MIGraphX ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_MIGraphX$VH() {
        return constants$98.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$98.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_MIGraphX)(OrtSessionOptions*,const OrtMIGraphXProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(MemorySegment seg, MemorySegment x) {
        constants$98.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_MIGraphX$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$98.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_MIGraphX$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$98.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_MIGraphX SessionOptionsAppendExecutionProvider_MIGraphX(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_MIGraphX.ofAddress(
                SessionOptionsAppendExecutionProvider_MIGraphX$get(segment), scope);
    }
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

        static MemorySegment allocate(AddExternalInitializers fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$98.const$1, fi, constants$83.const$3, scope);
        }

        static AddExternalInitializers ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle AddExternalInitializers$VH() {
        return constants$98.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*AddExternalInitializers)(OrtSessionOptions*,char**,const OrtValue**,size_t);
     * }
     */
    public static MemorySegment AddExternalInitializers$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$98.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*AddExternalInitializers)(OrtSessionOptions*,char**,const OrtValue**,size_t);
     * }
     */
    public static void AddExternalInitializers$set(MemorySegment seg, MemorySegment x) {
        constants$98.const$2.set(seg, 0L, x);
    }

    public static MemorySegment AddExternalInitializers$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$98.const$2.get(seg, index * sizeof());
    }

    public static void AddExternalInitializers$set(MemorySegment seg, long index, MemorySegment x) {
        constants$98.const$2.set(seg, index * sizeof(), x);
    }

    public static AddExternalInitializers AddExternalInitializers(MemorySegment segment, Arena scope) {
        return AddExternalInitializers.ofAddress(AddExternalInitializers$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateOpAttr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$98.const$4, fi, constants$98.const$3, scope);
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
                            constants$98.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateOpAttr$VH() {
        return constants$99.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpAttr)(char*,void*,int,OrtOpAttrType,OrtOpAttr**);
     * }
     */
    public static MemorySegment CreateOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$99.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOpAttr)(char*,void*,int,OrtOpAttrType,OrtOpAttr**);
     * }
     */
    public static void CreateOpAttr$set(MemorySegment seg, MemorySegment x) {
        constants$99.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$99.const$0.get(seg, index * sizeof());
    }

    public static void CreateOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$99.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateOpAttr CreateOpAttr(MemorySegment segment, Arena scope) {
        return CreateOpAttr.ofAddress(CreateOpAttr$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseOpAttr)(OrtOpAttr*);
     * }
     */
    public interface ReleaseOpAttr {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseOpAttr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$99.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseOpAttr ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseOpAttr$VH() {
        return constants$99.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseOpAttr)(OrtOpAttr*);
     * }
     */
    public static MemorySegment ReleaseOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$99.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseOpAttr)(OrtOpAttr*);
     * }
     */
    public static void ReleaseOpAttr$set(MemorySegment seg, MemorySegment x) {
        constants$99.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$99.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$99.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseOpAttr ReleaseOpAttr(MemorySegment segment, Arena scope) {
        return ReleaseOpAttr.ofAddress(ReleaseOpAttr$get(segment), scope);
    }
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

        static MemorySegment allocate(CreateOp fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$99.const$4, fi, constants$99.const$3, scope);
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
                    return (java.lang.foreign.MemorySegment) constants$99.const$5.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8, __x9, __x10, __x11);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateOp$VH() {
        return constants$100.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOp)(const OrtKernelInfo*,char*,char*,int,char**,const ONNXTensorElementDataType*,int,const OrtOpAttr**,int,int,int,OrtOp**);
     * }
     */
    public static MemorySegment CreateOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$100.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateOp)(const OrtKernelInfo*,char*,char*,int,char**,const ONNXTensorElementDataType*,int,const OrtOpAttr**,int,int,int,OrtOp**);
     * }
     */
    public static void CreateOp$set(MemorySegment seg, MemorySegment x) {
        constants$100.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$100.const$0.get(seg, index * sizeof());
    }

    public static void CreateOp$set(MemorySegment seg, long index, MemorySegment x) {
        constants$100.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateOp CreateOp(MemorySegment segment, Arena scope) {
        return CreateOp.ofAddress(CreateOp$get(segment), scope);
    }
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

        static MemorySegment allocate(InvokeOp fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$100.const$2, fi, constants$100.const$1, scope);
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
                            constants$100.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle InvokeOp$VH() {
        return constants$100.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*InvokeOp)(const OrtKernelContext*,const OrtOp*,const OrtValue**,int,OrtValue**,int);
     * }
     */
    public static MemorySegment InvokeOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$100.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*InvokeOp)(const OrtKernelContext*,const OrtOp*,const OrtValue**,int,OrtValue**,int);
     * }
     */
    public static void InvokeOp$set(MemorySegment seg, MemorySegment x) {
        constants$100.const$4.set(seg, 0L, x);
    }

    public static MemorySegment InvokeOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$100.const$4.get(seg, index * sizeof());
    }

    public static void InvokeOp$set(MemorySegment seg, long index, MemorySegment x) {
        constants$100.const$4.set(seg, index * sizeof(), x);
    }

    public static InvokeOp InvokeOp(MemorySegment segment, Arena scope) {
        return InvokeOp.ofAddress(InvokeOp$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseOp)(OrtOp*);
     * }
     */
    public interface ReleaseOp {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseOp fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$100.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseOp ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseOp$VH() {
        return constants$101.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseOp)(OrtOp*);
     * }
     */
    public static MemorySegment ReleaseOp$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$101.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseOp)(OrtOp*);
     * }
     */
    public static void ReleaseOp$set(MemorySegment seg, MemorySegment x) {
        constants$101.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseOp$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$101.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseOp$set(MemorySegment seg, long index, MemorySegment x) {
        constants$101.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseOp ReleaseOp(MemorySegment segment, Arena scope) {
        return ReleaseOp.ofAddress(ReleaseOp$get(segment), scope);
    }
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

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$101.const$1, fi, constants$51.const$1, scope);
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
                            constants$51.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider$VH() {
        return constants$101.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider)(OrtSessionOptions*,char*,char**,char**,size_t);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$101.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider)(OrtSessionOptions*,char*,char**,char**,size_t);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, MemorySegment x) {
        constants$101.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$101.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider$set(MemorySegment seg, long index, MemorySegment x) {
        constants$101.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider SessionOptionsAppendExecutionProvider(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider.ofAddress(
                SessionOptionsAppendExecutionProvider$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
     * }
     */
    public interface CopyKernelInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CopyKernelInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$101.const$3, fi, constants$15.const$4, scope);
        }

        static CopyKernelInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CopyKernelInfo$VH() {
        return constants$101.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
     * }
     */
    public static MemorySegment CopyKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$101.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CopyKernelInfo)(const OrtKernelInfo*,OrtKernelInfo**);
     * }
     */
    public static void CopyKernelInfo$set(MemorySegment seg, MemorySegment x) {
        constants$101.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CopyKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$101.const$4.get(seg, index * sizeof());
    }

    public static void CopyKernelInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$101.const$4.set(seg, index * sizeof(), x);
    }

    public static CopyKernelInfo CopyKernelInfo(MemorySegment segment, Arena scope) {
        return CopyKernelInfo.ofAddress(CopyKernelInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseKernelInfo)(OrtKernelInfo*);
     * }
     */
    public interface ReleaseKernelInfo {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseKernelInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$101.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseKernelInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseKernelInfo$VH() {
        return constants$102.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseKernelInfo)(OrtKernelInfo*);
     * }
     */
    public static MemorySegment ReleaseKernelInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$102.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseKernelInfo)(OrtKernelInfo*);
     * }
     */
    public static void ReleaseKernelInfo$set(MemorySegment seg, MemorySegment x) {
        constants$102.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseKernelInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$102.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseKernelInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$102.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseKernelInfo ReleaseKernelInfo(MemorySegment segment, Arena scope) {
        return ReleaseKernelInfo.ofAddress(ReleaseKernelInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
     * }
     */
    public interface GetTrainingApi {

        java.lang.foreign.MemorySegment apply(int _x0);

        static MemorySegment allocate(GetTrainingApi fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$102.const$1, fi, constants$12.const$4, scope);
        }

        static GetTrainingApi ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (int __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$13.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTrainingApi$VH() {
        return constants$102.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
     * }
     */
    public static MemorySegment GetTrainingApi$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$102.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * const OrtTrainingApi* (*GetTrainingApi)(uint32_t);
     * }
     */
    public static void GetTrainingApi$set(MemorySegment seg, MemorySegment x) {
        constants$102.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetTrainingApi$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$102.const$2.get(seg, index * sizeof());
    }

    public static void GetTrainingApi$set(MemorySegment seg, long index, MemorySegment x) {
        constants$102.const$2.set(seg, index * sizeof(), x);
    }

    public static GetTrainingApi GetTrainingApi(MemorySegment segment, Arena scope) {
        return GetTrainingApi.ofAddress(GetTrainingApi$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_CANN {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_CANN fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$102.const$3, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_CANN ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_CANN$VH() {
        return constants$102.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$102.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_CANN)(OrtSessionOptions*,const OrtCANNProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, MemorySegment x) {
        constants$102.const$4.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_CANN$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$102.const$4.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_CANN$set(MemorySegment seg, long index, MemorySegment x) {
        constants$102.const$4.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_CANN SessionOptionsAppendExecutionProvider_CANN(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_CANN.ofAddress(
                SessionOptionsAppendExecutionProvider_CANN$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
     * }
     */
    public interface CreateCANNProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateCANNProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$102.const$5, fi, constants$1.const$4, scope);
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
        return constants$103.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
     * }
     */
    public static MemorySegment CreateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$103.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateCANNProviderOptions)(OrtCANNProviderOptions**);
     * }
     */
    public static void CreateCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$103.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CreateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$103.const$0.get(seg, index * sizeof());
    }

    public static void CreateCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$103.const$0.set(seg, index * sizeof(), x);
    }

    public static CreateCANNProviderOptions CreateCANNProviderOptions(MemorySegment segment, Arena scope) {
        return CreateCANNProviderOptions.ofAddress(CreateCANNProviderOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(UpdateCANNProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$103.const$1, fi, constants$83.const$3, scope);
        }

        static UpdateCANNProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateCANNProviderOptions$VH() {
        return constants$103.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCANNProviderOptions)(OrtCANNProviderOptions*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$103.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCANNProviderOptions)(OrtCANNProviderOptions*,char**,char**,size_t);
     * }
     */
    public static void UpdateCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$103.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UpdateCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$103.const$2.get(seg, index * sizeof());
    }

    public static void UpdateCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$103.const$2.set(seg, index * sizeof(), x);
    }

    public static UpdateCANNProviderOptions UpdateCANNProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateCANNProviderOptions.ofAddress(UpdateCANNProviderOptions$get(segment), scope);
    }
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

        static MemorySegment allocate(GetCANNProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$103.const$3, fi, constants$15.const$0, scope);
        }

        static GetCANNProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCANNProviderOptionsAsString$VH() {
        return constants$103.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCANNProviderOptionsAsString)(const OrtCANNProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetCANNProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$103.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCANNProviderOptionsAsString)(const OrtCANNProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$103.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetCANNProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$103.const$4.get(seg, index * sizeof());
    }

    public static void GetCANNProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$103.const$4.set(seg, index * sizeof(), x);
    }

    public static GetCANNProviderOptionsAsString GetCANNProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetCANNProviderOptionsAsString.ofAddress(GetCANNProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
     * }
     */
    public interface ReleaseCANNProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseCANNProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$103.const$5, fi, constants$14.const$1, scope);
        }

        static ReleaseCANNProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseCANNProviderOptions$VH() {
        return constants$104.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseCANNProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$104.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseCANNProviderOptions)(OrtCANNProviderOptions*);
     * }
     */
    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$104.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseCANNProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$104.const$0.get(seg, index * sizeof());
    }

    public static void ReleaseCANNProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$104.const$0.set(seg, index * sizeof(), x);
    }

    public static ReleaseCANNProviderOptions ReleaseCANNProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseCANNProviderOptions.ofAddress(ReleaseCANNProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
     * }
     */
    public interface MemoryInfoGetDeviceType {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(MemoryInfoGetDeviceType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$104.const$1, fi, constants$1.const$0, scope);
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
        return constants$104.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
     * }
     */
    public static MemorySegment MemoryInfoGetDeviceType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$104.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*MemoryInfoGetDeviceType)(const OrtMemoryInfo*,OrtMemoryInfoDeviceType*);
     * }
     */
    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, MemorySegment x) {
        constants$104.const$2.set(seg, 0L, x);
    }

    public static MemorySegment MemoryInfoGetDeviceType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$104.const$2.get(seg, index * sizeof());
    }

    public static void MemoryInfoGetDeviceType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$104.const$2.set(seg, index * sizeof(), x);
    }

    public static MemoryInfoGetDeviceType MemoryInfoGetDeviceType(MemorySegment segment, Arena scope) {
        return MemoryInfoGetDeviceType.ofAddress(MemoryInfoGetDeviceType$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
     * }
     */
    public interface UpdateEnvWithCustomLogLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, int _x1);

        static MemorySegment allocate(UpdateEnvWithCustomLogLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$104.const$3, fi, constants$23.const$3, scope);
        }

        static UpdateEnvWithCustomLogLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$23.const$5.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateEnvWithCustomLogLevel$VH() {
        return constants$104.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
     * }
     */
    public static MemorySegment UpdateEnvWithCustomLogLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$104.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateEnvWithCustomLogLevel)(OrtEnv*,OrtLoggingLevel);
     * }
     */
    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, MemorySegment x) {
        constants$104.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UpdateEnvWithCustomLogLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$104.const$4.get(seg, index * sizeof());
    }

    public static void UpdateEnvWithCustomLogLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$104.const$4.set(seg, index * sizeof(), x);
    }

    public static UpdateEnvWithCustomLogLevel UpdateEnvWithCustomLogLevel(MemorySegment segment, Arena scope) {
        return UpdateEnvWithCustomLogLevel.ofAddress(UpdateEnvWithCustomLogLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
     * }
     */
    public interface SetGlobalIntraOpThreadAffinity {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SetGlobalIntraOpThreadAffinity fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$104.const$5, fi, constants$15.const$4, scope);
        }

        static SetGlobalIntraOpThreadAffinity ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetGlobalIntraOpThreadAffinity$VH() {
        return constants$105.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
     * }
     */
    public static MemorySegment SetGlobalIntraOpThreadAffinity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$105.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetGlobalIntraOpThreadAffinity)(OrtThreadingOptions*,char*);
     * }
     */
    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, MemorySegment x) {
        constants$105.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetGlobalIntraOpThreadAffinity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$105.const$0.get(seg, index * sizeof());
    }

    public static void SetGlobalIntraOpThreadAffinity$set(MemorySegment seg, long index, MemorySegment x) {
        constants$105.const$0.set(seg, index * sizeof(), x);
    }

    public static SetGlobalIntraOpThreadAffinity SetGlobalIntraOpThreadAffinity(MemorySegment segment, Arena scope) {
        return SetGlobalIntraOpThreadAffinity.ofAddress(SetGlobalIntraOpThreadAffinity$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
     * }
     */
    public interface RegisterCustomOpsLibrary_V2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RegisterCustomOpsLibrary_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$105.const$1, fi, constants$15.const$4, scope);
        }

        static RegisterCustomOpsLibrary_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterCustomOpsLibrary_V2$VH() {
        return constants$105.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment RegisterCustomOpsLibrary_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$105.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsLibrary_V2)(OrtSessionOptions*,char*);
     * }
     */
    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, MemorySegment x) {
        constants$105.const$2.set(seg, 0L, x);
    }

    public static MemorySegment RegisterCustomOpsLibrary_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$105.const$2.get(seg, index * sizeof());
    }

    public static void RegisterCustomOpsLibrary_V2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$105.const$2.set(seg, index * sizeof(), x);
    }

    public static RegisterCustomOpsLibrary_V2 RegisterCustomOpsLibrary_V2(MemorySegment segment, Arena scope) {
        return RegisterCustomOpsLibrary_V2.ofAddress(RegisterCustomOpsLibrary_V2$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
     * }
     */
    public interface RegisterCustomOpsUsingFunction {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(RegisterCustomOpsUsingFunction fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$105.const$3, fi, constants$15.const$4, scope);
        }

        static RegisterCustomOpsUsingFunction ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RegisterCustomOpsUsingFunction$VH() {
        return constants$105.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
     * }
     */
    public static MemorySegment RegisterCustomOpsUsingFunction$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$105.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RegisterCustomOpsUsingFunction)(OrtSessionOptions*,char*);
     * }
     */
    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, MemorySegment x) {
        constants$105.const$4.set(seg, 0L, x);
    }

    public static MemorySegment RegisterCustomOpsUsingFunction$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$105.const$4.get(seg, index * sizeof());
    }

    public static void RegisterCustomOpsUsingFunction$set(MemorySegment seg, long index, MemorySegment x) {
        constants$105.const$4.set(seg, index * sizeof(), x);
    }

    public static RegisterCustomOpsUsingFunction RegisterCustomOpsUsingFunction(MemorySegment segment, Arena scope) {
        return RegisterCustomOpsUsingFunction.ofAddress(RegisterCustomOpsUsingFunction$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public interface KernelInfo_GetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelInfo_GetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$105.const$5, fi, constants$15.const$4, scope);
        }

        static KernelInfo_GetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetInputCount$VH() {
        return constants$106.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$106.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static void KernelInfo_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$106.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$106.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$106.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetInputCount KernelInfo_GetInputCount(MemorySegment segment, Arena scope) {
        return KernelInfo_GetInputCount.ofAddress(KernelInfo_GetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public interface KernelInfo_GetOutputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelInfo_GetOutputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$106.const$1, fi, constants$15.const$4, scope);
        }

        static KernelInfo_GetOutputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetOutputCount$VH() {
        return constants$106.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$106.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputCount)(const OrtKernelInfo*,size_t*);
     * }
     */
    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, MemorySegment x) {
        constants$106.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetOutputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$106.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetOutputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$106.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetOutputCount KernelInfo_GetOutputCount(MemorySegment segment, Arena scope) {
        return KernelInfo_GetOutputCount.ofAddress(KernelInfo_GetOutputCount$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfo_GetInputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$106.const$3, fi, constants$31.const$5, scope);
        }

        static KernelInfo_GetInputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$32.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetInputName$VH() {
        return constants$106.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetInputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$106.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static void KernelInfo_GetInputName$set(MemorySegment seg, MemorySegment x) {
        constants$106.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetInputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$106.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetInputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$106.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetInputName KernelInfo_GetInputName(MemorySegment segment, Arena scope) {
        return KernelInfo_GetInputName.ofAddress(KernelInfo_GetInputName$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfo_GetOutputName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$106.const$5, fi, constants$31.const$5, scope);
        }

        static KernelInfo_GetOutputName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$32.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetOutputName$VH() {
        return constants$107.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$107.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputName)(const OrtKernelInfo*,size_t,char*,size_t*);
     * }
     */
    public static void KernelInfo_GetOutputName$set(MemorySegment seg, MemorySegment x) {
        constants$107.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetOutputName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$107.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetOutputName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$107.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetOutputName KernelInfo_GetOutputName(MemorySegment segment, Arena scope) {
        return KernelInfo_GetOutputName.ofAddress(KernelInfo_GetOutputName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public interface KernelInfo_GetInputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetInputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$107.const$1, fi, constants$30.const$3, scope);
        }

        static KernelInfo_GetInputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetInputTypeInfo$VH() {
        return constants$107.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment KernelInfo_GetInputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$107.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetInputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$107.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetInputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$107.const$2.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetInputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$107.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetInputTypeInfo KernelInfo_GetInputTypeInfo(MemorySegment segment, Arena scope) {
        return KernelInfo_GetInputTypeInfo.ofAddress(KernelInfo_GetInputTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public interface KernelInfo_GetOutputTypeInfo {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetOutputTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$107.const$3, fi, constants$30.const$3, scope);
        }

        static KernelInfo_GetOutputTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetOutputTypeInfo$VH() {
        return constants$107.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static MemorySegment KernelInfo_GetOutputTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$107.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetOutputTypeInfo)(const OrtKernelInfo*,size_t,OrtTypeInfo**);
     * }
     */
    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$107.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$107.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetOutputTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$107.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetOutputTypeInfo KernelInfo_GetOutputTypeInfo(MemorySegment segment, Arena scope) {
        return KernelInfo_GetOutputTypeInfo.ofAddress(KernelInfo_GetOutputTypeInfo$get(segment), scope);
    }
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

        static MemorySegment allocate(KernelInfoGetAttribute_tensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$107.const$5, fi, constants$20.const$3, scope);
        }

        static KernelInfoGetAttribute_tensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetAttribute_tensor$VH() {
        return constants$108.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_tensor)(const OrtKernelInfo*,char*,OrtAllocator*,OrtValue**);
     * }
     */
    public static MemorySegment KernelInfoGetAttribute_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$108.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetAttribute_tensor)(const OrtKernelInfo*,char*,OrtAllocator*,OrtValue**);
     * }
     */
    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, MemorySegment x) {
        constants$108.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetAttribute_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$108.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfoGetAttribute_tensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$108.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetAttribute_tensor KernelInfoGetAttribute_tensor(MemorySegment segment, Arena scope) {
        return KernelInfoGetAttribute_tensor.ofAddress(KernelInfoGetAttribute_tensor$get(segment), scope);
    }
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

        static MemorySegment allocate(HasSessionConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$108.const$1, fi, constants$15.const$0, scope);
        }

        static HasSessionConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle HasSessionConfigEntry$VH() {
        return constants$108.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*HasSessionConfigEntry)(const OrtSessionOptions*,char*,int*);
     * }
     */
    public static MemorySegment HasSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$108.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*HasSessionConfigEntry)(const OrtSessionOptions*,char*,int*);
     * }
     */
    public static void HasSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$108.const$2.set(seg, 0L, x);
    }

    public static MemorySegment HasSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$108.const$2.get(seg, index * sizeof());
    }

    public static void HasSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$108.const$2.set(seg, index * sizeof(), x);
    }

    public static HasSessionConfigEntry HasSessionConfigEntry(MemorySegment segment, Arena scope) {
        return HasSessionConfigEntry.ofAddress(HasSessionConfigEntry$get(segment), scope);
    }
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

        static MemorySegment allocate(GetSessionConfigEntry fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$108.const$3, fi, constants$20.const$3, scope);
        }

        static GetSessionConfigEntry ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetSessionConfigEntry$VH() {
        return constants$108.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSessionConfigEntry)(const OrtSessionOptions*,char*,char*,size_t*);
     * }
     */
    public static MemorySegment GetSessionConfigEntry$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$108.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetSessionConfigEntry)(const OrtSessionOptions*,char*,char*,size_t*);
     * }
     */
    public static void GetSessionConfigEntry$set(MemorySegment seg, MemorySegment x) {
        constants$108.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetSessionConfigEntry$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$108.const$4.get(seg, index * sizeof());
    }

    public static void GetSessionConfigEntry$set(MemorySegment seg, long index, MemorySegment x) {
        constants$108.const$4.set(seg, index * sizeof(), x);
    }

    public static GetSessionConfigEntry GetSessionConfigEntry(MemorySegment segment, Arena scope) {
        return GetSessionConfigEntry.ofAddress(GetSessionConfigEntry$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_Dnnl)(OrtSessionOptions*,const OrtDnnlProviderOptions*);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_Dnnl {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_Dnnl fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$108.const$5, fi, constants$15.const$4, scope);
        }

        static SessionOptionsAppendExecutionProvider_Dnnl ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_Dnnl$VH() {
        return constants$109.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_Dnnl)(OrtSessionOptions*,const OrtDnnlProviderOptions*);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_Dnnl$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$109.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_Dnnl)(OrtSessionOptions*,const OrtDnnlProviderOptions*);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_Dnnl$set(MemorySegment seg, MemorySegment x) {
        constants$109.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_Dnnl$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$109.const$0.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_Dnnl$set(MemorySegment seg, long index, MemorySegment x) {
        constants$109.const$0.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_Dnnl SessionOptionsAppendExecutionProvider_Dnnl(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_Dnnl.ofAddress(
                SessionOptionsAppendExecutionProvider_Dnnl$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateDnnlProviderOptions)(OrtDnnlProviderOptions**);
     * }
     */
    public interface CreateDnnlProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateDnnlProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$109.const$1, fi, constants$1.const$4, scope);
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
        return constants$109.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateDnnlProviderOptions)(OrtDnnlProviderOptions**);
     * }
     */
    public static MemorySegment CreateDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$109.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateDnnlProviderOptions)(OrtDnnlProviderOptions**);
     * }
     */
    public static void CreateDnnlProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$109.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$109.const$2.get(seg, index * sizeof());
    }

    public static void CreateDnnlProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$109.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateDnnlProviderOptions CreateDnnlProviderOptions(MemorySegment segment, Arena scope) {
        return CreateDnnlProviderOptions.ofAddress(CreateDnnlProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateDnnlProviderOptions)(OrtDnnlProviderOptions*,char**,char**,size_t);
     * }
     */
    public interface UpdateDnnlProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateDnnlProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$109.const$3, fi, constants$83.const$3, scope);
        }

        static UpdateDnnlProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateDnnlProviderOptions$VH() {
        return constants$109.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateDnnlProviderOptions)(OrtDnnlProviderOptions*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$109.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateDnnlProviderOptions)(OrtDnnlProviderOptions*,char**,char**,size_t);
     * }
     */
    public static void UpdateDnnlProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$109.const$4.set(seg, 0L, x);
    }

    public static MemorySegment UpdateDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$109.const$4.get(seg, index * sizeof());
    }

    public static void UpdateDnnlProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$109.const$4.set(seg, index * sizeof(), x);
    }

    public static UpdateDnnlProviderOptions UpdateDnnlProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateDnnlProviderOptions.ofAddress(UpdateDnnlProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetDnnlProviderOptionsAsString)(const OrtDnnlProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public interface GetDnnlProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetDnnlProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$109.const$5, fi, constants$15.const$0, scope);
        }

        static GetDnnlProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetDnnlProviderOptionsAsString$VH() {
        return constants$110.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDnnlProviderOptionsAsString)(const OrtDnnlProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetDnnlProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$110.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetDnnlProviderOptionsAsString)(const OrtDnnlProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static void GetDnnlProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$110.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetDnnlProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$110.const$0.get(seg, index * sizeof());
    }

    public static void GetDnnlProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$110.const$0.set(seg, index * sizeof(), x);
    }

    public static GetDnnlProviderOptionsAsString GetDnnlProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetDnnlProviderOptionsAsString.ofAddress(GetDnnlProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseDnnlProviderOptions)(OrtDnnlProviderOptions*);
     * }
     */
    public interface ReleaseDnnlProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseDnnlProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$110.const$1, fi, constants$14.const$1, scope);
        }

        static ReleaseDnnlProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseDnnlProviderOptions$VH() {
        return constants$110.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseDnnlProviderOptions)(OrtDnnlProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseDnnlProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$110.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseDnnlProviderOptions)(OrtDnnlProviderOptions*);
     * }
     */
    public static void ReleaseDnnlProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$110.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseDnnlProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$110.const$2.get(seg, index * sizeof());
    }

    public static void ReleaseDnnlProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$110.const$2.set(seg, index * sizeof(), x);
    }

    public static ReleaseDnnlProviderOptions ReleaseDnnlProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseDnnlProviderOptions.ofAddress(ReleaseDnnlProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetNodeName)(const OrtKernelInfo*,char*,size_t*);
     * }
     */
    public interface KernelInfo_GetNodeName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelInfo_GetNodeName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$110.const$3, fi, constants$15.const$0, scope);
        }

        static KernelInfo_GetNodeName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetNodeName$VH() {
        return constants$110.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetNodeName)(const OrtKernelInfo*,char*,size_t*);
     * }
     */
    public static MemorySegment KernelInfo_GetNodeName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$110.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetNodeName)(const OrtKernelInfo*,char*,size_t*);
     * }
     */
    public static void KernelInfo_GetNodeName$set(MemorySegment seg, MemorySegment x) {
        constants$110.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetNodeName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$110.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetNodeName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$110.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetNodeName KernelInfo_GetNodeName(MemorySegment segment, Arena scope) {
        return KernelInfo_GetNodeName.ofAddress(KernelInfo_GetNodeName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetLogger)(const OrtKernelInfo*,const OrtLogger**);
     * }
     */
    public interface KernelInfo_GetLogger {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelInfo_GetLogger fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$110.const$5, fi, constants$15.const$4, scope);
        }

        static KernelInfo_GetLogger ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfo_GetLogger$VH() {
        return constants$111.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetLogger)(const OrtKernelInfo*,const OrtLogger**);
     * }
     */
    public static MemorySegment KernelInfo_GetLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$111.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfo_GetLogger)(const OrtKernelInfo*,const OrtLogger**);
     * }
     */
    public static void KernelInfo_GetLogger$set(MemorySegment seg, MemorySegment x) {
        constants$111.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfo_GetLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$111.const$0.get(seg, index * sizeof());
    }

    public static void KernelInfo_GetLogger$set(MemorySegment seg, long index, MemorySegment x) {
        constants$111.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelInfo_GetLogger KernelInfo_GetLogger(MemorySegment segment, Arena scope) {
        return KernelInfo_GetLogger.ofAddress(KernelInfo_GetLogger$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetLogger)(const OrtKernelContext*,const OrtLogger**);
     * }
     */
    public interface KernelContext_GetLogger {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelContext_GetLogger fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$111.const$1, fi, constants$15.const$4, scope);
        }

        static KernelContext_GetLogger ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetLogger$VH() {
        return constants$111.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetLogger)(const OrtKernelContext*,const OrtLogger**);
     * }
     */
    public static MemorySegment KernelContext_GetLogger$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$111.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetLogger)(const OrtKernelContext*,const OrtLogger**);
     * }
     */
    public static void KernelContext_GetLogger$set(MemorySegment seg, MemorySegment x) {
        constants$111.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetLogger$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$111.const$2.get(seg, index * sizeof());
    }

    public static void KernelContext_GetLogger$set(MemorySegment seg, long index, MemorySegment x) {
        constants$111.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetLogger KernelContext_GetLogger(MemorySegment segment, Arena scope) {
        return KernelContext_GetLogger.ofAddress(KernelContext_GetLogger$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*Logger_LogMessage)(const OrtLogger*,OrtLoggingLevel,char*,char*,int,char*);
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
            return RuntimeHelper.upcallStub(constants$111.const$4, fi, constants$111.const$3, scope);
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
                            constants$111.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Logger_LogMessage$VH() {
        return constants$112.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*Logger_LogMessage)(const OrtLogger*,OrtLoggingLevel,char*,char*,int,char*);
     * }
     */
    public static MemorySegment Logger_LogMessage$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$112.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*Logger_LogMessage)(const OrtLogger*,OrtLoggingLevel,char*,char*,int,char*);
     * }
     */
    public static void Logger_LogMessage$set(MemorySegment seg, MemorySegment x) {
        constants$112.const$0.set(seg, 0L, x);
    }

    public static MemorySegment Logger_LogMessage$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$112.const$0.get(seg, index * sizeof());
    }

    public static void Logger_LogMessage$set(MemorySegment seg, long index, MemorySegment x) {
        constants$112.const$0.set(seg, index * sizeof(), x);
    }

    public static Logger_LogMessage Logger_LogMessage(MemorySegment segment, Arena scope) {
        return Logger_LogMessage.ofAddress(Logger_LogMessage$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*Logger_GetLoggingSeverityLevel)(const OrtLogger*,OrtLoggingLevel*);
     * }
     */
    public interface Logger_GetLoggingSeverityLevel {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(Logger_GetLoggingSeverityLevel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$112.const$1, fi, constants$15.const$4, scope);
        }

        static Logger_GetLoggingSeverityLevel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle Logger_GetLoggingSeverityLevel$VH() {
        return constants$112.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*Logger_GetLoggingSeverityLevel)(const OrtLogger*,OrtLoggingLevel*);
     * }
     */
    public static MemorySegment Logger_GetLoggingSeverityLevel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$112.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*Logger_GetLoggingSeverityLevel)(const OrtLogger*,OrtLoggingLevel*);
     * }
     */
    public static void Logger_GetLoggingSeverityLevel$set(MemorySegment seg, MemorySegment x) {
        constants$112.const$2.set(seg, 0L, x);
    }

    public static MemorySegment Logger_GetLoggingSeverityLevel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$112.const$2.get(seg, index * sizeof());
    }

    public static void Logger_GetLoggingSeverityLevel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$112.const$2.set(seg, index * sizeof(), x);
    }

    public static Logger_GetLoggingSeverityLevel Logger_GetLoggingSeverityLevel(MemorySegment segment, Arena scope) {
        return Logger_GetLoggingSeverityLevel.ofAddress(Logger_GetLoggingSeverityLevel$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetConstantInput_tensor)(const OrtKernelInfo*,size_t,int*,const OrtValue**);
     * }
     */
    public interface KernelInfoGetConstantInput_tensor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                long _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelInfoGetConstantInput_tensor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$112.const$3, fi, constants$31.const$5, scope);
        }

        static KernelInfoGetConstantInput_tensor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$32.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelInfoGetConstantInput_tensor$VH() {
        return constants$112.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetConstantInput_tensor)(const OrtKernelInfo*,size_t,int*,const OrtValue**);
     * }
     */
    public static MemorySegment KernelInfoGetConstantInput_tensor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$112.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelInfoGetConstantInput_tensor)(const OrtKernelInfo*,size_t,int*,const OrtValue**);
     * }
     */
    public static void KernelInfoGetConstantInput_tensor$set(MemorySegment seg, MemorySegment x) {
        constants$112.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelInfoGetConstantInput_tensor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$112.const$4.get(seg, index * sizeof());
    }

    public static void KernelInfoGetConstantInput_tensor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$112.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelInfoGetConstantInput_tensor KernelInfoGetConstantInput_tensor(
            MemorySegment segment, Arena scope) {
        return KernelInfoGetConstantInput_tensor.ofAddress(KernelInfoGetConstantInput_tensor$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToOptionalTypeInfo)(const OrtTypeInfo*,const OrtOptionalTypeInfo**);
     * }
     */
    public interface CastTypeInfoToOptionalTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(CastTypeInfoToOptionalTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$112.const$5, fi, constants$15.const$4, scope);
        }

        static CastTypeInfoToOptionalTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CastTypeInfoToOptionalTypeInfo$VH() {
        return constants$113.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToOptionalTypeInfo)(const OrtTypeInfo*,const OrtOptionalTypeInfo**);
     * }
     */
    public static MemorySegment CastTypeInfoToOptionalTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$113.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CastTypeInfoToOptionalTypeInfo)(const OrtTypeInfo*,const OrtOptionalTypeInfo**);
     * }
     */
    public static void CastTypeInfoToOptionalTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$113.const$0.set(seg, 0L, x);
    }

    public static MemorySegment CastTypeInfoToOptionalTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$113.const$0.get(seg, index * sizeof());
    }

    public static void CastTypeInfoToOptionalTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$113.const$0.set(seg, index * sizeof(), x);
    }

    public static CastTypeInfoToOptionalTypeInfo CastTypeInfoToOptionalTypeInfo(MemorySegment segment, Arena scope) {
        return CastTypeInfoToOptionalTypeInfo.ofAddress(CastTypeInfoToOptionalTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetOptionalContainedTypeInfo)(const OrtOptionalTypeInfo*,OrtTypeInfo**);
     * }
     */
    public interface GetOptionalContainedTypeInfo {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(GetOptionalContainedTypeInfo fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$113.const$1, fi, constants$15.const$4, scope);
        }

        static GetOptionalContainedTypeInfo ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOptionalContainedTypeInfo$VH() {
        return constants$113.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOptionalContainedTypeInfo)(const OrtOptionalTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static MemorySegment GetOptionalContainedTypeInfo$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$113.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetOptionalContainedTypeInfo)(const OrtOptionalTypeInfo*,OrtTypeInfo**);
     * }
     */
    public static void GetOptionalContainedTypeInfo$set(MemorySegment seg, MemorySegment x) {
        constants$113.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetOptionalContainedTypeInfo$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$113.const$2.get(seg, index * sizeof());
    }

    public static void GetOptionalContainedTypeInfo$set(MemorySegment seg, long index, MemorySegment x) {
        constants$113.const$2.set(seg, index * sizeof(), x);
    }

    public static GetOptionalContainedTypeInfo GetOptionalContainedTypeInfo(MemorySegment segment, Arena scope) {
        return GetOptionalContainedTypeInfo.ofAddress(GetOptionalContainedTypeInfo$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetResizedStringTensorElementBuffer)(OrtValue*,size_t,size_t,char**);
     * }
     */
    public interface GetResizedStringTensorElementBuffer {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, long _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(GetResizedStringTensorElementBuffer fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$113.const$3, fi, constants$66.const$5, scope);
        }

        static GetResizedStringTensorElementBuffer ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    long __x1,
                    long __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$67.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetResizedStringTensorElementBuffer$VH() {
        return constants$113.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetResizedStringTensorElementBuffer)(OrtValue*,size_t,size_t,char**);
     * }
     */
    public static MemorySegment GetResizedStringTensorElementBuffer$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$113.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetResizedStringTensorElementBuffer)(OrtValue*,size_t,size_t,char**);
     * }
     */
    public static void GetResizedStringTensorElementBuffer$set(MemorySegment seg, MemorySegment x) {
        constants$113.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetResizedStringTensorElementBuffer$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$113.const$4.get(seg, index * sizeof());
    }

    public static void GetResizedStringTensorElementBuffer$set(MemorySegment seg, long index, MemorySegment x) {
        constants$113.const$4.set(seg, index * sizeof(), x);
    }

    public static GetResizedStringTensorElementBuffer GetResizedStringTensorElementBuffer(
            MemorySegment segment, Arena scope) {
        return GetResizedStringTensorElementBuffer.ofAddress(GetResizedStringTensorElementBuffer$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetAllocator)(const OrtKernelContext*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public interface KernelContext_GetAllocator {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(KernelContext_GetAllocator fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$113.const$5, fi, constants$15.const$0, scope);
        }

        static KernelContext_GetAllocator ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetAllocator$VH() {
        return constants$114.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetAllocator)(const OrtKernelContext*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public static MemorySegment KernelContext_GetAllocator$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$114.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetAllocator)(const OrtKernelContext*,const OrtMemoryInfo*,OrtAllocator**);
     * }
     */
    public static void KernelContext_GetAllocator$set(MemorySegment seg, MemorySegment x) {
        constants$114.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetAllocator$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$114.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_GetAllocator$set(MemorySegment seg, long index, MemorySegment x) {
        constants$114.const$0.set(seg, index * sizeof(), x);
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
            return RuntimeHelper.upcallStub(constants$114.const$1, fi, constants$13.const$2, scope);
        }

        static GetBuildInfoString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return () -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$13.const$4.invokeExact(symbol);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetBuildInfoString$VH() {
        return constants$114.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetBuildInfoString)();
     * }
     */
    public static MemorySegment GetBuildInfoString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$114.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetBuildInfoString)();
     * }
     */
    public static void GetBuildInfoString$set(MemorySegment seg, MemorySegment x) {
        constants$114.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetBuildInfoString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$114.const$2.get(seg, index * sizeof());
    }

    public static void GetBuildInfoString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$114.const$2.set(seg, index * sizeof(), x);
    }

    public static GetBuildInfoString GetBuildInfoString(MemorySegment segment, Arena scope) {
        return GetBuildInfoString.ofAddress(GetBuildInfoString$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateROCMProviderOptions)(OrtROCMProviderOptions**);
     * }
     */
    public interface CreateROCMProviderOptions {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(CreateROCMProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$114.const$3, fi, constants$1.const$4, scope);
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
        return constants$114.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateROCMProviderOptions)(OrtROCMProviderOptions**);
     * }
     */
    public static MemorySegment CreateROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$114.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateROCMProviderOptions)(OrtROCMProviderOptions**);
     * }
     */
    public static void CreateROCMProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$114.const$4.set(seg, 0L, x);
    }

    public static MemorySegment CreateROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$114.const$4.get(seg, index * sizeof());
    }

    public static void CreateROCMProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$114.const$4.set(seg, index * sizeof(), x);
    }

    public static CreateROCMProviderOptions CreateROCMProviderOptions(MemorySegment segment, Arena scope) {
        return CreateROCMProviderOptions.ofAddress(CreateROCMProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateROCMProviderOptions)(OrtROCMProviderOptions*,char**,char**,size_t);
     * }
     */
    public interface UpdateROCMProviderOptions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(UpdateROCMProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$114.const$5, fi, constants$83.const$3, scope);
        }

        static UpdateROCMProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateROCMProviderOptions$VH() {
        return constants$115.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateROCMProviderOptions)(OrtROCMProviderOptions*,char**,char**,size_t);
     * }
     */
    public static MemorySegment UpdateROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$115.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateROCMProviderOptions)(OrtROCMProviderOptions*,char**,char**,size_t);
     * }
     */
    public static void UpdateROCMProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$115.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UpdateROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$115.const$0.get(seg, index * sizeof());
    }

    public static void UpdateROCMProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$115.const$0.set(seg, index * sizeof(), x);
    }

    public static UpdateROCMProviderOptions UpdateROCMProviderOptions(MemorySegment segment, Arena scope) {
        return UpdateROCMProviderOptions.ofAddress(UpdateROCMProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetROCMProviderOptionsAsString)(const OrtROCMProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public interface GetROCMProviderOptionsAsString {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetROCMProviderOptionsAsString fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$115.const$1, fi, constants$15.const$0, scope);
        }

        static GetROCMProviderOptionsAsString ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetROCMProviderOptionsAsString$VH() {
        return constants$115.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetROCMProviderOptionsAsString)(const OrtROCMProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static MemorySegment GetROCMProviderOptionsAsString$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$115.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetROCMProviderOptionsAsString)(const OrtROCMProviderOptions*,OrtAllocator*,char**);
     * }
     */
    public static void GetROCMProviderOptionsAsString$set(MemorySegment seg, MemorySegment x) {
        constants$115.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetROCMProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$115.const$2.get(seg, index * sizeof());
    }

    public static void GetROCMProviderOptionsAsString$set(MemorySegment seg, long index, MemorySegment x) {
        constants$115.const$2.set(seg, index * sizeof(), x);
    }

    public static GetROCMProviderOptionsAsString GetROCMProviderOptionsAsString(MemorySegment segment, Arena scope) {
        return GetROCMProviderOptionsAsString.ofAddress(GetROCMProviderOptionsAsString$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*ReleaseROCMProviderOptions)(OrtROCMProviderOptions*);
     * }
     */
    public interface ReleaseROCMProviderOptions {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(ReleaseROCMProviderOptions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$115.const$3, fi, constants$14.const$1, scope);
        }

        static ReleaseROCMProviderOptions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$3.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReleaseROCMProviderOptions$VH() {
        return constants$115.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*ReleaseROCMProviderOptions)(OrtROCMProviderOptions*);
     * }
     */
    public static MemorySegment ReleaseROCMProviderOptions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$115.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*ReleaseROCMProviderOptions)(OrtROCMProviderOptions*);
     * }
     */
    public static void ReleaseROCMProviderOptions$set(MemorySegment seg, MemorySegment x) {
        constants$115.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReleaseROCMProviderOptions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$115.const$4.get(seg, index * sizeof());
    }

    public static void ReleaseROCMProviderOptions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$115.const$4.set(seg, index * sizeof(), x);
    }

    public static ReleaseROCMProviderOptions ReleaseROCMProviderOptions(MemorySegment segment, Arena scope) {
        return ReleaseROCMProviderOptions.ofAddress(ReleaseROCMProviderOptions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocatorV2)(OrtEnv*,char*,const OrtMemoryInfo*,const OrtArenaCfg*,char**,char**,size_t);
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
            return RuntimeHelper.upcallStub(constants$116.const$0, fi, constants$115.const$5, scope);
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
                            constants$116.const$1.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateAndRegisterAllocatorV2$VH() {
        return constants$116.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocatorV2)(OrtEnv*,char*,const OrtMemoryInfo*,const OrtArenaCfg*,char**,char**,size_t);
     * }
     */
    public static MemorySegment CreateAndRegisterAllocatorV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$116.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateAndRegisterAllocatorV2)(OrtEnv*,char*,const OrtMemoryInfo*,const OrtArenaCfg*,char**,char**,size_t);
     * }
     */
    public static void CreateAndRegisterAllocatorV2$set(MemorySegment seg, MemorySegment x) {
        constants$116.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateAndRegisterAllocatorV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$116.const$2.get(seg, index * sizeof());
    }

    public static void CreateAndRegisterAllocatorV2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$116.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateAndRegisterAllocatorV2 CreateAndRegisterAllocatorV2(MemorySegment segment, Arena scope) {
        return CreateAndRegisterAllocatorV2.ofAddress(CreateAndRegisterAllocatorV2$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*RunAsync)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**,RunAsyncCallbackFn,void*);
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
            return RuntimeHelper.upcallStub(constants$116.const$4, fi, constants$116.const$3, scope);
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
                    return (java.lang.foreign.MemorySegment) constants$116.const$5.invokeExact(
                            symbol, __x0, __x1, __x2, __x3, __x4, __x5, __x6, __x7, __x8, __x9);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle RunAsync$VH() {
        return constants$117.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*RunAsync)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**,RunAsyncCallbackFn,void*);
     * }
     */
    public static MemorySegment RunAsync$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$117.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*RunAsync)(OrtSession*,const OrtRunOptions*,char**,const OrtValue**,size_t,char**,size_t,OrtValue**,RunAsyncCallbackFn,void*);
     * }
     */
    public static void RunAsync$set(MemorySegment seg, MemorySegment x) {
        constants$117.const$0.set(seg, 0L, x);
    }

    public static MemorySegment RunAsync$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$117.const$0.get(seg, index * sizeof());
    }

    public static void RunAsync$set(MemorySegment seg, long index, MemorySegment x) {
        constants$117.const$0.set(seg, index * sizeof(), x);
    }

    public static RunAsync RunAsync(MemorySegment segment, Arena scope) {
        return RunAsync.ofAddress(RunAsync$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptionsWithValue)(OrtTensorRTProviderOptionsV2*,char*,void*);
     * }
     */
    public interface UpdateTensorRTProviderOptionsWithValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(UpdateTensorRTProviderOptionsWithValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$117.const$1, fi, constants$15.const$0, scope);
        }

        static UpdateTensorRTProviderOptionsWithValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateTensorRTProviderOptionsWithValue$VH() {
        return constants$117.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptionsWithValue)(OrtTensorRTProviderOptionsV2*,char*,void*);
     * }
     */
    public static MemorySegment UpdateTensorRTProviderOptionsWithValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$117.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateTensorRTProviderOptionsWithValue)(OrtTensorRTProviderOptionsV2*,char*,void*);
     * }
     */
    public static void UpdateTensorRTProviderOptionsWithValue$set(MemorySegment seg, MemorySegment x) {
        constants$117.const$2.set(seg, 0L, x);
    }

    public static MemorySegment UpdateTensorRTProviderOptionsWithValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$117.const$2.get(seg, index * sizeof());
    }

    public static void UpdateTensorRTProviderOptionsWithValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$117.const$2.set(seg, index * sizeof(), x);
    }

    public static UpdateTensorRTProviderOptionsWithValue UpdateTensorRTProviderOptionsWithValue(
            MemorySegment segment, Arena scope) {
        return UpdateTensorRTProviderOptionsWithValue.ofAddress(
                UpdateTensorRTProviderOptionsWithValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsByName)(const OrtTensorRTProviderOptionsV2*,char*,void**);
     * }
     */
    public interface GetTensorRTProviderOptionsByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetTensorRTProviderOptionsByName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$117.const$3, fi, constants$15.const$0, scope);
        }

        static GetTensorRTProviderOptionsByName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetTensorRTProviderOptionsByName$VH() {
        return constants$117.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsByName)(const OrtTensorRTProviderOptionsV2*,char*,void**);
     * }
     */
    public static MemorySegment GetTensorRTProviderOptionsByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$117.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetTensorRTProviderOptionsByName)(const OrtTensorRTProviderOptionsV2*,char*,void**);
     * }
     */
    public static void GetTensorRTProviderOptionsByName$set(MemorySegment seg, MemorySegment x) {
        constants$117.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetTensorRTProviderOptionsByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$117.const$4.get(seg, index * sizeof());
    }

    public static void GetTensorRTProviderOptionsByName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$117.const$4.set(seg, index * sizeof(), x);
    }

    public static GetTensorRTProviderOptionsByName GetTensorRTProviderOptionsByName(
            MemorySegment segment, Arena scope) {
        return GetTensorRTProviderOptionsByName.ofAddress(GetTensorRTProviderOptionsByName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptionsWithValue)(OrtCUDAProviderOptionsV2*,char*,void*);
     * }
     */
    public interface UpdateCUDAProviderOptionsWithValue {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(UpdateCUDAProviderOptionsWithValue fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$117.const$5, fi, constants$15.const$0, scope);
        }

        static UpdateCUDAProviderOptionsWithValue ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle UpdateCUDAProviderOptionsWithValue$VH() {
        return constants$118.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptionsWithValue)(OrtCUDAProviderOptionsV2*,char*,void*);
     * }
     */
    public static MemorySegment UpdateCUDAProviderOptionsWithValue$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$118.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*UpdateCUDAProviderOptionsWithValue)(OrtCUDAProviderOptionsV2*,char*,void*);
     * }
     */
    public static void UpdateCUDAProviderOptionsWithValue$set(MemorySegment seg, MemorySegment x) {
        constants$118.const$0.set(seg, 0L, x);
    }

    public static MemorySegment UpdateCUDAProviderOptionsWithValue$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$118.const$0.get(seg, index * sizeof());
    }

    public static void UpdateCUDAProviderOptionsWithValue$set(MemorySegment seg, long index, MemorySegment x) {
        constants$118.const$0.set(seg, index * sizeof(), x);
    }

    public static UpdateCUDAProviderOptionsWithValue UpdateCUDAProviderOptionsWithValue(
            MemorySegment segment, Arena scope) {
        return UpdateCUDAProviderOptionsWithValue.ofAddress(UpdateCUDAProviderOptionsWithValue$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsByName)(const OrtCUDAProviderOptionsV2*,char*,void**);
     * }
     */
    public interface GetCUDAProviderOptionsByName {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(GetCUDAProviderOptionsByName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$118.const$1, fi, constants$15.const$0, scope);
        }

        static GetCUDAProviderOptionsByName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetCUDAProviderOptionsByName$VH() {
        return constants$118.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsByName)(const OrtCUDAProviderOptionsV2*,char*,void**);
     * }
     */
    public static MemorySegment GetCUDAProviderOptionsByName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$118.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*GetCUDAProviderOptionsByName)(const OrtCUDAProviderOptionsV2*,char*,void**);
     * }
     */
    public static void GetCUDAProviderOptionsByName$set(MemorySegment seg, MemorySegment x) {
        constants$118.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetCUDAProviderOptionsByName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$118.const$2.get(seg, index * sizeof());
    }

    public static void GetCUDAProviderOptionsByName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$118.const$2.set(seg, index * sizeof(), x);
    }

    public static GetCUDAProviderOptionsByName GetCUDAProviderOptionsByName(MemorySegment segment, Arena scope) {
        return GetCUDAProviderOptionsByName.ofAddress(GetCUDAProviderOptionsByName$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetResource)(const OrtKernelContext*,int,int,void**);
     * }
     */
    public interface KernelContext_GetResource {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, int _x1, int _x2, java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(KernelContext_GetResource fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$118.const$4, fi, constants$118.const$3, scope);
        }

        static KernelContext_GetResource ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, int __x1, int __x2, java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$118.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_GetResource$VH() {
        return constants$119.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetResource)(const OrtKernelContext*,int,int,void**);
     * }
     */
    public static MemorySegment KernelContext_GetResource$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$119.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_GetResource)(const OrtKernelContext*,int,int,void**);
     * }
     */
    public static void KernelContext_GetResource$set(MemorySegment seg, MemorySegment x) {
        constants$119.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_GetResource$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$119.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_GetResource$set(MemorySegment seg, long index, MemorySegment x) {
        constants$119.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelContext_GetResource KernelContext_GetResource(MemorySegment segment, Arena scope) {
        return KernelContext_GetResource.ofAddress(KernelContext_GetResource$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetUserLoggingFunction)(OrtSessionOptions*,OrtLoggingFunction,void*);
     * }
     */
    public interface SetUserLoggingFunction {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(SetUserLoggingFunction fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$119.const$1, fi, constants$15.const$0, scope);
        }

        static SetUserLoggingFunction ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetUserLoggingFunction$VH() {
        return constants$119.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetUserLoggingFunction)(OrtSessionOptions*,OrtLoggingFunction,void*);
     * }
     */
    public static MemorySegment SetUserLoggingFunction$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$119.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetUserLoggingFunction)(OrtSessionOptions*,OrtLoggingFunction,void*);
     * }
     */
    public static void SetUserLoggingFunction$set(MemorySegment seg, MemorySegment x) {
        constants$119.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetUserLoggingFunction$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$119.const$2.get(seg, index * sizeof());
    }

    public static void SetUserLoggingFunction$set(MemorySegment seg, long index, MemorySegment x) {
        constants$119.const$2.set(seg, index * sizeof(), x);
    }

    public static SetUserLoggingFunction SetUserLoggingFunction(MemorySegment segment, Arena scope) {
        return SetUserLoggingFunction.ofAddress(SetUserLoggingFunction$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetInputCount)(const OrtShapeInferContext*,size_t*);
     * }
     */
    public interface ShapeInferContext_GetInputCount {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(ShapeInferContext_GetInputCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$119.const$3, fi, constants$15.const$4, scope);
        }

        static ShapeInferContext_GetInputCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$16.const$0.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ShapeInferContext_GetInputCount$VH() {
        return constants$119.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetInputCount)(const OrtShapeInferContext*,size_t*);
     * }
     */
    public static MemorySegment ShapeInferContext_GetInputCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$119.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetInputCount)(const OrtShapeInferContext*,size_t*);
     * }
     */
    public static void ShapeInferContext_GetInputCount$set(MemorySegment seg, MemorySegment x) {
        constants$119.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ShapeInferContext_GetInputCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$119.const$4.get(seg, index * sizeof());
    }

    public static void ShapeInferContext_GetInputCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$119.const$4.set(seg, index * sizeof(), x);
    }

    public static ShapeInferContext_GetInputCount ShapeInferContext_GetInputCount(MemorySegment segment, Arena scope) {
        return ShapeInferContext_GetInputCount.ofAddress(ShapeInferContext_GetInputCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetInputTypeShape)(const OrtShapeInferContext*,size_t,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public interface ShapeInferContext_GetInputTypeShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ShapeInferContext_GetInputTypeShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$119.const$5, fi, constants$30.const$3, scope);
        }

        static ShapeInferContext_GetInputTypeShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ShapeInferContext_GetInputTypeShape$VH() {
        return constants$120.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetInputTypeShape)(const OrtShapeInferContext*,size_t,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static MemorySegment ShapeInferContext_GetInputTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$120.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetInputTypeShape)(const OrtShapeInferContext*,size_t,OrtTensorTypeAndShapeInfo**);
     * }
     */
    public static void ShapeInferContext_GetInputTypeShape$set(MemorySegment seg, MemorySegment x) {
        constants$120.const$0.set(seg, 0L, x);
    }

    public static MemorySegment ShapeInferContext_GetInputTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$120.const$0.get(seg, index * sizeof());
    }

    public static void ShapeInferContext_GetInputTypeShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$120.const$0.set(seg, index * sizeof(), x);
    }

    public static ShapeInferContext_GetInputTypeShape ShapeInferContext_GetInputTypeShape(
            MemorySegment segment, Arena scope) {
        return ShapeInferContext_GetInputTypeShape.ofAddress(ShapeInferContext_GetInputTypeShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetAttribute)(const OrtShapeInferContext*,char*,const OrtOpAttr**);
     * }
     */
    public interface ShapeInferContext_GetAttribute {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ShapeInferContext_GetAttribute fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$120.const$1, fi, constants$15.const$0, scope);
        }

        static ShapeInferContext_GetAttribute ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$2.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ShapeInferContext_GetAttribute$VH() {
        return constants$120.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetAttribute)(const OrtShapeInferContext*,char*,const OrtOpAttr**);
     * }
     */
    public static MemorySegment ShapeInferContext_GetAttribute$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$120.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_GetAttribute)(const OrtShapeInferContext*,char*,const OrtOpAttr**);
     * }
     */
    public static void ShapeInferContext_GetAttribute$set(MemorySegment seg, MemorySegment x) {
        constants$120.const$2.set(seg, 0L, x);
    }

    public static MemorySegment ShapeInferContext_GetAttribute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$120.const$2.get(seg, index * sizeof());
    }

    public static void ShapeInferContext_GetAttribute$set(MemorySegment seg, long index, MemorySegment x) {
        constants$120.const$2.set(seg, index * sizeof(), x);
    }

    public static ShapeInferContext_GetAttribute ShapeInferContext_GetAttribute(MemorySegment segment, Arena scope) {
        return ShapeInferContext_GetAttribute.ofAddress(ShapeInferContext_GetAttribute$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_SetOutputTypeShape)(const OrtShapeInferContext*,size_t,const OrtTensorTypeAndShapeInfo*);
     * }
     */
    public interface ShapeInferContext_SetOutputTypeShape {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, long _x1, java.lang.foreign.MemorySegment _x2);

        static MemorySegment allocate(ShapeInferContext_SetOutputTypeShape fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$120.const$3, fi, constants$30.const$3, scope);
        }

        static ShapeInferContext_SetOutputTypeShape ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1, java.lang.foreign.MemorySegment __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$30.const$5.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ShapeInferContext_SetOutputTypeShape$VH() {
        return constants$120.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_SetOutputTypeShape)(const OrtShapeInferContext*,size_t,const OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static MemorySegment ShapeInferContext_SetOutputTypeShape$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$120.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ShapeInferContext_SetOutputTypeShape)(const OrtShapeInferContext*,size_t,const OrtTensorTypeAndShapeInfo*);
     * }
     */
    public static void ShapeInferContext_SetOutputTypeShape$set(MemorySegment seg, MemorySegment x) {
        constants$120.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ShapeInferContext_SetOutputTypeShape$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$120.const$4.get(seg, index * sizeof());
    }

    public static void ShapeInferContext_SetOutputTypeShape$set(MemorySegment seg, long index, MemorySegment x) {
        constants$120.const$4.set(seg, index * sizeof(), x);
    }

    public static ShapeInferContext_SetOutputTypeShape ShapeInferContext_SetOutputTypeShape(
            MemorySegment segment, Arena scope) {
        return ShapeInferContext_SetOutputTypeShape.ofAddress(ShapeInferContext_SetOutputTypeShape$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetSymbolicDimensions)(OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public interface SetSymbolicDimensions {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1, long _x2);

        static MemorySegment allocate(SetSymbolicDimensions fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$120.const$5, fi, constants$38.const$1, scope);
        }

        static SetSymbolicDimensions ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1, long __x2) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$38.const$3.invokeExact(symbol, __x0, __x1, __x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetSymbolicDimensions$VH() {
        return constants$121.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSymbolicDimensions)(OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public static MemorySegment SetSymbolicDimensions$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$121.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetSymbolicDimensions)(OrtTensorTypeAndShapeInfo*,char**,size_t);
     * }
     */
    public static void SetSymbolicDimensions$set(MemorySegment seg, MemorySegment x) {
        constants$121.const$0.set(seg, 0L, x);
    }

    public static MemorySegment SetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$121.const$0.get(seg, index * sizeof());
    }

    public static void SetSymbolicDimensions$set(MemorySegment seg, long index, MemorySegment x) {
        constants$121.const$0.set(seg, index * sizeof(), x);
    }

    public static SetSymbolicDimensions SetSymbolicDimensions(MemorySegment segment, Arena scope) {
        return SetSymbolicDimensions.ofAddress(SetSymbolicDimensions$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*ReadOpAttr)(const OrtOpAttr*,OrtOpAttrType,void*,size_t,size_t*);
     * }
     */
    public interface ReadOpAttr {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                int _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(ReadOpAttr fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$121.const$2, fi, constants$121.const$1, scope);
        }

        static ReadOpAttr ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    int __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$121.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle ReadOpAttr$VH() {
        return constants$121.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*ReadOpAttr)(const OrtOpAttr*,OrtOpAttrType,void*,size_t,size_t*);
     * }
     */
    public static MemorySegment ReadOpAttr$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$121.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*ReadOpAttr)(const OrtOpAttr*,OrtOpAttrType,void*,size_t,size_t*);
     * }
     */
    public static void ReadOpAttr$set(MemorySegment seg, MemorySegment x) {
        constants$121.const$4.set(seg, 0L, x);
    }

    public static MemorySegment ReadOpAttr$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$121.const$4.get(seg, index * sizeof());
    }

    public static void ReadOpAttr$set(MemorySegment seg, long index, MemorySegment x) {
        constants$121.const$4.set(seg, index * sizeof(), x);
    }

    public static ReadOpAttr ReadOpAttr(MemorySegment segment, Arena scope) {
        return ReadOpAttr.ofAddress(ReadOpAttr$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SetDeterministicCompute)(OrtSessionOptions*,_Bool);
     * }
     */
    public interface SetDeterministicCompute {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, boolean _x1);

        static MemorySegment allocate(SetDeterministicCompute fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$122.const$0, fi, constants$121.const$5, scope);
        }

        static SetDeterministicCompute ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, boolean __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$122.const$1.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SetDeterministicCompute$VH() {
        return constants$122.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SetDeterministicCompute)(OrtSessionOptions*,_Bool);
     * }
     */
    public static MemorySegment SetDeterministicCompute$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$122.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SetDeterministicCompute)(OrtSessionOptions*,_Bool);
     * }
     */
    public static void SetDeterministicCompute$set(MemorySegment seg, MemorySegment x) {
        constants$122.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SetDeterministicCompute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$122.const$2.get(seg, index * sizeof());
    }

    public static void SetDeterministicCompute$set(MemorySegment seg, long index, MemorySegment x) {
        constants$122.const$2.set(seg, index * sizeof(), x);
    }

    public static SetDeterministicCompute SetDeterministicCompute(MemorySegment segment, Arena scope) {
        return SetDeterministicCompute.ofAddress(SetDeterministicCompute$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelContext_ParallelFor)(const OrtKernelContext*,void (*)(void*,size_t),size_t,size_t,void*);
     * }
     */
    public interface KernelContext_ParallelFor {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                long _x2,
                long _x3,
                java.lang.foreign.MemorySegment _x4);

        static MemorySegment allocate(KernelContext_ParallelFor fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$122.const$4, fi, constants$122.const$3, scope);
        }

        static KernelContext_ParallelFor ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    long __x2,
                    long __x3,
                    java.lang.foreign.MemorySegment __x4) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$122.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3, __x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelContext_ParallelFor$VH() {
        return constants$123.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_ParallelFor)(const OrtKernelContext*,void (*)(void*,size_t),size_t,size_t,void*);
     * }
     */
    public static MemorySegment KernelContext_ParallelFor$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$123.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelContext_ParallelFor)(const OrtKernelContext*,void (*)(void*,size_t),size_t,size_t,void*);
     * }
     */
    public static void KernelContext_ParallelFor$set(MemorySegment seg, MemorySegment x) {
        constants$123.const$0.set(seg, 0L, x);
    }

    public static MemorySegment KernelContext_ParallelFor$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$123.const$0.get(seg, index * sizeof());
    }

    public static void KernelContext_ParallelFor$set(MemorySegment seg, long index, MemorySegment x) {
        constants$123.const$0.set(seg, index * sizeof(), x);
    }

    public static KernelContext_ParallelFor KernelContext_ParallelFor(MemorySegment segment, Arena scope) {
        return KernelContext_ParallelFor.ofAddress(KernelContext_ParallelFor$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO_V2)(OrtSessionOptions*,char**,char**,size_t);
     * }
     */
    public interface SessionOptionsAppendExecutionProvider_OpenVINO_V2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                long _x3);

        static MemorySegment allocate(SessionOptionsAppendExecutionProvider_OpenVINO_V2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$123.const$1, fi, constants$83.const$3, scope);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO_V2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    long __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$83.const$5.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle SessionOptionsAppendExecutionProvider_OpenVINO_V2$VH() {
        return constants$123.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO_V2)(OrtSessionOptions*,char**,char**,size_t);
     * }
     */
    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO_V2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$123.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*SessionOptionsAppendExecutionProvider_OpenVINO_V2)(OrtSessionOptions*,char**,char**,size_t);
     * }
     */
    public static void SessionOptionsAppendExecutionProvider_OpenVINO_V2$set(MemorySegment seg, MemorySegment x) {
        constants$123.const$2.set(seg, 0L, x);
    }

    public static MemorySegment SessionOptionsAppendExecutionProvider_OpenVINO_V2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$123.const$2.get(seg, index * sizeof());
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO_V2$set(
            MemorySegment seg, long index, MemorySegment x) {
        constants$123.const$2.set(seg, index * sizeof(), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO_V2 SessionOptionsAppendExecutionProvider_OpenVINO_V2(
            MemorySegment segment, Arena scope) {
        return SessionOptionsAppendExecutionProvider_OpenVINO_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO_V2$get(segment), scope);
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
