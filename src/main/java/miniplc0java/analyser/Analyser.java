package miniplc0java.analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import miniplc0java.error.AnalyzeError;
import miniplc0java.error.CompileError;
import miniplc0java.error.ErrorCode;
import miniplc0java.error.ExpectedTokenError;
import miniplc0java.error.TokenizeError;
import miniplc0java.instruction.Instruction;
import miniplc0java.instruction.Operation;
import miniplc0java.tokenizer.Token;
import miniplc0java.tokenizer.TokenType;
import miniplc0java.tokenizer.Tokenizer;
import miniplc0java.util.Pos;

public final class Analyser {

    Tokenizer tokenizer;
    ArrayList<Instruction> instructions;

    /** 当前偷看的 token */
    Token peekedToken = null;

    /** 符号表 */
    HashMap<String, SymbolEntry> symbolTable = new HashMap<>();

    /** 下一个变量的栈偏移 */
    int nextOffset = 0;

    public Analyser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
        this.instructions = new ArrayList<>();
    }

    public List<Instruction> analyse() throws CompileError {
        analyseProgram();
        return instructions;
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

    /**
     * 获取下一个变量的栈偏移
     * 
     * @return
     */
    private int getNextVariableOffset() {
        return this.nextOffset++;
    }

    /**
     * 添加一个符号
     * 
     * @param name          名字
     * @param isInitialized 是否已赋值
     * @param isConstant    是否是常量
     * @param curPos        当前 token 的位置（报错用）
     * @throws AnalyzeError 如果重复定义了则抛异常
     */
    private void addSymbol(String name, boolean isInitialized, boolean isConstant, Pos curPos) throws AnalyzeError {
        if (this.symbolTable.get(name) != null) {
            throw new AnalyzeError(ErrorCode.DuplicateDeclaration, curPos);
        } else {
            this.symbolTable.put(name, new SymbolEntry(isConstant, isInitialized, getNextVariableOffset()));
        }
    }

    /**
     * 设置符号为已赋值
     * 
     * @param name   符号名称
     * @param curPos 当前位置（报错用）
     * @throws AnalyzeError 如果未定义则抛异常
     */
    private void declareSymbol(String name, Pos curPos) throws AnalyzeError {
        var entry = this.symbolTable.get(name);
        if (entry == null) {
            throw new AnalyzeError(ErrorCode.NotDeclared, curPos);
        } else {
            entry.setInitialized(true);
        }
    }

    /**
     * 获取变量在栈上的偏移
     * 
     * @param name   符号名
     * @param curPos 当前位置（报错用）
     * @return 栈偏移
     * @throws AnalyzeError
     */
    private int getOffset(String name, Pos curPos) throws AnalyzeError {
        var entry = this.symbolTable.get(name);
        if (entry == null) {
            throw new AnalyzeError(ErrorCode.NotDeclared, curPos);
        } else {
            return entry.getStackOffset();
        }
    }

    /**
     * 获取变量是否是常量
     * 
     * @param name   符号名
     * @param curPos 当前位置（报错用）
     * @return 是否为常量
     * @throws AnalyzeError
     */
    private boolean isConstant(String name, Pos curPos) throws AnalyzeError {
        var entry = this.symbolTable.get(name);
        if (entry == null) {
            throw new AnalyzeError(ErrorCode.NotDeclared, curPos);
        } else {
            return entry.isConstant();
        }
    }

    /**
     * <程序> ::= 'begin'<主过程>'end' 
    */
    private void analyseProgram() throws CompileError {
        // 示例函数，示例如何调用子程序
        // 'begin'
        expect(TokenType.Begin);
        
        // Main函数
        analyseMain();

        // 'end'
        expect(TokenType.End);
        expect(TokenType.EOF);
    }

    /**
     * <主过程> ::= <常量声明><变量声明><语句序列>
     */
    private void analyseMain() throws CompileError {
        // 示例函数，示例如何调用主过程
        // 常量声明
        analyseConstantDeclaration();

        // 变量声明
        analyseVariableDeclaration();

        // 语句序列
        analyseStatementSequence();
        
    }

    /**
     * <常量声明> ::= {<常量声明语句>} 
     * <常量声明语句> ::= 'const'<标识符>'='<常表达式>';'
     */
    private void analyseConstantDeclaration() throws CompileError {
        // 示例函数，示例如何解析常量声明
        // 如果下一个 token 是 const 就继续
        while (nextIf(TokenType.Const) != null) {
            // 标识符
            var nameToken = expect(TokenType.Ident);

            // 在符号表里面添加这个符号
            addSymbol(nameToken.getValueString(), false, true, nameToken.getStartPos());
            
            // 等于号
            expect(TokenType.Equal);

            // 常表达式
            analyseConstantExpression();

            // 分号
            expect(TokenType.Semicolon);
        }
    }

    /**
     * <变量声明> ::= {<变量声明语句>} 
     * <变量声明语句> ::= 'var'<标识符>['='<表达式>]';'
     */
    private void analyseVariableDeclaration() throws CompileError {
        // 变量声明
        // 如果下一个 token 是 var 就继续
        while (nextIf(TokenType.Var) != null) {
            // 变量名
            var nameToken = expect(TokenType.Ident);

            if(!check(TokenType.Semicolon)){
                // 等于号
                expect(TokenType.Equal);

                // 表达式
                analyseExpression();

                // 分号
                expect(TokenType.Semicolon);
            }
            else{
                // 分号
                expect(TokenType.Semicolon);
            }
        }
    }

    /**
     * <语句序列> ::= {<语句>}
     */
    private void analyseStatementSequence() throws CompileError {
        // 语句序列
        while(check(TokenType.Semicolon)||check(TokenType.Ident)||check(TokenType.Print)){
            analyseStatement();
        }
        
    }

    /**
     * <语句> ::= <赋值语句>|<输出语句>|<空语句>
     */
    private void analyseStatement() throws CompileError {
        // 语句
        if(check(TokenType.Semicolon))
            expect(TokenType.Semicolon);
        else if(check(TokenType.Ident))
            analyseAssignmentStatement();
        else if(check(TokenType.Print))
            analyseOutputStatement();
    }

    /**
     * <常表达式> ::= [<符号>]<无符号整数>
     */
    private void analyseConstantExpression() throws CompileError {
        // 常表达式
        Integer num = 0;
        if(nextIf(TokenType.Plus)!=null){
            var numToken = expect(TokenType.Uint);
            num = (Integer) numToken.getValue();
            //declareSymbol(name, numToken.getStartPos());
        }
        else if(nextIf(TokenType.Minus)!=null){
            var numToken = expect(TokenType.Uint);
            num = (Integer) numToken.getValue() * -1;
            //declareSymbol(name, numToken.getStartPos());
        }
        else{
            var numToken = expect(TokenType.Uint);
            num = (Integer) numToken.getValue();
            //declareSymbol(name, numToken.getStartPos());
        }
    }

    /**
     * <表达式> ::= <项>{<加法型运算符><项>}
     */
    private void analyseExpression() throws CompileError {
        // 表达式
        analyseItem();
        while(nextIf(TokenType.Plus)!=null||nextIf(TokenType.Minus)!=null)
        {
            analyseItem();
        }
    }

    /**
     * <赋值语句> ::= <标识符>'='<表达式>';'
     */
    private void analyseAssignmentStatement() throws CompileError {
        // 赋值语句
        expect(TokenType.Ident);
        expect(TokenType.Equal);
        analyseExpression();
        expect(TokenType.Semicolon);
    }

    /**
     * <输出语句> ::= 'print' '(' <表达式> ')' ';'
     */
    private void analyseOutputStatement() throws CompileError {
        // 输出语句
        expect(TokenType.Print);
        expect(TokenType.LParen);
        analyseExpression();
        expect(TokenType.RParen);
        expect(TokenType.Semicolon);
        instructions.add(new Instruction(Operation.WRT));
    }

    /**
     * <项> ::= <因子>{<乘法型运算符><因子>}
     */
    private void analyseItem() throws CompileError {
        // 项
        analyseFactor();
        while(nextIf(TokenType.Mult)!=null||nextIf(TokenType.Div)!=null){
            analyseFactor();
        }
    }

    /**
     * <因子> ::= [<符号>]( <标识符> | <无符号整数> | '('<表达式>')' )
     */
    private void analyseFactor() throws CompileError {
        // 因子
        boolean negate;
        if (nextIf(TokenType.Minus) != null) {
            negate = true;
            // 计算结果需要被 0 减
            instructions.add(new Instruction(Operation.LIT, 0));
        } else {
            nextIf(TokenType.Plus);
            negate = false;
        }

        if (check(TokenType.Ident)) {
            // 调用相应的处理函数
            expect(TokenType.Ident);
        } else if (check(TokenType.Uint)) {
            // 调用相应的处理函数
            var num = (Integer)expect(TokenType.Uint).getValue();
            instructions.add(new Instruction(Operation.LIT, num));
        } else if (check(TokenType.LParen)) {
            // 调用相应的处理函数
            expect(TokenType.LParen);
            analyseExpression();
            expect(TokenType.RParen);
        } else {
            // 都不是，摸了
            throw new ExpectedTokenError(List.of(TokenType.Ident, TokenType.Uint, TokenType.LParen), next());
        }

        if (negate) {
            instructions.add(new Instruction(Operation.SUB));
        }
    }
}
