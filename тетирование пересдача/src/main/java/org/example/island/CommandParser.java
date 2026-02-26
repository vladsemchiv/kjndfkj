package org.example.island;

import java.util.Locale;

public final class CommandParser {

    public Command parseLine(String line) {
        if (line == null) throw new IllegalArgumentException("Line is null");
        String trimmed = line.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("Empty line");

        String[] parts = trimmed.split("\\s+");
        String head = parts[0].toUpperCase(Locale.ROOT);

        return switch (head) {
            case "SIZE" -> {
                if (parts.length != 2) throw new IllegalArgumentException("SIZE expects 1 аргумент");
                yield new Command.Size(parseInt(parts[1], "size"));
            }
            case "START" -> {
                if (parts.length != 3) throw new IllegalArgumentException("START expects 2 аргумента");
                int x = parseInt(parts[1], "x");
                int y = parseInt(parts[2], "y");
                yield new Command.Start(x, y);
            }
            case "MOVE" -> {
                if (parts.length != 2) throw new IllegalArgumentException("MOVE expects 1 аргумент");
                yield new Command.Move(Direction.fromToken(parts[1]));
            }
            case "REPORT" -> {
                if (parts.length != 1) throw new IllegalArgumentException("REPORT expects 0 аргументов");
                yield new Command.Report();
            }
            case "EXIT" -> {
                if (parts.length != 1) throw new IllegalArgumentException("EXIT expects 0 аргументов");
                yield new Command.Exit();
            }
            default -> throw new IllegalArgumentException("Unknown command: " + parts[0]);
        };
    }

    private static int parseInt(String s, String name) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid int for " + name + ": " + s);
        }
    }
}
