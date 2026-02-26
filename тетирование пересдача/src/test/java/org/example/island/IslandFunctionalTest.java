package org.example.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandFunctionalTest {

    @Test
    void scenario_happyPath_shouldReachExpectedPosition() {
        String input = """
                SIZE 5
                START 2 2
                MOVE R
                MOVE R
                REPORT
                EXIT
                """;

        String out = TestIO.runWithInput(input, () -> Main.main(new String[0]));

        assertTrue(out.contains("OK SIZE 5"));
        assertTrue(out.contains("OK START 2 2"));
        assertTrue(out.contains("OK MOVE 3 2"));
        assertTrue(out.contains("OK MOVE 4 2"));
        assertTrue(out.contains("POS 4 2"));
        assertTrue(out.contains("BYE"));
    }

    @Test
    void scenario_errorsAndBlocked_shouldPrintErrors() {
        String input = """
                START 0 0
                SIZE 2
                START 0 0
                MOVE L
                MOVE U
                REPORT
                EXIT
                """;

        String out = TestIO.runWithInput(input, () -> Main.main(new String[0]));

        assertTrue(out.contains("ERROR"));     // START before SIZE
        assertTrue(out.contains("OK SIZE 2"));
        assertTrue(out.contains("OK START 0 0"));
        assertTrue(out.contains("BLOCKED"));   // border blocks
        assertTrue(out.contains("POS 0 0"));
        assertTrue(out.contains("BYE"));
    }
}
