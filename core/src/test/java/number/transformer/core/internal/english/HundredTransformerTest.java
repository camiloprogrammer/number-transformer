package number.transformer.core.internal.english;

import static org.mockito.Mockito.mock;

import java.io.PrintWriter;

import org.junit.Test;

public class HundredTransformerTest {

    private HundredTransformer transformer = new HundredTransformer();

    private PrintWriter out = mock(PrintWriter.class);

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUnits() {
        transformer.transformNumber(out, 1000);
    }

}
