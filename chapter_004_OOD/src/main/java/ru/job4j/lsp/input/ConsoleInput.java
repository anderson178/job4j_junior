package ru.job4j.lsp.input;

import java.util.List;

public class ConsoleInput implements InputInterface {
    @Override
    public String ask(String question) {
        return null;
    }

    @Override
    public int ask(String question, List<Integer> range) {
        return 0;
    }
}
