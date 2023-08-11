package ru.vsu.cs.java.cinema.repositories_db_impl;

import ru.vsu.cs.java.cinema.repositories.*;

public class DBRepositoriesProvider implements RepositoriesProvider {
    private RecordRepository mr;

    public DBRepositoriesProvider(ConnectorFactory cf){
        mr = new RecordRepositoryDBImpl(cf);
    }
    @Override
    public RecordRepository getRecordRepository() {
        return mr;
    }

}
