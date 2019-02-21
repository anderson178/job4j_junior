package ru.job4j.list;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 19.02.2019
 */

public class SimpleQueue<T> {
    private SimpleStack<T> stackTemp = new SimpleStack<>();
    private SimpleStack<T> stackResult = new SimpleStack<>();


    /**
     * Метод добавляет в первый (temp) стек если второй стек пустой. Иначе если второй стек полный, то сперва
     * из второго стека переносятся данные в первый и только потом добавляется новый элемент в перввый стек
     *
     * @param value - input element
     */
    public void push(T value) {
        if (stackResult.size() == 0) {
            stackTemp.push(value);
        } else {
            int size = stackResult.size();
            for (int i = 0; i < size; i++) {
                stackTemp.push(stackResult.poll());
            }
            stackTemp.push(value);
        }


    }

    /**
     * Method return and remove first elemnt from the second stack
     *
     * @return
     */
    public T poll() {
        int size = stackTemp.size();
        for (int i = 0; i < size; i++) {
            stackResult.push(stackTemp.poll());
        }
        return stackResult.poll();
    }

}
