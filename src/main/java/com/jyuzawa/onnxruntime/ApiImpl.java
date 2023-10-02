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
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.Function;

final class ApiImpl implements Api {

    private static final Logger LOG = System.getLogger(ApiImpl.class.getName());

    final AddRunConfigEntry AddRunConfigEntry;
    final AddSessionConfigEntry AddSessionConfigEntry;
    final AllocatorFree AllocatorFree;
    final CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo;
    final CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo;
    final CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo;
    final CreateAllocator CreateAllocator;
    final CreateAndRegisterAllocator CreateAndRegisterAllocator;
    final CreateArenaCfgV2 CreateArenaCfgV2;
    final CreateCpuMemoryInfo CreateCpuMemoryInfo;
    final CreateCUDAProviderOptions CreateCUDAProviderOptions;
    final CreateDnnlProviderOptions CreateDnnlProviderOptions;
    final CreateTensorRTProviderOptions CreateTensorRTProviderOptions;
    final CreateEnvWithCustomLogger CreateEnvWithCustomLogger;
    final CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools;
    final CreateRunOptions CreateRunOptions;
    final CreateSession CreateSession;
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
    final GetBuildInfoString GetBuildInfoString;
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
    final RegisterAllocator RegisterAllocator;
    final RegisterCustomOpsLibrary_V2 RegisterCustomOpsLibrary_V2;
    final ReleaseAllocator ReleaseAllocator;
    final ReleaseAvailableProviders ReleaseAvailableProviders;
    final ReleaseCUDAProviderOptions ReleaseCUDAProviderOptions;
    final ReleaseDnnlProviderOptions ReleaseDnnlProviderOptions;
    final ReleaseEnv ReleaseEnv;
    final ReleaseMemoryInfo ReleaseMemoryInfo;
    final ReleaseModelMetadata ReleaseModelMetadata;
    final ReleaseRunOptions ReleaseRunOptions;
    final ReleaseSession ReleaseSession;
    final ReleaseSessionOptions ReleaseSessionOptions;
    final ReleaseStatus ReleaseStatus;
    final ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions;
    final ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo;
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
    final SessionOptionsAppendExecutionProvider_Dnnl SessionOptionsAppendExecutionProvider_Dnnl;
    final SessionOptionsAppendExecutionProvider_MIGraphX SessionOptionsAppendExecutionProvider_MIGraphX;
    final SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO;
    final SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM;
    final SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2;
    final UpdateCUDAProviderOptions UpdateCUDAProviderOptions;
    final UpdateDnnlProviderOptions UpdateDnnlProviderOptions;
    final UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions;

    private final Set<ExecutionProvider> providers;

    ApiImpl(MemorySegment memorySegment) {
        MemorySession memorySession = MemorySession.global();
        this.AddRunConfigEntry = OrtApi.AddRunConfigEntry(memorySegment, memorySession);
        this.AddSessionConfigEntry = OrtApi.AddSessionConfigEntry(memorySegment, memorySession);
        this.AllocatorFree = OrtApi.AllocatorFree(memorySegment, memorySession);
        this.CastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfo(memorySegment, memorySession);
        this.CastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfo(memorySegment, memorySession);
        this.CastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfo(memorySegment, memorySession);
        this.CreateAllocator = OrtApi.CreateAllocator(memorySegment, memorySession);
        this.CreateAndRegisterAllocator = OrtApi.CreateAndRegisterAllocator(memorySegment, memorySession);
        this.CreateArenaCfgV2 = OrtApi.CreateArenaCfgV2(memorySegment, memorySession);
        this.CreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfo(memorySegment, memorySession);
        this.CreateCUDAProviderOptions = OrtApi.CreateCUDAProviderOptions(memorySegment, memorySession);
        this.CreateDnnlProviderOptions = OrtApi.CreateDnnlProviderOptions(memorySegment, memorySession);
        this.CreateTensorRTProviderOptions = OrtApi.CreateTensorRTProviderOptions(memorySegment, memorySession);
        this.CreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLogger(memorySegment, memorySession);
        this.CreateEnvWithCustomLoggerAndGlobalThreadPools =
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools(memorySegment, memorySession);
        this.CreateRunOptions = OrtApi.CreateRunOptions(memorySegment, memorySession);
        this.CreateSession = OrtApi.CreateSession(memorySegment, memorySession);
        this.CreateSessionFromArray = OrtApi.CreateSessionFromArray(memorySegment, memorySession);
        this.CreateSessionOptions = OrtApi.CreateSessionOptions(memorySegment, memorySession);
        this.CreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValue(memorySegment, memorySession);
        this.CreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValue(memorySegment, memorySession);
        this.CreateThreadingOptions = OrtApi.CreateThreadingOptions(memorySegment, memorySession);
        this.CreateValue = OrtApi.CreateValue(memorySegment, memorySession);
        this.DisableCpuMemArena = OrtApi.DisableCpuMemArena(memorySegment, memorySession);
        this.DisableMemPattern = OrtApi.DisableMemPattern(memorySegment, memorySession);
        this.DisablePerSessionThreads = OrtApi.DisablePerSessionThreads(memorySegment, memorySession);
        this.DisableProfiling = OrtApi.DisableProfiling(memorySegment, memorySession);
        this.DisableTelemetryEvents = OrtApi.DisableTelemetryEvents(memorySegment, memorySession);
        this.EnableTelemetryEvents = OrtApi.EnableTelemetryEvents(memorySegment, memorySession);
        this.EnableCpuMemArena = OrtApi.EnableCpuMemArena(memorySegment, memorySession);
        this.EnableMemPattern = OrtApi.EnableMemPattern(memorySegment, memorySession);
        this.EnableProfiling = OrtApi.EnableProfiling(memorySegment, memorySession);
        this.FillStringTensor = OrtApi.FillStringTensor(memorySegment, memorySession);
        this.GetAllocatorWithDefaultOptions = OrtApi.GetAllocatorWithDefaultOptions(memorySegment, memorySession);
        this.GetAvailableProviders = OrtApi.GetAvailableProviders(memorySegment, memorySession);
        this.GetBuildInfoString = OrtApi.GetBuildInfoString(memorySegment, memorySession);
        this.GetDimensions = OrtApi.GetDimensions(memorySegment, memorySession);
        this.GetDimensionsCount = OrtApi.GetDimensionsCount(memorySegment, memorySession);
        this.GetErrorCode = OrtApi.GetErrorCode(memorySegment, memorySession);
        this.GetErrorMessage = OrtApi.GetErrorMessage(memorySegment, memorySession);
        this.GetMapKeyType = OrtApi.GetMapKeyType(memorySegment, memorySession);
        this.GetMapValueType = OrtApi.GetMapValueType(memorySegment, memorySession);
        this.GetOnnxTypeFromTypeInfo = OrtApi.GetOnnxTypeFromTypeInfo(memorySegment, memorySession);
        this.GetSequenceElementType = OrtApi.GetSequenceElementType(memorySegment, memorySession);
        this.GetStringTensorElement = OrtApi.GetStringTensorElement(memorySegment, memorySession);
        this.GetStringTensorElementLength = OrtApi.GetStringTensorElementLength(memorySegment, memorySession);
        this.GetTensorElementType = OrtApi.GetTensorElementType(memorySegment, memorySession);
        this.GetTensorMutableData = OrtApi.GetTensorMutableData(memorySegment, memorySession);
        this.GetTensorShapeElementCount = OrtApi.GetTensorShapeElementCount(memorySegment, memorySession);
        this.GetTensorTypeAndShape = OrtApi.GetTensorTypeAndShape(memorySegment, memorySession);
        this.GetValue = OrtApi.GetValue(memorySegment, memorySession);
        this.GetValueCount = OrtApi.GetValueCount(memorySegment, memorySession);
        this.ModelMetadataGetCustomMetadataMapKeys =
                OrtApi.ModelMetadataGetCustomMetadataMapKeys(memorySegment, memorySession);
        this.ModelMetadataGetDescription = OrtApi.ModelMetadataGetDescription(memorySegment, memorySession);
        this.ModelMetadataGetDomain = OrtApi.ModelMetadataGetDomain(memorySegment, memorySession);
        this.ModelMetadataGetGraphDescription = OrtApi.ModelMetadataGetGraphDescription(memorySegment, memorySession);
        this.ModelMetadataGetGraphName = OrtApi.ModelMetadataGetGraphName(memorySegment, memorySession);
        this.ModelMetadataGetProducerName = OrtApi.ModelMetadataGetProducerName(memorySegment, memorySession);
        this.ModelMetadataGetVersion = OrtApi.ModelMetadataGetVersion(memorySegment, memorySession);
        this.ModelMetadataLookupCustomMetadataMap =
                OrtApi.ModelMetadataLookupCustomMetadataMap(memorySegment, memorySession);
        this.RegisterAllocator = OrtApi.RegisterAllocator(memorySegment, memorySession);
        this.RegisterCustomOpsLibrary_V2 = OrtApi.RegisterCustomOpsLibrary_V2(memorySegment, memorySession);
        this.ReleaseAllocator = OrtApi.ReleaseAllocator(memorySegment, memorySession);
        this.ReleaseAvailableProviders = OrtApi.ReleaseAvailableProviders(memorySegment, memorySession);
        this.ReleaseCUDAProviderOptions = OrtApi.ReleaseCUDAProviderOptions(memorySegment, memorySession);
        this.ReleaseDnnlProviderOptions = OrtApi.ReleaseDnnlProviderOptions(memorySegment, memorySession);
        this.ReleaseEnv = OrtApi.ReleaseEnv(memorySegment, memorySession);
        this.ReleaseMemoryInfo = OrtApi.ReleaseMemoryInfo(memorySegment, memorySession);
        this.ReleaseModelMetadata = OrtApi.ReleaseModelMetadata(memorySegment, memorySession);
        this.ReleaseRunOptions = OrtApi.ReleaseRunOptions(memorySegment, memorySession);
        this.ReleaseSession = OrtApi.ReleaseSession(memorySegment, memorySession);
        this.ReleaseSessionOptions = OrtApi.ReleaseSessionOptions(memorySegment, memorySession);
        this.ReleaseStatus = OrtApi.ReleaseStatus(memorySegment, memorySession);
        this.ReleaseTensorRTProviderOptions = OrtApi.ReleaseTensorRTProviderOptions(memorySegment, memorySession);
        this.ReleaseTensorTypeAndShapeInfo = OrtApi.ReleaseTensorTypeAndShapeInfo(memorySegment, memorySession);
        this.ReleaseThreadingOptions = OrtApi.ReleaseThreadingOptions(memorySegment, memorySession);
        this.ReleaseTypeInfo = OrtApi.ReleaseTypeInfo(memorySegment, memorySession);
        this.ReleaseValue = OrtApi.ReleaseValue(memorySegment, memorySession);
        this.Run = OrtApi.Run(memorySegment, memorySession);
        this.RunOptionsSetRunLogSeverityLevel = OrtApi.RunOptionsSetRunLogSeverityLevel(memorySegment, memorySession);
        this.RunOptionsSetRunLogVerbosityLevel = OrtApi.RunOptionsSetRunLogVerbosityLevel(memorySegment, memorySession);
        this.RunOptionsSetRunTag = OrtApi.RunOptionsSetRunTag(memorySegment, memorySession);
        this.RunOptionsSetTerminate = OrtApi.RunOptionsSetTerminate(memorySegment, memorySession);
        this.SetGlobalDenormalAsZero = OrtApi.SetGlobalDenormalAsZero(memorySegment, memorySession);
        this.SetGlobalIntraOpNumThreads = OrtApi.SetGlobalIntraOpNumThreads(memorySegment, memorySession);
        this.SetGlobalInterOpNumThreads = OrtApi.SetGlobalInterOpNumThreads(memorySegment, memorySession);
        this.SetGlobalSpinControl = OrtApi.SetGlobalSpinControl(memorySegment, memorySession);
        this.SetInterOpNumThreads = OrtApi.SetInterOpNumThreads(memorySegment, memorySession);
        this.SetIntraOpNumThreads = OrtApi.SetIntraOpNumThreads(memorySegment, memorySession);
        this.SetLanguageProjection = OrtApi.SetLanguageProjection(memorySegment, memorySession);
        this.SetOptimizedModelFilePath = OrtApi.SetOptimizedModelFilePath(memorySegment, memorySession);
        this.SetSessionExecutionMode = OrtApi.SetSessionExecutionMode(memorySegment, memorySession);
        this.SetSessionGraphOptimizationLevel = OrtApi.SetSessionGraphOptimizationLevel(memorySegment, memorySession);
        this.SetSessionLogId = OrtApi.SetSessionLogId(memorySegment, memorySession);
        this.SetSessionLogSeverityLevel = OrtApi.SetSessionLogSeverityLevel(memorySegment, memorySession);
        this.SetSessionLogVerbosityLevel = OrtApi.SetSessionLogVerbosityLevel(memorySegment, memorySession);
        this.SessionEndProfiling = OrtApi.SessionEndProfiling(memorySegment, memorySession);
        this.SessionGetInputCount = OrtApi.SessionGetInputCount(memorySegment, memorySession);
        this.SessionGetInputName = OrtApi.SessionGetInputName(memorySegment, memorySession);
        this.SessionGetInputTypeInfo = OrtApi.SessionGetInputTypeInfo(memorySegment, memorySession);
        this.SessionGetModelMetadata = OrtApi.SessionGetModelMetadata(memorySegment, memorySession);
        this.SessionGetOutputCount = OrtApi.SessionGetOutputCount(memorySegment, memorySession);
        this.SessionGetOutputName = OrtApi.SessionGetOutputName(memorySegment, memorySession);
        this.SessionGetOutputTypeInfo = OrtApi.SessionGetOutputTypeInfo(memorySegment, memorySession);
        this.SessionGetOverridableInitializerCount =
                OrtApi.SessionGetOverridableInitializerCount(memorySegment, memorySession);
        this.SessionGetOverridableInitializerName =
                OrtApi.SessionGetOverridableInitializerName(memorySegment, memorySession);
        this.SessionGetOverridableInitializerTypeInfo =
                OrtApi.SessionGetOverridableInitializerTypeInfo(memorySegment, memorySession);
        this.SessionGetProfilingStartTimeNs = OrtApi.SessionGetProfilingStartTimeNs(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider =
                OrtApi.SessionOptionsAppendExecutionProvider(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_CANN =
                OrtApi.SessionOptionsAppendExecutionProvider_CANN(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_CUDA_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_Dnnl =
                OrtApi.SessionOptionsAppendExecutionProvider_Dnnl(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_MIGraphX =
                OrtApi.SessionOptionsAppendExecutionProvider_MIGraphX(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_OpenVINO =
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_ROCM =
                OrtApi.SessionOptionsAppendExecutionProvider_ROCM(memorySegment, memorySession);
        this.SessionOptionsAppendExecutionProvider_TensorRT_V2 =
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2(memorySegment, memorySession);
        this.UpdateCUDAProviderOptions = OrtApi.UpdateCUDAProviderOptions(memorySegment, memorySession);
        this.UpdateDnnlProviderOptions = OrtApi.UpdateDnnlProviderOptions(memorySegment, memorySession);
        this.UpdateTensorRTProviderOptions = OrtApi.UpdateTensorRTProviderOptions(memorySegment, memorySession);

        try (MemorySession session = MemorySession.openConfined()) {
            Set<ExecutionProvider> providers = EnumSet.noneOf(ExecutionProvider.class);
            MemorySegment pointer = memorySession.allocate(C_POINTER);
            MemorySegment countPointer = memorySession.allocate(C_INT);
            checkStatus(GetAvailableProviders.apply(pointer.address(), countPointer.address()));
            int numProviders = countPointer.getAtIndex(C_INT, 0);
            MemorySegment providersArray = MemorySegment.ofAddress(
                    pointer.getAtIndex(C_POINTER, 0), numProviders * C_POINTER.byteSize(), session);
            for (int i = 0; i < numProviders; i++) {
                MemoryAddress providerAddress = providersArray.getAtIndex(C_POINTER, i);
                String identifier = providerAddress.getUtf8String(0);
                ExecutionProvider provider = ExecutionProvider.of(identifier);
                if (provider == null) {
                    LOG.log(Level.WARNING, "Unknown available provider " + identifier);
                } else if (!provider.isSupported()) {
                    LOG.log(Level.WARNING, "Provider " + provider + " is available, but not supported by this library");
                } else {
                    providers.add(provider);
                }
            }
            checkStatus(ReleaseAvailableProviders.apply(providersArray.address(), numProviders));
            this.providers = Collections.unmodifiableSet(providers);
            LOG.log(Level.DEBUG, "Available providers: " + providers);
        }
    }

    @Override
    public String getBuildString() {
        return GetBuildInfoString.apply().address().getUtf8String(0);
    }

    @Override
    public Environment.Builder newEnvironment() {
        return new EnvironmentImpl.Builder(this);
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
