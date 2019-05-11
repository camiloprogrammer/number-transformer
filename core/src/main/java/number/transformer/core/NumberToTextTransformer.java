package number.transformer.core;

/**
 * A transformer function that provides a way to transform a numerical input <code>String</code>
 * object into its textual representation.
 * 
 * @see NumberToEnglishTextTransformer
 */
public interface NumberToTextTransformer {

    String transformNumber(String number);

}
