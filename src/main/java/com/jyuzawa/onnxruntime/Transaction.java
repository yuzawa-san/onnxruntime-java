/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A representation of a model evaluation. Should NOT be reused.
 *
 */
public interface Transaction {
    /**
     * Run the model evaluation.
     * @return the results
     */
    NamedCollection<OnnxValue> run();
    
    void cancel();

    /**
     * A builder of a {@link Transaction}.
     *
     */
    public interface Builder {
        OnnxValue addInput(String name);

        OnnxValue addInput(int index);

        Builder addOutput(String name);

        Builder addOutput(int index);
        
        Builder setLogLevel​(OrtLoggingLevel level);
        
        Builder setLogVerbosityLevel​(int level);
        
        Builder setRunTag​(java.lang.String runTag);
        


        // TODO: more run options
        /**
         * Construct a {@link Transaction}.
         * @return a new instance
         */
        Transaction build();
    }
}
