package com.jyuzawa.onnxruntime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;

public class RunIt {

  @Test
  public void test() throws FileNotFoundException, IOException, InterruptedException {
    System.load(
        "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib");
    ApiBase apiBase = ApiBase.get();
    System.out.println(apiBase.getVersion());
    Api api = apiBase.getApi();
    try (Environment environment = api.newEnvironment().build()) {
      File f =
          new File(
              "/Users/jtyuzawa/Documents/personal_repos/onnxruntime-java/src/test/resources/mmo_model.onnx");
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

        Transaction txn =
            Transaction.newBuilder()
                .addInput("float_input", new float[] {6195379, 28388, 4700000})
                .addOutput("variable")
                .build();

        session.run(txn);
      }
    }
    System.out.println("done");
  }
}
