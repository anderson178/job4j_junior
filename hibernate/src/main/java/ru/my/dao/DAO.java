package ru.my.dao;

public interface DAO<Entity, Key> {
    void create(Entity entity);
    void delete(Entity entity);
    Entity get(Key key);
    void update(Entity entity);
}
