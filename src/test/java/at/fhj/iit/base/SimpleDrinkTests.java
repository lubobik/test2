package at.fhj.iit.base;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the <code>SimpleDrink</code> class.
 * <p>
 * Note: Lifecycle.PER_CLASS will be used to omit static declarations.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see SimpleDrink
 * @since 2.0
 */
@DisplayName("Testing SimpleDrink class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleDrinkTests {

    /*
     * Constant / field declaration
     */
    private SimpleDrink drink;

    /*
     * Phase: Setup
     */
    @BeforeAll
    public void setup() {
        drink = new SimpleDrink("TestDrink 1", new Liquid("Alcoholic water", 1.0, 0.1));
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void getVolume() {
        // Phases: Verify(Exercise)
        assertEquals(1, drink.getVolume());
    }

    /**
     * Tests getAlcoholicPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void getAlcoholPercent() {
        // Phases: Verify(Exercise)
        assertEquals(0.1, drink.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void isAlcoholic() {
        // Phase: (Individual) setup
        SimpleDrink nonAlcoholic =
                new SimpleDrink("TestDrink 2", new Liquid("Water", 1.0, 0.0));

        // Phases: Verify(Exercise)
        assertTrue(drink.isAlcoholic());
        assertFalse(nonAlcoholic.isAlcoholic());
    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        // Phases: Verify(Exercise)
        assertEquals("Simple Drink called TestDrink 1 with 0.1 percent alcohol by volume", drink.toString());
    }
}