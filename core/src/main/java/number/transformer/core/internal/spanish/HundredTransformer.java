package number.transformer.core.internal.spanish;

import java.io.PrintWriter;

import number.transformer.core.internal.RegularIntNumberTransformer;

public class HundredTransformer extends RegularIntNumberTransformer {

    private static final String HUNDRED_UNITS_NAME = "cien";

    private static final int ONE_HUNDRED = 100;

    private static final String[] HUNDRED_MAPPINGS = { "", "ciento", "doscientos", "trescientos", "cuatrocientos",
            "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos" };

    public HundredTransformer() {
        super(HUNDRED_UNITS_NAME, ONE_HUNDRED, null, new UnitAndTenTransformer());
    }

    @Override
    protected void appendTransformedUnits(PrintWriter out, int numberOfUnits) {
    }

    @Override
    protected void appendUnitsName(PrintWriter out, int numberOfUnits, int remainder) {
        if (numberOfUnits == 1 && remainder == 0) {
            out.append(HUNDRED_UNITS_NAME);
        } else {
            out.append(HUNDRED_MAPPINGS[numberOfUnits]);
        }
    }

    @Override
    protected void appendUnitsToNameSeparator(PrintWriter out, int numberOfUnits) {
    }

    @Override
    protected void validateUnits(int hundredUnits) {
        if (hundredUnits < 0 || hundredUnits > 9) {
            throw new IllegalArgumentException(hundredUnits + " hundred units not supported by this transformer");
        }
    }
}
