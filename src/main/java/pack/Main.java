package pack;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Lexer lexer = new Lexer("((2 | 1.5) & 2)");
        Parser parser = new Parser(lexer);
        Interpreter interpreter = new Interpreter(parser);
        Double result = interpreter.interpret();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }
}
