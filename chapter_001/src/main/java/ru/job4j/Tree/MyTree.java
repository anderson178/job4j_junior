package ru.job4j.tree;


import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.03.2019
 */

public class MyTree<T extends Comparable<T>> implements SimpleTree<T> {
    private Node<T> root;
    private int modCount;

    public MyTree(T value) {
        this.root = new Node<>(value);
    }

    /**
     * Method to return iterator for Tree
     *
     * @return - iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor;
            int innerModCount = modCount;
            Queue<Node<T>> data = new LinkedList<>();

            {
                data.offer(root);
            }

            @Override
            public boolean hasNext() {
                boolean rst = false;
                if (this.innerModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!data.isEmpty()) {
                    rst = true;
                }
                return rst;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> el = data.poll();
                T rst = el.getValue();
                for (Node<T> child : el.leaves()) {
                    data.offer(child);
                }
                return rst;
            }
        };
    }

    /**
     * Еhe method checks if there is such an element, if not, before the parent node adds the child
     * @param parent - the parent node
     * @param child - the child node
     * @return - if elemnet to add thee Tree than to return true else false
     */
    @Override
    public boolean add(T parent, T child) {
        boolean rst = false;
        if (parent != null && child != null && !this.findBy(child).isPresent()) {
            Optional<Node<T>> temp = this.findBy(parent);
            if (temp.isPresent()) {
                temp.get().add(new Node<>(child));
                this.modCount++;
                rst = true;
            }
        }
        return rst;
    }

    /**
     * The method to search value all over the tree. The search method is executed in width
     * @param value - the to search value
     * @return - Optional
     */
    @Override
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


}
