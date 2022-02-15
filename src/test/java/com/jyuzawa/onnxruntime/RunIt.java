/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.Test;

public class RunIt {

    @Test
    public void test() throws FileNotFoundException, IOException, InterruptedException {
        ApiBase apiBase = ApiBase.get();
        System.out.println(apiBase.getVersion());
        Api api = apiBase.getApi();
        try (Environment environment =
                api.newEnvironment().setLogSeverityLevel(OrtLoggingLevel.ERROR).build()) {
            File f = new File(
                    "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/src/test/resources/mmo_model.onnx");
            byte[] b = Files.readAllBytes(f.toPath());
            try (Session session = environment.newSession().setPath(f.toPath()).build()) {
                for (int i = 0; i < 10000; i++) {
                    // session.newTransaction().addInput().addOutput().run();
                    Transaction.Builder txn = session.newTransaction();
                    txn.addInput(0).asTensor().getFloatBuffer().put(new float[] {6195379, 28388, 4700000});
                    txn.addOutput(0);
                    NamedCollection<OnnxValue> output = txn.build().run();
                    System.out.println(output.get(0).asTensor().getFloatBuffer().get());
                }
            }
        }
    }
}
