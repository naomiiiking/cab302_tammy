package com.example.addressbook.tammy2.MemoryLogs;


import java.sql.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        // Create a connection to the SQLite database
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db")) {
            // Create the table if it doesn't exist
            createTable(connection);

            // Ask the user to input their mood
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Mood Tracker!");
            System.out.println("How are you feeling today?");
            String mood = scanner.nextLine();

            // Record the date and time
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            // Insert the mood and timestamp into the database
            insertMood(connection, mood, timestamp);

            // Display a message to the user
            System.out.println("Your mood has been recorded.");

            // Give the user an allowance of $2
            System.out.println("You've been granted an allowance of $2.");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // Method to create the "moods" table if it doesn't exist
    private static void createTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS moods (" +
                "id INTEGER PRIMARY KEY," +
                "mood TEXT NOT NULL," +
                "timestamp TIMESTAMP NOT NULL" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    // Method to insert a mood and timestamp into the "moods" table
    // Method to insert a mood and timestamp into the "moods" table
    private static void insertMood(Connection connection, String mood, Timestamp timestamp) throws SQLException {
        // Extract the date from the timestamp
        Date date = new Date(timestamp.getTime());

        // Format the date as "DAY/MONTH/YEAR"
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);

        String sql = "INSERT INTO moods (mood, timestamp) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mood);
            statement.setString(2, formattedDate);
            statement.executeUpdate();
        }
    }

}
