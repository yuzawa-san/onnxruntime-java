package com.jyuzawa.onnxruntime;

public enum OnnxRuntimeExecutionMode {
	SEQUENTIAL(0),
    PARALLEL(1);


    private final int number;

    private OnnxRuntimeExecutionMode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static final OnnxRuntimeExecutionMode forNumber(int number) {
        switch (number) {
            case 1:
                return PARALLEL;
            case 0:
            default:
                return SEQUENTIAL;
        }
    }
}
