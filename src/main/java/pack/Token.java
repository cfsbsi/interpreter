package pack;

/**
 * Created by christian on 3/8/17.
 */
public class Token {

    private final TokenType tokenType;
    private String value;

    public Token(TokenType tokenType, String value){
        this.tokenType = tokenType;
        this.value = value;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getValue() {
        return value;
    }
}
