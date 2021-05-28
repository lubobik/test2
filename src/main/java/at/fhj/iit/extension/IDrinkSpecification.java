package at.fhj.iit.extension;

/**
 * Represents a little extension for <code>Drink</code> class(es).
 * (for more conceptual reasons, have a look at the README file).
 *
 * @author Andreas Steirer
 * @version 3.0
 */
public interface IDrinkSpecification {

    /**
     * Calculates the price of a specific drink,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific drink
     */
    double calculatePrice();
}
