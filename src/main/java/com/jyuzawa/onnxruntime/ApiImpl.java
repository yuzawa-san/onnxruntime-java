/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApi.*;

final class ApiImpl implements Api {

    private static final Logger LOG = System.getLogger(ApiImpl.class.getName());

    final AddRunConfigEntry AddRunConfigEntry;
    final AddSessionConfigEntry AddSessionConfigEntry;
    final AllocatorFree AllocatorFree;
    final CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo;
    final CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo;
    final CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo;
    final CreateCpuMemoryInfo CreateCpuMemoryInfo;
    final CreateCUDAProviderOptions CreateCUDAProviderOptions;
    final CreateTensorRTProviderOptions CreateTensorRTProviderOptions;
    final CreateEnvWithCustomLogger CreateEnvWithCustomLogger;
    final CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools;
    final CreateRunOptions CreateRunOptions;
    final CreateSessionFromArray CreateSessionFromArray;
    final CreateSessionOptions CreateSessionOptions;
    final CreateTensorAsOrtValue CreateTensorAsOrtValue;
    final CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue;
    final CreateThreadingOptions CreateThreadingOptions;
    final CreateValue CreateValue;
    final DisableCpuMemArena DisableCpuMemArena;
    final DisableMemPattern DisableMemPattern;
    final DisablePerSessionThreads DisablePerSessionThreads;
    final DisableProfiling DisableProfiling;
    final DisableTelemetryEvents DisableTelemetryEvents;
    final EnableCpuMemArena EnableCpuMemArena;
    final EnableMemPattern EnableMemPattern;
    final EnableProfiling EnableProfiling;
    final EnableTelemetryEvents EnableTelemetryEvents;
    final FillStringTensor FillStringTensor;
    final GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions;
    final GetAvailableProviders GetAvailableProviders;
    final GetDimensions GetDimensions;
    final GetDimensionsCount GetDimensionsCount;
    final GetErrorCode GetErrorCode;
    final GetErrorMessage GetErrorMessage;
    final GetMapKeyType GetMapKeyType;
    final GetMapValueType GetMapValueType;
    final GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo;
    final GetSequenceElementType GetSequenceElementType;
    final GetStringTensorElement GetStringTensorElement;
    final GetStringTensorElementLength GetStringTensorElementLength;
    final GetTensorElementType GetTensorElementType;
    final GetTensorMutableData GetTensorMutableData;
    final GetTensorShapeElementCount GetTensorShapeElementCount;
    final GetTensorTypeAndShape GetTensorTypeAndShape;
    final GetValue GetValue;
    final GetValueCount GetValueCount;
    final ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys;
    final ModelMetadataGetDescription ModelMetadataGetDescription;
    final ModelMetadataGetDomain ModelMetadataGetDomain;
    final ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription;
    final ModelMetadataGetGraphName ModelMetadataGetGraphName;
    final ModelMetadataGetProducerName ModelMetadataGetProducerName;
    final ModelMetadataGetVersion ModelMetadataGetVersion;
    final ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap;
    final ReleaseAvailableProviders ReleaseAvailableProviders;
    final ReleaseCUDAProviderOptions ReleaseCUDAProviderOptions;
    final ReleaseEnv ReleaseEnv;
    final ReleaseMemoryInfo ReleaseMemoryInfo;
    final ReleaseModelMetadata ReleaseModelMetadata;
    final ReleaseRunOptions ReleaseRunOptions;
    final ReleaseSession ReleaseSession;
    final ReleaseSessionOptions ReleaseSessionOptions;
    final ReleaseStatus ReleaseStatus;
    final ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions;
    final ReleaseThreadingOptions ReleaseThreadingOptions;
    final ReleaseTypeInfo ReleaseTypeInfo;
    final ReleaseValue ReleaseValue;
    final Run Run;
    final RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel;
    final RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel;
    final RunOptionsSetRunTag RunOptionsSetRunTag;
    final RunOptionsSetTerminate RunOptionsSetTerminate;
    final SetGlobalDenormalAsZero SetGlobalDenormalAsZero;
    final SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads;
    final SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads;
    final SetGlobalSpinControl SetGlobalSpinControl;
    final SetInterOpNumThreads SetInterOpNumThreads;
    final SetIntraOpNumThreads SetIntraOpNumThreads;
    final SetLanguageProjection SetLanguageProjection;
    final SetOptimizedModelFilePath SetOptimizedModelFilePath;
    final SetSessionExecutionMode SetSessionExecutionMode;
    final SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel;
    final SetSessionLogId SetSessionLogId;
    final SetSessionLogSeverityLevel SetSessionLogSeverityLevel;
    final SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel;
    final SessionEndProfiling SessionEndProfiling;
    final SessionGetInputCount SessionGetInputCount;
    final SessionGetInputName SessionGetInputName;
    final SessionGetInputTypeInfo SessionGetInputTypeInfo;
    final SessionGetModelMetadata SessionGetModelMetadata;
    final SessionGetOutputCount SessionGetOutputCount;
    final SessionGetOutputName SessionGetOutputName;
    final SessionGetOutputTypeInfo SessionGetOutputTypeInfo;
    final SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount;
    final SessionGetOverridableInitializerName SessionGetOverridableInitializerName;
    final SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo;
    final SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs;
    final SessionOptionsAppendExecutionProvider SessionOptionsAppendExecutionProvider;
    final SessionOptionsAppendExecutionProvider_CANN SessionOptionsAppendExecutionProvider_CANN;
    final SessionOptionsAppendExecutionProvider_CUDA_V2 SessionOptionsAppendExecutionProvider_CUDA_V2;
    final SessionOptionsAppendExecutionProvider_MIGraphX SessionOptionsAppendExecutionProvider_MIGraphX;
    final SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO;
    final SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM;
    final SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2;
    final UpdateCUDAProviderOptions UpdateCUDAProviderOptions;
    final UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions;

    private final Set<ExecutionProvider> providers;

    ApiImpl(MemorySegment segment) {
        MemorySession scope = MemorySession.global();
        this.AddRunConfigEntry = OrtApi.AddRunConfigEntry(segment, scope);
        this.AddSessionConfigEntry = OrtApi.AddSessionConfigEntry(segment, scope);
        this.AllocatorFree = OrtApi.AllocatorFree(segment, scope);
        this.CastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfo(segment, scope);
        this.CastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfo(segment, scope);
        this.CastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfo(segment, scope);
        this.CreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfo(segment, scope);
        this.CreateCUDAProviderOptions = OrtApi.CreateCUDAProviderOptions(segment, scope);
        this.CreateTensorRTProviderOptions = OrtApi.CreateTensorRTProviderOptions(segment, scope);
        this.CreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLogger(segment, scope);
        this.CreateEnvWithCustomLoggerAndGlobalThreadPools =
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools(segment, scope);
        this.CreateRunOptions = OrtApi.CreateRunOptions(segment, scope);
        this.CreateSessionFromArray = OrtApi.CreateSessionFromArray(segment, scope);
        this.CreateSessionOptions = OrtApi.CreateSessionOptions(segment, scope);
        this.CreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValue(segment, scope);
        this.CreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValue(segment, scope);
        this.CreateThreadingOptions = OrtApi.CreateThreadingOptions(segment, scope);
        this.CreateValue = OrtApi.CreateValue(segment, scope);
        this.DisableCpuMemArena = OrtApi.DisableCpuMemArena(segment, scope);
        this.DisableMemPattern = OrtApi.DisableMemPattern(segment, scope);
        this.DisablePerSessionThreads = OrtApi.DisablePerSessionThreads(segment, scope);
        this.DisableProfiling = OrtApi.DisableProfiling(segment, scope);
        this.DisableTelemetryEvents = OrtApi.DisableTelemetryEvents(segment, scope);
        this.EnableTelemetryEvents = OrtApi.EnableTelemetryEvents(segment, scope);
        this.EnableCpuMemArena = OrtApi.EnableCpuMemArena(segment, scope);
        this.EnableMemPattern = OrtApi.EnableMemPattern(segment, scope);
        this.EnableProfiling = OrtApi.EnableProfiling(segment, scope);
        this.FillStringTensor = OrtApi.FillStringTensor(segment, scope);
        this.GetAllocatorWithDefaultOptions = OrtApi.GetAllocatorWithDefaultOptions(segment, scope);
        this.GetAvailableProviders = OrtApi.GetAvailableProviders(segment, scope);
        this.GetDimensions = OrtApi.GetDimensions(segment, scope);
        this.GetDimensionsCount = OrtApi.GetDimensionsCount(segment, scope);
        this.GetErrorCode = OrtApi.GetErrorCode(segment, scope);
        this.GetErrorMessage = OrtApi.GetErrorMessage(segment, scope);
        this.GetMapKeyType = OrtApi.GetMapKeyType(segment, scope);
        this.GetMapValueType = OrtApi.GetMapValueType(segment, scope);
        this.GetOnnxTypeFromTypeInfo = OrtApi.GetOnnxTypeFromTypeInfo(segment, scope);
        this.GetSequenceElementType = OrtApi.GetSequenceElementType(segment, scope);
        this.GetStringTensorElement = OrtApi.GetStringTensorElement(segment, scope);
        this.GetStringTensorElementLength = OrtApi.GetStringTensorElementLength(segment, scope);
        this.GetTensorElementType = OrtApi.GetTensorElementType(segment, scope);
        this.GetTensorMutableData = OrtApi.GetTensorMutableData(segment, scope);
        this.GetTensorShapeElementCount = OrtApi.GetTensorShapeElementCount(segment, scope);
        this.GetTensorTypeAndShape = OrtApi.GetTensorTypeAndShape(segment, scope);
        this.GetValue = OrtApi.GetValue(segment, scope);
        this.GetValueCount = OrtApi.GetValueCount(segment, scope);
        this.ModelMetadataGetCustomMetadataMapKeys = OrtApi.ModelMetadataGetCustomMetadataMapKeys(segment, scope);
        this.ModelMetadataGetDescription = OrtApi.ModelMetadataGetDescription(segment, scope);
        this.ModelMetadataGetDomain = OrtApi.ModelMetadataGetDomain(segment, scope);
        this.ModelMetadataGetGraphDescription = OrtApi.ModelMetadataGetGraphDescription(segment, scope);
        this.ModelMetadataGetGraphName = OrtApi.ModelMetadataGetGraphName(segment, scope);
        this.ModelMetadataGetProducerName = OrtApi.ModelMetadataGetProducerName(segment, scope);
        this.ModelMetadataGetVersion = OrtApi.ModelMetadataGetVersion(segment, scope);
        this.ModelMetadataLookupCustomMetadataMap = OrtApi.ModelMetadataLookupCustomMetadataMap(segment, scope);
        this.ReleaseAvailableProviders = OrtApi.ReleaseAvailableProviders(segment, scope);
        this.ReleaseCUDAProviderOptions = OrtApi.ReleaseCUDAProviderOptions(segment, scope);
        this.ReleaseEnv = OrtApi.ReleaseEnv(segment, scope);
        this.ReleaseMemoryInfo = OrtApi.ReleaseMemoryInfo(segment, scope);
        this.ReleaseModelMetadata = OrtApi.ReleaseModelMetadata(segment, scope);
        this.ReleaseRunOptions = OrtApi.ReleaseRunOptions(segment, scope);
        this.ReleaseSession = OrtApi.ReleaseSession(segment, scope);
        this.ReleaseSessionOptions = OrtApi.ReleaseSessionOptions(segment, scope);
        this.ReleaseStatus = OrtApi.ReleaseStatus(segment, scope);
        this.ReleaseTensorRTProviderOptions = OrtApi.ReleaseTensorRTProviderOptions(segment, scope);
        this.ReleaseThreadingOptions = OrtApi.ReleaseThreadingOptions(segment, scope);
        this.ReleaseTypeInfo = OrtApi.ReleaseTypeInfo(segment, scope);
        this.ReleaseValue = OrtApi.ReleaseValue(segment, scope);
        this.Run = OrtApi.Run(segment, scope);
        this.RunOptionsSetRunLogSeverityLevel = OrtApi.RunOptionsSetRunLogSeverityLevel(segment, scope);
        this.RunOptionsSetRunLogVerbosityLevel = OrtApi.RunOptionsSetRunLogVerbosityLevel(segment, scope);
        this.RunOptionsSetRunTag = OrtApi.RunOptionsSetRunTag(segment, scope);
        this.RunOptionsSetTerminate = OrtApi.RunOptionsSetTerminate(segment, scope);
        this.SetGlobalDenormalAsZero = OrtApi.SetGlobalDenormalAsZero(segment, scope);
        this.SetGlobalIntraOpNumThreads = OrtApi.SetGlobalIntraOpNumThreads(segment, scope);
        this.SetGlobalInterOpNumThreads = OrtApi.SetGlobalInterOpNumThreads(segment, scope);
        this.SetGlobalSpinControl = OrtApi.SetGlobalSpinControl(segment, scope);
        this.SetInterOpNumThreads = OrtApi.SetInterOpNumThreads(segment, scope);
        this.SetIntraOpNumThreads = OrtApi.SetIntraOpNumThreads(segment, scope);
        this.SetLanguageProjection = OrtApi.SetLanguageProjection(segment, scope);
        this.SetOptimizedModelFilePath = OrtApi.SetOptimizedModelFilePath(segment, scope);
        this.SetSessionExecutionMode = OrtApi.SetSessionExecutionMode(segment, scope);
        this.SetSessionGraphOptimizationLevel = OrtApi.SetSessionGraphOptimizationLevel(segment, scope);
        this.SetSessionLogId = OrtApi.SetSessionLogId(segment, scope);
        this.SetSessionLogSeverityLevel = OrtApi.SetSessionLogSeverityLevel(segment, scope);
        this.SetSessionLogVerbosityLevel = OrtApi.SetSessionLogVerbosityLevel(segment, scope);
        this.SessionEndProfiling = OrtApi.SessionEndProfiling(segment, scope);
        this.SessionGetInputCount = OrtApi.SessionGetInputCount(segment, scope);
        this.SessionGetInputName = OrtApi.SessionGetInputName(segment, scope);
        this.SessionGetInputTypeInfo = OrtApi.SessionGetInputTypeInfo(segment, scope);
        this.SessionGetModelMetadata = OrtApi.SessionGetModelMetadata(segment, scope);
        this.SessionGetOutputCount = OrtApi.SessionGetOutputCount(segment, scope);
        this.SessionGetOutputName = OrtApi.SessionGetOutputName(segment, scope);
        this.SessionGetOutputTypeInfo = OrtApi.SessionGetOutputTypeInfo(segment, scope);
        this.SessionGetOverridableInitializerCount = OrtApi.SessionGetOverridableInitializerCount(segment, scope);
        this.SessionGetOverridableInitializerName = OrtApi.SessionGetOverridableInitializerName(segment, scope);
        this.SessionGetOverridableInitializerTypeInfo = OrtApi.SessionGetOverridableInitializerTypeInfo(segment, scope);
        this.SessionGetProfilingStartTimeNs = OrtApi.SessionGetProfilingStartTimeNs(segment, scope);
        this.SessionOptionsAppendExecutionProvider = OrtApi.SessionOptionsAppendExecutionProvider(segment, scope);
        this.SessionOptionsAppendExecutionProvider_CANN =
                OrtApi.SessionOptionsAppendExecutionProvider_CANN(segment, scope);
        this.SessionOptionsAppendExecutionProvider_CUDA_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2(segment, scope);
        this.SessionOptionsAppendExecutionProvider_MIGraphX =
                OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX(segment, scope);
        this.SessionOptionsAppendExecutionProvider_OpenVINO =
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO(segment, scope);
        this.SessionOptionsAppendExecutionProvider_ROCM =
                OrtApi.SessionOptionsAppendExecutionProvider_ROCM(segment, scope);
        this.SessionOptionsAppendExecutionProvider_TensorRT_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2(segment, scope);
        this.UpdateCUDAProviderOptions = OrtApi.UpdateCUDAProviderOptions(segment, scope);
        this.UpdateTensorRTProviderOptions = OrtApi.UpdateTensorRTProviderOptions(segment, scope);

        try (MemorySession session = MemorySession.openConfined()) {
            Set<ExecutionProvider> providers = EnumSet.noneOf(ExecutionProvider.class);
            MemorySegment pointer = scope.allocate(C_POINTER);
            MemorySegment countPointer = scope.allocate(C_INT);
            checkStatus(GetAvailableProviders.apply(pointer.address(), countPointer.address()));
            int numProviders = countPointer.getAtIndex(C_INT, 0);
            MemorySegment providersArray = MemorySegment.ofAddress(
                    pointer.getAtIndex(C_POINTER, 0), numProviders * C_POINTER.byteSize(), session);
            for (int i = 0; i < numProviders; i++) {
                MemoryAddress providerAddress = providersArray.getAtIndex(C_POINTER, i);
                String identifier = providerAddress.getUtf8String(0);
                ExecutionProvider provider = ExecutionProvider.of(identifier);
                if (provider == null) {
                    LOG.log(Level.WARNING, "Unknown available provider {}", identifier);
                } else if(!provider.isSupported()) {
                	LOG.log(Level.WARNING, "Provider {} is available, but not supported by this library", provider);
                }else {
                    providers.add(provider);
                }
            }
            checkStatus(ReleaseAvailableProviders.apply(providersArray.address(), numProviders));
            this.providers = Collections.unmodifiableSet(providers);
        }
    }

    @Override
    public Environment.Builder newEnvironment() {
        return new EnvironmentBuilderImpl(this);
    }

    @Override
    public Set<ExecutionProvider> getAvailableProviders() {
        return providers;
    }

    void checkStatus(Addressable rawAddress) {
        MemoryAddress status = rawAddress.address();
        if (MemoryAddress.NULL.equals(status)) {
            return;
        }
        int code = GetErrorCode.apply(status);
        String message = GetErrorMessage.apply(status).address().getUtf8String(0);
        ReleaseStatus.apply(status);
        throw new OnnxRuntimeException(code, message);
    }

    MemoryAddress create(SegmentAllocator allocator, Function<MemoryAddress, Addressable> constructor) {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        checkStatus(constructor.apply(pointer.address()));
        return pointer.getAtIndex(C_POINTER, 0);
    }

    int extractInt(SegmentAllocator allocator, Function<MemoryAddress, Addressable> method) {
        MemorySegment pointer = allocator.allocate(C_INT);
        checkStatus(method.apply(pointer.address()));
        return pointer.getAtIndex(C_INT, 0);
    }

    long extractLong(SegmentAllocator allocator, Function<MemoryAddress, Addressable> method) {
        MemorySegment pointer = allocator.allocate(C_LONG);
        checkStatus(method.apply(pointer.address()));
        return pointer.getAtIndex(C_LONG, 0);
    }
}
