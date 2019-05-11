package number.transformer.core.internal;

import java.io.PrintWriter;

/**
 * Internal base class for number transformers that are regular, this means, numbers that when
 * transformed have the following structure:
 *
 * <p>
 * <code>[UNITS[ ]UNITS_NAME][[ ]REMAINDER]</code>, where parts in square brackets are optional.
 *
 * <p>
 * For example, in English, numbers in the hundreds, thousands and millions are regular. In the case
 * of a hundreds transformer, we can break the number <code>120</code> as follows:
 * <ul>
 * <li><code>UNITS=1</code> which transformed is <code>one</code> and represents the number of
 * <code>hundreds</code> in the input
 * <li>a space separator
 * <li><code>UNITS_NAME="hundred"</code>
 * <li>a space separator
 * <li><code>REMAINDER=20</code> which transformed is <code>twenty</code>
 * </ul>
 *
 * <p>
 * This results in <code>120 -> "one hundred twenty"</code>, and we can apply the same principle to
 * other regular numbers.
 *
 * <p>
 * In general, {@link RegularIntNumberTransformer} rely on other {@link IntNumberTransformer} to
 * transform the <code>UNITS</code> and the <code>REMAINDER</code>
 */
public abstract class RegularIntNumberTransformer implements IntNumberTransformer {

    private final String unitsName;
    private final int divisor;
    private final IntNumberTransformer unitsTransformer;
    private final IntNumberTransformer remainderTransformer;

    public RegularIntNumberTransformer(String unitsName, int divisor, IntNumberTransformer unitsTransformer,
            IntNumberTransformer remainderTransformer) {
        this.divisor = divisor;
        this.unitsName = unitsName;
        this.unitsTransformer = unitsTransformer;
        this.remainderTransformer = remainderTransformer;
    }

    @Override
    public void transformNumber(PrintWriter out, int number) {
        int numberOfUnits = Math.abs(number / this.divisor);
        int remainder = Math.abs(number % this.divisor);
        validateUnits(numberOfUnits);
        transformAndAppendUnits(out, numberOfUnits, remainder);
        transformAndAppendRemainder(out, numberOfUnits, remainder);
    }

    private void transformAndAppendUnits(PrintWriter out, int numberOfUnits, int remainder) {
        if (numberOfUnits > 0) {
            appendTransformedUnits(out, numberOfUnits);
            appendUnitsToNameSeparator(out, numberOfUnits);
            appendUnitsName(out, numberOfUnits, remainder);
        }
    }

    private void transformAndAppendRemainder(PrintWriter out, int numberOfUnits, int remainder) {
        if (remainder > 0) {
            appendUnitsToRemainderSeparator(out, numberOfUnits, remainder);
            appendTransformedRemainder(out, remainder);
        }
    }

    protected void appendTransformedUnits(PrintWriter out, int numberOfUnits) {
        this.unitsTransformer.transformNumber(out, numberOfUnits);
    }

    protected void appendTransformedRemainder(PrintWriter out, int remainder) {
        if (remainder > 0) {
            this.remainderTransformer.transformNumber(out, remainder);
        }
    }

    protected void appendUnitsName(PrintWriter out, int numberOfUnits, int remainder) {
        out.append(this.unitsName);
    }

    protected void appendUnitsToNameSeparator(PrintWriter out, int numberOfUnits) {
        out.append(" ");
    }

    protected void appendUnitsToRemainderSeparator(PrintWriter out, int numberOfUnits, int remainder) {
        if (remainder > 0 && numberOfUnits > 0) {
            out.append(" ");
        }
    }

    protected void validateUnits(int units) {
    }

}
