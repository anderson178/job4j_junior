package ru.job4j;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.07.2019
 */
public class Config {
    public static String gerCronTime(String properties) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(properties)) {
            Properties config = new Properties();
            config.load(in);
            return config.getProperty("cron.time");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Connection getConnection(String properties) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(properties)) {
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
}
