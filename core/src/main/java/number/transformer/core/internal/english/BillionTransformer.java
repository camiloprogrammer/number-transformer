package number.transformer.core.internal.english;

import number.transformer.core.internal.RegularIntNumberTransformer;

public class BillionTransformer extends RegularIntNumberTransformer {

    private static final String BILLION_UNITS_NAME = "billion";

    private static final int ONE_BILLION = 1_000_000_000;

    public BillionTransformer() {
        super(BILLION_UNITS_NAME, ONE_BILLION, new HundredTransformer(), new MillionTransformer());
    }
}
