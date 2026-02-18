/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static org.junit.jupiter.api.Assertions.*;

import com.google.protobuf.ByteString;
import com.jyuzawa.onnxruntime_extern.onnxruntime_all_h;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import onnx.OnnxMl.AttributeProto;
import onnx.OnnxMl.AttributeProto.AttributeType;
import onnx.OnnxMl.GraphProto;
import onnx.OnnxMl.ModelProto;
import onnx.OnnxMl.NodeProto;
import onnx.OnnxMl.OperatorSetIdProto;
import onnx.OnnxMl.StringStringEntryProto;
import onnx.OnnxMl.TensorProto.DataType;
import onnx.OnnxMl.TensorShapeProto;
import onnx.OnnxMl.TensorShapeProto.Dimension;
import onnx.OnnxMl.TypeProto;
import onnx.OnnxMl.TypeProto.Sequence;
import onnx.OnnxMl.TypeProto.Tensor;
import onnx.OnnxMl.ValueInfoProto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class SessionTest {

    private static final Logger LOG = System.getLogger(SessionTest.class.getName());
    private static Api api;
    private static Environment environment;

    private static final TypeProto FLOAT_TYPE = TypeProto.newBuilder()
            .setTensorType(Tensor.newBuilder()
                    .setElemType(DataType.FLOAT_VALUE)
                    .setShape(TensorShapeProto.newBuilder()
                            .addDim(Dimension.newBuilder().setDimValue(1))
                            .addDim(Dimension.newBuilder().setDimValue(3))))
            .build();

    @BeforeAll
    public static void setup() {
        OnnxRuntime apiBase = OnnxRuntime.get();
        api = apiBase.getApi();
        environment = api.newEnvironment()
                .setLogSeverityLevel(OnnxRuntimeLoggingLevel.VERBOSE)
                .setLogId("testing")
                .setGlobalDenormalAsZero(true)
                .setGlobalSpinControl(true)
                .setArenaConfig(Map.of("initial_chunk_size_bytes", 65535L, "initial_growth_chunk_size_bytes", 65535L))
                .build();
        environment.setTelemetryEvents(true);
        environment.setTelemetryEvents(false);
        ((com.jyuzawa.onnxruntime.EnvironmentImpl) environment).getAllocatorStats();
    }

    @AfterAll
    public static void tearDown() {
        environment.close();
    }

    private ByteBuffer identityModel(TypeProto type) {
        return ModelProto.newBuilder()
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
                .toByteString()
                .asReadOnlyByteBuffer();
    }

    @Test
    public void providersTest() {
        Set<ExecutionProvider> providers = api.getAvailableProviders();
        assertFalse(providers.isEmpty());
        assertTrue(providers.contains(ExecutionProvider.CPU_EXECUTION_PROVIDER));
    }

    @Test
    public void buildInfoTest() {
        assertFalse(OnnxRuntime.get().getVersion().isEmpty());
        assertEquals(OnnxRuntime.get().getApiVersion(), onnxruntime_all_h.ORT_API_VERSION());
        assertFalse(api.getBuildString().isEmpty());
    }

    @Test
    public void infoTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        String description = "description";
        String domain = "com.jyuzawa";
        String graphDescription = "graphDescription";
        String graphName = "graphName";
        String producerName = "producerName";
        long version = 215L;
        String key1 = "key1";
        String value1 = "value1";
        String key2 = "key2";
        String value2 = "value2";
        String inputName = "input";
        String outputName = "output";
        ByteBuffer byteBuffer = ModelProto.newBuilder()
                .setDocString(description)
                .setDomain(domain)
                .setProducerName(producerName)
                .setModelVersion(version)
                .addMetadataProps(
                        StringStringEntryProto.newBuilder().setKey(key1).setValue(value1))
                .addMetadataProps(
                        StringStringEntryProto.newBuilder().setKey(key2).setValue(value2))
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(10))
                .setGraph(GraphProto.newBuilder()
                        .setDocString(graphDescription)
                        .setName(graphName)
                        .addNode(NodeProto.newBuilder()
                                .addInput(inputName)
                                .addOutput(outputName)
                                .setOpType("Identity"))
                        .addInput(ValueInfoProto.newBuilder().setName(inputName).setType(type))
                        .addOutput(
                                ValueInfoProto.newBuilder().setName(outputName).setType(type)))
                .build()
                .toByteString()
                .asReadOnlyByteBuffer();
        ExecutionProvider provider = ExecutionProvider.of("CANNExecutionProvider");
        if (!provider.isSupported()) {
            assertThrows(UnsupportedOperationException.class, () -> environment
                    .newSession()
                    .setByteBuffer(byteBuffer)
                    .addProvider(provider)
                    .build());
        }
        try (Session session = environment
                .newSession()
                .setByteBuffer(byteBuffer)
                .setDeterministicCompute(true)
                .build()) {
            TypeInfo typeInfo = session.getInputs().get(0).getTypeInfo();
            assertThrows(NoSuchElementException.class, () -> typeInfo.getSequenceInfo());
            assertThrows(NoSuchElementException.class, () -> typeInfo.getMapInfo());
            assertNotNull(typeInfo.getTensorInfo());
            assertEquals(OnnxType.TENSOR, typeInfo.getType());
            typeInfo.toString();
            ModelMetadata metadata = session.getModelMetadata();
            Map<String, String> metadataMap = metadata.getCustomMetadata();
            assertEquals(2, metadataMap.size());
            assertEquals(value1, metadataMap.get(key1));
            assertEquals(value2, metadataMap.get(key2));
            assertEquals(description, metadata.getDescription());
            assertEquals(domain, metadata.getDomain());
            assertEquals(graphDescription, metadata.getGraphDescription());
            assertEquals(graphName, metadata.getGraphName());
            assertEquals(producerName, metadata.getProducerName());
            assertEquals(version, metadata.getVersion());
            NamedCollection<NodeInfo> inputs = session.getInputs();
            assertEquals(1, inputs.size());
            NodeInfo input = inputs.get(0);
            assertEquals(input, inputs.get(inputName));
            assertEquals(inputName, input.getName());
            assertEquals(OnnxType.TENSOR, input.getTypeInfo().getType());
            assertEquals(
                    OnnxTensorElementDataType.FLOAT,
                    input.getTypeInfo().getTensorInfo().getType());
            assertEquals(2, input.getTypeInfo().getTensorInfo().getShape().size());
            assertEquals(
                    1, input.getTypeInfo().getTensorInfo().getShape().get(0).intValue());
            assertEquals(
                    3, input.getTypeInfo().getTensorInfo().getShape().get(1).intValue());
            NamedCollection<NodeInfo> outputs = session.getOutputs();
            assertEquals(1, outputs.size());
            NodeInfo output = outputs.get(0);
            assertEquals(output, outputs.get(outputName));
            assertEquals(outputName, output.getName());
            assertEquals(OnnxType.TENSOR, output.getTypeInfo().getType());
            assertEquals(
                    OnnxTensorElementDataType.FLOAT,
                    output.getTypeInfo().getTensorInfo().getType());
            assertEquals(2, output.getTypeInfo().getTensorInfo().getShape().size());
            assertEquals(
                    1, output.getTypeInfo().getTensorInfo().getShape().get(0).intValue());
            assertEquals(
                    3, output.getTypeInfo().getTensorInfo().getShape().get(1).intValue());
        }
    }

    @Test
    public void multiTest() throws IOException {
        String inputName1 = "in1";
        String inputName2 = "in2";
        String outputName1 = "out1";
        String outputName2 = "out2";
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        ByteBuffer byteBuffer = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(10))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput(inputName1)
                                .addOutput(outputName1)
                                .setOpType("Identity"))
                        .addInput(
                                ValueInfoProto.newBuilder().setName(inputName1).setType(type))
                        .addOutput(
                                ValueInfoProto.newBuilder().setName(outputName1).setType(type))
                        .addNode(NodeProto.newBuilder()
                                .addInput(inputName2)
                                .addOutput(outputName2)
                                .setOpType("Identity"))
                        .addInput(
                                ValueInfoProto.newBuilder().setName(inputName2).setType(type))
                        .addOutput(
                                ValueInfoProto.newBuilder().setName(outputName2).setType(type)))
                .build()
                .toByteString()
                .asReadOnlyByteBuffer();
        try (Session session =
                        environment.newSession().setByteBuffer(byteBuffer).build();
                Transaction txn = session.newTransaction().build()) {
            float[] rawInput1 = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput1);
            float[] rawInput2 = new float[] {5346, 62346, 2345};
            txn.addInput(1).asTensor().getFloatBuffer().put(rawInput2);
            txn.addOutput(0);
            txn.addOutput(1);
            NamedCollection<OnnxValue> output = txn.run();
            float[] rawOutput1 = new float[3];
            OnnxValue outputValue1 = output.get(0);
            OnnxTensor outputTensor1 = outputValue1.asTensor();
            outputTensor1.getFloatBuffer().get(rawOutput1);
            assertArrayEquals(rawInput1, rawOutput1);
            float[] rawOutput2 = new float[3];
            OnnxValue outputValue2 = output.get(1);
            OnnxTensor outputTensor2 = outputValue2.asTensor();
            outputTensor2.getFloatBuffer().get(rawOutput2);
            assertArrayEquals(rawInput2, rawOutput2);
        }
    }

    @Test
    public void floatTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            assertFalse(session.getInputs().get(0).getTypeInfo().getTensorInfo().isDynamicShape());
            float[] rawInput = new float[] {554354, 52345234, 143646};
            OnnxValue addedInput = txn.addInput(0);
            assertThrows(IllegalArgumentException.class, () -> addedInput.asTensor(List.of(1L, 2L, 3L)));
            addedInput.asTensor().getFloatBuffer().put(rawInput);

            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            float[] rawOutput = new float[3];
            OnnxValue outputValue = output.get(0);
            assertEquals(OnnxType.TENSOR, outputValue.getType());
            assertThrows(NoSuchElementException.class, () -> outputValue.asMap());
            assertThrows(NoSuchElementException.class, () -> outputValue.asSequence());
            OnnxTensor outputTensor = outputValue.asTensor();
            assertThrows(NoSuchElementException.class, () -> outputTensor.getByteBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getShortBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getIntBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getDoubleBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getLongBuffer());
            outputTensor.getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void doubleTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.DOUBLE_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            double[] rawInput = new double[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getDoubleBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            double[] rawOutput = new double[3];
            output.get(0).asTensor().getDoubleBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void byteTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT8_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            byte[] rawInput = new byte[] {4, 3, 2};
            txn.addInput(0).asTensor().getByteBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            byte[] rawOutput = new byte[3];
            output.get(0).asTensor().getByteBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void shortTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT16_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            short[] rawInput = new short[] {4, 3, 2};
            txn.addInput(0).asTensor().getShortBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            short[] rawOutput = new short[3];
            output.get(0).asTensor().getShortBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void intTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT32_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            int[] rawInput = new int[] {4, 3, 2};
            txn.addInput(0).asTensor().getIntBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            int[] rawOutput = new int[3];
            output.get(0).asTensor().getIntBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void longTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT64_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            long[] rawInput = new long[] {4, 3, 2};
            txn.addInput(0).asTensor().getLongBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            long[] rawOutput = new long[3];
            output.get(0).asTensor().getLongBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void stringTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.STRING_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            String[] rawInput = txn.addInput(0).asTensor().getStringBuffer();
            rawInput[0] = "foo";
            rawInput[1] = "bar";
            rawInput[2] = "boom";
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            String[] rawOutput = output.get(0).asTensor().getStringBuffer();
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void sequenceTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setSequenceType(Sequence.newBuilder()
                        .setElemType(TypeProto.newBuilder()
                                .setTensorType(Tensor.newBuilder()
                                        .setElemType(DataType.FLOAT_VALUE)
                                        .setShape(TensorShapeProto.newBuilder()
                                                .addDim(Dimension.newBuilder().setDimValue(1))
                                                .addDim(Dimension.newBuilder().setDimValue(3))))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            TypeInfo typeInfo = session.getInputs().get(0).getTypeInfo();
            assertThrows(NoSuchElementException.class, () -> typeInfo.getTensorInfo());
            assertThrows(NoSuchElementException.class, () -> typeInfo.getMapInfo());
            assertNotNull(typeInfo.getSequenceInfo());
            assertEquals(OnnxType.SEQUENCE, typeInfo.getType());
            typeInfo.toString();
            float[] rawInput1 = new float[] {554354, 52345234, 143646};
            float[] rawInput2 = new float[] {5234, 1436, 613};
            OnnxSequence inputSequence = txn.addInput(0).asSequence();
            inputSequence.add().asTensor().getFloatBuffer().put(rawInput1);
            inputSequence.add().asTensor().getFloatBuffer().put(rawInput2);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            float[] outputBuffer = new float[3];
            OnnxValue outputValue = output.get(0);
            assertThrows(NoSuchElementException.class, () -> outputValue.asMap());
            assertThrows(NoSuchElementException.class, () -> outputValue.asTensor());
            assertThrows(NoSuchElementException.class, () -> outputValue.asTensor(List.of(1L)));
            OnnxSequence outputSequence = outputValue.asSequence();
            assertEquals(
                    OnnxTensorElementDataType.FLOAT,
                    outputSequence.getInfo().getTensorInfo().getType());
            assertThrows(UnsupportedOperationException.class, () -> outputSequence.add(outputValue));
            assertThrows(
                    UnsupportedOperationException.class,
                    () -> outputSequence.addAll(Collections.singletonList(outputValue)));
            assertThrows(UnsupportedOperationException.class, () -> outputSequence.set(0, outputValue));
            assertThrows(UnsupportedOperationException.class, () -> outputSequence.add(0, outputValue));
            assertThrows(UnsupportedOperationException.class, () -> outputSequence.remove(outputValue));
            assertThrows(
                    UnsupportedOperationException.class,
                    () -> outputSequence.removeAll(Collections.singletonList(outputValue)));
            assertThrows(
                    UnsupportedOperationException.class,
                    () -> outputSequence.retainAll(Collections.singletonList(outputValue)));
            assertThrows(UnsupportedOperationException.class, () -> outputSequence.clear());
            assertThrows(UnsupportedOperationException.class, () -> outputSequence.remove(0));
            assertEquals(2, outputSequence.size());
            assertFalse(outputSequence.isEmpty());
            assertTrue(outputSequence.contains(outputSequence.get(0)));
            assertTrue(outputSequence.containsAll(Collections.singletonList(outputSequence.get(0))));
            assertEquals(1, outputSequence.indexOf(outputSequence.get(1)));
            assertEquals(1, outputSequence.lastIndexOf(outputSequence.get(1)));
            assertTrue(outputSequence.listIterator().hasNext());
            assertTrue(outputSequence.listIterator(0).hasNext());
            assertFalse(outputSequence.subList(0, 1).isEmpty());
            outputSequence.get(0).asTensor().getFloatBuffer().get(outputBuffer);
            assertArrayEquals(rawInput1, outputBuffer);
            outputSequence.get(1).asTensor().getFloatBuffer().get(outputBuffer);
            assertArrayEquals(rawInput2, outputBuffer);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void chainingTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        float[] rawInput = new float[] {554354, 52345234, 143646};
        try (Session session0 = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Session session1 = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Session session2 = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build()) {

            OnnxTensor input = environment.newTensor(
                    OnnxTensorElementDataType.FLOAT,
                    List.of(1L, 3L),
                    Arena.ofAuto().allocateFrom(ValueLayout.JAVA_FLOAT, rawInput));
            OnnxValue output0 = session0.newTransaction()
                    .run(Map.of("input", input), List.of("output"))
                    .get(0);
            OnnxValue output1 = session1.newTransaction()
                    .run(Map.of("input", output0), List.of("output"))
                    .get(0);
            float[] rawOutput = new float[3];
            session2.newTransaction()
                    .run(Map.of("input", output1), List.of("output"))
                    .get(0)
                    .asTensor()
                    .getFloatBuffer()
                    .get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
        }
    }

    @Test
    public void dimParamTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimParam("param"))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            assertEquals(
                    List.of(1L, -1L),
                    session.getInputs().get(0).getTypeInfo().getTensorInfo().getShape());
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor(List.of(1L, 3L)).getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            float[] rawOutput = new float[3];
            txn.run().get(0).asTensor().getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
        }

        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .setFreeDimensionOverrideByName(Map.of("param", 3))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            assertEquals(
                    List.of(1L, 3L),
                    session.getInputs().get(0).getTypeInfo().getTensorInfo().getShape());
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            float[] rawOutput = new float[3];
            txn.run().get(0).asTensor().getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
        }
    }

    @Test
    public void dimDenotationTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDenotation("DENOTATION"))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            assertEquals(
                    List.of(1L, -1L),
                    session.getInputs().get(0).getTypeInfo().getTensorInfo().getShape());
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor(List.of(1L, 3L)).getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            float[] rawOutput = new float[3];
            txn.run().get(0).asTensor().getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
        }

        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .setFreeDimensionOverride(Map.of("DENOTATION", 3))
                        .build();
                Transaction txn = session.newTransaction().build()) {
            assertEquals(
                    List.of(1L, 3L),
                    session.getInputs().get(0).getTypeInfo().getTensorInfo().getShape());
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            float[] rawOutput = new float[3];
            txn.run().get(0).asTensor().getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
        }
    }

    @Test
    public void dynamicShapeTest() throws IOException {
        ByteBuffer model = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(23))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput("input1")
                                .addInput("input2")
                                .addOutput("output")
                                .setName("addtwotensors-node-0")
                                .setOpType("Add"))
                        .setName("addtwotensors-graph-0")
                        .addInput(ValueInfoProto.newBuilder()
                                .setName("input1")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder().setElemType(DataType.DOUBLE_VALUE))))
                        .addInput(ValueInfoProto.newBuilder()
                                .setName("input2")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder().setElemType(DataType.DOUBLE_VALUE))))
                        .addOutput(ValueInfoProto.newBuilder()
                                .setName("output")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder().setElemType(DataType.DOUBLE_VALUE)))))
                .build()
                .toByteString()
                .asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build();
                Transaction txn = session.newTransaction().build()) {
            assertTrue(session.getInputs().get(0).getTypeInfo().getTensorInfo().isDynamicShape());
            assertTrue(session.getInputs().get(1).getTypeInfo().getTensorInfo().isDynamicShape());
            assertTrue(session.getOutputs().get(0).getTypeInfo().getTensorInfo().isDynamicShape());
            double[] input1 = new double[] {1, 2, 3};
            double[] input2 = new double[] {4, 5, 6};
            OnnxValue addedInput1 = txn.addInput(0);
            assertThrows(IllegalArgumentException.class, () -> addedInput1.asTensor());
            assertThrows(IllegalArgumentException.class, () -> addedInput1.asTensor(List.of(-1L, 256L)));
            addedInput1.asTensor(List.of(1L, 3L)).getDoubleBuffer().put(input1);
            assertThrows(IllegalArgumentException.class, () -> addedInput1.asTensor(List.of(1L, 4L)));
            txn.addInput(1).asTensor(List.of(1L, 3L)).getDoubleBuffer().put(input2);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            double[] rawOutput = new double[3];
            OnnxValue outputValue = output.get(0);
            assertThrows(IllegalArgumentException.class, () -> addedInput1.asTensor(List.of(1L, 2L, 3L)));
            OnnxTensor outputTensor = outputValue.asTensor();
            assertEquals(List.of(1L, 3L), outputTensor.getInfo().getShape());
            outputTensor.getDoubleBuffer().get(rawOutput);
            assertArrayEquals(new double[] {5, 7, 9}, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void zipMapLongTest() throws IOException {
        ModelProto modelProto = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(15))
                .setGraph(
                        GraphProto.newBuilder()
                                .addNode(NodeProto.newBuilder()
                                        .addInput("input")
                                        .addOutput("output")
                                        .setOpType("ZipMap")
                                        .setDomain("ai.onnx.ml")
                                        .addAttribute(AttributeProto.newBuilder()
                                                .setName("classlabels_int64s")
                                                .setType(AttributeType.INTS)
                                                .addInts(1435)
                                                .addInts(35234)
                                                .addInts(572457)))
                                .addInput(ValueInfoProto.newBuilder()
                                        .setName("input")
                                        .setType(TypeProto.newBuilder()
                                                .setTensorType(Tensor.newBuilder()
                                                        .setElemType(DataType.FLOAT_VALUE)
                                                        .setShape(TensorShapeProto.newBuilder()
                                                                .addDim(Dimension.newBuilder()
                                                                        .setDimValue(3))))))
                                .addOutput(
                                        ValueInfoProto.newBuilder()
                                                .setName("output")
                                                .setType(
                                                        TypeProto.newBuilder()
                                                                .setSequenceType(
                                                                        Sequence.newBuilder()
                                                                                .setElemType(
                                                                                        TypeProto.newBuilder()
                                                                                                .setMapType(
                                                                                                        TypeProto.Map
                                                                                                                .newBuilder()
                                                                                                                .setKeyType(
                                                                                                                        DataType
                                                                                                                                .INT64_VALUE)
                                                                                                                .setValueType(
                                                                                                                        TypeProto
                                                                                                                                .newBuilder()
                                                                                                                                .setTensorType(
                                                                                                                                        Tensor
                                                                                                                                                .newBuilder()
                                                                                                                                                .setElemType(
                                                                                                                                                        DataType
                                                                                                                                                                .FLOAT_VALUE)
                                                                                                                                                .setShape(
                                                                                                                                                        TensorShapeProto
                                                                                                                                                                .newBuilder()
                                                                                                                                                                .addDim(
                                                                                                                                                                        Dimension
                                                                                                                                                                                .newBuilder()
                                                                                                                                                                                .setDimValue(
                                                                                                                                                                                        1)))))))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build();
                Transaction txn = session.newTransaction().build()) {
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            OnnxTypedMap<Long> outputMap =
                    output.get(0).asSequence().get(0).asMap().asLongMap();
            float[] rawOutput = new float[3];
            rawOutput[0] = outputMap.get(1435L).asTensor().getFloatBuffer().get();
            rawOutput[1] = outputMap.get(35234L).asTensor().getFloatBuffer().get();
            rawOutput[2] = outputMap.get(572457L).asTensor().getFloatBuffer().get();
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void zipMapStringTest() throws IOException {
        ModelProto modelProto = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(15))
                .setGraph(
                        GraphProto.newBuilder()
                                .addNode(NodeProto.newBuilder()
                                        .addInput("input")
                                        .addOutput("output")
                                        .setOpType("ZipMap")
                                        .setDomain("ai.onnx.ml")
                                        .addAttribute(AttributeProto.newBuilder()
                                                .setName("classlabels_strings")
                                                .setType(AttributeType.STRINGS)
                                                .addStrings(ByteString.copyFrom("foo", "utf-8"))
                                                .addStrings(ByteString.copyFrom("bazz", "utf-8"))
                                                .addStrings(ByteString.copyFrom("barss", "utf-8"))))
                                .addInput(ValueInfoProto.newBuilder()
                                        .setName("input")
                                        .setType(TypeProto.newBuilder()
                                                .setTensorType(Tensor.newBuilder()
                                                        .setElemType(DataType.FLOAT_VALUE)
                                                        .setShape(TensorShapeProto.newBuilder()
                                                                .addDim(Dimension.newBuilder()
                                                                        .setDimValue(3))))))
                                .addOutput(
                                        ValueInfoProto.newBuilder()
                                                .setName("output")
                                                .setType(
                                                        TypeProto.newBuilder()
                                                                .setSequenceType(
                                                                        Sequence.newBuilder()
                                                                                .setElemType(
                                                                                        TypeProto.newBuilder()
                                                                                                .setMapType(
                                                                                                        TypeProto.Map
                                                                                                                .newBuilder()
                                                                                                                .setKeyType(
                                                                                                                        DataType
                                                                                                                                .STRING_VALUE)
                                                                                                                .setValueType(
                                                                                                                        TypeProto
                                                                                                                                .newBuilder()
                                                                                                                                .setTensorType(
                                                                                                                                        Tensor
                                                                                                                                                .newBuilder()
                                                                                                                                                .setElemType(
                                                                                                                                                        DataType
                                                                                                                                                                .FLOAT_VALUE)
                                                                                                                                                .setShape(
                                                                                                                                                        TensorShapeProto
                                                                                                                                                                .newBuilder()
                                                                                                                                                                .addDim(
                                                                                                                                                                        Dimension
                                                                                                                                                                                .newBuilder()
                                                                                                                                                                                .setDimValue(
                                                                                                                                                                                        1)))))))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build();
                Transaction txn = session.newTransaction().build()) {
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            OnnxValue outputValue = output.get(0).asSequence().get(0);
            assertThrows(NoSuchElementException.class, () -> outputValue.asTensor());
            assertThrows(NoSuchElementException.class, () -> outputValue.asSequence());
            OnnxMap map = outputValue.asMap();
            OnnxTypedMap<String> outputMap = map.asStringMap();
            assertEquals(OnnxTensorElementDataType.STRING, map.getInfo().getKeyType());
            assertEquals(OnnxType.TENSOR, map.getInfo().getValueType().getType());
            assertEquals(
                    OnnxTensorElementDataType.FLOAT,
                    map.getInfo().getValueType().getTensorInfo().getType());
            assertThrows(NoSuchElementException.class, () -> map.asLongMap());
            assertThrows(UnsupportedOperationException.class, () -> outputMap.put("blah", null));
            assertThrows(UnsupportedOperationException.class, () -> outputMap.putAll(null));
            assertThrows(UnsupportedOperationException.class, () -> outputMap.remove("foo"));
            assertThrows(UnsupportedOperationException.class, () -> outputMap.clear());
            assertEquals(3, outputMap.size());
            assertFalse(outputMap.isEmpty());
            assertTrue(outputMap.containsKey("foo"));
            assertFalse(outputMap.containsValue(outputValue));
            assertEquals(3, outputMap.keySet().size());
            assertEquals(3, outputMap.values().size());
            assertEquals(3, outputMap.entrySet().size());
            float[] rawOutput = new float[3];
            rawOutput[0] = outputMap.get("foo").asTensor().getFloatBuffer().get();
            rawOutput[1] = outputMap.get("bazz").asTensor().getFloatBuffer().get();
            rawOutput[2] = outputMap.get("barss").asTensor().getFloatBuffer().get();
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void castMapStringTest() throws IOException {
        ModelProto modelProto = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(15))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput("input")
                                .addOutput("output")
                                .setOpType("CastMap")
                                .setDomain("ai.onnx.ml")
                                .addAttribute(AttributeProto.newBuilder()
                                        .setName("cast_to")
                                        .setType(AttributeType.STRING)
                                        .setS(ByteString.copyFrom("TO_STRING", StandardCharsets.UTF_8))))
                        .addInput(ValueInfoProto.newBuilder()
                                .setName("input")
                                .setType(TypeProto.newBuilder()
                                        .setMapType(TypeProto.Map.newBuilder()
                                                .setKeyType(DataType.INT64_VALUE)
                                                .setValueType(TypeProto.newBuilder()
                                                        .setTensorType(Tensor.newBuilder()
                                                                .setElemType(DataType.STRING_VALUE)
                                                                .setShape(TensorShapeProto.newBuilder()
                                                                        .addDim(Dimension.newBuilder()
                                                                                .setDimValue(1))))))))
                        .addOutput(ValueInfoProto.newBuilder()
                                .setName("output")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder()
                                                .setElemType(DataType.STRING_VALUE)
                                                .setShape(TensorShapeProto.newBuilder()
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(1))
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(5)))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build();
                Transaction txn = session.newTransaction().build()) {
            TypeInfo typeInfo = session.getInputs().get(0).getTypeInfo();
            assertThrows(NoSuchElementException.class, () -> typeInfo.getTensorInfo());
            assertThrows(NoSuchElementException.class, () -> typeInfo.getSequenceInfo());
            assertNotNull(typeInfo.getMapInfo());
            assertEquals(OnnxType.MAP, typeInfo.getType());
            typeInfo.toString();
            String[] rawInputs = new String[] {"fsaf", "fa3sf", "fe", "ab", "xr"};
            long[] keys = new long[] {554354, 52345234, 143646, 10, 19};
            OnnxTypedMap<Long> mapInput = txn.addInput(0).asMap().asLongMap();
            mapInput.set(keys[0]).asTensor().getStringBuffer()[0] = rawInputs[0];
            mapInput.set(keys[1]).asTensor().getStringBuffer()[0] = rawInputs[1];
            mapInput.set(keys[2]).asTensor().getStringBuffer()[0] = rawInputs[2];
            mapInput.set(keys[3]).asTensor().getStringBuffer()[0] = rawInputs[3];
            mapInput.set(keys[4]).asTensor().getStringBuffer()[0] = rawInputs[4];
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            String[] rawOutput = output.get(0).asTensor().getStringBuffer();
            String[] orderedOut = new String[] {"ab", "xr", "fe", "fsaf", "fa3sf"};
            assertArrayEquals(orderedOut, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    @Test
    public void castMapLongTest() throws IOException {
        ModelProto modelProto = ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(15))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput("input")
                                .addOutput("output")
                                .setOpType("CastMap")
                                .setDomain("ai.onnx.ml")
                                .addAttribute(AttributeProto.newBuilder()
                                        .setName("cast_to")
                                        .setType(AttributeType.STRING)
                                        .setS(ByteString.copyFrom("TO_INT64", StandardCharsets.UTF_8))))
                        .addInput(ValueInfoProto.newBuilder()
                                .setName("input")
                                .setType(TypeProto.newBuilder()
                                        .setMapType(TypeProto.Map.newBuilder()
                                                .setKeyType(DataType.INT64_VALUE)
                                                .setValueType(TypeProto.newBuilder()
                                                        .setTensorType(Tensor.newBuilder()
                                                                .setElemType(DataType.FLOAT_VALUE)
                                                                .setShape(TensorShapeProto.newBuilder()
                                                                        .addDim(Dimension.newBuilder()
                                                                                .setDimValue(1))))))))
                        .addOutput(ValueInfoProto.newBuilder()
                                .setName("output")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder()
                                                .setElemType(DataType.INT64_VALUE)
                                                .setShape(TensorShapeProto.newBuilder()
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(1))
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(5)))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();

        try (Session session = environment.newSession().setByteBuffer(model).build();
                Transaction txn = session.newTransaction().build()) {
            float[] rawInputs = new float[] {1092, 20932, 53, 10, 902};
            long[] keys = new long[] {554354, 52345234, 143646, 10, 19};
            OnnxTypedMap<Long> mapInput = txn.addInput(0).asMap().asLongMap();
            mapInput.set(keys[0]).asTensor().getFloatBuffer().put(rawInputs[0]);
            mapInput.set(keys[1]).asTensor().getFloatBuffer().put(rawInputs[1]);
            mapInput.set(keys[2]).asTensor().getFloatBuffer().put(rawInputs[2]);
            mapInput.set(keys[3]).asTensor().getFloatBuffer().put(rawInputs[3]);
            mapInput.set(keys[4]).asTensor().getFloatBuffer().put(rawInputs[4]);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            long[] rawOutput = new long[5];
            output.get(0).asTensor().getLongBuffer().get(rawOutput);
            long[] orderedOut = new long[] {10, 902, 53, 1092, 20932};
            assertArrayEquals(orderedOut, rawOutput);
            LOG.log(Level.INFO, output.get(0));
        }
    }

    private OnnxTensorImpl newTensor(OnnxTensorElementDataType type, long size) {
        return (OnnxTensorImpl) environment.newTensor(type, List.of(size));
    }

    @Test
    public void byteVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.INT8;
        byte[] truth = new byte[] {0x01, 0x02, 0x03};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getByteBuffer().put(truth[0]);
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getByteBuffer().put(truth[1]);
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        vector.getByteBuffer().flip();
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getByteBuffer().get());
        assertEquals(truth[1], outScalar1.getByteBuffer().get());
    }

    @Test
    public void shortVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.INT16;
        short[] truth = new short[] {0x01, 0x02, 0x03};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getShortBuffer().put(truth[0]);
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getShortBuffer().put(truth[1]);
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        vector.getShortBuffer().flip();
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getShortBuffer().get());
        assertEquals(truth[1], outScalar1.getShortBuffer().get());
    }

    @Test
    public void intVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.INT32;
        int[] truth = new int[] {0x01, 0x02, 0x03};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getIntBuffer().put(truth[0]);
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getIntBuffer().put(truth[1]);
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        vector.getIntBuffer().flip();
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getIntBuffer().get());
        assertEquals(truth[1], outScalar1.getIntBuffer().get());
    }

    @Test
    public void longVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.INT64;
        long[] truth = new long[] {0x01, 0x02, 0x03};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getLongBuffer().put(truth[0]);
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getLongBuffer().put(truth[1]);
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        vector.getLongBuffer().flip();
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getLongBuffer().get());
        assertEquals(truth[1], outScalar1.getLongBuffer().get());
    }

    @Test
    public void floatVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.FLOAT;
        float[] truth = new float[] {1, 2, 3};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getFloatBuffer().put(truth[0]);
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getFloatBuffer().put(truth[1]);
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        vector.getFloatBuffer().flip();
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getFloatBuffer().get());
        assertEquals(truth[1], outScalar1.getFloatBuffer().get());
    }

    @Test
    public void doubleVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.DOUBLE;
        double[] truth = new double[] {1, 2, 3};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getDoubleBuffer().put(truth[0]);
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getDoubleBuffer().put(truth[1]);
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        vector.getDoubleBuffer().flip();
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getDoubleBuffer().get());
        assertEquals(truth[1], outScalar1.getDoubleBuffer().get());
    }

    @Test
    public void stringVectorizationTest() {
        OnnxTensorElementDataType type = OnnxTensorElementDataType.STRING;
        String[] truth = new String[] {"foo", "bar", "baz"};
        OnnxTensorImpl inScalar0 = newTensor(type, 1);
        inScalar0.getStringBuffer()[0] = truth[0];
        OnnxTensorImpl inScalar1 = newTensor(type, 1);
        inScalar1.getStringBuffer()[0] = truth[1];
        OnnxTensorImpl vector = newTensor(type, truth.length);
        vector.putScalars(List.of(inScalar0, inScalar1));
        OnnxTensorImpl outScalar0 = newTensor(type, 1);
        OnnxTensorImpl outScalar1 = newTensor(type, 1);
        vector.getScalars(List.of(outScalar0, outScalar1).stream());
        assertEquals(truth[0], outScalar0.getStringBuffer()[0]);
        assertEquals(truth[1], outScalar1.getStringBuffer()[0]);
    }

    @Test
    public void directByteBufferLoadTest() throws IOException {
        ByteBuffer source = identityModel(FLOAT_TYPE);
        ByteBuffer direct = ByteBuffer.allocateDirect(source.remaining());
        direct.put(source).flip();
        try (Session session = environment.newSession().setByteBuffer(direct).build()) {
            assertEquals(1, session.getInputs().size());
        }
    }

    @Test
    public void byteLoadTest() throws IOException {
        ByteBuffer source = identityModel(FLOAT_TYPE);
        byte[] bytes = new byte[source.remaining()];
        source.get(bytes);
        try (Session session = environment.newSession().setByteArray(bytes).build()) {
            assertEquals(1, session.getInputs().size());
        }
    }

    @Test
    public void fileLoadTest() throws IOException {
        ByteBuffer source = identityModel(FLOAT_TYPE);
        byte[] bytes = new byte[source.remaining()];
        source.get(bytes);
        Path f = Files.createTempFile("ort", ".onnx");
        try {
            Files.write(f, bytes);
            try (Session session = environment.newSession().setPath(f).build()) {
                assertEquals(1, session.getInputs().size());
            }
        } finally {
            f.toFile().delete();
        }
    }

    @Test
    public void emptyLoadTest() throws IOException {
        assertThrows(OnnxRuntimeException.class, () -> {
            environment.newSession().setByteArray(new byte[0]).build();
        });
    }

    @Test
    public void missingLoadTest() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            environment.newSession().build();
        });
    }

    @Test
    public void sessionOptionsTest() throws IOException {
        ByteBuffer source = identityModel(FLOAT_TYPE);
        try (Session session = environment
                .newSession()
                .setByteBuffer(source)
                .setExecutionMode(OnnxRuntimeExecutionMode.SEQUENTIAL)
                .setInterOpNumThreads(0)
                .setIntraOpNumThreads(0)
                .setLogId("LOGGER")
                .setLogSeverityLevel(OnnxRuntimeLoggingLevel.VERBOSE)
                .setLogVerbosityLevel(0)
                .addProvider(ExecutionProvider.CPU_EXECUTION_PROVIDER, Map.of("use_arena", "1"))
                .setMemoryPatternOptimization(true)
                .setOptimizationLevel(OnnxRuntimeOptimizationLevel.ENABLE_ALL)
                .setConfigMap(Map.of("foo", "bar", "baz", "boom"))
                .build()) {
            assertEquals(1, session.getInputs().size());
        }
    }

    @Test
    public void runOptionsTest() throws IOException {
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(FLOAT_TYPE))
                        .build();
                Transaction txn = session.newTransaction()
                        .setLogSeverityLevel(OnnxRuntimeLoggingLevel.VERBOSE)
                        .setLogVerbosityLevel(0)
                        .setRunTag("LOGGER")
                        .setConfigMap(Map.of("foo", "bar", "baz", "boom"))
                        .build()) {
            session.setEpDynamicOptions(Map.of("blah", "wham", "whizz", "bang"));
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput("input").asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput("output");
            NamedCollection<OnnxValue> output = txn.run();
            float[] rawOutput = new float[3];
            OnnxValue outputValue = output.get(0);
            OnnxTensor outputTensor = outputValue.asTensor();
            outputTensor.getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            LOG.log(Level.INFO, output.get(0));

            assertThrows(IllegalArgumentException.class, () -> {
                Transaction.Builder t = session.newTransaction();
                t.build().run();
            });
            assertThrows(IllegalArgumentException.class, () -> {
                Transaction t = session.newTransaction().build();
                t.addInput(0);
                t.run();
            });
        }
    }

    @Test
    public void ioBindingTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT32_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(type))
                        .build();
                IoBinding txn = session.newIoBinding()
                        .bindInput(0)
                        .bindInput("input")
                        .bindOutput(0)
                        .bindOutput("output")
                        .setConfigMap(Map.of("foo", "bar"))
                        .build()) {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> session.newIoBinding().bindInput(0).build());
            assertThrows(
                    IllegalArgumentException.class,
                    () -> session.newIoBinding().bindOutput(0).build());
            assertThrows(
                    IllegalArgumentException.class,
                    () -> session.newIoBinding().bindOutput("not_an_output").build());
            txn.setLogSeverityLevel(OnnxRuntimeLoggingLevel.INFO);
            txn.setLogVerbosityLevel(0);
            txn.setRunTag("foo");
            IntBuffer inputBuf = txn.getInputs().get(0).asTensor().getIntBuffer();
            IntBuffer outputBuf = txn.getOutputs().get(0).asTensor().getIntBuffer();
            int[] rawOutput = new int[3];
            for (int i = 0; i < 100; i++) {
                int[] rawInput = new int[] {
                    ThreadLocalRandom.current().nextInt(),
                    ThreadLocalRandom.current().nextInt(),
                    ThreadLocalRandom.current().nextInt()
                };
                inputBuf.clear().put(rawInput);
                txn.synchronizeBoundInputs();
                txn.run();
                txn.synchronizeBoundOutputs();
                outputBuf.rewind().get(rawOutput);
                assertArrayEquals(rawInput, rawOutput);
            }
        }
    }

    @Test
    public void optimizationTest() throws IOException {
        File file = File.createTempFile("ort-optimized", ".onnx");
        try {
            assertEquals(0, file.length());
            try (Session session = environment
                    .newSession()
                    .setByteBuffer(identityModel(FLOAT_TYPE))
                    .setOptimizationOutputPath(file.toPath())
                    .setOptimizationLevel(OnnxRuntimeOptimizationLevel.ENABLE_BASIC)
                    .build()) {
                assertEquals(1, session.getInputs().size());
            }
            assertTrue(file.exists());
            assertTrue(file.length() > 0);
        } finally {
            file.delete();
        }
    }

    @Test
    public void profilingTest() throws IOException {
        Path f = Files.createTempFile("ort", ".onnx");
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(FLOAT_TYPE))
                        .setProfilingOutputPath(f)
                        .build();
                Transaction txn = session.newTransaction().build()) {
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            float[] rawOutput = new float[3];
            OnnxValue outputValue = output.get(0);
            assertThrows(NoSuchElementException.class, () -> outputValue.asSequence());
            OnnxTensor outputTensor = outputValue.asTensor();
            outputTensor.getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
            long startNs = session.getProfilingStartTimeInNs();
            assertTrue(startNs > 0L);
            File out = session.endProfiling().toFile();
            assertTrue(out.length() > 0);
            out.delete();
        }
    }

    @Test
    @EnabledOnOs(value = OS.MAC, architectures = "x86_64")
    public void customOpTest() throws Exception {
        Path f = Path.of(getClass().getResource("/libcustom_op_library.dylib").toURI());
        try (Session session = environment
                        .newSession()
                        .setByteBuffer(identityModel(FLOAT_TYPE))
                        .addCustomOpsLibrary(f)
                        .build();
                Transaction txn = session.newTransaction().build()) {
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.run();
            float[] rawOutput = new float[3];
            OnnxValue outputValue = output.get(0);
            assertThrows(NoSuchElementException.class, () -> outputValue.asSequence());
            OnnxTensor outputTensor = outputValue.asTensor();
            outputTensor.getFloatBuffer().get(rawOutput);
            assertArrayEquals(rawInput, rawOutput);
        }
    }

    private void providerTest(ExecutionProvider executionProvider, Map<String, String> config) throws Exception {
        Session.Builder session = environment
                .newSession()
                .setByteBuffer(identityModel(FLOAT_TYPE))
                .addProvider(executionProvider, config);
        assertTrue(executionProvider.isSupported());
        if (api.getAvailableProviders().contains(executionProvider)) {
            session.build().close();
        } else {
            OnnxRuntimeException e = assertThrows(OnnxRuntimeException.class, () -> session.build());
            String message = e.getMessage();
            LOG.log(Level.ERROR, "Provider failed with: " + message);
            assertTrue(message.contains("not enabled in this build")
                    || message.contains("not supported in this build")
                    || message.contains("Failed to load shared library")
                    || message.contains("onnxruntime::ProviderSharedLibrary")
                    || message.contains("onnxruntime::ProviderLibrary"));
        }
    }

    @Test
    public void cudaTest() throws Exception {
        providerTest(ExecutionProvider.CUDA_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    @EnabledOnOs({OS.MAC})
    public void coreMLTest() throws Exception {
        providerTest(ExecutionProvider.COREML_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void tensorRtTest() throws Exception {
        providerTest(ExecutionProvider.TENSORRT_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void miGraphXTest() throws Exception {
        providerTest(ExecutionProvider.MIGRAPHX_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void openVINOTest() throws Exception {
        providerTest(ExecutionProvider.OPENVINO_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void rocmTest() throws Exception {
        providerTest(ExecutionProvider.ROCM_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void dnnlTest() throws Exception {
        providerTest(ExecutionProvider.DNNL_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void snpeTest() throws Exception {
        providerTest(ExecutionProvider.SNPE_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void xnnpackTest() throws Exception {
        providerTest(ExecutionProvider.XNNPACK_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }

    @Test
    public void qnnTest() throws Exception {
        providerTest(ExecutionProvider.QNN_EXECUTION_PROVIDER, Map.of("device_id", "0"));
    }
}
