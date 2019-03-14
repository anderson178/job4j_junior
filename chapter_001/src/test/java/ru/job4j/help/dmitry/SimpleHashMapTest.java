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
        List<Integer> list = new LinkedList<>();

        //list.o
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        Integer p = list.lastIndexOf(1);
        //Integer p = list.set(0,2);


        map = new SimpleHashMap<>();
        map.insert(user1, "One");
        map.insert(user2, "Two");
        map.insert(user3, "Three");
        map.insert(user4, "Four");
        map.insert(user5, "Five");
    }

    @Test
    public void whenInsertTrue() {
        SimpleHashMap<UserMap, String> mapTemp = new SimpleHashMap<>();
        mapTemp.insert(user1, "One");
        mapTemp.insert(user2, "Two");
        mapTemp.insert(user3, "Three");
        mapTemp.insert(user4, "Four");
        mapTemp.insert(user5, "Five");
        mapTemp.insert(this.user6, "Sixxx");
        assertThat(mapTemp.size(), is(5));
    }

    @Test
    public void whenInsertReplaceValue() {
        map.insert(this.user6, "Sixxx");
        assertThat(this.map.get(this.user6), is("Sixxx"));
        assertThat(this.map.size(), is(6));
    }
    @Test
    public void whenRemoveForKeyTrue() {
        assertThat(this.map.get(this.user5), is("Five"));
        assertThat(this.map.delete(this.user5), is(true));
        assertThat(this.map.get(this.user5), is(nullValue()));
    }


}
