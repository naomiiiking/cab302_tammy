// Define TammyInfoDAO.java
package com.example.addressbook.tammy2.AuthenLog;

import java.sql.*;

public class TammyInfoDAO {
    private Connection connection;

    public TammyInfoDAO() {
        // Initialize the database connection
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:TammyInfo.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTammyInfoTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS TammyInfo (" +
                            "userID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "username VARCHAR, " +
                            "tammyName VARCHAR, " +
                            "tammyType VARCHAR, " +
                            "tammySpecies VARCHAR" +
                            ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertTammyInfo(String username, String tammyName, String tammyType, String tammySpecies) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO TammyInfo (username, tammyName, tammyType, tammySpecies) VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, username);
            statement.setString(2, tammyName);
            statement.setString(3, tammyType);
            statement.setString(4, tammySpecies);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
