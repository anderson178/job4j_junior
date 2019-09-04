package ru.job4j.srp.ordinary;

import java.util.List;
import java.util.Scanner;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class ConsoleInput implements Input {
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
     * Write input number from console line
     *
     * @param question
     * @return -input number from console line
     */
    public Double askNumber(String question) {
        return Double.valueOf(this.ask(question));
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
