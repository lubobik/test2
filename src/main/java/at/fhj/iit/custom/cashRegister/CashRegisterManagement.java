package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Drink;
import at.fhj.iit.util.DrinkUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an inventory of a certain <code>DrinkSale</code> history.
 * Next to managing the sales history (in this case only additions are allowed),
 * there is also the possibility to retrieve reports from sales history.
 *
 * @author Andreas Steirer
 * @version 3.0
 */
public class CashRegisterManagement {

    /**
     * The history of all <code>DrinkSale</code> objects
     * of this particular <code>CashRegisterManagement</code> instance
     * (source of report generation).
     */
    private final List<DrinkSale> salesHistory;

    /**
     * Initialisation of the <code>DrinkSale</code> history.
     */
    public CashRegisterManagement() {
        this.salesHistory = new ArrayList<>();
    }

    /**
     * Initialisation of the <code>DrinkSale</code> history,
     * with an already available history.
     */
    public CashRegisterManagement(List<DrinkSale> salesHistory) {
        this.salesHistory = salesHistory;
    }

    /**
     * Getter to retrieve the current sales history.
     *
     * @return the current <code>DrinkSale</code> history entries.
     */
    public List<DrinkSale> getSalesHistory() {
        return salesHistory;
    }

    /**
     * Adds the passed <code>DrinkSale</code> to
     * the current <code>DrinkSale</code> history list.
     *
     * @param drinkSale a specific <code>DrinkSale</code>
     */
    public void addDrinkSale(DrinkSale drinkSale) {
        salesHistory.add(drinkSale);
    }

    /**
     * Adds the passed <code>DrinkSale</code>s list and
     * therefore its entries to the current <code>DrinkSale</code> history list.
     *
     * @param drinkSales specific <code>DrinkSale</code> entries
     */
    public void addMultiDrinkSales(List<DrinkSale> drinkSales) {
        salesHistory.addAll(drinkSales);
    }

    /**
     * Retrieves the total of all non alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @return the total of all non alcoholic <code>Drink</code> sales
     */
    public double retrieveTotalOfNonAlcoholicBeverages() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> !sale.getDrink().isAlcoholic())
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all weak alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @return the total of all weak alcoholic <code>Drink</code> sales
     */
    public double retrieveTotalOfAlcoholicBeveragesWeak() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> {
                    Drink drink = sale.getDrink();
                    return drink.isAlcoholic() && drink.getAlcoholPercent() <= 16.0;
                })
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all intense alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @return the total of all intense alcoholic <code>Drink</code> sales
     */
    public double retrieveTotalOfAlcoholicBeveragesIntense() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> {
                    Drink drink = sale.getDrink();
                    return drink.isAlcoholic() && drink.getAlcoholPercent() > 16.0;
                })
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all <code>Drink</code>s by a certain date
     * from the current <code>DrinkSale</code> history.
     *
     * @param soldAt a certain date / day on which the sale occurred
     * @return the total of all <code>Drink</code> sales on the passed date
     */
    public double retrieveTotalByDate(LocalDate soldAt) {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> sale.getSoldAt().toLocalDate().equals(soldAt))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all <code>Drink</code>s sold by a specific <code>Operator</code>
     * from the current <code>DrinkSale</code> history.
     *
     * @param soldBy a certain <code>Operator</code> who achieved the sale
     * @return the total of all <code>Drink</code> sales for the passed <code>Operator</code>
     */
    public double retrieveTotalByOperator(Operator soldBy) {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> sale.getOperator().equals(soldBy))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all <code>Drink</code>s
     * sold at a specific date and by a specific <code>Operator</code>
     * from the current <code>DrinkSale</code> history.
     *
     * @param soldAt a certain date / day on which the sale occurred
     * @param soldBy a certain <code>Operator</code> who achieved the sale
     * @return the total of all <code>Drink</code> sales for the passed date and <code>Operator</code>
     */
    public double retrieveTotalByDateAndOperator(LocalDate soldAt, Operator soldBy) {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale ->
                        sale.getSoldAt().toLocalDate().equals(soldAt)
                                && sale.getOperator().equals(soldBy)
                )
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }
}
