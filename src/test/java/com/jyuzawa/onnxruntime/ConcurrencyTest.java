/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcurrencyTest {

    private static Environment environment;
    private static byte[] model;

    @BeforeClass
    public static void setup() {
        OnnxRuntime apiBase = OnnxRuntime.get();
        Api api = apiBase.getApi();
        environment = api.newEnvironment()
                .setLogSeverityLevel(OnnxRuntimeLoggingLevel.WARNING)
                .setGlobalDenormalAsZero(false)
                .setGlobalInterOpNumThreads(0)
                .setGlobalIntraOpNumThreads(0)
                .setGlobalSpinControl(false)
                .build();
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        model = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(15))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput("input")
                                .addOutput("output")
                                .setOpType("Identity"))
                        .addInput(ValueInfoProto.newBuilder().setName("input").setType(type))
                        .addOutput(ValueInfoProto.newBuilder().setName("output").setType(type)))
                .build()
                .toByteArray();
    }

    @AfterClass
    public static void tearDown() {
        environment.close();
    }

    @Test
    public void loadUnloadTest() throws IOException {
        for (int i = 0; i < 10; i++) {
            try (Session session = environment
                    .newSession()
                    .setByteArray(model)
                    .disablePerSessionThreads()
                    .setMemoryPatternOptimization(false)
                    .addProvider(ExecutionProvider.CPU_EXECUTION_PROVIDER, Map.of("use_arena", "0"))
                    .setConfigMap(Map.of("session.use_env_allocators", "1"))
                    .build()) {
                for (int j = 0; j < 10; j++) {
                    Transaction.Builder txn = session.newTransaction();
                    float[] rawInput = new float[] {554354, 52345234, 143646};
                    txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
                    txn.addOutput(0);
                    NamedCollection<OnnxValue> output = txn.build().run();
                    float[] rawOutput = new float[3];
                    OnnxValue outputValue = output.get(0);
                    OnnxTensor outputTensor = outputValue.asTensor();
                    outputTensor.getFloatBuffer().get(rawOutput);
                    assertTrue(Arrays.equals(rawInput, rawOutput));
                }
            }
        }
    }

    @Test
    public void poolTest() throws Exception {
        int numThreads = 4;
        try (Session session = environment
                .newSession()
                .setByteArray(model)
                .disablePerSessionThreads()
                .setMemoryPatternOptimization(false)
                .addProvider(ExecutionProvider.CPU_EXECUTION_PROVIDER, Map.of("use_arena", "0"))
                .setConfigMap(Map.of("session.use_env_allocators", "1"))
                .build()) {
            ExecutorService executor = Executors.newFixedThreadPool(numThreads);
            for (int i = 0; i < numThreads; i++) {
                executor.submit(() -> {
                    for (int j = 0; j < 10000; j++) {
                        Transaction.Builder txn = session.newTransaction();
                        float[] rawInput = new float[] {554354, 52345234, 143646};
                        txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
                        txn.addOutput(0);
                        NamedCollection<OnnxValue> output = txn.build().run();
                        float[] rawOutput = new float[3];
                        OnnxValue outputValue = output.get(0);
                        OnnxTensor outputTensor = outputValue.asTensor();
                        outputTensor.getFloatBuffer().get(rawOutput);
                        assertTrue(Arrays.equals(rawInput, rawOutput));
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }
    }
}
