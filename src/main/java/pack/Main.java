package pack;

/**
 * Created by christian on 3/8/17.
 */
public class Main {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter("7 - 3 + 2 - 1");
        System.out.println(interpreter.expr());
    }
}
