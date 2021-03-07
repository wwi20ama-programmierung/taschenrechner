package de.dhbw.calculator;

import de.dhbw.calculator.exceptions.TestFailedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private static final List<String> runTests = new ArrayList<>();

    /**
     * Überprüft, ob zwei Objekte gleich sind.
     *
     * @param a
     * @param b
     */
    public static void assertEqual(Object a, Object b) {
        if (a != b) {
            addFailingTest("'" + a + "' ist nicht gleich '" + b + "'.");
        } else {
            addFailingTest("'" + a + "' ist gleich '" + b + "'.");
        }
    }

    /**
     * Muss vor der Ausführung von Tests ausgeführt werden, um die Konsolenausgaben umzuleiten, damit diese
     * überprüft werden können.
     */
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Muss nach der Ausführung von Tests ausgeführt werden, um die Konsolenausgaben wieder zurück zur
     * Standardausgabe (Konsole) umzuleiten, um die Testauswertung anzeigen zu können.
     */
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Überprüft, ob die Konsolenausgabe den übergebenen String enthält oder diesem entspricht.
     *
     * @param expected
     */
    public static void assertOutputContains(String expected) {
        String actual = outContent.toString();

        // Nicht benötigte Sonderzeichen löschen
        actual = actual.replace("\r", "").replace("\n", "");
        if (!actual.contains(expected)) {
            addFailingTest("Ausgabe '" + actual + "' ist nicht gleich oder Teil von '" + expected + "'.");
        } else {
            addSuccessfulTest("Ausgabe '" + actual + "' ist gleich oder Teil von '" + expected + "'. ");
        }

        outContent.reset();
    }

    /**
     * Gibt die Testresultate an der Konsole aus.
     */
    public static void displayResults() {
        for (String runTest : runTests) {
            System.out.println(runTest);
        }
    }

    /**
     * Hilfsmethode, um einen erfolgreichen Test zu protokollieren.
     *
     * @param message
     */
    private static void addSuccessfulTest(String message) {
        runTests.add("[ERFOLG] " + message);
    }

    /**
     * Hilfsmethode, um einen fehlgeschlagenen Test zu protokollieren.
     *
     * @param message
     */
    private static void addFailingTest(String message) {
        runTests.add("[FEHLER] " + message);
    }
}
