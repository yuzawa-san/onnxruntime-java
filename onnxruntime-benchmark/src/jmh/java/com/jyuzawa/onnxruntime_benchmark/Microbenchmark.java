/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import onnx.OnnxMl.GraphProto;
import onnx.OnnxMl.ModelProto;
import onnx.OnnxMl.NodeProto;
import onnx.OnnxMl.OperatorSetIdProto;
import onnx.OnnxMl.TensorProto.DataType;
import onnx.OnnxMl.TensorShapeProto;
import onnx.OnnxMl.TensorShapeProto.Dimension;
import onnx.OnnxMl.TypeProto;
import onnx.OnnxMl.TypeProto.Tensor;
import onnx.OnnxMl.ValueInfoProto;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(org.openjdk.jmh.annotations.Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(
        value = 3,
        jvmArgsAppend = {"--enable-native-access=ALL-UNNAMED", "--enable-preview"})
public class Microbenchmark {

    private static final String ONNXRUNTIME_JAVA = "onnxruntime-java";
    private static final String ONNXRUNTIME_JAVA_ARENA = "onnxruntime-java-arena";
    private static final String MICROSOFT = "microsoft";

    @Param(value = {ONNXRUNTIME_JAVA, ONNXRUNTIME_JAVA_ARENA, MICROSOFT})
    private String implementation;

    @Param({"16", "256", "4096"})
    private int size;

    private long[] input;
    private Wrapper wrapper;

    @Setup
    public void setup() throws Exception {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT64_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(size))))
                .build();
        ModelProto model = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(15))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput("input")
                                .addOutput("output")
                                .setOpType("Identity"))
                        .addInput(ValueInfoProto.newBuilder().setName("input").setType(type))
                        .addOutput(ValueInfoProto.newBuilder().setName("output").setType(type)))
                .build();
        byte[] bytes = model.toByteArray();
        input = new long[size];
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            input[i] = random.nextLong();
        }
        wrapper = switch (implementation) {
            case ONNXRUNTIME_JAVA -> new OnnxruntimeJava(bytes, false);
            case ONNXRUNTIME_JAVA_ARENA -> new OnnxruntimeJava(bytes, true);
            case MICROSOFT -> new Microsoft(bytes);
            default -> throw new IllegalArgumentException();};
    }

    @Benchmark
    @Threads(Threads.MAX)
    public void run(Blackhole bh) throws Exception {
        bh.consume(wrapper.evaluate(input));
    }
}
