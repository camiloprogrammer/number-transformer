package number.transformer.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import number.transformer.core.internal.IntNumberTransformer;
import number.transformer.core.internal.english.BillionTransformer;
import number.transformer.core.internal.english.SignTransformer;
import number.transformer.core.internal.english.ZeroTransformer;

/**
 * An implementation of a {@link NumberToTextTransformer} that transforms numbers into their English
 * textual representation.
 */
public class NumberToEnglishTextTransformer implements NumberToTextTransformer {

    private static final String NEGATIVE_ZERO = "-0";

    private final IntNumberTransformer transformer;

    public NumberToEnglishTextTransformer() {
        this.transformer = new ZeroTransformer(new SignTransformer(new BillionTransformer()));
    }

    /**
     * Transforms the input <code>String</code> number into its English textual representation.
     * 
     * <p>
     * For example:
     * <ul>
     * <li><code>"1"</code> to <code>"One"</code>
     * <li><code>"-11"</code> to <code>"Negative eleven"</code>
     * </ul>
     * 
     * <p>
     * Valid inputs:
     * <ul>
     * <li>This implementation supports numbers in the range <code>Integer.MIN_VALUE</code> to
     * <code>Integer.MAX_VALUE</code>.
     * <li>The input string can only contain digits <code>[0-9]</code> and can start with a
     * <code>-</code> to represent negative numbers.
     * <li>"-0" is considered an invalid input.
     * </ul>
     * 
     * @throws NullPointerException     if the input is <code>null</code>
     * @throws IllegalArgumentException if the input doesn't conform to the specification above.
     */
    @Override
    public String transformNumber(String numberAsString) {
        int number = validateAndParseInput(numberAsString);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintWriter out = new PrintWriter(byteStream);
        transformer.transformNumber(out, number);
        out.flush();
        String result = byteStream.toString().trim();
        return formatResult(result);
    }

    private String formatResult(String result) {
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }

    private int validateAndParseInput(String number) {
        if (number == null) {
            throw new NullPointerException("The provided number must not be null");
        }

        if (NEGATIVE_ZERO.equals(number)) {
            throw new IllegalArgumentException(number + " isn't a valid input");
        }

        return Integer.parseInt(number);
    }

}
