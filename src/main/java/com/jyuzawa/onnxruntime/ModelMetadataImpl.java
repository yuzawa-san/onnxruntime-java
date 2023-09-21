/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

final class ModelMetadataImpl implements ModelMetadata {

    private final String description;
    private final String domain;
    private final String graphDescription;
    private final String graphName;
    private final String producerName;
    private final long version;
    private final Map<String, String> customMetadata;

    ModelMetadataImpl(ApiImpl api, Arena memorySession, MemorySegment session, MemorySegment ortAllocator) {
        MemorySegment metadata = api.create(memorySession, out -> api.SessionGetModelMetadata.apply(session, out));
        {
            MemorySegment pointer = api.create(
                    memorySession, out -> api.ModelMetadataGetDescription.apply(metadata, ortAllocator, out));
            this.description = pointer.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
        }
        {
            MemorySegment pointer =
                    api.create(memorySession, out -> api.ModelMetadataGetDomain.apply(metadata, ortAllocator, out));
            this.domain = pointer.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
        }
        {
            MemorySegment pointer = api.create(
                    memorySession, out -> api.ModelMetadataGetGraphDescription.apply(metadata, ortAllocator, out));
            this.graphDescription = pointer.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
        }
        {
            MemorySegment pointer =
                    api.create(memorySession, out -> api.ModelMetadataGetGraphName.apply(metadata, ortAllocator, out));
            this.graphName = pointer.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
        }
        {
            MemorySegment pointer = api.create(
                    memorySession, out -> api.ModelMetadataGetProducerName.apply(metadata, ortAllocator, out));
            this.producerName = pointer.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
        }
        {
            this.version = api.extractLong(memorySession, out -> api.ModelMetadataGetVersion.apply(metadata, out));
        }
        {
            MemorySegment count = memorySession.allocate(C_LONG);
            MemorySegment keys = api.create(
                    memorySession,
                    out -> api.ModelMetadataGetCustomMetadataMapKeys.apply(metadata, ortAllocator, out, count));
            long numKeys = count.getAtIndex(C_LONG, 0);
            if (numKeys == 0) {
                this.customMetadata = Collections.emptyMap();
            } else {
                Map<String, String> customMetadata = new LinkedHashMap<>(Math.toIntExact(numKeys));
                for (long i = 0; i < numKeys; i++) {
                    MemorySegment key = keys.getAtIndex(C_POINTER, i);
                    MemorySegment value = api.create(
                            memorySession,
                            out -> api.ModelMetadataLookupCustomMetadataMap.apply(metadata, ortAllocator, key, out));
                    customMetadata.put(key.getUtf8String(0), value.getUtf8String(0));
                    api.checkStatus(api.AllocatorFree.apply(ortAllocator, key));
                    api.checkStatus(api.AllocatorFree.apply(ortAllocator, value));
                }
                this.customMetadata = Collections.unmodifiableMap(customMetadata);
            }
        }
        api.ReleaseModelMetadata.apply(metadata);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public String getGraphDescription() {
        return graphDescription;
    }

    @Override
    public String getGraphName() {
        return graphName;
    }

    @Override
    public String getProducerName() {
        return producerName;
    }

    @Override
    public long getVersion() {
        return version;
    }

    @Override
    public Map<String, String> getCustomMetadata() {
        return customMetadata;
    }

    @Override
    public String toString() {
        return "{ModelMetadata: graphName=" + graphName + ", version=" + version + ", producerName=" + producerName
                + ", domain=" + domain + "}";
    }
}
