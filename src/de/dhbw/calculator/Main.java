package de.dhbw.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(true);

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (Calculator.isDouble(arg)) {
                int zahlAlsInteger = Integer.parseInt(arg);
                calculator.addNumber(zahlAlsInteger);
            } else {
                calculator.addOperator(arg);
            }
        }

        double result = calculator.calculate();
        System.out.println("Das Ergebnis ist: " + result);
    }
}
