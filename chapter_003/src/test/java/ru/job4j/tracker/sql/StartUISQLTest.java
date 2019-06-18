package ru.job4j.tracker.sql;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.05.2019
 */

public class StartUISQLTest {
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
    private TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()));

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private StringBuilder menu = new StringBuilder("-----------MENU--------" + ln + "0: ADD" + ln
            + "1: SHOW_ALL" + ln + "2: EDIT" + ln + "3: DELETE"
            + ln + "4: FIND_BY_ID" + ln + "5: FIND_BY_NAME" + ln + "6: EXIT"
            + ln + "-----------------------" + ln);

    @Before
    public void loadOutput() {
        Connection connection = tracker.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM item");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new ArrayList<>(Arrays.asList("0", "test name3", "desc3", "1", "6")));
        new StartUI(input, this.tracker, consumer).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append(this.menu)
                .append("You selection ADD")
                .append(ln)
                .append("Item create")
                .append(ln)
                .append(this.menu)
                .append("You selection SHOW_ALL")
                .append(ln)
                .append(this.tracker.getAll().get(0).toString())
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
    public void whenUserEditItem() {
        Item item1 = this.tracker.add(new Item("test name", "desc"));
        Item item2 = this.tracker.add(new Item("test2 name2", "desc2"));
        String id = item1.getId();
        Input input = new StubInput(new ArrayList<>(Arrays.asList("2", id, "test3 name3", "desc3", "1", "6")));
        new StartUI(input, this.tracker, consumer).init();
        assertThat(new String(out.toByteArray()), is(new StringBuffer()
                .append(this.menu)
                .append("You selection EDIT")
                .append(ln)
                .append("Item is update")
                .append(ln)
                .append(menu)
                .append("You selection SHOW_ALL")
                .append(ln)
                .append(this.tracker.getAll().get(0).toString())
                .append(ln)
                .append(this.tracker.getAll().get(1).toString())
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
    public void whenUserRemoveItem() {
        Item item1 = this.tracker.add(new Item("test name", "desc"));
        Item item2 = this.tracker.add(new Item("test2 name2", "desc2"));
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
                .append(this.tracker.getAll().get(0).toString())
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
