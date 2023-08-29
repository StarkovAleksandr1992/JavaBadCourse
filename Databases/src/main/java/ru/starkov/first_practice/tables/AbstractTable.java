package ru.starkov.first_practice.tables;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractTable {
    protected Connection connection;

    public AbstractTable(Connection connection) {
        this.connection = connection;
    }

    public abstract void createTable() throws SQLException;

    public abstract void dropTable() throws SQLException;

    public abstract void viewTable() throws SQLException;

    public abstract void populateTable() throws SQLException;
}
