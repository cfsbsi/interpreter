package pack;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("(2 & f) | ( (1 & 2) & 2)");
        Parser parser = new Parser(lexer);
        Interpreter interpreter = new Interpreter(parser);
        Integer result = interpreter.interpret();
        System.out.println(result);
    }
}
