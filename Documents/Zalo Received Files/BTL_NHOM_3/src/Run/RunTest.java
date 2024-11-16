package Run;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RunTest {

    @Test
    void testMain() {
        // This test will check if the main method runs without throwing any exceptions.
        assertDoesNotThrow(() -> Run.main(new String[] {}));
    }
}