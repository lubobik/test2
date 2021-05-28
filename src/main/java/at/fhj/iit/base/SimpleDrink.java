package at.fhj.iit.base;

/**
 * Represents a <code>SimpleDrink</code>
 * with a <code>Liquid</code> which can be used in drinks.
 *
 * @author Michael Ulm
 * @author Christian Hofer
 * @author Andreas Steirer
 * @version 3.0
 * @see Drink
 * @since 1.0
 */
public class SimpleDrink extends Drink {

    /**
     * A single <code>Liquid</code> of the <code>Drink</code>.
     */
    protected Liquid liquid;

    /**
     * Creates a <code>SimpleDrink</code> object with given name and <code>Liquid</code>.
     *
     * @param name   name of <code>Drink</code>
     * @param liquid only one <code>Liquid</code> in <code>Drink</code>,
     *               because it's a <code>SimpleDrink</code> and not e.g. a <code>Cocktail</code>
     */
    public SimpleDrink(String name, Liquid liquid) {
        super(name);
        this.liquid = liquid;
    }

    /**
     * Returns volume of the included <code>Liquid</code>.
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        return liquid.getVolume();
    }

    /**
     * Returns alcohol volume percent of the included <code>Liquid</code>.
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return liquid.getAlcoholPercent();
    }

    /**
     * Gives information if <code>Drink</code> is alcoholic or not.
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return liquid.getAlcoholPercent() > 0;
    }

    /**
     * Formatted output of a <code>SimpleDrink</code> object.
     *
     * @return the String representation of the object
     */
    @Override
    public String toString() {
        return "Simple Drink called " + name + " with " + liquid.getAlcoholPercent() + " percent alcohol by volume";
    }

    /**
     * Calculates the price of the <code>Drink</code>,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific <code>Drink</code>
     */
    @Override
    public double calculatePrice() {
        return getVolume() * (1.0 + (getAlcoholPercent() / 100.0));
    }
}
