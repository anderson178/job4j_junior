package ru.job4j.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 22.3.2019
 */

public class Hotels {
    private List<Integer> hotels;
    private int starMin = 1;
    private int starMax = 5;

    public Hotels(List<Integer> hotels) {
        this.hotels = hotels;
    }

    /**
     * Метод изначально сортирует времнный список с рейтингами отелей.
     * Даллее записываем в map отели в тосортрованнам виде, но кол-во звезд записываем
     * исходя из положения рейтинга в списке.
     *
     * @return
     */
    public List<Integer> starsCounting() {
        Map<Integer, Integer> map = new HashMap<>(hotels.size());
        List<Integer> hotelsSort = hotels.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < hotelsSort.size(); i++) {
            if (i != 0 && i % (hotelsSort.size() / this.starMax) == 0) {
                this.starMin++;
            }
            map.put(hotelsSort.get(i), this.starMin);
        }
        return this.getStars(map);
    }

    /**
     * Метод вынимает из map кол-во звезд по каждому отелю
     *
     * @param map - коллекция с ассоциацией рейтинг <-> кол-во звезд
     * @return - список с кол-вом звезд по каждому отелю
     */
    private List<Integer> getStars(Map<Integer, Integer> map) {
       return IntStream.range(0, this.hotels.size()).mapToObj(i -> map.get(this.hotels.get(i))).collect(Collectors.toList());
    }

}
