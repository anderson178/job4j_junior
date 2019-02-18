package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 18.02.2019
 */

public class SimpleStackTest {
    SimpleStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void addTestVelue() {
        assertThat(stack.getElement(0), is(1));
        assertThat(stack.getElement(1), is(2));
        assertThat(stack.getElement(2), is(3));
    }

    @Test
    public void pollSttack() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
