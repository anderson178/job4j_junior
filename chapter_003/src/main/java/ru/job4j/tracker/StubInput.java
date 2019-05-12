package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.10.2018
 */

public class StubInput implements Input {
    private List<String> answer = new ArrayList<>();
    private int position = 0;

    public StubInput(ArrayList<String> answer) {
        this.answer = answer;
    }
    @Override
    public String ask(String questions, Consumer<String> show) {
        return answer.get(position++);
    }

    @Override
    /**
     * метод валидации введенных данных при выборе меню
     *
     * @param question - вопрос
     * @param range    - набор чисел меню
     * @return - ключ иначе сообщение об ошибке
     */
    public int ask(String question, Consumer<String> show, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question, System.out::println));
        boolean result = false;
        for (int value : range) {
            if (value == key) {
                result = true;
                break;
            }
        }
        if (!result) {
            throw new MenuOutExeption("out of menu range");
        } else {
            return key;
        }
    }

}
