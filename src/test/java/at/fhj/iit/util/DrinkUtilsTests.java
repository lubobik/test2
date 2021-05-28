package at.fhj.iit.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains test cases regarding the
 * <code>DrinkUtils</code> class and its
 * corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see DrinkUtils
 */
@DisplayName("Testing DrinkUtils class")
public class DrinkUtilsTests {
    @Test
    @DisplayName("Testing rounding to utility method")
    public void roundToTwoDecimals() {
        // Phase: Verify(Exercise)
        assertEquals(12.01, DrinkUtils.roundToTwoDecimals(12.01234));
    }
}
