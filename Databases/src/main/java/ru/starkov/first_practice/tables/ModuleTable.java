package ru.starkov.first_practice.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModuleTable extends AbstractTable {
    public ModuleTable(Connection connection) {
        super(connection);
    }

    @Override
    public void createTable() throws SQLException {
        String createModuleTable = "CREATE TABLE IF NOT EXISTS module (module_id SERIAL PRIMARY KEY, module_name VARCHAR(64));";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createModuleTable);
        }
        System.out.println("Таблица 'module' создана");
    }

    @Override
    public void dropTable() throws SQLException {
        String dropModuleTable = "DROP TABLE IF EXISTS module;";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropModuleTable);
        }
        System.out.println("Таблица 'module' удалена");
    }

    @Override
    public void viewTable() throws SQLException {
        String viewModuleTableQuery = "SELECT module_id, module_name FROM module";
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery(viewModuleTableQuery);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getRow());
                System.out.printf("module_id = %d, module_name = %s", resultSet.getInt(1),
                        resultSet.getString(2));
            }
        }
    }

    @Override
    public void populateTable() throws SQLException {

    }
}
