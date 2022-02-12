/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.Arrays;
import onnx.OnnxMl.GraphProto;
import onnx.OnnxMl.ModelProto;
import onnx.OnnxMl.NodeProto;
import onnx.OnnxMl.OperatorSetIdProto;
import onnx.OnnxMl.StringStringEntryProto;
import onnx.OnnxMl.TensorProto.DataType;
import onnx.OnnxMl.TensorShapeProto;
import onnx.OnnxMl.TensorShapeProto.Dimension;
import onnx.OnnxMl.TypeProto;
import onnx.OnnxMl.TypeProto.Tensor;
import onnx.OnnxMl.ValueInfoProto;
import org.junit.Test;

public class TensorTest {

    @Test
    public void test() throws IOException {
        System.load(
                "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/build/jnioutput/META-INF/native/libonnxruntime.jnilib");
        ApiBase apiBase = ApiBase.get();
        System.out.println(apiBase.getVersion());
        Api api = apiBase.getApi();
        try (Environment environment =
                api.newEnvironment().setLogSeverityLevel(OrtLoggingLevel.ERROR).build()) {
            byte[] b = ModelProto.newBuilder()
                    .setIrVersion(8)
                    .setModelVersion(100)
                    .setDocString("fasjdf")
                    .addMetadataProps(
                            StringStringEntryProto.newBuilder().setKey("foo").setValue("bar"))
                    .addMetadataProps(
                            StringStringEntryProto.newBuilder().setKey("baz").setValue("boom"))
                    .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(10))
                    .setGraph(GraphProto.newBuilder()
                            .addNode(NodeProto.newBuilder()
                                    .addInput("input")
                                    .addOutput("output")
                                    .setOpType("Identity"))
                            .addInput(ValueInfoProto.newBuilder()
                                    .setName("input")
                                    .setType(TypeProto.newBuilder()
                                            .setTensorType(Tensor.newBuilder()
                                                    .setElemType(DataType.FLOAT_VALUE)
                                                    .setShape(TensorShapeProto.newBuilder()
                                                            .addDim(Dimension.newBuilder()
                                                                    .setDimValue(1))
                                                            .addDim(Dimension.newBuilder()
                                                                    .setDimValue(3))))))
                            .addOutput(ValueInfoProto.newBuilder()
                                    .setName("input")
                                    .setType(TypeProto.newBuilder()
                                            .setTensorType(Tensor.newBuilder()
                                                    .setElemType(DataType.FLOAT_VALUE)
                                                    .setShape(TensorShapeProto.newBuilder()
                                                            .addDim(Dimension.newBuilder()
                                                                    .setDimValue(1))
                                                            .addDim(Dimension.newBuilder()
                                                                    .setDimValue(3)))))))
                    .build()
                    .toByteArray();
            try (Session session = environment.newSession().setByteArray(b).build()) {
                System.out.println(session.getInputs());
                System.out.println(session.getOutputs());
                System.out.println(session.getOverridableInitializers());
                System.out.println(session.getModelMetadata());
                System.out.println(session.getModelMetadata().getDescription());
                System.out.println(session.getModelMetadata().getDomain());
                System.out.println(session.getModelMetadata().getGraphDescription());
                System.out.println(session.getModelMetadata().getGraphName());
                System.out.println(session.getModelMetadata().getProducerName());
                System.out.println(session.getModelMetadata().getVersion());
                System.out.println(session.getModelMetadata().getCustomMetadata());
                for (int i = 0; i < 10; i++) {
                    // session.newTransaction().addInput().addOutput().run();
                    Transaction.Builder txn = session.newTransaction();
                    txn.addInput(0).asTensor().getFloatBuffer().put(new float[] {6195379, 28388, 4700000});
                    txn.addOutput(0);
                    NamedCollection<OnnxValue> output = txn.build().run();
                    FloatBuffer out = output.get(0).asTensor().getFloatBuffer();
                    System.out.println(Arrays.toString(out.array()));
                }
            }
        }
        System.out.flush();
        System.err.flush();
        System.out.println("done");

        ModelProto.newBuilder()
                .setIrVersion(8)
                .addOpsetImport(OperatorSetIdProto.newBuilder().setVersion(10))
                .setGraph(GraphProto.newBuilder()
                        .addNode(NodeProto.newBuilder()
                                .addInput("input")
                                .addOutput("output")
                                .setOpType("Identity"))
                        .addInput(ValueInfoProto.newBuilder()
                                .setName("input")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder()
                                                .setElemType(DataType.FLOAT_VALUE)
                                                .setShape(TensorShapeProto.newBuilder()
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(1))
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(3))))))
                        .addOutput(ValueInfoProto.newBuilder()
                                .setName("input")
                                .setType(TypeProto.newBuilder()
                                        .setTensorType(Tensor.newBuilder()
                                                .setElemType(DataType.FLOAT_VALUE)
                                                .setShape(TensorShapeProto.newBuilder()
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(1))
                                                        .addDim(Dimension.newBuilder()
                                                                .setDimValue(3)))))))
                .build();
    }
}
