package miniplc0java.instructioner;

import java.util.Arrays;

public class ChangeToByte {
	public static byte[] intToByte(int in) {
		byte[] byteNum = new byte[4];
		for (int ix = 0; ix < 4; ++ix) {
			int offset = 32 - (ix + 1) * 8;
			byteNum[ix] = (byte) ((in >> offset) & 0xff);
		}
		return byteNum;
	}

	public static byte[] longToByte(long in) {
		byte[] byteNum = new byte[8];
		for (int ix = 0; ix < 8; ++ix) {
			int offset = 64 - (ix + 1) * 8;
			byteNum[ix] = (byte) ((in >> offset) & 0xff);
		}
		return byteNum;
	}


	public static byte[] concat(byte[] isCount, byte[] bs) {
		byte[] result = Arrays.copyOf(isCount, isCount.length + bs.length);
		System.arraycopy(bs, 0, result, isCount.length, bs.length);
		return result;
	}
}
