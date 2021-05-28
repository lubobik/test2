package at.fhj.iit.util;

import at.fhj.iit.custom.cashRegister.CashRegisterManagement;
import at.fhj.iit.custom.cashRegister.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases regarding the
 * <code>CashRegisterRandomizer</code> class and its
 * corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see CashRegisterRandomizer
 */
@DisplayName("Testing CashRegisterRandomizer class")
public class CashRegisterRandomizerTests {

    @Test
    @DisplayName("Testing generation of random cash register")
    public void generateRandomTestCashRegister() {
        // Phase: Setup and Exercise
        CashRegisterManagement cashRegisterManagement =
                CashRegisterRandomizer.generateRandomTestCashRegister();

        // Phase: Verify
        assertFalse(cashRegisterManagement.getSalesHistory().isEmpty());
    }

    @Test
    @DisplayName("Testing retrieval of random static operator")
    public void retrieveRandomOperator() {
        // Phase: Setup and Exercise
        Operator operator =
                CashRegisterRandomizer.retrieveRandomOperator();

        // Phase: Verify
        assertNotNull(operator);
        assertNotEquals("", operator.getFullName());
    }
}
