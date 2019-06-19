package ru.job4j.tracker.sql;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 14.05.2019
 */

public class TrackerSQLTest {


    private TrackerSQL tracker = new TrackerSQL();


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

    @Test
    public void checkConnection() {
        try (Tracker tracker = new Tracker()) {

        }
        assertNotNull(this.tracker.getConnection());
    }


    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Assert.assertThat(tracker.getAll().get(0).toString(), Is.is(item.toString()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        tracker.edit(previous.getId(), next);
        Assert.assertThat(tracker.edit(previous.getId(), next), is(true));
        Assert.assertThat(tracker.findById(previous.getId()).getName(), is(next.getName()));
        Assert.assertThat(tracker.findById(previous.getId()).getDescription(), is(next.getDescription()));
    }

    @Test
    public void whenCoincidesNameReturnListName() {
        List<Item> items = new ArrayList<>();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item second = new Item("test2", "testDescription2");
        tracker.add(second);
        Item third = new Item("test1", "testDescription3");
        tracker.add(third);
        items.add(first);
        items.add(third);
        assertThat(tracker.findByName("test1").toString(), is(items.toString()));
    }

    @Test
    public void whenFindiIdReturnItem() {
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        String id = first.getId();
        assertThat(tracker.findById(id).toString(), is(first.toString()));
    }

    @Test
    public void removeWhenById() {
        ArrayList<Item> items = new ArrayList<>();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item second = new Item("test2", "testDescription2");
        tracker.add(second);
        Item third = new Item("test3", "testDescription3");
        tracker.add(third);
        String id = second.getId();
        items.add(first);
        items.add(third);
        assertThat(tracker.remove(id), is(true));
        assertThat(items.get(0).toString().equals(tracker.getAll().get(0).toString())
                && items.get(1).toString().equals(tracker.getAll().get(1).toString()), is(true));
    }


}
