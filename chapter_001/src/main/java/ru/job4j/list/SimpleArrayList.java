package ru.job4j.list;

import java.util.LinkedList;

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

    private Node<E> lastElement(Node<E> node, int index) {
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        return node;
    }


    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        Node<E> result = this.first;
        E rst = this.get(size - 1);
        this.first = null;
        int sizeIn = this.size - 1;
        this.size = 0;
        for (int i = sizeIn; i > 0; i--) {
            Node<E> temp = lastElement(result, i);
            this.add(temp.date);
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
