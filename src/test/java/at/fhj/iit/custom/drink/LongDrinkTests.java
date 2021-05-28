package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Liquid;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the <code>LongDrink</code> class.
 * <p>
 * Note: Lifecycle.PER_CLASS will be used to omit static declarations.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see LongDrink
 * @since 2.0
 */
@DisplayName("Testing LongDrink class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LongDrinkTests {

    /*
     * Constant / field declaration
     */
    private LongDrink longDrink;

    /*
     * Phase: Setup
     */
    @BeforeAll
    public void setup() {
        longDrink = new LongDrink(
                "Test drink 1",
                new Liquid("Test liquid 1", 0.5, 20.0),
                new Liquid("Test juice 1", 0.3, 0.0)
        );
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void getVolume() {
        // Phases: Verify(Exercise)
        assertEquals(0.8, longDrink.getVolume());
    }

    /**
     * Tests getAlcoholicPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void getAlcoholPercent() {
        // Phases: Verify(Exercise)
        assertEquals(12.5, longDrink.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void isAlcoholic() {
        // Phase: (Individual) setup
        LongDrink testDrink = new LongDrink(
                "Test drink 2",
                new Liquid("Test liquid 2", 0.5, 0.0),
                new Liquid("Test liquid 2", 0.3, 0.0)
        );

        // Phases: Verify(Exercise)
        assertTrue(longDrink.isAlcoholic());
        assertFalse(testDrink.isAlcoholic());
    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        // Phases: Verify(Exercise)
        assertEquals(
                "Test drink 1 like the name suggests is " +
                        "Test liquid 1 and Test juice 1 with an alcohol percentage of 12.5%.",
                longDrink.toString()
        );
    }
}