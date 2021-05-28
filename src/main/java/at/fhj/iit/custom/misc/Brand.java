package at.fhj.iit.custom.misc;

/**
 * Specifies a <code>Brand</code> enumeration with an
 * also fixed name specification.
 *
 * @author Andreas Steirer
 * @version 2.0
 * @since 1.0
 */
public enum Brand {
    COCA_COLA("Coca Cola"),
    LA_CROIX("La Croix"),
    PEPSI("Pepsi"),
    NESQUIK("Nesquik"),
    OTHER("Other"),
    ;

    /*
     * The specified name.
     */
    private final String name;

    /**
     * The initialisation of an enum value.
     *
     * @param name the more specified name of the enum value.
     */
    Brand(String name) {
        this.name = name;
    }

    /**
     * Output of a stringified <code>Brand</code> enum value.
     *
     * @return the specified name of the enum value
     */
    @Override
    public String toString() {
        return name;
    }
}
