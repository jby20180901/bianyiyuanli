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
    /** �޷������� */
    UINT_LITERAL,
    /** ������ */
    DOUBLE_LITERAL,
    /** �ַ��� */
    STRING_LITERAL,
    /** �ַ� */
    CHAR_LITERAL,
    /** ��ʶ�� */
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
    /** ע�� */
    COMMENT,
    /** ǰ�ø��� */
    NEGATE,
    /** #����ʽǰ����ֹ�� */
    STOP,
    /** �ļ�β */
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
            /** �޷������� */
            case UINT_LITERAL:
                return "unint";
            /** ������ */
            case DOUBLE_LITERAL:
                return "double";
            /** �ַ��� */
            case STRING_LITERAL:
                return "string";
            /** �ַ� */
            case CHAR_LITERAL:
                return "char";
            /** ��ʶ�� */
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
            case SEMICOLON:
                return "semicolon";
            /** ע�� */
            case COMMENT:
                return "comment";
            /** �ļ�β */
            case EOF:
                return "EOF";
            case NONE:
                return "NullToken";
            default:
                return "InvalidToken";
        }
    }
}

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
//throw new AnalyzeError(ErrorCode.InvalidInput,token.getStartPos());
/**
 * + - * \ == != < > <= >= AS_KW IDENT ( ) #
 */