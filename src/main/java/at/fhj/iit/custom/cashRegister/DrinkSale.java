package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Drink;
import at.fhj.iit.util.DrinkUtils;

import java.time.LocalDateTime;

/**
 * Represent a sale of a particular drink,
 * including information about price,
 * the operator who fulfilled the sale and
 * the timestamp stating when the sale happened.
 *
 * @author Andreas Steirer
 * @version 3.0
 */
public class DrinkSale {

    /**
     * The <code>Drink</code> included in the sale.
     */
    private final Drink drink;

    /**
     * The price of the sale.
     */
    private final double price;

    /**
     * The <code>Operator</code> who achieved the sale.
     */
    private final Operator operator;

    /**
     * The time and date on which the sale happened.
     */
    private final LocalDateTime soldAt;

    /**
     * Initialises a new <code>DrinkSale</code> object,
     * with its corresponding <code>Drink</code>,
     * <code>Operator</code>, timestamp and price values.
     *
     * @param drink    the <code>Drink</code> included in the sale
     * @param operator the <code>Operator</code> who achieved the sale
     */
    public DrinkSale(Drink drink, Operator operator) {
        this.drink = drink;
        this.operator = operator;
        this.soldAt = LocalDateTime.now();
        this.price = DrinkUtils.roundToTwoDecimals(drink.calculatePrice());
    }

    /**
     * Retrieves information about the price of the sale.
     *
     * @return the calculated price of the particular <code>Drink</code>.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves information about the <code>Operator</code> who achieved the sale.
     *
     * @return the <code>Operator</code> who achieved the sale
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * Retrieves information about the time and date on which the sale happened.
     *
     * @return the <code>LocalDateTime</code> on which the sale happened
     */
    public LocalDateTime getSoldAt() {
        return soldAt;
    }

    /**
     * Retrieves information about the <code>Drink</code> included in the sale.
     *
     * @return the <code>Drink</code> of the sale
     */
    public Drink getDrink() {
        return drink;
    }
}
