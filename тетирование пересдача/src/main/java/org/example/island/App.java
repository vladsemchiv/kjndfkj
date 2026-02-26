package org.example.island;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class App {
    private final CommandParser parser = new CommandParser();

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Island island = null;
        Navigator nav = null;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            if (line.trim().isEmpty()) continue;

            try {
                Command cmd = parser.parseLine(line);

                if (cmd instanceof Command.Size s) {
                    island = new Island(s.n());
                    nav = new Navigator(island);
                    System.out.println("OK SIZE " + island.size());
                } else if (cmd instanceof Command.Start st) {
                    require(nav, "SIZE must be set before START");
                    nav.start(st.x(), st.y());
                    System.out.println("OK START " + nav.getPosition());
                } else if (cmd instanceof Command.Move m) {
                    require(nav, "SIZE must be set before MOVE");
                    boolean moved = nav.move(m.direction());
                    System.out.println(moved ? "OK MOVE " + nav.getPosition() : "BLOCKED");
                } else if (cmd instanceof Command.Report) {
                    require(nav, "SIZE must be set before REPORT");
                    if (!nav.isStarted()) {
                        System.out.println("NOT_STARTED");
                    } else {
                        System.out.println("POS " + nav.getPosition());
                    }
                } else if (cmd instanceof Command.Exit) {
                    System.out.println("BYE");
                    break;
                }
            } catch (RuntimeException ex) {
                System.out.println("ERROR " + ex.getMessage());
            }
        }
    }

    private static void require(Object obj, String msg) {
        if (obj == null) throw new IllegalStateException(msg);
    }
}
