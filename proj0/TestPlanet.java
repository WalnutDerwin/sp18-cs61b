
/**
 * Tests My Planet by creating two planets and prints out the pairwise force between them
 */
public class TestPlanet {

    /**
     * Tests My Planet
     */
    public static void main(String[] args) {
        checkMyPlanet();
    }

    /**
     * Checks whether or not two Doubles are equal and prints the result.
     *
     * @param expected Expected double
     * @param actual Double received
     * @param label Label for the 'test' case
     * @param eps Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     * Checks my planet and make sure pairwise force between them is right.
     */
    private static void checkMyPlanet() {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 133.4, "Pairwise Force", 0.01);
    }
}
