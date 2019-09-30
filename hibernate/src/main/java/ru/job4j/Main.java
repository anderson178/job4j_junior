package ru.job4j;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.dao.CityDAO;
import ru.job4j.model.City;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try  {
            Configuration configuration = new Configuration().configure();
            factory = new Configuration().configure().buildSessionFactory();
            CityDAO cityDAO = new CityDAO(factory);
            City city = new City();
            city.setName("Kislovodsk");
            cityDAO.create(city);
            System.out.println(cityDAO.get(3));
        } finally {
            if (factory != null) {
                factory.close();
            }
        }

    }
}
