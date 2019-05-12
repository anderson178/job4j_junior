package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.sql.ITracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Метод-тесты для операций в трекере
 *
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.10.2018
 */

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String ln = System.lineSeparator();
    private final Consumer<String> consumer = new Consumer<String>() {
        private final PrintStream printStream = new PrintStream(stdout);

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    };


    private StringBuilder menu = new StringBuilder("-----------MENU--------" + ln + "0: ADD" + ln
            + "1: SHOW_ALL" + ln + "2: EDIT" + ln + "3: DELETE"
            + ln + "4: FIND_BY_ID" + ln + "5: FIND_BY_NAME" + ln + "6: EXIT"
            + ln + "-----------------------" + ln);

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws SQLException {
        Input input = new StubInput(new ArrayList<>(Arrays.asList("0", "test name3", "desc3", "1", "6")));
        ITracker trackerTemp = new Tracker();
        new StartUI(input, trackerTemp, consumer).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append(this.menu)
                .append("You selection ADD")
                .append(ln)
                .append("Item create")
                .append(ln)
                .append(this.menu)
                .append("You selection SHOW_ALL")
                .append(ln)
                .append(trackerTemp.getAll().get(0).toString())
                .append(ln)
                .append(menu)
                .append("You selection EXIT")
                .append(ln)
                .append("Goode bye")
                .append(ln)
                .toString()
        ));
    }

    @Test
    public void whenUserEditItem() throws SQLException {
        ITracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test2 name2", "desc2"));
        String id = item1.getId();
        Input input = new StubInput(new ArrayList<>(Arrays.asList("2", id, "test3 name3", "desc3", "1", "6")));
        new StartUI(input, tracker, consumer).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append(this.menu)
                .append("You selection EDIT")
                .append(ln)
                .append("Item is update")
                .append(ln)
                .append(menu)
                .append("You selection SHOW_ALL")
                .append(ln)
                .append(tracker.getAll().get(0).toString())
                .append(ln)
                .append(tracker.getAll().get(1).toString())
                .append(ln)
                .append(menu)
                .append("You selection EXIT")
                .append(ln)
                .append("Goode bye")
                .append(ln)
                .toString()
        ));
    }

    @Test
    public void whenUserRemoveItem() throws SQLException {
        ITracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test2 name2", "desc2"));
        String id = item1.getId();
        Input input = new StubInput(new ArrayList<>(Arrays.asList("3", id, "1", "6")));
        new StartUI(input, tracker, consumer).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append(this.menu)
                .append("You selection DELETE")
                .append(ln)
                .append("Item remove")
                .append(ln)
                .append(this.menu)
                .append("You selection SHOW_ALL")
                .append(ln)
                .append(tracker.getAll().get(0).toString())
                .append(ln)
                .append(menu)
                .append("You selection EXIT")
                .append(ln)
                .append("Goode bye")
                .append(ln)
                .toString()
        ));
    }
}
