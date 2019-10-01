package ru.job4j.dao;

import java.util.List;

public interface DAO<Entity, Key> {
    void create(Entity entity);
    void delete(Entity entity);
    Entity get(Key key);
    List<Entity> get(String name);
    void update(Entity entity);
}
