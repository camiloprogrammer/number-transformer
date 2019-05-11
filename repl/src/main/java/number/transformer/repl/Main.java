package number.transformer.repl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import number.transformer.core.NumberToEnglishTextTransformer;
import number.transformer.core.NumberToTextTransformer;

public class Main {

    private static NumberToTextTransformer numberTransformer = new NumberToEnglishTextTransformer();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = System.out;

        printHelp(out);

        boolean shouldExit = false;
        do {
            out.print("> ");
            String input = in.readLine().trim();
            if ("exit".equals(input)) {
                shouldExit = true;
            } else {
                try {
                    String result = numberTransformer.transformNumber(input);
                    out.printf("%s\n", result);
                } catch (IllegalArgumentException ex) {
                    out.println("The provided number was invalid or outside the allowed range");
                } catch (Exception ex) {
                    out.println("Couldn't convert the provided number");
                }
            }
        } while (!shouldExit);
    }

    private static void printHelp(PrintStream out) {
        out.printf("Type a number and press enter to transform it to english\n");
        out.printf("Numbers must be between %d and %d\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        out.printf("Type exit to terminate the application\n\n");
    }

}
