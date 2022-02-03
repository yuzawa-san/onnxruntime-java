package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime.extern.OrtApi.*;
import static jdk.incubator.foreign.CLinker.C_INT;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toJavaString;

import com.jyuzawa.onnxruntime.extern.OrtApi;
import java.util.function.Function;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SegmentAllocator;

final class ApiImpl implements Api {

  private final MemorySegment segment;
  final CreateStatus CreateStatus;
  final GetErrorCode GetErrorCode;
  final GetErrorMessage GetErrorMessage;
  final CreateEnv CreateEnv;
  final CreateEnvWithCustomLogger CreateEnvWithCustomLogger;
  final EnableTelemetryEvents EnableTelemetryEvents;
  final DisableTelemetryEvents DisableTelemetryEvents;
  final CreateSession CreateSession;
  final CreateSessionFromArray CreateSessionFromArray;
  final Run Run;
  final CreateSessionOptions CreateSessionOptions;
  final SetOptimizedModelFilePath SetOptimizedModelFilePath;
  final CloneSessionOptions CloneSessionOptions;
  final SetSessionExecutionMode SetSessionExecutionMode;
  final EnableProfiling EnableProfiling;
  final DisableProfiling DisableProfiling;
  final EnableMemPattern EnableMemPattern;
  final DisableMemPattern DisableMemPattern;
  final EnableCpuMemArena EnableCpuMemArena;
  final DisableCpuMemArena DisableCpuMemArena;
  final SetSessionLogId SetSessionLogId;
  final SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel;
  final SetSessionLogSeverityLevel SetSessionLogSeverityLevel;
  final SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel;
  final SetIntraOpNumThreads SetIntraOpNumThreads;
  final SetInterOpNumThreads SetInterOpNumThreads;
  final CreateCustomOpDomain CreateCustomOpDomain;
  final CustomOpDomain_Add CustomOpDomain_Add;
  final AddCustomOpDomain AddCustomOpDomain;
  final RegisterCustomOpsLibrary RegisterCustomOpsLibrary;
  final SessionGetInputCount SessionGetInputCount;
  final SessionGetOutputCount SessionGetOutputCount;
  final SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount;
  final SessionGetInputTypeInfo SessionGetInputTypeInfo;
  final SessionGetOutputTypeInfo SessionGetOutputTypeInfo;
  final SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo;
  final SessionGetInputName SessionGetInputName;
  final SessionGetOutputName SessionGetOutputName;
  final SessionGetOverridableInitializerName SessionGetOverridableInitializerName;
  final CreateRunOptions CreateRunOptions;
  final RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel;
  final RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel;
  final RunOptionsSetRunTag RunOptionsSetRunTag;
  final RunOptionsGetRunLogVerbosityLevel RunOptionsGetRunLogVerbosityLevel;
  final RunOptionsGetRunLogSeverityLevel RunOptionsGetRunLogSeverityLevel;
  final RunOptionsGetRunTag RunOptionsGetRunTag;
  final RunOptionsSetTerminate RunOptionsSetTerminate;
  final RunOptionsUnsetTerminate RunOptionsUnsetTerminate;
  final CreateTensorAsOrtValue CreateTensorAsOrtValue;
  final CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue;
  final IsTensor IsTensor;
  final GetTensorMutableData GetTensorMutableData;
  final FillStringTensor FillStringTensor;
  final GetStringTensorDataLength GetStringTensorDataLength;
  final GetStringTensorContent GetStringTensorContent;
  final CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo;
  final GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo;
  final CreateTensorTypeAndShapeInfo CreateTensorTypeAndShapeInfo;
  final SetTensorElementType SetTensorElementType;
  final SetDimensions SetDimensions;
  final GetTensorElementType GetTensorElementType;
  final GetDimensionsCount GetDimensionsCount;
  final GetDimensions GetDimensions;
  final GetSymbolicDimensions GetSymbolicDimensions;
  final GetTensorShapeElementCount GetTensorShapeElementCount;
  final GetTensorTypeAndShape GetTensorTypeAndShape;
  final GetTypeInfo GetTypeInfo;
  final GetValueType GetValueType;
  final CreateMemoryInfo CreateMemoryInfo;
  final CreateCpuMemoryInfo CreateCpuMemoryInfo;
  final CompareMemoryInfo CompareMemoryInfo;
  final MemoryInfoGetName MemoryInfoGetName;
  final MemoryInfoGetId MemoryInfoGetId;
  final MemoryInfoGetMemType MemoryInfoGetMemType;
  final MemoryInfoGetType MemoryInfoGetType;
  final AllocatorAlloc AllocatorAlloc;
  final AllocatorFree AllocatorFree;
  final AllocatorGetInfo AllocatorGetInfo;
  final GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions;
  final AddFreeDimensionOverride AddFreeDimensionOverride;
  final GetValue GetValue;
  final GetValueCount GetValueCount;
  final CreateValue CreateValue;
  final CreateOpaqueValue CreateOpaqueValue;
  final GetOpaqueValue GetOpaqueValue;
  final KernelInfoGetAttribute_float KernelInfoGetAttribute_float;
  final KernelInfoGetAttribute_int64 KernelInfoGetAttribute_int64;
  final KernelInfoGetAttribute_string KernelInfoGetAttribute_string;
  final KernelContext_GetInputCount KernelContext_GetInputCount;
  final KernelContext_GetOutputCount KernelContext_GetOutputCount;
  final KernelContext_GetInput KernelContext_GetInput;
  final KernelContext_GetOutput KernelContext_GetOutput;
  final ReleaseEnv ReleaseEnv;
  final ReleaseStatus ReleaseStatus;
  final ReleaseMemoryInfo ReleaseMemoryInfo;
  final ReleaseSession ReleaseSession;
  final ReleaseValue ReleaseValue;
  final ReleaseRunOptions ReleaseRunOptions;
  final ReleaseTypeInfo ReleaseTypeInfo;
  final ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo;
  final ReleaseSessionOptions ReleaseSessionOptions;
  final ReleaseCustomOpDomain ReleaseCustomOpDomain;
  final GetDenotationFromTypeInfo GetDenotationFromTypeInfo;
  final CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo;
  final CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo;
  final GetMapKeyType GetMapKeyType;
  final GetMapValueType GetMapValueType;
  final GetSequenceElementType GetSequenceElementType;
  final ReleaseMapTypeInfo ReleaseMapTypeInfo;
  final ReleaseSequenceTypeInfo ReleaseSequenceTypeInfo;
  final SessionEndProfiling SessionEndProfiling;
  final SessionGetModelMetadata SessionGetModelMetadata;
  final ModelMetadataGetProducerName ModelMetadataGetProducerName;
  final ModelMetadataGetGraphName ModelMetadataGetGraphName;
  final ModelMetadataGetDomain ModelMetadataGetDomain;
  final ModelMetadataGetDescription ModelMetadataGetDescription;
  final ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap;
  final ModelMetadataGetVersion ModelMetadataGetVersion;
  final ReleaseModelMetadata ReleaseModelMetadata;
  final CreateEnvWithGlobalThreadPools CreateEnvWithGlobalThreadPools;
  final DisablePerSessionThreads DisablePerSessionThreads;
  final CreateThreadingOptions CreateThreadingOptions;
  final ReleaseThreadingOptions ReleaseThreadingOptions;
  final ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys;
  final AddFreeDimensionOverrideByName AddFreeDimensionOverrideByName;
  final GetAvailableProviders GetAvailableProviders;
  final ReleaseAvailableProviders ReleaseAvailableProviders;
  final GetStringTensorElementLength GetStringTensorElementLength;
  final GetStringTensorElement GetStringTensorElement;
  final FillStringTensorElement FillStringTensorElement;
  final AddSessionConfigEntry AddSessionConfigEntry;
  final CreateAllocator CreateAllocator;
  final ReleaseAllocator ReleaseAllocator;
  final RunWithBinding RunWithBinding;
  final CreateIoBinding CreateIoBinding;
  final ReleaseIoBinding ReleaseIoBinding;
  final BindInput BindInput;
  final BindOutput BindOutput;
  final BindOutputToDevice BindOutputToDevice;
  final GetBoundOutputNames GetBoundOutputNames;
  final GetBoundOutputValues GetBoundOutputValues;
  final ClearBoundInputs ClearBoundInputs;
  final ClearBoundOutputs ClearBoundOutputs;
  final TensorAt TensorAt;
  final CreateAndRegisterAllocator CreateAndRegisterAllocator;
  final SetLanguageProjection SetLanguageProjection;
  final SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs;
  final SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads;
  final SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads;
  final SetGlobalSpinControl SetGlobalSpinControl;
  final AddInitializer AddInitializer;
  final CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools;
  final SessionOptionsAppendExecutionProvider_CUDA SessionOptionsAppendExecutionProvider_CUDA;
  final SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM;
  final SessionOptionsAppendExecutionProvider_OpenVINO
      SessionOptionsAppendExecutionProvider_OpenVINO;
  final SetGlobalDenormalAsZero SetGlobalDenormalAsZero;
  final CreateArenaCfg CreateArenaCfg;
  final ReleaseArenaCfg ReleaseArenaCfg;
  final ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription;
  final SessionOptionsAppendExecutionProvider_TensorRT
      SessionOptionsAppendExecutionProvider_TensorRT;
  final SetCurrentGpuDeviceId SetCurrentGpuDeviceId;
  final GetCurrentGpuDeviceId GetCurrentGpuDeviceId;
  final KernelInfoGetAttributeArray_float KernelInfoGetAttributeArray_float;
  final KernelInfoGetAttributeArray_int64 KernelInfoGetAttributeArray_int64;
  final CreateArenaCfgV2 CreateArenaCfgV2;
  final AddRunConfigEntry AddRunConfigEntry;
  final CreatePrepackedWeightsContainer CreatePrepackedWeightsContainer;
  final ReleasePrepackedWeightsContainer ReleasePrepackedWeightsContainer;
  final CreateSessionWithPrepackedWeightsContainer CreateSessionWithPrepackedWeightsContainer;
  final CreateSessionFromArrayWithPrepackedWeightsContainer
      CreateSessionFromArrayWithPrepackedWeightsContainer;
  final SessionOptionsAppendExecutionProvider_TensorRT_V2
      SessionOptionsAppendExecutionProvider_TensorRT_V2;
  final CreateTensorRTProviderOptions CreateTensorRTProviderOptions;
  final UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions;
  final GetTensorRTProviderOptionsAsString GetTensorRTProviderOptionsAsString;
  final ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions;
  final EnableOrtCustomOps EnableOrtCustomOps;
  final RegisterAllocator RegisterAllocator;
  final UnregisterAllocator UnregisterAllocator;
  final IsSparseTensor IsSparseTensor;
  final CreateSparseTensorAsOrtValue CreateSparseTensorAsOrtValue;
  final FillSparseTensorCoo FillSparseTensorCoo;
  final FillSparseTensorCsr FillSparseTensorCsr;
  final FillSparseTensorBlockSparse FillSparseTensorBlockSparse;
  final CreateSparseTensorWithValuesAsOrtValue CreateSparseTensorWithValuesAsOrtValue;
  final UseCooIndices UseCooIndices;
  final UseCsrIndices UseCsrIndices;
  final UseBlockSparseIndices UseBlockSparseIndices;
  final GetSparseTensorFormat GetSparseTensorFormat;
  final GetSparseTensorValuesTypeAndShape GetSparseTensorValuesTypeAndShape;
  final GetSparseTensorValues GetSparseTensorValues;
  final GetSparseTensorIndicesTypeShape GetSparseTensorIndicesTypeShape;
  final GetSparseTensorIndices GetSparseTensorIndices;
  final HasValue HasValue;
  final KernelContext_GetGPUComputeStream KernelContext_GetGPUComputeStream;
  final GetTensorMemoryInfo GetTensorMemoryInfo;
  final GetExecutionProviderApi GetExecutionProviderApi;
  final SessionOptionsSetCustomCreateThreadFn SessionOptionsSetCustomCreateThreadFn;
  final SessionOptionsSetCustomThreadCreationOptions SessionOptionsSetCustomThreadCreationOptions;
  final SessionOptionsSetCustomJoinThreadFn SessionOptionsSetCustomJoinThreadFn;
  final SetGlobalCustomCreateThreadFn SetGlobalCustomCreateThreadFn;
  final SetGlobalCustomThreadCreationOptions SetGlobalCustomThreadCreationOptions;
  final SetGlobalCustomJoinThreadFn SetGlobalCustomJoinThreadFn;
  final SynchronizeBoundInputs SynchronizeBoundInputs;
  final SynchronizeBoundOutputs SynchronizeBoundOutputs;

  ApiImpl(MemorySegment segment) {
    this.segment = segment;
    this.CreateStatus = OrtApi.CreateStatus(segment);
    this.GetErrorCode = OrtApi.GetErrorCode(segment);
    this.GetErrorMessage = OrtApi.GetErrorMessage(segment);
    this.CreateEnv = OrtApi.CreateEnv(segment);
    this.CreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLogger(segment);
    this.EnableTelemetryEvents = OrtApi.EnableTelemetryEvents(segment);
    this.DisableTelemetryEvents = OrtApi.DisableTelemetryEvents(segment);
    this.CreateSession = OrtApi.CreateSession(segment);
    this.CreateSessionFromArray = OrtApi.CreateSessionFromArray(segment);
    this.Run = OrtApi.Run(segment);
    this.CreateSessionOptions = OrtApi.CreateSessionOptions(segment);
    this.SetOptimizedModelFilePath = OrtApi.SetOptimizedModelFilePath(segment);
    this.CloneSessionOptions = OrtApi.CloneSessionOptions(segment);
    this.SetSessionExecutionMode = OrtApi.SetSessionExecutionMode(segment);
    this.EnableProfiling = OrtApi.EnableProfiling(segment);
    this.DisableProfiling = OrtApi.DisableProfiling(segment);
    this.EnableMemPattern = OrtApi.EnableMemPattern(segment);
    this.DisableMemPattern = OrtApi.DisableMemPattern(segment);
    this.EnableCpuMemArena = OrtApi.EnableCpuMemArena(segment);
    this.DisableCpuMemArena = OrtApi.DisableCpuMemArena(segment);
    this.SetSessionLogId = OrtApi.SetSessionLogId(segment);
    this.SetSessionLogVerbosityLevel = OrtApi.SetSessionLogVerbosityLevel(segment);
    this.SetSessionLogSeverityLevel = OrtApi.SetSessionLogSeverityLevel(segment);
    this.SetSessionGraphOptimizationLevel = OrtApi.SetSessionGraphOptimizationLevel(segment);
    this.SetIntraOpNumThreads = OrtApi.SetIntraOpNumThreads(segment);
    this.SetInterOpNumThreads = OrtApi.SetInterOpNumThreads(segment);
    this.CreateCustomOpDomain = OrtApi.CreateCustomOpDomain(segment);
    this.CustomOpDomain_Add = OrtApi.CustomOpDomain_Add(segment);
    this.AddCustomOpDomain = OrtApi.AddCustomOpDomain(segment);
    this.RegisterCustomOpsLibrary = OrtApi.RegisterCustomOpsLibrary(segment);
    this.SessionGetInputCount = OrtApi.SessionGetInputCount(segment);
    this.SessionGetOutputCount = OrtApi.SessionGetOutputCount(segment);
    this.SessionGetOverridableInitializerCount =
        OrtApi.SessionGetOverridableInitializerCount(segment);
    this.SessionGetInputTypeInfo = OrtApi.SessionGetInputTypeInfo(segment);
    this.SessionGetOutputTypeInfo = OrtApi.SessionGetOutputTypeInfo(segment);
    this.SessionGetOverridableInitializerTypeInfo =
        OrtApi.SessionGetOverridableInitializerTypeInfo(segment);
    this.SessionGetInputName = OrtApi.SessionGetInputName(segment);
    this.SessionGetOutputName = OrtApi.SessionGetOutputName(segment);
    this.SessionGetOverridableInitializerName =
        OrtApi.SessionGetOverridableInitializerName(segment);
    this.CreateRunOptions = OrtApi.CreateRunOptions(segment);
    this.RunOptionsSetRunLogVerbosityLevel = OrtApi.RunOptionsSetRunLogVerbosityLevel(segment);
    this.RunOptionsSetRunLogSeverityLevel = OrtApi.RunOptionsSetRunLogSeverityLevel(segment);
    this.RunOptionsSetRunTag = OrtApi.RunOptionsSetRunTag(segment);
    this.RunOptionsGetRunLogVerbosityLevel = OrtApi.RunOptionsGetRunLogVerbosityLevel(segment);
    this.RunOptionsGetRunLogSeverityLevel = OrtApi.RunOptionsGetRunLogSeverityLevel(segment);
    this.RunOptionsGetRunTag = OrtApi.RunOptionsGetRunTag(segment);
    this.RunOptionsSetTerminate = OrtApi.RunOptionsSetTerminate(segment);
    this.RunOptionsUnsetTerminate = OrtApi.RunOptionsUnsetTerminate(segment);
    this.CreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValue(segment);
    this.CreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValue(segment);
    this.IsTensor = OrtApi.IsTensor(segment);
    this.GetTensorMutableData = OrtApi.GetTensorMutableData(segment);
    this.FillStringTensor = OrtApi.FillStringTensor(segment);
    this.GetStringTensorDataLength = OrtApi.GetStringTensorDataLength(segment);
    this.GetStringTensorContent = OrtApi.GetStringTensorContent(segment);
    this.CastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfo(segment);
    this.GetOnnxTypeFromTypeInfo = OrtApi.GetOnnxTypeFromTypeInfo(segment);
    this.CreateTensorTypeAndShapeInfo = OrtApi.CreateTensorTypeAndShapeInfo(segment);
    this.SetTensorElementType = OrtApi.SetTensorElementType(segment);
    this.SetDimensions = OrtApi.SetDimensions(segment);
    this.GetTensorElementType = OrtApi.GetTensorElementType(segment);
    this.GetDimensionsCount = OrtApi.GetDimensionsCount(segment);
    this.GetDimensions = OrtApi.GetDimensions(segment);
    this.GetSymbolicDimensions = OrtApi.GetSymbolicDimensions(segment);
    this.GetTensorShapeElementCount = OrtApi.GetTensorShapeElementCount(segment);
    this.GetTensorTypeAndShape = OrtApi.GetTensorTypeAndShape(segment);
    this.GetTypeInfo = OrtApi.GetTypeInfo(segment);
    this.GetValueType = OrtApi.GetValueType(segment);
    this.CreateMemoryInfo = OrtApi.CreateMemoryInfo(segment);
    this.CreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfo(segment);
    this.CompareMemoryInfo = OrtApi.CompareMemoryInfo(segment);
    this.MemoryInfoGetName = OrtApi.MemoryInfoGetName(segment);
    this.MemoryInfoGetId = OrtApi.MemoryInfoGetId(segment);
    this.MemoryInfoGetMemType = OrtApi.MemoryInfoGetMemType(segment);
    this.MemoryInfoGetType = OrtApi.MemoryInfoGetType(segment);
    this.AllocatorAlloc = OrtApi.AllocatorAlloc(segment);
    this.AllocatorFree = OrtApi.AllocatorFree(segment);
    this.AllocatorGetInfo = OrtApi.AllocatorGetInfo(segment);
    this.GetAllocatorWithDefaultOptions = OrtApi.GetAllocatorWithDefaultOptions(segment);
    this.AddFreeDimensionOverride = OrtApi.AddFreeDimensionOverride(segment);
    this.GetValue = OrtApi.GetValue(segment);
    this.GetValueCount = OrtApi.GetValueCount(segment);
    this.CreateValue = OrtApi.CreateValue(segment);
    this.CreateOpaqueValue = OrtApi.CreateOpaqueValue(segment);
    this.GetOpaqueValue = OrtApi.GetOpaqueValue(segment);
    this.KernelInfoGetAttribute_float = OrtApi.KernelInfoGetAttribute_float(segment);
    this.KernelInfoGetAttribute_int64 = OrtApi.KernelInfoGetAttribute_int64(segment);
    this.KernelInfoGetAttribute_string = OrtApi.KernelInfoGetAttribute_string(segment);
    this.KernelContext_GetInputCount = OrtApi.KernelContext_GetInputCount(segment);
    this.KernelContext_GetOutputCount = OrtApi.KernelContext_GetOutputCount(segment);
    this.KernelContext_GetInput = OrtApi.KernelContext_GetInput(segment);
    this.KernelContext_GetOutput = OrtApi.KernelContext_GetOutput(segment);
    this.ReleaseEnv = OrtApi.ReleaseEnv(segment);
    this.ReleaseStatus = OrtApi.ReleaseStatus(segment);
    this.ReleaseMemoryInfo = OrtApi.ReleaseMemoryInfo(segment);
    this.ReleaseSession = OrtApi.ReleaseSession(segment);
    this.ReleaseValue = OrtApi.ReleaseValue(segment);
    this.ReleaseRunOptions = OrtApi.ReleaseRunOptions(segment);
    this.ReleaseTypeInfo = OrtApi.ReleaseTypeInfo(segment);
    this.ReleaseTensorTypeAndShapeInfo = OrtApi.ReleaseTensorTypeAndShapeInfo(segment);
    this.ReleaseSessionOptions = OrtApi.ReleaseSessionOptions(segment);
    this.ReleaseCustomOpDomain = OrtApi.ReleaseCustomOpDomain(segment);
    this.GetDenotationFromTypeInfo = OrtApi.GetDenotationFromTypeInfo(segment);
    this.CastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfo(segment);
    this.CastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfo(segment);
    this.GetMapKeyType = OrtApi.GetMapKeyType(segment);
    this.GetMapValueType = OrtApi.GetMapValueType(segment);
    this.GetSequenceElementType = OrtApi.GetSequenceElementType(segment);
    this.ReleaseMapTypeInfo = OrtApi.ReleaseMapTypeInfo(segment);
    this.ReleaseSequenceTypeInfo = OrtApi.ReleaseSequenceTypeInfo(segment);
    this.SessionEndProfiling = OrtApi.SessionEndProfiling(segment);
    this.SessionGetModelMetadata = OrtApi.SessionGetModelMetadata(segment);
    this.ModelMetadataGetProducerName = OrtApi.ModelMetadataGetProducerName(segment);
    this.ModelMetadataGetGraphName = OrtApi.ModelMetadataGetGraphName(segment);
    this.ModelMetadataGetDomain = OrtApi.ModelMetadataGetDomain(segment);
    this.ModelMetadataGetDescription = OrtApi.ModelMetadataGetDescription(segment);
    this.ModelMetadataLookupCustomMetadataMap =
        OrtApi.ModelMetadataLookupCustomMetadataMap(segment);
    this.ModelMetadataGetVersion = OrtApi.ModelMetadataGetVersion(segment);
    this.ReleaseModelMetadata = OrtApi.ReleaseModelMetadata(segment);
    this.CreateEnvWithGlobalThreadPools = OrtApi.CreateEnvWithGlobalThreadPools(segment);
    this.DisablePerSessionThreads = OrtApi.DisablePerSessionThreads(segment);
    this.CreateThreadingOptions = OrtApi.CreateThreadingOptions(segment);
    this.ReleaseThreadingOptions = OrtApi.ReleaseThreadingOptions(segment);
    this.ModelMetadataGetCustomMetadataMapKeys =
        OrtApi.ModelMetadataGetCustomMetadataMapKeys(segment);
    this.AddFreeDimensionOverrideByName = OrtApi.AddFreeDimensionOverrideByName(segment);
    this.GetAvailableProviders = OrtApi.GetAvailableProviders(segment);
    this.ReleaseAvailableProviders = OrtApi.ReleaseAvailableProviders(segment);
    this.GetStringTensorElementLength = OrtApi.GetStringTensorElementLength(segment);
    this.GetStringTensorElement = OrtApi.GetStringTensorElement(segment);
    this.FillStringTensorElement = OrtApi.FillStringTensorElement(segment);
    this.AddSessionConfigEntry = OrtApi.AddSessionConfigEntry(segment);
    this.CreateAllocator = OrtApi.CreateAllocator(segment);
    this.ReleaseAllocator = OrtApi.ReleaseAllocator(segment);
    this.RunWithBinding = OrtApi.RunWithBinding(segment);
    this.CreateIoBinding = OrtApi.CreateIoBinding(segment);
    this.ReleaseIoBinding = OrtApi.ReleaseIoBinding(segment);
    this.BindInput = OrtApi.BindInput(segment);
    this.BindOutput = OrtApi.BindOutput(segment);
    this.BindOutputToDevice = OrtApi.BindOutputToDevice(segment);
    this.GetBoundOutputNames = OrtApi.GetBoundOutputNames(segment);
    this.GetBoundOutputValues = OrtApi.GetBoundOutputValues(segment);
    this.ClearBoundInputs = OrtApi.ClearBoundInputs(segment);
    this.ClearBoundOutputs = OrtApi.ClearBoundOutputs(segment);
    this.TensorAt = OrtApi.TensorAt(segment);
    this.CreateAndRegisterAllocator = OrtApi.CreateAndRegisterAllocator(segment);
    this.SetLanguageProjection = OrtApi.SetLanguageProjection(segment);
    this.SessionGetProfilingStartTimeNs = OrtApi.SessionGetProfilingStartTimeNs(segment);
    this.SetGlobalIntraOpNumThreads = OrtApi.SetGlobalIntraOpNumThreads(segment);
    this.SetGlobalInterOpNumThreads = OrtApi.SetGlobalInterOpNumThreads(segment);
    this.SetGlobalSpinControl = OrtApi.SetGlobalSpinControl(segment);
    this.AddInitializer = OrtApi.AddInitializer(segment);
    this.CreateEnvWithCustomLoggerAndGlobalThreadPools =
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools(segment);
    this.SessionOptionsAppendExecutionProvider_CUDA =
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA(segment);
    this.SessionOptionsAppendExecutionProvider_ROCM =
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM(segment);
    this.SessionOptionsAppendExecutionProvider_OpenVINO =
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO(segment);
    this.SetGlobalDenormalAsZero = OrtApi.SetGlobalDenormalAsZero(segment);
    this.CreateArenaCfg = OrtApi.CreateArenaCfg(segment);
    this.ReleaseArenaCfg = OrtApi.ReleaseArenaCfg(segment);
    this.ModelMetadataGetGraphDescription = OrtApi.ModelMetadataGetGraphDescription(segment);
    this.SessionOptionsAppendExecutionProvider_TensorRT =
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT(segment);
    this.SetCurrentGpuDeviceId = OrtApi.SetCurrentGpuDeviceId(segment);
    this.GetCurrentGpuDeviceId = OrtApi.GetCurrentGpuDeviceId(segment);
    this.KernelInfoGetAttributeArray_float = OrtApi.KernelInfoGetAttributeArray_float(segment);
    this.KernelInfoGetAttributeArray_int64 = OrtApi.KernelInfoGetAttributeArray_int64(segment);
    this.CreateArenaCfgV2 = OrtApi.CreateArenaCfgV2(segment);
    this.AddRunConfigEntry = OrtApi.AddRunConfigEntry(segment);
    this.CreatePrepackedWeightsContainer = OrtApi.CreatePrepackedWeightsContainer(segment);
    this.ReleasePrepackedWeightsContainer = OrtApi.ReleasePrepackedWeightsContainer(segment);
    this.CreateSessionWithPrepackedWeightsContainer =
        OrtApi.CreateSessionWithPrepackedWeightsContainer(segment);
    this.CreateSessionFromArrayWithPrepackedWeightsContainer =
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer(segment);
    this.SessionOptionsAppendExecutionProvider_TensorRT_V2 =
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2(segment);
    this.CreateTensorRTProviderOptions = OrtApi.CreateTensorRTProviderOptions(segment);
    this.UpdateTensorRTProviderOptions = OrtApi.UpdateTensorRTProviderOptions(segment);
    this.GetTensorRTProviderOptionsAsString = OrtApi.GetTensorRTProviderOptionsAsString(segment);
    this.ReleaseTensorRTProviderOptions = OrtApi.ReleaseTensorRTProviderOptions(segment);
    this.EnableOrtCustomOps = OrtApi.EnableOrtCustomOps(segment);
    this.RegisterAllocator = OrtApi.RegisterAllocator(segment);
    this.UnregisterAllocator = OrtApi.UnregisterAllocator(segment);
    this.IsSparseTensor = OrtApi.IsSparseTensor(segment);
    this.CreateSparseTensorAsOrtValue = OrtApi.CreateSparseTensorAsOrtValue(segment);
    this.FillSparseTensorCoo = OrtApi.FillSparseTensorCoo(segment);
    this.FillSparseTensorCsr = OrtApi.FillSparseTensorCsr(segment);
    this.FillSparseTensorBlockSparse = OrtApi.FillSparseTensorBlockSparse(segment);
    this.CreateSparseTensorWithValuesAsOrtValue =
        OrtApi.CreateSparseTensorWithValuesAsOrtValue(segment);
    this.UseCooIndices = OrtApi.UseCooIndices(segment);
    this.UseCsrIndices = OrtApi.UseCsrIndices(segment);
    this.UseBlockSparseIndices = OrtApi.UseBlockSparseIndices(segment);
    this.GetSparseTensorFormat = OrtApi.GetSparseTensorFormat(segment);
    this.GetSparseTensorValuesTypeAndShape = OrtApi.GetSparseTensorValuesTypeAndShape(segment);
    this.GetSparseTensorValues = OrtApi.GetSparseTensorValues(segment);
    this.GetSparseTensorIndicesTypeShape = OrtApi.GetSparseTensorIndicesTypeShape(segment);
    this.GetSparseTensorIndices = OrtApi.GetSparseTensorIndices(segment);
    this.HasValue = OrtApi.HasValue(segment);
    this.KernelContext_GetGPUComputeStream = OrtApi.KernelContext_GetGPUComputeStream(segment);
    this.GetTensorMemoryInfo = OrtApi.GetTensorMemoryInfo(segment);
    this.GetExecutionProviderApi = OrtApi.GetExecutionProviderApi(segment);
    this.SessionOptionsSetCustomCreateThreadFn =
        OrtApi.SessionOptionsSetCustomCreateThreadFn(segment);
    this.SessionOptionsSetCustomThreadCreationOptions =
        OrtApi.SessionOptionsSetCustomThreadCreationOptions(segment);
    this.SessionOptionsSetCustomJoinThreadFn = OrtApi.SessionOptionsSetCustomJoinThreadFn(segment);
    this.SetGlobalCustomCreateThreadFn = OrtApi.SetGlobalCustomCreateThreadFn(segment);
    this.SetGlobalCustomThreadCreationOptions =
        OrtApi.SetGlobalCustomThreadCreationOptions(segment);
    this.SetGlobalCustomJoinThreadFn = OrtApi.SetGlobalCustomJoinThreadFn(segment);
    this.SynchronizeBoundInputs = OrtApi.SynchronizeBoundInputs(segment);
    this.SynchronizeBoundOutputs = OrtApi.SynchronizeBoundOutputs(segment);
  }

  @Override
  public Environment.Builder newEnvironment() {
    return new EnviromentBuilderImpl(this);
  }

  void checkStatus(MemoryAddress status) {
    if (MemoryAddress.NULL.equals(status)) {
      return;
    }
    int code = GetErrorCode.apply(status);
    String message = toJavaString(GetErrorMessage.apply(status));
    ReleaseStatus.apply(status);
    throw new OrtException(code, message);
  }

  MemoryAddress create(
      SegmentAllocator allocator, Function<MemoryAddress, MemoryAddress> constructor) {
    MemorySegment pointer = allocator.allocate(C_POINTER);
    checkStatus(constructor.apply(pointer.address()));
    return MemoryAccess.getAddress(pointer);
  }

  int extractInt(SegmentAllocator allocator, Function<MemoryAddress, MemoryAddress> method) {
    MemorySegment pointer = allocator.allocate(C_INT);
    checkStatus(method.apply(pointer.address()));
    return MemoryAccess.getInt(pointer);
  }

  long extractLong(SegmentAllocator allocator, Function<MemoryAddress, MemoryAddress> method) {
    MemorySegment pointer = allocator.allocate(C_LONG);
    checkStatus(method.apply(pointer.address()));
    return MemoryAccess.getLong(pointer);
  }
}
