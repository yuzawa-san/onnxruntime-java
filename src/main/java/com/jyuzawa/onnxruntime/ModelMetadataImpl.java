package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toJavaString;

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
        MemorySegment pointer = allocator.allocate(C_POINTER);
        api.checkStatus(
            api.ModelMetadataGetDescription.apply(metadata, ortAllocator, pointer.address()));
        this.description = toJavaString(MemoryAccess.getAddress(pointer));
        api.checkStatus(api.AllocatorFree.apply(ortAllocator, MemoryAccess.getAddress(pointer)));
      }
      {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        api.checkStatus(
            api.ModelMetadataGetDomain.apply(metadata, ortAllocator, pointer.address()));
        this.domain = toJavaString(MemoryAccess.getAddress(pointer));
        api.checkStatus(api.AllocatorFree.apply(ortAllocator, MemoryAccess.getAddress(pointer)));
      }
      {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        api.checkStatus(
            api.ModelMetadataGetGraphDescription.apply(metadata, ortAllocator, pointer.address()));
        this.graphDescription = toJavaString(MemoryAccess.getAddress(pointer));
        api.checkStatus(api.AllocatorFree.apply(ortAllocator, MemoryAccess.getAddress(pointer)));
      }
      {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        api.checkStatus(
            api.ModelMetadataGetGraphName.apply(metadata, ortAllocator, pointer.address()));
        this.graphName = toJavaString(MemoryAccess.getAddress(pointer));
        api.checkStatus(api.AllocatorFree.apply(ortAllocator, MemoryAccess.getAddress(pointer)));
      }
      {
        MemorySegment pointer = allocator.allocate(C_POINTER);
        api.checkStatus(
            api.ModelMetadataGetProducerName.apply(metadata, ortAllocator, pointer.address()));
        this.producerName = toJavaString(MemoryAccess.getAddress(pointer));
        api.checkStatus(api.AllocatorFree.apply(ortAllocator, MemoryAccess.getAddress(pointer)));
      }
      {
        MemorySegment pointer = allocator.allocate(C_LONG);
        api.checkStatus(api.ModelMetadataGetVersion.apply(metadata, pointer.address()));
        this.version = MemoryAccess.getLong(pointer);
      }
      {
        MemorySegment count = allocator.allocate(C_LONG);
        MemorySegment keys = allocator.allocate(C_POINTER);
        api.checkStatus(
            api.ModelMetadataGetCustomMetadataMapKeys.apply(
                metadata, ortAllocator, keys.address(), count.address()));
        long numKeys = MemoryAccess.getLong(count);
        Map<String, String> customMetadata = new LinkedHashMap<>(Math.toIntExact(numKeys));
        for (long i = 0; i < numKeys; i++) {
          MemoryAddress key = MemoryAccess.getAddressAtOffset(keys, i);
          MemoryAddress value =
              api.create(
                  allocator,
                  out ->
                      api.ModelMetadataLookupCustomMetadataMap.apply(
                          metadata, ortAllocator, key, out));
          customMetadata.put(toJavaString(key), toJavaString(value));
          api.checkStatus(api.AllocatorFree.apply(ortAllocator, key));
          api.checkStatus(api.AllocatorFree.apply(ortAllocator, value));
        }
        this.customMetadata = customMetadata;
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

  public String toString() {
    return "{ModelMetadata: graphName="
        + graphName
        + ", version="
        + version
        + ", producerName="
        + producerName
        + ", domain="
        + domain
        + "}";
  }
}
