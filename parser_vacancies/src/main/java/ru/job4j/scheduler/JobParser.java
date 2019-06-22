package ru.job4j.scheduler;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.Config;
import ru.job4j.Parser;
import ru.job4j.ParserSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 02.07.2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobParser implements Job {
    static final Logger LOG = LoggerFactory.getLogger(JobParser.class.getName());
    Connection connection;

    /**
     * Метод добавляет запись о выполненном задании
     */
    private void addJobDB() {
        String sql = "INSERT INTO jobs (name, date) Values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, this.getClass().getSimpleName());
            preparedStatement.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод запршаивает из БД дату последнего выполннеого задания
     *
     * @return - дата последнего выполненго задания
     */
    private Date getLastJobDB() {
        String sql = "SELECT * FROM jobs order by ID desc LIMIT 1";
        Date rst = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rst = resultSet.getTimestamp("date");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return rst;

    }

    /**
     * Метод создания таблицы для хранения выполненных заданий
     */
    private void createTable() {
        String sql = "CREATE TABLE if not exists jobs ("
                + "id serial primary key,"
                + "name varchar(255),"
                + "date timestamp)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод возвращает дату начало текущего года
     *
     * @return - дата начала текущего года
     */
    private Date getBeginingYear() {
        Date rst = new Date();
        try {
            rst = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-" + Calendar.getInstance().get(Calendar.YEAR));
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }

    /**
     * Метод запуска задания
     *
     * @param jobExecutionContext - параметры переданные планировщником из класс ScheldulerParser
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        String properties = jobExecutionContext.getJobDetail().getJobDataMap().get("nameProperties").toString();
        connection = Config.getConnection(properties);
        this.createTable();
        Date date = getLastJobDB();
        if (date != null) {
            this.runParser(properties, date);
        } else {
            this.runParser(properties, this.getBeginingYear());
        }
    }

    /**
     * Метод вызова класса для парсинга страниц
     *
     * @param properties - путь к файлу с настройками для соединения с БД
     * @param date       - дата
     */
    private void runParser(String properties, Date date) {
        try (Parser parser = new ParserSQL(properties, date)) {
            parser.parsPages();
            addJobDB();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
