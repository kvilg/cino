package ru.vsu.cs.java.cinema.repositories;

import ru.vsu.cs.java.cinema.models.Record;

import java.util.List;

public interface RecordRepository extends BaseCRUDRepository<Record> {

    List<Record> find(String name);

    List<Record> getAllRecord();
}
