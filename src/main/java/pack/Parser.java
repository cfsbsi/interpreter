package pack;


public class Parser {
    private final Lexer lexer;
    private Token currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        currentToken = lexer.getNextToken();
    }

    private void eat(TokenType tokenType) {
        if (currentToken.getTokenType() == tokenType) {
            currentToken = lexer.getNextToken();
        } else {
            throw new RuntimeException();
        }
    }

//    public Ast expr() {
//
//        Ast node = term();
//
//        while (currentToken.getTokenType() == TokenType.PLUS || currentToken.getTokenType() == TokenType.MINUS) {
//
//            Token token = currentToken;
//
//            eat(token.getTokenType());
//
//            node = new BinOp(node, token, term());
//
//        }
//        return node;
//    }

    private Ast factor() {

        Token token = currentToken;

        if (token.getTokenType() == TokenType.INTEGER) {
            eat(TokenType.INTEGER);
            return new Num(token, Integer.parseInt(token.getValue()));
        } else if (token.getTokenType() == TokenType.FALSE_STATEMENT) {
            eat(TokenType.FALSE_STATEMENT);
            return new Num(token, null);
        } else if (token.getTokenType() == TokenType.LPARENT) {
            eat(TokenType.LPARENT);
            Ast node = term();
            eat(TokenType.RPARENT);
            return node;
        }

        throw new RuntimeException("Invalid operator");
    }

    private Ast term() {
        Ast node = factor();

        while (currentToken.getTokenType() == TokenType.AND || currentToken.getTokenType() == TokenType.OR) {

            Token token = currentToken;
            eat(token.getTokenType());

            node = new BinOp(node, token, factor());
        }
        return node;
    }

    public Ast parse() {
        return this.term();
    }
}
