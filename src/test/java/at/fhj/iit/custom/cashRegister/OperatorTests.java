package at.fhj.iit.custom.cashRegister;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Contains test cases regarding the
 * <code>Operator</code>
 * class and its corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see Operator
 */
@DisplayName("Testing Operator class")
public class OperatorTests {

    /*
     * Normally this is very rarely tested separately.
     * Typically, only when there are
     * more complex operations happening in there.
     * Testing value assigning of non-complex ctors is useless /
     * more or less not important.
     *
     * We also test a custom get method,
     * that makes it a little bit more useful,
     * but not really in an astonishing way.
     */
    @Test
    @DisplayName("Testing init and retrieval of full name")
    public void initAndCheckOperatorName() {
        // Phase: Setup
        Operator operator = new Operator("Jon", "Doe");

        // Phases: Verify(Exercise)
        assertNotNull(operator);
        assertEquals("Jon Doe", operator.getFullName());
    }
}
