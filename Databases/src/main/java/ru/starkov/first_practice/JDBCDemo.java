package ru.starkov.first_practice;

import ru.starkov.first_practice.tables.ModuleTable;
import util.ConnectionUtilities;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        try (Connection connectionToDataBase = ConnectionUtilities.getConnectionToDataBase()) {
            ModuleTable moduleTable = new ModuleTable(connectionToDataBase);

            moduleTable.viewTable();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
