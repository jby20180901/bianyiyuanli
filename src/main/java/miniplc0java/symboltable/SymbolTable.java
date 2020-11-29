package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

import error.AnalyzeError;
import error.CompileError;
import error.ErrorCode;
import util.Pos;

public class SymbolTable {
	/**
	 * 整个符号表
	 */
	public static ArrayList<HashMap<String, Entry>> symboltable = new ArrayList<>();
	
	/**
	 * 符号表层数上升
	 */
	public static void levelup() {
		symboltable.add(new HashMap<>());
	}
	
	/**
	 * 符号表层数下降
	 * @throws CompileError 
	 */
	public static void leveldown() throws CompileError {
		checkVarEntryInit(symboltable.size() - 1);
		symboltable.remove(symboltable.size() - 1);
	}
	
	/**
	 * 插入变量
	 * @param level
	 * @param name
	 * @param isInitialized
	 * @param isConstant
	 * @param symboltype
	 * @param datatype
	 * @param offset
	 * @param pos
	 * @throws AnalyzeError
	 */
	public static void insertVarEntry(int level, String name, boolean isInitialized, boolean isConstant, SymbolType symboltype, DataType datatype, int offset, Pos pos) throws AnalyzeError {
		HashMap<String, Entry> symbolTable = symboltable.get(level);
		if(symbolTable.containsKey(name)) {
			throw new AnalyzeError(ErrorCode.DuplicateDeclaration,pos);
		}
		else {
			symbolTable.put(name, new VarEntry(name,symboltype,datatype,level,offset,pos,isConstant,isInitialized));
		}
	}
	
	/**
	 * 插入函数
	 * @param name
	 * @param symboltype
	 * @param datatype
	 * @param offset
	 * @param pos
	 * @return
	 * @throws AnalyzeError
	 */
	public static FunctionEntry insertFunctionEntry(String name, SymbolType symboltype, DataType datatype, int offset, Pos pos) throws AnalyzeError {
		HashMap<String, Entry> symbolTable = symboltable.get(0);
		if(symbolTable.containsKey(name)) {
			throw new AnalyzeError(ErrorCode.DuplicateDeclaration,pos);
		}
		else {
			FunctionEntry fuc = new FunctionEntry(name, symboltype, datatype, 0, offset, pos);
			symbolTable.put(name, fuc);
			return fuc;
		}
	}
	
	/**
	 * 更新函数参数
	 * @param fucName
	 * @param varName
	 * @param symbolType
	 * @param dataType
	 * @param offset
	 * @param pos
	 * @param isConstant
	 * @throws AnalyzeError
	 */
	public static void updateFunctionCallList(String fucName, String varName, SymbolType symbolType, DataType dataType,int offset, Pos pos, boolean isConstant) throws AnalyzeError  {
		HashMap<String, Entry> symbolTable = symboltable.get(0);;
		FunctionEntry functionEntry;
		if(!symbolTable.containsKey(fucName)) {
			throw new AnalyzeError(ErrorCode.DuplicateDeclaration,pos);
		}
		else if(symbolTable.get(fucName) instanceof FunctionEntry) {
			functionEntry = (FunctionEntry) symbolTable.get(fucName);
			functionEntry.addArgs(varName,new VarEntry(varName,symbolType,dataType,1,offset,pos,isConstant,true));
		}
		else {
			throw new AnalyzeError(ErrorCode.DuplicateDeclaration,pos);
		}
	}
	
	/**
	 * 全表搜索变量
	 * @param Var
	 * @return
	 */
	public static VarEntry findVarEntry(String Var) {
		HashMap<String, Entry> symbolTable;
		for(int i = symboltable.size() - 1; i >= 0; i--) {
			symbolTable = symboltable.get(i);
			if(symbolTable.containsKey(Var)) {
				if(symbolTable.get(Var) instanceof VarEntry) {
					return (VarEntry) symbolTable.get(Var);
				}
			}
		}
		return null;
	}
	
	/**
	 * 全层检测变量定义
	 * @param Var
	 * @return
	 * @throws CompileError 
	 */
	public static void checkVarEntryInit(int level) throws CompileError {
		HashMap<String, Entry> symbolTable;
		symbolTable = symboltable.get(level);
		for (String key:symbolTable.keySet()){
			if(symbolTable.get(key) instanceof VarEntry) {
				if(((VarEntry) symbolTable.get(key)).isInitialized != true) {
					throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
				}
			}
			
        }
	}
	
	/**
	 * 全表搜索函数
	 * @param Func
	 * @return
	 */
	public static FunctionEntry findFunctionEntry(String Func) {
		HashMap<String, Entry> symbolTable;
		for(int i = symboltable.size() - 1; i >= 0; i--) {
			symbolTable = symboltable.get(i);
			if(symbolTable.containsKey(Func)) {
				if(symbolTable.get(Func) instanceof FunctionEntry) {
					return (FunctionEntry) symbolTable.get(Func);
				}
			}
		}
		return null;
	}
	
	/**
	 * 按层搜索变量
	 * @param Var
	 * @param level
	 * @return
	 */
	public static VarEntry findVarEntry(String Var,int level) {
		HashMap<String, Entry> symbolTable;
		symbolTable = symboltable.get(level);
		if(symbolTable.containsKey(Var)) {
			if(symbolTable.get(Var) instanceof VarEntry) {
				return (VarEntry) symbolTable.get(Var);
			}
		}
		return null;
	}
	
	/**
	 * 按层搜索函数
	 * @param Func
	 * @param level
	 * @return
	 */
	public static FunctionEntry findFunctionEntry(String Func,int level) {
		HashMap<String, Entry> symbolTable;
		symbolTable = symboltable.get(level);
		if(symbolTable.containsKey(Func)) {
			if(symbolTable.get(Func) instanceof FunctionEntry) {
				return (FunctionEntry) symbolTable.get(Func);
			}
		}
		return null;
	}
}
