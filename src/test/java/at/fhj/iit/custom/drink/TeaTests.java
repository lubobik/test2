package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Liquid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the <code>Tea</code> class.
 * <p>
 * Note: Lifecycle.PER_CLASS will be used to omit static declarations.
 *
 * @author Lukas Bobik
 * @author Andreas Steirer
 * @version 3.0
 * @see Tea
 * @since 2.0
 */
@DisplayName("Testing Tea class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TeaTests {

    /*
     * Constant / field declaration
     */
    private Tea tea;

    /*
     * Phase: Setup
     */
    @BeforeEach
    public void setup() {
        tea = new Tea("Test", new Liquid("Test liquid 1", 0.5, 0), true, true);

    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        // Phase: (Individual) setup
        Tea teaMilk = new Tea("Test", new Liquid("Test liquid 2", 0.5, 0), false, true);
        Tea teaSugar = new Tea("Test", new Liquid("Test liquid 3", 0.5, 0), true, false);
        Tea teaBoring = new Tea("Test", new Liquid("Test liquid 4", 0.5, 0), false, false);

        // Phases: Verify(Exercise)
        assertEquals("This tea is from sort Test with sugar and milk", tea.toString());
        assertEquals("This tea is from sort Test with sugar", teaSugar.toString());
        assertEquals("This tea is from sort Test with milk", teaMilk.toString());
        assertEquals("This tea is from sort Test without milk or sugar", teaBoring.toString());
    }

    /**
     * Tests getMilk
     */
    @Test
    @DisplayName("Testing getMilk")
    public void testGetMilk() {
        // Phases: Verify(Exercise)
        assertTrue(tea.getMilk());
    }

    /**
     * Tests getSugar
     */
    @Test
    @DisplayName("Testing getSugar")
    public void testGetSugar() {
        // Phases: Verify(Exercise)
        assertTrue(tea.getSugar());
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void testGetVolume() {
        // Phases: Verify(Exercise)
        assertEquals(0.5, tea.getVolume());
    }

    /**
     * Tests getAlcoholPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void testGetAlcoholPercent() {
        // Phases: Verify(Exercise)
        assertEquals(0, tea.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void testIsAlcoholic() {
        // Phases: Verify(Exercise)
        assertFalse(tea.isAlcoholic());
    }

}

