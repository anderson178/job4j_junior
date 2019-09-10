package ru.job4j.tsystems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 10.09.2019
 */
public class PyramidTest {

    @Test
    public void whenTreeNumbersBuidTrue() {

        int[][] expect = new int[][]{
                {0, 1, 0},
                {2, 0, 3}
        };
        assertThat(new Pyramid().build(new ArrayList<>(Arrays.asList(3, 1, 2))), is(expect));
    }

    @Test
    public void whenSixNumbersBuidTrue() {

        int[][] expect = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 2, 0, 3, 0},
                {4, 0, 5, 0, 6}

        };
        assertThat(new Pyramid().build(new ArrayList<>(Arrays.asList(4, 5, 6, 3, 1, 2))), is(expect));
    }

    @Test
    public void whenTenNumbersBuidTrue() {

        int[][] expect = new int[][]{
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 2, 0, 3, 0, 0},
                {0, 4, 0, 5, 0, 6, 0},
                {7, 0, 8, 0, 9, 0, 10}

        };
        assertThat(new Pyramid().build(new ArrayList<>(Arrays.asList(4, 5, 6, 3, 9, 1, 2, 8, 7, 10))), is(expect));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenImpossibleBuildTriangle() {
        new Pyramid().build(new ArrayList<>(Arrays.asList(4, 5, 6, 3, 9, 1, 2, 8, 7, 10, 11)));

    }
}
