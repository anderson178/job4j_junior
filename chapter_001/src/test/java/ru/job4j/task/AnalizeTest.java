package ru.job4j.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    Analize.User user1 = new Analize.User(111, "Denis");
    Analize.User user2 = new Analize.User(222, "Petr");
    Analize.User user3 = new Analize.User(333, "Sergey");
    Analize.User user4 = new Analize.User(444, "Nikoly");
    Analize.User user5 = new Analize.User(555, "Maksim");
    List<Analize.User> previous;
    List<Analize.User> current;

    @Before
    public void setUp() {
        previous = new ArrayList<>();
        current = new ArrayList<>();
    }

    @Test
    public void test() {
        previous.add(user1);
        previous.add(user4);
        current.add(user1);
        current.add(user2);
        current.add(user3);
        current.add(user4);
        current.add(user5);
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        List<Analize.User> add = info.getAdded();

        int changed = 0;
    }

    @Test
    public void whenAddNewThreeUser() {
        previous.add(user1);
        previous.add(user4);
        current.add(user1);
        current.add(user2);
        current.add(user3);
        current.add(user4);
        current.add(user5);
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.getAdded().size(), is(3));
    }
}
