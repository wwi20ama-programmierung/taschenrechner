package de.dhbw.calculator.operations;

public class Multiplication implements Operator {

    @Override
    public double calculate(double a, double b) {
        return a * b;
    }

    @Override
    public String getActionName() {
        return "Multiplikation";
    }
}
