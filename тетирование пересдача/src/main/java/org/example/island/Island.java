package org.example.island;

public final class Island {
    private final int size;

    public Island(int size) {
        if (size < 1) throw new IllegalArgumentException("Size must be >= 1");
        this.size = size;
    }

    public int size() { return size; }

    public boolean isInside(Position p) {
        if (p == null) return false;
        return p.x() >= 0 && p.y() >= 0 && p.x() < size && p.y() < size;
    }
}
