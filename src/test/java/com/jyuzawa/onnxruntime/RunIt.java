/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import org.junit.Test;

public class RunIt {

    @Test
    public void test() throws FileNotFoundException, IOException, InterruptedException {
        System.load(
                "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/build/jnioutput/META-INF/native/libonnxruntime.jnilib");
        ApiBase apiBase = ApiBase.get();
        System.out.println(apiBase.getVersion());
        Api api = apiBase.getApi();
        try (Environment environment = api.newEnvironment().build()) {
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

                // session.newTransaction().addInput().addOutput().run();
                Transaction.Builder txn = session.newTransaction();
                NodeInfo inputNode = session.getInputs().get(0);
                FloatBuffer xxx = txn.addInput(inputNode).asTensor().getFloatBuffer();
                //                xxx.put(0);
                //                xxx.put(24603);
                //                xxx.put(100000);
                xxx.put(new float[] {6195379, 28388, 4700000});
                NodeInfo outputNode = session.getOutputs().get(0);
                txn.addOutput(outputNode);
                NamedCollection<OnnxValue> output = txn.build().run();
                System.out.println(output.get(0).asTensor().getFloatBuffer().get());
            }
        }
        System.out.flush();
        System.err.flush();
        System.out.println("done");
    }
}
