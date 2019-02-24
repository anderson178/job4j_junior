package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 24.02.2019
 */

public class NodeCycleTest {
    private NodeCycle.Node<Integer> first = new NodeCycle.Node<>(1);
    private NodeCycle.Node<Integer> second = new NodeCycle.Node<>(2);
    private NodeCycle.Node<Integer> third = new NodeCycle.Node<>(3);
    private NodeCycle.Node<Integer> four = new NodeCycle.Node<>(4);

    @Test
    public void whenHasCycleTrueFirstNode() {
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = first;
        NodeCycle<Integer> nodes = new NodeCycle<>(first);
        assertThat(nodes.hasCycle(), is(true));
    }
    @Test
    public void whenHasCycleFalse() {
        first.next = second;
        second.next = third;
        third.next = four;
        NodeCycle<Integer> nodes = new NodeCycle<>(first);
        assertThat(nodes.hasCycle(), is(false));
    }

    @Test
    public void whenHasCycleTrueSecondNode() {
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = second;
        NodeCycle<Integer> nodes = new NodeCycle<>(first);
        assertThat(nodes.hasCycle(), is(true));
    }

}
