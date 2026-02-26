package org.example.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NavigatorTest {

    @Test
    void start_setsPosition_whenInside() {
        Navigator nav = new Navigator(new Island(5));
        nav.start(2, 2);
        assertEquals(new Position(2, 2), nav.getPosition());
    }

    @Test
    void start_rejectsOutOfBounds_boundary() {
        Navigator nav = new Navigator(new Island(2));
        assertThrows(IllegalArgumentException.class, () -> nav.start(2, 0));
    }

    @Test
    void move_rejectsBeforeStart_negative() {
        Navigator nav = new Navigator(new Island(2));
        assertThrows(IllegalStateException.class, () -> nav.move(Direction.R));
    }

    @Test
    void move_returnsFalse_whenHitsBorder() {
        Navigator nav = new Navigator(new Island(2));
        nav.start(0, 0);
        assertFalse(nav.move(Direction.L));
        assertEquals(new Position(0, 0), nav.getPosition());
    }

    @Test
    void move_updatesPosition_whenInside() {
        Navigator nav = new Navigator(new Island(3));
        nav.start(1, 1);
        assertTrue(nav.move(Direction.R));
        assertEquals(new Position(2, 1), nav.getPosition());
    }
}
