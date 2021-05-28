package at.fhj.iit.util;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.cashRegister.CashRegisterManagement;
import at.fhj.iit.custom.cashRegister.DrinkSale;
import at.fhj.iit.custom.cashRegister.Operator;
import at.fhj.iit.custom.drink.Cocktail;
import at.fhj.iit.custom.drink.LongDrink;
import at.fhj.iit.custom.drink.Smoothie;
import at.fhj.iit.custom.drink.Tea;
import at.fhj.iit.custom.misc.Fruit;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class for filling the <code>CashRegisterManagement</code>
 * implementation with random information
 * (mainly for demonstration purposes, but also created out of sheer fun :D).
 *
 * @author Andreas Steirer
 * @version 3.0
 */
public final class CashRegisterRandomizer {

    /**
     * Constant definition
     */
    private static final Faker FAKER = new Faker();
    private static final List<Operator> OPERATORS = List.of(
            new Operator("Andreas", "Steirer"),
            new Operator("Lukas", "Bobik"),
            new Operator("Michael", "Ulm"),
            new Operator("Christian", "Hofer")
    );

    /**
     * Class wide definition of <code>CashRegisterManagement</code>
     * object to prevent unnecessary passing between generation methods.
     */
    private static CashRegisterManagement cashRegisterManagement;

    /**
     * Required to reach full Jacoco code coverage.
     */
    private CashRegisterRandomizer() {
    }

    /**
     * Creates a new instance of the <code>CashRegisterManagement</code> object,
     * and fills its sales list with random generated <code>Drink</code> objects.
     *
     * @return the retrieved random percent value
     */
    public static CashRegisterManagement generateRandomTestCashRegister() {
        cashRegisterManagement = new CashRegisterManagement();

        generateRandomCocktails();
        generateRandomLongDrinks();
        generateRandomSmoothies();
        generateRandomTeas();

        return cashRegisterManagement;
    }

    /**
     * Retrieves a random operator from
     * the predefined <code>Operator</code> list.
     *
     * @return the retrieved random percent value
     */
    public static Operator retrieveRandomOperator() {
        return OPERATORS.get(FAKER.number().numberBetween(0, OPERATORS.size() - 1));
    }

    /**
     * Generates random <code>Cocktail</code> creations and
     * adds them to the current <code>CashRegisterManagement</code> object of the class.
     */
    private static void generateRandomCocktails() {
        ArrayList<Liquid> liquids = new ArrayList<>();
        for (int i = 0; i < FAKER.number().numberBetween(1, 5); i++) {
            for (int j = 0; j < FAKER.number().numberBetween(1, 5); j++) {
                liquids.add(generateRandomLiquid(FAKER.random().nextBoolean()));
            }
            cashRegisterManagement.addDrinkSale(
                    new DrinkSale(
                            new Cocktail(FAKER.beer().name(), liquids),
                            retrieveRandomOperator()
                    )
            );
        }
    }

    /**
     * Generates random <code>LongDrink</code> creations and
     * adds them to the current <code>CashRegisterManagement</code> object of the class.
     */
    private static void generateRandomLongDrinks() {
        for (int i = 0; i < FAKER.number().numberBetween(1, 5); i++) {
            cashRegisterManagement.addDrinkSale(
                    new DrinkSale(
                            new LongDrink(
                                    FAKER.beer().name(),
                                    generateRandomLiquid(true),
                                    generateRandomLiquid(false)
                            ),
                            retrieveRandomOperator()
                    )
            );
        }
    }

    /**
     * Generates random <code>Smoothie</code>  creations and
     * adds them to the current <code>CashRegisterManagement</code> object of the class.
     */
    private static void generateRandomSmoothies() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < FAKER.number().numberBetween(1, 5); i++) {
            for (int j = 0; j < FAKER.number().numberBetween(1, 5); j++) {
                fruits.add(new Fruit(FAKER.food().fruit()));
            }
            cashRegisterManagement.addDrinkSale(
                    new DrinkSale(
                            new Smoothie(
                                    FAKER.beer().name(),
                                    generateRandomLiquid(false),
                                    fruits,
                                    FAKER.random().nextBoolean()
                            ),
                            retrieveRandomOperator()
                    )
            );
        }
    }

    /**
     * Generates random <code>Tea</code>  creations and
     * adds them to the current <code>CashRegisterManagement</code> object of the class.
     */
    private static void generateRandomTeas() {
        for (int i = 0; i < FAKER.number().numberBetween(1, 5); i++) {
            cashRegisterManagement.addDrinkSale(
                    new DrinkSale(
                            new Tea(
                                    FAKER.beer().name(),
                                    generateRandomLiquid(false),
                                    FAKER.random().nextBoolean(),
                                    FAKER.random().nextBoolean()
                            ),
                            retrieveRandomOperator()
                    )
            );
        }
    }

    /**
     * Generates a <code>Liquid</code> object including random values
     * (name, volume and alcoholPercentage).
     *
     * @param isAlcoholic states if the <code>Liquid</code> should be alcoholic or not.
     * @return the retrieved randomly generated Liquid
     */
    private static Liquid generateRandomLiquid(boolean isAlcoholic) {
        return new Liquid(
                FAKER.food().ingredient(),
                generateRandomVolume(),
                isAlcoholic ? generateRandomPercentage() : 0.0
        );
    }

    /**
     * Generates a random volume value between 0 and 10.
     *
     * @return the retrieved random volume value
     */
    private static double generateRandomVolume() {
        return FAKER
                .number()
                .randomDouble(2, 1, 11) - 1;
    }

    /**
     * Generates a random percent value between 0 and 100.
     *
     * @return the retrieved random percent value
     */
    private static double generateRandomPercentage() {
        return FAKER
                .number()
                .randomDouble(2, 0, 100);
    }
}
