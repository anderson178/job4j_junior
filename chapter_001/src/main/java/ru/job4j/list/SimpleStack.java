package ru.job4j.list;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 18.02.2019
 */

public class SimpleStack<T> {

    private MyLinkedList<T> list = new MyLinkedList<>();


    /**
     * Method to add in the list
     *
     * @return
     */
    public void push(T value) {
        list.add(value);
    }

    /**
     * Method to remove elemnt from the list and return this is element
     *
     * @return - element<T>
     */
    public T poll() {
        return list.removeForStack();
    }

    /**
     * Method to return element by index in list
     *
     * @param index - input index
     * @return - element<T>
     */
    public T getElement(int index) {
        return list.get(index);
    }

}
