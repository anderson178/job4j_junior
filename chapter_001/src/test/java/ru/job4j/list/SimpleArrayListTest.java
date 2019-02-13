package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 13.2.2019
 */

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(4));
    }
    @Test
    public void whenRemoveThirtElemnt() {
        SimpleArrayList<Integer> list2 = new SimpleArrayList<>();
        Integer p = list2.delete();
        assertThat(list.delete(), is(1));
        assertThat(list.get(1), is(3));
        assertThat(list.getSize(), is(3));
    }
}
