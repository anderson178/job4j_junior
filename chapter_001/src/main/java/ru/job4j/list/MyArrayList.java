package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.02.2019
 */

public class MyArrayList<T> implements Iterable<T> {
    private int size;
    private int fillPosition = 0;
    private Object[] objects;
    private int modCount;

    public MyArrayList() {
        this.size = 5;
        objects = new Object[size];
    }

    public MyArrayList(int size) {
        this.size = size;
        objects = new Object[size];
    }

    /**
     * Method return iterator. If structure collection is change then throw an exception
     *
     * @return - iterator
     */
    @Override
    public Iterator<T> iterator() throws ConcurrentModificationException, NoSuchElementException {
        return new Iterator<T>() {
            int cursor;
            int innerModCount = modCount;

            @Override
            public boolean hasNext() {
                if (this.innerModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return this.cursor < fillPosition;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rst = (T) objects[cursor];
                this.cursor++;
                return rst;
            }
        };
    }

    /**
     * Mwthod return the quantity elements in array
     *
     * @return - quantity elements
     */
    public int length() {
        return this.fillPosition;
    }

    /**
     * Method increase size array
     */
    private void increaseSizeArray() {
        Object[] array = new Object[(this.size * 3) / 2 + 1];
        System.arraycopy(objects, 0, array, 0, this.fillPosition);
        this.size = array.length;
        this.objects = array;
    }

    /**
     * Method to add input element in the array
     *
     * @param - element
     */
    public void add(T element) {
        if (this.fillPosition == size) {
            this.increaseSizeArray();
        }
        this.objects[fillPosition] = element;
        fillPosition++;
        this.modCount++;
    }

    /**
     * Methos get element of index from this array
     *
     * @param index - input indes
     * @return - element
     * @throws ArrayIndexOutOfBoundsException
     */
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index > fillPosition) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.objects[index];
    }
}
