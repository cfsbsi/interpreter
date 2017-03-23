package pack;

public enum TokenType {
    NUMBER(),
    FALSE_STATEMENT("null"),
    OR("|"),
    AND("&"),
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
