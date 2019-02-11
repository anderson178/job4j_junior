package ru.job4j.generic;

import java.util.Random;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.02.2019
 */

public abstract class Base {
    private static final Random RN = new Random();
    private final String id;

    protected Base() {
        this.id = String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public String getId() {
        return id;
    }
}
