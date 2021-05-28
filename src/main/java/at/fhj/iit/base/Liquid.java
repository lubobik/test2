package at.fhj.iit.base;

import at.fhj.iit.exception.ValidationException;

/**
 * Represents a <code>Liquid</code> which can be used in <code>Drink</code>s.
 *
 * @author Michael Ulm
 * @author Christian Hofer
 * @author Andreas Steirer
 * @version 2.0
 * @see Drink
 * @since 1.0
 */
public class Liquid {

    /**
     * Name of a <code>Liquid</code>.
     */
    private String name;

    /**
     * Volume of a <code>Liquid</code> (in liter).
     */
    private double volume;

    /**
     * Alcohol percentage of a <code>Liquid</code> (in percent eg. 42).
     */
    private double alcoholPercent;

    /**
     * Creates new <code>Liquid</code> with given name, volume and
     * alcohol percentage.
     *
     * @param name           name of <code>Liquid</code>
     * @param volume         volume of <code>Liquid</code>
     * @param alcoholPercent of <code>Liquid</code>
     */
    public Liquid(String name, double volume, double alcoholPercent) {
        this.name = name;
        checkVolume(volume);

        this.volume = volume;
        this.alcoholPercent = alcoholPercent;
    }

    /**
     * Checks if the passed volume is lower than or equal to zero.
     * If so, throws a <code>ValidationException</code>.
     *
     * @param volume which should be checked
     * @throws ValidationException if the volume is below zero or equal to zero.
     */
    private void checkVolume(double volume) {
        if (volume <= 0) {
            throw new ValidationException("liquid " + name + " must have a volume > 0");
        }
    }

    /**
     * Getter for name.
     *
     * @return the name of <code>Liquid</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name a new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for volume.
     *
     * @return the volume of liquid (in liter)
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Setter for volume.
     *
     * @param volume a new volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Getter for alcohol percentage.
     *
     * @return the alcohol percentage (e.g. 40)
     */
    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    /**
     * Setter for alcohol percentage.
     *
     * @param alcoholPercent a new alcohol percentage
     */
    public void setAlcoholPercent(double alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }
}