package ru.job4j.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 20.03.2019
 */

public class ContainsTest {

    @Test
    public void whenCheckContainsEqualseTrue() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        assertThat(new Contains().checkContains(listOne, listTwo), is(true));
    }

    @Test
    public void whenCheckContainsEqualseTrue2() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(2, 4, 3, 1));
        assertThat(new Contains().checkContains(listOne, listTwo), is(true));
    }

    @Test
    public void whenCheckContainsEqualseFalse() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 3, 2, 7));
        assertThat(new Contains().checkContains(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse2() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 4, 3));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 1, 4, 3));
        assertThat(new Contains().checkContains(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse3() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 5));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(2, 4, 3, 1));
        assertThat(new Contains().checkContains(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse4() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 4, 3, 2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(2, 4, 3, 1, 5));
        assertThat(new Contains().checkContains(listOne, listTwo), is(false));
    }

    @Test
    public void whenCheckContainsEqualseFalse5() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 1, 2));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 2, 2));
        assertThat(new Contains().checkContains(listOne, listTwo), is(false));
    }
}
