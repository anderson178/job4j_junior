package ru.job4j.ocp.engineerCalc;

public abstract class BaseActionEngineer implements UserActionEngineer {
    final int key;
    final String info;

    public BaseActionEngineer(int key, String info) {
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
    public String getInfo() {
        return this.info;
    }
}
