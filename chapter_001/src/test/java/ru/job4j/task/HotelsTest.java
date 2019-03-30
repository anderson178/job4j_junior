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
 * @since 22.3.2019
 */

public class HotelsTest {

    @Test
    public void whenTenHotels() {
        Hotels hotels = new Hotels(new ArrayList<>(Arrays.asList(60, 10, 30, 50, 11, 100, 40, 90, 70, 80)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(3, 1, 2, 3, 1, 5, 2, 5, 4, 4));
        assertThat(hotels.starsCounting(), is(expected));
    }

    @Test
    public void whenFiveHotels() {
        Hotels hotels = new Hotels(new ArrayList<>(Arrays.asList(99, 2, 100, 50, 1)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 2, 5, 3, 1));
        assertThat(hotels.starsCounting(), is(expected));
    }

    @Test
    public void whenFifteenHotels() {
        Hotels hotels = new Hotels(new ArrayList<>(Arrays.asList(6, 36, 60, 30, 100, 48, 12, 66, 78, 84, 24, 18, 72, 42, 54)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 4, 2, 5, 3, 1, 4, 5, 5, 2, 1, 4, 3, 3));
        assertThat(hotels.starsCounting(), is(expected));
    }


}
