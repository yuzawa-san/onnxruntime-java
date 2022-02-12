/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Map;
import org.junit.Test;

public class RunIt {

    @Test
    public void test() throws FileNotFoundException, IOException, InterruptedException {
        System.load(
                "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/build/jnioutput/META-INF/native/libonnxruntime.jnilib");
        ApiBase apiBase = ApiBase.get();
        System.out.println(apiBase.getVersion());
        Api api = apiBase.getApi();
        try (Environment environment =
                api.newEnvironment().setLogSeverityLevel(OrtLoggingLevel.ERROR).build()) {
            File f = new File(
                    "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/src/test/resources/mmo_model.onnx");
            byte[] b = Files.readAllBytes(f.toPath());
            try (Session session = environment.newSession().setPath(f.toPath()).build()) {
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
                for (int i = 0; i < 10000; i++) {
                    // session.newTransaction().addInput().addOutput().run();
                    Transaction.Builder txn = session.newTransaction();
                    txn.addInput(0).asTensor().getFloatBuffer().put(new float[] {6195379, 28388, 4700000});
                    OnnxSequence sequence = txn.addInput(0).asSequence();
                    sequence.add().asTensor().getFloatBuffer().put(315);
                    sequence.add().asTensor().getFloatBuffer().put(23);
                    OnnxMap<Long> map = txn.addInput(0).asLongMap();
                    map.put(15115L).asTensor().getFloatBuffer().put(315);
                    txn.addInput(0).asOpaque().set(ByteBuffer.wrap(new byte[] {}));
                    txn.addInput(0)
                            .asOptional()
                            .set()
                            .asTensor()
                            .getFloatBuffer()
                            .put(315);
                    txn.addOutput(0);
                    NamedCollection<OnnxValue> output = txn.build().run();
                    System.out.println(output.get(0).asTensor().getFloatBuffer().get());
                    OnnxSequence sequenceOut = output.get(0).asSequence();
                    for (OnnxValue value : sequenceOut) {
                        value.asTensor().getFloatBuffer().get();
                    }
                    OnnxMap<Long> mapOut = output.get(0).asLongMap();
                    for (Map.Entry<Long, OnnxValue> entry : mapOut.entrySet()) {
                        entry.getValue().asTensor().getFloatBuffer().get();
                    }
                    output.get(0).asOpaque().get().get();
                    OnnxOptional optionalOut = output.get(0).asOptional();
                    if (optionalOut.isPresent()) {
                        optionalOut.get().asTensor().getFloatBuffer().get();
                    }
                }
            }
        }
        System.out.flush();
        System.err.flush();
        System.out.println("done");
    }
}
