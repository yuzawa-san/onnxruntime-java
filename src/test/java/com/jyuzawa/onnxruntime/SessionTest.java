/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
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
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SessionTest {

    private static final Charset UTF8 = Charset.forName("utf-8");
    private static Environment environment;

    @BeforeClass
    public static void setup() {
        OnnxRuntime apiBase = OnnxRuntime.get();
        Api api = apiBase.getApi();
        environment = api.newEnvironment()
                .setLogSeverityLevel(OnnxRuntimeLoggingLevel.VERBOSE)
                .build();
    }

    @AfterClass
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
        try (Session session =
                environment.newSession().setByteBuffer(byteBuffer).build()) {
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
    public void floatTest() throws IOException {
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.FLOAT_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(3))))
                .build();
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            float[] rawOutput = new float[3];
            OnnxValue outputValue = output.get(0);
            assertThrows(NoSuchElementException.class, () -> outputValue.asMap());
            assertThrows(NoSuchElementException.class, () -> outputValue.asSequence());
            OnnxTensor outputTensor = outputValue.asTensor();
            assertThrows(NoSuchElementException.class, () -> outputTensor.getByteBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getShortBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getIntBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getDoubleBuffer());
            assertThrows(NoSuchElementException.class, () -> outputTensor.getLongBuffer());
            outputTensor.getFloatBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            double[] rawInput = new double[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getDoubleBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            double[] rawOutput = new double[3];
            output.get(0).asTensor().getDoubleBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            byte[] rawInput = new byte[] {4, 3, 2};
            txn.addInput(0).asTensor().getByteBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            byte[] rawOutput = new byte[3];
            output.get(0).asTensor().getByteBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            short[] rawInput = new short[] {4, 3, 2};
            txn.addInput(0).asTensor().getShortBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            short[] rawOutput = new short[3];
            output.get(0).asTensor().getShortBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            int[] rawInput = new int[] {4, 3, 2};
            txn.addInput(0).asTensor().getIntBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            int[] rawOutput = new int[3];
            output.get(0).asTensor().getIntBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            long[] rawInput = new long[] {4, 3, 2};
            txn.addInput(0).asTensor().getLongBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            long[] rawOutput = new long[3];
            output.get(0).asTensor().getLongBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            String[] rawInput = txn.addInput(0).asTensor().getStringBuffer();
            rawInput[0] = "foo";
            rawInput[1] = "bar";
            rawInput[2] = "boom";
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            String[] rawOutput = output.get(0).asTensor().getStringBuffer();
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session =
                environment.newSession().setByteBuffer(identityModel(type)).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInput1 = new float[] {554354, 52345234, 143646};
            float[] rawInput2 = new float[] {5234, 1436, 613};
            OnnxSequence inputSequence = txn.addInput(0).asSequence();
            inputSequence.add().asTensor().getFloatBuffer().put(rawInput1);
            inputSequence.add().asTensor().getFloatBuffer().put(rawInput2);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            float[] outputBuffer = new float[3];
            OnnxValue outputValue = output.get(0);
            assertThrows(NoSuchElementException.class, () -> outputValue.asMap());
            assertThrows(NoSuchElementException.class, () -> outputValue.asTensor());
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
            assertTrue(Arrays.equals(rawInput1, outputBuffer));
            outputSequence.get(1).asTensor().getFloatBuffer().get(outputBuffer);
            assertTrue(Arrays.equals(rawInput2, outputBuffer));
            System.out.println(output.get(0));
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
        try (Session session = environment.newSession().setByteBuffer(model).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            OnnxTypedMap<Long> outputMap =
                    output.get(0).asSequence().get(0).asMap().asLongMap();
            float[] rawOutput = new float[3];
            rawOutput[0] = outputMap.get(1435L).asTensor().getFloatBuffer().get();
            rawOutput[1] = outputMap.get(35234L).asTensor().getFloatBuffer().get();
            rawOutput[2] = outputMap.get(572457L).asTensor().getFloatBuffer().get();
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
        try (Session session = environment.newSession().setByteBuffer(model).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
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
            assertTrue(Arrays.equals(rawInput, rawOutput));
            System.out.println(output.get(0));
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
                                        .setS(ByteString.copyFrom("TO_STRING", UTF8))))
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
                                                                .setDimValue(5)))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build()) {
            Transaction.Builder txn = session.newTransaction();
            String[] rawInputs = new String[] {"fsaf", "fa3sf", "fe", "ab", "xr"};
            long[] keys = new long[] {554354, 52345234, 143646, 10, 19};
            OnnxTypedMap<Long> mapInput = txn.addInput(0).asMap().asLongMap();
            mapInput.set(keys[0]).asTensor().getStringBuffer()[0] = rawInputs[0];
            mapInput.set(keys[1]).asTensor().getStringBuffer()[0] = rawInputs[1];
            mapInput.set(keys[2]).asTensor().getStringBuffer()[0] = rawInputs[2];
            mapInput.set(keys[3]).asTensor().getStringBuffer()[0] = rawInputs[3];
            mapInput.set(keys[4]).asTensor().getStringBuffer()[0] = rawInputs[4];
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            String[] rawOutput = output.get(0).asTensor().getStringBuffer();
            String[] orderedOut = new String[] {"ab", "xr", "fe", "fsaf", "fa3sf"};
            assertTrue(Arrays.equals(orderedOut, rawOutput));
            System.out.println(output.get(0));
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
                                        .setS(ByteString.copyFrom("TO_INT64", UTF8))))
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
                                                                .setDimValue(5)))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInputs = new float[] {1092, 20932, 53, 10, 902};
            long[] keys = new long[] {554354, 52345234, 143646, 10, 19};
            OnnxTypedMap<Long> mapInput = txn.addInput(0).asMap().asLongMap();
            mapInput.set(keys[0]).asTensor().getFloatBuffer().put(rawInputs[0]);
            mapInput.set(keys[1]).asTensor().getFloatBuffer().put(rawInputs[1]);
            mapInput.set(keys[2]).asTensor().getFloatBuffer().put(rawInputs[2]);
            mapInput.set(keys[3]).asTensor().getFloatBuffer().put(rawInputs[3]);
            mapInput.set(keys[4]).asTensor().getFloatBuffer().put(rawInputs[4]);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            long[] rawOutput = new long[5];
            output.get(0).asTensor().getLongBuffer().get(rawOutput);
            long[] orderedOut = new long[] {10, 902, 53, 1092, 20932};
            assertTrue(Arrays.equals(orderedOut, rawOutput));
            System.out.println(output.get(0));
        }
    }

    @Test
    public void castMapFloatTest() throws IOException {
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
                                        .setS(ByteString.copyFrom("TO_FLOAT", UTF8))))
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
                                                .setElemType(DataType.FLOAT_VALUE)
                                                .setShape(TensorShapeProto.newBuilder()
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(5)))))))
                .build();
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInputs = new float[] {1092, 20932, 53, 10, 902};
            long[] keys = new long[] {554354, 52345234, 143646, 10, 19};
            OnnxTypedMap<Long> mapInput = txn.addInput(0).asMap().asLongMap();
            mapInput.set(keys[0]).asTensor().getFloatBuffer().put(rawInputs[0]);
            mapInput.set(keys[1]).asTensor().getFloatBuffer().put(rawInputs[1]);
            mapInput.set(keys[2]).asTensor().getFloatBuffer().put(rawInputs[2]);
            mapInput.set(keys[3]).asTensor().getFloatBuffer().put(rawInputs[3]);
            mapInput.set(keys[4]).asTensor().getFloatBuffer().put(rawInputs[4]);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            float[] rawOutput = new float[5];
            output.get(0).asTensor().getFloatBuffer().get(rawOutput);
            float[] orderedOut = new float[] {10, 902, 53, 1092, 20932};
            assertTrue(Arrays.equals(orderedOut, rawOutput));
            System.out.println(output.get(0));
        }
    }
}
