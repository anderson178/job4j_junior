package ru.job4j.models;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.07.2019
 */


public enum  Months {
    янв(1), фев(2), мар(3), апр(4), май(5), июн(6),
    июл(7), авг(8), сен(9), окт(10), ноя(11), дек(12);
    public int number;

    Months(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
