package org.example.island;

import java.io.*;

public final class TestIO {
    private TestIO() {}

    public static String runWithInput(String input, Runnable app) {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            System.setIn(in);
            System.setOut(new PrintStream(out));
            app.run();
            return out.toString().replace("\r\n", "\n");
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }
}
