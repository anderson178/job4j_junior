package ru.job4j.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 22.03.2019
 */

public class Hotels {
    private int countHotels;
    private List<Integer> listHotels;
    private int starMin = 1;
    private int starMax = 5;

    public Hotels(int countHotels, List<Integer> listHotels) {
        this.countHotels = countHotels;
        this.listHotels = listHotels;
    }

    /**
     * Метод изначально сортирует времнный список с рейтингами отелей.
     * Даллее записываем в map отели в тосортрованнам виде, но кол-во звезд записываем
     * исходя из положения рейтинга в списке.
     *
     * @return
     */
    public List<Integer> starsCounting() {
        Map<Integer, Integer> map = new HashMap<>(listHotels.size());
        List<Integer> listHotelsTemp = listHotels.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < listHotelsTemp.size(); i++) {
            if (i != 0 && i % (listHotelsTemp.size() / starMax) == 0) {
                this.starMin++;
            }
            map.put(listHotelsTemp.get(i), this.starMin);
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
        List<Integer> rst = new ArrayList<>(this.listHotels.size());
        for (int i = 0; i < this.listHotels.size(); i++) {
            rst.add(map.get(this.listHotels.get(i)));
        }
        return rst;
    }

}
