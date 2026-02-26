package org.example.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void moveRight_increasesX() {
        Position p = new Position(1, 1);
        assertEquals(new Position(2, 1), p.move(Direction.R));
    }

    @Test
    void moveUp_decreasesY() {
        Position p = new Position(1, 1);
        assertEquals(new Position(1, 0), p.move(Direction.U));
    }

    @Test
    void toString_formatsAsTwoInts() {
        assertEquals("3 4", new Position(3, 4).toString());
    }
}
