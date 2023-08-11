package ru.vsu.cs.java.cinema.controllers;

import ru.vsu.cs.java.cinema.models.Record;
import ru.vsu.cs.java.cinema.repositories.RecordRepository;
import ru.vsu.cs.java.cinema.repositories.RepositoriesProvider;

import java.util.List;

public class RecordController {
    private RecordRepository recordRepository;

    public RecordController(RepositoriesProvider repository) {
        recordRepository = repository.getRecordRepository();
    }

    public void addNewRecord(Record m) {
        recordRepository.create(m);
    }

    public List<Record> getAllRecord() {
        return recordRepository.getAllRecord();
    }

    public List<Record> findByName(String name) {
        return recordRepository.find(name);
    }

    public void updateRecord(Record r){
        recordRepository.update(r);
    }


    public boolean remove(Record record) {
        return recordRepository.delete(record);
    }
}
