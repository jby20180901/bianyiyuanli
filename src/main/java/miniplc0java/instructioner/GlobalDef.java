package miniplc0java.instructioner;

import miniplc0java.symboltable.FunctionEntry;

import java.util.Arrays;

public class GlobalDef {
	// 是否为常量？非零值视为真
	byte is_const ;
	boolean is_Const;
	// 数组的长度
	int count;
	// 值
	byte items[];
	//值
	Object item;
	/**
	 * 函数名 转 byte[]
	 * @param isConst
	 * @param Func
	 */
	public GlobalDef(boolean isConst, FunctionEntry Func) {
		String FuncName = Func.name;
		this.is_const = (byte) (isConst?1:0);
		this.count = FuncName.length();
		this.items = new byte[count];
		this.items = FuncName.getBytes();
		this.item = FuncName;
	}

	/**
	 * String 转 byte[]
	 * @param isConst
	 * @param outStr
	 */
	public GlobalDef(boolean isConst, String outStr) {
		this.is_const = (byte) (isConst?1:0);
		this.count = outStr.length();
		this.items = new byte[count];
		this.items = outStr.getBytes();
		this.item = outStr;
	}

	/**
	 * char(实际是int) 转 byte[]
	 * @param isConst
	 * @param outChar
	 */
	public GlobalDef(boolean isConst, char outChar) {
		this.is_Const = isConst;
		long charValue = (long) outChar;
		this.is_const = (byte) (isConst?1:0);
		this.count = 8;
		this.items = new byte[count];
		for (int ix = 0; ix < 8; ++ix) {
			int offset = 64 - (ix + 1) * 8;
			this.items[ix] = (byte) ((charValue >> offset) & 0xff);
		}
		this.item = outChar;
	}

	/**
	 * int 转 byte[]
	 * @param isConst
	 * @param longNum
	 */
	public GlobalDef(boolean isConst, long longNum) {
		this.is_const = (byte) (isConst?1:0);
		this.count = 8;
		this.items = new byte[count];
		for (int ix = 0; ix < 8; ++ix) {
			int offset = 64 - (ix + 1) * 8;
			this.items[ix] = (byte) ((longNum >> offset) & 0xff);
		}
		this.item = longNum;
	}

	/**
	 * double 转 byte[]
	 * @param isConst
	 * @param doubleNum
	 */
	public GlobalDef(boolean isConst, double doubleNum) {
		long doubleValue = Double.doubleToRawLongBits(doubleNum);
		this.is_const = (byte) (isConst?1:0);
		this.count = 8;
		this.items = new byte[count];
		for (int i = 0; i < 8; i++) {
			this.items[i] = (byte) ((doubleValue >> 8 * i) & 0xff);
		}
		this.item = doubleNum;
	}

	@Override
	public String toString() {
		String ret = String.format("%02x",(is_Const?0:1)) + " //is_count\n"
				+ String.format("%08x",count) + "//value.count\n" ;
		if (this.item instanceof String) {
			ret += (String)this.item;
		}
		else {
			for(int i = 0; i < this.items.length; i ++){
				ret += this.items[i];
			}
		}
		ret += "\n";
		return ret;
	}

	public byte[] toByte() {
		byte[] isCount = new byte[1];
		isCount[0] = is_const;
		return ChangeToByte.concat(ChangeToByte.concat(isCount,ChangeToByte.intToByte(count)),items);
	}
}