package ru.job4j.tracker;

import ru.job4j.tracker.sql.ITracker;

import java.sql.SQLException;

public interface UserAction {
    int key();
    void execute(Input input, ITracker tracker);
    String info();
}
