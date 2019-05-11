package number.transformer.core.internal.english;

import number.transformer.core.internal.RegularIntNumberTransformer;

public class ThousandTransformer extends RegularIntNumberTransformer {

    private static final String THOUSAND_UNITS_NAME = "thousand";

    private static final int ONE_THOUSAND = 1_000;

    public ThousandTransformer() {
        super(THOUSAND_UNITS_NAME, ONE_THOUSAND, new HundredTransformer(), new HundredTransformer());
    }
}
