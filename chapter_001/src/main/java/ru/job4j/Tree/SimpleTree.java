package ru.job4j.tree;

import java.util.Optional;

public interface SimpleTree<T extends Comparable<T>> extends Iterable<T> {
    boolean add(T parent, T child);

    Optional<Node<T>> findBy(T value);
}
