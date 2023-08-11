package ru.vsu.cs.java.cinema.repositories;

public interface BaseCRUDRepository<T> {

    void create(T entity);

    void update(T entity);

    boolean delete(T entity);

    T get(long id);

}
