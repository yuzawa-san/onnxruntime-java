/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import java.util.Arrays;
import java.util.List;
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

public final class Benchmark {

    public static final void main(String[] args) throws Exception {
        long[] input = new long[] {1, 2, 3};
        TypeProto type = TypeProto.newBuilder()
                .setTensorType(Tensor.newBuilder()
                        .setElemType(DataType.INT64_VALUE)
                        .setShape(TensorShapeProto.newBuilder()
                                .addDim(Dimension.newBuilder().setDimValue(1))
                                .addDim(Dimension.newBuilder().setDimValue(input.length))))
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
        List<Wrapper> wrappers = List.of(new OnnxruntimeJava(bytes, false), new Microsoft(bytes));
        long i = 0;
        long startMs = System.currentTimeMillis();
        while (i >= 0) {
            for (Wrapper wrapper : wrappers) {
                long[] output = wrapper.evaluate(input);
                if (!Arrays.equals(input, output)) {
                    throw new RuntimeException("mismatch");
                }
            }
            if (i % 10000 == 0) {
                if (System.currentTimeMillis() - startMs > 60000) {
                    break;
                }
            }
            i++;
        }
    }
}
