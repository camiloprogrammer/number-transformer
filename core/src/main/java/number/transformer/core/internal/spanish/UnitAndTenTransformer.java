package number.transformer.core.internal.spanish;

import java.io.PrintWriter;

import number.transformer.core.internal.IntNumberTransformer;

public class UnitAndTenTransformer implements IntNumberTransformer {

    /**
     * Separator used in Spanish for numbers between 31 and 99. In Spanish numbers between 21 and 29
     * have no separator between tens and units (e.g. 21 -> "veintiuno" instead of "veinte y uno")
     */
    private static final String TENS_TO_UNITS_SEPARATOR = " y ";

    private static final String[] NUMBER_MAPPINGS = {
            "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho",
            "diecinueve", "veinte" };

    private static final String[] TENS_MAPPINGS = {
            "", "", "veinti", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa" };

    @Override
    public void transformNumber(PrintWriter out, int number) {
        validateNumber(number);
        if (NUMBER_MAPPINGS.length > number) {
            out.append(NUMBER_MAPPINGS[number]);
            return;
        }

        int tensUnits = number / 10;
        int remainder = number % 10;
        transformAndAppendUnits(out, tensUnits);
        transformAndAppendRemainder(out, tensUnits, remainder);
    }

    private void transformAndAppendUnits(PrintWriter out, int tensUnits) {
        out.append(TENS_MAPPINGS[tensUnits]);
    }

    private void transformAndAppendRemainder(PrintWriter out, int tensUnits, int remainder) {
        if (remainder > 0) {
            if (tensUnits > 2) {
                out.append(TENS_TO_UNITS_SEPARATOR);
            }
            out.append(NUMBER_MAPPINGS[remainder]);
        }
    }

    private void validateNumber(int number) {
        if (number < 0 || number > 99) {
            throw new IllegalArgumentException(number + " not supported by this transformer");
        }
    }
}
