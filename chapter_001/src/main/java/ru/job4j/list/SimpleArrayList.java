package ru.job4j.list;


/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.02.2019
 */

public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        Node<E> result = this.first;
        E rst = null;
        if (size != 0) {
            for (int i = 0; i < size - 1; i++) {
                if (size == 1) {
                    this.first = null;
                }
                if (result.next.next == null) {
                    rst = result.next.date;
                    result.next = null;
                    break;
                } else {
                    result = result.next;
                }
            }
            this.size--;
        }
        return rst;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
