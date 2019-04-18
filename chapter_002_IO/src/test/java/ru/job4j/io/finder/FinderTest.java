package ru.job4j.io.finder;

import org.junit.Test;

public class FinderTest {

    @Test
    public void testFinder() {
        String[] args = new String[]{"-d","C;/lala","-n","inst1", "-m", "-o","log.txt"};
        Finder finder = new Finder(args);
        finder.find();
    }
}
