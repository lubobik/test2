package at.fhj.iit.custom.misc;

/**
 * Specifies a <code>Fruit</code>
 * class storing the name of the <code>Fruit</code>.
 *
 * @author Lukas Bobik
 * @version 1.0
 */
public class Fruit {
    private String name;

    /**
     * Creates new <code>Fruit</code>.
     *
     * @param name name of <code>Fruit</code>
     */
    public Fruit(String name) {
        this.name = name;
    }

    /**
     * Getter for name.
     *
     * @return name of <code>Fruit</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name <code>Fruit</code> name
     */
    public void setName(String name) {
        this.name = name;
    }
}
