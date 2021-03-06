package de.dhbw.calculator.exceptions;

/**
 * Über diese Exception (die von RuntimeException erbt), können wir einen sehr spezifischen Fehler
 * bei der Eingabe von falschen Operatoren werfen.
 */
public class UnsupportedOperatorException extends RuntimeException {

    // Wir benötigen einen Konstruktor, der die Fehlermeldung entgegennimmt.
    public UnsupportedOperatorException(String errorMessage) {
        super(errorMessage);
    }
}
