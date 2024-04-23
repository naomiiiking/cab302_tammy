package com.example.addressbook.tammy2.TammyDatabase;

import tammy.Tammys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TammyDAO implements ITammyDAO{
    private final Connection connection;

    public TammyDAO() {
        connection = TammyDatabaseConnection.getInstance();
        createTable();
    }

    @Override
    public void addTammy(Tammys tammys) {
        /// want to add owner id onto this late by calling the users table and getting the persons logged in id but first
        /// need to implement the sequence of being able to log in and stay within process, should be fairly easy, however.
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Tammy (name, health, Characteristic) VALUES (?, ?, ?)");
            statement.setString(1, tammys.GetName());
            statement.setInt(2, tammys.getHealth());
            statement.setString(3, tammys.getCharacteristic());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTammy(Tammys tammys) {

    }

    @Override
    public void getTammy(int id) {

    }

    @Override
    public void createTable() {
        // Create table if not exists
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS Tammy ("
                    + "ownerId INTEGER PRIMARY KEY,"
                    + "name VARCHAR NOT NULL,"
                    + "health INTEGER NOT NULL,"
                    + "Characteristic VARCHAR NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
