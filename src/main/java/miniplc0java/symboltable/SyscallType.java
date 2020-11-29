package symboltable;

public enum SyscallType {
	/** 读入一个有符号整数
	  * fn getint() -> int; 
	  */
   GETINT,
   /** 读入一个浮点数
		fn getdouble() -> double;
	 */
   GETDOUBLE,
   /** 读入一个字符
		fn getchar() -> int;
	 */
   GETCHAR,
   /** 输出一个整数
		fn putint(int) -> void;
	 */
   PUTINT,
   /** 输出一个浮点数
		fn putdouble(double) -> void;
	 */
   PUTDOUBLE,
   /** 输出一个字符
		fn putchar(int) -> void;
    */
   PUTCHAR,
   /** 输出整数代表的全局常量字符串
		fn putstr(int) -> void; 
	 */
   PUTSTR,
   /** 输出一个换行 */
   PUTLN;
	
	@Override
    public String toString() {
        switch (this) {
	        case GETINT:
	            /** 读入一个浮点数
	        		fn getdouble() -> double;
	        	 */
	        	return "fuc getint()";
	        case GETDOUBLE:
	            /** 读入一个字符
	        		fn getchar() -> int;
	        	 */
	        	return "fuc getdouble()";
	        case GETCHAR:
	            /** 输出一个整数
	        		fn putint(int) -> void;
	        	 */
	        	return "fuc getchar()";
	        case PUTINT:
	            /** 输出一个浮点数
	        		fn putdouble(double) -> void;
	        	 */
	        	return "fuc putint()";
	        case PUTDOUBLE:
	            /** 输出一个字符
	        		fn putchar(int) -> void;
	             */
	        	return "fuc putdouble()";
	        case PUTCHAR:
	            /** 输出整数代表的全局常量字符串
	        		fn putstr(int) -> void; 
	        	 */
	        	return "fuc putchar()";
	        case PUTSTR:
	            /** 输出一个换行 */
	        	return "fuc putstr()";
	        case PUTLN:
	        	return "fuc putln()";
	        default:
                return "InvalidSyscall";
        }
    }
}
