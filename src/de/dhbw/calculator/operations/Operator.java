package de.dhbw.calculator.operations;

/**
 * Dieses Interface muss von jeder Rechenoperator (z. B. Addition) implementiert werden
 */
public interface Operator {
    /**
     * Die eigentliche Berechnung findet in dieser Methode statt.
     *
     * @param a
     * @param b
     * @return Ergebnis
     */
    double calculate(double a, double b);

    /**
     * Für die Logging-Funktionalität kann jede Rechenoperation mitteilen, was an der Konsole ausgegeben werden
     * soll, z. B. "Addition" oder "Subtraktion"
     *
     * @return Name des Operators als String
     */
    String getActionName();
}
