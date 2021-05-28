package at.fhj.iit.custom.cashRegister;

/**
 * Represents an <code>Operator</code> / person,
 * who is capable of selling <code>Drink</code>s to customers.
 *
 * @author Andreas Steirer
 * @version 3.0
 */
public class Operator {
    
    /**
     * The first name of the <code>Operator</code> / person.
     */
    private final String firstName;

    /**
     * The last name of the <code>Operator</code> / person.
     */
    private final String lastName;

    /**
     * Initialises a new <code>DrinkSale</code> object,
     * with its corresponding <code>Drink</code>,
     * <code>Operator</code>, timestamp and price values.
     *
     * @param firstName the firstname of the particular <code>Operator</code> / person
     * @param lastName  the lastname of the particular <code>Operator</code> / person
     */
    public Operator(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the first- and lastname
     * of the particular <code>Operator</code> concatenated.
     *
     * @return the full name of the <code>Operator</code>
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
