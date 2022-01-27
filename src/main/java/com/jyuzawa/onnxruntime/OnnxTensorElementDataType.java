package com.jyuzawa.onnxruntime;

public enum OnnxTensorElementDataType {
	
	UNDEFINED(0),
	FLOAT(1),
	UINT8(2),
	INT8(3),
	UINT16(4),
	INT16(5),
	INT32(6),
	INT64(7),
	STRING(8),
	BOOL(9),
	FLOAT16(10),
	DOUBLE(11),
	UINT32(12),
	UINT64(13),
	COMPLEX64(14),
	COMPLEX128(15),
	BFLOAT16(16);

	private final int number; 
	private OnnxTensorElementDataType(int number) {
		this.number= number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public static final OnnxTensorElementDataType forNumber(int number) {
		switch(number) {
		case 1: return FLOAT;
		case 2: return UINT8;
		case 3: return INT8;
		case 4: return UINT16;
		case 5: return INT16;
		case 6: return INT32;
		case 7: return INT64;
		case 8: return STRING;
		case 9: return BOOL;
		case 10: return FLOAT16;
		case 11: return DOUBLE;
		case 12: return UINT32;
		case 13: return UINT64;
		case 14: return COMPLEX64;
		case 15: return COMPLEX128;
		case 16: return BFLOAT16;
		case 0:
		default:
			return UNDEFINED;
		}
	}
	
}
