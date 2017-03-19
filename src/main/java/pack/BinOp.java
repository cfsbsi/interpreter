package pack;

/**
 * Created by christian on 3/18/17.
 */
public class BinOp extends Ast {
    private Ast left;
    private Token token;
    private Ast right;

    public BinOp(Ast left, Token token, Ast right) {
        this.left = left;
        this.token = token;
        this.right = right;
    }

    public Ast getLeft() {
        return left;
    }

    public Token getToken() {
        return token;
    }

    public Ast getRight() {
        return right;
    }
}
