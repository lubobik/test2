package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;

/**
 * Describes a <code>Tea</code> object.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see Drink
 * @since 1.0
 */
public class Tea extends Drink {

    /**
     * Uses one <code>Liquid</code>.
     */
    protected Liquid liquid;

    /**
     * Sugar is optional.
     */
    protected Boolean sugar;

    /**
     * Milk is optional.
     */
    protected Boolean milk;


    /**
     * Creates a <code>Tea</code> object with given name, <code>Liquid</code> and sugar.
     *
     * @param name   name of <code>Liquid</code>
     * @param liquid only one liquid (maybe water) in drink, because it's a tea
     * @param sugar  tells if the <code>Tea</code> is with or without sugar
     * @param milk   tells if the <code>Tea</code> is with or without milk
     */
    public Tea(String name, Liquid liquid, Boolean sugar, Boolean milk) {
        super(name);
        this.liquid = liquid;
        this.sugar = sugar;
        this.milk = milk;
    }

    /**
     * Tells if the <code>Tea</code> has milk or not.
     *
     * @return true, if there is milk in the <code>Tea</code>
     */
    public boolean getMilk() {
        return sugar;
    }

    /**
     * Tells if the <code>Tea</code> has sugar or not.
     *
     * @return true, if there is sugar in the <code>Tea</code>
     */
    public boolean getSugar() {
        return sugar;
    }

    /**
     * Returns volume of <code>Liquid</code>.
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        return liquid.getVolume();
    }

    /**
     * Calculates and returns the alcohol percentage.
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return liquid.getAlcoholPercent();
    }

    /**
     * Gives information if <code>Drink</code> is alcoholic or not.
     *
     * @return true when alcoholic <code>Liquid</code>s are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return false;
    }

    /**
     * Formatted output for a <code>Tea</code>.
     *
     * @return the String representation of the object
     */
    @Override
    public String toString() {
        String text = "This tea is from sort " + name + " with";
        if (sugar && milk) {
            text += " sugar and milk";
        } else if (sugar) {
            text += " sugar";
        } else if (milk) {
            text += " milk";
        } else {
            text += "out milk or sugar";
        }
        return text;
    }

    /**
     * Calculates the price of the <code>Drink</code>,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific <code>Drink</code>
     */
    @Override
    public double calculatePrice() {
        double multiplier = 1 + (sugar ? 1 : 0) + (milk ? 1 : 0);
        return getVolume() * (1.0 + (getAlcoholPercent() / 100.0)) * multiplier;
    }
}
