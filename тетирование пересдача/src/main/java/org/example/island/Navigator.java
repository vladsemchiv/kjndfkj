package org.example.island;

import java.util.Objects;

public final class Navigator {
    private final Island island;
    private Position position;
    private boolean started = false;

    public Navigator(Island island) {
        this.island = Objects.requireNonNull(island, "island");
    }

    public boolean isStarted() {
        return started;
    }

    public Position getPosition() {
        if (!started) throw new IllegalStateException("Not started");
        return position;
    }

    public void start(int x, int y) {
        Position p = new Position(x, y);
        if (!island.isInside(p)) throw new IllegalArgumentException("Start position out of bounds: " + p);
        this.position = p;
        this.started = true;
    }

    public boolean move(Direction d) {
        if (!started) throw new IllegalStateException("Not started");
        Objects.requireNonNull(d, "direction");
        Position next = position.move(d);
        if (!island.isInside(next)) return false; // blocked by border
        this.position = next;
        return true;
    }
}
