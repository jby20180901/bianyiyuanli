package miniplc0java.instructioner;

public enum InstructionType {
	nop,
	push,
	pop,
	popn,
	dup,
	loca,
	arga,
	globa,
	load_8,
	load_16,
	load_32,
	load_64,
	store_8,
	store_16,
	store_32,
	store_64,
	alloc,
	free,
	stackalloc,
	add_i,
	sub_i,
	mul_i,
	div_i,
	add_f,
	sub_f,
	mul_f,
	div_f,
	div_u,
	shl,
	shr,
	and,
	or,
	xor,
	not,
	cmp_i,
	cmp_u,
	cmp_f,
	neg_i,
	neg_f,
	itof,
	ftoi,
	shrl,
	set_lt,
	set_gt,
	br,
	br_false,
	br_true,
	call,
	ret,
	callname,
	scan_i,
	scan_c,
	scan_f,
	print_i,
	print_c,
	print_f,
	print_s,
	println,
	panic;

	public byte toAssemble() {
		switch(this) {
			/**0x00*/
			case nop:
				return (byte)0x00;
			/**0x01*/
			case push:
				return (byte)0x01;
			/**0x02*/
			case pop:
				return (byte)0x02;
			/**0x03*/
			case popn:
				return (byte)0x03;
			/**0x04*/
			case dup:
				return (byte)0x04;
			/**0x0a*/
			case loca:
				return (byte)0x0a;
			/**0x0b*/
			case arga:
				return (byte)0x0b;
			/**0x0c*/
			case globa:
				return (byte)0x0c;
			/**0x10*/
			case load_8:
				return (byte)0x10;
			/**0x11*/
			case load_16:
				return (byte)0x11;
			/**0x12*/
			case load_32:
				return (byte)0x12;
			/**0x13*/
			case load_64:
				return (byte)0x13;
			/**0x14*/
			case store_8:
				return (byte)0x14;
			/**0x15*/
			case store_16:
				return (byte)0x15;
			/**0x16*/
			case store_32:
				return (byte)0x16;
			/**0x17*/
			case store_64:
				return (byte)0x17;
			/**0x18*/
			case alloc:
				return (byte)0x18;
			/**0x19*/
			case free:
				return (byte)0x19;
			/**	0x1a*/
			case stackalloc:
				return (byte)0x1a;
			/**	0x20*/
			case add_i:
				return (byte)0x20;
			/**	0x21*/
			case sub_i:
				return (byte)0x21;
			/**	0x22*/
			case mul_i:
				return (byte)0x22;
			/**	0x23*/
			case div_i:
				return(byte)0x23;
			/**	0x24*/
			case add_f:
				return (byte)0x24;
			/**	0x25*/
			case sub_f:
				return (byte)0x25;
			/**	0x26*/
			case mul_f:
				return (byte)0x26;
			/**	0x27*/
			case div_f:
				return (byte)0x27;
			/**	0x28*/
			case div_u:
				return (byte)0x28;
			/**	0x29*/
			case shl:
				return (byte)0x29;
			/**	0x2a*/
			case shr:
				return (byte)0x2a;
			/**	0x2b*/
			case and:
				return (byte)0x2b;
			/**	0x2c*/
			case or:
				return (byte)0x2c;
			/**	0x2d*/
			case xor:
				return (byte)0x2d;
			/**	0x2e*/
			case not:
				return (byte)0x2e;
			/**	0x30*/
			case cmp_i:
				return (byte)0x30;
			/**	0x31*/
			case cmp_u:
				return (byte)0x31;
			/**	0x32*/
			case cmp_f:
				return (byte)0x32;
			/**	0x34*/
			case neg_i:
				return (byte)0x34;
			/**	0x35*/
			case neg_f:
				return (byte)0x35;
			/**	0x36*/
			case itof:
				return (byte)0x36;
			/**	0x37*/
			case ftoi:
				return (byte)0x37;
			/**	0x38*/
			case shrl:
				return (byte)0x38;
			/**	0x39*/
			case set_lt:
				return (byte)0x39;
			/**	0x3a*/
			case set_gt:
				return (byte)0x3a;
			/**	0x41*/
			case br:
				return (byte)0x41;
			/**	0x42*/
			case br_false:
				return (byte)0x42;
			/**	0x43*/
			case br_true:
				return (byte)0x43;
			/**	0x48*/
			case call:
				return (byte)0x48;
			/**	0x49*/
			case ret:
				return (byte)0x49;
			/**	0x4a*/
			case callname:
				return (byte)0x4a;
			/**	0x50*/
			case scan_i:
				return (byte)0x50;
			/**	0x51*/
			case scan_c:
				return (byte)0x51;
			/**	0x52*/
			case scan_f:
				return (byte)0x52;
			/**	0x54*/
			case print_i:
				return (byte)0x54;
			/**0x55*/
			case print_c:
				return (byte)0x55;
			/**0x56*/
			case print_f:
				return (byte)0x56;
			/**0x57*/
			case print_s:
				return (byte)0x57;
			/**0x58*/
			case println:
				return (byte)0x58;
			/**0xfe*/
			case panic:
				return (byte)0xfe;
			default:
				return (byte)0x00;
		}
	}

	public String toString() {
		switch(this) {
			/**0x00*/
			case nop:
				return "nop";
			/**0x01*/
			case push:
				return "push";
			/**0x02*/
			case pop:
				return "pop";
			/**0x03*/
			case popn:
				return "popn";
			/**0x04*/
			case dup:
				return "0x04";
			/**0x0a*/
			case loca:
				return "loca";
			/**0x0b*/
			case arga:
				return "arga";
			/**0x0c*/
			case globa:
				return "globa";
			/**0x10*/
			case load_8:
				return "load.8";
			/**0x11*/
			case load_16:
				return "load.16";
			/**0x12*/
			case load_32:
				return "load.32";
			/**0x13*/
			case load_64:
				return "load.64";
			/**0x14*/
			case store_8:
				return "store.8";
			/**0x15*/
			case store_16:
				return "store.16";
			/**0x16*/
			case store_32:
				return "store.32";
			/**0x17*/
			case store_64:
				return "store.64";
			/**0x18*/
			case alloc:
				return "alloc";
			/**0x19*/
			case free:
				return "free";
			/**	0x1a*/
			case stackalloc:
				return "stackalloc";
			/**	0x20*/
			case add_i:
				return "add.i";
			/**	0x21*/
			case sub_i:
				return "sub.i";
			/**	0x22*/
			case mul_i:
				return "mul.i";
			/**	0x23*/
			case div_i:
				return "div.i";
			/**	0x24*/
			case add_f:
				return "add.f";
			/**	0x25*/
			case sub_f:
				return "sub.f";
			/**	0x26*/
			case mul_f:
				return "mul.f";
			/**	0x27*/
			case div_f:
				return "div.f";
			/**	0x28*/
			case div_u:
				return "div.u";
			/**	0x29*/
			case shl:
				return "shl";
			/**	0x2a*/
			case shr:
				return "shr";
			/**	0x2b*/
			case and:
				return "and";
			/**	0x2c*/
			case or:
				return "or";
			/**	0x2d*/
			case xor:
				return "xor";
			/**	0x2e*/
			case not:
				return "not";
			/**	0x30*/
			case cmp_i:
				return "cmp.i";
			/**	0x31*/
			case cmp_u:
				return "cmp.u";
			/**	0x32*/
			case cmp_f:
				return "cmp.f";
			/**	0x34*/
			case neg_i:
				return "neg.i";
			/**	0x35*/
			case neg_f:
				return "neg.f";
			/**	0x36*/
			case itof:
				return "itof";
			/**	0x37*/
			case ftoi:
				return "ftoi";
			/**	0x38*/
			case shrl:
				return "shrl";
			/**	0x39*/
			case set_lt:
				return "set.lt";
			/**	0x3a*/
			case set_gt:
				return "set.gt";
			/**	0x41*/
			case br:
				return "br";
			/**	0x42*/
			case br_false:
				return "br.false";
			/**	0x43*/
			case br_true:
				return "br.true";
			/**	0x48*/
			case call:
				return "call";
			/**	0x49*/
			case ret:
				return "ret";
			/**	0x4a*/
			case callname:
				return "callname";
			/**	0x50*/
			case scan_i:
				return "scan.i";
			/**	0x51*/
			case scan_c:
				return "scan.c";
			/**	0x52*/
			case scan_f:
				return "scan.f";
			/**	0x54*/
			case print_i:
				return "print.i";
			/**0x55*/
			case print_c:
				return "print.c";
			/**0x56*/
			case print_f:
				return "print.f";
			/**0x57*/
			case print_s:
				return "print.s";
			/**0x58*/
			case println:
				return "println";
			/**0xfe*/
			case panic:
				return "panic";
			default:
				return "????";
		}
	}
}
