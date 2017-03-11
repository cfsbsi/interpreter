package pack;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("6 * 3 + 2");
        Interpreter interpreter = new Interpreter(lexer);
        System.out.println(interpreter.expr());
    }
}
