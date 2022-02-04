/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Collection;
import java.util.List;
import java.util.Map;

final class TransactionImpl implements Transaction {

    private final Map<String, float[]> inputs;
    private final List<String> outputs;

    public TransactionImpl(Map<String, float[]> inputs, List<String> outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public Map<String, float[]> getInputs() {
        return inputs;
    }

    @Override
    public Collection<String> getOutputs() {
        return outputs;
    }
}
