package number.transformer.core.internal.spanish;

import java.io.PrintWriter;

import number.transformer.core.internal.IntNumberTransformer;
import number.transformer.core.internal.RegularIntNumberTransformer;

/**
 * Extension of a {@link RegularIntNumberTransformer} for Spanish that handles plural suffixes and
 * cases where 1 unit is referred to a "Un" instead of "Uno"
 */
public abstract class SpanishRegularIntNumberTransformer extends RegularIntNumberTransformer {

    private static final String PLURAL_SUFFIX = "es";

    private static final String SINGULAR_UNIT_NAME = "un";

    public SpanishRegularIntNumberTransformer(String unitsName, int divisor, IntNumberTransformer unitsTransformer,
            IntNumberTransformer remainderTransformer) {

        super(unitsName, divisor, unitsTransformer, remainderTransformer);
    }

    @Override
    protected void appendUnitsName(PrintWriter out, int numberOfUnits, int remainder) {
        super.appendUnitsName(out, numberOfUnits, remainder);
        if (numberOfUnits > 1) {
            out.append(PLURAL_SUFFIX);
        }
    }

    @Override
    protected void appendTransformedUnits(PrintWriter out, int numberOfUnits) {
        if (numberOfUnits == 1) {
            out.append(SINGULAR_UNIT_NAME);
            return;
        }
        super.appendTransformedUnits(out, numberOfUnits);
    }

}
