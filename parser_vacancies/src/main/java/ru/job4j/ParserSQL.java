package ru.job4j;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.models.Months;
import ru.job4j.models.Vacancy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.07.2019
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParserSQL implements Parser {
    static final String URL = "https://www.sql.ru/forum/job-offers";
    static final Logger LOG = LoggerFactory.getLogger(ParserSQL.class.getName());
    Connection connection;
    String properties;
    Date dateBegin;

    public ParserSQL(String properties, Date dateBegin) {
        this.properties = properties;
        this.dateBegin = dateBegin;
    }


    /**
     * Метод добавления записи в БД
     *
     * @param vacancy - вакансия
     */
    private void addVacDB(Vacancy vacancy) {
        String sql = "INSERT INTO vacancies (name, description, link) Values (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vacancy.getName());
            preparedStatement.setString(2, vacancy.getDescription());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод запуска парсинга каждой из страниц
     */
    @Override
    public void parsPages() {
        connection = Config.getConnection(properties);
        this.createTable();
        try {
            int countPages = Integer.parseInt(Jsoup.connect(URL).get().select("table.sort_options")
                    .select("a")
                    .last()
                    .html());
            IntStream.range(1, countPages).forEach(i -> this.parsPage(URL + "/" + i));
        } catch (
                IOException e) {
            LOG.error(e.getMessage(), e);
        }

    }

    /**
     * Метод парсит страницу
     *
     * @param urlPage - адресс страницы
     */
    private void parsPage(String urlPage) {
        try {
            Elements elements = Jsoup.connect(urlPage).get().select("table.forumTable");
            for (Element element : elements.select("td.postslisttopic")) {
                Element link = element.select("a").first();
                if (this.validate(link.html())) {
                    Element data = Jsoup.connect(link.attr("href"))
                            .get()
                            .selectFirst("table.msgTable");
                    Element description = data.select("td.msgBody").get(1);
                    Date dateVacancy = convertDate(data.select("td.msgFooter").first().text().split(",")[0]);
                    if (dateVacancy != null && dateVacancy.after(this.dateBegin)) {
                        this.addVacDB(new Vacancy(link.html(), description.text(), link.attr("href")));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Метод создания таблицы для хранения вакансий
     */
    private void createTable() {
        String sql = "CREATE TABLE if not exists vacancies ("
                + "id serial primary key not null"
                + ",name varchar(255) UNIQUE not null"
                + ",description text"
                + ",link text)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }


    /**
     * Метод конвертирует полученную строку дата с страницы в формат даты
     *
     * @param date - дата в формате строки
     * @return - дата
     * @throws ParseException
     */
    private Date convertDate(String date) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date rst = new Date();
        if (date.toLowerCase().equals("сегодня")) {
            rst = new SimpleDateFormat("dd-MM-yyyy")
                    .parse(localDateTime.getDayOfMonth()
                            + "-" + localDateTime.getMonth().getValue()
                            + "-" + localDateTime.getYear());
        } else if (date.toLowerCase().equals("вчера")) {
            localDateTime = localDateTime.minusDays(1);
            rst = new SimpleDateFormat("dd-MM-yyyy")
                    .parse(localDateTime.getDayOfMonth()
                            + "-" + localDateTime.getMonth().getValue()
                            + "-" + localDateTime.getYear());
        } else {
            String[] dateDMY = date.split(" ");
            rst = new SimpleDateFormat("dd-MM-yyyy")
                    .parse(dateDMY[0]
                            + "-" + Months.valueOf(dateDMY[1]).getNumber()
                            + "-20" + dateDMY[2]);
        }
        return rst;
    }

    /**
     * Метод проверки строки на содрежание конкретного слова
     *
     * @param text - входящая строка
     * @return - если содержит то true иначе false
     */
    private boolean validate(String text) {
        return text.toLowerCase().contains("Java".toLowerCase())
                && !text.toLowerCase().contains("Java Script".toLowerCase())
                && !text.toLowerCase().contains("JavaScript".toLowerCase());
    }

    /**
     * Метод закрытия ресурса Connection
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }


}
