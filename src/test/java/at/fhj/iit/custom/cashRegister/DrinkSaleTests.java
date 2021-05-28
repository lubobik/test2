package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.base.SimpleDrink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contains test cases regarding the
 * <code>DrinkSale</code> class and its
 * corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see DrinkSale
 */
@DisplayName("Testing DrinkSale class")
public class DrinkSaleTests {

    /*
     * Normally this is very rarely tested separately.
     * Typically, only when there are
     * more complex operations happening in there.
     * Testing value assigning of non-complex ctors is useless /
     * more or less not important.
     * The same principal applies to non-custom / standard getter
     * and setter implementations.
     *
     * We assign a price and and a timestamp, next to field initialisation,
     * that makes it a little bit more useful,
     * but not really in an astonishing way.
     */
    @Test
    @DisplayName("Testing init and retrieval of DrinkSale values")
    public void initAndRetrieveSaleValues() {
        // Phase: Setup
        Operator operator = new Operator("Jon", "Doe");
        DrinkSale drinkSale = new DrinkSale(
                new SimpleDrink(
                        "TestDrink",
                        new Liquid("TestLiquid", 12.23, 12.09)
                ), operator);

        // Phases: Verify(Exercise)
        assertTrue(drinkSale.getDrink().isAlcoholic());
        assertEquals(13.71, drinkSale.getPrice());
        assertEquals(12.23, drinkSale.getDrink().getVolume());
        assertEquals(12.09, drinkSale.getDrink().getAlcoholPercent());
        assertEquals(operator.getFullName(), drinkSale.getOperator().getFullName());
        assertEquals(
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                drinkSale.getSoldAt().truncatedTo(ChronoUnit.SECONDS)
        );
    }
}
