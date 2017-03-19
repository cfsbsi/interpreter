package pack;

/**
 * Created by christian on 3/18/17.
 */
public class Num extends Ast {
    private Token token;
    private Integer value;

    public Num(Token token, Integer value) {
        this.token = token;
        this.value = value;
    }

    public Token getToken() {
        return token;
    }

    public Integer getValue() {
        return value;
    }
}
