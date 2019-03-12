package ru.job4j.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 12.03.2019
 */


public class AnalizeTest {
    Analize.User user1 = new Analize.User(111, "Denis");
    Analize.User user2 = new Analize.User(222, "Petr");
    Analize.User user3 = new Analize.User(333, "Sergey");
    Analize.User user4 = new Analize.User(444, "Nikoly");
    Analize.User user5 = new Analize.User(555, "Maksim");
    Analize.User user6 = new Analize.User(111, "Vasily");
    Analize.User user7 = new Analize.User(777, "Anton");


    List<Analize.User> previous;
    List<Analize.User> current;

    @Before
    public void setUp() {
        previous = new ArrayList<>();
        current = new ArrayList<>();
    }

    @Test
    public void whenIfExistDoubleUserInCurrentList() {
        previous.add(user1);
        previous.add(user4);
        current.add(user2);
        current.add(user2);
        current.add(user3);
        assertThat(new Analize().diff(previous, current).getAdded(), is(2));
    }

    @Test
    public void whenAddNewThreeUserAndOndeChangedAndOneDeleted() {
        previous.add(user1);
        previous.add(user4);
        previous.add(user7);
        current.add(user1);
        current.add(user2);
        current.add(user3);
        current.add(user4);
        current.add(user5);
        current.add(user6);
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.getAdded(), is(3));
        assertThat(info.getCnanged(), is(1));
        assertThat(info.getDeleted(), is(1));
    }

    @Test
    public void whenAddNewThreeUser() {
        previous.add(user1);
        previous.add(user4);
        previous.add(user7);
        current.add(user2);
        current.add(user3);
        current.add(user5);
        assertThat(new Analize().diff(previous, current).getAdded(), is(3));
    }

    @Test
    public void whenChangedOneUser() {
        previous.add(user1);
        previous.add(user4);
        current.add(user6);
        assertThat(new Analize().diff(previous, current).getCnanged(), is(1));

    }

}
