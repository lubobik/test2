package at.fhj.iit.custom.misc;

import at.fhj.iit.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Contains test cases regarding the
 * <code>SoftLiquid</code> class and its implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see SoftLiquid
 */
@DisplayName("Testing SoftLiquid class")
public class SoftLiquidTests {

    /*
     * Constant / field declaration
     */
    private SoftLiquid softLiquid;

    /*
     * Phase: Setup
     */
    @BeforeEach
    public void setup() {
        softLiquid = new SoftLiquid("TestDrink", 12.45, Brand.NESQUIK);
    }

    /*
     * Normally this is not tested separately.
     * Testing value assigning with non-complex setters is useless /
     * more or less not important.
     */
    @Test
    @DisplayName("Testing change of name")
    public void changeName() {
        // Phases: Exercise
        String newName = "NewTestDrink";
        softLiquid.setName(newName);

        // Phases: Verify
        assertEquals(newName, softLiquid.getName());
    }

    /*
     * Normally this is not tested separately.
     * Testing value assigning with non-complex setters is useless /
     * more or less not important.
     */
    @Test
    @DisplayName("Testing change of volume")
    public void changeVolume() {
        // Phases: Exercise
        double newVolume = 10.0;
        softLiquid.setVolume(newVolume);

        // Phases: Verify
        assertEquals(newVolume, softLiquid.getVolume());
    }

    /*
     * Normally this is not tested separately.
     * Testing value assigning with non-complex setters is useless /
     * more or less not important.
     */
    @Test
    @DisplayName("Testing change of Brand")
    public void changeBrand() {
        // Phases: Exercise
        Brand newBrand = Brand.LA_CROIX;
        softLiquid.setBrand(newBrand);

        // Phases: Verify
        assertEquals(newBrand, softLiquid.getBrand());
    }

    @Test
    @DisplayName("Testing fails at SoftLiquid creation")
    public void createInvalidSoftLiquid() {
        // Phases: Verify(Exception specification, Exercise)
        assertThrows(
                ValidationException.class,
                () -> new SoftLiquid("CheckerDrink", 0.0, Brand.OTHER)
        );
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
                "The SoftLiquid 'TestDrink' is manufactured by 'Nesquik' " +
                        "and got a standard volume of 12.45 liters.",
                softLiquid.toString()
        );
    }
}
