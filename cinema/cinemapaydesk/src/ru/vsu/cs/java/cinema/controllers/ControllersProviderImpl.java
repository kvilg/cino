package ru.vsu.cs.java.cinema.controllers;

import ru.vsu.cs.java.cinema.ControllersProvider;
import ru.vsu.cs.java.cinema.repositories.RepositoriesProvider;

public class ControllersProviderImpl implements ControllersProvider {
    private RecordController mc;

    public ControllersProviderImpl(RepositoriesProvider rp) {
        mc = new RecordController(rp);
    }

    @Override
    public RecordController getMovieController() {
        return mc;
    }
}
