package Memorylogs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudyLogsDAO {
    private Connection connection;

    public StudyLogsDAO() {
        // Initialize the database connection
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:MemoryLog.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createStudyLogsTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS StudyLogs (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "user_id INTEGER, " +
                            "date TEXT, " +
                            "hours_studied REAL, " +
                            "money_earned REAL, " +
                            "FOREIGN KEY (user_id) REFERENCES UserAccounts(id)" +
                            ")"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudyLog(int userId, String date, String hoursStudied, int moneyEarned) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO StudyLogs (user_id, date, hours_studied, money_earned) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, userId);
            statement.setString(2, date);
            statement.setString(3, hoursStudied);
            statement.setInt(4, moneyEarned);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all study logs from the database
     * @return A list of MemoryEntry objects representing study logs
     * @throws SQLException If a database access error occurs
     */
    public List<MemoryEntry> getAllStudyLogs() throws SQLException {
        List<MemoryEntry> studyLogs = new ArrayList<>();

        // Query to select all study logs from the database
        String query = "SELECT date, hours_studied, money_earned FROM StudyLogs";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Iterate through the result set and create MemoryEntry objects
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                int hoursStudied = resultSet.getInt("hours_studied");
                int creditsGained = resultSet.getInt("money_earned");

                // Create a new MemoryEntry object and add it to the list
                MemoryEntry memoryEntry = new MemoryEntry(date, hoursStudied, creditsGained);
                studyLogs.add(memoryEntry);
            }
        }

        return studyLogs;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
