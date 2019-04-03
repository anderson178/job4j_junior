package ru.job4j.io.chat;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.04.2019
 */

public class StubInput implements Input {
    private List<String> answer;
    private int position = 0;

    public StubInput(List<String> answer) {
        this.answer = answer;
    }

    /**
     * Метод последовательно отдает элементв(слово) из списка. Для прогонки через тесты
     *
     * @return - строка
     */
    @Override
    public String ask() {
        System.out.println(answer.get(position));
        return answer.get(position++);
    }
}
