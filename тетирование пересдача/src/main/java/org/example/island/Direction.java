package org.example.island;

public enum Direction {
    U(0, -1),
    D(0, 1),
    L(-1, 0),
    R(1, 0);

    public final int dx;
    public final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction fromToken(String token) {
        if (token == null) throw new IllegalArgumentException("Direction token is null");
        return switch (token.trim().toUpperCase()) {
            case "U", "UP" -> U;
            case "D", "DOWN" -> D;
            case "L", "LEFT" -> L;
            case "R", "RIGHT" -> R;
            default -> throw new IllegalArgumentException("Unknown direction: " + token);
        };
    }
}
