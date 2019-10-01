package ru.job4j.lsp.input;

import java.util.List;

public class StabInput implements InputInterface {
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
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        if (range.stream().filter(value -> value == key).findFirst().isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("out of menu range");
        }
        return key;
    }
}
