package ru.vsu.cs.java.cinema.console_ui;

import ru.vsu.cs.java.cinema.ControllersProvider;

import java.util.Arrays;
import java.util.List;

public class AllAplication extends CommandsGroup<ControllersProvider> {
    public AllAplication() {
        super(Arrays.asList(new RecordCommands()));
    }

    @Override
    public String getName() {
        return null;
    }
}
