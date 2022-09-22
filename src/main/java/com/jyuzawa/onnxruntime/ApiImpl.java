/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.function.Function;

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
        MemorySession scope = MemorySession.global();
        this.AllocatorFree = OrtApi.AllocatorFree(segment, scope);
        this.CastTypeInfoToMapTypeInfo = OrtApi.CastTypeInfoToMapTypeInfo(segment, scope);
        this.CastTypeInfoToSequenceTypeInfo = OrtApi.CastTypeInfoToSequenceTypeInfo(segment, scope);
        this.CastTypeInfoToTensorInfo = OrtApi.CastTypeInfoToTensorInfo(segment, scope);
        this.CreateCpuMemoryInfo = OrtApi.CreateCpuMemoryInfo(segment, scope);
        this.CreateEnvWithCustomLogger = OrtApi.CreateEnvWithCustomLogger(segment, scope);
        this.CreateSessionFromArray = OrtApi.CreateSessionFromArray(segment, scope);
        this.CreateSessionOptions = OrtApi.CreateSessionOptions(segment, scope);
        this.CreateTensorAsOrtValue = OrtApi.CreateTensorAsOrtValue(segment, scope);
        this.CreateTensorWithDataAsOrtValue = OrtApi.CreateTensorWithDataAsOrtValue(segment, scope);
        this.CreateValue = OrtApi.CreateValue(segment, scope);
        this.DisableTelemetryEvents = OrtApi.DisableTelemetryEvents(segment, scope);
        this.EnableTelemetryEvents = OrtApi.EnableTelemetryEvents(segment, scope);
        this.FillStringTensor = OrtApi.FillStringTensor(segment, scope);
        this.GetAllocatorWithDefaultOptions = OrtApi.GetAllocatorWithDefaultOptions(segment, scope);
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
        this.ReleaseEnv = OrtApi.ReleaseEnv(segment, scope);
        this.ReleaseMemoryInfo = OrtApi.ReleaseMemoryInfo(segment, scope);
        this.ReleaseModelMetadata = OrtApi.ReleaseModelMetadata(segment, scope);
        this.ReleaseSession = OrtApi.ReleaseSession(segment, scope);
        this.ReleaseSessionOptions = OrtApi.ReleaseSessionOptions(segment, scope);
        this.ReleaseStatus = OrtApi.ReleaseStatus(segment, scope);
        this.ReleaseTypeInfo = OrtApi.ReleaseTypeInfo(segment, scope);
        this.ReleaseValue = OrtApi.ReleaseValue(segment, scope);
        this.Run = OrtApi.Run(segment, scope);
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
    }

    @Override
    public Environment.Builder newEnvironment() {
        return new EnvironmentBuilderImpl(this);
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

    MemoryAddress create(MemorySession allocator, Function<MemoryAddress, Addressable> constructor) {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        checkStatus(constructor.apply(pointer.address()));
        return pointer.getAtIndex(C_POINTER, 0);
    }

    int extractInt(MemorySession allocator, Function<MemoryAddress, Addressable> method) {
        MemorySegment pointer = allocator.allocate(C_INT);
        checkStatus(method.apply(pointer.address()));
        return pointer.getAtIndex(C_INT, 0);
    }

    long extractLong(MemorySession allocator, Function<MemoryAddress, Addressable> method) {
        MemorySegment pointer = allocator.allocate(C_LONG);
        checkStatus(method.apply(pointer.address()));
        return pointer.getAtIndex(C_LONG, 0);
    }
}
