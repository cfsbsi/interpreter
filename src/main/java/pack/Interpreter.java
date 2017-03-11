package pack;

import org.apache.commons.lang.StringUtils;

public class Interpreter {
    private final Lexer lexer;
    private Token currentToken;

    public Interpreter(Lexer lexer) {
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

    public Integer expr() {

        Integer result = term();

        while (isAnOperator()) {

            Token token = currentToken;

            if (token.getTokenType() == TokenType.MINUS) {
                token = currentToken;
                eat(token.getTokenType());
                result = result - term();
            }

            if (token.getTokenType() == TokenType.PLUS) {
                token = currentToken;
                eat(token.getTokenType());
                result = result + term();
            }

            if (token.getTokenType() == TokenType.MUL) {
                token = currentToken;
                eat(token.getTokenType());
                result = result * term();
            }

            if (token.getTokenType() == TokenType.DIV) {
                token = currentToken;
                eat(token.getTokenType());
                result = result / term();
            }
        }
        return result;
    }

    private boolean isAnOperator() {
        return currentToken.getTokenType() == TokenType.PLUS || currentToken.getTokenType() == TokenType.MINUS ||
                currentToken.getTokenType() == TokenType.MUL || currentToken.getTokenType() == TokenType.DIV;
    }

    private Integer term() {
        Token token = currentToken;
        int result = Integer.parseInt(token.getValue());
        eat(TokenType.INTEGER);
        return result;
    }

}
