package symboltable;

public enum SyscallType {
	/** ����һ���з�������
	  * fn getint() -> int; 
	  */
   GETINT,
   /** ����һ��������
		fn getdouble() -> double;
	 */
   GETDOUBLE,
   /** ����һ���ַ�
		fn getchar() -> int;
	 */
   GETCHAR,
   /** ���һ������
		fn putint(int) -> void;
	 */
   PUTINT,
   /** ���һ��������
		fn putdouble(double) -> void;
	 */
   PUTDOUBLE,
   /** ���һ���ַ�
		fn putchar(int) -> void;
    */
   PUTCHAR,
   /** �������������ȫ�ֳ����ַ���
		fn putstr(int) -> void; 
	 */
   PUTSTR,
   /** ���һ������ */
   PUTLN;
	
	@Override
    public String toString() {
        switch (this) {
	        case GETINT:
	            /** ����һ��������
	        		fn getdouble() -> double;
	        	 */
	        	return "fuc getint()";
	        case GETDOUBLE:
	            /** ����һ���ַ�
	        		fn getchar() -> int;
	        	 */
	        	return "fuc getdouble()";
	        case GETCHAR:
	            /** ���һ������
	        		fn putint(int) -> void;
	        	 */
	        	return "fuc getchar()";
	        case PUTINT:
	            /** ���һ��������
	        		fn putdouble(double) -> void;
	        	 */
	        	return "fuc putint()";
	        case PUTDOUBLE:
	            /** ���һ���ַ�
	        		fn putchar(int) -> void;
	             */
	        	return "fuc putdouble()";
	        case PUTCHAR:
	            /** �������������ȫ�ֳ����ַ���
	        		fn putstr(int) -> void; 
	        	 */
	        	return "fuc putchar()";
	        case PUTSTR:
	            /** ���һ������ */
	        	return "fuc putstr()";
	        case PUTLN:
	        	return "fuc putln()";
	        default:
                return "InvalidSyscall";
        }
    }
}
