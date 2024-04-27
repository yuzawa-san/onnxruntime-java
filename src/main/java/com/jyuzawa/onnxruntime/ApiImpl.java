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
import java.lang.foreign.SegmentAllocator;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;

final class ApiImpl implements Api {

    private static final Logger LOG = System.getLogger(ApiImpl.class.getName());

    final AddRunConfigEntry.Function AddRunConfigEntry;
    final AddSessionConfigEntry.Function AddSessionConfigEntry;
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
    final GetAllocatorWithDefaultOptions.Function GetAllocatorWithDefaultOptions;
    final GetAvailableProviders.Function GetAvailableProviders;
    final GetBuildInfoString.Function GetBuildInfoString;
    final GetDimensions.Function GetDimensions;
    final GetDimensionsCount.Function GetDimensionsCount;
    final GetErrorCode.Function GetErrorCode;
    final GetErrorMessage.Function GetErrorMessage;
    final GetMapKeyType.Function GetMapKeyType;
    final GetMapValueType.Function GetMapValueType;
    final GetOnnxTypeFromTypeInfo.Function GetOnnxTypeFromTypeInfo;
    final GetSequenceElementType.Function GetSequenceElementType;
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
    final RegisterAllocator.Function RegisterAllocator;
    final RegisterCustomOpsLibrary_V2.Function RegisterCustomOpsLibrary_V2;
    final ReleaseAllocator.Function ReleaseAllocator;
    final ReleaseAvailableProviders.Function ReleaseAvailableProviders;
    final ReleaseCUDAProviderOptions.Function ReleaseCUDAProviderOptions;
    final ReleaseDnnlProviderOptions.Function ReleaseDnnlProviderOptions;
    final ReleaseEnv.Function ReleaseEnv;
    final ReleaseIoBinding.Function ReleaseIoBinding;
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
    final RunOptionsSetTerminate.Function RunOptionsSetTerminate;
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
    final SynchronizeBoundInputs.Function SynchronizeBoundInputs;
    final SynchronizeBoundOutputs.Function SynchronizeBoundOutputs;
    final UpdateCUDAProviderOptions.Function UpdateCUDAProviderOptions;
    final UpdateDnnlProviderOptions.Function UpdateDnnlProviderOptions;
    final UpdateTensorRTProviderOptions.Function UpdateTensorRTProviderOptions;

    private final Set<ExecutionProvider> providers;

    ApiImpl(MemorySegment memorySegment) {
        this.AddRunConfigEntry = OrtApi.AddRunConfigEntryFunction(memorySegment);
        this.AddSessionConfigEntry = OrtApi.AddSessionConfigEntryFunction(memorySegment);
        this.AllocatorFree = OrtApi.AllocatorFreeFunction(memorySegment);
        this.BindInput = OrtApi.BindInputFunction(memorySegment);
        this.BindOutput = OrtApi.BindOutputFunction(memorySegment);
        this.CastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfoFunction(memorySegment);
        this.CastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfoFunction(memorySegment);
        this.CastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfoFunction(memorySegment);
        this.CreateAllocator = OrtApi.CreateAllocatorFunction(memorySegment);
        this.CreateAndRegisterAllocator = OrtApi.CreateAndRegisterAllocatorFunction(memorySegment);
        this.CreateArenaCfgV2 = OrtApi.CreateArenaCfgV2Function(memorySegment);
        this.CreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfoFunction(memorySegment);
        this.CreateCUDAProviderOptions = OrtApi.CreateCUDAProviderOptionsFunction(memorySegment);
        this.CreateDnnlProviderOptions = OrtApi.CreateDnnlProviderOptionsFunction(memorySegment);
        this.CreateTensorRTProviderOptions = OrtApi.CreateTensorRTProviderOptionsFunction(memorySegment);
        this.CreateIoBinding = OrtApi.CreateIoBindingFunction(memorySegment);
        this.CreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLoggerFunction(memorySegment);
        this.CreateEnvWithCustomLoggerAndGlobalThreadPools =
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPoolsFunction(memorySegment);
        this.CreateRunOptions = OrtApi.CreateRunOptionsFunction(memorySegment);
        this.CreateSession = OrtApi.CreateSessionFunction(memorySegment);
        this.CreateSessionFromArray = OrtApi.CreateSessionFromArrayFunction(memorySegment);
        this.CreateSessionOptions = OrtApi.CreateSessionOptionsFunction(memorySegment);
        this.CreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValueFunction(memorySegment);
        this.CreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValueFunction(memorySegment);
        this.CreateThreadingOptions = OrtApi.CreateThreadingOptionsFunction(memorySegment);
        this.CreateValue = OrtApi.CreateValueFunction(memorySegment);
        this.DisableCpuMemArena = OrtApi.DisableCpuMemArenaFunction(memorySegment);
        this.DisableMemPattern = OrtApi.DisableMemPatternFunction(memorySegment);
        this.DisablePerSessionThreads = OrtApi.DisablePerSessionThreadsFunction(memorySegment);
        this.DisableProfiling = OrtApi.DisableProfilingFunction(memorySegment);
        this.DisableTelemetryEvents = OrtApi.DisableTelemetryEventsFunction(memorySegment);
        this.EnableTelemetryEvents = OrtApi.EnableTelemetryEventsFunction(memorySegment);
        this.EnableCpuMemArena = OrtApi.EnableCpuMemArenaFunction(memorySegment);
        this.EnableMemPattern = OrtApi.EnableMemPatternFunction(memorySegment);
        this.EnableProfiling = OrtApi.EnableProfilingFunction(memorySegment);
        this.FillStringTensor = OrtApi.FillStringTensorFunction(memorySegment);
        this.GetAllocatorWithDefaultOptions = OrtApi.GetAllocatorWithDefaultOptionsFunction(memorySegment);
        this.GetAvailableProviders = OrtApi.GetAvailableProvidersFunction(memorySegment);
        this.GetBuildInfoString = OrtApi.GetBuildInfoStringFunction(memorySegment);
        this.GetDimensions = OrtApi.GetDimensionsFunction(memorySegment);
        this.GetDimensionsCount = OrtApi.GetDimensionsCountFunction(memorySegment);
        this.GetErrorCode = OrtApi.GetErrorCodeFunction(memorySegment);
        this.GetErrorMessage = OrtApi.GetErrorMessageFunction(memorySegment);
        this.GetMapKeyType = OrtApi.GetMapKeyTypeFunction(memorySegment);
        this.GetMapValueType = OrtApi.GetMapValueTypeFunction(memorySegment);
        this.GetOnnxTypeFromTypeInfo = OrtApi.GetOnnxTypeFromTypeInfoFunction(memorySegment);
        this.GetSequenceElementType = OrtApi.GetSequenceElementTypeFunction(memorySegment);
        this.GetStringTensorElement = OrtApi.GetStringTensorElementFunction(memorySegment);
        this.GetStringTensorElementLength = OrtApi.GetStringTensorElementLengthFunction(memorySegment);
        this.GetTensorElementType = OrtApi.GetTensorElementTypeFunction(memorySegment);
        this.GetTensorMutableData = OrtApi.GetTensorMutableDataFunction(memorySegment);
        this.GetTensorShapeElementCount = OrtApi.GetTensorShapeElementCountFunction(memorySegment);
        this.GetTensorTypeAndShape = OrtApi.GetTensorTypeAndShapeFunction(memorySegment);
        this.GetValue = OrtApi.GetValueFunction(memorySegment);
        this.GetValueCount = OrtApi.GetValueCountFunction(memorySegment);
        this.ModelMetadataGetCustomMetadataMapKeys =
                OrtApi.ModelMetadataGetCustomMetadataMapKeysFunction(memorySegment);
        this.ModelMetadataGetDescription = OrtApi.ModelMetadataGetDescriptionFunction(memorySegment);
        this.ModelMetadataGetDomain = OrtApi.ModelMetadataGetDomainFunction(memorySegment);
        this.ModelMetadataGetGraphDescription = OrtApi.ModelMetadataGetGraphDescriptionFunction(memorySegment);
        this.ModelMetadataGetGraphName = OrtApi.ModelMetadataGetGraphNameFunction(memorySegment);
        this.ModelMetadataGetProducerName = OrtApi.ModelMetadataGetProducerNameFunction(memorySegment);
        this.ModelMetadataGetVersion = OrtApi.ModelMetadataGetVersionFunction(memorySegment);
        this.ModelMetadataLookupCustomMetadataMap = OrtApi.ModelMetadataLookupCustomMetadataMapFunction(memorySegment);
        this.RegisterAllocator = OrtApi.RegisterAllocatorFunction(memorySegment);
        this.RegisterCustomOpsLibrary_V2 = OrtApi.RegisterCustomOpsLibrary_V2Function(memorySegment);
        this.ReleaseAllocator = OrtApi.ReleaseAllocatorFunction(memorySegment);
        this.ReleaseAvailableProviders = OrtApi.ReleaseAvailableProvidersFunction(memorySegment);
        this.ReleaseCUDAProviderOptions = OrtApi.ReleaseCUDAProviderOptionsFunction(memorySegment);
        this.ReleaseDnnlProviderOptions = OrtApi.ReleaseDnnlProviderOptionsFunction(memorySegment);
        this.ReleaseEnv = OrtApi.ReleaseEnvFunction(memorySegment);
        this.ReleaseIoBinding = OrtApi.ReleaseIoBindingFunction(memorySegment);
        this.ReleaseMemoryInfo = OrtApi.ReleaseMemoryInfoFunction(memorySegment);
        this.ReleaseModelMetadata = OrtApi.ReleaseModelMetadataFunction(memorySegment);
        this.ReleaseRunOptions = OrtApi.ReleaseRunOptionsFunction(memorySegment);
        this.ReleaseSession = OrtApi.ReleaseSessionFunction(memorySegment);
        this.ReleaseSessionOptions = OrtApi.ReleaseSessionOptionsFunction(memorySegment);
        this.ReleaseStatus = OrtApi.ReleaseStatusFunction(memorySegment);
        this.ReleaseTensorRTProviderOptions = OrtApi.ReleaseTensorRTProviderOptionsFunction(memorySegment);
        this.ReleaseTensorTypeAndShapeInfo = OrtApi.ReleaseTensorTypeAndShapeInfoFunction(memorySegment);
        this.ReleaseThreadingOptions = OrtApi.ReleaseThreadingOptionsFunction(memorySegment);
        this.ReleaseTypeInfo = OrtApi.ReleaseTypeInfoFunction(memorySegment);
        this.ReleaseValue = OrtApi.ReleaseValueFunction(memorySegment);
        this.Run = OrtApi.RunFunction(memorySegment);
        this.RunOptionsSetRunLogSeverityLevel = OrtApi.RunOptionsSetRunLogSeverityLevelFunction(memorySegment);
        this.RunOptionsSetRunLogVerbosityLevel = OrtApi.RunOptionsSetRunLogVerbosityLevelFunction(memorySegment);
        this.RunOptionsSetRunTag = OrtApi.RunOptionsSetRunTagFunction(memorySegment);
        this.RunOptionsSetTerminate = OrtApi.RunOptionsSetTerminateFunction(memorySegment);
        this.RunWithBinding = OrtApi.RunWithBindingFunction(memorySegment);
        this.SetGlobalDenormalAsZero = OrtApi.SetGlobalDenormalAsZeroFunction(memorySegment);
        this.SetGlobalIntraOpNumThreads = OrtApi.SetGlobalIntraOpNumThreadsFunction(memorySegment);
        this.SetGlobalInterOpNumThreads = OrtApi.SetGlobalInterOpNumThreadsFunction(memorySegment);
        this.SetGlobalSpinControl = OrtApi.SetGlobalSpinControlFunction(memorySegment);
        this.SetInterOpNumThreads = OrtApi.SetInterOpNumThreadsFunction(memorySegment);
        this.SetIntraOpNumThreads = OrtApi.SetIntraOpNumThreadsFunction(memorySegment);
        this.SetLanguageProjection = OrtApi.SetLanguageProjectionFunction(memorySegment);
        this.SetOptimizedModelFilePath = OrtApi.SetOptimizedModelFilePathFunction(memorySegment);
        this.SetDeterministicCompute = OrtApi.SetDeterministicComputeFunction(memorySegment);
        this.SetSessionExecutionMode = OrtApi.SetSessionExecutionModeFunction(memorySegment);
        this.SetSessionGraphOptimizationLevel = OrtApi.SetSessionGraphOptimizationLevelFunction(memorySegment);
        this.SetSessionLogId = OrtApi.SetSessionLogIdFunction(memorySegment);
        this.SetSessionLogSeverityLevel = OrtApi.SetSessionLogSeverityLevelFunction(memorySegment);
        this.SetSessionLogVerbosityLevel = OrtApi.SetSessionLogVerbosityLevelFunction(memorySegment);
        this.SessionEndProfiling = OrtApi.SessionEndProfilingFunction(memorySegment);
        this.SessionGetInputCount = OrtApi.SessionGetInputCountFunction(memorySegment);
        this.SessionGetInputName = OrtApi.SessionGetInputNameFunction(memorySegment);
        this.SessionGetInputTypeInfo = OrtApi.SessionGetInputTypeInfoFunction(memorySegment);
        this.SessionGetModelMetadata = OrtApi.SessionGetModelMetadataFunction(memorySegment);
        this.SessionGetOutputCount = OrtApi.SessionGetOutputCountFunction(memorySegment);
        this.SessionGetOutputName = OrtApi.SessionGetOutputNameFunction(memorySegment);
        this.SessionGetOutputTypeInfo = OrtApi.SessionGetOutputTypeInfoFunction(memorySegment);
        this.SessionGetOverridableInitializerCount =
                OrtApi.SessionGetOverridableInitializerCountFunction(memorySegment);
        this.SessionGetOverridableInitializerName = OrtApi.SessionGetOverridableInitializerNameFunction(memorySegment);
        this.SessionGetOverridableInitializerTypeInfo =
                OrtApi.SessionGetOverridableInitializerTypeInfoFunction(memorySegment);
        this.SessionGetProfilingStartTimeNs = OrtApi.SessionGetProfilingStartTimeNsFunction(memorySegment);
        this.SessionOptionsAppendExecutionProvider =
                OrtApi.SessionOptionsAppendExecutionProviderFunction(memorySegment);
        this.SessionOptionsAppendExecutionProvider_CANN =
                OrtApi.SessionOptionsAppendExecutionProvider_CANNFunction(memorySegment);
        this.SessionOptionsAppendExecutionProvider_CUDA_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2Function(memorySegment);
        this.SessionOptionsAppendExecutionProvider_Dnnl =
                OrtApi.SessionOptionsAppendExecutionProvider_DnnlFunction(memorySegment);
        this.SessionOptionsAppendExecutionProvider_MIGraphX =
                OrtApi.SessionOptionsAppendExecutionProvider_MIGraphXFunction(memorySegment);
        this.SessionOptionsAppendExecutionProvider_OpenVINO_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO_V2Function(memorySegment);
        this.SessionOptionsAppendExecutionProvider_ROCM =
                OrtApi.SessionOptionsAppendExecutionProvider_ROCMFunction(memorySegment);
        this.SessionOptionsAppendExecutionProvider_TensorRT_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2Function(memorySegment);
        this.SynchronizeBoundInputs = OrtApi.SynchronizeBoundInputsFunction(memorySegment);
        this.SynchronizeBoundOutputs = OrtApi.SynchronizeBoundOutputsFunction(memorySegment);
        this.UpdateCUDAProviderOptions = OrtApi.UpdateCUDAProviderOptionsFunction(memorySegment);
        this.UpdateDnnlProviderOptions = OrtApi.UpdateDnnlProviderOptionsFunction(memorySegment);
        this.UpdateTensorRTProviderOptions = OrtApi.UpdateTensorRTProviderOptionsFunction(memorySegment);

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

    MemorySegment create(SegmentAllocator allocator, Function<MemorySegment, MemorySegment> constructor) {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        checkStatus(constructor.apply(pointer));
        return pointer.getAtIndex(C_POINTER, 0);
    }

    int extractInt(SegmentAllocator allocator, Function<MemorySegment, MemorySegment> method) {
        MemorySegment pointer = allocator.allocate(C_INT);
        checkStatus(method.apply(pointer));
        return pointer.getAtIndex(C_INT, 0);
    }

    long extractLong(SegmentAllocator allocator, Function<MemorySegment, MemorySegment> method) {
        MemorySegment pointer = allocator.allocate(C_LONG);
        checkStatus(method.apply(pointer));
        return pointer.getAtIndex(C_LONG, 0);
    }
}
