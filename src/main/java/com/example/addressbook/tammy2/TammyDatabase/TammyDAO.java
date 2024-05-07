package com.example.addressbook.tammy2.TammyDatabase;

import com.example.addressbook.tammy2.AuthenLog.DatabaseConnection;
import com.example.addressbook.tammy2.AuthenLog.UserAccountDAO;
import com.example.addressbook.tammy2.tammy.Tammys;
import com.example.addressbook.tammy2.functions.TimeCalculators;

import java.sql.*;

public class TammyDAO{
    private final Connection connection;
    TimeCalculators timecalc;

    public TammyDAO() {
        connection = DatabaseConnection.getInstance();
        createTammyTable();
        timecalc = new TimeCalculators();
    }


    public void addTammy(Tammys tammys) {
        /// want to add owner id onto this late by calling the users table and getting the persons logged in id but first
        /// need to implement the sequence of being able to log in and stay within process, should be fairly easy, however.
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Tammy (ownerId, name, food, water, Characteristic, Species, LastLogin) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, tammys.getOwnerId());
            statement.setString(2, tammys.getName());
            statement.setInt(3, tammys.getFoodVar());
            statement.setInt(4, tammys.getWaterVar());
            statement.setString(5, tammys.getCharacteristic());
            statement.setString(6, tammys.getSpecies());
            statement.setString(7, timecalc.GetTime());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateNameTammy(Tammys tammys, String newName) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET name = ? WHERE name = ?");
            statement.setString(1, newName);
            statement.setString(2, tammys.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTammyTime(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET LastLogin WHERE ownerId = ?");
            statement.setString(1, timecalc.GetTime());
            statement.setInt(2, id);
            statement.executeUpdate();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getTammyTime(int id){
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT LastLogin FROM Tammy WHERE ownerId");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String lastLogin = resultSet.getString("LastLogin");
                return lastLogin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void updateTammyFood(Tammys tammy, int amount){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET food = ? WHERE ownerId = ?");
            int foodVal = 0;
            if(amount > 0){foodVal = tammy.getFoodVar() + amount;}
            else{foodVal = tammy.getFoodVar() - amount;}

            if(foodVal > 100){
                foodVal = 100;
            }
            else if(foodVal < 0){
                foodVal = 0;
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
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET water = ? WHERE ownerId = ? ");
            int waterVal = 0;
            if (amount > 0){waterVal = tammy.getFoodVar() + amount;}
            else {waterVal = tammy.getFoodVar() - amount;}

            if(waterVal > 100){
                waterVal = 100;
            } else if (waterVal < 0) {
                waterVal = 0;
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Tammy WHERE ownerId = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int Id = resultSet.getInt("ownerId");
                String name = resultSet.getString("name");
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
                    + "Species VARCHAR NOT NULL,"
                    + "LastLogin VARCHAR NOT NULL"
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
