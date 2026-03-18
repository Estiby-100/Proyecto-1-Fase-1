import java.util.List;

/**
 * Application entry point.
 */
public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        Collection<byte[]> stack = new PilaArrayList<>();

        boolean trace = false;

        // Check for trace flag
        for (String arg : args) {
            if (arg.equals("--trace")) {
                trace = true;
            }
        }

        Interpreter interpreter = new Interpreter(stack, trace);
        FileReader dataObtainer = new FileReader();

        // Read and execute script
        String script = dataObtainer.ReadFile("src/resources/Script_commands.txt");
        List<Token> tokens = parser.parse(script);

        boolean result = interpreter.execute(tokens);

        System.out.println("Resultado: " + result);
    }
}