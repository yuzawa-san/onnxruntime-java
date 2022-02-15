/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
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

    private static Environment environment;

    @BeforeClass
    public static void setup() {
        ApiBase apiBase = ApiBase.get();
        Api api = apiBase.getApi();
        environment = api.newEnvironment()
                .setLogSeverityLevel(OrtLoggingLevel.VERBOSE)
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
            output.get(0).asTensor().getFloatBuffer().get(rawOutput);
            assertTrue(Arrays.equals(rawInput, rawOutput));
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
            OnnxSequence outputSequence = output.get(0).asSequence();
            assertEquals(2, outputSequence.size());
            outputSequence.get(0).asTensor().getFloatBuffer().get(outputBuffer);
            assertTrue(Arrays.equals(rawInput1, outputBuffer));
            outputSequence.get(1).asTensor().getFloatBuffer().get(outputBuffer);
            assertTrue(Arrays.equals(rawInput2, outputBuffer));
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
        System.out.println(modelProto);
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
        System.out.println(modelProto);
        ByteBuffer model = modelProto.toByteString().asReadOnlyByteBuffer();
        try (Session session = environment.newSession().setByteBuffer(model).build()) {
            Transaction.Builder txn = session.newTransaction();
            float[] rawInput = new float[] {554354, 52345234, 143646};
            txn.addInput(0).asTensor().getFloatBuffer().put(rawInput);
            txn.addOutput(0);
            NamedCollection<OnnxValue> output = txn.build().run();
            OnnxTypedMap<String> outputMap =
                    output.get(0).asSequence().get(0).asMap().asStringMap();
            float[] rawOutput = new float[3];
            rawOutput[0] = outputMap.get("foo").asTensor().getFloatBuffer().get();
            rawOutput[1] = outputMap.get("bazz").asTensor().getFloatBuffer().get();
            rawOutput[2] = outputMap.get("barss").asTensor().getFloatBuffer().get();
            assertTrue(Arrays.equals(rawInput, rawOutput));
        }
    }
}
