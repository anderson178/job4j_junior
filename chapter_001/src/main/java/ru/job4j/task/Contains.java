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
        ArrayList<Integer> tt = new ArrayList<>();
        return first.size() == second.size()
                && this.compareList(first.stream().sorted().collect(Collectors.toList()),
                        second.stream().sorted().collect(Collectors.toList())).isEmpty();

    }

    /**
     * Метод сранивает два списка по-индексно. Если элементы будут равны друг другу то вернет пустой OptionalInt
     * иначе с первым
     *
     * @param firstSort  - первый отсортированный список
     * @param secondSort - второй отсортированный список
     * @return - OptionalInt
     */
    private OptionalInt compareList(List<Integer> firstSort, List<Integer> secondSort) {
        return IntStream.range(0, firstSort.size()).filter(i -> !firstSort.get(i).equals(secondSort.get(i))).findFirst();
    }
}
