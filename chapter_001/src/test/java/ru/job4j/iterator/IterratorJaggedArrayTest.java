package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 31.01.2019
 */

public class IterratorJaggedArrayTest {
    private IterratorJaggedArray it;
    private IterratorJaggedArray itTwo;

    @Before
    public void setUp() {
        it = new IterratorJaggedArray(new int[][]{{1, 2, 3}, {4, 5, 6}});
        itTwo = new IterratorJaggedArray(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        it = new IterratorJaggedArray(new int[][]{});
        it.next();
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocationItTwo() {
        assertThat(itTwo.next(), is(1));
        assertThat(itTwo.next(), is(3));
        assertThat(itTwo.next(), is(4));
        assertThat(itTwo.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrderItTwo() {
        assertThat(itTwo.hasNext(), is(true));
        assertThat(itTwo.hasNext(), is(true));
        assertThat(itTwo.next(), is(1));
        assertThat(itTwo.next(), is(3));
        assertThat(itTwo.next(), is(4));
        assertThat(itTwo.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocationItTwo() {
        assertThat(itTwo.hasNext(), is(true));
        assertThat(itTwo.next(), is(1));
        assertThat(itTwo.hasNext(), is(true));
        assertThat(itTwo.next(), is(3));
        assertThat(itTwo.hasNext(), is(true));
        assertThat(itTwo.next(), is(4));
        assertThat(itTwo.hasNext(), is(true));
        assertThat(itTwo.next(), is(7));
        assertThat(itTwo.hasNext(), is(false));
    }
}
