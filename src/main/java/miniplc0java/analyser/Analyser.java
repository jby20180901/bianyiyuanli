package miniplc0java.analyser;

import java.util.ArrayList;

import error.AnalyzeError;
import error.CompileError;
import error.ErrorCode;
import error.ExpectedTokenError;
import error.TokenizeError;
import tokenizer.Token;
import tokenizer.TokenType;
import tokenizer.Tokenizer;
import util.Pos;
import symboltable.FunctionEntry;
import symboltable.SymbolTable;
import symboltable.SymbolType;
import symboltable.VarEntry;
import symboltable.DataKeywordType;
import symboltable.DataType;

public final class Analyser {
    Tokenizer tokenizer;
    int level = 0;//����
    private int functionOffset = 0;//����ƫ����
    private int[][] priorty = new int[100][100];
    private TokenType[] priortyToken = new TokenType[20];
    ArrayList<Object> functionLPRecent = new ArrayList<>();
    int ifReturn[] = new int[1000];
    boolean isVoid = false;
    int LPNum = 0;
    DataType nowReturn = null; //��ǰ����ֵ����
    /** ��ǰ͵���� token */
    Token peekedToken = null;

    /** �������ź��� */
    int brace = 0;

    /** ��һ��������ջƫ�� */
    int nextOffset = 0;
    
    public int enumToInt(TokenType tokenType) {
    	int ret;
        if(tokenType.equals(TokenType.PLUS)) {
        	ret = 0;
        }
        else if(tokenType.equals(TokenType.MINUS)) {
        	ret = 1;
        }
        else if(tokenType.equals(TokenType.MUL)) {
        	ret = 2;
        }
        else if(tokenType.equals(TokenType.DIV)) {
        	ret = 3;
        }
        else if(tokenType.equals(TokenType.UINT_LITERAL)) {
        	ret = 4;
        }
        else if(tokenType.equals(TokenType.DOUBLE_LITERAL)) {
        	ret = 5;
        }
        else if(tokenType.equals(TokenType.IDENT)) {
        	ret = 6;
        }
        else if(tokenType.equals(TokenType.L_PAREN)) {
        	ret = 7;
        }
        else if(tokenType.equals(TokenType.R_PAREN)) {
        	ret = 8;
        }
        else if(tokenType.equals(TokenType.EQ)) {
        	ret = 9;
        }
        else if(tokenType.equals(TokenType.NEQ)) {
        	ret = 10;
        }
        else if(tokenType.equals(TokenType.LT)) {
        	ret = 11;
        }
        else if(tokenType.equals(TokenType.GT)) {
        	ret = 12;
        }
        else if(tokenType.equals(TokenType.LE)) {
        	ret = 13;
        }
        else if(tokenType.equals(TokenType.GE)) {
        	ret = 14;
        }
        else if(tokenType.equals(TokenType.NEGATE)) {
        	ret = 15;
        }
        else if(tokenType.equals(TokenType.AS_KW)) {
        	ret = 16;
        }
        else if(tokenType.equals(TokenType.STOP)) {
        	ret = 17;
        }
        else {
        	ret = -1;
        }
        return ret;
    }
    public Analyser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        /** 
         * + - 					PLUS MINUS 
         * ǰ��- 				NEGATE
         * * \ 					MUL DIV 
         * == != < > <= >= 		EQ NEQ LT GT LE GE
         * as 					AS_KW 
         * uint double ident 	UINT_LITERAL DOUBLE_LITERAL IDENT
         * ( 					L_PAREN 
         * ) 					R_PAREN
         * # 					STOP
        */
        /**
         * 0����<
         * 1����>
         * 2����=
         * 3����X
         * 4��������
         * |      | +    | *    | i    | (    | )    | <    | '-'  | as   | #    |
		 * | +    | 1    | 0    | 0    | 0    | 1    | 1    | 0    | 0    | 1    |
		 * | *    | 1    | 1    | 0    | 0    | 1    | 1    | 0    | 0    | 1    |
		 * | i    | 1    | 1    | 3    | 3    | 1    | 1    | 3    | 1    | 1    |
		 * | (    | 0    | 0    | 0    | 0    | 2    | 0    | 0    | 0    | 3    |
		 * | )    | 1    | 1    | 3    | 3    | 1    | 1    | 3    | 1    | 1    |
		 * | <    | 0    | 0    | 0    | 0    | 1    | 1    | 0    | 0    | 1    |
		 * | '-'  | 1    | 1    | 0    | 3    | 1    | 1    | 0    | 1    | 1    |
		 * | as   | 1    | 1    | 3    | 3    | 1    | 1    | 3    | 1    | 1    |
		 * | #    | 0    | 0    | 0    | 0    | 3    | 0    | 0    | 0    | 4    |
         */
        /** +- */
        priortyToken[0] = TokenType.PLUS;
        priortyToken[1] = TokenType.MINUS;
        /** *\ */
        priortyToken[2] = TokenType.MUL;
        priortyToken[3] = TokenType.DIV;
        /** uint double ident */
        priortyToken[4] = TokenType.UINT_LITERAL;  
        priortyToken[5] = TokenType.DOUBLE_LITERAL;
        priortyToken[6] = TokenType.IDENT;
        /** ( */
        priortyToken[7] = TokenType.L_PAREN;
        /** ) */
        priortyToken[8] = TokenType.R_PAREN;
        /** == != < > <= >= */
        priortyToken[9] = TokenType.EQ;
        priortyToken[10] = TokenType.NEQ;
        priortyToken[11] = TokenType.LT;
        priortyToken[12] = TokenType.GT;
        priortyToken[13] = TokenType.LE;
        priortyToken[14] = TokenType.GE;
        /** '-' */
        priortyToken[15] = TokenType.NEGATE;
        /** as */
        priortyToken[16] = TokenType.AS_KW;
        /** # */
        priortyToken[17] = TokenType.STOP;
        for(int i=0;i<18;i++) {//ջ�� ��
        	for(int j=0;j<18;j++) {//ջ�� ��
    			if(i==0||i==1) {/** +- */
    				if(j==0||j==1) {/** +- */
            			priorty[i][j] = 1;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 0;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 0;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 0;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 0;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 0;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==2||i==3) {/** *\ */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 1;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 1;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 0;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 0;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 0;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 0;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==4||i==5||i==6) {/** uint double ident */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 1;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 1;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 3;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 3;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 3;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 1;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==7) {/** ( */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 0;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 0;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 0;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 0;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 2;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 0;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 0;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 0;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 3;
            		}
        		}
        		else if(i==8) {/** ) */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 1;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 1;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 3;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 3;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 3;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 1;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==9||i==10||i==11||i==12||i==13||i==14) {/** == != < > <= >= */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 0;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 0;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 0;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 0;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 0;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 0;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==15) {/** '-' */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 1;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 1;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 0;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 3;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 0;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 1;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==16) {/** as */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 1;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 1;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 3;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 3;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 1;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 1;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 3;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 1;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 1;
            		}
        		}
        		else if(i==17) {/** # */
        			if(j==0||j==1) {/** +- */
            			priorty[i][j] = 0;
            		}
            		else if(j==2||j==3) {/** *\ */
            			priorty[i][j] = 0;
            		}
            		else if(j==4||j==5||j==6) {/** uint double ident */
            			priorty[i][j] = 0;
            		}
            		else if(j==7) {/** ( */
            			priorty[i][j] = 0;
            		}
            		else if(j==8) {/** ) */
            			priorty[i][j] = 3;
            		}
            		else if(j==9||j==10||j==11||j==12||j==13||j==14) {/** == != < > <= >= */
            			priorty[i][j] = 0;
            		}
            		else if(j==15) {/** '-' */
            			priorty[i][j] = 0;
            		}
            		else if(j==16) {/** as */
            			priorty[i][j] = 0;
            		}
            		else if(j==17) {/** # */
            			priorty[i][j] = 4;
            		}
        		}
        	}
        }
        for(int i=0;i<1000;i++) {
        	this.ifReturn[i] = -1;
        }
    }

    public void analyse() throws CompileError {
    	SymbolTable.levelup();
    	initSystemcall();
        analyseProgram();
        startAtMain();
    }

    /**
     * �鿴��һ�� Token
     * 
     * @return
     * @throws TokenizeError
     */
    private Token peek() throws TokenizeError {
        if (peekedToken == null) {
            peekedToken = tokenizer.nextToken();
        }
        return peekedToken;
    }

    /**
     * ��ȡ��һ�� Token
     * 
     * @return
     * @throws TokenizeError
     */
    private Token next() throws TokenizeError {
        if (peekedToken != null) {
            var token = peekedToken;
            peekedToken = null;
            return token;
        } else {
            return tokenizer.nextToken();
        }
    }

    /**
     * �����һ�� token �������� tt���򷵻� true
     * 
     * @param tt
     * @return
     * @throws TokenizeError
     */
    private boolean check(TokenType tt) throws TokenizeError {
        var token = peek();
        return token.getTokenType() == tt;
    }

    /**
     * �����һ�� token �������� tt����ǰ��һ�� token ��������� token
     * 
     * @param tt ����
     * @return ���ƥ���򷵻���� token�����򷵻� null
     * @throws TokenizeError
     */
    private Token nextIf(TokenType tt) throws TokenizeError {
        var token = peek();
        if (token.getTokenType() == tt) {
            return next();
        } else {
            return null;
        }
    }
    
    /**
     * �����һ�� token �������� tt����ǰ��һ�� token ��������� token
     * 
     * @param tt ����
     * @return ���ƥ���򷵻���� token�����򷵻� null
     * @throws TokenizeError
     */
    private Token seekIf(TokenType tt) throws TokenizeError {
        var token = peek();
        if (token.getTokenType() == tt) {
            return token;
        } else {
            return null;
        }
    }

    /**
     * �����һ�� token �������� tt����ǰ��һ�� token �����أ������׳��쳣
     * 
     * @param tt ����
     * @return ��� token
     * @throws CompileError ������Ͳ�ƥ��
     */
    private Token expect(TokenType tt) throws CompileError {
        var token = peek();
        if (token.getTokenType() == tt) {
            return next();
        } else {
            throw new ExpectedTokenError(tt, token);
        }
    }
    
    /**
     * ����һ���з�������
	 * fn getint() -> int
	 * ����һ��������
	 * fn getdouble() -> double
	 * ����һ���ַ�
	 * fn getchar() -> int
	 * ���һ������
	 * fn putint(int) -> void
	 * ���һ��������
	 * fn putdouble(double) -> void
	 * ���һ���ַ�
	 * fn putchar(int) -> void
	 * �����Ϊ���������ȫ�ֳ��������ַ������
	 * fn putstr(int) -> void
	 * ���һ������
	 * fn putln() -> void
     * @throws CompileError
     */
    private void initSystemcall() throws CompileError {
    	Pos startPos = new Pos(0,0);
    	/** 
    	 * ����һ���з�������
    	 * fn getint() -> int
	 	 */
    	level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("getint", SymbolType.Function, DataType.INT, functionOffset, startPos);
    	level --;
    	SymbolTable.leveldown();
    	/** 
    	 * ����һ��������
    	 * fn getdouble() -> double
	 	 */
    	level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("getdouble", SymbolType.Function, DataType.DOUBLE, functionOffset, startPos);
    	level --;
    	SymbolTable.leveldown();
    	/** 
    	 * ����һ���ַ�
    	 * fn getchar() -> int
	 	 */
    	level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("getchar", SymbolType.Function, DataType.INT, functionOffset, startPos);
    	level --;
    	SymbolTable.leveldown();
    	/** 
    	 * ���һ������
    	 * fn putint(int) -> void
	 	 */
    	level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("putint", SymbolType.Function, DataType.VOID, functionOffset, startPos);
    	//��������������
        SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.INT, 1, startPos);
        //��������һ������
        SymbolTable.updateFunctionCallList("putint", "x", SymbolType.Variable, DataType.INT, 1, startPos, false);
        level --;
    	SymbolTable.leveldown();
    	/** 
    	 * ���һ��������
    	 * fn putdouble(double) -> void
	 	 */
        level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("putdouble", SymbolType.Function, DataType.VOID, functionOffset, startPos);
    	//��������������
        SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.DOUBLE, 1, startPos);
        //��������һ������
        SymbolTable.updateFunctionCallList("putdouble", "x", SymbolType.Variable, DataType.DOUBLE, 1, startPos, false);
        level --;
    	SymbolTable.leveldown();
    	/** 
    	 * ���һ���ַ�
    	 * fn putchar(int) -> void
	 	 */
        level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("putchar", SymbolType.Function, DataType.VOID, functionOffset, startPos);
    	//��������������
        SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.INT, 1, startPos);
        //��������һ������
        SymbolTable.updateFunctionCallList("putchar", "x", SymbolType.Variable, DataType.INT, 1, startPos, false);
        level --;
    	SymbolTable.leveldown();
    	/** 
    	 * �����Ϊ���������ȫ�ֳ��������ַ������
    	 * fn putstr(int) -> void
	 	 */
        level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("putstr", SymbolType.Function, DataType.VOID, functionOffset, startPos);
    	//��������������
        SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.INT, 1, startPos);
        //��������һ������
        SymbolTable.updateFunctionCallList("putstr", "x", SymbolType.Variable, DataType.INT, 1, startPos, false);
        level --;
    	SymbolTable.leveldown();
    	/** 
    	 * ���һ������
    	 * fn putln() -> void
	 	 */
        level ++;
    	SymbolTable.levelup();
    	SymbolTable.insertFunctionEntry("putln", SymbolType.Function, DataType.VOID, functionOffset, startPos);
    	level --;
    	SymbolTable.leveldown();
    }
    
    /**
     * 
     * @throws CompileError
     */
    private void startAtMain() throws CompileError {
    	Pos pos = new Pos(0,0);
    	if(SymbolTable.findFunctionEntry("main") != null) {
    		
    	}
    	else {
    		throw new AnalyzeError(ErrorCode.NoBegin,pos);
    	}
    }
    
    /**
     * program -> item*
    */
    private void analyseProgram() throws CompileError {
        //ѭ������Ƿ����β��
        while(!check(TokenType.EOF)){
            analyseItem();
        }
        expect(TokenType.EOF);
    }


    /**
     * item -> function | decl_stmt
     */
    private void analyseItem() throws CompileError {
        // ����һ�������ǲ���fn
        if(check(TokenType.FN_KW)){
            analyseFuc();
        }
        //����ǲ��Ǳ����������
        else if(check(TokenType.LET_KW)||check(TokenType.CONST_KW)){
            analyseDeclStmt();
        }
        else{
            expect(TokenType.FN_KW);
            expect(TokenType.LET_KW);
            expect(TokenType.CONST_KW);
        }
    }

    /**
     * function -> 'fn' IDENT '(' function_param_list? ')' '->' ty block_stmt
     */
    private void analyseFuc() throws CompileError {
    	DataType datatype = null;//����ֵ����
    	FunctionEntry functionEntry;//���ɵĺ�������
    	String fucName;//��������
    	int offset = 0;
        // ����һ�������ǲ���fn
        expect(TokenType.FN_KW);
        var fucNameToken = expect(TokenType.IDENT);
        fucName = (String) fucNameToken.getValue();
        functionEntry = SymbolTable.insertFunctionEntry(fucName, SymbolType.Function, null, functionOffset,fucNameToken.getStartPos());
        //String name, SymbolType symboltype, DataType datatype, int offset, Pos pos
        expect(TokenType.L_PAREN);
        LPNum ++;
        level ++;
        SymbolTable.levelup();
        if(!TokenType.R_PAREN.equals(peek().getTokenType())) {
        	offset = analyseFuncList(fucNameToken);
        }
        functionEntry.setVarOffset(offset);
        expect(TokenType.R_PAREN);
        LPNum --;
        expect(TokenType.ARROW);
        /**
         * ty -> IDENT
         */
        var fucTypeToken = expect(TokenType.IDENT);
        if(((String)fucTypeToken.getValue()).equals("int")) {
        	datatype = DataType.INT;
        	isVoid = false;
        }
        else if(((String)fucTypeToken.getValue()).equals("double")) {
        	datatype = DataType.DOUBLE;
        	isVoid = false;
        }
        else if(((String)fucTypeToken.getValue()).equals("void")) {
        	datatype = DataType.VOID;
        	isVoid = true;
        }
        else {
        	throw new AnalyzeError(ErrorCode.InvalidVariableDeclaration,fucTypeToken.getStartPos());
        }
        functionEntry.datatype = datatype;
        nowReturn = datatype;
        analyseFucBlockStmt();
//        checkFlow();
    }

    /**
     * function_param_list -> function_param (',' function_param)*
     */
    private int analyseFuncList(Token fucNameToken) throws CompileError {
        int offset = 0;
    	analyseFucPara(fucNameToken,offset);
        offset ++;
        if(nextIf(TokenType.COMMA)!=null){
            analyseFucPara(fucNameToken,offset);
            offset ++;
        }
        return offset;
    }

    /**
     * function_param -> const? IDENT ':' ty 
     */
    private void analyseFucPara(Token fucNameToken,int offset) throws CompileError {
    	DataType datatype = null;//��������
    	SymbolType symbolType = null;
    	String varName = null;//������
    	String fucName = (String)fucNameToken.getValue();//������
    	boolean isConst = false;
    	if(nextIf(TokenType.CONST_KW)!=null) {
    		isConst = true;
    		symbolType = SymbolType.Constant;
    	}
    	else {
    		symbolType = SymbolType.Variable;
    	}
    	var paraNameToken = expect(TokenType.IDENT);
    	varName = (String)paraNameToken.getValue();
        expect(TokenType.COLON);
        /**
         * ty -> IDENT
         */
        var varTypeToken = expect(TokenType.IDENT);
        if(((String)varTypeToken.getValue()).equals("int")) {
        	datatype = DataType.INT;
        }
        else if(((String)varTypeToken.getValue()).equals("double")) {
        	datatype = DataType.DOUBLE;
        }
        else if(((String)varTypeToken.getValue()).equals("void")) {
        	datatype = DataType.VOID;
        }
        else {
        	throw new AnalyzeError(ErrorCode.InvalidVariableDeclaration,varTypeToken.getStartPos());
        }
        //��������������
        SymbolTable.insertVarEntry(level, varName, true, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
        //��������һ������
        SymbolTable.updateFunctionCallList(fucName, varName, symbolType, datatype, offset, varTypeToken.getStartPos(), isConst);
    }

    /**
     * ���ÿ�����
     */
    private void setFlow() throws CompileError {
//    	System.out.println("num:"+level+" ifret:"+this.ifReturn[level]);
    	if(this.ifReturn[level] == 1) {
    		ifReturn[level-1] = 1;
    	}
    	else if(isVoid){
    		ifReturn[level-1] = 1;
    	}
    	else {
    		ifReturn[level-1] = 0;
    	}
    }
    
    /**
     * ��������
     */
    private void checkFlow() throws CompileError {
//    	System.out.println("num:"+level+" ifret:"+this.ifReturn[level]);
    	if(this.ifReturn[1]==1) {
    		for(int i=0;i<1000;i++) {
            	this.ifReturn[i] = -1;
            }
    		return;
    	}
    	else {
    		throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
    	}
    }
    
    /**
     * block_stmt -> '{' stmt* '}'
     */
    private void analyseBlockStmt() throws CompileError {
    	level ++;
    	SymbolTable.levelup();
    	this.ifReturn[level] = 0;
    	expect(TokenType.L_BRACE);
    	int thisLevel  = level;
        while(!(check(TokenType.R_BRACE)&&(level == thisLevel))){
            analyseStmt();
        }
        expect(TokenType.R_BRACE);
        setFlow();
    	level --;
    	SymbolTable.leveldown();
    }
    
    /**
     * block_stmt -> '{' stmt* '}'
     */
    private void analyseFucBlockStmt() throws CompileError {
    	this.ifReturn[level] = 0;
    	expect(TokenType.L_BRACE);
    	int thisLevel  = level;
        while(!(check(TokenType.R_BRACE)&&(level == thisLevel))){
            analyseStmt();
        }
        expect(TokenType.R_BRACE);
        setFlow();
    	level --;
    	SymbolTable.leveldown();
    }

    /**
     * stmt ->
     * expr_stmt
     * | decl_stmt
     * | if_stmt
     * | while_stmt
     * | break_stmt
     * | continue_stmt
     * | return_stmt
     * | block_stmt
     * | empty_stmt
     */
    private void analyseStmt() throws CompileError {
        if(check(TokenType.LET_KW)||check(TokenType.CONST_KW)){
            analyseDeclStmt();
        }
        else if(check(TokenType.IF_KW)){
            analyseIfStmt();
        }
        else if(check(TokenType.WHILE_KW)){
            analyseWhileStmt();
        }
        else if(check(TokenType.BREAK_KW)){
            analyseBreakStmt();
        }
        else if(check(TokenType.CONTINUE_KW)){
            analyseContinueStmt();
        }
        else if(check(TokenType.RETURN_KW)){
            ananlyseReturnStmt();
        }
        else if(check(TokenType.L_BRACE)){
            analyseBlockStmt();
        }
        else if(check(TokenType.SEMICOLON)){
            expect(TokenType.SEMICOLON);
        }
        else{
            analyseExprStmt();
        }
    }
    
    /**
     * decl_stmt -> let_decl_stmt | const_decl_stmt
     * let_decl_stmt -> 'let' IDENT ':' ty ('=' expr)? ';'
	 * const_decl_stmt -> 'const' IDENT ':' ty '=' expr ';'
     */
    private void analyseDeclStmt() throws CompileError {
    	DataType datatype = null ,rDataType = null;//��������
    	SymbolType symbolType = null;
    	String varName = null;//������
    	boolean isConst = false;
    	int offset = 0;
        // ����һ�������ǲ���let const
    	if(nextIf(TokenType.CONST_KW)!=null) {
    		isConst = true;
    		symbolType = SymbolType.Constant;
    	}
    	else if(nextIf(TokenType.LET_KW)!=null)  {
    		symbolType = SymbolType.Variable;
    	}
    	//String fucName = (String)fucNameToken.getValue();//������
    	var paraNameToken = expect(TokenType.IDENT);
    	varName = (String)paraNameToken.getValue();
        expect(TokenType.COLON);
        /**
         * ty -> IDENT
         */
        var varTypeToken = expect(TokenType.IDENT);
        if(((String)varTypeToken.getValue()).equals("int")) {
        	datatype = DataType.INT;
        }
        else if(((String)varTypeToken.getValue()).equals("double")) {
        	datatype = DataType.DOUBLE;
        }
        else if(((String)varTypeToken.getValue()).equals("void")) {
        	datatype = DataType.VOID;
        }
        else {
        	throw new AnalyzeError(ErrorCode.InvalidVariableDeclaration,varTypeToken.getStartPos());
        }
        if(isConst) {
        	expect(TokenType.ASSIGN);
        	rDataType = analyseExpr(TokenType.ASSIGN);//����ʽ�������
        	if(!datatype.equals(rDataType)) {
            	throw new AnalyzeError(ErrorCode.InvalidInput,varTypeToken.getStartPos());
            }
        	expect(TokenType.SEMICOLON);
        	//�����������
            SymbolTable.insertVarEntry(level, varName, true, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
        
        }
        else if(nextIf(TokenType.ASSIGN)!=null){
        	rDataType = analyseExpr(TokenType.ASSIGN);//����ʽ�������
        	if(!datatype.equals(rDataType)) {
            	throw new AnalyzeError(ErrorCode.InvalidInput,varTypeToken.getStartPos());
            }
        	expect(TokenType.SEMICOLON);
        	//�����������
            SymbolTable.insertVarEntry(level, varName, true, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
        }
        else {
        	expect(TokenType.SEMICOLON);
        	//�����������
            SymbolTable.insertVarEntry(level, varName, false, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
        }
    }
    
    /**
     * �����ж�
     */
    
    /**
     * if_stmt -> 'if' expr block_stmt ('else' 'if' expr block_stmt)* ('else' block_stmt)?
     */
    private void analyseIfStmt() throws CompileError {
        expect(TokenType.IF_KW);
        analyseExpr(TokenType.IF_KW);//����ʽ
        analyseBlockStmt();
        while(nextIf(TokenType.ELSE_KW)!=null){
            if(nextIf(TokenType.IF_KW)!=null){
                analyseExpr(TokenType.IF_KW);//����ʽ�������
                analyseBlockStmt();
            }
            analyseBlockStmt();
        }
    }

    /**
     * while_stmt -> 'while' expr block_stmt
     */
    private void analyseWhileStmt() throws CompileError {
        expect(TokenType.WHILE_KW);
        analyseExpr(TokenType.WHILE_KW);//����ʽ�������
        analyseBlockStmt();
    }

    /**
     * break_stmt -> 'break' ';'
     */
    private void analyseBreakStmt() throws CompileError {
        expect(TokenType.BREAK_KW);
        expect(TokenType.SEMICOLON);
    }

    /**
     * continue_stmt -> 'continue' ';'
     */
    private void analyseContinueStmt() throws CompileError {
        expect(TokenType.CONTINUE_KW);
        expect(TokenType.SEMICOLON);
    }

    /**
     * return_stmt -> 'return' expr? ';'
     */
    private void ananlyseReturnStmt() throws CompileError {
    	DataType dataType = null;
        Token token = expect(TokenType.RETURN_KW);
        if(nextIf(TokenType.SEMICOLON)==null){
            dataType = analyseExpr(TokenType.RETURN_KW);  //����ʽ�������
            if(dataType==null) {
            	throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos()); 
            }
            else if(!dataType.equals(nowReturn)) {
            	throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
            }
            expect(TokenType.SEMICOLON);
        }
        this.ifReturn[this.level] = 1;
//    	System.out.println("num:"+level+" ifret:"+this.ifReturn[level]);
    }

    /**
     * expr_stmt -> expr ';'
     */
    private void analyseExprStmt() throws CompileError {
        analyseAssignExpr();//�������ܵĸ�ֵ����ʽ
        expect(TokenType.SEMICOLON);
    }
    
    /**
     * ��ֵ����ʽ���п�����ת������ֵΪvoid�ĺ�������ʽ����
     * @throws CompileError
     */
    private DataType analyseAssignExpr() throws CompileError {
    	DataType leftDataType = DataType.VOID;
    	DataType rightDataType = DataType.VOID;
    	VarEntry varEntry = null;
    	var nameToken = expect(TokenType.IDENT);
    	if(SymbolTable.findFunctionEntry((String)nameToken.getValue())!=null){
        	return analyseFunction(nameToken);
        }
    	/**
         * assign_expr -> l_expr '=' expr
         */
    	else if(SymbolTable.findVarEntry((String)nameToken.getValue())!=null){
    		varEntry = SymbolTable.findVarEntry((String)nameToken.getValue());
    		leftDataType = varEntry.datatype;
    		expect(TokenType.ASSIGN);
    		rightDataType = analyseExpr(TokenType.ASSIGN);//����ʽ�������
    		if(!leftDataType.equals(rightDataType)) {
    			throw new AnalyzeError(ErrorCode.InvalidAssignment,nameToken.getStartPos());
    		}
    		else if(varEntry.isConstant==true) {
    			throw new AnalyzeError(ErrorCode.InvalidAssignment,nameToken.getStartPos());
    		}
    	}
    	else {
    		throw new AnalyzeError(ErrorCode.InvalidAssignment,nameToken.getStartPos());
    	}
    	return DataType.VOID;
    }
    
    /**
     * ��������ʽ
     * @param functionToken
     * @return
     * @throws CompileError
     */
    private DataType analyseFunction(Token functionToken) throws CompileError {
    	FunctionEntry functionEntry = SymbolTable.findFunctionEntry((String)functionToken.getValue());
    	DataType getDataType = null, baseDataType = null;
    	int i = 0;
    	expect(TokenType.L_PAREN);
    	LPNum ++;
    	functionLPRecent.add(LPNum);
    	if(!check(TokenType.R_PAREN)){
    		/**
    	     * call_param_list -> expr (',' expr)*
    	     */
    		getDataType = analyseExpr(TokenType.L_PAREN);//����ʽ�������
    		baseDataType = functionEntry.getArgData(i);
    		if(baseDataType==null) {
    			throw new AnalyzeError(ErrorCode.InvalidInput,functionToken.getStartPos());
    		}
    		else if(!baseDataType.equals(getDataType)) {
    			throw new AnalyzeError(ErrorCode.InvalidInput,functionToken.getStartPos());
    		}
	        while(check(TokenType.COMMA)){
	            expect(TokenType.COMMA);
	            getDataType = analyseExpr(TokenType.COMMA);//����ʽ�������
	            i ++;
	    		baseDataType = functionEntry.getArgData(i);
	    		if(baseDataType==null) {
	    			throw new AnalyzeError(ErrorCode.InvalidInput,functionToken.getStartPos());
	    		}
	    		else if(!baseDataType.equals(getDataType)) {
	    			throw new AnalyzeError(ErrorCode.InvalidInput,functionToken.getStartPos());
	    		}
	        }
	    }
	    expect(TokenType.R_PAREN);
	    LPNum --;
    	functionLPRecent.remove(functionLPRecent.size()-1);
    	return functionEntry.datatype;
    }
    
    /**
     * expr -> 
     * operator_expr
     * | negate_expr
     * | assign_expr
     * | as_expr
     * | call_expr
     * | literal_expr
     * | ident_expr
     * | group_expr
     */
    private DataType analyseExpr(TokenType recent) throws CompileError {
    	OperatorStack stack = new OperatorStack();
    	DataType ret = DataType.VOID;
    	Token token = null;
    	stack.push(TokenType.STOP);
    	
    	/** 
         * + - 					PLUS MINUS 
         * ǰ��- 				NEGATE
         * * \ 					MUL DIV 
         * == != < > <= >= 		EQ NEQ LT GT LE GE
         * as 					AS_KW 
         * uint double ident 	UINT_LITERAL DOUBLE_LITERAL IDENT
         * ( 					L_PAREN 
         * ) 					R_PAREN
         * # 					STOP
        */
    	/**
    	 * + - * \ == != < > <= >= AS_KW IDENT ( ) #
    	 */
        while(true) {
        	if(check(TokenType.PLUS)) {//+
        		recent = TokenType.PLUS;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.MINUS)) {//- '-'
        		token = seekIf(TokenType.MINUS);
        		/**
        		 * ASSIGN IF_KW WHILE_KW RETURN_KW ( + - * \ < > <= >= == != 
        		 */
        		if(recent.equals(TokenType.ASSIGN)||recent.equals(TokenType.IF_KW)||recent.equals(TokenType.WHILE_KW)||recent.equals(TokenType.RETURN_KW)||recent.equals(TokenType.L_PAREN)||recent.equals(TokenType.PLUS)||recent.equals(TokenType.MINUS)||recent.equals(TokenType.MUL)||recent.equals(TokenType.DIV)||recent.equals(TokenType.EQ)||recent.equals(TokenType.NEQ)||recent.equals(TokenType.GE)||recent.equals(TokenType.GT)||recent.equals(TokenType.LE)||recent.equals(TokenType.LT)) {
        			recent = TokenType.NEGATE;
        			int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
	        		if(priorty[i][j] == 0) {
	        			next();
	        			stack.push(recent);
	        		}
	        		else if(priorty[i][j] == 3) {
	        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
	        		}
        		}
        		else {
	        		recent = TokenType.MINUS;
	        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
	        		if(priorty[i][j] == 0) {
	        			next();
	        			stack.push(recent);
	        		}
	        		else if(priorty[i][j] == 1) {
	        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])) {
	        				stackEoE(stack, token);
	        			}
	        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
	        				stackoEo(stack, token);
	        			}
	        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
	        				stackoE(stack, token);
	        			}
	        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
	        				stackEoT(stack, token);
	        			}
	        			else if(judgeNum(priortyToken[i])) {
	        				stacko(stack, token);
	        			}
	        		}
        		}
        	}
        	else if(check(TokenType.MUL)) {//*
        		recent = TokenType.MUL;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgeMD(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.DIV)) {//\
        		recent = TokenType.DIV;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgeMD(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.EQ)) {//==
        		recent = TokenType.EQ;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.NEQ)) {//!=
        		recent = TokenType.NEQ;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.LT)) {//<
        		recent = TokenType.LT;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.LE)) {//<=
        		recent = TokenType.LE;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.GT)) {//>
        		recent = TokenType.GT;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.GE)) {//>=
        		recent = TokenType.GE;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.AS_KW)) {//as
        		recent = TokenType.AS_KW;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 1) {
        			if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        	}
        	else if(check(TokenType.UINT_LITERAL)) {//IDENT
        		recent = TokenType.UINT_LITERAL;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(TokenType.UINT_LITERAL);
        		}
        		else if(priorty[i][j] == 3) {
        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
        		}
        	}
        	else if(check(TokenType.DOUBLE_LITERAL)) {//IDENT
        		recent = TokenType.DOUBLE_LITERAL;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			stack.push(TokenType.DOUBLE_LITERAL);
        		}
        		else if(priorty[i][j] == 3) {
        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
        		}
        	}
        	else if(check(TokenType.IDENT)) {//IDENT
        		if(recent.equals(TokenType.AS_KW)) {
        			recent = TokenType.IDENT;
            		token = seekIf(recent);
            		if(((String)token.getValue()).equals("int")) {
            			next();
            			stack.push(DataKeywordType.INT_KW);
            		}
            		else if(((String)token.getValue()).equals("double")) {
            			next();
            			stack.push(DataKeywordType.DOUBLE_KW);
            		}
        		}
        		else {
        			recent = TokenType.IDENT;
            		token = seekIf(recent);
	        		if(SymbolTable.findFunctionEntry((String)token.getValue())!=null){
	        			next();
	        			stack.push(analyseFunction(token));
	        		}
	        		else if(SymbolTable.findVarEntry((String)token.getValue())!=null){
		        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
		        		if(priorty[i][j] == 0) {
		        			next();
		        			if(SymbolTable.findVarEntry((String)token.getValue()).datatype.equals(DataType.INT)) {
		        				stack.push(TokenType.UINT_LITERAL);
		        			}
		        			else if(SymbolTable.findVarEntry((String)token.getValue()).datatype.equals(DataType.DOUBLE)) {
		        				stack.push(TokenType.DOUBLE_LITERAL);
		        			}
		        		}
		        		else if(priorty[i][j] == 3) {
		        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		        		}
	        		}
	        		else {
	        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
	        		}
        		}
        	}
        	else if(check(TokenType.L_PAREN)) {//(
        		recent = TokenType.L_PAREN;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 0) {
        			next();
        			LPNum ++;
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 3) {
        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
        		}
        	}
        	else if(check(TokenType.R_PAREN)&&(LPNum > (int)functionLPRecent.get(functionLPRecent.size()-1))) {//)
        		recent = TokenType.R_PAREN;
        		token = seekIf(recent);
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(recent);
        		if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        		}
        		else if(priorty[i][j] == 2) {
        			next();
        			LPNum --;
        			stack.push(recent);
        		}
        		else if(priorty[i][j] == 3) {
        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
        		}
        	}
        	else {//#
        		TokenType stop = TokenType.STOP;
        		int i = enumToInt(stack.getTopToken()), j = enumToInt(stop);
        		if(priorty[i][j] == 1) {
        			if(judgePM(priortyToken[i])||judgeMD(priortyToken[i])||judgeCMP(priortyToken[i])) {
        				stackEoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.R_PAREN)) {
        				stackoEo(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.NEGATE)) {
        				stackoE(stack, token);
        			}
        			else if(priortyToken[i].equals(TokenType.AS_KW)) {
        				stackEoT(stack, token);
        			}
        			else if(judgeNum(priortyToken[i])) {
        				stacko(stack, token);
        			}
        		}
        		else if(priorty[i][j] == 3) {
        			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
        		}
        		else if(priorty[i][j] == 4) {//����
        			ret = (DataType)stack.getTop();
        			break;
        		}
        	}
        }
		return ret;
    }
    
    /** 
     * + - * \ < > <= >= == != ����
     * EoE��
     * @throws AnalyzeError 
     */
    private OperatorStack stackEoE(OperatorStack stack, Token token) throws AnalyzeError {
    	DataType dataType = null;
    	TokenType tokenType = token.getTokenType();
    	Object first = stack.getTop();
		Object second = stack.getSecond();
		Object third = stack.getThird();
		if((first instanceof DataType)&&(second instanceof TokenType)&&(third instanceof DataType)) {
			dataType = (DataType)first;
			if(dataType.equals((DataType)third)){
				stack.pop();
				stack.pop();
				stack.pop();
				stack.push(dataType);
			}
			else {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		}
    	return stack;
    }
    
    /**
     * ( ) ����
     * oEo��
     */
    private OperatorStack stackoEo(OperatorStack stack, Token token) throws AnalyzeError {
    	DataType dataType = null;
    	TokenType tokenType = token.getTokenType();
    	Object first = stack.getTop();
		Object second = stack.getSecond();
		Object third = stack.getThird();
		if((first instanceof TokenType)&&(second instanceof DataType)&&(third instanceof TokenType)) {
			dataType = (DataType)second;
			if(TokenType.R_PAREN.equals((TokenType)first)&&TokenType.L_PAREN.equals((TokenType)third)){
				stack.pop();
				stack.pop();
				stack.pop();
				stack.push(dataType);
			}
			else {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		}
		return stack;
    }
    
    /**
     * '-' ǰ�ø��Ų���
     * oE��
     */
    private OperatorStack stackoE(OperatorStack stack, Token token) throws AnalyzeError {
    	DataType dataType = null;
    	TokenType tokenType = token.getTokenType();
    	Object first = stack.getTop();
		Object second = stack.getSecond();
		if((first instanceof DataType)&&(second instanceof TokenType)) {
			dataType = (DataType)first;
			stack.pop();
			stack.pop();
			stack.push(dataType);
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		}
		return stack;
    }
    
    /**
     * AS����
     * EoT��
     */
    private OperatorStack stackEoT(OperatorStack stack, Token token) throws AnalyzeError {
    	DataType dataType = null;
    	TokenType tokenType = token.getTokenType();
    	Object first = stack.getTop();
		Object second = stack.getSecond();
		Object third = stack.getThird();
		if((first instanceof DataKeywordType)&&(second instanceof TokenType)&&(third instanceof DataType)) {
			dataType = (DataType)third;
			if(DataKeywordType.INT_KW.equals((DataKeywordType)first)){
				stack.pop();
				stack.pop();
				stack.pop();
				stack.push(DataType.INT);
			}
			else if(DataKeywordType.DOUBLE_KW.equals((DataKeywordType)first)){
				stack.pop();
				stack.pop();
				stack.pop();
				stack.push(DataType.DOUBLE);
			}
			else {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		}
    	return stack;
    }
    
    /**
     * ����ת��type
     * o��
     * @param stack
     * @param token
     * @return
     * @throws AnalyzeError
     */
    private OperatorStack stacko(OperatorStack stack, Token token) throws AnalyzeError {
    	DataType dataType = null;
    	TokenType tokenType = token.getTokenType();
    	Object first = stack.getTop();
		if((first instanceof TokenType)) {
			if(TokenType.UINT_LITERAL.equals((TokenType)first)){
				stack.pop();
				dataType = DataType.INT;
				stack.push(dataType);
			}
			else if(TokenType.DOUBLE_LITERAL.equals((TokenType)first)){
				stack.pop();
				dataType = DataType.DOUBLE;
				stack.push(dataType);
			}
			else {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		}
    	return stack;
    }
    
    /**
     * �ж��ǲ���+-
     */
    private boolean judgePM(TokenType tokenType) {
    	return (TokenType.PLUS.equals(tokenType)||TokenType.MINUS.equals(tokenType));
    }
    
    /**
     * �ж��ǲ���*\
     */
    private boolean judgeMD(TokenType tokenType) {
    	return (TokenType.MUL.equals(tokenType)||TokenType.DIV.equals(tokenType));
    }
    
    /**
     * �ж��ǲ���<> <= >= == !=
     */
    private boolean judgeCMP(TokenType tokenType) {
    	return (TokenType.LT.equals(tokenType)||TokenType.LE.equals(tokenType)||TokenType.GT.equals(tokenType)||TokenType.GE.equals(tokenType)||TokenType.EQ.equals(tokenType)||TokenType.NEQ.equals(tokenType));
    }
    
    /**
     * �ж��ǲ��� uint double
     */
    private boolean judgeNum(TokenType tokenType) {
    	return (TokenType.UINT_LITERAL.equals(tokenType)||TokenType.DOUBLE_LITERAL.equals(tokenType));
    }
}

