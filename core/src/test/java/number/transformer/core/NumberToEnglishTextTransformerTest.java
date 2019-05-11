package number.transformer.core;

import org.junit.Test;

public class NumberToEnglishTextTransformerTest {

    private NumberToEnglishTextTransformer transformer = new NumberToEnglishTextTransformer();

    @Test(expected = NullPointerException.class)
    public void testNullInput() {
        transformer.transformNumber(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeZero() {
        transformer.transformNumber("-0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotAnInt() {
        transformer.transformNumber("abc");
    }
}
