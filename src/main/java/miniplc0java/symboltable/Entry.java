package symboltable;

import util.Pos;

public class Entry {
	public SymbolType symboltype;//符号类型
	public DataType datatype;//数据类型
	public String name;//名称
	public int level;//层数
	public int offset;//当前层的偏移
	public Pos pos;//错误位置
	
	Entry(String name, SymbolType symboltype, DataType datatype, int level, int offset, Pos pos){
		this.name = name;
		this.symboltype = symboltype;
		this.datatype = datatype;
		this.level = level;
		this.offset = offset;
		this.pos = pos;
	}
}
