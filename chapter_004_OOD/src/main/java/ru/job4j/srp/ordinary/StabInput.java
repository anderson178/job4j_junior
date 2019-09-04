package ru.job4j.srp.ordinary;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.08.2019
 */
public class StabInput implements Input {
    private List<String> answer;
    private int position = 0;

    public StabInput(List<String> answer) {
        this.answer = answer;
    }

    @Override
    public String ask(String question) {
        return answer.get(position++);
    }

    @Override
    public Double askNumber(String question) {
        return Double.valueOf(answer.get(position++));
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        if (range.stream().filter(value -> value == key).findFirst().isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("out of menu range");
        }
        return key;
    }
}
