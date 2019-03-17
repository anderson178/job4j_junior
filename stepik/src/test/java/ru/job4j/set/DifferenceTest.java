package ru.job4j.set;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DifferenceTest {
    @Test
    public void whenDifferenceseroAndThree() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(0, 1, 2));
        Set<Integer> expected = new HashSet<>(Set.of(0, 3));
        assertThat(Difference.symmetricDifference(set1, set2), is(expected));
    }
}
