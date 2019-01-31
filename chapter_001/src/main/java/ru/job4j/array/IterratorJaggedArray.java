package ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 31.01.2019
 */

public class IterratorJaggedArray implements Iterator<Integer> {
    int[][] array;
    int carriage = 0;
    int countElements = 0;

    public IterratorJaggedArray(int[][] array) {
        this.array = array;
        counts();
    }

    /**
     * Сounting the number of elements in the entire array
     */
    private void counts() {
        for (int[] mas : this.array) {
            countElements += mas.length;
        }
    }

    /**
     * Method for getting an element from an array
     *
     * @return - element an array
     */
    private Integer getElemnt() {
        Integer rst = null;
        int count = 0;
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array[i].length; j++) {
                if (count == carriage) {
                    return this.array[i][j];
                } else {
                    count++;
                }
            }
        }
        return rst;
    }

    /**
     * Checks if the next element is
     *
     * @return - true or false
     */
    @Override
    public boolean hasNext() {
        return carriage < this.countElements;
    }

    /**
     * takes the next element
     *
     * @return - element
     * @throws NoSuchElementException - if no such element
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            Integer rst = this.getElemnt();
            carriage++;
            return rst;
        } else {
            throw new NoSuchElementException();
        }
    }
}
