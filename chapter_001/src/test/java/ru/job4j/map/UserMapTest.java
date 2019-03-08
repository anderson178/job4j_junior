package ru.job4j.map;

import org.junit.Test;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 25.02.2019
 */

public class UserMapTest {
    private UserMap user1 = new UserMap("Denis", 2, new GregorianCalendar(1989, 10, 21));
    private UserMap user2 = new UserMap("Denis", 2, new GregorianCalendar(1989, 10, 21));

    @Test
    public void whenAddShowKeys() {
        Map<UserMap, Object> map = new HashMap<>();
        map.put(this.user1, new Object());
        map.put(this.user2, new Object());
        System.out.println(map.keySet().toString());
    }



}
