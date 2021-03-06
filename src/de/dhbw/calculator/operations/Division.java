package de.dhbw.calculator.operations;

import de.dhbw.calculator.exceptions.CalculationException;

public class Division implements Operator {
    @Override
    public double calculate(double a, double b) {
        if (b == 0.0) {
            throw new CalculationException("Teilen durch 0 ist nicht erlaubt!");
        }

        return a / b;
    }

    @Override
    public String getActionName() {
        return "Division";
    }
}
