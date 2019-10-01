package ru.job4j;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.dao.EmloyeeDAO;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = null;
        try  {
            Configuration configuration = new Configuration().configure();
            factory = new Configuration().configure().buildSessionFactory();
//            CityDAO cityDAO = new CityDAO(factory);
//            EmloyeeDAO emloyeeDAO = new EmloyeeDAO(factory);
//            Employee employee = new Employee();
//            employee.setName("qw");
//            employee.setSurname("er");
//            employee.setPatronymic("ty");
//            employee.setCity(cityDAO.get(4));
//            emloyeeDAO.create(employee);
//            System.out.println(emloyeeDAO.get(3));
            EmloyeeDAO emloyeeDAO = new EmloyeeDAO(factory);
            System.out.println(emloyeeDAO.get("Денис"));
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
        Predicate<Integer> pred = x-> x>3;
        pred.test(10);

    }
}
