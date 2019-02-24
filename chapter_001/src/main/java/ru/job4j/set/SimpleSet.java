package ru.job4j.set;

import ru.job4j.list.MyLinkedList;

import java.util.Iterator;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.02.2019
 */
public class SimpleSet<T> implements Iterable<T> {
    private MyLinkedList<T> array = new MyLinkedList<>();

    /**
     * Method to add in array if input element not exist in the array
     *
     * @param value - input element
     * @return - true if the element to add alse false
     */
    public boolean add(T value) {
        boolean rst = true;
        for (T temp : array) {
            if (temp.equals(value)) {
                rst = false;
                break;
            }
        }
        if (rst) {
            array.add(value);
        }
        return rst;
    }

    /**
     * Method return iterator. If structure collection is change then throw an exception
     *
     * @return - iterator
     */
    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}
