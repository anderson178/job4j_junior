package ru.job4j.set;

import java.util.HashSet;
import java.util.Set;

public class Difference {
    /**
     * Метод проверяет разницу структур, разницу записывает в новую структуру
     *
     * @param set1 -  первая структура
     * @param set2 - вторая структура
     * @param <T>  - тип данных
     * @return - структура содержащая разницу двух входящих структур
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        boolean check = false;
        Set<T> rst = new HashSet<T>();

        for (T object : set1) {
            if (!set2.contains(object)) {
                rst.add(object);
            }
        }
        for (T object : set2) {
            if (!set1.contains(object)) {
                rst.add(object);
            }
        }

        return rst;
    }

}
