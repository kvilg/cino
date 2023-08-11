package ru.vsu.cs.java.cinema;

import ru.vsu.cs.java.cinema.controllers.ControllersProviderImpl;
import ru.vsu.cs.java.cinema.repositories.RepositoriesProvider;
import ru.vsu.cs.java.cinema.repositories_array_impl.ArrayRepositoriesProvider;
import ru.vsu.cs.java.cinema.repositories_db_impl.ConnectorFactory;
import ru.vsu.cs.java.cinema.repositories_db_impl.DBRepositoriesProvider;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Необходимо указать путь к БД");
            return;
        }

        ConnectorFactory cf = new SQLiteConnectionFactory(args[0]);

        RepositoriesProvider rp = new DBRepositoriesProvider(cf);
        ControllersProvider cp = new ControllersProviderImpl(rp);
        ConsoleApplication app = new ConsoleApplication(cp);
        app.start();

    }
}
