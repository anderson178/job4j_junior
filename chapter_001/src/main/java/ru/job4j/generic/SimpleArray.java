package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.02.2019
 */

public class SimpleArray<T> implements Iterable<T> {

    private int position = 0;
    private Object[] objects;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Method generation iterator
     *
     * @return - iterator
     * @throws NoSuchElementException - when no more edements
     */
    @Override
    public Iterator<T> iterator() throws NoSuchElementException {
        return new Iterator<T>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[cursor++];
            }
        };
    }

    /**
     * Method check the index in rnage array
     *
     * @param index - input index
     * @throws ArrayIndexOutOfBoundsException - if wayout range the array
     */
    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (this.position < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Method add element in array
     *
     * @param element - inpunt element
     * @throws ArrayIndexOutOfBoundsException - if wayout range the array
     */
    public void add(T element) throws ArrayIndexOutOfBoundsException {
        if (this.objects.length < this.position) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[position++] = element;
    }

    /**
     * Methos insert element in array
     *
     * @param index  - input index
     * @param object - input element
     */
    public void set(int index, T object) {
        this.checkIndex(index);
        this.objects[index] = object;
    }

    /**
     * Methos remove element from array
     *
     * @param index - input index
     */
    public void remove(int index) {
        this.checkIndex(index);
        System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - index - 1);
        this.objects[this.objects.length - 1] = null;
        this.position--;
    }

    /**
     * Method take element from array
     *
     * @param index - input index
     * @return - get element
     */
    public T get(int index) {
        this.checkIndex(index);
        return (T) this.objects[index];
    }

    /**
     * get length array
     *
     * @return - length array
     */
    public int getLength() {
        return this.objects.length;
    }

    public int getFillLength() {
        return this.position;
    }
}
