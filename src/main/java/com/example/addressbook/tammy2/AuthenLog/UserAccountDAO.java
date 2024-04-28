package com.example.addressbook.tammy2.AuthenLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {
    private static Connection connection;

    public UserAccountDAO() {
        connection = DatabaseConnection.getInstance();
    }

    public void createTable() {
        try {
            Statement createTable = connection.createStatement();
            createTable.execute(
                    "CREATE TABLE IF NOT EXISTS UserAccounts ("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "username VARCHAR NOT NULL, "
                            + "email VARCHAR NOT NULL, "
                            + "password VARCHAR NOT NULL"
                            + ")"
            );
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        }

    public static void insert(UserAccount userAccount){
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO UserAccounts (username, email, password) VALUES (?, ?, ?)"
            );
            insertAccount.setString(1, UserAccount.getUsername());
            insertAccount.setString(2, UserAccount.getEmail());
            insertAccount.setString(3, UserAccount.getPassword());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void update(UserAccount userAccount) {
        try {
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE UserAccounts SET username = ?, email = ?, password = ? WHERE id = ?"
            );
            updateAccount.setString(1, UserAccount.getUsername());
            updateAccount.setString(2, UserAccount.getEmail());
            updateAccount.setString(3, UserAccount.getPassword());
            updateAccount.setInt(4, UserAccount.getID());
            updateAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

         }

    public void delete(int id) {
        // Todo Later: Create a PreparedStatement to run the DELETE query
    }

    public static List<UserAccount> getAll() {
        List<UserAccount> accounts = new ArrayList<>();
        try {
            Statement getAll = connection.createStatement();
            ResultSet rs = getAll.executeQuery("SELECT * FROM UserAccounts");
            while (rs.next()) {
                accounts.add(
                        new UserAccount(
                                rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("email"),
                                rs.getString("password")
                        )
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return accounts;
    }

    public static UserAccount getById(int id) {
        try {
            PreparedStatement getAccount = connection.prepareStatement("SELECT * FROM UserAccounts WHERE id = ?");
            getAccount.setInt(1, id);
            ResultSet rs = getAccount.executeQuery();
            if (rs.next()) {
                return new UserAccount(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return null;
    }

    // Inside the UserAccountDAO class


    public static void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static UserAccount getByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM UserAccounts WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new UserAccount(id, username, email, password);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }
}

