package pack;


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

        while (currentToken.getTokenType() == TokenType.PLUS || currentToken.getTokenType() == TokenType.MINUS) {

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

        }
        return result;
    }

    private Integer factor() {
        Token token = currentToken;
        int result = Integer.parseInt(token.getValue());
        eat(TokenType.INTEGER);
        return result;
    }

    private Integer term() {
        int result = factor();

        while (currentToken.getTokenType() == TokenType.MUL || currentToken.getTokenType() == TokenType.DIV) {
            Token token = currentToken;
            if (token.getTokenType() == TokenType.DIV) {
                eat(token.getTokenType());
                result = result / factor();
            } else if (token.getTokenType() == TokenType.MUL) {
                eat(token.getTokenType());
                result = result * factor();
            }
        }
        return result;
    }
}
