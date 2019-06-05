package ru.job4j.xml;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */

public class Config {
    private final Properties values = new Properties();

    /**
     * Метод считывает данные из файла настроек и записывает в переменную настроек
     */
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
