package ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 04.02.2019
 */

public class IteratorEventNumbers implements Iterator<Integer> {
    int[] array;
    int column = 0;

    public IteratorEventNumbers(int[] array) {
        this.array = array;
    }

    /**
     * Method for changes line and column. Imitation move carriage
     */
    private void moveCarriage() {
        for (int i = this.column; i < this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                this.column = i;
                break;
            }
        }
    }

    /**
     * Checks if the next element is
     *
     * @return - true or false
     */
    @Override
    public boolean hasNext() {
        boolean rst = false;
        for (int i = this.column; i < this.array.length; i++) {
            if (this.array[i] % 2 == 0) {
                rst = true;
                break;
            }
        }
        return rst;
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
            this.moveCarriage();
            int rst = this.array[column];
            this.column++;
            return rst;

        } else {
            throw new NoSuchElementException();
        }

    }
}
