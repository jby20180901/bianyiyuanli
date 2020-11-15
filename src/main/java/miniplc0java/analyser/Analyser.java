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

    /** 大括号信号量 */
    int brace = 0;

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
     * item -> fuexpectnction | decl_stmt
     */
    private void analyseItem() throws CompileError {
        // 检查第一个单词是不是fn
        if(check(TokenType.FN_KW)){
            analyseFuc();
        }
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
        // 检查第一个单词是不是fn
        expect(TokenType.FN_KW);
        var fucNameToken = expect(TokenType.IDENT);
        expect(TokenType.L_PAREN);
        analyseFuncList();
        expect(TokenType.R_PAREN);
        expect(TokenType.ARROW);
        analyseType();
        analyseBlockStmt();
    }

    /**
     * function_param_list -> function_param (',' function_param)*
     */
    private void analyseFuncList() throws CompileError {
        analyseFucPara();
        if(nextIf(TokenType.COMMA)!=null){
            analyseFucPara();
        }
    }

    /**
     * ty -> IDENT
     */
    private void analyseType() throws CompileError {
        var TypeNameToken = expect(TokenType.IDENT);
    }

    /**
     * function_param -> IDENT ':' ty 
     */
    private void analyseFucPara() throws CompileError {
        var paraNameToken = expect(TokenType.IDENT);
        expect(TokenType.COLON);
        analyseType();
    }

    /**
     * block_stmt -> '{' stmt* '}'
     */
    private void analyseBlockStmt() throws CompileError {
        expect(TokenType.L_BRACE);
        brace++;
        int thisBrace = brace;
        while(!(check(TokenType.R_BRACE)&&(brace == thisBrace))){
            analyseStmt();
        }
        expect(TokenType.R_BRACE);
        brace--;
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
     * if_stmt -> 'if' expr block_stmt ('else' 'if' expr block_stmt)* ('else' block_stmt)?
     */
    private void analyseIfStmt() throws CompileError {
        expect(TokenType.IF_KW);
        analyseExpr();
        analyseBlockStmt();
        while(nextIf(TokenType.ELSE_KW)!=null){
            if(nextIf(TokenType.IF_KW)!=null){
                analyseExpr();
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
        analyseExpr();
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
        expect(TokenType.RETURN_KW);
        if(nextIf(TokenType.SEMICOLON)==null){
            analyseExpr();  
            expect(TokenType.SEMICOLON);
        }
    }

    /**
     * expr_stmt -> expr ';'
     */
    private void analyseExprStmt() throws CompileError {
        analyseExpr();
        expect(TokenType.SEMICOLON);
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
     */
    private void analyseExpr() throws CompileError {
        /**
         * negate_expr -> '-' expr
         */
        if(check(TokenType.MINUS)){
            expect(TokenType.MINUS);
            analyseExpr();
        }
        else if(check(TokenType.IDENT)){
            var nameToken = expect(TokenType.IDENT);
            /**
             * call_expr -> IDENT '(' call_param_list? ')'
             */
            if(check(TokenType.L_PAREN)){
                expect(TokenType.L_PAREN);
                if(!check(TokenType.R_PAREN)){
                    analyseCallList();
                }
                expect(TokenType.R_PAREN);
            }
            /**
             * assign_expr -> l_expr '=' expr
             */
            else if(check(TokenType.ASSIGN)){
                expect(TokenType.ASSIGN);
                analyseExpr();
            }
            /**
             * ident_expr -> IDENT
             */
            else{
                ;
            }
        }
        /**
         * literal_expr -> UINT_LITERAL | DOUBLE_LITERAL | STRING_LITERAL | CHAR_LITERAL
         */
        else if(check(TokenType.UINT_LITERAL)){
            var LiterToken = expect(TokenType.UINT_LITERAL);
        }
        else if(check(TokenType.DOUBLE_LITERAL)){
            var LiterToken = expect(TokenType.DOUBLE_LITERAL);
        }
        else if(check(TokenType.STRING_LITERAL)){
            var LiterToken = expect(TokenType.STRING_LITERAL);
        }
        else if(check(TokenType.CHAR_LITERAL)){
            var LiterToken = expect(TokenType.CHAR_LITERAL);
        }
        /**
         * 不认识这个东西，摸了
         */
        else{
            expect(TokenType.MINUS);
        }
        /**
         * 重写文法，消除左递归之后
         * binary_operator -> '+' | '-' | '*' | '/' | '==' | '!=' | '<' | '>' | '<=' | '>='
         * operator_expr -> expr binary_operator expr
         * 
         * 和
         * 
         * as_expr -> expr 'as' ty
         */
        while(check(TokenType.AS_KW)||check(TokenType.PLUS)||check(TokenType.MINUS)||check(TokenType.MUL)||check(TokenType.DIV)||check(TokenType.EQ)||check(TokenType.NEQ)||check(TokenType.LT)||check(TokenType.LE)||check(TokenType.GT)||check(TokenType.GE)){
            if(nextIf(TokenType.AS_KW)!=null){
                analyseExpr();
            }
            else{
                if(nextIf(TokenType.PLUS)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.MINUS)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.MUL)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.DIV)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.EQ)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.NEQ)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.LT)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.LE)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.GT)){
                    analyseExpr();
                }
                else if(nextIf(TokenType.GE)){
                    analyseExpr();
                }
            }
        }
    }

    /**
     * call_param_list -> expr (',' expr)*
     */
    private void analyseCallList() throws CompileError{
        analyseExpr();
        while(check(TokenType.COMMA)){
            expect(TokenType.COMMA);
            analyseExpr();
        }
    }

    /**
     * decl_stmt -> let_decl_stmt | const_decl_stmt
     */
    private void analyseDeclStmt() throws CompileError {
        // 检查第一个单词是不是let const
        if(check(TokenType.LET_KW)){
            analyseLetDecl();
        }
        else if(check(TokenType.CONST_KW)){
            analyseConstDecl();
        }
    }
}
