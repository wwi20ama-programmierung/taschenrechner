package de.dhbw.calculator;

import de.dhbw.calculator.exceptions.CalculationException;
import de.dhbw.calculator.exceptions.UnsupportedOperatorException;
import de.dhbw.calculator.operations.*;
import de.dhbw.calculator.operations.Operator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private boolean logging = false;
    // Erinnerung: Für die Liste müssen wir "Integer" (Double) statt dem Basistyp "double" verwenden
    private List<Double> numbers;
    private List<Operator> operators;

    public Calculator() {
        // Beide Listen bei Erstellung eines neuen Rechner-Objekts mit leeren ArrayLists initialisieren
        this.numbers = new ArrayList<>();
        this.operators = new ArrayList<>();
    }

    /**
     * Optional kann bei Erstellung eines Calculators entschieden werden, ob die einzelnen Rechenschritte
     * an der Konsole ausgegeben werden sollen.
     *
     * @param logging
     */
    public Calculator(boolean logging) {
        this(); // ruft den Konstruktor ohne Argumente auf
        this.logging = logging;
    }

    /**
     * Fügt eine weitere Zahl zur Liste der zu berechnenden Zahlen hinzu.
     *
     * @param number
     */
    public void addNumber(double number) {
        this.numbers.add(number);
    }

    /**
     * Diese Methode ermöglicht die Verwendung verschiedener Beschreibungen (z. B. "plus" oder "+" für Addition)
     * und mappt die Nutzereingabe zu einem Operator, der das Interface "Operator" implementieren muss.
     *
     * @param operator
     */
    public void addOperator(String operator) {
        // zur einfachereren Vergleichbarkeit werden alle Operator-Strings zu Kleinbuchstaben konvertiert
        operator = operator.toLowerCase();

        switch (operator) {
            case "+":
            case "plus":
                this.operators.add(new Addition());
                break;
            case "-":
            case "minus":
                this.operators.add(new Subtraction());
                break;
            case "*":
            case "x":
            case "mal":
                this.operators.add(new Multiplication());
                break;
            case "/":
            case ":":
            case "%":
            case "geteilt durch":
                this.operators.add(new Division());
                break;
            default:
                // ... ansonsten wird eine Exception geworfen
                throw new UnsupportedOperatorException("Operator " + operator + " nicht unterstützt.");
        }
    }

    /**
     * Nutzt die vorher hinzugefügten Zahlen und Operatoren, um das Ergebnis zu berechnen.
     *
     * @return Ergebnis
     */
    public double calculate() {
        // Da wir die Anzahl der Elemente in der Liste mehrmals brauchen, speichern wie sie hier zwischen.
        int numbersSize = this.numbers.size();
        int operatorsSize = this.operators.size();

        if (numbersSize == 0 && operatorsSize == 0) {
            // Keine Berechnung notwendig, das Ergebnis ist 0.0
            return 0.0;
        }

        // Überprüfen, ob die Anzahl der Zahlen und Operatoren valide ist:
        // Ist die Anzahl der Zahlen gerade, muss die Anzahl der Operatoren ungerade sein (und andersherum).
        boolean geradeZahlen = (numbersSize % 2 == 0) && (operatorsSize % 2 == 1);
        boolean geradeOperatoren = (numbersSize % 2 == 1) && (operatorsSize % 2 == 0);
        if (!(geradeZahlen || geradeOperatoren)) {
            // Das Werfen einer Exception beendet automatisch auch die Methode.
            throw new CalculationException("Berechnung mit " + numbersSize + " Zahlen und " + operatorsSize + " Operatoren nicht möglich.");
        }

        double result = this.numbers.get(0); // Wir starten mit der zuerst eingegebenen Zahl
        for (int i = 0; i < numbersSize - 1; i++) {
            double b = this.numbers.get(i + 1);
            Operator operator = this.operators.get(i);

            if (this.logging) {
                // Falls das Logging für der Zwischenergebnisse aktiviert wurde, gebe dieses aus.
                String loggingOutput = String.format("%s von %f mit %f.", operator.getActionName(), result, b);
                System.out.println(loggingOutput);
            }
            result = operator.calculate(result, b);
        }

        return result;
    }

    /**
     * Versucht, den String in einen Double umzuwandeln. Schlägt dies fehl, ist der übergebene String
     * kein numerischer Wert.
     *
     * @param doubleAsStr
     * @return Ist String ein Double?
     */
    public static boolean isDouble(String doubleAsStr) {
        try {
            double number = Double.parseDouble(doubleAsStr);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
