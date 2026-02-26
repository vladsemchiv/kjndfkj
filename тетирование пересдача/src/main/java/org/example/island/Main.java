package org.example.island;

import java.io.IOException;

public final class Main {
    public static void main(String[] args) {
        try {
            new App().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
