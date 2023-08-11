package ru.vsu.cs.java.cinema.repositories_db_impl;

import java.sql.Connection;

public interface ConnectorFactory {
    Connection create();
}
