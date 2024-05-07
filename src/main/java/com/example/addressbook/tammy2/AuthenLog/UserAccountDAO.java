package com.example.addressbook.tammy2.AuthenLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {
    private static Connection connection;

    public UserAccountDAO() {
        connection = DatabaseConnection.getInstance();

    }

    /**
     * Creates database table if it doesn't exist already
     */
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

    /**
     * Inserts user account into table
     * @param userAccount
     */
    public void insert(UserAccount userAccount){
        try {
            PreparedStatement insertAccount = connection.prepareStatement(
                    "INSERT INTO UserAccounts (username, email, password) VALUES (?, ?, ?)"
            );
            insertAccount.setString(1, userAccount.getUsername());
            insertAccount.setString(2, userAccount.getEmail());
            insertAccount.setString(3, userAccount.getPassword());
            insertAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Updates user account
     * @param userAccount account to update
     */
    public void update(UserAccount userAccount) {
        try {
            PreparedStatement updateAccount = connection.prepareStatement(
                    "UPDATE UserAccounts SET username = ?, email = ?, password = ? WHERE id = ?"
            );
            updateAccount.setString(1, userAccount.getUsername());
            updateAccount.setString(2, userAccount.getEmail());
            updateAccount.setString(3, userAccount.getPassword());
            updateAccount.setInt(4, userAccount.getID());
            updateAccount.execute();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Deletes user account
     * @param id ID of account to delete
     */
    public void delete(int id) {
        // Todo Later: Create a PreparedStatement to run the DELETE query
    }

    /**
     * Gets all user accounts
     * @return list of user accounts
     */
    public List<UserAccount> getAll() {
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

    /**
     * Get user account by ID
     * @param id ID used to get user accounts
     * @return
     */
    public UserAccount getById(int id) {
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

    /**
     * Get user account by username
     * @param username username required
     * @return returns user account
     */
    public UserAccount getByUsername(String username) {
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


    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}

