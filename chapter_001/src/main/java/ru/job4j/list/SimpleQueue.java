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
        stackTemp.push(value);
    }

    /**
     * Method to transfers items from one stack to another
     *
     * @param first  - first stack
     * @param second - secont stack
     * @param size   - size second stack
     */
    private void revers(SimpleStack<T> first, SimpleStack<T> second, int size) {
        for (int i = 0; i < size; i++) {
            first.push(second.poll());
        }
    }

     /**
     * Method return and remove first elemnt from the second stack
     *
     * @return
     */
    public T poll() {
        if (stackResult.size() == 0) {
            this.revers(stackResult, stackTemp, stackTemp.size());
        }
        return stackResult.poll();
    }

}
