package de.dhbw.calculator.operations;

public class Addition implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }

    @Override
    public String getActionName() {
        return "Addition";
    }
}
