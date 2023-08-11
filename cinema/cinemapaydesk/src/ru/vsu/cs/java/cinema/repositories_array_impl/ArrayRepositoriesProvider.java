package ru.vsu.cs.java.cinema.repositories_array_impl;

import ru.vsu.cs.java.cinema.repositories.*;

public class ArrayRepositoriesProvider implements RepositoriesProvider {
    private RecordRepository mr;

    public ArrayRepositoriesProvider(){
        mr = new RecordRepositoryArrayImpl();
    }

    @Override
    public RecordRepository getRecordRepository() {
        return mr;
    }

}
