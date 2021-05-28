package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.misc.Fruit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the <code>Smoothie</code> class.
 * <p>
 * Note: Lifecycle.PER_CLASS will be used to omit static declarations.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see Smoothie
 * @since 2.0
 */
@DisplayName("Testing Smoothie class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SmoothieTests {

    /*
     * Constant / field declaration
     */
    private Smoothie smoothie;

    /*
     * Phase: Setup
     */
    @BeforeAll
    public void setup() {
        smoothie =
                new Smoothie(
                        "Milkshake", new Liquid("Test liquid 1", 1.0, 0.0),
                        List.of(new Fruit("test1"), new Fruit("test2")), true);
    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        // Phase: (Individual) setup
        Smoothie smoothieMilk =
                new Smoothie(
                        "Milkshake",
                        new Liquid("milk", 1.0, 4.5),
                        List.of(new Fruit("test1"), new Fruit("test2")), false
                );

        // Phases: Verify(Exercise)
        assertEquals(
                "Here, have a nice Smoothie, it's a mix from milk and test1, test2.\n" +
                        "And guess what, as the base is milk, it's even better than a normal smoothie. It's a milkshake!",
                smoothieMilk.toString()
        );
        assertEquals(
                "Here, have a nice Smoothie, it's a mix from Test liquid 1 and test1, test2. It's even sweetened.",
                smoothie.toString()
        );
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void testGetVolume() {
        // Phases: Verify(Exercise)
        assertEquals(1, smoothie.getVolume());
    }

    /**
     * Tests getAlcoholPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void testGetAlcoholPercent() {
        // Phases: Verify(Exercise)
        assertEquals(0, smoothie.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void testIsAlcoholic() {
        // Phase: (Individual) setup
        Smoothie testSmoothie =
                new Smoothie(
                        "Banana tasty",
                        new Liquid("Milk", 1.0, 1.1),
                        List.of(), true
                );

        // Phases: Verify(Exercise)
        assertFalse(smoothie.isAlcoholic());
        assertTrue(testSmoothie.isAlcoholic());
    }
}

