package ru.job4j.xml;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.*;


public class StoreSQL {
    public static final Logger LOG = LoggerFactory.getLogger(StoreSQL.class.getName());
    private final Config config;
    private Connection connection;

    public StoreSQL(Config config) {
        this.config = config;
    }

    public void init() {
        this.config.init();

        if (!new File(config.getProperty("url")).exists()) {
            try {
                connection = DriverManager.getConnection(this.config.getProperty("url"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void createTable() {
        String sql = "CREATE TABLE if not exists entry (name varchar(255))";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            //LOG.error(e.getMessage(), e);
        }
    }

    private void clearTable() {
        String query = "select * from entry";
        try (ResultSet select = connection.prepareStatement(query).executeQuery()) {
            if (select.next()) {
                query = "delete from entry";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.executeUpdate();
                    printDB();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void generate(int size) {
        this.createTable();
        this.clearTable();
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO entry (name) VALUES ");
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                sql.append("('I am " + i + "'),");
            } else {
                sql.append("('I am " + i + "');");
            }
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printDB() {
        String query = "select * from entry";
        try (ResultSet resultSet = connection.prepareStatement(query).executeQuery()) {
            while (resultSet.next()) {
                try {
                    System.out.println(resultSet.getString("name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.init();
        storeSQL.generate(100);
        storeSQL.printDB();
    }
}
