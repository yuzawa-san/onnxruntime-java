package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class SessionBuilderImpl implements Session.Builder {

  private final ApiImpl api;
  private final MemoryAddress environment;
  Path path;
  ByteBuffer buffer;

  SessionBuilderImpl(ApiImpl api, MemoryAddress environment) {
    this.api = api;
    this.environment = environment;
  }

  @Override
  public Session.Builder setPath(Path path) {
    this.path = path;
    return this;
  }

  @Override
  public Session.Builder setBuffer(ByteBuffer buffer) {
    this.buffer = buffer;
    return this;
  }

  @Override
  public Session build() throws IOException {
    ResourceScope scope = ResourceScope.newConfinedScope();
    SegmentAllocator allocator = SegmentAllocator.ofScope(scope);

    MemoryAddress sessionOptions =
        api.create(allocator, out -> api.CreateSessionOptions.apply(out));
    api.checkStatus(api.SetIntraOpNumThreads.apply(sessionOptions, 1));

    try {

      long size;
      MemorySegment mappedBuf;
      if (path == null) {
        mappedBuf = MemorySegment.ofByteBuffer(buffer);
        size = buffer.capacity();
      } else {
        size = Files.size(path);
        mappedBuf = MemorySegment.mapFile(path, 0, size, FileChannel.MapMode.READ_ONLY, scope);
      }
      MemoryAddress session =
          api.create(
              allocator,
              out ->
                  api.CreateSessionFromArray.apply(
                      environment, mappedBuf.address(), size, sessionOptions, out));
      scope.addCloseAction(
          () -> {
            System.out.println("sessionOptions");
            api.ReleaseSession.apply(session);
          });

      return new SessionImpl(api, scope, session);
    } finally {
      api.ReleaseSessionOptions.apply(sessionOptions);
    }
  }
}
