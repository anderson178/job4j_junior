package ru.job4j.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Integer, Integer> map = new HashMap<>();
        listTwo.forEach(o -> map.put(o, null));
        for (Integer value : listOne) {
            if (!map.containsKey(value)) {
                rst = false;
                break;
            }
        }
        return rst;


    }
}
