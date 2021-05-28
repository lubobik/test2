package at.fhj.iit.util;

/**
 * A little helper class containing utility methods
 * used throughout the Drinks project.
 *
 * @author Andreas Steirer
 * @version 3.0
 */
public final class DrinkUtils {

    /**
     * Required to reach full Jacoco code coverage.
     */
    private DrinkUtils() {
    }

    /**
     * Prints a dashed line out of 110 characters to the console.
     */
    public static void printSeparator() {
        System.out.println("-".repeat(110));
    }

    /**
     * Rounds / floors a specified value to two decimal places.
     *
     * @param value a value which should be rounded and fixed to two decimal places
     * @return the rounded / floored value
     */
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * Prints a formatted output message including a passed metric
     * (format: "<message>: <metric> (formatted to two decimal places)\n").
     *
     * @param message an individual output message
     * @param metric  an individual metric
     */
    public static void printFormattedMetric(String message, double metric) {
        System.out.printf("%s: %.2f€\n", message, metric);
    }
}
