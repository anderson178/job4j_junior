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
        stackResult.push(stackTemp.poll());
    }

    public T poll() {
        return stackResult.pollForQueue();
    }

    public T getElement(int index) {
        return this.stackResult.getElement(index);
    }
}
