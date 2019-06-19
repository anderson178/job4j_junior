package ru.job4j.tracker.sql;

import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.job4j.tracker.Item;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 15.05.2019
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    public static final Logger LOG = LoggerFactory.getLogger(TrackerSQL.class.getName());
    private Connection connection;

    /**
     * Статический блок инициализации для подключения к базе данных
     */
//    {
//        this.init();
//    }


    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }
    public TrackerSQL() {
        this.init();
    }

    /**
     * Метод возвращает объект connection
     *
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Метод подключения к базе данных
     *
     * @return true - если подключено осуществленно, иначе false
     */
    private boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Метод добавления заявки в БД
     *
     * @param item - входящая заявка
     * @return - добавленная заявка
     */
    @Override
    public Item add(Item item) {
        String sql = "INSERT INTO item (id, name, description, date) Values (?, ?, ?, ?)";
        item.setId(String.valueOf(System.currentTimeMillis() + new Random().nextInt()));
        item.setCreate(new Date().toString());
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, Long.parseLong(item.getId()));
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getDescription());
            preparedStatement.setString(4, item.getCreate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return item;

    }

    /**
     * Метод получения всех заявок из БД
     *
     * @return
     */
    @Override
    public List<Item> getAll() {
        return getItems("SELECT * from item");
    }

    /**
     * Метод возвращения заявок из БД
     *
     * @param query - SQL-запрос
     * @return - список заявок
     */
    private List<Item> getItems(String query) {
        List<Item> rst = new ArrayList<>();
        try (ResultSet resultSet = connection.prepareStatement(query).executeQuery()) {
            while (resultSet.next()) {
                Item temp = new Item(resultSet.getString("name"), resultSet.getString("description"));
                temp.setId(resultSet.getString("id"));
                temp.setCreate(resultSet.getString("date"));
                rst.add(temp);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return rst;
    }

    /**
     * Метод редактирование заявки
     *
     * @param id   - id заявки которую необходимо реактировать
     * @param item - заявка на которую будет происходить замена
     * @return - true если было произведено изменение, иначе false
     */
    @Override
    public boolean edit(String id, Item item) {
        String sql = "UPDATE item set name = ?, description = ? where id = ?";
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setLong(3, Long.parseLong(id));
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Метод поиска заявки по id
     *
     * @param id - id Заявки
     * @return - заявка
     */
    @Override
    public Item findById(String id) {
        String sql = "SELECT * from item where id = ?";
        Item rst = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, Long.parseLong(id));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    rst = new Item(resultSet.getString("name"), resultSet.getString("description"));
                    rst.setId(Long.toString(resultSet.getLong("id")));
                    rst.setCreate(resultSet.getString("date"));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }

        return rst;
    }

    /**
     * Метод удаления заявки по id
     *
     * @param id - id заявки
     * @return - true если было произведено удаление, иначе false
     */
    @Override
    public boolean remove(String id) {
        String sql = "DELETE from item where id = ?";
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, Long.parseLong(id));
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Метод поиска заявок по имени
     *
     * @param key - имя заявки
     * @return - список найденных заявок
     */
    @Override
    public List<Item> findByName(String key) {
        return this.getItems("SELECT * from item where name = " + "'" + key + "'");
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }
}