package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Describes a <code>Cocktail</code> object (with data access)
 * and offers manipulation options.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see Drink
 * @since 1.0
 */
public class Cocktail extends Drink {

    /**
     * All <code>Liquid</code>s included in the <code>Cocktail</code>.
     */
    private final List<Liquid> liquids;

    /**
     * Creates a <code>Cocktail</code> object with
     * a given name and some included liquids.
     *
     * @param name name of the drink
     */
    public Cocktail(String name, List<Liquid> liquids) {
        super(name);
        verifyLiquidAmount(liquids);
        this.liquids = new ArrayList<>(liquids);
    }

    /**
     * Checks if the list of <code>Liquid</code>s is empty.
     * If so, throws a <code>ValidationException</code>.
     *
     * @param liquids which should be checked
     * @throws ValidationException if the list ist empty
     */
    private void verifyLiquidAmount(List<Liquid> liquids) {
        if (liquids.isEmpty())
            throw new ValidationException("A cocktail needs at least one liquid.");
    }

    /**
     * Returns the sum of included <code>Liquid</code>s in liters.
     *
     * @return total volume in liters
     */
    @Override
    public double getVolume() {
        return liquids
                .stream()
                .mapToDouble(Liquid::getVolume)
                .sum();
    }

    /**
     * Retrieves the total alcohol volume
     * of the <code>Cocktail</code> in percent.
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return (getAlcoholVolume() / getVolume()) * 100.0;
    }

    /**
     * Retrieves the total alcohol volume of the <code>Cocktail</code>.
     *
     * @return alcohol volume in liters
     */
    public double getAlcoholVolume() {
        return isAlcoholic() ?
                liquids
                        .stream()
                        .filter(liquid -> liquid.getAlcoholPercent() > 0)
                        .mapToDouble(liquid -> (liquid.getVolume() * (liquid.getAlcoholPercent() / 100)))
                        .sum()
                : 0.0;
    }

    /**
     * States if the <code>Cocktail</code> is alcoholic or not.
     *
     * @return true when alcoholic <code>Liquid</code>s are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return liquids
                .stream()
                .anyMatch(liquid -> liquid.getAlcoholPercent() > 0);
    }

    /**
     * Updates the passed <code>Liquid</code> within the list if it exists.
     *
     * @param liquid  which should be changed within the list
     * @param updater function which is responsible for value manipulation / update
     */
    public void updateLiquid(Liquid liquid, Consumer<Liquid> updater) {
        int foundIndex = liquids.indexOf(liquid);
        if (foundIndex != -1) {
            liquids.set(foundIndex, liquid);
            updater.accept(liquid);
        }
    }

    /**
     * Getter for <code>Liquid</code> list
     *
     * @return all included <code>Liquid</code>s
     */
    public List<Liquid> getLiquids() {
        return liquids;
    }

    /**
     * Formatted output of a <code>Cocktail</code> object.
     *
     * @return the String representation of the object
     */
    @Override
    public String toString() {
        String formattedLiquidNames = liquids
                .stream()
                .map(Liquid::getName)
                .collect(Collectors.joining(", "));
        String totalAlcoholPercentage = String.format("%.2f", getAlcoholPercent());

        return "The '" + name + "' includes following ingredients\n[" +
                formattedLiquidNames + "] with a total alcohol percentage of " + totalAlcoholPercentage + "%.";
    }

    /**
     * Calculates the price of the <code>Drink</code>,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific <code>Drink</code>
     */
    @Override
    public double calculatePrice() {
        return getVolume() * (1.0 + (getAlcoholPercent() / 100.0)) * this.liquids.size();
    }
}

