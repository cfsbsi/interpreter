package pack;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(" 2 + 6 * 2  ");
        Interpreter interpreter = new Interpreter(lexer);
        System.out.println(interpreter.expr());
    }
}
