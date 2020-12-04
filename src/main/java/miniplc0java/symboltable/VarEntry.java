package symboltable;

import util.Pos;

public class VarEntry extends Entry{
	public boolean isConstant;
    public boolean isInitialized;
    public int offset;//ÔÚÄ³Ò»¿éµÄÆ«ÒÆ
    
    public VarEntry(String name, SymbolType symboltype, DataType datatype, int level, int offset,Pos pos, boolean isConstant, boolean isInitialized) {
    	super(name,symboltype,datatype,level,offset,pos);
    	this.isConstant = isConstant;
    	this.isInitialized = isInitialized;
    }
    
    /**
     * @return the isConstant
     */
    public boolean isConstant() {
        return isConstant;
    }

    /**
     * @return the isInitialized
     */
    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     * @param isConstant the isConstant to set
     */
    public void setConstant(boolean isConstant) {
        this.isConstant = isConstant;
    }

    /**
     * @param isInitialized the isInitialized to set
     */
    public void setInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }
}
