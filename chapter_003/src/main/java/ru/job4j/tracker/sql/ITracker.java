package ru.job4j.tracker.sql;


import ru.job4j.tracker.Item;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 15.05.2019
 */

public interface ITracker {
    Item add(Item item);
    boolean edit(String id, Item item);
    boolean remove(String id);
    List<Item> getAll();
    List<Item> findByName(String key);
    Item findById(String id);
}
