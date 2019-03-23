package ru.job4j.task;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 20.3.2019
 */

public class Contains {

    /**
     * Метод проверяет содержатся ли символы одной коллекции в другой
     *
     * @param listOne - первая коллекция
     * @param listTwo - вторая коллекция
     * @return - true/false
     */
    public boolean checkContains(List<Integer> listOne, List<Integer> listTwo) {
        boolean rst = true;
        Set<Integer> set = new HashSet<>(listOne);
        Map<Integer, Integer> map = new HashMap<>();
        listTwo.forEach(o -> map.put(o, null));
        for (Integer value : set) {
            if (!map.containsKey(value)) {
                rst = false;
                break;
            }
        }
        return rst;


    }
}
