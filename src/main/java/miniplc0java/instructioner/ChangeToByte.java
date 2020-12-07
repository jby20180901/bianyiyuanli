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

	public static byte[] doubleToByte(double in) {
		long value = Double.doubleToRawLongBits(in);
		byte[] byteNum = new byte[8];
		for (int ix = 0; ix < 8; ++ix) {
			int offset = 64 - (ix + 1) * 8;
			byteNum[ix] = (byte) ((value >> offset) & 0xff);
		}
		return byteNum;
	}

	public static long bytesToLong(byte[] bs){
		int bytes = bs.length;
		switch(bytes) {
			case 0:
				return 0;
			case 1:
				return (long) ((bs[0] & 0xff));
			case 2:
				return (long) ((bs[0] & 0xff) << 8 | (bs[1] & 0xff));
			case 4:
				return (long) ((bs[0] & 0xffL) << 24 | (bs[1] & 0xffL) << 16 | (bs[2] & 0xffL) << 8 | (bs[3] & 0xffL));
			case 8:
				return (long) ((bs[0] & 0xffL) << 56 | (bs[1] & 0xffL) << 48 | (bs[2] & 0xffL) << 40 | (bs[3] & 0xffL) << 32 |
						(bs[4] & 0xffL) << 24 | (bs[5] & 0xffL) << 16 | (bs[6] & 0xffL) << 8 | (bs[7] & 0xffL));
			default:
				return (long)0;
		}
	}

	public static byte[] concat(byte[] isCount, byte[] bs) {
		byte[] result = Arrays.copyOf(isCount, isCount.length + bs.length);
		System.arraycopy(bs, 0, result, isCount.length, bs.length);
		return result;
	}
}
