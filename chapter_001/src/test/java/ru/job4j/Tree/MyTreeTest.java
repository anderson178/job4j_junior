package ru.job4j.tree;


import org.junit.Before;
import org.junit.Test;
import ru.job4j.tree.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.3.2019
 */

public class MyTreeTest {
    private MyTree<Integer> tree;

    @Before
    public void setUp() {
        this.tree = new MyTree<>(1);
        this.tree.add(1, 2);
        this.tree.add(1, 3);
        this.tree.add(1, 4);
        this.tree.add(4, 5);
        this.tree.add(5, 6);
    }

    @Test
    public void when6ElFindLastThen6() {
        assertThat(this.tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        assertThat(this.tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenAddDoubleFalse() {
        assertThat(this.tree.add(1, 3), is(false));
        assertThat(this.tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void whenIteratorTrue() {
        Iterator<Integer> it = tree.iterator();
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
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it = this.tree.iterator();
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
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeStructureArrayNextMethodShouldThrowConcurrentModificationException() {
        Iterator<Integer> it = this.tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        this.tree.add(4, 7);
        it.next();
    }

    @Test
    public void whenTreeIsNotBinary() {
        assertThat(this.tree.isBinary(), is(false));
    }

    @Test
    public void whenTreeIsBinary() {
        MyTree<Integer> treeTemp = new MyTree<>(1);
        treeTemp.add(1, 2);
        treeTemp.add(1, 3);
        treeTemp.add(2, 4);
        treeTemp.add(2, 5);
        assertThat(treeTemp.isBinary(), is(true));
    }
}
