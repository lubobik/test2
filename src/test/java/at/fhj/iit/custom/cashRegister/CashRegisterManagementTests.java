package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.base.SimpleDrink;
import at.fhj.iit.custom.drink.Cocktail;
import at.fhj.iit.custom.drink.LongDrink;
import at.fhj.iit.custom.drink.Smoothie;
import at.fhj.iit.custom.drink.Tea;
import at.fhj.iit.custom.misc.Brand;
import at.fhj.iit.custom.misc.Fruit;
import at.fhj.iit.custom.misc.SoftLiquid;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains test cases regarding the
 * <code>CashRegisterManagement</code>
 * class and its corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see CashRegisterManagement
 */
@DisplayName("Testing CashRegisterManagement class")
public class CashRegisterManagementTests {

    /*
     * Constant / field declaration
     */
    private final DrinkSale TEST_SALE = new DrinkSale(
            new SimpleDrink("TestDrink", new Liquid("TestLiquid", 12.23, 0.0)),
            new Operator("Jon", "Doe")
    );

    /*
     * Nested class to prevent unneeded setup phase for test cases.
     */
    @Nested
    @DisplayName("Testing capsuled addition tests")
    class AdditionTests {
        private CashRegisterManagement cashRegisterManagement;

        /*
         * Phase: Setup
         *
         * @BeforeEach is used here as re-init is required.
         */
        @BeforeEach
        public void setupEach() {
            cashRegisterManagement = new CashRegisterManagement();
        }

        @Test
        @DisplayName("Testing the addition of a single entry")
        public void addHistoryItem() {
            // Phase: Exercise
            cashRegisterManagement.addDrinkSale(TEST_SALE);

            // Phase: Verify
            assertNotNull(cashRegisterManagement);
            assertEquals(1, cashRegisterManagement.getSalesHistory().size());
        }

        @Test
        @DisplayName("Testing the addition of multiple entries")
        public void addMultipleHistoryItems() {
            // Phase: Exercise
            cashRegisterManagement.addMultiDrinkSales(
                    List.of(TEST_SALE, TEST_SALE, TEST_SALE)
            );

            // Phase: Verify
            assertNotNull(cashRegisterManagement);
            assertEquals(3, cashRegisterManagement.getSalesHistory().size());
        }
    }

    /*
     * Nested class to prevent unneeded setup phase for test cases.
     * Note: Lifecycle.PER_CLASS will be used to omit static declarations.
     */
    @Nested
    @DisplayName("Testing capsuled report tests")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ReportTests {

        /*
         * Test field declaration
         */
        private Operator operatorOne;
        private Operator operatorTwo;
        private CashRegisterManagement cashRegisterManagement;

        /*
         * Phase: Setup
         *
         * @BeforeAll is used here to prevent redundant initialisation
         * (only when no manipulation takes place,
         * because manipulation throughout multiple tests is considered bad practice).
         */
        @BeforeAll
        public void setupAll() {
            operatorOne = new Operator("Christian", "Hofer");
            operatorTwo = new Operator("Andreas", "Steirer");

            Cocktail magicSunrise = new Cocktail("Magic Sunrise", List.of(
                    new Liquid("Grenadine", 0.4, 0.0),
                    new Liquid("Orange juice", 3.0, 0.0),
                    new Liquid("Lemon juice", 0.04, 0.0),
                    new Liquid("Pineapple juice", 1.7, 0.0)
            ));

            Cocktail maiTai = new Cocktail("Mai Tai", List.of(
                    new Liquid("Lime juice", 2.0, 0.0),
                    new Liquid("Brown rum", 6.0, 80.0),
                    new Liquid("Sugar syrup", 1.0, 0.0),
                    new Liquid("Almond syrup", 1.0, 0.0),
                    new Liquid("Orange liquor", 1.0, 30.0),
                    new Liquid("Pineapple syrup", 5.0, 0.0)

            ));

            LongDrink vodkaCranberry = new LongDrink(
                    "Vodka Cranberry",
                    new Liquid("Vodka", 0.3, 40),
                    new SoftLiquid("Cranberry Juice", 0.5, Brand.PEPSI)
            );

            Smoothie milkshake = new Smoothie(
                    "Milkshake",
                    new Liquid("Milk", 0.5, 0),
                    List.of(
                            new Fruit("Strawberry"),
                            new Fruit("Banana"),
                            new Fruit("Ananas")
                    ),
                    false);

            Tea earlyGrey = new Tea(
                    "Early Grey",
                    new Liquid("Water", 0.3, 0),
                    true,
                    true
            );

            SimpleDrink redWine =
                    new SimpleDrink("Red wine", new Liquid("Wine", 0.75, 13));

            cashRegisterManagement = new CashRegisterManagement(
                    List.of(
                            new DrinkSale(magicSunrise, operatorOne),
                            new DrinkSale(maiTai, operatorTwo),
                            new DrinkSale(vodkaCranberry, operatorOne),
                            new DrinkSale(milkshake, operatorOne),
                            new DrinkSale(earlyGrey, operatorOne),
                            new DrinkSale(redWine, operatorTwo)
                    )
            );
        }

        @Test
        @DisplayName("Testing report of total non alcoholic beverages")
        public void retrieveTotalOfNonAlcoholicBeverages() {
            // Phases: Verify(Exercise)
            assertEquals(23.46, cashRegisterManagement.retrieveTotalOfNonAlcoholicBeverages(), 0.001);
        }

        @Test
        @DisplayName("Testing report of total weak alcoholic beverages")
        public void retrieveTotalOfAlcoholicBeveragesWeak() {
            // Phases: Verify(Exercise)
            assertEquals(2.69, cashRegisterManagement.retrieveTotalOfAlcoholicBeveragesWeak(), 0.001);
        }

        @Test
        @DisplayName("Testing report of total intense alcoholic beverages")
        public void retrieveTotalOfAlcoholicBeveragesIntense() {
            // Phases: Verify(Exercise)
            assertEquals(126.6, cashRegisterManagement.retrieveTotalOfAlcoholicBeveragesIntense(), 0.001);
        }

        @Test
        @DisplayName("Testing report of total by date")
        public void retrieveTotalByDate() {
            // Phases: Verify(Exercise)
            assertEquals(152.75, cashRegisterManagement.retrieveTotalByDate(LocalDate.now()), 0.001);
        }

        @Test
        @DisplayName("Testing report of total by Operator")
        public void retrieveTotalByOperator() {
            // Phases: Verify(Exercise)
            assertEquals(25.3, cashRegisterManagement.retrieveTotalByOperator(operatorOne), 0.001);
        }

        @Test
        @DisplayName("Testing report of total by date and Operator")
        public void retrieveTotalByDateAndOperator() {
            // Phases: Verify(Exercise)
            assertEquals(127.45,
                    cashRegisterManagement.retrieveTotalByDateAndOperator(
                            LocalDate.now(), operatorTwo)
            );
            assertEquals(0.0,
                    cashRegisterManagement.retrieveTotalByDateAndOperator(
                            LocalDate.now().minusDays(1), operatorTwo)
            );
        }

        /*
         * More or less important to test.
         * Normally this is very rarely tested separately.
         */
        @Test
        @DisplayName("Testing history list retrieval")
        public void retrieveSaleHistory() {
            // Phases: Verify(Exercise)
            assertEquals(6, cashRegisterManagement.getSalesHistory().size());
        }
    }

    /*
     * Normally this is very rarely tested separately.
     * Typically, only when there are
     * more complex operations happening in there.
     * Testing value assigning of non-complex ctors is useless /
     * more or less not important.
     */
    @Test
    @DisplayName("Testing the default constructor")
    public void initNewInstanceEmpty() {
        // Phase: Exercise
        CashRegisterManagement cashRegisterManagement =
                new CashRegisterManagement();

        // Phase: Verify
        assertNotNull(cashRegisterManagement);
        assertTrue(cashRegisterManagement.getSalesHistory().isEmpty());
    }

    /*
     * Normally this is very rarely tested separately.
     * Typically, only when there are
     * more complex operations happening in there.
     * Testing value assigning of non-complex ctors is useless /
     * more or less not important.
     */
    @Test
    @DisplayName("Testing the history initialization constructor")
    public void initNewInstanceFilled() {
        // Phase: Exercise
        CashRegisterManagement testManagement =
                new CashRegisterManagement(List.of(TEST_SALE));

        // Phase: Verify
        assertNotNull(testManagement);
        assertEquals(1, testManagement.getSalesHistory().size());
    }
}
