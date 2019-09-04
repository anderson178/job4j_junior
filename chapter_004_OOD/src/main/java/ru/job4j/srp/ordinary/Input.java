package ru.job4j.srp.ordinary;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public interface Input {
    /**
     * Write input action console line
     *
     * @param question
     * @return - input console line
     */
    String ask(String question);

    /**
     * Write input number from console line
     *
     * @param question
     * @return -input number from console line
     */
    Double askNumber(String question);

    /**
     * Write input action from console line and check on the range validate
     *
     * @param question
     * @param range
     * @return
     */
    int ask(String question, List<Integer> range);
}
