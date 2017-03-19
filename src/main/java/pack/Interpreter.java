package pack;

/**
 * Created by christian on 3/18/17.
 */
public class Interpreter {
    private final Parser parser;

    public Interpreter(Parser parser) {
        this.parser = parser;
    }

    public Integer interpret(){
        return visit(parser.parse());
    }

    public Integer visitBinOp(BinOp node) {
        if (node.getToken().getTokenType() == TokenType.PLUS) {
            return this.visit(node.getLeft()) + this.visit(node.getRight());
        } else if (node.getToken().getTokenType() == TokenType.MINUS) {
            return this.visit(node.getLeft()) - this.visit(node.getRight());
        } else if(node.getToken().getTokenType() == TokenType.MUL){
            return this.visit(node.getLeft()) * this.visit(node.getRight());
        } else if(node.getToken().getTokenType() == TokenType.DIV){
            return this.visit(node.getLeft()) / this.visit(node.getRight());
        }

        throw new RuntimeException("Invalid Node");

    }

    public Integer visit(Ast node){
        if(node instanceof BinOp){
            return this.visitBinOp((BinOp) node);
        }else{
            return this.visitNum(node);
        }
    }

    private Integer visitNum(Ast node) {
        Num num = (Num) node;
        return num.getValue();
    }
}
