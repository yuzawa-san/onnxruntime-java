/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toJavaString;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class ModelMetadataImpl implements ModelMetadata {

    private final String description;
    private final String domain;
    private final String graphDescription;
    private final String graphName;
    private final String producerName;
    private final long version;
    private final Map<String, String> customMetadata;

    ModelMetadataImpl(ApiImpl api, MemoryAddress metadata, MemoryAddress ortAllocator) {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
            {
                MemoryAddress pointer = api.create(
                        allocator, out -> api.ModelMetadataGetDescription.apply(metadata, ortAllocator, out));
                this.description = toJavaString(pointer);
                api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
            }
            {
                MemoryAddress pointer =
                        api.create(allocator, out -> api.ModelMetadataGetDomain.apply(metadata, ortAllocator, out));
                this.domain = toJavaString(pointer);
                api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
            }
            {
                MemoryAddress pointer = api.create(
                        allocator, out -> api.ModelMetadataGetGraphDescription.apply(metadata, ortAllocator, out));
                this.graphDescription = toJavaString(pointer);
                api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
            }
            {
                MemoryAddress pointer =
                        api.create(allocator, out -> api.ModelMetadataGetGraphName.apply(metadata, ortAllocator, out));
                this.graphName = toJavaString(pointer);
                api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
            }
            {
                MemoryAddress pointer = api.create(
                        allocator, out -> api.ModelMetadataGetProducerName.apply(metadata, ortAllocator, out));
                this.producerName = toJavaString(pointer);
                api.checkStatus(api.AllocatorFree.apply(ortAllocator, pointer));
            }
            {
                this.version = api.extractLong(allocator, out -> api.ModelMetadataGetVersion.apply(metadata, out));
            }
            {
                MemorySegment count = allocator.allocate(C_LONG);
                MemoryAddress keys = api.create(
                        allocator,
                        out -> api.ModelMetadataGetCustomMetadataMapKeys.apply(
                                metadata, ortAllocator, out, count.address()));
                long numKeys = MemoryAccess.getLong(count);
                if (numKeys == 0) {
                    this.customMetadata = Collections.emptyMap();
                } else {
                    MemorySegment keyArray = keys.asSegment(C_POINTER.byteSize() * numKeys, scope);
                    Map<String, String> customMetadata = new LinkedHashMap<>(Math.toIntExact(numKeys));
                    for (long i = 0; i < numKeys; i++) {
                        MemoryAddress key = MemoryAccess.getAddressAtIndex(keyArray, i);
                        MemoryAddress value = api.create(
                                allocator,
                                out -> api.ModelMetadataLookupCustomMetadataMap.apply(
                                        metadata, ortAllocator, key, out));
                        customMetadata.put(toJavaString(key), toJavaString(value));
                        api.checkStatus(api.AllocatorFree.apply(ortAllocator, key));
                        api.checkStatus(api.AllocatorFree.apply(ortAllocator, value));
                    }
                    this.customMetadata = customMetadata;
                }
            }
        }
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
