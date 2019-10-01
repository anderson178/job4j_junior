package ru.job4j.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.job4j.model.City;

import java.util.List;

public class CityDAO implements DAO<City, Integer> {
    private final SessionFactory factory;

    public CityDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(City city) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(City city) {

    }

    @Override
    public City get(Integer id) {
        try (Session session = factory.openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> get(String name) {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from Employee where name " + "= :value");
            query.setParameter("value", name);
            return query.list();
        }
    }

    @Override
    public void update(City city) {

    }
}
