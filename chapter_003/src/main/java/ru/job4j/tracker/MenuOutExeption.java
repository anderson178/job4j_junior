package ru.job4j.tracker;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.09.2018
 */
public class MenuOutExeption extends RuntimeException {
    public MenuOutExeption(String msg) {
            super(msg);
        }
}
