package com.example.addressbook.tammy2.TammyDatabase;

import com.example.addressbook.tammy2.AuthenLog.DatabaseConnection;
import com.example.addressbook.tammy2.functions.TimeCalculators;
import com.example.addressbook.tammy2.tammy.Tammys;

import java.sql.*;

/**
 * A Class which holds the methods for querying the sqlite database
 */
public class TammyDAO{
    private static Connection connection;
    TimeCalculators timecalc;

    /**
     * Constructor for the class TammyDAO, gets the connection to the database via the method in DatabaseConnection
     * also is used to instantiate other classes for their methods.
     */
    public TammyDAO() {
        connection = DatabaseConnection.getInstance();
        createTammyTable();
        timecalc = new TimeCalculators();
    }

    /**
     * Method uses the parameter Tammys object which is the virtual pet associated with the user account
     * method creates a sql query and then INSERT it to the database 'database.db'
     * @param tammys the object Tammys
     */
    public void addTammy(Tammys tammys) {
        /// want to add owner id onto this late by calling the users table and getting the persons logged in id but first
        /// need to implement the sequence of being able to log in and stay within process, should be fairly easy, however.
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Tammy (ownerId, name, food, water, Characteristic, Species, LastLogin, happiness) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, tammys.getOwnerId());
            statement.setString(2, tammys.getName());
            statement.setInt(3, tammys.getFoodVar());
            statement.setInt(4, tammys.getWaterVar());
            statement.setString(5, tammys.getCharacteristic());
            statement.setString(6, tammys.getSpecies());
            statement.setString(7, timecalc.GetTime());
            statement.setInt(8, tammys.getHappiness());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The database method is used to update the name of the tammy in the database
     * newName acts as the string to be set as the name and the tammys object is used to identify the
     * specific tammy in the database
     * @param tammys the Object Tammys
     * @param newName the String for the new name for the tammys
     */
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

    /**
     * This method updates the last time the tammy was accessed in the database via a method in the functions package
     * this inputs the date and time as a string into the database, the id param is used as an identifier
     * to find the specific tammy to be updated
     * @param id ownerId of the tammy in the database
     */
    public void updateTammyTime(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET LastLogin = ? WHERE ownerId = ?");
            statement.setString(1, timecalc.GetTime());
            statement.setInt(2, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method selects the specific tammy via the id param to return the last time the tammy was accessed
     * in a string type
     * @param id ownerId of the tammy in the database
     * @return String lastLogin
     */
    public String getTammyTime(int id){
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT LastLogin FROM Tammy WHERE ownerId = ?");
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

    /**
     * Method updates the tammys food water, happiness and LastLogin columns in the database
     * tammy param is used to get the tammys food water and id which is all set within other methods
     * in AuthenController
     * @param tammy the Tammys Object
     */
    public void updateTammy(Tammys tammy){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET food = ?, water = ?, LastLogin = ?, happiness = ? WHERE ownerId = ?");

            statement.setInt(1, tammy.getFoodVar());
            statement.setInt(2, tammy.getWaterVar());
            statement.setString(3, timecalc.GetTime());
            statement.setInt(4, tammy.getHappiness());
            statement.setInt(5, tammy.getOwnerId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method updates the tammys food water and happiness columns in the database
     * tammy param is used to get the tammys food water happiness and id which is all set within other methods
     * in AuthenController
     * @param tammy the Tammys object
     */

    public void updateTammyVitals(Tammys tammy){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET food = ?, water = ?, happiness = ? WHERE ownerId = ?");

            statement.setInt(1, tammy.getFoodVar());
            statement.setInt(2, tammy.getWaterVar());
            statement.setInt(3, tammy.getHappiness());
            statement.setInt(4, tammy.getOwnerId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public void updateTammyWater(Tammys tammy, int amount){
//        try {
//            PreparedStatement statement = connection.prepareStatement("UPDATE Tammy SET water = ? WHERE ownerId = ? ");
//            int waterVal = 0;
//            if (amount > 0){waterVal = tammy.getFoodVar() + amount;}
//            else {waterVal = tammy.getFoodVar() - amount;}
//
//            if(waterVal > 100){
//                waterVal = 100;
//            } else if (waterVal < 0) {
//                waterVal = 0;
//            }
//            statement.setInt(1, waterVal);
//            statement.setInt(2, tammy.getOwnerId());
//            statement.executeUpdate();
//
//            tammy.setWaterVar(waterVal);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Method finds the unique tammy via the id identifier, it then SELECTS all the columns of that specific
     * tammy and creates a new tammy object and returns it.
     * @param id ownerId of the tammy in the database
     * @return Tammys object
     */
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
                int happiness = resultSet.getInt("happiness");
                return new Tammys(id, name, food, water, characteristic,species, happiness);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates the tammy table with the columns ownerId, name, food, water Characteristic, Specis, LastLogin
     * only if the table doesnt exist. Is only called when this class is instantiated.
     */
    public void createTammyTable() {
        // Create table if not exists
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS Tammy ("
                    + "ownerId INTEGER NOT NULL,"
                    + "name VARCHAR NOT NULL,"
                    + "food INTEGER NOT NULL,"
                    + "water INTEGER NOT NULL,"
                    + "happiness INTEGER NOT NULL,"
                    + "Characteristic VARCHAR NOT NULL,"
                    + "Species VARCHAR NOT NULL,"
                    + "LastLogin VARCHAR NOT NULL"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to close the classes connection to the database
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
