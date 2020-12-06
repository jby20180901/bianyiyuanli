package miniplc0java.analyser;

import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.Stack;

import miniplc0java.error.AnalyzeError;
import miniplc0java.error.CompileError;
import miniplc0java.error.ErrorCode;
import miniplc0java.error.ExpectedTokenError;
import miniplc0java.error.TokenizeError;
import miniplc0java.instructioner.*;
import miniplc0java.tokenizer.Token;
import miniplc0java.tokenizer.TokenType;
import miniplc0java.tokenizer.Tokenizer;
import miniplc0java.util.Pos;
import miniplc0java.symboltable.FunctionEntry;
import miniplc0java.symboltable.SymbolTable;
import miniplc0java.symboltable.SymbolType;
import miniplc0java.symboltable.VarEntry;
import miniplc0java.symboltable.DataKeywordType;
import miniplc0java.symboltable.DataType;

public final class Analyser {
	Tokenizer tokenizer;
	Assembler assembler;//汇编器
	int level = 0;//层数
	private int functionOffset = 0;//函数偏移量
	private int[][] priorty = new int[100][100];
	private TokenType[] priortyToken = new TokenType[20];
	ArrayList<Object> functionLPRecent = new ArrayList<>();
	FunctionEntry nowFunc = null;
	FunctionDef _start = new FunctionDef();
	int ifReturn[] = new int[1000];
	boolean isVoid = false;
	int LPNum = 0;
	DataType nowReturn = null; //当前返回值类型
	boolean isInLoop = false;	//当前在循环体内部
	Instruction in ;
	int whileLevel = -1;
	/** 当前偷看的 token */
	Token peekedToken = null;

	/** 大括号信号量 */
	int brace = 0;

	/** 下一个变量的栈偏移 */
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
		this.assembler = new Assembler();
		assembler.addFunctionDef(_start,"_start");
		_start = assembler.findFunctionDef("_start");
		/**
		 * + - 					PLUS MINUS
		 * 前置- 				NEGATE
		 * * \ 					MUL DIV
		 * == != < > <= >= 		EQ NEQ LT GT LE GE
		 * as 					AS_KW
		 * uint double ident 	UINT_LITERAL DOUBLE_LITERAL IDENT
		 * ( 					L_PAREN
		 * ) 					R_PAREN
		 * # 					STOP
		 */
		/**
		 * 0代表<
		 * 1代表>
		 * 2代表=
		 * 3代表X
		 * 4代表结束
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
		for(int i=0;i<18;i++) {//栈内 左
			for(int j=0;j<18;j++) {//栈外 右
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
		functionLPRecent.add(-1000);
	}

	public byte[] Assemble() {
		return this.assembler.toByte();
	}

	public String AssembleTo() {
		return this.assembler.toString();
	}

	public void analyse() throws CompileError {
		SymbolTable.levelup();
		initSystemcall();
		analyseProgram();
		startAtMain();
	}

	/**
	 * 查看下一个 Token
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
	 * 获取下一个 Token
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
	 * 如果下一个 token 的类型是 tt，则返回 true
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
	 * 如果下一个 token 的类型是 tt，则前进一个 token 并返回这个 token
	 *
	 * @param tt 类型
	 * @return 如果匹配则返回这个 token，否则返回 null
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
	 * 如果下一个 token 的类型是 tt，则前进一个 token 并返回这个 token
	 *
	 * @param tt 类型
	 * @return 如果匹配则返回这个 token，否则返回 null
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
	 * 如果下一个 token 的类型是 tt，则前进一个 token 并返回，否则抛出异常
	 *
	 * @param tt 类型
	 * @return 这个 token
	 * @throws CompileError 如果类型不匹配
	 */
	private Token expect(TokenType tt) throws CompileError {
		var token = peek();
		if (token.getTokenType() == tt) {
			return next();
		} else {
			throw new ExpectedTokenError(tt, token);
		}
	}

	private void putInstruction(Instruction in){
		if(nowFunc == null) {//这里是全局空间
			_start.putInstruction(in);
		}
		else {
			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
			funcDef.putInstruction(in);
		}
	}

	private void getlocal(String varname){
		Instruction in ;
		VarEntry var = SymbolTable.findVarEntry(varname);
		if(var.level == 0){
			in = new Instruction(InstructionType.globa, var.offset);
		}
		else if(nowFunc.findArgs(varname)!=null){
			in = new Instruction(InstructionType.arga, nowFunc.findArgsID(varname));
		}
		else{
			in = new Instruction(InstructionType.loca, var.offset);
			System.out.println("llllllllllllllllllllllllllllllllllllllllll"+var.offset);
		}
		if(nowFunc == null) {//这里是全局空间
			_start.putInstruction(in);
		}
		else {
			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
			funcDef.putInstruction(in);
		}
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
//		in = new Instruction(InstructionType.print_i);//////
//		funcDef.putInstruction(in);//////
	}


	/**
	 * 读入一个有符号整数
	 * fn getint() -> int
	 * 读入一个浮点数
	 * fn getdouble() -> double
	 * 读入一个字符
	 * fn getchar() -> int
	 * 输出一个整数
	 * fn putint(int) -> void
	 * 输出一个浮点数
	 * fn putdouble(double) -> void
	 * 输出一个字符
	 * fn putchar(int) -> void
	 * 将编号为这个整数的全局常量看作字符串输出
	 * fn putstr(int) -> void
	 * 输出一个换行
	 * fn putln() -> void
	 * @throws CompileError
	 */
	private void initSystemcall() throws CompileError {
		Pos startPos = new Pos(0,0);
		GlobalDef funcDef;
		/**
		 * 读入一个有符号整数
		 * fn getint() -> int
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("getint", SymbolType.Function, DataType.INT, functionOffset, startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("getint"));
		assembler.addGlobalDef(funcDef, "getint");
		/**
		 * 读入一个浮点数
		 * fn getdouble() -> double
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("getdouble", SymbolType.Function, DataType.DOUBLE, functionOffset, startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("getdouble"));
		assembler.addGlobalDef(funcDef, "getdouble");
		/**
		 * 读入一个字符
		 * fn getchar() -> int
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("getchar", SymbolType.Function, DataType.INT, functionOffset, startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("getchar"));
		assembler.addGlobalDef(funcDef, "getchar");
		/**
		 * 输出一个整数
		 * fn putint(int) -> void
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("putint", SymbolType.Function, DataType.VOID, functionOffset, startPos);
		//这层增加这个参数
		SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.INT, 1, startPos);
		//函数增加一个参数
		SymbolTable.updateFunctionCallList("putint", "x", startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("putint"));
		assembler.addGlobalDef(funcDef, "putint");
		/**
		 * 输出一个浮点数
		 * fn putdouble(double) -> void
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("putdouble", SymbolType.Function, DataType.VOID, functionOffset, startPos);
		//这层增加这个参数
		SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.DOUBLE, 1, startPos);
		//函数增加一个参数
		SymbolTable.updateFunctionCallList("putdouble", "x", startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("putdouble"));
		assembler.addGlobalDef(funcDef, "putdouble");
		/**
		 * 输出一个字符
		 * fn putchar(int) -> void
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("putchar", SymbolType.Function, DataType.VOID, functionOffset, startPos);
		//这层增加这个参数
		SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.INT, 1, startPos);
		//函数增加一个参数
		SymbolTable.updateFunctionCallList("putchar", "x", startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("putchar"));
		assembler.addGlobalDef(funcDef, "putchar");
		/**
		 * 将编号为这个整数的全局常量看作字符串输出
		 * fn putstr(int) -> void
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("putstr", SymbolType.Function, DataType.VOID, functionOffset, startPos);
		//这层增加这个参数
		SymbolTable.insertVarEntry(1, "x", true, false, SymbolType.Variable, DataType.INT, 1, startPos);
		//函数增加一个参数
		SymbolTable.updateFunctionCallList("putstr", "x", startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("putstr"));
		assembler.addGlobalDef(funcDef, "putstr");
		/**
		 * 输出一个换行
		 * fn putln() -> void
		 */
		level ++;
		SymbolTable.levelup();
		SymbolTable.insertFunctionEntry("putln", SymbolType.Function, DataType.VOID, functionOffset, startPos);
		level --;
		SymbolTable.leveldown();
		funcDef = new GlobalDef(true, SymbolTable.findFunctionEntry("putln"));
		assembler.addGlobalDef(funcDef, "putln");
	}

	/**
	 *
	 * @throws CompileError
	 */
	private void startAtMain() throws CompileError {
		Pos pos = new Pos(0,0);
		if(SymbolTable.findFunctionEntry("main") != null) {
			in = new Instruction(InstructionType.stackalloc, assembler.findFunctionDef("main").getReturnSlots());
			_start.putInstruction(in);
			in = new Instruction(InstructionType.call, assembler.findFunctionDefID(assembler.findFunctionDef("main")));
			_start.putInstruction(in);
			GlobalDef funcDef = new GlobalDef(true, "_start");
			assembler.addGlobalDef(funcDef, "_start");
		}
		else {
			throw new AnalyzeError(ErrorCode.NoBegin,pos);
		}
	}

	/**
	 * program -> item*
	 */
	private void analyseProgram() throws CompileError {
		//循环检查是否程序尾部
		while(!check(TokenType.EOF)){
			analyseItem();
		}
		expect(TokenType.EOF);
	}


	/**
	 * item -> function | decl_stmt
	 */
	private void analyseItem() throws CompileError {
		// 检查第一个单词是不是fn
		if(check(TokenType.FN_KW)){
			analyseFuc();
		}
		//检查是不是变量声明语句
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
		DataType datatype = null;//返回值类型
		FunctionEntry functionEntry;//生成的函数符号
		GlobalDef funcDef;
		FunctionDef funcDefi;
		String fucName;//函数名称
		int offset = 0;
		// 检查第一个单词是不是fn
		expect(TokenType.FN_KW);
		var fucNameToken = expect(TokenType.IDENT);
		fucName = (String) fucNameToken.getValue();
		functionEntry = SymbolTable.insertFunctionEntry(fucName, SymbolType.Function, null, functionOffset,fucNameToken.getStartPos());
		expect(TokenType.L_PAREN);
		LPNum ++;
		level ++;
		SymbolTable.levelup();
		if(!TokenType.R_PAREN.equals(peek().getTokenType())) {
			/*offset = */analyseFuncList(fucNameToken);
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
		System.out.println("nowReturn:"+nowReturn);
		funcDef = new GlobalDef(true, functionEntry);
		assembler.addGlobalDef(funcDef, functionEntry.name);
		funcDefi = new FunctionDef(functionEntry);
		assembler.addFunctionDef(funcDefi, functionEntry.name);
		funcDefi.updateNameOffset(assembler.findGlobalDefID(funcDef));
		nowFunc = functionEntry;
		analyseFucBlockStmt();
		if((!funcDefi.isRet)&&(DataType.VOID.equals(datatype))){
			in = new Instruction(InstructionType.ret);
			funcDefi.putInstruction(in);
		}
		nowFunc = null;
//        checkFlow();
	}

	/**
	 * function_param_list -> function_param (',' function_param)*
	 */
	private int analyseFuncList(Token fucNameToken) throws CompileError {
		int offset = 0;
		analyseFucPara(fucNameToken,offset);
		offset ++;
		while(nextIf(TokenType.COMMA)!=null){
			analyseFucPara(fucNameToken,offset);
			offset ++;
		}
		return offset;
	}

	/**
	 * function_param -> const? IDENT ':' ty
	 */
	private void analyseFucPara(Token fucNameToken,int offset) throws CompileError {
		DataType datatype = null;//数据类型
		SymbolType symbolType = null;
		String varName = null;//参数名
		String fucName = (String)fucNameToken.getValue();//函数名
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
		//这层增加这个参数
		SymbolTable.insertVarEntry(level, varName, true, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
		//函数增加一个参数
		SymbolTable.updateFunctionCallList(fucName, varName, varTypeToken.getStartPos());
	}

	/**
	 * 设置控制流
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
	 * 检查控制流
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
	private boolean analyseBlockStmt() throws CompileError {
		boolean haveStmt = true;
		level ++;
		SymbolTable.levelup();
		this.ifReturn[level] = 0;
		expect(TokenType.L_BRACE);
		int thisLevel  = level;
		if(check(TokenType.R_BRACE)) {
			haveStmt = false;
		}
		while(!(check(TokenType.R_BRACE)&&(level == thisLevel))){
			analyseStmt();
		}
		expect(TokenType.R_BRACE);
		setFlow();
		level --;
		SymbolTable.leveldown();
		return haveStmt;
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
		DataType datatype = null ,rDataType = null;//数据类型
		SymbolType symbolType = null;
		String varName = null;//参数名
		boolean isConst = false;
		int offset = 0;
		// 检查第一个单词是不是let const
		if(nextIf(TokenType.CONST_KW)!=null) {
			isConst = true;
			symbolType = SymbolType.Constant;
		}
		else if(nextIf(TokenType.LET_KW)!=null)  {
			symbolType = SymbolType.Variable;
		}
		//String fucName = (String)fucNameToken.getValue();//函数名
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
		if(nowFunc == null) {//这里是全局空间
			GlobalDef varDef = new GlobalDef(isConst, (DataType.INT.equals(datatype)?(long)0:(double)0.0));
			assembler.addGlobalDef(varDef, varName);
			offset = assembler.findGlobalDefID(varDef);
		}
		else{
			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
			offset = funcDef.getLocSlots();
			funcDef.updateLocSlots(funcDef.getLocSlots()+1);
			nowFunc.offset ++;
		}
		if(isConst) {
			expect(TokenType.ASSIGN);
			if(nowFunc == null) {//这里是全局空间
				in = new Instruction(InstructionType.globa, offset);//global offset
				putInstruction(in);
			}
			else {
				in = new Instruction(InstructionType.loca, offset);//lobal offset
				putInstruction(in);
			}
			rDataType = analyseExpr(TokenType.ASSIGN);//表达式整体分析
			if(!datatype.equals(rDataType)) {
				throw new AnalyzeError(ErrorCode.InvalidInput,varTypeToken.getStartPos());
			}
			expect(TokenType.SEMICOLON);
			in = new Instruction(InstructionType.store_64);//store.64
			putInstruction(in);
			//增加这个变量
			SymbolTable.insertVarEntry(level, varName, true, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());

		}
		else if(nextIf(TokenType.ASSIGN)!=null){
			if(nowFunc == null) {//这里是全局空间
				in = new Instruction(InstructionType.globa, offset);//global offset
				putInstruction(in);
			}
			else {
				in = new Instruction(InstructionType.loca, offset);//lobal offset
				putInstruction(in);
			}
			rDataType = analyseExpr(TokenType.ASSIGN);//表达式整体分析
			if(!datatype.equals(rDataType)) {
				throw new AnalyzeError(ErrorCode.InvalidInput,varTypeToken.getStartPos());
			}
			expect(TokenType.SEMICOLON);
			in = new Instruction(InstructionType.store_64);//store.64
			putInstruction(in);
			//增加这个变量
			SymbolTable.insertVarEntry(level, varName, true, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
		}
		else {
			expect(TokenType.SEMICOLON);
			//增加这个变量
			SymbolTable.insertVarEntry(level, varName, false, isConst, symbolType, datatype, offset, varTypeToken.getStartPos());
		}
		VarEntry varEntry = SymbolTable.findVarEntry(varName, level);
		varEntry.offset = offset;
//		if(nowFunc == null) {//这里是全局空间
//			if(rDataType!=null) {
//				;
//			}
//		}
//		else {
//			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
//			funcDef.updateLocSlots(funcDef.getLocSlots()+1);
//			nowFunc.offset ++;
//		}
	}

	/**
	 * 条件判断
	 */

	/**
	 * if_stmt -> 'if' expr block_stmt ('else' 'if' expr block_stmt)* ('else' block_stmt)?
	 */
	private void analyseIfStmt() throws CompileError {
		ArrayList<Instruction> brList = new ArrayList<>();
		ArrayList<Integer> brOpList = new ArrayList<>();
		Instruction newIn, In;
		boolean checkDucElse = false;
		int start = 0, end = 0;
		expect(TokenType.IF_KW);
		analyseExpr(TokenType.IF_KW);//表达式
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		start = funcDef.getInstructionLength();
		In = new Instruction(InstructionType.br,0);
		funcDef.putInstruction(In);
		analyseBlockStmt();
		end = funcDef.getInstructionLength();
		In.setX(end-start);
		newIn = new Instruction(InstructionType.br,0);
		funcDef.putInstruction(newIn);
		brList.add(newIn);
		brOpList.add(funcDef.getInstructionLength());
		while(nextIf(TokenType.ELSE_KW)!=null){
			if(nextIf(TokenType.IF_KW)!=null){
				analyseExpr(TokenType.IF_KW);//表达式整体分析
				start = funcDef.getInstructionLength();
				In = new Instruction(InstructionType.br,0);
				funcDef.putInstruction(In);
				analyseBlockStmt();
				end = funcDef.getInstructionLength();
				In.setX(end-start);
				newIn = new Instruction(InstructionType.br,0);
				funcDef.putInstruction(newIn);
				brList.add(newIn);
				brOpList.add(funcDef.getInstructionLength());
			}
			else {
				if(!checkDucElse) {
					checkDucElse = true;
				}
				else {
					throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
				}
				analyseBlockStmt();
				newIn = new Instruction(InstructionType.br,0);
				funcDef.putInstruction(newIn);
				brList.add(newIn);
				brOpList.add(funcDef.getInstructionLength());
			}
		}
		int ends = funcDef.getInstructionLength();
		for(int i = 0; i < brList.size(); i ++){
			brList.get(i).setX(ends - brOpList.get(i));
		}
		newIn = new Instruction(InstructionType.br,0);
		funcDef.putInstruction(newIn);
	}

	/**
	 * while_stmt -> 'while' expr block_stmt
	 */
	private void analyseWhileStmt() throws CompileError {
		Instruction newIn, In;
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		int start = 0, end = 0,start1 = 0, end1 = 0;
		In = new Instruction(InstructionType.br, 0);
		funcDef.putInstruction(In);
		start = funcDef.getInstructionLength();
		expect(TokenType.WHILE_KW);
		analyseExpr(TokenType.WHILE_KW);//表达式整体分析
		whileLevel ++;
		SymbolTable.whileLevelup();
		isInLoop = true;
		newIn = new Instruction(InstructionType.br, 0);
		funcDef.putInstruction(newIn);
		start1 = funcDef.getInstructionLength();
		analyseBlockStmt();
		In = new Instruction(InstructionType.br, 0);
		funcDef.putInstruction(In);
		end = end1 = funcDef.getInstructionLength();
		newIn.setX(end1-start1);
		In.setX(start-end);
		isInLoop = false;
		while(!SymbolTable.breakInstructionList.get(whileLevel).empty()){
			int offset = (int)SymbolTable.breakInstructionList.get(whileLevel).pop();
			In = (Instruction) SymbolTable.breakInstructionList.get(whileLevel).pop();
			In.setX(end1 - offset);
		}
		while(!SymbolTable.continueInstructionList.get(whileLevel).empty()){
			int offset = (int)SymbolTable.continueInstructionList.get(whileLevel).pop();
			In = (Instruction) SymbolTable.continueInstructionList.get(whileLevel).pop();
			In.setX(start - offset);
		}
		whileLevel --;
		SymbolTable.whileLeveldown();
	}

	/**
	 * break_stmt -> 'break' ';'
	 */
	private void analyseBreakStmt() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		if(!isInLoop) {
			throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
		}
		expect(TokenType.BREAK_KW);
		expect(TokenType.SEMICOLON);
		in = new Instruction(InstructionType.br, 0);
		funcDef.putInstruction(in);
		SymbolTable.breakInstructionList.get(whileLevel).push(in);
		SymbolTable.breakInstructionList.get(whileLevel).push(funcDef.getInstructionLength());
	}

	/**
	 * continue_stmt -> 'continue' ';'
	 */
	private void analyseContinueStmt() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		if(!isInLoop) {
			throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
		}
		expect(TokenType.CONTINUE_KW);
		expect(TokenType.SEMICOLON);
		in = new Instruction(InstructionType.br, 0);
		funcDef.putInstruction(in);
		SymbolTable.continueInstructionList.get(whileLevel).push(in);
		SymbolTable.continueInstructionList.get(whileLevel).push(funcDef.getInstructionLength());
	}

	/**
	 * return_stmt -> 'return' expr? ';'
	 */
	private void ananlyseReturnStmt() throws CompileError {
		DataType dataType = null;
		Token token = expect(TokenType.RETURN_KW);
		FunctionDef funcDefi = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.arga, 0);
		funcDefi.putInstruction(in);
		if(nextIf(TokenType.SEMICOLON)==null){
			dataType = analyseExpr(TokenType.RETURN_KW);  //表达式整体分析
			if(dataType==null) {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
			else if(!dataType.equals(nowReturn)) {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
			expect(TokenType.SEMICOLON);
			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
			in = new Instruction(InstructionType.store_64);
			funcDef.putInstruction(in);
			in = new Instruction(InstructionType.ret);
			funcDef.putInstruction(in);
		}
		else {
			dataType = DataType.VOID;  //表达式整体分析
			if(dataType==null) {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
			else if(!dataType.equals(nowReturn)) {
				throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
			}
			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
			in = new Instruction(InstructionType.ret);
			funcDef.putInstruction(in);
		}
		this.ifReturn[this.level] = 1;
//    	System.out.println("num:"+level+" ifret:"+this.ifReturn[level]);
	}

	/**
	 * expr_stmt -> expr ';'
	 */
	private void analyseExprStmt() throws CompileError {
		analyseAssignExpr();//处理可能的赋值表达式
		expect(TokenType.SEMICOLON);
	}

	/**
	 * 赋值表达式，有可能跳转到返回值为void的函数表达式处理
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
			getlocal(nameToken.getValueString());
			expect(TokenType.ASSIGN);
			rightDataType = analyseExpr(TokenType.ASSIGN);//表达式整体分析
			if(!leftDataType.equals(rightDataType)) {
				throw new AnalyzeError(ErrorCode.InvalidAssignment,nameToken.getStartPos());
			}
			else if(varEntry.isConstant==true) {
				throw new AnalyzeError(ErrorCode.InvalidAssignment,nameToken.getStartPos());
			}
			varEntry.setInitialized(true);
			FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
			in = new Instruction(InstructionType.store_64);
			funcDef.putInstruction(in);
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidAssignment,nameToken.getStartPos());
		}
		return DataType.VOID;
	}

	/**
	 * 函数调用式
	 * @param functionToken
	 * @return
	 * @throws CompileError
	 */
	private DataType analyseFunction(Token functionToken) throws CompileError {
		FunctionEntry functionEntry = SymbolTable.findFunctionEntry((String)functionToken.getValue());
		DataType getDataType = null, baseDataType = null;
		int i = 0;
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		FunctionDef callFuncDef = assembler.findFunctionDef(functionEntry.name);
		expect(TokenType.L_PAREN);
		LPNum ++;
		functionLPRecent.add(LPNum);
		/**
		 * 读入一个有符号整数
		 * fn getint() -> int
		 * 读入一个浮点数
		 * fn getdouble() -> double
		 * 读入一个字符
		 * fn getchar() -> int
		 * 输出一个整数
		 * fn putint(int) -> void
		 * 输出一个浮点数
		 * fn putdouble(double) -> void
		 * 输出一个字符
		 * fn putchar(int) -> void
		 * 将编号为这个整数的全局常量看作字符串输出
		 * fn putstr(int) -> void
		 * 输出一个换行
		 * fn putln() -> void
		 * @throws CompileError
		 */
		boolean isSystemCall = false;
		if("getint".equals(functionEntry.name)) {
			getDataType = analyseGetint();
			isSystemCall = true;
		}
		else if("getdouble".equals(functionEntry.name)) {
			getDataType = analyseGetdouble();
			isSystemCall = true;
		}
		else if("getchar".equals(functionEntry.name)) {
			getDataType = analyseGetchar();
			isSystemCall = true;
		}
		else if("putint".equals(functionEntry.name)) {
			getDataType = analysePutint();
			isSystemCall = true;
		}
		else if("putdouble".equals(functionEntry.name)) {
			getDataType = analysePutdouble();
			isSystemCall = true;
		}
		else if("putchar".equals(functionEntry.name)) {
			getDataType = analysePutchar();
			isSystemCall = true;
		}
		else if("putstr".equals(functionEntry.name)) {
			getDataType = analysePutstr();
			isSystemCall = true;
		}
		else if("putln".equals(functionEntry.name)) {
			getDataType = analysePutln();
			isSystemCall = true;
		}
		if(!isSystemCall) {
			in = new Instruction(InstructionType.stackalloc, callFuncDef.getReturnSlots());
			funcDef.putInstruction(in);
		}
		if(!check(TokenType.R_PAREN)){
			/**
			 * call_param_list -> expr (',' expr)*
			 */
			getDataType = analyseExpr(TokenType.L_PAREN);//表达式整体分析
			baseDataType = functionEntry.getArgData(i);
			if(baseDataType==null) {
				throw new AnalyzeError(ErrorCode.InvalidInput,functionToken.getStartPos());
			}
			else if(!baseDataType.equals(getDataType)) {
				throw new AnalyzeError(ErrorCode.InvalidInput,functionToken.getStartPos());
			}
			while(check(TokenType.COMMA)){
				expect(TokenType.COMMA);
				getDataType = analyseExpr(TokenType.COMMA);//表达式整体分析
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
		if(!isSystemCall) {
			in = new Instruction(InstructionType.call, assembler.findFunctionDefID(assembler.findFunctionDef(functionEntry.name)));
			funcDef.putInstruction(in);
		}
		LPNum --;
		functionLPRecent.remove(functionLPRecent.size()-1);
		return functionEntry.datatype;
	}

	/**
	 * 读入一个有符号整数
	 * fn getint() -> int
	 */
	private DataType analyseGetint() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 1);
		funcDef.putInstruction(in);
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("getint")));
		funcDef.putInstruction(in);
		return DataType.INT;
	}

	/**
	 * 读入一个浮点数
	 * fn getdouble() -> double
	 */
	private DataType analyseGetdouble() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 1);
		funcDef.putInstruction(in);
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("getdouble")));
		funcDef.putInstruction(in);
		return DataType.DOUBLE;
	}

	/**
	 * 读入一个字符
	 * fn getchar() -> int
	 */
	private DataType analyseGetchar() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 1);
		funcDef.putInstruction(in);
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("getchar")));
		funcDef.putInstruction(in);
		return DataType.INT;
	}

	/**
	 * 输出一个整数
	 * fn putint(int) -> void
	 */
	private DataType analysePutint() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 0);
		funcDef.putInstruction(in);
		DataType putout = analyseExpr(TokenType.L_PAREN);
		if(!DataType.INT.equals(putout)) {
			throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
		}
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("putint")));
		funcDef.putInstruction(in);
		return DataType.VOID;
	}

	/**
	 * 输出一个浮点数
	 * fn putdouble(double) -> void
	 */
	private DataType analysePutdouble() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 0);
		funcDef.putInstruction(in);
		DataType putout = analyseExpr(TokenType.L_PAREN);
		if(!DataType.DOUBLE.equals(putout)) {
			throw new AnalyzeError(ErrorCode.InvalidInput,new Pos(0,0));
		}
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("putdouble")));
		funcDef.putInstruction(in);
		return DataType.VOID;
	}

	/**
	 * 输出一个字符
	 * fn putchar(int) -> void
	 */
	private DataType analysePutchar() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		analyseExpr(TokenType.L_PAREN);
		in = new Instruction(InstructionType.stackalloc, 0);
		funcDef.putInstruction(in);
//		in = new Instruction(InstructionType.push, (long)charToken.getValue());
//		funcDef.putInstruction(in);
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("putchar")));
		funcDef.putInstruction(in);
		return DataType.VOID;
	}

	/**
	 * 将编号为这个整数的全局常量看作字符串输出
	 * fn putstr(int) -> void
	 */
	private DataType analysePutstr() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 0);
		funcDef.putInstruction(in);
		Token stringToken = next();
		GlobalDef varDef = new GlobalDef(true, stringToken.getValueString());
		assembler.addGlobalDef(varDef, stringToken.getValueString());
		int offset = assembler.findGlobalDefID(varDef);
		in = new Instruction(InstructionType.push,(long)offset);
		funcDef.putInstruction(in);
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("putstr")));
		funcDef.putInstruction(in);
		return DataType.VOID;
	}

	/**
	 * 输出一个换行
	 * fn putln() -> void
	 */
	private DataType analysePutln() throws CompileError {
		FunctionDef funcDef = assembler.findFunctionDef(nowFunc.name);
		in = new Instruction(InstructionType.stackalloc, 0);
		funcDef.putInstruction(in);
		in = new Instruction(InstructionType.callname,assembler.findGlobalDefID(assembler.findGlobalDef("putln")));
		funcDef.putInstruction(in);
		return DataType.VOID;
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
		TokenType recentToken = null;
		OperatorStack stack = new OperatorStack();
		Stack<Object> numStack = new Stack<>();
		DataType ret = DataType.VOID;
		Token token = null;
		stack.push(TokenType.STOP);

		/**
		 * + - 					PLUS MINUS
		 * 前置- 				NEGATE
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
				System.out.println(stack.toString());
				recentToken = TokenType.PLUS;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.PLUS;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.MINUS)) {//- '-'
				System.out.println(stack.toString());
				token = seekIf(TokenType.MINUS);
				/**
				 * ASSIGN IF_KW WHILE_KW RETURN_KW ( + - * \ < > <= >= == !=
				 */
				if(recent.equals(TokenType.ASSIGN)||recent.equals(TokenType.IF_KW)||recent.equals(TokenType.WHILE_KW)||recent.equals(TokenType.RETURN_KW)||recent.equals(TokenType.L_PAREN)||recent.equals(TokenType.PLUS)||recent.equals(TokenType.MINUS)||recent.equals(TokenType.MUL)||recent.equals(TokenType.DIV)||recent.equals(TokenType.EQ)||recent.equals(TokenType.NEQ)||recent.equals(TokenType.GE)||recent.equals(TokenType.GT)||recent.equals(TokenType.LE)||recent.equals(TokenType.LT)) {
					//System.out.println("l----- "+recent);
					recentToken = TokenType.NEGATE;
					int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
					if(priorty[i][j] == 0) {
						next();
						stack.push(recentToken);
						recent = TokenType.MINUS;
					}
					else if(priorty[i][j] == 3) {
						throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
					}
				}
				else {
					recentToken = TokenType.MINUS;
					int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
					if(priorty[i][j] == 0) {
						next();
						stack.push(recentToken);
						recent = TokenType.MINUS;
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
							stacko(stack, token, numStack);
						}
					}
				}
			}
			else if(check(TokenType.MUL)) {//*
				System.out.println(stack.toString());
				recentToken = TokenType.MUL;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.MUL;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.DIV)) {//\
				System.out.println(stack.toString());
				recentToken = TokenType.DIV;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = recentToken = TokenType.DIV;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.EQ)) {//==
				System.out.println(stack.toString());
				recentToken = TokenType.EQ;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.EQ;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.NEQ)) {//!=
				System.out.println(stack.toString());
				recentToken = TokenType.NEQ;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.NEQ;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.LT)) {//<
				System.out.println(stack.toString());
				recentToken = TokenType.LT;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.LT;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.LE)) {//<=
				System.out.println(stack.toString());
				recentToken = TokenType.LE;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.LE;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.GT)) {//>
				System.out.println(stack.toString());
				recentToken = TokenType.GT;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.GT;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.GE)) {//>=
				System.out.println(stack.toString());
				recentToken = TokenType.GE;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.GE;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.AS_KW)) {//as
				System.out.println(stack.toString());
				recentToken = TokenType.AS_KW;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					stack.push(recentToken);
					recent = TokenType.AS_KW;
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
						stacko(stack, token, numStack);
					}
				}
			}
			else if(check(TokenType.UINT_LITERAL)) {//IDENT
				System.out.println(stack.toString());
				recentToken = TokenType.UINT_LITERAL;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					numStack.push(token.getValue());
					next();
					stack.push(recentToken);
					recent = TokenType.UINT_LITERAL;
				}
				else if(priorty[i][j] == 3) {
					throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
				}
			}
			else if(check(TokenType.DOUBLE_LITERAL)) {//IDENT
				System.out.println(stack.toString());
				recentToken = TokenType.DOUBLE_LITERAL;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					numStack.push(token.getValue());
					next();
					stack.push(recentToken);
					recent = TokenType.DOUBLE_LITERAL;
				}
				else if(priorty[i][j] == 3) {
					throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
				}
			}
			else if(check(TokenType.IDENT)) {//IDENT
				System.out.println(stack.toString());
				if(recent.equals(TokenType.AS_KW)) {
					recentToken = TokenType.IDENT;
					token = seekIf(recentToken);
					if(((String)token.getValue()).equals("int")) {
						next();
						stack.push(DataKeywordType.INT_KW);
						recent = TokenType.IDENT;
					}
					else if(((String)token.getValue()).equals("double")) {
						next();
						stack.push(DataKeywordType.DOUBLE_KW);
						recent = TokenType.IDENT;
					}
				}
				else {
					recentToken = TokenType.IDENT;
					token = seekIf(recentToken);
					if(SymbolTable.findFunctionEntry((String)token.getValue())!=null){
						next();
						stack.push(analyseFunction(token));
						recent = TokenType.IDENT;
					}
					else if(SymbolTable.findVarEntry((String)token.getValue())!=null){
						int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
						if(priorty[i][j] == 0) {
							next();
							if(SymbolTable.findVarEntry((String)token.getValue()).datatype.equals(DataType.INT)) {
								numStack.push(SymbolTable.findVarEntry((String)token.getValue()));
								stack.push(TokenType.UINT_LITERAL);
								recent = TokenType.IDENT;
							}
							else if(SymbolTable.findVarEntry((String)token.getValue()).datatype.equals(DataType.DOUBLE)) {
								numStack.push(SymbolTable.findVarEntry((String)token.getValue()));
								stack.push(TokenType.DOUBLE_LITERAL);
								recent = TokenType.IDENT;
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
				System.out.println(stack.toString());
				recentToken = TokenType.L_PAREN;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					next();
					LPNum ++;
					stack.push(recentToken);
					recent = TokenType.L_PAREN;
				}
				else if(priorty[i][j] == 3) {
					System.out.println(stack.toString());
					throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
				}
			}
			else if(check(TokenType.R_PAREN)&&(LPNum > (int)functionLPRecent.get(functionLPRecent.size()-1))) {//)
				System.out.println(stack.toString());
				recentToken = TokenType.R_PAREN;
				token = seekIf(recentToken);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
//        		System.out.println(priorty[i][j]);
//        		System.out.println(priortyToken[i]);
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
						stacko(stack, token, numStack);
					}
				}
				else if(priorty[i][j] == 2) {
					next();
					LPNum --;
					stack.push(recentToken);
					recent = TokenType.R_PAREN;
				}
				else if(priorty[i][j] == 3) {
					throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
				}
			}
			else if(check(TokenType.CHAR_LITERAL)) {
				System.out.println(stack.toString());
				recentToken = TokenType.UINT_LITERAL;
				token = seekIf(TokenType.CHAR_LITERAL);
				int i = enumToInt(stack.getTopToken()), j = enumToInt(recentToken);
				if(priorty[i][j] == 0) {
					char need = (char)token.getValue();
					int needs = (int) need;
					long needss = (long) needs;
					numStack.push(needss);
					next();
					stack.push(recentToken);
					recent = TokenType.UINT_LITERAL;
				}
				else if(priorty[i][j] == 3) {
					throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
				}
			}
			else {//#
				System.out.println(stack.toString());
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
						stacko(stack, token, numStack);
					}
				}
				else if(priorty[i][j] == 3) {
					throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
				}
				else if(priorty[i][j] == 4) {//返回
					ret = (DataType)stack.getTop();
					break;
				}
			}
		}
		return ret;
	}

	/**
	 * + - * \ < > <= >= == != 操作
	 * EoE型
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
				if(TokenType.PLUS.equals((TokenType)second)) {
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.add_i);//add.i
					} else {
						in = new Instruction(InstructionType.add_f);//add.f
					}
				}
				else if(TokenType.MINUS.equals((TokenType)second)) {
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.sub_i);//sub.i
					} else {
						in = new Instruction(InstructionType.sub_f);//sub.f
					}
				}
				else if(TokenType.MUL.equals((TokenType)second)) {
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.mul_i);//mul.i
					} else {
						in = new Instruction(InstructionType.mul_f);//mul.f
					}
				}
				else if(TokenType.DIV.equals((TokenType)second)) {
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.div_i);//div.i
					} else {
						in = new Instruction(InstructionType.div_f);//div.f
					}
				}
				else if(TokenType.LT.equals((TokenType)second)) {//<
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.cmp_i);//cmp.i
					} else {
						in = new Instruction(InstructionType.cmp_f);//cmp.f
					}
					putInstruction(in);
					in = new Instruction(InstructionType.set_lt);//<是真
					putInstruction(in);
					in = new Instruction(InstructionType.br_true,1);
				}
				else if(TokenType.GT.equals((TokenType)second)) {//>
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.cmp_i);//cmp.i
					} else {
						in = new Instruction(InstructionType.cmp_f);//cmp.f
					}
					putInstruction(in);
					in = new Instruction(InstructionType.set_gt);//>是真
					putInstruction(in);
					in = new Instruction(InstructionType.br_true,1);
				}
				else if(TokenType.LE.equals((TokenType)second)) {//<=
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.cmp_i);//cmp.i
					} else {
						in = new Instruction(InstructionType.cmp_f);//cmp.f
					}
					putInstruction(in);
					in = new Instruction(InstructionType.set_gt);//>是假
					putInstruction(in);
					in = new Instruction(InstructionType.br_false,1);
				}
				else if(TokenType.GE.equals((TokenType)second)) {//>=
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.cmp_i);//cmp.i
					} else {
						in = new Instruction(InstructionType.cmp_f);//cmp.f
					}
					putInstruction(in);
					in = new Instruction(InstructionType.set_lt);//<是假
					putInstruction(in);
					in = new Instruction(InstructionType.br_false,1);
				}
				else if(TokenType.EQ.equals((TokenType)second)) {//==
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.cmp_i);//cmp.i
					} else {
						in = new Instruction(InstructionType.cmp_f);//cmp.f
					}
					putInstruction(in);
					in = new Instruction(InstructionType.not);//是0则为1
					putInstruction(in);
					in = new Instruction(InstructionType.br_true,1);
				}
				else if(TokenType.NEQ.equals((TokenType)second)) {//!=
					if (dataType.equals(DataType.INT)) {
						in = new Instruction(InstructionType.cmp_i);//cmp.i
					} else {
						in = new Instruction(InstructionType.cmp_f);//cmp.f
					}
					putInstruction(in);
					in = new Instruction(InstructionType.br_true,1);
				}
				putInstruction(in);
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
	 * ( ) 操作
	 * oEo型
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
	 * '-' 前置负号操作
	 * oE型
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
			if(DataType.INT.equals(dataType)){
				in = new Instruction(InstructionType.neg_i);//negi
				putInstruction(in);
			}
			else if(DataType.DOUBLE.equals(dataType)){
				in = new Instruction(InstructionType.neg_f);//negf
				putInstruction(in);
			}
			stack.push(dataType);
		}
		else {
			throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
		}
		return stack;
	}

	/**
	 * AS操作
	 * EoT型
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
				in = new Instruction(InstructionType.ftoi);//push int
				putInstruction(in);
				stack.push(DataType.INT);
			}
			else if(DataKeywordType.DOUBLE_KW.equals((DataKeywordType)first)){
				stack.pop();
				stack.pop();
				stack.pop();
				in = new Instruction(InstructionType.itof);//push int
				putInstruction(in);
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
	 * 变量转换type
	 * o型
	 * @param stack
	 * @param token
	 * @return
	 * @throws AnalyzeError
	 */
	private OperatorStack stacko(OperatorStack stack, Token token, Stack numStack) throws AnalyzeError {
		DataType dataType = null;
		TokenType tokenType = token.getTokenType();
		Object first = stack.getTop();
		Object needPush = numStack.pop();
		if((first instanceof TokenType)) {
			if(TokenType.UINT_LITERAL.equals((TokenType)first)){
				stack.pop();
				dataType = DataType.INT;
				if(needPush instanceof Long) {
					in = new Instruction(InstructionType.push, (long)needPush);//push int
					putInstruction(in);
				}
				else{
					getlocal(((VarEntry)needPush).name);
					in = new Instruction(InstructionType.load_64);//load.64
					putInstruction(in);
				}
				stack.push(dataType);
			}
			else if(TokenType.DOUBLE_LITERAL.equals((TokenType)first)){
				stack.pop();
				dataType = DataType.DOUBLE;
				if(needPush instanceof Double) {
					in = new Instruction(InstructionType.push, (double)needPush);//push double
					putInstruction(in);
				}
				else{
					getlocal(((VarEntry)needPush).name);
					in = new Instruction(InstructionType.load_64);//load.64
					putInstruction(in);
				}
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
	 * 判断是不是+-
	 */
	private boolean judgePM(TokenType tokenType) {
		return (TokenType.PLUS.equals(tokenType)||TokenType.MINUS.equals(tokenType));
	}

	/**
	 * 判断是不是*\
	 */
	private boolean judgeMD(TokenType tokenType) {
		return (TokenType.MUL.equals(tokenType)||TokenType.DIV.equals(tokenType));
	}

	/**
	 * 判断是不是<> <= >= == !=
	 */
	private boolean judgeCMP(TokenType tokenType) {
		return (TokenType.LT.equals(tokenType)||TokenType.LE.equals(tokenType)||TokenType.GT.equals(tokenType)||TokenType.GE.equals(tokenType)||TokenType.EQ.equals(tokenType)||TokenType.NEQ.equals(tokenType));
	}

	/**
	 * 判断是不是 uint double
	 */
	private boolean judgeNum(TokenType tokenType) {
		return (TokenType.UINT_LITERAL.equals(tokenType)||TokenType.DOUBLE_LITERAL.equals(tokenType));
	}
}

