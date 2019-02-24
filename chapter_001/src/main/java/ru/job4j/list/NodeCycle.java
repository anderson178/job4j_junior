package ru.job4j.list;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.02.2019
 */

public class NodeCycle<T> {
    private Node<T> first;
    private Node<T> second;

    public NodeCycle(Node<T> node) {
        this.first = node;
        this.second = node;
    }

    boolean hasCycle() {
        boolean rst = false;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (first == second) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }
}
