package de.dhbw.calculator;

public class MainTest {
    /**
     * Hier werden die einzelnen Unit-Testfälle aufgerufen.
     */
    public static void runTests() {
        testAddition();
        testSubtraction();
        testMultiplication();
        testDivision();
    }

    /**
     * Test-Suite einrichten, Tests ausführen, aufräumen und Resultate ausgeben.
     *
     * @param args
     */
    public static void main(String[] args) {
        TestUtil.setUpStreams();
        runTests();
        TestUtil.restoreStreams();
        TestUtil.displayResults();
    }

    /**
     * Einfacher Additionstest.
     */
    public static void testAddition() {
        String[] args = {"2", "+", "2"};
        String ergebnis = "4.0";

        Main.main(args);

        TestUtil.assertOutputContains(ergebnis);
    }

    /**
     * Einfacher Subtraktionstest.
     */
    public static void testSubtraction() {
        String[] args = {"2", "-", "2"};
        String ergebnis = "0.0";

        Main.main(args);

        TestUtil.assertOutputContains(ergebnis);
    }

    /**
     * Einfacher Multiplikationstest.
     */
    public static void testMultiplication() {
        String[] args = {"2", "*", "2"};
        String ergebnis = "4.0";

        Main.main(args);

        TestUtil.assertOutputContains(ergebnis);
    }

    /**
     * Einfacher Divisionstest.
     */
    public static void testDivision() {
        String[] args = {"2", "/", "2"};
        String ergebnis = "1.0";

        Main.main(args);

        TestUtil.assertOutputContains(ergebnis);
    }
}
