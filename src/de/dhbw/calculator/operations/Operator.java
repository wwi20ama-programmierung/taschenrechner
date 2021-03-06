package de.dhbw.calculator.operations;

/**
 * Dieses Interface muss jede Rechenoperator (z. B. Addition) implementieren
 */
public interface Operator {
    double calculate(double a, double b);

    String getActionName();
}
