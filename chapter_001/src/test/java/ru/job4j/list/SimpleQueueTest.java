package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 19.02.2019
 */

public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @Before
    public void setUp() {
        this.queue = new SimpleQueue<>();
        this.queue.push(1);
        this.queue.push(2);
        this.queue.push(3);

    }

    @Test
    public void addTestVelue() {
        assertThat(this.queue.getElement(0), is(1));
        assertThat(this.queue.getElement(1), is(2));
        assertThat(this.queue.getElement(2), is(3));
    }

    @Test
    public void pollSttack() {
        assertThat(this.queue.poll(), is(1));
        assertThat(this.queue.poll(), is(2));
        assertThat(this.queue.poll(), is(3));
    }

}
