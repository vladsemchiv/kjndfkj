package org.example.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    void ctor_rejectsSizeZero_boundary() {
        assertThrows(IllegalArgumentException.class, () -> new Island(0));
    }

    @Test
    void isInside_acceptsCorners_boundaryValues() {
        Island island = new Island(3);
        assertTrue(island.isInside(new Position(0, 0)));
        assertTrue(island.isInside(new Position(2, 2)));
    }

    @Test
    void isInside_rejectsOutside_negativeAndOverflow() {
        Island island = new Island(3);
        assertFalse(island.isInside(new Position(-1, 0)));
        assertFalse(island.isInside(new Position(0, -1)));
        assertFalse(island.isInside(new Position(3, 0)));
        assertFalse(island.isInside(new Position(0, 3)));
    }
}
