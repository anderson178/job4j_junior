package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.03.2019
 */

public class MyHashMapTest {
    private UserMap user1 = new UserMap("Denis", 2, new GregorianCalendar(1989, 10, 21));
    private UserMap user2 = new UserMap("Nikita", 1, new GregorianCalendar(1987, 9, 71));
    private UserMap user3 = new UserMap("Lev", 10, new GregorianCalendar(1289, 11, 5));
    private UserMap user4 = new UserMap("Ivan", 4, new GregorianCalendar(1940, 3, 1));
    private UserMap user5 = new UserMap("Seniy", 1, new GregorianCalendar(1956, 2, 6));
    private UserMap user6 = new UserMap("Sasha", 1, new GregorianCalendar(1911, 10, 11));
    private MyHashMap<UserMap, String> map;

    @Before
    public void setUp() {
        map = new MyHashMap<>(8, 0.25);
        map.insert(user1, "One");
        map.insert(user2, "Two");
        map.insert(user3, "Three");
        map.insert(user4, "Four");
        map.insert(user5, "Five");
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeStructureArrayNextMethodShouldThrowConcurrentModificationException() {
        Iterator<MyHashMap.Node> it = map.iterator();
        MyHashMap.Node result = it.next();
        assertThat(result.getKey(), is((Object) user3));
        assertThat(result.getValue(), is((Object) "Three"));
        result = it.next();
        assertThat(result.getKey(), is((Object) user5));
        assertThat(result.getValue(), is((Object) "Five"));
        map.insert(user6, "Six");
        it.next();
    }

    @Test
    public void whenIteratorTrue() {
        Iterator<MyHashMap.Node> it = this.map.iterator();
        assertThat(it.hasNext(), is(true));
        MyHashMap.Node result = it.next();
        assertThat(result.getKey(), is((Object) user3));
        assertThat(result.getValue(), is((Object) "Three"));
        assertThat(it.hasNext(), is(true));
        result = it.next();
        assertThat(result.getKey(), is((Object) user5));
        assertThat(result.getValue(), is((Object) "Five"));
        assertThat(it.hasNext(), is(true));
        result = it.next();
        assertThat(result.getKey(), is((Object) user4));
        assertThat(result.getValue(), is((Object) "Four"));
        assertThat(it.hasNext(), is(true));
        result = it.next();
        assertThat(result.getKey(), is((Object) user2));
        assertThat(result.getValue(), is((Object) "Two"));
        assertThat(it.hasNext(), is(true));
        result = it.next();
        assertThat(result.getKey(), is((Object) user1));
        assertThat(result.getValue(), is((Object) "One"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<MyHashMap.Node> it = map.iterator();
        MyHashMap.Node result = it.next();
        assertThat(result.getKey(), is((Object) user3));
        assertThat(result.getValue(), is((Object) "Three"));
        result = it.next();
        assertThat(result.getKey(), is((Object) user5));
        assertThat(result.getValue(), is((Object) "Five"));
        result = it.next();
        assertThat(result.getKey(), is((Object) user4));
        assertThat(result.getValue(), is((Object) "Four"));
        result = it.next();
        assertThat(result.getKey(), is((Object) user2));
        assertThat(result.getValue(), is((Object) "Two"));
        result = it.next();
        assertThat(result.getKey(), is((Object) user1));
        assertThat(result.getValue(), is((Object) "One"));
        it.next();
    }

    @Test
    public void whenInsertTrue() {
        MyHashMap<UserMap, String> mapTemp = new MyHashMap<>(8, 0.25);
        mapTemp.insert(user1, "One");
        mapTemp.insert(user2, "Two");
        mapTemp.insert(user3, "Three");
        mapTemp.insert(user4, "Four");
        mapTemp.insert(user5, "Five");
        assertThat(mapTemp.getFillCount(), is(5));
    }

    @Test
    public void whenInsertReplaceValue() {
        map.insert(this.user6, "Sixxx");
        assertThat(this.map.get(this.user6), is("Sixxx"));
        assertThat(this.map.getFillCount(), is(6));
    }
    @Test
    public void whenRemoveForKeyTrue() {
        assertThat(this.map.get(this.user5), is("Five"));
        assertThat(this.map.remove(this.user5), is(true));
        assertThat(this.map.get(this.user5), is(nullValue()));
    }
}
