package com.example.addressbook.tammy2.TammyDatabase;

import com.example.addressbook.tammy2.AuthenLog.DatabaseConnection;
import com.example.addressbook.tammy2.tammy.Tammys;

import java.sql.*;

public class TammyDAO{
    private final Connection connection;

    public TammyDAO() {
        connection = DatabaseConnection.getInstance();
        createTammyTable();
    }


    public void addTammy(Tammys tammys) {
        /// want to add owner id onto this late by calling the users table and getting the persons logged in id but first
        /// need to implement the sequence of being able to log in and stay within process, should be fairly easy, however.
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Tammy (ownerId, name, food, water, Characteristic, Species) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, tammys.getOwnerId());
            statement.setString(2, tammys.getName());
            statement.setInt(3, tammys.getFoodVar());
            statement.setInt(4, tammys.getWaterVar());
            statement.setString(5, tammys.getCharacteristic());
            statement.setString(6, tammys.getSpecies());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO
    // Implement method to change name, done later if have time
    public void updateNameTammy(Tammys tammys) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET name = ? WHERE name = ?");
            statement.setString(1, tammys.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateTammyFood(Tammys tammy, int amount){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET food = ? WHERE id = ?");
            int foodVal = tammy.getFoodVar() + amount;
            if(foodVal > 100){
                foodVal = 100;
            }
            statement.setInt(1, foodVal);
            statement.setInt(2, tammy.getOwnerId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTammyWater(Tammys tammy, int amount){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET water = ? WHERE id = ? ");
            int waterVal = tammy.getFoodVar() + amount;
            if(waterVal > 100){
                waterVal = 100;
            }
            statement.setInt(1, waterVal);
            statement.setInt(2, tammy.getOwnerId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Tammys getTammy(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contacts WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Id = resultSet.getInt("ownerId");
                String name = resultSet.getString("firstName");
                int food = resultSet.getInt("food");
                int water = resultSet.getInt("water");
                String characteristic = resultSet.getString("Characteristic");
                String species = resultSet.getString("Species");
                return new Tammys(id, name, food, water, characteristic,species);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void createTammyTable() {
        // Create table if not exists
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS Tammy ("
                    + "ownerId INTEGER NOT NULL,"
                    + "name VARCHAR NOT NULL,"
                    + "food INTEGER NOT NULL,"
                    + "water INTEGER NOT NULL,"
                    + "Characteristic VARCHAR NOT NULL,"
                    + "Species VARCHAR NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
