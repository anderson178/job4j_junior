package ru.job4j.task;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 20.03.2019
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
        Set<Integer> setOne = new HashSet<>(listOne);
        Set<Integer> setTwo = new HashSet<>(listTwo);
        for (Integer value : setOne) {
            if (!setTwo.contains(value)) {
                rst = false;
                break;
            }
        }
        return rst;


    }
}
