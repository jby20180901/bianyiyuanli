package instructioner;

import java.util.ArrayList;

import symboltable.DataType;
import symboltable.FunctionEntry;

public class FunctionDef {
	// ����������ȫ�ֱ����е�λ��
    int nameOffset;
    // ����ֵռ�ݵ� slot ��
    int return_slots;
    // ����ռ�ݵ� slot ��
    int param_slots;
    // �ֲ�����ռ�ݵ� slot ��
    int loc_slots;
    // ������
    ArrayList<Instruction> body;
	
    public FunctionDef(FunctionEntry newFunc) {
    	this.nameOffset = 0;
    	DataType ret = newFunc.datatype;
    	this.return_slots = (DataType.VOID.equals(ret)?0:1);
    	this.param_slots = newFunc.offset;
    	this.loc_slots = 0;
    	body = new ArrayList<Instruction>();
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
    
    public void putInstruction(Instruction newInstruction) {
    	this.body.add(newInstruction);
    }
    
    public byte[] bodyToByte() {
    	byte ret[];
    	ret = ChangeToByte.intToByte(this.body.size());
    	for(int i = 0; i < this.body.size(); i++) {
    		ret = ChangeToByte.concat(ret, body.get(i).toByte());
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
