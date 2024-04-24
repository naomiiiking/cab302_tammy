package com.example.addressbook.tammy2.TammyDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TammyDatabaseConnection {
    private static Connection instance = null;

    private TammyDatabaseConnection() {
        String url = "jdbc:sqlite:Tammy.db";
        try {
            instance = DriverManager.getConnection(url);
        } catch (SQLException sqlEx) {
            System.err.println(sqlEx);
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            new TammyDatabaseConnection();
        }
        return instance;
    }
}
