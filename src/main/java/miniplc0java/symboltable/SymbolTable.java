package symboltable;

import java.util.ArrayList;
import java.util.HashMap;

import error.AnalyzeError;
import error.ErrorCode;
import util.Pos;

public class SymbolTable {
	/**
	 * �������ű�
	 */
	public static ArrayList<HashMap<String, Entry>> symboltable = new ArrayList<>();
	
	/**
	 * ���ű��������
	 */
	public static void levelup() {
		symboltable.add(new HashMap<>());
	}
	
	/**
	 * ���ű�����½�
	 */
	public static void leveldown() {
		symboltable.remove(symboltable.size() - 1);
	}
	
	/**
	 * �������
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
	 * ���뺯��
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
	 * ���º�������
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
	 * ȫ����������
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
	 * ȫ����������
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
	 * ������������
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
	 * ������������
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
