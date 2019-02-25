package ru.job4j.map;

import java.util.Calendar;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 25.02.2019
 */

public class UserMap {

    private String name;
    private int children;
    private Calendar birthday;

    public UserMap(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserMap{" + "name='"
                + name + '\'' + ", " + "children="
                + children + ", birthday="
                + birthday.get(Calendar.YEAR) + "."
                + birthday.get(Calendar.MONTH) + "."
                + birthday.get(Calendar.DAY_OF_MONTH)
                + '}';
    }
}
