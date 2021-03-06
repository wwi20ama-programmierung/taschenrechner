package de.dhbw.calculator.exceptions;

/**
 * Über diese Exception (die von RuntimeException erbt), können wir einen sehr spezifischen Fehler
 * bei Berechnungsproblemen werfen.
 */
public class CalculationException extends RuntimeException {

    // Wir benötigen einen Konstruktor, der die Fehlermeldung entgegennimmt.
    public CalculationException(String errorMessage) {
        super(errorMessage);
    }
}
