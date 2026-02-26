package org.example.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    private final CommandParser parser = new CommandParser();

    @Test
    void parse_size_ok_equivalenceClass() {
        Command cmd = parser.parseLine("SIZE 5");
        assertEquals(new Command.Size(5), cmd);
    }

    @Test
    void parse_start_ok() {
        Command cmd = parser.parseLine("START 1 2");
        assertEquals(new Command.Start(1, 2), cmd);
    }

    @Test
    void parse_move_acceptsLowercaseAndAliases() {
        assertEquals(new Command.Move(Direction.U), parser.parseLine("move up"));
    }

    @Test
    void parse_rejectsUnknownCommand_negative() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseLine("JUMP 1"));
    }

    @Test
    void parse_rejectsEmptyLine_negative() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseLine("   "));
    }
}
