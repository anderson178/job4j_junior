package ru.job4j.tsystems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 11.09.2019
 */
public class SubsequenceTest {

    @Test
    public void whenSubsequenceFalseOptionNumberOne() {
        boolean rst = new Subsequence().find(new ArrayList<>(Arrays.asList("a", "a", "b", "c", "d")),
                new ArrayList<>(Arrays.asList("bd", "a", "n", "b", "dc", "c", "a", "d", "d")));
        assertThat(rst, is(false));
    }

    @Test
    public void whenSubsequenceTrueOptionNumberOne() {
        boolean rst = new Subsequence().find(new ArrayList<>(Arrays.asList("a", "b", "c", "d")),
                new ArrayList<>(Arrays.asList("bd", "a", "n", "b", "dc", "c", "a", "d", "d")));
        assertThat(rst, is(true));
    }

    @Test
    public void whenSubsequenceTrueOptionNumberTwo() {
        boolean rst = new Subsequence().find(new ArrayList<>(Arrays.asList("aa", "b", "c", "d")),
                new ArrayList<>(Arrays.asList("bd", "aa", "n", "b", "dc", "c", "a", "d")));
        assertThat(rst, is(true));
    }

    @Test
    public void whenSubsequenceTrueOptionNumberThree() {
        boolean rst = new Subsequence().find(new ArrayList<>(Arrays.asList("a", "b", "b","c", "d")),
                new ArrayList<>(Arrays.asList("bd", "a", "a", "b", "n", "b", "dc", "c", "a", "d")));
        assertThat(rst, is(true));
    }

    @Test
    public void whenSubsequenceFalseOptionNumberTwo() {
        boolean rst = new Subsequence().find(new ArrayList<>(Arrays.asList("a", "b", "c", "d")),
                new ArrayList<>(Arrays.asList("a", "b", "c")));
        assertThat(rst, is(false));
    }
}
