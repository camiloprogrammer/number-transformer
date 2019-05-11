package number.transformer.core.internal.english;

import static org.mockito.Mockito.mock;

import java.io.PrintWriter;

import org.junit.Test;

import number.transformer.core.internal.english.UnitAndTenTransformer;

public class UnitAndTenTransformerTest {

    private UnitAndTenTransformer transformer = new UnitAndTenTransformer();

    private PrintWriter out = mock(PrintWriter.class);

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUnits() {
        transformer.transformNumber(out, 1000);
    }

}
