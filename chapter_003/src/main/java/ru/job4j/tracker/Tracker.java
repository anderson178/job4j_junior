package ru.job4j.tracker;

import ru.job4j.tracker.sql.ITracker;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 09.01.2019
 */

public class Tracker implements ITracker {
    private ArrayList<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * метод генерации id для заявки
     *
     * @return
     */
    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * добавление новой заявки в трекер
     *
     * @param item - заявка
     * @return
     */
    public Item add(Item item) {
        String create = new Date().toString();
        item.setId(this.generatedId());
        item.setCreate(create);
        items.add(item);
        return item;
    }

    /**
     * выводит список всех заявок в трекере
     *
     * @return
     */
    public ArrayList<Item> getAll() {
        return this.items;
    }

    /**
     * заменяет существущую заявку на другую по id
     *
     * @param id - идентификатор заявки
     * @item - заявка
     */
    public boolean edit(String id, Item item) {
        boolean result = false;
        if (!this.items.isEmpty()) {
            Optional<Integer> index = IntStream.range(0, this.items.size()).filter(i -> this.items.get(i).getId().equals(id)).boxed().findFirst();
            if (index.isPresent()) {
                item.setId(this.items.get(index.get()).getId());
                item.setCreate(this.items.get(index.get()).getCreate());
                this.items.set(index.get(), item);
                result = true;
            }
        }
        return result;
    }

    /**
     * поиск заявки по id
     *
     * @param id - идентификатор заявки
     * @return
     */
    public Item findById(String id) {
        return this.items.stream().filter(value -> value.getId().equals(id)).findFirst().orElse(null);
    }

    private static Predicate<Item> checkName(String keyName) {
        return p -> p.getName().equals(keyName);
    }
    /**
     * метод поиска заявки по имени
     *
     * @param keyName - имя заявки
     * @return
     */
    public List<Item> findByName(String keyName) {
        return new ArrayList<>(this.items.stream().filter(value -> checkName(keyName).test(value)).collect(Collectors.toList()));
    }

    /**
     * метод удаления заявки по id
     *
     * @param id - идентификатор заявки
     * @return
     */
    public boolean remove(String id) {
        boolean res = false;
        Optional<Integer> index = IntStream.range(0, this.items.size()).filter(i -> this.items.get(i).getId().equals(id)).boxed().findFirst();
        if (index.isPresent()) {
            this.items.remove(index.get().intValue());
            res = true;
        }
        return res;
    }
}
