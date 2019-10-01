package ru.job4j.lsp.action;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String info;

    public BaseAction(int key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * Get key
     *
     * @param key - key
     * @return - key
     */
    @Override
    public int key(int key) {
        return this.key;
    }

    /**
     * Get info action
     *
     * @return - Get info action
     */
    @Override
    public String info() {
        return this.info;
    }
}
