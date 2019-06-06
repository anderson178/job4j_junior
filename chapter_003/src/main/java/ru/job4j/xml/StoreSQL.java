package ru.job4j.xml;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.xml.models.Field;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 05.06.2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoreSQL {
    static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());
    final Config config;
    Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Метод создает базу, соединение с ней и чистит ее
     */
    public void init() {
        this.config.init();
        if (!new File(config.getProperty("url")).exists()) {
            try {
                connection = DriverManager.getConnection(this.config.getProperty("url"));
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        this.createTable();
        this.clearTable();
    }

    /**
     * Метод создает базу если она не существует
     */
    private void createTable() {
        String sql = "CREATE TABLE if not exists entry (name varchar(255))";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод удаляет данные из таблицы если в ней что-то есть
     */
    private void clearTable() {
        String query = "select * from entry";
        try (ResultSet select = connection.prepareStatement(query).executeQuery()) {
            if (select.next()) {
                query = "delete from entry";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создает в таблице новые записи
     *
     * @param size - количество записей в таблице
     */
    public void generate(int size) {
        this.createTable();
        this.clearTable();
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO entry (name) VALUES ");
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                sql.append("('" + i + "'),");
            } else {
                sql.append("('" + i + "');");
            }
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод запрашивает из таблицы все значения записей поля name
     *
     * @return - список с значениями полей
     */
    public List<Field> getAllValues() {
        String query = "select * from entry";
        List<Field> result = new ArrayList<>();
        try (ResultSet resultSet = connection.prepareStatement(query).executeQuery()) {
            while (resultSet.next()) {
                try {
                    result.add(new Field(resultSet.getString("name")));
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

}
