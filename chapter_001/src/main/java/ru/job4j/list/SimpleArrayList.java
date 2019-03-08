package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.02.2019
 */

public class SimpleArrayList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private int modCount;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    /**
     * Method return iterator. If structure collection is change then throw an exception
     *
     * @return - iterator
     */
    @Override
    public java.util.Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> cursor = first;
            int innerModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.innerModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.cursor != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rst = cursor.date;
                cursor = cursor.next;
                return rst;
            }
        };
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
