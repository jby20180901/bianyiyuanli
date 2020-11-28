package miniplc0java.symboltable;

import util.Pos;

public class Entry {
	public SymbolType symboltype;//��������
	public DataType datatype;//��������
	public String name;//����
	public int level;//����
	public int offset;//��ǰ���ƫ��
	public Pos pos;//����λ��
	
	Entry(String name, SymbolType symboltype, DataType datatype, int level, int offset, Pos pos){
		this.name = name;
		this.symboltype = symboltype;
		this.datatype = datatype;
		this.level = level;
		this.offset = offset;
		this.pos = pos;
	}
}
