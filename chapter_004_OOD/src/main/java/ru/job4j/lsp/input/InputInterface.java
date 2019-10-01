package ru.job4j.lsp.input;

import java.util.List;

public interface InputInterface {
    /**
     * Write input action console line
     *
     * @param question
     * @return - input console line
     */
    String ask(String question);

    /**
     * Write input action from console line and check on the range validate
     *
     * @param question
     * @param range
     * @return
     */
    int ask(String question, List<Integer> range);
}
