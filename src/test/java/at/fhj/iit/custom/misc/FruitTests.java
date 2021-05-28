package at.fhj.iit.custom.misc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains test cases for the <code>Fruit</code> class.
 *
 * @author Lukas Bobik
 * @version 2.0
 * @see Fruit
 */
@DisplayName("Testing Fruit class")
public class FruitTests {

    /*
     * Constant / field declaration
     */
    private Fruit fruit;

    /*
     * Phase: Setup
     */
    @BeforeEach
    public void setup() {
        fruit = new Fruit("test");
    }

    /**
     * Tests getName
     */
    @Test
    @DisplayName("Testing getName")
    public void testGetName() {
        // Phases: Verify(Exercise)
        assertEquals("test", fruit.getName());
    }

    /**
     * Tests getName
     */
    @Test
    @DisplayName("Testing setName")
    public void testSetName() {
        // Phase: (Individual) setup
        String test = "test123";

        // Phase: Exercise
        fruit.setName(test);

        // Phase: Verify
        assertEquals(test, fruit.getName());
    }
}
