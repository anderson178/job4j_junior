package ru.job4j.lsp.input;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements InputInterface {
    private Scanner scaner = new Scanner(System.in);

    /**
     * Write input action console line
     *
     * @param question
     * @return - input console line
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scaner.nextLine();
    }

    /**
     * Write input action from console line and check on the range validate
     *
     * @param question
     * @param range
     * @return
     */
    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean result = false;
        for (int value : range) {
            if (value == key) {
                result = true;
                break;
            }
        }
        if (!result) {
            throw new ArrayIndexOutOfBoundsException("out of menu range");

        } else {
            return key;
        }
    }
}
