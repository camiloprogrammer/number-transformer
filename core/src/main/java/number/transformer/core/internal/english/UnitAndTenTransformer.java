package number.transformer.core.internal.english;

import java.io.PrintWriter;

import number.transformer.core.internal.IntNumberTransformer;

public class UnitAndTenTransformer implements IntNumberTransformer {

    private static final String[] NUMBER_MAPPINGS = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen" };

    private static final String[] TENS_MAPPINGS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    @Override
    public void transformNumber(PrintWriter out, int number) {
        validateNumber(number);
        if (NUMBER_MAPPINGS.length > number) {
            out.append(NUMBER_MAPPINGS[number]);
            return;
        }

        int tensUnits = number / 10;
        int remainder = number % 10;
        transformAndAppendUnits(out, tensUnits);
        transformAndAppendRemainder(out, remainder);
    }

    private void transformAndAppendUnits(PrintWriter out, int tensUnits) {
        out.append(TENS_MAPPINGS[tensUnits]);
    }

    private void transformAndAppendRemainder(PrintWriter out, int remainder) {
        if (remainder > 0) {
            out.append(" ");
            out.append(NUMBER_MAPPINGS[remainder]);
        }
    }

    private void validateNumber(int number) {
        if (number < 0 || number > 99) {
            throw new IllegalArgumentException(number + " not supported by this transformer");
        }
    }
}
