package ru.vsu.cs.java.cinema.repositories_array_impl;

import ru.vsu.cs.java.cinema.models.Record;
import ru.vsu.cs.java.cinema.repositories.RecordRepository;

import java.util.*;

public class RecordRepositoryArrayImpl implements RecordRepository {
    private List<Record> data = new ArrayList<>();
    private static long lastId = 0;

    @Override
    public void create(Record entity) {
        entity.id = ++lastId;
        data.add(entity);
    }

    @Override
    public void update(Record entity) {
        for (int i = 0; i < data.size(); i++) {
            if(Objects.equals(data.get(i).getName(), entity.name)){
                data.set(i, entity);
            }
        }
    }

    @Override
    public boolean delete(Record ch) {
        if (ch == null)
            return false;
        Record toDelete = null;
        for (Record m : data) {
            if (m.id == ch.id)
                toDelete = m;

        }
        if (toDelete == null)
            return false;
        return data.remove(toDelete);
    }

    @Override
    public Record get(long id) {
        for (Record m : data) {
            if (m.id == id)
                return m;
        }
        return null;
    }


    @Override
    public List<Record> find(String name) {
        List<Record> result = new ArrayList<>();
        for (Record m : data) {
            if (m.name.toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                Record tmp = new Record(m);
                result.add(m);
            }
        }
        return result;
    }


    @Override
    public List<Record> getAllRecord() {
        return new AbstractList<Record>() {
            @Override
            public Record get(int index) {
                Record original = data.get(index);
                if (original == null)
                    return null;
                return new Record(original);
            }

            @Override
            public int size() {
                return data.size();
            }
        };

    }
}
