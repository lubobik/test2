package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.misc.Fruit;

import java.util.List;

/**
 * Describes a <code>Smoothie</code> object.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see Drink
 * @since 1.0
 */
public class Smoothie extends Drink {

    /**
     * The base <code>Liquid</code> of the <code>Smoothie</code>.
     */
    protected Liquid baseLiquid;

    /**
     * States if sugar is included or not.
     */
    protected Boolean sugar;

    /**
     * Includes all <code>Fruit</code>s of the <code>Smoothie</code>.
     */
    private final List<Fruit> fruitList;

    /**
     * Creates a <code>Smoothie</code> object with given name,
     * base <code>Liquid</code>, <code>Fruit</code>s and sweetener.
     *
     * @param name        name of drink
     * @param baseLiquid, tells us the base of the <code>Smoothie</code> (eg milk, juice...)
     * @param fruitList   is a list from <code>Fruit</code>s that are mixed together
     * @param sweetener   tells if the <code>Smoothie</code> is sweetened
     */
    public Smoothie(String name, Liquid baseLiquid, List<Fruit> fruitList, boolean sweetener) {
        super(name);
        this.fruitList = fruitList;
        this.baseLiquid = baseLiquid;
        this.sugar = sweetener;
    }

    /**
     * Calculates and returns volume of <code>Drink</code>.
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return baseLiquid.getVolume();
    }

    /**
     * Calculates and returns the alcohol percentage.
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return baseLiquid.getAlcoholPercent();
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
     * Formatted output for a <code>Smoothie</code>
     *
     * @return the String representation of the object
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Here, have a nice Smoothie, it's a mix from " + baseLiquid.getName() + " and ");
        boolean first = true;
        for (Fruit fruit : fruitList) {
            if (first) {
                text.append(fruit.getName());
                first = false;
            } else {
                text.append(", ").append(fruit.getName());
            }
        }
        text.append(".");
        if (sugar) text.append(" It's even sweetened.");
        if (baseLiquid.getName().toLowerCase().equals("milk"))
            text.append("\nAnd guess what, as the base is milk, it's even better than a normal smoothie. It's a milkshake!");
        return text.toString();
    }

    /**
     * Calculates the price of the <code>Drink</code>,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific <code>Drink</code>
     */
    @Override
    public double calculatePrice() {
        double multiplier = 1 + (sugar ? 1 : 0) + fruitList.size();
        return getVolume() * (1.0 + (getAlcoholPercent() / 100.0)) * multiplier;
    }
}



