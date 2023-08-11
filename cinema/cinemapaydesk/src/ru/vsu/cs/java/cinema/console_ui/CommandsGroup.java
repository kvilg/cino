package ru.vsu.cs.java.cinema.console_ui;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandsGroup<T> implements AbstractCommand<T> {
    private List<AbstractCommand<T>> allCommands = new ArrayList<>();

    public CommandsGroup(List<AbstractCommand<T>> commands){
        allCommands.addAll(commands);
    }

    @Override
    public void action(T controller) {
        int choice;
        do {
            printMenu();
            choice = IO.instance.readNextInt();
            if (choice == 0)
                break;
            if (choice < 0 || choice > allCommands.size())
                System.out.println("Ошибочная команда! Попробуйте ещё раз.");
            else
                allCommands.get(choice - 1).action(controller);
        }
        while (true);
    }

    public void printMenu() {
        System.out.println("Выберите операцию:");
        System.out.println("0. Выход");
        for (int i = 0; i < allCommands.size(); i++) {
            System.out.printf("%d. %s;\n", i + 1, allCommands.get(i).getName());
        }
    }
}
