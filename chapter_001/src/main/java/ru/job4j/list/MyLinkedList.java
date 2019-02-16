package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.2.2019
 */

public class MyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> tail;
    private Node<T> nodes;
    private int modCount;

    /**
     * Method to add input element in the array
     *
     * @param - element
     */
    public void add(T date) {
        if (this.nodes != null) {
            this.tail.next = new Node<>(date);
            this.tail = this.tail.next;
            this.size++;
            this.modCount++;
        } else {
            this.nodes = new Node<>(date);
            this.tail = this.nodes;
            this.size++;
            this.modCount++;
        }

    }

    /**
     * Method return iterator. If structure collection is change then throw an exception
     *
     * @return - iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> cursor = nodes;
            int innerModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.innerModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.cursor != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rst = cursor.date;
                cursor = cursor.next;
                return rst;
            }
        };
    }

    /**
     * Метод получения элемента по индексу.
     */
    public T get(int index) {
        Node<T> result = this.nodes;
        if (index > this.size - 1) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.date;
    }


    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public T delete() {
        Node<T> result = this.nodes;
        T rst = null;
        if (size != 0) {
            for (int i = 0; i < size - 1; i++) {
                if (size == 1) {
                    this.nodes = null;
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

    private static class Node<T> {
        T date;
        Node<T> next;

        Node(T date) {
            this.date = date;
        }
    }
}
