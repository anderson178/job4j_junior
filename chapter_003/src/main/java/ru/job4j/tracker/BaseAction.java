package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    public final int key;
    public final String action;

    protected BaseAction(final int key, final String action) {
        this.key = key;
        this.action = action;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s: %s", this.key, this.action);
    }
}
