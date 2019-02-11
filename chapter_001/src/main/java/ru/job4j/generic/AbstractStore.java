package ru.job4j.generic;

import java.util.NoSuchElementException;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.02.2019
 */

public abstract class AbstractStore<T extends Base> implements Store<T> {
    final private int size;
    final private SimpleArray<T> array;

    public AbstractStore(int size) {
        this.size = size;
        this.array = new SimpleArray<>(size);
    }

    @Override
    public void add(T element) throws ArrayIndexOutOfBoundsException {
        array.add(element);
    }

    @Override
    public boolean replace(String id, T element) {
        boolean rst = false;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i).getId().equals(id)) {
                array.set(i, element);
                break;
            }
        }
        return rst;
    }

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.get(i).getId().equals(id)) {
                array.remove(i);
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public T findByID(String id) {
        T rst = null;
        for (T role : array) {
            if (role.getId().equals(id)) {
                rst = role;
                break;
            }
        }
        return rst;
    }

    @Override
    public T findByIndex(int index) {
        return this.array.get(index);
    }

    @Override
    public int fillSize() {
        return this.array.getFillLength();
    }
}
