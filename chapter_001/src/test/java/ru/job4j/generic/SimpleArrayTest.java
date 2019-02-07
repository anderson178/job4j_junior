package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.02.2019
 */

public class SimpleArrayTest {
    SimpleArray<Integer> array = new SimpleArray<>(5);

    @Before
    public void setUp() {
        for (int i = 0; i < this.array.getLength(); i++) {
            this.array.add(i + 3);
        }
    }
    @Test
    public void addTest() {
        for (int i = 0; i < 5; i++) {
            assertThat(array.get(i), is(i + 3));
        }
    }
    @Test
    public void iteratorTest() {
        Iterator<Integer> it = this.array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it = this.array.iterator();
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        it.next();
    }

    @Test
    public void getTestWhenNumberThree() {
        assertThat(array.get(0), is(3));
    }

    @Test
    public void setTestWhenIndex2() {
        array.set(1, 10);
        assertThat(array.get(1), is(10));
    }

    @Test
    public void removeTestWhenIndexThree() {
        array.remove(3);
        assertThat(array.get(3), is(7));
    }

}
