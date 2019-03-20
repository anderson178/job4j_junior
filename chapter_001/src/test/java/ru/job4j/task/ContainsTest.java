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
 * @since 20.3.2019
 */

public class ContainsTest {

    @Test
    public void whenCheckContainsEqualseTrue() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 3, 2, 1));
        assertThat(new Contains().checkContains(listOne, listTwo), is(true));
    }

    @Test
    public void whenCheckContainsEqualseFalse() {
        List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 3, 2, 7));
        assertThat(new Contains().checkContains(listOne, listTwo), is(false));
    }
}
