package ru.vsu.cs.java.cinema;

import ru.vsu.cs.java.cinema.repositories_db_impl.ConnectorFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionFactory implements ConnectorFactory {
    private final String connectionString;

    public SQLiteConnectionFactory(String path) {
        this.connectionString = "jdbc:sqlite:" + path;
    }

    @Override
    public Connection create() {
        try {
            return DriverManager.getConnection(connectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
