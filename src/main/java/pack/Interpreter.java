package pack;

import org.apache.commons.lang.StringUtils;

public class Interpreter {
    private String text;
    private int pos;
    private String currentChar;
    private Token currentToken;

    public Interpreter(String text) {
        this.text = text;
        this.pos = 0;
        this.currentToken = null;
        currentChar = String.valueOf(text.charAt(pos));
    }

    private void advance() {
        this.pos++;
        if (this.pos > this.text.length() - 1) {
            this.currentChar = null;
        } else {
            this.currentChar = String.valueOf(this.text.charAt(this.pos));
        }
    }

    private void skipWhiteSpace(){
        while (currentChar != null && currentChar.equals(" ")){
            this.advance();
        }
    }

    private Token getNextToken() {
        while (currentChar != null) {

            if (currentChar.equals(" ")){
                this.skipWhiteSpace();
                continue;
            }

            if (StringUtils.isNumeric(currentChar)) {
                return new Token(TokenType.INTEGER, integer());
            }

            if (TokenType.PLUS.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.PLUS, currentChar);
            }

            if (TokenType.MINUS.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.MINUS, currentChar);
            }

            throw new RuntimeException("invalid char");
        }

        return new Token(TokenType.EOF, null);
    }

    private String integer() {
        String result = "";
        while (this.currentChar != null && StringUtils.isNumeric(currentChar)){
            result = result + currentChar;
            this.advance();
        }
        return result;
    }

    private void eat(TokenType tokenType) {
        if (currentToken.getTokenType() == tokenType) {
            currentToken = getNextToken();
        } else {
            throw new RuntimeException();
        }
    }

    public Integer expr() {
        this.currentToken = this.getNextToken();

        Token left = currentToken;
        this.eat(TokenType.INTEGER);

        Token op = currentToken;
        this.eat(op.getTokenType());

        Token right = currentToken;
        this.eat(TokenType.INTEGER);

        if (op.getTokenType() == TokenType.PLUS)
            return Integer.parseInt(left.getValue())
                    + Integer.parseInt(right.getValue());


        return Integer.parseInt(left.getValue())
                - Integer.parseInt(right.getValue());

    }

}
