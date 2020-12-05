package miniplc0java.symboltable;

import java.util.ArrayList;
import java.util.HashMap;

import miniplc0java.error.AnalyzeError;
import miniplc0java.error.ErrorCode;
import miniplc0java.util.Pos;

public class FunctionEntry extends Entry{
	private HashMap<String, VarEntry> argsMap;//参数表
	private ArrayList<VarEntry> argsList;//参数表
	private int varOffset;//函数内部参数偏移

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

	public VarEntry findArgs(String name){
		return argsMap.get(name);
	}

	public int findArgsID(String name){
		int ret = -1;
		for(int i = 0; i < argsList.size(); i ++){
			if(argsList.get(i).equals(findArgs(name))){
				ret = i;
			}
		}
		return ret + 1;
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
