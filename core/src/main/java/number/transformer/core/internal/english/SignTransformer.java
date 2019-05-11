package number.transformer.core.internal.english;

import java.io.PrintWriter;

import number.transformer.core.internal.IntNumberTransformer;

public class SignTransformer implements IntNumberTransformer {

    private static final String NEGATIVE_PREFIX = "negative ";

    private final IntNumberTransformer delegate;

    public SignTransformer(IntNumberTransformer delegate) {
        this.delegate = delegate;
    }

    @Override
    public void transformNumber(PrintWriter out, int number) {
        if (number < 0) {
            out.append(NEGATIVE_PREFIX);
        }
        delegate.transformNumber(out, number);
    }
}
