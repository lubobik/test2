package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;

/**
 * Describes a <code>LongDrink</code> object,
 * with methods to calculate Volume/alcoholic percentage.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see Drink
 * @since 2.0
 */
public class LongDrink extends Drink {

    /**
     * An alcoholic <code>Liquid</code> for mixing purposes.
     */
    protected Liquid alcoholic;

    /**
     * A (maybe) non-alcoholic liquid <code>Liquid</code> for mixing purposes.
     */
    protected Liquid softLiquid;

    /**
     * Creates a <code>LongDrink</code> object with a give name,
     * one alcoholic <code>Liquid</code> and a <code>SoftLiquid</code>.
     *
     * @param name       name of the drink
     * @param alcoholic  the alcoholic liquid of a <code>LongDrink</code>
     * @param softLiquid the (maybe) non-alcoholic liquid of a <code>LongDrink</code>
     */
    public LongDrink(String name, Liquid alcoholic, Liquid softLiquid) {
        super(name);
        this.alcoholic = alcoholic;
        this.softLiquid = softLiquid;
    }

    /**
     * Calculates and returns volume of <code>Drink</code>.
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return alcoholic.getVolume() + softLiquid.getVolume();
    }

    /**
     * Calculates and returns the alcohol percentage.
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return (alcoholic.getAlcoholPercent() * alcoholic.getVolume() + softLiquid.getAlcoholPercent() * softLiquid.getVolume()) / getVolume();

    }

    /**
     * Gives information if <code>Drink</code> is alcoholic or not.
     *
     * @return true when alcoholic <code>Liquid</code>s are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

    /**
     * Formatted output of a <code>LongDrink</code> object.
     *
     * @return the String representation of the object
     */
    @Override
    public String toString() {
        return name + " like the name suggests is " + alcoholic.getName() + " and " + softLiquid.getName() + " with an alcohol percentage of " + getAlcoholPercent() + "%.";
    }

    /**
     * Calculates the price of the <code>Drink</code>,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific <code>Drink</code>
     */
    @Override
    public double calculatePrice() {
        return getVolume() * (1.0 + (getAlcoholPercent() / 100.0)) * 2.0;
    }
}
