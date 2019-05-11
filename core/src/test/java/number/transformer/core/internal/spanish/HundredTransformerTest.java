package number.transformer.core.internal.spanish;

import static org.mockito.Mockito.mock;

import java.io.PrintWriter;

import org.junit.Test;

import number.transformer.core.internal.spanish.HundredTransformer;

public class HundredTransformerTest {

    private HundredTransformer transformer = new HundredTransformer();

    private PrintWriter out = mock(PrintWriter.class);

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUnits() {
        transformer.transformNumber(out, 1000);
    }

}
