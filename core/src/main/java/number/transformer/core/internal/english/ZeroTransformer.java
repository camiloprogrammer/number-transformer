package number.transformer.core.internal.english;

import java.io.PrintWriter;

import number.transformer.core.internal.IntNumberTransformer;

public class ZeroTransformer implements IntNumberTransformer {

    private static final String ZERO = "zero";
    
    private final IntNumberTransformer delegate;

    public ZeroTransformer(IntNumberTransformer delegate) {
        this.delegate = delegate;
    }

    @Override
    public void transformNumber(PrintWriter out, int number) {
        if (number == 0) {
            out.append(ZERO);
        } else {
            delegate.transformNumber(out, number);
        }
    }
}
