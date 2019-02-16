package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 16.02.2019
 */

public class MyLinkedListTest {
    private MyLinkedList<Integer> list;

    @Before
    public void addTest() {
        list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    public void whenAddTest() {
        MyLinkedList<Integer> arrray = new MyLinkedList<>();
        arrray.add(2);
        arrray.add(3);
        assertThat(arrray.get(0), is(2));
        assertThat(arrray.get(1), is(3));
    }

    @Test
    public void getTestWhenNumberThree() {
        assertThat(list.get(2), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void getTestWhenMethodShouldThrowNullPointerException() {
        assertThat(list.get(10), is(3));
    }


    @Test
    public void whenIteratorTrue() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeStructureArrayNextMethodShouldThrowConcurrentModificationException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        list.add(11);
        it.next();
    }
}
