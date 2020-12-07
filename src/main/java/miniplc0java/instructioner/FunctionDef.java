package miniplc0java.instructioner;

import java.util.ArrayList;

import miniplc0java.symboltable.DataType;
import miniplc0java.symboltable.FunctionEntry;

public class FunctionDef {
	// 函数名称在全局变量中的位置
	int nameOffset;
	// 返回值占据的 slot 数
	int return_slots;
	// 参数占据的 slot 数
	int param_slots;
	// 局部变量占据的 slot 数
	int loc_slots;
	// 函数体
	ArrayList<Instruction> body;
	public boolean isRet = false;

	public FunctionDef() {
		this.nameOffset = 0;
		DataType ret = DataType.VOID;
		this.return_slots = (DataType.VOID.equals(ret)?0:1);
		this.param_slots = 0;
		this.loc_slots = 0;
		body = new ArrayList<Instruction>();
	}

	public FunctionDef(FunctionEntry newFunc) {
		this.nameOffset = 0;
		DataType ret = newFunc.datatype;
		this.return_slots = (DataType.VOID.equals(ret)?0:1);
		this.param_slots = newFunc.getVarOffset();
		this.loc_slots = 0;
		body = new ArrayList<Instruction>();
	}

	public int getInstructionLength(){
		return body.size();
	}

	public Instruction getLastInstruction(){
		return body.get(body.size() - 1);
	}

	public void updateNameOffset(int newNameOffset) {
		this.nameOffset = newNameOffset;
	}

	public void updateLocSlots(int newLocSlots) {
		this.loc_slots = newLocSlots;
	}

	public int getLocSlots() {
		return this.loc_slots;
	}

	public int getReturnSlots() {
		return this.return_slots;
	}

	public void putInstruction(Instruction newInstruction) {
		this.body.add(newInstruction);
		if(InstructionType.ret.equals(newInstruction.getOpt())){
			this.isRet = true;
		}
	}

	public byte[] bodyToByte() {
		byte ret[];
		ret = ChangeToByte.intToByte(this.body.size());
		for(int i = 0; i < this.body.size(); i++) {
			ret = ChangeToByte.concat(ret, body.get(i).toByte());
		}
		return ret;
	}

	@Override
	public String toString() {//String.format("%08x",this.globals.size())
		String ret = "fn" + "[" + nameOffset + "] "
				+ loc_slots
				+ " " + param_slots
				+ " -> " + return_slots + " {\n";
		for(int i = 0; i < body.size(); i ++){
			if(i<10) {
				ret += "         " + "   [" + i + "]" + body.get(i).toString();
			}
			else if (i<100){
				ret += "         " + "  [" + i + "]" + body.get(i).toString();
			}
			else if(i<1000){
				ret += "         " + " [" + i + "]" + body.get(i).toString();
			}
			else{
				ret += "         " + "[" + i + "]" + body.get(i).toString();
			}
		}
		ret += "         }" + "\n" + "\n";
		return ret;
	}

	public String toAssemblerString() {//String.format("%08x",this.globals.size())
		String ret = String.format("%08x",nameOffset) + "//nameOffset\n"
				+ String.format("%08x",return_slots) + "//ret_slots\n"
				+ String.format("%08x",param_slots) + "//param_slots\n"
				+ String.format("%08x",loc_slots) + "//loc_slots\n"
				+ String.format("%08x",this.body.size()) + "//body.count\n";
		for(int i = 0; i < body.size(); i ++){
			ret += body.get(i).toString();
		}
		return ret;
	}

	public byte[] toByte() {
		byte ret[];
		ret = ChangeToByte.intToByte(this.nameOffset);
		ret = ChangeToByte.concat(ret, ChangeToByte.intToByte(this.return_slots));
		ret = ChangeToByte.concat(ret, ChangeToByte.intToByte(this.param_slots));
		ret = ChangeToByte.concat(ret, ChangeToByte.intToByte(this.loc_slots));
		ret = ChangeToByte.concat(ret, this.bodyToByte());
		return ret;
	}
}
