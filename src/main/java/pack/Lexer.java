package pack;

import org.apache.commons.lang.StringUtils;

public class Lexer {
    private final String text;
    private int pos;
    private String currentChar;

    public Lexer(String text) {
        this.text = text;
        this.pos = 0;
        this.currentChar = String.valueOf(text.charAt(0));
    }

    private void skipWhiteSpace() {
        while (currentChar != null && currentChar.equals(" ")) {
            this.advance();
        }
    }

    private void advance() {
        this.pos++;
        if (this.pos > this.text.length() - 1) {
            this.currentChar = null;
        } else {
            this.currentChar = String.valueOf(this.text.charAt(this.pos));
        }
    }

    private String integer() {
        String result = "";
        while (this.currentChar != null && StringUtils.isNumeric(currentChar)) {
            result = result + currentChar;
            this.advance();
        }
        return result;
    }

    public Token getNextToken() {
        while (currentChar != null) {

            if (currentChar.equals(" ")) {
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

            if (TokenType.DIV.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.DIV, currentChar);
            }

            if (TokenType.MUL.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.MUL, currentChar);
            }

            if (TokenType.MINUS.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.MINUS, currentChar);
            }

            throw new RuntimeException("invalid char");
        }

        return new Token(TokenType.EOF, null);
    }

}
