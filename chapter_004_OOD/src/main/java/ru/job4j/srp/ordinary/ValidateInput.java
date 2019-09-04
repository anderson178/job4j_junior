package ru.job4j.srp.ordinary;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Write input action console line
     *
     * @param question
     * @return - input console line
     */
    @Override
    public String ask(String question) {
        return null;
    }

    /**
     * Write input number from console line
     *
     * @param question
     * @return -input number from console line
     */
    @Override
    public Double askNumber(String question) {
        return 0.0;
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
        boolean invalide = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalide = false;
            } catch (ArrayIndexOutOfBoundsException indexOfEx) {
                System.out.println("Enter number menu  of range");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        }
        while (invalide);
        return value;
    }
}
