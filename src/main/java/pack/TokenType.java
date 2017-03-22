package pack;

public enum TokenType {
    INTEGER(),
    FALSE_STATEMENT("f"),
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
