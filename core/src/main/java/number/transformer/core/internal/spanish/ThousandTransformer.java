package number.transformer.core.internal.spanish;

import java.io.PrintWriter;

import number.transformer.core.internal.RegularIntNumberTransformer;

public class ThousandTransformer extends RegularIntNumberTransformer {

    private static final String THOUSAND_UNITS_NAME = "mil";

    private static final int ONE_THOUSAND = 1_000;

    public ThousandTransformer() {
        super(THOUSAND_UNITS_NAME, ONE_THOUSAND, new HundredTransformer(), new HundredTransformer());
    }

    @Override
    protected void appendTransformedUnits(PrintWriter out, int numberOfUnits) {
        if (numberOfUnits > 1) {
            super.appendTransformedUnits(out, numberOfUnits);
        }
    }
}
