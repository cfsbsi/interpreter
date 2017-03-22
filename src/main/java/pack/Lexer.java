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

            if("f".equals(currentChar)){
                advance();
                return new Token(TokenType.FALSE_STATEMENT, null);
            }

            if (StringUtils.isNumeric(currentChar)) {
                return new Token(TokenType.INTEGER, integer());
            }

            if (TokenType.AND.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.AND, currentChar);
            }

            if (TokenType.OR.getValue().equals(currentChar)) {
                Token token = new Token(TokenType.OR, currentChar);
                advance();
                return token;
            }

            if (TokenType.LPARENT.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.LPARENT, currentChar);
            }

            if (TokenType.RPARENT.getValue().equals(currentChar)) {
                advance();
                return new Token(TokenType.RPARENT, currentChar);
            }

            throw new RuntimeException("invalid char");
        }

        return new Token(TokenType.EOF, null);
    }

}
