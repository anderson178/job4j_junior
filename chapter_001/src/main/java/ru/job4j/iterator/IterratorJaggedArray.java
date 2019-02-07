package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 31.01.2019
 */

public class IterratorJaggedArray implements Iterator<Integer> {
    int[][] array;
    int line = 0, column = 0;

    public IterratorJaggedArray(int[][] array) {
        this.array = array;
    }

    /**
     * Method for changes line and column. Imitation move carriage
     */
    private void moveCarriage() {
        if (column < this.array[line].length - 1) {
            this.column++;
        } else {
            this.line++;
            this.column = 0;
        }
    }

    /**
     * Checks if the next element is
     *
     * @return - true or false
     */
    @Override
    public boolean hasNext() {
        return line < this.array.length && column < this.array[line].length + 1;
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
            Integer rst = this.array[line][column];
            this.moveCarriage();
            return rst;
        } else {
            throw new NoSuchElementException();
        }
    }
}
