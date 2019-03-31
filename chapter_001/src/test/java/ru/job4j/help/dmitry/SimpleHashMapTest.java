package ru.job4j.help.dmitry;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.map.UserMap;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleHashMapTest {
    private UserMap user1 = new UserMap("Denis", 2, new GregorianCalendar(1989, 10, 21));
    private UserMap user2 = new UserMap("Nikita", 1, new GregorianCalendar(1987, 9, 71));
    private UserMap user3 = new UserMap("Lev", 10, new GregorianCalendar(1289, 11, 5));
    private UserMap user4 = new UserMap("Ivan", 4, new GregorianCalendar(1940, 3, 1));
    private UserMap user5 = new UserMap("Seniy", 1, new GregorianCalendar(1956, 2, 6));
    private UserMap user6 = new UserMap("Sasha121212", 1, new GregorianCalendar(1911, 10, 11));
    SimpleHashMap<UserMap, String> map;

    @Before
    public void setUp() {
        map = new SimpleHashMap<>();
        map.insert(user1, "One");
        map.insert(user2, "Two");
        map.insert(user3, "Three");
        map.insert(user4, "Four");
        map.insert(user5, "Five");
    }


}
