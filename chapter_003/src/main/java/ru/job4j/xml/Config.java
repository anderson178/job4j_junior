package ru.job4j.xml;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSqlLite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String getProperty(String key) {
        return this.values.getProperty(key);
    }
}
