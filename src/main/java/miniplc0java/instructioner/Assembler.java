package miniplc0java.instructioner;

import java.util.ArrayList;
import java.util.HashMap;

public class Assembler {
	byte magic[];//0x72303b3e
	byte version[];//0x00000001
	ArrayList<GlobalDef> globals;
	HashMap<String,GlobalDef> globalsMap;
	ArrayList<FunctionDef> functions;
	HashMap<String,FunctionDef> functionsMap;
	public Assembler() {
		this.magic = new byte[4];
		this.magic[0] = (byte)0x72;
		this.magic[1] = (byte)0x30;
		this.magic[2] = (byte)0x3b;
		this.magic[3] = (byte)0x3e;
		this.version = new byte[4];
		this.version[0] = (byte)0x00;
		this.version[1] = (byte)0x00;
		this.version[2] = (byte)0x00;
		this.version[3] = (byte)0x01;
		this.globals = new ArrayList<GlobalDef>();
		this.globalsMap = new HashMap<String,GlobalDef>();
		this.functions = new ArrayList<FunctionDef>();
		this.functionsMap = new HashMap<String,FunctionDef>();
	}

	public void addGlobalDef(GlobalDef def, String name) {
		globals.add(def);
		globalsMap.put(name, def);
	}

	public GlobalDef findGlobalDef(String name) {
		if(globalsMap.containsKey(name)) {
			if(globalsMap.get(name) instanceof GlobalDef) {
				return (GlobalDef) globalsMap.get(name);
			}
		}
		return null;
	}

	public int findGlobalDefID(GlobalDef def) {
		for(int i = 0; i < globals.size(); i ++) {
			if(def.equals(globals.get(i))){
				return i;
			}
		}
		return -1;
	}

	public void addFunctionDef(FunctionDef def,String name) {
		functions.add(def);
		functionsMap.put(name, def);
	}

	public FunctionDef findFunctionDef(String name) {
		if(functionsMap.containsKey(name)) {
			if(functionsMap.get(name) instanceof FunctionDef) {
				return (FunctionDef) functionsMap.get(name);
			}
		}
		return null;
	}

	public String toString(){
		String ret = "";
		ret = "72303b3e\n";
		ret += "00000001\n";
		ret += (String.format("%08x",this.globals.size())+"\n");
		for(int i = 0; i < this.globals.size(); i ++) {
			ret += this.globals.get(i).toString();
		}
		ret += (String.format("%08x",this.functions.size())+"\n");
		for(int i = 0; i < this.functions.size(); i ++) {
			ret += this.functions.get(i).toString();
		}
		return ret;
	}

	public byte[] toByte() {
		byte ret[];
		ret = this.magic;
		ret = ChangeToByte.concat(ret, this.version);
		ret = ChangeToByte.concat(ret, ChangeToByte.intToByte(this.globals.size()));
		for(int i = 0; i < this.globals.size(); i ++) {
			ret = ChangeToByte.concat(ret, this.globals.get(i).toByte());
		}
		ret = ChangeToByte.concat(ret, ChangeToByte.intToByte(this.functions.size()));
		for(int i = 0; i < this.functions.size(); i ++) {
			ret = ChangeToByte.concat(ret, this.functions.get(i).toByte());
		}
		return ret;
	}
}
