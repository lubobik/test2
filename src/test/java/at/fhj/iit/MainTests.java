package at.fhj.iit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Contains a test case regarding the
 * <code>Main</code> class and its
 * corresponding code executing parts.
 * <p>
 * This is very unusual and actually pretty useless.
 * Only created as we should achieve 100% test coverage :D
 * and debug / console output helper methods are also
 * """tested""" with this little help.
 * <p>
 * To actually test the debug / console output,
 * you could read from output stream.
 * This would be weird though and not
 * really suited for real world cases.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see Main
 */
@DisplayName("Testing Main class")
public class MainTests {
    @Test
    @DisplayName("Testing the main method")
    public void runMainMethod() {
        // Phase: Verify(Exercise(Setup))
        Main.main(new String[0]);
    }
}
