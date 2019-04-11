package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 12.04.2019
 */

public class ConfigTest {

    @Test
    public void whenApp() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        map.put("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/trackstudio");
        map.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        map.put("hibernate.connection.username", "postgres");
        map.put("hibernate.connection.password", "password");
        assertThat(new Config(new File("./" + "app.properties").getAbsolutePath()).load(), is(map));
    }

    @Test
    public void whenApp2() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("jdbc.connection.url", "jdbc:postgresql://127.0.0.1:5432/trackstudio");
        map.put("jdbc.connection.driver_class", "org.postgresql.Driver");
        map.put("jdbc.connection.username", "postgres");
        map.put("jdbc.connection.password", "password");
        assertThat(new Config(new File("./" + "app2.properties").getAbsolutePath()).load(), is(map));
    }

}
