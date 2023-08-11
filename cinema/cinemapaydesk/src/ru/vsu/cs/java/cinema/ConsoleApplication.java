package ru.vsu.cs.java.cinema;

import ru.vsu.cs.java.cinema.console_ui.AllAplication;
import ru.vsu.cs.java.cinema.controllers.RecordController;

import java.util.Scanner;

public class ConsoleApplication {
    private Scanner scanner;
    private RecordController movieController;
    private AllAplication app;
    ControllersProvider cp;



    public ConsoleApplication(ControllersProvider cp) {
        scanner = new Scanner(System.in);
        this.movieController = cp.getMovieController();
        this.cp = cp;
        app = new AllAplication();
    }

    public void start() {
        app.action(cp);
        System.out.println("Завершение работы программы.");
    }



}
