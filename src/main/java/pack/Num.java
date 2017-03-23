package pack;

/**
 * Created by christian on 3/18/17.
 */
public class Num extends Ast {
    private Token token;
    private Double value;

    public Num(Token token, Double value) {
        this.token = token;
        this.value = value;
    }

    public Token getToken() {
        return token;
    }

    public Double getValue() {
        return value;
    }
}
