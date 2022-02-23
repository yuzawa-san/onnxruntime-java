/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtApi {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_POINTER.withName("CreateStatus"),
                    C_POINTER.withName("GetErrorCode"),
                    C_POINTER.withName("GetErrorMessage"),
                    C_POINTER.withName("CreateEnv"),
                    C_POINTER.withName("CreateEnvWithCustomLogger"),
                    C_POINTER.withName("EnableTelemetryEvents"),
                    C_POINTER.withName("DisableTelemetryEvents"),
                    C_POINTER.withName("CreateSession"),
                    C_POINTER.withName("CreateSessionFromArray"),
                    C_POINTER.withName("Run"),
                    C_POINTER.withName("CreateSessionOptions"),
                    C_POINTER.withName("SetOptimizedModelFilePath"),
                    C_POINTER.withName("CloneSessionOptions"),
                    C_POINTER.withName("SetSessionExecutionMode"),
                    C_POINTER.withName("EnableProfiling"),
                    C_POINTER.withName("DisableProfiling"),
                    C_POINTER.withName("EnableMemPattern"),
                    C_POINTER.withName("DisableMemPattern"),
                    C_POINTER.withName("EnableCpuMemArena"),
                    C_POINTER.withName("DisableCpuMemArena"),
                    C_POINTER.withName("SetSessionLogId"),
                    C_POINTER.withName("SetSessionLogVerbosityLevel"),
                    C_POINTER.withName("SetSessionLogSeverityLevel"),
                    C_POINTER.withName("SetSessionGraphOptimizationLevel"),
                    C_POINTER.withName("SetIntraOpNumThreads"),
                    C_POINTER.withName("SetInterOpNumThreads"),
                    C_POINTER.withName("CreateCustomOpDomain"),
                    C_POINTER.withName("CustomOpDomain_Add"),
                    C_POINTER.withName("AddCustomOpDomain"),
                    C_POINTER.withName("RegisterCustomOpsLibrary"),
                    C_POINTER.withName("SessionGetInputCount"),
                    C_POINTER.withName("SessionGetOutputCount"),
                    C_POINTER.withName("SessionGetOverridableInitializerCount"),
                    C_POINTER.withName("SessionGetInputTypeInfo"),
                    C_POINTER.withName("SessionGetOutputTypeInfo"),
                    C_POINTER.withName("SessionGetOverridableInitializerTypeInfo"),
                    C_POINTER.withName("SessionGetInputName"),
                    C_POINTER.withName("SessionGetOutputName"),
                    C_POINTER.withName("SessionGetOverridableInitializerName"),
                    C_POINTER.withName("CreateRunOptions"),
                    C_POINTER.withName("RunOptionsSetRunLogVerbosityLevel"),
                    C_POINTER.withName("RunOptionsSetRunLogSeverityLevel"),
                    C_POINTER.withName("RunOptionsSetRunTag"),
                    C_POINTER.withName("RunOptionsGetRunLogVerbosityLevel"),
                    C_POINTER.withName("RunOptionsGetRunLogSeverityLevel"),
                    C_POINTER.withName("RunOptionsGetRunTag"),
                    C_POINTER.withName("RunOptionsSetTerminate"),
                    C_POINTER.withName("RunOptionsUnsetTerminate"),
                    C_POINTER.withName("CreateTensorAsOrtValue"),
                    C_POINTER.withName("CreateTensorWithDataAsOrtValue"),
                    C_POINTER.withName("IsTensor"),
                    C_POINTER.withName("GetTensorMutableData"),
                    C_POINTER.withName("FillStringTensor"),
                    C_POINTER.withName("GetStringTensorDataLength"),
                    C_POINTER.withName("GetStringTensorContent"),
                    C_POINTER.withName("CastTypeInfoToTensorInfo"),
                    C_POINTER.withName("GetOnnxTypeFromTypeInfo"),
                    C_POINTER.withName("CreateTensorTypeAndShapeInfo"),
                    C_POINTER.withName("SetTensorElementType"),
                    C_POINTER.withName("SetDimensions"),
                    C_POINTER.withName("GetTensorElementType"),
                    C_POINTER.withName("GetDimensionsCount"),
                    C_POINTER.withName("GetDimensions"),
                    C_POINTER.withName("GetSymbolicDimensions"),
                    C_POINTER.withName("GetTensorShapeElementCount"),
                    C_POINTER.withName("GetTensorTypeAndShape"),
                    C_POINTER.withName("GetTypeInfo"),
                    C_POINTER.withName("GetValueType"),
                    C_POINTER.withName("CreateMemoryInfo"),
                    C_POINTER.withName("CreateCpuMemoryInfo"),
                    C_POINTER.withName("CompareMemoryInfo"),
                    C_POINTER.withName("MemoryInfoGetName"),
                    C_POINTER.withName("MemoryInfoGetId"),
                    C_POINTER.withName("MemoryInfoGetMemType"),
                    C_POINTER.withName("MemoryInfoGetType"),
                    C_POINTER.withName("AllocatorAlloc"),
                    C_POINTER.withName("AllocatorFree"),
                    C_POINTER.withName("AllocatorGetInfo"),
                    C_POINTER.withName("GetAllocatorWithDefaultOptions"),
                    C_POINTER.withName("AddFreeDimensionOverride"),
                    C_POINTER.withName("GetValue"),
                    C_POINTER.withName("GetValueCount"),
                    C_POINTER.withName("CreateValue"),
                    C_POINTER.withName("CreateOpaqueValue"),
                    C_POINTER.withName("GetOpaqueValue"),
                    C_POINTER.withName("KernelInfoGetAttribute_float"),
                    C_POINTER.withName("KernelInfoGetAttribute_int64"),
                    C_POINTER.withName("KernelInfoGetAttribute_string"),
                    C_POINTER.withName("KernelContext_GetInputCount"),
                    C_POINTER.withName("KernelContext_GetOutputCount"),
                    C_POINTER.withName("KernelContext_GetInput"),
                    C_POINTER.withName("KernelContext_GetOutput"),
                    C_POINTER.withName("ReleaseEnv"),
                    C_POINTER.withName("ReleaseStatus"),
                    C_POINTER.withName("ReleaseMemoryInfo"),
                    C_POINTER.withName("ReleaseSession"),
                    C_POINTER.withName("ReleaseValue"),
                    C_POINTER.withName("ReleaseRunOptions"),
                    C_POINTER.withName("ReleaseTypeInfo"),
                    C_POINTER.withName("ReleaseTensorTypeAndShapeInfo"),
                    C_POINTER.withName("ReleaseSessionOptions"),
                    C_POINTER.withName("ReleaseCustomOpDomain"),
                    C_POINTER.withName("GetDenotationFromTypeInfo"),
                    C_POINTER.withName("CastTypeInfoToMapTypeInfo"),
                    C_POINTER.withName("CastTypeInfoToSequenceTypeInfo"),
                    C_POINTER.withName("GetMapKeyType"),
                    C_POINTER.withName("GetMapValueType"),
                    C_POINTER.withName("GetSequenceElementType"),
                    C_POINTER.withName("ReleaseMapTypeInfo"),
                    C_POINTER.withName("ReleaseSequenceTypeInfo"),
                    C_POINTER.withName("SessionEndProfiling"),
                    C_POINTER.withName("SessionGetModelMetadata"),
                    C_POINTER.withName("ModelMetadataGetProducerName"),
                    C_POINTER.withName("ModelMetadataGetGraphName"),
                    C_POINTER.withName("ModelMetadataGetDomain"),
                    C_POINTER.withName("ModelMetadataGetDescription"),
                    C_POINTER.withName("ModelMetadataLookupCustomMetadataMap"),
                    C_POINTER.withName("ModelMetadataGetVersion"),
                    C_POINTER.withName("ReleaseModelMetadata"),
                    C_POINTER.withName("CreateEnvWithGlobalThreadPools"),
                    C_POINTER.withName("DisablePerSessionThreads"),
                    C_POINTER.withName("CreateThreadingOptions"),
                    C_POINTER.withName("ReleaseThreadingOptions"),
                    C_POINTER.withName("ModelMetadataGetCustomMetadataMapKeys"),
                    C_POINTER.withName("AddFreeDimensionOverrideByName"),
                    C_POINTER.withName("GetAvailableProviders"),
                    C_POINTER.withName("ReleaseAvailableProviders"),
                    C_POINTER.withName("GetStringTensorElementLength"),
                    C_POINTER.withName("GetStringTensorElement"),
                    C_POINTER.withName("FillStringTensorElement"),
                    C_POINTER.withName("AddSessionConfigEntry"),
                    C_POINTER.withName("CreateAllocator"),
                    C_POINTER.withName("ReleaseAllocator"),
                    C_POINTER.withName("RunWithBinding"),
                    C_POINTER.withName("CreateIoBinding"),
                    C_POINTER.withName("ReleaseIoBinding"),
                    C_POINTER.withName("BindInput"),
                    C_POINTER.withName("BindOutput"),
                    C_POINTER.withName("BindOutputToDevice"),
                    C_POINTER.withName("GetBoundOutputNames"),
                    C_POINTER.withName("GetBoundOutputValues"),
                    C_POINTER.withName("ClearBoundInputs"),
                    C_POINTER.withName("ClearBoundOutputs"),
                    C_POINTER.withName("TensorAt"),
                    C_POINTER.withName("CreateAndRegisterAllocator"),
                    C_POINTER.withName("SetLanguageProjection"),
                    C_POINTER.withName("SessionGetProfilingStartTimeNs"),
                    C_POINTER.withName("SetGlobalIntraOpNumThreads"),
                    C_POINTER.withName("SetGlobalInterOpNumThreads"),
                    C_POINTER.withName("SetGlobalSpinControl"),
                    C_POINTER.withName("AddInitializer"),
                    C_POINTER.withName("CreateEnvWithCustomLoggerAndGlobalThreadPools"),
                    C_POINTER.withName("SessionOptionsAppendExecutionProvider_CUDA"),
                    C_POINTER.withName("SessionOptionsAppendExecutionProvider_ROCM"),
                    C_POINTER.withName("SessionOptionsAppendExecutionProvider_OpenVINO"),
                    C_POINTER.withName("SetGlobalDenormalAsZero"),
                    C_POINTER.withName("CreateArenaCfg"),
                    C_POINTER.withName("ReleaseArenaCfg"),
                    C_POINTER.withName("ModelMetadataGetGraphDescription"),
                    C_POINTER.withName("SessionOptionsAppendExecutionProvider_TensorRT"),
                    C_POINTER.withName("SetCurrentGpuDeviceId"),
                    C_POINTER.withName("GetCurrentGpuDeviceId"),
                    C_POINTER.withName("KernelInfoGetAttributeArray_float"),
                    C_POINTER.withName("KernelInfoGetAttributeArray_int64"),
                    C_POINTER.withName("CreateArenaCfgV2"),
                    C_POINTER.withName("AddRunConfigEntry"),
                    C_POINTER.withName("CreatePrepackedWeightsContainer"),
                    C_POINTER.withName("ReleasePrepackedWeightsContainer"),
                    C_POINTER.withName("CreateSessionWithPrepackedWeightsContainer"),
                    C_POINTER.withName("CreateSessionFromArrayWithPrepackedWeightsContainer"),
                    C_POINTER.withName("SessionOptionsAppendExecutionProvider_TensorRT_V2"),
                    C_POINTER.withName("CreateTensorRTProviderOptions"),
                    C_POINTER.withName("UpdateTensorRTProviderOptions"),
                    C_POINTER.withName("GetTensorRTProviderOptionsAsString"),
                    C_POINTER.withName("ReleaseTensorRTProviderOptions"),
                    C_POINTER.withName("EnableOrtCustomOps"),
                    C_POINTER.withName("RegisterAllocator"),
                    C_POINTER.withName("UnregisterAllocator"),
                    C_POINTER.withName("IsSparseTensor"),
                    C_POINTER.withName("CreateSparseTensorAsOrtValue"),
                    C_POINTER.withName("FillSparseTensorCoo"),
                    C_POINTER.withName("FillSparseTensorCsr"),
                    C_POINTER.withName("FillSparseTensorBlockSparse"),
                    C_POINTER.withName("CreateSparseTensorWithValuesAsOrtValue"),
                    C_POINTER.withName("UseCooIndices"),
                    C_POINTER.withName("UseCsrIndices"),
                    C_POINTER.withName("UseBlockSparseIndices"),
                    C_POINTER.withName("GetSparseTensorFormat"),
                    C_POINTER.withName("GetSparseTensorValuesTypeAndShape"),
                    C_POINTER.withName("GetSparseTensorValues"),
                    C_POINTER.withName("GetSparseTensorIndicesTypeShape"),
                    C_POINTER.withName("GetSparseTensorIndices"),
                    C_POINTER.withName("HasValue"),
                    C_POINTER.withName("KernelContext_GetGPUComputeStream"),
                    C_POINTER.withName("GetTensorMemoryInfo"),
                    C_POINTER.withName("GetExecutionProviderApi"),
                    C_POINTER.withName("SessionOptionsSetCustomCreateThreadFn"),
                    C_POINTER.withName("SessionOptionsSetCustomThreadCreationOptions"),
                    C_POINTER.withName("SessionOptionsSetCustomJoinThreadFn"),
                    C_POINTER.withName("SetGlobalCustomCreateThreadFn"),
                    C_POINTER.withName("SetGlobalCustomThreadCreationOptions"),
                    C_POINTER.withName("SetGlobalCustomJoinThreadFn"),
                    C_POINTER.withName("SynchronizeBoundInputs"),
                    C_POINTER.withName("SynchronizeBoundOutputs"))
            .withName("OrtApi");

    public static MemoryLayout $LAYOUT() {
        return OrtApi.$struct$LAYOUT;
    }

    static final FunctionDescriptor CreateStatus$FUNC = FunctionDescriptor.of(C_POINTER, C_INT, C_POINTER);
    static final MethodHandle CreateStatus$MH = RuntimeHelper.downcallHandle(
            "(ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateStatus$FUNC,
            false);

    public interface CreateStatus {

        jdk.incubator.foreign.MemoryAddress apply(int x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CreateStatus fi) {
            return RuntimeHelper.upcallStub(
                    CreateStatus.class,
                    fi,
                    OrtApi.CreateStatus$FUNC,
                    "(ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateStatus fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateStatus.class,
                    fi,
                    OrtApi.CreateStatus$FUNC,
                    "(ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateStatus ofAddress(MemoryAddress addr) {
            return (int x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateStatus$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateStatus$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateStatus")));

    public static VarHandle CreateStatus$VH() {
        return OrtApi.CreateStatus$VH;
    }

    public static MemoryAddress CreateStatus$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateStatus$VH.get(seg);
    }

    public static void CreateStatus$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateStatus$VH.set(seg, x);
    }

    public static MemoryAddress CreateStatus$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateStatus$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateStatus$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateStatus$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateStatus CreateStatus(MemorySegment segment) {
        return CreateStatus.ofAddress(CreateStatus$get(segment));
    }

    static final FunctionDescriptor GetErrorCode$FUNC = FunctionDescriptor.of(C_INT, C_POINTER);
    static final MethodHandle GetErrorCode$MH =
            RuntimeHelper.downcallHandle("(Ljdk/incubator/foreign/MemoryAddress;)I", OrtApi.GetErrorCode$FUNC, false);

    public interface GetErrorCode {

        int apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetErrorCode fi) {
            return RuntimeHelper.upcallStub(
                    GetErrorCode.class, fi, OrtApi.GetErrorCode$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)I");
        }

        static MemoryAddress allocate(GetErrorCode fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetErrorCode.class,
                    fi,
                    OrtApi.GetErrorCode$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)I",
                    scope);
        }

        static GetErrorCode ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (int) OrtApi.GetErrorCode$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetErrorCode$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetErrorCode")));

    public static VarHandle GetErrorCode$VH() {
        return OrtApi.GetErrorCode$VH;
    }

    public static MemoryAddress GetErrorCode$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetErrorCode$VH.get(seg);
    }

    public static void GetErrorCode$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetErrorCode$VH.set(seg, x);
    }

    public static MemoryAddress GetErrorCode$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetErrorCode$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetErrorCode$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetErrorCode$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetErrorCode GetErrorCode(MemorySegment segment) {
        return GetErrorCode.ofAddress(GetErrorCode$get(segment));
    }

    static final FunctionDescriptor GetErrorMessage$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle GetErrorMessage$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetErrorMessage$FUNC,
            false);

    public interface GetErrorMessage {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetErrorMessage fi) {
            return RuntimeHelper.upcallStub(
                    GetErrorMessage.class,
                    fi,
                    OrtApi.GetErrorMessage$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetErrorMessage fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetErrorMessage.class,
                    fi,
                    OrtApi.GetErrorMessage$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetErrorMessage ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetErrorMessage$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetErrorMessage$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetErrorMessage")));

    public static VarHandle GetErrorMessage$VH() {
        return OrtApi.GetErrorMessage$VH;
    }

    public static MemoryAddress GetErrorMessage$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetErrorMessage$VH.get(seg);
    }

    public static void GetErrorMessage$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetErrorMessage$VH.set(seg, x);
    }

    public static MemoryAddress GetErrorMessage$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetErrorMessage$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetErrorMessage$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetErrorMessage$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetErrorMessage GetErrorMessage(MemorySegment segment) {
        return GetErrorMessage.ofAddress(GetErrorMessage$get(segment));
    }

    static final FunctionDescriptor CreateEnv$FUNC = FunctionDescriptor.of(C_POINTER, C_INT, C_POINTER, C_POINTER);
    static final MethodHandle CreateEnv$MH = RuntimeHelper.downcallHandle(
            "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateEnv$FUNC,
            false);

    public interface CreateEnv {

        jdk.incubator.foreign.MemoryAddress apply(
                int x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(CreateEnv fi) {
            return RuntimeHelper.upcallStub(
                    CreateEnv.class,
                    fi,
                    OrtApi.CreateEnv$FUNC,
                    "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateEnv fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnv.class,
                    fi,
                    OrtApi.CreateEnv$FUNC,
                    "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateEnv ofAddress(MemoryAddress addr) {
            return (int x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateEnv$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnv$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateEnv")));

    public static VarHandle CreateEnv$VH() {
        return OrtApi.CreateEnv$VH;
    }

    public static MemoryAddress CreateEnv$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateEnv$VH.get(seg);
    }

    public static void CreateEnv$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnv$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnv$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateEnv$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnv$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnv$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnv CreateEnv(MemorySegment segment) {
        return CreateEnv.ofAddress(CreateEnv$get(segment));
    }

    static final FunctionDescriptor CreateEnvWithCustomLogger$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_INT, C_POINTER, C_POINTER);
    static final MethodHandle CreateEnvWithCustomLogger$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateEnvWithCustomLogger$FUNC,
            false);

    public interface CreateEnvWithCustomLogger {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                int x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateEnvWithCustomLogger fi) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLogger.class,
                    fi,
                    OrtApi.CreateEnvWithCustomLogger$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateEnvWithCustomLogger fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLogger.class,
                    fi,
                    OrtApi.CreateEnvWithCustomLogger$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateEnvWithCustomLogger ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    int x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateEnvWithCustomLogger$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnvWithCustomLogger$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLogger")));

    public static VarHandle CreateEnvWithCustomLogger$VH() {
        return OrtApi.CreateEnvWithCustomLogger$VH;
    }

    public static MemoryAddress CreateEnvWithCustomLogger$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateEnvWithCustomLogger$VH.get(seg);
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLogger$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnvWithCustomLogger$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateEnvWithCustomLogger$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithCustomLogger$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLogger$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithCustomLogger CreateEnvWithCustomLogger(MemorySegment segment) {
        return CreateEnvWithCustomLogger.ofAddress(CreateEnvWithCustomLogger$get(segment));
    }

    static final FunctionDescriptor EnableTelemetryEvents$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle EnableTelemetryEvents$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.EnableTelemetryEvents$FUNC,
            false);

    public interface EnableTelemetryEvents {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(EnableTelemetryEvents fi) {
            return RuntimeHelper.upcallStub(
                    EnableTelemetryEvents.class,
                    fi,
                    OrtApi.EnableTelemetryEvents$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(EnableTelemetryEvents fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    EnableTelemetryEvents.class,
                    fi,
                    OrtApi.EnableTelemetryEvents$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static EnableTelemetryEvents ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.EnableTelemetryEvents$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableTelemetryEvents$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("EnableTelemetryEvents")));

    public static VarHandle EnableTelemetryEvents$VH() {
        return OrtApi.EnableTelemetryEvents$VH;
    }

    public static MemoryAddress EnableTelemetryEvents$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableTelemetryEvents$VH.get(seg);
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableTelemetryEvents$VH.set(seg, x);
    }

    public static MemoryAddress EnableTelemetryEvents$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableTelemetryEvents$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableTelemetryEvents$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableTelemetryEvents$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableTelemetryEvents EnableTelemetryEvents(MemorySegment segment) {
        return EnableTelemetryEvents.ofAddress(EnableTelemetryEvents$get(segment));
    }

    static final FunctionDescriptor DisableTelemetryEvents$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle DisableTelemetryEvents$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.DisableTelemetryEvents$FUNC,
            false);

    public interface DisableTelemetryEvents {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(DisableTelemetryEvents fi) {
            return RuntimeHelper.upcallStub(
                    DisableTelemetryEvents.class,
                    fi,
                    OrtApi.DisableTelemetryEvents$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(DisableTelemetryEvents fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    DisableTelemetryEvents.class,
                    fi,
                    OrtApi.DisableTelemetryEvents$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static DisableTelemetryEvents ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.DisableTelemetryEvents$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableTelemetryEvents$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("DisableTelemetryEvents")));

    public static VarHandle DisableTelemetryEvents$VH() {
        return OrtApi.DisableTelemetryEvents$VH;
    }

    public static MemoryAddress DisableTelemetryEvents$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableTelemetryEvents$VH.get(seg);
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableTelemetryEvents$VH.set(seg, x);
    }

    public static MemoryAddress DisableTelemetryEvents$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.DisableTelemetryEvents$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableTelemetryEvents$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableTelemetryEvents$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableTelemetryEvents DisableTelemetryEvents(MemorySegment segment) {
        return DisableTelemetryEvents.ofAddress(DisableTelemetryEvents$get(segment));
    }

    static final FunctionDescriptor CreateSession$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateSession$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSession$FUNC,
            false);

    public interface CreateSession {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(CreateSession fi) {
            return RuntimeHelper.upcallStub(
                    CreateSession.class,
                    fi,
                    OrtApi.CreateSession$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSession fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSession.class,
                    fi,
                    OrtApi.CreateSession$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSession ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSession$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSession$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateSession")));

    public static VarHandle CreateSession$VH() {
        return OrtApi.CreateSession$VH;
    }

    public static MemoryAddress CreateSession$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSession$VH.get(seg);
    }

    public static void CreateSession$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSession$VH.set(seg, x);
    }

    public static MemoryAddress CreateSession$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSession$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSession$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSession$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSession CreateSession(MemorySegment segment) {
        return CreateSession.ofAddress(CreateSession$get(segment));
    }

    static final FunctionDescriptor CreateSessionFromArray$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER);
    static final MethodHandle CreateSessionFromArray$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSessionFromArray$FUNC,
            false);

    public interface CreateSessionFromArray {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateSessionFromArray fi) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArray.class,
                    fi,
                    OrtApi.CreateSessionFromArray$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSessionFromArray fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArray.class,
                    fi,
                    OrtApi.CreateSessionFromArray$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSessionFromArray ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSessionFromArray$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionFromArray$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateSessionFromArray")));

    public static VarHandle CreateSessionFromArray$VH() {
        return OrtApi.CreateSessionFromArray$VH;
    }

    public static MemoryAddress CreateSessionFromArray$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSessionFromArray$VH.get(seg);
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionFromArray$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionFromArray$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateSessionFromArray$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionFromArray$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionFromArray$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionFromArray CreateSessionFromArray(MemorySegment segment) {
        return CreateSessionFromArray.ofAddress(CreateSessionFromArray$get(segment));
    }

    static final FunctionDescriptor Run$FUNC = FunctionDescriptor.of(
            C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle Run$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.Run$FUNC,
            false);

    public interface Run {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3,
                long x4,
                jdk.incubator.foreign.MemoryAddress x5,
                long x6,
                jdk.incubator.foreign.MemoryAddress x7);

        static MemoryAddress allocate(Run fi) {
            return RuntimeHelper.upcallStub(
                    Run.class,
                    fi,
                    OrtApi.Run$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(Run fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    Run.class,
                    fi,
                    OrtApi.Run$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static Run ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    long x4,
                    jdk.incubator.foreign.MemoryAddress x5,
                    long x6,
                    jdk.incubator.foreign.MemoryAddress x7) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.Run$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4, x5, x6, x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle Run$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("Run")));

    public static VarHandle Run$VH() {
        return OrtApi.Run$VH;
    }

    public static MemoryAddress Run$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.Run$VH.get(seg);
    }

    public static void Run$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.Run$VH.set(seg, x);
    }

    public static MemoryAddress Run$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.Run$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void Run$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.Run$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static Run Run(MemorySegment segment) {
        return Run.ofAddress(Run$get(segment));
    }

    static final FunctionDescriptor CreateSessionOptions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle CreateSessionOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSessionOptions$FUNC,
            false);

    public interface CreateSessionOptions {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(CreateSessionOptions fi) {
            return RuntimeHelper.upcallStub(
                    CreateSessionOptions.class,
                    fi,
                    OrtApi.CreateSessionOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSessionOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionOptions.class,
                    fi,
                    OrtApi.CreateSessionOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSessionOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSessionOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateSessionOptions")));

    public static VarHandle CreateSessionOptions$VH() {
        return OrtApi.CreateSessionOptions$VH;
    }

    public static MemoryAddress CreateSessionOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSessionOptions$VH.get(seg);
    }

    public static void CreateSessionOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionOptions CreateSessionOptions(MemorySegment segment) {
        return CreateSessionOptions.ofAddress(CreateSessionOptions$get(segment));
    }

    static final FunctionDescriptor SetOptimizedModelFilePath$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SetOptimizedModelFilePath$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetOptimizedModelFilePath$FUNC,
            false);

    public interface SetOptimizedModelFilePath {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SetOptimizedModelFilePath fi) {
            return RuntimeHelper.upcallStub(
                    SetOptimizedModelFilePath.class,
                    fi,
                    OrtApi.SetOptimizedModelFilePath$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetOptimizedModelFilePath fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetOptimizedModelFilePath.class,
                    fi,
                    OrtApi.SetOptimizedModelFilePath$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetOptimizedModelFilePath ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetOptimizedModelFilePath$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetOptimizedModelFilePath$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetOptimizedModelFilePath")));

    public static VarHandle SetOptimizedModelFilePath$VH() {
        return OrtApi.SetOptimizedModelFilePath$VH;
    }

    public static MemoryAddress SetOptimizedModelFilePath$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetOptimizedModelFilePath$VH.get(seg);
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetOptimizedModelFilePath$VH.set(seg, x);
    }

    public static MemoryAddress SetOptimizedModelFilePath$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetOptimizedModelFilePath$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetOptimizedModelFilePath$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetOptimizedModelFilePath$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetOptimizedModelFilePath SetOptimizedModelFilePath(MemorySegment segment) {
        return SetOptimizedModelFilePath.ofAddress(SetOptimizedModelFilePath$get(segment));
    }

    static final FunctionDescriptor CloneSessionOptions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CloneSessionOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CloneSessionOptions$FUNC,
            false);

    public interface CloneSessionOptions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CloneSessionOptions fi) {
            return RuntimeHelper.upcallStub(
                    CloneSessionOptions.class,
                    fi,
                    OrtApi.CloneSessionOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CloneSessionOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CloneSessionOptions.class,
                    fi,
                    OrtApi.CloneSessionOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CloneSessionOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CloneSessionOptions$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CloneSessionOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CloneSessionOptions")));

    public static VarHandle CloneSessionOptions$VH() {
        return OrtApi.CloneSessionOptions$VH;
    }

    public static MemoryAddress CloneSessionOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CloneSessionOptions$VH.get(seg);
    }

    public static void CloneSessionOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CloneSessionOptions$VH.set(seg, x);
    }

    public static MemoryAddress CloneSessionOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CloneSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CloneSessionOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CloneSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CloneSessionOptions CloneSessionOptions(MemorySegment segment) {
        return CloneSessionOptions.ofAddress(CloneSessionOptions$get(segment));
    }

    static final FunctionDescriptor SetSessionExecutionMode$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetSessionExecutionMode$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetSessionExecutionMode$FUNC,
            false);

    public interface SetSessionExecutionMode {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetSessionExecutionMode fi) {
            return RuntimeHelper.upcallStub(
                    SetSessionExecutionMode.class,
                    fi,
                    OrtApi.SetSessionExecutionMode$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetSessionExecutionMode fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionExecutionMode.class,
                    fi,
                    OrtApi.SetSessionExecutionMode$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetSessionExecutionMode ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetSessionExecutionMode$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionExecutionMode$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetSessionExecutionMode")));

    public static VarHandle SetSessionExecutionMode$VH() {
        return OrtApi.SetSessionExecutionMode$VH;
    }

    public static MemoryAddress SetSessionExecutionMode$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetSessionExecutionMode$VH.get(seg);
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionExecutionMode$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionExecutionMode$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetSessionExecutionMode$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionExecutionMode$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionExecutionMode$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionExecutionMode SetSessionExecutionMode(MemorySegment segment) {
        return SetSessionExecutionMode.ofAddress(SetSessionExecutionMode$get(segment));
    }

    static final FunctionDescriptor EnableProfiling$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle EnableProfiling$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.EnableProfiling$FUNC,
            false);

    public interface EnableProfiling {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(EnableProfiling fi) {
            return RuntimeHelper.upcallStub(
                    EnableProfiling.class,
                    fi,
                    OrtApi.EnableProfiling$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(EnableProfiling fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    EnableProfiling.class,
                    fi,
                    OrtApi.EnableProfiling$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static EnableProfiling ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.EnableProfiling$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableProfiling$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("EnableProfiling")));

    public static VarHandle EnableProfiling$VH() {
        return OrtApi.EnableProfiling$VH;
    }

    public static MemoryAddress EnableProfiling$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableProfiling$VH.get(seg);
    }

    public static void EnableProfiling$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableProfiling$VH.set(seg, x);
    }

    public static MemoryAddress EnableProfiling$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableProfiling$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableProfiling EnableProfiling(MemorySegment segment) {
        return EnableProfiling.ofAddress(EnableProfiling$get(segment));
    }

    static final FunctionDescriptor DisableProfiling$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle DisableProfiling$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.DisableProfiling$FUNC,
            false);

    public interface DisableProfiling {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(DisableProfiling fi) {
            return RuntimeHelper.upcallStub(
                    DisableProfiling.class,
                    fi,
                    OrtApi.DisableProfiling$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(DisableProfiling fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    DisableProfiling.class,
                    fi,
                    OrtApi.DisableProfiling$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static DisableProfiling ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.DisableProfiling$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableProfiling$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("DisableProfiling")));

    public static VarHandle DisableProfiling$VH() {
        return OrtApi.DisableProfiling$VH;
    }

    public static MemoryAddress DisableProfiling$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableProfiling$VH.get(seg);
    }

    public static void DisableProfiling$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableProfiling$VH.set(seg, x);
    }

    public static MemoryAddress DisableProfiling$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableProfiling$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableProfiling DisableProfiling(MemorySegment segment) {
        return DisableProfiling.ofAddress(DisableProfiling$get(segment));
    }

    static final FunctionDescriptor EnableMemPattern$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle EnableMemPattern$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.EnableMemPattern$FUNC,
            false);

    public interface EnableMemPattern {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(EnableMemPattern fi) {
            return RuntimeHelper.upcallStub(
                    EnableMemPattern.class,
                    fi,
                    OrtApi.EnableMemPattern$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(EnableMemPattern fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    EnableMemPattern.class,
                    fi,
                    OrtApi.EnableMemPattern$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static EnableMemPattern ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.EnableMemPattern$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableMemPattern$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("EnableMemPattern")));

    public static VarHandle EnableMemPattern$VH() {
        return OrtApi.EnableMemPattern$VH;
    }

    public static MemoryAddress EnableMemPattern$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableMemPattern$VH.get(seg);
    }

    public static void EnableMemPattern$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableMemPattern$VH.set(seg, x);
    }

    public static MemoryAddress EnableMemPattern$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableMemPattern$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableMemPattern$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableMemPattern$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableMemPattern EnableMemPattern(MemorySegment segment) {
        return EnableMemPattern.ofAddress(EnableMemPattern$get(segment));
    }

    static final FunctionDescriptor DisableMemPattern$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle DisableMemPattern$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.DisableMemPattern$FUNC,
            false);

    public interface DisableMemPattern {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(DisableMemPattern fi) {
            return RuntimeHelper.upcallStub(
                    DisableMemPattern.class,
                    fi,
                    OrtApi.DisableMemPattern$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(DisableMemPattern fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    DisableMemPattern.class,
                    fi,
                    OrtApi.DisableMemPattern$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static DisableMemPattern ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.DisableMemPattern$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableMemPattern$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("DisableMemPattern")));

    public static VarHandle DisableMemPattern$VH() {
        return OrtApi.DisableMemPattern$VH;
    }

    public static MemoryAddress DisableMemPattern$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableMemPattern$VH.get(seg);
    }

    public static void DisableMemPattern$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableMemPattern$VH.set(seg, x);
    }

    public static MemoryAddress DisableMemPattern$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableMemPattern$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableMemPattern$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableMemPattern$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableMemPattern DisableMemPattern(MemorySegment segment) {
        return DisableMemPattern.ofAddress(DisableMemPattern$get(segment));
    }

    static final FunctionDescriptor EnableCpuMemArena$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle EnableCpuMemArena$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.EnableCpuMemArena$FUNC,
            false);

    public interface EnableCpuMemArena {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(EnableCpuMemArena fi) {
            return RuntimeHelper.upcallStub(
                    EnableCpuMemArena.class,
                    fi,
                    OrtApi.EnableCpuMemArena$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(EnableCpuMemArena fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    EnableCpuMemArena.class,
                    fi,
                    OrtApi.EnableCpuMemArena$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static EnableCpuMemArena ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.EnableCpuMemArena$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableCpuMemArena$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("EnableCpuMemArena")));

    public static VarHandle EnableCpuMemArena$VH() {
        return OrtApi.EnableCpuMemArena$VH;
    }

    public static MemoryAddress EnableCpuMemArena$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableCpuMemArena$VH.get(seg);
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableCpuMemArena$VH.set(seg, x);
    }

    public static MemoryAddress EnableCpuMemArena$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableCpuMemArena$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableCpuMemArena$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableCpuMemArena$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableCpuMemArena EnableCpuMemArena(MemorySegment segment) {
        return EnableCpuMemArena.ofAddress(EnableCpuMemArena$get(segment));
    }

    static final FunctionDescriptor DisableCpuMemArena$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle DisableCpuMemArena$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.DisableCpuMemArena$FUNC,
            false);

    public interface DisableCpuMemArena {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(DisableCpuMemArena fi) {
            return RuntimeHelper.upcallStub(
                    DisableCpuMemArena.class,
                    fi,
                    OrtApi.DisableCpuMemArena$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(DisableCpuMemArena fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    DisableCpuMemArena.class,
                    fi,
                    OrtApi.DisableCpuMemArena$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static DisableCpuMemArena ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.DisableCpuMemArena$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisableCpuMemArena$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("DisableCpuMemArena")));

    public static VarHandle DisableCpuMemArena$VH() {
        return OrtApi.DisableCpuMemArena$VH;
    }

    public static MemoryAddress DisableCpuMemArena$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableCpuMemArena$VH.get(seg);
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisableCpuMemArena$VH.set(seg, x);
    }

    public static MemoryAddress DisableCpuMemArena$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisableCpuMemArena$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisableCpuMemArena$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisableCpuMemArena$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisableCpuMemArena DisableCpuMemArena(MemorySegment segment) {
        return DisableCpuMemArena.ofAddress(DisableCpuMemArena$get(segment));
    }

    static final FunctionDescriptor SetSessionLogId$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SetSessionLogId$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetSessionLogId$FUNC,
            false);

    public interface SetSessionLogId {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SetSessionLogId fi) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogId.class,
                    fi,
                    OrtApi.SetSessionLogId$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetSessionLogId fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogId.class,
                    fi,
                    OrtApi.SetSessionLogId$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetSessionLogId ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetSessionLogId$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionLogId$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetSessionLogId")));

    public static VarHandle SetSessionLogId$VH() {
        return OrtApi.SetSessionLogId$VH;
    }

    public static MemoryAddress SetSessionLogId$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetSessionLogId$VH.get(seg);
    }

    public static void SetSessionLogId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionLogId$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionLogId$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetSessionLogId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionLogId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogId SetSessionLogId(MemorySegment segment) {
        return SetSessionLogId.ofAddress(SetSessionLogId$get(segment));
    }

    static final FunctionDescriptor SetSessionLogVerbosityLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetSessionLogVerbosityLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetSessionLogVerbosityLevel$FUNC,
            false);

    public interface SetSessionLogVerbosityLevel {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetSessionLogVerbosityLevel fi) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogVerbosityLevel.class,
                    fi,
                    OrtApi.SetSessionLogVerbosityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetSessionLogVerbosityLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogVerbosityLevel.class,
                    fi,
                    OrtApi.SetSessionLogVerbosityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetSessionLogVerbosityLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetSessionLogVerbosityLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionLogVerbosityLevel$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetSessionLogVerbosityLevel")));

    public static VarHandle SetSessionLogVerbosityLevel$VH() {
        return OrtApi.SetSessionLogVerbosityLevel$VH;
    }

    public static MemoryAddress SetSessionLogVerbosityLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetSessionLogVerbosityLevel$VH.get(seg);
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetSessionLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogVerbosityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogVerbosityLevel SetSessionLogVerbosityLevel(MemorySegment segment) {
        return SetSessionLogVerbosityLevel.ofAddress(SetSessionLogVerbosityLevel$get(segment));
    }

    static final FunctionDescriptor SetSessionLogSeverityLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetSessionLogSeverityLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetSessionLogSeverityLevel$FUNC,
            false);

    public interface SetSessionLogSeverityLevel {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetSessionLogSeverityLevel fi) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogSeverityLevel.class,
                    fi,
                    OrtApi.SetSessionLogSeverityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetSessionLogSeverityLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionLogSeverityLevel.class,
                    fi,
                    OrtApi.SetSessionLogSeverityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetSessionLogSeverityLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetSessionLogSeverityLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionLogSeverityLevel$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetSessionLogSeverityLevel")));

    public static VarHandle SetSessionLogSeverityLevel$VH() {
        return OrtApi.SetSessionLogSeverityLevel$VH;
    }

    public static MemoryAddress SetSessionLogSeverityLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetSessionLogSeverityLevel$VH.get(seg);
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionLogSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionLogSeverityLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetSessionLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionLogSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionLogSeverityLevel SetSessionLogSeverityLevel(MemorySegment segment) {
        return SetSessionLogSeverityLevel.ofAddress(SetSessionLogSeverityLevel$get(segment));
    }

    static final FunctionDescriptor SetSessionGraphOptimizationLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetSessionGraphOptimizationLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetSessionGraphOptimizationLevel$FUNC,
            false);

    public interface SetSessionGraphOptimizationLevel {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetSessionGraphOptimizationLevel fi) {
            return RuntimeHelper.upcallStub(
                    SetSessionGraphOptimizationLevel.class,
                    fi,
                    OrtApi.SetSessionGraphOptimizationLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetSessionGraphOptimizationLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetSessionGraphOptimizationLevel.class,
                    fi,
                    OrtApi.SetSessionGraphOptimizationLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetSessionGraphOptimizationLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetSessionGraphOptimizationLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetSessionGraphOptimizationLevel$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SetSessionGraphOptimizationLevel")));

    public static VarHandle SetSessionGraphOptimizationLevel$VH() {
        return OrtApi.SetSessionGraphOptimizationLevel$VH;
    }

    public static MemoryAddress SetSessionGraphOptimizationLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetSessionGraphOptimizationLevel$VH.get(seg);
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetSessionGraphOptimizationLevel$VH.set(seg, x);
    }

    public static MemoryAddress SetSessionGraphOptimizationLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetSessionGraphOptimizationLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetSessionGraphOptimizationLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetSessionGraphOptimizationLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetSessionGraphOptimizationLevel SetSessionGraphOptimizationLevel(MemorySegment segment) {
        return SetSessionGraphOptimizationLevel.ofAddress(SetSessionGraphOptimizationLevel$get(segment));
    }

    static final FunctionDescriptor SetIntraOpNumThreads$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetIntraOpNumThreads$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetIntraOpNumThreads$FUNC,
            false);

    public interface SetIntraOpNumThreads {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetIntraOpNumThreads fi) {
            return RuntimeHelper.upcallStub(
                    SetIntraOpNumThreads.class,
                    fi,
                    OrtApi.SetIntraOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetIntraOpNumThreads fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetIntraOpNumThreads.class,
                    fi,
                    OrtApi.SetIntraOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetIntraOpNumThreads ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetIntraOpNumThreads$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetIntraOpNumThreads$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetIntraOpNumThreads")));

    public static VarHandle SetIntraOpNumThreads$VH() {
        return OrtApi.SetIntraOpNumThreads$VH;
    }

    public static MemoryAddress SetIntraOpNumThreads$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetIntraOpNumThreads$VH.get(seg);
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetIntraOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetIntraOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetIntraOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetIntraOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetIntraOpNumThreads SetIntraOpNumThreads(MemorySegment segment) {
        return SetIntraOpNumThreads.ofAddress(SetIntraOpNumThreads$get(segment));
    }

    static final FunctionDescriptor SetInterOpNumThreads$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetInterOpNumThreads$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetInterOpNumThreads$FUNC,
            false);

    public interface SetInterOpNumThreads {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetInterOpNumThreads fi) {
            return RuntimeHelper.upcallStub(
                    SetInterOpNumThreads.class,
                    fi,
                    OrtApi.SetInterOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetInterOpNumThreads fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetInterOpNumThreads.class,
                    fi,
                    OrtApi.SetInterOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetInterOpNumThreads ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetInterOpNumThreads$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetInterOpNumThreads$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetInterOpNumThreads")));

    public static VarHandle SetInterOpNumThreads$VH() {
        return OrtApi.SetInterOpNumThreads$VH;
    }

    public static MemoryAddress SetInterOpNumThreads$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetInterOpNumThreads$VH.get(seg);
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetInterOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetInterOpNumThreads$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetInterOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetInterOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetInterOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetInterOpNumThreads SetInterOpNumThreads(MemorySegment segment) {
        return SetInterOpNumThreads.ofAddress(SetInterOpNumThreads$get(segment));
    }

    static final FunctionDescriptor CreateCustomOpDomain$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateCustomOpDomain$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateCustomOpDomain$FUNC,
            false);

    public interface CreateCustomOpDomain {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CreateCustomOpDomain fi) {
            return RuntimeHelper.upcallStub(
                    CreateCustomOpDomain.class,
                    fi,
                    OrtApi.CreateCustomOpDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateCustomOpDomain fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateCustomOpDomain.class,
                    fi,
                    OrtApi.CreateCustomOpDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateCustomOpDomain ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateCustomOpDomain$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateCustomOpDomain$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateCustomOpDomain")));

    public static VarHandle CreateCustomOpDomain$VH() {
        return OrtApi.CreateCustomOpDomain$VH;
    }

    public static MemoryAddress CreateCustomOpDomain$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateCustomOpDomain$VH.get(seg);
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateCustomOpDomain$VH.set(seg, x);
    }

    public static MemoryAddress CreateCustomOpDomain$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCustomOpDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCustomOpDomain CreateCustomOpDomain(MemorySegment segment) {
        return CreateCustomOpDomain.ofAddress(CreateCustomOpDomain$get(segment));
    }

    static final FunctionDescriptor CustomOpDomain_Add$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CustomOpDomain_Add$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CustomOpDomain_Add$FUNC,
            false);

    public interface CustomOpDomain_Add {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CustomOpDomain_Add fi) {
            return RuntimeHelper.upcallStub(
                    CustomOpDomain_Add.class,
                    fi,
                    OrtApi.CustomOpDomain_Add$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CustomOpDomain_Add fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CustomOpDomain_Add.class,
                    fi,
                    OrtApi.CustomOpDomain_Add$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CustomOpDomain_Add ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CustomOpDomain_Add$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CustomOpDomain_Add$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CustomOpDomain_Add")));

    public static VarHandle CustomOpDomain_Add$VH() {
        return OrtApi.CustomOpDomain_Add$VH;
    }

    public static MemoryAddress CustomOpDomain_Add$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CustomOpDomain_Add$VH.get(seg);
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CustomOpDomain_Add$VH.set(seg, x);
    }

    public static MemoryAddress CustomOpDomain_Add$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CustomOpDomain_Add$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CustomOpDomain_Add$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CustomOpDomain_Add$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CustomOpDomain_Add CustomOpDomain_Add(MemorySegment segment) {
        return CustomOpDomain_Add.ofAddress(CustomOpDomain_Add$get(segment));
    }

    static final FunctionDescriptor AddCustomOpDomain$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle AddCustomOpDomain$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AddCustomOpDomain$FUNC,
            false);

    public interface AddCustomOpDomain {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(AddCustomOpDomain fi) {
            return RuntimeHelper.upcallStub(
                    AddCustomOpDomain.class,
                    fi,
                    OrtApi.AddCustomOpDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AddCustomOpDomain fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AddCustomOpDomain.class,
                    fi,
                    OrtApi.AddCustomOpDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AddCustomOpDomain ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AddCustomOpDomain$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddCustomOpDomain$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AddCustomOpDomain")));

    public static VarHandle AddCustomOpDomain$VH() {
        return OrtApi.AddCustomOpDomain$VH;
    }

    public static MemoryAddress AddCustomOpDomain$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddCustomOpDomain$VH.get(seg);
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddCustomOpDomain$VH.set(seg, x);
    }

    public static MemoryAddress AddCustomOpDomain$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddCustomOpDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddCustomOpDomain AddCustomOpDomain(MemorySegment segment) {
        return AddCustomOpDomain.ofAddress(AddCustomOpDomain$get(segment));
    }

    static final FunctionDescriptor RegisterCustomOpsLibrary$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RegisterCustomOpsLibrary$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RegisterCustomOpsLibrary$FUNC,
            false);

    public interface RegisterCustomOpsLibrary {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(RegisterCustomOpsLibrary fi) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsLibrary.class,
                    fi,
                    OrtApi.RegisterCustomOpsLibrary$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RegisterCustomOpsLibrary fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RegisterCustomOpsLibrary.class,
                    fi,
                    OrtApi.RegisterCustomOpsLibrary$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RegisterCustomOpsLibrary ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RegisterCustomOpsLibrary$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RegisterCustomOpsLibrary$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RegisterCustomOpsLibrary")));

    public static VarHandle RegisterCustomOpsLibrary$VH() {
        return OrtApi.RegisterCustomOpsLibrary$VH;
    }

    public static MemoryAddress RegisterCustomOpsLibrary$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RegisterCustomOpsLibrary$VH.get(seg);
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RegisterCustomOpsLibrary$VH.set(seg, x);
    }

    public static MemoryAddress RegisterCustomOpsLibrary$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RegisterCustomOpsLibrary$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterCustomOpsLibrary$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RegisterCustomOpsLibrary$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterCustomOpsLibrary RegisterCustomOpsLibrary(MemorySegment segment) {
        return RegisterCustomOpsLibrary.ofAddress(RegisterCustomOpsLibrary$get(segment));
    }

    static final FunctionDescriptor SessionGetInputCount$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetInputCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetInputCount$FUNC,
            false);

    public interface SessionGetInputCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionGetInputCount fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputCount.class,
                    fi,
                    OrtApi.SessionGetInputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetInputCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputCount.class,
                    fi,
                    OrtApi.SessionGetInputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetInputCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetInputCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetInputCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetInputCount")));

    public static VarHandle SessionGetInputCount$VH() {
        return OrtApi.SessionGetInputCount$VH;
    }

    public static MemoryAddress SessionGetInputCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetInputCount$VH.get(seg);
    }

    public static void SessionGetInputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetInputCount$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetInputCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputCount SessionGetInputCount(MemorySegment segment) {
        return SessionGetInputCount.ofAddress(SessionGetInputCount$get(segment));
    }

    static final FunctionDescriptor SessionGetOutputCount$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetOutputCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetOutputCount$FUNC,
            false);

    public interface SessionGetOutputCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionGetOutputCount fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputCount.class,
                    fi,
                    OrtApi.SessionGetOutputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetOutputCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputCount.class,
                    fi,
                    OrtApi.SessionGetOutputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetOutputCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetOutputCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOutputCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetOutputCount")));

    public static VarHandle SessionGetOutputCount$VH() {
        return OrtApi.SessionGetOutputCount$VH;
    }

    public static MemoryAddress SessionGetOutputCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOutputCount$VH.get(seg);
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOutputCount$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOutputCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputCount SessionGetOutputCount(MemorySegment segment) {
        return SessionGetOutputCount.ofAddress(SessionGetOutputCount$get(segment));
    }

    static final FunctionDescriptor SessionGetOverridableInitializerCount$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetOverridableInitializerCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetOverridableInitializerCount$FUNC,
            false);

    public interface SessionGetOverridableInitializerCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionGetOverridableInitializerCount fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerCount.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetOverridableInitializerCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerCount.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetOverridableInitializerCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetOverridableInitializerCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOverridableInitializerCount$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerCount")));

    public static VarHandle SessionGetOverridableInitializerCount$VH() {
        return OrtApi.SessionGetOverridableInitializerCount$VH;
    }

    public static MemoryAddress SessionGetOverridableInitializerCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOverridableInitializerCount$VH.get(seg);
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerCount$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOverridableInitializerCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetOverridableInitializerCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerCount SessionGetOverridableInitializerCount(MemorySegment segment) {
        return SessionGetOverridableInitializerCount.ofAddress(SessionGetOverridableInitializerCount$get(segment));
    }

    static final FunctionDescriptor SessionGetInputTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle SessionGetInputTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetInputTypeInfo$FUNC,
            false);

    public interface SessionGetInputTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(SessionGetInputTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputTypeInfo.class,
                    fi,
                    OrtApi.SessionGetInputTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetInputTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputTypeInfo.class,
                    fi,
                    OrtApi.SessionGetInputTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetInputTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetInputTypeInfo$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetInputTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetInputTypeInfo")));

    public static VarHandle SessionGetInputTypeInfo$VH() {
        return OrtApi.SessionGetInputTypeInfo$VH;
    }

    public static MemoryAddress SessionGetInputTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetInputTypeInfo$VH.get(seg);
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetInputTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetInputTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetInputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetInputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputTypeInfo SessionGetInputTypeInfo(MemorySegment segment) {
        return SessionGetInputTypeInfo.ofAddress(SessionGetInputTypeInfo$get(segment));
    }

    static final FunctionDescriptor SessionGetOutputTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle SessionGetOutputTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetOutputTypeInfo$FUNC,
            false);

    public interface SessionGetOutputTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(SessionGetOutputTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputTypeInfo.class,
                    fi,
                    OrtApi.SessionGetOutputTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetOutputTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputTypeInfo.class,
                    fi,
                    OrtApi.SessionGetOutputTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetOutputTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetOutputTypeInfo$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOutputTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetOutputTypeInfo")));

    public static VarHandle SessionGetOutputTypeInfo$VH() {
        return OrtApi.SessionGetOutputTypeInfo$VH;
    }

    public static MemoryAddress SessionGetOutputTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOutputTypeInfo$VH.get(seg);
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOutputTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOutputTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetOutputTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOutputTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputTypeInfo SessionGetOutputTypeInfo(MemorySegment segment) {
        return SessionGetOutputTypeInfo.ofAddress(SessionGetOutputTypeInfo$get(segment));
    }

    static final FunctionDescriptor SessionGetOverridableInitializerTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle SessionGetOverridableInitializerTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC,
            false);

    public interface SessionGetOverridableInitializerTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(SessionGetOverridableInitializerTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerTypeInfo.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetOverridableInitializerTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerTypeInfo.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetOverridableInitializerTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetOverridableInitializerTypeInfo$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOverridableInitializerTypeInfo$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerTypeInfo")));

    public static VarHandle SessionGetOverridableInitializerTypeInfo$VH() {
        return OrtApi.SessionGetOverridableInitializerTypeInfo$VH;
    }

    public static MemoryAddress SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOverridableInitializerTypeInfo$VH.get(seg);
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOverridableInitializerTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetOverridableInitializerTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerTypeInfo SessionGetOverridableInitializerTypeInfo(
            MemorySegment segment) {
        return SessionGetOverridableInitializerTypeInfo.ofAddress(
                SessionGetOverridableInitializerTypeInfo$get(segment));
    }

    static final FunctionDescriptor SessionGetInputName$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetInputName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetInputName$FUNC,
            false);

    public interface SessionGetInputName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                long x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(SessionGetInputName fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputName.class,
                    fi,
                    OrtApi.SessionGetInputName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetInputName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetInputName.class,
                    fi,
                    OrtApi.SessionGetInputName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetInputName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    long x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetInputName$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetInputName$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetInputName")));

    public static VarHandle SessionGetInputName$VH() {
        return OrtApi.SessionGetInputName$VH;
    }

    public static MemoryAddress SessionGetInputName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetInputName$VH.get(seg);
    }

    public static void SessionGetInputName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetInputName$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetInputName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetInputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetInputName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetInputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetInputName SessionGetInputName(MemorySegment segment) {
        return SessionGetInputName.ofAddress(SessionGetInputName$get(segment));
    }

    static final FunctionDescriptor SessionGetOutputName$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetOutputName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetOutputName$FUNC,
            false);

    public interface SessionGetOutputName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                long x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(SessionGetOutputName fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputName.class,
                    fi,
                    OrtApi.SessionGetOutputName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetOutputName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOutputName.class,
                    fi,
                    OrtApi.SessionGetOutputName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetOutputName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    long x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetOutputName$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOutputName$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetOutputName")));

    public static VarHandle SessionGetOutputName$VH() {
        return OrtApi.SessionGetOutputName$VH;
    }

    public static MemoryAddress SessionGetOutputName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOutputName$VH.get(seg);
    }

    public static void SessionGetOutputName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOutputName$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOutputName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOutputName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOutputName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOutputName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOutputName SessionGetOutputName(MemorySegment segment) {
        return SessionGetOutputName.ofAddress(SessionGetOutputName$get(segment));
    }

    static final FunctionDescriptor SessionGetOverridableInitializerName$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetOverridableInitializerName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetOverridableInitializerName$FUNC,
            false);

    public interface SessionGetOverridableInitializerName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                long x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(SessionGetOverridableInitializerName fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerName.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetOverridableInitializerName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetOverridableInitializerName.class,
                    fi,
                    OrtApi.SessionGetOverridableInitializerName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetOverridableInitializerName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    long x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetOverridableInitializerName$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetOverridableInitializerName$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerName")));

    public static VarHandle SessionGetOverridableInitializerName$VH() {
        return OrtApi.SessionGetOverridableInitializerName$VH;
    }

    public static MemoryAddress SessionGetOverridableInitializerName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetOverridableInitializerName$VH.get(seg);
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerName$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetOverridableInitializerName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetOverridableInitializerName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetOverridableInitializerName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetOverridableInitializerName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetOverridableInitializerName SessionGetOverridableInitializerName(MemorySegment segment) {
        return SessionGetOverridableInitializerName.ofAddress(SessionGetOverridableInitializerName$get(segment));
    }

    static final FunctionDescriptor CreateRunOptions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle CreateRunOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateRunOptions$FUNC,
            false);

    public interface CreateRunOptions {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(CreateRunOptions fi) {
            return RuntimeHelper.upcallStub(
                    CreateRunOptions.class,
                    fi,
                    OrtApi.CreateRunOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateRunOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateRunOptions.class,
                    fi,
                    OrtApi.CreateRunOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateRunOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateRunOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateRunOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateRunOptions")));

    public static VarHandle CreateRunOptions$VH() {
        return OrtApi.CreateRunOptions$VH;
    }

    public static MemoryAddress CreateRunOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateRunOptions$VH.get(seg);
    }

    public static void CreateRunOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateRunOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateRunOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateRunOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateRunOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateRunOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateRunOptions CreateRunOptions(MemorySegment segment) {
        return CreateRunOptions.ofAddress(CreateRunOptions$get(segment));
    }

    static final FunctionDescriptor RunOptionsSetRunLogVerbosityLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle RunOptionsSetRunLogVerbosityLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC,
            false);

    public interface RunOptionsSetRunLogVerbosityLevel {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(RunOptionsSetRunLogVerbosityLevel fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogVerbosityLevel.class,
                    fi,
                    OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsSetRunLogVerbosityLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogVerbosityLevel.class,
                    fi,
                    OrtApi.RunOptionsSetRunLogVerbosityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsSetRunLogVerbosityLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsSetRunLogVerbosityLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetRunLogVerbosityLevel$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("RunOptionsSetRunLogVerbosityLevel")));

    public static VarHandle RunOptionsSetRunLogVerbosityLevel$VH() {
        return OrtApi.RunOptionsSetRunLogVerbosityLevel$VH;
    }

    public static MemoryAddress RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.get(seg);
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunLogVerbosityLevel RunOptionsSetRunLogVerbosityLevel(MemorySegment segment) {
        return RunOptionsSetRunLogVerbosityLevel.ofAddress(RunOptionsSetRunLogVerbosityLevel$get(segment));
    }

    static final FunctionDescriptor RunOptionsSetRunLogSeverityLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle RunOptionsSetRunLogSeverityLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC,
            false);

    public interface RunOptionsSetRunLogSeverityLevel {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(RunOptionsSetRunLogSeverityLevel fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogSeverityLevel.class,
                    fi,
                    OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsSetRunLogSeverityLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunLogSeverityLevel.class,
                    fi,
                    OrtApi.RunOptionsSetRunLogSeverityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsSetRunLogSeverityLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsSetRunLogSeverityLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetRunLogSeverityLevel$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("RunOptionsSetRunLogSeverityLevel")));

    public static VarHandle RunOptionsSetRunLogSeverityLevel$VH() {
        return OrtApi.RunOptionsSetRunLogSeverityLevel$VH;
    }

    public static MemoryAddress RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsSetRunLogSeverityLevel$VH.get(seg);
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RunOptionsSetRunLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunLogSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetRunLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunLogSeverityLevel RunOptionsSetRunLogSeverityLevel(MemorySegment segment) {
        return RunOptionsSetRunLogSeverityLevel.ofAddress(RunOptionsSetRunLogSeverityLevel$get(segment));
    }

    static final FunctionDescriptor RunOptionsSetRunTag$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RunOptionsSetRunTag$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsSetRunTag$FUNC,
            false);

    public interface RunOptionsSetRunTag {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(RunOptionsSetRunTag fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunTag.class,
                    fi,
                    OrtApi.RunOptionsSetRunTag$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsSetRunTag fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetRunTag.class,
                    fi,
                    OrtApi.RunOptionsSetRunTag$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsSetRunTag ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsSetRunTag$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetRunTag$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RunOptionsSetRunTag")));

    public static VarHandle RunOptionsSetRunTag$VH() {
        return OrtApi.RunOptionsSetRunTag$VH;
    }

    public static MemoryAddress RunOptionsSetRunTag$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsSetRunTag$VH.get(seg);
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetRunTag$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetRunTag$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsSetRunTag$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetRunTag$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetRunTag$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetRunTag RunOptionsSetRunTag(MemorySegment segment) {
        return RunOptionsSetRunTag.ofAddress(RunOptionsSetRunTag$get(segment));
    }

    static final FunctionDescriptor RunOptionsGetRunLogVerbosityLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RunOptionsGetRunLogVerbosityLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC,
            false);

    public interface RunOptionsGetRunLogVerbosityLevel {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(RunOptionsGetRunLogVerbosityLevel fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogVerbosityLevel.class,
                    fi,
                    OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsGetRunLogVerbosityLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogVerbosityLevel.class,
                    fi,
                    OrtApi.RunOptionsGetRunLogVerbosityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsGetRunLogVerbosityLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsGetRunLogVerbosityLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsGetRunLogVerbosityLevel$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("RunOptionsGetRunLogVerbosityLevel")));

    public static VarHandle RunOptionsGetRunLogVerbosityLevel$VH() {
        return OrtApi.RunOptionsGetRunLogVerbosityLevel$VH;
    }

    public static MemoryAddress RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.get(seg);
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsGetRunLogVerbosityLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunLogVerbosityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogVerbosityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunLogVerbosityLevel RunOptionsGetRunLogVerbosityLevel(MemorySegment segment) {
        return RunOptionsGetRunLogVerbosityLevel.ofAddress(RunOptionsGetRunLogVerbosityLevel$get(segment));
    }

    static final FunctionDescriptor RunOptionsGetRunLogSeverityLevel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RunOptionsGetRunLogSeverityLevel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC,
            false);

    public interface RunOptionsGetRunLogSeverityLevel {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(RunOptionsGetRunLogSeverityLevel fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogSeverityLevel.class,
                    fi,
                    OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsGetRunLogSeverityLevel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunLogSeverityLevel.class,
                    fi,
                    OrtApi.RunOptionsGetRunLogSeverityLevel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsGetRunLogSeverityLevel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsGetRunLogSeverityLevel$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsGetRunLogSeverityLevel$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("RunOptionsGetRunLogSeverityLevel")));

    public static VarHandle RunOptionsGetRunLogSeverityLevel$VH() {
        return OrtApi.RunOptionsGetRunLogSeverityLevel$VH;
    }

    public static MemoryAddress RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsGetRunLogSeverityLevel$VH.get(seg);
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogSeverityLevel$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsGetRunLogSeverityLevel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RunOptionsGetRunLogSeverityLevel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunLogSeverityLevel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsGetRunLogSeverityLevel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunLogSeverityLevel RunOptionsGetRunLogSeverityLevel(MemorySegment segment) {
        return RunOptionsGetRunLogSeverityLevel.ofAddress(RunOptionsGetRunLogSeverityLevel$get(segment));
    }

    static final FunctionDescriptor RunOptionsGetRunTag$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RunOptionsGetRunTag$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsGetRunTag$FUNC,
            false);

    public interface RunOptionsGetRunTag {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(RunOptionsGetRunTag fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunTag.class,
                    fi,
                    OrtApi.RunOptionsGetRunTag$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsGetRunTag fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsGetRunTag.class,
                    fi,
                    OrtApi.RunOptionsGetRunTag$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsGetRunTag ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsGetRunTag$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsGetRunTag$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RunOptionsGetRunTag")));

    public static VarHandle RunOptionsGetRunTag$VH() {
        return OrtApi.RunOptionsGetRunTag$VH;
    }

    public static MemoryAddress RunOptionsGetRunTag$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsGetRunTag$VH.get(seg);
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsGetRunTag$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsGetRunTag$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsGetRunTag$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsGetRunTag$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsGetRunTag$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsGetRunTag RunOptionsGetRunTag(MemorySegment segment) {
        return RunOptionsGetRunTag.ofAddress(RunOptionsGetRunTag$get(segment));
    }

    static final FunctionDescriptor RunOptionsSetTerminate$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle RunOptionsSetTerminate$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsSetTerminate$FUNC,
            false);

    public interface RunOptionsSetTerminate {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(RunOptionsSetTerminate fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetTerminate.class,
                    fi,
                    OrtApi.RunOptionsSetTerminate$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsSetTerminate fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsSetTerminate.class,
                    fi,
                    OrtApi.RunOptionsSetTerminate$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsSetTerminate ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsSetTerminate$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsSetTerminate$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RunOptionsSetTerminate")));

    public static VarHandle RunOptionsSetTerminate$VH() {
        return OrtApi.RunOptionsSetTerminate$VH;
    }

    public static MemoryAddress RunOptionsSetTerminate$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsSetTerminate$VH.get(seg);
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsSetTerminate$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsSetTerminate$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RunOptionsSetTerminate$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsSetTerminate$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsSetTerminate$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsSetTerminate RunOptionsSetTerminate(MemorySegment segment) {
        return RunOptionsSetTerminate.ofAddress(RunOptionsSetTerminate$get(segment));
    }

    static final FunctionDescriptor RunOptionsUnsetTerminate$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle RunOptionsUnsetTerminate$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunOptionsUnsetTerminate$FUNC,
            false);

    public interface RunOptionsUnsetTerminate {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(RunOptionsUnsetTerminate fi) {
            return RuntimeHelper.upcallStub(
                    RunOptionsUnsetTerminate.class,
                    fi,
                    OrtApi.RunOptionsUnsetTerminate$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunOptionsUnsetTerminate fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunOptionsUnsetTerminate.class,
                    fi,
                    OrtApi.RunOptionsUnsetTerminate$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunOptionsUnsetTerminate ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunOptionsUnsetTerminate$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunOptionsUnsetTerminate$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RunOptionsUnsetTerminate")));

    public static VarHandle RunOptionsUnsetTerminate$VH() {
        return OrtApi.RunOptionsUnsetTerminate$VH;
    }

    public static MemoryAddress RunOptionsUnsetTerminate$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunOptionsUnsetTerminate$VH.get(seg);
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunOptionsUnsetTerminate$VH.set(seg, x);
    }

    public static MemoryAddress RunOptionsUnsetTerminate$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.RunOptionsUnsetTerminate$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunOptionsUnsetTerminate$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunOptionsUnsetTerminate$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunOptionsUnsetTerminate RunOptionsUnsetTerminate(MemorySegment segment) {
        return RunOptionsUnsetTerminate.ofAddress(RunOptionsUnsetTerminate$get(segment));
    }

    static final FunctionDescriptor CreateTensorAsOrtValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_INT, C_POINTER);
    static final MethodHandle CreateTensorAsOrtValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateTensorAsOrtValue$FUNC,
            false);

    public interface CreateTensorAsOrtValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                int x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateTensorAsOrtValue fi) {
            return RuntimeHelper.upcallStub(
                    CreateTensorAsOrtValue.class,
                    fi,
                    OrtApi.CreateTensorAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateTensorAsOrtValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorAsOrtValue.class,
                    fi,
                    OrtApi.CreateTensorAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateTensorAsOrtValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    int x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateTensorAsOrtValue$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorAsOrtValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateTensorAsOrtValue")));

    public static VarHandle CreateTensorAsOrtValue$VH() {
        return OrtApi.CreateTensorAsOrtValue$VH;
    }

    public static MemoryAddress CreateTensorAsOrtValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateTensorAsOrtValue$VH.get(seg);
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateTensorAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorAsOrtValue CreateTensorAsOrtValue(MemorySegment segment) {
        return CreateTensorAsOrtValue.ofAddress(CreateTensorAsOrtValue$get(segment));
    }

    static final FunctionDescriptor CreateTensorWithDataAsOrtValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG, C_INT, C_POINTER);
    static final MethodHandle CreateTensorWithDataAsOrtValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateTensorWithDataAsOrtValue$FUNC,
            false);

    public interface CreateTensorWithDataAsOrtValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3,
                long x4,
                int x5,
                jdk.incubator.foreign.MemoryAddress x6);

        static MemoryAddress allocate(CreateTensorWithDataAsOrtValue fi) {
            return RuntimeHelper.upcallStub(
                    CreateTensorWithDataAsOrtValue.class,
                    fi,
                    OrtApi.CreateTensorWithDataAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateTensorWithDataAsOrtValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorWithDataAsOrtValue.class,
                    fi,
                    OrtApi.CreateTensorWithDataAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateTensorWithDataAsOrtValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    long x4,
                    int x5,
                    jdk.incubator.foreign.MemoryAddress x6) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateTensorWithDataAsOrtValue$MH.invokeExact(
                            (Addressable) addr, x0, x1, x2, x3, x4, x5, x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorWithDataAsOrtValue$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("CreateTensorWithDataAsOrtValue")));

    public static VarHandle CreateTensorWithDataAsOrtValue$VH() {
        return OrtApi.CreateTensorWithDataAsOrtValue$VH;
    }

    public static MemoryAddress CreateTensorWithDataAsOrtValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateTensorWithDataAsOrtValue$VH.get(seg);
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorWithDataAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorWithDataAsOrtValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateTensorWithDataAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorWithDataAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorWithDataAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue(MemorySegment segment) {
        return CreateTensorWithDataAsOrtValue.ofAddress(CreateTensorWithDataAsOrtValue$get(segment));
    }

    static final FunctionDescriptor IsTensor$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle IsTensor$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.IsTensor$FUNC,
            false);

    public interface IsTensor {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(IsTensor fi) {
            return RuntimeHelper.upcallStub(
                    IsTensor.class,
                    fi,
                    OrtApi.IsTensor$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(IsTensor fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    IsTensor.class,
                    fi,
                    OrtApi.IsTensor$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static IsTensor ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.IsTensor$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle IsTensor$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("IsTensor")));

    public static VarHandle IsTensor$VH() {
        return OrtApi.IsTensor$VH;
    }

    public static MemoryAddress IsTensor$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.IsTensor$VH.get(seg);
    }

    public static void IsTensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.IsTensor$VH.set(seg, x);
    }

    public static MemoryAddress IsTensor$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.IsTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void IsTensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.IsTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static IsTensor IsTensor(MemorySegment segment) {
        return IsTensor.ofAddress(IsTensor$get(segment));
    }

    static final FunctionDescriptor GetTensorMutableData$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTensorMutableData$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTensorMutableData$FUNC,
            false);

    public interface GetTensorMutableData {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetTensorMutableData fi) {
            return RuntimeHelper.upcallStub(
                    GetTensorMutableData.class,
                    fi,
                    OrtApi.GetTensorMutableData$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTensorMutableData fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorMutableData.class,
                    fi,
                    OrtApi.GetTensorMutableData$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTensorMutableData ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTensorMutableData$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorMutableData$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetTensorMutableData")));

    public static VarHandle GetTensorMutableData$VH() {
        return OrtApi.GetTensorMutableData$VH;
    }

    public static MemoryAddress GetTensorMutableData$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorMutableData$VH.get(seg);
    }

    public static void GetTensorMutableData$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorMutableData$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorMutableData$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorMutableData$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorMutableData$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorMutableData$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorMutableData GetTensorMutableData(MemorySegment segment) {
        return GetTensorMutableData.ofAddress(GetTensorMutableData$get(segment));
    }

    static final FunctionDescriptor FillStringTensor$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle FillStringTensor$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.FillStringTensor$FUNC,
            false);

    public interface FillStringTensor {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(FillStringTensor fi) {
            return RuntimeHelper.upcallStub(
                    FillStringTensor.class,
                    fi,
                    OrtApi.FillStringTensor$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(FillStringTensor fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    FillStringTensor.class,
                    fi,
                    OrtApi.FillStringTensor$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static FillStringTensor ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.FillStringTensor$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillStringTensor$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("FillStringTensor")));

    public static VarHandle FillStringTensor$VH() {
        return OrtApi.FillStringTensor$VH;
    }

    public static MemoryAddress FillStringTensor$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillStringTensor$VH.get(seg);
    }

    public static void FillStringTensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillStringTensor$VH.set(seg, x);
    }

    public static MemoryAddress FillStringTensor$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillStringTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillStringTensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillStringTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillStringTensor FillStringTensor(MemorySegment segment) {
        return FillStringTensor.ofAddress(FillStringTensor$get(segment));
    }

    static final FunctionDescriptor GetStringTensorDataLength$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetStringTensorDataLength$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetStringTensorDataLength$FUNC,
            false);

    public interface GetStringTensorDataLength {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetStringTensorDataLength fi) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorDataLength.class,
                    fi,
                    OrtApi.GetStringTensorDataLength$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetStringTensorDataLength fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorDataLength.class,
                    fi,
                    OrtApi.GetStringTensorDataLength$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetStringTensorDataLength ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetStringTensorDataLength$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorDataLength$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetStringTensorDataLength")));

    public static VarHandle GetStringTensorDataLength$VH() {
        return OrtApi.GetStringTensorDataLength$VH;
    }

    public static MemoryAddress GetStringTensorDataLength$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetStringTensorDataLength$VH.get(seg);
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorDataLength$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorDataLength$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetStringTensorDataLength$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorDataLength$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorDataLength$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorDataLength GetStringTensorDataLength(MemorySegment segment) {
        return GetStringTensorDataLength.ofAddress(GetStringTensorDataLength$get(segment));
    }

    static final FunctionDescriptor GetStringTensorContent$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG);
    static final MethodHandle GetStringTensorContent$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetStringTensorContent$FUNC,
            false);

    public interface GetStringTensorContent {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3,
                long x4);

        static MemoryAddress allocate(GetStringTensorContent fi) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorContent.class,
                    fi,
                    OrtApi.GetStringTensorContent$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetStringTensorContent fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorContent.class,
                    fi,
                    OrtApi.GetStringTensorContent$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetStringTensorContent ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    long x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetStringTensorContent$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorContent$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetStringTensorContent")));

    public static VarHandle GetStringTensorContent$VH() {
        return OrtApi.GetStringTensorContent$VH;
    }

    public static MemoryAddress GetStringTensorContent$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetStringTensorContent$VH.get(seg);
    }

    public static void GetStringTensorContent$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorContent$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorContent$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetStringTensorContent$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorContent$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorContent$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorContent GetStringTensorContent(MemorySegment segment) {
        return GetStringTensorContent.ofAddress(GetStringTensorContent$get(segment));
    }

    static final FunctionDescriptor CastTypeInfoToTensorInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CastTypeInfoToTensorInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CastTypeInfoToTensorInfo$FUNC,
            false);

    public interface CastTypeInfoToTensorInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CastTypeInfoToTensorInfo fi) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToTensorInfo.class,
                    fi,
                    OrtApi.CastTypeInfoToTensorInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CastTypeInfoToTensorInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToTensorInfo.class,
                    fi,
                    OrtApi.CastTypeInfoToTensorInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CastTypeInfoToTensorInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CastTypeInfoToTensorInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToTensorInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CastTypeInfoToTensorInfo")));

    public static VarHandle CastTypeInfoToTensorInfo$VH() {
        return OrtApi.CastTypeInfoToTensorInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToTensorInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CastTypeInfoToTensorInfo$VH.get(seg);
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToTensorInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToTensorInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CastTypeInfoToTensorInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToTensorInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToTensorInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo(MemorySegment segment) {
        return CastTypeInfoToTensorInfo.ofAddress(CastTypeInfoToTensorInfo$get(segment));
    }

    static final FunctionDescriptor GetOnnxTypeFromTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetOnnxTypeFromTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetOnnxTypeFromTypeInfo$FUNC,
            false);

    public interface GetOnnxTypeFromTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetOnnxTypeFromTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    GetOnnxTypeFromTypeInfo.class,
                    fi,
                    OrtApi.GetOnnxTypeFromTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetOnnxTypeFromTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOnnxTypeFromTypeInfo.class,
                    fi,
                    OrtApi.GetOnnxTypeFromTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetOnnxTypeFromTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetOnnxTypeFromTypeInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOnnxTypeFromTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetOnnxTypeFromTypeInfo")));

    public static VarHandle GetOnnxTypeFromTypeInfo$VH() {
        return OrtApi.GetOnnxTypeFromTypeInfo$VH;
    }

    public static MemoryAddress GetOnnxTypeFromTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetOnnxTypeFromTypeInfo$VH.get(seg);
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetOnnxTypeFromTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetOnnxTypeFromTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetOnnxTypeFromTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOnnxTypeFromTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetOnnxTypeFromTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOnnxTypeFromTypeInfo GetOnnxTypeFromTypeInfo(MemorySegment segment) {
        return GetOnnxTypeFromTypeInfo.ofAddress(GetOnnxTypeFromTypeInfo$get(segment));
    }

    static final FunctionDescriptor CreateTensorTypeAndShapeInfo$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle CreateTensorTypeAndShapeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateTensorTypeAndShapeInfo$FUNC,
            false);

    public interface CreateTensorTypeAndShapeInfo {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(CreateTensorTypeAndShapeInfo fi) {
            return RuntimeHelper.upcallStub(
                    CreateTensorTypeAndShapeInfo.class,
                    fi,
                    OrtApi.CreateTensorTypeAndShapeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateTensorTypeAndShapeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorTypeAndShapeInfo.class,
                    fi,
                    OrtApi.CreateTensorTypeAndShapeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateTensorTypeAndShapeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateTensorTypeAndShapeInfo$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorTypeAndShapeInfo$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("CreateTensorTypeAndShapeInfo")));

    public static VarHandle CreateTensorTypeAndShapeInfo$VH() {
        return OrtApi.CreateTensorTypeAndShapeInfo$VH;
    }

    public static MemoryAddress CreateTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateTensorTypeAndShapeInfo$VH.get(seg);
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorTypeAndShapeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateTensorTypeAndShapeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorTypeAndShapeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorTypeAndShapeInfo CreateTensorTypeAndShapeInfo(MemorySegment segment) {
        return CreateTensorTypeAndShapeInfo.ofAddress(CreateTensorTypeAndShapeInfo$get(segment));
    }

    static final FunctionDescriptor SetTensorElementType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetTensorElementType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetTensorElementType$FUNC,
            false);

    public interface SetTensorElementType {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetTensorElementType fi) {
            return RuntimeHelper.upcallStub(
                    SetTensorElementType.class,
                    fi,
                    OrtApi.SetTensorElementType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetTensorElementType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetTensorElementType.class,
                    fi,
                    OrtApi.SetTensorElementType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetTensorElementType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetTensorElementType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetTensorElementType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetTensorElementType")));

    public static VarHandle SetTensorElementType$VH() {
        return OrtApi.SetTensorElementType$VH;
    }

    public static MemoryAddress SetTensorElementType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetTensorElementType$VH.get(seg);
    }

    public static void SetTensorElementType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetTensorElementType$VH.set(seg, x);
    }

    public static MemoryAddress SetTensorElementType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetTensorElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetTensorElementType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetTensorElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetTensorElementType SetTensorElementType(MemorySegment segment) {
        return SetTensorElementType.ofAddress(SetTensorElementType$get(segment));
    }

    static final FunctionDescriptor SetDimensions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle SetDimensions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetDimensions$FUNC,
            false);

    public interface SetDimensions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(SetDimensions fi) {
            return RuntimeHelper.upcallStub(
                    SetDimensions.class,
                    fi,
                    OrtApi.SetDimensions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetDimensions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetDimensions.class,
                    fi,
                    OrtApi.SetDimensions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetDimensions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetDimensions$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetDimensions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetDimensions")));

    public static VarHandle SetDimensions$VH() {
        return OrtApi.SetDimensions$VH;
    }

    public static MemoryAddress SetDimensions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetDimensions$VH.get(seg);
    }

    public static void SetDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetDimensions$VH.set(seg, x);
    }

    public static MemoryAddress SetDimensions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetDimensions SetDimensions(MemorySegment segment) {
        return SetDimensions.ofAddress(SetDimensions$get(segment));
    }

    static final FunctionDescriptor GetTensorElementType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTensorElementType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTensorElementType$FUNC,
            false);

    public interface GetTensorElementType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetTensorElementType fi) {
            return RuntimeHelper.upcallStub(
                    GetTensorElementType.class,
                    fi,
                    OrtApi.GetTensorElementType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTensorElementType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorElementType.class,
                    fi,
                    OrtApi.GetTensorElementType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTensorElementType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTensorElementType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorElementType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetTensorElementType")));

    public static VarHandle GetTensorElementType$VH() {
        return OrtApi.GetTensorElementType$VH;
    }

    public static MemoryAddress GetTensorElementType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorElementType$VH.get(seg);
    }

    public static void GetTensorElementType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorElementType$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorElementType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorElementType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorElementType GetTensorElementType(MemorySegment segment) {
        return GetTensorElementType.ofAddress(GetTensorElementType$get(segment));
    }

    static final FunctionDescriptor GetDimensionsCount$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetDimensionsCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetDimensionsCount$FUNC,
            false);

    public interface GetDimensionsCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetDimensionsCount fi) {
            return RuntimeHelper.upcallStub(
                    GetDimensionsCount.class,
                    fi,
                    OrtApi.GetDimensionsCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetDimensionsCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetDimensionsCount.class,
                    fi,
                    OrtApi.GetDimensionsCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetDimensionsCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetDimensionsCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDimensionsCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetDimensionsCount")));

    public static VarHandle GetDimensionsCount$VH() {
        return OrtApi.GetDimensionsCount$VH;
    }

    public static MemoryAddress GetDimensionsCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetDimensionsCount$VH.get(seg);
    }

    public static void GetDimensionsCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDimensionsCount$VH.set(seg, x);
    }

    public static MemoryAddress GetDimensionsCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetDimensionsCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDimensionsCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDimensionsCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDimensionsCount GetDimensionsCount(MemorySegment segment) {
        return GetDimensionsCount.ofAddress(GetDimensionsCount$get(segment));
    }

    static final FunctionDescriptor GetDimensions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle GetDimensions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetDimensions$FUNC,
            false);

    public interface GetDimensions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(GetDimensions fi) {
            return RuntimeHelper.upcallStub(
                    GetDimensions.class,
                    fi,
                    OrtApi.GetDimensions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetDimensions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetDimensions.class,
                    fi,
                    OrtApi.GetDimensions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetDimensions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetDimensions$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDimensions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetDimensions")));

    public static VarHandle GetDimensions$VH() {
        return OrtApi.GetDimensions$VH;
    }

    public static MemoryAddress GetDimensions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetDimensions$VH.get(seg);
    }

    public static void GetDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDimensions$VH.set(seg, x);
    }

    public static MemoryAddress GetDimensions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDimensions GetDimensions(MemorySegment segment) {
        return GetDimensions.ofAddress(GetDimensions$get(segment));
    }

    static final FunctionDescriptor GetSymbolicDimensions$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle GetSymbolicDimensions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSymbolicDimensions$FUNC,
            false);

    public interface GetSymbolicDimensions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(GetSymbolicDimensions fi) {
            return RuntimeHelper.upcallStub(
                    GetSymbolicDimensions.class,
                    fi,
                    OrtApi.GetSymbolicDimensions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSymbolicDimensions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSymbolicDimensions.class,
                    fi,
                    OrtApi.GetSymbolicDimensions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSymbolicDimensions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSymbolicDimensions$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSymbolicDimensions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetSymbolicDimensions")));

    public static VarHandle GetSymbolicDimensions$VH() {
        return OrtApi.GetSymbolicDimensions$VH;
    }

    public static MemoryAddress GetSymbolicDimensions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSymbolicDimensions$VH.get(seg);
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSymbolicDimensions$VH.set(seg, x);
    }

    public static MemoryAddress GetSymbolicDimensions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSymbolicDimensions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSymbolicDimensions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSymbolicDimensions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSymbolicDimensions GetSymbolicDimensions(MemorySegment segment) {
        return GetSymbolicDimensions.ofAddress(GetSymbolicDimensions$get(segment));
    }

    static final FunctionDescriptor GetTensorShapeElementCount$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTensorShapeElementCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTensorShapeElementCount$FUNC,
            false);

    public interface GetTensorShapeElementCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetTensorShapeElementCount fi) {
            return RuntimeHelper.upcallStub(
                    GetTensorShapeElementCount.class,
                    fi,
                    OrtApi.GetTensorShapeElementCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTensorShapeElementCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorShapeElementCount.class,
                    fi,
                    OrtApi.GetTensorShapeElementCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTensorShapeElementCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTensorShapeElementCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorShapeElementCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetTensorShapeElementCount")));

    public static VarHandle GetTensorShapeElementCount$VH() {
        return OrtApi.GetTensorShapeElementCount$VH;
    }

    public static MemoryAddress GetTensorShapeElementCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorShapeElementCount$VH.get(seg);
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorShapeElementCount$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorShapeElementCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetTensorShapeElementCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorShapeElementCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorShapeElementCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorShapeElementCount GetTensorShapeElementCount(MemorySegment segment) {
        return GetTensorShapeElementCount.ofAddress(GetTensorShapeElementCount$get(segment));
    }

    static final FunctionDescriptor GetTensorTypeAndShape$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTensorTypeAndShape$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTensorTypeAndShape$FUNC,
            false);

    public interface GetTensorTypeAndShape {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetTensorTypeAndShape fi) {
            return RuntimeHelper.upcallStub(
                    GetTensorTypeAndShape.class,
                    fi,
                    OrtApi.GetTensorTypeAndShape$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTensorTypeAndShape fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorTypeAndShape.class,
                    fi,
                    OrtApi.GetTensorTypeAndShape$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTensorTypeAndShape ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTensorTypeAndShape$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorTypeAndShape$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetTensorTypeAndShape")));

    public static VarHandle GetTensorTypeAndShape$VH() {
        return OrtApi.GetTensorTypeAndShape$VH;
    }

    public static MemoryAddress GetTensorTypeAndShape$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorTypeAndShape$VH.get(seg);
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorTypeAndShape$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorTypeAndShape$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorTypeAndShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorTypeAndShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorTypeAndShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorTypeAndShape GetTensorTypeAndShape(MemorySegment segment) {
        return GetTensorTypeAndShape.ofAddress(GetTensorTypeAndShape$get(segment));
    }

    static final FunctionDescriptor GetTypeInfo$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTypeInfo$FUNC,
            false);

    public interface GetTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    GetTypeInfo.class,
                    fi,
                    OrtApi.GetTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTypeInfo.class,
                    fi,
                    OrtApi.GetTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTypeInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetTypeInfo")));

    public static VarHandle GetTypeInfo$VH() {
        return OrtApi.GetTypeInfo$VH;
    }

    public static MemoryAddress GetTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTypeInfo$VH.get(seg);
    }

    public static void GetTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTypeInfo GetTypeInfo(MemorySegment segment) {
        return GetTypeInfo.ofAddress(GetTypeInfo$get(segment));
    }

    static final FunctionDescriptor GetValueType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetValueType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetValueType$FUNC,
            false);

    public interface GetValueType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetValueType fi) {
            return RuntimeHelper.upcallStub(
                    GetValueType.class,
                    fi,
                    OrtApi.GetValueType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetValueType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetValueType.class,
                    fi,
                    OrtApi.GetValueType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetValueType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetValueType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetValueType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetValueType")));

    public static VarHandle GetValueType$VH() {
        return OrtApi.GetValueType$VH;
    }

    public static MemoryAddress GetValueType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetValueType$VH.get(seg);
    }

    public static void GetValueType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetValueType$VH.set(seg, x);
    }

    public static MemoryAddress GetValueType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetValueType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValueType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetValueType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValueType GetValueType(MemorySegment segment) {
        return GetValueType.ofAddress(GetValueType$get(segment));
    }

    static final FunctionDescriptor CreateMemoryInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT, C_INT, C_INT, C_POINTER);
    static final MethodHandle CreateMemoryInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;IIILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateMemoryInfo$FUNC,
            false);

    public interface CreateMemoryInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateMemoryInfo fi) {
            return RuntimeHelper.upcallStub(
                    CreateMemoryInfo.class,
                    fi,
                    OrtApi.CreateMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;IIILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateMemoryInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateMemoryInfo.class,
                    fi,
                    OrtApi.CreateMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;IIILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateMemoryInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    int x1,
                    int x2,
                    int x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateMemoryInfo$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateMemoryInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateMemoryInfo")));

    public static VarHandle CreateMemoryInfo$VH() {
        return OrtApi.CreateMemoryInfo$VH;
    }

    public static MemoryAddress CreateMemoryInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateMemoryInfo$VH.get(seg);
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress CreateMemoryInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateMemoryInfo CreateMemoryInfo(MemorySegment segment) {
        return CreateMemoryInfo.ofAddress(CreateMemoryInfo$get(segment));
    }

    static final FunctionDescriptor CreateCpuMemoryInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_INT, C_INT, C_POINTER);
    static final MethodHandle CreateCpuMemoryInfo$MH = RuntimeHelper.downcallHandle(
            "(IILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateCpuMemoryInfo$FUNC,
            false);

    public interface CreateCpuMemoryInfo {

        jdk.incubator.foreign.MemoryAddress apply(int x0, int x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(CreateCpuMemoryInfo fi) {
            return RuntimeHelper.upcallStub(
                    CreateCpuMemoryInfo.class,
                    fi,
                    OrtApi.CreateCpuMemoryInfo$FUNC,
                    "(IILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateCpuMemoryInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateCpuMemoryInfo.class,
                    fi,
                    OrtApi.CreateCpuMemoryInfo$FUNC,
                    "(IILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateCpuMemoryInfo ofAddress(MemoryAddress addr) {
            return (int x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateCpuMemoryInfo$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateCpuMemoryInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateCpuMemoryInfo")));

    public static VarHandle CreateCpuMemoryInfo$VH() {
        return OrtApi.CreateCpuMemoryInfo$VH;
    }

    public static MemoryAddress CreateCpuMemoryInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateCpuMemoryInfo$VH.get(seg);
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateCpuMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress CreateCpuMemoryInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateCpuMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateCpuMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateCpuMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateCpuMemoryInfo CreateCpuMemoryInfo(MemorySegment segment) {
        return CreateCpuMemoryInfo.ofAddress(CreateCpuMemoryInfo$get(segment));
    }

    static final FunctionDescriptor CompareMemoryInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CompareMemoryInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CompareMemoryInfo$FUNC,
            false);

    public interface CompareMemoryInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(CompareMemoryInfo fi) {
            return RuntimeHelper.upcallStub(
                    CompareMemoryInfo.class,
                    fi,
                    OrtApi.CompareMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CompareMemoryInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CompareMemoryInfo.class,
                    fi,
                    OrtApi.CompareMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CompareMemoryInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CompareMemoryInfo$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CompareMemoryInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CompareMemoryInfo")));

    public static VarHandle CompareMemoryInfo$VH() {
        return OrtApi.CompareMemoryInfo$VH;
    }

    public static MemoryAddress CompareMemoryInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CompareMemoryInfo$VH.get(seg);
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CompareMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress CompareMemoryInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CompareMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CompareMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CompareMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CompareMemoryInfo CompareMemoryInfo(MemorySegment segment) {
        return CompareMemoryInfo.ofAddress(CompareMemoryInfo$get(segment));
    }

    static final FunctionDescriptor MemoryInfoGetName$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle MemoryInfoGetName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.MemoryInfoGetName$FUNC,
            false);

    public interface MemoryInfoGetName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(MemoryInfoGetName fi) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetName.class,
                    fi,
                    OrtApi.MemoryInfoGetName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(MemoryInfoGetName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetName.class,
                    fi,
                    OrtApi.MemoryInfoGetName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static MemoryInfoGetName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.MemoryInfoGetName$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetName$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("MemoryInfoGetName")));

    public static VarHandle MemoryInfoGetName$VH() {
        return OrtApi.MemoryInfoGetName$VH;
    }

    public static MemoryAddress MemoryInfoGetName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetName$VH.get(seg);
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetName$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetName MemoryInfoGetName(MemorySegment segment) {
        return MemoryInfoGetName.ofAddress(MemoryInfoGetName$get(segment));
    }

    static final FunctionDescriptor MemoryInfoGetId$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle MemoryInfoGetId$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.MemoryInfoGetId$FUNC,
            false);

    public interface MemoryInfoGetId {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(MemoryInfoGetId fi) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetId.class,
                    fi,
                    OrtApi.MemoryInfoGetId$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(MemoryInfoGetId fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetId.class,
                    fi,
                    OrtApi.MemoryInfoGetId$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static MemoryInfoGetId ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.MemoryInfoGetId$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetId$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("MemoryInfoGetId")));

    public static VarHandle MemoryInfoGetId$VH() {
        return OrtApi.MemoryInfoGetId$VH;
    }

    public static MemoryAddress MemoryInfoGetId$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetId$VH.get(seg);
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetId$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetId$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetId MemoryInfoGetId(MemorySegment segment) {
        return MemoryInfoGetId.ofAddress(MemoryInfoGetId$get(segment));
    }

    static final FunctionDescriptor MemoryInfoGetMemType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle MemoryInfoGetMemType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.MemoryInfoGetMemType$FUNC,
            false);

    public interface MemoryInfoGetMemType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(MemoryInfoGetMemType fi) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetMemType.class,
                    fi,
                    OrtApi.MemoryInfoGetMemType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(MemoryInfoGetMemType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetMemType.class,
                    fi,
                    OrtApi.MemoryInfoGetMemType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static MemoryInfoGetMemType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.MemoryInfoGetMemType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetMemType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("MemoryInfoGetMemType")));

    public static VarHandle MemoryInfoGetMemType$VH() {
        return OrtApi.MemoryInfoGetMemType$VH;
    }

    public static MemoryAddress MemoryInfoGetMemType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetMemType$VH.get(seg);
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetMemType$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetMemType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetMemType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetMemType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetMemType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetMemType MemoryInfoGetMemType(MemorySegment segment) {
        return MemoryInfoGetMemType.ofAddress(MemoryInfoGetMemType$get(segment));
    }

    static final FunctionDescriptor MemoryInfoGetType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle MemoryInfoGetType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.MemoryInfoGetType$FUNC,
            false);

    public interface MemoryInfoGetType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(MemoryInfoGetType fi) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetType.class,
                    fi,
                    OrtApi.MemoryInfoGetType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(MemoryInfoGetType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    MemoryInfoGetType.class,
                    fi,
                    OrtApi.MemoryInfoGetType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static MemoryInfoGetType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.MemoryInfoGetType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle MemoryInfoGetType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("MemoryInfoGetType")));

    public static VarHandle MemoryInfoGetType$VH() {
        return OrtApi.MemoryInfoGetType$VH;
    }

    public static MemoryAddress MemoryInfoGetType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetType$VH.get(seg);
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.MemoryInfoGetType$VH.set(seg, x);
    }

    public static MemoryAddress MemoryInfoGetType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.MemoryInfoGetType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void MemoryInfoGetType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.MemoryInfoGetType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static MemoryInfoGetType MemoryInfoGetType(MemorySegment segment) {
        return MemoryInfoGetType.ofAddress(MemoryInfoGetType$get(segment));
    }

    static final FunctionDescriptor AllocatorAlloc$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle AllocatorAlloc$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AllocatorAlloc$FUNC,
            false);

    public interface AllocatorAlloc {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(AllocatorAlloc fi) {
            return RuntimeHelper.upcallStub(
                    AllocatorAlloc.class,
                    fi,
                    OrtApi.AllocatorAlloc$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AllocatorAlloc fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AllocatorAlloc.class,
                    fi,
                    OrtApi.AllocatorAlloc$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AllocatorAlloc ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AllocatorAlloc$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AllocatorAlloc$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AllocatorAlloc")));

    public static VarHandle AllocatorAlloc$VH() {
        return OrtApi.AllocatorAlloc$VH;
    }

    public static MemoryAddress AllocatorAlloc$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AllocatorAlloc$VH.get(seg);
    }

    public static void AllocatorAlloc$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AllocatorAlloc$VH.set(seg, x);
    }

    public static MemoryAddress AllocatorAlloc$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AllocatorAlloc$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorAlloc$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AllocatorAlloc$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorAlloc AllocatorAlloc(MemorySegment segment) {
        return AllocatorAlloc.ofAddress(AllocatorAlloc$get(segment));
    }

    static final FunctionDescriptor AllocatorFree$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle AllocatorFree$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AllocatorFree$FUNC,
            false);

    public interface AllocatorFree {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(AllocatorFree fi) {
            return RuntimeHelper.upcallStub(
                    AllocatorFree.class,
                    fi,
                    OrtApi.AllocatorFree$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AllocatorFree fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AllocatorFree.class,
                    fi,
                    OrtApi.AllocatorFree$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AllocatorFree ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AllocatorFree$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AllocatorFree$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AllocatorFree")));

    public static VarHandle AllocatorFree$VH() {
        return OrtApi.AllocatorFree$VH;
    }

    public static MemoryAddress AllocatorFree$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AllocatorFree$VH.get(seg);
    }

    public static void AllocatorFree$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AllocatorFree$VH.set(seg, x);
    }

    public static MemoryAddress AllocatorFree$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AllocatorFree$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorFree$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AllocatorFree$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorFree AllocatorFree(MemorySegment segment) {
        return AllocatorFree.ofAddress(AllocatorFree$get(segment));
    }

    static final FunctionDescriptor AllocatorGetInfo$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle AllocatorGetInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AllocatorGetInfo$FUNC,
            false);

    public interface AllocatorGetInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(AllocatorGetInfo fi) {
            return RuntimeHelper.upcallStub(
                    AllocatorGetInfo.class,
                    fi,
                    OrtApi.AllocatorGetInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AllocatorGetInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AllocatorGetInfo.class,
                    fi,
                    OrtApi.AllocatorGetInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AllocatorGetInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AllocatorGetInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AllocatorGetInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AllocatorGetInfo")));

    public static VarHandle AllocatorGetInfo$VH() {
        return OrtApi.AllocatorGetInfo$VH;
    }

    public static MemoryAddress AllocatorGetInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AllocatorGetInfo$VH.get(seg);
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AllocatorGetInfo$VH.set(seg, x);
    }

    public static MemoryAddress AllocatorGetInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AllocatorGetInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AllocatorGetInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AllocatorGetInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AllocatorGetInfo AllocatorGetInfo(MemorySegment segment) {
        return AllocatorGetInfo.ofAddress(AllocatorGetInfo$get(segment));
    }

    static final FunctionDescriptor GetAllocatorWithDefaultOptions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle GetAllocatorWithDefaultOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetAllocatorWithDefaultOptions$FUNC,
            false);

    public interface GetAllocatorWithDefaultOptions {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetAllocatorWithDefaultOptions fi) {
            return RuntimeHelper.upcallStub(
                    GetAllocatorWithDefaultOptions.class,
                    fi,
                    OrtApi.GetAllocatorWithDefaultOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetAllocatorWithDefaultOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetAllocatorWithDefaultOptions.class,
                    fi,
                    OrtApi.GetAllocatorWithDefaultOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetAllocatorWithDefaultOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetAllocatorWithDefaultOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetAllocatorWithDefaultOptions$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("GetAllocatorWithDefaultOptions")));

    public static VarHandle GetAllocatorWithDefaultOptions$VH() {
        return OrtApi.GetAllocatorWithDefaultOptions$VH;
    }

    public static MemoryAddress GetAllocatorWithDefaultOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetAllocatorWithDefaultOptions$VH.get(seg);
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetAllocatorWithDefaultOptions$VH.set(seg, x);
    }

    public static MemoryAddress GetAllocatorWithDefaultOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetAllocatorWithDefaultOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetAllocatorWithDefaultOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetAllocatorWithDefaultOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions(MemorySegment segment) {
        return GetAllocatorWithDefaultOptions.ofAddress(GetAllocatorWithDefaultOptions$get(segment));
    }

    static final FunctionDescriptor AddFreeDimensionOverride$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle AddFreeDimensionOverride$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AddFreeDimensionOverride$FUNC,
            false);

    public interface AddFreeDimensionOverride {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(AddFreeDimensionOverride fi) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverride.class,
                    fi,
                    OrtApi.AddFreeDimensionOverride$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AddFreeDimensionOverride fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverride.class,
                    fi,
                    OrtApi.AddFreeDimensionOverride$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AddFreeDimensionOverride ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AddFreeDimensionOverride$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddFreeDimensionOverride$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AddFreeDimensionOverride")));

    public static VarHandle AddFreeDimensionOverride$VH() {
        return OrtApi.AddFreeDimensionOverride$VH;
    }

    public static MemoryAddress AddFreeDimensionOverride$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverride$VH.get(seg);
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverride$VH.set(seg, x);
    }

    public static MemoryAddress AddFreeDimensionOverride$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.AddFreeDimensionOverride$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddFreeDimensionOverride$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverride$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddFreeDimensionOverride AddFreeDimensionOverride(MemorySegment segment) {
        return AddFreeDimensionOverride.ofAddress(AddFreeDimensionOverride$get(segment));
    }

    static final FunctionDescriptor GetValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT, C_POINTER, C_POINTER);
    static final MethodHandle GetValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetValue$FUNC,
            false);

    public interface GetValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                int x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(GetValue fi) {
            return RuntimeHelper.upcallStub(
                    GetValue.class,
                    fi,
                    OrtApi.GetValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetValue.class,
                    fi,
                    OrtApi.GetValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    int x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetValue$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetValue")));

    public static VarHandle GetValue$VH() {
        return OrtApi.GetValue$VH;
    }

    public static MemoryAddress GetValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetValue$VH.get(seg);
    }

    public static void GetValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetValue$VH.set(seg, x);
    }

    public static MemoryAddress GetValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValue GetValue(MemorySegment segment) {
        return GetValue.ofAddress(GetValue$get(segment));
    }

    static final FunctionDescriptor GetValueCount$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetValueCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetValueCount$FUNC,
            false);

    public interface GetValueCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetValueCount fi) {
            return RuntimeHelper.upcallStub(
                    GetValueCount.class,
                    fi,
                    OrtApi.GetValueCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetValueCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetValueCount.class,
                    fi,
                    OrtApi.GetValueCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetValueCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetValueCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetValueCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetValueCount")));

    public static VarHandle GetValueCount$VH() {
        return OrtApi.GetValueCount$VH;
    }

    public static MemoryAddress GetValueCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetValueCount$VH.get(seg);
    }

    public static void GetValueCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetValueCount$VH.set(seg, x);
    }

    public static MemoryAddress GetValueCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetValueCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetValueCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetValueCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetValueCount GetValueCount(MemorySegment segment) {
        return GetValueCount.ofAddress(GetValueCount$get(segment));
    }

    static final FunctionDescriptor CreateValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_INT, C_POINTER);
    static final MethodHandle CreateValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateValue$FUNC,
            false);

    public interface CreateValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, int x2, jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(CreateValue fi) {
            return RuntimeHelper.upcallStub(
                    CreateValue.class,
                    fi,
                    OrtApi.CreateValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateValue.class,
                    fi,
                    OrtApi.CreateValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    long x1,
                    int x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateValue$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateValue")));

    public static VarHandle CreateValue$VH() {
        return OrtApi.CreateValue$VH;
    }

    public static MemoryAddress CreateValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateValue$VH.get(seg);
    }

    public static void CreateValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateValue CreateValue(MemorySegment segment) {
        return CreateValue.ofAddress(CreateValue$get(segment));
    }

    static final FunctionDescriptor CreateOpaqueValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle CreateOpaqueValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateOpaqueValue$FUNC,
            false);

    public interface CreateOpaqueValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateOpaqueValue fi) {
            return RuntimeHelper.upcallStub(
                    CreateOpaqueValue.class,
                    fi,
                    OrtApi.CreateOpaqueValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateOpaqueValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateOpaqueValue.class,
                    fi,
                    OrtApi.CreateOpaqueValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateOpaqueValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateOpaqueValue$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateOpaqueValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateOpaqueValue")));

    public static VarHandle CreateOpaqueValue$VH() {
        return OrtApi.CreateOpaqueValue$VH;
    }

    public static MemoryAddress CreateOpaqueValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateOpaqueValue$VH.get(seg);
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateOpaqueValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateOpaqueValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateOpaqueValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateOpaqueValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateOpaqueValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateOpaqueValue CreateOpaqueValue(MemorySegment segment) {
        return CreateOpaqueValue.ofAddress(CreateOpaqueValue$get(segment));
    }

    static final FunctionDescriptor GetOpaqueValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle GetOpaqueValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetOpaqueValue$FUNC,
            false);

    public interface GetOpaqueValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3,
                long x4);

        static MemoryAddress allocate(GetOpaqueValue fi) {
            return RuntimeHelper.upcallStub(
                    GetOpaqueValue.class,
                    fi,
                    OrtApi.GetOpaqueValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetOpaqueValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOpaqueValue.class,
                    fi,
                    OrtApi.GetOpaqueValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetOpaqueValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    long x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetOpaqueValue$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOpaqueValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetOpaqueValue")));

    public static VarHandle GetOpaqueValue$VH() {
        return OrtApi.GetOpaqueValue$VH;
    }

    public static MemoryAddress GetOpaqueValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetOpaqueValue$VH.get(seg);
    }

    public static void GetOpaqueValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetOpaqueValue$VH.set(seg, x);
    }

    public static MemoryAddress GetOpaqueValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetOpaqueValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOpaqueValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetOpaqueValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOpaqueValue GetOpaqueValue(MemorySegment segment) {
        return GetOpaqueValue.ofAddress(GetOpaqueValue$get(segment));
    }

    static final FunctionDescriptor KernelInfoGetAttribute_float$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelInfoGetAttribute_float$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelInfoGetAttribute_float$FUNC,
            false);

    public interface KernelInfoGetAttribute_float {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(KernelInfoGetAttribute_float fi) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_float.class,
                    fi,
                    OrtApi.KernelInfoGetAttribute_float$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelInfoGetAttribute_float fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_float.class,
                    fi,
                    OrtApi.KernelInfoGetAttribute_float$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelInfoGetAttribute_float ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelInfoGetAttribute_float$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_float$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_float")));

    public static VarHandle KernelInfoGetAttribute_float$VH() {
        return OrtApi.KernelInfoGetAttribute_float$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_float$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_float$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_float$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_float$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_float$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_float$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_float$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_float KernelInfoGetAttribute_float(MemorySegment segment) {
        return KernelInfoGetAttribute_float.ofAddress(KernelInfoGetAttribute_float$get(segment));
    }

    static final FunctionDescriptor KernelInfoGetAttribute_int64$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelInfoGetAttribute_int64$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelInfoGetAttribute_int64$FUNC,
            false);

    public interface KernelInfoGetAttribute_int64 {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(KernelInfoGetAttribute_int64 fi) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_int64.class,
                    fi,
                    OrtApi.KernelInfoGetAttribute_int64$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelInfoGetAttribute_int64 fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_int64.class,
                    fi,
                    OrtApi.KernelInfoGetAttribute_int64$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelInfoGetAttribute_int64 ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelInfoGetAttribute_int64$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_int64$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_int64")));

    public static VarHandle KernelInfoGetAttribute_int64$VH() {
        return OrtApi.KernelInfoGetAttribute_int64$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_int64$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_int64$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_int64$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_int64$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_int64$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_int64$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_int64$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_int64 KernelInfoGetAttribute_int64(MemorySegment segment) {
        return KernelInfoGetAttribute_int64.ofAddress(KernelInfoGetAttribute_int64$get(segment));
    }

    static final FunctionDescriptor KernelInfoGetAttribute_string$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelInfoGetAttribute_string$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelInfoGetAttribute_string$FUNC,
            false);

    public interface KernelInfoGetAttribute_string {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(KernelInfoGetAttribute_string fi) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_string.class,
                    fi,
                    OrtApi.KernelInfoGetAttribute_string$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelInfoGetAttribute_string fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttribute_string.class,
                    fi,
                    OrtApi.KernelInfoGetAttribute_string$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelInfoGetAttribute_string ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelInfoGetAttribute_string$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttribute_string$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_string")));

    public static VarHandle KernelInfoGetAttribute_string$VH() {
        return OrtApi.KernelInfoGetAttribute_string$VH;
    }

    public static MemoryAddress KernelInfoGetAttribute_string$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelInfoGetAttribute_string$VH.get(seg);
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_string$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttribute_string$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttribute_string$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttribute_string$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttribute_string$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttribute_string KernelInfoGetAttribute_string(MemorySegment segment) {
        return KernelInfoGetAttribute_string.ofAddress(KernelInfoGetAttribute_string$get(segment));
    }

    static final FunctionDescriptor KernelContext_GetInputCount$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelContext_GetInputCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelContext_GetInputCount$FUNC,
            false);

    public interface KernelContext_GetInputCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(KernelContext_GetInputCount fi) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInputCount.class,
                    fi,
                    OrtApi.KernelContext_GetInputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelContext_GetInputCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInputCount.class,
                    fi,
                    OrtApi.KernelContext_GetInputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelContext_GetInputCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelContext_GetInputCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetInputCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("KernelContext_GetInputCount")));

    public static VarHandle KernelContext_GetInputCount$VH() {
        return OrtApi.KernelContext_GetInputCount$VH;
    }

    public static MemoryAddress KernelContext_GetInputCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelContext_GetInputCount$VH.get(seg);
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetInputCount$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetInputCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelContext_GetInputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetInputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetInputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetInputCount KernelContext_GetInputCount(MemorySegment segment) {
        return KernelContext_GetInputCount.ofAddress(KernelContext_GetInputCount$get(segment));
    }

    static final FunctionDescriptor KernelContext_GetOutputCount$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelContext_GetOutputCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelContext_GetOutputCount$FUNC,
            false);

    public interface KernelContext_GetOutputCount {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(KernelContext_GetOutputCount fi) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutputCount.class,
                    fi,
                    OrtApi.KernelContext_GetOutputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelContext_GetOutputCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutputCount.class,
                    fi,
                    OrtApi.KernelContext_GetOutputCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelContext_GetOutputCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelContext_GetOutputCount$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetOutputCount$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("KernelContext_GetOutputCount")));

    public static VarHandle KernelContext_GetOutputCount$VH() {
        return OrtApi.KernelContext_GetOutputCount$VH;
    }

    public static MemoryAddress KernelContext_GetOutputCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelContext_GetOutputCount$VH.get(seg);
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetOutputCount$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetOutputCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelContext_GetOutputCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetOutputCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetOutputCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetOutputCount KernelContext_GetOutputCount(MemorySegment segment) {
        return KernelContext_GetOutputCount.ofAddress(KernelContext_GetOutputCount$get(segment));
    }

    static final FunctionDescriptor KernelContext_GetInput$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle KernelContext_GetInput$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelContext_GetInput$FUNC,
            false);

    public interface KernelContext_GetInput {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(KernelContext_GetInput fi) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInput.class,
                    fi,
                    OrtApi.KernelContext_GetInput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelContext_GetInput fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetInput.class,
                    fi,
                    OrtApi.KernelContext_GetInput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelContext_GetInput ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelContext_GetInput$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetInput$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("KernelContext_GetInput")));

    public static VarHandle KernelContext_GetInput$VH() {
        return OrtApi.KernelContext_GetInput$VH;
    }

    public static MemoryAddress KernelContext_GetInput$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelContext_GetInput$VH.get(seg);
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetInput$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetInput$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelContext_GetInput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetInput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetInput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetInput KernelContext_GetInput(MemorySegment segment) {
        return KernelContext_GetInput.ofAddress(KernelContext_GetInput$get(segment));
    }

    static final FunctionDescriptor KernelContext_GetOutput$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle KernelContext_GetOutput$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelContext_GetOutput$FUNC,
            false);

    public interface KernelContext_GetOutput {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                long x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(KernelContext_GetOutput fi) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutput.class,
                    fi,
                    OrtApi.KernelContext_GetOutput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelContext_GetOutput fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetOutput.class,
                    fi,
                    OrtApi.KernelContext_GetOutput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelContext_GetOutput ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    long x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelContext_GetOutput$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetOutput$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("KernelContext_GetOutput")));

    public static VarHandle KernelContext_GetOutput$VH() {
        return OrtApi.KernelContext_GetOutput$VH;
    }

    public static MemoryAddress KernelContext_GetOutput$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelContext_GetOutput$VH.get(seg);
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetOutput$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetOutput$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelContext_GetOutput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetOutput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetOutput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetOutput KernelContext_GetOutput(MemorySegment segment) {
        return KernelContext_GetOutput.ofAddress(KernelContext_GetOutput$get(segment));
    }

    static final FunctionDescriptor ReleaseEnv$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseEnv$MH =
            RuntimeHelper.downcallHandle("(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseEnv$FUNC, false);

    public interface ReleaseEnv {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseEnv fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseEnv.class, fi, OrtApi.ReleaseEnv$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseEnv fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseEnv.class, fi, OrtApi.ReleaseEnv$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V", scope);
        }

        static ReleaseEnv ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseEnv$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseEnv$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseEnv")));

    public static VarHandle ReleaseEnv$VH() {
        return OrtApi.ReleaseEnv$VH;
    }

    public static MemoryAddress ReleaseEnv$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseEnv$VH.get(seg);
    }

    public static void ReleaseEnv$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseEnv$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseEnv$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseEnv$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseEnv$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseEnv$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseEnv ReleaseEnv(MemorySegment segment) {
        return ReleaseEnv.ofAddress(ReleaseEnv$get(segment));
    }

    static final FunctionDescriptor ReleaseStatus$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseStatus$MH =
            RuntimeHelper.downcallHandle("(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseStatus$FUNC, false);

    public interface ReleaseStatus {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseStatus fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseStatus.class, fi, OrtApi.ReleaseStatus$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseStatus fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseStatus.class,
                    fi,
                    OrtApi.ReleaseStatus$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseStatus ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseStatus$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseStatus$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseStatus")));

    public static VarHandle ReleaseStatus$VH() {
        return OrtApi.ReleaseStatus$VH;
    }

    public static MemoryAddress ReleaseStatus$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseStatus$VH.get(seg);
    }

    public static void ReleaseStatus$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseStatus$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseStatus$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseStatus$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseStatus$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseStatus$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseStatus ReleaseStatus(MemorySegment segment) {
        return ReleaseStatus.ofAddress(ReleaseStatus$get(segment));
    }

    static final FunctionDescriptor ReleaseMemoryInfo$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseMemoryInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseMemoryInfo$FUNC, false);

    public interface ReleaseMemoryInfo {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseMemoryInfo fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseMemoryInfo.class,
                    fi,
                    OrtApi.ReleaseMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseMemoryInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseMemoryInfo.class,
                    fi,
                    OrtApi.ReleaseMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseMemoryInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseMemoryInfo$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseMemoryInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseMemoryInfo")));

    public static VarHandle ReleaseMemoryInfo$VH() {
        return OrtApi.ReleaseMemoryInfo$VH;
    }

    public static MemoryAddress ReleaseMemoryInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseMemoryInfo$VH.get(seg);
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseMemoryInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseMemoryInfo ReleaseMemoryInfo(MemorySegment segment) {
        return ReleaseMemoryInfo.ofAddress(ReleaseMemoryInfo$get(segment));
    }

    static final FunctionDescriptor ReleaseSession$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseSession$MH =
            RuntimeHelper.downcallHandle("(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseSession$FUNC, false);

    public interface ReleaseSession {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseSession fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseSession.class, fi, OrtApi.ReleaseSession$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseSession fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseSession.class,
                    fi,
                    OrtApi.ReleaseSession$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseSession ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseSession$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseSession$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseSession")));

    public static VarHandle ReleaseSession$VH() {
        return OrtApi.ReleaseSession$VH;
    }

    public static MemoryAddress ReleaseSession$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseSession$VH.get(seg);
    }

    public static void ReleaseSession$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseSession$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseSession$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseSession$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSession$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseSession$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSession ReleaseSession(MemorySegment segment) {
        return ReleaseSession.ofAddress(ReleaseSession$get(segment));
    }

    static final FunctionDescriptor ReleaseValue$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseValue$MH =
            RuntimeHelper.downcallHandle("(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseValue$FUNC, false);

    public interface ReleaseValue {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseValue fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseValue.class, fi, OrtApi.ReleaseValue$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseValue.class,
                    fi,
                    OrtApi.ReleaseValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseValue$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseValue")));

    public static VarHandle ReleaseValue$VH() {
        return OrtApi.ReleaseValue$VH;
    }

    public static MemoryAddress ReleaseValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseValue$VH.get(seg);
    }

    public static void ReleaseValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseValue$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseValue ReleaseValue(MemorySegment segment) {
        return ReleaseValue.ofAddress(ReleaseValue$get(segment));
    }

    static final FunctionDescriptor ReleaseRunOptions$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseRunOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseRunOptions$FUNC, false);

    public interface ReleaseRunOptions {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseRunOptions fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseRunOptions.class,
                    fi,
                    OrtApi.ReleaseRunOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseRunOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseRunOptions.class,
                    fi,
                    OrtApi.ReleaseRunOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseRunOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseRunOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseRunOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseRunOptions")));

    public static VarHandle ReleaseRunOptions$VH() {
        return OrtApi.ReleaseRunOptions$VH;
    }

    public static MemoryAddress ReleaseRunOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseRunOptions$VH.get(seg);
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseRunOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseRunOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseRunOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseRunOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseRunOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseRunOptions ReleaseRunOptions(MemorySegment segment) {
        return ReleaseRunOptions.ofAddress(ReleaseRunOptions$get(segment));
    }

    static final FunctionDescriptor ReleaseTypeInfo$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseTypeInfo$FUNC, false);

    public interface ReleaseTypeInfo {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseTypeInfo.class, fi, OrtApi.ReleaseTypeInfo$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseTypeInfo.class,
                    fi,
                    OrtApi.ReleaseTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseTypeInfo$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseTypeInfo")));

    public static VarHandle ReleaseTypeInfo$VH() {
        return OrtApi.ReleaseTypeInfo$VH;
    }

    public static MemoryAddress ReleaseTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseTypeInfo$VH.get(seg);
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTypeInfo ReleaseTypeInfo(MemorySegment segment) {
        return ReleaseTypeInfo.ofAddress(ReleaseTypeInfo$get(segment));
    }

    static final FunctionDescriptor ReleaseTensorTypeAndShapeInfo$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseTensorTypeAndShapeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC, false);

    public interface ReleaseTensorTypeAndShapeInfo {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseTensorTypeAndShapeInfo fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorTypeAndShapeInfo.class,
                    fi,
                    OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseTensorTypeAndShapeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorTypeAndShapeInfo.class,
                    fi,
                    OrtApi.ReleaseTensorTypeAndShapeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseTensorTypeAndShapeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseTensorTypeAndShapeInfo$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseTensorTypeAndShapeInfo$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("ReleaseTensorTypeAndShapeInfo")));

    public static VarHandle ReleaseTensorTypeAndShapeInfo$VH() {
        return OrtApi.ReleaseTensorTypeAndShapeInfo$VH;
    }

    public static MemoryAddress ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseTensorTypeAndShapeInfo$VH.get(seg);
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseTensorTypeAndShapeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseTensorTypeAndShapeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ReleaseTensorTypeAndShapeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTensorTypeAndShapeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseTensorTypeAndShapeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTensorTypeAndShapeInfo ReleaseTensorTypeAndShapeInfo(MemorySegment segment) {
        return ReleaseTensorTypeAndShapeInfo.ofAddress(ReleaseTensorTypeAndShapeInfo$get(segment));
    }

    static final FunctionDescriptor ReleaseSessionOptions$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseSessionOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseSessionOptions$FUNC, false);

    public interface ReleaseSessionOptions {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseSessionOptions fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseSessionOptions.class,
                    fi,
                    OrtApi.ReleaseSessionOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseSessionOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseSessionOptions.class,
                    fi,
                    OrtApi.ReleaseSessionOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseSessionOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseSessionOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseSessionOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseSessionOptions")));

    public static VarHandle ReleaseSessionOptions$VH() {
        return OrtApi.ReleaseSessionOptions$VH;
    }

    public static MemoryAddress ReleaseSessionOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseSessionOptions$VH.get(seg);
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseSessionOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseSessionOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseSessionOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSessionOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseSessionOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSessionOptions ReleaseSessionOptions(MemorySegment segment) {
        return ReleaseSessionOptions.ofAddress(ReleaseSessionOptions$get(segment));
    }

    static final FunctionDescriptor ReleaseCustomOpDomain$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseCustomOpDomain$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseCustomOpDomain$FUNC, false);

    public interface ReleaseCustomOpDomain {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseCustomOpDomain fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseCustomOpDomain.class,
                    fi,
                    OrtApi.ReleaseCustomOpDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseCustomOpDomain fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseCustomOpDomain.class,
                    fi,
                    OrtApi.ReleaseCustomOpDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseCustomOpDomain ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseCustomOpDomain$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseCustomOpDomain$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseCustomOpDomain")));

    public static VarHandle ReleaseCustomOpDomain$VH() {
        return OrtApi.ReleaseCustomOpDomain$VH;
    }

    public static MemoryAddress ReleaseCustomOpDomain$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseCustomOpDomain$VH.get(seg);
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseCustomOpDomain$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseCustomOpDomain$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseCustomOpDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseCustomOpDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseCustomOpDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseCustomOpDomain ReleaseCustomOpDomain(MemorySegment segment) {
        return ReleaseCustomOpDomain.ofAddress(ReleaseCustomOpDomain$get(segment));
    }

    static final FunctionDescriptor GetDenotationFromTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetDenotationFromTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetDenotationFromTypeInfo$FUNC,
            false);

    public interface GetDenotationFromTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(GetDenotationFromTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    GetDenotationFromTypeInfo.class,
                    fi,
                    OrtApi.GetDenotationFromTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetDenotationFromTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetDenotationFromTypeInfo.class,
                    fi,
                    OrtApi.GetDenotationFromTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetDenotationFromTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetDenotationFromTypeInfo$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetDenotationFromTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetDenotationFromTypeInfo")));

    public static VarHandle GetDenotationFromTypeInfo$VH() {
        return OrtApi.GetDenotationFromTypeInfo$VH;
    }

    public static MemoryAddress GetDenotationFromTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetDenotationFromTypeInfo$VH.get(seg);
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetDenotationFromTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetDenotationFromTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetDenotationFromTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetDenotationFromTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetDenotationFromTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetDenotationFromTypeInfo GetDenotationFromTypeInfo(MemorySegment segment) {
        return GetDenotationFromTypeInfo.ofAddress(GetDenotationFromTypeInfo$get(segment));
    }

    static final FunctionDescriptor CastTypeInfoToMapTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CastTypeInfoToMapTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CastTypeInfoToMapTypeInfo$FUNC,
            false);

    public interface CastTypeInfoToMapTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CastTypeInfoToMapTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToMapTypeInfo.class,
                    fi,
                    OrtApi.CastTypeInfoToMapTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CastTypeInfoToMapTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToMapTypeInfo.class,
                    fi,
                    OrtApi.CastTypeInfoToMapTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CastTypeInfoToMapTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CastTypeInfoToMapTypeInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToMapTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CastTypeInfoToMapTypeInfo")));

    public static VarHandle CastTypeInfoToMapTypeInfo$VH() {
        return OrtApi.CastTypeInfoToMapTypeInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToMapTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CastTypeInfoToMapTypeInfo$VH.get(seg);
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToMapTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToMapTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CastTypeInfoToMapTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToMapTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToMapTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo(MemorySegment segment) {
        return CastTypeInfoToMapTypeInfo.ofAddress(CastTypeInfoToMapTypeInfo$get(segment));
    }

    static final FunctionDescriptor CastTypeInfoToSequenceTypeInfo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CastTypeInfoToSequenceTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC,
            false);

    public interface CastTypeInfoToSequenceTypeInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CastTypeInfoToSequenceTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToSequenceTypeInfo.class,
                    fi,
                    OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CastTypeInfoToSequenceTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CastTypeInfoToSequenceTypeInfo.class,
                    fi,
                    OrtApi.CastTypeInfoToSequenceTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CastTypeInfoToSequenceTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CastTypeInfoToSequenceTypeInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CastTypeInfoToSequenceTypeInfo$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("CastTypeInfoToSequenceTypeInfo")));

    public static VarHandle CastTypeInfoToSequenceTypeInfo$VH() {
        return OrtApi.CastTypeInfoToSequenceTypeInfo$VH;
    }

    public static MemoryAddress CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CastTypeInfoToSequenceTypeInfo$VH.get(seg);
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CastTypeInfoToSequenceTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress CastTypeInfoToSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CastTypeInfoToSequenceTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CastTypeInfoToSequenceTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CastTypeInfoToSequenceTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo(MemorySegment segment) {
        return CastTypeInfoToSequenceTypeInfo.ofAddress(CastTypeInfoToSequenceTypeInfo$get(segment));
    }

    static final FunctionDescriptor GetMapKeyType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetMapKeyType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetMapKeyType$FUNC,
            false);

    public interface GetMapKeyType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetMapKeyType fi) {
            return RuntimeHelper.upcallStub(
                    GetMapKeyType.class,
                    fi,
                    OrtApi.GetMapKeyType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetMapKeyType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetMapKeyType.class,
                    fi,
                    OrtApi.GetMapKeyType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetMapKeyType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetMapKeyType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetMapKeyType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetMapKeyType")));

    public static VarHandle GetMapKeyType$VH() {
        return OrtApi.GetMapKeyType$VH;
    }

    public static MemoryAddress GetMapKeyType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetMapKeyType$VH.get(seg);
    }

    public static void GetMapKeyType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetMapKeyType$VH.set(seg, x);
    }

    public static MemoryAddress GetMapKeyType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetMapKeyType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetMapKeyType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetMapKeyType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetMapKeyType GetMapKeyType(MemorySegment segment) {
        return GetMapKeyType.ofAddress(GetMapKeyType$get(segment));
    }

    static final FunctionDescriptor GetMapValueType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetMapValueType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetMapValueType$FUNC,
            false);

    public interface GetMapValueType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetMapValueType fi) {
            return RuntimeHelper.upcallStub(
                    GetMapValueType.class,
                    fi,
                    OrtApi.GetMapValueType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetMapValueType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetMapValueType.class,
                    fi,
                    OrtApi.GetMapValueType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetMapValueType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetMapValueType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetMapValueType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetMapValueType")));

    public static VarHandle GetMapValueType$VH() {
        return OrtApi.GetMapValueType$VH;
    }

    public static MemoryAddress GetMapValueType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetMapValueType$VH.get(seg);
    }

    public static void GetMapValueType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetMapValueType$VH.set(seg, x);
    }

    public static MemoryAddress GetMapValueType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetMapValueType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetMapValueType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetMapValueType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetMapValueType GetMapValueType(MemorySegment segment) {
        return GetMapValueType.ofAddress(GetMapValueType$get(segment));
    }

    static final FunctionDescriptor GetSequenceElementType$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetSequenceElementType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSequenceElementType$FUNC,
            false);

    public interface GetSequenceElementType {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetSequenceElementType fi) {
            return RuntimeHelper.upcallStub(
                    GetSequenceElementType.class,
                    fi,
                    OrtApi.GetSequenceElementType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSequenceElementType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSequenceElementType.class,
                    fi,
                    OrtApi.GetSequenceElementType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSequenceElementType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSequenceElementType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSequenceElementType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetSequenceElementType")));

    public static VarHandle GetSequenceElementType$VH() {
        return OrtApi.GetSequenceElementType$VH;
    }

    public static MemoryAddress GetSequenceElementType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSequenceElementType$VH.get(seg);
    }

    public static void GetSequenceElementType$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSequenceElementType$VH.set(seg, x);
    }

    public static MemoryAddress GetSequenceElementType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetSequenceElementType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSequenceElementType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSequenceElementType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSequenceElementType GetSequenceElementType(MemorySegment segment) {
        return GetSequenceElementType.ofAddress(GetSequenceElementType$get(segment));
    }

    static final FunctionDescriptor ReleaseMapTypeInfo$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseMapTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseMapTypeInfo$FUNC, false);

    public interface ReleaseMapTypeInfo {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseMapTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseMapTypeInfo.class,
                    fi,
                    OrtApi.ReleaseMapTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseMapTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseMapTypeInfo.class,
                    fi,
                    OrtApi.ReleaseMapTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseMapTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseMapTypeInfo$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseMapTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseMapTypeInfo")));

    public static VarHandle ReleaseMapTypeInfo$VH() {
        return OrtApi.ReleaseMapTypeInfo$VH;
    }

    public static MemoryAddress ReleaseMapTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseMapTypeInfo$VH.get(seg);
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseMapTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseMapTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseMapTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseMapTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseMapTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseMapTypeInfo ReleaseMapTypeInfo(MemorySegment segment) {
        return ReleaseMapTypeInfo.ofAddress(ReleaseMapTypeInfo$get(segment));
    }

    static final FunctionDescriptor ReleaseSequenceTypeInfo$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseSequenceTypeInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseSequenceTypeInfo$FUNC, false);

    public interface ReleaseSequenceTypeInfo {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseSequenceTypeInfo fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseSequenceTypeInfo.class,
                    fi,
                    OrtApi.ReleaseSequenceTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseSequenceTypeInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseSequenceTypeInfo.class,
                    fi,
                    OrtApi.ReleaseSequenceTypeInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseSequenceTypeInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseSequenceTypeInfo$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseSequenceTypeInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseSequenceTypeInfo")));

    public static VarHandle ReleaseSequenceTypeInfo$VH() {
        return OrtApi.ReleaseSequenceTypeInfo$VH;
    }

    public static MemoryAddress ReleaseSequenceTypeInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseSequenceTypeInfo$VH.get(seg);
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseSequenceTypeInfo$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseSequenceTypeInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ReleaseSequenceTypeInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseSequenceTypeInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseSequenceTypeInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseSequenceTypeInfo ReleaseSequenceTypeInfo(MemorySegment segment) {
        return ReleaseSequenceTypeInfo.ofAddress(ReleaseSequenceTypeInfo$get(segment));
    }

    static final FunctionDescriptor SessionEndProfiling$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionEndProfiling$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionEndProfiling$FUNC,
            false);

    public interface SessionEndProfiling {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(SessionEndProfiling fi) {
            return RuntimeHelper.upcallStub(
                    SessionEndProfiling.class,
                    fi,
                    OrtApi.SessionEndProfiling$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionEndProfiling fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionEndProfiling.class,
                    fi,
                    OrtApi.SessionEndProfiling$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionEndProfiling ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionEndProfiling$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionEndProfiling$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionEndProfiling")));

    public static VarHandle SessionEndProfiling$VH() {
        return OrtApi.SessionEndProfiling$VH;
    }

    public static MemoryAddress SessionEndProfiling$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionEndProfiling$VH.get(seg);
    }

    public static void SessionEndProfiling$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionEndProfiling$VH.set(seg, x);
    }

    public static MemoryAddress SessionEndProfiling$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionEndProfiling$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionEndProfiling$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionEndProfiling$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionEndProfiling SessionEndProfiling(MemorySegment segment) {
        return SessionEndProfiling.ofAddress(SessionEndProfiling$get(segment));
    }

    static final FunctionDescriptor SessionGetModelMetadata$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetModelMetadata$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetModelMetadata$FUNC,
            false);

    public interface SessionGetModelMetadata {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionGetModelMetadata fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetModelMetadata.class,
                    fi,
                    OrtApi.SessionGetModelMetadata$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetModelMetadata fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetModelMetadata.class,
                    fi,
                    OrtApi.SessionGetModelMetadata$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetModelMetadata ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetModelMetadata$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetModelMetadata$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SessionGetModelMetadata")));

    public static VarHandle SessionGetModelMetadata$VH() {
        return OrtApi.SessionGetModelMetadata$VH;
    }

    public static MemoryAddress SessionGetModelMetadata$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetModelMetadata$VH.get(seg);
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetModelMetadata$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetModelMetadata$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetModelMetadata$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetModelMetadata$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetModelMetadata$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetModelMetadata SessionGetModelMetadata(MemorySegment segment) {
        return SessionGetModelMetadata.ofAddress(SessionGetModelMetadata$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetProducerName$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetProducerName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetProducerName$FUNC,
            false);

    public interface ModelMetadataGetProducerName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(ModelMetadataGetProducerName fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetProducerName.class,
                    fi,
                    OrtApi.ModelMetadataGetProducerName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetProducerName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetProducerName.class,
                    fi,
                    OrtApi.ModelMetadataGetProducerName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetProducerName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetProducerName$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetProducerName$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetProducerName")));

    public static VarHandle ModelMetadataGetProducerName$VH() {
        return OrtApi.ModelMetadataGetProducerName$VH;
    }

    public static MemoryAddress ModelMetadataGetProducerName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetProducerName$VH.get(seg);
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetProducerName$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetProducerName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetProducerName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetProducerName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetProducerName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetProducerName ModelMetadataGetProducerName(MemorySegment segment) {
        return ModelMetadataGetProducerName.ofAddress(ModelMetadataGetProducerName$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetGraphName$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetGraphName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetGraphName$FUNC,
            false);

    public interface ModelMetadataGetGraphName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(ModelMetadataGetGraphName fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphName.class,
                    fi,
                    OrtApi.ModelMetadataGetGraphName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetGraphName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphName.class,
                    fi,
                    OrtApi.ModelMetadataGetGraphName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetGraphName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetGraphName$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetGraphName$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetGraphName")));

    public static VarHandle ModelMetadataGetGraphName$VH() {
        return OrtApi.ModelMetadataGetGraphName$VH;
    }

    public static MemoryAddress ModelMetadataGetGraphName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphName$VH.get(seg);
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphName$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetGraphName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetGraphName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetGraphName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetGraphName ModelMetadataGetGraphName(MemorySegment segment) {
        return ModelMetadataGetGraphName.ofAddress(ModelMetadataGetGraphName$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetDomain$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetDomain$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetDomain$FUNC,
            false);

    public interface ModelMetadataGetDomain {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(ModelMetadataGetDomain fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDomain.class,
                    fi,
                    OrtApi.ModelMetadataGetDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetDomain fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDomain.class,
                    fi,
                    OrtApi.ModelMetadataGetDomain$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetDomain ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetDomain$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetDomain$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetDomain")));

    public static VarHandle ModelMetadataGetDomain$VH() {
        return OrtApi.ModelMetadataGetDomain$VH;
    }

    public static MemoryAddress ModelMetadataGetDomain$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetDomain$VH.get(seg);
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetDomain$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetDomain$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetDomain$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetDomain$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetDomain$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetDomain ModelMetadataGetDomain(MemorySegment segment) {
        return ModelMetadataGetDomain.ofAddress(ModelMetadataGetDomain$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetDescription$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetDescription$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetDescription$FUNC,
            false);

    public interface ModelMetadataGetDescription {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(ModelMetadataGetDescription fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDescription.class,
                    fi,
                    OrtApi.ModelMetadataGetDescription$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetDescription fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetDescription.class,
                    fi,
                    OrtApi.ModelMetadataGetDescription$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetDescription ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetDescription$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetDescription$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetDescription")));

    public static VarHandle ModelMetadataGetDescription$VH() {
        return OrtApi.ModelMetadataGetDescription$VH;
    }

    public static MemoryAddress ModelMetadataGetDescription$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetDescription$VH.get(seg);
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetDescription$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetDescription$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetDescription$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetDescription$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetDescription$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetDescription ModelMetadataGetDescription(MemorySegment segment) {
        return ModelMetadataGetDescription.ofAddress(ModelMetadataGetDescription$get(segment));
    }

    static final FunctionDescriptor ModelMetadataLookupCustomMetadataMap$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataLookupCustomMetadataMap$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC,
            false);

    public interface ModelMetadataLookupCustomMetadataMap {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(ModelMetadataLookupCustomMetadataMap fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataLookupCustomMetadataMap.class,
                    fi,
                    OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataLookupCustomMetadataMap fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataLookupCustomMetadataMap.class,
                    fi,
                    OrtApi.ModelMetadataLookupCustomMetadataMap$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataLookupCustomMetadataMap ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataLookupCustomMetadataMap$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataLookupCustomMetadataMap$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("ModelMetadataLookupCustomMetadataMap")));

    public static VarHandle ModelMetadataLookupCustomMetadataMap$VH() {
        return OrtApi.ModelMetadataLookupCustomMetadataMap$VH;
    }

    public static MemoryAddress ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataLookupCustomMetadataMap$VH.get(seg);
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataLookupCustomMetadataMap$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataLookupCustomMetadataMap$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataLookupCustomMetadataMap$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataLookupCustomMetadataMap$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataLookupCustomMetadataMap$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataLookupCustomMetadataMap ModelMetadataLookupCustomMetadataMap(MemorySegment segment) {
        return ModelMetadataLookupCustomMetadataMap.ofAddress(ModelMetadataLookupCustomMetadataMap$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetVersion$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetVersion$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetVersion$FUNC,
            false);

    public interface ModelMetadataGetVersion {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(ModelMetadataGetVersion fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetVersion.class,
                    fi,
                    OrtApi.ModelMetadataGetVersion$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetVersion fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetVersion.class,
                    fi,
                    OrtApi.ModelMetadataGetVersion$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetVersion ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetVersion$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetVersion$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetVersion")));

    public static VarHandle ModelMetadataGetVersion$VH() {
        return OrtApi.ModelMetadataGetVersion$VH;
    }

    public static MemoryAddress ModelMetadataGetVersion$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetVersion$VH.get(seg);
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetVersion$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetVersion$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetVersion$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetVersion$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetVersion$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetVersion ModelMetadataGetVersion(MemorySegment segment) {
        return ModelMetadataGetVersion.ofAddress(ModelMetadataGetVersion$get(segment));
    }

    static final FunctionDescriptor ReleaseModelMetadata$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseModelMetadata$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseModelMetadata$FUNC, false);

    public interface ReleaseModelMetadata {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseModelMetadata fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseModelMetadata.class,
                    fi,
                    OrtApi.ReleaseModelMetadata$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseModelMetadata fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseModelMetadata.class,
                    fi,
                    OrtApi.ReleaseModelMetadata$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseModelMetadata ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseModelMetadata$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseModelMetadata$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseModelMetadata")));

    public static VarHandle ReleaseModelMetadata$VH() {
        return OrtApi.ReleaseModelMetadata$VH;
    }

    public static MemoryAddress ReleaseModelMetadata$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseModelMetadata$VH.get(seg);
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseModelMetadata$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseModelMetadata$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseModelMetadata$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseModelMetadata$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseModelMetadata$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseModelMetadata ReleaseModelMetadata(MemorySegment segment) {
        return ReleaseModelMetadata.ofAddress(ReleaseModelMetadata$get(segment));
    }

    static final FunctionDescriptor CreateEnvWithGlobalThreadPools$FUNC =
            FunctionDescriptor.of(C_POINTER, C_INT, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateEnvWithGlobalThreadPools$MH = RuntimeHelper.downcallHandle(
            "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateEnvWithGlobalThreadPools$FUNC,
            false);

    public interface CreateEnvWithGlobalThreadPools {

        jdk.incubator.foreign.MemoryAddress apply(
                int x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(CreateEnvWithGlobalThreadPools fi) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithGlobalThreadPools.class,
                    fi,
                    OrtApi.CreateEnvWithGlobalThreadPools$FUNC,
                    "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateEnvWithGlobalThreadPools fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithGlobalThreadPools.class,
                    fi,
                    OrtApi.CreateEnvWithGlobalThreadPools$FUNC,
                    "(ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateEnvWithGlobalThreadPools ofAddress(MemoryAddress addr) {
            return (int x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateEnvWithGlobalThreadPools$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnvWithGlobalThreadPools$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("CreateEnvWithGlobalThreadPools")));

    public static VarHandle CreateEnvWithGlobalThreadPools$VH() {
        return OrtApi.CreateEnvWithGlobalThreadPools$VH;
    }

    public static MemoryAddress CreateEnvWithGlobalThreadPools$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateEnvWithGlobalThreadPools$VH.get(seg);
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnvWithGlobalThreadPools$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnvWithGlobalThreadPools$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateEnvWithGlobalThreadPools$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithGlobalThreadPools$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnvWithGlobalThreadPools$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithGlobalThreadPools CreateEnvWithGlobalThreadPools(MemorySegment segment) {
        return CreateEnvWithGlobalThreadPools.ofAddress(CreateEnvWithGlobalThreadPools$get(segment));
    }

    static final FunctionDescriptor DisablePerSessionThreads$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle DisablePerSessionThreads$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.DisablePerSessionThreads$FUNC,
            false);

    public interface DisablePerSessionThreads {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(DisablePerSessionThreads fi) {
            return RuntimeHelper.upcallStub(
                    DisablePerSessionThreads.class,
                    fi,
                    OrtApi.DisablePerSessionThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(DisablePerSessionThreads fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    DisablePerSessionThreads.class,
                    fi,
                    OrtApi.DisablePerSessionThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static DisablePerSessionThreads ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.DisablePerSessionThreads$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle DisablePerSessionThreads$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("DisablePerSessionThreads")));

    public static VarHandle DisablePerSessionThreads$VH() {
        return OrtApi.DisablePerSessionThreads$VH;
    }

    public static MemoryAddress DisablePerSessionThreads$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.DisablePerSessionThreads$VH.get(seg);
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.DisablePerSessionThreads$VH.set(seg, x);
    }

    public static MemoryAddress DisablePerSessionThreads$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.DisablePerSessionThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void DisablePerSessionThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.DisablePerSessionThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static DisablePerSessionThreads DisablePerSessionThreads(MemorySegment segment) {
        return DisablePerSessionThreads.ofAddress(DisablePerSessionThreads$get(segment));
    }

    static final FunctionDescriptor CreateThreadingOptions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle CreateThreadingOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateThreadingOptions$FUNC,
            false);

    public interface CreateThreadingOptions {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(CreateThreadingOptions fi) {
            return RuntimeHelper.upcallStub(
                    CreateThreadingOptions.class,
                    fi,
                    OrtApi.CreateThreadingOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateThreadingOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateThreadingOptions.class,
                    fi,
                    OrtApi.CreateThreadingOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateThreadingOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateThreadingOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateThreadingOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateThreadingOptions")));

    public static VarHandle CreateThreadingOptions$VH() {
        return OrtApi.CreateThreadingOptions$VH;
    }

    public static MemoryAddress CreateThreadingOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateThreadingOptions$VH.get(seg);
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateThreadingOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateThreadingOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateThreadingOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateThreadingOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateThreadingOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateThreadingOptions CreateThreadingOptions(MemorySegment segment) {
        return CreateThreadingOptions.ofAddress(CreateThreadingOptions$get(segment));
    }

    static final FunctionDescriptor ReleaseThreadingOptions$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseThreadingOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseThreadingOptions$FUNC, false);

    public interface ReleaseThreadingOptions {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseThreadingOptions fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseThreadingOptions.class,
                    fi,
                    OrtApi.ReleaseThreadingOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseThreadingOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseThreadingOptions.class,
                    fi,
                    OrtApi.ReleaseThreadingOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseThreadingOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseThreadingOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseThreadingOptions$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseThreadingOptions")));

    public static VarHandle ReleaseThreadingOptions$VH() {
        return OrtApi.ReleaseThreadingOptions$VH;
    }

    public static MemoryAddress ReleaseThreadingOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseThreadingOptions$VH.get(seg);
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseThreadingOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseThreadingOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ReleaseThreadingOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseThreadingOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseThreadingOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseThreadingOptions ReleaseThreadingOptions(MemorySegment segment) {
        return ReleaseThreadingOptions.ofAddress(ReleaseThreadingOptions$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetCustomMetadataMapKeys$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetCustomMetadataMapKeys$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC,
            false);

    public interface ModelMetadataGetCustomMetadataMapKeys {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(ModelMetadataGetCustomMetadataMapKeys fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetCustomMetadataMapKeys.class,
                    fi,
                    OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetCustomMetadataMapKeys fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetCustomMetadataMapKeys.class,
                    fi,
                    OrtApi.ModelMetadataGetCustomMetadataMapKeys$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetCustomMetadataMapKeys ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetCustomMetadataMapKeys$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetCustomMetadataMapKeys$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetCustomMetadataMapKeys")));

    public static VarHandle ModelMetadataGetCustomMetadataMapKeys$VH() {
        return OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH;
    }

    public static MemoryAddress ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.get(seg);
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetCustomMetadataMapKeys$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetCustomMetadataMapKeys$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetCustomMetadataMapKeys$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetCustomMetadataMapKeys ModelMetadataGetCustomMetadataMapKeys(MemorySegment segment) {
        return ModelMetadataGetCustomMetadataMapKeys.ofAddress(ModelMetadataGetCustomMetadataMapKeys$get(segment));
    }

    static final FunctionDescriptor AddFreeDimensionOverrideByName$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle AddFreeDimensionOverrideByName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AddFreeDimensionOverrideByName$FUNC,
            false);

    public interface AddFreeDimensionOverrideByName {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(AddFreeDimensionOverrideByName fi) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverrideByName.class,
                    fi,
                    OrtApi.AddFreeDimensionOverrideByName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AddFreeDimensionOverrideByName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AddFreeDimensionOverrideByName.class,
                    fi,
                    OrtApi.AddFreeDimensionOverrideByName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AddFreeDimensionOverrideByName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AddFreeDimensionOverrideByName$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddFreeDimensionOverrideByName$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("AddFreeDimensionOverrideByName")));

    public static VarHandle AddFreeDimensionOverrideByName$VH() {
        return OrtApi.AddFreeDimensionOverrideByName$VH;
    }

    public static MemoryAddress AddFreeDimensionOverrideByName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddFreeDimensionOverrideByName$VH.get(seg);
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverrideByName$VH.set(seg, x);
    }

    public static MemoryAddress AddFreeDimensionOverrideByName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.AddFreeDimensionOverrideByName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddFreeDimensionOverrideByName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddFreeDimensionOverrideByName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddFreeDimensionOverrideByName AddFreeDimensionOverrideByName(MemorySegment segment) {
        return AddFreeDimensionOverrideByName.ofAddress(AddFreeDimensionOverrideByName$get(segment));
    }

    static final FunctionDescriptor GetAvailableProviders$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetAvailableProviders$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetAvailableProviders$FUNC,
            false);

    public interface GetAvailableProviders {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetAvailableProviders fi) {
            return RuntimeHelper.upcallStub(
                    GetAvailableProviders.class,
                    fi,
                    OrtApi.GetAvailableProviders$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetAvailableProviders fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetAvailableProviders.class,
                    fi,
                    OrtApi.GetAvailableProviders$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetAvailableProviders ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetAvailableProviders$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetAvailableProviders$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetAvailableProviders")));

    public static VarHandle GetAvailableProviders$VH() {
        return OrtApi.GetAvailableProviders$VH;
    }

    public static MemoryAddress GetAvailableProviders$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetAvailableProviders$VH.get(seg);
    }

    public static void GetAvailableProviders$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetAvailableProviders$VH.set(seg, x);
    }

    public static MemoryAddress GetAvailableProviders$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetAvailableProviders$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetAvailableProviders$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetAvailableProviders$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetAvailableProviders GetAvailableProviders(MemorySegment segment) {
        return GetAvailableProviders.ofAddress(GetAvailableProviders$get(segment));
    }

    static final FunctionDescriptor ReleaseAvailableProviders$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle ReleaseAvailableProviders$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ReleaseAvailableProviders$FUNC,
            false);

    public interface ReleaseAvailableProviders {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(ReleaseAvailableProviders fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseAvailableProviders.class,
                    fi,
                    OrtApi.ReleaseAvailableProviders$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ReleaseAvailableProviders fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseAvailableProviders.class,
                    fi,
                    OrtApi.ReleaseAvailableProviders$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ReleaseAvailableProviders ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ReleaseAvailableProviders$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseAvailableProviders$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseAvailableProviders")));

    public static VarHandle ReleaseAvailableProviders$VH() {
        return OrtApi.ReleaseAvailableProviders$VH;
    }

    public static MemoryAddress ReleaseAvailableProviders$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseAvailableProviders$VH.get(seg);
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseAvailableProviders$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseAvailableProviders$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ReleaseAvailableProviders$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseAvailableProviders$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseAvailableProviders$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseAvailableProviders ReleaseAvailableProviders(MemorySegment segment) {
        return ReleaseAvailableProviders.ofAddress(ReleaseAvailableProviders$get(segment));
    }

    static final FunctionDescriptor GetStringTensorElementLength$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle GetStringTensorElementLength$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetStringTensorElementLength$FUNC,
            false);

    public interface GetStringTensorElementLength {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(GetStringTensorElementLength fi) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElementLength.class,
                    fi,
                    OrtApi.GetStringTensorElementLength$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetStringTensorElementLength fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElementLength.class,
                    fi,
                    OrtApi.GetStringTensorElementLength$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetStringTensorElementLength ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetStringTensorElementLength$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorElementLength$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("GetStringTensorElementLength")));

    public static VarHandle GetStringTensorElementLength$VH() {
        return OrtApi.GetStringTensorElementLength$VH;
    }

    public static MemoryAddress GetStringTensorElementLength$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetStringTensorElementLength$VH.get(seg);
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorElementLength$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorElementLength$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetStringTensorElementLength$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorElementLength$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorElementLength$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorElementLength GetStringTensorElementLength(MemorySegment segment) {
        return GetStringTensorElementLength.ofAddress(GetStringTensorElementLength$get(segment));
    }

    static final FunctionDescriptor GetStringTensorElement$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_LONG, C_LONG, C_POINTER);
    static final MethodHandle GetStringTensorElement$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;JJLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetStringTensorElement$FUNC,
            false);

    public interface GetStringTensorElement {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, long x1, long x2, jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(GetStringTensorElement fi) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElement.class,
                    fi,
                    OrtApi.GetStringTensorElement$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JJLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetStringTensorElement fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetStringTensorElement.class,
                    fi,
                    OrtApi.GetStringTensorElement$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;JJLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetStringTensorElement ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    long x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetStringTensorElement$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetStringTensorElement$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetStringTensorElement")));

    public static VarHandle GetStringTensorElement$VH() {
        return OrtApi.GetStringTensorElement$VH;
    }

    public static MemoryAddress GetStringTensorElement$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetStringTensorElement$VH.get(seg);
    }

    public static void GetStringTensorElement$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetStringTensorElement$VH.set(seg, x);
    }

    public static MemoryAddress GetStringTensorElement$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetStringTensorElement$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetStringTensorElement$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetStringTensorElement$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetStringTensorElement GetStringTensorElement(MemorySegment segment) {
        return GetStringTensorElement.ofAddress(GetStringTensorElement$get(segment));
    }

    static final FunctionDescriptor FillStringTensorElement$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle FillStringTensorElement$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.FillStringTensorElement$FUNC,
            false);

    public interface FillStringTensorElement {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(FillStringTensorElement fi) {
            return RuntimeHelper.upcallStub(
                    FillStringTensorElement.class,
                    fi,
                    OrtApi.FillStringTensorElement$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(FillStringTensorElement fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    FillStringTensorElement.class,
                    fi,
                    OrtApi.FillStringTensorElement$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static FillStringTensorElement ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.FillStringTensorElement$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillStringTensorElement$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("FillStringTensorElement")));

    public static VarHandle FillStringTensorElement$VH() {
        return OrtApi.FillStringTensorElement$VH;
    }

    public static MemoryAddress FillStringTensorElement$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillStringTensorElement$VH.get(seg);
    }

    public static void FillStringTensorElement$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillStringTensorElement$VH.set(seg, x);
    }

    public static MemoryAddress FillStringTensorElement$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.FillStringTensorElement$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillStringTensorElement$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillStringTensorElement$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillStringTensorElement FillStringTensorElement(MemorySegment segment) {
        return FillStringTensorElement.ofAddress(FillStringTensorElement$get(segment));
    }

    static final FunctionDescriptor AddSessionConfigEntry$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle AddSessionConfigEntry$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AddSessionConfigEntry$FUNC,
            false);

    public interface AddSessionConfigEntry {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(AddSessionConfigEntry fi) {
            return RuntimeHelper.upcallStub(
                    AddSessionConfigEntry.class,
                    fi,
                    OrtApi.AddSessionConfigEntry$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AddSessionConfigEntry fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AddSessionConfigEntry.class,
                    fi,
                    OrtApi.AddSessionConfigEntry$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AddSessionConfigEntry ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AddSessionConfigEntry$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddSessionConfigEntry$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AddSessionConfigEntry")));

    public static VarHandle AddSessionConfigEntry$VH() {
        return OrtApi.AddSessionConfigEntry$VH;
    }

    public static MemoryAddress AddSessionConfigEntry$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddSessionConfigEntry$VH.get(seg);
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddSessionConfigEntry$VH.set(seg, x);
    }

    public static MemoryAddress AddSessionConfigEntry$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddSessionConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddSessionConfigEntry$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddSessionConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddSessionConfigEntry AddSessionConfigEntry(MemorySegment segment) {
        return AddSessionConfigEntry.ofAddress(AddSessionConfigEntry$get(segment));
    }

    static final FunctionDescriptor CreateAllocator$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateAllocator$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateAllocator$FUNC,
            false);

    public interface CreateAllocator {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(CreateAllocator fi) {
            return RuntimeHelper.upcallStub(
                    CreateAllocator.class,
                    fi,
                    OrtApi.CreateAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateAllocator fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateAllocator.class,
                    fi,
                    OrtApi.CreateAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateAllocator ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateAllocator$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateAllocator$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateAllocator")));

    public static VarHandle CreateAllocator$VH() {
        return OrtApi.CreateAllocator$VH;
    }

    public static MemoryAddress CreateAllocator$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateAllocator$VH.get(seg);
    }

    public static void CreateAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateAllocator$VH.set(seg, x);
    }

    public static MemoryAddress CreateAllocator$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAllocator CreateAllocator(MemorySegment segment) {
        return CreateAllocator.ofAddress(CreateAllocator$get(segment));
    }

    static final FunctionDescriptor ReleaseAllocator$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseAllocator$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseAllocator$FUNC, false);

    public interface ReleaseAllocator {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseAllocator fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseAllocator.class,
                    fi,
                    OrtApi.ReleaseAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseAllocator fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseAllocator.class,
                    fi,
                    OrtApi.ReleaseAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseAllocator ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseAllocator$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseAllocator$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseAllocator")));

    public static VarHandle ReleaseAllocator$VH() {
        return OrtApi.ReleaseAllocator$VH;
    }

    public static MemoryAddress ReleaseAllocator$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseAllocator$VH.get(seg);
    }

    public static void ReleaseAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseAllocator$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseAllocator$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseAllocator ReleaseAllocator(MemorySegment segment) {
        return ReleaseAllocator.ofAddress(ReleaseAllocator$get(segment));
    }

    static final FunctionDescriptor RunWithBinding$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RunWithBinding$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RunWithBinding$FUNC,
            false);

    public interface RunWithBinding {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(RunWithBinding fi) {
            return RuntimeHelper.upcallStub(
                    RunWithBinding.class,
                    fi,
                    OrtApi.RunWithBinding$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RunWithBinding fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RunWithBinding.class,
                    fi,
                    OrtApi.RunWithBinding$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RunWithBinding ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RunWithBinding$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RunWithBinding$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RunWithBinding")));

    public static VarHandle RunWithBinding$VH() {
        return OrtApi.RunWithBinding$VH;
    }

    public static MemoryAddress RunWithBinding$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunWithBinding$VH.get(seg);
    }

    public static void RunWithBinding$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RunWithBinding$VH.set(seg, x);
    }

    public static MemoryAddress RunWithBinding$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RunWithBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RunWithBinding$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RunWithBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RunWithBinding RunWithBinding(MemorySegment segment) {
        return RunWithBinding.ofAddress(RunWithBinding$get(segment));
    }

    static final FunctionDescriptor CreateIoBinding$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateIoBinding$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateIoBinding$FUNC,
            false);

    public interface CreateIoBinding {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(CreateIoBinding fi) {
            return RuntimeHelper.upcallStub(
                    CreateIoBinding.class,
                    fi,
                    OrtApi.CreateIoBinding$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateIoBinding fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateIoBinding.class,
                    fi,
                    OrtApi.CreateIoBinding$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateIoBinding ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateIoBinding$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateIoBinding$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateIoBinding")));

    public static VarHandle CreateIoBinding$VH() {
        return OrtApi.CreateIoBinding$VH;
    }

    public static MemoryAddress CreateIoBinding$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateIoBinding$VH.get(seg);
    }

    public static void CreateIoBinding$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateIoBinding$VH.set(seg, x);
    }

    public static MemoryAddress CreateIoBinding$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateIoBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateIoBinding$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateIoBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateIoBinding CreateIoBinding(MemorySegment segment) {
        return CreateIoBinding.ofAddress(CreateIoBinding$get(segment));
    }

    static final FunctionDescriptor ReleaseIoBinding$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseIoBinding$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseIoBinding$FUNC, false);

    public interface ReleaseIoBinding {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseIoBinding fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseIoBinding.class,
                    fi,
                    OrtApi.ReleaseIoBinding$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseIoBinding fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseIoBinding.class,
                    fi,
                    OrtApi.ReleaseIoBinding$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseIoBinding ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseIoBinding$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseIoBinding$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseIoBinding")));

    public static VarHandle ReleaseIoBinding$VH() {
        return OrtApi.ReleaseIoBinding$VH;
    }

    public static MemoryAddress ReleaseIoBinding$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseIoBinding$VH.get(seg);
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseIoBinding$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseIoBinding$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseIoBinding$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseIoBinding$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseIoBinding$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseIoBinding ReleaseIoBinding(MemorySegment segment) {
        return ReleaseIoBinding.ofAddress(ReleaseIoBinding$get(segment));
    }

    static final FunctionDescriptor BindInput$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle BindInput$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.BindInput$FUNC,
            false);

    public interface BindInput {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(BindInput fi) {
            return RuntimeHelper.upcallStub(
                    BindInput.class,
                    fi,
                    OrtApi.BindInput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(BindInput fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    BindInput.class,
                    fi,
                    OrtApi.BindInput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static BindInput ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.BindInput$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle BindInput$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("BindInput")));

    public static VarHandle BindInput$VH() {
        return OrtApi.BindInput$VH;
    }

    public static MemoryAddress BindInput$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.BindInput$VH.get(seg);
    }

    public static void BindInput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.BindInput$VH.set(seg, x);
    }

    public static MemoryAddress BindInput$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.BindInput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindInput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.BindInput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindInput BindInput(MemorySegment segment) {
        return BindInput.ofAddress(BindInput$get(segment));
    }

    static final FunctionDescriptor BindOutput$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle BindOutput$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.BindOutput$FUNC,
            false);

    public interface BindOutput {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(BindOutput fi) {
            return RuntimeHelper.upcallStub(
                    BindOutput.class,
                    fi,
                    OrtApi.BindOutput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(BindOutput fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    BindOutput.class,
                    fi,
                    OrtApi.BindOutput$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static BindOutput ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.BindOutput$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle BindOutput$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("BindOutput")));

    public static VarHandle BindOutput$VH() {
        return OrtApi.BindOutput$VH;
    }

    public static MemoryAddress BindOutput$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.BindOutput$VH.get(seg);
    }

    public static void BindOutput$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.BindOutput$VH.set(seg, x);
    }

    public static MemoryAddress BindOutput$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.BindOutput$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindOutput$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.BindOutput$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindOutput BindOutput(MemorySegment segment) {
        return BindOutput.ofAddress(BindOutput$get(segment));
    }

    static final FunctionDescriptor BindOutputToDevice$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle BindOutputToDevice$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.BindOutputToDevice$FUNC,
            false);

    public interface BindOutputToDevice {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(BindOutputToDevice fi) {
            return RuntimeHelper.upcallStub(
                    BindOutputToDevice.class,
                    fi,
                    OrtApi.BindOutputToDevice$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(BindOutputToDevice fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    BindOutputToDevice.class,
                    fi,
                    OrtApi.BindOutputToDevice$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static BindOutputToDevice ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.BindOutputToDevice$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle BindOutputToDevice$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("BindOutputToDevice")));

    public static VarHandle BindOutputToDevice$VH() {
        return OrtApi.BindOutputToDevice$VH;
    }

    public static MemoryAddress BindOutputToDevice$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.BindOutputToDevice$VH.get(seg);
    }

    public static void BindOutputToDevice$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.BindOutputToDevice$VH.set(seg, x);
    }

    public static MemoryAddress BindOutputToDevice$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.BindOutputToDevice$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void BindOutputToDevice$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.BindOutputToDevice$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static BindOutputToDevice BindOutputToDevice(MemorySegment segment) {
        return BindOutputToDevice.ofAddress(BindOutputToDevice$get(segment));
    }

    static final FunctionDescriptor GetBoundOutputNames$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetBoundOutputNames$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetBoundOutputNames$FUNC,
            false);

    public interface GetBoundOutputNames {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(GetBoundOutputNames fi) {
            return RuntimeHelper.upcallStub(
                    GetBoundOutputNames.class,
                    fi,
                    OrtApi.GetBoundOutputNames$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetBoundOutputNames fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetBoundOutputNames.class,
                    fi,
                    OrtApi.GetBoundOutputNames$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetBoundOutputNames ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetBoundOutputNames$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetBoundOutputNames$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetBoundOutputNames")));

    public static VarHandle GetBoundOutputNames$VH() {
        return OrtApi.GetBoundOutputNames$VH;
    }

    public static MemoryAddress GetBoundOutputNames$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetBoundOutputNames$VH.get(seg);
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetBoundOutputNames$VH.set(seg, x);
    }

    public static MemoryAddress GetBoundOutputNames$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetBoundOutputNames$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBoundOutputNames$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetBoundOutputNames$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBoundOutputNames GetBoundOutputNames(MemorySegment segment) {
        return GetBoundOutputNames.ofAddress(GetBoundOutputNames$get(segment));
    }

    static final FunctionDescriptor GetBoundOutputValues$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetBoundOutputValues$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetBoundOutputValues$FUNC,
            false);

    public interface GetBoundOutputValues {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(GetBoundOutputValues fi) {
            return RuntimeHelper.upcallStub(
                    GetBoundOutputValues.class,
                    fi,
                    OrtApi.GetBoundOutputValues$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetBoundOutputValues fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetBoundOutputValues.class,
                    fi,
                    OrtApi.GetBoundOutputValues$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetBoundOutputValues ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetBoundOutputValues$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetBoundOutputValues$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetBoundOutputValues")));

    public static VarHandle GetBoundOutputValues$VH() {
        return OrtApi.GetBoundOutputValues$VH;
    }

    public static MemoryAddress GetBoundOutputValues$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetBoundOutputValues$VH.get(seg);
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetBoundOutputValues$VH.set(seg, x);
    }

    public static MemoryAddress GetBoundOutputValues$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetBoundOutputValues$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetBoundOutputValues$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetBoundOutputValues$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetBoundOutputValues GetBoundOutputValues(MemorySegment segment) {
        return GetBoundOutputValues.ofAddress(GetBoundOutputValues$get(segment));
    }

    static final FunctionDescriptor ClearBoundInputs$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ClearBoundInputs$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ClearBoundInputs$FUNC, false);

    public interface ClearBoundInputs {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ClearBoundInputs fi) {
            return RuntimeHelper.upcallStub(
                    ClearBoundInputs.class,
                    fi,
                    OrtApi.ClearBoundInputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ClearBoundInputs fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ClearBoundInputs.class,
                    fi,
                    OrtApi.ClearBoundInputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ClearBoundInputs ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ClearBoundInputs$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ClearBoundInputs$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ClearBoundInputs")));

    public static VarHandle ClearBoundInputs$VH() {
        return OrtApi.ClearBoundInputs$VH;
    }

    public static MemoryAddress ClearBoundInputs$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ClearBoundInputs$VH.get(seg);
    }

    public static void ClearBoundInputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ClearBoundInputs$VH.set(seg, x);
    }

    public static MemoryAddress ClearBoundInputs$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ClearBoundInputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ClearBoundInputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ClearBoundInputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ClearBoundInputs ClearBoundInputs(MemorySegment segment) {
        return ClearBoundInputs.ofAddress(ClearBoundInputs$get(segment));
    }

    static final FunctionDescriptor ClearBoundOutputs$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ClearBoundOutputs$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ClearBoundOutputs$FUNC, false);

    public interface ClearBoundOutputs {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ClearBoundOutputs fi) {
            return RuntimeHelper.upcallStub(
                    ClearBoundOutputs.class,
                    fi,
                    OrtApi.ClearBoundOutputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ClearBoundOutputs fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ClearBoundOutputs.class,
                    fi,
                    OrtApi.ClearBoundOutputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ClearBoundOutputs ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ClearBoundOutputs$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ClearBoundOutputs$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ClearBoundOutputs")));

    public static VarHandle ClearBoundOutputs$VH() {
        return OrtApi.ClearBoundOutputs$VH;
    }

    public static MemoryAddress ClearBoundOutputs$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ClearBoundOutputs$VH.get(seg);
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ClearBoundOutputs$VH.set(seg, x);
    }

    public static MemoryAddress ClearBoundOutputs$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ClearBoundOutputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ClearBoundOutputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ClearBoundOutputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ClearBoundOutputs ClearBoundOutputs(MemorySegment segment) {
        return ClearBoundOutputs.ofAddress(ClearBoundOutputs$get(segment));
    }

    static final FunctionDescriptor TensorAt$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle TensorAt$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.TensorAt$FUNC,
            false);

    public interface TensorAt {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(TensorAt fi) {
            return RuntimeHelper.upcallStub(
                    TensorAt.class,
                    fi,
                    OrtApi.TensorAt$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(TensorAt fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    TensorAt.class,
                    fi,
                    OrtApi.TensorAt$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static TensorAt ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.TensorAt$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle TensorAt$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("TensorAt")));

    public static VarHandle TensorAt$VH() {
        return OrtApi.TensorAt$VH;
    }

    public static MemoryAddress TensorAt$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.TensorAt$VH.get(seg);
    }

    public static void TensorAt$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.TensorAt$VH.set(seg, x);
    }

    public static MemoryAddress TensorAt$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.TensorAt$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void TensorAt$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.TensorAt$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static TensorAt TensorAt(MemorySegment segment) {
        return TensorAt.ofAddress(TensorAt$get(segment));
    }

    static final FunctionDescriptor CreateAndRegisterAllocator$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateAndRegisterAllocator$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateAndRegisterAllocator$FUNC,
            false);

    public interface CreateAndRegisterAllocator {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(CreateAndRegisterAllocator fi) {
            return RuntimeHelper.upcallStub(
                    CreateAndRegisterAllocator.class,
                    fi,
                    OrtApi.CreateAndRegisterAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateAndRegisterAllocator fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateAndRegisterAllocator.class,
                    fi,
                    OrtApi.CreateAndRegisterAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateAndRegisterAllocator ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateAndRegisterAllocator$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateAndRegisterAllocator$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateAndRegisterAllocator")));

    public static VarHandle CreateAndRegisterAllocator$VH() {
        return OrtApi.CreateAndRegisterAllocator$VH;
    }

    public static MemoryAddress CreateAndRegisterAllocator$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateAndRegisterAllocator$VH.get(seg);
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateAndRegisterAllocator$VH.set(seg, x);
    }

    public static MemoryAddress CreateAndRegisterAllocator$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateAndRegisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateAndRegisterAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateAndRegisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateAndRegisterAllocator CreateAndRegisterAllocator(MemorySegment segment) {
        return CreateAndRegisterAllocator.ofAddress(CreateAndRegisterAllocator$get(segment));
    }

    static final FunctionDescriptor SetLanguageProjection$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetLanguageProjection$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetLanguageProjection$FUNC,
            false);

    public interface SetLanguageProjection {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetLanguageProjection fi) {
            return RuntimeHelper.upcallStub(
                    SetLanguageProjection.class,
                    fi,
                    OrtApi.SetLanguageProjection$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetLanguageProjection fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetLanguageProjection.class,
                    fi,
                    OrtApi.SetLanguageProjection$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetLanguageProjection ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetLanguageProjection$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetLanguageProjection$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetLanguageProjection")));

    public static VarHandle SetLanguageProjection$VH() {
        return OrtApi.SetLanguageProjection$VH;
    }

    public static MemoryAddress SetLanguageProjection$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetLanguageProjection$VH.get(seg);
    }

    public static void SetLanguageProjection$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetLanguageProjection$VH.set(seg, x);
    }

    public static MemoryAddress SetLanguageProjection$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetLanguageProjection$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetLanguageProjection$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetLanguageProjection$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetLanguageProjection SetLanguageProjection(MemorySegment segment) {
        return SetLanguageProjection.ofAddress(SetLanguageProjection$get(segment));
    }

    static final FunctionDescriptor SessionGetProfilingStartTimeNs$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionGetProfilingStartTimeNs$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionGetProfilingStartTimeNs$FUNC,
            false);

    public interface SessionGetProfilingStartTimeNs {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionGetProfilingStartTimeNs fi) {
            return RuntimeHelper.upcallStub(
                    SessionGetProfilingStartTimeNs.class,
                    fi,
                    OrtApi.SessionGetProfilingStartTimeNs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionGetProfilingStartTimeNs fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionGetProfilingStartTimeNs.class,
                    fi,
                    OrtApi.SessionGetProfilingStartTimeNs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionGetProfilingStartTimeNs ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionGetProfilingStartTimeNs$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionGetProfilingStartTimeNs$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionGetProfilingStartTimeNs")));

    public static VarHandle SessionGetProfilingStartTimeNs$VH() {
        return OrtApi.SessionGetProfilingStartTimeNs$VH;
    }

    public static MemoryAddress SessionGetProfilingStartTimeNs$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionGetProfilingStartTimeNs$VH.get(seg);
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionGetProfilingStartTimeNs$VH.set(seg, x);
    }

    public static MemoryAddress SessionGetProfilingStartTimeNs$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionGetProfilingStartTimeNs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionGetProfilingStartTimeNs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionGetProfilingStartTimeNs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionGetProfilingStartTimeNs SessionGetProfilingStartTimeNs(MemorySegment segment) {
        return SessionGetProfilingStartTimeNs.ofAddress(SessionGetProfilingStartTimeNs$get(segment));
    }

    static final FunctionDescriptor SetGlobalIntraOpNumThreads$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetGlobalIntraOpNumThreads$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalIntraOpNumThreads$FUNC,
            false);

    public interface SetGlobalIntraOpNumThreads {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetGlobalIntraOpNumThreads fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalIntraOpNumThreads.class,
                    fi,
                    OrtApi.SetGlobalIntraOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalIntraOpNumThreads fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalIntraOpNumThreads.class,
                    fi,
                    OrtApi.SetGlobalIntraOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalIntraOpNumThreads ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalIntraOpNumThreads$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalIntraOpNumThreads$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetGlobalIntraOpNumThreads")));

    public static VarHandle SetGlobalIntraOpNumThreads$VH() {
        return OrtApi.SetGlobalIntraOpNumThreads$VH;
    }

    public static MemoryAddress SetGlobalIntraOpNumThreads$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalIntraOpNumThreads$VH.get(seg);
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalIntraOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalIntraOpNumThreads$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetGlobalIntraOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalIntraOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalIntraOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalIntraOpNumThreads SetGlobalIntraOpNumThreads(MemorySegment segment) {
        return SetGlobalIntraOpNumThreads.ofAddress(SetGlobalIntraOpNumThreads$get(segment));
    }

    static final FunctionDescriptor SetGlobalInterOpNumThreads$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetGlobalInterOpNumThreads$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalInterOpNumThreads$FUNC,
            false);

    public interface SetGlobalInterOpNumThreads {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetGlobalInterOpNumThreads fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalInterOpNumThreads.class,
                    fi,
                    OrtApi.SetGlobalInterOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalInterOpNumThreads fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalInterOpNumThreads.class,
                    fi,
                    OrtApi.SetGlobalInterOpNumThreads$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalInterOpNumThreads ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalInterOpNumThreads$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalInterOpNumThreads$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetGlobalInterOpNumThreads")));

    public static VarHandle SetGlobalInterOpNumThreads$VH() {
        return OrtApi.SetGlobalInterOpNumThreads$VH;
    }

    public static MemoryAddress SetGlobalInterOpNumThreads$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalInterOpNumThreads$VH.get(seg);
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalInterOpNumThreads$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalInterOpNumThreads$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetGlobalInterOpNumThreads$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalInterOpNumThreads$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalInterOpNumThreads$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalInterOpNumThreads SetGlobalInterOpNumThreads(MemorySegment segment) {
        return SetGlobalInterOpNumThreads.ofAddress(SetGlobalInterOpNumThreads$get(segment));
    }

    static final FunctionDescriptor SetGlobalSpinControl$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT);
    static final MethodHandle SetGlobalSpinControl$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalSpinControl$FUNC,
            false);

    public interface SetGlobalSpinControl {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0, int x1);

        static MemoryAddress allocate(SetGlobalSpinControl fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalSpinControl.class,
                    fi,
                    OrtApi.SetGlobalSpinControl$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalSpinControl fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalSpinControl.class,
                    fi,
                    OrtApi.SetGlobalSpinControl$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalSpinControl ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalSpinControl$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalSpinControl$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetGlobalSpinControl")));

    public static VarHandle SetGlobalSpinControl$VH() {
        return OrtApi.SetGlobalSpinControl$VH;
    }

    public static MemoryAddress SetGlobalSpinControl$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalSpinControl$VH.get(seg);
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalSpinControl$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalSpinControl$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalSpinControl$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalSpinControl$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalSpinControl$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalSpinControl SetGlobalSpinControl(MemorySegment segment) {
        return SetGlobalSpinControl.ofAddress(SetGlobalSpinControl$get(segment));
    }

    static final FunctionDescriptor AddInitializer$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle AddInitializer$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AddInitializer$FUNC,
            false);

    public interface AddInitializer {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(AddInitializer fi) {
            return RuntimeHelper.upcallStub(
                    AddInitializer.class,
                    fi,
                    OrtApi.AddInitializer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AddInitializer fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AddInitializer.class,
                    fi,
                    OrtApi.AddInitializer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AddInitializer ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AddInitializer$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddInitializer$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AddInitializer")));

    public static VarHandle AddInitializer$VH() {
        return OrtApi.AddInitializer$VH;
    }

    public static MemoryAddress AddInitializer$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddInitializer$VH.get(seg);
    }

    public static void AddInitializer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddInitializer$VH.set(seg, x);
    }

    public static MemoryAddress AddInitializer$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddInitializer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddInitializer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddInitializer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddInitializer AddInitializer(MemorySegment segment) {
        return AddInitializer.ofAddress(AddInitializer$get(segment));
    }

    static final FunctionDescriptor CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_INT, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC,
            false);

    public interface CreateEnvWithCustomLoggerAndGlobalThreadPools {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                int x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4,
                jdk.incubator.foreign.MemoryAddress x5);

        static MemoryAddress allocate(CreateEnvWithCustomLoggerAndGlobalThreadPools fi) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLoggerAndGlobalThreadPools.class,
                    fi,
                    OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateEnvWithCustomLoggerAndGlobalThreadPools fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateEnvWithCustomLoggerAndGlobalThreadPools.class,
                    fi,
                    OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateEnvWithCustomLoggerAndGlobalThreadPools ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    int x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    jdk.incubator.foreign.MemoryAddress x4,
                    jdk.incubator.foreign.MemoryAddress x5) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3, x4, x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class,
                    MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLoggerAndGlobalThreadPools")));

    public static VarHandle CreateEnvWithCustomLoggerAndGlobalThreadPools$VH() {
        return OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH;
    }

    public static MemoryAddress CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.get(seg);
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.set(seg, x);
    }

    public static MemoryAddress CreateEnvWithCustomLoggerAndGlobalThreadPools$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateEnvWithCustomLoggerAndGlobalThreadPools$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateEnvWithCustomLoggerAndGlobalThreadPools CreateEnvWithCustomLoggerAndGlobalThreadPools(
            MemorySegment segment) {
        return CreateEnvWithCustomLoggerAndGlobalThreadPools.ofAddress(
                CreateEnvWithCustomLoggerAndGlobalThreadPools$get(segment));
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_CUDA$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsAppendExecutionProvider_CUDA$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC,
            false);

    public interface SessionOptionsAppendExecutionProvider_CUDA {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_CUDA fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CUDA.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_CUDA fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_CUDA.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_CUDA$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_CUDA ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_CUDA$MH.invokeExact(
                                    (Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_CUDA$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_CUDA")));

    public static VarHandle SessionOptionsAppendExecutionProvider_CUDA$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_CUDA$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_CUDA$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_CUDA$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_CUDA SessionOptionsAppendExecutionProvider_CUDA(
            MemorySegment segment) {
        return SessionOptionsAppendExecutionProvider_CUDA.ofAddress(
                SessionOptionsAppendExecutionProvider_CUDA$get(segment));
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_ROCM$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsAppendExecutionProvider_ROCM$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC,
            false);

    public interface SessionOptionsAppendExecutionProvider_ROCM {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_ROCM fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_ROCM.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_ROCM fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_ROCM.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_ROCM$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_ROCM ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_ROCM$MH.invokeExact(
                                    (Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_ROCM$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_ROCM")));

    public static VarHandle SessionOptionsAppendExecutionProvider_ROCM$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_ROCM$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_ROCM$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_ROCM$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_ROCM SessionOptionsAppendExecutionProvider_ROCM(
            MemorySegment segment) {
        return SessionOptionsAppendExecutionProvider_ROCM.ofAddress(
                SessionOptionsAppendExecutionProvider_ROCM$get(segment));
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_OpenVINO$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsAppendExecutionProvider_OpenVINO$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC,
            false);

    public interface SessionOptionsAppendExecutionProvider_OpenVINO {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_OpenVINO fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_OpenVINO.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_OpenVINO fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_OpenVINO.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_OpenVINO ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$MH.invokeExact(
                                    (Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_OpenVINO$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class,
                    MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_OpenVINO")));

    public static VarHandle SessionOptionsAppendExecutionProvider_OpenVINO$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_OpenVINO$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_OpenVINO$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_OpenVINO SessionOptionsAppendExecutionProvider_OpenVINO(
            MemorySegment segment) {
        return SessionOptionsAppendExecutionProvider_OpenVINO.ofAddress(
                SessionOptionsAppendExecutionProvider_OpenVINO$get(segment));
    }

    static final FunctionDescriptor SetGlobalDenormalAsZero$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle SetGlobalDenormalAsZero$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalDenormalAsZero$FUNC,
            false);

    public interface SetGlobalDenormalAsZero {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(SetGlobalDenormalAsZero fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalDenormalAsZero.class,
                    fi,
                    OrtApi.SetGlobalDenormalAsZero$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalDenormalAsZero fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalDenormalAsZero.class,
                    fi,
                    OrtApi.SetGlobalDenormalAsZero$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalDenormalAsZero ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalDenormalAsZero$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalDenormalAsZero$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetGlobalDenormalAsZero")));

    public static VarHandle SetGlobalDenormalAsZero$VH() {
        return OrtApi.SetGlobalDenormalAsZero$VH;
    }

    public static MemoryAddress SetGlobalDenormalAsZero$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalDenormalAsZero$VH.get(seg);
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalDenormalAsZero$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalDenormalAsZero$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetGlobalDenormalAsZero$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalDenormalAsZero$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalDenormalAsZero$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalDenormalAsZero SetGlobalDenormalAsZero(MemorySegment segment) {
        return SetGlobalDenormalAsZero.ofAddress(SetGlobalDenormalAsZero$get(segment));
    }

    static final FunctionDescriptor CreateArenaCfg$FUNC =
            FunctionDescriptor.of(C_POINTER, C_LONG, C_INT, C_INT, C_INT, C_POINTER);
    static final MethodHandle CreateArenaCfg$MH = RuntimeHelper.downcallHandle(
            "(JIIILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateArenaCfg$FUNC,
            false);

    public interface CreateArenaCfg {

        jdk.incubator.foreign.MemoryAddress apply(
                long x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateArenaCfg fi) {
            return RuntimeHelper.upcallStub(
                    CreateArenaCfg.class,
                    fi,
                    OrtApi.CreateArenaCfg$FUNC,
                    "(JIIILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateArenaCfg fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateArenaCfg.class,
                    fi,
                    OrtApi.CreateArenaCfg$FUNC,
                    "(JIIILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateArenaCfg ofAddress(MemoryAddress addr) {
            return (long x0, int x1, int x2, int x3, jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateArenaCfg$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateArenaCfg$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateArenaCfg")));

    public static VarHandle CreateArenaCfg$VH() {
        return OrtApi.CreateArenaCfg$VH;
    }

    public static MemoryAddress CreateArenaCfg$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateArenaCfg$VH.get(seg);
    }

    public static void CreateArenaCfg$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateArenaCfg$VH.set(seg, x);
    }

    public static MemoryAddress CreateArenaCfg$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateArenaCfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateArenaCfg$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateArenaCfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateArenaCfg CreateArenaCfg(MemorySegment segment) {
        return CreateArenaCfg.ofAddress(CreateArenaCfg$get(segment));
    }

    static final FunctionDescriptor ReleaseArenaCfg$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseArenaCfg$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseArenaCfg$FUNC, false);

    public interface ReleaseArenaCfg {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseArenaCfg fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseArenaCfg.class, fi, OrtApi.ReleaseArenaCfg$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseArenaCfg fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseArenaCfg.class,
                    fi,
                    OrtApi.ReleaseArenaCfg$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseArenaCfg ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseArenaCfg$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseArenaCfg$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("ReleaseArenaCfg")));

    public static VarHandle ReleaseArenaCfg$VH() {
        return OrtApi.ReleaseArenaCfg$VH;
    }

    public static MemoryAddress ReleaseArenaCfg$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseArenaCfg$VH.get(seg);
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseArenaCfg$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseArenaCfg$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseArenaCfg$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseArenaCfg$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseArenaCfg$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseArenaCfg ReleaseArenaCfg(MemorySegment segment) {
        return ReleaseArenaCfg.ofAddress(ReleaseArenaCfg$get(segment));
    }

    static final FunctionDescriptor ModelMetadataGetGraphDescription$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle ModelMetadataGetGraphDescription$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.ModelMetadataGetGraphDescription$FUNC,
            false);

    public interface ModelMetadataGetGraphDescription {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(ModelMetadataGetGraphDescription fi) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphDescription.class,
                    fi,
                    OrtApi.ModelMetadataGetGraphDescription$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(ModelMetadataGetGraphDescription fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ModelMetadataGetGraphDescription.class,
                    fi,
                    OrtApi.ModelMetadataGetGraphDescription$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static ModelMetadataGetGraphDescription ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.ModelMetadataGetGraphDescription$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ModelMetadataGetGraphDescription$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("ModelMetadataGetGraphDescription")));

    public static VarHandle ModelMetadataGetGraphDescription$VH() {
        return OrtApi.ModelMetadataGetGraphDescription$VH;
    }

    public static MemoryAddress ModelMetadataGetGraphDescription$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ModelMetadataGetGraphDescription$VH.get(seg);
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphDescription$VH.set(seg, x);
    }

    public static MemoryAddress ModelMetadataGetGraphDescription$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ModelMetadataGetGraphDescription$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ModelMetadataGetGraphDescription$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ModelMetadataGetGraphDescription$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ModelMetadataGetGraphDescription ModelMetadataGetGraphDescription(MemorySegment segment) {
        return ModelMetadataGetGraphDescription.ofAddress(ModelMetadataGetGraphDescription$get(segment));
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_TensorRT$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsAppendExecutionProvider_TensorRT$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC,
            false);

    public interface SessionOptionsAppendExecutionProvider_TensorRT {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_TensorRT fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_TensorRT fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$MH.invokeExact(
                                    (Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_TensorRT$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class,
                    MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_TensorRT")));

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT SessionOptionsAppendExecutionProvider_TensorRT(
            MemorySegment segment) {
        return SessionOptionsAppendExecutionProvider_TensorRT.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT$get(segment));
    }

    static final FunctionDescriptor SetCurrentGpuDeviceId$FUNC = FunctionDescriptor.of(C_POINTER, C_INT);
    static final MethodHandle SetCurrentGpuDeviceId$MH = RuntimeHelper.downcallHandle(
            "(I)Ljdk/incubator/foreign/MemoryAddress;", OrtApi.SetCurrentGpuDeviceId$FUNC, false);

    public interface SetCurrentGpuDeviceId {

        jdk.incubator.foreign.MemoryAddress apply(int x0);

        static MemoryAddress allocate(SetCurrentGpuDeviceId fi) {
            return RuntimeHelper.upcallStub(
                    SetCurrentGpuDeviceId.class,
                    fi,
                    OrtApi.SetCurrentGpuDeviceId$FUNC,
                    "(I)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetCurrentGpuDeviceId fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetCurrentGpuDeviceId.class,
                    fi,
                    OrtApi.SetCurrentGpuDeviceId$FUNC,
                    "(I)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetCurrentGpuDeviceId ofAddress(MemoryAddress addr) {
            return (int x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetCurrentGpuDeviceId$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetCurrentGpuDeviceId$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetCurrentGpuDeviceId")));

    public static VarHandle SetCurrentGpuDeviceId$VH() {
        return OrtApi.SetCurrentGpuDeviceId$VH;
    }

    public static MemoryAddress SetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetCurrentGpuDeviceId$VH.get(seg);
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetCurrentGpuDeviceId$VH.set(seg, x);
    }

    public static MemoryAddress SetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetCurrentGpuDeviceId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetCurrentGpuDeviceId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetCurrentGpuDeviceId SetCurrentGpuDeviceId(MemorySegment segment) {
        return SetCurrentGpuDeviceId.ofAddress(SetCurrentGpuDeviceId$get(segment));
    }

    static final FunctionDescriptor GetCurrentGpuDeviceId$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle GetCurrentGpuDeviceId$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetCurrentGpuDeviceId$FUNC,
            false);

    public interface GetCurrentGpuDeviceId {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetCurrentGpuDeviceId fi) {
            return RuntimeHelper.upcallStub(
                    GetCurrentGpuDeviceId.class,
                    fi,
                    OrtApi.GetCurrentGpuDeviceId$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetCurrentGpuDeviceId fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetCurrentGpuDeviceId.class,
                    fi,
                    OrtApi.GetCurrentGpuDeviceId$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetCurrentGpuDeviceId ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetCurrentGpuDeviceId$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetCurrentGpuDeviceId$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetCurrentGpuDeviceId")));

    public static VarHandle GetCurrentGpuDeviceId$VH() {
        return OrtApi.GetCurrentGpuDeviceId$VH;
    }

    public static MemoryAddress GetCurrentGpuDeviceId$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetCurrentGpuDeviceId$VH.get(seg);
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetCurrentGpuDeviceId$VH.set(seg, x);
    }

    public static MemoryAddress GetCurrentGpuDeviceId$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetCurrentGpuDeviceId$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetCurrentGpuDeviceId$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetCurrentGpuDeviceId$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetCurrentGpuDeviceId GetCurrentGpuDeviceId(MemorySegment segment) {
        return GetCurrentGpuDeviceId.ofAddress(GetCurrentGpuDeviceId$get(segment));
    }

    static final FunctionDescriptor KernelInfoGetAttributeArray_float$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelInfoGetAttributeArray_float$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelInfoGetAttributeArray_float$FUNC,
            false);

    public interface KernelInfoGetAttributeArray_float {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(KernelInfoGetAttributeArray_float fi) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_float.class,
                    fi,
                    OrtApi.KernelInfoGetAttributeArray_float$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelInfoGetAttributeArray_float fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_float.class,
                    fi,
                    OrtApi.KernelInfoGetAttributeArray_float$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelInfoGetAttributeArray_float ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelInfoGetAttributeArray_float$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttributeArray_float$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_float")));

    public static VarHandle KernelInfoGetAttributeArray_float$VH() {
        return OrtApi.KernelInfoGetAttributeArray_float$VH;
    }

    public static MemoryAddress KernelInfoGetAttributeArray_float$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelInfoGetAttributeArray_float$VH.get(seg);
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_float$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttributeArray_float$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttributeArray_float$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttributeArray_float$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_float$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttributeArray_float KernelInfoGetAttributeArray_float(MemorySegment segment) {
        return KernelInfoGetAttributeArray_float.ofAddress(KernelInfoGetAttributeArray_float$get(segment));
    }

    static final FunctionDescriptor KernelInfoGetAttributeArray_int64$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelInfoGetAttributeArray_int64$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelInfoGetAttributeArray_int64$FUNC,
            false);

    public interface KernelInfoGetAttributeArray_int64 {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(KernelInfoGetAttributeArray_int64 fi) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_int64.class,
                    fi,
                    OrtApi.KernelInfoGetAttributeArray_int64$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelInfoGetAttributeArray_int64 fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelInfoGetAttributeArray_int64.class,
                    fi,
                    OrtApi.KernelInfoGetAttributeArray_int64$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelInfoGetAttributeArray_int64 ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelInfoGetAttributeArray_int64$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelInfoGetAttributeArray_int64$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_int64")));

    public static VarHandle KernelInfoGetAttributeArray_int64$VH() {
        return OrtApi.KernelInfoGetAttributeArray_int64$VH;
    }

    public static MemoryAddress KernelInfoGetAttributeArray_int64$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelInfoGetAttributeArray_int64$VH.get(seg);
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_int64$VH.set(seg, x);
    }

    public static MemoryAddress KernelInfoGetAttributeArray_int64$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelInfoGetAttributeArray_int64$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelInfoGetAttributeArray_int64$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelInfoGetAttributeArray_int64$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelInfoGetAttributeArray_int64 KernelInfoGetAttributeArray_int64(MemorySegment segment) {
        return KernelInfoGetAttributeArray_int64.ofAddress(KernelInfoGetAttributeArray_int64$get(segment));
    }

    static final FunctionDescriptor CreateArenaCfgV2$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle CreateArenaCfgV2$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateArenaCfgV2$FUNC,
            false);

    public interface CreateArenaCfgV2 {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(CreateArenaCfgV2 fi) {
            return RuntimeHelper.upcallStub(
                    CreateArenaCfgV2.class,
                    fi,
                    OrtApi.CreateArenaCfgV2$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateArenaCfgV2 fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateArenaCfgV2.class,
                    fi,
                    OrtApi.CreateArenaCfgV2$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateArenaCfgV2 ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateArenaCfgV2$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateArenaCfgV2$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateArenaCfgV2")));

    public static VarHandle CreateArenaCfgV2$VH() {
        return OrtApi.CreateArenaCfgV2$VH;
    }

    public static MemoryAddress CreateArenaCfgV2$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateArenaCfgV2$VH.get(seg);
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateArenaCfgV2$VH.set(seg, x);
    }

    public static MemoryAddress CreateArenaCfgV2$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateArenaCfgV2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateArenaCfgV2$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateArenaCfgV2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateArenaCfgV2 CreateArenaCfgV2(MemorySegment segment) {
        return CreateArenaCfgV2.ofAddress(CreateArenaCfgV2$get(segment));
    }

    static final FunctionDescriptor AddRunConfigEntry$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle AddRunConfigEntry$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.AddRunConfigEntry$FUNC,
            false);

    public interface AddRunConfigEntry {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(AddRunConfigEntry fi) {
            return RuntimeHelper.upcallStub(
                    AddRunConfigEntry.class,
                    fi,
                    OrtApi.AddRunConfigEntry$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(AddRunConfigEntry fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    AddRunConfigEntry.class,
                    fi,
                    OrtApi.AddRunConfigEntry$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static AddRunConfigEntry ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.AddRunConfigEntry$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle AddRunConfigEntry$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("AddRunConfigEntry")));

    public static VarHandle AddRunConfigEntry$VH() {
        return OrtApi.AddRunConfigEntry$VH;
    }

    public static MemoryAddress AddRunConfigEntry$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddRunConfigEntry$VH.get(seg);
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.AddRunConfigEntry$VH.set(seg, x);
    }

    public static MemoryAddress AddRunConfigEntry$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.AddRunConfigEntry$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void AddRunConfigEntry$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.AddRunConfigEntry$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static AddRunConfigEntry AddRunConfigEntry(MemorySegment segment) {
        return AddRunConfigEntry.ofAddress(AddRunConfigEntry$get(segment));
    }

    static final FunctionDescriptor CreatePrepackedWeightsContainer$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle CreatePrepackedWeightsContainer$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreatePrepackedWeightsContainer$FUNC,
            false);

    public interface CreatePrepackedWeightsContainer {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(CreatePrepackedWeightsContainer fi) {
            return RuntimeHelper.upcallStub(
                    CreatePrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreatePrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreatePrepackedWeightsContainer fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreatePrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreatePrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreatePrepackedWeightsContainer ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreatePrepackedWeightsContainer$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreatePrepackedWeightsContainer$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("CreatePrepackedWeightsContainer")));

    public static VarHandle CreatePrepackedWeightsContainer$VH() {
        return OrtApi.CreatePrepackedWeightsContainer$VH;
    }

    public static MemoryAddress CreatePrepackedWeightsContainer$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreatePrepackedWeightsContainer$VH.get(seg);
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreatePrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress CreatePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreatePrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreatePrepackedWeightsContainer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreatePrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreatePrepackedWeightsContainer CreatePrepackedWeightsContainer(MemorySegment segment) {
        return CreatePrepackedWeightsContainer.ofAddress(CreatePrepackedWeightsContainer$get(segment));
    }

    static final FunctionDescriptor ReleasePrepackedWeightsContainer$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleasePrepackedWeightsContainer$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleasePrepackedWeightsContainer$FUNC, false);

    public interface ReleasePrepackedWeightsContainer {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleasePrepackedWeightsContainer fi) {
            return RuntimeHelper.upcallStub(
                    ReleasePrepackedWeightsContainer.class,
                    fi,
                    OrtApi.ReleasePrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleasePrepackedWeightsContainer fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleasePrepackedWeightsContainer.class,
                    fi,
                    OrtApi.ReleasePrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleasePrepackedWeightsContainer ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleasePrepackedWeightsContainer$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleasePrepackedWeightsContainer$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("ReleasePrepackedWeightsContainer")));

    public static VarHandle ReleasePrepackedWeightsContainer$VH() {
        return OrtApi.ReleasePrepackedWeightsContainer$VH;
    }

    public static MemoryAddress ReleasePrepackedWeightsContainer$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleasePrepackedWeightsContainer$VH.get(seg);
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleasePrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress ReleasePrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ReleasePrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleasePrepackedWeightsContainer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleasePrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleasePrepackedWeightsContainer ReleasePrepackedWeightsContainer(MemorySegment segment) {
        return ReleasePrepackedWeightsContainer.ofAddress(ReleasePrepackedWeightsContainer$get(segment));
    }

    static final FunctionDescriptor CreateSessionWithPrepackedWeightsContainer$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateSessionWithPrepackedWeightsContainer$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSessionWithPrepackedWeightsContainer$FUNC,
            false);

    public interface CreateSessionWithPrepackedWeightsContainer {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateSessionWithPrepackedWeightsContainer fi) {
            return RuntimeHelper.upcallStub(
                    CreateSessionWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionWithPrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSessionWithPrepackedWeightsContainer fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionWithPrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSessionWithPrepackedWeightsContainer ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSessionWithPrepackedWeightsContainer$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionWithPrepackedWeightsContainer$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("CreateSessionWithPrepackedWeightsContainer")));

    public static VarHandle CreateSessionWithPrepackedWeightsContainer$VH() {
        return OrtApi.CreateSessionWithPrepackedWeightsContainer$VH;
    }

    public static MemoryAddress CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.get(seg);
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionWithPrepackedWeightsContainer$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionWithPrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionWithPrepackedWeightsContainer CreateSessionWithPrepackedWeightsContainer(
            MemorySegment segment) {
        return CreateSessionWithPrepackedWeightsContainer.ofAddress(
                CreateSessionWithPrepackedWeightsContainer$get(segment));
    }

    static final FunctionDescriptor CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateSessionFromArrayWithPrepackedWeightsContainer$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC,
            false);

    public interface CreateSessionFromArrayWithPrepackedWeightsContainer {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3,
                jdk.incubator.foreign.MemoryAddress x4,
                jdk.incubator.foreign.MemoryAddress x5);

        static MemoryAddress allocate(CreateSessionFromArrayWithPrepackedWeightsContainer fi) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArrayWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSessionFromArrayWithPrepackedWeightsContainer fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSessionFromArrayWithPrepackedWeightsContainer.class,
                    fi,
                    OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSessionFromArrayWithPrepackedWeightsContainer ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    jdk.incubator.foreign.MemoryAddress x4,
                    jdk.incubator.foreign.MemoryAddress x5) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3, x4, x5);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSessionFromArrayWithPrepackedWeightsContainer$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class,
                    MemoryLayout.PathElement.groupElement("CreateSessionFromArrayWithPrepackedWeightsContainer")));

    public static VarHandle CreateSessionFromArrayWithPrepackedWeightsContainer$VH() {
        return OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH;
    }

    public static MemoryAddress CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.get(seg);
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.set(seg, x);
    }

    public static MemoryAddress CreateSessionFromArrayWithPrepackedWeightsContainer$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSessionFromArrayWithPrepackedWeightsContainer$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSessionFromArrayWithPrepackedWeightsContainer
            CreateSessionFromArrayWithPrepackedWeightsContainer(MemorySegment segment) {
        return CreateSessionFromArrayWithPrepackedWeightsContainer.ofAddress(
                CreateSessionFromArrayWithPrepackedWeightsContainer$get(segment));
    }

    static final FunctionDescriptor SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC,
            false);

    public interface SessionOptionsAppendExecutionProvider_TensorRT_V2 {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_TensorRT_V2 fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsAppendExecutionProvider_TensorRT_V2 fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsAppendExecutionProvider_TensorRT_V2.class,
                    fi,
                    OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsAppendExecutionProvider_TensorRT_V2 ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$MH.invokeExact(
                                    (Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class,
                    MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_TensorRT_V2")));

    public static VarHandle SessionOptionsAppendExecutionProvider_TensorRT_V2$VH() {
        return OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH;
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.get(seg);
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsAppendExecutionProvider_TensorRT_V2$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsAppendExecutionProvider_TensorRT_V2$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsAppendExecutionProvider_TensorRT_V2 SessionOptionsAppendExecutionProvider_TensorRT_V2(
            MemorySegment segment) {
        return SessionOptionsAppendExecutionProvider_TensorRT_V2.ofAddress(
                SessionOptionsAppendExecutionProvider_TensorRT_V2$get(segment));
    }

    static final FunctionDescriptor CreateTensorRTProviderOptions$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle CreateTensorRTProviderOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateTensorRTProviderOptions$FUNC,
            false);

    public interface CreateTensorRTProviderOptions {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(CreateTensorRTProviderOptions fi) {
            return RuntimeHelper.upcallStub(
                    CreateTensorRTProviderOptions.class,
                    fi,
                    OrtApi.CreateTensorRTProviderOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateTensorRTProviderOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateTensorRTProviderOptions.class,
                    fi,
                    OrtApi.CreateTensorRTProviderOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateTensorRTProviderOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateTensorRTProviderOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateTensorRTProviderOptions$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("CreateTensorRTProviderOptions")));

    public static VarHandle CreateTensorRTProviderOptions$VH() {
        return OrtApi.CreateTensorRTProviderOptions$VH;
    }

    public static MemoryAddress CreateTensorRTProviderOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateTensorRTProviderOptions$VH.get(seg);
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress CreateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateTensorRTProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateTensorRTProviderOptions CreateTensorRTProviderOptions(MemorySegment segment) {
        return CreateTensorRTProviderOptions.ofAddress(CreateTensorRTProviderOptions$get(segment));
    }

    static final FunctionDescriptor UpdateTensorRTProviderOptions$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle UpdateTensorRTProviderOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.UpdateTensorRTProviderOptions$FUNC,
            false);

    public interface UpdateTensorRTProviderOptions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3);

        static MemoryAddress allocate(UpdateTensorRTProviderOptions fi) {
            return RuntimeHelper.upcallStub(
                    UpdateTensorRTProviderOptions.class,
                    fi,
                    OrtApi.UpdateTensorRTProviderOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(UpdateTensorRTProviderOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    UpdateTensorRTProviderOptions.class,
                    fi,
                    OrtApi.UpdateTensorRTProviderOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static UpdateTensorRTProviderOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.UpdateTensorRTProviderOptions$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UpdateTensorRTProviderOptions$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("UpdateTensorRTProviderOptions")));

    public static VarHandle UpdateTensorRTProviderOptions$VH() {
        return OrtApi.UpdateTensorRTProviderOptions$VH;
    }

    public static MemoryAddress UpdateTensorRTProviderOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UpdateTensorRTProviderOptions$VH.get(seg);
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UpdateTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress UpdateTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.UpdateTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UpdateTensorRTProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UpdateTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UpdateTensorRTProviderOptions UpdateTensorRTProviderOptions(MemorySegment segment) {
        return UpdateTensorRTProviderOptions.ofAddress(UpdateTensorRTProviderOptions$get(segment));
    }

    static final FunctionDescriptor GetTensorRTProviderOptionsAsString$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTensorRTProviderOptionsAsString$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTensorRTProviderOptionsAsString$FUNC,
            false);

    public interface GetTensorRTProviderOptionsAsString {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(GetTensorRTProviderOptionsAsString fi) {
            return RuntimeHelper.upcallStub(
                    GetTensorRTProviderOptionsAsString.class,
                    fi,
                    OrtApi.GetTensorRTProviderOptionsAsString$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTensorRTProviderOptionsAsString fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorRTProviderOptionsAsString.class,
                    fi,
                    OrtApi.GetTensorRTProviderOptionsAsString$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTensorRTProviderOptionsAsString ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTensorRTProviderOptionsAsString$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorRTProviderOptionsAsString$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("GetTensorRTProviderOptionsAsString")));

    public static VarHandle GetTensorRTProviderOptionsAsString$VH() {
        return OrtApi.GetTensorRTProviderOptionsAsString$VH;
    }

    public static MemoryAddress GetTensorRTProviderOptionsAsString$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorRTProviderOptionsAsString$VH.get(seg);
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorRTProviderOptionsAsString$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorRTProviderOptionsAsString$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetTensorRTProviderOptionsAsString$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorRTProviderOptionsAsString$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorRTProviderOptionsAsString$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorRTProviderOptionsAsString GetTensorRTProviderOptionsAsString(MemorySegment segment) {
        return GetTensorRTProviderOptionsAsString.ofAddress(GetTensorRTProviderOptionsAsString$get(segment));
    }

    static final FunctionDescriptor ReleaseTensorRTProviderOptions$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle ReleaseTensorRTProviderOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtApi.ReleaseTensorRTProviderOptions$FUNC, false);

    public interface ReleaseTensorRTProviderOptions {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(ReleaseTensorRTProviderOptions fi) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorRTProviderOptions.class,
                    fi,
                    OrtApi.ReleaseTensorRTProviderOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(ReleaseTensorRTProviderOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    ReleaseTensorRTProviderOptions.class,
                    fi,
                    OrtApi.ReleaseTensorRTProviderOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static ReleaseTensorRTProviderOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtApi.ReleaseTensorRTProviderOptions$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle ReleaseTensorRTProviderOptions$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("ReleaseTensorRTProviderOptions")));

    public static VarHandle ReleaseTensorRTProviderOptions$VH() {
        return OrtApi.ReleaseTensorRTProviderOptions$VH;
    }

    public static MemoryAddress ReleaseTensorRTProviderOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.ReleaseTensorRTProviderOptions$VH.get(seg);
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.ReleaseTensorRTProviderOptions$VH.set(seg, x);
    }

    public static MemoryAddress ReleaseTensorRTProviderOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.ReleaseTensorRTProviderOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void ReleaseTensorRTProviderOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.ReleaseTensorRTProviderOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static ReleaseTensorRTProviderOptions ReleaseTensorRTProviderOptions(MemorySegment segment) {
        return ReleaseTensorRTProviderOptions.ofAddress(ReleaseTensorRTProviderOptions$get(segment));
    }

    static final FunctionDescriptor EnableOrtCustomOps$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle EnableOrtCustomOps$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.EnableOrtCustomOps$FUNC,
            false);

    public interface EnableOrtCustomOps {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(EnableOrtCustomOps fi) {
            return RuntimeHelper.upcallStub(
                    EnableOrtCustomOps.class,
                    fi,
                    OrtApi.EnableOrtCustomOps$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(EnableOrtCustomOps fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    EnableOrtCustomOps.class,
                    fi,
                    OrtApi.EnableOrtCustomOps$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static EnableOrtCustomOps ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.EnableOrtCustomOps$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle EnableOrtCustomOps$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("EnableOrtCustomOps")));

    public static VarHandle EnableOrtCustomOps$VH() {
        return OrtApi.EnableOrtCustomOps$VH;
    }

    public static MemoryAddress EnableOrtCustomOps$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableOrtCustomOps$VH.get(seg);
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.EnableOrtCustomOps$VH.set(seg, x);
    }

    public static MemoryAddress EnableOrtCustomOps$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.EnableOrtCustomOps$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void EnableOrtCustomOps$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.EnableOrtCustomOps$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static EnableOrtCustomOps EnableOrtCustomOps(MemorySegment segment) {
        return EnableOrtCustomOps.ofAddress(EnableOrtCustomOps$get(segment));
    }

    static final FunctionDescriptor RegisterAllocator$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle RegisterAllocator$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.RegisterAllocator$FUNC,
            false);

    public interface RegisterAllocator {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(RegisterAllocator fi) {
            return RuntimeHelper.upcallStub(
                    RegisterAllocator.class,
                    fi,
                    OrtApi.RegisterAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(RegisterAllocator fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    RegisterAllocator.class,
                    fi,
                    OrtApi.RegisterAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static RegisterAllocator ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.RegisterAllocator$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle RegisterAllocator$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("RegisterAllocator")));

    public static VarHandle RegisterAllocator$VH() {
        return OrtApi.RegisterAllocator$VH;
    }

    public static MemoryAddress RegisterAllocator$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RegisterAllocator$VH.get(seg);
    }

    public static void RegisterAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.RegisterAllocator$VH.set(seg, x);
    }

    public static MemoryAddress RegisterAllocator$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.RegisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void RegisterAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.RegisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static RegisterAllocator RegisterAllocator(MemorySegment segment) {
        return RegisterAllocator.ofAddress(RegisterAllocator$get(segment));
    }

    static final FunctionDescriptor UnregisterAllocator$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle UnregisterAllocator$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.UnregisterAllocator$FUNC,
            false);

    public interface UnregisterAllocator {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(UnregisterAllocator fi) {
            return RuntimeHelper.upcallStub(
                    UnregisterAllocator.class,
                    fi,
                    OrtApi.UnregisterAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(UnregisterAllocator fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    UnregisterAllocator.class,
                    fi,
                    OrtApi.UnregisterAllocator$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static UnregisterAllocator ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.UnregisterAllocator$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UnregisterAllocator$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("UnregisterAllocator")));

    public static VarHandle UnregisterAllocator$VH() {
        return OrtApi.UnregisterAllocator$VH;
    }

    public static MemoryAddress UnregisterAllocator$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UnregisterAllocator$VH.get(seg);
    }

    public static void UnregisterAllocator$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UnregisterAllocator$VH.set(seg, x);
    }

    public static MemoryAddress UnregisterAllocator$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UnregisterAllocator$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UnregisterAllocator$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UnregisterAllocator$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UnregisterAllocator UnregisterAllocator(MemorySegment segment) {
        return UnregisterAllocator.ofAddress(UnregisterAllocator$get(segment));
    }

    static final FunctionDescriptor IsSparseTensor$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle IsSparseTensor$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.IsSparseTensor$FUNC,
            false);

    public interface IsSparseTensor {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(IsSparseTensor fi) {
            return RuntimeHelper.upcallStub(
                    IsSparseTensor.class,
                    fi,
                    OrtApi.IsSparseTensor$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(IsSparseTensor fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    IsSparseTensor.class,
                    fi,
                    OrtApi.IsSparseTensor$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static IsSparseTensor ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.IsSparseTensor$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle IsSparseTensor$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("IsSparseTensor")));

    public static VarHandle IsSparseTensor$VH() {
        return OrtApi.IsSparseTensor$VH;
    }

    public static MemoryAddress IsSparseTensor$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.IsSparseTensor$VH.get(seg);
    }

    public static void IsSparseTensor$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.IsSparseTensor$VH.set(seg, x);
    }

    public static MemoryAddress IsSparseTensor$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.IsSparseTensor$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void IsSparseTensor$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.IsSparseTensor$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static IsSparseTensor IsSparseTensor(MemorySegment segment) {
        return IsSparseTensor.ofAddress(IsSparseTensor$get(segment));
    }

    static final FunctionDescriptor CreateSparseTensorAsOrtValue$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_INT, C_POINTER);
    static final MethodHandle CreateSparseTensorAsOrtValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSparseTensorAsOrtValue$FUNC,
            false);

    public interface CreateSparseTensorAsOrtValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                int x3,
                jdk.incubator.foreign.MemoryAddress x4);

        static MemoryAddress allocate(CreateSparseTensorAsOrtValue fi) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorAsOrtValue.class,
                    fi,
                    OrtApi.CreateSparseTensorAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSparseTensorAsOrtValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorAsOrtValue.class,
                    fi,
                    OrtApi.CreateSparseTensorAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSparseTensorAsOrtValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    int x3,
                    jdk.incubator.foreign.MemoryAddress x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSparseTensorAsOrtValue$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSparseTensorAsOrtValue$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("CreateSparseTensorAsOrtValue")));

    public static VarHandle CreateSparseTensorAsOrtValue$VH() {
        return OrtApi.CreateSparseTensorAsOrtValue$VH;
    }

    public static MemoryAddress CreateSparseTensorAsOrtValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSparseTensorAsOrtValue$VH.get(seg);
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSparseTensorAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateSparseTensorAsOrtValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateSparseTensorAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSparseTensorAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSparseTensorAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSparseTensorAsOrtValue CreateSparseTensorAsOrtValue(MemorySegment segment) {
        return CreateSparseTensorAsOrtValue.ofAddress(CreateSparseTensorAsOrtValue$get(segment));
    }

    static final FunctionDescriptor FillSparseTensorCoo$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle FillSparseTensorCoo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.FillSparseTensorCoo$FUNC,
            false);

    public interface FillSparseTensorCoo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3,
                jdk.incubator.foreign.MemoryAddress x4,
                jdk.incubator.foreign.MemoryAddress x5,
                long x6);

        static MemoryAddress allocate(FillSparseTensorCoo fi) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorCoo.class,
                    fi,
                    OrtApi.FillSparseTensorCoo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(FillSparseTensorCoo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorCoo.class,
                    fi,
                    OrtApi.FillSparseTensorCoo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static FillSparseTensorCoo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3,
                    jdk.incubator.foreign.MemoryAddress x4,
                    jdk.incubator.foreign.MemoryAddress x5,
                    long x6) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.FillSparseTensorCoo$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4, x5, x6);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillSparseTensorCoo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("FillSparseTensorCoo")));

    public static VarHandle FillSparseTensorCoo$VH() {
        return OrtApi.FillSparseTensorCoo$VH;
    }

    public static MemoryAddress FillSparseTensorCoo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorCoo$VH.get(seg);
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillSparseTensorCoo$VH.set(seg, x);
    }

    public static MemoryAddress FillSparseTensorCoo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorCoo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorCoo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillSparseTensorCoo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorCoo FillSparseTensorCoo(MemorySegment segment) {
        return FillSparseTensorCoo.ofAddress(FillSparseTensorCoo$get(segment));
    }

    static final FunctionDescriptor FillSparseTensorCsr$FUNC = FunctionDescriptor.of(
            C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG);
    static final MethodHandle FillSparseTensorCsr$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.FillSparseTensorCsr$FUNC,
            false);

    public interface FillSparseTensorCsr {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3,
                jdk.incubator.foreign.MemoryAddress x4,
                jdk.incubator.foreign.MemoryAddress x5,
                long x6,
                jdk.incubator.foreign.MemoryAddress x7,
                long x8);

        static MemoryAddress allocate(FillSparseTensorCsr fi) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorCsr.class,
                    fi,
                    OrtApi.FillSparseTensorCsr$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(FillSparseTensorCsr fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorCsr.class,
                    fi,
                    OrtApi.FillSparseTensorCsr$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static FillSparseTensorCsr ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3,
                    jdk.incubator.foreign.MemoryAddress x4,
                    jdk.incubator.foreign.MemoryAddress x5,
                    long x6,
                    jdk.incubator.foreign.MemoryAddress x7,
                    long x8) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorCsr$MH.invokeExact(
                            (Addressable) addr, x0, x1, x2, x3, x4, x5, x6, x7, x8);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillSparseTensorCsr$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("FillSparseTensorCsr")));

    public static VarHandle FillSparseTensorCsr$VH() {
        return OrtApi.FillSparseTensorCsr$VH;
    }

    public static MemoryAddress FillSparseTensorCsr$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorCsr$VH.get(seg);
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillSparseTensorCsr$VH.set(seg, x);
    }

    public static MemoryAddress FillSparseTensorCsr$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorCsr$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorCsr$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillSparseTensorCsr$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorCsr FillSparseTensorCsr(MemorySegment segment) {
        return FillSparseTensorCsr.ofAddress(FillSparseTensorCsr$get(segment));
    }

    static final FunctionDescriptor FillSparseTensorBlockSparse$FUNC = FunctionDescriptor.of(
            C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle FillSparseTensorBlockSparse$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.FillSparseTensorBlockSparse$FUNC,
            false);

    public interface FillSparseTensorBlockSparse {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3,
                jdk.incubator.foreign.MemoryAddress x4,
                jdk.incubator.foreign.MemoryAddress x5,
                long x6,
                jdk.incubator.foreign.MemoryAddress x7);

        static MemoryAddress allocate(FillSparseTensorBlockSparse fi) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorBlockSparse.class,
                    fi,
                    OrtApi.FillSparseTensorBlockSparse$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(FillSparseTensorBlockSparse fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    FillSparseTensorBlockSparse.class,
                    fi,
                    OrtApi.FillSparseTensorBlockSparse$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static FillSparseTensorBlockSparse ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3,
                    jdk.incubator.foreign.MemoryAddress x4,
                    jdk.incubator.foreign.MemoryAddress x5,
                    long x6,
                    jdk.incubator.foreign.MemoryAddress x7) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorBlockSparse$MH.invokeExact(
                            (Addressable) addr, x0, x1, x2, x3, x4, x5, x6, x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle FillSparseTensorBlockSparse$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("FillSparseTensorBlockSparse")));

    public static VarHandle FillSparseTensorBlockSparse$VH() {
        return OrtApi.FillSparseTensorBlockSparse$VH;
    }

    public static MemoryAddress FillSparseTensorBlockSparse$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.FillSparseTensorBlockSparse$VH.get(seg);
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.FillSparseTensorBlockSparse$VH.set(seg, x);
    }

    public static MemoryAddress FillSparseTensorBlockSparse$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.FillSparseTensorBlockSparse$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void FillSparseTensorBlockSparse$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.FillSparseTensorBlockSparse$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static FillSparseTensorBlockSparse FillSparseTensorBlockSparse(MemorySegment segment) {
        return FillSparseTensorBlockSparse.ofAddress(FillSparseTensorBlockSparse$get(segment));
    }

    static final FunctionDescriptor CreateSparseTensorWithValuesAsOrtValue$FUNC = FunctionDescriptor.of(
            C_POINTER, C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG, C_INT, C_POINTER);
    static final MethodHandle CreateSparseTensorWithValuesAsOrtValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.CreateSparseTensorWithValuesAsOrtValue$FUNC,
            false);

    public interface CreateSparseTensorWithValuesAsOrtValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2,
                long x3,
                jdk.incubator.foreign.MemoryAddress x4,
                long x5,
                int x6,
                jdk.incubator.foreign.MemoryAddress x7);

        static MemoryAddress allocate(CreateSparseTensorWithValuesAsOrtValue fi) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorWithValuesAsOrtValue.class,
                    fi,
                    OrtApi.CreateSparseTensorWithValuesAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateSparseTensorWithValuesAsOrtValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateSparseTensorWithValuesAsOrtValue.class,
                    fi,
                    OrtApi.CreateSparseTensorWithValuesAsOrtValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;JILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateSparseTensorWithValuesAsOrtValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    long x3,
                    jdk.incubator.foreign.MemoryAddress x4,
                    long x5,
                    int x6,
                    jdk.incubator.foreign.MemoryAddress x7) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.CreateSparseTensorWithValuesAsOrtValue$MH.invokeExact(
                                    (Addressable) addr, x0, x1, x2, x3, x4, x5, x6, x7);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateSparseTensorWithValuesAsOrtValue$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("CreateSparseTensorWithValuesAsOrtValue")));

    public static VarHandle CreateSparseTensorWithValuesAsOrtValue$VH() {
        return OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH;
    }

    public static MemoryAddress CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.get(seg);
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.set(seg, x);
    }

    public static MemoryAddress CreateSparseTensorWithValuesAsOrtValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateSparseTensorWithValuesAsOrtValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.CreateSparseTensorWithValuesAsOrtValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateSparseTensorWithValuesAsOrtValue CreateSparseTensorWithValuesAsOrtValue(MemorySegment segment) {
        return CreateSparseTensorWithValuesAsOrtValue.ofAddress(CreateSparseTensorWithValuesAsOrtValue$get(segment));
    }

    static final FunctionDescriptor UseCooIndices$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG);
    static final MethodHandle UseCooIndices$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.UseCooIndices$FUNC,
            false);

    public interface UseCooIndices {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2);

        static MemoryAddress allocate(UseCooIndices fi) {
            return RuntimeHelper.upcallStub(
                    UseCooIndices.class,
                    fi,
                    OrtApi.UseCooIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(UseCooIndices fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    UseCooIndices.class,
                    fi,
                    OrtApi.UseCooIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static UseCooIndices ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, long x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.UseCooIndices$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UseCooIndices$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("UseCooIndices")));

    public static VarHandle UseCooIndices$VH() {
        return OrtApi.UseCooIndices$VH;
    }

    public static MemoryAddress UseCooIndices$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UseCooIndices$VH.get(seg);
    }

    public static void UseCooIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UseCooIndices$VH.set(seg, x);
    }

    public static MemoryAddress UseCooIndices$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UseCooIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseCooIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UseCooIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseCooIndices UseCooIndices(MemorySegment segment) {
        return UseCooIndices.ofAddress(UseCooIndices$get(segment));
    }

    static final FunctionDescriptor UseCsrIndices$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER, C_LONG);
    static final MethodHandle UseCsrIndices$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.UseCsrIndices$FUNC,
            false);

    public interface UseCsrIndices {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3,
                long x4);

        static MemoryAddress allocate(UseCsrIndices fi) {
            return RuntimeHelper.upcallStub(
                    UseCsrIndices.class,
                    fi,
                    OrtApi.UseCsrIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(UseCsrIndices fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    UseCsrIndices.class,
                    fi,
                    OrtApi.UseCsrIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;J)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static UseCsrIndices ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3,
                    long x4) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.UseCsrIndices$MH.invokeExact((Addressable) addr, x0, x1, x2, x3, x4);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UseCsrIndices$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("UseCsrIndices")));

    public static VarHandle UseCsrIndices$VH() {
        return OrtApi.UseCsrIndices$VH;
    }

    public static MemoryAddress UseCsrIndices$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UseCsrIndices$VH.get(seg);
    }

    public static void UseCsrIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UseCsrIndices$VH.set(seg, x);
    }

    public static MemoryAddress UseCsrIndices$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UseCsrIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseCsrIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UseCsrIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseCsrIndices UseCsrIndices(MemorySegment segment) {
        return UseCsrIndices.ofAddress(UseCsrIndices$get(segment));
    }

    static final FunctionDescriptor UseBlockSparseIndices$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_LONG, C_POINTER);
    static final MethodHandle UseBlockSparseIndices$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.UseBlockSparseIndices$FUNC,
            false);

    public interface UseBlockSparseIndices {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                long x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(UseBlockSparseIndices fi) {
            return RuntimeHelper.upcallStub(
                    UseBlockSparseIndices.class,
                    fi,
                    OrtApi.UseBlockSparseIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(UseBlockSparseIndices fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    UseBlockSparseIndices.class,
                    fi,
                    OrtApi.UseBlockSparseIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;JLjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static UseBlockSparseIndices ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    long x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.UseBlockSparseIndices$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle UseBlockSparseIndices$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("UseBlockSparseIndices")));

    public static VarHandle UseBlockSparseIndices$VH() {
        return OrtApi.UseBlockSparseIndices$VH;
    }

    public static MemoryAddress UseBlockSparseIndices$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UseBlockSparseIndices$VH.get(seg);
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.UseBlockSparseIndices$VH.set(seg, x);
    }

    public static MemoryAddress UseBlockSparseIndices$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.UseBlockSparseIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void UseBlockSparseIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.UseBlockSparseIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static UseBlockSparseIndices UseBlockSparseIndices(MemorySegment segment) {
        return UseBlockSparseIndices.ofAddress(UseBlockSparseIndices$get(segment));
    }

    static final FunctionDescriptor GetSparseTensorFormat$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetSparseTensorFormat$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSparseTensorFormat$FUNC,
            false);

    public interface GetSparseTensorFormat {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetSparseTensorFormat fi) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorFormat.class,
                    fi,
                    OrtApi.GetSparseTensorFormat$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSparseTensorFormat fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorFormat.class,
                    fi,
                    OrtApi.GetSparseTensorFormat$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSparseTensorFormat ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSparseTensorFormat$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorFormat$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetSparseTensorFormat")));

    public static VarHandle GetSparseTensorFormat$VH() {
        return OrtApi.GetSparseTensorFormat$VH;
    }

    public static MemoryAddress GetSparseTensorFormat$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorFormat$VH.get(seg);
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorFormat$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorFormat$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorFormat$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorFormat$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorFormat$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorFormat GetSparseTensorFormat(MemorySegment segment) {
        return GetSparseTensorFormat.ofAddress(GetSparseTensorFormat$get(segment));
    }

    static final FunctionDescriptor GetSparseTensorValuesTypeAndShape$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetSparseTensorValuesTypeAndShape$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSparseTensorValuesTypeAndShape$FUNC,
            false);

    public interface GetSparseTensorValuesTypeAndShape {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetSparseTensorValuesTypeAndShape fi) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValuesTypeAndShape.class,
                    fi,
                    OrtApi.GetSparseTensorValuesTypeAndShape$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSparseTensorValuesTypeAndShape fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValuesTypeAndShape.class,
                    fi,
                    OrtApi.GetSparseTensorValuesTypeAndShape$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSparseTensorValuesTypeAndShape ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSparseTensorValuesTypeAndShape$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorValuesTypeAndShape$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("GetSparseTensorValuesTypeAndShape")));

    public static VarHandle GetSparseTensorValuesTypeAndShape$VH() {
        return OrtApi.GetSparseTensorValuesTypeAndShape$VH;
    }

    public static MemoryAddress GetSparseTensorValuesTypeAndShape$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorValuesTypeAndShape$VH.get(seg);
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorValuesTypeAndShape$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorValuesTypeAndShape$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetSparseTensorValuesTypeAndShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorValuesTypeAndShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorValuesTypeAndShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorValuesTypeAndShape GetSparseTensorValuesTypeAndShape(MemorySegment segment) {
        return GetSparseTensorValuesTypeAndShape.ofAddress(GetSparseTensorValuesTypeAndShape$get(segment));
    }

    static final FunctionDescriptor GetSparseTensorValues$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetSparseTensorValues$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSparseTensorValues$FUNC,
            false);

    public interface GetSparseTensorValues {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetSparseTensorValues fi) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValues.class,
                    fi,
                    OrtApi.GetSparseTensorValues$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSparseTensorValues fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorValues.class,
                    fi,
                    OrtApi.GetSparseTensorValues$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSparseTensorValues ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSparseTensorValues$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorValues$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetSparseTensorValues")));

    public static VarHandle GetSparseTensorValues$VH() {
        return OrtApi.GetSparseTensorValues$VH;
    }

    public static MemoryAddress GetSparseTensorValues$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorValues$VH.get(seg);
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorValues$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorValues$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorValues$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorValues$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorValues$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorValues GetSparseTensorValues(MemorySegment segment) {
        return GetSparseTensorValues.ofAddress(GetSparseTensorValues$get(segment));
    }

    static final FunctionDescriptor GetSparseTensorIndicesTypeShape$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT, C_POINTER);
    static final MethodHandle GetSparseTensorIndicesTypeShape$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSparseTensorIndicesTypeShape$FUNC,
            false);

    public interface GetSparseTensorIndicesTypeShape {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(GetSparseTensorIndicesTypeShape fi) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndicesTypeShape.class,
                    fi,
                    OrtApi.GetSparseTensorIndicesTypeShape$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSparseTensorIndicesTypeShape fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndicesTypeShape.class,
                    fi,
                    OrtApi.GetSparseTensorIndicesTypeShape$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSparseTensorIndicesTypeShape ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSparseTensorIndicesTypeShape$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorIndicesTypeShape$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("GetSparseTensorIndicesTypeShape")));

    public static VarHandle GetSparseTensorIndicesTypeShape$VH() {
        return OrtApi.GetSparseTensorIndicesTypeShape$VH;
    }

    public static MemoryAddress GetSparseTensorIndicesTypeShape$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorIndicesTypeShape$VH.get(seg);
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorIndicesTypeShape$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorIndicesTypeShape$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetSparseTensorIndicesTypeShape$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorIndicesTypeShape$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorIndicesTypeShape$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorIndicesTypeShape GetSparseTensorIndicesTypeShape(MemorySegment segment) {
        return GetSparseTensorIndicesTypeShape.ofAddress(GetSparseTensorIndicesTypeShape$get(segment));
    }

    static final FunctionDescriptor GetSparseTensorIndices$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT, C_POINTER, C_POINTER);
    static final MethodHandle GetSparseTensorIndices$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetSparseTensorIndices$FUNC,
            false);

    public interface GetSparseTensorIndices {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                int x1,
                jdk.incubator.foreign.MemoryAddress x2,
                jdk.incubator.foreign.MemoryAddress x3);

        static MemoryAddress allocate(GetSparseTensorIndices fi) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndices.class,
                    fi,
                    OrtApi.GetSparseTensorIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetSparseTensorIndices fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetSparseTensorIndices.class,
                    fi,
                    OrtApi.GetSparseTensorIndices$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetSparseTensorIndices ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    int x1,
                    jdk.incubator.foreign.MemoryAddress x2,
                    jdk.incubator.foreign.MemoryAddress x3) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetSparseTensorIndices$MH.invokeExact((Addressable) addr, x0, x1, x2, x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetSparseTensorIndices$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetSparseTensorIndices")));

    public static VarHandle GetSparseTensorIndices$VH() {
        return OrtApi.GetSparseTensorIndices$VH;
    }

    public static MemoryAddress GetSparseTensorIndices$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetSparseTensorIndices$VH.get(seg);
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetSparseTensorIndices$VH.set(seg, x);
    }

    public static MemoryAddress GetSparseTensorIndices$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetSparseTensorIndices$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetSparseTensorIndices$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetSparseTensorIndices$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetSparseTensorIndices GetSparseTensorIndices(MemorySegment segment) {
        return GetSparseTensorIndices.ofAddress(GetSparseTensorIndices$get(segment));
    }

    static final FunctionDescriptor HasValue$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle HasValue$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.HasValue$FUNC,
            false);

    public interface HasValue {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(HasValue fi) {
            return RuntimeHelper.upcallStub(
                    HasValue.class,
                    fi,
                    OrtApi.HasValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(HasValue fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    HasValue.class,
                    fi,
                    OrtApi.HasValue$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static HasValue ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.HasValue$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle HasValue$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("HasValue")));

    public static VarHandle HasValue$VH() {
        return OrtApi.HasValue$VH;
    }

    public static MemoryAddress HasValue$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.HasValue$VH.get(seg);
    }

    public static void HasValue$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.HasValue$VH.set(seg, x);
    }

    public static MemoryAddress HasValue$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.HasValue$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void HasValue$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.HasValue$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static HasValue HasValue(MemorySegment segment) {
        return HasValue.ofAddress(HasValue$get(segment));
    }

    static final FunctionDescriptor KernelContext_GetGPUComputeStream$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle KernelContext_GetGPUComputeStream$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.KernelContext_GetGPUComputeStream$FUNC,
            false);

    public interface KernelContext_GetGPUComputeStream {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(KernelContext_GetGPUComputeStream fi) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetGPUComputeStream.class,
                    fi,
                    OrtApi.KernelContext_GetGPUComputeStream$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(KernelContext_GetGPUComputeStream fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelContext_GetGPUComputeStream.class,
                    fi,
                    OrtApi.KernelContext_GetGPUComputeStream$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static KernelContext_GetGPUComputeStream ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.KernelContext_GetGPUComputeStream$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelContext_GetGPUComputeStream$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("KernelContext_GetGPUComputeStream")));

    public static VarHandle KernelContext_GetGPUComputeStream$VH() {
        return OrtApi.KernelContext_GetGPUComputeStream$VH;
    }

    public static MemoryAddress KernelContext_GetGPUComputeStream$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.KernelContext_GetGPUComputeStream$VH.get(seg);
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.KernelContext_GetGPUComputeStream$VH.set(seg, x);
    }

    public static MemoryAddress KernelContext_GetGPUComputeStream$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.KernelContext_GetGPUComputeStream$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelContext_GetGPUComputeStream$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.KernelContext_GetGPUComputeStream$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelContext_GetGPUComputeStream KernelContext_GetGPUComputeStream(MemorySegment segment) {
        return KernelContext_GetGPUComputeStream.ofAddress(KernelContext_GetGPUComputeStream$get(segment));
    }

    static final FunctionDescriptor GetTensorMemoryInfo$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle GetTensorMemoryInfo$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetTensorMemoryInfo$FUNC,
            false);

    public interface GetTensorMemoryInfo {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(GetTensorMemoryInfo fi) {
            return RuntimeHelper.upcallStub(
                    GetTensorMemoryInfo.class,
                    fi,
                    OrtApi.GetTensorMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetTensorMemoryInfo fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetTensorMemoryInfo.class,
                    fi,
                    OrtApi.GetTensorMemoryInfo$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetTensorMemoryInfo ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetTensorMemoryInfo$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetTensorMemoryInfo$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetTensorMemoryInfo")));

    public static VarHandle GetTensorMemoryInfo$VH() {
        return OrtApi.GetTensorMemoryInfo$VH;
    }

    public static MemoryAddress GetTensorMemoryInfo$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorMemoryInfo$VH.get(seg);
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetTensorMemoryInfo$VH.set(seg, x);
    }

    public static MemoryAddress GetTensorMemoryInfo$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetTensorMemoryInfo$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetTensorMemoryInfo$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetTensorMemoryInfo$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetTensorMemoryInfo GetTensorMemoryInfo(MemorySegment segment) {
        return GetTensorMemoryInfo.ofAddress(GetTensorMemoryInfo$get(segment));
    }

    static final FunctionDescriptor GetExecutionProviderApi$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_INT, C_POINTER);
    static final MethodHandle GetExecutionProviderApi$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.GetExecutionProviderApi$FUNC,
            false);

    public interface GetExecutionProviderApi {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(GetExecutionProviderApi fi) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderApi.class,
                    fi,
                    OrtApi.GetExecutionProviderApi$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetExecutionProviderApi fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderApi.class,
                    fi,
                    OrtApi.GetExecutionProviderApi$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetExecutionProviderApi ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.GetExecutionProviderApi$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetExecutionProviderApi$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetExecutionProviderApi")));

    public static VarHandle GetExecutionProviderApi$VH() {
        return OrtApi.GetExecutionProviderApi$VH;
    }

    public static MemoryAddress GetExecutionProviderApi$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.GetExecutionProviderApi$VH.get(seg);
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.GetExecutionProviderApi$VH.set(seg, x);
    }

    public static MemoryAddress GetExecutionProviderApi$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.GetExecutionProviderApi$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetExecutionProviderApi$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.GetExecutionProviderApi$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetExecutionProviderApi GetExecutionProviderApi(MemorySegment segment) {
        return GetExecutionProviderApi.ofAddress(GetExecutionProviderApi$get(segment));
    }

    static final FunctionDescriptor SessionOptionsSetCustomCreateThreadFn$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsSetCustomCreateThreadFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC,
            false);

    public interface SessionOptionsSetCustomCreateThreadFn {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsSetCustomCreateThreadFn fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomCreateThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsSetCustomCreateThreadFn fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomCreateThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomCreateThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsSetCustomCreateThreadFn ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsSetCustomCreateThreadFn$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsSetCustomCreateThreadFn$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomCreateThreadFn")));

    public static VarHandle SessionOptionsSetCustomCreateThreadFn$VH() {
        return OrtApi.SessionOptionsSetCustomCreateThreadFn$VH;
    }

    public static MemoryAddress SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.get(seg);
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsSetCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomCreateThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomCreateThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomCreateThreadFn SessionOptionsSetCustomCreateThreadFn(MemorySegment segment) {
        return SessionOptionsSetCustomCreateThreadFn.ofAddress(SessionOptionsSetCustomCreateThreadFn$get(segment));
    }

    static final FunctionDescriptor SessionOptionsSetCustomThreadCreationOptions$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsSetCustomThreadCreationOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC,
            false);

    public interface SessionOptionsSetCustomThreadCreationOptions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsSetCustomThreadCreationOptions fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsSetCustomThreadCreationOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomThreadCreationOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsSetCustomThreadCreationOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsSetCustomThreadCreationOptions$MH.invokeExact(
                                    (Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsSetCustomThreadCreationOptions$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomThreadCreationOptions")));

    public static VarHandle SessionOptionsSetCustomThreadCreationOptions$VH() {
        return OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH;
    }

    public static MemoryAddress SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.get(seg);
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsSetCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomThreadCreationOptions$set(
            MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomThreadCreationOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomThreadCreationOptions SessionOptionsSetCustomThreadCreationOptions(
            MemorySegment segment) {
        return SessionOptionsSetCustomThreadCreationOptions.ofAddress(
                SessionOptionsSetCustomThreadCreationOptions$get(segment));
    }

    static final FunctionDescriptor SessionOptionsSetCustomJoinThreadFn$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SessionOptionsSetCustomJoinThreadFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC,
            false);

    public interface SessionOptionsSetCustomJoinThreadFn {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SessionOptionsSetCustomJoinThreadFn fi) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomJoinThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SessionOptionsSetCustomJoinThreadFn fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SessionOptionsSetCustomJoinThreadFn.class,
                    fi,
                    OrtApi.SessionOptionsSetCustomJoinThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SessionOptionsSetCustomJoinThreadFn ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SessionOptionsSetCustomJoinThreadFn$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SessionOptionsSetCustomJoinThreadFn$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomJoinThreadFn")));

    public static VarHandle SessionOptionsSetCustomJoinThreadFn$VH() {
        return OrtApi.SessionOptionsSetCustomJoinThreadFn$VH;
    }

    public static MemoryAddress SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.get(seg);
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SessionOptionsSetCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SessionOptionsSetCustomJoinThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SessionOptionsSetCustomJoinThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SessionOptionsSetCustomJoinThreadFn SessionOptionsSetCustomJoinThreadFn(MemorySegment segment) {
        return SessionOptionsSetCustomJoinThreadFn.ofAddress(SessionOptionsSetCustomJoinThreadFn$get(segment));
    }

    static final FunctionDescriptor SetGlobalCustomCreateThreadFn$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SetGlobalCustomCreateThreadFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalCustomCreateThreadFn$FUNC,
            false);

    public interface SetGlobalCustomCreateThreadFn {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SetGlobalCustomCreateThreadFn fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomCreateThreadFn.class,
                    fi,
                    OrtApi.SetGlobalCustomCreateThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalCustomCreateThreadFn fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomCreateThreadFn.class,
                    fi,
                    OrtApi.SetGlobalCustomCreateThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalCustomCreateThreadFn ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalCustomCreateThreadFn$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalCustomCreateThreadFn$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
            long.class, MemoryLayout.PathElement.groupElement("SetGlobalCustomCreateThreadFn")));

    public static VarHandle SetGlobalCustomCreateThreadFn$VH() {
        return OrtApi.SetGlobalCustomCreateThreadFn$VH;
    }

    public static MemoryAddress SetGlobalCustomCreateThreadFn$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalCustomCreateThreadFn$VH.get(seg);
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalCustomCreateThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalCustomCreateThreadFn$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetGlobalCustomCreateThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomCreateThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalCustomCreateThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomCreateThreadFn SetGlobalCustomCreateThreadFn(MemorySegment segment) {
        return SetGlobalCustomCreateThreadFn.ofAddress(SetGlobalCustomCreateThreadFn$get(segment));
    }

    static final FunctionDescriptor SetGlobalCustomThreadCreationOptions$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SetGlobalCustomThreadCreationOptions$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalCustomThreadCreationOptions$FUNC,
            false);

    public interface SetGlobalCustomThreadCreationOptions {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SetGlobalCustomThreadCreationOptions fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SetGlobalCustomThreadCreationOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalCustomThreadCreationOptions fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomThreadCreationOptions.class,
                    fi,
                    OrtApi.SetGlobalCustomThreadCreationOptions$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalCustomThreadCreationOptions ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalCustomThreadCreationOptions$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalCustomThreadCreationOptions$VH =
            MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(
                    long.class, MemoryLayout.PathElement.groupElement("SetGlobalCustomThreadCreationOptions")));

    public static VarHandle SetGlobalCustomThreadCreationOptions$VH() {
        return OrtApi.SetGlobalCustomThreadCreationOptions$VH;
    }

    public static MemoryAddress SetGlobalCustomThreadCreationOptions$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalCustomThreadCreationOptions$VH.get(seg);
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalCustomThreadCreationOptions$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalCustomThreadCreationOptions$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetGlobalCustomThreadCreationOptions$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomThreadCreationOptions$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalCustomThreadCreationOptions$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomThreadCreationOptions SetGlobalCustomThreadCreationOptions(MemorySegment segment) {
        return SetGlobalCustomThreadCreationOptions.ofAddress(SetGlobalCustomThreadCreationOptions$get(segment));
    }

    static final FunctionDescriptor SetGlobalCustomJoinThreadFn$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle SetGlobalCustomJoinThreadFn$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SetGlobalCustomJoinThreadFn$FUNC,
            false);

    public interface SetGlobalCustomJoinThreadFn {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(SetGlobalCustomJoinThreadFn fi) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomJoinThreadFn.class,
                    fi,
                    OrtApi.SetGlobalCustomJoinThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SetGlobalCustomJoinThreadFn fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SetGlobalCustomJoinThreadFn.class,
                    fi,
                    OrtApi.SetGlobalCustomJoinThreadFn$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SetGlobalCustomJoinThreadFn ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SetGlobalCustomJoinThreadFn$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SetGlobalCustomJoinThreadFn$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SetGlobalCustomJoinThreadFn")));

    public static VarHandle SetGlobalCustomJoinThreadFn$VH() {
        return OrtApi.SetGlobalCustomJoinThreadFn$VH;
    }

    public static MemoryAddress SetGlobalCustomJoinThreadFn$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SetGlobalCustomJoinThreadFn$VH.get(seg);
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SetGlobalCustomJoinThreadFn$VH.set(seg, x);
    }

    public static MemoryAddress SetGlobalCustomJoinThreadFn$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SetGlobalCustomJoinThreadFn$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SetGlobalCustomJoinThreadFn$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SetGlobalCustomJoinThreadFn$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SetGlobalCustomJoinThreadFn SetGlobalCustomJoinThreadFn(MemorySegment segment) {
        return SetGlobalCustomJoinThreadFn.ofAddress(SetGlobalCustomJoinThreadFn$get(segment));
    }

    static final FunctionDescriptor SynchronizeBoundInputs$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle SynchronizeBoundInputs$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SynchronizeBoundInputs$FUNC,
            false);

    public interface SynchronizeBoundInputs {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(SynchronizeBoundInputs fi) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundInputs.class,
                    fi,
                    OrtApi.SynchronizeBoundInputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SynchronizeBoundInputs fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundInputs.class,
                    fi,
                    OrtApi.SynchronizeBoundInputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SynchronizeBoundInputs ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SynchronizeBoundInputs$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SynchronizeBoundInputs$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SynchronizeBoundInputs")));

    public static VarHandle SynchronizeBoundInputs$VH() {
        return OrtApi.SynchronizeBoundInputs$VH;
    }

    public static MemoryAddress SynchronizeBoundInputs$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SynchronizeBoundInputs$VH.get(seg);
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SynchronizeBoundInputs$VH.set(seg, x);
    }

    public static MemoryAddress SynchronizeBoundInputs$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SynchronizeBoundInputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SynchronizeBoundInputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SynchronizeBoundInputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SynchronizeBoundInputs SynchronizeBoundInputs(MemorySegment segment) {
        return SynchronizeBoundInputs.ofAddress(SynchronizeBoundInputs$get(segment));
    }

    static final FunctionDescriptor SynchronizeBoundOutputs$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle SynchronizeBoundOutputs$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtApi.SynchronizeBoundOutputs$FUNC,
            false);

    public interface SynchronizeBoundOutputs {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(SynchronizeBoundOutputs fi) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundOutputs.class,
                    fi,
                    OrtApi.SynchronizeBoundOutputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(SynchronizeBoundOutputs fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    SynchronizeBoundOutputs.class,
                    fi,
                    OrtApi.SynchronizeBoundOutputs$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static SynchronizeBoundOutputs ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtApi.SynchronizeBoundOutputs$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle SynchronizeBoundOutputs$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("SynchronizeBoundOutputs")));

    public static VarHandle SynchronizeBoundOutputs$VH() {
        return OrtApi.SynchronizeBoundOutputs$VH;
    }

    public static MemoryAddress SynchronizeBoundOutputs$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtApi.SynchronizeBoundOutputs$VH.get(seg);
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, MemoryAddress x) {
        OrtApi.SynchronizeBoundOutputs$VH.set(seg, x);
    }

    public static MemoryAddress SynchronizeBoundOutputs$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtApi.SynchronizeBoundOutputs$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void SynchronizeBoundOutputs$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtApi.SynchronizeBoundOutputs$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static SynchronizeBoundOutputs SynchronizeBoundOutputs(MemorySegment segment) {
        return SynchronizeBoundOutputs.ofAddress(SynchronizeBoundOutputs$get(segment));
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocate(ResourceScope scope) {
        return allocate(SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
