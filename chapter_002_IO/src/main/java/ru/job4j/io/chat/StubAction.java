package ru.job4j.io.chat;


import java.util.List;
import java.util.Random;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.04.2019
 */

public class StubAction extends Action {
    private static final Random RN = new Random();
    private int index = 0;

    /**
     * Метод получения слова из словаря. Берется последовательно. Для прогонки через тесты
     *
     * @param words - список с словами
     * @return - слово из словаря
     */
    @Override
    public String getWord(List<String> words) {
        index = index == words.size() ? 0 : index;
        System.out.println(words.get(index));
        return words.get(index++);
    }
}
