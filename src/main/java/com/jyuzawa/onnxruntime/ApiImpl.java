/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_INT;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toJavaString;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApi.AllocatorFree;
import com.jyuzawa.onnxruntime_extern.OrtApi.CastTypeInfoToMapTypeInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.CastTypeInfoToSequenceTypeInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.CastTypeInfoToTensorInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateCpuMemoryInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateEnvWithCustomLogger;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateSessionFromArray;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateSessionOptions;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateTensorAsOrtValue;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateTensorWithDataAsOrtValue;
import com.jyuzawa.onnxruntime_extern.OrtApi.CreateValue;
import com.jyuzawa.onnxruntime_extern.OrtApi.DisableTelemetryEvents;
import com.jyuzawa.onnxruntime_extern.OrtApi.EnableTelemetryEvents;
import com.jyuzawa.onnxruntime_extern.OrtApi.FillStringTensor;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetAllocatorWithDefaultOptions;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetDimensions;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetDimensionsCount;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetErrorCode;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetErrorMessage;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetMapKeyType;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetMapValueType;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetOnnxTypeFromTypeInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetSequenceElementType;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetStringTensorElement;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetStringTensorElementLength;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetTensorElementType;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetTensorMutableData;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetTensorShapeElementCount;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetTensorTypeAndShape;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetValue;
import com.jyuzawa.onnxruntime_extern.OrtApi.GetValueCount;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetCustomMetadataMapKeys;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetDescription;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetDomain;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetGraphDescription;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetGraphName;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetProducerName;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataGetVersion;
import com.jyuzawa.onnxruntime_extern.OrtApi.ModelMetadataLookupCustomMetadataMap;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseEnv;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseMemoryInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseModelMetadata;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseSession;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseSessionOptions;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseStatus;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseTypeInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.ReleaseValue;
import com.jyuzawa.onnxruntime_extern.OrtApi.Run;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetInputCount;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetInputName;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetInputTypeInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetModelMetadata;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetOutputCount;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetOutputName;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetOutputTypeInfo;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetOverridableInitializerCount;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetOverridableInitializerName;
import com.jyuzawa.onnxruntime_extern.OrtApi.SessionGetOverridableInitializerTypeInfo;
import java.util.function.Function;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SegmentAllocator;

final class ApiImpl implements Api {

    final AllocatorFree AllocatorFree;
    final CastTypeInfoToMapTypeInfo CastTypeInfoToMapTypeInfo;
    final CastTypeInfoToSequenceTypeInfo CastTypeInfoToSequenceTypeInfo;
    final CastTypeInfoToTensorInfo CastTypeInfoToTensorInfo;
    final CreateCpuMemoryInfo CreateCpuMemoryInfo;
    final CreateEnvWithCustomLogger CreateEnvWithCustomLogger;
    final CreateSessionFromArray CreateSessionFromArray;
    final CreateSessionOptions CreateSessionOptions;
    final CreateTensorAsOrtValue CreateTensorAsOrtValue;
    final CreateTensorWithDataAsOrtValue CreateTensorWithDataAsOrtValue;
    final CreateValue CreateValue;
    final DisableTelemetryEvents DisableTelemetryEvents;
    final EnableTelemetryEvents EnableTelemetryEvents;
    final FillStringTensor FillStringTensor;
    final GetAllocatorWithDefaultOptions GetAllocatorWithDefaultOptions;
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
    final ReleaseEnv ReleaseEnv;
    final ReleaseMemoryInfo ReleaseMemoryInfo;
    final ReleaseModelMetadata ReleaseModelMetadata;
    final ReleaseSession ReleaseSession;
    final ReleaseSessionOptions ReleaseSessionOptions;
    final ReleaseStatus ReleaseStatus;
    final ReleaseTypeInfo ReleaseTypeInfo;
    final ReleaseValue ReleaseValue;
    final Run Run;
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

    ApiImpl(MemorySegment segment) {
        this.AllocatorFree = OrtApi.AllocatorFree(segment);
        this.CastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfo(segment);
        this.CastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfo(segment);
        this.CastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfo(segment);
        this.CreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfo(segment);
        this.CreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLogger(segment);
        this.CreateSessionFromArray = OrtApi.CreateSessionFromArray(segment);
        this.CreateSessionOptions = OrtApi.CreateSessionOptions(segment);
        this.CreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValue(segment);
        this.CreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValue(segment);
        this.CreateValue = OrtApi.CreateValue(segment);
        this.DisableTelemetryEvents = OrtApi.DisableTelemetryEvents(segment);
        this.EnableTelemetryEvents = OrtApi.EnableTelemetryEvents(segment);
        this.FillStringTensor = OrtApi.FillStringTensor(segment);
        this.GetAllocatorWithDefaultOptions = OrtApi.GetAllocatorWithDefaultOptions(segment);
        this.GetDimensions = OrtApi.GetDimensions(segment);
        this.GetDimensionsCount = OrtApi.GetDimensionsCount(segment);
        this.GetErrorCode = OrtApi.GetErrorCode(segment);
        this.GetErrorMessage = OrtApi.GetErrorMessage(segment);
        this.GetMapKeyType = OrtApi.GetMapKeyType(segment);
        this.GetMapValueType = OrtApi.GetMapValueType(segment);
        this.GetOnnxTypeFromTypeInfo = OrtApi.GetOnnxTypeFromTypeInfo(segment);
        this.GetSequenceElementType = OrtApi.GetSequenceElementType(segment);
        this.GetStringTensorElement = OrtApi.GetStringTensorElement(segment);
        this.GetStringTensorElementLength = OrtApi.GetStringTensorElementLength(segment);
        this.GetTensorElementType = OrtApi.GetTensorElementType(segment);
        this.GetTensorMutableData = OrtApi.GetTensorMutableData(segment);
        this.GetTensorShapeElementCount = OrtApi.GetTensorShapeElementCount(segment);
        this.GetTensorTypeAndShape = OrtApi.GetTensorTypeAndShape(segment);
        this.GetValue = OrtApi.GetValue(segment);
        this.GetValueCount = OrtApi.GetValueCount(segment);
        this.ModelMetadataGetCustomMetadataMapKeys = OrtApi.ModelMetadataGetCustomMetadataMapKeys(segment);
        this.ModelMetadataGetDescription = OrtApi.ModelMetadataGetDescription(segment);
        this.ModelMetadataGetDomain = OrtApi.ModelMetadataGetDomain(segment);
        this.ModelMetadataGetGraphDescription = OrtApi.ModelMetadataGetGraphDescription(segment);
        this.ModelMetadataGetGraphName = OrtApi.ModelMetadataGetGraphName(segment);
        this.ModelMetadataGetProducerName = OrtApi.ModelMetadataGetProducerName(segment);
        this.ModelMetadataGetVersion = OrtApi.ModelMetadataGetVersion(segment);
        this.ModelMetadataLookupCustomMetadataMap = OrtApi.ModelMetadataLookupCustomMetadataMap(segment);
        this.ReleaseEnv = OrtApi.ReleaseEnv(segment);
        this.ReleaseMemoryInfo = OrtApi.ReleaseMemoryInfo(segment);
        this.ReleaseModelMetadata = OrtApi.ReleaseModelMetadata(segment);
        this.ReleaseSession = OrtApi.ReleaseSession(segment);
        this.ReleaseSessionOptions = OrtApi.ReleaseSessionOptions(segment);
        this.ReleaseStatus = OrtApi.ReleaseStatus(segment);
        this.ReleaseTypeInfo = OrtApi.ReleaseTypeInfo(segment);
        this.ReleaseValue = OrtApi.ReleaseValue(segment);
        this.Run = OrtApi.Run(segment);
        this.SessionGetInputCount = OrtApi.SessionGetInputCount(segment);
        this.SessionGetInputName = OrtApi.SessionGetInputName(segment);
        this.SessionGetInputTypeInfo = OrtApi.SessionGetInputTypeInfo(segment);
        this.SessionGetModelMetadata = OrtApi.SessionGetModelMetadata(segment);
        this.SessionGetOutputCount = OrtApi.SessionGetOutputCount(segment);
        this.SessionGetOutputName = OrtApi.SessionGetOutputName(segment);
        this.SessionGetOutputTypeInfo = OrtApi.SessionGetOutputTypeInfo(segment);
        this.SessionGetOverridableInitializerCount = OrtApi.SessionGetOverridableInitializerCount(segment);
        this.SessionGetOverridableInitializerName = OrtApi.SessionGetOverridableInitializerName(segment);
        this.SessionGetOverridableInitializerTypeInfo = OrtApi.SessionGetOverridableInitializerTypeInfo(segment);
    }

    @Override
    public Environment.Builder newEnvironment() {
        return new EnvironmentBuilderImpl(this);
    }

    void checkStatus(MemoryAddress status) {
        if (MemoryAddress.NULL.equals(status)) {
            return;
        }
        int code = GetErrorCode.apply(status);
        String message = toJavaString(GetErrorMessage.apply(status));
        ReleaseStatus.apply(status);
        throw new OnnxRuntimeException(code, message);
    }

    MemoryAddress create(SegmentAllocator allocator, Function<MemoryAddress, MemoryAddress> constructor) {
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
