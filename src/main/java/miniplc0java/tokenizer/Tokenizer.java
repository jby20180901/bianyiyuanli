package miniplc0java.tokenizer;

import miniplc0java.error.ErrorCode;
import miniplc0java.error.TokenizeError;
import static java.lang.Math.*;

public class Tokenizer {

    private StringIter it;

    public Tokenizer(StringIter it) {
        this.it = it;
    }

    // 这里本来是想实现 Iterator<Token> 的，但是 Iterator 不允许抛异常，于是就这样了
    /**
     * 获取下一个 Token
     *
     * @return
     * @throws TokenizeError 如果解析有异常则抛出
     */
    public Token nextToken() throws TokenizeError {
        it.readAll();

        // 跳过之前的所有空白字符
        skipSpaceCharacters();

        if (it.isEOF()) {
            return new Token(TokenType.EOF, "", it.currentPos(), it.currentPos());
        }

        char peek = it.peekChar();
        if (Character.isDigit(peek)) {
            Token token = lexUIntorFloat();
            System.out.println(token.getValueString()+"                "+token.getTokenType());
            return token;
        } else if ((peek >= 'a'&&peek <= 'z')||(peek >= 'A'&&peek <= 'Z')||(peek == '_')) {
            Token token = lexIdentOrKeyword();
            System.out.println(token.getValueString()+"                "+token.getTokenType());
            return token;
        } else {
            Token token = lexOperatorOrUnknown();
            System.out.println(token.getValueString()+"                "+token.getTokenType());
            return token;
        }
    }

    private Token lexUIntorFloat() throws TokenizeError {
        // 请填空：
        String num = "", num1 = "", num2 = "";
        // 直到查看下一个字符不是数字为止:
        while(Character.isDigit(it.peekChar())){
            // -- 前进一个字符，并存储这个字符
            char peek = it.nextChar();
            num += peek;
        }
        if(it.peekChar()=='.'){
            it.nextChar();
            // 直到查看下一个字符不是数字为止:
            while(Character.isDigit(it.peekChar())){
                // -- 前进一个字符，并存储这个字符
                char peek = it.nextChar();
                num1 += peek;
            }

            if(it.peekChar()=='e'||it.peekChar()=='E'){
                it.nextChar();
                int zhengfu = 1;
                if(it.peekChar()=='+') {
                    zhengfu = 1;
                    it.nextChar();
                }
                else if(it.peekChar()=='-'){
                    zhengfu = -1;
                    it.nextChar();
                }
                // 直到查看下一个字符不是数字为止:
                while(Character.isDigit(it.peekChar())){
                    // -- 前进一个字符，并存储这个字符
                    char peek = it.nextChar();
                    num2 += peek;
                }
                // 解析存储的字符串为无符号整数
                try{
                    // 解析成功则返回无符号整数类型的token，否则返回编译错误
                    long a = Long.parseLong(num);
                    long b = Long.parseLong(num1);
                    long c = zhengfu*Long.parseLong(num2);
                    double abc = (a + pow(10,-num1.length())*b) * pow(10,c);
                    //System.out.println("*"+abc);
                    return new Token(TokenType.DOUBLE_LITERAL, abc, it.previousPos(), it.currentPos());
                }
                catch (NumberFormatException e) {
                    throw new TokenizeError(ErrorCode.InvalidInput, it.previousPos());
                }
            }
            else{
                // 解析存储的字符串为无符号整数
                try{
                    // 解析成功则返回无符号整数类型的token，否则返回编译错误
                    long a = Long.parseLong(num);
                    long b = Long.parseLong(num1);
                    double ab = a + pow(10,-num1.length())*b;
                    //System.out.println("*"+ab);
                    return new Token(TokenType.DOUBLE_LITERAL, ab, it.previousPos(), it.currentPos());
                }
                catch (NumberFormatException e) {
                    throw new TokenizeError(ErrorCode.InvalidInput, it.previousPos());
                }
            }
        }
        else{
            //
            // 解析存储的字符串为无符号整数
            try{
                // 解析成功则返回无符号整数类型的token，否则返回编译错误
                long a = Long.parseLong(num);
                //System.out.println("*"+a);
                return new Token(TokenType.UINT_LITERAL, a, it.previousPos(), it.currentPos());
            }
            catch (NumberFormatException e) {
                throw new TokenizeError(ErrorCode.InvalidInput, it.previousPos());
            }
        }
        //
        // Token 的 Value 应填写数字的值

        // throw new Error("Not implemented");
    }

    private Token lexIdentOrKeyword() throws TokenizeError {
        // 请填空：
        String lex = "";
        // 直到查看下一个字符不是数字或字母为止:
        while(Character.isLetterOrDigit(it.peekChar())||it.peekChar()=='_'){
            // -- 前进一个字符，并存储这个字符
            char peek = it.nextChar();
            lex += peek;
        }

        //
        // 尝试将存储的字符串解释为关键字
        if(lex.equals("fn")){
            return new Token(TokenType.FN_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("let")){
            return new Token(TokenType.LET_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("const")) {
            return new Token(TokenType.CONST_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("as")) {
            return new Token(TokenType.AS_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("while")) {
            return new Token(TokenType.WHILE_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("if")) {
            return new Token(TokenType.IF_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("else")) {
            return new Token(TokenType.ELSE_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("return")) {
            return new Token(TokenType.RETURN_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("break")) {
            return new Token(TokenType.BREAK_KW, lex, it.previousPos(), it.currentPos());
        }
        else if (lex.equals("continue")) {
            return new Token(TokenType.CONTINUE_KW, lex, it.previousPos(), it.currentPos());
        }
        else{
            //System.out.println("*"+lex);
            return new Token(TokenType.IDENT, lex, it.previousPos(), it.currentPos());
        }
        // -- 如果是关键字，则返回关键字类型的 token
        // -- 否则，返回标识符
        //
        // Token 的 Value 应填写标识符或关键字的字符串
        // throw new Error("Not implemented");
    }

    private Token lexOperatorOrUnknown() throws TokenizeError {
        switch (it.nextChar()) {
            case '"':
                return newString();

            case '\'':
                return newChar();

            case '+':
                return new Token(TokenType.PLUS, '+', it.previousPos(), it.currentPos());

            case '-':
                return CheckMinusOrArrow();

            case '*':
                return new Token(TokenType.MUL, '*', it.previousPos(), it.currentPos());

            case '/':
                return CheckDivOrComment();

            case '=':
                return CheckAssignOrEqual();

            case '!':
                if(it.nextChar()=='=')
                    return new Token(TokenType.NEQ, "!=", it.previousPos(), it.currentPos());
                else
                    throw new TokenizeError(ErrorCode.NoError, it.previousPos());

            case '<':
                return checkLTOrLE();

            case '>':
                return checkGTOrGE();

            case '(':
                return new Token(TokenType.L_PAREN, '(', it.previousPos(), it.currentPos());

            case ')':
                return new Token(TokenType.R_PAREN, ')', it.previousPos(), it.currentPos());

            case '{':
                return new Token(TokenType.L_BRACE, '{', it.previousPos(), it.currentPos());

            case '}':
                return new Token(TokenType.R_BRACE, '}', it.previousPos(), it.currentPos());

            case ',':
                return new Token(TokenType.COMMA, ',', it.previousPos(), it.currentPos());

            case ':':
                return new Token(TokenType.COLON, ':', it.previousPos(), it.currentPos());

            case ';':
                return new Token(TokenType.SEMICOLON, ';', it.previousPos(), it.currentPos());


            default:
                // 不认识这个输入，摸了
                throw new TokenizeError(ErrorCode.NoError, it.previousPos());
        }
    }

    private Token newString() throws TokenizeError {
        String lex = "";
        // 直到查看下一个字符不是数字或字母为止:
        while(it.peekChar()!='"'){
            // -- 前进一个字符，并存储这个字符
            if(it.isEOF()) {
                throw new TokenizeError(ErrorCode.NoError, it.previousPos());
            }
            if(it.peekChar()=='\\'){
                char peek = it.nextChar();
                peek = it.nextChar();
                switch (peek){
                    case '\\': lex += peek; break;
                    case '"': lex += peek; break;
                    case '\'': lex += peek; break;
                    case 'n': lex += '\n'; break;
                    case 'r': lex += '\r'; break;
                    case 't': lex += '\t'; break;
                    default: // 不认识这个输入，摸了
                        throw new TokenizeError(ErrorCode.NoError, it.previousPos());
                }
            }
            else{
                char peek = it.nextChar();
                lex += peek;
            }
        }
        it.nextChar();
        //System.out.println("*"+lex);
        return new Token(TokenType.STRING_LITERAL, lex, it.previousPos(), it.currentPos());
    }

    private Token newChar() throws TokenizeError {
        char lex = ' ';
        // -- 前进一个字符，并存储这个字符
        if(it.peekChar()=='\\'){
            char peek = it.nextChar();
            peek = it.nextChar();
            switch (peek){
                case '\\': lex = peek; break;
                case '"': lex = peek; break;
                case '\'': lex = peek; break;
                case 'n': lex = '\n'; break;
                case 'r': lex = '\r'; break;
                case 't': lex = '\t'; break;
                default: // 不认识这个输入，摸了
                    throw new TokenizeError(ErrorCode.NoError, it.previousPos());
            }
        }
        else{
            lex = it.nextChar();
        }
        char peek = it.nextChar();
        if(peek!='\'')
            throw new TokenizeError(ErrorCode.NoError, it.previousPos());
        //System.out.println("*"+lex);
        return new Token(TokenType.CHAR_LITERAL, lex, it.previousPos(), it.currentPos());
    }

    private Token CheckMinusOrArrow() throws TokenizeError {
        if (it.peekChar()=='>'){
            it.nextChar();
            return new Token(TokenType.ARROW, "->", it.previousPos(), it.currentPos());
        }
        else{
            return new Token(TokenType.MINUS, '-', it.previousPos(), it.currentPos());
        }
    }

    private Token CheckDivOrComment() throws TokenizeError {
        if (it.peekChar()=='/'){
            while(it.peekChar()!='\n'){
                it.nextChar();
            }
            return nextToken();
        }
        else{
            return new Token(TokenType.DIV, '/', it.previousPos(), it.currentPos());
        }
    }

    private Token CheckAssignOrEqual() throws TokenizeError {
        if (it.peekChar()=='='){
            it.nextChar();
            return new Token(TokenType.EQ, "==", it.previousPos(), it.currentPos());
        }
        else{
            return new Token(TokenType.ASSIGN, '=', it.previousPos(), it.currentPos());
        }
    }

    private Token checkLTOrLE() throws TokenizeError {
        if (it.peekChar()=='='){
            it.nextChar();
            return new Token(TokenType.LE, "<=", it.previousPos(), it.currentPos());
        }
        else{
            return new Token(TokenType.LT, '<', it.previousPos(), it.currentPos());
        }
    }

    private Token checkGTOrGE() throws TokenizeError {
        if (it.peekChar()=='='){
            it.nextChar();
            return new Token(TokenType.GE, ">=", it.previousPos(), it.currentPos());
        }
        else{
            return new Token(TokenType.GT, '>', it.previousPos(), it.currentPos());
        }
    }

    private void skipSpaceCharacters() {
        while (!it.isEOF() && Character.isWhitespace(it.peekChar())) {
            it.nextChar();
        }
    }
}
