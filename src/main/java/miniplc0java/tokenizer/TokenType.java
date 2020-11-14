package miniplc0java.tokenizer;

public enum TokenType {
    /** none */
    NONE,
    /** fn */
    FN_KW,
    /** let */
    LET_KW,
    /** const */
    CONST_KW,
    /** as */
    AS_KW,
    /** while */
    WHILE_KW,
    /** if */
    IF_KW,
    /** else */
    ELSE_KW,
    /** return */
    RETURN_KW,
    /** break */
    BREAK_KW,
    /** continue */
    CONTINUE_KW,
    /** 无符号整数 */
    UINT_LITERAL,
    /** 浮点数 */
    FLOAT_LITERAL,
    /** 字符串 */
    STRING_LITERA,
    /** 字符 */
    CHAR_LITERAL,
    /** 标识符 */
    IDENT,
    /** + */
    PLUS,
    /** - */
    MINUS,
    /** * */
    MUL,
    /** / */
    DIV,
    /** = */
    ASSIGN,
    /** == */
    EQ,
    /** != */
    NEQ,
    /** < */
    LT,
    /** > */
    GT,
    /** <= */
    LE,
    /** >= */
    GE,
    /** ( */
    L_PAREN,
    /** ) */
    R_PAREN,
    /** { */
    L_BRACE,
    /** } */
    R_BRACE,
    /** -> */
    ARROW,
    /** , */
    COMMA,
    /** : */
    COLON,
    /** ; */
    SEMICOLON,
    /** 注释 */
    COMMENT,
    /** 文件尾 */
    EOF;

    @Override
    public String toString() {
        switch (this) {
            /** fn */
            case FN_KW:
                return "fn";
            /** let */
            case LET_KW:
                return "let";
            /** const */
            case CONST_KW:
                return "const";
            /** as */
            case AS_KW:
                return "as";
            /** while */
            case WHILE_KW:
                return "while";
            /** if */
            case IF_KW:
                return "if";
            /** else */
            case ELSE_KW:
                return "else";
            /** return */
            case RETURN_KW:
                return "return";
            /** break */
            case BREAK_KW:
                return "break";
            /** continue */
            case CONTINUE_KW:
                return "continue";
            /** 无符号整数 */
            case UINT_LITERAL:
                return "unint";
            /** 浮点数 */
            case FLOAT_LITERAL:
                return "float";
            /** 字符串 */
            case STRING_LITERA:
                return "string";
            /** 字符 */
            case CHAR_LITERAL:
                return "char";
            /** 标识符 */
            case IDENT:
                return "identification";
            /** + */
            case PLUS:
                return "plus";
            /** - */
            case MINUS:
                return "minus";
            /** * */
            case MUL:
                return "muli";
            /** / */
            case DIV:
                return "division";
            /** = */
            case ASSIGN:
                return "assign";
            /** == */
            case EQ:
                return "equal";
            /** != */
            case NEQ:
                return "noequal";
            /** < */
            case LT:
                return "littlethan";
            /** > */
            case GT:
                return "greatthan";
            /** <= */
            case LE:
                return "littleequal";
            /** >= */
            case GE:
                return "greatequal";
            /** ( */
            case L_PAREN:
                return "left paren";
            /** ) */
            case R_PAREN:
                return "right paren";
            /** { */
            case L_BRACE:
                return "leftbrace";
            /** } */
            case R_BRACE:
                return "rightbrace";
            /** -> */
            case ARROW:
                return "arrow";
            /** , */
            case COMMA:
                return "comma";
            /** : */
            case COLON:
                return "colon";
            /** ; */
            case SEMICOLO:
                return "semicolon";
            /** 注释 */
            case COMMENT:
                return "comment";
            /** 文件尾 */
            case EOF:
                return "EOF";
            case NONE:
                return "NullToken";
            default:
                return "InvalidToken";
        }
    }
}
