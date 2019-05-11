package number.transformer.core.internal.english;

import number.transformer.core.internal.RegularIntNumberTransformer;

public class MillionTransformer extends RegularIntNumberTransformer {

    private static final String MILLION_UNITS_NAME = "million";

    private static final int ONE_MILLION = 1_000_000;

    public MillionTransformer() {
        super(MILLION_UNITS_NAME, ONE_MILLION, new HundredTransformer(), new ThousandTransformer());
    }

}
