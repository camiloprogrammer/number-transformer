package number.transformer.core.internal.spanish;

public class BillionTransformer extends SpanishRegularIntNumberTransformer {

    private static final String BILLION_UNITS_NAME = "billon";

    private static final int ONE_BILLION = 1_000_000_000;

    public BillionTransformer() {
        super(BILLION_UNITS_NAME, ONE_BILLION, new HundredTransformer(), new MillionTransformer());
    }
}
