package ru.job4j.io.socket;


import java.util.Collections;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 17.04.2019
 */

public class StubOutput implements Output {
    private List<String> text;
    private int position = 0;

    public StubOutput(List<String> text) {
        this.text = text;
    }

    /**
     * Метод возвращает список с одним элементом который берется поочередно (для тестов)
     *
     * @return - список с одним элементом
     */
    @Override
    public List<String> answer() {
        if (this.position == this.text.size()) {
            this.position = 0;
        }
        return Collections.singletonList(this.text.get(position++));
    }
}
