package ru.vsu.cs.java.cinema.console_ui;

public interface AbstractCommand<T> {
    String getName();
    void action(T controller);
}
