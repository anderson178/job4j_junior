package ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.02.2019
 */

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> carriage = it.next();

            {
                skipEmpty();
            }

            private void skipEmpty() {
                if (it.hasNext() && !carriage.hasNext()) {
                    carriage = it.next();
                    skipEmpty();
                }
            }

            @Override
            public boolean hasNext() {
                return it.hasNext() || carriage.hasNext();
            }

            @Override
            public Integer next() {
                skipEmpty();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return carriage.next();
            }
        };
    }
}
