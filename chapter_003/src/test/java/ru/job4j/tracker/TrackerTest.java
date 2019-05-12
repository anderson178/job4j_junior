package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.sql.ITracker;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Метод-тесты для операций в трекере
 *
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.10.2018
 */

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws SQLException {
        ITracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() throws SQLException {
        ITracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        next.setId(previous.getId());
        tracker.edit(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenCoincidesNameReturnListName() throws SQLException {
        ITracker tracker = new Tracker();
        ArrayList<Item> items = new ArrayList<>();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        Item second = new Item("test2", "testDescription2");
        tracker.add(second);
        Item third = new Item("test1", "testDescription3");
        tracker.add(third);
        items.add(first);
        items.add(third);
        assertThat(tracker.findByName("test1"), is(items));
    }

    @Test
    public void whenFindiIdReturnItem() throws SQLException {
        ITracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1");
        tracker.add(first);
        String id = first.getId();
        assertThat(tracker.findById(id), is(first));
    }

    @Test
    public void removeWhenById() throws SQLException {
        ITracker tracker = new Tracker();
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
        tracker.remove(id);
        boolean result = items.get(0) == tracker.getAll().get(0) && items.get(1) == tracker.getAll().get(1);
        assertThat(result, is(true));
    }
}
