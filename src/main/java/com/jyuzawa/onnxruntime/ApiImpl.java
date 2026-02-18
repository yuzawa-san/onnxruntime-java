/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApi.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

final class ApiImpl implements Api {

    private static final Logger LOG = System.getLogger(ApiImpl.class.getName());

    final AddFreeDimensionOverride.Function AddFreeDimensionOverride;
    final AddFreeDimensionOverrideByName.Function AddFreeDimensionOverrideByName;
    final AddRunConfigEntry.Function AddRunConfigEntry;
    final AddSessionConfigEntry.Function AddSessionConfigEntry;
    final AllocatorGetStats.Function AllocatorGetStats;
    final AllocatorAlloc.Function AllocatorAlloc;
    final AllocatorFree.Function AllocatorFree;
    final BindInput.Function BindInput;
    final BindOutput.Function BindOutput;
    final CastTypeInfoToMapTypeInfo.Function CastTypeInfoToMapTypeInfo;
    final CastTypeInfoToSequenceTypeInfo.Function CastTypeInfoToSequenceTypeInfo;
    final CastTypeInfoToTensorInfo.Function CastTypeInfoToTensorInfo;
    final CreateAllocator.Function CreateAllocator;
    final CreateAndRegisterAllocator.Function CreateAndRegisterAllocator;
    final CreateArenaCfgV2.Function CreateArenaCfgV2;
    final CreateCpuMemoryInfo.Function CreateCpuMemoryInfo;
    final CreateCUDAProviderOptions.Function CreateCUDAProviderOptions;
    final CreateDnnlProviderOptions.Function CreateDnnlProviderOptions;
    final CreateIoBinding.Function CreateIoBinding;
    final CreateTensorRTProviderOptions.Function CreateTensorRTProviderOptions;
    final CreateEnvWithCustomLogger.Function CreateEnvWithCustomLogger;
    final CreateEnvWithCustomLoggerAndGlobalThreadPools.Function CreateEnvWithCustomLoggerAndGlobalThreadPools;
    final CreateRunOptions.Function CreateRunOptions;
    final CreateSession.Function CreateSession;
    final CreateSessionFromArray.Function CreateSessionFromArray;
    final CreateSessionOptions.Function CreateSessionOptions;
    final CreateTensorAsOrtValue.Function CreateTensorAsOrtValue;
    final CreateTensorWithDataAsOrtValue.Function CreateTensorWithDataAsOrtValue;
    final CreateThreadingOptions.Function CreateThreadingOptions;
    final CreateValue.Function CreateValue;
    final DisableCpuMemArena.Function DisableCpuMemArena;
    final DisableMemPattern.Function DisableMemPattern;
    final DisablePerSessionThreads.Function DisablePerSessionThreads;
    final DisableProfiling.Function DisableProfiling;
    final DisableTelemetryEvents.Function DisableTelemetryEvents;
    final EnableCpuMemArena.Function EnableCpuMemArena;
    final EnableMemPattern.Function EnableMemPattern;
    final EnableProfiling.Function EnableProfiling;
    final EnableTelemetryEvents.Function EnableTelemetryEvents;
    final FillStringTensor.Function FillStringTensor;
    final GetAvailableProviders.Function GetAvailableProviders;
    final GetBuildInfoString.Function GetBuildInfoString;
    final GetDimensions.Function GetDimensions;
    final GetDimensionsCount.Function GetDimensionsCount;
    final GetErrorCode.Function GetErrorCode;
    final GetErrorMessage.Function GetErrorMessage;
    final GetKeyValuePairs.Function GetKeyValuePairs;
    final GetMapKeyType.Function GetMapKeyType;
    final GetMapValueType.Function GetMapValueType;
    final GetOnnxTypeFromTypeInfo.Function GetOnnxTypeFromTypeInfo;
    final GetSequenceElementType.Function GetSequenceElementType;
    final GetSharedAllocator.Function GetSharedAllocator;
    final GetStringTensorElement.Function GetStringTensorElement;
    final GetStringTensorElementLength.Function GetStringTensorElementLength;
    final GetTensorElementType.Function GetTensorElementType;
    final GetTensorMutableData.Function GetTensorMutableData;
    final GetTensorShapeElementCount.Function GetTensorShapeElementCount;
    final GetTensorTypeAndShape.Function GetTensorTypeAndShape;
    final GetValue.Function GetValue;
    final GetValueCount.Function GetValueCount;
    final ModelMetadataGetCustomMetadataMapKeys.Function ModelMetadataGetCustomMetadataMapKeys;
    final ModelMetadataGetDescription.Function ModelMetadataGetDescription;
    final ModelMetadataGetDomain.Function ModelMetadataGetDomain;
    final ModelMetadataGetGraphDescription.Function ModelMetadataGetGraphDescription;
    final ModelMetadataGetGraphName.Function ModelMetadataGetGraphName;
    final ModelMetadataGetProducerName.Function ModelMetadataGetProducerName;
    final ModelMetadataGetVersion.Function ModelMetadataGetVersion;
    final ModelMetadataLookupCustomMetadataMap.Function ModelMetadataLookupCustomMetadataMap;
    final RegisterCustomOpsLibrary_V2.Function RegisterCustomOpsLibrary_V2;
    final ReleaseAvailableProviders.Function ReleaseAvailableProviders;
    final ReleaseCUDAProviderOptions.Function ReleaseCUDAProviderOptions;
    final ReleaseDnnlProviderOptions.Function ReleaseDnnlProviderOptions;
    final ReleaseEnv.Function ReleaseEnv;
    final ReleaseIoBinding.Function ReleaseIoBinding;
    final ReleaseKeyValuePairs.Function ReleaseKeyValuePairs;
    final ReleaseMemoryInfo.Function ReleaseMemoryInfo;
    final ReleaseModelMetadata.Function ReleaseModelMetadata;
    final ReleaseRunOptions.Function ReleaseRunOptions;
    final ReleaseSession.Function ReleaseSession;
    final ReleaseSessionOptions.Function ReleaseSessionOptions;
    final ReleaseStatus.Function ReleaseStatus;
    final ReleaseTensorRTProviderOptions.Function ReleaseTensorRTProviderOptions;
    final ReleaseTensorTypeAndShapeInfo.Function ReleaseTensorTypeAndShapeInfo;
    final ReleaseThreadingOptions.Function ReleaseThreadingOptions;
    final ReleaseTypeInfo.Function ReleaseTypeInfo;
    final ReleaseValue.Function ReleaseValue;
    final Run.Function Run;
    final RunOptionsSetRunLogSeverityLevel.Function RunOptionsSetRunLogSeverityLevel;
    final RunOptionsSetRunLogVerbosityLevel.Function RunOptionsSetRunLogVerbosityLevel;
    final RunOptionsSetRunTag.Function RunOptionsSetRunTag;
    final RunWithBinding.Function RunWithBinding;
    final SetGlobalDenormalAsZero.Function SetGlobalDenormalAsZero;
    final SetGlobalIntraOpNumThreads.Function SetGlobalIntraOpNumThreads;
    final SetGlobalInterOpNumThreads.Function SetGlobalInterOpNumThreads;
    final SetGlobalSpinControl.Function SetGlobalSpinControl;
    final SetInterOpNumThreads.Function SetInterOpNumThreads;
    final SetIntraOpNumThreads.Function SetIntraOpNumThreads;
    final SetLanguageProjection.Function SetLanguageProjection;
    final SetOptimizedModelFilePath.Function SetOptimizedModelFilePath;
    final SetDeterministicCompute.Function SetDeterministicCompute;
    final SetEpDynamicOptions.Function SetEpDynamicOptions;
    final SetSessionExecutionMode.Function SetSessionExecutionMode;
    final SetSessionGraphOptimizationLevel.Function SetSessionGraphOptimizationLevel;
    final SetSessionLogId.Function SetSessionLogId;
    final SetSessionLogSeverityLevel.Function SetSessionLogSeverityLevel;
    final SetSessionLogVerbosityLevel.Function SetSessionLogVerbosityLevel;
    final SessionEndProfiling.Function SessionEndProfiling;
    final SessionGetInputCount.Function SessionGetInputCount;
    final SessionGetInputName.Function SessionGetInputName;
    final SessionGetInputTypeInfo.Function SessionGetInputTypeInfo;
    final SessionGetModelMetadata.Function SessionGetModelMetadata;
    final SessionGetOutputCount.Function SessionGetOutputCount;
    final SessionGetOutputName.Function SessionGetOutputName;
    final SessionGetOutputTypeInfo.Function SessionGetOutputTypeInfo;
    final SessionGetOverridableInitializerCount.Function SessionGetOverridableInitializerCount;
    final SessionGetOverridableInitializerName.Function SessionGetOverridableInitializerName;
    final SessionGetOverridableInitializerTypeInfo.Function SessionGetOverridableInitializerTypeInfo;
    final SessionGetProfilingStartTimeNs.Function SessionGetProfilingStartTimeNs;
    final SessionOptionsAppendExecutionProvider.Function SessionOptionsAppendExecutionProvider;
    final SessionOptionsAppendExecutionProvider_CANN.Function SessionOptionsAppendExecutionProvider_CANN;
    final SessionOptionsAppendExecutionProvider_CUDA_V2.Function SessionOptionsAppendExecutionProvider_CUDA_V2;
    final SessionOptionsAppendExecutionProvider_Dnnl.Function SessionOptionsAppendExecutionProvider_Dnnl;
    final SessionOptionsAppendExecutionProvider_MIGraphX.Function SessionOptionsAppendExecutionProvider_MIGraphX;
    final SessionOptionsAppendExecutionProvider_OpenVINO_V2.Function SessionOptionsAppendExecutionProvider_OpenVINO_V2;
    final SessionOptionsAppendExecutionProvider_ROCM.Function SessionOptionsAppendExecutionProvider_ROCM;
    final SessionOptionsAppendExecutionProvider_TensorRT_V2.Function SessionOptionsAppendExecutionProvider_TensorRT_V2;
    final SessionOptionsAppendExecutionProvider_VitisAI.Function SessionOptionsAppendExecutionProvider_VitisAI;
    final SynchronizeBoundInputs.Function SynchronizeBoundInputs;
    final SynchronizeBoundOutputs.Function SynchronizeBoundOutputs;
    final UpdateCUDAProviderOptions.Function UpdateCUDAProviderOptions;
    final UpdateDnnlProviderOptions.Function UpdateDnnlProviderOptions;
    final UpdateTensorRTProviderOptions.Function UpdateTensorRTProviderOptions;

    private final Set<ExecutionProvider> providers;

    ApiImpl(MemorySegment memorySegment) {
        MemorySegment fnAddFreeDimensionOverride = OrtApi.AddFreeDimensionOverride(memorySegment);
        this.AddFreeDimensionOverride =
                (_x0, _x1, _x2) -> OrtApi.AddFreeDimensionOverride.invoke(fnAddFreeDimensionOverride, _x0, _x1, _x2);
        MemorySegment fnAddFreeDimensionOverrideByName = OrtApi.AddFreeDimensionOverrideByName(memorySegment);
        this.AddFreeDimensionOverrideByName = (_x0, _x1, _x2) ->
                OrtApi.AddFreeDimensionOverrideByName.invoke(fnAddFreeDimensionOverrideByName, _x0, _x1, _x2);
        MemorySegment fnAddRunConfigEntry = OrtApi.AddRunConfigEntry(memorySegment);
        this.AddRunConfigEntry = (_x0, _x1, _x2) -> OrtApi.AddRunConfigEntry.invoke(fnAddRunConfigEntry, _x0, _x1, _x2);
        MemorySegment fnAddSessionConfigEntry = OrtApi.AddSessionConfigEntry(memorySegment);
        this.AddSessionConfigEntry =
                (_x0, _x1, _x2) -> OrtApi.AddSessionConfigEntry.invoke(fnAddSessionConfigEntry, _x0, _x1, _x2);
        MemorySegment fnAllocatorGetStats = OrtApi.AllocatorGetStats(memorySegment);
        this.AllocatorGetStats = (_x1, _x2) -> OrtApi.AllocatorGetStats.invoke(fnAllocatorGetStats, _x1, _x2);
        MemorySegment fnAllocatorAlloc = OrtApi.AllocatorAlloc(memorySegment);
        this.AllocatorAlloc = (_x0, _x1, _x2) -> OrtApi.AllocatorAlloc.invoke(fnAllocatorAlloc, _x0, _x1, _x2);
        MemorySegment fnAllocatorFree = OrtApi.AllocatorFree(memorySegment);
        this.AllocatorFree = (_x0, _x1) -> OrtApi.AllocatorFree.invoke(fnAllocatorFree, _x0, _x1);
        MemorySegment fnBindInput = OrtApi.BindInput(memorySegment);
        this.BindInput = (_x0, _x1, _x2) -> OrtApi.BindInput.invoke(fnBindInput, _x0, _x1, _x2);
        MemorySegment fnBindOutput = OrtApi.BindOutput(memorySegment);
        this.BindOutput = (_x0, _x1, _x2) -> OrtApi.BindOutput.invoke(fnBindOutput, _x0, _x1, _x2);
        MemorySegment fnCastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfo(memorySegment);
        this.CastTypeInfoToMapTypeInfo =
                (_x0, _x1) -> OrtApi.CastTypeInfoToMapTypeInfo.invoke(fnCastTypeInfoToMapTypeInfo, _x0, _x1);
        MemorySegment fnCastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfo(memorySegment);
        this.CastTypeInfoToSequenceTypeInfo =
                (_x0, _x1) -> OrtApi.CastTypeInfoToSequenceTypeInfo.invoke(fnCastTypeInfoToSequenceTypeInfo, _x0, _x1);
        MemorySegment fnCastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfo(memorySegment);
        this.CastTypeInfoToTensorInfo =
                (_x0, _x1) -> OrtApi.CastTypeInfoToTensorInfo.invoke(fnCastTypeInfoToTensorInfo, _x0, _x1);
        MemorySegment fnCreateAllocator = OrtApi.CreateAllocator(memorySegment);
        this.CreateAllocator = (_x0, _x1, _x2) -> OrtApi.CreateAllocator.invoke(fnCreateAllocator, _x0, _x1, _x2);
        MemorySegment fnCreateAndRegisterAllocator = OrtApi.CreateAndRegisterAllocator(memorySegment);
        this.CreateAndRegisterAllocator = (_x0, _x1, _x2) ->
                OrtApi.CreateAndRegisterAllocator.invoke(fnCreateAndRegisterAllocator, _x0, _x1, _x2);
        MemorySegment fnCreateArenaCfgV2 = OrtApi.CreateArenaCfgV2(memorySegment);
        this.CreateArenaCfgV2 =
                (_x0, _x1, _x2, _x3) -> OrtApi.CreateArenaCfgV2.invoke(fnCreateArenaCfgV2, _x0, _x1, _x2, _x3);
        MemorySegment fnCreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfo(memorySegment);
        this.CreateCpuMemoryInfo =
                (_x0, _x1, _x2) -> OrtApi.CreateCpuMemoryInfo.invoke(fnCreateCpuMemoryInfo, _x0, _x1, _x2);
        MemorySegment fnCreateCUDAProviderOptions = OrtApi.CreateCUDAProviderOptions(memorySegment);
        this.CreateCUDAProviderOptions =
                (_x0) -> OrtApi.CreateCUDAProviderOptions.invoke(fnCreateCUDAProviderOptions, _x0);
        MemorySegment fnCreateDnnlProviderOptions = OrtApi.CreateDnnlProviderOptions(memorySegment);
        this.CreateDnnlProviderOptions =
                (_x0) -> OrtApi.CreateDnnlProviderOptions.invoke(fnCreateDnnlProviderOptions, _x0);
        MemorySegment fnCreateTensorRTProviderOptions = OrtApi.CreateTensorRTProviderOptions(memorySegment);
        this.CreateTensorRTProviderOptions =
                (_x0) -> OrtApi.CreateTensorRTProviderOptions.invoke(fnCreateTensorRTProviderOptions, _x0);
        MemorySegment fnCreateIoBinding = OrtApi.CreateIoBinding(memorySegment);
        this.CreateIoBinding = (_x0, _x1) -> OrtApi.CreateIoBinding.invoke(fnCreateIoBinding, _x0, _x1);
        MemorySegment fnCreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLogger(memorySegment);
        this.CreateEnvWithCustomLogger = (_x0, _x1, _x2, _x3, _x4) ->
                OrtApi.CreateEnvWithCustomLogger.invoke(fnCreateEnvWithCustomLogger, _x0, _x1, _x2, _x3, _x4);
        MemorySegment fnCreateEnvWithCustomLoggerAndGlobalThreadPools =
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools(memorySegment);
        this.CreateEnvWithCustomLoggerAndGlobalThreadPools =
                (_x0, _x1, _x2, _x3, _x4, _x5) -> OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools.invoke(
                        fnCreateEnvWithCustomLoggerAndGlobalThreadPools, _x0, _x1, _x2, _x3, _x4, _x5);
        MemorySegment fnCreateRunOptions = OrtApi.CreateRunOptions(memorySegment);
        this.CreateRunOptions = (_x0) -> OrtApi.CreateRunOptions.invoke(fnCreateRunOptions, _x0);
        MemorySegment fnCreateSession = OrtApi.CreateSession(memorySegment);
        this.CreateSession = (_x0, _x1, _x2, _x3) -> OrtApi.CreateSession.invoke(fnCreateSession, _x0, _x1, _x2, _x3);
        MemorySegment fnCreateSessionFromArray = OrtApi.CreateSessionFromArray(memorySegment);
        this.CreateSessionFromArray = (_x0, _x1, _x2, _x3, _x4) ->
                OrtApi.CreateSessionFromArray.invoke(fnCreateSessionFromArray, _x0, _x1, _x2, _x3, _x4);
        MemorySegment fnCreateSessionOptions = OrtApi.CreateSessionOptions(memorySegment);
        this.CreateSessionOptions = (_x0) -> OrtApi.CreateSessionOptions.invoke(fnCreateSessionOptions, _x0);
        MemorySegment fnCreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValue(memorySegment);
        this.CreateTensorAsOrtValue = (_x0, _x1, _x2, _x3, _x4) ->
                OrtApi.CreateTensorAsOrtValue.invoke(fnCreateTensorAsOrtValue, _x0, _x1, _x2, _x3, _x4);
        MemorySegment fnCreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValue(memorySegment);
        this.CreateTensorWithDataAsOrtValue =
                (_x0, _x1, _x2, _x3, _x4, _x5, _x6) -> OrtApi.CreateTensorWithDataAsOrtValue.invoke(
                        fnCreateTensorWithDataAsOrtValue, _x0, _x1, _x2, _x3, _x4, _x5, _x6);
        MemorySegment fnCreateThreadingOptions = OrtApi.CreateThreadingOptions(memorySegment);
        this.CreateThreadingOptions = (_x0) -> OrtApi.CreateThreadingOptions.invoke(fnCreateThreadingOptions, _x0);
        MemorySegment fnCreateValue = OrtApi.CreateValue(memorySegment);
        this.CreateValue = (_x0, _x1, _x2, _x3) -> OrtApi.CreateValue.invoke(fnCreateValue, _x0, _x1, _x2, _x3);
        MemorySegment fnDisableCpuMemArena = OrtApi.DisableCpuMemArena(memorySegment);
        this.DisableCpuMemArena = (_x0) -> OrtApi.DisableCpuMemArena.invoke(fnDisableCpuMemArena, _x0);
        MemorySegment fnDisableMemPattern = OrtApi.DisableMemPattern(memorySegment);
        this.DisableMemPattern = (_x0) -> OrtApi.DisableMemPattern.invoke(fnDisableMemPattern, _x0);
        MemorySegment fnDisablePerSessionThreads = OrtApi.DisablePerSessionThreads(memorySegment);
        this.DisablePerSessionThreads =
                (_x0) -> OrtApi.DisablePerSessionThreads.invoke(fnDisablePerSessionThreads, _x0);
        MemorySegment fnDisableProfiling = OrtApi.DisableProfiling(memorySegment);
        this.DisableProfiling = (_x0) -> OrtApi.DisableProfiling.invoke(fnDisableProfiling, _x0);
        MemorySegment fnDisableTelemetryEvents = OrtApi.DisableTelemetryEvents(memorySegment);
        this.DisableTelemetryEvents = (_x0) -> OrtApi.DisableTelemetryEvents.invoke(fnDisableTelemetryEvents, _x0);
        MemorySegment fnEnableTelemetryEvents = OrtApi.EnableTelemetryEvents(memorySegment);
        this.EnableTelemetryEvents = (_x0) -> OrtApi.EnableTelemetryEvents.invoke(fnEnableTelemetryEvents, _x0);
        MemorySegment fnEnableCpuMemArena = OrtApi.EnableCpuMemArena(memorySegment);
        this.EnableCpuMemArena = (_x0) -> OrtApi.EnableCpuMemArena.invoke(fnEnableCpuMemArena, _x0);
        MemorySegment fnEnableMemPattern = OrtApi.EnableMemPattern(memorySegment);
        this.EnableMemPattern = (_x0) -> OrtApi.EnableMemPattern.invoke(fnEnableMemPattern, _x0);
        MemorySegment fnEnableProfiling = OrtApi.EnableProfiling(memorySegment);
        this.EnableProfiling = (_x0, _x1) -> OrtApi.EnableProfiling.invoke(fnEnableProfiling, _x0, _x1);
        MemorySegment fnFillStringTensor = OrtApi.FillStringTensor(memorySegment);
        this.FillStringTensor = (_x0, _x1, _x2) -> OrtApi.FillStringTensor.invoke(fnFillStringTensor, _x0, _x1, _x2);
        MemorySegment fnGetAvailableProviders = OrtApi.GetAvailableProviders(memorySegment);
        this.GetAvailableProviders =
                (_x0, _x1) -> OrtApi.GetAvailableProviders.invoke(fnGetAvailableProviders, _x0, _x1);
        MemorySegment fnGetBuildInfoString = OrtApi.GetBuildInfoString(memorySegment);
        this.GetBuildInfoString = () -> OrtApi.GetBuildInfoString.invoke(fnGetBuildInfoString);
        MemorySegment fnGetDimensions = OrtApi.GetDimensions(memorySegment);
        this.GetDimensions = (_x0, _x1, _x2) -> OrtApi.GetDimensions.invoke(fnGetDimensions, _x0, _x1, _x2);
        MemorySegment fnGetDimensionsCount = OrtApi.GetDimensionsCount(memorySegment);
        this.GetDimensionsCount = (_x0, _x1) -> OrtApi.GetDimensionsCount.invoke(fnGetDimensionsCount, _x0, _x1);
        MemorySegment fnGetErrorCode = OrtApi.GetErrorCode(memorySegment);
        this.GetErrorCode = (_x0) -> OrtApi.GetErrorCode.invoke(fnGetErrorCode, _x0);
        MemorySegment fnGetErrorMessage = OrtApi.GetErrorMessage(memorySegment);
        this.GetErrorMessage = (_x0) -> OrtApi.GetErrorMessage.invoke(fnGetErrorMessage, _x0);
        MemorySegment fnGetKeyValuePairs = OrtApi.GetKeyValuePairs(memorySegment);
        this.GetKeyValuePairs =
                (_x0, _x1, _x2, _x3) -> OrtApi.GetKeyValuePairs.invoke(fnGetKeyValuePairs, _x0, _x1, _x2, _x3);
        MemorySegment fnGetMapKeyType = OrtApi.GetMapKeyType(memorySegment);
        this.GetMapKeyType = (_x0, _x1) -> OrtApi.GetMapKeyType.invoke(fnGetMapKeyType, _x0, _x1);
        MemorySegment fnGetMapValueType = OrtApi.GetMapValueType(memorySegment);
        this.GetMapValueType = (_x0, _x1) -> OrtApi.GetMapValueType.invoke(fnGetMapValueType, _x0, _x1);
        MemorySegment fnGetOnnxTypeFromTypeInfo = OrtApi.GetOnnxTypeFromTypeInfo(memorySegment);
        this.GetOnnxTypeFromTypeInfo =
                (_x0, _x1) -> OrtApi.GetOnnxTypeFromTypeInfo.invoke(fnGetOnnxTypeFromTypeInfo, _x0, _x1);
        MemorySegment fnGetSequenceElementType = OrtApi.GetSequenceElementType(memorySegment);
        this.GetSequenceElementType =
                (_x0, _x1) -> OrtApi.GetSequenceElementType.invoke(fnGetSequenceElementType, _x0, _x1);
        MemorySegment fnGetSharedAllocator = OrtApi.GetSharedAllocator(memorySegment);
        this.GetSharedAllocator =
                (_x0, _x1, _x2) -> OrtApi.GetSharedAllocator.invoke(fnGetSharedAllocator, _x0, _x1, _x2);
        MemorySegment fnGetStringTensorElement = OrtApi.GetStringTensorElement(memorySegment);
        this.GetStringTensorElement = (_x0, _x1, _x2, _x3) ->
                OrtApi.GetStringTensorElement.invoke(fnGetStringTensorElement, _x0, _x1, _x2, _x3);
        MemorySegment fnGetStringTensorElementLength = OrtApi.GetStringTensorElementLength(memorySegment);
        this.GetStringTensorElementLength = (_x0, _x1, _x2) ->
                OrtApi.GetStringTensorElementLength.invoke(fnGetStringTensorElementLength, _x0, _x1, _x2);
        MemorySegment fnGetTensorElementType = OrtApi.GetTensorElementType(memorySegment);
        this.GetTensorElementType = (_x0, _x1) -> OrtApi.GetTensorElementType.invoke(fnGetTensorElementType, _x0, _x1);
        MemorySegment fnGetTensorMutableData = OrtApi.GetTensorMutableData(memorySegment);
        this.GetTensorMutableData = (_x0, _x1) -> OrtApi.GetTensorMutableData.invoke(fnGetTensorMutableData, _x0, _x1);
        MemorySegment fnGetTensorShapeElementCount = OrtApi.GetTensorShapeElementCount(memorySegment);
        this.GetTensorShapeElementCount =
                (_x0, _x1) -> OrtApi.GetTensorShapeElementCount.invoke(fnGetTensorShapeElementCount, _x0, _x1);
        MemorySegment fnGetTensorTypeAndShape = OrtApi.GetTensorTypeAndShape(memorySegment);
        this.GetTensorTypeAndShape =
                (_x0, _x1) -> OrtApi.GetTensorTypeAndShape.invoke(fnGetTensorTypeAndShape, _x0, _x1);
        MemorySegment fnGetValue = OrtApi.GetValue(memorySegment);
        this.GetValue = (_x0, _x1, _x2, _x3) -> OrtApi.GetValue.invoke(fnGetValue, _x0, _x1, _x2, _x3);
        MemorySegment fnGetValueCount = OrtApi.GetValueCount(memorySegment);
        this.GetValueCount = (_x0, _x1) -> OrtApi.GetValueCount.invoke(fnGetValueCount, _x0, _x1);
        MemorySegment fnModelMetadataGetCustomMetadataMapKeys =
                OrtApi.ModelMetadataGetCustomMetadataMapKeys(memorySegment);
        this.ModelMetadataGetCustomMetadataMapKeys =
                (_x0, _x1, _x2, _x3) -> OrtApi.ModelMetadataGetCustomMetadataMapKeys.invoke(
                        fnModelMetadataGetCustomMetadataMapKeys, _x0, _x1, _x2, _x3);
        MemorySegment fnModelMetadataGetDescription = OrtApi.ModelMetadataGetDescription(memorySegment);
        this.ModelMetadataGetDescription = (_x0, _x1, _x2) ->
                OrtApi.ModelMetadataGetDescription.invoke(fnModelMetadataGetDescription, _x0, _x1, _x2);
        MemorySegment fnModelMetadataGetDomain = OrtApi.ModelMetadataGetDomain(memorySegment);
        this.ModelMetadataGetDomain =
                (_x0, _x1, _x2) -> OrtApi.ModelMetadataGetDomain.invoke(fnModelMetadataGetDomain, _x0, _x1, _x2);
        MemorySegment fnModelMetadataGetGraphDescription = OrtApi.ModelMetadataGetGraphDescription(memorySegment);
        this.ModelMetadataGetGraphDescription = (_x0, _x1, _x2) ->
                OrtApi.ModelMetadataGetGraphDescription.invoke(fnModelMetadataGetGraphDescription, _x0, _x1, _x2);
        MemorySegment fnModelMetadataGetGraphName = OrtApi.ModelMetadataGetGraphName(memorySegment);
        this.ModelMetadataGetGraphName =
                (_x0, _x1, _x2) -> OrtApi.ModelMetadataGetGraphName.invoke(fnModelMetadataGetGraphName, _x0, _x1, _x2);
        MemorySegment fnModelMetadataGetProducerName = OrtApi.ModelMetadataGetProducerName(memorySegment);
        this.ModelMetadataGetProducerName = (_x0, _x1, _x2) ->
                OrtApi.ModelMetadataGetProducerName.invoke(fnModelMetadataGetProducerName, _x0, _x1, _x2);
        MemorySegment fnModelMetadataGetVersion = OrtApi.ModelMetadataGetVersion(memorySegment);
        this.ModelMetadataGetVersion =
                (_x0, _x1) -> OrtApi.ModelMetadataGetVersion.invoke(fnModelMetadataGetVersion, _x0, _x1);
        MemorySegment fnModelMetadataLookupCustomMetadataMap =
                OrtApi.ModelMetadataLookupCustomMetadataMap(memorySegment);
        this.ModelMetadataLookupCustomMetadataMap =
                (_x0, _x1, _x2, _x3) -> OrtApi.ModelMetadataLookupCustomMetadataMap.invoke(
                        fnModelMetadataLookupCustomMetadataMap, _x0, _x1, _x2, _x3);
        MemorySegment fnRegisterCustomOpsLibrary_V2 = OrtApi.RegisterCustomOpsLibrary_V2(memorySegment);
        this.RegisterCustomOpsLibrary_V2 =
                (_x0, _x1) -> OrtApi.RegisterCustomOpsLibrary_V2.invoke(fnRegisterCustomOpsLibrary_V2, _x0, _x1);
        MemorySegment fnReleaseAvailableProviders = OrtApi.ReleaseAvailableProviders(memorySegment);
        this.ReleaseAvailableProviders =
                (_x0, _x1) -> OrtApi.ReleaseAvailableProviders.invoke(fnReleaseAvailableProviders, _x0, _x1);
        MemorySegment fnReleaseCUDAProviderOptions = OrtApi.ReleaseCUDAProviderOptions(memorySegment);
        this.ReleaseCUDAProviderOptions =
                (_x0) -> OrtApi.ReleaseCUDAProviderOptions.invoke(fnReleaseCUDAProviderOptions, _x0);
        MemorySegment fnReleaseDnnlProviderOptions = OrtApi.ReleaseDnnlProviderOptions(memorySegment);
        this.ReleaseDnnlProviderOptions =
                (_x0) -> OrtApi.ReleaseDnnlProviderOptions.invoke(fnReleaseDnnlProviderOptions, _x0);
        MemorySegment fnReleaseEnv = OrtApi.ReleaseEnv(memorySegment);
        this.ReleaseEnv = (_x0) -> OrtApi.ReleaseEnv.invoke(fnReleaseEnv, _x0);
        MemorySegment fnReleaseKeyValuePairs = OrtApi.ReleaseKeyValuePairs(memorySegment);
        this.ReleaseKeyValuePairs = (_x0) -> OrtApi.ReleaseKeyValuePairs.invoke(fnReleaseKeyValuePairs, _x0);
        MemorySegment fnReleaseIoBinding = OrtApi.ReleaseIoBinding(memorySegment);
        this.ReleaseIoBinding = (_x0) -> OrtApi.ReleaseIoBinding.invoke(fnReleaseIoBinding, _x0);
        MemorySegment fnReleaseMemoryInfo = OrtApi.ReleaseMemoryInfo(memorySegment);
        this.ReleaseMemoryInfo = (_x0) -> OrtApi.ReleaseMemoryInfo.invoke(fnReleaseMemoryInfo, _x0);
        MemorySegment fnReleaseModelMetadata = OrtApi.ReleaseModelMetadata(memorySegment);
        this.ReleaseModelMetadata = (_x0) -> OrtApi.ReleaseModelMetadata.invoke(fnReleaseModelMetadata, _x0);
        MemorySegment fnReleaseRunOptions = OrtApi.ReleaseRunOptions(memorySegment);
        this.ReleaseRunOptions = (_x0) -> OrtApi.ReleaseRunOptions.invoke(fnReleaseRunOptions, _x0);
        MemorySegment fnReleaseSession = OrtApi.ReleaseSession(memorySegment);
        this.ReleaseSession = (_x0) -> OrtApi.ReleaseSession.invoke(fnReleaseSession, _x0);
        MemorySegment fnReleaseSessionOptions = OrtApi.ReleaseSessionOptions(memorySegment);
        this.ReleaseSessionOptions = (_x0) -> OrtApi.ReleaseSessionOptions.invoke(fnReleaseSessionOptions, _x0);
        MemorySegment fnReleaseStatus = OrtApi.ReleaseStatus(memorySegment);
        this.ReleaseStatus = (_x0) -> OrtApi.ReleaseStatus.invoke(fnReleaseStatus, _x0);
        MemorySegment fnReleaseTensorRTProviderOptions = OrtApi.ReleaseTensorRTProviderOptions(memorySegment);
        this.ReleaseTensorRTProviderOptions =
                (_x0) -> OrtApi.ReleaseTensorRTProviderOptions.invoke(fnReleaseTensorRTProviderOptions, _x0);
        MemorySegment fnReleaseTensorTypeAndShapeInfo = OrtApi.ReleaseTensorTypeAndShapeInfo(memorySegment);
        this.ReleaseTensorTypeAndShapeInfo =
                (_x0) -> OrtApi.ReleaseTensorTypeAndShapeInfo.invoke(fnReleaseTensorTypeAndShapeInfo, _x0);
        MemorySegment fnReleaseThreadingOptions = OrtApi.ReleaseThreadingOptions(memorySegment);
        this.ReleaseThreadingOptions = (_x0) -> OrtApi.ReleaseThreadingOptions.invoke(fnReleaseThreadingOptions, _x0);
        MemorySegment fnReleaseTypeInfo = OrtApi.ReleaseTypeInfo(memorySegment);
        this.ReleaseTypeInfo = (_x0) -> OrtApi.ReleaseTypeInfo.invoke(fnReleaseTypeInfo, _x0);
        MemorySegment fnReleaseValue = OrtApi.ReleaseValue(memorySegment);
        this.ReleaseValue = (_x0) -> OrtApi.ReleaseValue.invoke(fnReleaseValue, _x0);
        MemorySegment fnRun = OrtApi.Run(memorySegment);
        this.Run = (_x0, _x1, _x2, _x3, _x4, _x5, _x6, _x7) ->
                OrtApi.Run.invoke(fnRun, _x0, _x1, _x2, _x3, _x4, _x5, _x6, _x7);
        MemorySegment fnRunOptionsSetRunLogSeverityLevel = OrtApi.RunOptionsSetRunLogSeverityLevel(memorySegment);
        this.RunOptionsSetRunLogSeverityLevel = (_x0, _x1) ->
                OrtApi.RunOptionsSetRunLogSeverityLevel.invoke(fnRunOptionsSetRunLogSeverityLevel, _x0, _x1);
        MemorySegment fnRunOptionsSetRunLogVerbosityLevel = OrtApi.RunOptionsSetRunLogVerbosityLevel(memorySegment);
        this.RunOptionsSetRunLogVerbosityLevel = (_x0, _x1) ->
                OrtApi.RunOptionsSetRunLogVerbosityLevel.invoke(fnRunOptionsSetRunLogVerbosityLevel, _x0, _x1);
        MemorySegment fnRunOptionsSetRunTag = OrtApi.RunOptionsSetRunTag(memorySegment);
        this.RunOptionsSetRunTag = (_x0, _x1) -> OrtApi.RunOptionsSetRunTag.invoke(fnRunOptionsSetRunTag, _x0, _x1);
        MemorySegment fnRunWithBinding = OrtApi.RunWithBinding(memorySegment);
        this.RunWithBinding = (_x0, _x1, _x2) -> OrtApi.RunWithBinding.invoke(fnRunWithBinding, _x0, _x1, _x2);
        MemorySegment fnSetGlobalDenormalAsZero = OrtApi.SetGlobalDenormalAsZero(memorySegment);
        this.SetGlobalDenormalAsZero = (_x0) -> OrtApi.SetGlobalDenormalAsZero.invoke(fnSetGlobalDenormalAsZero, _x0);
        MemorySegment fnSetGlobalIntraOpNumThreads = OrtApi.SetGlobalIntraOpNumThreads(memorySegment);
        this.SetGlobalIntraOpNumThreads =
                (_x0, _x1) -> OrtApi.SetGlobalIntraOpNumThreads.invoke(fnSetGlobalIntraOpNumThreads, _x0, _x1);
        MemorySegment fnSetGlobalInterOpNumThreads = OrtApi.SetGlobalInterOpNumThreads(memorySegment);
        this.SetGlobalInterOpNumThreads =
                (_x0, _x1) -> OrtApi.SetGlobalInterOpNumThreads.invoke(fnSetGlobalInterOpNumThreads, _x0, _x1);
        MemorySegment fnSetGlobalSpinControl = OrtApi.SetGlobalSpinControl(memorySegment);
        this.SetGlobalSpinControl = (_x0, _x1) -> OrtApi.SetGlobalSpinControl.invoke(fnSetGlobalSpinControl, _x0, _x1);
        MemorySegment fnSetInterOpNumThreads = OrtApi.SetInterOpNumThreads(memorySegment);
        this.SetInterOpNumThreads = (_x0, _x1) -> OrtApi.SetInterOpNumThreads.invoke(fnSetInterOpNumThreads, _x0, _x1);
        MemorySegment fnSetIntraOpNumThreads = OrtApi.SetIntraOpNumThreads(memorySegment);
        this.SetIntraOpNumThreads = (_x0, _x1) -> OrtApi.SetIntraOpNumThreads.invoke(fnSetIntraOpNumThreads, _x0, _x1);
        MemorySegment fnSetLanguageProjection = OrtApi.SetLanguageProjection(memorySegment);
        this.SetLanguageProjection =
                (_x0, _x1) -> OrtApi.SetLanguageProjection.invoke(fnSetLanguageProjection, _x0, _x1);
        MemorySegment fnSetOptimizedModelFilePath = OrtApi.SetOptimizedModelFilePath(memorySegment);
        this.SetOptimizedModelFilePath =
                (_x0, _x1) -> OrtApi.SetOptimizedModelFilePath.invoke(fnSetOptimizedModelFilePath, _x0, _x1);
        MemorySegment fnSetDeterministicCompute = OrtApi.SetDeterministicCompute(memorySegment);
        this.SetDeterministicCompute =
                (_x0, _x1) -> OrtApi.SetDeterministicCompute.invoke(fnSetDeterministicCompute, _x0, _x1);
        MemorySegment fnSetEpDynamicOptions = OrtApi.SetEpDynamicOptions(memorySegment);
        this.SetEpDynamicOptions =
                (_x0, _x1, _x2, _x3) -> OrtApi.SetEpDynamicOptions.invoke(fnSetEpDynamicOptions, _x0, _x1, _x2, _x3);
        MemorySegment fnSetSessionExecutionMode = OrtApi.SetSessionExecutionMode(memorySegment);
        this.SetSessionExecutionMode =
                (_x0, _x1) -> OrtApi.SetSessionExecutionMode.invoke(fnSetSessionExecutionMode, _x0, _x1);
        MemorySegment fnSetSessionGraphOptimizationLevel = OrtApi.SetSessionGraphOptimizationLevel(memorySegment);
        this.SetSessionGraphOptimizationLevel = (_x0, _x1) ->
                OrtApi.SetSessionGraphOptimizationLevel.invoke(fnSetSessionGraphOptimizationLevel, _x0, _x1);
        MemorySegment fnSetSessionLogId = OrtApi.SetSessionLogId(memorySegment);
        this.SetSessionLogId = (_x0, _x1) -> OrtApi.SetSessionLogId.invoke(fnSetSessionLogId, _x0, _x1);
        MemorySegment fnSetSessionLogSeverityLevel = OrtApi.SetSessionLogSeverityLevel(memorySegment);
        this.SetSessionLogSeverityLevel =
                (_x0, _x1) -> OrtApi.SetSessionLogSeverityLevel.invoke(fnSetSessionLogSeverityLevel, _x0, _x1);
        MemorySegment fnSetSessionLogVerbosityLevel = OrtApi.SetSessionLogVerbosityLevel(memorySegment);
        this.SetSessionLogVerbosityLevel =
                (_x0, _x1) -> OrtApi.SetSessionLogVerbosityLevel.invoke(fnSetSessionLogVerbosityLevel, _x0, _x1);
        MemorySegment fnSessionEndProfiling = OrtApi.SessionEndProfiling(memorySegment);
        this.SessionEndProfiling =
                (_x0, _x1, _x2) -> OrtApi.SessionEndProfiling.invoke(fnSessionEndProfiling, _x0, _x1, _x2);
        MemorySegment fnSessionGetInputCount = OrtApi.SessionGetInputCount(memorySegment);
        this.SessionGetInputCount = (_x0, _x1) -> OrtApi.SessionGetInputCount.invoke(fnSessionGetInputCount, _x0, _x1);
        MemorySegment fnSessionGetInputName = OrtApi.SessionGetInputName(memorySegment);
        this.SessionGetInputName =
                (_x0, _x1, _x2, _x3) -> OrtApi.SessionGetInputName.invoke(fnSessionGetInputName, _x0, _x1, _x2, _x3);
        MemorySegment fnSessionGetInputTypeInfo = OrtApi.SessionGetInputTypeInfo(memorySegment);
        this.SessionGetInputTypeInfo =
                (_x0, _x1, _x2) -> OrtApi.SessionGetInputTypeInfo.invoke(fnSessionGetInputTypeInfo, _x0, _x1, _x2);
        MemorySegment fnSessionGetModelMetadata = OrtApi.SessionGetModelMetadata(memorySegment);
        this.SessionGetModelMetadata =
                (_x0, _x1) -> OrtApi.SessionGetModelMetadata.invoke(fnSessionGetModelMetadata, _x0, _x1);
        MemorySegment fnSessionGetOutputCount = OrtApi.SessionGetOutputCount(memorySegment);
        this.SessionGetOutputCount =
                (_x0, _x1) -> OrtApi.SessionGetOutputCount.invoke(fnSessionGetOutputCount, _x0, _x1);
        MemorySegment fnSessionGetOutputName = OrtApi.SessionGetOutputName(memorySegment);
        this.SessionGetOutputName =
                (_x0, _x1, _x2, _x3) -> OrtApi.SessionGetOutputName.invoke(fnSessionGetOutputName, _x0, _x1, _x2, _x3);
        MemorySegment fnSessionGetOutputTypeInfo = OrtApi.SessionGetOutputTypeInfo(memorySegment);
        this.SessionGetOutputTypeInfo =
                (_x0, _x1, _x2) -> OrtApi.SessionGetOutputTypeInfo.invoke(fnSessionGetOutputTypeInfo, _x0, _x1, _x2);
        MemorySegment fnSessionGetOverridableInitializerCount =
                OrtApi.SessionGetOverridableInitializerCount(memorySegment);
        this.SessionGetOverridableInitializerCount = (_x0, _x1) ->
                OrtApi.SessionGetOverridableInitializerCount.invoke(fnSessionGetOverridableInitializerCount, _x0, _x1);
        MemorySegment fnSessionGetOverridableInitializerName =
                OrtApi.SessionGetOverridableInitializerName(memorySegment);
        this.SessionGetOverridableInitializerName =
                (_x0, _x1, _x2, _x3) -> OrtApi.SessionGetOverridableInitializerName.invoke(
                        fnSessionGetOverridableInitializerName, _x0, _x1, _x2, _x3);
        MemorySegment fnSessionGetOverridableInitializerTypeInfo =
                OrtApi.SessionGetOverridableInitializerTypeInfo(memorySegment);
        this.SessionGetOverridableInitializerTypeInfo =
                (_x0, _x1, _x2) -> OrtApi.SessionGetOverridableInitializerTypeInfo.invoke(
                        fnSessionGetOverridableInitializerTypeInfo, _x0, _x1, _x2);
        MemorySegment fnSessionGetProfilingStartTimeNs = OrtApi.SessionGetProfilingStartTimeNs(memorySegment);
        this.SessionGetProfilingStartTimeNs =
                (_x0, _x1) -> OrtApi.SessionGetProfilingStartTimeNs.invoke(fnSessionGetProfilingStartTimeNs, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider =
                OrtApi.SessionOptionsAppendExecutionProvider(memorySegment);
        this.SessionOptionsAppendExecutionProvider =
                (_x0, _x1, _x2, _x3, _x4) -> OrtApi.SessionOptionsAppendExecutionProvider.invoke(
                        fnSessionOptionsAppendExecutionProvider, _x0, _x1, _x2, _x3, _x4);
        MemorySegment fnSessionOptionsAppendExecutionProvider_CANN =
                OrtApi.SessionOptionsAppendExecutionProvider_CANN(memorySegment);
        this.SessionOptionsAppendExecutionProvider_CANN =
                (_x0, _x1) -> OrtApi.SessionOptionsAppendExecutionProvider_CANN.invoke(
                        fnSessionOptionsAppendExecutionProvider_CANN, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider_CUDA_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2(memorySegment);
        this.SessionOptionsAppendExecutionProvider_CUDA_V2 =
                (_x0, _x1) -> OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2.invoke(
                        fnSessionOptionsAppendExecutionProvider_CUDA_V2, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider_Dnnl =
                OrtApi.SessionOptionsAppendExecutionProvider_Dnnl(memorySegment);
        this.SessionOptionsAppendExecutionProvider_Dnnl =
                (_x0, _x1) -> OrtApi.SessionOptionsAppendExecutionProvider_Dnnl.invoke(
                        fnSessionOptionsAppendExecutionProvider_Dnnl, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider_MIGraphX =
                OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX(memorySegment);
        this.SessionOptionsAppendExecutionProvider_MIGraphX =
                (_x0, _x1) -> OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX.invoke(
                        fnSessionOptionsAppendExecutionProvider_MIGraphX, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider_OpenVINO_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2(memorySegment);
        this.SessionOptionsAppendExecutionProvider_OpenVINO_V2 =
                (_x0, _x1, _x2, _x3) -> OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2.invoke(
                        fnSessionOptionsAppendExecutionProvider_OpenVINO_V2, _x0, _x1, _x2, _x3);
        MemorySegment fnSessionOptionsAppendExecutionProvider_ROCM =
                OrtApi.SessionOptionsAppendExecutionProvider_ROCM(memorySegment);
        this.SessionOptionsAppendExecutionProvider_ROCM =
                (_x0, _x1) -> OrtApi.SessionOptionsAppendExecutionProvider_ROCM.invoke(
                        fnSessionOptionsAppendExecutionProvider_ROCM, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider_TensorRT_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2(memorySegment);
        this.SessionOptionsAppendExecutionProvider_TensorRT_V2 =
                (_x0, _x1) -> OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2.invoke(
                        fnSessionOptionsAppendExecutionProvider_TensorRT_V2, _x0, _x1);
        MemorySegment fnSessionOptionsAppendExecutionProvider_VitisAI =
                OrtApi.SessionOptionsAppendExecutionProvider_VitisAI(memorySegment);
        this.SessionOptionsAppendExecutionProvider_VitisAI =
                (_x0, _x1, _x2, _x3) -> OrtApi.SessionOptionsAppendExecutionProvider_VitisAI.invoke(
                        fnSessionOptionsAppendExecutionProvider_VitisAI, _x0, _x1, _x2, _x3);
        MemorySegment fnSynchronizeBoundInputs = OrtApi.SynchronizeBoundInputs(memorySegment);
        this.SynchronizeBoundInputs = (_x0) -> OrtApi.SynchronizeBoundInputs.invoke(fnSynchronizeBoundInputs, _x0);
        MemorySegment fnSynchronizeBoundOutputs = OrtApi.SynchronizeBoundOutputs(memorySegment);
        this.SynchronizeBoundOutputs = (_x0) -> OrtApi.SynchronizeBoundOutputs.invoke(fnSynchronizeBoundOutputs, _x0);
        MemorySegment fnUpdateCUDAProviderOptions = OrtApi.UpdateCUDAProviderOptions(memorySegment);
        this.UpdateCUDAProviderOptions = (_x0, _x1, _x2, _x3) ->
                OrtApi.UpdateCUDAProviderOptions.invoke(fnUpdateCUDAProviderOptions, _x0, _x1, _x2, _x3);
        MemorySegment fnUpdateDnnlProviderOptions = OrtApi.UpdateDnnlProviderOptions(memorySegment);
        this.UpdateDnnlProviderOptions = (_x0, _x1, _x2, _x3) ->
                OrtApi.UpdateDnnlProviderOptions.invoke(fnUpdateDnnlProviderOptions, _x0, _x1, _x2, _x3);
        MemorySegment fnUpdateTensorRTProviderOptions = OrtApi.UpdateTensorRTProviderOptions(memorySegment);
        this.UpdateTensorRTProviderOptions = (_x0, _x1, _x2, _x3) ->
                OrtApi.UpdateTensorRTProviderOptions.invoke(fnUpdateTensorRTProviderOptions, _x0, _x1, _x2, _x3);

        try (Arena session = Arena.ofConfined()) {
            Set<ExecutionProvider> providers = EnumSet.noneOf(ExecutionProvider.class);
            MemorySegment pointer = session.allocate(C_POINTER);
            MemorySegment countPointer = session.allocate(C_INT);
            checkStatus(GetAvailableProviders.apply(pointer, countPointer));
            int numProviders = countPointer.getAtIndex(C_INT, 0);
            MemorySegment providersArray =
                    pointer.getAtIndex(C_POINTER, 0).reinterpret(numProviders * C_POINTER.byteSize());
            try {
                for (int i = 0; i < numProviders; i++) {
                    MemorySegment providerAddress = providersArray.getAtIndex(C_POINTER, i);
                    String identifier = providerAddress.getString(0);
                    ExecutionProvider provider = ExecutionProvider.of(identifier);
                    if (provider == null) {
                        LOG.log(Level.WARNING, "Unknown available provider " + identifier);
                    } else if (!provider.isSupported()) {
                        LOG.log(
                                Level.WARNING,
                                "Provider " + provider + " is available, but not supported by this library");
                    } else {
                        providers.add(provider);
                    }
                }
            } finally {
                checkStatus(ReleaseAvailableProviders.apply(providersArray, numProviders));
            }
            this.providers = Collections.unmodifiableSet(providers);
            LOG.log(Level.DEBUG, "Available providers: " + providers);
        }
    }

    @Override
    public String getBuildString() {
        return GetBuildInfoString.apply().getString(0);
    }

    @Override
    public Environment.Builder newEnvironment() {
        return new EnvironmentImpl.Builder(this);
    }

    @Override
    public Set<ExecutionProvider> getAvailableProviders() {
        return providers;
    }

    void checkStatus(MemorySegment status) {
        try {
            if (MemorySegment.NULL.address() == status.address()) {
                return;
            }
            int code = GetErrorCode.apply(status);
            String message = GetErrorMessage.apply(status).getString(0);
            throw new OnnxRuntimeException(code, message);
        } finally {
            ReleaseStatus.apply(status);
        }
    }

    MemorySegment create(Arena arena, Function<MemorySegment, MemorySegment> constructor) {
        MemorySegment pointer = arena.allocate(C_POINTER);
        checkStatus(constructor.apply(pointer));
        return pointer.getAtIndex(C_POINTER, 0);
    }

    MemorySegment create(
            Arena arena, Function<MemorySegment, MemorySegment> constructor, Consumer<MemorySegment> cleanup) {
        return create(arena, constructor).reinterpret(C_POINTER.byteSize(), arena, cleanup);
    }

    int extractInt(Arena arena, Function<MemorySegment, MemorySegment> method) {
        MemorySegment pointer = arena.allocate(C_INT);
        checkStatus(method.apply(pointer));
        return pointer.getAtIndex(C_INT, 0);
    }

    long extractLong(Arena arena, Function<MemorySegment, MemorySegment> method) {
        MemorySegment pointer = arena.allocate(C_LONG);
        checkStatus(method.apply(pointer));
        return pointer.getAtIndex(C_LONG, 0);
    }
}
