package ru.job4j.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.job4j.model.Employee;

import java.util.List;

public class EmloyeeDAO implements DAO<Employee, Integer> {
    private final SessionFactory factory;

    public EmloyeeDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Employee employee) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public Employee get(Integer id) {
        try (Session session = factory.openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> get(String name) {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from Employee where name " + "= :value");
            query.setParameter("value", name);
            return query.list();
        }
    }

    @Override
    public void update(Employee employee) {

    }
}
