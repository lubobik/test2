package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Contains test cases regarding the
 * <code>Cocktail</code> class and its implementations.
 *
 * @author Andreas Steirer
 * @version 2.0
 * @see Cocktail
 */
@DisplayName("Testing Cocktail class")
public class CocktailTests {

    /*
     * Nested class to prevent unneeded setup phase for test cases.
     */
    @Nested
    @DisplayName("Testing setup needy tests")
    class SetupNeedyTests {

        /*
         * Class / Test field declaration
         */
        private Cocktail cocktailNumberOne;
        private Cocktail cocktailNumberTwo;

        /*
         * Phase: Setup
         *
         * @BeforeAll could be used here to prevent redundant initialisation
         * (only when no manipulation takes place,
         * because manipulation throughout multiple tests is considered bad practice).
         * We would need to extract all tests out of the @Nested class though,
         * as the static keyword would be required.
         * Else we could use Lifecycle.PER_CLASS in front of the
         * nested class to omit static declarations.
         */
        @BeforeEach
        public void setup() {
            cocktailNumberOne = new Cocktail("Magic Sunrise", List.of(
                    new Liquid("Grenadine", 0.4, 0.0),
                    new Liquid("Orange juice", 3.0, 0.0),
                    new Liquid("Lemon juice", 0.04, 0.0),
                    new Liquid("Pineapple juice", 1.7, 0.0)
            ));
            cocktailNumberTwo = new Cocktail("Mai Tai", List.of(
                    new Liquid("Lime juice", 2.0, 0.0),
                    new Liquid("Brown rum", 6.0, 80.0),
                    new Liquid("Sugar syrup", 1.0, 0.0),
                    new Liquid("Almond syrup", 1.0, 0.0),
                    new Liquid("Orange liquor", 1.0, 30.0),
                    new Liquid("Pineapple syrup", 5.0, 0.0)

            ));
        }


        @Test
        @DisplayName("Testing if non alcoholic")
        public void nonAlcoholicDetermination() {
            // Phases: Verify(Exercise)
            assertFalse(cocktailNumberOne.isAlcoholic());
        }

        @Test
        @DisplayName("Testing if alcoholic")
        public void alcoholicDetermination() {
            // Phases: Verify(Exercise)
            assertTrue(cocktailNumberTwo.isAlcoholic());
        }

        @Test
        @DisplayName("Testing total alcohol volumes (zero in total)")
        public void calculateTotalAlcoholVolumeWithZero() {
            // Phases: Verify(Exercise)
            assertEquals(0.0, cocktailNumberOne.getAlcoholVolume());
        }

        @Test
        @DisplayName("Testing total alcohol volumes")
        public void calculateTotalAlcoholVolume() {
            // Phases: Verify(Exercise)
            assertEquals(5.1, cocktailNumberTwo.getAlcoholVolume(), 0.001);
        }

        @Test
        @DisplayName("Testing total alcohol percentages (zero in total)")
        public void calculateTotalAlcoholPercentageWithZero() {
            // Phases: Verify(Exercise)
            assertEquals(0.0, cocktailNumberOne.getAlcoholPercent());
        }

        @Test
        @DisplayName("Testing total alcohol percentages")
        public void calculateTotalAlcoholPercentage() {
            // Phases: Verify(Exercise)
            assertEquals(31.875, cocktailNumberTwo.getAlcoholPercent(), 0.001);
        }

        @Test
        @DisplayName("Testing total volumes")
        public void calculateTotalVolume() {
            // Phases: Verify(Exercise)
            assertEquals(5.14, cocktailNumberOne.getVolume());
        }

        @Test
        @DisplayName("Testing update liquid name")
        public void updateLiquidName() {
            // Phase: (Individual) setup
            String newName = "Lime juice";
            Liquid numberOne = cocktailNumberOne.getLiquids().get(0);

            // Phase: Exercise
            cocktailNumberOne.updateLiquid(numberOne, (it) -> it.setName(newName));

            // Phase: Verify
            assertEquals(newName, numberOne.getName());
        }

        @Test
        @DisplayName("Testing try to update Liquid name")
        public void updateLiquidNameNotExistent() {
            // Phase: (Individual) setup
            String name = "NotExistent";
            Liquid numberOne = new Liquid(name, 1.0, 0.5);

            // Phase: Exercise
            cocktailNumberOne.updateLiquid(numberOne, (it) -> it.setName("Lime juice"));

            // Phase: Verify
            assertEquals(name, numberOne.getName());
        }

        /*
         * More or less important to test.
         * Normally this is very rarely tested separately.
         */
        @Test
        @DisplayName("Testing toString implementation")
        public void callToString() {
            // Phases: Verify(Exercise)
            assertEquals(
                    "The 'Mai Tai' includes following ingredients\n" +
                            "[Lime juice, Brown rum, Sugar syrup, Almond syrup, Orange liquor, Pineapple syrup] " +
                            "with a total alcohol percentage of 31,88%.",
                    cocktailNumberTwo.toString()
            );
        }
    }

    @Test
    @DisplayName("Testing fails at cocktail creation")
    public void createInvalidEmptyCocktail() {
        // Phases: Verify(Exception specification, Exercise)
        assertThrows(
                ValidationException.class,
                () -> new Cocktail("CheckerCocktail", List.of())
        );
    }

    @Test
    @DisplayName("Testing fails at cocktail creation (failed Liquid creation)")
    public void createInvalidFilledCocktail() {
        // Phases: Verify(Exception specification, Exercise)
        assertThrows(
                ValidationException.class,
                () -> new Cocktail(
                        "CheckerCocktail",
                        List.of(new Liquid("Nothing", 0.0, 0.0))
                )
        );
    }
}
