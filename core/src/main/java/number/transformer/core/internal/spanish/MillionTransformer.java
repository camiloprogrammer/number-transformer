package number.transformer.core.internal.spanish;

public class MillionTransformer extends SpanishRegularIntNumberTransformer {

    private static final String MILLION_UNITS_NAME = "millon";

    private static final int ONE_MILLION = 1_000_000;

    public MillionTransformer() {
        super(MILLION_UNITS_NAME, ONE_MILLION, new HundredTransformer(), new ThousandTransformer());
    }

}
