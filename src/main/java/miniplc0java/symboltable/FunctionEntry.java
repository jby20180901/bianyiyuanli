package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

import error.AnalyzeError;
import error.ErrorCode;
import util.Pos;

public class FunctionEntry extends Entry{
	private HashMap<String, VarEntry> argsMap;//参数表
	private ArrayList<VarEntry> argsList;//参数表
	private int varOffset;//函数内部偏移
	
	public FunctionEntry(String name, SymbolType symboltype, DataType datatype, int level, int offset, Pos pos) {
		super(name,symboltype,datatype,level,offset,pos);
		this.argsMap = new HashMap<>();
		this.argsList = new ArrayList<>();
	}
	
	public void addArgs(String name,VarEntry var) throws AnalyzeError{
		if(argsMap.containsKey(name)) {
			throw new AnalyzeError(ErrorCode.DuplicateDeclaration,this.pos);
		}
		argsMap.put(name, var);
		argsList.add(var);
	}
	
	public DataType getArgData(int index) {
		if(index >= getSize()) {
			return null;
		}
		return argsList.get(index).datatype;
	}
	
	public int getSize() {
		return argsMap.size();
	}
	
	public int getVarOffset() {
		return varOffset;
	}
	
	public void setVarOffset(int newOffset) {
		this.varOffset = newOffset;
	}
}
