package ru.job4j.generic;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.02.2019
 */

public interface Store<T extends Base> {
    void add(T element);
    boolean replace(String id, T element);
    boolean delete(String id);
    T findByID(String id);
    T findByIndex(int index);
    int fillSize();
}
