package org.example.island;

public sealed interface Command permits Command.Size, Command.Start, Command.Move, Command.Report, Command.Exit {

    record Size(int n) implements Command {}
    record Start(int x, int y) implements Command {}
    record Move(Direction direction) implements Command {}
    record Report() implements Command {}
    record Exit() implements Command {}
}
