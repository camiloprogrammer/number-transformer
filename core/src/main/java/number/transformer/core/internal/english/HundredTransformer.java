package number.transformer.core.internal.english;

import number.transformer.core.internal.RegularIntNumberTransformer;

public class HundredTransformer extends RegularIntNumberTransformer {

    private static final String HUNDRED_UNITS_NAME = "hundred";

    private static final int ONE_HUNDRED = 100;

    public HundredTransformer() {
        super(HUNDRED_UNITS_NAME, ONE_HUNDRED, new UnitAndTenTransformer(), new UnitAndTenTransformer());
    }

    @Override
    protected void validateUnits(int hundredUnits) {
        if (hundredUnits < 0 || hundredUnits > 9) {
            throw new IllegalArgumentException(hundredUnits + " hundred units not supported by this transformer");
        }
    }
}
