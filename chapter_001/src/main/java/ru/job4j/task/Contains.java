package ru.job4j.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 20.03.2019
 */

public class Contains {

    /**
     * Метод проверяет содержатся ли символы одной коллекции в другой
     *
     * @param first  - первая коллекция
     * @param second - вторая коллекция
     * @return - true/false
     */
    public boolean checkContains(List<Integer> first, List<Integer> second) {
        return first.size() == second.size() && checkMap(first, second).size() == 0;
    }

    /**
     * Метод записывает в мапу значения из первой коллекции, затем удаляет из мапы значения из второй коллекции
     *
     * @param first
     * @param second
     * @return
     */
    private Map checkMap(List<Integer> first, List<Integer> second) {
        Map<Integer, Integer> map = new HashMap<>();
        first.forEach(number -> {
            if (map.get(number) != null) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        });
        second.forEach(number -> {
            if (map.get(number) != null && map.get(number) > 1) {
                map.put(number, map.get(number) - 1);
            } else {
                map.remove(number);
            }
        });
        return map;
    }
}
