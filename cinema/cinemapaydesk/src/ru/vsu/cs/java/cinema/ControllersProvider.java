package ru.vsu.cs.java.cinema;

import ru.vsu.cs.java.cinema.controllers.RecordController;

public interface ControllersProvider {
    RecordController getMovieController();
}
