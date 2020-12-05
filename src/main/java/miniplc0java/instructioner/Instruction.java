package miniplc0java.instructioner;

import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

public class Instruction {
    private InstructionType opt;
    Integer x;
    Long y;
    Double z;
    int type;

    public Instruction(InstructionType opt) {
        this.opt = opt;
        this.x = 0;
        this.y = (long) 0;
        this.z = 0.0;
        this.type = 1;
    }

    public Instruction(InstructionType opt, Integer x) {
        this.opt = opt;
        this.x = x;
        this.y = (long) 0;
        this.z = 0.0;
        this.type = 2;
    }

    public Instruction(InstructionType opt, Long y) {
        this.opt = opt;
        this.x = 0;
        this.y = y;
        this.z = 0.0;
        this.type = 3;
    }

    public Instruction(InstructionType opt, Double z) {
        this.opt = opt;
        this.x = 0;
        this.y = (long)0;
        this.z = z;
        this.type = 3;
    }

    @Override
    public String toString() {
        String ret = opt.toString();
        if(this.type == 1 ){
            ret += "\n";
        }
        else if(this.type == 2 ){
            ret += String.format("%08x",x) + "\n";
        }
        else if(this.type == 3 ){
            ret += String.format("%016x",y) + "\n";
        }
        else if(this.type == 4 ){
            ret += String.format("%016x",z) + "\n";
        }
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Instruction that = (Instruction) o;
        return opt == that.opt && Objects.equals(x, that.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opt, x);
    }

    public InstructionType getOpt() {
        return opt;
    }

    public void setOpt(InstructionType opt) {
        this.opt = opt;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public byte[] toByte() {
        byte ret[];
        if(this.type == 1) {
            ret = new byte[1];
            ret[0] = this.opt.toAssemble();
        }
        else if(this.type == 2) {
            ret = new byte[1];
            ret[0] = this.opt.toAssemble();
            ret = ChangeToByte.concat(ret, ChangeToByte.intToByte((int)this.x));
        }
        else if(this.type == 3) {
            ret = new byte[1];
            ret[0] = this.opt.toAssemble();
            ret = ChangeToByte.concat(ret, ChangeToByte.longToByte((long)this.y));
        }
        else if(this.type == 4){
            ret = new byte[1];
            ret[0] = this.opt.toAssemble();
            ret = ChangeToByte.concat(ret, ChangeToByte.doubleToByte((long)this.y));
        }
        else {
            ret = null;
        }
        return ret;
    }
}
