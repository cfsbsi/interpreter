package pack;

public enum TokenType {
    INTEGER(),
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    LPARENT("("),
    RPARENT(")"),
    EOF();

    private String value = null;

    TokenType(String value){
        this.value  = value;
    }

    TokenType(){
    }

    public String getValue() {
        return value;
    }
}
