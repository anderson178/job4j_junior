package ru.job4j.list;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 19.02.2019
 */

public class SimpleQueue<T> {
    private SimpleStack<T> stackTemp = new SimpleStack<>();
    private SimpleStack<T> stackResult = new SimpleStack<>();

    public void push(T value) {
        stackTemp.push(value);

    }

    public T poll() {
        stackResult.push(stackTemp.poll());
        return stackResult.poll();
    }

}
